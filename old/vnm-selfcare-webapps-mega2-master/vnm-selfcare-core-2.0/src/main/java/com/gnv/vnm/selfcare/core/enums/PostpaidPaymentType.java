/**
 * TopUpType.java
 */
package com.gnv.vnm.selfcare.core.enums;

/**
 * @author nandipinto
 *
 */
public enum PostpaidPaymentType {
	
	SCRATCH_CARD("Scratch Card"),
	BANK_ACCOUNT("Bank Account");
	
	private String displayName;
	
	private PostpaidPaymentType(String displayName){
		this.displayName = displayName;
	}

	public String displayName(){
		return this.displayName;
	}
}
