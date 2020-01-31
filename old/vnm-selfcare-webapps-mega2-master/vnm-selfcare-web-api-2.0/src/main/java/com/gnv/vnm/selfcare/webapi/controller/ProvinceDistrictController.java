package com.gnv.vnm.selfcare.webapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProvinceDistrictController extends BaseRestController  {

	@GetMapping(value = "/getAllProvinceList")
	public ResponseEntity<?> getAllProvinceList(){
		return new ResponseEntity<>(provinceDistrictService.getAllProvince(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getDistrictList/{district}")
	public ResponseEntity<?> getDistrictList(@PathVariable("district") Integer district){
		return new ResponseEntity<>(provinceDistrictService.getDistrictByProvince(district), HttpStatus.OK);
	}
	
}

