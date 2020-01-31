/**
 * May 18, 2018 10:27:06 PM
 */
package com.gnv.vnm.selfcare.fcmclient;

import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gnv.vnm.selfcare.fcmclient.enums.LmsConfigNames;
import com.gnv.vnm.selfcare.fcmclient.enums.NotificationStatus;
import com.gnv.vnm.selfcare.fcmclient.enums.PushedCampaignType;
import com.gnv.vnm.selfcare.fcmclient.model.FcmMessage;
import com.gnv.vnm.selfcare.fcmclient.model.FcmNotification;
import com.gnv.vnm.selfcare.fcmclient.model.FcmResponse;
import com.gnv.vnm.selfcare.fcmclient.model.PushedCampaign;
import com.gnv.vnm.selfcare.fcmclient.model.SqlProperties;

/**
 * @author nandipinto
 *
 */

@Service
public class FcmNotificationSender {
	
	private static final Logger logger = LoggerFactory.getLogger(FcmNotificationSender.class);

	static final String ENG = "en";
	static final String VIE	= "vi";

	static final String FCM_ENDPOINT = "https://fcm.googleapis.com/fcm/send";
	static final String[] SCOPES = new String[] { "https://www.googleapis.com/auth/firebase.messaging" };

	static final String MAX_SENT_COUNT = "6";
	static final String MAX_CONNECTIONS = "100";
	static final String CONNECTION_TIMEOUT_IN_SECS = "30";

	static final int CONNECTION_CHECK_INTV_SECS = 10 * 1000;
	static final String[] NAME_OF_DAYS = { "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY" };
	
	@Autowired 
	private TaskScheduler taskScheduler;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private SqlProperties sqlProperties;

	private Map<String, Object> applicationConfigs = new Hashtable<>();
	private Map<String, Object> lmsConfigs = new Hashtable<>();
	
	private ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	
	private CloseableHttpClient httpClient = null; 
	private PoolingHttpClientConnectionManager connectionManager = null;
	private RequestConfig requestConfig = null;
	
	private ScheduledFuture<?> scheduledJob;
	private String topupReminderCronExpr = "", lastTopupReminderCronExpr  = "";
	
	@Value("${fcmclient.scheduler.enabled}")
	private boolean schedulerEnabled = true;
	
	@Autowired Environment env;
	
	@PostConstruct
	public void initiate() {
		logger.info("Loading application configuration...");
		loadApplicationConfigs();
		loadLmsConfigs();
		
		startScheduler();
	}
	
	@PreDestroy
	public void stopService(){
		try {
			if (httpClient != null) httpClient.close();
			if (connectionManager != null) connectionManager.shutdown();
		} catch (Exception e) {}
	}
	
	
	public void restartScheduler() {
		if (scheduledJob != null) {
			scheduledJob.cancel(true);
			
			logger.info("Restarting scheduled jobs...");
			startScheduler();
		}
	}
	
	public void startScheduler() {
		if (!schedulerEnabled) {
			logger.info("Scheduler is not enabled -- please update config/application.properties to enable, I'm not sending FCM messages.");
			return;
		} 

		logger.debug("#startScheduler --- topupReminderCronExpr= " + topupReminderCronExpr  + " --- lastTopupReminderCronExpr= " + lastTopupReminderCronExpr);
		
		scheduledJob = taskScheduler.schedule(new Runnable() {
			
			@Override
			public void run() {
				sendTopupReminders();
			}
		}, new CronTrigger(topupReminderCronExpr));
	}
	
	public void sendTopupReminders() {
		String endPoint = getAppConfigValue("fcm.endpoint.legacy", FCM_ENDPOINT).toString();
		
		List<PushedCampaign> list = getUnreadMessages(PushedCampaignType.FATTY_MONSTER);
		logger.info("About to send top up reminders for " + list.size() + " user(s)..");
		
		for (PushedCampaign pc : list) {
			String msisdn = pc.getTargetedUser();
			String language = getUserLanguage(msisdn);
			String token = getUserToken(msisdn);
			if (token != null) {
				String title = language.equals(VIE) ? pc.getTitleVI() : pc.getTitleEN();
				String body = language.equals(VIE) ? pc.getDetailsVI() : pc.getDetailsEN();

				FcmNotification notification = new FcmNotification(title, body);
				notification.setBadge("1");
				FcmMessage message = new FcmMessage(notification, token);
				message.setMessageId(pc.getId());
				message.setMsisdn(msisdn);
				
				if (pushMessage(message, endPoint)) {
					updateMessageSentCounter(pc.getId());
				}
			}
		}
	}

