/**
 * Jun 1, 2018 1:29:43 PM
 */
package com.gnv.vnm.selfcare.webportal.controller;

import java.security.Principal;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gnv.vnm.selfcare.core.adapter.BackEndAdapterResponse;
import com.gnv.vnm.selfcare.core.adapter.vasman.VASManErrorMessage;
import com.gnv.vnm.selfcare.core.adapter.vasman.VASManSelfPackageBalance;
import com.gnv.vnm.selfcare.core.adapter.vasman.VASManSelfPackageRequest;
import com.gnv.vnm.selfcare.core.enums.SelfPackageCycle;
import com.gnv.vnm.selfcare.core.enums.SelfPackageType;
import com.gnv.vnm.selfcare.core.model.KeyValue;
import com.gnv.vnm.selfcare.core.model.SelfPackagePriceMapping;
import com.gnv.vnm.selfcare.core.model.SubscriberProfile;
import com.gnv.vnm.selfcare.core.utils.LoggingUtil;
import com.gnv.vnm.selfcare.webportal.config.ScreenNames;
import com.gnv.vnm.selfcare.webportal.config.TopMenu;

/**
 * @author nandipinto
 *
 */

@Controller
public class SelfPackageController extends WebPortalBaseController {

	private static final Logger logger = LoggerFactory.getLogger(SelfPackageController.class);

	static final String VOICE_ONNET = "DYNAMIC_ONNET_VOICE";
	static final String VOICE_OFFNET = "DYNAMIC_OFFNET_VOICE";
	static final String SMS_ONNET = "DYNAMIC_ONNET_SMS";
	static final String SMS_OFFNET = "DYNAMIC_OFFNET_SMS";
	
	private String priceMappings = null;
	
	private String dailyVoicePriceMappings = null;
	private String weeklyVoicePriceMappings = null;
	private String monthlyVoicePriceMappings = null;

	private String dailySmsPriceMappings = null;
	private String weeklySmsPriceMappings = null;
	private String monthlySmsPriceMappings = null;
	
	private Map<String, String> commonConfigs = null;
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@RequestMapping(value = "/secure/selfpkg", method = { RequestMethod.GET, RequestMethod.POST})
	public String petieMonster(Model model, Principal authUser, Locale locale, HttpServletRequest request){

		SubscriberProfile profile = getProfile(request, authUser);
		setSessionData(model, request, profile, locale);
		setActiveTopMenu(model, TopMenu.SHOP);

		return ScreenNames.SELF_PACKAGE;
	}
	
