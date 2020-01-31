/**
 * 
 */
package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;

/**
 * @author nandipinto
 *
 */
public class LmsKeywordMapping implements Serializable {

	private static final long serialVersionUID = -2597614492591201115L;
	
	private String keyword;
	private int unitAmount;
	
	public LmsKeywordMapping() { }
	public LmsKeywordMapping(String keyword, int unitAmount) {
		this.keyword = keyword;
		this.unitAmount = unitAmount;
	}
	/**
	 * @return the keyword
	 */
	public String getKeyword() {
		return keyword;
	}
	/**
	 * @param keyword the keyword to set
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	/**
	 * @return the unitAmount
	 */
	public int getUnitAmount() {
		return unitAmount;
	}
	/**
	 * @param unitAmount the unitAmount to set
	 */
	public void setUnitAmount(int unitAmount) {
		this.unitAmount = unitAmount;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((keyword == null) ? 0 : keyword.hashCode());
		result = prime * result + unitAmount;
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
		LmsKeywordMapping other = (LmsKeywordMapping) obj;
		if (keyword == null) {
			if (other.keyword != null)
				return false;
		} else if (!keyword.equals(other.keyword))
			return false;
		if (unitAmount != other.unitAmount)
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LmsKeywordMapping [keyword=");
		builder.append(keyword);
		builder.append(", unitAmount=");
		builder.append(unitAmount);
		builder.append("]");
		return builder.toString();
	}

}
