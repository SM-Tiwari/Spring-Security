/**
 * TopUpController.java
 */
package com.gnv.vnm.selfcare.webapi.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gnv.vnm.selfcare.core.AppDefaultValues;
import com.gnv.vnm.selfcare.core.adapter.RechargeResponse;
import com.gnv.vnm.selfcare.core.enums.ClientAppId;
import com.gnv.vnm.selfcare.core.enums.TibcoResponse;
import com.gnv.vnm.selfcare.core.model.ScratchStatusModel;
import com.gnv.vnm.selfcare.core.model.TopUpHistory;
import com.gnv.vnm.selfcare.core.utils.AppUtils;
import com.gnv.vnm.selfcare.dao.entity.ScratchBlockHistoryEntity;
import com.gnv.vnm.selfcare.webapi.DefaultApiResponse;
import com.gnv.vnm.selfcare.webapi.model.ApiResponse;

/**
 * @author nandipinto
 *
 */

@RestController
public class TopUpController extends BaseRestController {

	//TODO remove this method later -- only kept for backward compatibility
	/*@PostMapping(value = "/subscriber/topup/{msisdn}/{voucherCode}")
	public ResponseEntity<?> topUp(@PathVariable("msisdn") String msisdn, @PathVariable String voucherCode, @RequestParam(defaultValue = "") String referrer) {

		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}
		
		if (!subscriberManagementService.isVnmNumber(msisdn)){
			return new ResponseEntity<>(String.format(DefaultApiResponse.NUMBER_NOT_RECOGNIZED.message(), msisdn), HttpStatus.OK);
		}
		if (!subscriberManagementService.isActiveSubscriber(msisdn)) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn), HttpStatus.OK);
		}

		RechargeResponse response = backEndRequestProcessor.topUpWithScratchCard(msisdn, voucherCode, msisdn, ClientAppId.MOBILE_APP, referrer, null);
		if (response.getCode().equals(TibcoResponse.SUCCESS.code())) {
			return new ResponseEntity<>(response.getBalance(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("ERROR: " + response.getMessage(), HttpStatus.OK);
		}
		
	}
	
	@PostMapping(value = "/subscriber/topup/{msisdn}/{voucherCode}/{recipientNumber}")
	public ResponseEntity<?> topUp(@PathVariable("msisdn") String msisdn, @PathVariable String voucherCode, @PathVariable String recipientNumber, @RequestParam(defaultValue = "") String referrer) {

		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		//TODO check if MSISDN is VNM or not
		if (!subscriberManagementService.isVnmNumber(msisdn)){
			return new ResponseEntity<>(String.format(DefaultApiResponse.NUMBER_NOT_RECOGNIZED.message(), msisdn), HttpStatus.OK);
		}
		if (!subscriberManagementService.isActiveSubscriber(msisdn)) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn), HttpStatus.OK);
		}

		RechargeResponse response = backEndRequestProcessor.topUpWithScratchCard(msisdn, voucherCode, recipientNumber, ClientAppId.MOBILE_APP, referrer, null);
		if (response.getCode().equals(TibcoResponse.SUCCESS.code())) {
			return new ResponseEntity<>(response.getBalance(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("ERROR: " + response.getMessage(), HttpStatus.OK);
		}

	}
*/
	/*
	@PostMapping(value = "/subscriber/etopup/{msisdn}/{amount}")
	public ResponseEntity<?> etopUp(@PathVariable("msisdn") String msisdn, @PathVariable String amount) {

		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(DefaultApiResponse.UNAUTHORIZED.message(), HttpStatus.OK);
		}

		if (!subscriberManagementService.isActiveSubscriber(msisdn)) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn), HttpStatus.OK);
		}
		
		double damount = 0;
		try {
			damount = Double.parseDouble(amount);
		} catch (Exception e) {}
		return new ResponseEntity<>(backEndRequestProcessor.etopUp(msisdn, damount, ClientAppId.MOBILE_APP).getBalance(), HttpStatus.OK);
	}
	*/
	
