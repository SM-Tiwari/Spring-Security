/**
 * MetaDataEntity.java
 */
package com.gnv.vnm.selfcare.dao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @author nandipinto
 *
 */

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class}) 
public class MetaDataEntity implements Serializable, Comparable<MetaDataEntity>{

	private static final long serialVersionUID = 1262479567953962761L;
	
	@Column(name = "name", nullable = false)
	protected String name;
	
	@Lob
	@Column(name = "value")
	protected String value;
	
	@Column(name = "display_order")
	protected Integer displayOrder = 0;

	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_timestamp", updatable = false, nullable = false)
	protected Date createTimestamp = new Date();
	
	@CreatedBy
	@Column(name = "created_by", nullable = false)
	private String createdBy;
	
	@Version
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_modified_timestamp", nullable = false)
	protected Date lastModifiedTime;
	
	@LastModifiedBy
    @Column(name = "last_modified_by", nullable = false)
	protected String lastModifiedBy;

	public MetaDataEntity(){}
	
	public MetaDataEntity(String name, String value, Integer displayOrder) {
		this.name = name;
		this.value = value;
		this.displayOrder = displayOrder;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the displayOrder
	 */
	public Integer getDisplayOrder() {
		return displayOrder;
	}

	/**
	 * @param displayOrder the displayOrder to set
	 */
	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}

	/**
	 * @return the createTimestamp
	 */
	public Date getCreateTimestamp() {
		return createTimestamp;
	}

	/**
	 * @param createTimestamp the createTimestamp to set
	 */
	public void setCreateTimestamp(Date createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the lastModifiedTime
	 */
	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}

	/**
	 * @param lastModifiedTime the lastModifiedTime to set
	 */
	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	/**
	 * @return the lastModifiedBy
	 */
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	/**
	 * @param lastModifiedBy the lastModifiedBy to set
	 */
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MetaDataEntity other = (MetaDataEntity) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MetaDataEntity [name=");
		builder.append(name);
		builder.append(", value=");
		builder.append(value);
		builder.append(", displayOrder=");
		builder.append(displayOrder);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(MetaDataEntity o) {
		return this.name.compareToIgnoreCase(o.getName());
	}

}
