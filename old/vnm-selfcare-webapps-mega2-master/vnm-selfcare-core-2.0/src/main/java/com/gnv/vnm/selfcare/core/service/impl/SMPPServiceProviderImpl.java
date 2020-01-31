/**
 * SMPPServiceProviderImpl.java
 */
package com.gnv.vnm.selfcare.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.jsmpp.bean.BindType;
import org.jsmpp.bean.GeneralDataCoding;
import org.jsmpp.bean.TypeOfNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gnv.vnm.selfcare.core.service.ApplicationConfigurationService;
import com.gnv.vnm.selfcare.core.service.SMPPServiceProvider;
import com.gnv.vnm.selfcare.core.smpp.SMPPClient;
import com.gnv.vnm.selfcare.core.smpp.SMPPConnection;
import com.gnv.vnm.selfcare.core.utils.AppUtils;
import com.gnv.vnm.selfcare.dao.entity.OtpStatusEntity;
import com.gnv.vnm.selfcare.dao.entity.QOtpStatusEntity;
import com.gnv.vnm.selfcare.dao.repo.OtpStatusRepository;

/**
 * @author nandipinto
 *
 */

@Service("smppServiceProvider")
public class SMPPServiceProviderImpl implements SMPPServiceProvider {

	private static final Logger logger = LoggerFactory.getLogger(SMPPServiceProviderImpl.class);

	static final String SEPARATOR_REGEX = "\\|";
	static final int MAX_RETRY_ATTEMPTS = 3;

	@Autowired
	private ApplicationConfigurationService applicationConfigurationService;

	@Autowired
	private OtpStatusRepository otpstatusRepository;

	private int lastIdx = 0;

	private String[] hostList;
	private String[] portList;
	private String[] userList;
	private String[] passwordList;

	private List<SMPPClient> smppClients = new ArrayList<>();

	/*@PostConstruct
	public void setupSmppConnection() {
		// commented out for temporary
		BindType bindType = BindType
				.valueOf(applicationConfigurationService.get("smpp.bindtype", "BIND_TX").toString());
		String reconnectInterval = applicationConfigurationService.get("smpp.reconnectinterval.secs", "60").toString();
		String senderTON = applicationConfigurationService.get("smpp.ton.sender", "").toString().toUpperCase();
		String recipientTON = applicationConfigurationService.get("smpp.ton.recepient", "").toString().toUpperCase();

		hostList = applicationConfigurationService.get("smpp.host", "localhost").toString().split(SEPARATOR_REGEX);
		portList = applicationConfigurationService.get("smpp.port", "2775").toString().split(SEPARATOR_REGEX);
		userList = applicationConfigurationService.get("smpp.username", "").toString().split(SEPARATOR_REGEX);
		passwordList = applicationConfigurationService.get("smpp.password", "").toString().split(SEPARATOR_REGEX);

		if (hostList.length > 0) {
			int clientCount = hostList.length;
			for (int i = 0; i < clientCount; i++) {
				try {
					SMPPConnection connection = new SMPPConnection();
					connection.setBindType(bindType);
					connection.setCredential(passwordList[i]);
					connection.setHost(hostList[i]);
					connection.setPort(Integer.parseInt(portList[i]));
					connection.setReconnectInterval(Integer.parseInt(reconnectInterval));
					connection.setUserName(userList[i]);

					if (StringUtils.hasText(senderTON)) {
						try {
							connection.setSenderTON(TypeOfNumber.valueOf(senderTON));
						} catch (Exception e) {
						}
					}

					if (StringUtils.hasText(recipientTON)) {
						try {
							connection.setRecipientTON(TypeOfNumber.valueOf(recipientTON));
						} catch (Exception e) {
						}
					}

					SMPPClient smppClient = new SMPPClient(connection);
					smppClient.connect();

					smppClients.add(smppClient);
				} catch (Exception e) {
					logger.error("-- error initiating up SMPP connection to " + hostList[i], e);
				}
			}
		}
	}*/

