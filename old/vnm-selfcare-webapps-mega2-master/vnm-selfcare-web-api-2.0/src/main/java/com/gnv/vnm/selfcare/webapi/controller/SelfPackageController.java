/**
 * 
 */
package com.gnv.vnm.selfcare.webapi.controller;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.gnv.vnm.selfcare.core.adapter.vasman.VASManSelfPackageBalance;
import com.gnv.vnm.selfcare.core.adapter.vasman.VASManSelfPackageRequest;
import com.gnv.vnm.selfcare.core.enums.SelfPackageCycle;
import com.gnv.vnm.selfcare.core.utils.LoggingUtil;
import com.gnv.vnm.selfcare.webapi.DefaultApiResponse;
import com.gnv.vnm.selfcare.webapi.model.ApiResponse;
import com.gnv.vnm.selfcare.webapi.model.GetSelfPackageConfigResponse;
import com.gnv.vnm.selfcare.webapi.model.GetSelfPackageKeywordResponse;
import com.gnv.vnm.selfcare.webapi.model.GetSelfPackagePriceMappingsResponse;
import com.gnv.vnm.selfcare.webapi.model.SelfPackageBalance;
import com.gnv.vnm.selfcare.webapi.model.SelfPackageRequest;

/**
 * @author nandipinto
 *
 */

@RestController
@RequestMapping(value = "/selfpkg")
public class SelfPackageController extends BaseRestController {

	private static final Logger logger = LoggerFactory.getLogger(SelfPackageController.class);
	
	@GetMapping(value = "/keywords")
	public ResponseEntity<?> getKeywords(){
		
		GetSelfPackageKeywordResponse response = new GetSelfPackageKeywordResponse(true, DefaultApiResponse.SUCCESS.code(), DefaultApiResponse.SUCCESS.message(), 
				backEndRequestProcessor.getSelfPackageBalanceList());
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/*@GetMapping(value = "/configs")
	public ResponseEntity<?> getConfigs(){
		
		Map<String, String> result =  backEndRequestProcessor.getSelfPackageCommonConfigs();
		TreeMap<String, String> sorted = new TreeMap<>(result);
        Set<Entry<String, String>> mappings = sorted.entrySet();
		
		return new ResponseEntity<>(
				new GetSelfPackageConfigResponse(true, DefaultApiResponse.SUCCESS.code(),
						DefaultApiResponse.SUCCESS.message(), mappings),
				HttpStatus.OK);
	}*/
	
	@GetMapping(value = "/configs")
	public ResponseEntity<?> getConfigs(){
		
		Map<String, String> result =  backEndRequestProcessor.getSelfPackageCommonConfigs();
		TreeMap<String, String> sorted = new TreeMap<>(result);
        Set<Entry<String, String>> mappings = sorted.entrySet();
		
		return new ResponseEntity<>(
				new GetSelfPackageConfigResponse(true, DefaultApiResponse.SUCCESS.code(),
						DefaultApiResponse.SUCCESS.message(), mappings),
				HttpStatus.OK);
	}

	@GetMapping(value = "/pricemappings")
	public ResponseEntity<?> getPriceMappings(){
		
		GetSelfPackagePriceMappingsResponse response = new GetSelfPackagePriceMappingsResponse(true,
				DefaultApiResponse.SUCCESS.code(), DefaultApiResponse.SUCCESS.message(),
				backEndRequestProcessor.getSelfPackagePriceMappings());
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(value = "/pricemappings/{type}")
	public ResponseEntity<?> getPriceMappings(@PathVariable String type){
		
		GetSelfPackagePriceMappingsResponse response = new GetSelfPackagePriceMappingsResponse(true,
				DefaultApiResponse.SUCCESS.code(), DefaultApiResponse.SUCCESS.message(),
				backEndRequestProcessor.getSelfPackagePriceMappings(type));
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/pricemappings/{type}/{cycle}")
	public ResponseEntity<?> getPriceMappings(@PathVariable String type, @PathVariable String cycle){
		
		GetSelfPackagePriceMappingsResponse response = new GetSelfPackagePriceMappingsResponse(true,
				DefaultApiResponse.SUCCESS.code(), DefaultApiResponse.SUCCESS.message(),
				backEndRequestProcessor.getSelfPackagePriceMappings(type, Integer.parseInt(cycle)));
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/pricemappings/{type}/{cycle}/{amount}")
	public ResponseEntity<?> getPriceMappings(@PathVariable String type, @PathVariable String cycle, @PathVariable String amount){
		
		GetSelfPackagePriceMappingsResponse response = new GetSelfPackagePriceMappingsResponse(true,
				DefaultApiResponse.SUCCESS.code(), DefaultApiResponse.SUCCESS.message(),
				backEndRequestProcessor.getSelfPackagePriceMappings(type, Integer.parseInt(cycle), Double.parseDouble(amount)));
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(value = "/register")
	public ResponseEntity<?> registerSelfPackage(@RequestBody SelfPackageRequest request){
		
		if (request == null || !StringUtils.hasText(request.getMsisdn())) {
			return new ResponseEntity<>(
			        new ApiResponse(false, DefaultApiResponse.MISSING_REQUIRED_PARAMETER.code(),
			                String.format(DefaultApiResponse.MISSING_REQUIRED_PARAMETER.message(), "msisdn")),
			        HttpStatus.OK);
		}
		if (!request.getMsisdn().equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
					DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}
		
		LoggingUtil.debug(logger, "#registerSelfPackage --- receiving request= " + request);
		
		VASManSelfPackageRequest pkgRequest = new VASManSelfPackageRequest();
		pkgRequest.setDescription(request.getDescription());
		pkgRequest.setMsisdn(request.getMsisdn());
		pkgRequest.setPackageId(request.getPackageId());
		pkgRequest.setChargingAmount(request.getChargingAmount());
		
		SelfPackageCycle cycle = SelfPackageCycle.MONTHLY;
		try {
			cycle = SelfPackageCycle.valueOf(request.getCycle().toUpperCase());
		} catch (Exception e) {}
		pkgRequest.setCycle(cycle);
		
		for (SelfPackageBalance balance : request.getBalanceList()) {
			pkgRequest.getBalanceList().add(new VASManSelfPackageBalance(balance.getName(), balance.getAmount()));
		}
		
		BackEndAdapterResponse bar = backEndRequestProcessor.registerSelfPackage(pkgRequest);
		
		ApiResponse response = new ApiResponse(bar.isSuccessful(), bar.getResponseCode(), bar.getResponseDescription());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
