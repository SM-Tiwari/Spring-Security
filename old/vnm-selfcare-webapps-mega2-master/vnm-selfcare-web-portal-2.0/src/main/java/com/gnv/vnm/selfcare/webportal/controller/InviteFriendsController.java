/**
 * 
 */
package com.gnv.vnm.selfcare.webportal.controller;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gnv.vnm.selfcare.core.fault.SubscriberNotFoundException;
import com.gnv.vnm.selfcare.webportal.config.DefaultWebPortalMessages;
import com.gnv.vnm.selfcare.webportal.config.ScreenNames;
import com.gnv.vnm.selfcare.webportal.config.TopMenu;

/**
 * @author nandipinto
 *
 */

@Controller
@RequestMapping(value = "/secure/invite")
public class InviteFriendsController extends WebPortalBaseController {

	
	@GetMapping(value = "/init")
	public String showForm(Model model, HttpServletRequest request, Locale locale, Principal authUser) {
		
		setActiveTopMenu(model, TopMenu.ACCOUNT);
		setSessionData(model, request, getProfile(request, authUser), locale);

		return ScreenNames.INVITE_FRIENDS;
	}
	
	@RequestMapping(value = "/confirm", method = {RequestMethod.GET, RequestMethod.POST})
	public String confirm(Model model, HttpServletRequest request, Locale locale, Principal authUser) {
		
		String[] params = ServletRequestUtils.getStringParameters(request, "phoneNumber");
		if (params != null && params.length > 0) {
			
			List<String> phoneNumbers = Arrays.asList(params);
			try {
				subscriberManagementService.inviteMembers(authUser.getName(), phoneNumbers);
				
				String message = resolveMessage(messageSource, "Message.InviteFriends.InvitationSent", null, DefaultWebPortalMessages.INVITATION_SENT.message(), locale);
				model.addAttribute("message", message);
				
			} catch (SubscriberNotFoundException e) {
				//can safely ignore this exception -- only applicable for mobile app
			}
		}
		
		setActiveTopMenu(model, TopMenu.ACCOUNT);
		setSessionData(model, request, getProfile(request, authUser), locale);
		
		return ScreenNames.INVITE_FRIENDS;
	}
}
