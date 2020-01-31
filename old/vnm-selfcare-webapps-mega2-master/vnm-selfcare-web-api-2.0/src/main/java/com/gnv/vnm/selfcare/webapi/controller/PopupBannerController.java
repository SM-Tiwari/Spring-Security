package com.gnv.vnm.selfcare.webapi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.gnv.vnm.selfcare.core.model.PopupBannner;
import com.gnv.vnm.selfcare.core.service.PopupBannerManagementService;

@RestController
public class PopupBannerController extends BaseRestController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(PopupBannerController.class);
	/*-----------*/
	@Autowired
	private PopupBannerManagementService popupBannerManagementService;
	
	@GetMapping(value = "/popupbanner/{lang}")
	public ResponseEntity<?>getPopupBannerData(@PathVariable String lang){
		
		//return null;
		return new ResponseEntity<List<PopupBannner>>(popupBannerManagementService.getPopupBannerData(lang),HttpStatus.OK);
		
	}

}