	/*@PreDestroy
	public void cleanUp() {
		for (SMPPClient smppClient : smppClients) {
			if (smppClient != null) {
				smppClient.disconnect();
			}
		}
	}*/

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gnv.vnm.selfcare.core.service.SMPPServiceProvider#sendSMS(java.lang.
	 * String, java.lang.String, java.lang.String)
	 */
	/*@Override
	public String sendSMS(String sender, String recipient, String message, boolean prependCountryCode,
			GeneralDataCoding dataCoding, String charset) {

		if (smppClients.isEmpty()) {
			logger.error("#sendSMS --- could not send message to " + recipient + ", not connected to any SMSC!");
			return null;
		}

		SMPPClient smppClient = null;
		if (prependCountryCode)
			recipient = AppUtils.prependCountryCodeToMsisdn(recipient,
					applicationConfigurationService.getDefaultCountryCode());

		String msgId = null;
		int attempt = 0;
		while (attempt < MAX_RETRY_ATTEMPTS && msgId == null) {
			smppClient = smppClients.get(getLastIdx());
			if (smppClient.isConnected()) {
				msgId = smppClient.sendMessage(sender, recipient, message, dataCoding, charset);
				attempt++;
			}
		}

		return msgId;
	}*/

	private int getLastIdx() {
		if (smppClients.size() == 1)
			return 0;
		lastIdx++;
		if (lastIdx >= smppClients.size())
			lastIdx = 0;

		return lastIdx;
	}

	/*@Override
	public String sendSMSnew(String sender, String recipient, String message, boolean prependCountryCode,
			GeneralDataCoding dataCoding, String charset) {
		int count = 0;
		String msgId = null;
		String msisdn = recipient;

		try {
			if (smppClients.isEmpty()) {
				logger.error("#sendSMS --- could not send message to " + recipient + ", not connected to any SMSC!");
				return null;
			}

			SMPPClient smppClient = null;

			if (prependCountryCode)
				recipient = AppUtils.prependCountryCodeToMsisdn(recipient,
						applicationConfigurationService.getDefaultCountryCode());

			// System.out.println("smppClients size "+smppClients.size()+" index
			// "+getLastIdx());

			int attempt = 0;
			while (attempt < MAX_RETRY_ATTEMPTS && msgId == null) {
				smppClient = smppClients.get(getLastIdx());
				if (smppClient.isConnected()) {
					msgId = smppClient.sendMessagenew(sender, recipient, message, dataCoding, charset);
					// msgId =
					// smppClient.sendMessagenew("10.6.2.33","84528050884","OTP
					// của bạn là 249334",null,"UTF-8");

					// msgId="123";
					// msgId= null;
					System.out.println("msgId " + msgId);
					attempt++;
				}
			}

			if (msgId == null) {
				System.out.println("In msgId fail " + msisdn);
				System.out.println("msisidn " + msisdn);
				OtpStatusEntity otpStatusEntity = otpstatusRepository
						.findOne(QOtpStatusEntity.otpStatusEntity.msisdn.eq(msisdn));
				System.out.println("entity from msisdn " + otpStatusEntity);
				if (otpStatusEntity != null) {
					System.out.println("if otpstatus not null");
					System.out.println("fc drd " + otpStatusEntity.getFailCount());
					int failCount = otpStatusEntity.getFailCount();
					System.out.println("fc" + failCount);
					if (failCount >= 0) {
						failCount++;
						otpStatusEntity.setFailCount(failCount);
					} else {
						otpStatusEntity.setFailCount(0);
					}
					otpStatusEntity.setId(otpStatusEntity.getId());
					otpstatusRepository.save(otpStatusEntity);
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		 * //smppClient=smppClients.get(1); BindType bindType =
		 * BindType.valueOf(applicationConfigurationService.get("smpp.bindtype",
		 * "BIND_TX").toString()); String reconnectInterval =
		 * applicationConfigurationService.get("smpp.reconnectinterval.secs",
		 * "60").toString(); String senderTON =
		 * applicationConfigurationService.get("smpp.ton.sender",
		 * "").toString().toUpperCase(); String recipientTON =
		 * applicationConfigurationService.get("smpp.ton.recepient",
		 * "").toString().toUpperCase();
		 * 
		 * hostList = applicationConfigurationService.get("smpp.host",
		 * "localhost").toString().split(SEPARATOR_REGEX); portList =
		 * applicationConfigurationService.get("smpp.port",
		 * "2775").toString().split(SEPARATOR_REGEX); userList =
		 * applicationConfigurationService.get("smpp.username",
		 * "").toString().split(SEPARATOR_REGEX); passwordList =
		 * applicationConfigurationService.get("smpp.password",
		 * "").toString().split(SEPARATOR_REGEX); SMPPConnection connection =
		 * new SMPPConnection();
		 * 
		 * connection.setBindType(bindType);
		 * connection.setCredential(passwordList[0]);
		 * connection.setHost(hostList[0]);
		 * connection.setPort(Integer.parseInt(portList[0]));
		 * connection.setReconnectInterval(Integer.parseInt(reconnectInterval));
		 * connection.setUserName(userList[0]);;
		 * 
		 * 
		 * backEndRequestProcessor.saveOtpStatus("8588027214", 0, "0",
		 * getCurrentDateTime()); SMPPClient smppClient1 = new
		 * SMPPClient(connection); try { smppClient1.connect(); } catch
		 * (Exception e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * smppClients.add(smppClient1); msgId =
		 * smppClient1.sendMessagenew("10.6.2.33",
		 * "84528050884","OTP của bạn là 249334",null,"UTF-8");
		 
		
		 * long blockHours=0; String firstFailTransactionTime =
		 * backEndRequestProcessor.getFirstTimestampOtpStatus(recipient);
		 * 
		 * if(firstFailTransactionTime != null){
		 * 
		 * blockHours = TimeDiff(firstFailTransactionTime,
		 * getCurrentDateTime()); } if(blockHours >= 24){
		 * backEndRequestProcessor.saveOtpStatus(recipient, 1, "0",
		 * getCurrentDateTime()); } else{
		 * 
		 * OtpBlockHistoryEntity otpBlockHistoryEntity = new
		 * OtpBlockHistoryEntity(); count =
		 * backEndRequestProcessor.getCountFromOtpBlock(recipient); } if(count
		 * == 0 ){ count = 1; } else if(count != 0 ){ count = count + 1;
		 * 
		 * } ; if (msgId!=null){
		 * backEndRequestProcessor.saveOtpStatus(recipient, count, "0",
		 * getCurrentDateTime()); } else{
		 * backEndRequestProcessor.saveOtpStatus(recipient, count, "0",
		 * getCurrentDateTime()); }
		 

		// block if failed five times

		return msgId;
	}*/

}
