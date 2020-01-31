/**
 * PGCallbackResponse.java
 */
package com.gnv.vnm.selfcare.webapi.model;

import java.io.Serializable;

/**
 * @author nandipinto
 *
 */
public class PGCallbackResponse implements Serializable {

	private static final long serialVersionUID = 8251657232840607174L;

	private String resultCode;

	public PGCallbackResponse(String resultCode) {
		this.resultCode = resultCode;
	}

	/**
	 * @return the resultCode
	 */
	public String getResultCode() {
		return resultCode;
	}

	/**
	 * @param resultCode the resultCode to set
	 */
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	
}
