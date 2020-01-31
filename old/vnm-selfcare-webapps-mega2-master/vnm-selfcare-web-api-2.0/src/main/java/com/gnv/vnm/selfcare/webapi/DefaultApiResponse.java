/**
 * DefaultApiResponse.java
 */
package com.gnv.vnm.selfcare.webapi;

/**
 * @author nandipinto
 *
 */
public enum DefaultApiResponse {

	SUCCESS("0","SUCCESS"),
	SUBSCRIBER_NOT_FOUND("100", "ERROR: Subscriber %s not registered."),
	SUBSCRIBER_ALREADY_EXISTS("101", "ERROR: Subscriber %s already exists."),
	SUBSCRIPTION_ALREADY_ACTIVE("102", "ERROR: Subscription still active."),
	NUMBER_NOT_RECOGNIZED("103", "ERROR: Number not recognized."),
	INVALID_IP_ADDRESS("104", "ERROR: Invalid IP address: %s."),
	INVALID_TOKEN ("105", "ERROR: Invalid token or token has expired."),
	INVALID_PASSWORD_FORMAT("106", "ERROR: Password does not meet security and password policy."),
	PASSWORD_MISMATCH("107", "ERROR: Password mismatch."),
	AVATAR_NOT_FOUND("108", "ERROR: Avatar not found."),
	ORDER_ID_NOT_FOUND("200", "Order Id does not exist."),
	TRANSACTION_IN_PROGRESS("201", "Transaction already in progress."),
	NO_MESSAGE_TO_SEND("300", "No message to send to destination."),
	MESSAGE_NOT_SENT("301", "Message not sent to destination."),
	INVALID_PARAMETER_VALUE("400", "ERROR: Invalid parameter value for %s"),
	MISSING_REQUIRED_PARAMETER("401", "ERROR: Missing required parameter %s"),
	PARTIAL_BACK_END_FAILURE("402", "Partial back-end failure: %s"),
	INTERNAL_APP_ERROR("500", "Internal server error"),
	SUBSCRIBER_OTP_BLOCK("209", "Subscriber OTP Block."),
	SUBSCRIBER_OTP_VALID("210", "Subscriber OTP Sent."),
	SUBSCRIBER_OTP_INVALID_TOKEN("310", "Subscriber OTP Block ."),
	INVALIDIMAGE("0123", "Invalid Image"),
	PASSWORD_MISMATCH_CHANGE("111", "ERROR: Password Changed."),
	FAIL("1", "Fail"),
	UNAUTHORIZED("999", "Unauthorized access.");
	
	private String code;
	private String message;
	
	private DefaultApiResponse(String code, String message){
		this.code = code;
		this.message = message;
	}
	
	public String code(){
		return this.code;
	}
	
	public String message(){
		return this.message;
	}
}
