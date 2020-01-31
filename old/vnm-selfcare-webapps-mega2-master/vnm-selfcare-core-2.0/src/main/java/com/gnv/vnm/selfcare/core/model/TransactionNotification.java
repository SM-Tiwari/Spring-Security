/**
 * TransactionNotification.java
 */
package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;

import com.gnv.vnm.selfcare.core.enums.NotificationStatus;

/**
 * @author nandipinto
 *
 */
public class TransactionNotification implements Serializable {

	private static final long serialVersionUID = 2599811479055010567L;
	
	private int msgId;
	private String msisdn;
	private String messageEN;
	private String messageVN;
	private NotificationStatus status;
	
	public TransactionNotification(int msgId, NotificationStatus status){
		this.msgId = msgId;
		this.status = status;
	}
	
	public TransactionNotification(int msgId, String msisdn, String messageEN, String messageVN,
			NotificationStatus status) {
		this.msgId = msgId;
		this.msisdn = msisdn;
		this.messageEN = messageEN;
		this.messageVN = messageVN;
		this.status = status;
	}

	/**
	 * @return the msgId
	 */
	public int getMsgId() {
		return msgId;
	}

	/**
	 * @param msgId the msgId to set
	 */
	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}

	/**
	 * @return the msisdn
	 */
	public String getMsisdn() {
		return msisdn;
	}

	/**
	 * @param msisdn the msisdn to set
	 */
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	/**
	 * @return the messageEN
	 */
	public String getMessageEN() {
		return messageEN;
	}

	/**
	 * @param messageEN the messageEN to set
	 */
	public void setMessageEN(String messageEN) {
		this.messageEN = messageEN;
	}

	/**
	 * @return the messageVN
	 */
	public String getMessageVN() {
		return messageVN;
	}

	/**
	 * @param messageVN the messageVN to set
	 */
	public void setMessageVN(String messageVN) {
		this.messageVN = messageVN;
	}

	/**
	 * @return the status
	 */
	public NotificationStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(NotificationStatus status) {
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + msgId;
		result = prime * result + ((msisdn == null) ? 0 : msisdn.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransactionNotification other = (TransactionNotification) obj;
		if (msgId != other.msgId)
			return false;
		if (msisdn == null) {
			if (other.msisdn != null)
				return false;
		} else if (!msisdn.equals(other.msisdn))
			return false;
		return true;
	}
	
	

}
