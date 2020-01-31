/**
 * ContentCategoryMetaDataEntity.java
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
@Table(name = "apps_category_metadata") //, uniqueConstraints = {@UniqueConstraint(columnNames = "id")}
@SequenceGenerator(name = "apps_catmd_seq", sequenceName = "apps_catmd_seq", allocationSize = 1)
public class AppsCategoryMetaDataEntity extends MetaDataEntity {

	private static final long serialVersionUID = 3652370324241784348L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "apps_catmd_seq")
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "apps_cat_id", referencedColumnName = "id")
	private AppsCategoryEntity category;

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
	 * @return the category
	 */
	public AppsCategoryEntity getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(AppsCategoryEntity category) {
		this.category = category;
	}


}