	private boolean pushMessage(FcmMessage message, String endPoint) {
		
		logger.info("#pushMessage_" + message.getMsisdn() + " --- sending message to FCM for MSISDN " + message.getMsisdn());
		try {
			HttpPost httpPost = new HttpPost(endPoint);
			httpPost.setEntity(new StringEntity(objectMapper.writeValueAsString(message), "UTF-8"));
			
			CloseableHttpResponse response = getHttpClient().execute(httpPost);
			if (response != null && response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				FcmResponse result = objectMapper.readValue(response.getEntity().getContent(), FcmResponse.class);
				
				logger.debug("#pushMessage_" + message.getMsisdn() + ", message= " + message.getNotification().getBody() + ", --- receiving response from FCM " + result);
				
				response.close();
				
				return result != null && result.getSuccess() > 0;
				
			}
		} catch (Exception e) {
			logger.error("#pushMessage --- error when pushing message to FCM for MSISDN " + message.getMsisdn(), e);
		}
		return false;
	}
	
	private void updateMessageSentCounter(Integer id) {
		try {
			jdbcTemplate.update(sqlProperties.getUpdateSentCounterSql(), new Object[] { id });
		} catch (Exception e) {
			logger.error("#updateMessageSentCounter --- error when updating sent_counter for message_id " + id, e);
		}
	}
	
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public List<PushedCampaign> getUnreadMessages(PushedCampaignType type){
		
		List<PushedCampaign> result = new ArrayList<>();
		try {
			int maxSentCount = Integer.parseInt(getLmsConfigValue("RECHARGE_REMINDER_MAX_SHOW_COUNT", MAX_SENT_COUNT).toString());
			
			result = jdbcTemplate.query(sqlProperties.getFetchMessagesSql(),
					new Object[] { type.ordinal(), NotificationStatus.UNREAD.ordinal(), maxSentCount },
					new RowMapper<PushedCampaign>() {

				@Override
				public PushedCampaign mapRow(ResultSet rs, int rowNum) throws SQLException {
					String detailsVI = "", descVI = "", titleVI = "";
					/*
					try {
						titleVI = new String(rs.getString("title_vi").getBytes(), "UTF-8");
						descVI = new String(rs.getString("desc_vi").getBytes(), "UTF-8");
						detailsVI = new String(rs.getString("details_vi").getBytes(), "UTF-8");
					} catch (UnsupportedEncodingException e) { }
					*/
					titleVI = rs.getString("title_vi");
					descVI = rs.getString("desc_vi");
					detailsVI = rs.getString("details_vi");
					
					PushedCampaign pc = new PushedCampaign(rs.getInt("id"), 
							rs.getString("title_en"), rs.getString("desc_en"), rs.getString("details_en"), 
							titleVI, descVI, detailsVI, 
							rs.getString("target_msisdn"));
					
					return pc;
				}
			});
		} catch (Exception e) {
			logger.error("#getUnreadMessages --- error retrieving unread messages from DB!", e);
		}
		return result;
	}
	
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public List<PushedCampaign> getUsersUnreadMessages(PushedCampaignType type, String msisdn){
		
		List<PushedCampaign> result = new ArrayList<>();
		try {
			int maxSentCount = Integer.parseInt(getLmsConfigValue("RECHARGE_REMINDER_MAX_SHOW_COUNT", MAX_SENT_COUNT).toString());
			
			result = jdbcTemplate.query(sqlProperties.getFetchMessageForUserSql(),
					new Object[] { msisdn, type.ordinal(), NotificationStatus.UNREAD.ordinal(), maxSentCount },
					new RowMapper<PushedCampaign>() {

				@Override
				public PushedCampaign mapRow(ResultSet rs, int rowNum) throws SQLException {
					String detailsVI = "", descVI = "", titleVI = "";
					/*
					try {
						titleVI = new String(rs.getString("title_vi").getBytes(), "UTF-8");
						descVI = new String(rs.getString("desc_vi").getBytes(), "UTF-8");
						detailsVI = new String(rs.getString("details_vi").getBytes(), "UTF-8");
					} catch (UnsupportedEncodingException e) { }
					*/
					titleVI = rs.getString("title_vi");
					descVI = rs.getString("desc_vi");
					detailsVI = rs.getString("details_vi");
					
					PushedCampaign pc = new PushedCampaign(rs.getInt("id"), 
							rs.getString("title_en"), rs.getString("desc_en"), rs.getString("details_en"), 
							titleVI, descVI, detailsVI, 
							rs.getString("target_msisdn"));
					
					return pc;
				}
			});
		} catch (Exception e) {
			logger.error("#getUnreadMessages --- error retrieving unread messages from DB!", e);
		}
		return result;
	}
	
	
	public int pushInstantMessage(String msisdn, String title, String msgBody, String badge) {
		
		int count = 0;

		if (!StringUtils.hasText(msisdn)) return count;
		
		String endPoint = getAppConfigValue("fcm.endpoint.legacy", FCM_ENDPOINT).toString();
		
		String token = getUserToken(msisdn);
		if (token != null) {
			if (StringUtils.hasText(msgBody)) {
				FcmNotification notification = new FcmNotification(title, msgBody);
				if (StringUtils.hasText(badge)) {
					notification.setBadge("" + badge);
				}
				FcmMessage message = new FcmMessage(notification, token);
				message.setMsisdn(msisdn);
				
				if (pushMessage(message, endPoint)) count++;
			} else {
				List<PushedCampaign> list = getUsersUnreadMessages(PushedCampaignType.FATTY_MONSTER, msisdn);
				
				if (list != null) {
					String language = getUserLanguage(msisdn);
					
					for (PushedCampaign pc : list) {
						title = language.equals(VIE) ? pc.getTitleVI() : pc.getTitleEN();
						String body = language.equals(VIE) ? pc.getDetailsVI() : pc.getDetailsEN();

						FcmNotification notification = new FcmNotification(title, body);
						notification.setBadge("1");
						FcmMessage message = new FcmMessage(notification, token);
						message.setMessageId(pc.getId());
						message.setMsisdn(msisdn);
						
						if (pushMessage(message, endPoint)) {
							updateMessageSentCounter(pc.getId());
							count++;
						}
					}
				}
			}
		}
		return count;
	}
	
