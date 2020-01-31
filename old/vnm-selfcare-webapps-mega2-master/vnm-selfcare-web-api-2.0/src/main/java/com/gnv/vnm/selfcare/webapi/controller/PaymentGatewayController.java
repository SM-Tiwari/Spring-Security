/**
 * PaymentGatewayController.java
 */
package com.gnv.vnm.selfcare.webapi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.NameValuePair;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.gnv.vnm.selfcare.core.enums.ClientAppId;
import com.gnv.vnm.selfcare.core.enums.TransactionStatus;
import com.gnv.vnm.selfcare.core.enums.TransactionType;
import com.gnv.vnm.selfcare.core.fault.OrderIdNotFoundException;
import com.gnv.vnm.selfcare.core.fault.TransactionInProgressException;
import com.gnv.vnm.selfcare.core.fault.TransactionNotFoundException;
import com.gnv.vnm.selfcare.core.model.Bank;
import com.gnv.vnm.selfcare.core.model.pg.FinalResponse;
import com.gnv.vnm.selfcare.core.model.pg.NapasErrorCode;
import com.gnv.vnm.selfcare.core.model.pg.PGResponseCode;
import com.gnv.vnm.selfcare.core.model.pg.RedirectResponse;
import com.gnv.vnm.selfcare.core.utils.AppUtils;
import com.gnv.vnm.selfcare.core.utils.LoggingUtil;
import com.gnv.vnm.selfcare.webapi.model.PGCallbackResponse;

/**
 * @author nandipinto
 *
 */

