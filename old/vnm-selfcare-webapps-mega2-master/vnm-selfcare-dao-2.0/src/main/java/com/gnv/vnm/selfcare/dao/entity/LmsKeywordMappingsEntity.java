/**
 * 
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
@Table(name = "lms_keyword_mapping",  uniqueConstraints = { @UniqueConstraint(columnNames = "keyword") })
@SequenceGenerator(name = "lms_keyword_seq", sequenceName = "lms_keyword_seq", allocationSize = 1)
public class LmsKeywordMappingsEntity extends BaseEntity {

	private static final long serialVersionUID = -2552962419495410952L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lms_keyword_seq")
	@Column
	private Integer id;
	
	@Column(name = "keyword", length = 50, nullable = false)
	private String keyword;

	@Column(name = "unit_amount")
	private Integer unitAmount;

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
	public Integer getUnitAmount() {
		return unitAmount;
	}

	/**
	 * @param unitAmount the unitAmount to set
	 */
	public void setUnitAmount(Integer unitAmount) {
		this.unitAmount = unitAmount;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((keyword == null) ? 0 : keyword.hashCode());
		result = prime * result + ((unitAmount == null) ? 0 : unitAmount.hashCode());
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
		LmsKeywordMappingsEntity other = (LmsKeywordMappingsEntity) obj;
		if (keyword == null) {
			if (other.keyword != null)
				return false;
		} else if (!keyword.equals(other.keyword))
			return false;
		if (unitAmount == null) {
			if (other.unitAmount != null)
				return false;
		} else if (!unitAmount.equals(other.unitAmount))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LmsKeywordMappingsEntity [id=");
		builder.append(id);
		builder.append(", keyword=");
		builder.append(keyword);
		builder.append(", unitAmount=");
		builder.append(unitAmount);
		builder.append("]");
		return builder.toString();
	}
	
}
