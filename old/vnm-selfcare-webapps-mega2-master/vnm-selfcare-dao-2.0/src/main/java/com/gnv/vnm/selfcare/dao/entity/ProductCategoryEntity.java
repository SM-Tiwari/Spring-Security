/**
 * ProductCategoryEntity.java
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

import org.hibernate.annotations.OrderBy;

/**
 * @author nandipinto
 *
 */

@Entity
@Table(name = "product_category", uniqueConstraints = { /*@UniqueConstraint(columnNames = "id"), */@UniqueConstraint(columnNames = "code") })
@SequenceGenerator(name = "pcat_seq", sequenceName = "pcat_seq", allocationSize = 1)
public class ProductCategoryEntity extends BaseEntity {

	private static final long serialVersionUID = 2596877506309566578L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pcat_seq")
	@Column(name = "id")
	private Integer id;

	@Column(name = "parent_cat_id")
	private Integer parentCategoryId;
	
	@Column(name = "code", nullable = false, length = 50)
	private String code;
	
	@Column(name = "name_en", length = 500)
	private String nameEN;
	
	@Column(name = "name_vi", length = 500)
	private String nameVI;

	@Column(name = "description_en", length = 1000)
	private String descriptionEN;

	@Column(name = "description_vi", length = 1000)
	private String descriptionVI;

	@Column(name = "default_icon", length = 1000)
	private String defaultIcon;

	@Column(name = "default_image", length = 1000)
	private String defaultImage;

	@Column(name = "default_banner", length = 1000)
	private String defaultBanner;

	@OneToMany(mappedBy = "productCategory", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval=true)
	@OrderBy(clause = "name ASC")
	Set<ProductCategoryMetaDataEntity> metadata = new HashSet<>();

	public ProductCategoryEntity(){ }

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
	 * @return the descriptionEN
	 */
	public String getDescriptionEN() {
		return descriptionEN;
	}

	/**
	 * @param descriptionEN the descriptionEN to set
	 */
	public void setDescriptionEN(String descriptionEN) {
		this.descriptionEN = descriptionEN;
	}

	/**
	 * @return the descriptionVI
	 */
	public String getDescriptionVI() {
		return descriptionVI;
	}

	/**
	 * @param descriptionVI the descriptionVI to set
	 */
	public void setDescriptionVI(String descriptionVI) {
		this.descriptionVI = descriptionVI;
	}

	/**
	 * @return the defaultIcon
	 */
	public String getDefaultIcon() {
		return defaultIcon;
	}

	/**
	 * @param defaultIcon the defaultIcon to set
	 */
	public void setDefaultIcon(String defaultIcon) {
		this.defaultIcon = defaultIcon;
	}

	/**
	 * @return the defaultImage
	 */
	public String getDefaultImage() {
		return defaultImage;
	}

	/**
	 * @param defaultImage the defaultImage to set
	 */
	public void setDefaultImage(String defaultImage) {
		this.defaultImage = defaultImage;
	}

	/**
	 * @return the defaultBanner
	 */
	public String getDefaultBanner() {
		return defaultBanner;
	}

	/**
	 * @param defaultBanner the defaultBanner to set
	 */
	public void setDefaultBanner(String defaultBanner) {
		this.defaultBanner = defaultBanner;
	}

	/**
	 * @return the metadata
	 */
	public Set<ProductCategoryMetaDataEntity> getMetadata() {
		return metadata;
	}

	/**
	 * @param metadata the metadata to set
	 */
	public void setMetadata(Set<ProductCategoryMetaDataEntity> metadata) {
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
		ProductCategoryEntity other = (ProductCategoryEntity) obj;
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
		builder.append("ProductCategoryEntity [id=");
		builder.append(id);
		builder.append(", parentCategoryId=");
		builder.append(parentCategoryId);
		builder.append(", code=");
		builder.append(code);
		builder.append(", nameEN=");
		builder.append(nameEN);
		builder.append(", nameVI=");
		builder.append(nameVI);
		builder.append(", descriptionEN=");
		builder.append(descriptionEN);
		builder.append(", descriptionVI=");
		builder.append(descriptionVI);
		builder.append(", defaultIcon=");
		builder.append(defaultIcon);
		builder.append(", defaultImage=");
		builder.append(defaultImage);
		builder.append(", defaultBanner=");
		builder.append(defaultBanner);
		builder.append(", metadata=");
		builder.append(metadata);
		builder.append("]");
		return builder.toString();
	}

}
