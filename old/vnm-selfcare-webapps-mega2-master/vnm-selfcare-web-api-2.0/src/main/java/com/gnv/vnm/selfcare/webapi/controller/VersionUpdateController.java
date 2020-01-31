package com.gnv.vnm.selfcare.webapi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import com.gnv.vnm.selfcare.core.model.VersionUpdate;

 

@RestController
public class VersionUpdateController extends BaseRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(VersionUpdateController.class);
	
	
	/*
	 *  To Get version update 
	 */ 
	@GetMapping(value = "/getVnmVersion/{appVersion}/{os}")
	public ResponseEntity<?> viewMicUploadSubscriber(@PathVariable("appVersion") String appVersion, @PathVariable("os") String os) {

		List<VersionUpdate> versionUpdate = versionUpdateService.viewVersionUpdate(appVersion, os);
		if(versionUpdate.size() != 0){
			return new ResponseEntity<>(versionUpdate, HttpStatus.OK);	
		}else{
			return new ResponseEntity<>("No Data", HttpStatus.OK);	
		}
		
		
		}
	
}
