/**
 * AccountDetailsController.java
 */
package com.gnv.vnm.selfcare.webportal.controller;

import java.security.Principal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gnv.vnm.selfcare.core.enums.NotificationStatus;
import com.gnv.vnm.selfcare.core.model.CurrentBalance;
import com.gnv.vnm.selfcare.core.model.PackageSubscription;
import com.gnv.vnm.selfcare.core.model.PushedCampaign;
import com.gnv.vnm.selfcare.webportal.config.ScreenNames;
import com.gnv.vnm.selfcare.webportal.config.TopMenu;

/**
 * @author nandipinto
 *
 */

@Controller
public class AccountDetailsController extends WebPortalBaseController {

	
	@GetMapping("/secure/account")
	public String dashboard(Model model, HttpServletRequest request, HttpServletResponse response, Principal authUser, Locale locale){
		setSessionData(model, request, getProfile(request, authUser), locale);
		setActiveTopMenu(model, TopMenu.HOME);
		
		CurrentBalance currentBalance = backEndRequestProcessor.getCurrentBalance(authUser.getName(), locale.getLanguage());
		int dataBalanceCnt = currentBalance.getDataBalance().getBalanceList().size();

		model.addAttribute("currentBalance", currentBalance);
		model.addAttribute("promoBalanceListSize", currentBalance.getPromotionBalance().getBalanceList().size());
		model.addAttribute("dataBalanceListSize", dataBalanceCnt);

		List<PackageSubscription> vasProductList = backEndRequestProcessor.getSubscribedPackages(authUser.getName(), null, locale.getLanguage());
		Collections.sort(vasProductList, new Comparator<PackageSubscription>() {
			   @Override
				public int compare(PackageSubscription o1, PackageSubscription o2) {
					// TODO Auto-generated method stub
					return o2.getEndDate().compareTo(o1.getEndDate());
				}
			});
		model.addAttribute("vasProductList", vasProductList);
		model.addAttribute("vasProductListSize", vasProductList.size());
		
		return ScreenNames.ACCOUNT_DETAILS;
	}
	
	@GetMapping("/secure/notifications")
	public String notifications(Model model, HttpServletRequest request, HttpServletResponse response, Principal authUser, Locale locale){
		
		setSessionData(model, request, getProfile(request, authUser), locale);
		setActiveTopMenu(model, TopMenu.NOTIFICATIONS);
		
		List<PushedCampaign> notifications = pushedCampaignService.getCampaigns(authUser.getName(), null, new NotificationStatus[] { NotificationStatus.UNREAD }, null, 0);
		model.addAttribute("notificationList", notifications);
		
		//added on June 01, 2018
		pushedCampaignService.setCampaignStatus(authUser.getName(), NotificationStatus.READ.ordinal());
		
		return ScreenNames.NOTIFICATIONS;
	}

}
