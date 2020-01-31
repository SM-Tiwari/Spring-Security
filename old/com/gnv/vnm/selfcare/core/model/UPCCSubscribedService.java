package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;

public class UPCCSubscribedService implements Serializable {

	private static final long serialVersionUID = -6287546646927086355L;
	
	private String name;
	private String servicePackageName;
	private String usageState;
	private String subscribedDate;
	private String startDateTime;
	private String overDueDate;
	private String endDateTime;
	private String roamingType;
	private String subscriptionType;
	private String status;
	private String workDaysTimeSchedule;
	private String restDaysTimeSchedule;
	private String contactMethod;
	private String useFlag;
	private String extendedAttr;
	private String[] userDefinedPeriods;
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param nameEN the name to set
	 */
	public void setName(String serviceName) {
		this.name = serviceName;
	}
	/**
	 * @return the servicePackageName
	 */
	public String getServicePackageName() {
		return servicePackageName;
	}
	/**
	 * @param servicePackageName the servicePackageName to set
	 */
	public void setServicePackageName(String servicePackageName) {
		this.servicePackageName = servicePackageName;
	}
	/**
	 * @return the usageState
	 */
	public String getUsageState() {
		return usageState;
	}
	/**
	 * @param usageState the usageState to set
	 */
	public void setUsageState(String serviceUsageState) {
		this.usageState = serviceUsageState;
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
	public void setSubscribedDate(String serviceProvidedDate) {
		this.subscribedDate = serviceProvidedDate;
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
	public void setStartDateTime(String serviceStartDateTime) {
		this.startDateTime = serviceStartDateTime;
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
	public void setOverDueDate(String serviceDueDate) {
		this.overDueDate = serviceDueDate;
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
	public void setEndDateTime(String serviceEndDateTime) {
		this.endDateTime = serviceEndDateTime;
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
	public void setRoamingType(String serviceRoamingType) {
		this.roamingType = serviceRoamingType;
	}
	/**
	 * @return the subscriptionType
	 */
	public String getSubscriptionType() {
		return subscriptionType;
	}
	/**
	 * @param subscriptionType the subscriptionType to set
	 */
	public void setSubscriptionType(String serviceSubscriptionType) {
		this.subscriptionType = serviceSubscriptionType;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String serviceStatus) {
		this.status = serviceStatus;
	}
	/**
	 * @return the workDaysTimeSchedule
	 */
	public String getWorkDaysTimeSchedule() {
		return workDaysTimeSchedule;
	}
	/**
	 * @param workDaysTimeSchedule the workDaysTimeSchedule to set
	 */
	public void setWorkDaysTimeSchedule(String serviceWorkDaysTimeSchedule) {
		this.workDaysTimeSchedule = serviceWorkDaysTimeSchedule;
	}
	/**
	 * @return the restDaysTimeSchedule
	 */
	public String getRestDaysTimeSchedule() {
		return restDaysTimeSchedule;
	}
	/**
	 * @param restDaysTimeSchedule the restDaysTimeSchedule to set
	 */
	public void setRestDaysTimeSchedule(String serviceRestDaysTimeSchedule) {
		this.restDaysTimeSchedule = serviceRestDaysTimeSchedule;
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
	public void setContactMethod(String serviceContactMethod) {
		this.contactMethod = serviceContactMethod;
	}
	/**
	 * @return the useFlag
	 */
	public String getUseFlag() {
		return useFlag;
	}
	/**
	 * @param useFlag the useFlag to set
	 */
	public void setUseFlag(String serviceUseFlag) {
		this.useFlag = serviceUseFlag;
	}
	/**
	 * @return the extendedAttr
	 */
	public String getExtendedAttr() {
		return extendedAttr;
	}
	/**
	 * @param extendedAttr the extendedAttr to set
	 */
	public void setExtendedAttr(String serviceExtendedAttr) {
		this.extendedAttr = serviceExtendedAttr;
	}
	/**
	 * @return the userDefinedPeriods
	 */
	public String[] getUserDefinedPeriods() {
		return userDefinedPeriods;
	}
	/**
	 * @param userDefinedPeriods the userDefinedPeriods to set
	 */
	public void setUserDefinedPeriods(String[] serviceUserDefinedPeriods) {
		this.userDefinedPeriods = serviceUserDefinedPeriods;
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
		UPCCSubscribedService other = (UPCCSubscribedService) obj;
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
		builder.append("UPCCSubscribedService [name=");
		builder.append(name);
		builder.append(", servicePackageName=");
		builder.append(servicePackageName);
		builder.append(", usageState=");
		builder.append(usageState);
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
		builder.append(", subscriptionType=");
		builder.append(subscriptionType);
		builder.append(", status=");
		builder.append(status);
		builder.append(", workDaysTimeSchedule=");
		builder.append(workDaysTimeSchedule);
		builder.append(", restDaysTimeSchedule=");
		builder.append(restDaysTimeSchedule);
		builder.append(", contactMethod=");
		builder.append(contactMethod);
		builder.append(", useFlag=");
		builder.append(useFlag);
		builder.append(", extendedAttr=");
		builder.append(extendedAttr);
		builder.append("]");
		return builder.toString();
	}
	
	
}

