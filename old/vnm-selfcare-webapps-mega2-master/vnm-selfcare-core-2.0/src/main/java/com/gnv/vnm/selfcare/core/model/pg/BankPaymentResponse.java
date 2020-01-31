/**
 * BankPaymentResponse.java
 */
package com.gnv.vnm.selfcare.core.model.pg;

import java.io.Serializable;

/**
 * @author nandipinto
 *
 */
public class BankPaymentResponse implements Serializable {

	private static final long serialVersionUID = 2292275801469503973L;
	
	private String orderId;
	private String resultCode;
	private String responseMsg;
	private String transactionId;
	
	public BankPaymentResponse(){ }

	public BankPaymentResponse(String orderId, String resultCode, String responseMsg, String transactionId) {
		this.orderId = orderId;
		this.resultCode = resultCode;
		this.responseMsg = responseMsg;
		this.transactionId = transactionId;
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
	 * @return the resultCode
	 */
	public String getResultCode() {
		return resultCode;
	}
	/**
	 * @param resultCode the resultCode to set
	 */
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	/**
	 * @return the responseMsg
	 */
	public String getResponseMsg() {
		return responseMsg;
	}
	/**
	 * @param responseMsg the responseMsg to set
	 */
	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}
	/**
	 * @return the transactionId
	 */
	public String getTransactionId() {
		return transactionId;
	}
	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BankPaymentResponse [orderId=");
		builder.append(orderId);
		builder.append(", resultCode=");
		builder.append(resultCode);
		builder.append(", responseMsg=");
		builder.append(responseMsg);
		builder.append(", transactionId=");
		builder.append(transactionId);
		builder.append("]");
		return builder.toString();
	}
	
	
}
