/**
 * MusicContentController.java
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
@RequestMapping(value = "/shop/content")
public class MusicContentController extends WebPortalBaseController {
	
	@GetMapping(value = "/music")
	public String music(Model model, Locale locale, HttpServletRequest request, Principal authUser){
		
		setSessionData(model, request, getProfile(request, authUser), locale);
		setActiveTopMenu(model, TopMenu.SHOP);

		return ScreenNames.MUSIC;
	}
	

}
