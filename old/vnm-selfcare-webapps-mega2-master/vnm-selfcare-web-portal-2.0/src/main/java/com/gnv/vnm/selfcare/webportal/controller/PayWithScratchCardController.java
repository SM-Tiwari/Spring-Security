/**
 * TopUpWitchVoucherController.java
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
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gnv.vnm.selfcare.core.adapter.RechargeResponse;
import com.gnv.vnm.selfcare.core.enums.ClientAppId;
import com.gnv.vnm.selfcare.core.enums.TibcoResponse;
import com.gnv.vnm.selfcare.core.service.TibcoServiceProvider;
import com.gnv.vnm.selfcare.core.utils.LoggingUtil;
import com.gnv.vnm.selfcare.dao.entity.QTopUpHistoryEntity;
import com.gnv.vnm.selfcare.dao.repo.TopUpHistoryRepository;
import com.gnv.vnm.selfcare.webportal.config.DefaultWebPortalMessages;
import com.gnv.vnm.selfcare.webportal.config.ScreenNames;
import com.gnv.vnm.selfcare.webportal.config.TopMenu;
import com.gnv.vnm.selfcare.webportal.model.VoucherTopUpForm;

import nl.captcha.Captcha;

/**
 * @author nandipinto
 *
 */

@Controller
public class PayWithScratchCardController extends WebPortalBaseController {

	private static final Logger logger = LoggerFactory.getLogger(PayWithScratchCardController.class);
	
	static final String PIN_CODE_REGEX = "^\\d{4}-?\\d{4}-?\\d{4}$";
	static final String PHONE_NO_REGEX = "((018)|(092))[0-9]{7,8}";
	
	@Autowired 
	private TopUpHistoryRepository topUpHistoryRepository;
	
	
	private VoucherTopUpValidator validator = new VoucherTopUpValidator();
	
	@GetMapping(value = "/secure/scardbillpmt")
	public String showForm(Model model, Principal authUser, HttpServletRequest request, Locale locale){
		
		profile = getProfile(request, authUser, locale);
		
		VoucherTopUpForm voucherTopUp = new VoucherTopUpForm();
		voucherTopUp.setMsisdn(authUser.getName());
		model.addAttribute("is_done", 0);
		model.addAttribute("voucherTopUp", voucherTopUp);
		model.addAttribute("outstandingBalance", tibcoServiceProvider.getCurrentOutstandingBalance(authUser.getName()));
		setSessionData(model, request, profile, locale);
		setActiveTopMenu(model, TopMenu.HOME);

		model.addAttribute("outstandingBalance", tibcoServiceProvider.getCurrentOutstandingBalance(authUser.getName()));

		return ScreenNames.POSTPAID_PAY_WITH_SCRATCH_CARD;
	}
	
	//add GET supports to accommodate switch language in the middle of form entry
	@RequestMapping(value = "/secure/scardbillpmt/validate", method = {RequestMethod.POST, RequestMethod.GET})
	public String validate(Model model, @ModelAttribute(name = "voucherTopUp") VoucherTopUpForm voucherTopUp, BindingResult result,
			HttpServletRequest request, Locale locale, Principal authUser){
		
		int done = 0;
		String message = "";
		
		setSessionData(model, request, getProfile(request, authUser, locale), locale);
		setActiveTopMenu(model, TopMenu.HOME);
		
		validator.setRequest(request);
		validator.validate(voucherTopUp, result);
		
		if (result.hasErrors()){
			model.addAttribute("voucherTopUp", voucherTopUp);
			model.addAttribute("is_done", 0);
		
			return ScreenNames.POSTPAID_PAY_WITH_SCRATCH_CARD;
		}

		RechargeResponse rechargeResponse = backEndRequestProcessor.topUpWithScratchCard(authUser.getName(),
				voucherTopUp.getCode().replaceAll("-", ""), voucherTopUp.getMsisdn(), ClientAppId.WEB_APP, "BILL_PMT", request.getSession().getId());
		
		if (rechargeResponse.getCode().equals(TibcoResponse.SUCCESS.code()) && rechargeResponse.getBalance() > 0){
			done = 1;

			message = resolveMessage(messageSource, "Message.PayWithScratchCard.Success", new Object[]{rechargeResponse.getBalance()},
					String.format(DefaultWebPortalMessages.TOPUP_SUCCESS.message(), "" + rechargeResponse.getBalance()), locale);
			
			if (!authUser.getName().equals(voucherTopUp.getMsisdn())) {
				model.addAttribute("topup_for_other", "1");
			}

		}else{
			if (rechargeResponse.getCode().equals(TibcoResponse.VOUCHER_IS_ALREADY_CONSUMED.code())) {
				message = resolveMessage(messageSource, "Message.PayWithScratchCard.PinCodeAlreadyUsed", null,
						DefaultWebPortalMessages.TOPUP_PIN_CODE_ALREADY_USED.message(), locale);
				
			} else if (rechargeResponse.getCode().equals(TibcoResponse.VOUCHER_PIN_NOT_FOUND_IN_DB.code())) {
				message = resolveMessage(messageSource, "Message.PayWithScratchCard.InvalidPinCode", null,
						DefaultWebPortalMessages.TOPUP_INVALID_PIN_CODE.message(), locale);
				
			} else {
				message = resolveMessage(messageSource, "Message.PayWithScratchCard.Fail", null,
						DefaultWebPortalMessages.TOPUP_FAIL.message(), locale);
			}
		}
		
		model.addAttribute("message", message);
		model.addAttribute("is_done", done);
		
		return ScreenNames.POSTPAID_PAY_WITH_SCRATCH_CARD;
	}
	
