/**
 * ExtAuthTokenEntity.java
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
 * @author nandipinto
 *
 */

@Entity
@Table(name = "ext_app_token")
@SequenceGenerator(name = "token_seq", sequenceName = "token_seq", allocationSize = 1)
public class ExtAuthTokenEntity extends BaseEntity {

	private static final long serialVersionUID = 3506312027714344388L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "token_seq")
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "ext_app_id", length = 50)
	private String extAppId;
	
	@Column(name = "secret_key")
	private String secretKey;

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
	 * @return the extAppId
	 */
	public String getExtAppId() {
		return extAppId;
	}

	/**
	 * @param extAppId the extAppId to set
	 */
	public void setExtAppId(String extAppId) {
		this.extAppId = extAppId;
	}

	/**
	 * @return the secretKey
	 */
	public String getSecretKey() {
		return secretKey;
	}

	/**
	 * @param secretKey the secretKey to set
	 */
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((extAppId == null) ? 0 : extAppId.hashCode());
		result = prime * result + ((secretKey == null) ? 0 : secretKey.hashCode());
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
		ExtAuthTokenEntity other = (ExtAuthTokenEntity) obj;
		if (extAppId == null) {
			if (other.extAppId != null)
				return false;
		} else if (!extAppId.equals(other.extAppId))
			return false;
		if (secretKey == null) {
			if (other.secretKey != null)
				return false;
		} else if (!secretKey.equals(other.secretKey))
			return false;
		return true;
	}

}
