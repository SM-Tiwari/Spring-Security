/**
 * AvatarEntity.java
 */
package com.gnv.vnm.selfcare.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author nandipinto
 *
 */

@Entity
@Table(name = "avatar" /*, uniqueConstraints = { @UniqueConstraint(columnNames = "id") }*/, indexes = {
		@Index(columnList = "title"), @Index(columnList = "category") })
@SequenceGenerator(name = "avatar_seq", sequenceName = "avatar_seq", allocationSize = 1)
public class AvatarEntity extends BaseEntity {

	private static final long serialVersionUID = 1534631728972903518L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "avatar_seq")
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "file_name")
	private String fileName;
	
	@Column(name = "img_height")
	private Integer imageHeight;
	
	@Column(name = "img_width")
	private Integer imageWidth;
	
	@Lob
	@Column(name = "content")
	private byte[] content;

	public AvatarEntity(){ }

	public AvatarEntity(Integer id, String category, String title, String fileName, Integer imageHeight, Integer imageWidth) {
		this.id = id;
		this.category = category;
		this.title = title;
		this.fileName = fileName;
		this.imageHeight = imageHeight;
		this.imageWidth = imageWidth;
	}

	public AvatarEntity(String category, String title, String fileName, Integer imageHeight, Integer imageWidth) {
		this.category = category;
		this.title = title;
		this.fileName = fileName;
		this.imageHeight = imageHeight;
		this.imageWidth = imageWidth;
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
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the imageHeight
	 */
	public Integer getImageHeight() {
		return imageHeight;
	}

	/**
	 * @param imageHeight the imageHeight to set
	 */
	public void setImageHeight(Integer imageHeight) {
		this.imageHeight = imageHeight;
	}

	/**
	 * @return the imageWidth
	 */
	public Integer getImageWidth() {
		return imageWidth;
	}

	/**
	 * @param imageWidth the imageWidth to set
	 */
	public void setImageWidth(Integer imageWidth) {
		this.imageWidth = imageWidth;
	}

	/**
	 * @return the content
	 */
	public byte[] getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(byte[] content) {
		this.content = content;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imageHeight == null) ? 0 : imageHeight.hashCode());
		result = prime * result + ((imageWidth == null) ? 0 : imageWidth.hashCode());
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
		AvatarEntity other = (AvatarEntity) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (imageHeight == null) {
			if (other.imageHeight != null)
				return false;
		} else if (!imageHeight.equals(other.imageHeight))
			return false;
		if (imageWidth == null) {
			if (other.imageWidth != null)
				return false;
		} else if (!imageWidth.equals(other.imageWidth))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AvatarEntity [id=");
		builder.append(id);
		builder.append(", category=");
		builder.append(category);
		builder.append(", title=");
		builder.append(title);
		builder.append(", fileName=");
		builder.append(fileName);
		builder.append(", imageHeight=");
		builder.append(imageHeight);
		builder.append(", imageWidth=");
		builder.append(imageWidth);
		builder.append("]");
		return builder.toString();
	}
	
}
