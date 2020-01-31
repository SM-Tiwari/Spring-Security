package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gnv.vnm.selfcare.core.enums.SubscriberStatus;
import com.gnv.vnm.selfcare.core.enums.SubscriberType;
import com.gnv.vnm.selfcare.core.enums.SupportedLanguage;

/**
 * @author nandipinto
 *
 */
public class SubscriberProfile implements Serializable {

	private static final long serialVersionUID = -5319902842063496082L;
	
	private Integer id;
	private String msisdn;
	private String imsi;
	private String imei;
	private String classOfServiceName; 
	@JsonIgnore
	private String credential;
	private String emailAddress;
	private String preferredLanguage = SupportedLanguage.VIETNAMESE.code();
	private SubscriberType type = SubscriberType.PREPAID;
	private SubscriberStatus status = SubscriberStatus.PENDING;
	private String avatar;

	private SubscriberDetails details = new SubscriberDetails();
	private CurrentBalance currentBalance = new CurrentBalance();
	private List<PackageSubscription> subscriptions = new ArrayList<>();
	private List<CallRecord> callHistory = new ArrayList<>();
	private List<SmsRecord> smsHistory = new ArrayList<>();
	private List<BillingSummary> billingHistory = new ArrayList<>();

	private int subscriptionCount = 0;
	private int notificationCount = 0;
	private boolean roamingEnabled = false;
	private List<String> disabledAppFeatures = new ArrayList<>();
   
	private List<String> enabledAppFeatures = new ArrayList<>();
	private int micUploadStatus = 0;
	
	public SubscriberProfile(){ }
	
	/**
	 * @param id
	 * @param msisdn
	 * @param imsi
	 * @param imei
	 * @param emailAddress
	 * @param type
	 * @param status
	 */
	public SubscriberProfile(Integer id, String msisdn, String imsi, String imei, String emailAddress, SubscriberType type,
			SubscriberStatus status) {
		this.id = id;
		this.msisdn = msisdn;
		this.imsi = imsi;
		this.imei = imei;
		this.emailAddress = emailAddress;
		this.type = type;
		this.status = status;
	}

	/**
	 * @param msisdn
	 * @param imsi
	 * @param imei
	 * @param credential
	 * @param emailAddress
	 */
	public SubscriberProfile(String msisdn, String imsi, String imei, String credential, String emailAddress) {
		this.msisdn = msisdn;
		this.imsi = imsi;
		this.imei = imei;
		this.credential = credential;
		this.emailAddress = emailAddress;
	}

	public List<String> getEnabledAppFeatures() {
		return enabledAppFeatures;
	}

	public void setEnabledAppFeatures(List<String> enabledAppFeatures) {
		this.enabledAppFeatures = enabledAppFeatures;
	}

	public int getMicUploadStatus() {
		return micUploadStatus;
	}

