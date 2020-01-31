/**
 * SubscriberRegistrationCounterEntity.java
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
@Table(name = "subscriber_reg_ctr", uniqueConstraints = {/* @UniqueConstraint(columnNames = "id"), */ @UniqueConstraint(columnNames = "app_src_id")})
@SequenceGenerator(name = "subscriber_reg_seq", sequenceName = "subscriber_reg_seq", allocationSize = 1)
public class SubscriberRegistrationCounterEntity extends BaseEntity {

	private static final long serialVersionUID = -3261140536024615604L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subscriber_reg_seq")
	@Column
	private Integer id;

	@Column(name = "app_src_id", length = 20)
	private String appSourceId;
	
	private Integer count = 0;

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
	 * @return the appSourceId
	 */
	public String getAppSourceId() {
		return appSourceId;
	}

	/**
	 * @param appSourceId the appSourceId to set
	 */
	public void setAppSourceId(String appSourceId) {
		this.appSourceId = appSourceId;
	}

	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((appSourceId == null) ? 0 : appSourceId.hashCode());
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		SubscriberRegistrationCounterEntity other = (SubscriberRegistrationCounterEntity) obj;
		if (appSourceId == null) {
			if (other.appSourceId != null)
				return false;
		} else if (!appSourceId.equals(other.appSourceId))
			return false;
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
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SubscriberRegistrationCounterEntity [id=");
		builder.append(id);
		builder.append(", appSourceId=");
		builder.append(appSourceId);
		builder.append(", count=");
		builder.append(count);
		builder.append("]");
		return builder.toString();
	}

}