	private boolean voucherCodeAlreadyUsed(String code){
		if (!StringUtils.hasText(code)) return false;
		
		long count = 0;
		try {
			count  = topUpHistoryRepository.count(QTopUpHistoryEntity.topUpHistoryEntity.voucherCode.eq(code));
		} catch (Exception e) {
			logger.error("#voucherCodeAlreadyUsed --- error occured when validating voucher code!", e);
		}
		return count > 0;
	}
	
	@ModelAttribute("pincode_regex")
	public String pinCodeRegex() {
		return applicationConfigurationService.get("topup.scratchcard.regex", PIN_CODE_REGEX, false).toString();
	}
	
	@ModelAttribute("phone_regex")
	public String phoneNumberRegex() {
		return applicationConfigurationService.get("phonenumber.regex", PHONE_NO_REGEX, false).toString();
	}
	
	class VoucherTopUpValidator implements Validator {
		
		@Autowired TopUpHistoryRepository topUpHistoryRepository;
		private HttpServletRequest request;

		/**
		 * @param request the request to set
		 */
		public void setRequest(HttpServletRequest request) {
			this.request = request;
		}

		/* (non-Javadoc)
		 * @see org.springframework.validation.Validator#supports(java.lang.Class)
		 */
		@Override
		public boolean supports(Class<?> clazz) {
			return VoucherTopUpForm.class.isAssignableFrom(clazz);
		}

		/* (non-Javadoc)
		 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
		 */
		@Override
		public void validate(Object target, Errors errors) {
			VoucherTopUpForm form = (VoucherTopUpForm)target;
			
			if (!StringUtils.hasText(form.getCode()) || !form.getCode().replaceAll("-", "").matches(pinCodeRegex())){
				errors.rejectValue("code", "Message.PayWithScratchCard.IncompletePinCode", DefaultWebPortalMessages.TOPUP_INCOMPLETE_PIN_CODE.message());
			}
			
			if (voucherCodeAlreadyUsed(form.getCode())){
				errors.rejectValue("code", "Message.PayWithScratchCard.PinCodeAlreadyUsed", DefaultWebPortalMessages.TOPUP_PIN_CODE_ALREADY_USED.message());
			}
			
			if (!subscriberManagementService.isVnmNumber(form.getMsisdn())){
				errors.rejectValue("msisdn", "Message.PayWithScratchCard.InvalidMsisdn", DefaultWebPortalMessages.TOPUP_INVALID_MSISDN.message());
			}
			
			Captcha captchaSession = (Captcha) request.getSession().getAttribute(Captcha.NAME);
			boolean captchaValid = captchaSession.isCorrect(form.getCaptcha());
			
			LoggingUtil.debug(logger, "#validate --- captchaValid= " + captchaValid);
			
			if (!captchaValid){
				errors.rejectValue("msisdn", "Message.PayWithScratchCard.InvalidCaptchaAnswer", DefaultWebPortalMessages.TOPUP_INVALID_CAPTCHA.message());
			}

		}
	}
}
