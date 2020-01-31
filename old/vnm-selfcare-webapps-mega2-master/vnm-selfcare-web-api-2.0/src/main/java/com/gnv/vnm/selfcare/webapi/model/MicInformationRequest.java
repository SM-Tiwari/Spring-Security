/**
 * 
 */
package com.gnv.vnm.selfcare.webapi.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author dhiraj kumar
 *
 */

 
public class MicInformationRequest implements Serializable {

	private static final long serialVersionUID = 3823396869563371531L;
    	 
	private String firstNmae;
	 
	private String lastName;
	 
	private String dob;
 
	private String idCard;
	 
	private String date_of_issue;
	 
	private String placeOfIssue;
 
	private String address;
	 
	private String province;
 
	private String district;
	 
	private String country;
	 
	private String msisdn;
	 
	private String firstSideIdcard;
	 
	private String secondSideIdcard;
	private String customerPortrait;
	private String customerSignature;
	private String gender;
	
   public MicInformationRequest(){ }
	
	
	public MicInformationRequest(String firstNmae, String lastName, String dob, String idCard, String date_of_issue,
		String placeOfIssue, String address, String province, String district, String country, String msisdn,
		String firstSideIdcard, String secondSideIdcard, String customerPortrait, String customerSignature, String gender) {
	super();
	this.firstNmae = firstNmae;
	this.lastName = lastName;
	this.dob = dob;
	this.idCard = idCard;
	this.date_of_issue = date_of_issue;
	this.placeOfIssue = placeOfIssue;
	this.address = address;
	this.province = province;
	this.district = district;
	this.country = country;
	this.msisdn = msisdn;
	this.firstSideIdcard = firstSideIdcard;
	this.secondSideIdcard = secondSideIdcard;
	this.customerPortrait = customerPortrait;
	this.customerSignature = customerSignature;
	this.gender = gender;
}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	 
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((msisdn == null) ? 0 : msisdn.hashCode());
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
		MicInformationRequest other = (MicInformationRequest) obj;
		if (msisdn == null) {
			if (other.msisdn != null)
				return false;
		} else if (!msisdn.equals(other.msisdn))
			return false;
		return true;
	}
	
	
	public String getFirstNmae() {
		return firstNmae;
	}



	public void setFirstNmae(String firstNmae) {
		this.firstNmae = firstNmae;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getDob() {
		return dob;
	}



	public void setDob(String dob) {
		this.dob = dob;
	}



	public String getIdCard() {
		return idCard;
	}



	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}



	public String getDate_of_issue() {
		return date_of_issue;
	}



	public void setDate_of_issue(String date_of_issue) {
		this.date_of_issue = date_of_issue;
	}



	public String getPlaceOfIssue() {
		return placeOfIssue;
	}



	public void setPlaceOfIssue(String placeOfIssue) {
		this.placeOfIssue = placeOfIssue;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getProvince() {
		return province;
	}



	public void setProvince(String province) {
		this.province = province;
	}



	public String getDistrict() {
		return district;
	}



	public void setDistrict(String district) {
		this.district = district;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public String getMsisdn() {
		return msisdn;
	}



	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}



	public String getFirstSideIdcard() {
		return firstSideIdcard;
	}



	public void setFirstSideIdcard(String firstSideIdcard) {
		this.firstSideIdcard = firstSideIdcard;
	}



	public String getSecondSideIdcard() {
		return secondSideIdcard;
	}



	public void setSecondSideIdcard(String secondSideIdcard) {
		this.secondSideIdcard = secondSideIdcard;
	}



	public String getCustomerPortrait() {
		return customerPortrait;
	}


	public void setCustomerPortrait(String customerPortrait) {
		this.customerPortrait = customerPortrait;
	}


	public String getCustomerSignature() {
		return customerSignature;
	}


	public void setCustomerSignature(String customerSignature) {
		this.customerSignature = customerSignature;
	}


	
	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "MicInformationRequest [firstNmae=" + firstNmae + ", lastName=" + lastName + ", dob=" + dob + ", idCard="
				+ idCard + ", date_of_issue=" + date_of_issue + ", placeOfIssue=" + placeOfIssue + ", address="
				+ address + ", province=" + province + ", district=" + district + ", country=" + country + ", msisdn="
				+ msisdn + ", firstSideIdcard=" + firstSideIdcard + ", secondSideIdcard=" + secondSideIdcard
				+ ", customerPortrait=" + customerPortrait + ", customerSignature=" + customerSignature + ", gender="
				+ gender + "]";
	}



	
}
