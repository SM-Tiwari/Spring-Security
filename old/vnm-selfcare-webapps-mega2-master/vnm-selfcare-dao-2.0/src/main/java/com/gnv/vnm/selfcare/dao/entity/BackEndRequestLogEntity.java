/**
 * BackEndRequestLogEntity.java
 */
package com.gnv.vnm.selfcare.dao.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author nandipinto
 *
 */

@Entity
@Table(name = "backend_req_log"/*, uniqueConstraints = {@UniqueConstraint(columnNames = "id")}*/)
@SequenceGenerator(name = "backend_reqlog_seq", sequenceName = "backend_reqlog_seq", allocationSize = 1)
public class BackEndRequestLogEntity extends BaseEntity {

	private static final long serialVersionUID = 4531210462712449074L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "backend_reqlog_seq")
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "adapter_name", length = 30, nullable = false)
	private String adapterName;
	
	@Column(name = "trx_id", length = 100)
	private String trxId;
	
	@Column(name = "req_payload")
	@Lob @Basic(fetch = FetchType.LAZY)
	private String reqPayload;

	@Column(name = "start_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startTime;
	
	@Column(name = "end_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endTime;
	
	@Column
	private Integer status = 0;
	
	@Column(name = "status_code", length = 20)
	private String statusCode;
	
	@Column(name = "status_desc")
	@Lob @Basic(fetch = FetchType.LAZY)
	private String statusDesc;

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
	 * @return the adapterName
	 */
	public String getAdapterName() {
		return adapterName;
	}

	/**
	 * @param adapterName the adapterName to set
	 */
	public void setAdapterName(String adapterName) {
		this.adapterName = adapterName;
	}

	/**
	 * @return the trxId
	 */
	public String getTrxId() {
		return trxId;
	}

	/**
	 * @param trxId the trxId to set
	 */
	public void setTrxId(String trxId) {
		this.trxId = trxId;
	}

	/**
	 * @return the reqPayload
	 */
	public String getReqPayload() {
		return reqPayload;
	}

	/**
	 * @param reqPayload the reqPayload to set
	 */
	public void setReqPayload(String reqPayload) {
		this.reqPayload = reqPayload;
	}

	/**
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the statusCode
	 */
	public String getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * @return the statusDesc
	 */
	public String getStatusDesc() {
		return statusDesc;
	}

	/**
	 * @param statusDesc the statusDesc to set
	 */
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((adapterName == null) ? 0 : adapterName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((trxId == null) ? 0 : trxId.hashCode());
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
		BackEndRequestLogEntity other = (BackEndRequestLogEntity) obj;
		if (adapterName == null) {
			if (other.adapterName != null)
				return false;
		} else if (!adapterName.equals(other.adapterName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (trxId == null) {
			if (other.trxId != null)
				return false;
		} else if (!trxId.equals(other.trxId))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BackEndRequestLogEntity [id=");
		builder.append(id);
		builder.append(", adapterName=");
		builder.append(adapterName);
		builder.append(", trxId=");
		builder.append(trxId);
		builder.append(", reqPayload=");
		builder.append(reqPayload);
		builder.append(", startTime=");
		builder.append(startTime);
		builder.append(", endTime=");
		builder.append(endTime);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}

	
}
