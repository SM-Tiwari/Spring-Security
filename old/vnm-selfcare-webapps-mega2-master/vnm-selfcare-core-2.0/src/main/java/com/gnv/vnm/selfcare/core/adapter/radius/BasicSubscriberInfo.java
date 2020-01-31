/**
 * BasicSubscriberInfo.java
 */
package com.gnv.vnm.selfcare.core.adapter.radius;

import java.io.Serializable;
import java.util.Comparator;

/**
 * @author nandipinto
 *
 */
public class BasicSubscriberInfo implements Serializable {

	private static final long serialVersionUID = -7934976757223360744L;

	private String msisdn;
	private String imsi;
	private String currentIpAddress;
	private long sessionStartTime;
	
	public BasicSubscriberInfo(String msisdn, String imsi) {
		this.msisdn = msisdn;
		this.imsi = imsi;
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
	 * @return the imsi
	 */
	public String getImsi() {
		return imsi;
	}

	/**
	 * @param imsi the imsi to set
	 */
	public void setImsi(String imsi) {
		this.imsi = imsi;
	}
	
	/**
	 * @return the currentIpAddress
	 */
	public String getCurrentIpAddress() {
		return currentIpAddress;
	}

	/**
	 * @param currentIpAddress the currentIpAddress to set
	 */
	public void setCurrentIpAddress(String ipAddress) {
		this.currentIpAddress = ipAddress;
	}

	/**
	 * @return the sessionStartTime
	 */
	public long getSessionStartTime() {
		return sessionStartTime;
	}

	/**
	 * @param sessionStartTime the sessionStartTime to set
	 */
	public void setSessionStartTime(long sessionStartTime) {
		this.sessionStartTime = sessionStartTime;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imsi == null) ? 0 : imsi.hashCode());
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
		BasicSubscriberInfo other = (BasicSubscriberInfo) obj;
		if (imsi == null) {
			if (other.imsi != null)
				return false;
		} else if (!imsi.equals(other.imsi))
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
		builder.append("BasicSubscriberInfo [msisdn=");
		builder.append(msisdn);
		builder.append(", imsi=");
		builder.append(imsi);
		builder.append(", currentIpAddress=");
		builder.append(currentIpAddress);
		builder.append(", sessionStartTime=");
		builder.append(sessionStartTime);
		builder.append("]");
		return builder.toString();
	}
	
	public static class SessionStartTimeComparator implements Comparator<BasicSubscriberInfo>{

		@Override
		public int compare(BasicSubscriberInfo o1, BasicSubscriberInfo o2) {
			return o2.getSessionStartTime() > o1.getSessionStartTime() ? 1 : -1;
		}
		
	}
}
