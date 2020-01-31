/**
 * UsageRecord.java
 */
package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author nandipinto
 *
 */
public class UsageRecord implements Serializable {

	private static final long serialVersionUID = -4607460698671691650L;

	private long callTime;
	private int smsSent;
	private double dataUsage;
	private double totalCredit;
	@JsonIgnore
	private Date startDate;
	private String startDateAsString;
	@JsonIgnore
	private Date endDate;
	private String endDateAsString;
	
	/**
	 * @return the callTime
	 */
	public long getCallTime() {
		return callTime;
	}
	/**
	 * @param callTime the callTime to set
	 */
	public void setCallTime(long callTime) {
		this.callTime = callTime;
	}
	/**
	 * @return the smsSent
	 */
	public int getSmsSent() {
		return smsSent;
	}
	/**
	 * @param smsSent the smsSent to set
	 */
	public void setSmsSent(int smsSent) {
		this.smsSent = smsSent;
	}
	/**
	 * @return the dataUsage
	 */
	public double getDataUsage() {
		return dataUsage;
	}
	/**
	 * @param dataUsage the dataUsage to set
	 */
	public void setDataUsage(double dataUsage) {
		this.dataUsage = dataUsage;
	}
	/**
	 * @return the totalCredit
	 */
	public double getTotalCredit() {
		return totalCredit;
	}
	/**
	 * @param totalCredit the totalCredit to set
	 */
	public void setTotalCredit(double totalCredit) {
		this.totalCredit = totalCredit;
	}
	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the startDateAsString
	 */
	public String getStartDateAsString() {
		return startDateAsString;
	}
	/**
	 * @param startDateAsString the startDateAsString to set
	 */
	public void setStartDateAsString(String startDateAsString) {
		this.startDateAsString = startDateAsString;
	}
	/**
	 * @return the endDateAsString
	 */
	public String getEndDateAsString() {
		return endDateAsString;
	}
	/**
	 * @param endDateAsString the endDateAsString to set
	 */
	public void setEndDateAsString(String endDateAsString) {
		this.endDateAsString = endDateAsString;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (callTime ^ (callTime >>> 32));
		long temp;
		temp = Double.doubleToLongBits(dataUsage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + smsSent;
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		temp = Double.doubleToLongBits(totalCredit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		UsageRecord other = (UsageRecord) obj;
		if (callTime != other.callTime)
			return false;
		if (Double.doubleToLongBits(dataUsage) != Double.doubleToLongBits(other.dataUsage))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (smsSent != other.smsSent)
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (Double.doubleToLongBits(totalCredit) != Double.doubleToLongBits(other.totalCredit))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UsageRecord [callTime=");
		builder.append(callTime);
		builder.append(", smsSent=");
		builder.append(smsSent);
		builder.append(", dataUsage=");
		builder.append(dataUsage);
		builder.append(", totalCredit=");
		builder.append(totalCredit);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append("]");
		return builder.toString();
	}

}
