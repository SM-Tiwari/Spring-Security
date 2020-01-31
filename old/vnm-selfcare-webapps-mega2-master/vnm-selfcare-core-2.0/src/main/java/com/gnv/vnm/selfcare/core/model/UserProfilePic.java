package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;

public class UserProfilePic implements Serializable{
	
	private String userImgBase64;
	private String userImgName;
	public UserProfilePic(String userImgBase64, String userImgName) {
		super();
		this.userImgBase64 = userImgBase64;
		this.userImgName = userImgName;
	}
	public UserProfilePic() {
		super();
	}
	public String getUserImgBase64() {
		return userImgBase64;
	}
	public void setUserImgBase64(String userImgBase64) {
		this.userImgBase64 = userImgBase64;
	}
	public String getUserImgName() {
		return userImgName;
	}
	public void setUserImgName(String userImgName) {
		this.userImgName = userImgName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userImgBase64 == null) ? 0 : userImgBase64.hashCode());
		result = prime * result + ((userImgName == null) ? 0 : userImgName.hashCode());
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
		UserProfilePic other = (UserProfilePic) obj;
		if (userImgBase64 == null) {
			if (other.userImgBase64 != null)
				return false;
		} else if (!userImgBase64.equals(other.userImgBase64))
			return false;
		if (userImgName == null) {
			if (other.userImgName != null)
				return false;
		} else if (!userImgName.equals(other.userImgName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserProfilePic [userImgBase64=" + userImgBase64 + ", userImgName=" + userImgName + "]";
	}
	
	

}