	private String getTopupReminderCronExpr() {
		
		String hoursInterval = getLmsConfigValue(LmsConfigNames.RECHARGE_REMINDER_HOURS.name(), "1").toString();
		String days = getLmsConfigValue(LmsConfigNames.RECHARGE_REMINDER_DAYS.name(), "?").toString();
		StringBuffer dayExpr = new StringBuffer();
		
		if (!days.equals("?")) {
			String[] arrDays = days.split(",");
			if (arrDays.length > 1){
				for (int i=0; i<arrDays.length; i++) {
					if (arrDays[i].length() >= 3){
						dayExpr.append(arrDays[i].toUpperCase().substring(0, 3));
					} else {
						dayExpr.append(arrDays[i]);
					}
					if (i < arrDays.length - 1) {
						dayExpr.append(",");
					}
				}
			} else {
				if (days.length() >= 3){
					dayExpr.append(days.trim().toUpperCase().substring(0, 3));
				} else {
					dayExpr.append(days);
				}
			}
		}
		
		//minute takes precedence
		int min = Integer.parseInt(getLmsConfigValue(LmsConfigNames.RECHARGE_REMINDER_MINUTES.name(), "0").toString());
		if (min > 0) {
			topupReminderCronExpr = "0 */" + min + " * * * " + dayExpr.toString();
		} else {
			topupReminderCronExpr = "0 0 */" + hoursInterval + " * * " + dayExpr.toString();
		}
		 
		logger.debug("#createCronExpressionForTopupReminder --- cron expr= " + topupReminderCronExpr);
		
		return topupReminderCronExpr;
	}
	
	private String getUserToken(String msisdn) {
		try {
			//return jdbcTemplate.queryForObject(sqlProperties.getRetrieveFcmTokenSql(), new String[] { msisdn }, String.class);
			List<String> tokens = jdbcTemplate.queryForList(sqlProperties.getRetrieveFcmTokenSql(), new String[] { msisdn }, String.class);
			return tokens != null && !tokens.isEmpty() ? tokens.get(0) : null; 
			
		} catch (Exception e) {
			logger.error("#getUserToken --- error retrieving FCM token for MSISDN " + msisdn, e);
		}
		return null;
	}
	
	private String getUserLanguage(String msisdn) {
		try {
			return jdbcTemplate.queryForObject(sqlProperties.getUserLanguageSql(), new String[] { msisdn }, String.class);
		} catch (Exception e) {
			logger.error("#getUserLanguage --- error retrieving subscriber data for MSISDN " + msisdn, e);
		}
		return VIE;
	}
	