	@GetMapping(value = "/subscriber/topuphistory/{msisdn}")
	public ResponseEntity<?> getTopUpHistory(@PathVariable("msisdn") String msisdn,
			@PathVariable("startdate") String startDate, @PathVariable("enddate") String endDate) {

		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		if (!subscriberManagementService.isActiveSubscriber(msisdn)) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn), HttpStatus.OK);
		}

		List<TopUpHistory> history = backEndRequestProcessor.getTopUpHistory(msisdn, 
				AppUtils.stringToDate(startDate, AppDefaultValues.DATE_FORMAT), 
				AppUtils.stringToDate(endDate, AppDefaultValues.DATE_FORMAT));

		return new ResponseEntity<List<TopUpHistory>>(history, HttpStatus.OK);
	}

	@GetMapping(value = "/subscriber/dailytopuphistory/{msisdn}")
	public ResponseEntity<?> getDailyTopUpHistory(@PathVariable("msisdn") String msisdn) {

		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		if (!subscriberManagementService.isActiveSubscriber(msisdn)) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn), HttpStatus.OK);
		}

		List<TopUpHistory> history = backEndRequestProcessor.getDailyTopUpHistory(msisdn);

		return new ResponseEntity<List<TopUpHistory>>(history, HttpStatus.OK);
	}
	
	@GetMapping(value = "/subscriber/weeklytopuphistory/{msisdn}")
	public ResponseEntity<?> getWeeklyTopUpHistory(@PathVariable("msisdn") String msisdn) {

		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		if (!subscriberManagementService.isActiveSubscriber(msisdn)) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn), HttpStatus.OK);
		}

		List<TopUpHistory> history = backEndRequestProcessor.getWeeklyTopUpHistory(msisdn);

		return new ResponseEntity<List<TopUpHistory>>(history, HttpStatus.OK);
	}

	@GetMapping(value = "/subscriber/monthlytopuphistory/{msisdn}")
	public ResponseEntity<?> getMonthlyTopUpHistory(@PathVariable("msisdn") String msisdn) {

		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		if (!subscriberManagementService.isActiveSubscriber(msisdn)) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn), HttpStatus.OK);
		}

		List<TopUpHistory> history = backEndRequestProcessor.getMonthlyTopUpHistory(msisdn);

		return new ResponseEntity<List<TopUpHistory>>(history, HttpStatus.OK);
	}
	
	@GetMapping(value = "/subscriber/yearlytopuphistory/{msisdn}")
	public ResponseEntity<?> getYearlyTopUpHistory(@PathVariable("msisdn") String msisdn) {

		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		if (!subscriberManagementService.isActiveSubscriber(msisdn)) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn), HttpStatus.OK);
		}

		List<TopUpHistory> history = backEndRequestProcessor.getYearlyTopUpHistory(msisdn);

		return new ResponseEntity<List<TopUpHistory>>(history, HttpStatus.OK);
	}
	
	/*
     *  25Jun2018 - eTopUp to check maximum 5 wrong voucher(if limit is exceeding more than 5 then top up feature will be block for one day from last transaction)
     *  Changes By Onec 
      */
     
     @PostMapping(value = "/subscriber/topupnew/{msisdn}/{voucherCode}/{recipientNumber}")
     public ResponseEntity<?> topUpUpdate(@PathVariable("msisdn") String msisdn, @PathVariable String voucherCode, @PathVariable String recipientNumber,  @RequestParam(defaultValue = "") String referrer){

            
            if (!msisdn.equals(getCurrentUserName())) {
                   return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
                             DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
            }

            //TODO check if MSISDN is VNM or not
            if (!subscriberManagementService.isVnmNumber(msisdn)){
                   return new ResponseEntity<>(String.format(DefaultApiResponse.NUMBER_NOT_RECOGNIZED.message(), msisdn), HttpStatus.OK);
            }
            if (!subscriberManagementService.isActiveSubscriber(msisdn)) {
                   return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn), HttpStatus.OK);
            }

            
            
            ScratchStatusModel scratchStatusModel = backEndRequestProcessor.checkBlockUnblockTopUp(msisdn);
            String blocktime = null;
            String blockstatus = null;
            long time = 0;
            String currenttime = getCurrentDateTime(); 
             
             blocktime=scratchStatusModel.getTimeStamp();
            blockstatus = scratchStatusModel.getStatus();
            
               
              if(blocktime!=null){
                    time=TimeDiff(blocktime,currenttime);
              }

            
          if(blockstatus.equalsIgnoreCase("1") && (time >=24))
          {
            backEndRequestProcessor.saveScratchStatus(msisdn, 0, "0", getCurrentDateTime());    
             scratchStatusModel = backEndRequestProcessor.checkBlockUnblockTopUp(msisdn);
          
          }

            if(scratchStatusModel.getStatus().equalsIgnoreCase("0")){
                   RechargeResponse response = backEndRequestProcessor.topUpWithScratchCardUpdate(msisdn, voucherCode, recipientNumber, ClientAppId.MOBILE_APP, referrer);
                   
            
                   if (response.getCode().equals(TibcoResponse.SUCCESS.code())) {
                         
                         /**
                          * 
                          */
                         ScratchBlockHistoryEntity scratchBlockHistoryEntity = new ScratchBlockHistoryEntity();
                         
                         scratchBlockHistoryEntity.setCount(0);
                         scratchBlockHistoryEntity.setId(0);
                         scratchBlockHistoryEntity.setMsisdn(msisdn);
                         scratchBlockHistoryEntity.setStatusMessage(response.getMessage());
                         scratchBlockHistoryEntity.setTimeStamp(getCurrentDateTime());
                         backEndRequestProcessor.saveScratchCardInHistory(scratchBlockHistoryEntity);
                   
                         backEndRequestProcessor.saveScratchStatus(msisdn, 0, "0", getCurrentDateTime());
                         /**
                         * 
                          */
                         
                         return new ResponseEntity<>(response.getBalance(), HttpStatus.OK);
                   }  
                   else{  
                         /**
                         *  For failure re charge 
                          */
                         long blockHours=0;
                         String firstFailTransactionTime = backEndRequestProcessor.getFirstTimestampScratchStatus(msisdn);
                         
                         if(firstFailTransactionTime != null){
                         
                           blockHours =  TimeDiff(firstFailTransactionTime, getCurrentDateTime());
                         }
                         if(blockHours >= 24){
                                backEndRequestProcessor.saveScratchStatus(msisdn, 1, "0", getCurrentDateTime());
                         }
                         else{
                         
                         ScratchBlockHistoryEntity scratchBlockHistoryEntity = new ScratchBlockHistoryEntity();
                         int count = backEndRequestProcessor.getCountFromScratchBlock(msisdn);
                         
                         if(count == 0 ){
                                count = 1;
                         }
                       else if(count != 0 ){
                                count = count + 1;         
                                
                         }
                   
                         scratchBlockHistoryEntity.setCount(count);
                         scratchBlockHistoryEntity.setId(0);
                         scratchBlockHistoryEntity.setMsisdn(msisdn);
                         scratchBlockHistoryEntity.setStatusMessage(response.getMessage());
                         scratchBlockHistoryEntity.setTimeStamp(getCurrentDateTime());
                         backEndRequestProcessor.saveScratchCardInHistory(scratchBlockHistoryEntity);
                         
                         if(count != 5)
                         {
                         
                         backEndRequestProcessor.saveScratchStatus(msisdn, count, "0", getCurrentDateTime());
                         }
                         
                         else if(count == 5){
                                
                                backEndRequestProcessor.saveScratchStatus(msisdn, count, "1", getCurrentDateTime());
                                return new ResponseEntity<>("ERROR: " + "scratch_card_security_issue", HttpStatus.OK);
                         }
                         /**
                         * 
                          */
                         }
                         return new ResponseEntity<>("ERROR: " + response.getMessage(), HttpStatus.OK);
                   
                   }
                   
            }
            else{
                   return new ResponseEntity<>("ERROR: " + "scratch_card_security_issue", HttpStatus.OK);
            }
     }
     public long TimeDiff(String blockTime,String currentTime){
         DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy HH:mm");   
         Date d1 = null;
         Date d2 = null;
         long diffHours=0;
         try {
                d1 = dateFormat1.parse(blockTime);
                d2 = dateFormat1.parse(currentTime);

                //in milliseconds
                long diff = (long) (d2.getTime() - d1.getTime());

                
                  diffHours = diff / (60 * 60 * 1000);
                
               // System.out.print(diffHours + " hours, ");
         
         } catch (Exception e) {
                e.printStackTrace();
         }

         
         return diffHours;
         
  }



        public String getCurrentDateTime(){
        
               Date dt = new Date();
               DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");  
          String strDate = dateFormat.format(dt);
               //System.out.println(strDate);
               return strDate;
        }

}
