/**
 * DefaultScreenMessage.java
 */
package com.gnv.vnm.selfcare.core.enums;

/**
 * @author nandipinto
 *
 */
public enum DefaultBackendMessage {
	
	OTP_REQUEST_SUCCESS("Your One Time Password is %s"),
	CHANGE_PASSWORD_SUCCESSFUL("Your password has been changed to %s, please login and update your password immediately."),
	TOPUP_SUCCESSFUL("Top up successful, your balance is now %s."),
	TOPUP_FAILED("We're sorry, we could not process your Top Up request at the moment, please try again later."),
	ETOPUP_SUCCESSFUL("Your transaction %s is successful, your updated balance is now %s."),
	ETOPUP_FAILED("We're sorry, we could not process your Top Up request at the moment, please try again later."),
	PURCHASE_PKG_SUCCESS("Congratulations, you have successfully activated package %s"),
	PURCHASE_PKG_FAILED("Your request cannot be processed at this moment."),
	CANCEL_PKG_SUCCESS("Your subscription to %s has been terminated"),
	CANCEL_PKG_FAILED("We are sorry, your request cannot be processed at this time, please try again later."),
	SUBSCRIPTION_ALREADY_ACTIVE("You still have an active subscription to %s"),
	CHANGE_PKG_FAILED("We are sorry, your request to change package subscription could not be processed at this time. Please try again later."),
	PURCHASE_NOTIF("You have purchased %s on %s."),
	TOPUP_FOR_ANOTHER_NUMBER("Your account has been loaded %d from %s at %s");
	

	private String message;
	
	private DefaultBackendMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return this.message;
	}

}