@Controller
public class PaymentGatewayController extends BaseRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(PaymentGatewayController.class);

	static final String NAPAS_SUCCESS_RESP = "0";
	
	static final String INIT_PG_VIEW = "InitPayment";
	static final String PG_RESP_VIEW = "PaymentResponse";
	static final String PAYMENT_RESULT = "PaymentResult";
	
	static final String IMG_STRING = "_r/images/";

	@GetMapping(value = "/trx/initpayment/{msisdn}/{itemCode}/{amount}/{trxType}")
	public ResponseEntity<?> initPayment(@PathVariable String msisdn, @PathVariable String itemCode,
			@PathVariable double amount, @PathVariable String trxType, 
			@RequestParam(defaultValue = "") String refPaymentNo,
			@RequestParam(defaultValue = "") String referrer) {
		/*
		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}*/

		TransactionType transactionType = TransactionType.E_TOPUP;
		try {
			transactionType = TransactionType.valueOf(trxType.toUpperCase());
		} catch (Exception e) {}
		
		if (transactionType.equals(TransactionType.E_TOPUP)) {
			itemCode = "ETOPUP_" + msisdn + "_" + AppUtils.dateToString(new Date(), "yyyyMMddHHmmss");
			
		} else if (transactionType.equals(TransactionType.POSTPAID_BILL_PAYMENT)) {
			itemCode = "POSTPAY_" + msisdn + "_" + AppUtils.dateToString(new Date(), "yyyyMMddHHmmss");
			
		} else if (transactionType.equals(TransactionType.POSTPAID_DEPOSIT)) {
			itemCode = "POSTDEP_" + msisdn + "_" + AppUtils.dateToString(new Date(), "yyyyMMddHHmmss");
		}
		String orderId = paymentGatewayService.initTransaction(msisdn, itemCode, amount, ClientAppId.MOBILE_APP, transactionType, refPaymentNo, referrer, null);

		return orderId == null ? new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR) : new ResponseEntity<>(orderId, HttpStatus.OK);
	}
	
	
	////created by oneclick 22_10_2018
	@GetMapping(value = "/trx/initpaymentdiscount/{msisdn}/{itemCode}/{amount}/{rechrgeamount}/{trxType}")
	public ResponseEntity<?> initPaymentDiscount(@PathVariable String msisdn, @PathVariable String itemCode,
			@PathVariable double amount,@PathVariable double rechrgeamount, @PathVariable String trxType, 
			@RequestParam(defaultValue = "") String refPaymentNo,
			@RequestParam(defaultValue = "") String referrer) {
		/*
		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}*/

		TransactionType transactionType = TransactionType.E_TOPUP;
		try {
			transactionType = TransactionType.valueOf(trxType.toUpperCase());
		} catch (Exception e) {}
		
		if (transactionType.equals(TransactionType.E_TOPUP)) {
			itemCode = "ETOPUP_" + msisdn + "_" + AppUtils.dateToString(new Date(), "yyyyMMddHHmmss");
			
		} else if (transactionType.equals(TransactionType.POSTPAID_BILL_PAYMENT)) {
			itemCode = "POSTPAY_" + msisdn + "_" + AppUtils.dateToString(new Date(), "yyyyMMddHHmmss");
			
		} else if (transactionType.equals(TransactionType.POSTPAID_DEPOSIT)) {
			itemCode = "POSTDEP_" + msisdn + "_" + AppUtils.dateToString(new Date(), "yyyyMMddHHmmss");
		}
		String orderId = paymentGatewayService.initTransactiondiscount(msisdn, itemCode, amount,rechrgeamount, ClientAppId.MOBILE_APP, transactionType, refPaymentNo, referrer, null);

		return orderId == null ? new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR) : new ResponseEntity<>(orderId, HttpStatus.OK);
	}
	
	
	 
	@GetMapping(value = "/trx/paymentstatus/{orderId}")
	public ResponseEntity<?> getPaymentStatus(@PathVariable String orderId){
		
		return new ResponseEntity<>(paymentGatewayService.getTransactionStatus(orderId), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/pg/executepayment", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView executePayment(@RequestParam String orderId,
			@RequestParam(defaultValue = "") String clientAppId, @RequestParam(defaultValue = "") String lang,
			HttpServletRequest request, HttpServletResponse resp) {
		
		ClientAppId cai = ClientAppId.MOBILE_APP;
		try {
			cai = ClientAppId.valueOf(clientAppId.toUpperCase());
		} catch (Exception e) {}
		
		resp.setCharacterEncoding("UTF-8");
		ModelAndView view = new ModelAndView();

		LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);

		String message = resolveMessage(messageSource, "Message.api.TransactionFailed", null,
				"Your transaction could not be processed. Please try again.", localeResolver.resolveLocale(request));

		String response = "";
		try {
			response = paymentGatewayService.executeTransaction(orderId, cai, lang);
		} catch (OrderIdNotFoundException | TransactionInProgressException e) {
			
			view.setViewName(PAYMENT_RESULT);

			view.addObject("resultFlag", TransactionStatus.FAIL.ordinal());
			view.addObject("message", message);

			return view;
		}
		
		if (StringUtils.hasText(response)) {
			view.setViewName(INIT_PG_VIEW);
			view.addObject("pgResponse", modifyResponse(response, request));
			
		} else {
			view.setViewName(PAYMENT_RESULT);
			view.addObject("resultFlag", TransactionStatus.FAIL.ordinal());
			view.addObject("message", message);
		}
		return view;
	}
	
	
	//create by oneclick
	@RequestMapping(value = "/pg/executepaymentdiscount", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView executePaymentDiscount(@RequestParam String orderId,
			@RequestParam(defaultValue = "") String clientAppId, @RequestParam(defaultValue = "") String lang,
			HttpServletRequest request, HttpServletResponse resp) {
		
		ClientAppId cai = ClientAppId.MOBILE_APP;
		try {
			cai = ClientAppId.valueOf(clientAppId.toUpperCase());
		} catch (Exception e) {}
		
		resp.setCharacterEncoding("UTF-8");
		ModelAndView view = new ModelAndView();

		LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);

		String message = resolveMessage(messageSource, "Message.api.TransactionFailed", null,
				"Your transaction could not be processed. Please try again.", localeResolver.resolveLocale(request));

		String response = "";
		try {
			response = paymentGatewayService.executeTransactionwithDiscount(orderId, cai, lang);
		} catch (OrderIdNotFoundException | TransactionInProgressException e) {
			
			view.setViewName(PAYMENT_RESULT);

			view.addObject("resultFlag", TransactionStatus.FAIL.ordinal());
			view.addObject("message", message);

			return view;
		}
		
		if (StringUtils.hasText(response)) {
			view.setViewName(INIT_PG_VIEW);
			view.addObject("pgResponse", modifyResponse(response, request));
			
		} else {
			view.setViewName(PAYMENT_RESULT);
			view.addObject("resultFlag", TransactionStatus.FAIL.ordinal());
			view.addObject("message", message);
		}
		return view;
	}
	//End by oneclick
	
	private String[] getFinalCallbackParamNames(){
		return applicationConfigurationService.get("pg.paymentdone.params", 
				"vpc_AdditionalData;vpc_Amount;vpc_BatchNo;vpc_Command;vpc_CurrencyCode;vpc_Locale;"
				+ "vpc_MerchTxnRef;vpc_Merchant;vpc_OrderInfo;vpc_ResponseCode;vpc_TransactionNo;"
				+ "vpc_Version;vpc_SecureHash").toString().split(";");

	}
	
	@RequestMapping(value = "/pg/napasCallBackHandler", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView napasCallBackHandler(HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView(PAYMENT_RESULT);
		
		LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
		
		CloseableHttpResponse response = null;
		int connectTimeout = Integer.parseInt(applicationConfigurationService.get("pg.connecttimeout", "5").toString());
		boolean success = false;
		String extTrxId = "", cardType = null, bankCode = null;
		
		try {
			String callbackURL = applicationConfigurationService.get("pg.paymentdone.callbackurl", "").toString();
			Enumeration<String> reqParamNames = request.getParameterNames();
			List<NameValuePair> paramList = new ArrayList<>();
			String status = "";
			
			while (reqParamNames.hasMoreElements()){
				String pname = reqParamNames.nextElement();
				String pvalue = request.getParameter(pname);
				paramList.add(new BasicNameValuePair(pname, pvalue));

				if (pname.equalsIgnoreCase("vpc_ResponseCode")){
					status = pvalue;
					
				}else if (pname.equalsIgnoreCase("vpc_MerchTxnRef")){
					extTrxId = pvalue;
					
				}else if (pname.equalsIgnoreCase("vpc_CardType")) {
					cardType  = pvalue;
					
				}else if (pname.equalsIgnoreCase("vpc_AdditionalData")) {
					bankCode = pvalue;
				}
			}
			
			if (!StringUtils.hasText(cardType)) {
				//this indicates transaction with Domestic bank
				if (StringUtils.hasText(bankCode)) {
					Bank bank = paymentGatewayService.getBankDetails(bankCode);
					if (bank != null) {
						cardType = bank.getName();
					}
				}
			}
			LoggingUtil.debug(logger, "#napasCallBackHandler --- trxId= " + extTrxId + ", cardType= " + cardType + ", bankCode= " + bankCode + ", bankName= " + cardType);
			
			paramList.add(new BasicNameValuePair("vpc_CardType", cardType));
			
			CloseableHttpClient httpClient = HttpClients.custom()
					.setDefaultRequestConfig(RequestConfig.custom()
							.setConnectTimeout(connectTimeout * 1000)
							.setConnectionRequestTimeout(connectTimeout * 1000)
							.setCookieSpec(CookieSpecs.DEFAULT).build())
					.setRedirectStrategy(new LaxRedirectStrategy()).build();

			HttpClientContext context = HttpClientContext.create();
			HttpPost post = new HttpPost(callbackURL);
			post.setEntity(new UrlEncodedFormEntity(paramList));

			LoggingUtil.debug(logger, "#napasCallBackHandler -- forwarding data from NAPAS to PG....");
			response = httpClient.execute(post, context);
			
			LoggingUtil.debug(logger, "#napasCallBackHandler -- receiving response from PG= " + response.getStatusLine());

			//TODO update payment_history status, paramName/value= vpc_ResponseCode=0, vpc_MerchTxnRef=orderId
			//commented out as final update needs to come from PG
//			paymentGatewayService.confirmTransaction(orderId, status.equals(NAPAS_SUCCESS_RESP) ? TransactionStatus.SUCCESS : TransactionStatus.FAIL);
			
			success = status.equals(NAPAS_SUCCESS_RESP) ? true : false;
			
			httpClient.close();
			
		} catch (Exception e) {
			logger.error("#napasCallBackHandler -- error occurred when processing data from NAPAS!", e);
			
		} finally{
			try {
				if (response != null) response.close();
			} catch (IOException e) {}
		}
		
		String message = "";
		if (success){
			message = resolveMessage(messageSource, "Message.api.TransactionSuccess", null, "Your transaction is being processed.", localeResolver.resolveLocale(request));
		}else{
			message = resolveMessage(messageSource, "Message.api.TransactionFailed", null, "Your transaction could not be processed.", localeResolver.resolveLocale(request));
		}
		
		mav.addObject("orderId", paymentGatewayService.getOrderIdByExtTrxId(extTrxId));
		mav.addObject("resultFlag", success ? TransactionStatus.SUCCESS.ordinal() : TransactionStatus.FAIL.ordinal());
		mav.addObject("message", message);
		
		return mav;
	}
	
	@RequestMapping(value = "/pg/cancelPayment", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView cancelPayment(@RequestParam String orderId, HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView(PAYMENT_RESULT);
		LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
		
		String[] callbackParamNames = getFinalCallbackParamNames();
		
		String callbackURL = applicationConfigurationService.get("pg.paymentdone.callbackurl", "").toString();
		CloseableHttpResponse response = null;
		int connectTimeout = Integer.parseInt(applicationConfigurationService.get("pg.connecttimeout", "5").toString());

		CloseableHttpClient httpClient = HttpClients.custom()
				.setDefaultRequestConfig(RequestConfig.custom()
						.setConnectTimeout(connectTimeout * 1000)
						.setConnectionRequestTimeout(connectTimeout * 1000)
						.setCookieSpec(CookieSpecs.DEFAULT).build())
				.setRedirectStrategy(new LaxRedirectStrategy()).build();
		
		String message = "";

		try {
			String extTrxId = paymentGatewayService.confirmTransaction(orderId, TransactionStatus.CANCELED);
			
			String mid = applicationConfigurationService.get("pg.mid", "938425").toString();
			
			List<NameValuePair> paramList = new ArrayList<>();
			for (String pname:callbackParamNames){
				if (pname.equals("vpc_MerchTxnRef")){
					paramList.add(new BasicNameValuePair(pname, extTrxId));//was orderId
				}else{
					if (pname.equals("vpc_Merchant")){
						paramList.add(new BasicNameValuePair(pname, mid));
					}else{
						if (pname.equals("vpc_ResponseCode")){
							paramList.add(new BasicNameValuePair(pname, NapasErrorCode.TRANSACTION_TIMEOUT.code()));
						}else{
							if (pname.equals("vpc_TransactionNo")){
								paramList.add(new BasicNameValuePair(pname, extTrxId)); //was extTrxId
							} else {
								paramList.add(new BasicNameValuePair(pname, ""));
							}
						}
					}
				}
			}
			
			LoggingUtil.debug(logger, "#cancelPayment --- param list= " + paramList);
			
			HttpClientContext context = HttpClientContext.create();
			HttpPost post = new HttpPost(callbackURL);
			post.setEntity(new UrlEncodedFormEntity(paramList));

			LoggingUtil.debug(logger, "#cancelPayment -- forwarding data from NAPAS to PG....");
			response = httpClient.execute(post, context);
			
			LoggingUtil.debug(logger, "#cancelPayment -- receiving response from PG= " + response.getStatusLine());
			
			message = resolveMessage(messageSource, "Message.api.TransactionCanceled", null,
					"Your transaction has been canceled.", localeResolver.resolveLocale(request));

			EntityUtils.consume(response.getEntity());
			
		} catch (TransactionNotFoundException e) {
			logger.error("#cancelPayment -- " + e.getMessage());
			
			message = resolveMessage(messageSource, "Message.api.TransactionFailed", null,
					"Your transaction could not be processed. Please try again.", localeResolver.resolveLocale(request));
			
		} catch (Exception e) {
			logger.error("#cancelPayment -- error forwarding data to PG! ", e);

			message = resolveMessage(messageSource, "Message.api.TransactionFailed", null,
					"Your transaction could not be processed. Please try again.", localeResolver.resolveLocale(request));

		} finally{
			try {
				if (response != null) response.close();
				httpClient.close();
			} catch (IOException e) {}
		}
		
		mav.addObject("orderId", orderId);
		mav.addObject("resultFlag", TransactionStatus.CANCELED.ordinal());
		mav.addObject("message", message);
		
		return mav;
	}
	
	@PostMapping(value = "/pg/paymentresp")
	public ModelAndView paymentResponse(@RequestBody String pgResponse){
		
		ModelAndView mv = new ModelAndView(PG_RESP_VIEW);
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			RedirectResponse redirectResponse = mapper.readValue(pgResponse, RedirectResponse.class);
			mv.addObject("redirectResponse", redirectResponse);
			
		} catch (Exception e) {
			logger.error("#paymentResponse -- error reading redirect response from PG!", e);
			
			mv.addObject("redirectResponse", new RedirectResponse());
		}
		return mv;
	}
	
	@PostMapping(value = "/pg/callback")
	public ResponseEntity<PGCallbackResponse> confirmPayment(@RequestBody FinalResponse finalResponse, HttpServletResponse response){

		LoggingUtil.debug(logger, "#callback --- start processing= " + finalResponse);
		PGCallbackResponse commonResponse = null;
		try {
			boolean confirmed = paymentGatewayService.confirmTransaction(finalResponse);
			commonResponse = confirmed ? new PGCallbackResponse(PGResponseCode.SUCCESS.getCode()) : new PGCallbackResponse(PGResponseCode.INTERNAL_SYSTEM_ERROR.getCode());
			
		} catch (TransactionNotFoundException e) {
			commonResponse = new PGCallbackResponse(PGResponseCode.TRANSACTION_NOT_FOUND.getCode());
			
			logger.error("#callback -- " + e.getMessage());
			
		} catch (Exception e){
			commonResponse = new PGCallbackResponse(PGResponseCode.INTERNAL_SYSTEM_ERROR.getCode());
			
			logger.error("#callback -- error processing call back from PG!", e);
		}
		
		LoggingUtil.debug(logger, "#callback --- end of processing= " + finalResponse);
		return new ResponseEntity<PGCallbackResponse>(commonResponse, HttpStatus.OK);
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
	
}
