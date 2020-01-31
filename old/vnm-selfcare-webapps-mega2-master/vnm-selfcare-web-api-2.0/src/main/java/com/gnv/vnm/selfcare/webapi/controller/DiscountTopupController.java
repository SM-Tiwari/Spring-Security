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

import com.gnv.vnm.selfcare.core.model.DiscountTopUp;
import com.gnv.vnm.selfcare.core.service.DiscountTopupService;
@RestController
public class DiscountTopupController extends BaseRestController{

	private static final Logger logger = LoggerFactory.getLogger(DiscountTopupController.class);
	@Autowired
	private DiscountTopupService discountTopupService;
	@GetMapping(value = "/topupdiscount/{lang}")
	public ResponseEntity<?> getDiscountTopupdata(@PathVariable String lang) {
		return new ResponseEntity<List<DiscountTopUp>>(discountTopupService.getDiscountTopupData(lang), HttpStatus.OK);
	}
	
}
