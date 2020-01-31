/**
 * MovieBannerEntity.java
 */
package com.gnv.vnm.selfcare.dao.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author nandipinto
 *
 */

@Entity
@Table(name = "music_banner", /*uniqueConstraints = { @UniqueConstraint(columnNames = "id") }, */indexes = {
		@Index(columnList = "music_id"), @Index(columnList = "end_date") })
@SequenceGenerator(name = "music_banner_seq", sequenceName = "music_banner_seq", allocationSize = 1)
public class MusicBannerEntity extends BaseEntity {

	private static final long serialVersionUID = -704402753603622208L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "music_banner_seq")
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "music_id")
	private Integer musicId;
	
	@Column(name = "start_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	
	@Column(name = "end_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	
	@Column(name = "status")
	private Integer status = 1;
	
	public MusicBannerEntity(){ }

	public MusicBannerEntity(Integer id, Integer musicId, Date startDate, Date endDate) {
		this.id = id;
		this.musicId = musicId;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public MusicBannerEntity(Integer musicId, Date startDate, Date endDate) {
		this(null, musicId, startDate, endDate);
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
	 * @return the musicId
	 */
	public Integer getMusicId() {
		return musicId;
	}

	/**
	 * @param musicId the musicId to set
	 */
	public void setMusicId(Integer musicId) {
		this.musicId = musicId;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((musicId == null) ? 0 : musicId.hashCode());
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
		MusicBannerEntity other = (MusicBannerEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (musicId == null) {
			if (other.musicId != null)
				return false;
		} else if (!musicId.equals(other.musicId))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MusicBannerEntity [id=");
		builder.append(id);
		builder.append(", musicId=");
		builder.append(musicId);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}
	
}
