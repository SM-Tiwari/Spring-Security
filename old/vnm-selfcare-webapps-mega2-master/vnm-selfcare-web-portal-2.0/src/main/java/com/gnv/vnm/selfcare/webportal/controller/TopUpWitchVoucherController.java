/**
 * TopUpWitchVoucherController.java
 */
package com.gnv.vnm.selfcare.webportal.controller;

import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gnv.vnm.selfcare.core.adapter.RechargeResponse;
import com.gnv.vnm.selfcare.core.enums.ClientAppId;
import com.gnv.vnm.selfcare.core.enums.TibcoResponse;
import com.gnv.vnm.selfcare.core.model.ScratchStatusModel;
import com.gnv.vnm.selfcare.core.utils.LoggingUtil;
import com.gnv.vnm.selfcare.dao.entity.QTopUpHistoryEntity;
import com.gnv.vnm.selfcare.dao.entity.ScratchBlockHistoryEntity;
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
public class TopUpWitchVoucherController extends WebPortalBaseController {

	private static final Logger logger = LoggerFactory.getLogger(TopUpWitchVoucherController.class);
	
	static final String PIN_CODE_REGEX = "^\\d{4}-?\\d{4}-?\\d{4}$";
	static final String PHONE_NO_REGEX = "((018)|(092))[0-9]{7,8}";
	
	@Autowired 
	private TopUpHistoryRepository topUpHistoryRepository;
	private VoucherTopUpValidator validator = new VoucherTopUpValidator();
	
