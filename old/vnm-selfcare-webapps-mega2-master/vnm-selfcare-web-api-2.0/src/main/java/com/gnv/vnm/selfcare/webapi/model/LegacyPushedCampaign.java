/**
 * 
 */
package com.gnv.vnm.selfcare.webapi.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author nandipinto
 *
 */
public class LegacyPushedCampaign implements Serializable {

	private static final long serialVersionUID = -5460193153191604968L;

	private Integer id;
	private String code;
	private String nameEN;
	private String descriptionEN;
	private String nameVI;
	private String descriptionVI;
	@JsonIgnore
	private byte[] imageStream;
	private String base64EncodedImage; //Base64 encoded string representation of the image
	private String targetedUser;
	private Date startDate;
	private Date endDate;
	
	public LegacyPushedCampaign(){ }
	
	public LegacyPushedCampaign(Integer id, String productCode, String productName, String description,
			String targetedUser, Date startDate, Date endDate) {
		this.id = id;
		this.code = productCode;
		this.nameEN = productName;
		this.descriptionEN = description;
		this.targetedUser = targetedUser;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public LegacyPushedCampaign(String productCode, String productName, String description,
			String targetedUser, Date startDate, Date endDate) {
		this(null, productCode, productName, description, targetedUser, startDate, endDate);
	}
	
	public LegacyPushedCampaign(Integer id, String productCode, String productNameEN, String descriptionEN,
			String productNameVI, String productDescriptionVI, String targetedUser, Date startDate,
			Date endDate) {
		this.id = id;
		this.code = productCode;
		this.nameEN = productNameEN;
		this.descriptionEN = descriptionEN;
		this.nameVI = productNameVI;
		this.descriptionVI = productDescriptionVI;
		this.targetedUser = targetedUser;
		this.startDate = startDate;
		this.endDate = endDate;
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
	public void setCode(String productCode) {
		this.code = productCode;
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
	public void setNameEN(String productName) {
		this.nameEN = productName;
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
	public void setNameVI(String productNameVI) {
		this.nameVI = productNameVI;
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
	public void setDescriptionVI(String productDescriptionVI) {
		this.descriptionVI = productDescriptionVI;
	}

	/**
	 * @return the imageStream
	 */
	public byte[] getImageStream() {
		return imageStream;
	}
	/**
	 * @param imageStream the imageStream to set
	 */
	public void setImageStream(byte[] productImage) {
		this.imageStream = productImage;
	}
	/**
	 * @return the base64EncodedImage
	 */
	public String getBase64EncodedImage() {
		return base64EncodedImage;
	}
	/**
	 * @param base64EncodedImage the base64EncodedImage to set
	 */
	public void setBase64EncodedImage(String encodedImage) {
		this.base64EncodedImage = encodedImage;
	}

	/**
	 * @return the targetedUser
	 */
	public String getTargetedUser() {
		return targetedUser;
	}
	/**
	 * @param targetedUser the targetedUser to set
	 */
	public void setTargetedUser(String targetedUser) {
		this.targetedUser = targetedUser;
	}
	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		LegacyPushedCampaign other = (LegacyPushedCampaign) obj;
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
		builder.append("PushedCampaign [id=");
		builder.append(id);
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
		builder.append(", imageStream=");
		builder.append(Arrays.toString(imageStream));
		builder.append(", targetedUser=");
		builder.append(targetedUser);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append("]");
		return builder.toString();
	}

}
