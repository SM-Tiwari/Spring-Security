/**
 * MusicEntity.java
 */
package com.gnv.vnm.selfcare.dao.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * @author nandipinto
 *
 */

@Entity
@Table(name = "movie", uniqueConstraints = {/* @UniqueConstraint(columnNames = "id"),*/ @UniqueConstraint(columnNames = "code") })
@SequenceGenerator(name = "movie_seq", sequenceName = "movie_seq", allocationSize = 1)
public class MovieEntity extends BaseEntity {

	private static final long serialVersionUID = -5316773010939117030L;

	//PRODUCT_ID	PRODUCT_NAME_EN	PRODUCT_NAME_VN	DISPLAY_NAME_VN	DISPLAY_NAME_VN	DESCRIPTION_EN	
	//DESCRIPTION_VN	DIRECTOR	ACTORS	LENGTH	YEAR	CAETEGORY	SUB_CATEGORY	 PRICE 	PRODUCT_URL	PRODUCT_IMAGE
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_seq")
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "code", length = 20, nullable = false)
	private String code;
	
	@Column(name = "name_en")
	private String productNameEN;
	
	@Column(name = "name_vi")
	private String productNameVI;
	
	@Column(name = "display_name_en")
	private String displayNameEN;
	
	@Column(name = "display_name_vi")
	private String displayNameVI;
	
	@Lob
	@Column(name = "description_en")
	private String descriptionEN;

	@Lob
	@Column(name = "description_vi")
	private String descriptionVI;
	
	@Lob
	@Column(name = "storyline_en")
	private String storyLineEN;

	@Lob
	@Column(name = "storyline_vi")
	private String storyLineVI;

	@Column(name = "price", precision = 10, scale = 2)
	private BigDecimal price;
	
	@Column(name = "status")//, columnDefinition = "NUMBER(1,0)")
	private Integer status = 1;
	
	@Column(name = "preview_url")
	private String previewURL;
	
	@Column(name = "source_url")
	private String sourceURL;

	@Column(name = "directors")
	private String directors;
	
	@Column(name = "writers")
	private String writers;
	
	@Column(name = "producers")
	private String producers;
	
	@Column(name = "actors")
	private String actors;
	
	@Column(name = "duration")
	private Long duration = 0L;
	
	@Column(name = "release_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date releaseDate;
	
	@Column(name = "default_icon", length = 500)
	private String defaultIcon;

	@Column(name = "default_image", length = 500)
	private String defaultImage;
	
	@Column(name = "default_banner", length = 500)
	private String defaultBanner;

	@Column(name = "default_web_banner", length = 500)
	private String defaultWebBanner;

	@ManyToOne
	@JoinColumn(name = "movie_cat_id", referencedColumnName = "id")
	private MovieCategoryEntity category;

	@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval=true)
	Set<MovieMetaDataEntity> metadata = new HashSet<>();

	public MovieEntity() {
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
	 * @return the productNameEN
	 */
	public String getProductNameEN() {
		return productNameEN;
	}

	/**
	 * @param productNameEN the productNameEN to set
	 */
	public void setProductNameEN(String productNameEN) {
		this.productNameEN = productNameEN;
	}

	/**
	 * @return the productNameVI
	 */
	public String getProductNameVI() {
		return productNameVI;
	}

	/**
	 * @param productNameVI the productNameVI to set
	 */
	public void setProductNameVI(String productNameVI) {
		this.productNameVI = productNameVI;
	}

	/**
	 * @return the displayNameEN
	 */
	public String getDisplayNameEN() {
		return displayNameEN;
	}

	/**
	 * @param displayNameEN the displayNameEN to set
	 */
	public void setDisplayNameEN(String displayNameEN) {
		this.displayNameEN = displayNameEN;
	}

	/**
	 * @return the displayNameVI
	 */
	public String getDisplayNameVI() {
		return displayNameVI;
	}

	/**
	 * @param displayNameVI the displayNameVI to set
	 */
	public void setDisplayNameVI(String displayNameVI) {
		this.displayNameVI = displayNameVI;
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
	 * @return the storyLineEN
	 */
	public String getStoryLineEN() {
		return storyLineEN;
	}

	/**
	 * @param storyLineEN the storyLineEN to set
	 */
	public void setStoryLineEN(String storyLineEN) {
		this.storyLineEN = storyLineEN;
	}

	/**
	 * @return the storyLineVI
	 */
	public String getStoryLineVI() {
		return storyLineVI;
	}

	/**
	 * @param storyLineVI the storyLineVI to set
	 */
	public void setStoryLineVI(String storyLineVI) {
		this.storyLineVI = storyLineVI;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the previewURL
	 */
	public String getPreviewURL() {
		return previewURL;
	}

	/**
	 * @param previewURL the previewURL to set
	 */
	public void setPreviewURL(String previewURL) {
		this.previewURL = previewURL;
	}

	/**
	 * @return the sourceURL
	 */
	public String getSourceURL() {
		return sourceURL;
	}

	/**
	 * @param sourceURL the sourceURL to set
	 */
	public void setSourceURL(String sourceURL) {
		this.sourceURL = sourceURL;
	}

	/**
	 * @return the directors
	 */
	public String getDirectors() {
		return directors;
	}

	/**
	 * @param directors the directors to set
	 */
	public void setDirectors(String directors) {
		this.directors = directors;
	}

	/**
	 * @return the writers
	 */
	public String getWriters() {
		return writers;
	}

	/**
	 * @param writers the writers to set
	 */
	public void setWriters(String writers) {
		this.writers = writers;
	}

	/**
	 * @return the producers
	 */
	public String getProducers() {
		return producers;
	}

	/**
	 * @param producers the producers to set
	 */
	public void setProducers(String producers) {
		this.producers = producers;
	}

	/**
	 * @return the actors
	 */
	public String getActors() {
		return actors;
	}

	/**
	 * @param actors the actors to set
	 */
	public void setActors(String actors) {
		this.actors = actors;
	}

	/**
	 * @return the duration
	 */
	public Long getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(Long duration) {
		this.duration = duration;
	}

	/**
	 * @return the releaseDate
	 */
	public Date getReleaseDate() {
		return releaseDate;
	}

	/**
	 * @param releaseDate the releaseDate to set
	 */
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
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
	public void setDefaultBanner(String bannerImage) {
		this.defaultBanner = bannerImage;
	}

	/**
	 * @return the defaultWebBanner
	 */
	public String getDefaultWebBanner() {
		return defaultWebBanner;
	}

	/**
	 * @param defaultWebBanner the defaultWebBanner to set
	 */
	public void setDefaultWebBanner(String webBanner) {
		this.defaultWebBanner = webBanner;
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
	 * @return the category
	 */
	public MovieCategoryEntity getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(MovieCategoryEntity category) {
		this.category = category;
	}

	/**
	 * @return the metadata
	 */
	public Set<MovieMetaDataEntity> getMetadata() {
		return metadata;
	}

	/**
	 * @param metadata the metadata to set
	 */
	public void setMetadata(Set<MovieMetaDataEntity> metadata) {
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
		MovieEntity other = (MovieEntity) obj;
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
		builder.append("MovieEntity [id=");
		builder.append(id);
		builder.append(", code=");
		builder.append(code);
		builder.append(", productNameEN=");
		builder.append(productNameEN);
		builder.append(", productNameVI=");
		builder.append(productNameVI);
		builder.append(", displayNameEN=");
		builder.append(displayNameEN);
		builder.append(", displayNameVI=");
		builder.append(displayNameVI);
		builder.append(", descriptionEN=");
		builder.append(descriptionEN);
		builder.append(", descriptionVI=");
		builder.append(descriptionVI);
		builder.append(", storyLineEN=");
		builder.append(storyLineEN);
		builder.append(", storyLineVI=");
		builder.append(storyLineVI);
		builder.append(", price=");
		builder.append(price);
		builder.append(", status=");
		builder.append(status);
		builder.append(", previewURL=");
		builder.append(previewURL);
		builder.append(", sourceURL=");
		builder.append(sourceURL);
		builder.append(", directors=");
		builder.append(directors);
		builder.append(", writers=");
		builder.append(writers);
		builder.append(", producers=");
		builder.append(producers);
		builder.append(", actors=");
		builder.append(actors);
		builder.append(", duration=");
		builder.append(duration);
		builder.append(", releaseDate=");
		builder.append(releaseDate);
		builder.append(", defaultIcon=");
		builder.append(defaultIcon);
		builder.append(", defaultImage=");
		builder.append(defaultImage);
		builder.append(", category=");
		builder.append(category);
		builder.append(", metadata=");
		builder.append(metadata);
		builder.append("]");
		return builder.toString();
	}

}
