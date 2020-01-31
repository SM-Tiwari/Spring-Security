package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;


public class MicInformationView implements Serializable {

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
	public MicInformationView() {
		 
	}


	public MicInformationView(String firstNmae, String lastName, String dob, String idCard, String date_of_issue,
			String placeOfIssue, String address, String province, String district, String country, String msisdn,
			String firstSideIdcard, String secondSideIdcard, String customerPortrait, String customerSignature) {
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
	
	}
	 

	public MicInformationView(String firstNmae, String lastName, String dob, String idCard, String date_of_issue,
			String placeOfIssue, String address, String province, String district, String country, String msisdn,
			String firstSideIdcard, String secondSideIdcard, String customerPortrait, String customerSignature,String gender) {
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




	 


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((customerPortrait == null) ? 0 : customerPortrait.hashCode());
		result = prime * result + ((customerSignature == null) ? 0 : customerSignature.hashCode());
		result = prime * result + ((date_of_issue == null) ? 0 : date_of_issue.hashCode());
		result = prime * result + ((district == null) ? 0 : district.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((firstNmae == null) ? 0 : firstNmae.hashCode());
		result = prime * result + ((firstSideIdcard == null) ? 0 : firstSideIdcard.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((idCard == null) ? 0 : idCard.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((msisdn == null) ? 0 : msisdn.hashCode());
		result = prime * result + ((placeOfIssue == null) ? 0 : placeOfIssue.hashCode());
		result = prime * result + ((province == null) ? 0 : province.hashCode());
		result = prime * result + ((secondSideIdcard == null) ? 0 : secondSideIdcard.hashCode());
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
		MicInformationView other = (MicInformationView) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (customerPortrait == null) {
			if (other.customerPortrait != null)
				return false;
		} else if (!customerPortrait.equals(other.customerPortrait))
			return false;
		if (customerSignature == null) {
			if (other.customerSignature != null)
				return false;
		} else if (!customerSignature.equals(other.customerSignature))
			return false;
		if (date_of_issue == null) {
			if (other.date_of_issue != null)
				return false;
		} else if (!date_of_issue.equals(other.date_of_issue))
			return false;
		if (district == null) {
			if (other.district != null)
				return false;
		} else if (!district.equals(other.district))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (firstNmae == null) {
			if (other.firstNmae != null)
				return false;
		} else if (!firstNmae.equals(other.firstNmae))
			return false;
		if (firstSideIdcard == null) {
			if (other.firstSideIdcard != null)
				return false;
		} else if (!firstSideIdcard.equals(other.firstSideIdcard))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (idCard == null) {
			if (other.idCard != null)
				return false;
		} else if (!idCard.equals(other.idCard))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (msisdn == null) {
			if (other.msisdn != null)
				return false;
		} else if (!msisdn.equals(other.msisdn))
			return false;
		if (placeOfIssue == null) {
			if (other.placeOfIssue != null)
				return false;
		} else if (!placeOfIssue.equals(other.placeOfIssue))
			return false;
		if (province == null) {
			if (other.province != null)
				return false;
		} else if (!province.equals(other.province))
			return false;
		if (secondSideIdcard == null) {
			if (other.secondSideIdcard != null)
				return false;
		} else if (!secondSideIdcard.equals(other.secondSideIdcard))
			return false;
		return true;
	}




	@Override
	public String toString() {
		return "MicInformationView [firstNmae=" + firstNmae + ", lastName=" + lastName + ", dob=" + dob + ", idCard="
				+ idCard + ", date_of_issue=" + date_of_issue + ", placeOfIssue=" + placeOfIssue + ", address="
				+ address + ", province=" + province + ", district=" + district + ", country=" + country + ", msisdn="
				+ msisdn + ", firstSideIdcard=" + firstSideIdcard + ", secondSideIdcard=" + secondSideIdcard
				+ ", customerPortrait=" + customerPortrait + ", customerSignature=" + customerSignature + ", gender="
				+ gender + "]";
	}



 










	 
	 

}
