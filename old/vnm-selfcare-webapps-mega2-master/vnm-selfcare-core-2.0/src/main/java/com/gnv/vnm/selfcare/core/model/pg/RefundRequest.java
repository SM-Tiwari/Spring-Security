/**
 * 
 */
package com.gnv.vnm.selfcare.core.model.pg;

import java.io.Serializable;

/**
 * @author nandipinto
 *
 */
public class RefundRequest implements Serializable {

	private static final long serialVersionUID = -5236907161071535243L;

	private String orderId;
	private String languageId;
	private String channel;
	private String mid;
	private int amount;
	private String requestTime;
	private String referenceId;
	private String userName;
	private String passWord;
	
	public RefundRequest() { }
	
	public RefundRequest(String orderId, String languageId, String channel, String mid, int amount, String requestTime,
			String referenceId, String userName, String passWord) {
		this.orderId = orderId;
		this.languageId = languageId;
		this.channel = channel;
		this.mid = mid;
		this.amount = amount;
		this.requestTime = requestTime;
		this.referenceId = referenceId;
		this.userName = userName;
		this.passWord = passWord;
	}

	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the languageId
	 */
	public String getLanguageId() {
		return languageId;
	}
	/**
	 * @param languageId the languageId to set
	 */
	public void setLanguageId(String languageId) {
		this.languageId = languageId;
	}
	/**
	 * @return the channel
	 */
	public String getChannel() {
		return channel;
	}
	/**
	 * @param channel the channel to set
	 */
	public void setChannel(String channel) {
		this.channel = channel;
	}
	/**
	 * @return the mid
	 */
	public String getMid() {
		return mid;
	}
	/**
	 * @param mid the mid to set
	 */
	public void setMid(String mid) {
		this.mid = mid;
	}
	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	/**
	 * @return the requestTime
	 */
	public String getRequestTime() {
		return requestTime;
	}
	/**
	 * @param requestTime the requestTime to set
	 */
	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}
	/**
	 * @return the referenceId
	 */
	public String getReferenceId() {
		return referenceId;
	}
	/**
	 * @param referenceId the referenceId to set
	 */
	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the passWord
	 */
	public String getPassWord() {
		return passWord;
	}
	/**
	 * @param passWord the passWord to set
	 */
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RefundRequest [orderId=");
		builder.append(orderId);
		builder.append(", languageId=");
		builder.append(languageId);
		builder.append(", channel=");
		builder.append(channel);
		builder.append(", mid=");
		builder.append(mid);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", requestTime=");
		builder.append(requestTime);
		builder.append(", referenceId=");
		builder.append(referenceId);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", passWord=");
		builder.append(passWord);
		builder.append("]");
		return builder.toString();
	}
	
}
