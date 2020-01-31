/**
 * VASManProvisioningRequest.java
 */
package com.gnv.vnm.selfcare.core.adapter.vasman;

import java.util.Date;

import com.gnv.vnm.selfcare.core.adapter.BackEndAdapterRequest;
import com.gnv.vnm.selfcare.core.enums.RequestType;

/**
 * @author nandipinto
 *
 */
public class VASManProvisioningRequest extends BackEndAdapterRequest {

	private static final long serialVersionUID = -2664129809096413907L;
	
	private String msisdn;
	private String packageId;
	private int commandId;
	
	public VASManProvisioningRequest(){ }
	
	public VASManProvisioningRequest(String msisdn, String packageId, int commandId) {
		this.msisdn = msisdn;
		this.packageId = packageId;
		this.commandId = commandId;
	}

	public VASManProvisioningRequest(String requestId, RequestType requestType, Date timeStamp, String subscriberId, String packageId) {
		super(requestId, requestType, timeStamp);
		
		if (requestType.equals(RequestType.CREATE)){
			commandId = VASManAdapter.ACTIVATE_CMD;
			
		}else if (requestType.equals(RequestType.DELETE)){
			commandId = VASManAdapter.DEACTIVATE_CMD;
		}
		this.msisdn = subscriberId;
		this.packageId = packageId;
	}

	public VASManProvisioningRequest(String requestId, RequestType requestType, Date timeStamp, String subscriberId, String packageId, int commandId) {
		super(requestId, requestType, timeStamp);
		this.msisdn = subscriberId;
		this.packageId = packageId;
		this.commandId = commandId;
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
	public void setMsisdn(String subscriberId) {
		this.msisdn = subscriberId;
	}

	/**
	 * @return the packageId
	 */
	public String getPackageId() {
		return packageId;
	}

	/**
	 * @param packageId the packageId to set
	 */
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	/**
	 * @return the commandId
	 */
	public int getCommandId() {
		return commandId;
	}

	/**
	 * @param commandId the commandId to set
	 */
	public void setCommandId(int commandId) {
		this.commandId = commandId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + commandId;
		result = prime * result + ((packageId == null) ? 0 : packageId.hashCode());
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
		VASManProvisioningRequest other = (VASManProvisioningRequest) obj;
		if (commandId != other.commandId)
			return false;
		if (packageId == null) {
			if (other.packageId != null)
				return false;
		} else if (!packageId.equals(other.packageId))
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
		builder.append("VASManProvisioningRequest [msisdn=");
		builder.append(msisdn);
		builder.append(", packageId=");
		builder.append(packageId);
		builder.append(", commandId=");
		builder.append(commandId);
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
