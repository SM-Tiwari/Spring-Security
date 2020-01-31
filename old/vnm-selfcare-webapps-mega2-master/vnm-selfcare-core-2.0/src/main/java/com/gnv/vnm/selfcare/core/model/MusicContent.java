/**
 * MusicContent.java
 */
package com.gnv.vnm.selfcare.core.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author nandipinto
 *
 */
public class MusicContent extends Content {

	private static final long serialVersionUID = 2132614833137297351L;

	private String 	artistName;
	private String 	albumName;
	private Long   	duration = 0L;
	private String 	format;
	private Integer	quality;
	private Integer releaseYear;
	@JsonIgnore
	private Date	releaseDate;
	
	public MusicContent() {
		
	}
	
	public MusicContent(Integer id, Integer categoryId, String code, String name, String title, String description,
			Double price, String previewURL, String sourceURL) {
		super(id, categoryId, code, name, title, description, price, previewURL, sourceURL);
	}

	/**
	 * @return the artistName
	 */
	public String getArtistName() {
		return artistName;
	}

	/**
	 * @param artistName the artistName to set
	 */
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	/**
	 * @return the albumName
	 */
	public String getAlbumName() {
		return albumName;
	}

	/**
	 * @param albumName the albumName to set
	 */
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
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
	 * @return the format
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * @param format the format to set
	 */
	public void setFormat(String format) {
		this.format = format;
	}

	/**
	 * @return the quality
	 */
	public Integer getQuality() {
		return quality;
	}

	/**
	 * @param quality the quality to set
	 */
	public void setQuality(Integer quality) {
		this.quality = quality;
	}

	/**
	 * @return the releaseYear
	 */
	public Integer getReleaseYear() {
		return releaseYear;
	}

	/**
	 * @param releaseYear the releaseYear to set
	 */
	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MusicContent [artistName=");
		builder.append(artistName);
		builder.append(", albumName=");
		builder.append(albumName);
		builder.append(", duration=");
		builder.append(duration);
		builder.append(", format=");
		builder.append(format);
		builder.append(", quality=");
		builder.append(quality);
		builder.append(", releaseYear=");
		builder.append(releaseYear);
		builder.append(", releaseDate=");
		builder.append(releaseDate);
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
