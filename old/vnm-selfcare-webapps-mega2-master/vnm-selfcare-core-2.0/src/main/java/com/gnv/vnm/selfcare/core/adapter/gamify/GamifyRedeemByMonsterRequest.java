/**
 * GamifyRedeemByMonsterRequest.java
 */
package com.gnv.vnm.selfcare.core.adapter.gamify;

import java.util.Arrays;

import com.gnv.vnm.selfcare.core.adapter.BackEndAdapterRequest;
import com.gnv.vnm.selfcare.core.enums.RequestType;

/**
 * @author nandipinto
 *
 */
public class GamifyRedeemByMonsterRequest extends BackEndAdapterRequest {

	private static final long serialVersionUID = -7250860109655244044L;

	private String langCode;
	private String msisdn;
	private GamifyRedeemMonster[] monsters;
	private String trxId;
	
	public GamifyRedeemByMonsterRequest(){
		this.requestType = RequestType.UPDATE;
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

	/**
	 * @return the monsters
	 */
	public GamifyRedeemMonster[] getMonsters() {
		return monsters;
	}

	/**
	 * @param monsters the monsters to set
	 */
	public void setMonsters(GamifyRedeemMonster[] monsters) {
		this.monsters = monsters;
	}

	/**
	 * @return the trxId
	 */
	public String getTrxId() {
		return trxId;
	}

	/**
	 * @param trxId the trxId to set
	 */
	public void setTrxId(String trxId) {
		this.trxId = trxId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((msisdn == null) ? 0 : msisdn.hashCode());
		result = prime * result + ((trxId == null) ? 0 : trxId.hashCode());
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
		GamifyRedeemByMonsterRequest other = (GamifyRedeemByMonsterRequest) obj;
		if (msisdn == null) {
			if (other.msisdn != null)
				return false;
		} else if (!msisdn.equals(other.msisdn))
			return false;
		if (trxId == null) {
			if (other.trxId != null)
				return false;
		} else if (!trxId.equals(other.trxId))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GamifyRedeemByMonsterRequest [langCode=");
		builder.append(langCode);
		builder.append(", msisdn=");
		builder.append(msisdn);
		builder.append(", monsters=");
		builder.append(Arrays.toString(monsters));
		builder.append(", trxId=");
		builder.append(trxId);
		builder.append("]");
		return builder.toString();
	}

	
	
}
