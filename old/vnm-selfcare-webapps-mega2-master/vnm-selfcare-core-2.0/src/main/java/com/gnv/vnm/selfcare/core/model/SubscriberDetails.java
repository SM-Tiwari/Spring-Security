/**
 * SubscriberDetails.java
 */
package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;
import java.util.Date;

import com.gnv.vnm.selfcare.core.enums.Gender;

/**
 * @author nandipinto
 *
 */
public class SubscriberDetails implements Serializable {

	private static final long serialVersionUID = 547544855685226700L;

	private String fullName;
	private Gender gender;
	private Date birthDate;
	private String avatar;
	private String address1;
	private String address2;
	private String address3;
	private String address4;
	private String zipCode;
	private String occupation;
	private String companyName;
	
	public SubscriberDetails(){ }
	
	/**
	 * @param fullName
	 * @param gender
	 * @param birthDate
	 * @param avatar
	 * @param address1
	 * @param address2
	 * @param address3
	 * @param address4
	 * @param zipCode
	 * @param occupation
	 * @param companyName
	 */
	public SubscriberDetails(String fullName, Gender gender,
			Date birthDate, String avatar, String address1, String address2, String address3, String address4,
			String zipCode, String occupation, String companyName) {
		this.fullName = fullName;
		this.gender = gender;
		this.birthDate = birthDate;
		this.avatar = avatar;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.address4 = address4;
		this.zipCode = zipCode;
		this.occupation = occupation;
		this.companyName = companyName;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}
	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}
	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
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
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}
	/**
	 * @param address1 the address1 to set
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}
	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	/**
	 * @return the address3
	 */
	public String getAddress3() {
		return address3;
	}
	/**
	 * @param address3 the address3 to set
	 */
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	/**
	 * @return the address4
	 */
	public String getAddress4() {
		return address4;
	}
	/**
	 * @param address4 the address4 to set
	 */
	public void setAddress4(String address4) {
		this.address4 = address4;
	}
	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}
	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	/**
	 * @return the occupation
	 */
	public String getOccupation() {
		return occupation;
	}
	/**
	 * @param occupation the occupation to set
	 */
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SubscriberDetails [fullName=");
		builder.append(fullName);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", birthDate=");
		builder.append(birthDate);
		builder.append(", avatar=");
		builder.append(avatar);
		builder.append(", address1=");
		builder.append(address1);
		builder.append(", address2=");
		builder.append(address2);
		builder.append(", address3=");
		builder.append(address3);
		builder.append(", address4=");
		builder.append(address4);
		builder.append(", zipCode=");
		builder.append(zipCode);
		builder.append(", occupation=");
		builder.append(occupation);
		builder.append(", companyName=");
		builder.append(companyName);
		builder.append("]");
		return builder.toString();
	}
}