	public void setMicUploadStatus(int micUploadStatus) {
		this.micUploadStatus = micUploadStatus;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
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
	 * @return the classOfServiceName
	 */
	public String getClassOfServiceName() {
		return classOfServiceName;
	}

	/**
	 * @param classOfServiceName the classOfServiceName to set
	 */
	public void setClassOfServiceName(String classOfService) {
		this.classOfServiceName = classOfService;
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
	 * @return the credential
	 */
	public String getCredential() {
		return credential;
	}

	/**
	 * @param credential the credential to set
	 */
	public void setCredential(String credential) {
		this.credential = credential;
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
	 * @return the preferredLanguage
	 */
	@JsonProperty("languageCode")
	public String getPreferredLanguage() {
		return preferredLanguage;
	}

	/**
	 * @param preferredLanguage the preferredLanguage to set
	 */
	public void setPreferredLanguage(String languageId) {
		this.preferredLanguage = languageId;
	}

	/**
	 * @return the type
	 */
	public SubscriberType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(SubscriberType type) {
		this.type = type;
	}

	/**
	 * @return the status
	 */
	public SubscriberStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(SubscriberStatus status) {
		this.status = status;
	}

	/**
	 * @return the avatar
	 */
	public String getAvatar() {
		return avatar;
	}

	/**
	 * @param avatar the avatar to set
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	/**
	 * @return the details
	 */
	public SubscriberDetails getDetails() {
		return details;
	}

	/**
	 * @param details the details to set
	 */
	public void setDetails(SubscriberDetails details) {
		this.details = details;
	}

	/**
	 * @return the currentBalance
	 */
	public CurrentBalance getCurrentBalance() {
		return currentBalance;
	}

	/**
	 * @param currentBalance the currentBalance to set
	 */
	public void setCurrentBalance(CurrentBalance currentBalance) {
		this.currentBalance = currentBalance;
	}

	/**
	 * @return the subscriptions
	 */
	public List<PackageSubscription> getSubscriptions() {
		return subscriptions;
	}

	/**
	 * @param subscriptions the subscriptions to set
	 */
	public void setSubscriptions(List<PackageSubscription> subscriptions) {
		this.subscriptions = subscriptions;
	}

	/**
	 * @return the callHistory
	 */
	public List<CallRecord> getCallHistory() {
		return callHistory;
	}

	/**
	 * @param callHistory the callHistory to set
	 */
	public void setCallHistory(List<CallRecord> callHistory) {
		this.callHistory = callHistory;
	}

	/**
	 * @return the smsHistory
	 */
	public List<SmsRecord> getSmsHistory() {
		return smsHistory;
	}

	/**
	 * @param smsHistory the smsHistory to set
	 */
	public void setSmsHistory(List<SmsRecord> smsHistory) {
		this.smsHistory = smsHistory;
	}

	/**
	 * @return the billingHistory
	 */
	public List<BillingSummary> getBillingHistory() {
		return billingHistory;
	}

	/**
	 * @param billingHistory the billingHistory to set
	 */
	public void setBillingHistory(List<BillingSummary> billingHistory) {
		this.billingHistory = billingHistory;
	}

	

	public int getSubscriptionCount() {
		return subscriptionCount;
	}

	public void setSubscriptionCount(int subscriptionCount) {
		this.subscriptionCount = subscriptionCount;
	}

	/**
	 * @return the notificationCount
	 */
	public int getNotificationCount() {
		return notificationCount;
	}

	/**
	 * @param notificationCount the notificationCount to set
	 */
	public void setNotificationCount(int notificationCount) {
		this.notificationCount = notificationCount;
	}

	/**
	 * @return the roamingEnabled
	 */
	public boolean isRoamingEnabled() {
		return roamingEnabled;
	}

	/**
	 * @param roamingEnabled the roamingEnabled to set
	 */
	public void setRoamingEnabled(boolean roamingEnabled) {
		this.roamingEnabled = roamingEnabled;
	}

	/**
	 * @return the disabledAppFeatures
	 */
	public List<String> getDisabledAppFeatures() {
		return disabledAppFeatures;
	}

	/**
	 * @param disabledAppFeatures the disabledAppFeatures to set
	 */
	public void setDisabledAppFeatures(List<String> enabledAppFeatures) {
		this.disabledAppFeatures = enabledAppFeatures;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		SubscriberProfile other = (SubscriberProfile) obj;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (msisdn == null) {
			if (other.msisdn != null)
				return false;
		} else if (!msisdn.equals(other.msisdn))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SubscriberProfile [id=" + id + ", msisdn=" + msisdn + ", imsi=" + imsi + ", imei=" + imei
				+ ", classOfServiceName=" + classOfServiceName + ", credential=" + credential + ", emailAddress="
				+ emailAddress + ", preferredLanguage=" + preferredLanguage + ", type=" + type + ", status=" + status
				+ ", avatar=" + avatar + ", details=" + details + ", currentBalance=" + currentBalance
				+ ", subscriptions=" + subscriptions + ", callHistory=" + callHistory + ", smsHistory=" + smsHistory
				+ ", billingHistory=" + billingHistory + ", subscriptionCount=" + subscriptionCount
				+ ", notificationCount=" + notificationCount + ", roamingEnabled=" + roamingEnabled
				+ ", disabledAppFeatures=" + disabledAppFeatures + ", enabledAppFeatures=" + enabledAppFeatures
				+ ", micUploadStatus=" + micUploadStatus + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	 
	
}