	@GetMapping(value = "/secure/vtopup")
	public String showForm(Model model, Principal authUser, HttpServletRequest request, Locale locale){
		
		VoucherTopUpForm voucherTopUp = new VoucherTopUpForm();
		voucherTopUp.setMsisdn(authUser.getName());
		model.addAttribute("is_done", 0);
		model.addAttribute("voucherTopUp", voucherTopUp);
		
		setSessionData(model, request, getProfile(request, authUser), locale);
		setActiveTopMenu(model, TopMenu.HOME);

		String petieFlag = request.getParameter("petie");
		if (petieFlag != null && petieFlag.equals("1")) {
			request.getSession().setAttribute("last_topup_was_petie_triggered", petieFlag);
		}
		return ScreenNames.SCRATCH_CARD;
	}
	/*Changes By OneClick 10-07-2018 Start*/
	@RequestMapping(value = "/secure/vtopup/validate", method = { RequestMethod.POST, RequestMethod.GET })
    public String validate(Model model, @ModelAttribute(name = "voucherTopUp") VoucherTopUpForm voucherTopUp,
                  BindingResult result, HttpServletRequest request, Locale locale, Principal authUser) {

           int done = 0;
           long time = 0;
           int count = 0;
           String message = "";
           String blockstatus = "";
           String blocktime = null;
           ScratchStatusModel scratchStatusModel=null;
           setSessionData(model, request, getProfile(request, authUser), locale);
           setActiveTopMenu(model, TopMenu.HOME);

             scratchStatusModel = backEndRequestProcessor.checkBlockUnblockTopUp(authUser.getName());

           Date datecurrent = new Date();
           DateFormat dateFormater = new SimpleDateFormat("dd-MM-yyyy HH:mm");
           String currenttime = dateFormater.format(datecurrent.getTime());
           blocktime = scratchStatusModel.getTimeStamp();
           blockstatus = scratchStatusModel.getStatus();

           if (blocktime != null) {
                  time = TimeDiff(blocktime, currenttime);
           }
           if (blockstatus.equalsIgnoreCase("1") && (time >= 24)) {
                  backEndRequestProcessor.saveScratchStatus(authUser.getName(), 0, "0", currenttime);
                    scratchStatusModel = backEndRequestProcessor.checkBlockUnblockTopUp(authUser.getName());
           }
           if (scratchStatusModel.getStatus().equalsIgnoreCase("0")) {
                  validator.setRequest(request);
                  validator.validate(voucherTopUp, result);

                  if (result.hasErrors()) {
                        model.addAttribute("voucherTopUp", voucherTopUp);
                        model.addAttribute("is_done", 0);
                        return ScreenNames.SCRATCH_CARD;
                  }

                  RechargeResponse rechargeResponse = backEndRequestProcessor.topUpWithScratchCard(authUser.getName(),voucherTopUp.getCode().replaceAll("-", ""), voucherTopUp.getMsisdn(), ClientAppId.WEB_APP, null);

                  if (rechargeResponse.getCode().equals(TibcoResponse.SUCCESS.code()) && rechargeResponse.getBalance() > 0) {
                        done = 1;
                        message = resolveMessage(messageSource, "Message.Topup.Success",
                                      new Object[] { rechargeResponse.getBalance() },
                                      String.format(DefaultWebPortalMessages.TOPUP_SUCCESS.message(),
                                                    "" + rechargeResponse.getBalance()),
                                      locale);

                        if (!authUser.getName().equals(voucherTopUp.getMsisdn())) {
                               model.addAttribute("topup_for_other", "1");
                        }

                        ScratchBlockHistoryEntity scratchBlockHistoryEntity = new ScratchBlockHistoryEntity();

                        scratchBlockHistoryEntity.setCount(0);
                        scratchBlockHistoryEntity.setId(0);
                        scratchBlockHistoryEntity.setMsisdn(authUser.getName());
                        scratchBlockHistoryEntity.setStatusMessage(message);
                        scratchBlockHistoryEntity.setTimeStamp(currenttime);
                         backEndRequestProcessor.saveScratchCardInHistory(scratchBlockHistoryEntity);

                        backEndRequestProcessor.saveScratchStatus(authUser.getName(), 0, "0", currenttime);
                  } else {

                        if (rechargeResponse.getCode().equals(TibcoResponse.VOUCHER_IS_ALREADY_CONSUMED.code())) {
                               message = resolveMessage(messageSource, "Message.Topup.PinCodeAlreadyUsed", null,
                                             DefaultWebPortalMessages.TOPUP_PIN_CODE_ALREADY_USED.message(), locale);

                        } else if (rechargeResponse.getCode().equals(TibcoResponse.VOUCHER_PIN_NOT_FOUND_IN_DB.code())) {
                               message = resolveMessage(messageSource, "Message.Topup.InvalidPinCode", null,
                                             DefaultWebPortalMessages.TOPUP_INVALID_PIN_CODE.message(), locale);

                        } else {
                               message = resolveMessage(messageSource, "Message.Topup.Fail", null,
                                             DefaultWebPortalMessages.TOPUP_FAIL.message(), locale);
                        }

                  
                  ScratchBlockHistoryEntity scratchBlockHistoryEntity = new ScratchBlockHistoryEntity();
                  count = backEndRequestProcessor.getCountFromScratchBlock(authUser.getName());

                  if (count == 0) {
                        count = 1;
                  } else if (count != 0) {
                        count = count + 1;

                  }

                  scratchBlockHistoryEntity.setCount(count);
                  scratchBlockHistoryEntity.setId(0);
                  scratchBlockHistoryEntity.setMsisdn(authUser.getName());
                  scratchBlockHistoryEntity.setStatusMessage(message);
                  scratchBlockHistoryEntity.setTimeStamp(currenttime);
                  backEndRequestProcessor.saveScratchCardInHistory(scratchBlockHistoryEntity);

                  if (count != 5) {

                        backEndRequestProcessor.saveScratchStatus(authUser.getName(), count, "0", currenttime);
                  }

                  else if (count == 5) {

                        backEndRequestProcessor.saveScratchStatus(authUser.getName(), count, "1", currenttime);
                       // message = "You have exceeded the limit unsuccessful top-up by Scratch Card. The feature is blocked for next 24 hours.";
                        if(locale.getLanguage().equalsIgnoreCase("en")){
            				message = "You have exceeded the limit unsuccessful top-up by Scratch Card. The feature is blocked for next 24 hours.";
            				}
            				else{
            					message = "Bạn đã vượt quá giới hạn không thành công khi nạp thẻ cào. Tính năng này bị chặn trong 24 giờ tới.";
            				}
                  }
                  }
                  model.addAttribute("message", message);

                  model.addAttribute("is_done", done);
                  //return ScreenNames.SCRATCH_CARD;
           }else{
                 // message = "You have exceeded the limit unsuccessful top-up by Scratch Card. The feature is blocked for next 24 hours.";
        	   if(locale.getLanguage().equalsIgnoreCase("en")){
   				message = "You have exceeded the limit unsuccessful top-up by Scratch Card. The feature is blocked for next 24 hours.";
   				}
   				else{
   					message = "Bạn đã vượt quá giới hạn không thành công khi nạp thẻ cào. Tính năng này bị chặn trong 24 giờ tới.";
   				}  
        	   model.addAttribute("message", message);

                  model.addAttribute("is_done", done);
                  //return ScreenNames.SCRATCH_CARD;
           }

           return ScreenNames.SCRATCH_CARD;
    }
	public long TimeDiff(String first_time, String second_time) {
        DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date d1 = null;
        Date d2 = null;
        long diffHours = 0;
        try {
               d1 = dateFormat1.parse(first_time);
               d2 = dateFormat1.parse(second_time);

               // in milliseconds
               long diff = (int) (d2.getTime() - d1.getTime());

               diffHours = diff / (60 * 60 * 1000);

               System.out.print(diffHours + " hours, ");

        } catch (Exception e) {
               e.printStackTrace();
        }

        return diffHours;

 }

