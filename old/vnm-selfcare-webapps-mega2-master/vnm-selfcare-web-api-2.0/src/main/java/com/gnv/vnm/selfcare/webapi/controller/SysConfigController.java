/**
 * 
 */
package com.gnv.vnm.selfcare.webapi.controller;

import java.util.Hashtable;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gnv.vnm.selfcare.webapi.DefaultApiResponse;
import com.gnv.vnm.selfcare.webapi.model.GetLmsConfigResponse;

/**
 * @author nandipinto
 *
 */

@RestController
@RequestMapping(value = "/sysconfig")
public class SysConfigController extends BaseRestController {

	@GetMapping(value = "/contactus")
	public ResponseEntity<?> getContactUsConfig(){
		
		Map<String, String> map = new Hashtable<>();
		map.put("contactus_phoneno_en", applicationConfigurationService.get("contactus.phoneno.en", "0922366366").toString());
		map.put("contactus_phoneno_vi", applicationConfigurationService.get("contactus.phoneno.vi", "0922789789").toString());
		map.put("contactus_email_addr", applicationConfigurationService.get("contactus.email.addr", "cskh@vietnamobile.com.vn").toString());
		
		map.put("mobileapp.version.android", applicationConfigurationService.get("mobileapp.version.android", "2.0.0").toString());
		map.put("mobileapp.version.ios", applicationConfigurationService.get("mobileapp.version.ios", "2.0.0").toString());
		
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	@GetMapping(value = "/versions")
	public ResponseEntity<?> appVersions(){
		
		Map<String, String> map = new Hashtable<>();
		
		map.put("mobileapp.version.android", applicationConfigurationService.get("mobileapp.version.android", "2.0.0").toString());
		map.put("mobileapp.version.ios", applicationConfigurationService.get("mobileapp.version.ios", "2.0.0").toString());
		
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	@GetMapping(value = "/lms")
	public ResponseEntity<GetLmsConfigResponse> lmsConfigs(){
		GetLmsConfigResponse response = new GetLmsConfigResponse(true, DefaultApiResponse.SUCCESS.code(), DefaultApiResponse.SUCCESS.message());
		response.setConfigs(backEndRequestProcessor.getLmsConfigs());
		
		return ResponseEntity.ok(response);
	}	
}
