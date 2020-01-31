/**
 * UPCCSubscriberAccount.java
 */
package com.gnv.vnm.selfcare.core.adapter.upcc;

import java.io.Serializable;

/**
 * @author nandipinto
 *
 */
public class UPCCSubscriberAccount implements Serializable {

	private static final long serialVersionUID = 1340470014206163068L;
	
	private String name;
	private String value;
	private String balance;
	private String privilege;
	private String expiryDate;
	private String status;
	private String personalizedValue;
	private String consumption;
	
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
	/**
	 * @return the balance
	 */
	public String getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(String balance) {
		this.balance = balance;
	}
	/**
	 * @return the privilege
	 */
	public String getPrivilege() {
		return privilege;
	}
	/**
	 * @param privilege the privilege to set
	 */
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
	/**
	 * @return the expiryDate
	 */
	public String getExpiryDate() {
		return expiryDate;
	}
	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the personalizedValue
	 */
	public String getPersonalizedValue() {
		return personalizedValue;
	}
	/**
	 * @param personalizedValue the personalizedValue to set
	 */
	public void setPersonalizedValue(String personalizedValue) {
		this.personalizedValue = personalizedValue;
	}
	/**
	 * @return the consumption
	 */
	public String getConsumption() {
		return consumption;
	}
	/**
	 * @param consumption the consumption to set
	 */
	public void setConsumption(String consumption) {
		this.consumption = consumption;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		UPCCSubscriberAccount other = (UPCCSubscriberAccount) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UPCCSubscriberAccount [name=");
		builder.append(name);
		builder.append(", value=");
		builder.append(value);
		builder.append(", balance=");
		builder.append(balance);
		builder.append(", privilege=");
		builder.append(privilege);
		builder.append(", expiryDate=");
		builder.append(expiryDate);
		builder.append(", status=");
		builder.append(status);
		builder.append(", personalizedValue=");
		builder.append(personalizedValue);
		builder.append(", consumption=");
		builder.append(consumption);
		builder.append("]");
		return builder.toString();
	}

}
