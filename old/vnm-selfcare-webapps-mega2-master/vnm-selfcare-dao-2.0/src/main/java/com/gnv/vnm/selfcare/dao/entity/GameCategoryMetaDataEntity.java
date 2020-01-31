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
@Table(name = "game_category_metadata" /*, uniqueConstraints = {@UniqueConstraint(columnNames = "id")}*/)
@SequenceGenerator(name = "game_catmd_seq", sequenceName = "game_catmd_seq", allocationSize = 1)
public class GameCategoryMetaDataEntity extends MetaDataEntity {

	private static final long serialVersionUID = 3652370324241784348L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_catmd_seq")
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "game_cat_id", referencedColumnName = "id")
	private GameCategoryEntity category;

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
	public GameCategoryEntity getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(GameCategoryEntity category) {
		this.category = category;
	}


}
