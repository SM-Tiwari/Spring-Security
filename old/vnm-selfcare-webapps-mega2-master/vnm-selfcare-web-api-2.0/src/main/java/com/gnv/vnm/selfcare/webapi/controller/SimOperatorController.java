package com.gnv.vnm.selfcare.webapi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gnv.vnm.selfcare.core.model.SimOperatorPrefix;
import com.gnv.vnm.selfcare.dao.entity.SimOperatorEntity;
import com.gnv.vnm.selfcare.dao.entity.SimOperatorPrefixEntity;


@RestController
public class SimOperatorController extends BaseRestController  {

	/*
	 *  To get all SIM operator list 
	 */
	@GetMapping(value = "/getAllSimOperatorList")
	public ResponseEntity<?> getAllSimOperatorList(){
		return new ResponseEntity<>(simOperatorService.getAllSimOperator(), HttpStatus.OK);
	}
	
	/*
	 *  To get MSISDN prefix for individual operator 
	 */ 
	@GetMapping(value = "/getOperatorPrefix/{operatorId}")
	public ResponseEntity<?> getOperatorPrefix(@PathVariable int operatorId) {

		List<SimOperatorPrefix> simOperatorEntities = simOperatorService.getOperatorPrefix(operatorId);
		return new ResponseEntity<>(simOperatorEntities, HttpStatus.OK);
		
		}
	
	
	/*
	 *  To get MSISDN prefix for individual operator 
	 */ 
	@GetMapping(value = "/getAllOperatorPrefix")
	public ResponseEntity<?> getAllOperatorPrefix() {

		List<SimOperatorPrefix> simOperatorEntities = simOperatorService.getAllOperatorPrefix();
		return new ResponseEntity<>(simOperatorEntities, HttpStatus.OK);
		
		}
	
	/*
	 *  Save Operator
	 */
	@PostMapping(value = "/saveOperator")
	public ResponseEntity<?> saveOperator(@RequestBody SimOperatorEntity simOperatorEntity, HttpServletRequest request) {

		String simOperatorEntities = simOperatorService.saveOperator(simOperatorEntity.getOperatorName(),simOperatorEntity.getOperatorStatus());
		return new ResponseEntity<>(simOperatorEntities, HttpStatus.OK);
		
		}
	
	
	/*
	 *  Save Operator with prefix key - value
	 */
	@PostMapping(value = "/saveOperatorPrefix")
	public ResponseEntity<?> saveOperatorPrefix(@RequestBody SimOperatorPrefixEntity simOperatorPrefixEntity, HttpServletRequest request) {

		String simOperatorPrefixEntities = simOperatorService.saveOperatorPrefix(simOperatorPrefixEntity.getOperatorId(),simOperatorPrefixEntity.getOldPrefix(), simOperatorPrefixEntity.getNewPrefix());
		return new ResponseEntity<>(simOperatorPrefixEntities, HttpStatus.OK);
		
		}
	
	

}

