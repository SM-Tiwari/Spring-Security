/**
 * Jan 25, 2018 5:05:45 PM
 */
package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;

import com.gnv.vnm.selfcare.core.enums.SubscriberType;

/**
 * @author nandipinto
 *
 */
public class BasicAccount implements Serializable {

	private static final long serialVersionUID = -8435360960939624805L;

	private String msisdn;
	private String cos;
	private String cosDisplayName;
	private SubscriberType type;
	
	public BasicAccount() {}

	public BasicAccount(String msisdn, String cos, SubscriberType type) {
		this.msisdn = msisdn;
		this.cosDisplayName = cos;
		this.type = type;
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
	 * @return the cos
	 */
	public String getCos() {
		return cos;
	}

	/**
	 * @param cos the cos to set
	 */
	public void setCos(String cos) {
		this.cos = cos;
	}

	/**
	 * @return the cosDisplayName
	 */
	public String getCosDisplayName() {
		return cosDisplayName;
	}

	/**
	 * @param cosDisplayName the cosDisplayName to set
	 */
	public void setCosDisplayName(String cosDisplayName) {
		this.cosDisplayName = cosDisplayName;
	}

	/**
	 * @return the type
	 */
	public SubscriberType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(SubscriberType type) {
		this.type = type;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cosDisplayName == null) ? 0 : cosDisplayName.hashCode());
		result = prime * result + ((msisdn == null) ? 0 : msisdn.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		BasicAccount other = (BasicAccount) obj;
		if (cosDisplayName == null) {
			if (other.cosDisplayName != null)
				return false;
		} else if (!cosDisplayName.equals(other.cosDisplayName))
			return false;
		if (msisdn == null) {
			if (other.msisdn != null)
				return false;
		} else if (!msisdn.equals(other.msisdn))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BasicAccount [msisdn=");
		builder.append(msisdn);
		builder.append(", cosDisplayName=");
		builder.append(cosDisplayName);
		builder.append(", type=");
		builder.append(type);
		builder.append("]");
		return builder.toString();
	}
	
	
}

