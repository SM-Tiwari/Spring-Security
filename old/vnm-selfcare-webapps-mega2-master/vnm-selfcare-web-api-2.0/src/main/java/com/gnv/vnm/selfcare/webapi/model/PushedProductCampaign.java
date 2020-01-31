/**
 * PushedProductCampaign.java
 */
package com.gnv.vnm.selfcare.webapi.model;

import java.io.Serializable;

/**
 * @author nandipinto
 *
 */
public class PushedProductCampaign implements Serializable {

	private static final long serialVersionUID = 4683824375907702731L;

	private String code;
	private String nameEN;
	private String descriptionEN;
	private String nameVI;
	private String descriptionVI;
	private String image; //encoded Base64 String
	
	public PushedProductCampaign(){ }
	
	public PushedProductCampaign(String code, String name, String description) {
		this.code = code;
		this.nameEN = name;
		this.descriptionEN = description;
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
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PushedProductCampaign [code=");
		builder.append(code);
		builder.append(", nameEN=");
		builder.append(nameEN);
		builder.append(", descriptionEN=");
		builder.append(descriptionEN);
		builder.append(", nameVI=");
		builder.append(nameVI);
		builder.append(", descriptionVI=");
		builder.append(descriptionVI);
		builder.append(", image=");
		builder.append(image);
		builder.append("]");
		return builder.toString();
	}

}
