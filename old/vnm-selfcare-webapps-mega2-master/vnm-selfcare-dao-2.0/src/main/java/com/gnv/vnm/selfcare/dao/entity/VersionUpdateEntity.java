/**
 * OtpEntity.java
 */
package com.gnv.vnm.selfcare.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author nandipinto
 *
 */

@Entity
@Table(name = "version_update")
@SequenceGenerator(name = "version_update_seq", sequenceName = "version_update_seq", allocationSize = 1)
public class VersionUpdateEntity extends BaseEntity {

	private static final long serialVersionUID = -189136718357159610L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "version_update_seq")
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "bundle_identifier", length = 100)
	private String bundleIdentifier;
	
	@Column(name = "current_version", length = 20)
	private String currentVersion;
	
	@Column(name = "update_version", length = 20)
	private String updateVersion;
	
	@Column(name = "is_update", length = 20)
	private String isUpdate;
	
	@Column(name = "is_mandatory", length = 20)
	private String isMandatory;
	
	@Column(name = "os_type", length = 20)
	private String osType;
	
	@Column(name = "app_update_url")
	private String appUpdateURL;
	
	public VersionUpdateEntity(){ }



	public VersionUpdateEntity(Integer id, String bundleIdentifier, String currentVersion, String updateVersion,
			String isUpdate, String isMandatory, String osType, String appUpdateURL) {
		super();
		this.id = id;
		this.bundleIdentifier = bundleIdentifier;
		this.currentVersion = currentVersion;
		this.updateVersion = updateVersion;
		this.isUpdate = isUpdate;
		this.isMandatory = isMandatory;
		this.osType = osType;
		this.appUpdateURL = appUpdateURL;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBundleIdentifier() {
		return bundleIdentifier;
	}

	public void setBundleIdentifier(String bundleIdentifier) {
		this.bundleIdentifier = bundleIdentifier;
	}

	 

	public String getCurrentVersion() {
		return currentVersion;
	}



	public void setCurrentVersion(String currentVersion) {
		this.currentVersion = currentVersion;
	}



	public String getUpdateVersion() {
		return updateVersion;
	}



	public void setUpdateVersion(String updateVersion) {
		this.updateVersion = updateVersion;
	}



	public String getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(String isUpdate) {
		this.isUpdate = isUpdate;
	}

	public String getIsMandatory() {
		return isMandatory;
	}

	public void setIsMandatory(String isMandatory) {
		this.isMandatory = isMandatory;
	}

	
	
	public String getOsType() {
		return osType;
	}


	public void setOsType(String osType) {
		this.osType = osType;
	}


	 

	public String getAppUpdateURL() {
		return appUpdateURL;
	}



	public void setAppUpdateURL(String appUpdateURL) {
		this.appUpdateURL = appUpdateURL;
	}



	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((appUpdateURL == null) ? 0 : appUpdateURL.hashCode());
		result = prime * result + ((bundleIdentifier == null) ? 0 : bundleIdentifier.hashCode());
		result = prime * result + ((currentVersion == null) ? 0 : currentVersion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isMandatory == null) ? 0 : isMandatory.hashCode());
		result = prime * result + ((isUpdate == null) ? 0 : isUpdate.hashCode());
		result = prime * result + ((osType == null) ? 0 : osType.hashCode());
		result = prime * result + ((updateVersion == null) ? 0 : updateVersion.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		VersionUpdateEntity other = (VersionUpdateEntity) obj;
		if (appUpdateURL == null) {
			if (other.appUpdateURL != null)
				return false;
		} else if (!appUpdateURL.equals(other.appUpdateURL))
			return false;
		if (bundleIdentifier == null) {
			if (other.bundleIdentifier != null)
				return false;
		} else if (!bundleIdentifier.equals(other.bundleIdentifier))
			return false;
		if (currentVersion == null) {
			if (other.currentVersion != null)
				return false;
		} else if (!currentVersion.equals(other.currentVersion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isMandatory == null) {
			if (other.isMandatory != null)
				return false;
		} else if (!isMandatory.equals(other.isMandatory))
			return false;
		if (isUpdate == null) {
			if (other.isUpdate != null)
				return false;
		} else if (!isUpdate.equals(other.isUpdate))
			return false;
		if (osType == null) {
			if (other.osType != null)
				return false;
		} else if (!osType.equals(other.osType))
			return false;
		if (updateVersion == null) {
			if (other.updateVersion != null)
				return false;
		} else if (!updateVersion.equals(other.updateVersion))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "VersionUpdateEntity [id=" + id + ", bundleIdentifier=" + bundleIdentifier + ", currentVersion="
				+ currentVersion + ", updateVersion=" + updateVersion + ", isUpdate=" + isUpdate + ", isMandatory="
				+ isMandatory + ", osType=" + osType + ", appUpdateURL=" + appUpdateURL + "]";
	}


}
