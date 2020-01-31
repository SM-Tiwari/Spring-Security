/**
 * AppConfig.java
 */
package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;

/**
 * @author nandipinto
 *
 */
public class AppConfig implements Serializable {

	private static final long serialVersionUID = 4274771300502967783L;

	private Integer id;
	private String name;
	private String value;
	private boolean isFlag;
	
	public AppConfig(){ }

	/**
	 * @param name
	 * @param isFlag
	 * @param value
	 */
	public AppConfig(String name, String value, boolean isFlag) {
		this.name = name;
		this.isFlag = isFlag;
		this.value = value;
	}

	/**
	 * @param id
	 * @param name
	 * @param isFlag
	 * @param value
	 */
	public AppConfig(Integer id, String name, String value, boolean isFlag) {
		this(name, value, isFlag);
		this.id = id;
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
	 * @return the isFlag
	 */
	public boolean isFlag() {
		return isFlag;
	}

	/**
	 * @param isFlag the isFlag to set
	 */
	public void setFlag(boolean isFlag) {
		this.isFlag = isFlag;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AppConfig other = (AppConfig) obj;
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
		builder.append("AppConfig [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", value=");
		builder.append(value);
		builder.append(", isFlag=");
		builder.append(isFlag);
		builder.append("]");
		return builder.toString();
	}
	
	
}
