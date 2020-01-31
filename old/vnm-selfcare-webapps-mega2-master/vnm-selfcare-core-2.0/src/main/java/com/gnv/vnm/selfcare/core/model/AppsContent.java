/**
 * AppsContent.java
 */
package com.gnv.vnm.selfcare.core.model;

import java.util.Arrays;
import java.util.Date;

/**
 * @author nandipinto
 *
 */
public class AppsContent extends Content {

	private static final long serialVersionUID = -4797922928623636148L;

	private String[] screenShots;
	private String producers;
	private String version;
	private Long fileSize = 0L;
	private Date releaseDate;
	private Date lastUpdatedDate;
	private String supportedSystems;
	private String notesEN;
	private String notesVI;
	
	private String androidProductURL;
	private String iosProductURL;
	
	/**
	 * @return the screenShots
	 */
	public String[] getScreenShots() {
		return screenShots;
	}
	/**
	 * @param screenShots the screenShots to set
	 */
	public void setScreenShots(String[] screenShots) {
		this.screenShots = screenShots;
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
	 * @return the lastUpdatedDate
	 */
	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	/**
	 * @param lastUpdatedDate the lastUpdatedDate to set
	 */
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
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
	 * @return the notesEN
	 */
	public String getNotesEN() {
		return notesEN;
	}
	/**
	 * @param notesEN the notesEN to set
	 */
	public void setNotesEN(String notes) {
		this.notesEN = notes;
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
	 * @return the androidProductURL
	 */
	public String getAndroidProductURL() {
		return androidProductURL;
	}
	/**
	 * @param androidProductURL the androidProductURL to set
	 */
	public void setAndroidProductURL(String androidProductURL) {
		this.androidProductURL = androidProductURL;
	}
	/**
	 * @return the iosProductURL
	 */
	public String getIosProductURL() {
		return iosProductURL;
	}
	/**
	 * @param iosProductURL the iosProductURL to set
	 */
	public void setIosProductURL(String iosProductURL) {
		this.iosProductURL = iosProductURL;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AppsContent [screenShots=");
		builder.append(Arrays.toString(screenShots));
		builder.append(", producers=");
		builder.append(producers);
		builder.append(", version=");
		builder.append(version);
		builder.append(", fileSize=");
		builder.append(fileSize);
		builder.append(", releaseDate=");
		builder.append(releaseDate);
		builder.append(", lastUpdatedDate=");
		builder.append(lastUpdatedDate);
		builder.append(", supportedSystems=");
		builder.append(supportedSystems);
		builder.append(", notesEN=");
		builder.append(notesEN);
		builder.append(", androidProductURL=");
		builder.append(androidProductURL);
		builder.append(", iosProductURL=");
		builder.append(iosProductURL);
		builder.append(", id=");
		builder.append(id);
		builder.append(", categoryId=");
		builder.append(categoryId);
		builder.append(", categoryNameEN=");
		builder.append(categoryNameEN);
		builder.append(", code=");
		builder.append(code);
		builder.append(", name=");
		builder.append(nameEN);
		builder.append(", titleEN=");
		builder.append(titleEN);
		builder.append(", descriptionEN=");
		builder.append(descriptionEN);
		builder.append(", price=");
		builder.append(price);
		builder.append(", previewURL=");
		builder.append(previewURL);
		builder.append(", sourceURL=");
		builder.append(sourceURL);
		builder.append(", defaultIcon=");
		builder.append(defaultIcon);
		builder.append(", defaultImage=");
		builder.append(defaultImage);
		builder.append(", smallIcon=");
		builder.append(smallIcon);
		builder.append(", mediumIcon=");
		builder.append(mediumIcon);
		builder.append(", largeIcon=");
		builder.append(largeIcon);
		builder.append(", xlargeIcon=");
		builder.append(xlargeIcon);
		builder.append(", smallImage=");
		builder.append(smallImage);
		builder.append(", mediumImage=");
		builder.append(mediumImage);
		builder.append(", largeImage=");
		builder.append(largeImage);
		builder.append(", xlargeImage=");
		builder.append(xlargeImage);
		builder.append(", status=");
		builder.append(status);
		builder.append(", metadata=");
		builder.append(metadata);
		builder.append("]");
		return builder.toString();
	}
	
}
