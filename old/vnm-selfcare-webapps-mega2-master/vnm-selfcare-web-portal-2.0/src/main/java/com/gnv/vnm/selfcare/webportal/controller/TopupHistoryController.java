/**
 * TopupHistoryController.java
 */
package com.gnv.vnm.selfcare.webportal.controller;

import java.security.Principal;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gnv.vnm.selfcare.core.model.TopUpHistory;
import com.gnv.vnm.selfcare.webportal.config.ScreenNames;
import com.gnv.vnm.selfcare.webportal.config.TopMenu;

/**
 * @author nandipinto
 *
 */

@Controller
public class TopupHistoryController extends WebPortalBaseController {

	@GetMapping(value = "/secure/topuphistory")
	public String topupHistory(Model model, Principal authUser, HttpServletRequest request, Locale locale){
		
		List<TopUpHistory> history = backEndRequestProcessor.getMonthlyTopUpHistory(authUser.getName());
		model.addAttribute("topupHistory", history);

		double totalAmount = 0;
		for (TopUpHistory th : history){
			totalAmount = totalAmount + th.getAmount();
		}
		
		model.addAttribute("totalAmount", totalAmount);
		
		setSessionData(model, request, getProfile(request, authUser), locale);
		setActiveTopMenu(model, TopMenu.HOME);

		return ScreenNames.TOPUP_HISTORY;
	}
	
}
