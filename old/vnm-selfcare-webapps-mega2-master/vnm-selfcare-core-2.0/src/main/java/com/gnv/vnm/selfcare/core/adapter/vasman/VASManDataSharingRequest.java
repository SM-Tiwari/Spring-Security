/**
 * 
 */
package com.gnv.vnm.selfcare.core.adapter.vasman;

import java.util.ArrayList;
import java.util.List;

import com.gnv.vnm.selfcare.core.adapter.BackEndAdapterRequest;

/**
 * @author nandipinto
 *
 */
public class VASManDataSharingRequest extends BackEndAdapterRequest {

	private static final long serialVersionUID = -2371144127127319131L;

	private String msisdn;
	private String packageId;
	private int commandId;
	private List<String> members = new ArrayList<>();
	
	public VASManDataSharingRequest() {
		super();
	}

	public VASManDataSharingRequest(String msisdn, String packageId, int commandId) {
		this.msisdn = msisdn;
		this.packageId = packageId;
		this.commandId = commandId;
	}
	
	public VASManDataSharingRequest(String msisdn, String packageId, int commandId, List<String> members) {
		this(msisdn, packageId, commandId);
		this.members = members;
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

	/**
	 * @return the members
	 */
	public List<String> getMembers() {
		return members;
	}

	/**
	 * @param members the members to set
	 */
	public void setMembers(List<String> members) {
		this.members = members;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + commandId;
		result = prime * result + ((msisdn == null) ? 0 : msisdn.hashCode());
		result = prime * result + ((packageId == null) ? 0 : packageId.hashCode());
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
		VASManDataSharingRequest other = (VASManDataSharingRequest) obj;
		if (commandId != other.commandId)
			return false;
		if (msisdn == null) {
			if (other.msisdn != null)
				return false;
		} else if (!msisdn.equals(other.msisdn))
			return false;
		if (packageId == null) {
			if (other.packageId != null)
				return false;
		} else if (!packageId.equals(other.packageId))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VASManDataSharingRequest [msisdn=");
		builder.append(msisdn);
		builder.append(", packageId=");
		builder.append(packageId);
		builder.append(", commandId=");
		builder.append(commandId);
		builder.append(", members=");
		builder.append(members);
		builder.append("]");
		return builder.toString();
	}
	
}
