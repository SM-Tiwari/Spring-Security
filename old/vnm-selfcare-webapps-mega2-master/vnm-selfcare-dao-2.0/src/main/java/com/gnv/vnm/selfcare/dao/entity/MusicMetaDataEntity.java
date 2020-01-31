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
@Table(name = "music_metadata"/*, uniqueConstraints = {@UniqueConstraint(columnNames = "id")}*/)
@SequenceGenerator(name = "music_md_seq", sequenceName = "music_md_seq", allocationSize = 1)
public class MusicMetaDataEntity extends MetaDataEntity {

	private static final long serialVersionUID = -1111989255493093089L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "music_md_seq")
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "music_id", referencedColumnName = "id")
	private MusicEntity music;

	public MusicMetaDataEntity(){ }
	
	public MusicMetaDataEntity(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	public MusicMetaDataEntity(Integer id, String name, String value) {
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
	 * @return the music
	 */
	public MusicEntity getMusic() {
		return music;
	}

	/**
	 * @param music the music to set
	 */
	public void setMusic(MusicEntity music) {
		this.music = music;
	}

	
}
