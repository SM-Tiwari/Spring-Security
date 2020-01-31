/**
 * RegistrationController.java
 */
package com.gnv.vnm.selfcare.webapi.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gnv.vnm.selfcare.core.AppDefaultValues;
import com.gnv.vnm.selfcare.core.enums.ClientAppId;
import com.gnv.vnm.selfcare.core.fault.ExternalSubscriberException;
import com.gnv.vnm.selfcare.core.fault.InvalidPasswordFormatException;
import com.gnv.vnm.selfcare.core.fault.InvalidTokenException;
import com.gnv.vnm.selfcare.core.fault.SubscriberAlreadyExistsException;
import com.gnv.vnm.selfcare.core.fault.SubscriberNotFoundException;
import com.gnv.vnm.selfcare.core.model.OtpStatusModel;
import com.gnv.vnm.selfcare.core.model.SubscriberProfile;
import com.gnv.vnm.selfcare.core.security.SelfCareUserDetailsService;
import com.gnv.vnm.selfcare.core.utils.LoggingUtil;
import com.gnv.vnm.selfcare.webapi.DefaultApiResponse;
import com.gnv.vnm.selfcare.webapi.model.ApiResponse;
import com.gnv.vnm.selfcare.webapi.model.RedeemApiResponce;
import com.gnv.vnm.selfcare.webapi.model.RegisterSubscriberRequest;
import com.gnv.vnm.selfcare.webapi.model.ValidateNumberRequest;
import com.gnv.vnm.selfcare.webapi.model.ValidateNumberResponse;

/**
 * @author nandipinto
 *
 */

@RestController
public class RegistrationController extends BaseRestController{
	
	private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

	@Autowired
	SelfCareUserDetailsService userDetailsService;

