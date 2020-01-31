/**
 * OTP.java
 */
package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;

import com.gnv.vnm.selfcare.core.enums.TokenStatus;

/**
 * @author nandipinto
 *
 */
public class OTP implements Serializable {

	private static final long serialVersionUID = 620903223118001692L;

	private int id;
	private String subscriberId;
	private String token;
	private long expirationTime;
	private TokenStatus status = TokenStatus.UNUSED;

	public OTP(){}

	/**
	 * @param id
	 * @param subscriberId
	 * @param token
	 * @param expirationTime
	 * @param status
	 */
	public OTP(int id, String subscriberId, String token, long expirationTime, TokenStatus status) {
		this.id = id;
		this.subscriberId = subscriberId;
		this.token = token;
		this.expirationTime = expirationTime;
		this.status = status;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the subscriberId
	 */
	public String getSubscriberId() {
		return subscriberId;
	}

	/**
	 * @param subscriberId the subscriberId to set
	 */
	public void setSubscriberId(String subscriberId) {
		this.subscriberId = subscriberId;
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
	 * @return the expirationTime
	 */
	public long getExpirationTime() {
		return expirationTime;
	}

	/**
	 * @param expirationTime the expirationTime to set
	 */
	public void setExpirationTime(long expirationTime) {
		this.expirationTime = expirationTime;
	}

	/**
	 * @return the status
	 */
	public TokenStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(TokenStatus status) {
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (expirationTime ^ (expirationTime >>> 32));
		result = prime * result + id;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((subscriberId == null) ? 0 : subscriberId.hashCode());
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
		OTP other = (OTP) obj;
		if (expirationTime != other.expirationTime)
			return false;
		if (id != other.id)
			return false;
		if (status != other.status)
			return false;
		if (subscriberId == null) {
			if (other.subscriberId != null)
				return false;
		} else if (!subscriberId.equals(other.subscriberId))
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
		builder.append("OTP [id=");
		builder.append(id);
		builder.append(", subscriberId=");
		builder.append(subscriberId);
		builder.append(", token=");
		builder.append(token);
		builder.append(", expirationTime=");
		builder.append(expirationTime);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}
	
}
