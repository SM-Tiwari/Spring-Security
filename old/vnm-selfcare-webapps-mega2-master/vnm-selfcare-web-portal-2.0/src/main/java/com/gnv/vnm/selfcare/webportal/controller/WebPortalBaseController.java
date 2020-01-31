/**
 * WebPortalBaseController.java
 */
package com.gnv.vnm.selfcare.webportal.controller;

import java.security.Principal;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;

import com.gnv.vnm.selfcare.core.AppDefaultValues;
import com.gnv.vnm.selfcare.core.enums.LmsConfigNames;
import com.gnv.vnm.selfcare.core.enums.SubscriberType;
import com.gnv.vnm.selfcare.core.model.SubscriberProfile;
import com.gnv.vnm.selfcare.core.security.AuthConstants;
import com.gnv.vnm.selfcare.core.service.ApplicationConfigurationService;
import com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor;
import com.gnv.vnm.selfcare.core.service.ContentManagementService;
import com.gnv.vnm.selfcare.core.service.EposDbClient;
import com.gnv.vnm.selfcare.core.service.FattyMonsterService;
import com.gnv.vnm.selfcare.core.service.HotNewsManagementService;
import com.gnv.vnm.selfcare.core.service.MicInformationService;
import com.gnv.vnm.selfcare.core.service.PaymentGatewayService;
import com.gnv.vnm.selfcare.core.service.PopupBannerManagementService;
import com.gnv.vnm.selfcare.core.service.ProductManagementService;
import com.gnv.vnm.selfcare.core.service.ProvinceDistrictService;
import com.gnv.vnm.selfcare.core.service.PushedCampaignService;
import com.gnv.vnm.selfcare.core.service.StoreManagementService;
import com.gnv.vnm.selfcare.core.service.SubscriberManagementService;
import com.gnv.vnm.selfcare.core.service.TibcoServiceProvider;
import com.gnv.vnm.selfcare.webportal.config.TopMenu;
import com.gnv.vnm.selfcare.webportal.filter.JwtTokenUtil;

/**
 * @author nandipinto
 *
 */
public class WebPortalBaseController {

	static final String DEFAULT_AVATAR 	= "/static/assets/image/default-avatar.png";
	static final int ITEMS_PER_PAGE 		= 12;
	static final String ETOPUP_SESSION = "ETOPUP_SESSION";
	
	static final int MIN_REDEEM_POINT = 5;
	static final int MIN_MONSTER_WEIGHT = 5;
	static final int MAX_MONSTER_WEIGHT = 1000;
	
	static final long FIVE_MINUTES = 5 * 60 * 1000;
	
	static final String MONSTER_IMG_LEVEL1 = "Level_1.png";
	static final String MONSTER_IMG_LEVEL2 = "Level_2.png";
	static final String MONSTER_IMG_LEVEL3 = "Level_3.png";
	static final String MONSTER_IMG_LEVEL4 = "Level_4.png";
	static final String MONSTER_IMG_LEVEL5 = "Level_5.png";
	static final String MONSTER_IMG_LEVEL6 = "Level_6.png";

	static final String TOPUP_REFERER_PETIE = "PETIE";
	
	@Autowired 
	protected MessageSource messageSource;
	
	@Autowired
	protected ApplicationConfigurationService applicationConfigurationService;
	@Autowired
	protected SubscriberManagementService subscriberManagementService;
	@Autowired
	protected ProductManagementService productManagementService;
	@Autowired
	protected EposDbClient eposDbClient;
	@Autowired
	protected BackEndRequestProcessor backEndRequestProcessor;
	@Autowired
	protected PaymentGatewayService paymentGatewayService;
	@Autowired
	protected StoreManagementService storeManagementService;
	@Autowired
	protected PushedCampaignService pushedCampaignService;
	@Autowired
	protected ContentManagementService contentManagementService;
	@Autowired
	protected MicInformationService micInformationService;
	@Autowired
	protected ProvinceDistrictService provinceDistrictService;
	
	@Autowired
	protected FattyMonsterService fattyMonsterService;
	
	@Autowired
	protected HotNewsManagementService hotNewsManagementService;
	
	@Autowired
	protected PopupBannerManagementService popupBannerManagementService;
	
	protected SubscriberProfile profile = null;
	
	@Autowired
	protected TibcoServiceProvider tibcoServiceProvider;
	
	
	
	private long lastLmsConfigLoad = -1;
	
	private JwtTokenUtil jwtTokenUtil;
	
	protected Map<String, Object> lmsConfigs = null;

	protected SubscriberType getCurrentSubscriberType() {
		return profile != null ? profile.getType() : null;
		}
	
	protected String resolveMessage(MessageSource messageSource, String key, Object[] args, String defaultMessage, Locale locale){
		return messageSource.getMessage(key, args, defaultMessage, locale);
	}
	
	protected SubscriberProfile getProfile(HttpServletRequest request, Principal authUser){
		if (authUser == null) return null;
		
		SubscriberProfile profile = subscriberManagementService.getSubscriberProfile(authUser.getName(), false);
		if (profile != null && !StringUtils.hasText(profile.getAvatar())){
			profile.setAvatar(request.getContextPath() + DEFAULT_AVATAR);
		}
		return profile;
	}
	
