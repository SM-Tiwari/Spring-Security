/**
 * SignUpController.java
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
import org.springframework.security.crypto.password.PasswordEncoder;
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
import com.gnv.vnm.selfcare.core.fault.InvalidTokenException;
import com.gnv.vnm.selfcare.core.utils.LoggingUtil;
import com.gnv.vnm.selfcare.webportal.config.DefaultWebPortalMessages;
import com.gnv.vnm.selfcare.webportal.config.ScreenNames;
import com.gnv.vnm.selfcare.webportal.model.UserRegistrationForm;
import com.gnv.vnm.selfcare.webportal.validator.UserRegistrationValidator;

/**
 * @author nandipinto
 *
 */

@Controller
public class SignUpController extends WebPortalBaseController{
	
	private static final Logger logger = LoggerFactory.getLogger(SignUpController.class);
	
	private static final String CURRENT_MSISDN = "CURRENT_MSISDN";
	
	@Autowired UserRegistrationValidator userRegistrationValidator;
	@Autowired PasswordEncoder passwordEncoder;
	@Autowired SessionLocaleResolver localeResolver;

	
	@RequestMapping(value = "/signup", method = {RequestMethod.GET, RequestMethod.POST})
	public String showForm(Model model, HttpServletRequest request){
		
		UserRegistrationForm signUpForm = new UserRegistrationForm();
		model.addAttribute("signUpForm", signUpForm);
		
		return ScreenNames.INIT_SIGN_UP;
	}
	
	@PostMapping(value = "/signup/next")
	public String register(Model model, 
			@ModelAttribute(name = "signUpForm") UserRegistrationForm userRegistrationForm, BindingResult result, 
			@RequestParam(defaultValue = "") String lang,
			Locale locale, 
			HttpServletRequest request, HttpServletResponse response){

		
		if (StringUtils.hasText(lang)) {
			locale = new Locale(lang);
			localeResolver.setLocale(request, response, locale);
			return ScreenNames.INIT_SIGN_UP;
			
		} else {
			String message = "";
			
			if (subscriberManagementService.isActiveSubscriber(userRegistrationForm.getPhoneNumber())) {
				result.rejectValue("phoneNumber", "Message.PhoneNumberAlreadyRegistered", null, DefaultWebPortalMessages.PHONE_NUMBER_ALREADY_REGISTERED.message());
				return ScreenNames.INIT_SIGN_UP;
			}

			try {
				String otp = subscriberManagementService.generateOTP(userRegistrationForm.getPhoneNumber(), true, locale.getLanguage());
				
				LoggingUtil.debug(logger, String.format("#next --- MSISDN= %s, OTP= %s", userRegistrationForm.getPhoneNumber(), otp));
				
				message = resolveMessage(messageSource, "Message.OTPSent", null, DefaultWebPortalMessages.OTP_SENT.message(), locale);
				model.addAttribute("message", message);

				request.getSession(true).setAttribute(CURRENT_MSISDN, userRegistrationForm.getPhoneNumber());
				
				return ScreenNames.CONFIRM_SIGN_UP;

			} catch (ExternalSubscriberException e) {
				message = resolveMessage(messageSource, "Message.InvalidPhoneNumber", null, DefaultWebPortalMessages.INVALID_PHONE_NUMBER.message(), locale);
				model.addAttribute("message", message);
				
				return ScreenNames.INIT_SIGN_UP;
			}
		}
	}
	
	@PostMapping(value = "/signup/confirm")
	public String confirm(Model model, @ModelAttribute(name = "signUpForm") UserRegistrationForm userRegistrationForm, BindingResult result,
			@RequestParam(defaultValue = "") String lang,
			Locale locale, HttpServletRequest request, HttpServletResponse response) {
		
		
		String message = "";
		Integer done = 0;
		
		if (StringUtils.hasText(lang)) {
			locale = new Locale(lang);
			localeResolver.setLocale(request, response, locale);
			return ScreenNames.CONFIRM_SIGN_UP;
			
		} else {
			
			userRegistrationValidator.validate(userRegistrationForm, result);
			if (result.hasErrors()) {
				return ScreenNames.CONFIRM_SIGN_UP;
			}
			
			try {
				subscriberManagementService.confirmRegistration(userRegistrationForm.getPhoneNumber(),
						userRegistrationForm.getPassword(), userRegistrationForm.getOtp());
				
				done = 1;
				message = resolveMessage(messageSource, "Message.SignUpSuccess", new String[]{request.getContextPath() + "/login"}, 
						String.format(DefaultWebPortalMessages.SIGNUP_SUCCESS.message(), request.getContentLength() + "/login"), locale);

			} catch (InvalidTokenException e1) {
				message = resolveMessage(messageSource, "Message.InvalidOTP", null, DefaultWebPortalMessages.INVALID_OTP.message(), locale);
				logger.error("#confirm -- invalid OTP entered= " + userRegistrationForm.getOtp() + ", MSISDN= " + userRegistrationForm.getPhoneNumber());

			} catch (Exception e1) {
				message = resolveMessage(messageSource, "Message.InternalError", null, DefaultWebPortalMessages.INTERNAL_ERROR.message(), locale);
				logger.error("#confirm -- error processing sign up, MSISDN= " + userRegistrationForm.getPhoneNumber(), e1);
			}
			
			model.addAttribute("message", message);
			model.addAttribute("is_done", done);
			
			return ScreenNames.CONFIRM_SIGN_UP;
		}
	}
	
//	@GetMapping(value = "/getotp/{msisdn}")
//  public ResponseEntity<?> getOTP(@PathVariable String msisdn, Locale locale){
	@GetMapping(value = "/signup/otp")
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
}
