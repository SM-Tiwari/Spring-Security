/**
 * PGResponseCode.java
 */
package com.gnv.vnm.selfcare.core.model;

/**
 * @author nandipinto
 *
 */
public enum PGResponseCode {

	SUCCESS("0", "Success"),
	INTERNAL_SYSTEM_ERROR("100", "Internal or System Error"),
	INVALID_ORDER_ID("108", "Invalid order Id"),
	TRANSACTION_NOT_FOUND("117", "Transaction not found");
	
	private String code;
	private String description;
	
	private PGResponseCode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
}
