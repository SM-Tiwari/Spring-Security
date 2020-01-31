/**
 * 
 */
package com.gnv.vnm.selfcare.dao.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
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
@Table(name = "product_subscription", indexes = {
		@Index(columnList = "product_id"), @Index(columnList = "subscriber_id"),
		@Index(columnList = "start_date") })
@SequenceGenerator(name = "product_subs_seq", sequenceName = "product_subs_seq", allocationSize = 1)
public class ProductSubscriptionEntity extends BaseEntity {

	private static final long serialVersionUID = -6496561932309087830L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_subs_seq")
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
	
	@ManyToOne//(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private ProductEntity product;
	
	@ManyToOne//(cascade=CascadeType.ALL)
	@JoinColumn(name = "subscriber_id", referencedColumnName = "id")
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
	 * @return the product
	 */
	public ProductEntity getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(ProductEntity product) {
		this.product = product;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((subscriber == null) ? 0 : subscriber.hashCode());
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
		ProductSubscriptionEntity other = (ProductSubscriptionEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.getId().equals(other.product.getId()))
			return false;
		if (subscriber == null) {
			if (other.subscriber != null)
				return false;
		} else if (!subscriber.getId().equals(other.subscriber.getId()))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductSubscriptionEntity [id=");
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
		builder.append(", product=");
		builder.append(product != null ? product.getCode() : null);
		builder.append(", subscriber=");
		builder.append(subscriber != null ? subscriber.getMsisdn() : null);
		builder.append("]");
		return builder.toString();
	}
	
	

}
