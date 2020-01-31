/**
 * ContentCategory.java
 */
package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author nandipinto
 *
 */
public class ContentCategory implements Serializable {

	private static final long serialVersionUID = 80847540945601279L;

	protected Integer id;
	protected Integer parentCategoryId;
	protected String code;
	protected String nameEN;
	protected String descriptionEN;
	protected String nameVI;
	protected String descriptionVI;
	protected String smallIcon;
	protected String mediumIcon;
	protected String largeIcon;
	@JsonIgnore
	protected boolean visible = true;
	@JsonIgnore
	protected int itemCount = 0;

	protected List<ContentCategory> subCategories = new ArrayList<>();
	
	public ContentCategory(){ }
	
	public ContentCategory(Integer id, Integer parentCategoryId, String code) {
		this.id = id;
		this.parentCategoryId = parentCategoryId;
		this.code = code;
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
	 * @return the parentCategoryId
	 */
	public Integer getParentCategoryId() {
		return parentCategoryId;
	}

	/**
	 * @param parentCategoryId the parentCategoryId to set
	 */
	public void setParentCategoryId(Integer parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the nameEN
	 */
	public String getNameEN() {
		return nameEN;
	}

	/**
	 * @param nameEN the nameEN to set
	 */
	public void setNameEN(String name) {
		this.nameEN = name;
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
	public void setDescriptionEN(String description) {
		this.descriptionEN = description;
	}

	/**
	 * @return the nameVI
	 */
	public String getNameVI() {
		return nameVI;
	}

	/**
	 * @param nameVI the nameVI to set
	 */
	public void setNameVI(String nameVI) {
		this.nameVI = nameVI;
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

	/**
	 * @return the smallIcon
	 */
	public String getSmallIcon() {
		return smallIcon;
	}

	/**
	 * @param smallIcon the smallIcon to set
	 */
	public void setSmallIcon(String smallIcon) {
		this.smallIcon = smallIcon;
	}

	/**
	 * @return the mediumIcon
	 */
	public String getMediumIcon() {
		return mediumIcon;
	}

	/**
	 * @param mediumIcon the mediumIcon to set
	 */
	public void setMediumIcon(String mediumIcon) {
		this.mediumIcon = mediumIcon;
	}

	/**
	 * @return the largeIcon
	 */
	public String getLargeIcon() {
		return largeIcon;
	}

	/**
	 * @param largeIcon the largeIcon to set
	 */
	public void setLargeIcon(String largeIcon) {
		this.largeIcon = largeIcon;
	}

	/**
	 * @return the subCategories
	 */
	public List<ContentCategory> getSubCategories() {
		return subCategories;
	}

	/**
	 * @param subCategories the subCategories to set
	 */
	public void setSubCategories(List<ContentCategory> subCategories) {
		this.subCategories = subCategories;
	}

	/**
	 * @return the visible
	 */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * @param visible the visible to set
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	/**
	 * @return the itemCount
	 */
	public int getItemCount() {
		return itemCount;
	}

	/**
	 * @param itemCount the itemCount to set
	 */
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
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
		ContentCategory other = (ContentCategory) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContentCategory [id=");
		builder.append(id);
		builder.append(", parentCategoryId=");
		builder.append(parentCategoryId);
		builder.append(", code=");
		builder.append(code);
		builder.append(", nameEN=");
		builder.append(nameEN);
		builder.append(", descriptionEN=");
		builder.append(descriptionEN);
		builder.append(", nameVI=");
		builder.append(nameVI);
		builder.append(", descriptionVI=");
		builder.append(descriptionVI);
		builder.append(", smallIcon=");
		builder.append(smallIcon);
		builder.append(", mediumIcon=");
		builder.append(mediumIcon);
		builder.append(", largeIcon=");
		builder.append(largeIcon);
		builder.append(", visible=");
		builder.append(visible);
		builder.append(", subCategories=");
		builder.append(subCategories);
		builder.append("]");
		return builder.toString();
	}

}
