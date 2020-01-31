/**
 * PackageSubscriptionController.java
 */
package com.gnv.vnm.selfcare.webapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gnv.vnm.selfcare.core.adapter.BackEndAdapterResponse;
import com.gnv.vnm.selfcare.core.enums.ClientAppId;
import com.gnv.vnm.selfcare.core.enums.SubscriptionStatus;
import com.gnv.vnm.selfcare.core.model.PackageSubscription;
import com.gnv.vnm.selfcare.webapi.DefaultApiResponse;
import com.gnv.vnm.selfcare.webapi.model.ApiResponse;

/**
 * @author nandipinto
 *
 */

@RestController
@RequestMapping("/package")
public class PackageSubscriptionController extends BaseRestController{
	
	@GetMapping(value = "/list/{msisdn}/{langCode}")
	public ResponseEntity<?> getSubscribedPackages(@PathVariable("msisdn") String msisdn, @PathVariable String langCode) {

		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		if (!subscriberManagementService.isActiveSubscriber(msisdn)) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn), HttpStatus.OK);
		}

		List<PackageSubscription> list = subscriberManagementService.getSubscribedPackages(msisdn, langCode);

		return new ResponseEntity<List<PackageSubscription>>(list, HttpStatus.OK);
	}

	@GetMapping(value = "/details/{msisdn}/{packageId}")
	public ResponseEntity<?> getSubscribedPackageDetail(@PathVariable String msisdn, @PathVariable String packageId){
		
		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		if (!subscriberManagementService.isActiveSubscriber(msisdn)) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn), HttpStatus.OK);
		}

		PackageSubscription pkg = subscriberManagementService.getPackageSubscriptionDetails(msisdn, packageId);
		return new ResponseEntity<>(pkg, HttpStatus.OK);
	}
	
	@PostMapping(value = "/purchase/{msisdn}/{packageId}")
	public ResponseEntity<?> purchasePackage(@PathVariable String msisdn, @PathVariable String packageId){
		
		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		if (!subscriberManagementService.isActiveSubscriber(msisdn)) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn), HttpStatus.OK);
		}
		/*
		if (subscriberManagementService.getProductSubscriptionStatus(msisdn, packageId).equals(SubscriptionStatus.ACTIVE)){
			return new ResponseEntity<>(DefaultApiResponse.SUBSCRIPTION_ALREADY_ACTIVE, HttpStatus.OK);
		}
		*/
		BackEndAdapterResponse result = backEndRequestProcessor.activatePackageSubscription(msisdn, packageId, ClientAppId.MOBILE_APP);
		return new ResponseEntity<>(result.getResponseCode(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/cancel/{msisdn}/{packageId}")
	public ResponseEntity<?> cancelPackage(@PathVariable String msisdn, @PathVariable String packageId){
		
		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(DefaultApiResponse.UNAUTHORIZED.message(), HttpStatus.OK);
		}

		if (!subscriberManagementService.isActiveSubscriber(msisdn)) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn), HttpStatus.OK);
		}

		boolean result = backEndRequestProcessor.cancelPackageSubscription(msisdn, packageId);
		return new ResponseEntity<>(result ? "1" : "0", HttpStatus.OK);
	}

	@GetMapping(value = "/status/{msisdn}/{packageId}")
	public ResponseEntity<?> geteSubscriptionStatus(@PathVariable String msisdn, @PathVariable String packageId){
		
		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		if (!subscriberManagementService.isActiveSubscriber(msisdn)) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn), HttpStatus.OK);
		}
		
		SubscriptionStatus status = backEndRequestProcessor.getPackageSubscriptionStatus(msisdn, packageId);
		return new ResponseEntity<>(status != null ? status.name() : "", HttpStatus.OK);
	}
	
	/*
	//use purchasePackage instead (as advised by Tuan)
	@PostMapping(value = "/change/{msisdn}/{oldPackageId}/{newPackageId}")
	public ResponseEntity<?> changePackage(@PathVariable String msisdn, @PathVariable String oldPackageId, @PathVariable String newPackageId){
		
		if (!subscriberManagementService.isActiveSubscriber(msisdn)) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND, msisdn), HttpStatus.OK);
		}

		boolean result = backEndRequestProcessor.changePackageSubscription(msisdn, oldPackageId, newPackageId);
		return new ResponseEntity<>(result ? "1" : "0", HttpStatus.OK);
	}
	*/
}
