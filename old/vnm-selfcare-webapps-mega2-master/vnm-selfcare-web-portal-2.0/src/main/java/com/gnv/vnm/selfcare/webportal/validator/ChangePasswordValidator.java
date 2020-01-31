/**
 * UserRegistrationValidator.java
 */
package com.gnv.vnm.selfcare.webportal.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.gnv.vnm.selfcare.core.AppDefaultValues;
import com.gnv.vnm.selfcare.core.service.ApplicationConfigurationService;
import com.gnv.vnm.selfcare.webportal.config.DefaultWebPortalMessages;
import com.gnv.vnm.selfcare.webportal.model.UserRegistrationForm;

/**
 * @author nandipinto
 *
 */

@Component
public class ChangePasswordValidator implements Validator{

	@Autowired
	protected ApplicationConfigurationService applicationConfigurationService;

	@Override
	public boolean supports(Class<?> clazz) {
		return UserRegistrationForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserRegistrationForm form = (UserRegistrationForm)target;
		
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "Message.InvalidPhoneNumber", DefaultWebPortalMessages.INVALID_PHONE_NUMBER.message());
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "otp", "Message.InvalidOTP", DefaultWebPortalMessages.INVALID_OTP.message());
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Message.InvalidPasswordFormat", DefaultWebPortalMessages.INVALID_PASSWORD_FORMAT.message());
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "Message.InvalidPasswordFormat", DefaultWebPortalMessages.INVALID_PASSWORD_FORMAT.message());

		String password = form.getPassword();
		String confirmPassword = form.getConfirmPassword();
		
		String regex = applicationConfigurationService.get("security.password.regex", AppDefaultValues.PASSWORD_REGEX).toString();
		if (!password.matches(regex)){
			errors.rejectValue("password", "Message.InvalidPasswordFormat", null, DefaultWebPortalMessages.INVALID_PASSWORD_FORMAT.message());
		}else{
			if (!form.getPassword().equals(confirmPassword)){
				errors.rejectValue("confirmPassword", "Message.PasswordsNotMatch", null, DefaultWebPortalMessages.PASSWORDS_NOT_MATCH.message());
			}
		}
	}
}
