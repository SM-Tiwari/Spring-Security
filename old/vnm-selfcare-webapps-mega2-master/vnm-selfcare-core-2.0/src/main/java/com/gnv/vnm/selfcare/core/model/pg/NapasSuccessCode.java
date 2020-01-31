/**
 * 
 */
package com.gnv.vnm.selfcare.core.model.pg;

/**
 * @author nandipinto
 *
 */
public enum NapasSuccessCode {

	SUCCESS("0"),
	CARD_VERIFICATION_SUCCESSFUL("11"),
	AWAITING_BANK_CONFIRMATION("26"),
	ORDER_NOT_TO_MAKE_PAYMENT("32");
	
	private String code;
	
	private NapasSuccessCode(String code) {
		this.code = code;
	}
	
	public String code() {
		return this.code;
	}
}
