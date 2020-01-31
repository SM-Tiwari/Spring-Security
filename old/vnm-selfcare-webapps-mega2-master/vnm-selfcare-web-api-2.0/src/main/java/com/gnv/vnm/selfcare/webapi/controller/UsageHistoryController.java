/**
 * UsageHistoryController.java
 */
package com.gnv.vnm.selfcare.webapi.controller;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gnv.vnm.selfcare.core.fault.SubscriberNotFoundException;
import com.gnv.vnm.selfcare.core.model.CallRecord;
import com.gnv.vnm.selfcare.core.model.SmsCallHistoryStatusModel;
import com.gnv.vnm.selfcare.core.model.SmsRecord;
import com.gnv.vnm.selfcare.core.utils.AppUtils;
import com.gnv.vnm.selfcare.webapi.DefaultApiResponse;
import com.gnv.vnm.selfcare.webapi.model.ApiResponse;
import com.gnv.vnm.selfcare.webapi.model.SmsCallHistoryStatusRequest;

/**
 * @author nandipinto
 *
 */

@RestController
public class UsageHistoryController extends BaseRestController {

	@GetMapping(value = "/subscriber/callhistory/{msisdn}/{startdate}/{enddate}")
	public ResponseEntity<?> getCallHistory(@PathVariable("msisdn") String msisdn,
			@PathVariable("startdate") String startDate, @PathVariable("enddate") String endDate) {

		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		if (!subscriberManagementService.isActiveSubscriber(msisdn)) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn), HttpStatus.OK);
		}
		
		List<CallRecord> callHistory = backEndRequestProcessor.getCallHistory(msisdn,
				AppUtils.stringToDate(startDate, getDateFormat()),
				AppUtils.stringToDate(endDate, getDateFormat()));
		
		return new ResponseEntity<List<CallRecord>>(callHistory, HttpStatus.OK);
	}

	@GetMapping(value = "/subscriber/dailycallhistory/{msisdn}")
	public ResponseEntity<?> getDailyCallHistory(@PathVariable("msisdn") String msisdn) {

		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		if (!subscriberManagementService.isActiveSubscriber(msisdn)) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn), HttpStatus.OK);
		}
		
		Calendar startDate = Calendar.getInstance();
		startDate.set(Calendar.HOUR, 0);
		startDate.set(Calendar.MINUTE, 0);
		startDate.set(Calendar.SECOND, 0);
	
		List<CallRecord> callHistory = backEndRequestProcessor.getCallHistory(msisdn, startDate.getTime(), new Date());
		
		return new ResponseEntity<List<CallRecord>>(callHistory, HttpStatus.OK);
	}

	@GetMapping(value = "/subscriber/weeklycallhistory/{msisdn}")
	public ResponseEntity<?> getWeeklyCallHistory(@PathVariable("msisdn") String msisdn) {

		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		if (!subscriberManagementService.isActiveSubscriber(msisdn)) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn), HttpStatus.OK);
		}

		Calendar startDate = Calendar.getInstance();
		startDate.add(Calendar.DATE, -7);

		List<CallRecord> callHistory = backEndRequestProcessor.getCallHistory(msisdn, startDate.getTime(), new Date());

		return new ResponseEntity<List<CallRecord>>(callHistory, HttpStatus.OK);
	}

	@GetMapping(value = "/subscriber/monthlycallhistory/{msisdn}")
	public ResponseEntity<?> getMonthlyCallHistory(@PathVariable("msisdn") String msisdn) {

		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		if (!subscriberManagementService.isActiveSubscriber(msisdn)) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn), HttpStatus.OK);
		}

		Calendar startDate = Calendar.getInstance();
		startDate.add(Calendar.DATE, -30);
		List<CallRecord> callHistory = backEndRequestProcessor.getCallHistory(msisdn, startDate.getTime(), new Date());

		return new ResponseEntity<List<CallRecord>>(callHistory, HttpStatus.OK);
	}

	@GetMapping(value = "/subscriber/yearlycallhistory/{msisdn}")
	public ResponseEntity<?> getYearlyCallHistory(@PathVariable("msisdn") String msisdn) {

		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		if (!subscriberManagementService.isActiveSubscriber(msisdn)) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn), HttpStatus.OK);
		}

		Calendar startDate = Calendar.getInstance();
		startDate.add(Calendar.YEAR, -1);
		List<CallRecord> callHistory = backEndRequestProcessor.getCallHistory(msisdn, startDate.getTime(), new Date());

		return new ResponseEntity<List<CallRecord>>(callHistory, HttpStatus.OK);
	}

	@GetMapping(value = "/subscriber/dailysmshistory/{msisdn}")
	public ResponseEntity<?> getDailySmsHistory(@PathVariable String msisdn){

		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		if (!subscriberManagementService.isActiveSubscriber(msisdn)) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn), HttpStatus.OK);
		}

		Calendar startDate = Calendar.getInstance();
		startDate.set(Calendar.HOUR, 0);
		startDate.set(Calendar.MINUTE, 0);
		startDate.set(Calendar.SECOND, 0);

		List<SmsRecord> smsHistory = backEndRequestProcessor.getSmsHistory(msisdn, startDate.getTime(), new Date());
		
		return new ResponseEntity<List<SmsRecord>>(smsHistory, HttpStatus.OK);
	}
	
	@GetMapping(value = "/subscriber/weeklysmshistory/{msisdn}")
	public ResponseEntity<?> getWeeklySmsHistory(@PathVariable String msisdn){
	
		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		if (!subscriberManagementService.isActiveSubscriber(msisdn)) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn), HttpStatus.OK);
		}

		Calendar startDate = Calendar.getInstance();
		startDate.add(Calendar.DATE, -7);
		List<SmsRecord> smsHistory = backEndRequestProcessor.getSmsHistory(msisdn, startDate.getTime(), new Date());

		return new ResponseEntity<List<SmsRecord>>(smsHistory, HttpStatus.OK);
	}
	
	@GetMapping(value = "/subscriber/monthlysmshistory/{msisdn}")
	public ResponseEntity<?> getMonthlySmsHistory(@PathVariable String msisdn){
	
		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		if (!subscriberManagementService.isActiveSubscriber(msisdn)) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn), HttpStatus.OK);
		}

		Calendar startDate = Calendar.getInstance();
		startDate.add(Calendar.DATE, -30);

		List<SmsRecord> smsHistory = backEndRequestProcessor.getSmsHistory(msisdn, startDate.getTime(), new Date());

		return new ResponseEntity<List<SmsRecord>>(smsHistory, HttpStatus.OK);
	}
	
	@GetMapping(value = "/subscriber/yearlysmshistory/{msisdn}")
	public ResponseEntity<?> getYearlySmsHistory(@PathVariable String msisdn){
	
		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		if (!subscriberManagementService.isActiveSubscriber(msisdn)) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn), HttpStatus.OK);
		}

		Calendar startDate = Calendar.getInstance();
		startDate.add(Calendar.YEAR, -1);

		List<SmsRecord> smsHistory = backEndRequestProcessor.getSmsHistory(msisdn, startDate.getTime(), new Date());

		return new ResponseEntity<List<SmsRecord>>(smsHistory, HttpStatus.OK);
	}
	@PostMapping(value = "/subscriber/updatehistorystatus")
    public ResponseEntity<?> micUploadSubscriber(@RequestBody SmsCallHistoryStatusRequest smsCallHistoryStatusRequest, HttpServletRequest request) throws SubscriberNotFoundException, UnsupportedEncodingException {
    
          
           String msisdn = smsCallHistoryStatusRequest.getMsisdn();
           String credential =null;
           if(smsCallHistoryStatusRequest.getCredential()!=null)
           {
        	   credential = smsCallHistoryStatusRequest.getCredential();
           } 
           String status = smsCallHistoryStatusRequest.getSmsCallHistoryStatus();
           System.out.println(" In micUploadSubscriber Method  MsisDn Id Is "+msisdn+"  credential --"+credential +" status ---"+status);
           if((status==null)&&(status.trim().length()!=0))
           {
        	   status="0";
           }
         
           SmsCallHistoryStatusModel smStatusModel = backEndRequestProcessor.updateSmsCallHistoryStatus(msisdn, credential, status);
           //MicInformation micInformation = micInformationService.saveMicDocumentByMobile(firstName ,lastName, dob, idcard, date_of_issue, place_of_issue, address, province, district, country, msisdn, firstIdCard, secondIdCard, custPortarit, custSignature);
    
           return new ResponseEntity<SmsCallHistoryStatusModel>(smStatusModel, HttpStatus.OK);
    }
       @PostMapping(value = "/subscriber/gethistorystatus")
    public ResponseEntity<?> checkHistorydetails(@RequestBody SmsCallHistoryStatusRequest smsCallHistoryStatusRequest, HttpServletRequest request) throws SubscriberNotFoundException, UnsupportedEncodingException {
    
           
           String msisdn = smsCallHistoryStatusRequest.getMsisdn();
           String credential =null;
           if(smsCallHistoryStatusRequest.getCredential()!=null)
           {
        	   credential = smsCallHistoryStatusRequest.getCredential();
           } 
           //String status = smsCallHistoryStatusRequest.getSmsCallHistoryStatus();
           System.out.println("In checkHistorydetails Method -- MsisDn Id Is "+msisdn+"  credential --"+credential);
           SmsCallHistoryStatusModel smStatusModel = backEndRequestProcessor.checkSmsCallHistorycredential(msisdn, credential);
           //MicInformation micInformation = micInformationService.saveMicDocumentByMobile(firstName ,lastName, dob, idcard, date_of_issue, place_of_issue, address, province, district, country, msisdn, firstIdCard, secondIdCard, custPortarit, custSignature);
    
           return new ResponseEntity<SmsCallHistoryStatusModel>(smStatusModel, HttpStatus.OK);
    }


}
