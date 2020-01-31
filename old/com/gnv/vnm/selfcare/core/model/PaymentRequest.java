package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;

public class PaymentRequest implements Serializable {

	private static final long serialVersionUID = 588780643616027697L;

//	"napasCallBackURL":" http://10.0.0.36:8080/merchant/status/callBackURL "
//		"napasCancelURL":" http://10.0.0.56/webapi/pg/cancelPayment?orderId=xxxxxxxxx"
			
	private String channel;
	private String orderId;
	private String requestTime;  //datetimeformat: DDMMYYYY HH24:MI:SS:SSS
	private String mobileNumber;
	private double amount;
	private String mid;
	private String languageId;
	private String callBackUrl;
	private String napasCallBackURL;
	private String napasCancelURL;
	private String orderInfo;
	private String ipAddress;
	private String checkSumHash;
	private String emailId;
	private String txnType;
	private String cardType;
	
	public PaymentRequest(){ }
	
	public PaymentRequest(String channel, String orderId, String requestTime, String mobileNumber, double amount,
			String mid, String languageId, String callBackUrl, String orderInfo, String ipAddress, String checkSumHash,
			String emailId, String trxType, String cardType) {
		this.channel = channel;
		this.orderId = orderId;
		this.requestTime = requestTime;
		this.mobileNumber = mobileNumber;
		this.amount = amount;
		this.mid = mid;
		this.languageId = languageId;
		this.callBackUrl = callBackUrl;
		this.orderInfo = orderInfo;
		this.ipAddress = ipAddress;
		this.checkSumHash = checkSumHash;
		this.emailId = emailId;
		this.txnType = trxType;
		this.cardType = cardType;
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
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}
	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
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
	 * @return the callBackUrl
	 */
	public String getCallBackUrl() {
		return callBackUrl;
	}
	/**
	 * @param callBackUrl the callBackUrl to set
	 */
	public void setCallBackUrl(String callBackUrl) {
		this.callBackUrl = callBackUrl;
	}
	
	/**
	 * @return the napasCallBackURL
	 */
	public String getNapasCallBackURL() {
		return napasCallBackURL;
	}

	/**
	 * @param napasCallBackURL the napasCallBackURL to set
	 */
	public void setNapasCallBackURL(String napasCallBackURL) {
		this.napasCallBackURL = napasCallBackURL;
	}

	/**
	 * @return the napasCancelURL
	 */
	public String getNapasCancelURL() {
		return napasCancelURL;
	}

	/**
	 * @param napasCancelURL the napasCancelURL to set
	 */
	public void setNapasCancelURL(String napasCancelURL) {
		this.napasCancelURL = napasCancelURL;
	}

	/**
	 * @return the orderInfo
	 */
	public String getOrderInfo() {
		return orderInfo;
	}
	/**
	 * @param orderInfo the orderInfo to set
	 */
	public void setOrderInfo(String orderInfo) {
		this.orderInfo = orderInfo;
	}
	/**
	 * @return the ipAddress
	 */
	public String getIpAddress() {
		return ipAddress;
	}
	/**
	 * @param ipAddress the ipAddress to set
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	/**
	 * @return the checkSumHash
	 */
	public String getCheckSumHash() {
		return checkSumHash;
	}
	/**
	 * @param checkSumHash the checkSumHash to set
	 */
	public void setCheckSumHash(String checkSumHash) {
		this.checkSumHash = checkSumHash;
	}
	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}
	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	/**
	 * @return the txnType
	 */
	public String getTxnType() {
		return txnType;
	}
	/**
	 * @param txnType the txnType to set
	 */
	public void setTxnType(String trxType) {
		this.txnType = trxType;
	}
	/**
	 * @return the cardType
	 */
	public String getCardType() {
		return cardType;
	}
	/**
	 * @param cardType the cardType to set
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mobileNumber == null) ? 0 : mobileNumber.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((requestTime == null) ? 0 : requestTime.hashCode());
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
		PaymentRequest other = (PaymentRequest) obj;
		if (mobileNumber == null) {
			if (other.mobileNumber != null)
				return false;
		} else if (!mobileNumber.equals(other.mobileNumber))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (requestTime == null) {
			if (other.requestTime != null)
				return false;
		} else if (!requestTime.equals(other.requestTime))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PaymentRequest [channel=");
		builder.append(channel);
		builder.append(", orderId=");
		builder.append(orderId);
		builder.append(", requestTime=");
		builder.append(requestTime);
		builder.append(", mobileNumber=");
		builder.append(mobileNumber);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", mid=");
		builder.append(mid);
		builder.append(", languageId=");
		builder.append(languageId);
		builder.append(", callBackUrl=");
		builder.append(callBackUrl);
		builder.append(", napasCallBackURL=");
		builder.append(napasCallBackURL);
		builder.append(", napasCancelURL=");
		builder.append(napasCancelURL);
		builder.append(", orderInfo=");
		builder.append(orderInfo);
		builder.append(", ipAddress=");
		builder.append(ipAddress);
		builder.append(", checkSumHash=");
		builder.append(checkSumHash);
		builder.append(", emailId=");
		builder.append(emailId);
		builder.append(", txnType=");
		builder.append(txnType);
		builder.append(", cardType=");
		builder.append(cardType);
		builder.append("]");
		return builder.toString();
	}
	
}
