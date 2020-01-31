/**
 * PromotedProductEntity.java
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
@Table(name = "promoted_product", indexes = {
		@Index(columnList = "product_id"), @Index(columnList = "start_date") })
@SequenceGenerator(name = "promoted_prod_seq", sequenceName = "promoted_prod_seq", allocationSize = 1)
public class PromotedProductEntity extends BaseEntity {

	private static final long serialVersionUID = -3080748379661711623L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "promoted_prod_seq")
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne //(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private ProductEntity product;
	
	@Column(name = "start_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	
	@Column(name = "end_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	
	@Column(name = "status")
	private Integer status;
	
	public PromotedProductEntity(){ }

	/**
	 * @param id
	 * @param product
	 * @param startDate
	 * @param endDate
	 * @param status
	 */
	public PromotedProductEntity(Integer id, ProductEntity product, Date startDate, Date endDate, Integer status) {
		this.id = id;
		this.product = product;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
	}

	/**
	 * @param product
	 * @param startDate
	 * @param endDate
	 * @param status
	 */
	public PromotedProductEntity(ProductEntity product, Date startDate, Date endDate, Integer status) {
		this.product = product;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
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
		PromotedProductEntity other = (PromotedProductEntity) obj;
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
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PromotedProductEntity [id=");
		builder.append(id);
		builder.append(", product=");
		builder.append(product != null ? product.getId() : null);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}
	
}