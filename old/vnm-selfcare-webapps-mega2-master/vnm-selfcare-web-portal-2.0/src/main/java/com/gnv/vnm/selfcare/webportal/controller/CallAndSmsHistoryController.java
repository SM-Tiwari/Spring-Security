/**
 * CallAndSmsHistoryController.java
 */
package com.gnv.vnm.selfcare.webportal.controller;

import java.security.Principal;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gnv.vnm.selfcare.core.model.CallRecord;
import com.gnv.vnm.selfcare.core.model.SmsRecord;
import com.gnv.vnm.selfcare.core.security.AuthConstants;
import com.gnv.vnm.selfcare.webportal.config.ScreenNames;
import com.gnv.vnm.selfcare.webportal.config.TopMenu;

/**
 * @author nandipinto
 *
 */

@Controller
public class CallAndSmsHistoryController extends WebPortalBaseController {

	@GetMapping(value = "/secure/history")
	public String getUsageHistory(Model model, Principal authUser, HttpServletRequest request, Locale locale){

		Calendar startDate = Calendar.getInstance();
		startDate.add(Calendar.DATE, -30);
		List<CallRecord> callHistory = backEndRequestProcessor.getCallHistory(authUser.getName(), startDate.getTime(), new Date());
		List<SmsRecord> smsHistory = backEndRequestProcessor.getSmsHistory(authUser.getName(), startDate.getTime(), new Date());
		
		model.addAttribute("callHistory", callHistory);
		model.addAttribute("smsHistory", smsHistory);
//		model.addAttribute("notificationCount", notificationService.getPurchaseNotification(authUser.getName(), false).size());
		
		setSessionData(model, request, getProfile(request, authUser), locale);
		setActiveTopMenu(model, TopMenu.HOME);

		return ScreenNames.USAGE_HISTORY;
	}
	
	 
	
	@GetMapping(value = "/usagehistory/{usermsisdn}")
	public String getUnsecuredUsageHistory(Model model, @PathVariable String usermsisdn){

		String msisdn = "";
		/*try{
		String[] prefixStr = usermsisdn.split("vnm018866789564321securitytoken");
		
		for(String w:prefixStr){  
			String[] suffixStr = w.split("securityimplemntation");
			
			for(String w1:suffixStr){  
				//System.out.println(w1);  
				msisdn = w1;
			}
			
	}
		}
		catch(Exception exception){
			exception.printStackTrace();
			  msisdn = "";
		}*/
		usermsisdn = usermsisdn.replace(AuthConstants.JWT_PREFIX, "");
		byte[] decoded = Base64.getMimeDecoder().decode(usermsisdn);
		String decodeString = new String(decoded);
		msisdn= getJwtTokenUtil().getUsernameFromToken(decodeString);
		System.out.println("final msisdn::"+msisdn);
		Calendar startDate = Calendar.getInstance();
		startDate.add(Calendar.DATE, -30);
		List<CallRecord> callHistory = backEndRequestProcessor.getCallHistory(msisdn, startDate.getTime(), new Date());
		List<SmsRecord> smsHistory = backEndRequestProcessor.getSmsHistory(msisdn, startDate.getTime(), new Date());
		
		model.addAttribute("callHistory", callHistory);
		model.addAttribute("smsHistory", smsHistory);
		setActiveTopMenu(model, TopMenu.HOME);

		return ScreenNames.USAGE_HISTORY;
	}
	
	
	public String convertStringToBase64(String originalInput){
		
		String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
		return encodedString;
	}
	
	public String convertBase64ToString(String encodedString){
		byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
		String decodedString = new String(decodedBytes);
		return decodedString;
	}
	
	}