	private CloseableHttpClient getHttpClient(){
		if (httpClient == null){
			String serverKey = getAppConfigValue("fcm.serverkey", "").toString();
			
			List<Header> headers = new ArrayList<>();
			headers.add(new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/json"));
			headers.add(new BasicHeader(HttpHeaders.AUTHORIZATION, "key=" + serverKey));
			
			httpClient = HttpClients.custom()
					.setRedirectStrategy(new LaxRedirectStrategy())
					.setConnectionManager(getConnectionManager())
					.setConnectionManagerShared(true)
					.setDefaultHeaders(headers)
					.setDefaultRequestConfig(getRequestConfig()).build();
		}
		return httpClient;
	}

	private PoolingHttpClientConnectionManager getConnectionManager() {
		if (connectionManager == null) {
			connectionManager = new PoolingHttpClientConnectionManager();
			connectionManager.setMaxTotal(Integer.parseInt(getAppConfigValue("fcm.maxconnections", MAX_CONNECTIONS).toString()));
			connectionManager.setValidateAfterInactivity(CONNECTION_CHECK_INTV_SECS);
		}
		return connectionManager;
	}
	
	private RequestConfig getRequestConfig() {
		
		if (requestConfig == null) {
			
			int connectTimeout = Integer.parseInt(getAppConfigValue("fcm.connectimeout", CONNECTION_TIMEOUT_IN_SECS).toString()) * 1000;

			requestConfig = RequestConfig.custom()
					.setCookieSpec(CookieSpecs.DEFAULT)
					.setSocketTimeout(connectTimeout)
					.setConnectTimeout(connectTimeout)
					.setConnectionRequestTimeout(connectTimeout).build();
		}
		return requestConfig;
	}
	
	private Object getLmsConfigValue(String name, Object defaultValue) {
		Object value = lmsConfigs.get(name);
		return value != null ? value : defaultValue;
	}

	private Object getAppConfigValue(String name, Object defaultValue) {
		Object value = applicationConfigs.get(name);
		return value != null ? value : defaultValue;
	}
	
	@Scheduled(cron = "${fcmclient.config.common.reloadinterval:0 0/30 * * * ?}")
//	@Scheduled(fixedRate = 300000)
	public void loadApplicationConfigs(){
		logger.info("--- loading configuration from APP_CONFIG table...");
		try {
			List<NameValue> list = jdbcTemplate.query(sqlProperties.getRetrieveAllAppConfigSql(), new RowMapper<NameValue>() {

				@Override
				public NameValue mapRow(ResultSet rs, int rowNum) throws SQLException {
					return new NameValue(rs.getString("name"), rs.getString("value"));
				}
				
			});
			
			if (list != null) {
				for (NameValue nv : list) {
					applicationConfigs.put(nv.getName(), nv.getValue());
				}
			}
		} catch (Exception e) {
			logger.error("#loadApplicationConfigs --- error retrieving data from app_config table!", e);
		}
	}
	
	@Scheduled(cron = "${fcmclient.config.lms.reloadinterval:0 0/5 * * * ?}")
//	@Scheduled(fixedRate = 300000)
	public void loadLmsConfigs(){
		logger.info("--- loading configuration from LMS_CONFIG table...");
		try {
			List<NameValue> list = jdbcTemplate.query(sqlProperties.getRetrieveAllLmsConfigSql(), new RowMapper<NameValue>() {

				@Override
				public NameValue mapRow(ResultSet rs, int rowNum) throws SQLException {
					return new NameValue(rs.getString("name"), rs.getString("value"));
				}
				
			});
			
			if (list != null) {
				for (NameValue nv : list) {
					lmsConfigs.put(nv.getName(), nv.getValue());
				}
				
				String newCronExpr = getTopupReminderCronExpr();
				if (!lastTopupReminderCronExpr.equalsIgnoreCase("") && !lastTopupReminderCronExpr.equals(newCronExpr)) {
					logger.debug(String.format("Change of scheduler expression detected (old_expr= %s, new_expr= %s, restarting cron job now...", lastTopupReminderCronExpr, newCronExpr));
					
					lastTopupReminderCronExpr = newCronExpr;
					restartScheduler();
				}
				
			}
		} catch (Exception e) {
			logger.error("#loadLmsConfigs --- error retrieving data from lms_config table!", e);
		}
	}
	
	final class NameValue{
		
		private String name;
		private String value;
		
		public NameValue(String name, String value) {
			this.name = name;
			this.value = value;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * @return the value
		 */
		public String getValue() {
			return value;
		}

		/**
		 * @param value the value to set
		 */
		public void setValue(String value) {
			this.value = value;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("NameValue [name=");
			builder.append(name);
			builder.append(", value=");
			builder.append(value);
			builder.append("]");
			return builder.toString();
		}
		
	}
}
