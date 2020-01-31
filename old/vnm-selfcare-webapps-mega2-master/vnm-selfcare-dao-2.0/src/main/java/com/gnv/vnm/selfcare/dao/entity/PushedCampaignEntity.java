/**
 * PushedCampaignEntity.java
 */
package com.gnv.vnm.selfcare.dao.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author nandipinto
 *
 */

@Entity
@Table(name = "pushed_campaign", indexes = { @Index(columnList = "target_msisdn") })
@SequenceGenerator(name = "pushed_camp_seq", sequenceName = "pushed_camp_seq", allocationSize = 1)
public class PushedCampaignEntity extends BaseEntity {

	private static final long serialVersionUID = -3651221074584216847L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pushed_camp_seq")
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "title_en")
	private String titleEN;
	
	@Column(name = "desc_en")
	private String descriptionEN;

	@Column(name = "details_en", length = 1000)
	private String detailsEN;

	@Column(name = "title_vi")
	private String titleVI;
	
	@Column(name = "desc_vi")
	private String descriptionVI;

	@Column(name = "details_vi", length = 1000)
	private String detailsVI;

	@Column(name = "target_msisdn", length = 20)
	private String targetedUser;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_date")
	private Date startDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_date")
	private Date endDate;

	@Column(name = "image_url", length = 1000)
	private String imageURL;
	
	@Column(name = "type")
	private Integer type = 0;
	
	@Column(name = "status")
	private Integer status = 0;

	@Column(name = "sent_counter")
	private Integer sentCounter = 0;
	
//	@Column(name = "sent_status")
//	private Integer sentStatus = 0;
	
	@Column(name = "display_type")
	private Integer displayType = 0;
	
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
	 * @return the imageURL
	 */
	public String getImageURL() {
		return imageURL;
	}

	/**
	 * @param imageURL the imageURL to set
	 */
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	/**
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
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

//	/**
//	 * @return the sentStatus
//	 */
//	public Integer getSentStatus() {
//		return sentStatus;
//	}
//
//	/**
//	 * @param sentStatus the sentStatus to set
//	 */
//	public void setSentStatus(Integer sentStatus) {
//		this.sentStatus = sentStatus;
//	}

	/**
	 * @return the displayType
	 */
	public Integer getDisplayType() {
		return displayType;
	}

	/**
	 * @param displayType the displayType to set
	 */
	public void setDisplayType(Integer displayType) {
		this.displayType = displayType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
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
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PushedCampaignEntity other = (PushedCampaignEntity) obj;
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
		builder.append("PushedCampaignEntity [id=");
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
		builder.append(", imageURL=");
		builder.append(imageURL);
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
