/**
 * SMPPClient.java
 */
package com.gnv.vnm.selfcare.core.smpp;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

import org.jsmpp.InvalidResponseException;
import org.jsmpp.PDUException;
import org.jsmpp.bean.Alphabet;
import org.jsmpp.bean.ESMClass;
import org.jsmpp.bean.GeneralDataCoding;
import org.jsmpp.bean.NumberingPlanIndicator;
import org.jsmpp.bean.OptionalParameter;
import org.jsmpp.bean.OptionalParameters;
import org.jsmpp.bean.RegisteredDelivery;
import org.jsmpp.bean.SMSCDeliveryReceipt;
import org.jsmpp.bean.TypeOfNumber;
import org.jsmpp.extra.NegativeResponseException;
import org.jsmpp.extra.ResponseTimeoutException;
import org.jsmpp.extra.SessionState;
import org.jsmpp.session.MessageReceiverListener;
import org.jsmpp.session.SMPPSession;
import org.jsmpp.session.SessionStateListener;
import org.jsmpp.util.AbsoluteTimeFormatter;
import org.jsmpp.util.TimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor;
import com.gnv.vnm.selfcare.core.utils.AppUtils;
import com.gnv.vnm.selfcare.core.utils.LoggingUtil;

/**
 * @author nandipinto
 *
 */
public class SMPPClient {
	
	private static final Logger logger = LoggerFactory.getLogger(SMPPClient.class);
	
	public static final int RECONNECT_INTERVAL = 60 * 1000;
	public static final int MAX_RECONNECT_ATTEMPT = 10;
	
	public static final int UCS2_MAX_TXT_LEN = 70;
	public static final int DEFAULT_MAX_TXT_LEN = 140;
	
	private static TimeFormatter timeFormatter = new AbsoluteTimeFormatter();

	private SMPPConnection connection;
	
	private SMPPSession smppSession = null;
	private boolean connected = false;
	private MessageReceiverListener messageReceiverListener;
	
	@Autowired
	private BackEndRequestProcessor backEndRequestProcessor;
	
	Mieadter meadietr =new Mieadter();
	
	/**
	 * @param connection
	 */
	public SMPPClient(SMPPConnection connection) {
		this.connection = connection;
	}

	/**
	 * @param connection
	 * @param messageReceiverListener
	 */
	public SMPPClient(SMPPConnection connection, MessageReceiverListener messageReceiverListener) {
		this.connection = connection;
		this.messageReceiverListener = messageReceiverListener;
	}

	/**
	 * @return the connected
	 */
	public boolean isConnected() {
		return connected;
	}

	/**
	 * @param connected the connected to set
	 */
	public void setConnected(boolean connected) {
		this.connected = connected;
	}

	/**
	 * @return the messageReceiverListener
	 */
	public MessageReceiverListener getMessageReceiverListener() {
		return messageReceiverListener;
	}

	/**
	 * @param messageReceiverListener the messageReceiverListener to set
	 */
	public void setMessageReceiverListener(MessageReceiverListener messageReceiverListener) {
		this.messageReceiverListener = messageReceiverListener;
	}

	/*public void connect() throws Exception {
		
		LoggingUtil.debug(logger, "#connect >> Establishing SMPP connection to " + connection.getHost() + ":" + connection.getPort());
		smppSession = new SMPPSession();
		smppSession.addSessionStateListener(new SessionStateListenerImpl());
		if (this.messageReceiverListener != null){
			smppSession.setMessageReceiverListener(this.messageReceiverListener);
		}
		smppSession.connectAndBind(connection.getHost(), connection.getPort(), connection.getBindType(), 
				connection.getUserName(), connection.getCredential(), "smpp", TypeOfNumber.INTERNATIONAL,
				NumberingPlanIndicator.UNKNOWN, null);

		connected = true;
		LoggingUtil.debug(logger, "#connect >> SMPP connection established.");
		
		if (!smppSession.getSessionState().isBound()) {
			throw new Exception("Failed to open SMPP session!");
		}
	}*/
	
