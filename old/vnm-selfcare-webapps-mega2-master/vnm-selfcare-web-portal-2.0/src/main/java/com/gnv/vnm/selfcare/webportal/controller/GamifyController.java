/**
 * GamifyController.java
 */
package com.gnv.vnm.selfcare.webportal.controller;

import java.security.Principal;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gnv.vnm.selfcare.webportal.config.ScreenNames;
import com.gnv.vnm.selfcare.webportal.config.TopMenu;

/**
 * @author nandipinto
 *
 */

@Controller
public class GamifyController extends WebPortalBaseController {

	@GetMapping(value = "/gamify")
	public String gamify(Model model, Principal authUser, Locale locale, HttpServletRequest request, HttpServletResponse response){
		
		setSessionData(model, request, getProfile(request, authUser), locale);
		setActiveTopMenu(model, TopMenu.GAMIFY);

		return ScreenNames.GAMIFY;
	}
}
