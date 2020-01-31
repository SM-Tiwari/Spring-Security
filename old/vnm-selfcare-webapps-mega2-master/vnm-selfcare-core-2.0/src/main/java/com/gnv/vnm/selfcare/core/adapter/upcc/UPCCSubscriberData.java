/**
 * UPCCSubscriberData.java
 */
package com.gnv.vnm.selfcare.core.adapter.upcc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author nandipinto
 *
 */
public class UPCCSubscriberData implements Serializable {

	private static final long serialVersionUID = 4524279037366612788L;

	private String id;
	private String secondaryId;
	private String msisdn;
	private String secondaryMsisdn;
	private String imsi;
	private String imei;
	private String state;
	private String homeServiceZone;
	private String paymentType; 
	private String category;
	private String station;
	private String masterId;
	private String contactMethod;
	private String emailAddress;
	private String cycleDate;
	private String subTerminalType;
	private String creationType;
	private String maxOfflineDays;
	private String lastOfflineTimestamp;
	private String subNetType;
	private String customAttribute;
	private String[] extendedAttributes;
	private String languageId;
	private String smsReceiveFlag;
	private String birthDate;
	private String groupId;
	
	private List<UPCCSubscribedService> subscribedServices = new ArrayList<>();
	private List<UPCCServicePackage> servicePackages = new ArrayList<>();
	private List<UPCCSubscriberQuota> quotas = new ArrayList<>();
	private List<UPCCSubscriberAccount> accounts = new ArrayList<>();
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the secondaryId
	 */
	public String getSecondaryId() {
		return secondaryId;
	}
	/**
	 * @param secondaryId the secondaryId to set
	 */
	public void setSecondaryId(String secondaryId) {
		this.secondaryId = secondaryId;
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
	 * @return the secondaryMsisdn
	 */
	public String getSecondaryMsisdn() {
		return secondaryMsisdn;
	}
	/**
	 * @param secondaryMsisdn the secondaryMsisdn to set
	 */
	public void setSecondaryMsisdn(String secondaryMsisdn) {
		this.secondaryMsisdn = secondaryMsisdn;
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
	 * @return the imei
	 */
	public String getImei() {
		return imei;
	}
	/**
	 * @param imei the imei to set
	 */
	public void setImei(String imei) {
		this.imei = imei;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the homeServiceZone
	 */
	public String getHomeServiceZone() {
		return homeServiceZone;
	}
	/**
	 * @param homeServiceZone the homeServiceZone to set
	 */
	public void setHomeServiceZone(String homeServiceZone) {
		this.homeServiceZone = homeServiceZone;
	}
	/**
	 * @return the paymentType
	 */
	public String getPaymentType() {
		return paymentType;
	}
	/**
	 * @param paymentType the paymentType to set
	 */
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return the station
	 */
	public String getStation() {
		return station;
	}
	/**
	 * @param station the station to set
	 */
	public void setStation(String station) {
		this.station = station;
	}
	/**
	 * @return the masterId
	 */
	public String getMasterId() {
		return masterId;
	}
	/**
	 * @param masterId the masterId to set
	 */
	public void setMasterId(String masterId) {
		this.masterId = masterId;
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
	public void setContactMethod(String contactMethod) {
		this.contactMethod = contactMethod;
	}
	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}
	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	/**
	 * @return the cycleDate
	 */
	public String getCycleDate() {
		return cycleDate;
	}
	/**
	 * @param cycleDate the cycleDate to set
	 */
	public void setCycleDate(String cycleDate) {
		this.cycleDate = cycleDate;
	}
	/**
	 * @return the subTerminalType
	 */
	public String getSubTerminalType() {
		return subTerminalType;
	}
	/**
	 * @param subTerminalType the subTerminalType to set
	 */
	public void setSubTerminalType(String subTerminalType) {
		this.subTerminalType = subTerminalType;
	}
	/**
	 * @return the creationType
	 */
	public String getCreationType() {
		return creationType;
	}
	/**
	 * @param creationType the creationType to set
	 */
	public void setCreationType(String creationType) {
		this.creationType = creationType;
	}
	/**
	 * @return the maxOfflineDays
	 */
	public String getMaxOfflineDays() {
		return maxOfflineDays;
	}
	/**
	 * @param maxOfflineDays the maxOfflineDays to set
	 */
	public void setMaxOfflineDays(String maxOfflineDays) {
		this.maxOfflineDays = maxOfflineDays;
	}
	/**
	 * @return the lastOfflineTimestamp
	 */
	public String getLastOfflineTimestamp() {
		return lastOfflineTimestamp;
	}
	/**
	 * @param lastOfflineTimestamp the lastOfflineTimestamp to set
	 */
	public void setLastOfflineTimestamp(String lastOfflineTimestamp) {
		this.lastOfflineTimestamp = lastOfflineTimestamp;
	}
	/**
	 * @return the subNetType
	 */
	public String getSubNetType() {
		return subNetType;
	}
	/**
	 * @param subNetType the subNetType to set
	 */
	public void setSubNetType(String subNetType) {
		this.subNetType = subNetType;
	}
	/**
	 * @return the customAttribute
	 */
	public String getCustomAttribute() {
		return customAttribute;
	}
	/**
	 * @param customAttribute the customAttribute to set
	 */
	public void setCustomAttribute(String customAttribute) {
		this.customAttribute = customAttribute;
	}
	/**
	 * @return the extendedAttributes
	 */
	public String[] getExtendedAttributes() {
		return extendedAttributes;
	}
	/**
	 * @param extendedAttributes the extendedAttributes to set
	 */
	public void setExtendedAttributes(String[] extendedAttributes) {
		this.extendedAttributes = extendedAttributes;
	}
	/**
	 * @return the languageId
	 */
	public String getLanguageId() {
		return languageId;
	}
	/**
	 * @param languageId the languageId to set
	 */
	public void setLanguageId(String languageId) {
		this.languageId = languageId;
	}
	/**
	 * @return the smsReceiveFlag
	 */
	public String getSmsReceiveFlag() {
		return smsReceiveFlag;
	}
	/**
	 * @param smsReceiveFlag the smsReceiveFlag to set
	 */
	public void setSmsReceiveFlag(String smsReceiveFlag) {
		this.smsReceiveFlag = smsReceiveFlag;
	}
	/**
	 * @return the birthDate
	 */
	public String getBirthDate() {
		return birthDate;
	}
	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	/**
	 * @return the groupId
	 */
	public String getGroupId() {
		return groupId;
	}
	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	/**
	 * @return the subscribedServices
	 */
	public List<UPCCSubscribedService> getSubscribedServices() {
		return subscribedServices;
	}
	/**
	 * @param subscribedServices the subscribedServices to set
	 */
	public void setSubscribedServices(List<UPCCSubscribedService> subscribedServices) {
		this.subscribedServices = subscribedServices;
	}
	/**
	 * @return the servicePackages
	 */
	public List<UPCCServicePackage> getServicePackages() {
		return servicePackages;
	}
	/**
	 * @param servicePackages the servicePackages to set
	 */
	public void setServicePackages(List<UPCCServicePackage> servicePackages) {
		this.servicePackages = servicePackages;
	}
	/**
	 * @return the quotas
	 */
	public List<UPCCSubscriberQuota> getQuotas() {
		return quotas;
	}
	/**
	 * @param quotas the quotas to set
	 */
	public void setQuotas(List<UPCCSubscriberQuota> quotas) {
		this.quotas = quotas;
	}
	/**
	 * @return the accounts
	 */
	public List<UPCCSubscriberAccount> getAccounts() {
		return accounts;
	}
	/**
	 * @param accounts the accounts to set
	 */
	public void setAccounts(List<UPCCSubscriberAccount> accounts) {
		this.accounts = accounts;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		UPCCSubscriberData other = (UPCCSubscriberData) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UPCCSubscriberData [id=");
		builder.append(id);
		builder.append(", secondaryId=");
		builder.append(secondaryId);
		builder.append(", msisdn=");
		builder.append(msisdn);
		builder.append(", secondaryMsisdn=");
		builder.append(secondaryMsisdn);
		builder.append(", imsi=");
		builder.append(imsi);
		builder.append(", imei=");
		builder.append(imei);
		builder.append(", state=");
		builder.append(state);
		builder.append(", homeServiceZone=");
		builder.append(homeServiceZone);
		builder.append(", paymentType=");
		builder.append(paymentType);
		builder.append(", category=");
		builder.append(category);
		builder.append(", station=");
		builder.append(station);
		builder.append(", masterId=");
		builder.append(masterId);
		builder.append(", contactMethod=");
		builder.append(contactMethod);
		builder.append(", emailAddress=");
		builder.append(emailAddress);
		builder.append(", cycleDate=");
		builder.append(cycleDate);
		builder.append(", subTerminalType=");
		builder.append(subTerminalType);
		builder.append(", creationType=");
		builder.append(creationType);
		builder.append(", maxOfflineDays=");
		builder.append(maxOfflineDays);
		builder.append(", lastOfflineTimestamp=");
		builder.append(lastOfflineTimestamp);
		builder.append(", subNetType=");
		builder.append(subNetType);
		builder.append(", customAttribute=");
		builder.append(customAttribute);
		builder.append(", extendedAttributes=");
		builder.append(Arrays.toString(extendedAttributes));
		builder.append(", languageId=");
		builder.append(languageId);
		builder.append(", smsReceiveFlag=");
		builder.append(smsReceiveFlag);
		builder.append(", birthDate=");
		builder.append(birthDate);
		builder.append(", groupId=");
		builder.append(groupId);
		builder.append(", subscribedServices=");
		builder.append(subscribedServices);
		builder.append(", servicePackages=");
		builder.append(servicePackages);
		builder.append(", quotas=");
		builder.append(quotas);
		builder.append(", accounts=");
		builder.append(accounts);
		builder.append("]");
		return builder.toString();
	}
	
}