	/*public String sendMessage(String sourceAddr, String destAddr, String message, GeneralDataCoding dataCoding, String charset){
		String msgId = null;
        try {
        		LoggingUtil.debug(logger, String.format("#sendMessage >> Sending message via SMPP [%s] to (%s), message= [%s] ", new Object[]{connection.getHost(), destAddr, message}));
        	
//        		GeneralDataCoding dataCoding = new GeneralDataCoding(); 
//        		GeneralDataCoding dataCoding = new GeneralDataCoding(Alphabet.ALPHA_DEFAULT, MessageClass.CLASS1, true);
//        		GeneralDataCoding dataCoding = new GeneralDataCoding(Alphabet.ALPHA_8_BIT, MessageClass.CLASS1, true);
        		if (dataCoding == null) {
        			dataCoding = new GeneralDataCoding(Alphabet.ALPHA_UCS2);
        		}
        		if (AppUtils.emptyOrWhiteSpace(charset)) {
        			charset = "UTF-16BE";
        		}
        		
        		int maxLength = dataCoding.getAlphabet().equals(Alphabet.ALPHA_UCS2) ? UCS2_MAX_TXT_LEN : DEFAULT_MAX_TXT_LEN;
        		if (message.length() <= maxLength) {
        			msgId = smppSession.submitShortMessage("", connection.getSenderTON(), NumberingPlanIndicator.UNKNOWN, sourceAddr, 
        			        connection.getRecipientTON(), NumberingPlanIndicator.UNKNOWN, destAddr, 
        			        new ESMClass(), (byte)0, (byte)0, 
        			        null, null, new RegisteredDelivery(SMSCDeliveryReceipt.DEFAULT), 
        			        (byte)0, 
        			        dataCoding,
        			        (byte)0, message.getBytes(charset)); //message.getBytes("UTF-16BE"));
        			
        			LoggingUtil.debug(logger, "#sendMessage >> Message sent successfully, returning MessageID= " + msgId);
        			return msgId;
        			
        		} else {
        			String[] messages = AppUtils.sliceString(message, maxLength);
        			OptionalParameter sarMsgRefNum = OptionalParameters.newSarMsgRefNum((short)new Random().nextInt());
        	        OptionalParameter sarTotalSegments = OptionalParameters.newSarTotalSegments(messages.length);
        	        
        	        int seqNum = 1;
        	        for (String msg : messages) {
        	        		OptionalParameter sarSegmentSeqnum = OptionalParameters.newSarSegmentSeqnum(seqNum);
        	        		
        	        		messageId = session.submitShortMessage("CMT", TypeOfNumber.INTERNATIONAL, NumberingPlanIndicator.UNKNOWN, "1616", TypeOfNumber.INTERNATIONAL, 
        	        				NumberingPlanIndicator.UNKNOWN, "628176504657", new ESMClass(), (byte)0, (byte)1,  timeFormatter.format(new Date()), null, 
        	        				new RegisteredDelivery(SMSCDeliveryReceipt.DEFAULT), (byte)0, 
        	        					DataCodings.ZERO, (byte)0, message.getBytes(), sarMsgRefNum, sarSegmentSeqnum, sarTotalSegments);
        	        		
        	        		LoggingUtil.debug(logger, "#sendMessage >> sending message part " + seqNum + " of " + messages.length + ", text_msg= [" + msg + "]");
        	        		msgId = smppSession.submitShortMessage("", connection.getSenderTON(), NumberingPlanIndicator.UNKNOWN, sourceAddr, 
                			        connection.getRecipientTON(), NumberingPlanIndicator.UNKNOWN, destAddr, 
                			        new ESMClass(), (byte)0, (byte)1, 
                			        timeFormatter.format(new Date()), null, new RegisteredDelivery(SMSCDeliveryReceipt.DEFAULT), 
                			        (byte)0, dataCoding, (byte)0, msg.getBytes(charset), 
                			        sarMsgRefNum, sarSegmentSeqnum, sarTotalSegments);
        	        		
        	        		LoggingUtil.debug(logger, "#sendMessage >> message part " + seqNum + " of " + messages.length + "sent successfully, returning MessageID= " + msgId);
        	        		seqNum++;
        	        }
        		}
		} catch (PDUException e) {
			logger.error("PDU_ERROR, could not send message to " + destAddr + ", error= " + e.getMessage());
		} catch (ResponseTimeoutException e) {
			logger.error("RESPONSE_TIMEOUT, could not send message to " + destAddr + ", error= " + e.getMessage());
		} catch (InvalidResponseException e) {
			logger.error("INVALID_RESPONSE, could not send message to " + destAddr + ", error= " + e.getMessage());
		} catch (NegativeResponseException e) {
			logger.error("NEGATIVE_RESPONSE, could not send message to " + destAddr + ", error= " + e.getMessage());
		} catch (IOException e) {
			logger.error("IO_EXCEPTION, could not send message to " + destAddr + ", error= " + e.getMessage());
		} 
        return msgId;
	}*/
	
