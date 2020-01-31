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
@Table(name = "product_cat_metadata"/*, uniqueConstraints = {@UniqueConstraint(columnNames = "id")}*/)
@SequenceGenerator(name = "prodcat_md_seq", sequenceName = "prodcat_md_seq", allocationSize = 1)
public class ProductCategoryMetaDataEntity extends MetaDataEntity {

	private static final long serialVersionUID = 342133189832889674L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prodcat_md_seq")
	@Column(name = "id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "product_cat_id", referencedColumnName = "id")
	private ProductCategoryEntity productCategory;

	public ProductCategoryMetaDataEntity(){ }

	public ProductCategoryMetaDataEntity(String name, String value, Integer displayOrder) {
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
	 * @return the productCategory
	 */
	public ProductCategoryEntity getProductCategory() {
		return productCategory;
	}

	/**
	 * @param productCategory the productCategory to set
	 */
	public void setProductCategory(ProductCategoryEntity productCategory) {
		this.productCategory = productCategory;
	}

}
