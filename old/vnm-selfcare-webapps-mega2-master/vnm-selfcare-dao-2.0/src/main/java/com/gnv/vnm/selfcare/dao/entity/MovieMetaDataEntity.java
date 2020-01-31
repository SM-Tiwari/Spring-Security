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
@Table(name = "movie_metadata"/*, uniqueConstraints = {@UniqueConstraint(columnNames = "id")}*/)
@SequenceGenerator(name = "movie_md_seq", sequenceName = "movie_md_seq", allocationSize = 1)
public class MovieMetaDataEntity extends MetaDataEntity {

	private static final long serialVersionUID = -1111989255493093089L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_md_seq")
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "movie_id", referencedColumnName = "id")
	private MovieEntity movie;

	public MovieMetaDataEntity(){ }
	
	public MovieMetaDataEntity(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	public MovieMetaDataEntity(Integer id, String name, String value) {
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
	 * @return the movie
	 */
	public MovieEntity getMovie() {
		return movie;
	}

	/**
	 * @param movie the movie to set
	 */
	public void setMovie(MovieEntity movie) {
		this.movie = movie;
	}
	
}
