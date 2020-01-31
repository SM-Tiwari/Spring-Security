/**
 * Apr 26, 2018 6:45:50 PM
 */
package com.gnv.vnm.selfcare.webapi.fcm;

import java.util.List;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gnv.vnm.selfcare.core.AppDefaultValues;
import com.gnv.vnm.selfcare.core.enums.NotificationDisplayType;
import com.gnv.vnm.selfcare.core.enums.NotificationStatus;
import com.gnv.vnm.selfcare.core.enums.PushedCampaignType;
import com.gnv.vnm.selfcare.core.model.PushedCampaign;
import com.gnv.vnm.selfcare.core.service.ApplicationConfigurationService;
import com.gnv.vnm.selfcare.core.service.PushedCampaignService;
import com.gnv.vnm.selfcare.core.utils.HttpResponseWrapper;
import com.gnv.vnm.selfcare.core.utils.HttpSessionManager;
import com.gnv.vnm.selfcare.core.utils.LoggingUtil;
import com.gnv.vnm.selfcare.dao.entity.FcmTokenEntity;
import com.gnv.vnm.selfcare.dao.entity.LmsConfigEntity;
import com.gnv.vnm.selfcare.dao.entity.PushedCampaignEntity;
import com.gnv.vnm.selfcare.dao.entity.QFcmTokenEntity;
import com.gnv.vnm.selfcare.dao.entity.QLmsConfigEntity;
import com.gnv.vnm.selfcare.dao.entity.QSubscriberEntity;
import com.gnv.vnm.selfcare.dao.entity.SubscriberEntity;
import com.gnv.vnm.selfcare.dao.repo.FcmTokenRepository;
import com.gnv.vnm.selfcare.dao.repo.LmsConfigRepository;
import com.gnv.vnm.selfcare.dao.repo.PushedCampaignRepository;
import com.gnv.vnm.selfcare.dao.repo.SubscriberRepository;

/**
 * @author nandipinto
 *
 */

@Component
public class FCMClient {
	
	static final String FCM_ENDPOINT = "https://fcm.googleapis.com/fcm/send";
	private static final Logger logger = LoggerFactory.getLogger(FCMClient.class);
	
	static final String MAX_SENT_COUNT = "6";
	static final String[] SCOPES = new String[] { "https://www.googleapis.com/auth/firebase.messaging" };
	static final String CONNECT_TIMEOUT = "30";
	static final String MAX_CONNECTIONS = "100";

	@Autowired 
	private ApplicationConfigurationService applicationConfigurationService;

	@Autowired
	private LmsConfigRepository lmsConfigRepository;
	@Autowired
	private SubscriberRepository subscriberRepository;
	@Autowired 
	private PushedCampaignRepository pushedCampaignRepository;
	@Autowired
	private FcmTokenRepository fcmTokenRepository;

	@Autowired
	private PushedCampaignService pushedCampaignService;
	
	private Header[] headers;
	private ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	
	public String getUserToken(String msisdn) {
		try {
			FcmTokenEntity entity = fcmTokenRepository.findOne(QFcmTokenEntity.fcmTokenEntity.msisdn.eq(msisdn));
			if (entity != null) {
				return entity.getToken();
			}
		} catch (Exception e) {
			logger.error("#getUserToken --- error retrievig FCM token for MSISDN " + msisdn, e);
		}
		return null;
	}
	
	private HttpSessionManager getHttpSessionManager() {
		int connectTimeout = Integer.parseInt(applicationConfigurationService.get("fcm.connectimeout", CONNECT_TIMEOUT).toString()) * 1000;
		int maxConnections = Integer.parseInt(applicationConfigurationService.get("fcm.maxconnections", MAX_CONNECTIONS).toString());

		return HttpSessionManager.getInstance(connectTimeout, connectTimeout, maxConnections, true);
	}
	
	public int pushInstantMessage(String msisdn, String title, String msgBody, String badge) {
		
		int count = 0;

		if (!StringUtils.hasText(msisdn)) return count;
		
		String token = getUserToken(msisdn);
		if (token != null) {
			if (StringUtils.hasText(msgBody)) {
				FcmNotification notification = new FcmNotification(title, msgBody);
				if (StringUtils.hasText(badge)) {
					notification.setBadge("" + badge);
				}
				FcmMessage message = new FcmMessage(notification, token);
				message.setMsisdn(msisdn);
				
				if (pushMessage(message)) count++;
			} else {
				int maxSentCount = Integer.parseInt(getLmsConfigValue("RECHARGE_REMINDER_MAX_SHOW_COUNT", MAX_SENT_COUNT).toString());
				List<PushedCampaign> list = pushedCampaignService.getCampaigns(msisdn, 
						new PushedCampaignType[] { PushedCampaignType.FCM },
						new NotificationStatus[] { NotificationStatus.UNREAD }, 
						new NotificationDisplayType[] { NotificationDisplayType.PUSHED }, 
						maxSentCount);
				
				if (list != null) {
					for (PushedCampaign pc : list) {
						String language = getPreferredLanguage(msisdn);
						title = language.equals(AppDefaultValues.LANGUAGE_VIETNAMESE) ? pc.getTitleVI() : pc.getTitleEN();
						String body = language.equals(AppDefaultValues.LANGUAGE_VIETNAMESE) ? pc.getDetailsVI() : pc.getDetailsEN();
						long unreadMsgCount = pushedCampaignService.getUnreadCampaignCount(msisdn, NotificationDisplayType.PUSHED);

						FcmNotification notification = new FcmNotification(title, body);
						notification.setBadge("" + unreadMsgCount);
						FcmMessage message = new FcmMessage(notification, token);
						message.setMessageId(pc.getId());
						message.setMsisdn(msisdn);
						
						if (pushMessage(message)) count++;
					}
				}
			}
		}
		return count;
	}
	
