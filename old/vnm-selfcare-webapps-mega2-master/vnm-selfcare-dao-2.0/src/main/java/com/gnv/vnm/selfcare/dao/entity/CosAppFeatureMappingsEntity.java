/**
 * Apr 22, 2018 9:47:17 AM
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
@Table(name = "cos_feature_mapping")
@SequenceGenerator(name = "cfm_seq", sequenceName = "cfm_seq", allocationSize = 1)
public class CosAppFeatureMappingsEntity extends BaseEntity {

	private static final long serialVersionUID = 456171053121421764L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cfm_seq")	
	@Column
	private Integer id;

	@Column(name = "cos_name", length = 100)
	private String cosName;

	@Column(name = "disabled_feature", length = 100)
	private String disabledFeatureName;

	public CosAppFeatureMappingsEntity() {}
	
	public CosAppFeatureMappingsEntity(Integer id, String cosName, String disabledFeatureName) {
		this.id = id;
		this.cosName = cosName;
		this.disabledFeatureName = disabledFeatureName;
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
	 * @return the cosName
	 */
	public String getCosName() {
		return cosName;
	}

	/**
	 * @param cosName the cosName to set
	 */
	public void setCosName(String cosName) {
		this.cosName = cosName;
	}

	/**
	 * @return the disabledFeatureName
	 */
	public String getDisabledFeatureName() {
		return disabledFeatureName;
	}

	/**
	 * @param disabledFeatureName the disabledFeatureName to set
	 */
	public void setDisabledFeatureName(String disabledFeatureName) {
		this.disabledFeatureName = disabledFeatureName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cosName == null) ? 0 : cosName.hashCode());
		result = prime * result + ((disabledFeatureName == null) ? 0 : disabledFeatureName.hashCode());
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
		CosAppFeatureMappingsEntity other = (CosAppFeatureMappingsEntity) obj;
		if (cosName == null) {
			if (other.cosName != null)
				return false;
		} else if (!cosName.equals(other.cosName))
			return false;
		if (disabledFeatureName == null) {
			if (other.disabledFeatureName != null)
				return false;
		} else if (!disabledFeatureName.equals(other.disabledFeatureName))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CosAppFeatureMappingsEntity [id=");
		builder.append(id);
		builder.append(", cosName=");
		builder.append(cosName);
		builder.append(", disabledFeatureName=");
		builder.append(disabledFeatureName);
		builder.append("]");
		return builder.toString();
	}

	
}
