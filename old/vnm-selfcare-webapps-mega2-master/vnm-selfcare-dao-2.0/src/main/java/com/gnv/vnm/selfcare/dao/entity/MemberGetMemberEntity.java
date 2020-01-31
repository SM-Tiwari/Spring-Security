/**
 * MemberGetMemberEntity.java
 */
package com.gnv.vnm.selfcare.dao.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author nandipinto
 *
 */

@Entity
@Table(name = "member_get_member") //, indexes = {@Index(columnList = "msisdn")}
@SequenceGenerator(name = "mgm_seq", sequenceName = "mgm_seq", allocationSize = 1)
public class MemberGetMemberEntity extends BaseEntity {

	private static final long serialVersionUID = 1160575315674479665L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mgm_seq")
	@Column(name = "id")
	private Integer id;

	@Column(name = "msisdn", length = 15, nullable = false)
	private String msisdn;

	@Column(name = "invited_msisdn", length = 15, nullable = false)
	private String invidtedMsisdn;
	
	@Column(name = "is_activated")
	private Integer activatedFlag = 0;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "activation_date")
	private Date activationDate;
	
	public MemberGetMemberEntity(){}
	
	public MemberGetMemberEntity(String msisdn, String invidtedMsisdn) {
		this.msisdn = msisdn;
		this.invidtedMsisdn = invidtedMsisdn;
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
	 * @return the invidtedMsisdn
	 */
	public String getInvidtedMsisdn() {
		return invidtedMsisdn;
	}

	/**
	 * @param invidtedMsisdn the invidtedMsisdn to set
	 */
	public void setInvidtedMsisdn(String invidtedMsisdn) {
		this.invidtedMsisdn = invidtedMsisdn;
	}

	/**
	 * @return the activatedFlag
	 */
	public Integer getActivatedFlag() {
		return activatedFlag;
	}

	/**
	 * @param activatedFlag the activatedFlag to set
	 */
	public void setActivatedFlag(Integer registeredFlag) {
		this.activatedFlag = registeredFlag;
	}

	/**
	 * @return the activationDate
	 */
	public Date getActivationDate() {
		return activationDate;
	}

	/**
	 * @param activationDate the activationDate to set
	 */
	public void setActivationDate(Date registeredDate) {
		this.activationDate = registeredDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((invidtedMsisdn == null) ? 0 : invidtedMsisdn.hashCode());
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
		MemberGetMemberEntity other = (MemberGetMemberEntity) obj;
		if (invidtedMsisdn == null) {
			if (other.invidtedMsisdn != null)
				return false;
		} else if (!invidtedMsisdn.equals(other.invidtedMsisdn))
			return false;
		if (msisdn == null) {
			if (other.msisdn != null)
				return false;
		} else if (!msisdn.equals(other.msisdn))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MemberGetMemberEntity [id=");
		builder.append(id);
		builder.append(", msisdn=");
		builder.append(msisdn);
		builder.append(", invidtedMsisdn=");
		builder.append(invidtedMsisdn);
		builder.append(", activatedFlag=");
		builder.append(activatedFlag);
		builder.append(", activationDate=");
		builder.append(activationDate);
		builder.append("]");
		return builder.toString();
	}

}
