package com.gnv.vnm.selfcare.webapi.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gnv.vnm.selfcare.core.fault.SubscriberNotFoundException;
import com.gnv.vnm.selfcare.core.model.SocialMediaIntegration;
import com.gnv.vnm.selfcare.webapi.DefaultApiResponse;
import com.gnv.vnm.selfcare.webapi.model.ApiResponse;

@RestController
public class SocialMediaIntegrationController extends BaseRestController {

	private static final Logger logger = LoggerFactory.getLogger(SocialMediaIntegrationController.class);
	
	@PostMapping(value = "/sharesocialmediastatus")
	public ResponseEntity<?> saveSocialMediaStatus(@RequestBody SocialMediaIntegration socialMediaIntegration, HttpServletRequest request) throws SubscriberNotFoundException, UnsupportedEncodingException{
		
		String msisdn = socialMediaIntegration.getMsisdn();
		String share_os_type = socialMediaIntegration.getShare_os_type();		
		Integer media_count_sucess = socialMediaIntegration.getMedia_count_sucess();
		Integer media_count_fail = socialMediaIntegration.getMedia_count_fail();
		Integer share_product_id= socialMediaIntegration.getShare_product_id();
		String share_product_deatils = socialMediaIntegration.getShare_product_deatils();
		String social_media_name = socialMediaIntegration.getSocial_media_name();
		
		boolean  status = sMediaIntegrationService.saveSocialMediaIntegration(msisdn, share_os_type, media_count_sucess, media_count_fail, share_product_id, share_product_deatils, social_media_name);
			 
		if(status) return new ResponseEntity<>(new ApiResponse(true,DefaultApiResponse.SUCCESS.code(),DefaultApiResponse.SUCCESS.message()),HttpStatus.OK);
		
		//return new ResponseEntity<SocialMediaIntegration>(socialMediaIntegration2,HttpStatus.OK);
		return new ResponseEntity<>(new ApiResponse(true,DefaultApiResponse.FAIL.code(),DefaultApiResponse.FAIL.message()),HttpStatus.OK);
	}
}
