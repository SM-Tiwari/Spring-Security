/**
 * BaseRestController.java
 */
package com.gnv.vnm.selfcare.webapi.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.gnv.vnm.selfcare.core.AppDefaultValues;
import com.gnv.vnm.selfcare.core.security.AuthConstants;
import com.gnv.vnm.selfcare.core.service.ApplicationConfigurationService;
import com.gnv.vnm.selfcare.core.service.AvatarService;
import com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor;
import com.gnv.vnm.selfcare.core.service.ContentManagementService;
import com.gnv.vnm.selfcare.core.service.DiscountTopupService;
import com.gnv.vnm.selfcare.core.service.FattyMonsterService;
import com.gnv.vnm.selfcare.core.service.HotNewsManagementService;
import com.gnv.vnm.selfcare.core.service.MicInformationService;
import com.gnv.vnm.selfcare.core.service.PaymentGatewayService;
import com.gnv.vnm.selfcare.core.service.PopupBannerManagementService;
import com.gnv.vnm.selfcare.core.service.ProvinceDistrictService;
import com.gnv.vnm.selfcare.core.service.PushedCampaignService;
import com.gnv.vnm.selfcare.core.service.SMPPServiceProvider;
import com.gnv.vnm.selfcare.core.service.SendSMSService;
import com.gnv.vnm.selfcare.core.service.StoreManagementService;
import com.gnv.vnm.selfcare.core.service.SubscriberManagementService;
import com.gnv.vnm.selfcare.core.service.TibcoServiceProvider;
import com.gnv.vnm.selfcare.core.service.VersionDetailsSevice;
import com.gnv.vnm.selfcare.core.service.VersionUpdateService;
import com.gnv.vnm.selfcare.core.utils.AppUtils;
import com.gnv.vnm.selfcare.core.utils.LoggingUtil;
import com.gnv.vnm.selfcare.dao.repo.BazNotifcationStatusRepository;
import com.gnv.vnm.selfcare.webapi.security.JwtTokenUtil;
import com.gnv.vnm.selfcare.core.service.SimOperatorService;
import com.gnv.vnm.selfcare.core.service.SocialMediaIntegrationService;
/**
 * @author nandipinto
 *
 */
public class BaseRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(BaseRestController.class);
	
	@Autowired 
	protected MessageSource messageSource;

	@Autowired
	SubscriberManagementService subscriberManagementService;
	@Autowired
	BackEndRequestProcessor backEndRequestProcessor;
	@Autowired
	ApplicationConfigurationService applicationConfigurationService;
	@Autowired 
	AvatarService avatarService;
	@Autowired
	PaymentGatewayService paymentGatewayService;
	@Autowired
	PushedCampaignService pushedCampaignService;
	@Autowired
	StoreManagementService storeManagementService;
	@Autowired 
	ContentManagementService contentManagementService;
	@Autowired
	SMPPServiceProvider smppServiceProvider;
	@Autowired
	TibcoServiceProvider tibcoServiceProvider;
	@Autowired
    ProvinceDistrictService provinceDistrictService;
	
	/// Changes By OneClick 10-07-2018
	@Autowired
	VersionUpdateService versionUpdateService;
	/////
	@Autowired
	SimOperatorService simOperatorService;
	@Autowired
    MicInformationService micInformationService;
	
	@Autowired
	BazNotifcationStatusRepository bazNotifcationStatusRepository;
	
	@Autowired
	SocialMediaIntegrationService sMediaIntegrationService;
   
	@Autowired
	  DiscountTopupService discountTopupService;
	@Autowired
	  PopupBannerManagementService popupBannerManagementService;
	@Autowired
	  HotNewsManagementService hotNewsManagementService;
	@Autowired
	  VersionDetailsSevice versionDetailsSevice;
	@Autowired
	SendSMSService sendsmsservice;
	private JwtTokenUtil jwtTokenUtil;

	String getDateFormat() {
		return applicationConfigurationService.get("dateformat.default", AppDefaultValues.DATE_FORMAT).toString();
	}
	
	protected String resolveMessage(MessageSource messageSource, String key, Object[] args, String defaultMessage, Locale locale){
		return messageSource.getMessage(key, args, defaultMessage, locale);
	}
	
	protected String getCurrentUserName() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		LoggingUtil.debug(logger, "--- current principal is= " + (auth != null ? auth.getName() : null));
		return auth != null ? auth.getName() : null;
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
	
	protected boolean isCurrentUserNameValid(String msisdn) {
		String currentUserName = getCurrentUserName();
		if (currentUserName == null) return false;
		
		return stripCountryCode(msisdn).equals(stripCountryCode(currentUserName));
	}
	
	protected String stripCountryCode(String msisdn){
		String countryCode = applicationConfigurationService.getDefaultCountryCode();
		return AppUtils.removeCountryCode(msisdn, countryCode);
	}
}