	protected void setSessionData(Model model, HttpServletRequest request, SubscriberProfile profile, Locale locale){
		if (profile != null) {
			model.addAttribute("userProfile", profile);
			//previously notificationCount
			model.addAttribute("messageCount", pushedCampaignService.getCampaignCount(profile.getMsisdn()));
			model.addAttribute("unreadMessageCount", pushedCampaignService.getUnreadCampaignCount(profile.getMsisdn()));
		}
		
		if (locale.getLanguage().equalsIgnoreCase(AppDefaultValues.LANGUAGE_ENGLISH)) {
			model.addAttribute("contactus_phoneno", applicationConfigurationService.get("contactus.phoneno.en", "0922366366").toString());
		} else {
			model.addAttribute("contactus_phoneno", applicationConfigurationService.get("contactus.phoneno.vi", "0922789789").toString());
		}
		
		model.addAttribute("contactus_email_addr", applicationConfigurationService.get("contactus.email.addr", "cskh@vietnamobile.com.vn").toString());
		model.addAttribute("contactus_email_subject", applicationConfigurationService.get("contactus.email.subject", "Self Care").toString());
	}
	
	protected void setActiveTopMenu(Model model, TopMenu topMenu){
		model.addAttribute("activeTopMenu", topMenu.name());
	}

	protected int getMonsterWeight(int points) {
		int minWeight = Integer.parseInt(getLmsConfigs().getOrDefault(LmsConfigNames.MIN_MONSTER_WEIGHT, "" + MIN_MONSTER_WEIGHT).toString());
		
		return points >= minWeight ? points : minWeight; 
	}
	
	protected String getMonsterImageName(int weight) {
		
		lmsConfigs = getLmsConfigs();
		
		if (weight >= 10) {
			if (weight >= 20) {
				if (weight >= 40) {
					if (weight >= 100) {
						if (weight >= 1000) {
							return lmsConfigs.getOrDefault(LmsConfigNames.MONSTER_IMG_LEVEL6, MONSTER_IMG_LEVEL6).toString();
						} else {
							return lmsConfigs.getOrDefault(LmsConfigNames.MONSTER_IMG_LEVEL5, MONSTER_IMG_LEVEL5).toString();
						}
					} else {
						return lmsConfigs.getOrDefault(LmsConfigNames.MONSTER_IMG_LEVEL4, MONSTER_IMG_LEVEL4).toString();
					}
				} else {
					return lmsConfigs.getOrDefault(LmsConfigNames.MONSTER_IMG_LEVEL3, MONSTER_IMG_LEVEL3).toString();
				}
			} else {
				return lmsConfigs.getOrDefault(LmsConfigNames.MONSTER_IMG_LEVEL2, MONSTER_IMG_LEVEL2).toString();
			}
		}
		
		return lmsConfigs.getOrDefault(LmsConfigNames.MONSTER_IMG_LEVEL1, MONSTER_IMG_LEVEL1).toString();
	}
	
	public int getPetieLevel(int point) {
		int level = 0;

		if (point >= 1000) {
			level = 6;
		} else if (point >= 100) {
			level = 5;
		} else if (point >= 40) {
			level = 4;
		} else if (point >= 20) {
			level = 3;
		} else if (point >= 10) {
			level = 2;
		} else {
			level = 1;
		}

		return level;
	}
	
	protected Map<String, Object> getLmsConfigs() {
		long now = System.currentTimeMillis();
		//reload config if empty or last read was 5 minutes ago
		if (lmsConfigs == null || lastLmsConfigLoad == -1 || (( now - lastLmsConfigLoad ) >= FIVE_MINUTES)) {
			lmsConfigs = backEndRequestProcessor.getLmsConfigs();
			
			lastLmsConfigLoad = System.currentTimeMillis();
		}
		return lmsConfigs;
	}
	protected JwtTokenUtil getJwtTokenUtil() {
		if (jwtTokenUtil == null) {
			String issuer = applicationConfigurationService.get("security.token.issuer", AuthConstants.JWT_ISSUER).toString();
			String signature = applicationConfigurationService.get("security.token.signature", AuthConstants.JWT_SIGNATURE).toString();
			long expiration = Long.parseLong(applicationConfigurationService
					.get("security.token.expirationinminutes", AuthConstants.TOKEN_VALIDITY_IN_MINUTES).toString());

			jwtTokenUtil = new JwtTokenUtil(issuer, signature, expiration * 60 * 60 * 1000);
		}

		return jwtTokenUtil;
	}
	
	protected SubscriberProfile getProfile(HttpServletRequest request, Principal authUser, Locale locale){
		if (authUser == null) return null;
		
		profile = subscriberManagementService.getSubscriberProfile(authUser.getName(), false, locale.getLanguage());
		if (profile != null && !StringUtils.hasText(profile.getAvatar())){
			profile.setAvatar(request.getContextPath() + DEFAULT_AVATAR);
		}
		return profile;
	}
}
