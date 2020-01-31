/**
 * VASManErrorMessage.java
 */
package com.gnv.vnm.selfcare.core.adapter.vasman;

/**
 * @author nandipinto
 *
 */
public enum VASManErrorMessage {

	SUCCESS("1"),
	ERROR("0"),
	SYSTEM_UPGRADING("2"),
	INVALID_REQUEST("4"),
	INVALID_SYNTAX("5"),
	OVER_LIMIT("6"),
	CREATE_ORDER_FAIL("7"),
	UNKNOWN_ROUTE("9"),
	UNKNOWN_CAMPAIGN("10"),
	UNKNOWN_PROVISIONING("11"),
	UNKNOWN_ORDER("13"),
	UNKNOWN_SUBSCRIBER("14"),
	UNKNOWN_SUBSCRIPTION("15"),
	UNKNOWN_CLASS("16"),
	UNKNOWN_METHOD("17"),
	UNKNOWN_BALANCE("18"),
	DUPLICATED("20"),
	ALREADY_REGISTERED("21"),
	UNREGISTERED("22"),
	EXPIRED("23"),
	BLACKLISTED_PRODUCT("24"),
	UNKNOWN_KEYWORD("25"),
	RECURSIVE_COMMAND("28"),
	DENIED_SUBSCRIBER_COS("29"),
	DENIED_SUBSCRIBER_STATE("30"),
	DENIED_SUBSCRIBER_TYPE("31"),
	NOT_ENOUGH_MONEY("32"),
	BALANCE_TOO_LARGE("33"),
	EXPIRE_TOO_LARGE("34"),
	BALANCE_TOO_SMALL("35"),
	INVALID_OWNER("36"),
	INVALID_DELIVERY("37"),
	DUPLICATE_SUBSCRIPTION("38"),
	UNKNOWN_PRODUCT("902"),
	UNSUPPORTED("907"),
	SYSTEM_DISCONNECTED("908"),
	SYSTEM_BUSY("909"),
	TIMED_OUT("910"),
	INVALID_CREDENTIALS("911"),
	SUBSCRIBER_NOT_FOUND("912");

	private String code;
	
	private VASManErrorMessage(String code){
		this.code = code;
	}
	
	public String code(){
		return this.code;
	}
	
	public static VASManErrorMessage fromCode(String code){
		if (code == null) return ERROR;
		
		VASManErrorMessage[] values = VASManErrorMessage.values();
		for (VASManErrorMessage v : values){
			if (v.code().equals(code)) return v;
		}
		
		return ERROR;
	}
}
