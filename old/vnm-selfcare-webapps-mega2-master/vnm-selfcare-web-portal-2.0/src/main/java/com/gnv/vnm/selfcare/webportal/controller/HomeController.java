/**
 * HomeController.java
 */
package com.gnv.vnm.selfcare.webportal.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gnv.vnm.selfcare.core.AppDefaultValues;
import com.gnv.vnm.selfcare.core.enums.BillPaymentStatus;
import com.gnv.vnm.selfcare.core.enums.DisplayOrder;
import com.gnv.vnm.selfcare.core.enums.LmsConfigNames;
import com.gnv.vnm.selfcare.core.enums.SubscriberType;
import com.gnv.vnm.selfcare.core.enums.TransactionStatus;
import com.gnv.vnm.selfcare.core.model.CurrentBalance;
import com.gnv.vnm.selfcare.core.model.DataBalance;
import com.gnv.vnm.selfcare.core.model.HotNews;
import com.gnv.vnm.selfcare.core.model.OutstandingBalance;
import com.gnv.vnm.selfcare.core.model.PopupBannner;
import com.gnv.vnm.selfcare.core.model.Product;
import com.gnv.vnm.selfcare.core.model.SubscriberProfile;
import com.gnv.vnm.selfcare.core.model.TopUpHistory;
import com.gnv.vnm.selfcare.core.model.UnbilledBalance;
import com.gnv.vnm.selfcare.core.utils.Constant;
import com.gnv.vnm.selfcare.core.utils.LoggingUtil;
import com.gnv.vnm.selfcare.webportal.config.ScreenNames;
import com.gnv.vnm.selfcare.webportal.config.TopMenu;

/**
 * @author nandipinto
 *
 */

