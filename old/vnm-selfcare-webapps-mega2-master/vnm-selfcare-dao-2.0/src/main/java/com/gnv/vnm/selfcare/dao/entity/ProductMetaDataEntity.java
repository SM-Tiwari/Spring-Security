/**
 * ProductMetaDataEntity.java
 */
package com.gnv.vnm.selfcare.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author nandipinto
 *
 */

@Entity
@Table(name = "product_metadata"/*, uniqueConstraints = {@UniqueConstraint(columnNames = "id")}*/)
@SequenceGenerator(name = "product_md_seq", sequenceName = "product_md_seq", allocationSize = 1)
public class ProductMetaDataEntity extends MetaDataEntity {

	private static final long serialVersionUID = 342133189832889674L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_md_seq")
	@Column(name = "id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private ProductEntity product;

	public ProductMetaDataEntity(){ }
	
	public ProductMetaDataEntity(String name, String value, Integer displayOrder) {
		super(name, value, displayOrder);
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

}
