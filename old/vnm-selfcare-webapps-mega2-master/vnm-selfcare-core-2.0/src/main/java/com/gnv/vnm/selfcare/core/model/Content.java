/**
 * 
 */
package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gnv.vnm.selfcare.core.enums.DataStatus;

/**
 * @author nandipIntegero
 *
 */
public abstract class Content implements Serializable {

	protected static final long serialVersionUID = -410337699408138565L;
	
	protected Integer id;
	protected Integer categoryId;
	protected String categoryNameEN;
	protected String categoryNameVI;
	protected String code;
	protected String nameEN;
	protected String titleEN;
	protected String descriptionEN;
	protected String nameVI;
	protected String titleVI;
	protected String descriptionVI;
	protected Double price;
	protected String previewURL;
	protected String sourceURL;
	protected String defaultIcon;
	protected String defaultImage;
	protected String defaultBanner;
	@JsonIgnore
	protected String webBanner;
	protected String smallIcon;
	protected String mediumIcon;
	protected String largeIcon;
	protected String xlargeIcon;
	protected String smallImage;
	protected String mediumImage;
	protected String largeImage;
	protected String xlargeImage;
	protected DataStatus status = DataStatus.ACTIVE;
	protected Map<String, String> metadata = new HashMap<String, String>();
	
	public Content(){ }
	
	public Content(Integer id, Integer categoryId, String code, String name, String title, String description,
			Double price, String previewURL, String sourceURL) {
		this.id = id;
		this.categoryId = categoryId;
		this.code = code;
		this.nameEN = name;
		this.titleEN = title;
		this.descriptionEN = description;
		this.price = price;
		this.previewURL = previewURL;
		this.sourceURL = sourceURL;
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
	 * @return the categoryNameEN
	 */
	public String getCategoryNameEN() {
		return categoryNameEN;
	}

	/**
	 * @param categoryNameEN the categoryNameEN to set
	 */
	public void setCategoryNameEN(String categoryName) {
		this.categoryNameEN = categoryName;
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
	public String getNameEN() {
		return nameEN;
	}

	/**
	 * @param name the name to set
	 */
	public void setNameEN(String name) {
		this.nameEN = name;
	}

	/**
	 * @return the titleEN
	 */
	public String getTitleEN() {
		return titleEN;
	}

	/**
	 * @param titleEN the titleEN to set
	 */
	public void setTitleEN(String title) {
		this.titleEN = title;
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
	 * @return the categoryNameVI
	 */
	public String getCategoryNameVI() {
		return categoryNameVI;
	}

	/**
	 * @param categoryNameVI the categoryNameVI to set
	 */
	public void setCategoryNameVI(String categoryNameVI) {
		this.categoryNameVI = categoryNameVI;
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
	 * @return the titleVI
	 */
	public String getTitleVI() {
		return titleVI;
	}

	/**
	 * @param titleVI the titleVI to set
	 */
	public void setTitleVI(String titleVI) {
		this.titleVI = titleVI;
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
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * @return the previewURL
	 */
	public String getPreviewURL() {
		return previewURL;
	}

	/**
	 * @param previewURL the previewURL to set
	 */
	public void setPreviewURL(String previewURL) {
		this.previewURL = previewURL;
	}

	/**
	 * @return the sourceURL
	 */
	public String getSourceURL() {
		return sourceURL;
	}

	/**
	 * @param sourceURL the sourceURL to set
	 */
	public void setSourceURL(String sourceURL) {
		this.sourceURL = sourceURL;
	}

	/**
	 * @return the defaultIcon
	 */
	public String getDefaultIcon() {
		return defaultIcon;
	}

	/**
	 * @param defaultIcon the defaultIcon to set
	 */
	public void setDefaultIcon(String defaultIcon) {
		this.defaultIcon = defaultIcon;
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
	 * @return the webBanner
	 */
	public String getWebBanner() {
		return webBanner;
	}

	/**
	 * @param webBanner the webBanner to set
	 */
	public void setWebBanner(String webBanner) {
		this.webBanner = webBanner;
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
	 * @return the status
	 */
	public DataStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(DataStatus status) {
		this.status = status;
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
		result = prime * result + categoryId;
		result = prime * result + id;
		result = prime * result + ((nameEN == null) ? 0 : nameEN.hashCode());
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
		Content other = (Content) obj;
		if (categoryId != other.categoryId)
			return false;
		if (id != other.id)
			return false;
		if (nameEN == null) {
			if (other.nameEN != null)
				return false;
		} else if (!nameEN.equals(other.nameEN))
			return false;
		return true;
	}
	
}
