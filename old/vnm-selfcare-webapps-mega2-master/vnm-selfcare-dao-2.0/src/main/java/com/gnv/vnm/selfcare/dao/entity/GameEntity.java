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
@Table(name = "game", uniqueConstraints = {/* @UniqueConstraint(columnNames = "id"), */ @UniqueConstraint(columnNames = "code") })
@SequenceGenerator(name = "game_seq", sequenceName = "game_seq", allocationSize = 1)
public class GameEntity extends BaseEntity {

	private static final long serialVersionUID = -5316773010939117030L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_seq")
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
	
	@Column(name = "notes_en")
	private String notesEN;
	
	@Column(name = "notes_vi")
	private String notesVI;
	
	@Column(name = "price", precision = 10, scale = 2)
	private BigDecimal price;
	
	@Column(name = "status")//, columnDefinition = "NUMBER(1,0)")
	private Integer status = 1;
	
	@Column(name = "preview_url")
	private String previewURL;
	
	@Column(name = "android_source_url")
	private String androidSourceURL;

	@Column(name = "ios_source_url")
	private String iosSourceURL;

	@Column(name = "producers")
	private String producers;
	
	@Column(name = "version")
	private String version;
	
	@Column(name = "file_size")
	private Long fileSize = 0L;
	
	@Column(name = "supported_systems")
	private String supportedSystems;
	
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
	@JoinColumn(name = "game_cat_id", referencedColumnName = "id")
	private GameCategoryEntity category;

	@OneToMany(mappedBy = "game", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval=true)
	Set<GameMetaDataEntity> metadata = new HashSet<>();

	public GameEntity() {
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
	 * @return the notesEN
	 */
	public String getNotesEN() {
		return notesEN;
	}

	/**
	 * @param notesEN the notesEN to set
	 */
	public void setNotesEN(String notesEN) {
		this.notesEN = notesEN;
	}

	/**
	 * @return the notesVI
	 */
	public String getNotesVI() {
		return notesVI;
	}

	/**
	 * @param notesVI the notesVI to set
	 */
	public void setNotesVI(String notesVI) {
		this.notesVI = notesVI;
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
	 * @return the androidSourceURL
	 */
	public String getAndroidSourceURL() {
		return androidSourceURL;
	}

	/**
	 * @param androidSourceURL the androidSourceURL to set
	 */
	public void setAndroidSourceURL(String sourceURL) {
		this.androidSourceURL = sourceURL;
	}

	/**
	 * @return the iosSourceURL
	 */
	public String getIosSourceURL() {
		return iosSourceURL;
	}

	/**
	 * @param iosSourceURL the iosSourceURL to set
	 */
	public void setIosSourceURL(String iosSourceURL) {
		this.iosSourceURL = iosSourceURL;
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
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the fileSize
	 */
	public Long getFileSize() {
		return fileSize;
	}

	/**
	 * @param fileSize the fileSize to set
	 */
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	/**
	 * @return the supportedSystems
	 */
	public String getSupportedSystems() {
		return supportedSystems;
	}

	/**
	 * @param supportedSystems the supportedSystems to set
	 */
	public void setSupportedSystems(String supportedSystems) {
		this.supportedSystems = supportedSystems;
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

	/**
	 * @return the metadata
	 */
	public Set<GameMetaDataEntity> getMetadata() {
		return metadata;
	}

	/**
	 * @param metadata the metadata to set
	 */
	public void setMetadata(Set<GameMetaDataEntity> metadata) {
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
		GameEntity other = (GameEntity) obj;
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
		builder.append("GameEntity [id=");
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
		builder.append(", notesEN=");
		builder.append(notesEN);
		builder.append(", notesVI=");
		builder.append(notesVI);
		builder.append(", price=");
		builder.append(price);
		builder.append(", status=");
		builder.append(status);
		builder.append(", previewURL=");
		builder.append(previewURL);
		builder.append(", androidSourceURL=");
		builder.append(androidSourceURL);
		builder.append(", producers=");
		builder.append(producers);
		builder.append(", version=");
		builder.append(version);
		builder.append(", fileSize=");
		builder.append(fileSize);
		builder.append(", supportedSystems=");
		builder.append(supportedSystems);
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
