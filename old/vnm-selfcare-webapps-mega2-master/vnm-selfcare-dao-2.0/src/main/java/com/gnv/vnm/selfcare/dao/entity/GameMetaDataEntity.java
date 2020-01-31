/**
 * ContentMetaDataEntity.java
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
@Table(name = "game_metadata" /*, uniqueConstraints = {@UniqueConstraint(columnNames = "id")}*/)
@SequenceGenerator(name = "game_md_seq", sequenceName = "game_md_seq", allocationSize = 1)
public class GameMetaDataEntity extends MetaDataEntity {

	private static final long serialVersionUID = -1111989255493093089L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_md_seq")
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "game_id", referencedColumnName = "id")
	private GameEntity game;

	public GameMetaDataEntity(){ }
	
	public GameMetaDataEntity(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	public GameMetaDataEntity(Integer id, String name, String value) {
		this.id = id;
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
	 * @return the game
	 */
	public GameEntity getGame() {
		return game;
	}

	/**
	 * @param game the game to set
	 */
	public void setGame(GameEntity game) {
		this.game = game;
	}
	
}