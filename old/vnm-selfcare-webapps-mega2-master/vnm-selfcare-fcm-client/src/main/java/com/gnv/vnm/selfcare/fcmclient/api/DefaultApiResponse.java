/**
 * DefaultApiResponse.java
 */
package com.gnv.vnm.selfcare.fcmclient.api;

/**
 * @author nandipinto
 *
 */
public enum DefaultApiResponse {

	ERROR("0", "Request cannot be processed at this time."),
	SUCCESS("1","SUCCESS"),
	SUBSCRIBER_NOT_FOUND("100", "ERROR: Subscriber %s not registered."),
	INTERNAL_APP_ERROR("500", "ERROR: Internal server error");
	
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
