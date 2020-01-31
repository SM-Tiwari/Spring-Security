/**
 * ChangePasswordController.java
 */
package com.gnv.vnm.selfcare.webportal.controller;

import java.security.Principal;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gnv.vnm.selfcare.core.fault.ExternalSubscriberException;
import com.gnv.vnm.selfcare.core.fault.InvalidPasswordFormatException;
import com.gnv.vnm.selfcare.core.fault.InvalidTokenException;
import com.gnv.vnm.selfcare.core.fault.SubscriberNotFoundException;
import com.gnv.vnm.selfcare.webportal.config.DefaultWebPortalMessages;
import com.gnv.vnm.selfcare.webportal.config.ScreenNames;
import com.gnv.vnm.selfcare.webportal.config.TopMenu;
import com.gnv.vnm.selfcare.webportal.model.UserRegistrationForm;
import com.gnv.vnm.selfcare.webportal.validator.ChangePasswordValidator;

/**
 * @author nandipinto
 *
 */

@Controller
public class ChangePasswordController extends WebPortalBaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(ChangePasswordController.class);
	
	@Autowired private ChangePasswordValidator changePasswordValidator;
	
	@GetMapping(value = "/secure/changepwd")
	public String showForm(Model model, Principal authUser, Locale locale, HttpServletRequest request){
		
		UserRegistrationForm form = new UserRegistrationForm();
		form.setPhoneNumber(authUser.getName());
		
		try {
			subscriberManagementService.generateOTP(authUser.getName(), true, locale.getLanguage());
		} catch (ExternalSubscriberException e) {
			
		}
		
		setSessionData(model, request, getProfile(request, authUser), locale);
		setActiveTopMenu(model, TopMenu.ACCOUNT);

		model.addAttribute("changePasswordForm", form);
		
		return ScreenNames.CHANGE_PASSWORD;
	}
	
	@PostMapping(value = "/secure/changepwd/confirm")
	public String confirm(Model model, @ModelAttribute(name = "changePasswordForm") UserRegistrationForm userRegistrationForm,
			BindingResult result, Locale locale, HttpServletRequest request, Principal authUser) {
		
		setActiveTopMenu(model, TopMenu.ACCOUNT);

		String message = "";
		Integer done = 0;

		changePasswordValidator.validate(userRegistrationForm, result);
		
		if (result.hasErrors()){
			model.addAttribute("is_done", 0);
			return ScreenNames.CHANGE_PASSWORD;
		}

		try {
			subscriberManagementService.resetPassword(userRegistrationForm.getPhoneNumber(), userRegistrationForm.getPassword(), userRegistrationForm.getOtp());
			done = 1;

			message = resolveMessage(messageSource, "Message.ChangePasswordSuccess", null, DefaultWebPortalMessages.CHANGE_PASSWORD_SUCCESS.message(), locale);
			
		} catch (ExternalSubscriberException e) {
			message = resolveMessage(messageSource, "Message.InvalidPhoneNumber", null, 
					DefaultWebPortalMessages.INVALID_PHONE_NUMBER.message(), locale);

		} catch (SubscriberNotFoundException e) {
			message = resolveMessage(messageSource, "Message.PhoneNumberNotRegistered", null, 
					DefaultWebPortalMessages.PHONE_NUMBER_NOT_REGISTERED.message(), locale);

		} catch (InvalidTokenException e) {
			message = resolveMessage(messageSource, "Message.InvalidOTP", null, DefaultWebPortalMessages.INVALID_OTP.message(), locale);
			logger.error("#confirm -- invalid OTP entered= " + userRegistrationForm.getOtp() + ", MSISDN= " + userRegistrationForm.getPhoneNumber());

		} catch (InvalidPasswordFormatException e) {
			message = resolveMessage(messageSource, "Message.InvalidPasswordFormat", null, DefaultWebPortalMessages.INVALID_PASSWORD_FORMAT.message(), locale);
			
		} catch (Exception e) {
			message = resolveMessage(messageSource, "Message.InternalError", null, DefaultWebPortalMessages.INTERNAL_ERROR.message(), locale);
			logger.error("#confirm -- error processing change password request, MSISDN= " + userRegistrationForm.getPhoneNumber(), e);

		}
		
		setSessionData(model, request, getProfile(request, authUser), locale);
		
		model.addAttribute("message", message);
		model.addAttribute("is_done", done);
		
		return ScreenNames.CHANGE_PASSWORD;
	}

}
