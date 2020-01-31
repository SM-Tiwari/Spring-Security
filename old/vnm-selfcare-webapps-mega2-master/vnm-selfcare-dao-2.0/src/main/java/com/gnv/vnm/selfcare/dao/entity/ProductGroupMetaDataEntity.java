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
@Table(name = "product_group_metadata"/*, uniqueConstraints = {@UniqueConstraint(columnNames = "id")}*/)
@SequenceGenerator(name = "pgroup_md_seq", sequenceName = "pgroup_md_seq", allocationSize = 1)
public class ProductGroupMetaDataEntity extends MetaDataEntity {

	private static final long serialVersionUID = 342133189832889674L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pgroup_md_seq")
	@Column(name = "id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "product_group_id", referencedColumnName = "id")
	private ProductGroupEntity productGroup;

	public ProductGroupMetaDataEntity(){ }
	
	public ProductGroupMetaDataEntity(Integer id, String name, String value, ProductGroupEntity productGroup) {
		this.id = id;
		this.name = name;
		this.value = value;
		this.productGroup = productGroup;
	}

	/**
	 * @param id
	 * @param name
	 * @param value
	 */
	public ProductGroupMetaDataEntity(Integer id, String name, String value) {
		this.id = id;
		this.name = name;
		this.value = value;
	}

	/**
	 * @param name
	 * @param value
	 */
	public ProductGroupMetaDataEntity(String name, String value) {
		this.name = name;
		this.value = value;
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
	 * @return the productGroup
	 */
	public ProductGroupEntity getProductGroup() {
		return productGroup;
	}

	/**
	 * @param productGroup the productGroup to set
	 */
	public void setProductGroup(ProductGroupEntity productGroup) {
		this.productGroup = productGroup;
	}

}
