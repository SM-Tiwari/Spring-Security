/**
 * Apr 15, 2018 9:19:12 PM
 */
package com.gnv.vnm.selfcare.webapi.model;

import java.io.Serializable;

/**
 * @author nandipinto
 *
 */
public class UpdateUserTokenRequest implements Serializable {

	private static final long serialVersionUID = 1980298296916589204L;
	
	private String msisdn;
	private String token;
	private String osType;
	
	public UpdateUserTokenRequest() {
		
	}

	public UpdateUserTokenRequest(String msisdn, String token, String osType) {
		this.msisdn = msisdn;
		this.token = token;
		this.osType = osType;
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
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the osType
	 */
	public String getOsType() {
		return osType;
	}

	/**
	 * @param osType the osType to set
	 */
	public void setOsType(String osType) {
		this.osType = osType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((msisdn == null) ? 0 : msisdn.hashCode());
		result = prime * result + ((token == null) ? 0 : token.hashCode());
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
		UpdateUserTokenRequest other = (UpdateUserTokenRequest) obj;
		if (msisdn == null) {
			if (other.msisdn != null)
				return false;
		} else if (!msisdn.equals(other.msisdn))
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UpdateUserTokenRequest [msisdn=");
		builder.append(msisdn);
		builder.append(", token=");
		builder.append(token);
		builder.append(", osType=");
		builder.append(osType);
		builder.append("]");
		return builder.toString();
	}

}
