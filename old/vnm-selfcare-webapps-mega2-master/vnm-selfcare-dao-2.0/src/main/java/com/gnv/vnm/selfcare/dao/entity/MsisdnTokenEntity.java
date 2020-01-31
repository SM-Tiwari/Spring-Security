
package com.gnv.vnm.selfcare.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name = "msisdn_token")
@SequenceGenerator(name = "msisdn_token_seq", sequenceName = "msisdn_token_seq", allocationSize = 1)
public class MsisdnTokenEntity extends BaseEntity {

	private static final long serialVersionUID = -5027352163052435955L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "msisdn_token_seq")
	@Column(name = "id")
	private Integer id;
	
	@Column(length = 20)
	private String msisdn;
 
	@Column(name = "token")
	private String token;
	
	@Column(name="ip_address")
	private String ipAddress;

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}


	 
	
	
}
