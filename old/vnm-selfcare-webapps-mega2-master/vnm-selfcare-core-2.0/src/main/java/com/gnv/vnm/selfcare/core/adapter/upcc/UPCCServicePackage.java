/**
 * UPCCServicePackage.java
 */
package com.gnv.vnm.selfcare.core.adapter.upcc;

import java.io.Serializable;

/**
 * @author nandipinto
 *
 */
public class UPCCServicePackage implements Serializable {

	private static final long serialVersionUID = 1979905382765331499L;

	private String name;
	private String subscribedDate;
	private String startDateTime;
	private String overDueDate;
	private String endDateTime;
	private String roamingType;
	private String contactMethod;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param nameEN the name to set
	 */
	public void setName(String servicePackageName) {
		this.name = servicePackageName;
	}
	/**
	 * @return the subscribedDate
	 */
	public String getSubscribedDate() {
		return subscribedDate;
	}
	/**
	 * @param subscribedDate the subscribedDate to set
	 */
	public void setSubscribedDate(String servicePackageProvidedDate) {
		this.subscribedDate = servicePackageProvidedDate;
	}
	/**
	 * @return the startDateTime
	 */
	public String getStartDateTime() {
		return startDateTime;
	}
	/**
	 * @param startDateTime the startDateTime to set
	 */
	public void setStartDateTime(String servicePackageStartDateTime) {
		this.startDateTime = servicePackageStartDateTime;
	}
	/**
	 * @return the overDueDate
	 */
	public String getOverDueDate() {
		return overDueDate;
	}
	/**
	 * @param overDueDate the overDueDate to set
	 */
	public void setOverDueDate(String servicePackageOverDueDate) {
		this.overDueDate = servicePackageOverDueDate;
	}
	/**
	 * @return the endDateTime
	 */
	public String getEndDateTime() {
		return endDateTime;
	}
	/**
	 * @param endDateTime the endDateTime to set
	 */
	public void setEndDateTime(String servicePackageEndDateTime) {
		this.endDateTime = servicePackageEndDateTime;
	}
	/**
	 * @return the roamingType
	 */
	public String getRoamingType() {
		return roamingType;
	}
	/**
	 * @param roamingType the roamingType to set
	 */
	public void setRoamingType(String servicePackageRoamingType) {
		this.roamingType = servicePackageRoamingType;
	}
	/**
	 * @return the contactMethod
	 */
	public String getContactMethod() {
		return contactMethod;
	}
	/**
	 * @param contactMethod the contactMethod to set
	 */
	public void setContactMethod(String servicePackageContactMethod) {
		this.contactMethod = servicePackageContactMethod;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		UPCCServicePackage other = (UPCCServicePackage) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UPCCServicePackage [name=");
		builder.append(name);
		builder.append(", subscribedDate=");
		builder.append(subscribedDate);
		builder.append(", startDateTime=");
		builder.append(startDateTime);
		builder.append(", overDueDate=");
		builder.append(overDueDate);
		builder.append(", endDateTime=");
		builder.append(endDateTime);
		builder.append(", roamingType=");
		builder.append(roamingType);
		builder.append(", contactMethod=");
		builder.append(contactMethod);
		builder.append("]");
		return builder.toString();
	}

	
}
