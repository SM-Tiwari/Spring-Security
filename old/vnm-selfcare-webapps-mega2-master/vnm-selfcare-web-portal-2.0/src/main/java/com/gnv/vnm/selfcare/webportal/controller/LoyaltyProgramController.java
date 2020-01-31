/**
 * 
 */
package com.gnv.vnm.selfcare.webportal.controller;

import java.security.Principal;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gnv.vnm.selfcare.webportal.config.ScreenNames;
import com.gnv.vnm.selfcare.webportal.config.TopMenu;

/**
 * @author nandipinto
 *
 */

@Controller
@RequestMapping(value = "/lp")
public class LoyaltyProgramController extends WebPortalBaseController {

	@GetMapping(value = "/intro")
	public String music(Model model, Locale locale, HttpServletRequest request, Principal authUser){
		
		setSessionData(model, request, getProfile(request, authUser), locale);
		setActiveTopMenu(model, TopMenu.ACCOUNT);

		return ScreenNames.STATIC_LOYALTY_PROGRAM;
	}

}