	@PostMapping(value = "/secure/selfpkg/register")
	public ResponseEntity<?> register(Principal authUser, @RequestParam(name = "selected_cycle", defaultValue = "daily") String cycle, 
			@RequestParam(name = "total_money_amount", defaultValue = "0") double chargingAmount,
			Locale locale, HttpServletRequest request){
	
		String message = resolveMessage(messageSource, "Message.SelfPkg.RegisterFail", null, "Your registration to package has failed.", locale);
		
		KeyValue keyValue = new KeyValue();

		try {
			String packageId = backEndRequestProcessor.getSelfPackageCommonConfigs().getOrDefault("PACKAGE_ID", "132374");
			
			VASManSelfPackageRequest selfPkgRequest = new VASManSelfPackageRequest();
			selfPkgRequest.setCycle(SelfPackageCycle.valueOf(cycle.toUpperCase()));
			selfPkgRequest.setDescription("SelfPackage_" + cycle + "_" + authUser.getName());
			selfPkgRequest.setMsisdn(authUser.getName());
			selfPkgRequest.setPackageId(packageId);
			selfPkgRequest.setChargingAmount(chargingAmount);

			double voiceOnNet = ServletRequestUtils.getDoubleParameter(request, "total_amount_voice_onnet_" + cycle, 0);
			double voiceOffNet = ServletRequestUtils.getDoubleParameter(request, "total_amount_voice_offnet_" + cycle, 0);
			double smsOnNet = ServletRequestUtils.getDoubleParameter(request, "total_amount_sms_onnet_" + cycle, 0);
			double smsOffNet = ServletRequestUtils.getDoubleParameter(request, "total_amount_sms_offnet_" + cycle, 0);
			
			LoggingUtil.debug(logger, "#register --- chargeAmount= " + chargingAmount + ", voice_onnet= " + voiceOnNet
					+ ", voice_offnet= " + voiceOffNet + ", sms_onnet= " + smsOnNet + ", sms_offnet= " + smsOffNet);
			
			selfPkgRequest.getBalanceList().add(new VASManSelfPackageBalance(VOICE_ONNET, voiceOnNet));
			selfPkgRequest.getBalanceList().add(new VASManSelfPackageBalance(VOICE_OFFNET, voiceOffNet));
			selfPkgRequest.getBalanceList().add(new VASManSelfPackageBalance(SMS_ONNET, smsOnNet));
			selfPkgRequest.getBalanceList().add(new VASManSelfPackageBalance(SMS_OFFNET, smsOffNet));
			
			BackEndAdapterResponse resp = backEndRequestProcessor.registerSelfPackage(selfPkgRequest);
			
			String respCode = resp.getResponseCode();
			keyValue.setKey(respCode);

			if (resp.isSuccessful() || respCode.equals(VASManErrorMessage.SUCCESS.code())) {

				if (selfPkgRequest.getCycle().equals(SelfPackageCycle.DAILY)) {
					message = resolveMessage(messageSource, "Message.SelfPkg.DailyRegisterSuccess", null,
							"You have registered the Daily package successfully.", locale);

				} else if (selfPkgRequest.getCycle().equals(SelfPackageCycle.WEEKLY)) {
					message = resolveMessage(messageSource, "Message.SelfPkg.WeeklyRegisterSuccess", null,
							"You have registered the Weekly package successfully.", locale);
				} else {
					message = resolveMessage(messageSource, "Message.SelfPkg.MonthlyRegisterSuccess", null,
							"You have registered the Monthly package successfully.", locale);
				}

			} else if (respCode.equals(VASManErrorMessage.NOT_ENOUGH_MONEY.code())
					|| respCode.equals(VASManErrorMessage.BALANCE_TOO_SMALL.code())) {
				message = resolveMessage(messageSource, "Message.SelfPkg.RegisterFailNotEnoughBalance", null,
						"Your account is not sufficient. Please Top Up to register for this package.", locale);

			} else if (respCode.equals(VASManErrorMessage.ALREADY_REGISTERED.code())) {
				message = resolveMessage(messageSource, "Message.SelfPkg.RegisterFailAlreadyRegistered", null,
						"The registration has failed. This package is already registered.", locale);

			} else {
				message = resolveMessage(messageSource, "Message.SelfPkg.RegisterFail", null,
						"Your registration to package has failed.", locale);
			}
			
			keyValue.setValue(message);
			
		} catch (Exception e) {
			keyValue.setKey(VASManErrorMessage.ERROR.code());

			logger.error("#register --- error when registering self package for user " + authUser.getName(), e);
		}
		
		return new ResponseEntity<>(keyValue, HttpStatus.OK);
	}
	
	@ModelAttribute("COMMON_CONFIGS")
	public Map<String, String> commonConfigs(){
		if (commonConfigs == null) {
			commonConfigs = backEndRequestProcessor.getSelfPackageCommonConfigs();
		}
		return commonConfigs;
	}
	
	@ModelAttribute("PRICE_MAPPINGS")
	public String priceMappings() {
		if (priceMappings == null) {
			List<SelfPackagePriceMapping> list = backEndRequestProcessor.getSelfPackagePriceMappings();
			
			try {
				priceMappings = objectMapper.writeValueAsString(list);
			} catch (Exception e) {
				logger.error("#priceMappings --- " + e.getMessage());
			}
		}
		
		return priceMappings;
	}
	
	@ModelAttribute("VOICE_DAILY_PRICE_MAPPINGS")
	public String dailyVoicePriceMappings(){
		
		if (dailyVoicePriceMappings == null) {
			List<SelfPackagePriceMapping> list = backEndRequestProcessor.getSelfPackagePriceMappings(SelfPackageType.VOICE.name(), SelfPackageCycle.DAILY.ordinal());
			Map<String, List<SelfPackagePriceMapping>> maps = new Hashtable<>();
			maps.put("VOICE_DAILY_PRICE_MAPPINGS", list);
			
			try {
				dailyVoicePriceMappings = objectMapper.writeValueAsString(maps);
			} catch (Exception e) {
				logger.error("#dailyVoicePriceMappings --- " + e.getMessage());
			}
		}
		
		return dailyVoicePriceMappings;
	}
	