	public boolean pushMessage(FcmMessage fcmMsg) {
		if (fcmMsg == null) return false;
		
		if (fcmMsg.getTo() == null) {
			logger.warn("#pushMessage --- could not push FCM notification to MSISDN " + fcmMsg.getMsisdn() + ", token is null.");
			return false;
		}

		boolean sent = false;
		try {
			LoggingUtil.debug(logger, "#pushMessage --- sending notification to MSISDN " + fcmMsg.getMsisdn());
			
			HttpResponseWrapper response = getHttpSessionManager().post(getEndPoint(),
					objectMapper.writeValueAsString(fcmMsg), "application/json", getHttpHeaders());
			
			if (response != null && response.getCode() == HttpStatus.SC_OK) {
				logger.debug("#pushMessage --- done sending notification to MSISDN " + fcmMsg.getMsisdn() + ", receiving response= " + response.getContent());
				
				FcmResponse result = objectMapper.readValue(response.getContent(), FcmResponse.class);
				sent = result != null && result.getSuccess() > 0;
			}
		} catch (Exception e) {
			logger.error("#pushMessage --- could not send notification to MSISDN " + fcmMsg.getMsisdn(), e);
		}
		
		if (sent) {
			try {
				if (fcmMsg.getMessageId() > 0) {
					PushedCampaignEntity pce = pushedCampaignRepository.findOne(fcmMsg.getMessageId());
					if (pce != null) {
						pce.setSentCounter(pce.getSentCounter() + 1);
						pushedCampaignRepository.saveAndFlush(pce);
					}
				}
			} catch (Exception e) {
				logger.error("#pushMessage --- error updating sent_counter on message with id " + fcmMsg.getMessageId(), e);
			}
		}

		return sent;
	}
	
	public void pushMessages(List<FcmMessage> badgeMessages) {
		if (badgeMessages == null || badgeMessages.isEmpty()) return;
		
		try {
			for (FcmMessage message : badgeMessages) {
				
				if (StringUtils.hasText(message.getTo())) {
					HttpResponseWrapper response = getHttpSessionManager().post(getEndPoint(),
							objectMapper.writeValueAsString(message), "application/json", getHttpHeaders());
					
					LoggingUtil.debug(logger,
							"#pushBadgeNotification --- sending FCM notification for token= "
									+ message.getTo() + ", receiving response= "
									+ (response != null ? response.getCode() : -1));
				}
			}
		} catch (Exception e) {
			logger.error("#pushBadgeNotifications --- error when sending notifications", e);
		}
	}
	
	private Object getLmsConfigValue(String key, Object defaultValue) {
		try {
			LmsConfigEntity lce = lmsConfigRepository.findOne(QLmsConfigEntity.lmsConfigEntity.name.equalsIgnoreCase(key));
			if (lce != null && lce.getValue() != null) {
				return lce.getValue();
			}
		} catch (Exception e) {
			logger.error("#getLmsConfigValue --- error retrieving LMS config value for name= " + key, e);
		}
		return defaultValue;
	}
	
	private String getPreferredLanguage(String msisdn) {
		String language = null;
		try {
			SubscriberEntity subscriber = subscriberRepository.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(msisdn));
			if (subscriber != null) {
				language = subscriber.getLanguageCode();
			}
		} catch (Exception e) {}
		return language != null ? language : AppDefaultValues.LANGUAGE_VIETNAMESE;
	}
	
	private Header[] getHttpHeaders() throws Exception {
		if (headers == null) {
			String serverKey = applicationConfigurationService.get("fcm.serverkey", "").toString();
			headers = new Header[] { new Header("Content-Type", "application/json"),
					new Header("Authorization", "key=" + serverKey) };
		}
		return headers;
	}
	
	private String getEndPoint() {
		return applicationConfigurationService.get("fcm.endpoint.legacy", FCM_ENDPOINT).toString();
	}
}
