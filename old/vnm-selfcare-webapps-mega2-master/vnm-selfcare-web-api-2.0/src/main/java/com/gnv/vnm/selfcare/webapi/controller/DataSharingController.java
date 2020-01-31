/**
 * 
 */
package com.gnv.vnm.selfcare.webapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gnv.vnm.selfcare.core.adapter.BackEndAdapterResponse;
import com.gnv.vnm.selfcare.webapi.DefaultApiResponse;
import com.gnv.vnm.selfcare.webapi.model.ApiResponse;
import com.gnv.vnm.selfcare.webapi.model.DataSharingRequest;

/**
 * @author nandipinto
 *
 */

@RestController
@RequestMapping(value = "/datasharing")
public class DataSharingController extends BaseRestController {

	@PostMapping(value = "/register")
	public ResponseEntity<?> register(@RequestBody DataSharingRequest request){
		
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

		BackEndAdapterResponse response = backEndRequestProcessor.registerDataSharing(request.getMsisdn(), request.getPackageId(), request.getMembers());
		ApiResponse ar = new ApiResponse();
		if (response.isSuccessful()) {
			ar.setSuccessful(true);
			ar.setCode(DefaultApiResponse.SUCCESS.code());
			ar.setMessage(DefaultApiResponse.SUCCESS.message());
		}else {
			ar.setCode(response.getResponseCode());
			ar.setMessage(response.getResponseDescription());
		}
		return new ResponseEntity<>(ar, HttpStatus.OK);
	}
	
	@PostMapping(value = "/delete/{msisdn}/{packageId}")
	public ResponseEntity<?> delete(@PathVariable String msisdn, @PathVariable String packageId){
		
		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		BackEndAdapterResponse response = backEndRequestProcessor.deleteDataSharing(msisdn, packageId);

		ApiResponse ar = new ApiResponse();
		if (response.isSuccessful()) {
			ar.setSuccessful(true);
			ar.setCode(DefaultApiResponse.SUCCESS.code());
			ar.setMessage(DefaultApiResponse.SUCCESS.message());
		}else {
			ar.setCode(response.getResponseCode());
			ar.setMessage(response.getResponseDescription());
		}
		return new ResponseEntity<>(ar, HttpStatus.OK);
	}

}