	@ModelAttribute("VOICE_WEEKLY_PRICE_MAPPINGS")
	public String weeklyVoicePriceMappings() {
		
		if (weeklyVoicePriceMappings == null) {
			List<SelfPackagePriceMapping> list = backEndRequestProcessor.getSelfPackagePriceMappings(SelfPackageType.VOICE.name(), SelfPackageCycle.WEEKLY.ordinal());
			Map<String, List<SelfPackagePriceMapping>> maps = new Hashtable<>();
			maps.put("VOICE_WEEKLY_PRICE_MAPPINGS", list);
			
			try {
				weeklyVoicePriceMappings = objectMapper.writeValueAsString(maps);
			} catch (Exception e) {
				logger.error("#weeklyVoicePriceMappings --- " + e.getMessage());
			}
		}
		
		return weeklyVoicePriceMappings;
	}
	
	@ModelAttribute("VOICE_MONTHLY_PRICE_MAPPINGS")
	public String monthlyVoicePriceMappings() {
		
		if (monthlyVoicePriceMappings == null) {
			List<SelfPackagePriceMapping> list = backEndRequestProcessor.getSelfPackagePriceMappings(SelfPackageType.VOICE.name(), SelfPackageCycle.MONTHLY.ordinal());
			Map<String, List<SelfPackagePriceMapping>> maps = new Hashtable<>();
			maps.put("VOICE_MONTHLY_PRICE_MAPPINGS", list);
			
			try {
				monthlyVoicePriceMappings = objectMapper.writeValueAsString(maps);
			} catch (Exception e) {
				logger.error("#monthlyVoicePriceMappings --- " + e.getMessage());
			}
		}
		
		return monthlyVoicePriceMappings;
	}
	
	@ModelAttribute("SMS_DAILY_PRICE_MAPPINGS")
	public String dailySmsPriceMappings(){
		
		if (dailySmsPriceMappings == null) {
			List<SelfPackagePriceMapping> list = backEndRequestProcessor.getSelfPackagePriceMappings(SelfPackageType.SMS.name(), SelfPackageCycle.DAILY.ordinal());
			Map<String, List<SelfPackagePriceMapping>> maps = new Hashtable<>();
			maps.put("SMS_DAILY_PRICE_MAPPINGS", list);
			
			try {
				dailySmsPriceMappings = objectMapper.writeValueAsString(maps);
			} catch (Exception e) {
				logger.error("#dailySmsPriceMappings --- " + e.getMessage());
			}
		}
		
		return dailySmsPriceMappings;
	}
	
	@ModelAttribute("SMS_WEEKLY_PRICE_MAPPINGS")
	public String weeklySmsPriceMappings(){
		
		if (dailySmsPriceMappings == null) {
			List<SelfPackagePriceMapping> list = backEndRequestProcessor.getSelfPackagePriceMappings(SelfPackageType.SMS.name(), SelfPackageCycle.WEEKLY.ordinal());
			Map<String, List<SelfPackagePriceMapping>> maps = new Hashtable<>();
			maps.put("SMS_WEEKLY_PRICE_MAPPINGS", list);
			
			try {
				weeklySmsPriceMappings = objectMapper.writeValueAsString(maps);
			} catch (Exception e) {
				logger.error("#weeklySmsPriceMappings --- " + e.getMessage());
			}
		}
		
		return weeklySmsPriceMappings;
	}
	
	@ModelAttribute("SMS_MONTHLY_PRICE_MAPPINGS")
	public String monthlySmsPriceMappings(){
		
		if (dailySmsPriceMappings == null) {
			List<SelfPackagePriceMapping> list = backEndRequestProcessor.getSelfPackagePriceMappings(SelfPackageType.SMS.name(), SelfPackageCycle.MONTHLY.ordinal());
			Map<String, List<SelfPackagePriceMapping>> maps = new Hashtable<>();
			maps.put("SMS_MONTHLY_PRICE_MAPPINGS", list);
			
			try {
				monthlySmsPriceMappings = objectMapper.writeValueAsString(maps);
			} catch (Exception e) {
				logger.error("#monthlySmsPriceMappings --- " + e.getMessage());
			}
		}
		
		return monthlySmsPriceMappings;
	}
}
