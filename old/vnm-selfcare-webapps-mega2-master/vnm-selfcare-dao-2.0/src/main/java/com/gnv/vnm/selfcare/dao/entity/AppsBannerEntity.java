/**
 * MovieBannerEntity.java
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
//uniqueConstraints = { @UniqueConstraint(columnNames = "id") }, 
@Table(name = "apps_banner", indexes = {
		@Index(columnList = "apps_id"), @Index(columnList = "end_date") })
@SequenceGenerator(name = "apps_banner_seq", sequenceName = "apps_banner_seq", allocationSize = 1)
public class AppsBannerEntity extends BaseEntity {

	private static final long serialVersionUID = -704402753603622208L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "apps_banner_seq")
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "apps_id")
	private Integer appsId;
	
	@Column(name = "start_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	
	@Column(name = "end_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	
	@Column(name = "status")
	private Integer status = 1;
	
	public AppsBannerEntity(){ }

	public AppsBannerEntity(Integer id, Integer appsId, Date startDate, Date endDate) {
		this.id = id;
		this.appsId = appsId;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public AppsBannerEntity(Integer appsId, Date startDate, Date endDate) {
		this(null, appsId, startDate, endDate);
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
	 * @return the appsId
	 */
	public Integer getAppsId() {
		return appsId;
	}

	/**
	 * @param appsId the appsId to set
	 */
	public void setAppsId(Integer appsId) {
		this.appsId = appsId;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((appsId == null) ? 0 : appsId.hashCode());
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
		AppsBannerEntity other = (AppsBannerEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (appsId == null) {
			if (other.appsId != null)
				return false;
		} else if (!appsId.equals(other.appsId))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AppsBannerEntity [id=");
		builder.append(id);
		builder.append(", appsId=");
		builder.append(appsId);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}
	
}
