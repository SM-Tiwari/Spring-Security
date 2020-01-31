/**
 * DefaultWebPortalMessages.java
 */
package com.gnv.vnm.selfcare.webportal.config;

/**
 * @author nandipinto
 *
 */
public enum DefaultWebPortalMessages {
	
	INTERNAL_ERROR("System is under Maintenance, we will come back Soon , Please try after some time."),
	LOGIN_FAILURE("Your number or password was entered incorrectly"),
	PHONE_NUMBER_EMPTY("Please enter your phone number"),
	INVALID_PHONE_NUMBER("Please enter a valid Vietnamobile number"),
	PASSWORDS_NOT_MATCH("Entered passwords do not match"),
	INVALID_PASSWORD_FORMAT("Password must be at least 8 characters with alpha numeric"),
	PHONE_NUMBER_ALREADY_REGISTERED("Your phone number has already been registered."),
	PHONE_NUMBER_NOT_REGISTERED("Your phone number is not recognized."),
	INVALID_OTP("The code you have entered is incorrect."),
	OTP_SENT("Your one-time-password has beent sent to your number"),
	SIGNUP_SUCCESS("Congratulations, your phone number has been successfully registered. Click <a href=\"%s\">here</a> to login."),
	CHANGE_PASSWORD_SUCCESS("Your password has been changed successfully."),
	RESET_PASSWORD_SUCCESS("Your password has been changed successfully. Click <a href=\"%s\">here</a> to login."),
	
	TOPUP_INCOMPLETE_PIN_CODE("The code you entered is incorrect, please try again."),
	TOPUP_PIN_CODE_ALREADY_USED("Recharge unsuccessful, scratch card expired. Please purchase another."),
	TOPUP_INVALID_PIN_CODE("The code you entered is incorrect, please try again."),
	TOPUP_INVALID_MSISDN("Please enter a valid Vietnamobile number."),
	TOPUP_SUCCESS("Your updated Core balance is %s dong."),
	TOPUP_FAIL("Recharge unsuccessful, please try again."),
	TOPUP_INVALID_CAPTCHA("Your answer is incorrect, please try again."),
	
	INVITATION_SENT("Invitations have beent sent successfully."),
	
	REGISTER_DATA_SHARING_SUCCESS("Your registration was successful."),
	REGISTER_DATA_SHARING_FAIL("Your request could not be processed, please try again.");
	
	private String message;
	
	private DefaultWebPortalMessages(String message){
		this.message = message;
	}
	
	public String message(){
		return this.message;
	}

}
