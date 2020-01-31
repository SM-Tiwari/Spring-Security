package com.gnv.vnm.selfcare.webportal.controller;

import java.text.MessageFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gnv.vnm.selfcare.webportal.config.ScreenNames;
import com.google.common.base.Throwables;

/**
 * @author  nandipinto
 * @version 1.0
 *
 */

@Controller
public class CustomErrorController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomErrorController.class);
	
	@RequestMapping(value = "/denied")
	public String denyAccess(){
		return ScreenNames.ACCESS_DENIED;
	}

	@RequestMapping("/apperror")	
	public String generalError(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		
		String viewName = "";
		if (statusCode == HttpStatus.NOT_FOUND.value()){
			viewName = ScreenNames.PAGE_NOT_FOUND;
			
		}else{
			viewName = ScreenNames.ERROR_PAGE;
			
			Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
			String exceptionMessage = getExceptionMessage(throwable, statusCode);
			
			String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
			if (requestUri == null) {
				requestUri = "Unknown";
			}
			
			String message = MessageFormat.format("Error Code= [{0}], Error Message= [{1}]",  statusCode, exceptionMessage); 
			model.addAttribute("errorMessage", message);
			
			logger.error("Unexpected application error", throwable);
		}
		
        return viewName;
	}

	private String getExceptionMessage(Throwable throwable, Integer statusCode) {
		if (throwable != null) {
			return Throwables.getRootCause(throwable).getMessage();
		}
		HttpStatus httpStatus = HttpStatus.valueOf(statusCode);
		return httpStatus.getReasonPhrase();
	}

}
