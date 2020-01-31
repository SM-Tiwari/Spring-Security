/**
 * TopUpHistoryEntity.java
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
 * @author dhirajkumar
 *
 */

@Entity
@Table(name = "scratch_card_status")
@SequenceGenerator(name = "scratch_status_seq", sequenceName = "scratch_status_seq", allocationSize = 1)
public class ScratchStatusEntity extends BaseEntity {

	private static final long serialVersionUID = -5027352163052435955L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "scratch_status_seq")
	@Column(name = "id")
	private Integer id;
	
	@Column(length = 20, nullable = false)
	private String msisdn;
 
	@Column(name = "timeStamp")
	private String timeStamp;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "count")
	private Integer count;
 
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

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	
	 

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public ScratchStatusEntity(){ }

	 

	public ScratchStatusEntity(String msisdn, String timeStamp, String status, Integer count) {
		super();
		this.msisdn = msisdn;
		this.timeStamp = timeStamp;
		this.status = status;
		this.count = count;
	}

	
	 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((msisdn == null) ? 0 : msisdn.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((timeStamp == null) ? 0 : timeStamp.hashCode());
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
		ScratchStatusEntity other = (ScratchStatusEntity) obj;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
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
		if (timeStamp == null) {
			if (other.timeStamp != null)
				return false;
		} else if (!timeStamp.equals(other.timeStamp))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ScratchStatusEntity [id=" + id + ", msisdn=" + msisdn + ", timeStamp=" + timeStamp + ", status="
				+ status + ", count=" + count + "]";
	}

	
	 
	
}
