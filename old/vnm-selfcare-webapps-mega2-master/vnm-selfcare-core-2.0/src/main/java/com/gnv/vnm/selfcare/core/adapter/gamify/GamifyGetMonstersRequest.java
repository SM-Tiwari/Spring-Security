/**
 * GamifyGetMonstersRequest.java
 */
package com.gnv.vnm.selfcare.core.adapter.gamify;

import com.gnv.vnm.selfcare.core.adapter.BackEndAdapterRequest;
import com.gnv.vnm.selfcare.core.enums.RequestType;

/**
 * @author nandipinto
 *
 */
public class GamifyGetMonstersRequest extends BackEndAdapterRequest {

	private static final long serialVersionUID = -251511177728453654L;

	private String langCode;
	private String msisdn;
	
	public GamifyGetMonstersRequest(){
		this.requestType = RequestType.QUERY;
	}

	public GamifyGetMonstersRequest(String langCode, String msisdn) {
		this.requestType = RequestType.QUERY;
		this.langCode = langCode;
		this.msisdn = msisdn;
	}

	/**
	 * @return the langCode
	 */
	public String getLangCode() {
		return langCode;
	}

	/**
	 * @param langCode the langCode to set
	 */
	public void setLangCode(String langCode) {
		this.langCode = langCode;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
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
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		GamifyGetMonstersRequest other = (GamifyGetMonstersRequest) obj;
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
		builder.append("GamifyGetMonstersRequest [langCode=");
		builder.append(langCode);
		builder.append(", msisdn=");
		builder.append(msisdn);
		builder.append("]");
		return builder.toString();
	}
	
}
