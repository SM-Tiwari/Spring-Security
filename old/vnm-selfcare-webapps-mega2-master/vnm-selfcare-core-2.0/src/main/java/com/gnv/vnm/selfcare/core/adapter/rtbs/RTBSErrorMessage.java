/**
 * RTBSErrorMessage.java
 */
package com.gnv.vnm.selfcare.core.adapter.rtbs;

/**
 * @author nandipinto
 *
 */
public enum RTBSErrorMessage {

	SUBSCRIBER_ID_DOES_NOT_EXIST("4700", "SubscriberIdentityDoesNotExist"),
	SUBSCRIBER_NOT_FOUND("4006", "SubscriberNotFound"),
	RECHARGE_CARD_DOES_NOT_EXIST("4910", "RechargeCardDoesNotExist"),
	RECHARGE_VOUCHER_CARD_DOES_NOT_EXIST("4911", "RechargeVoucherCardDoesNotExist"),
	RECHARGE_INVALID_STATE("4912", "RechargeInvalidState"),
	RECHARGE_INVALID_CARD_EXP_DATE("4913", "RechargeInvalidCardExpirationDate"),
	RECHARGE_EXP_DATE_IN_PAST("4918", "RechargeExpireDateinPast"),
	RECHARGE_FAILED("4926", "UnableToPerformRecharge");
	
	private String code;
	private String message;
	
	private RTBSErrorMessage(String code, String message){
		this.code = code;
		this.message = message;
	}
	
	public String code(){
		return code;
	}
	
	public String message(){
		return message;
	}
}