	/*public String sendMessagenew(String sourceAddr, String destAddr, String message, GeneralDataCoding dataCoding, String charset){
		String msgId = null;
		int count=0;
		try {
		LoggingUtil.debug(logger, String.format("#sendMessage >> Sending message via SMPP [%s] to (%s), message= [%s] ", new Object[]{connection.getHost(), destAddr, message}));

		// GeneralDataCoding dataCoding = new GeneralDataCoding(); 
		// GeneralDataCoding dataCoding = new GeneralDataCoding(Alphabet.ALPHA_DEFAULT, MessageClass.CLASS1, true);
		// GeneralDataCoding dataCoding = new GeneralDataCoding(Alphabet.ALPHA_8_BIT, MessageClass.CLASS1, true);
		if (dataCoding == null) {
		dataCoding = new GeneralDataCoding(Alphabet.ALPHA_UCS2);
		}
		if (AppUtils.emptyOrWhiteSpace(charset)) {
		charset = "UTF-16BE";
		}

		int maxLength = dataCoding.getAlphabet().equals(Alphabet.ALPHA_UCS2) ? UCS2_MAX_TXT_LEN : DEFAULT_MAX_TXT_LEN;
		if (message.length() <= maxLength) {
		msgId = smppSession.submitShortMessage("", connection.getSenderTON(), NumberingPlanIndicator.UNKNOWN, sourceAddr, 
		connection.getRecipientTON(), NumberingPlanIndicator.UNKNOWN, destAddr, 
		new ESMClass(), (byte)0, (byte)0, 
		null, null, new RegisteredDelivery(SMSCDeliveryReceipt.DEFAULT), 
		(byte)0, 
		dataCoding,
		(byte)0, message.getBytes(charset)); //message.getBytes("UTF-16BE"));

		LoggingUtil.debug(logger, "#sendMessage >> Message sent successfully, returning MessageID= " + msgId);
		// Sending message via SMPP [10.6.2.33] to (84528050884), message= [OTP của bạn là 249334] 
		// Message sent successfully, returning MessageID= 20640b7b-80b4-47ac-b618-babba672fb3e
		LoggingUtil.debug(logger, "#print backEndRequestProcessor >> backEndRequestProcessor" + meadietr+"-----destAddr ----"+destAddr);

		long blockHours=0;
		String firstFailTransactionTime = meadietr.getFirstTimestampOtpStatus(destAddr);

		if(firstFailTransactionTime != null){ 

		blockHours = TimeDiff(firstFailTransactionTime, getCurrentDateTime());
		}
		if(blockHours >= 24){
		backEndRequestProcessor.saveOtpStatus(destAddr, 1, "0", getCurrentDateTime());
		}
		else{

		OtpBlockHistoryEntity otpBlockHistoryEntity = new OtpBlockHistoryEntity();
		count = backEndRequestProcessor.getCountFromOtpBlock(destAddr);

		if(count == 0 ){
		count = 1;
		}
		else if(count != 0 ){
		count = count + 1; 

		}
		}
		System.out.println("Backed Request Is "+backEndRequestProcessor);
//			backEndRequestProcessor.saveOtpStatus(destAddr, 0, "0", getCurrentDateTime());
		//meadietr.savedata(destAddr, 0, "0", getCurrentDateTime()); 
		return msgId;

		} else {
		String[] messages = AppUtils.sliceString(message, maxLength);
		OptionalParameter sarMsgRefNum = OptionalParameters.newSarMsgRefNum((short)new Random().nextInt());
		OptionalParameter sarTotalSegments = OptionalParameters.newSarTotalSegments(messages.length);

		int seqNum = 1;
		for (String msg : messages) {
		OptionalParameter sarSegmentSeqnum = OptionalParameters.newSarSegmentSeqnum(seqNum);
		
		messageId = session.submitShortMessage("CMT", TypeOfNumber.INTERNATIONAL, NumberingPlanIndicator.UNKNOWN, "1616", TypeOfNumber.INTERNATIONAL, 
		NumberingPlanIndicator.UNKNOWN, "628176504657", new ESMClass(), (byte)0, (byte)1, timeFormatter.format(new Date()), null, 
		new RegisteredDelivery(SMSCDeliveryReceipt.DEFAULT), (byte)0, 
		DataCodings.ZERO, (byte)0, message.getBytes(), sarMsgRefNum, sarSegmentSeqnum, sarTotalSegments);
		
		LoggingUtil.debug(logger, "#sendMessage >> sending message part " + seqNum + " of " + messages.length + ", text_msg= [" + msg + "]");
		msgId = smppSession.submitShortMessage("", connection.getSenderTON(), NumberingPlanIndicator.UNKNOWN, sourceAddr, 
		connection.getRecipientTON(), NumberingPlanIndicator.UNKNOWN, destAddr, 
		new ESMClass(), (byte)0, (byte)1, 
		timeFormatter.format(new Date()), null, new RegisteredDelivery(SMSCDeliveryReceipt.DEFAULT), 
		(byte)0, dataCoding, (byte)0, msg.getBytes(charset), 
		sarMsgRefNum, sarSegmentSeqnum, sarTotalSegments);

		LoggingUtil.debug(logger, "#sendMessage >> message part " + seqNum + " of " + messages.length + "sent successfully, returning MessageID= " + msgId);

		seqNum++;
		}
		}
		} catch (PDUException e) {
		//meadietr.savedata(destAddr, count, "0", getCurrentDateTime()); 
		logger.error("PDU_ERROR, could not send message to " + destAddr + ", error= " + e.getMessage());
		} catch (ResponseTimeoutException e) {
//			meadietr.savedata(destAddr, count, "0", getCurrentDateTime());
		logger.error("RESPONSE_TIMEOUT, could not send message to " + destAddr + ", error= " + e.getMessage());
		} catch (InvalidResponseException e) {
//			meadietr.savedata(destAddr, count, "0", getCurrentDateTime()); 
		logger.error("INVALID_RESPONSE, could not send message to " + destAddr + ", error= " + e.getMessage());
		} catch (NegativeResponseException e) {
//			meadietr.savedata(destAddr, count, "0", getCurrentDateTime());
		logger.error("NEGATIVE_RESPONSE, could not send message to " + destAddr + ", error= " + e.getMessage());
		} catch (IOException e) {
//			meadietr.savedata(destAddr, count, "0", getCurrentDateTime());
		logger.error("IO_EXCEPTION, could not send message to " + destAddr + ", error= " + e.getMessage());
		} 
		return msgId;
		}
	
	public void disconnect(){
		if (smppSession != null){
			smppSession.unbindAndClose();
			smppSession = null;	
		}
	}
	
	private void reconnect(final long timeInMillis) {
		new Thread() {
			@Override
			public void run() {
				LoggingUtil.debug(logger, "#recoverSmppConnection >> Scheduled to reconnect after " + timeInMillis + " millis", null);
				try {
					Thread.sleep(timeInMillis);
				} catch (InterruptedException e) {
				}
				int attempt = 0;
				//while (!isConnected() && attempt < maxLoginAttempt){
				while ( (smppSession == null || smppSession.getSessionState().equals(SessionState.CLOSED)) && attempt < MAX_RECONNECT_ATTEMPT) {
					attempt++;

					try {
						LoggingUtil.debug(logger, "#recoverSmppConnection >> Reconnecting attempt #" + (attempt) + "...", null);
						connect();
					} catch (Exception e) {
						logger.error("#recoverSmppConnection >> Failed to recover SMPP connection to " + connection.getHost() + ":" + connection.getPort(), e);
						// wait for a second
						try {
							Thread.sleep(1000);
						} catch (InterruptedException ee) {}
					}

				}
				if (smppSession == null || smppSession.getSessionState().equals(SessionState.CLOSED)) {
					logger.error("#recoverSmppConnection >> Failed to recover SMPP connection to " + connection.getHost()
									+ ":" + connection.getPort() + " after " + attempt + " attempts");
				}
				attempt = 0; //reset attempt counter
			}
		}.start();
	}
	
	private class SessionStateListenerImpl implements SessionStateListener {
		public void onStateChange(SessionState newState, SessionState oldState, Object source) {
			if (newState.equals(SessionState.CLOSED)) {
				LoggingUtil.debug(logger, "SMPP Session closed, will try to reconnect.", null);
				reconnect(connection.getReconnectInterval() * 1000L);
			}
		}
	}*/

}
