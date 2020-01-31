/**
 * PushedCampaignDTO.java
 */
package com.gnv.vnm.selfcare.webapi.model;

import java.io.Serializable;

/**
 * @author nandipinto
 *
 */
public class PushedCampaignDTO implements Serializable {

	private static final long serialVersionUID = 4157457800872983412L;
	
	private Integer id;
	private String titleEN;
	private String descriptionEN;
	private String detailsEN;
	private String titleVI;
	private String descriptionVI;
	private String detailsVI;
	private String targetedUser;
	private String startDate;
	private String endDate;

	public PushedCampaignDTO() {}

	public PushedCampaignDTO(String titleEN, String descriptionEN, String detailsEN, String titleVI,
			String descriptionVI, String detailsVI, String targetedUser, String startDate, String endDate) {
		this.titleEN = titleEN;
		this.descriptionEN = descriptionEN;
		this.detailsEN = detailsEN;
		this.titleVI = titleVI;
		this.descriptionVI = descriptionVI;
		this.detailsVI = detailsVI;
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
	 * @return the titleEN
	 */
	public String getTitleEN() {
		return titleEN;
	}

	/**
	 * @param titleEN the titleEN to set
	 */
	public void setTitleEN(String titleEN) {
		this.titleEN = titleEN;
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
	 * @return the detailsEN
	 */
	public String getDetailsEN() {
		return detailsEN;
	}

	/**
	 * @param detailsEN the detailsEN to set
	 */
	public void setDetailsEN(String detailsEN) {
		this.detailsEN = detailsEN;
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
	 * @return the detailsVI
	 */
	public String getDetailsVI() {
		return detailsVI;
	}

	/**
	 * @param detailsVI the detailsVI to set
	 */
	public void setDetailsVI(String detailsVI) {
		this.detailsVI = detailsVI;
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
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((titleEN == null) ? 0 : titleEN.hashCode());
		result = prime * result + ((titleVI == null) ? 0 : titleVI.hashCode());
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
		PushedCampaignDTO other = (PushedCampaignDTO) obj;
		if (titleEN == null) {
			if (other.titleEN != null)
				return false;
		} else if (!titleEN.equals(other.titleEN))
			return false;
		if (titleVI == null) {
			if (other.titleVI != null)
				return false;
		} else if (!titleVI.equals(other.titleVI))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PushedCampaignDTO [titleEN=");
		builder.append(titleEN);
		builder.append(", descriptionEN=");
		builder.append(descriptionEN);
		builder.append(", detailsEN=");
		builder.append(detailsEN);
		builder.append(", titleVI=");
		builder.append(titleVI);
		builder.append(", descriptionVI=");
		builder.append(descriptionVI);
		builder.append(", detailsVI=");
		builder.append(detailsVI);
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
