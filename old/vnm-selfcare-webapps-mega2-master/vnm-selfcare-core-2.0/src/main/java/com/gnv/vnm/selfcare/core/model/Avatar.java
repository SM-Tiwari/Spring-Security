/**
 * Avatar.java
 */
package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;

/**
 * @author nandipinto
 *
 */
public class Avatar implements Serializable {

	private static final long serialVersionUID = -2379755399803163535L;

	private Integer id;
	private String category;
	private String title;
	private String fileName;
	private String imageURL;
	
	public Avatar(Integer id, String category, String title, String fileName) {
		this.id = id;
		this.category = category;
		this.title = title;
		this.fileName = fileName;
	}

	public Avatar(String category, String title, String fileName) {
		this.category = category;
		this.title = title;
		this.fileName = fileName;
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
	 * @return the imageURL
	 */
	public String getImageURL() {
		return imageURL;
	}

	/**
	 * @param imageURL the imageURL to set
	 */
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Avatar [id=");
		builder.append(id);
		builder.append(", category=");
		builder.append(category);
		builder.append(", title=");
		builder.append(title);
		builder.append(", fileName=");
		builder.append(fileName);
		builder.append(", imageURL=");
		builder.append(imageURL);
		builder.append("]");
		return builder.toString();
	}
	
	
}
