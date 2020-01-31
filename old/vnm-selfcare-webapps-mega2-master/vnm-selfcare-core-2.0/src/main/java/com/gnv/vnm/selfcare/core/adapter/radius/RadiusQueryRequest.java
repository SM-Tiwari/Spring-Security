/**
 * RadiusQueryRequest.java
 */
package com.gnv.vnm.selfcare.core.adapter.radius;

import java.util.Date;

import com.gnv.vnm.selfcare.core.adapter.BackEndAdapterRequest;
import com.gnv.vnm.selfcare.core.enums.RequestType;

/**
 * @author nandipinto
 *
 */
public class RadiusQueryRequest extends BackEndAdapterRequest {

	private static final long serialVersionUID = -7401200778871894039L;

	private String ipAddress;
	private String msisdn;
	
	public RadiusQueryRequest() {}

	/**
	 * @param requestId
	 * @param requestType
	 * @param timeStamp
	 */
	public RadiusQueryRequest(String requestId, RequestType requestType, Date timeStamp) {
		super(requestId, requestType, timeStamp);
	}

	/**
	 * @return the ipAddress
	 */
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * @param ipAddress the ipAddress to set
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
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
		result = prime * result + ((ipAddress == null) ? 0 : ipAddress.hashCode());
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
		RadiusQueryRequest other = (RadiusQueryRequest) obj;
		if (ipAddress == null) {
			if (other.ipAddress != null)
				return false;
		} else if (!ipAddress.equals(other.ipAddress))
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
		builder.append("RadiusQueryRequest [ipAddress=");
		builder.append(ipAddress);
		builder.append(", msisdn=");
		builder.append(msisdn);
		builder.append(", requestId=");
		builder.append(requestId);
		builder.append(", requestType=");
		builder.append(requestType);
		builder.append(", timeStamp=");
		builder.append(timeStamp);
		builder.append("]");
		return builder.toString();
	}
	
}
