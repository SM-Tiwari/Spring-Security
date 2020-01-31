/**
 * LoginHistoryEntity.java
 */
package com.gnv.vnm.selfcare.dao.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author nandipinto
 *
 */


@Entity
@Table(name = "login_history" /*, uniqueConstraints = {@UniqueConstraint(columnNames = "id")}*/)
@SequenceGenerator(name = "login_history_seq", sequenceName = "login_history_seq", allocationSize = 1)
public class LoginHistoryEntity extends BaseEntity {

	private static final long serialVersionUID = 3225319530363776900L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "login_history_seq")
	@Column(name = "id")
	private Integer id;

	@Column(name = "msisdn", length = 15, nullable = false)
	private String msisdn;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_login_time")
	private Date lastLoginTime;
	
	@Column(name = "last_login_from")
	private String lastLoginFrom;

	@Column(name = "app_id")
	private String clientAppId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "logout_time")
	private Date logoutTime;
	
	public LoginHistoryEntity(){ }

	/**
	 * @param id
	 * @param msisdn
	 * @param lastLoginTime
	 * @param lastLoginFrom
	 */
	public LoginHistoryEntity(Integer id, String msisdn, Date lastLoginTime, String lastLoginFrom) {
		this.id = id;
		this.msisdn = msisdn;
		this.lastLoginTime = lastLoginTime;
		this.lastLoginFrom = lastLoginFrom;
	}

	/**
	 * @param msisdn
	 * @param lastLoginTime
	 * @param lastLoginFrom
	 * @param clientAppId
	 */
	public LoginHistoryEntity(String msisdn, Date lastLoginTime, String lastLoginFrom, String clientAppId) {
		this.msisdn = msisdn;
		this.lastLoginTime = lastLoginTime;
		this.lastLoginFrom = lastLoginFrom;
		this.clientAppId = clientAppId;
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
	 * @return the msisdn
	 */
	public String getMsisdn() {
		return msisdn;
	}

	/**
	 * @param msisdn the msisdn to set
	 */
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	/**
	 * @return the lastLoginTime
	 */
	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	/**
	 * @param lastLoginTime the lastLoginTime to set
	 */
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	/**
	 * @return the lastLoginFrom
	 */
	public String getLastLoginFrom() {
		return lastLoginFrom;
	}

	/**
	 * @param lastLoginFrom the lastLoginFrom to set
	 */
	public void setLastLoginFrom(String lastLoginFrom) {
		this.lastLoginFrom = lastLoginFrom;
	}

	/**
	 * @return the clientAppId
	 */
	public String getClientAppId() {
		return clientAppId;
	}

	/**
	 * @param clientAppId the clientAppId to set
	 */
	public void setClientAppId(String clientAppId) {
		this.clientAppId = clientAppId;
	}

	/**
	 * @return the logoutTime
	 */
	public Date getLogoutTime() {
		return logoutTime;
	}

	/**
	 * @param logoutTime the logoutTime to set
	 */
	public void setLogoutTime(Date logoutTime) {
		this.logoutTime = logoutTime;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastLoginFrom == null) ? 0 : lastLoginFrom.hashCode());
		result = prime * result + ((lastLoginTime == null) ? 0 : lastLoginTime.hashCode());
		result = prime * result + ((msisdn == null) ? 0 : msisdn.hashCode());
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
		LoginHistoryEntity other = (LoginHistoryEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastLoginFrom == null) {
			if (other.lastLoginFrom != null)
				return false;
		} else if (!lastLoginFrom.equals(other.lastLoginFrom))
			return false;
		if (lastLoginTime == null) {
			if (other.lastLoginTime != null)
				return false;
		} else if (!lastLoginTime.equals(other.lastLoginTime))
			return false;
		if (msisdn == null) {
			if (other.msisdn != null)
				return false;
		} else if (!msisdn.equals(other.msisdn))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoginHistoryEntity [id=");
		builder.append(id);
		builder.append(", msisdn=");
		builder.append(msisdn);
		builder.append(", lastLoginTime=");
		builder.append(lastLoginTime);
		builder.append(", lastLoginFrom=");
		builder.append(lastLoginFrom);
		builder.append(", clientAppId=");
		builder.append(clientAppId);
		builder.append(", logoutTime=");
		builder.append(logoutTime);
		builder.append("]");
		return builder.toString();
	}
	
	
}