	@PostMapping(value = "/autosignin/{imsi}")
	public ResponseEntity<?> autoSignIn(@PathVariable("imsi") String imsi, HttpServletRequest request) {

		SubscriberProfile subscriberProfile = null;
		try {
			subscriberProfile = subscriberManagementService.signInWithIMSI(imsi, request != null ? request.getRemoteAddr() : null, ClientAppId.MOBILE_APP.name());
		} catch (ExternalSubscriberException e) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.NUMBER_NOT_RECOGNIZED.message(), imsi), HttpStatus.OK);
		}
		if (subscriberProfile != null) {
			return new ResponseEntity<SubscriberProfile>(subscriberProfile, HttpStatus.OK);
		}else{
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), imsi), HttpStatus.OK);
		}
	}
	
	@GetMapping(value = "/isinhomenetwork/{ipAddress}")
	public ResponseEntity<?> isInHomeNetwork(@PathVariable String ipAddress){
		boolean result = backEndRequestProcessor.isInHomeNetwork(ipAddress);
		return result ? new ResponseEntity<>("1", HttpStatus.OK) : new ResponseEntity<>("0", HttpStatus.OK);
	}
	
	@GetMapping(value = "/subscriberexists/{msisdn}")
	public ResponseEntity<?> subscriberExists(@PathVariable("msisdn") String msisdn) {

		return subscriberManagementService.isActiveSubscriber(msisdn) ? new ResponseEntity<>("1", HttpStatus.OK)
				: new ResponseEntity<>("0", HttpStatus.OK);
	}

	@PostMapping(value = "/register")
	public ResponseEntity<?> registerSubscriber(@RequestBody RegisterSubscriberRequest request) {

		try {
			int status=getBlockStatus(request.getLoginId());
			if(status==1)
			{
				return new ResponseEntity<>(DefaultApiResponse.SUBSCRIBER_OTP_BLOCK.code(), HttpStatus.OK);
			}
			if(status==2)
			{
				return new ResponseEntity<>(DefaultApiResponse.SUBSCRIBER_OTP_INVALID_TOKEN.code(), HttpStatus.OK);
			}
			
			subscriberManagementService.registerSubscriber(request.getLoginId(),
					request.getCredential(), request.getOtp(), ClientAppId.MOBILE_APP.name());
			return new ResponseEntity<>(HttpStatus.OK);
			
		} catch (ExternalSubscriberException e) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.NUMBER_NOT_RECOGNIZED.message(), request.getLoginId()), HttpStatus.OK);
			
		} catch (InvalidPasswordFormatException e) {
			return new ResponseEntity<>(DefaultApiResponse.INVALID_PASSWORD_FORMAT.message(), HttpStatus.OK);
			
		} catch (SubscriberAlreadyExistsException e) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_ALREADY_EXISTS.message(), request.getLoginId()), HttpStatus.OK);
			
		} catch (InvalidTokenException e) {
			return new ResponseEntity<>(DefaultApiResponse.INVALID_TOKEN.message(), HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(DefaultApiResponse.INTERNAL_APP_ERROR.message(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value = "/registerTemp")
	public ResponseEntity<?> registerSubscriberTemp(@RequestBody RegisterSubscriberRequest request) {

		try {
			subscriberManagementService.registerSubscriberTemp(request.getLoginId(),
					request.getCredential(), request.getOtp(), ClientAppId.MOBILE_APP.name());
			return new ResponseEntity<>(HttpStatus.OK);
			
		} catch (ExternalSubscriberException e) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.NUMBER_NOT_RECOGNIZED.message(), request.getLoginId()), HttpStatus.OK);
			
		} catch (InvalidPasswordFormatException e) {
			return new ResponseEntity<>(DefaultApiResponse.INVALID_PASSWORD_FORMAT.message(), HttpStatus.OK);
			
		} catch (SubscriberAlreadyExistsException e) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_ALREADY_EXISTS.message(), request.getLoginId()), HttpStatus.OK);
			
		} catch (InvalidTokenException e) {
			return new ResponseEntity<>(DefaultApiResponse.INVALID_TOKEN.message(), HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(DefaultApiResponse.INTERNAL_APP_ERROR.message(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(value = "/activate/{msisdn}/{otp}")
	public ResponseEntity<?> activateSubscriber(@PathVariable String msisdn, @PathVariable String otp) {

		try {
			subscriberManagementService.activateSubscriber(msisdn, otp);

		} catch (SubscriberNotFoundException e) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn), HttpStatus.OK);

		} catch (InvalidTokenException e) {
			return new ResponseEntity<>(DefaultApiResponse.INVALID_TOKEN.message(), HttpStatus.OK);

		} catch (Exception e) {
			logger.error("#activateSubscriber --- error activating subscriber " + msisdn, e);
			return new ResponseEntity<>(DefaultApiResponse.INTERNAL_APP_ERROR.message(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}

	/*@GetMapping(value = "/getotp/{msisdn}/{langCode}")
	public ResponseEntity<?> getOTP(@PathVariable("msisdn") String msisdn, @PathVariable String langCode) {
//		String otp = null;
		try {
			LoggingUtil.debug(logger, String.format("#generateOTP >> activa generated OTP ", ""));
			subscriberManagementService.generateOTP(msisdn, true, langCode);
		} catch (ExternalSubscriberException e) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.NUMBER_NOT_RECOGNIZED.message(), msisdn), HttpStatus.OK);
		}
//		return StringUtils.hasText(otp) ? new ResponseEntity<>(otp, HttpStatus.OK) : new ResponseEntity<>("", HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.OK);
	}*/
	
	
		
	@GetMapping(value = "/isvalidotp/{msisdn}/{otp}")
	public ResponseEntity<?> isValidOTP(@PathVariable("msisdn") String msisdn, @PathVariable("otp") String otp) {
		return new ResponseEntity<>(subscriberManagementService.isValidOTP(otp, msisdn) ? "1" : "0", HttpStatus.OK);
	}
	
	@PostMapping(value = "/sendsms/{msisdn}")
	public ResponseEntity<?> sendSms(@PathVariable String msisdn, @RequestBody String message){
		
		String sender = applicationConfigurationService.get("smpp.defaultsender", "SELFCARE").toString();
		sendsmsservice.sendSMS(sender, msisdn, message, false, null, null);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping(value = "/validatenumbers")
	public ResponseEntity<?> validateMsisdn(@RequestBody ValidateNumberRequest request){

		if (request.getNumbers() == null || request.getNumbers().isEmpty()) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.MISSING_REQUIRED_PARAMETER.code(), 
					String.format(DefaultApiResponse.MISSING_REQUIRED_PARAMETER.message(), "numbers")), HttpStatus.OK);
		}
		
		ValidateNumberResponse response = new ValidateNumberResponse(true, DefaultApiResponse.SUCCESS.code(), DefaultApiResponse.SUCCESS.message());

		List<ValidateNumberResponse.NumberValidationResult> numberValidationResults = new ArrayList<>();
		String regex = applicationConfigurationService.get("phonenumber.regex", AppDefaultValues.PHONE_NO_REGEX).toString();

		for (String no : request.getNumbers()) {
			ValidateNumberResponse.NumberValidationResult validated = new ValidateNumberResponse.NumberValidationResult(no, isValidNumber(no, regex) ? 1 : 0);
			numberValidationResults.add(validated);
		}
		response.setValidationResults(numberValidationResults);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	private boolean isValidNumber(String no, String regex) {
		return no.matches(regex);
	}
	

	@GetMapping(value = "/getotp/{msisdn}/{langCode}")
	public ResponseEntity<?> getOTPNew(@PathVariable("msisdn") String msisdn, @PathVariable String langCode) {
		// String otp = null;
		try {
			LoggingUtil.debug(logger, String.format("#generateOTP >> activa generated OTP ", ""));
			OtpStatusModel otpStatusModel = backEndRequestProcessor.checkBlockUnblockOtp(msisdn);
			String blocktime = null;
			String blockstatus = null;
			long time = 0;
			String currenttime = getCurrentDateTime();

			blocktime =  otpStatusModel.getTimeStamp();
			blockstatus = otpStatusModel.getStatus();

			//System.out.println("blocktime "+blocktime+" blockstatus "+blockstatus);
			
			time = TimeDiff(blocktime,  currenttime);
			//System.out.println("time difference "+time);
			int count = otpStatusModel.getCount();
			int failCount= backEndRequestProcessor.getfailCountFromOtpBlock(msisdn);
			
			//System.out.println("Count "+count+" failCount "+failCount);
			
			int MAX_TRY_IN_A_DAY=10;
			/**
			 * changes
			 */
			
			if(blockstatus.equals("0") && time < 24){
				
				
				if(count > 11 || failCount >= 5){
					// save with status=1
					//System.out.println("count > MAXtry");
					/*backEndRequestProcessor.saveOtpStatus(msisdn, 1, "1", getCurrentDateTime(),false);
					backEndRequestProcessor.resetFailCount(msisdn);*/
					/*return new ResponseEntity<>(new ApiResponse(true, 
							DefaultApiResponse.SUBSCRIBER_OTP_BLOCK.code(), 
							String.format(DefaultApiResponse.SUBSCRIBER_OTP_BLOCK.message())), 
							HttpStatus.OK);*/
					
					
					/*return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_OTP_BLOCK.message(), msisdn),
							HttpStatus.OK);*/
				} else{
					//System.out.println("not block else");
					
					//save with new count
					if(time >= 24){			
						backEndRequestProcessor.saveOtpStatus(msisdn, 1, "0", getCurrentDateTime(),true);
						backEndRequestProcessor.resetFailCount(msisdn);
					}else{
						count++;
						backEndRequestProcessor.saveOtpStatus(msisdn, count, "0", getCurrentDateTime(),false);
					}
					subscriberManagementService.generateOTPnew(msisdn, true, langCode);
					/*return new ResponseEntity<>(new ApiResponse(true, 
							DefaultApiResponse.SUBSCRIBER_OTP_VALID.code(), 
							String.format(DefaultApiResponse.SUBSCRIBER_OTP_VALID.message())), 
							HttpStatus.OK);*/
					
					//return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_OTP_VALID.message(), msisdn),HttpStatus.OK);
				}
				
				
			} else{
				
				if(time >= 24){
					//System.out.println("block.....  unblock");
					backEndRequestProcessor.saveOtpStatus(msisdn, 1, "0", getCurrentDateTime(),true);
					backEndRequestProcessor.resetFailCount(msisdn);
					/*return new ResponseEntity<>(new ApiResponse(true, 
							DefaultApiResponse.SUBSCRIBER_OTP_VALID.code(), 
							String.format(DefaultApiResponse.SUBSCRIBER_OTP_VALID.message())), 
							HttpStatus.OK);*/
					//return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_OTP_VALID.message(), msisdn),HttpStatus.OK);
					
				}else{
					////System.out.println("still block");
					/*return new ResponseEntity<>(new ApiResponse(true, 
							DefaultApiResponse.SUBSCRIBER_OTP_BLOCK.code(), 
							String.format(DefaultApiResponse.SUBSCRIBER_OTP_BLOCK.message())), 
							HttpStatus.OK);*/
					
					/*return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_OTP_BLOCK.message(), msisdn),
							HttpStatus.OK);*/
					
				}
				
				
			}
			int status=getBlockStatus(msisdn);
			System.out.println("status"+status);
			if(status==1)
			{
				return new ResponseEntity<>(new ApiResponse(true, 
						DefaultApiResponse.SUBSCRIBER_OTP_BLOCK.code(), 
						String.format(DefaultApiResponse.SUBSCRIBER_OTP_BLOCK.message())), 
						HttpStatus.OK);
				
			}
			if(status==2)
			{
				return new ResponseEntity<>(new ApiResponse(true, 
						DefaultApiResponse.SUBSCRIBER_OTP_INVALID_TOKEN.code(), 
						String.format(DefaultApiResponse.SUBSCRIBER_OTP_INVALID_TOKEN.message())), 
						HttpStatus.OK);
				
			}
			
			return new ResponseEntity<>(new ApiResponse(true, 
					DefaultApiResponse.SUBSCRIBER_OTP_VALID.code(), 
					String.format(DefaultApiResponse.SUBSCRIBER_OTP_VALID.message())), 
					HttpStatus.OK);
			

		} catch (ExternalSubscriberException e) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.NUMBER_NOT_RECOGNIZED.message(), msisdn),
					HttpStatus.OK);
		}	
			
		
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
			long diff =  (d2.getTime() - d1.getTime());

			diffHours = diff / (60 * 60 * 1000);

			// //System.out.print(diffHours + " hours, ");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return diffHours;

	}

	public String getCurrentDateTime() {

		Date dt = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		String strDate = dateFormat.format(dt);
		// //System.out.println(strDate);
		return strDate;
	}
	
	public int getBlockStatus(String msisdn)
	{
		int status=0;
		try
		{
			OtpStatusModel otpStatusModel=backEndRequestProcessor.checkBlockUnblockOtp(msisdn);
			if(otpStatusModel!=null)
			{
				System.out.println("get Status block------count-#####"+otpStatusModel.getCount()+" --fail count####"+otpStatusModel.getFailCount());
					if(otpStatusModel.getCount()>=11)
					{
						status=1;
						return status;
					}
					if(otpStatusModel.getFailCount()>=5)
					{
						status=2;
						return status;
					}
				
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return status;
	}
	
}
