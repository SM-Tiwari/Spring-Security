/**
 * ProductGroup.java
 */
package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author nandipinto
 *
 */
public class ProductGroup implements Serializable {

	private static final long serialVersionUID = -6233346552017820865L;

	private Integer id;
	private Integer categoryId;
	private String categoryCode;
	private String categoryName;
	private String code;
	private String name;
	private String description;
	private Integer displayOrder;
	private String smallIcon;
	private String mediumIcon;
	private String largeIcon;
	private String xlargeIcon;
	private String smallImage;
	private String mediumImage;
	private String largeImage;
	private String xlargeImage;
	@JsonIgnore
	private String defaultImage;
	@JsonIgnore
	private String defaultBanner;

	private Map<String, String> metadata = new HashMap<String, String>();
	
	public ProductGroup(){ }

	public ProductGroup(Integer id, Integer categoryId, String code, String name, String description) {
		this.id = id;
		this.categoryId = categoryId;
		this.code = code;
		this.name = name;
		this.description = description;
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
	 * @return the categoryId
	 */
	public Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the categoryCode
	 */
	public String getCategoryCode() {
		return categoryCode;
	}

	/**
	 * @param categoryCode the categoryCode to set
	 */
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	/**
	 * @return the categoryNameEN
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryNameEN the categoryNameEN to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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

	/**
	 * @return the displayOrder
	 */
	public Integer getDisplayOrder() {
		return displayOrder;
	}

	/**
	 * @param displayOrder the displayOrder to set
	 */
	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
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
	 * @return the xlargeIcon
	 */
	public String getXlargeIcon() {
		return xlargeIcon;
	}

	/**
	 * @param xlargeIcon the xlargeIcon to set
	 */
	public void setXlargeIcon(String xlargeIcon) {
		this.xlargeIcon = xlargeIcon;
	}

	/**
	 * @return the smallImage
	 */
	public String getSmallImage() {
		return smallImage;
	}

	/**
	 * @param smallImage the smallImage to set
	 */
	public void setSmallImage(String smallImage) {
		this.smallImage = smallImage;
	}

	/**
	 * @return the mediumImage
	 */
	public String getMediumImage() {
		return mediumImage;
	}

	/**
	 * @param mediumImage the mediumImage to set
	 */
	public void setMediumImage(String mediumImage) {
		this.mediumImage = mediumImage;
	}

	/**
	 * @return the largeImage
	 */
	public String getLargeImage() {
		return largeImage;
	}

	/**
	 * @param largeImage the largeImage to set
	 */
	public void setLargeImage(String largeImage) {
		this.largeImage = largeImage;
	}

	/**
	 * @return the xlargeImage
	 */
	public String getXlargeImage() {
		return xlargeImage;
	}

	/**
	 * @param xlargeImage the xlargeImage to set
	 */
	public void setXlargeImage(String xlargeImage) {
		this.xlargeImage = xlargeImage;
	}

	/**
	 * @return the defaultImage
	 */
	public String getDefaultImage() {
		return defaultImage;
	}

	/**
	 * @param defaultImage the defaultImage to set
	 */
	public void setDefaultImage(String defaultImage) {
		this.defaultImage = defaultImage;
	}

	/**
	 * @return the defaultBanner
	 */
	public String getDefaultBanner() {
		return defaultBanner;
	}

	/**
	 * @param defaultBanner the defaultBanner to set
	 */
	public void setDefaultBanner(String defaultBanner) {
		this.defaultBanner = defaultBanner;
	}

	/**
	 * @return the metadata
	 */
	public Map<String, String> getMetadata() {
		return metadata;
	}

	/**
	 * @param metadata the metadata to set
	 */
	public void setMetadata(Map<String, String> metadata) {
		this.metadata = metadata;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ProductGroup other = (ProductGroup) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductGroup [id=");
		builder.append(id);
		builder.append(", categoryId=");
		builder.append(categoryId);
		builder.append(", categoryCode=");
		builder.append(categoryCode);
		builder.append(", categoryNameEN=");
		builder.append(categoryName);
		builder.append(", code=");
		builder.append(code);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append(", displayOrder=");
		builder.append(displayOrder);
		builder.append(", smallIcon=");
		builder.append(smallIcon);
		builder.append(", mediumIcon=");
		builder.append(mediumIcon);
		builder.append(", largeIcon=");
		builder.append(largeIcon);
		builder.append(", xlargeIcon=");
		builder.append(xlargeIcon);
		builder.append(", smallImage=");
		builder.append(smallImage);
		builder.append(", mediumImage=");
		builder.append(mediumImage);
		builder.append(", largeImage=");
		builder.append(largeImage);
		builder.append(", xlargeImage=");
		builder.append(xlargeImage);
		builder.append(", defaultImage=");
		builder.append(defaultImage);
		builder.append(", defaultBanner=");
		builder.append(defaultBanner);
		builder.append(", metadata=");
		builder.append(metadata);
		builder.append("]");
		return builder.toString();
	}
	
}
