/**
 * MovieContent.java
 */
package com.gnv.vnm.selfcare.core.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author nandipinto
 *
 */
public class MovieContent extends Content {

	private static final long serialVersionUID = -1714838128053825692L;
	
	private String directors;
	private String writers;
	private String producers;
	private String actors;
	private String language;
	private String storyLineEN;
	private String storyLineVI;
	private Long	 duration = 0L;
	private Integer releaseYear;
	@JsonIgnore
	private Date	releaseDate;
	
	public MovieContent() {
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
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
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
	public void setStoryLineEN(String storyLine) {
		this.storyLineEN = storyLine;
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
		builder.append("MovieContent [directors=");
		builder.append(directors);
		builder.append(", writers=");
		builder.append(writers);
		builder.append(", producers=");
		builder.append(producers);
		builder.append(", actors=");
		builder.append(actors);
		builder.append(", language=");
		builder.append(language);
		builder.append(", storyLineEN=");
		builder.append(storyLineEN);
		builder.append(", duration=");
		builder.append(duration);
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
