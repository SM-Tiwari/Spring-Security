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
@Table(name = "transaction_history", 
indexes = {
		@Index(columnList = "subscriber_id"), @Index(columnList = "product_id"), @Index(columnList = "content_id"),
		@Index(columnList = "trx_date") })
@SequenceGenerator(name = "trx_hist_seq", sequenceName = "trx_hist_seq", allocationSize = 1)
public class TransactionHistoryEntity extends BaseEntity {

	private static final long serialVersionUID = -7228649917030112468L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trx_hist_seq")
	@Column
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "subscriber_id", referencedColumnName = "id")
	private SubscriberEntity subscriber;
	
	@Column(name = "product_id")
	private Integer productId;
	
	@Column(name = "product_code", length = 20)
	private String productCode;
	
	@Column(name = "content_category_id")
	private Integer contentCategoryId;

	@Column(name = "content_id")
	private Integer contentId;
	
	@Column(name = "content_code", length = 20)
	private String contentCode;
	
	@Column(name = "payment_method")
	private Integer paymentMethod;
	
	@Column(name = "trx_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date trxDate;

	@Column(name = "trx_status")
	private Integer status;

	@Column(name = "client_app_id")
	private String clientAppId;

	public TransactionHistoryEntity(){ }

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

	/**
	 * @return the productId
	 */
	public Integer getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
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
	 * @return the paymentMethod
	 */
	public Integer getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * @param paymentMethod the paymentMethod to set
	 */
	public void setPaymentMethod(Integer paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	/**
	 * @return the trxDate
	 */
	public Date getTrxDate() {
		return trxDate;
	}

	/**
	 * @param trxDate the trxDate to set
	 */
	public void setTrxDate(Date trxDate) {
		this.trxDate = trxDate;
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
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**
	 * @return the contentCode
	 */
	public String getContentCode() {
		return contentCode;
	}

	/**
	 * @param contentCode the contentCode to set
	 */
	public void setContentCode(String contentCode) {
		this.contentCode = contentCode;
	}
	
	/**
	 * @return the clientAppId
	 */
	public String getClientAppId() {
		return clientAppId;
	}

	/**
	 * @param clientAppId the clientAppId to set
	 */
	public void setClientAppId(String clientAppId) {
		this.clientAppId = clientAppId;
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
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
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
		TransactionHistoryEntity other = (TransactionHistoryEntity) obj;
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
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TransactionHistoryEntity [id=");
		builder.append(id);
		builder.append(", subscriber=");
		builder.append(subscriber);
		builder.append(", productId=");
		builder.append(productId);
		builder.append(", productCode=");
		builder.append(productCode);
		builder.append(", contentCategoryId=");
		builder.append(contentCategoryId);
		builder.append(", contentId=");
		builder.append(contentId);
		builder.append(", contentCode=");
		builder.append(contentCode);
		builder.append(", paymentMethod=");
		builder.append(paymentMethod);
		builder.append(", trxDate=");
		builder.append(trxDate);
		builder.append(", status=");
		builder.append(status);
		builder.append(", clientAppId=");
		builder.append(clientAppId);
		builder.append("]");
		return builder.toString();
	}
	
	
}
