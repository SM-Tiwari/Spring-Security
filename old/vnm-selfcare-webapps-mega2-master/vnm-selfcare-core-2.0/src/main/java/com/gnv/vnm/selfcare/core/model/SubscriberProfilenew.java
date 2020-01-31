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
public class SubscriberProfilenew implements Serializable {

	private static final long serialVersionUID = -5319902842063496082L;
	
	private Integer id;
	private String msisdn;
	private String imsi;
	private String imei;
	private int micUploadStatus = 0;
	private int appFeaturesStatus=0;
	private FattyMonsterDetails fattyMonsterDetails;
	 
	public FattyMonsterDetails getFattyMonsterDetails() {
		return fattyMonsterDetails;
	}

	public void setFattyMonsterDetails(FattyMonsterDetails fattyMonsterDetails) {
		this.fattyMonsterDetails = fattyMonsterDetails;
	}


	public int getAppFeaturesStatus() {
		return appFeaturesStatus;
	}

	public void setAppFeaturesStatus(int appFeaturesStatus) {
		this.appFeaturesStatus = appFeaturesStatus;
	}
	
	@JsonIgnore
	private String credential;
	public int getMicUploadStatus() {
		return micUploadStatus;
	}

	public void setMicUploadStatus(int micUploadStatus) {
		this.micUploadStatus = micUploadStatus;
	}



	private String emailAddress;
	private String preferredLanguage = SupportedLanguage.VIETNAMESE.code();
	private SubscriberType type = SubscriberType.PREPAID;
	private SubscriberStatus status = SubscriberStatus.PENDING;
	private String avatar;
     private int notificationCount = 0;
     private List<String> enabledAppFeatures = new ArrayList<>();
 	private SubscriberDetails details = new SubscriberDetails();
 	
	public SubscriberProfilenew(){ }
	
	/**
	 * @param id
	 * @param msisdn
	 * @param imsi
	 * @param imei
	 * @param emailAddress
	 * @param type
	 * @param status
	 */
	public SubscriberProfilenew(Integer id, String msisdn, String imsi, String imei, String emailAddress, SubscriberType type,
			SubscriberStatus status) {
		this.id = id;
		this.msisdn = msisdn;
		this.imsi = imsi;
		this.imei = imei;
		this.emailAddress = emailAddress;
		this.type = type;
		this.status = status;
		this.micUploadStatus=micUploadStatus;
	}

	/**
	 * @param msisdn
	 * @param imsi
	 * @param imei
	 * @param credential
	 * @param emailAddress
	 */
	public SubscriberProfilenew(String msisdn, String imsi, String imei, String credential, String emailAddress) {
		this.msisdn = msisdn;
		this.imsi = imsi;
		this.imei = imei;
		this.credential = credential;
		this.emailAddress = emailAddress;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	

	public String getCredential() {
		return credential;
	}

	public void setCredential(String credential) {
		this.credential = credential;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPreferredLanguage() {
		return preferredLanguage;
	}

	public void setPreferredLanguage(String preferredLanguage) {
		this.preferredLanguage = preferredLanguage;
	}

	public SubscriberType getType() {
		return type;
	}

	public void setType(SubscriberType type) {
		this.type = type;
	}

	public SubscriberStatus getStatus() {
		return status;
	}

	public void setStatus(SubscriberStatus status) {
		this.status = status;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getNotificationCount() {
		return notificationCount;
	}

	public void setNotificationCount(int notificationCount) {
		this.notificationCount = notificationCount;
	}

	public List<String> getEnabledAppFeatures() {
		return enabledAppFeatures;
	}

	public void setEnabledAppFeatures(List<String> enabledAppFeatures) {
		this.enabledAppFeatures = enabledAppFeatures;
	}

	public SubscriberDetails getDetails() {
		return details;
	}

	public void setDetails(SubscriberDetails details) {
		this.details = details;
	}

	

	@Override
	public String toString() {
		return "SubscriberProfilenew [id=" + id + ", msisdn=" + msisdn + ", imsi=" + imsi + ", imei=" + imei
				+ ", micUploadStatus=" + micUploadStatus + ", credential=" + credential + ", emailAddress=" + emailAddress
				+ ", preferredLanguage=" + preferredLanguage + ", type=" + type + ", status=" + status + ", avatar="
				+ avatar + ", notificationCount=" + notificationCount + ", enabledAppFeatures=" + enabledAppFeatures
				+ ", details=" + details + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((avatar == null) ? 0 : avatar.hashCode());
		result = prime * result + ((credential == null) ? 0 : credential.hashCode());
		result = prime * result + ((details == null) ? 0 : details.hashCode());
		result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result + ((enabledAppFeatures == null) ? 0 : enabledAppFeatures.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imei == null) ? 0 : imei.hashCode());
		result = prime * result + ((imsi == null) ? 0 : imsi.hashCode());
		result = prime * result + micUploadStatus;
		result = prime * result + ((msisdn == null) ? 0 : msisdn.hashCode());
		result = prime * result + notificationCount;
		result = prime * result + ((preferredLanguage == null) ? 0 : preferredLanguage.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		SubscriberProfilenew other = (SubscriberProfilenew) obj;
		if (avatar == null) {
			if (other.avatar != null)
				return false;
		} else if (!avatar.equals(other.avatar))
			return false;
		if (credential == null) {
			if (other.credential != null)
				return false;
		} else if (!credential.equals(other.credential))
			return false;
		if (details == null) {
			if (other.details != null)
				return false;
		} else if (!details.equals(other.details))
			return false;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		if (enabledAppFeatures == null) {
			if (other.enabledAppFeatures != null)
				return false;
		} else if (!enabledAppFeatures.equals(other.enabledAppFeatures))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (imei == null) {
			if (other.imei != null)
				return false;
		} else if (!imei.equals(other.imei))
			return false;
		if (imsi == null) {
			if (other.imsi != null)
				return false;
		} else if (!imsi.equals(other.imsi))
			return false;
		if (micUploadStatus != other.micUploadStatus)
			return false;
		if (msisdn == null) {
			if (other.msisdn != null)
				return false;
		} else if (!msisdn.equals(other.msisdn))
			return false;
		if (notificationCount != other.notificationCount)
			return false;
		if (preferredLanguage == null) {
			if (other.preferredLanguage != null)
				return false;
		} else if (!preferredLanguage.equals(other.preferredLanguage))
			return false;
		if (status != other.status)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	

	 
	 
	
}
