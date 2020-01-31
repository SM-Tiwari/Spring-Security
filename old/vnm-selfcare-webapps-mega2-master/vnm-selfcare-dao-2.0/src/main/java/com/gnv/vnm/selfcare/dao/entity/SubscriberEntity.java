/**
 * 
 */
package com.gnv.vnm.selfcare.dao.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author nandipinto
 *
 */

@Entity
@Table(name = "subscriber", uniqueConstraints = {/*@UniqueConstraint(columnNames = "id"), */ @UniqueConstraint(columnNames = "msisdn")})
@SequenceGenerator(name = "subscriber_seq", sequenceName = "subscriber_seq", allocationSize = 1)
public class SubscriberEntity extends BaseEntity {

	private static final long serialVersionUID = 3823396869563371531L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subscriber_seq")
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "msisdn", length = 15, nullable = false)
	private String msisdn;
	
	@Column(name = "imei", length = 16)
	private String imei;

	@Column(name = "imsi", length = 15)
	private String imsi;

	@Column(name = "credential", length = 255)
	private String credential;
	
	@Column(name = "subscriber_type")
	private Integer type = 0;
	
	@Column(name = "status")
	private Integer status = 0;

	@Column(name = "email_addr", length = 100)
	private String emailAddress;
	
	@Column(name = "lang_id", length = 2)
	private String languageCode;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "subscriber")
	private SubscriberDetailEntity details;
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="subscriber_id")
	private Set<ContentSubscriptionEntity> subscribedContents = new HashSet<>();
	
	@Column(name = "avatar_id")
	private Integer avatarId;
	
	@Column(name = "reg_channel", length = 20)
	private String registerFrom;
	
	public SubscriberEntity(){ }
	
	public SubscriberEntity(Integer id, String msisdn, String imei, String imsi, String credential, Integer type,
			Integer status) {
		this.id = id;
		this.msisdn = msisdn;
		this.imei = imei;
		this.imsi = imsi;
		this.credential = credential;
		this.type = type;
		this.status = status;
	}
	
	public SubscriberEntity(String msisdn, String imei, String imsi, String credential, Integer type,
			Integer status) {
		this.msisdn = msisdn;
		this.imei = imei;
		this.imsi = imsi;
		this.credential = credential;
		this.type = type;
		this.status = status;
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
	 * @return the imei
	 */
	public String getImei() {
		return imei;
	}
	/**
	 * @param imei the imei to set
	 */
	public void setImei(String imei) {
		this.imei = imei;
	}
	/**
	 * @return the imsi
	 */
	public String getImsi() {
		return imsi;
	}
	/**
	 * @param imsi the imsi to set
	 */
	public void setImsi(String imsi) {
		this.imsi = imsi;
	}
	/**
	 * @return the credential
	 */
	public String getCredential() {
		return credential;
	}
	/**
	 * @param credential the credential to set
	 */
	public void setCredential(String credential) {
		this.credential = credential;
	}
	/**
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
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
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * @return the languageCode
	 */
	public String getLanguageCode() {
		return languageCode;
	}

	/**
	 * @param languageCode the languageCode to set
	 */
	public void setLanguageCode(String languageId) {
		this.languageCode = languageId;
	}

	/**
	 * @return the details
	 */
	public SubscriberDetailEntity getDetails() {
		return details;
	}
	
	/**
	 * @param details the details to set
	 */
	public void setDetails(SubscriberDetailEntity detail) {
		this.details = detail;
	}
	
	/**
	 * @return the subscribedContents
	 */
	public Set<ContentSubscriptionEntity> getSubscribedContents() {
		return subscribedContents;
	}

	/**
	 * @param subscribedContents the subscribedContents to set
	 */
	public void setSubscribedContents(Set<ContentSubscriptionEntity> subscribedContents) {
		this.subscribedContents = subscribedContents;
	}

	/**
	 * @return the avatarId
	 */
	public Integer getAvatarId() {
		return avatarId;
	}

	/**
	 * @param avatarId the avatarId to set
	 */
	public void setAvatarId(Integer avatarId) {
		this.avatarId = avatarId;
	}

	/**
	 * @return the registerFrom
	 */
	public String getRegisterFrom() {
		return registerFrom;
	}

	/**
	 * @param registerFrom the registerFrom to set
	 */
	public void setRegisterFrom(String registerFrom) {
		this.registerFrom = registerFrom;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		SubscriberEntity other = (SubscriberEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		builder.append("SubscriberEntity [id=");
		builder.append(id);
		builder.append(", msisdn=");
		builder.append(msisdn);
		builder.append(", type=");
		builder.append(type);
		builder.append(", status=");
		builder.append(status);
		builder.append(", languageCode=");
		builder.append(languageCode);
		builder.append(", avatarId=");
		builder.append(avatarId);
		builder.append(", registerFrom=");
		builder.append(registerFrom);
		builder.append("]");
		return builder.toString();
	}
	
}
