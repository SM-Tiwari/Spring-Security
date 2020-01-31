/**
 * GamifyResponse.java
 */
package com.gnv.vnm.selfcare.core.adapter.gamify;

import java.io.Serializable;

/**
 * @author nandipinto
 *
 */
public class GamifyResponse implements Serializable {

	private static final long serialVersionUID = -2627924437250769470L;

	private String code;
	private String sys_message;
	private String message;
	
	public GamifyResponse(){}

	public GamifyResponse(String code, String sys_message, String message) {
		this.code = code;
		this.sys_message = sys_message;
		this.message = message;
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
	 * @return the sys_message
	 */
	public String getSys_message() {
		return sys_message;
	}

	/**
	 * @param sys_message the sys_message to set
	 */
	public void setSys_message(String sys_message) {
		this.sys_message = sys_message;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		GamifyResponse other = (GamifyResponse) obj;
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
		builder.append("GamifyResponse [code=");
		builder.append(code);
		builder.append(", sys_message=");
		builder.append(sys_message);
		builder.append(", message=");
		builder.append(message);
		builder.append("]");
		return builder.toString();
	}
	
}
