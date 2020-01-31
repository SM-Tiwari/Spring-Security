/**
 * BalanceController.java
 */
package com.gnv.vnm.selfcare.webapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.gnv.vnm.selfcare.core.enums.SubscriberType;
import com.gnv.vnm.selfcare.core.model.Balance;
import com.gnv.vnm.selfcare.core.model.CurrentBalance;
import com.gnv.vnm.selfcare.core.model.MyDataBalance;
import com.gnv.vnm.selfcare.core.model.MyPromotionBalance;
import com.gnv.vnm.selfcare.core.model.MySmsBalance;
import com.gnv.vnm.selfcare.core.model.MyVoiceBalance;
import com.gnv.vnm.selfcare.core.model.Simname;
import com.gnv.vnm.selfcare.webapi.DefaultApiResponse;
import com.gnv.vnm.selfcare.webapi.model.ApiResponse;

/**
 * @author nandipinto
 *
 */

@RestController
public class BalanceController extends BaseRestController {
	
	@GetMapping(value = "/subscriber/balance/{msisdn}/{langCode}")
	public ResponseEntity<?> getCurrentBalance(@PathVariable("msisdn") String msisdn, @PathVariable String langCode) {
		
		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		if (!subscriberManagementService.isActiveSubscriber(msisdn)) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn), HttpStatus.OK);
		}
		CurrentBalance currentBalance =backEndRequestProcessor.getCurrentBalance(msisdn, langCode);
		Simname simname = subscriberManagementService.getSimname(msisdn);
		if (simname.getType() != null && simname.getType().equals(SubscriberType.POSTPAID)) {
			currentBalance.setOutstandingBalance(tibcoServiceProvider.getCurrentOutstandingBalance(msisdn));
			currentBalance.setUnbilledBalance(tibcoServiceProvider.getUnbilledBalanceSummary(msisdn));
			currentBalance.setDepositBalance(tibcoServiceProvider.getDepositBalance(msisdn));
		}
		return new ResponseEntity<CurrentBalance>(currentBalance,
				HttpStatus.OK);
	}

	@GetMapping(value = "/subscriber/balance/main/{msisdn}")
	public ResponseEntity<?> getCoreBalance(@PathVariable("msisdn") String msisdn) {
		
		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		if (!subscriberManagementService.isActiveSubscriber(msisdn)) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn), HttpStatus.OK);
		}

		return new ResponseEntity<Balance>(backEndRequestProcessor.getCoreBalance(msisdn), HttpStatus.OK);
	}
	
	@GetMapping(value = "/subscriber/balance/voice/{msisdn}")
	public ResponseEntity<?> getVoiceBalance(@PathVariable("msisdn") String msisdn) {
		
		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		if (!subscriberManagementService.isActiveSubscriber(msisdn)) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn), HttpStatus.OK);
		}

		return new ResponseEntity<MyVoiceBalance>(backEndRequestProcessor.getVoiceBalance(msisdn), HttpStatus.OK);
	}
	
	@GetMapping(value = "/subscriber/balance/sms/{msisdn}")
	public ResponseEntity<?> getSmsBalance(@PathVariable("msisdn") String msisdn) {
		
		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}
		
		if (!subscriberManagementService.isActiveSubscriber(msisdn)) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn), HttpStatus.OK);
		}

		return new ResponseEntity<MySmsBalance>(backEndRequestProcessor.getSmsBalance(msisdn), HttpStatus.OK);
	}
	
	@GetMapping(value = "/subscriber/balance/promotion/{msisdn}/{langCode}")
	public ResponseEntity<?> getPromotionBalance(@PathVariable("msisdn") String msisdn, @PathVariable String langCode) {
		
		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		if (!subscriberManagementService.isActiveSubscriber(msisdn)) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn), HttpStatus.OK);
		}

		return new ResponseEntity<MyPromotionBalance>(backEndRequestProcessor.getPromotionBalance(msisdn, langCode), HttpStatus.OK);
	}
	
	@GetMapping(value = "/subscriber/balance/data/{msisdn}")
	public ResponseEntity<?> getDataBalance(@PathVariable("msisdn") String msisdn) {
		
		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		if (!subscriberManagementService.isActiveSubscriber(msisdn)) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn), HttpStatus.OK);
		}

		return new ResponseEntity<MyDataBalance>(backEndRequestProcessor.getDataBalance(msisdn, null), HttpStatus.OK);
	}
	
}
