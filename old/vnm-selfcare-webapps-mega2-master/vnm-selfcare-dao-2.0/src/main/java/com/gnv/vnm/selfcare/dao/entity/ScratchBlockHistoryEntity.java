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
@Table(name = "scratch_card_history")
@SequenceGenerator(name = "scratch_card_seq", sequenceName = "scratch_card_seq", allocationSize = 1)
public class ScratchBlockHistoryEntity extends BaseEntity {

	private static final long serialVersionUID = -5027352163052435955L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "scratch_card_seq")
	@Column(name = "id")
	private Integer id;
	
	@Column(length = 20, nullable = false)
	private String msisdn;
 
	@Column(name = "timeStamp")
	private String timeStamp;
	
	@Column(name = "statusMessage")
	private String statusMessage;
 
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

 

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public ScratchBlockHistoryEntity(){ }

	public ScratchBlockHistoryEntity(String msisdn, String timeStamp, String statusMessage, Integer count) {
		super();
		this.msisdn = msisdn;
		this.timeStamp = timeStamp;
		this.statusMessage = statusMessage;
		this.count = count;
	}

	 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((msisdn == null) ? 0 : msisdn.hashCode());
		result = prime * result + ((statusMessage == null) ? 0 : statusMessage.hashCode());
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
		ScratchBlockHistoryEntity other = (ScratchBlockHistoryEntity) obj;
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
		if (statusMessage == null) {
			if (other.statusMessage != null)
				return false;
		} else if (!statusMessage.equals(other.statusMessage))
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
		return "ScratchBlockHistoryEntity [id=" + id + ", msisdn=" + msisdn + ", timeStamp=" + timeStamp
				+ ", statusMessage=" + statusMessage + ", count=" + count + "]";
	}

	 
	
	
}
