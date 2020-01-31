/**
 * 
 */
package com.gnv.vnm.selfcare.dao.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author nandipinto
 *
 */

@Entity
@Table(name = "content_subscription"/*, uniqueConstraints = {@UniqueConstraint(columnNames = "id")}*/)
@SequenceGenerator(name = "content_subs_seq", sequenceName = "content_subs_seq", allocationSize = 1)
public class ContentSubscriptionEntity extends BaseEntity {

	private static final long serialVersionUID = -6496561932309087830L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "content_subs_seq")
	@Column
	private Integer id;
	
	@Column(name = "start_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	
	@Column(name = "end_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	
	@Column(name = "exp_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date expDate;
	
	@Column(name = "unreg_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date unregisterDate;
	
	@Column(name = "status")
	private Integer status;

	@Column(name = "content_category_id")
	private Integer contentCategoryId;

	@Column(name = "content_id")
	private Integer contentId;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private SubscriberEntity subscriber;

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
	 * @return the expDate
	 */
	public Date getExpDate() {
		return expDate;
	}

	/**
	 * @param expDate the expDate to set
	 */
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	/**
	 * @return the unregisterDate
	 */
	public Date getUnregisterDate() {
		return unregisterDate;
	}

	/**
	 * @param unregisterDate the unregisterDate to set
	 */
	public void setUnregisterDate(Date unregisterDate) {
		this.unregisterDate = unregisterDate;
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
	 * @return the contentCategoryId
	 */
	public Integer getContentCategoryId() {
		return contentCategoryId;
	}

	/**
	 * @param contentCategoryId the contentCategoryId to set
	 */
	public void setContentCategoryId(Integer contentCategoryId) {
		this.contentCategoryId = contentCategoryId;
	}

	/**
	 * @return the contentId
	 */
	public Integer getContentId() {
		return contentId;
	}

	/**
	 * @param contentId the contentId to set
	 */
	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}

	/**
	 * @return the subscriber
	 */
	public SubscriberEntity getSubscriber() {
		return subscriber;
	}

	/**
	 * @param subscriber the subscriber to set
	 */
	public void setSubscriber(SubscriberEntity subscriber) {
		this.subscriber = subscriber;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((contentCategoryId == null) ? 0 : contentCategoryId.hashCode());
		result = prime * result + ((contentId == null) ? 0 : contentId.hashCode());
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
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContentSubscriptionEntity other = (ContentSubscriptionEntity) obj;
		if (contentCategoryId == null) {
			if (other.contentCategoryId != null)
				return false;
		} else if (!contentCategoryId.equals(other.contentCategoryId))
			return false;
		if (contentId == null) {
			if (other.contentId != null)
				return false;
		} else if (!contentId.equals(other.contentId))
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
		builder.append("ContentSubscriptionEntity [id=");
		builder.append(id);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append(", expDate=");
		builder.append(expDate);
		builder.append(", unregisterDate=");
		builder.append(unregisterDate);
		builder.append(", status=");
		builder.append(status);
		builder.append(", contentCategoryId=");
		builder.append(contentCategoryId);
		builder.append(", contentId=");
		builder.append(contentId);
		builder.append(", subscriber=");
		builder.append(subscriber != null ? subscriber.getMsisdn() : null);
		builder.append("]");
		return builder.toString();
	}
	
	


}
