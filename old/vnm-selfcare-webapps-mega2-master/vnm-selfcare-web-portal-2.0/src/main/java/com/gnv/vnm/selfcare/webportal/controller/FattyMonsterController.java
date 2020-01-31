package com.gnv.vnm.selfcare.webportal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gnv.vnm.selfcare.core.model.FattyRedeemPointRequest;

@Controller
@RequestMapping(value = "/secure/fatty")
public class FattyMonsterController extends WebPortalBaseController
{
	private static final Logger logger = LoggerFactory.getLogger(FattyMonsterController.class);
	
	@RequestMapping(value = "/redeemPoint/", method = RequestMethod.POST)
	public ResponseEntity<?> redeemFattyPopnt(@RequestBody FattyRedeemPointRequest request )
	{
		try {
			request.setUserType("consoleUser");
			fattyMonsterService.redeemPoint(request);
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return new ResponseEntity<>("OK", HttpStatus.OK);
	}
}
