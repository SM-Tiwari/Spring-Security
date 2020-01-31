/**
 * ForgotPasswordController.java
 */
package com.gnv.vnm.selfcare.webportal.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.gnv.vnm.selfcare.core.fault.ExternalSubscriberException;
import com.gnv.vnm.selfcare.core.fault.InvalidPasswordFormatException;
import com.gnv.vnm.selfcare.core.fault.InvalidTokenException;
import com.gnv.vnm.selfcare.core.fault.SubscriberNotFoundException;
import com.gnv.vnm.selfcare.webportal.config.DefaultWebPortalMessages;
import com.gnv.vnm.selfcare.webportal.config.ScreenNames;
import com.gnv.vnm.selfcare.webportal.model.UserRegistrationForm;
import com.gnv.vnm.selfcare.webportal.validator.ForgotPasswordValidator;

/**
 * @author nandipinto
 *
 */

@Controller
public class ForgotPasswordController extends WebPortalBaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(ForgotPasswordController.class);

	private static final String CURRENT_MSISDN = "CURRENT_MSISDN";
	
	@Autowired ForgotPasswordValidator forgotPasswordValidator;
	@Autowired SessionLocaleResolver localeResolver;
	
	@RequestMapping(value = "/forgotpwd", method = {RequestMethod.POST, RequestMethod.GET})
	public String showForm(Model model, HttpServletRequest request){
		model.addAttribute("changePasswordForm", new UserRegistrationForm());
		return ScreenNames.INIT_CHANGE_PASSWORD;
	}

	@RequestMapping(value = "/forgotpwd/next", method = {RequestMethod.POST, RequestMethod.GET})
	public String sendOtp(Model model, @ModelAttribute(name = "changePasswordForm") UserRegistrationForm userRegistrationForm, 
			@RequestParam(defaultValue = "") String lang,
			Locale locale, 
			HttpServletRequest request, HttpServletResponse response){

		
		if (StringUtils.hasText(lang)) {
			locale = new Locale(lang);
			localeResolver.setLocale(request, response, locale);
			return ScreenNames.INIT_CHANGE_PASSWORD;
			
		} else {
			String message = "";
			
			if (!subscriberManagementService.isActiveSubscriber(userRegistrationForm.getPhoneNumber())){
				message = resolveMessage(messageSource, "Message.PhoneNumberNotRegistered", null, 
						DefaultWebPortalMessages.PHONE_NUMBER_NOT_REGISTERED.message(), locale);
				
				model.addAttribute("message", message);
				
				return ScreenNames.INIT_CHANGE_PASSWORD;
			}

			model.addAttribute("is_done", 0);
			try {
				subscriberManagementService.generateOTP(userRegistrationForm.getPhoneNumber(), true, locale.getLanguage());
				
				request.getSession(true).setAttribute(CURRENT_MSISDN, userRegistrationForm.getPhoneNumber());
				
				return ScreenNames.CONFIRM_CHANGE_PASSWORD;
				
			} catch (ExternalSubscriberException e) {
				message = resolveMessage(messageSource, "Message.InvalidPhoneNumber", null, DefaultWebPortalMessages.INVALID_PHONE_NUMBER.message(), locale);
				model.addAttribute("message", message);

				return ScreenNames.INIT_CHANGE_PASSWORD;
			}
		}
	}
	
	@GetMapping(value = "/forgetpwd/otp")
	public ResponseEntity<?> getOTP(Locale locale, HttpServletRequest request){
		String otp = null;
		try {
			String msisdn = (String)request.getSession().getAttribute(CURRENT_MSISDN);
			if (msisdn != null) {
				otp = subscriberManagementService.generateOTP(msisdn, true, locale.getLanguage());
			}
		} catch (ExternalSubscriberException e) {
			logger.error(e.getMessage());
		}
		if (otp != null){
			return new ResponseEntity<>(otp, HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping(value = "/forgotpwd/confirm")
	public String confirm(Model model, @ModelAttribute(name = "changePasswordForm") UserRegistrationForm userRegistrationForm, BindingResult result, 
			@RequestParam(defaultValue = "") String lang,
			Locale locale, HttpServletRequest request, HttpServletResponse response) {
		
		
		if (StringUtils.hasText(lang)) {
			locale = new Locale(lang);
			localeResolver.setLocale(request, response, locale);
			
			return ScreenNames.CONFIRM_CHANGE_PASSWORD;
			
		} else {
			String message = "";
			Integer done = 0;

			forgotPasswordValidator.validate(userRegistrationForm, result);
			
			if (result.hasErrors()){
				model.addAttribute("is_done", done);
				return ScreenNames.CONFIRM_CHANGE_PASSWORD;
			}

			try {
				subscriberManagementService.resetPassword(userRegistrationForm.getPhoneNumber(), userRegistrationForm.getPassword(), userRegistrationForm.getOtp());
				done = 1;

				message = resolveMessage(messageSource, "Message.ResetPasswordSuccess", new String[]{request.getContextPath() + "/login"}, 
						String.format(DefaultWebPortalMessages.RESET_PASSWORD_SUCCESS.message(), request.getContentLength() + "/login"), locale);
				
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
			
			model.addAttribute("message", message);
			model.addAttribute("is_done", done);

			return ScreenNames.CONFIRM_CHANGE_PASSWORD;
		}

	}
}
