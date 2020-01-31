/**
 * RechargeResponse.java
 */
package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;

/**
 * @author nandipinto
 *
 */
public class RechargeResponse implements Serializable {

	private static final long serialVersionUID = -6524313951537992529L;

	private String code = "";
	private String message = "";
	private int balance = 0;
	private int rechargeValue = 0;
	
	public RechargeResponse(){ }
	
	public RechargeResponse(String code, String message, int balance) {
		this.code = code;
		this.message = message;
		this.balance = balance;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the balance
	 */
	public int getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	/**
	 * @return the rechargeValue
	 */
	public int getRechargeValue() {
		return rechargeValue;
	}

	/**
	 * @param rechargeValue the rechargeValue to set
	 */
	public void setRechargeValue(int rechargeValue) {
		this.rechargeValue = rechargeValue;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((code == null) ? 0 : code.hashCode());
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
		RechargeResponse other = (RechargeResponse) obj;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RechargeResponse [code=");
		builder.append(code);
		builder.append(", message=");
		builder.append(message);
		builder.append(", balance=");
		builder.append(balance);
		builder.append(", rechargeValue=");
		builder.append(rechargeValue);
		builder.append("]");
		return builder.toString();
	}
	
	
}
