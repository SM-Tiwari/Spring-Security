/**
 * ETopupController.java
 */
package com.gnv.vnm.selfcare.webportal.controller;

import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gnv.vnm.selfcare.core.AppDefaultValues;
import com.gnv.vnm.selfcare.core.enums.ClientAppId;
import com.gnv.vnm.selfcare.core.enums.TransactionStatus;
import com.gnv.vnm.selfcare.core.enums.TransactionType;
import com.gnv.vnm.selfcare.core.model.Balance;
import com.gnv.vnm.selfcare.core.model.TopUpHistory;
import com.gnv.vnm.selfcare.core.utils.AppUtils;
import com.gnv.vnm.selfcare.webportal.config.ScreenNames;
import com.gnv.vnm.selfcare.webportal.model.ETopupStatus;

/**
 * @author nandipinto
 *
 */

@Controller
@RequestMapping(value = "/secure/etopup")
public class ETopupController extends WebPortalBaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(ETopupController.class);
	
	public static final String REFERER_PETIE = "PETIE"; 
	
	static final String IMG_STRING = "_r/images/";
	
	@GetMapping(value = "/init/{msisdn}/{amount}")
	public ResponseEntity<?> init(@PathVariable String msisdn, @PathVariable double amount, HttpServletRequest request){
		
		String itemCode = "ETOPUP_" + msisdn + "_" + AppUtils.dateToString(new Date(), "yyyyMMddHHmmssS");
		String orderId = "-1";
		
		String petieFlag = request.getParameter("petie");
		String referrer = null;
		if (petieFlag != null && petieFlag.equalsIgnoreCase("1")) {
			referrer = TOPUP_REFERER_PETIE;
			request.getSession().setAttribute("last_topup_was_petie_triggered", petieFlag);
		}

		try {
			orderId = paymentGatewayService.initTransaction(msisdn, itemCode, amount, ClientAppId.WEB_APP,
					TransactionType.E_TOPUP, null, referrer, request.getSession().getId());
		} catch (Exception e) {
			logger.error("#init --- could not initiate eTopUp!", e);
		}
		return new ResponseEntity<>(orderId, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/pay/{orderId}", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView executePayment(@PathVariable String orderId, Locale locale, HttpServletRequest request, HttpServletResponse resp) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		String language = "VN";
		
		if (locale != null) {
			if (locale.getLanguage().equalsIgnoreCase(AppDefaultValues.LANGUAGE_ENGLISH)) {
				language = "E";
			}
		}
		String response = paymentGatewayService.executeTransaction(orderId, ClientAppId.WEB_APP, language);
		if (StringUtils.hasText(response)) {
			
			mv.setViewName(ScreenNames.PAYMENT_GW_CONTAINER);
			mv.addObject("pgResponse", modifyResponse(response, request));
			
			request.getSession(true).setAttribute(ETOPUP_SESSION, new ETopupStatus(orderId, TransactionStatus.PROCESSING));
			
		} else {
			mv = new ModelAndView(ScreenNames.PAYMENT_GW_ERROR);
		}
		
		return mv;
	}
	
	private String modifyResponse(String response, HttpServletRequest request){
		try {
			String modifiedResponse = response.replace(IMG_STRING, request.getContextPath() + "/static/assets/image/");
			return modifiedResponse;
		} catch (Exception e) {
			logger.error("#modifyResponse --- error modifying response string!", e);
		}
		return response;
	}
	
	@GetMapping(value = "/status/{orderId}")
	public ResponseEntity<?> getStatus(@PathVariable String orderId, HttpServletRequest request, Locale locale){
		
		ETopupStatus etopupStatus = new ETopupStatus();
		etopupStatus.setRefTrxId(orderId);

		String message = "";
		TopUpHistory th = backEndRequestProcessor.getInternalTopUpHistoryByRefTrxId(orderId);
		if (th != null) {
			TransactionStatus status = th.getStatus();
			if (status.ordinal() > TransactionStatus.PROCESSING.ordinal()) {
				try {
					request.getSession().removeAttribute(ETOPUP_SESSION);
				} catch (Exception e) {}
			}

			if (status.equals(TransactionStatus.SUCCESS)) {
				Balance balance = backEndRequestProcessor.getCoreBalance(th.getMsisdn());
				message = resolveMessage(messageSource, "Message.Topup.Success", new Integer[] { balance.getAvailableValue() }, 
						String.format("Topup successful. The updated balance is %d dong.", balance.getAvailableValue()), locale);
				
			} else {
				if (status.equals(TransactionStatus.CANCELED)) {
					message = resolveMessage(messageSource, "Message.TransactionCanceled", null, "Your transaction has been canceled.", locale);
					
				} else if (status.equals(TransactionStatus.FAIL) || status.equals(TransactionStatus.NOT_FOUND)
						|| status.equals(TransactionStatus.ROLL_BACK) || status.equals(TransactionStatus.TIME_OUT)) {
					
					message = resolveMessage(messageSource, "Message.Topup.Fail", null, "Recharge unsuccessful, please try again.", locale);
				}
			}
			etopupStatus.setStatus(status);
			etopupStatus.setMessage(message);
		}
		return new ResponseEntity<>(etopupStatus, HttpStatus.OK);
//		return new ResponseEntity<>(paymentGatewayService.getTransactionStatus(orderId).ordinal(), HttpStatus.OK);
	}

}
