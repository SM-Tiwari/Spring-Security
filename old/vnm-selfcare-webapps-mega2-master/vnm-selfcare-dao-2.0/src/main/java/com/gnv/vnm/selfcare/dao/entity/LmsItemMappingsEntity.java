/**
 * LmsItemMappingsEntity.java
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
@Table(name = "lms_item_mapping",  uniqueConstraints = {/* @UniqueConstraint(columnNames = "id"), */ @UniqueConstraint(columnNames = "keyword") })
@SequenceGenerator(name = "lms_seq", sequenceName = "lms_seq", allocationSize = 1)
public class LmsItemMappingsEntity extends BaseEntity {

	private static final long serialVersionUID = -1758838390954123960L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lms_seq")
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "keyword", length = 50, nullable = false)
	private String keyword;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "display_name_en")
	private String displayNameEN;
	
	@Column(name = "display_name_vi")
	private String displayNameVI;
	
	@Column(name = "monster_weight")
	private Integer monsterWeight;
	
	@Column(name = "monster_img")
	private String monsterImage;

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
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the displayNameEN
	 */
	public String getDisplayNameEN() {
		return displayNameEN;
	}

	/**
	 * @param displayNameEN the displayNameEN to set
	 */
	public void setDisplayNameEN(String displayNameEN) {
		this.displayNameEN = displayNameEN;
	}

	/**
	 * @return the displayNameVI
	 */
	public String getDisplayNameVI() {
		return displayNameVI;
	}

	/**
	 * @param displayNameVI the displayNameVI to set
	 */
	public void setDisplayNameVI(String displayNameVI) {
		this.displayNameVI = displayNameVI;
	}

	/**
	 * @return the monsterWeight
	 */
	public Integer getMonsterWeight() {
		return monsterWeight;
	}

	/**
	 * @param monsterWeight the monsterWeight to set
	 */
	public void setMonsterWeight(Integer monsterWeight) {
		this.monsterWeight = monsterWeight;
	}

	/**
	 * @return the monsterImage
	 */
	public String getMonsterImage() {
		return monsterImage;
	}

	/**
	 * @param monsterImage the monsterImage to set
	 */
	public void setMonsterImage(String monsterImage) {
		this.monsterImage = monsterImage;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((keyword == null) ? 0 : keyword.hashCode());
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
		LmsItemMappingsEntity other = (LmsItemMappingsEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (keyword == null) {
			if (other.keyword != null)
				return false;
		} else if (!keyword.equals(other.keyword))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LmsItemMappingsEntity [id=");
		builder.append(id);
		builder.append(", keyword=");
		builder.append(keyword);
		builder.append(", productName=");
		builder.append(productName);
		builder.append(", displayNameEN=");
		builder.append(displayNameEN);
		builder.append(", displayNameVI=");
		builder.append(displayNameVI);
		builder.append(", monsterWeight=");
		builder.append(monsterWeight);
		builder.append(", monsterImage=");
		builder.append(monsterImage);
		builder.append("]");
		return builder.toString();
	}

}
