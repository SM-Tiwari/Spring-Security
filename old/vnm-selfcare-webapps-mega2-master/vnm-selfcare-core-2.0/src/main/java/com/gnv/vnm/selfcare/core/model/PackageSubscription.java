/**
 * PackageSubscription.java
 */
package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gnv.vnm.selfcare.core.enums.SubscriptionStatus;

/**
 * @author nandipinto
 *
 */
public class PackageSubscription implements Serializable {

	private static final long serialVersionUID = 494499593683924228L;

	private int id;
	private Product product;
	@JsonIgnore
	private Date startDate;
	private String startDateAsString = "";
	@JsonIgnore
	private Date endDate;
	private String endDateAsString = "";
	@JsonIgnore
	private Date expDate;
	private String expDateAsString = "";
	private SubscriptionStatus status;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}
	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
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
	 * @return the startDateAsString
	 */
	public String getStartDateAsString() {
		return startDateAsString;
	}
	/**
	 * @param startDateAsString the startDateAsString to set
	 */
	public void setStartDateAsString(String startDateAsString) {
		this.startDateAsString = startDateAsString;
	}
	/**
	 * @return the endDateAsString
	 */
	public String getEndDateAsString() {
		return endDateAsString;
	}
	/**
	 * @param endDateAsString the endDateAsString to set
	 */
	public void setEndDateAsString(String endDateAsString) {
		this.endDateAsString = endDateAsString;
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
	 * @return the expDateAsString
	 */
	public String getExpDateAsString() {
		return expDateAsString;
	}
	/**
	 * @param expDateAsString the expDateAsString to set
	 */
	public void setExpDateAsString(String expDateAsString) {
		this.expDateAsString = expDateAsString;
	}
	/**
	 * @return the status
	 */
	public SubscriptionStatus getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(SubscriptionStatus status) {
		this.status = status;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + id;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		PackageSubscription other = (PackageSubscription) obj;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (id != other.id)
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PackageSubscription [id=");
		builder.append(id);
		builder.append(", product=");
		builder.append(product);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append(", startDateAsString=");
		builder.append(startDateAsString);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append(", endDateAsString=");
		builder.append(endDateAsString);
		builder.append(", expDate=");
		builder.append(expDate);
		builder.append(", expDateAsString=");
		builder.append(expDateAsString);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}
	
	
}
