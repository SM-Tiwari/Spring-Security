package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;

public class EposTokenModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String status;
	private String message;
	private String sessionid;
	
	
	public EposTokenModel() {
		 
	}


	public EposTokenModel(String status, String message, String sessionid) {
		super();
		this.status = status;
		this.message = message;
		this.sessionid = sessionid;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getSessionid() {
		return sessionid;
	}


	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}


	@Override
	public String toString() {
		return "EposTokenModel [status=" + status + ", message=" + message + ", sessionid=" + sessionid + "]";
	}
	
	
	
	
}
