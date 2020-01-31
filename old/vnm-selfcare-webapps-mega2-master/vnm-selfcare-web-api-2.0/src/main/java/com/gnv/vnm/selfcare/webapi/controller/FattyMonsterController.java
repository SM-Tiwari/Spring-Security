package com.gnv.vnm.selfcare.webapi.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.gnv.vnm.selfcare.core.enums.RequestStatus;
import com.gnv.vnm.selfcare.core.model.FattyMonsterDetails;
import com.gnv.vnm.selfcare.core.model.FattyRedeemPointRequest;
import com.gnv.vnm.selfcare.core.model.TopUpHistory;
import com.gnv.vnm.selfcare.core.service.FattyMonsterService;
import com.gnv.vnm.selfcare.core.utils.Constant.FattyRedeemStatus;
import com.gnv.vnm.selfcare.webapi.DefaultApiResponse;
import com.gnv.vnm.selfcare.webapi.model.ApiResponse;
import com.gnv.vnm.selfcare.webapi.model.LmsParam;
import com.gnv.vnm.selfcare.webapi.model.RedeemApiResponce;

/**
 * This rest controller is used for handling the request related to Fatty
 * Monster.
 * 
 * @author kuldeep Singh
 *
 */
@RestController
@RequestMapping(value = "/fatty/")
public class FattyMonsterController extends BaseRestController {
	/**
	 * Instance of Logger {@link Logger}
	 */
	private static final Logger logger = LoggerFactory.getLogger(FattyMonsterController.class);
	/**
	 * Instance of {@link FattyMonsterService}
	 */
	@Autowired
	private FattyMonsterService fattyMonsterService;

	/**
	 * This method is used for get fatty Monster details based on msisdn
	 * 
	 * @param msisdn
	 *            {@link String}
	 * @return {@link ServiceResult}
	 */
	@GetMapping(value = "/"
			+ "/{msisdn}")
	public ResponseEntity<?>  getFattyMonsterDetails(@PathVariable("msisdn") String msisdn) {
		logger.info("Inside FattyMonsterController in getFattyMonsterDetails :::::::::::::"+msisdn);
		/*if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}
		
		if (!subscriberManagementService.isActiveSubscriber(msisdn)) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn), HttpStatus.OK);
		}*/
		
		FattyMonsterDetails fattyMonsterDetails = new FattyMonsterDetails();
		
		try {
			fattyMonsterDetails = fattyMonsterService.getFattyMonsterDetailsBasedOnMsisdn(msisdn, fattyMonsterDetails);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return  new  ResponseEntity<FattyMonsterDetails>(fattyMonsterDetails, HttpStatus.OK);
	}
	
	/**
	 * This method is used for redeem point 
	
	 * @return {@link ResponseEntity}
	 */
	@PostMapping(value = "/redeemPoint/")
	public ResponseEntity<?>  redeemPoint(@RequestBody FattyRedeemPointRequest fattyRedeemPointReq) {
		logger.info("Inside FattyMonsterController in redeemPoint :::::::::::::");
		if (!fattyRedeemPointReq.getMsisdn().equals(getCurrentUserName())) {
			return new ResponseEntity<>(new RedeemApiResponce(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}
		
		
		if (!subscriberManagementService.isActiveSubscriber(fattyRedeemPointReq.getMsisdn())) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), fattyRedeemPointReq.getMsisdn()), HttpStatus.OK);
		} 
		if (fattyRedeemPointReq == null || !StringUtils.hasText(fattyRedeemPointReq.getMsisdn()) || !StringUtils.hasText(fattyRedeemPointReq.getKeyward())) {
			return new ResponseEntity<>(new RedeemApiResponce(false, 
					DefaultApiResponse.MISSING_REQUIRED_PARAMETER.code(), 
					String.format(DefaultApiResponse.MISSING_REQUIRED_PARAMETER.message(), "keyward")), 
					HttpStatus.OK);
		}
		Map<String, Integer> keywords = backEndRequestProcessor.getFattyKeywordMappings();
		if(!keywords.containsKey(fattyRedeemPointReq.getKeyward().toUpperCase()))
		{
			return new ResponseEntity<>(new RedeemApiResponce(false, 
					DefaultApiResponse.INVALID_PARAMETER_VALUE.code(), 
					String.format(DefaultApiResponse.INVALID_PARAMETER_VALUE.message(), "keyword") + ": " + fattyRedeemPointReq.getKeyward()), 
					HttpStatus.OK);
		}
		
		try {
			fattyRedeemPointReq.setUserType("appUser");
			BackEndAdapterResponse backEndAdapterResponse=fattyMonsterService.redeemPoint(fattyRedeemPointReq);
			RedeemApiResponce apiResponce=new RedeemApiResponce();
			
			if(backEndAdapterResponse.getResponseCode().equalsIgnoreCase("1"))apiResponce.setSuccessful(true);else apiResponce.setSuccessful(false);
			apiResponce.setCode(backEndAdapterResponse.getResponseCode());
			apiResponce.setMessage(backEndAdapterResponse.getResponseDescription());
			apiResponce=bindRedeemApiResponce(apiResponce, fattyRedeemPointReq);
			return new ResponseEntity<>(apiResponce, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}
	
	public RedeemApiResponce bindRedeemApiResponce(RedeemApiResponce apiResponce,FattyRedeemPointRequest fattyRedeemPointReq)
	{
		FattyMonsterDetails fattyMonsterDetails = new FattyMonsterDetails();
		                    fattyMonsterDetails = fattyMonsterService.getFattyMonsterDetailsBasedOnMsisdn(fattyRedeemPointReq.getMsisdn(), fattyMonsterDetails);
		                    if(fattyMonsterDetails!=null)
		    				{
		    					apiResponce.setDisplayNameEn(fattyMonsterDetails.getDisplayNameEn());
		    					apiResponce.setDisplayNameVi(fattyMonsterDetails.getDisplayNameVi());
		    					apiResponce.setKeyward(fattyMonsterDetails.getKeyward());
		    					apiResponce.setLevel(fattyMonsterDetails.getLevel());
		    					apiResponce.setAvilableForRedeem(fattyMonsterDetails.isAvilableForRedeem());
		    					apiResponce.setFattyImageUrl(fattyMonsterDetails.getFattyImageUrl());
		    					apiResponce.setProductName(fattyMonsterDetails.getProductName());
		    					apiResponce.setRemainingDays(fattyMonsterDetails.getRemainingDays());
		    					apiResponce.setPoint(fattyMonsterDetails.getPoint());
		    					apiResponce.setWeight(fattyMonsterDetails.getWeight());
		    					if(apiResponce.isSuccessful())
		    					{
		    						apiResponce.setSuccessMessageEn(fattyMonsterDetails.getSuccessMessageEn());
		    						apiResponce.setSuccessMessageVi(fattyMonsterDetails.getSuccessMessageVi());
		    					}
		    				}
							return apiResponce;
	}

}
