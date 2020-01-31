/**
 * PushedCampaign.java
 */
package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gnv.vnm.selfcare.core.enums.NotificationDisplayType;
import com.gnv.vnm.selfcare.core.enums.NotificationStatus;
import com.gnv.vnm.selfcare.core.enums.PushedCampaignType;

/**
 * @author nandipinto
 *
 */
public class PushedCampaign implements Serializable {

	private static final long serialVersionUID = 2685390065328191263L;

	//TODO remove JsongIgnore when mobile app is ready
	@JsonIgnore
	private Integer id;
	private String titleEN;
	private String descriptionEN;
	private String detailsEN;
	private String titleVI;
	private String descriptionVI;
	private String detailsVI;
	private String targetedUser;
	private Date startDate;
	private Date endDate;
	
	@JsonIgnore
	private PushedCampaignType type = PushedCampaignType.NEWS;
	@JsonIgnore
	private NotificationStatus status = NotificationStatus.UNREAD;
	@JsonIgnore
	private Integer sentCounter = 0;
	@JsonIgnore
	private NotificationDisplayType displayType = NotificationDisplayType.REGULAR;
	
	public PushedCampaign(){ }
	
	public PushedCampaign(Integer id, String titleEN, String descriptionEN, String detailsEN, String titleVI,
			String descriptionVI, String detailsVI, String targetedUser, Date startDate, Date endDate) {
		this.id = id;
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

	public PushedCampaign(String titleEN, String descriptionEN, String detailsEN, String titleVI,
			String descriptionVI, String detailsVI, String targetedUser, Date startDate, Date endDate) {
		
		this(null, titleEN, descriptionEN, detailsEN, titleVI, descriptionVI, detailsVI, targetedUser, startDate, endDate);
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

	/**
	 * @return the type
	 */
	public PushedCampaignType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(PushedCampaignType type) {
		this.type = type;
	}

	/**
	 * @return the status
	 */
	public NotificationStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(NotificationStatus status) {
		this.status = status;
	}

	/**
	 * @return the sentCounter
	 */
	public Integer getSentCounter() {
		return sentCounter;
	}

	/**
	 * @param sentCounter the sentCounter to set
	 */
	public void setSentCounter(Integer sentCounter) {
		this.sentCounter = sentCounter;
	}

	/**
	 * @return the displayType
	 */
	public NotificationDisplayType getDisplayType() {
		return displayType;
	}

	/**
	 * @param displayType the displayType to set
	 */
	public void setDisplayType(NotificationDisplayType displayType) {
		this.displayType = displayType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		PushedCampaign other = (PushedCampaign) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
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
		builder.append("PushedCampaign [id=");
		builder.append(id);
		builder.append(", titleEN=");
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
		builder.append(", type=");
		builder.append(type);
		builder.append(", status=");
		builder.append(status);
		builder.append(", sentCounter=");
		builder.append(sentCounter);
		builder.append(", displayType=");
		builder.append(displayType);
		builder.append("]");
		return builder.toString();
	}
}
