

package com.gnv.vnm.selfcare.webapi.model;

import java.io.Serializable;
import java.util.Date;

public class MsisdnTokenModel implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5425117788402296841L;
	private int id;
	private String token;
	private String msisdn;
	protected Date createTimestamp = new Date();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	
	
	/**
	 * @return the createTimestamp
	 */
	public Date getCreateTimestamp() {
		return createTimestamp;
	}

	/**
	 * @param createTimestamp the createTimestamp to set
	 */
	public void setCreateTimestamp(Date createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	
	
                
                
}
