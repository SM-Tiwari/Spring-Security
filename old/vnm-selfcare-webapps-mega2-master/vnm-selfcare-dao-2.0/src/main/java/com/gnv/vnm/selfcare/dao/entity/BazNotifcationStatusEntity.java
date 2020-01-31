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
import javax.persistence.UniqueConstraint;

 
@Entity
@Table(name = "baz_notification_status", uniqueConstraints = { @UniqueConstraint(columnNames = "msisdn") })
@SequenceGenerator(name = "baz_notification_seq", sequenceName = "baz_notification_seq", allocationSize = 1)
public class BazNotifcationStatusEntity extends BaseEntity {

	private static final long serialVersionUID = 5464627765920518785L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "baz_notification_seq")
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "msisdn", length = 20, nullable = false)
	private String msisdn;
	
	@Column(name = "notification_status", length = 500)
	private String notification_status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "read_time")
	private Date read_time;
	
	@Column(name = "read_by", length = 20)
	private String read_by;
	
	@Column(name="number_notification",columnDefinition = "int default 0")
	private String number_notification;
	
	public BazNotifcationStatusEntity() {
		super();
	}

	public BazNotifcationStatusEntity(Integer id, String msisdn, String notification_status, Date read_time,
			String read_by) {
		super();
		this.id = id;
		this.msisdn = msisdn;
		this.notification_status = notification_status;
		this.read_time = read_time;
		this.read_by = read_by;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber_notification() {
		return number_notification;
	}

	public void setNumber_notification(String number_notification) {
		this.number_notification = number_notification;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getNotification_status() {
		return notification_status;
	}

	public void setNotification_status(String notification_status) {
		this.notification_status = notification_status;
	}

	public Date getRead_time() {
		return read_time;
	}

	public void setRead_time(Date read_time) {
		this.read_time = read_time;
	}

	public String getRead_by() {
		return read_by;
	}

	public void setRead_by(String read_by) {
		this.read_by = read_by;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((msisdn == null) ? 0 : msisdn.hashCode());
		result = prime * result + ((notification_status == null) ? 0 : notification_status.hashCode());
		result = prime * result + ((read_by == null) ? 0 : read_by.hashCode());
		result = prime * result + ((read_time == null) ? 0 : read_time.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		BazNotifcationStatusEntity other = (BazNotifcationStatusEntity) obj;
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
		if (notification_status == null) {
			if (other.notification_status != null)
				return false;
		} else if (!notification_status.equals(other.notification_status))
			return false;
		if (read_by == null) {
			if (other.read_by != null)
				return false;
		} else if (!read_by.equals(other.read_by))
			return false;
		if (read_time == null) {
			if (other.read_time != null)
				return false;
		} else if (!read_time.equals(other.read_time))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BazNotifcationStatusEntity [id=" + id + ", msisdn=" + msisdn + ", notification_status="
				+ notification_status + ", read_time=" + read_time + ", read_by=" + read_by + "]";
	}
	
}