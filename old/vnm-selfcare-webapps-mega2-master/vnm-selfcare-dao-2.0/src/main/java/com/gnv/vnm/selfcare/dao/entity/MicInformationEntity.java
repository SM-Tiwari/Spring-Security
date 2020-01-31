/**
 * 
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

import org.hibernate.annotations.DynamicUpdate;

/**
 * @author nandipinto
 *
 */

@Entity
@Table(name = "mic_information", uniqueConstraints = {/*@UniqueConstraint(columnNames = "id"), */ @UniqueConstraint(columnNames = "msisdn")})
@DynamicUpdate
@SequenceGenerator(name = "micinfo_seq", sequenceName = "micinfo_seq", allocationSize = 1)
public class MicInformationEntity extends BaseEntity {

	private static final long serialVersionUID = 3823396869563371531L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "micinfo_seq")
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "first_name")
	private String firstNmae;
	
	@Column(name = "last_name")
	private String lastName;
	
  
	@Column(name = "dob")
	private String dob;

	@Column(name = "id_card")
	private String idCard;
	
	@Column(name = "date_of_issue")
	private String date_of_issue;
	
	@Column(name = "place_of_issue")
	private String placeOfIssue;

	@Column(name = "address")
	private String Address;
	
	@Column(name = "province")
	private String province;

	@Column(name = "district")
	private String district;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "msisdn")
	private String msisdn;
	
	@Column(name = "first_side_idcard")
	private String firstSideIdcard;
	
	@Column(name = "second_side_idcard")
	private String secondSideIdcard;
	
	@Column(name = "customer_portrait")
	private String customerPortrait;
	
	@Column(name = "customer_signature")
	private String customerSignature;
	//add gender field by oneclick
	@Column(name = "gender" , columnDefinition="varchar2(10) default 'N/A'")
	private String gender;
	
   public MicInformationEntity(){ }
	
	



	public MicInformationEntity(Integer id, String firstNmae, String lastName, String dob, String idCard,
		String date_of_issue, String placeOfIssue, String address, String province, String district, String country,
		String msisdn, String firstSideIdcard, String secondSideIdcard, String customerPortrait,
		String customerSignature,String gender) {
	super();
	this.id = id;
	this.firstNmae = firstNmae;
	this.lastName = lastName;
	this.dob = dob;
	this.idCard = idCard;
	this.date_of_issue = date_of_issue;
	this.placeOfIssue = placeOfIssue;
	Address = address;
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
		int result = super.hashCode();
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
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		MicInformationEntity other = (MicInformationEntity) obj;
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
	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
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
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
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
		return "MicInformationEntity [id=" + id + ", firstNmae=" + firstNmae + ", lastName=" + lastName + ", dob=" + dob
				+ ", idCard=" + idCard + ", date_of_issue=" + date_of_issue + ", placeOfIssue=" + placeOfIssue
				+ ", Address=" + Address + ", province=" + province + ", district=" + district + ", country=" + country
				+ ", msisdn=" + msisdn + ", firstSideIdcard=" + firstSideIdcard + ", secondSideIdcard="
				+ secondSideIdcard + ", customerPortrait=" + customerPortrait + ", customerSignature="
				+ customerSignature + ", gender="+ gender + "]";
	}







	


	


 
	
}
