/**
 * InitialResponse.java
 */
package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;

/**
 * @author nandipinto
 *
 */
public class InitialResponse implements Serializable {

	private static final long serialVersionUID = -7039154781010021453L;

	private String transactionId;
	private String orderId;
	private String responseTime;
	private String resultCode;
	private String responseMsg;
	private String CommandStatus;
	private String redirectionURL;

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
	 * @return the responseTime
	 */
	public String getResponseTime() {
		return responseTime;
	}
	/**
	 * @param responseTime the responseTime to set
	 */
	public void setResponseTime(String responseTime) {
		this.responseTime = responseTime;
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
	 * @return the commandStatus
	 */
	public String getCommandStatus() {
		return CommandStatus;
	}
	/**
	 * @param commandStatus the commandStatus to set
	 */
	public void setCommandStatus(String commandStatus) {
		CommandStatus = commandStatus;
	}
	/**
	 * @return the redirectionURL
	 */
	public String getRedirectionURL() {
		return redirectionURL;
	}
	/**
	 * @param redirectionURL the redirectionURL to set
	 */
	public void setRedirectionURL(String redirectionURL) {
		this.redirectionURL = redirectionURL;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((resultCode == null) ? 0 : resultCode.hashCode());
		result = prime * result + ((transactionId == null) ? 0 : transactionId.hashCode());
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
		InitialResponse other = (InitialResponse) obj;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (resultCode == null) {
			if (other.resultCode != null)
				return false;
		} else if (!resultCode.equals(other.resultCode))
			return false;
		if (transactionId == null) {
			if (other.transactionId != null)
				return false;
		} else if (!transactionId.equals(other.transactionId))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InitialResponse [transactionId=");
		builder.append(transactionId);
		builder.append(", orderId=");
		builder.append(orderId);
		builder.append(", responseTime=");
		builder.append(responseTime);
		builder.append(", resultCode=");
		builder.append(resultCode);
		builder.append(", responseMsg=");
		builder.append(responseMsg);
		builder.append(", CommandStatus=");
		builder.append(CommandStatus);
		builder.append(", redirectionURL=");
		builder.append(redirectionURL);
		builder.append("]");
		return builder.toString();
	}
	
	
}
