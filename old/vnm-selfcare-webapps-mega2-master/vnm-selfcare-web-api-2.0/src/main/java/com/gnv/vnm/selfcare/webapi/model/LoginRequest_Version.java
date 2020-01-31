package com.gnv.vnm.selfcare.webapi.model;

import java.io.Serializable;

public class LoginRequest_Version implements Serializable {

	private static final long serialVersionUID = 7076487879332279215L;
	
	private String loginId;
	private String credential;
	private String app_version;
	private String app_os;
	private String app_os_version;
	private String devic_name;
	private String devic_modeil;
	private String devic_id;
	
public LoginRequest_Version(){ }
	
	/**
	 * @param loginId
	 * @param credential
	 */
	public LoginRequest_Version(String loginId, String credential,String app_version,String app_os,String app_os_version,String devic_name,String devic_modeil,String devic_id) {
		this.loginId = loginId;
		this.credential = credential;
		this.app_version = app_version;
		this.app_os = app_os;
		this.app_os_version = app_os_version;
		this.devic_name = devic_name;
		this.devic_modeil = devic_modeil;
		this.devic_id = devic_id;
		
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getCredential() {
		return credential;
	}

	public void setCredential(String credential) {
		this.credential = credential;
	}

	public String getApp_version() {
		return app_version;
	}

	public void setApp_version(String app_version) {
		this.app_version = app_version;
	}

	public String getApp_os() {
		return app_os;
	}

	public void setApp_os(String app_os) {
		this.app_os = app_os;
	}

	public String getApp_os_version() {
		return app_os_version;
	}

	public void setApp_os_version(String app_os_version) {
		this.app_os_version = app_os_version;
	}

	public String getDevic_name() {
		return devic_name;
	}

	public void setDevic_name(String devic_name) {
		this.devic_name = devic_name;
	}

	public String getDevic_modeil() {
		return devic_modeil;
	}

	public void setDevic_modeil(String devic_modeil) {
		this.devic_modeil = devic_modeil;
	}

	public String getDevic_id() {
		return devic_id;
	}

	public void setDevic_id(String devic_id) {
		this.devic_id = devic_id;
	}

	@Override
	public String toString() {
		return "LoginRequest_Version [loginId=" + loginId + ", credential=" + credential + ", app_version="
				+ app_version + ", app_os=" + app_os + ", app_os_version=" + app_os_version + ", devic_name="
				+ devic_name + ", devic_modeil=" + devic_modeil + ", devic_id=" + devic_id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((app_os == null) ? 0 : app_os.hashCode());
		result = prime * result + ((app_os_version == null) ? 0 : app_os_version.hashCode());
		result = prime * result + ((app_version == null) ? 0 : app_version.hashCode());
		result = prime * result + ((credential == null) ? 0 : credential.hashCode());
		result = prime * result + ((devic_id == null) ? 0 : devic_id.hashCode());
		result = prime * result + ((devic_modeil == null) ? 0 : devic_modeil.hashCode());
		result = prime * result + ((devic_name == null) ? 0 : devic_name.hashCode());
		result = prime * result + ((loginId == null) ? 0 : loginId.hashCode());
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
		LoginRequest_Version other = (LoginRequest_Version) obj;
		if (app_os == null) {
			if (other.app_os != null)
				return false;
		} else if (!app_os.equals(other.app_os))
			return false;
		if (app_os_version == null) {
			if (other.app_os_version != null)
				return false;
		} else if (!app_os_version.equals(other.app_os_version))
			return false;
		if (app_version == null) {
			if (other.app_version != null)
				return false;
		} else if (!app_version.equals(other.app_version))
			return false;
		if (credential == null) {
			if (other.credential != null)
				return false;
		} else if (!credential.equals(other.credential))
			return false;
		if (devic_id == null) {
			if (other.devic_id != null)
				return false;
		} else if (!devic_id.equals(other.devic_id))
			return false;
		if (devic_modeil == null) {
			if (other.devic_modeil != null)
				return false;
		} else if (!devic_modeil.equals(other.devic_modeil))
			return false;
		if (devic_name == null) {
			if (other.devic_name != null)
				return false;
		} else if (!devic_name.equals(other.devic_name))
			return false;
		if (loginId == null) {
			if (other.loginId != null)
				return false;
		} else if (!loginId.equals(other.loginId))
			return false;
		return true;
	}

	
	 
	
}
