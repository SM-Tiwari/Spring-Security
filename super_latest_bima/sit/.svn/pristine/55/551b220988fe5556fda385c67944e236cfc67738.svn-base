/**
 * TopUpHistory.java
 */
package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import id.gnvsolution.d3.api.helper.enums.TransactionStatus;


/**
 * @author nandipinto
 *
 */
public class TopUpHistory implements Serializable {

	private static final long serialVersionUID = -5027352163052435955L;

	private String msisdn;
	private String voucherCode;
	private double amount;
	@JsonIgnore
	private Date timeStamp;
	private String timeStampAsString;
	private TransactionStatus status;
	private String typeNameEN;
	private String typeNameVN;
	@JsonIgnore
	private String refTrxId;
	
	public TopUpHistory(){}
	
	/**
	 * @param msisdn
	 * @param voucherCode
	 * @param amount
	 * @param timeStamp
	 * @param timeStampAsString
	 * @param status
	 */
	public TopUpHistory(String msisdn, String voucherCode, double amount, Date timeStamp, String timeStampAsString,
			TransactionStatus status) {
		this.msisdn = msisdn;
		this.voucherCode = voucherCode;
		this.amount = amount;
		this.timeStamp = timeStamp;
		this.timeStampAsString = timeStampAsString;
		this.status = status;
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
	 * @return the voucherCode
	 */
	public String getVoucherCode() {
		return voucherCode;
	}
	/**
	 * @param voucherCode the voucherCode to set
	 */
	public void setVoucherCode(String voucherCode) {
		this.voucherCode = voucherCode;
	}
	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	/**
	 * @return the timeStamp
	 */
	public Date getTimeStamp() {
		return timeStamp;
	}
	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	/**
	 * @return the timeStampAsString
	 */
	public String getTimeStampAsString() {
		return timeStampAsString;
	}
	/**
	 * @param timeStampAsString the timeStampAsString to set
	 */
	public void setTimeStampAsString(String timeStampAsString) {
		this.timeStampAsString = timeStampAsString;
	}
	/**
	 * @return the status
	 */
	public TransactionStatus getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(TransactionStatus status) {
		this.status = status;
	}

	/**
	 * @return the typeNameEN
	 */
	public String getTypeNameEN() {
		return typeNameEN;
	}

	/**
	 * @param typeNameEN the typeNameEN to set
	 */
	public void setTypeNameEN(String type) {
		this.typeNameEN = type;
	}

	/**
	 * @return the typeNameVN
	 */
	public String getTypeNameVN() {
		return typeNameVN;
	}

	/**
	 * @param typeNameVN the typeNameVN to set
	 */
	public void setTypeNameVN(String typeNameVN) {
		this.typeNameVN = typeNameVN;
	}

	/**
	 * @return the refTrxId
	 */
	public String getRefTrxId() {
		return refTrxId;
	}

	/**
	 * @param refTrxId the refTrxId to set
	 */
	public void setRefTrxId(String refTrxId) {
		this.refTrxId = refTrxId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((msisdn == null) ? 0 : msisdn.hashCode());
		result = prime * result + ((voucherCode == null) ? 0 : voucherCode.hashCode());
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
		TopUpHistory other = (TopUpHistory) obj;
		if (msisdn == null) {
			if (other.msisdn != null)
				return false;
		} else if (!msisdn.equals(other.msisdn))
			return false;
		if (voucherCode == null) {
			if (other.voucherCode != null)
				return false;
		} else if (!voucherCode.equals(other.voucherCode))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TopUpHistory [msisdn=");
		builder.append(msisdn);
		builder.append(", voucherCode=");
		builder.append(voucherCode);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", timeStamp=");
		builder.append(timeStamp);
		builder.append(", timeStampAsString=");
		builder.append(timeStampAsString);
		builder.append(", status=");
		builder.append(status);
		builder.append(", typeNameEN=");
		builder.append(typeNameEN);
		builder.append(", typeNameVN=");
		builder.append(typeNameVN);
		builder.append(", refTrxId=");
		builder.append(refTrxId);
		builder.append("]");
		return builder.toString();
	}
	
	public static class TopUpHistoryTimestampDescendingComparator implements Comparator<TopUpHistory>{

		@Override
		public int compare(TopUpHistory o1, TopUpHistory o2) {
			return o2.timeStamp.after(o1.timeStamp) ? 1 : -1;
		}
		
	}
	
	public static class TopUpHistoryTimestampAscendingComparator implements Comparator<TopUpHistory>{

		@Override
		public int compare(TopUpHistory o1, TopUpHistory o2) {
			return o1.timeStamp.after(o2.timeStamp) ? 1 : -1;
		}
		
	}
	
}
