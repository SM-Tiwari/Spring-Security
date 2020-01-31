package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;
import java.util.Date;

public class OtpStatusModel  implements Serializable {

	private String msisdn;
	private String timeStamp;
	private String status;
	private int count;
	private int failCount;
	
	public OtpStatusModel() {
		 
	}
	public OtpStatusModel(String msisdn, String timeStamp, String status) {
		super();
		this.msisdn = msisdn;
		this.timeStamp = timeStamp;
		this.status = status;
	}
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	 
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getFailCount() {
		return failCount;
	}
	public void setFailCount(int failCount) {
		this.failCount = failCount;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((msisdn == null) ? 0 : msisdn.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((timeStamp == null) ? 0 : timeStamp.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OtpStatusModel other = (OtpStatusModel) obj;
		if (msisdn == null) {
			if (other.msisdn != null)
				return false;
		} else if (!msisdn.equals(other.msisdn))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (timeStamp == null) {
			if (other.timeStamp != null)
				return false;
		} else if (!timeStamp.equals(other.timeStamp))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ScratchStatusModel [msisdn=" + msisdn + ", timeStamp=" + timeStamp + ", status=" + status + "]";
	}
	

	
}
