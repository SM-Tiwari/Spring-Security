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
@Table(name = "sms_call_history_status")
@SequenceGenerator(name = "sms_call_history_status_seq", sequenceName = "sms_call_history_status_seq", allocationSize = 1)
public class SmsCallHistoryStatusEntity extends BaseEntity {

	private static final long serialVersionUID = -189136718357159610L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sms_call_history_status_seq")
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "msisdn", length = 100)
	private String msisdn;
	
	@Column(name = "status", length = 20)
	private String status;
	
	 
	
	public SmsCallHistoryStatusEntity(){ }



	public SmsCallHistoryStatusEntity(Integer id, String msisdn, String status) {
		super();
		this.id = id;
		this.msisdn = msisdn;
		this.status = status;
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



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((msisdn == null) ? 0 : msisdn.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		SmsCallHistoryStatusEntity other = (SmsCallHistoryStatusEntity) obj;
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
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "SmsCallHistoryStatusEntity [id=" + id + ", msisdn=" + msisdn + ", status=" + status + "]";
	}

}
