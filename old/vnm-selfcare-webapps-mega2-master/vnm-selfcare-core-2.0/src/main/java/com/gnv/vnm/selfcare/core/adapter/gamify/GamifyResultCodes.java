/**
 * GamifyResultCodes.java
 */
package com.gnv.vnm.selfcare.core.adapter.gamify;

/**
 * @author nandipinto
 *
 */
public enum GamifyResultCodes {
	
	SUCCESS("1000"),
	MISSING_PARAMETER("2001"),
	INVALID_PHONE_AREA_CODE("2003"),
	INVALID_PHONE_NUMBER("2004"),
	INVALID_MONSTER_ID("2025"),
	INVALID_QUANTITY("2026"),
	TRANSACTION_ALREADY_PROCESSED("4025"),
	MEMBER_RECORD_NOT_FOUND("4033"),
	NOT_ENOUGH_MONSTER("4034"),
	SYSTEM_ERROR("9000");
	
	private String code;
	
	private GamifyResultCodes(String code){
		this.code = code;
	}
	
	public String code(){
		return this.code;
	}

}
