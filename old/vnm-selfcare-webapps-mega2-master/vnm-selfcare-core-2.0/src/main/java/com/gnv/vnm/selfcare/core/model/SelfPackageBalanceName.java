/**
 * 
 */
package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;

/**
 * @author nandipinto
 *
 */
public class SelfPackageBalanceName implements Serializable {

	private static final long serialVersionUID = 2026321871267340412L;

	private String name;
	private String descriptionEN;
	private String descriptionVI;
	
	public SelfPackageBalanceName() { }

	public SelfPackageBalanceName(String name, String descriptionEN, String descriptionVI) {
		this.name = name;
		this.descriptionEN = descriptionEN;
		this.descriptionVI = descriptionVI;
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
	 * @return the descriptionEN
	 */
	public String getDescriptionEN() {
		return descriptionEN;
	}

	/**
	 * @param descriptionEN the descriptionEN to set
	 */
	public void setDescriptionEN(String descriptionEN) {
		this.descriptionEN = descriptionEN;
	}

	/**
	 * @return the descriptionVI
	 */
	public String getDescriptionVI() {
		return descriptionVI;
	}

	/**
	 * @param descriptionVI the descriptionVI to set
	 */
	public void setDescriptionVI(String descriptionVI) {
		this.descriptionVI = descriptionVI;
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
		SelfPackageBalanceName other = (SelfPackageBalanceName) obj;
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
		builder.append("SelfPackageBalanceName [name=");
		builder.append(name);
		builder.append(", descriptionEN=");
		builder.append(descriptionEN);
		builder.append(", descriptionVI=");
		builder.append(descriptionVI);
		builder.append("]");
		return builder.toString();
	}
	
	
}
