/**
 * 
 */
package com.gnv.vnm.selfcare.webapi.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author nandipinto
 *
 */
public class DataSharingRequest implements Serializable {

	private static final long serialVersionUID = 1133666239042737576L;
	
	private String msisdn;
	private String packageId;
	private ArrayList<String> members = new ArrayList<>();

	public DataSharingRequest() {}

	public DataSharingRequest(String msisdn, String packageId, ArrayList<String> members) {
		this.msisdn = msisdn;
		this.packageId = packageId;
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
	 * @return the members
	 */
	public ArrayList<String> getMembers() {
		return members;
	}

	/**
	 * @param members the members to set
	 */
	public void setMembers(ArrayList<String> members) {
		this.members = members;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DataSharingRequest [msisdn=");
		builder.append(msisdn);
		builder.append(", packageId=");
		builder.append(packageId);
		builder.append(", members=");
		builder.append(members);
		builder.append("]");
		return builder.toString();
	}
}
