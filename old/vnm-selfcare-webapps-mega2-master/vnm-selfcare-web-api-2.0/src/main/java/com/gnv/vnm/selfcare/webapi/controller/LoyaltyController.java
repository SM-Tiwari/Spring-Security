/**
 * LoyaltyController.java
 */
package com.gnv.vnm.selfcare.webapi.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gnv.vnm.selfcare.core.adapter.BackEndAdapterResponse;
import com.gnv.vnm.selfcare.core.fault.SubscriberNotFoundException;
import com.gnv.vnm.selfcare.webapi.DefaultApiResponse;
import com.gnv.vnm.selfcare.webapi.model.ApiResponse;
import com.gnv.vnm.selfcare.webapi.model.GetLmsKeywordMappingsResponse;
import com.gnv.vnm.selfcare.webapi.model.GetLmsPointResponse;
import com.gnv.vnm.selfcare.webapi.model.InviteMemberRequest;
import com.gnv.vnm.selfcare.webapi.model.LmsParam;
import com.gnv.vnm.selfcare.webapi.model.RedeemLmsPointRequest;

/**
 * @author nandipinto
 *
 */

@RestController
@RequestMapping(value = "/lms")
public class LoyaltyController extends BaseRestController {

	@GetMapping(value = "/keywordmappings")
	public ResponseEntity<?> getKeywordMappings(){
		
		GetLmsKeywordMappingsResponse response = new GetLmsKeywordMappingsResponse(true,
				DefaultApiResponse.SUCCESS.code(), DefaultApiResponse.SUCCESS.message(),
				backEndRequestProcessor.getLmsKeywordMappings());
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(value = "/point/{msisdn}")
	public ResponseEntity<?> getLoyaltyPoint(@PathVariable String msisdn){
		
		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		GetLmsPointResponse response = new GetLmsPointResponse(true, DefaultApiResponse.SUCCESS.code(),
				DefaultApiResponse.SUCCESS.message(), msisdn, backEndRequestProcessor.getLmsPoint(msisdn));
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping(value = "/redeem")
	public ResponseEntity<?> redeemPoint(@RequestBody RedeemLmsPointRequest request){
		
		if (request == null || !StringUtils.hasText(request.getMsisdn()) || request.getPoints() == null || request.getPoints().isEmpty()) {
			return new ResponseEntity<>(new ApiResponse(false, 
					DefaultApiResponse.MISSING_REQUIRED_PARAMETER.code(), 
					String.format(DefaultApiResponse.MISSING_REQUIRED_PARAMETER.message(), "points")), 
					HttpStatus.OK);
		}
		
		if (!request.getMsisdn().equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		Map<String, Integer> keywords = backEndRequestProcessor.getLmsKeywordMappings();

		//validate parameters
		for (LmsParam p : request.getPoints()) {
			if (!keywords.containsKey(p.getKeyword().toUpperCase())) {
				return new ResponseEntity<>(new ApiResponse(false, 
						DefaultApiResponse.INVALID_PARAMETER_VALUE.code(), 
						String.format(DefaultApiResponse.INVALID_PARAMETER_VALUE.message(), "keyword") + ": " + p.getKeyword()), 
						HttpStatus.OK);

			}
		}

		int count = 0;
		int size = request.getPoints().size();
		LmsParam firstParam = request.getPoints().get(0);
		
		if (firstParam.getPoint() <= 0){
			return new ResponseEntity<>(new ApiResponse(false, 
					DefaultApiResponse.INVALID_PARAMETER_VALUE.code(), 
					String.format(DefaultApiResponse.INVALID_PARAMETER_VALUE.message(), "point")), 
					HttpStatus.OK);
		}
		
		String errorCode = "", errorMsg = "";
		BackEndAdapterResponse fr = backEndRequestProcessor.redeemLmsPoint(request.getMsisdn(), firstParam.getKeyword(), firstParam.getPoint());
		if (fr.isSuccessful()) {
			count++;
			
			if (size > 1) {
				for (int i=1; i<size; i++) {
					LmsParam nextParam = request.getPoints().get(i);
					
					//ignore parameter if point <= 0
					if (nextParam.getPoint() > 0) {
						fr = backEndRequestProcessor.redeemLmsPoint(request.getMsisdn(), nextParam.getKeyword(), nextParam.getPoint());
						if (fr.isSuccessful()) {
							count++;
						} else {
							errorCode = fr.getResponseCode();
							errorMsg = fr.getResponseDescription();
						}
					}
				}
			}
			
		} else {
			return new ResponseEntity<>(new ApiResponse(false, fr.getResponseCode(), fr.getResponseDescription()), HttpStatus.OK);
		}
		
		if (count > 0 && count >= size - 1) {
			return new ResponseEntity<>(new ApiResponse(true, DefaultApiResponse.SUCCESS.code(), DefaultApiResponse.SUCCESS.message()), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ApiResponse(false, errorCode, errorMsg), HttpStatus.OK);
		}
		
	}
	
	@PostMapping(value = "/invite")
	public ResponseEntity<?> inviteMembers(@RequestBody InviteMemberRequest request){
		if (request == null || !StringUtils.hasLength(request.getMsisdn())){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		if (!request.getMsisdn().equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		ApiResponse response = new ApiResponse();
		try {
			subscriberManagementService.inviteMembers(request.getMsisdn(), request.getInvitedNumbers());
			response.setCode(DefaultApiResponse.SUCCESS.code());
			response.setMessage(DefaultApiResponse.SUCCESS.message());
			
		} catch (SubscriberNotFoundException e) {
			response.setCode(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.code());
			response.setMessage(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message());
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	
}
