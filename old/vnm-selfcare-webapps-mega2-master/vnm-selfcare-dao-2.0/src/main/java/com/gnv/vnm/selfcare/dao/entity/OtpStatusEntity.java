/**
 * TopUpHistoryEntity.java
 */
package com.gnv.vnm.selfcare.dao.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



/**
 * @author dhirajkumar
 *
 */

@Entity
@Table(name = "otp_card_status")
@SequenceGenerator(name = "otp_status_seq", sequenceName = "otp_status_seq", allocationSize = 1)
public class OtpStatusEntity extends BaseEntity {

	private static final long serialVersionUID = -5027352163052435955L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "otp_status_seq")
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
	
	@Column(name = "failcount")
	private Integer failCount;
 
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
	

	public Integer getFailCount() {
		return failCount;
	}

	public void setFailCount(Integer failCount) {
		this.failCount = failCount;
	}

	public OtpStatusEntity(){ }

	 



	@Override
	public String toString() {
		return "ScratchStatusEntity [id=" + id + ", msisdn=" + msisdn + ", timeStamp=" + timeStamp + ", status="
				+ status + ", count=" + count + ",failcount"+failCount+"]";
	}

	
	 
	
}