@Controller
public class HomeController extends WebPortalBaseController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	static final String CURRENT_USER = "CURRENT_USER";

	static final String EXTRA_DATA_PRODUCT_GROUP = "EXTRA_BYTE";
	static final String EXTRA_PACKAGE_PREFIX = "E";
	static final int MAX_DISPLAYED_PRODUCT_COUNT = 3;
	
	
	
	static final String[] NAME_OF_DAYS = { "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY" }; 
	
	
	public  String mode=Constant.MODE;
	@GetMapping("/")
	public String start(Model model, Principal authUser, Locale locale, HttpServletRequest request){
		if (authUser != null) {
			return "redirect:/secure/dashboard";
		}else {
			return ScreenNames.LOGIN;
		}
	}
	
	@GetMapping("/login")
	public String login(){
		return ScreenNames.LOGIN;
	}

	@GetMapping("/secure/dashboard")
	public String dashboard(Model model, Principal authUser, Locale locale, HttpServletRequest request){

		profile = getProfile(request, authUser, locale);
		setSessionData(model, request, profile, locale);
		setActiveTopMenu(model, TopMenu.HOME);
		
		CurrentBalance currentBalance = backEndRequestProcessor.getCurrentBalance(authUser.getName(), locale.getLanguage());
		int dataBalanceCnt = currentBalance.getDataBalance().getBalanceList().size();

		boolean extraPkgEnabled = false;
		if (dataBalanceCnt > 0){
			String pkgName = "";
			//updated on Dec 30, 2017 -- need to exclude data balance with dash board visibility = 0 (false)
			for (DataBalance db : currentBalance.getDataBalance().getBalanceList()){
				if (!db.getName().toUpperCase().startsWith(EXTRA_PACKAGE_PREFIX) && db.isDashboardVisible()) {
					
					model.addAttribute("dataBalance", db); //show the first data balance with biggest remaining value
					
					pkgName = db.getName().toUpperCase();
					extraPkgEnabled = pkgName.startsWith("M") || pkgName.startsWith("F") || pkgName.startsWith("D");
					if (db.getCode() != null){
						List<Product> list = productManagementService.getProductListForChangePackage(db.getCode(), locale.getLanguage());
						if (list != null && !list.isEmpty()){
							model.addAttribute("productListForChangePkg", list);
						}
					}
					break;
				}
			}

		}else{
			model.addAttribute("dataBalance", new DataBalance());
		}
		try{
            String mic_pop_up = (String)request.getSession(true).getAttribute("MIC_SHOW_POPUP");   
            String value="0";
            if(mode.equalsIgnoreCase("test")){
            	//dev
              value=micInformationService.getDevMicStatus(authUser.getName());
            }
            else{
            	//prod
            	value=micInformationService.getMicStatus(authUser.getName());
            }
            System.out.println(value);
            if(mic_pop_up==null){
            	mic_pop_up="0";
            }
            if(value.equals("0") && mic_pop_up.equalsIgnoreCase("0"))
            {
                              
            	model.addAttribute("micstatus", "0");
            	request.getSession(true).setAttribute("MIC_SHOW_POPUP", "1");  
             }else{
            	 model.addAttribute("micstatus", "5");
            }


            }catch (Exception e) {
                            // TODO: handle exception
                            e.printStackTrace();
                            
            }
		String smsCallHistoryStatus = backEndRequestProcessor.getSmsCallHistoryStatus(authUser.getName());
        model.addAttribute("smsCallHistoryStatus",smsCallHistoryStatus);


		model.addAttribute("extraPkgEnabled", extraPkgEnabled);
		//model.addAttribute("currentBalance", currentBalance);
		model.addAttribute("promoBalanceListSize", currentBalance.getPromotionBalance().getBalanceList().size());
	//	model.addAttribute("dataBalanceListSize", dataBalanceCnt);
		
		model.addAttribute("extraDataProducts", productManagementService.getProductsByProductGroupCode(EXTRA_DATA_PRODUCT_GROUP,
				DisplayOrder.PRICE_ASC, locale.getLanguage(), true));
		
		List<Product> recommendedProducts = productManagementService.getRecommendedProducts(locale.getLanguage(), getCurrentSubscriberType());

		//only display 3 products at the front page
		int size = recommendedProducts.size();
		if (size > MAX_DISPLAYED_PRODUCT_COUNT){
		model.addAttribute("recommendedProducts", recommendedProducts.subList(0, MAX_DISPLAYED_PRODUCT_COUNT));
		}else{
		model.addAttribute("recommendedProducts", recommendedProducts);
		}
		
		/*List<Product> recommendedProducts = productManagementService.getRecommendedProducts(locale.getLanguage());
		//only display 3 products at the front page
		int size = recommendedProducts.size();
		if (size > MAX_DISPLAYED_PRODUCT_COUNT){
			model.addAttribute("recommendedProducts", recommendedProducts.subList(0,  MAX_DISPLAYED_PRODUCT_COUNT));
		}else{
			model.addAttribute("recommendedProducts", recommendedProducts);
		}*/
		/**
		 * Start code Add PostPad Migration */
		
		
		model.addAttribute("extraDataProducts", productManagementService.getProductsByProductGroupCode(EXTRA_DATA_PRODUCT_GROUP,
		DisplayOrder.PRICE_ASC, locale.getLanguage(), true, null));

		
		
/*for hotnews by Vimal Start */
		
		List<HotNews> recommendedHotNews = hotNewsManagementService.getHotNewsdata(locale.getLanguage());
		//only display 3 products at the front page
		int sizeH = recommendedHotNews.size();
		if (sizeH > MAX_DISPLAYED_PRODUCT_COUNT){
		model.addAttribute("hotnewsData", recommendedHotNews.subList(0, MAX_DISPLAYED_PRODUCT_COUNT));
		}else{
		model.addAttribute("hotnewsData", recommendedHotNews);
		}


		/*for hotnews by Vimal End*/


		/*for popupBanner by Vimal Start */

		List<PopupBannner> recommendedpopupBanner = popupBannerManagementService.getPopupBannerData(locale.getLanguage());
		//only display 3 products at the front page
		int sizeB = recommendedpopupBanner.size();
		if (sizeB > MAX_DISPLAYED_PRODUCT_COUNT){
		model.addAttribute("popupBannerData", recommendedpopupBanner.subList(0, MAX_DISPLAYED_PRODUCT_COUNT));
		}else{
		model.addAttribute("popupBannerData", recommendedpopupBanner);
		}
		
		
		/*long trxTimeoutInSecs = Long.parseLong(applicationConfigurationService.get("napas.trxtimeout.seconds", "600").toString()); //10 minutes
		model.addAttribute("TRX_TIME_OUT_SECS", trxTimeoutInSecs);*/
		
		//Show Petie monster
		/*int lmsPoint = backEndRequestProcessor.getLmsPoint(authUser.getName());
		int fattyMonsterWeight = getMonsterWeight(lmsPoint);
		String fattyMonsterImg = getMonsterImageName(lmsPoint);
		
		model.addAttribute("petieMonsterWeight", fattyMonsterWeight);
		model.addAttribute("petieMonsterImg", fattyMonsterImg);*/
		
		int minCoreBalance = Integer.parseInt(getLmsConfigs().getOrDefault(LmsConfigNames.CORE_BALANCE_MIN_AMOUNT.name(), "0").toString());
		int availableBalance = currentBalance.getCoreBalance().getAvailableValue();
		
		model.addAttribute("minCoreBalance", minCoreBalance);
		model.addAttribute("coreBalance", availableBalance);
		
		String lang = locale.getLanguage();
		String hungryMsgTitle = lang.equalsIgnoreCase(AppDefaultValues.LANGUAGE_VIETNAMESE)
				? getLmsConfigs().getOrDefault(LmsConfigNames.POPUP_NOTIF_HUNGRY_TITLE_VI.name(), "").toString()
				: getLmsConfigs().getOrDefault(LmsConfigNames.POPUP_NOTIF_HUNGRY_TITLE_EN.name(), "").toString();
				
		String hungryMsgTxt = lang.equalsIgnoreCase(AppDefaultValues.LANGUAGE_VIETNAMESE)
				? getLmsConfigs().getOrDefault(LmsConfigNames.POPUP_NOTIF_HUNGRY_TEXT_VI.name(), "").toString()
				: getLmsConfigs().getOrDefault(LmsConfigNames.POPUP_NOTIF_HUNGRY_TEXT_EN.name(), "").toString();

		String fullMsgTitle = lang.equalsIgnoreCase(AppDefaultValues.LANGUAGE_VIETNAMESE)
				? getLmsConfigs().getOrDefault(LmsConfigNames.POPUP_NOTIF_FULL_TITLE_VI.name(), "").toString()
				: getLmsConfigs().getOrDefault(LmsConfigNames.POPUP_NOTIF_FULL_TITLE_EN.name(), "").toString();
				
		String fullMsgTxt = lang.equalsIgnoreCase(AppDefaultValues.LANGUAGE_VIETNAMESE)
				? getLmsConfigs().getOrDefault(LmsConfigNames.POPUP_NOTIF_FULL_TEXT_VI.name(), "").toString()
				: getLmsConfigs().getOrDefault(LmsConfigNames.POPUP_NOTIF_FULL_TEXT_EN.name(), "").toString();
				
		model.addAttribute("hungryMsgTitle", hungryMsgTitle);
		model.addAttribute("hungryMsgTxt", hungryMsgTxt);
		
		model.addAttribute("fullMsgTitle", fullMsgTitle);
		model.addAttribute("fullMsgTxt", fullMsgTxt);
		
		model.addAttribute("hungryMonsterImg", getLmsConfigs().getOrDefault(LmsConfigNames.POPUP_NOTIF_IMAGE_HUNGRY.name(), 
				request.getContextPath() + "/static/assets/image/weak.png").toString());
		model.addAttribute("fullMonsterImg", getLmsConfigs().getOrDefault(LmsConfigNames.POPUP_NOTIF_IMAGE_FULL.name(), 
				request.getContextPath() + "/static/assets/image/strong.png").toString());
		
		model.addAttribute("showWeakMonsterPopup", showWeakMonsterPopup(availableBalance, minCoreBalance, request) ? "1" : "0");
		
		String strongMonsterShownInSession = (String)request.getSession().getAttribute("STRONG_MONSTER_POPUP_SHOWN");
		LoggingUtil.debug(logger, "---strongMonsterShownInSession = " + strongMonsterShownInSession);
		System.out.println("---strongMonsterShownInSession = " + strongMonsterShownInSession+" type :::"+profile.getType().name());
		if (strongMonsterShownInSession == null) {
			List<TopUpHistory> topupHistory = backEndRequestProcessor.getTopupHistoryBySessionId(request.getSession().getId(), WebPortalBaseController.TOPUP_REFERER_PETIE);
			if (topupHistory != null && !topupHistory.isEmpty()) {
				TopUpHistory th = topupHistory.get(0);
				if (th.getStatus().equals(TransactionStatus.SUCCESS) && (currentBalance.getCoreBalance().getAvailableValue() > minCoreBalance)) {
					
					model.addAttribute("showStrongMonsterPopup", "1");
				
					request.getSession().setAttribute("STRONG_MONSTER_POPUP_SHOWN", "1");
				}
			}
		}
		if (profile.getType().name().trim().equalsIgnoreCase(SubscriberType.POSTPAID.name().trim())) {
		
			List<OutstandingBalance> outstandingBalanceList = tibcoServiceProvider.getOutstandingBalances(authUser.getName());
			UnbilledBalance unbilledBalance = tibcoServiceProvider.getUnbilledBalanceSummary(authUser.getName());
            System.out.println("outstandingBalanceList :::"+outstandingBalanceList.size());
			model.addAttribute("outstandingBalanceList", outstandingBalanceList);
			model.addAttribute("outstandingBalanceSize", outstandingBalanceList.size());

			model.addAttribute("unbilledBalance", unbilledBalance);

			currentBalance.setOutstandingBalance(tibcoServiceProvider.getCurrentOutstandingBalance(authUser.getName()));
		}
		model.addAttribute("currentBalance", currentBalance);
		model.addAttribute("dataBalanceListSize", dataBalanceCnt);
		
		long trxTimeoutInSecs = Long.parseLong(applicationConfigurationService.get("napas.trxtimeout.seconds", "600", false).toString()); //10 minutes
		model.addAttribute("TRX_TIME_OUT_SECS", trxTimeoutInSecs);

		//Show Petie monster
		int lmsPoint = backEndRequestProcessor.getLmsPoint(authUser.getName());
		int fattyMonsterWeight = getMonsterWeight(lmsPoint);
		String fattyMonsterImg = getMonsterImageName(lmsPoint);

		model.addAttribute("petieMonsterWeight", fattyMonsterWeight);
		model.addAttribute("petieMonsterImg", fattyMonsterImg);

		return profile.getType().equals(SubscriberType.PREPAID) ? ScreenNames.DASHBOARD : ScreenNames.POSTPAID_DASHBOARD;
	}

	/**
	 * Determine if Weak Monster popup should be displayed based on the defined schedules
	 * @return
	 */
	private boolean showWeakMonsterPopup(double availableBalance, double minCoreBalance, HttpServletRequest request) {
		
		LoggingUtil.debug(logger, "#showWeakMonsterPopup --- available balance= " + availableBalance + ", min core balance= " + minCoreBalance);
		
		if (availableBalance > minCoreBalance) {
			LoggingUtil.debug(logger, "#showWeakMonsterPopup --- not showing weak monster popup!");
			return false;
		}
		
		String weakMonsterShownInSession = (String)request.getSession().getAttribute("WEAK_MONSTER_POPUP_SHOWN");
		
		LoggingUtil.debug(logger, "---weakMonsterShownInSession = " + weakMonsterShownInSession);
		if (weakMonsterShownInSession != null) {
			LoggingUtil.debug(logger, "#showWeakMonsterPopup --- has been shown in current session, not showing weak monster popup again!");
			return false;
		}
		
		Calendar cal = Calendar.getInstance();
		int dayIdx = cal.get(Calendar.DAY_OF_WEEK) - 1;
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		//int min = cal.get(Calendar.MINUTE);
		
		List<Integer> displayHours = getHoursToShow();
		String[] daysInConfig = getLmsConfigs().getOrDefault("POPUP_NOTIF_DAYS", "").toString().split(",");
		if (daysInConfig.length > 0) {
			for (String day : daysInConfig) {
				if (NAME_OF_DAYS[dayIdx].equals(day.toUpperCase()) && displayHours.contains(hour)) { //&& min == 0
					
					request.getSession().setAttribute("WEAK_MONSTER_POPUP_SHOWN", "1");
					LoggingUtil.debug(logger, "#showWeakMonsterPopup --- weak popup will be shown!");
					return true;
				}
			}
		}
		return false;
	}
	
	private List<Integer> getHoursToShow(){
		//
		int hourInterval = Integer.parseInt(getLmsConfigs().getOrDefault("POPUP_NOTIF_HOURS", "6").toString());
		List<Integer> hours = new ArrayList<>();
		
		for (int i=1; i<=24; i++) {
			if (i % hourInterval == 0) {
				hours.add(i);
			}
		}
		return hours;
	}
	
	@GetMapping(value = "/secure/mycorebalance")
	private ResponseEntity<?> getAvailableCoreBalance(Principal authUser, Locale locale, HttpServletRequest request){
		CurrentBalance balance = backEndRequestProcessor.getCurrentBalance(authUser.getName(), locale.getLanguage());
		
		int availableBalance = balance != null && balance.getCoreBalance() != null ? balance.getCoreBalance().getAvailableValue() : 0;
		
		request.getSession().removeAttribute("PETIE_TOPUP_REF_ORDER_ID");
		
		return new ResponseEntity<>(availableBalance, HttpStatus.OK);
	}
}
