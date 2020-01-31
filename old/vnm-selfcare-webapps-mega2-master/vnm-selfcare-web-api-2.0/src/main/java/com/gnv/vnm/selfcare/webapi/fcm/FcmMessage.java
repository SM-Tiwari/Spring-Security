/**
 * Apr 15, 2018 3:12:47 PM
 */
package com.gnv.vnm.selfcare.webapi.fcm;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author nandipinto
 *
 */
public class FcmMessage implements Serializable {

	private static final long serialVersionUID = -5800738331504538798L;

	@JsonIgnore
	private int messageId;
	@JsonIgnore
	private String msisdn;
	private String to;
	private FcmNotification notification;
	
	public FcmMessage() { }

	public FcmMessage(FcmNotification notification, String to) {
		this.notification = notification;
		this.to = to;
	}

	public FcmMessage(int messageId, FcmNotification notification, String to) {
		this(notification, to);
		this.messageId = messageId;
	}

	/**
	 * @return the messageId
	 */
	public int getMessageId() {
		return messageId;
	}

	/**
	 * @param messageId the messageId to set
	 */
	public void setMessageId(int messageId) {
		this.messageId = messageId;
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
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * @return the notification
	 */
	public FcmNotification getNotification() {
		return notification;
	}

	/**
	 * @param notification the notification to set
	 */
	public void setNotification(FcmNotification notification) {
		this.notification = notification;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + messageId;
		result = prime * result + ((to == null) ? 0 : to.hashCode());
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
		FcmMessage other = (FcmMessage) obj;
		if (messageId != other.messageId)
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FcmMessage [messageId=");
		builder.append(messageId);
		builder.append(", msisdn=");
		builder.append(msisdn);
		builder.append(", to=");
		builder.append(to);
		builder.append(", notification=");
		builder.append(notification);
		builder.append("]");
		return builder.toString();
	}
	
}
