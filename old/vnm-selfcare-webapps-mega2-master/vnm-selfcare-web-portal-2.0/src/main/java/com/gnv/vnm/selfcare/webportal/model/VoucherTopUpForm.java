/**
 * VoucherTopUpForm.java
 */
package com.gnv.vnm.selfcare.webportal.model;

import java.io.Serializable;

/**
 * @author nandipinto
 *
 */
public class VoucherTopUpForm implements Serializable {

	private static final long serialVersionUID = -2895700075527627396L;

	private String code;
	private String msisdn;
	private String captcha;
	
	public VoucherTopUpForm(){ }
	
	public VoucherTopUpForm(String code, String msisdn, String captcha) {
		this.code = code;
		this.msisdn = msisdn;
		this.captcha = captcha;
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
	 * @return the captcha
	 */
	public String getCaptcha() {
		return captcha;
	}

	/**
	 * @param captcha the captcha to set
	 */
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((captcha == null) ? 0 : captcha.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((msisdn == null) ? 0 : msisdn.hashCode());
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
		VoucherTopUpForm other = (VoucherTopUpForm) obj;
		if (captcha == null) {
			if (other.captcha != null)
				return false;
		} else if (!captcha.equals(other.captcha))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (msisdn == null) {
			if (other.msisdn != null)
				return false;
		} else if (!msisdn.equals(other.msisdn))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VoucherTopUpForm [code=");
		builder.append(code);
		builder.append(", msisdn=");
		builder.append(msisdn);
		builder.append(", captcha=");
		builder.append(captcha);
		builder.append("]");
		return builder.toString();
	}
	
}