	/*Changes By OneClick 10-07-2018 End*/
/*	//add GET supports to accommodate switch language in the middle of form entry
	@RequestMapping(value = "/secure/vtopup/validate", method = {RequestMethod.POST, RequestMethod.GET})
	public String validate(Model model, @ModelAttribute(name = "voucherTopUp") VoucherTopUpForm voucherTopUp, BindingResult result,
			HttpServletRequest request, Locale locale, Principal authUser){
		
		int done = 0;
		String message = "";
		
		setSessionData(model, request, getProfile(request, authUser), locale);
		setActiveTopMenu(model, TopMenu.HOME);
		
		validator.setRequest(request);
		validator.validate(voucherTopUp, result);
		
		if (result.hasErrors()){
			model.addAttribute("voucherTopUp", voucherTopUp);
			model.addAttribute("is_done", 0);
		
			return ScreenNames.SCRATCH_CARD;
		}

		String referrer = null;
		String petieFlag = (String)request.getSession().getAttribute("last_topup_was_petie_triggered");
		if (petieFlag != null && petieFlag.equals("1")) {
			referrer = TOPUP_REFERER_PETIE;
		}
			
		RechargeResponse rechargeResponse = backEndRequestProcessor.topUpWithScratchCard(authUser.getName(),
				voucherTopUp.getCode().replaceAll("-", ""), voucherTopUp.getMsisdn(), ClientAppId.WEB_APP, referrer, request.getSession().getId());
		
		if (rechargeResponse.getCode().equals(TibcoResponse.SUCCESS.code()) && rechargeResponse.getBalance() > 0){
			done = 1;

			message = resolveMessage(messageSource, "Message.Topup.Success", new Object[]{rechargeResponse.getBalance()},
					String.format(DefaultWebPortalMessages.TOPUP_SUCCESS.message(), "" + rechargeResponse.getBalance()), locale);
			
			if (!authUser.getName().equals(voucherTopUp.getMsisdn())) {
				model.addAttribute("topup_for_other", "1");
			}

		}else{
			if (rechargeResponse.getCode().equals(TibcoResponse.VOUCHER_IS_ALREADY_CONSUMED.code())) {
				message = resolveMessage(messageSource, "Message.Topup.PinCodeAlreadyUsed", null,
						DefaultWebPortalMessages.TOPUP_PIN_CODE_ALREADY_USED.message(), locale);
				
			} else if (rechargeResponse.getCode().equals(TibcoResponse.VOUCHER_PIN_NOT_FOUND_IN_DB.code())) {
				message = resolveMessage(messageSource, "Message.Topup.InvalidPinCode", null,
						DefaultWebPortalMessages.TOPUP_INVALID_PIN_CODE.message(), locale);
				
			} else {
				message = resolveMessage(messageSource, "Message.Topup.Fail", null,
						DefaultWebPortalMessages.TOPUP_FAIL.message(), locale);
			}
		}
		
		model.addAttribute("message", message);
		model.addAttribute("is_done", done);
		
		return ScreenNames.SCRATCH_CARD;
	}
	*/
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
	
	@RequestMapping(value = "/validcaptcha/{code}")
	public ResponseEntity<?> validateCaptcha(HttpServletRequest request, @PathVariable String code){
		Captcha captchaSession = (Captcha) request.getSession().getAttribute(Captcha.NAME);
		return new ResponseEntity<>(captchaSession.isCorrect(code) ? "1":"0", HttpStatus.OK);
	}
	
	@ModelAttribute("pincode_regex")
	public String pinCodeRegex() {
		return applicationConfigurationService.get("topup.scratchcard.regex", PIN_CODE_REGEX).toString();
	}
	
	@ModelAttribute("phone_regex")
	public String phoneNumberRegex() {
		return applicationConfigurationService.get("phonenumber.regex", PHONE_NO_REGEX).toString();
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
				errors.rejectValue("code", "Message.Topup.IncompletePinCode", DefaultWebPortalMessages.TOPUP_INCOMPLETE_PIN_CODE.message());
			}
			
			if (voucherCodeAlreadyUsed(form.getCode())){
				errors.rejectValue("code", "Message.Topup.PinCodeAlreadyUsed", DefaultWebPortalMessages.TOPUP_PIN_CODE_ALREADY_USED.message());
			}
			
			if (!subscriberManagementService.isVnmNumber(form.getMsisdn())){
				errors.rejectValue("msisdn", "Message.InvalidPhoneNumber", DefaultWebPortalMessages.TOPUP_INVALID_MSISDN.message());
			}
			
			Captcha captchaSession = (Captcha) request.getSession().getAttribute(Captcha.NAME);
			boolean captchaValid = captchaSession.isCorrect(form.getCaptcha());
			
			LoggingUtil.debug(logger, "#validate --- captchaValid= " + captchaValid);
			
			if (!captchaValid){
				errors.rejectValue("msisdn", "Message.Topup.InvalidCaptchaAnswer", DefaultWebPortalMessages.TOPUP_INVALID_CAPTCHA.message());
			}

		}
	}
}
