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

import com.gnv.vnm.selfcare.core.model.HotNews;
import com.gnv.vnm.selfcare.core.service.HotNewsManagementService;



@RestController
public class HotNewsController extends BaseRestController {

	private static final Logger logger = LoggerFactory.getLogger(HotNewsController.class);
	@Autowired
	private HotNewsManagementService hotNewsManagementService;
	@GetMapping(value = "/hotnews/{lang}")
	public ResponseEntity<?> getHotNewsBanner(@PathVariable String lang) {
		return new ResponseEntity<List<HotNews>>(hotNewsManagementService.getHotNewsdata(lang), HttpStatus.OK);
	}
}
