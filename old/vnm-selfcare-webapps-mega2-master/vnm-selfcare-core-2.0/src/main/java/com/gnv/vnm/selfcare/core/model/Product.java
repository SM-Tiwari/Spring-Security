/**
 * Product.java
 */
package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gnv.vnm.selfcare.core.enums.DataStatus;

/**
 * @author nandipinto
 *
 */
public class Product implements Serializable {

	private static final long serialVersionUID = 5100107805265556353L;

	private Integer id = -1;
	private String code = "";
	private String alias = "";
	private String name = "";
	private String description = "";
	private String details = "";
	private String howToRegister = "";
	private String howToUnregister = "";
	private DataStatus status = DataStatus.INACTIVE;
	private double price = 0;
	private Integer categoryId = -1;
	private String categoryCode = "";
	private Integer productGroupId = -1;
	private String productGroupName = "";
	private String smallIcon = "";
	private String mediumIcon = "";
	private String largeIcon = "";
	private String xlargeIcon = "";
	private String smallImage = "";
	private String mediumImage = "";
	private String largeImage = "";
	private String xlargeImage = "";
	private String defaultImage = "";
	private String defaultBanner = "";
	
	//ignore this for the time being so mobile app not affected - 20170526
	@JsonIgnore
	private String quota;
	@JsonIgnore
	private Date validFromDate;
	@JsonIgnore
	private Date validToDate;
	@JsonIgnore
	private boolean purchaseEnabled = true;
	
	private Map<String, String> metadata = new HashMap<String, String>();
	
	public Product(){ }

	public Product(Integer id, String code, String name, String description, String details, DataStatus status,
			double price) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.details = details;
		this.status = status;
		this.price = price;
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
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * @param alias the alias to set
	 */
	public void setAlias(String alias) {
		this.alias = alias;
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
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * @param details the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}

	/**
	 * @return the howToRegister
	 */
	public String getHowToRegister() {
		return howToRegister;
	}

	/**
	 * @param howToRegister the howToRegister to set
	 */
	public void setHowToRegister(String registrationInstruction) {
		this.howToRegister = registrationInstruction;
	}

	/**
	 * @return the howToUnregister
	 */
	public String getHowToUnregister() {
		return howToUnregister;
	}

	/**
	 * @param howToUnregister the howToUnregister to set
	 */
	public void setHowToUnregister(String howToUnregister) {
		this.howToUnregister = howToUnregister;
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
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
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
	 * @return the productGroupId
	 */
	public Integer getProductGroupId() {
		return productGroupId;
	}

	/**
	 * @param productGroupId the productGroupId to set
	 */
	public void setProductGroupId(Integer productGroupId) {
		this.productGroupId = productGroupId;
	}

	/**
	 * @return the productGroupName
	 */
	public String getProductGroupName() {
		return productGroupName;
	}

	/**
	 * @param productGroupName the productGroupName to set
	 */
	public void setProductGroupName(String productGroupName) {
		this.productGroupName = productGroupName;
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
	 * @return the validFromDate
	 */
	public Date getValidFromDate() {
		return validFromDate;
	}

	/**
	 * @param validFromDate the validFromDate to set
	 */
	public void setValidFromDate(Date validFromDate) {
		this.validFromDate = validFromDate;
	}

	/**
	 * @return the validToDate
	 */
	public Date getValidToDate() {
		return validToDate;
	}

	/**
	 * @param validToDate the validToDate to set
	 */
	public void setValidToDate(Date validToDate) {
		this.validToDate = validToDate;
	}

	/**
	 * @return the quota
	 */
	public String getQuota() {
		return quota;
	}

	/**
	 * @param quota the quota to set
	 */
	public void setQuota(String quota) {
		this.quota = quota;
	}

	/**
	 * @return the purchaseEnabled
	 */
	public boolean isPurchaseEnabled() {
		return purchaseEnabled;
	}

	/**
	 * @param purchaseEnabled the purchaseEnabled to set
	 */
	public void setPurchaseEnabled(boolean purchaseEnabled) {
		this.purchaseEnabled = purchaseEnabled;
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
		Product other = (Product) obj;
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
		builder.append("Product [id=");
		builder.append(id);
		builder.append(", code=");
		builder.append(code);
		builder.append(", alias=");
		builder.append(alias);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append(", details=");
		builder.append(details);
		builder.append(", howToRegister=");
		builder.append(howToRegister);
		builder.append(", howToUnregister=");
		builder.append(howToUnregister);
		builder.append(", status=");
		builder.append(status);
		builder.append(", price=");
		builder.append(price);
		builder.append(", categoryId=");
		builder.append(categoryId);
		builder.append(", categoryCode=");
		builder.append(categoryCode);
		builder.append(", productGroupId=");
		builder.append(productGroupId);
		builder.append(", productGroupName=");
		builder.append(productGroupName);
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
		builder.append(", quota=");
		builder.append(quota);
		builder.append(", validFromDate=");
		builder.append(validFromDate);
		builder.append(", validToDate=");
		builder.append(validToDate);
		builder.append(", metadata=");
		builder.append(metadata);
		builder.append("]");
		return builder.toString();
	}

}
