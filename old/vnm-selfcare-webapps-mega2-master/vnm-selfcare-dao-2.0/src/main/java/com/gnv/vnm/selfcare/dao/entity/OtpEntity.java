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
@Table(name = "otp", uniqueConstraints = {/*@UniqueConstraint(columnNames = "id"), */@UniqueConstraint(columnNames = "subscriber_id")})
@SequenceGenerator(name = "otp_seq", sequenceName = "otp_seq", allocationSize = 1)
public class OtpEntity extends BaseEntity {

	private static final long serialVersionUID = -189136718357159610L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "otp_seq")
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "subscriber_id", length = 16)
	private String subscriberId;
	
	@Column(name = "secret_key", length = 20)
	private String key;
	
	@Column(name = "status")
	private Integer status = 0;
	
	public OtpEntity(){ }

	/**
	 * @param id
	 * @param key
	 * @param status
	 */
	public OtpEntity(Integer id, String key, Integer status) {
		this.id = id;
		this.key = key;
		this.status = status;
	}

	/**
	 * 
	 * @param subscriberId
	 * @param key
	 * @param status
	 */
	public OtpEntity(String subscriberId, String key, Integer status) {
		this.subscriberId = subscriberId;
		this.key = key;
		this.status = status;
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
	 * @return the subscriberId
	 */
	public String getSubscriberId() {
		return subscriberId;
	}

	/**
	 * @param subscriberId the subscriberId to set
	 */
	public void setSubscriberId(String subscriberId) {
		this.subscriberId = subscriberId;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
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
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((subscriberId == null) ? 0 : subscriberId.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
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
		OtpEntity other = (OtpEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (subscriberId == null) {
			if (other.subscriberId != null)
				return false;
		} else if (!subscriberId.equals(other.subscriberId))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OtpEntity [id=");
		builder.append(id);
		builder.append(", subscriberId=");
		builder.append(subscriberId);
		builder.append(", key=");
		builder.append(key);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}
	
}
