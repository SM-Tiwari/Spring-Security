/**
 * 
 */
package com.gnv.vnm.selfcare.dao.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author nandipinto
 *
 */

@Entity
@Table(name = "movie_category", uniqueConstraints = {/* @UniqueConstraint(columnNames = "id"),*/ @UniqueConstraint(columnNames = "code") })
@SequenceGenerator(name = "movie_cat_seq", sequenceName = "movie_cat_seq", allocationSize = 1)
public class MovieCategoryEntity extends BaseEntity {

	private static final long serialVersionUID = 3198139394854056739L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_cat_seq")
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "parent_cat_id")
	private Integer parentCategoryId;
	
	@Column(name = "code", nullable = false)
	private String code;
	
	@Column(name = "name_en")
	private String nameEN;
	
	@Column(name = "name_vi")
	private String nameVI;
	
	@Column(name = "display_order")
	private Integer displayOrder = 0;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval=true)
	Set<MovieCategoryMetaDataEntity> metadata = new HashSet<>();

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
	 * @return the parentCategoryId
	 */
	public Integer getParentCategoryId() {
		return parentCategoryId;
	}

	/**
	 * @param parentCategoryId the parentCategoryId to set
	 */
	public void setParentCategoryId(Integer parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the nameEN
	 */
	public String getNameEN() {
		return nameEN;
	}

	/**
	 * @param nameEN the nameEN to set
	 */
	public void setNameEN(String nameEN) {
		this.nameEN = nameEN;
	}

	/**
	 * @return the nameVI
	 */
	public String getNameVI() {
		return nameVI;
	}

	/**
	 * @param nameVI the nameVI to set
	 */
	public void setNameVI(String nameVI) {
		this.nameVI = nameVI;
	}

	/**
	 * @return the displayOrder
	 */
	public Integer getDisplayOrder() {
		return displayOrder;
	}

	/**
	 * @param displayOrder the displayOrder to set
	 */
	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}

	/**
	 * @return the metadata
	 */
	public Set<MovieCategoryMetaDataEntity> getMetadata() {
		return metadata;
	}

	/**
	 * @param metadata the metadata to set
	 */
	public void setMetadata(Set<MovieCategoryMetaDataEntity> metadata) {
		this.metadata = metadata;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		MovieCategoryEntity other = (MovieCategoryEntity) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MovieCategoryEntity [id=");
		builder.append(id);
		builder.append(", parentCategoryId=");
		builder.append(parentCategoryId);
		builder.append(", code=");
		builder.append(code);
		builder.append(", nameEN=");
		builder.append(nameEN);
		builder.append(", nameVI=");
		builder.append(nameVI);
		builder.append(", metadata=");
		builder.append(metadata);
		builder.append("]");
		return builder.toString();
	}
	
}
