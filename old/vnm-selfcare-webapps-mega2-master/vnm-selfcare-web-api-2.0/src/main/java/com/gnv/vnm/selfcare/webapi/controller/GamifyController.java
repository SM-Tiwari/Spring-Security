/**
 * GamifyController.java
 */
package com.gnv.vnm.selfcare.webapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gnv.vnm.selfcare.core.adapter.BackEndAdapterResponse;
import com.gnv.vnm.selfcare.core.adapter.gamify.GamifyGetMonsterResponse;
import com.gnv.vnm.selfcare.core.adapter.gamify.GamifyRedeemByMonsterRequest;
import com.gnv.vnm.selfcare.core.enums.RequestStatus;
import com.gnv.vnm.selfcare.webapi.DefaultApiResponse;

/**
 * @author nandipinto
 *
 */

@RestController
@RequestMapping(value = "/gamify")
public class GamifyController extends BaseRestController {

	@GetMapping(value = "/getmonsters/{msisdn}/{langCode}")
	public ResponseEntity<?> getMonsters(@PathVariable String msisdn, @PathVariable String langCode){
		
		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(DefaultApiResponse.UNAUTHORIZED.message(), HttpStatus.OK);
		}
		GamifyGetMonsterResponse response = backEndRequestProcessor.getGamifyMonsters(msisdn, langCode);
		if (response != null){
			return new ResponseEntity<>(response.getData(), HttpStatus.OK);
		}else{
			List<GamifyGetMonsterResponse.MonsterData> list = new ArrayList<>();
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
	}
	
	@PostMapping(value = "/redeem")
	public ResponseEntity<?> redeem(@RequestBody GamifyRedeemByMonsterRequest request){
		
		if (!request.getMsisdn().equals(getCurrentUserName())) {
			return new ResponseEntity<>(DefaultApiResponse.INTERNAL_APP_ERROR.message(), HttpStatus.OK);
		}

		BackEndAdapterResponse result = backEndRequestProcessor.gamifyRedeemByMonsters(request);
		if (result.isSuccessful()){
			return new ResponseEntity<>("1: " + RequestStatus.SUCCESS.name(), HttpStatus.OK);
		}else{
			return new ResponseEntity<>("0: " + result.getResponseDescription(), HttpStatus.OK);
		}
		
	}
}
