package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;
import java.util.Date;

public class ScratchBlockModel  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msisdn;
	private String timeStamp;
	private String status;
	private String count;
	
	/*
	 * {
	"msisdn":"01888044003",
	"timeStamp":"323326541",
	"status":"Scratch voucher invalid",
	"count":"5"
	}
	 */
	public ScratchBlockModel() {
		 
	}

	public ScratchBlockModel(String msisdn, String timeStamp, String status, String count) {
		super();
		this.msisdn = msisdn;
		this.timeStamp = timeStamp;
		this.status = status;
		this.count = count;
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

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((count == null) ? 0 : count.hashCode());
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
		ScratchBlockModel other = (ScratchBlockModel) obj;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
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
		return "ScratchBlockModel [msisdn=" + msisdn + ", timeStamp=" + timeStamp + ", status=" + status + ", count="
				+ count + "]";
	}
	 
	 
	
	
}
