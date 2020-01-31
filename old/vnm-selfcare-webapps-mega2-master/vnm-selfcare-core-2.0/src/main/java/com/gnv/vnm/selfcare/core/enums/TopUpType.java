/**
 * TopUpType.java
 */
package com.gnv.vnm.selfcare.core.enums;

/**
 * @author nandipinto
 *
 */
public enum TopUpType {
	
	SCRATCH_CARD("Scratch Card"),
	E_TOPUP("e-Top Up"),
	BANK_ACCOUNT("Bank Account");
	
	private String displayName;
	
	private TopUpType(String displayName){
		this.displayName = displayName;
	}

	public String displayName(){
		return this.displayName;
	}
}
