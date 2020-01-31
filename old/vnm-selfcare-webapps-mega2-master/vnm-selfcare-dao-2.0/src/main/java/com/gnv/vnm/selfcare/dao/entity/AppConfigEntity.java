/**
 * AppConfigEntity.java
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
@Table(name = "app_config", uniqueConstraints = { @UniqueConstraint(columnNames = "name")})
@SequenceGenerator(name = "app_config_seq", sequenceName = "app_config_seq", allocationSize = 1)
public class AppConfigEntity extends BaseEntity {

	private static final long serialVersionUID = -6505269836605209639L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "app_config_seq")	
	@Column(name = "id")
	private Integer id;
	
	@Column(nullable = false, unique=true)
	private String name;
	
	@Column
	private String value;

	@Column(name = "is_flag")
	private Integer isFlag;
	
	@Column(name = "description")
	private String description;
	
	public AppConfigEntity(){ }
	
	public AppConfigEntity(String name, String value){
		this.name = name;
		this.value = value;
	}

	/**
	 * @param id
	 * @param name
	 * @param isFlag
	 * @param value
	 */
	public AppConfigEntity(Integer id, String name, String value, Integer isFlag) {
		this.id = id;
		this.name = name;
		this.value = value;
		this.isFlag = isFlag;
	}

	/**
	 * @param name
	 * @param isFlag
	 * @param value
	 */
	public AppConfigEntity(String name, String value, Integer isFlag) {
		this.name = name;
		this.isFlag = isFlag;
		this.value = value;
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
	 * @return the isFlag
	 */
	public Integer getIsFlag() {
		return isFlag;
	}

	/**
	 * @param isFlag the isFlag to set
	 */
	public void setIsFlag(Integer isFlag) {
		this.isFlag = isFlag;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		AppConfigEntity other = (AppConfigEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AppConfigEntity [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", value=");
		builder.append(value);
		builder.append(", isFlag=");
		builder.append(isFlag);
		builder.append(", description=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
	}
	
}
