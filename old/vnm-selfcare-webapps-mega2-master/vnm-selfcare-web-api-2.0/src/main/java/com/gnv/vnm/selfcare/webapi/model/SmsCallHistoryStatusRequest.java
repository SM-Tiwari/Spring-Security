package com.gnv.vnm.selfcare.webapi.model;

import java.io.Serializable;

public class SmsCallHistoryStatusRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String msisdn;
	private String credential;
	private String smsCallHistoryStatus;
	
	
	
	public SmsCallHistoryStatusRequest() {
		super();
	}



	public SmsCallHistoryStatusRequest(String msisdn, String credential, String smsCallHistoryStatus) {
		super();
		this.msisdn = msisdn;
		this.credential = credential;
		this.smsCallHistoryStatus = smsCallHistoryStatus;
	}


	public String getMsisdn() {
		return msisdn;
	}



	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}



	public String getCredential() {
		return credential;
	}



	public void setCredential(String credential) {
		this.credential = credential;
	}



	public String getSmsCallHistoryStatus() {
		return smsCallHistoryStatus;
	}



	public void setSmsCallHistoryStatus(String smsCallHistoryStatus) {
		this.smsCallHistoryStatus = smsCallHistoryStatus;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((credential == null) ? 0 : credential.hashCode());
		result = prime * result + ((msisdn == null) ? 0 : msisdn.hashCode());
		result = prime * result + ((smsCallHistoryStatus == null) ? 0 : smsCallHistoryStatus.hashCode());
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
		SmsCallHistoryStatusRequest other = (SmsCallHistoryStatusRequest) obj;
		if (credential == null) {
			if (other.credential != null)
				return false;
		} else if (!credential.equals(other.credential))
			return false;
		if (msisdn == null) {
			if (other.msisdn != null)
				return false;
		} else if (!msisdn.equals(other.msisdn))
			return false;
		if (smsCallHistoryStatus == null) {
			if (other.smsCallHistoryStatus != null)
				return false;
		} else if (!smsCallHistoryStatus.equals(other.smsCallHistoryStatus))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "SmsCallHistoryStatusRequest [msisdn=" + msisdn + ", credential=" + credential
				+ ", smsCallHistoryStatus=" + smsCallHistoryStatus + "]";
	}
	

}
