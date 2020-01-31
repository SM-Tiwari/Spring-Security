package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;

public class UpdateCustomerInforModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String transId;
	private String status;
	private String message;
	
	
	public UpdateCustomerInforModel() {
		 
	}

	public UpdateCustomerInforModel(String transId, String status, String message) {
		super();
		this.transId = transId;
		this.status = status;
		this.message = message;
	}

	public String getTransId() {
		return transId;
	}

	public void setTransId(String transId) {
		this.transId = transId;
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

	@Override
	public String toString() {
		return "UpdateCustomerInforModel [transId=" + transId + ", status=" + status + ", message=" + message + "]";
	}
	
	
	
	
}
