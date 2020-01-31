package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class VersionUpdate implements Serializable {

	private static final long serialVersionUID = 3823396869563371531L;
   
	@JsonIgnore
	private String bundleIdentifier;
	
	private String currentVersion;

	private String updateVersion;

	private String isUpdate;
	 
	private String isMandatory;
	@JsonIgnore 
	private String osType;
	
	private String appUpdateURL;
	
	private int appFeaturesStatus=0;
  

	public int getAppFeaturesStatus() {
		return appFeaturesStatus;
	}


	public void setAppFeaturesStatus(int appFeaturesStatus) {
		this.appFeaturesStatus = appFeaturesStatus;
	}


	public VersionUpdate() {
		 
	}


	public VersionUpdate(String isUpdate, String isMandatory, String osType) {
		super();
		this.isUpdate = isUpdate;
		this.isMandatory = isMandatory;
		this.osType = osType;
	}

	
	public VersionUpdate(String bundleIdentifier, String currentVersion, String updateVersion, String isUpdate,
			String isMandatory, String osType, String appUpdateURL,int status) {
		super();
		this.bundleIdentifier = bundleIdentifier;
		this.currentVersion = currentVersion;
		this.updateVersion = updateVersion;
		this.isUpdate = isUpdate;
		this.isMandatory = isMandatory;
		this.osType = osType;
		this.appUpdateURL = appUpdateURL;
		this.appFeaturesStatus=status;
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


	 

	public String getAppUpdateURL() {
		return appUpdateURL;
	}


	public void setAppUpdateURL(String appUpdateURL) {
		this.appUpdateURL = appUpdateURL;
	}


	 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appUpdateURL == null) ? 0 : appUpdateURL.hashCode());
		result = prime * result + ((bundleIdentifier == null) ? 0 : bundleIdentifier.hashCode());
		result = prime * result + ((currentVersion == null) ? 0 : currentVersion.hashCode());
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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VersionUpdate other = (VersionUpdate) obj;
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
		return "VersionUpdate [bundleIdentifier=" + bundleIdentifier + ", currentVersion=" + currentVersion
				+ ", updateVersion=" + updateVersion + ", isUpdate=" + isUpdate + ", isMandatory=" + isMandatory
				+ ", osType=" + osType + ", appUpdateURL=" + appUpdateURL + "]";
	}


	 
	
	
}
