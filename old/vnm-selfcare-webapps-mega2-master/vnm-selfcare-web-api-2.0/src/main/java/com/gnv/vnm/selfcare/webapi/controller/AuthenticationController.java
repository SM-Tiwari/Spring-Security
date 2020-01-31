/**
 * Mar 30, 2018 12:50:23 PM
 */
package com.gnv.vnm.selfcare.webapi.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gnv.vnm.selfcare.core.enums.ClientAppId;
import com.gnv.vnm.selfcare.core.enums.SubscriberType;
import com.gnv.vnm.selfcare.core.fault.ExternalSubscriberException;
import com.gnv.vnm.selfcare.core.fault.PasswordMismatchException;
import com.gnv.vnm.selfcare.core.fault.SubscriberNotFoundException;
import com.gnv.vnm.selfcare.core.model.BlanceAndSelfPackage;
import com.gnv.vnm.selfcare.core.model.CurrentBalance;
import com.gnv.vnm.selfcare.core.model.DiscountTopUp;
import com.gnv.vnm.selfcare.core.model.FattyMonsterDetails;
import com.gnv.vnm.selfcare.core.model.HotNews;
import com.gnv.vnm.selfcare.core.model.PackageSubscription;
import com.gnv.vnm.selfcare.core.model.PopupBannner;
import com.gnv.vnm.selfcare.core.model.Simname;
import com.gnv.vnm.selfcare.core.model.SubscriberProfile;
import com.gnv.vnm.selfcare.core.model.SubscriberProfilenew;
import com.gnv.vnm.selfcare.core.security.AuthConstants;
import com.gnv.vnm.selfcare.core.security.SelfCareUser;
import com.gnv.vnm.selfcare.core.service.FattyMonsterService;
import com.gnv.vnm.selfcare.core.utils.LoggingUtil;
import com.gnv.vnm.selfcare.webapi.DefaultApiResponse;
import com.gnv.vnm.selfcare.webapi.model.LoginRequest;
import com.gnv.vnm.selfcare.webapi.model.LoginRequest_Version;
import com.gnv.vnm.selfcare.core.enums.NotificationStatus;
import com.gnv.vnm.selfcare.core.model.PushedCampaign;
import com.gnv.vnm.selfcare.core.utils.AppUtils;
import com.gnv.vnm.selfcare.dao.entity.BazNotifcationStatusEntity;
import com.gnv.vnm.selfcare.dao.entity.QBazNotifcationStatusEntity;
import com.gnv.vnm.selfcare.webapi.model.PushedCampaignDTO;

/**
 * @author nandipinto
 *
 */

@RestController
public class AuthenticationController extends BaseRestController {

	private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
	
	@Autowired AuthenticationManager authenticationManager;
	
	static final String DATE_FORMAT = "dd/MM/yyyy";
	
	@Autowired
	private FattyMonsterService fattyMonsterService;
	
	/*@PostMapping(value = "/autosigninwithip")
	public ResponseEntity<?> autoSignInWitIP(@RequestBody String ipAddress, final HttpServletRequest request, final HttpServletResponse response) {
		if (!StringUtils.hasText(ipAddress)){
			return new ResponseEntity<>(String.format(DefaultApiResponse.INVALID_PARAMETER_VALUE.message(), "[null_ip_address]"), HttpStatus.OK);
		}

		String regex = applicationConfigurationService.get("adapter.radius.ipaddr.regex", "10\\.2[0|1|2|3]\\d\\.\\d{1,3}\\.\\d{1,3}").toString();
		if(!Pattern.matches(regex, ipAddress)){
			return new ResponseEntity<>(String.format(DefaultApiResponse.INVALID_IP_ADDRESS.message(), ipAddress), HttpStatus.OK);
		}
		
		String msisdn = subscriberManagementService.lookupUserByIpAddress(ipAddress);
		if (msisdn != null) {
			SubscriberProfile subscriberProfile = subscriberManagementService.getSubscriberProfile(msisdn, true);
			
			final Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                		subscriberProfile.getMsisdn(),
	                		subscriberProfile.getCredential()
	                )
	        );
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        final String token = getJwtTokenUtil().generateToken(subscriberProfile.getMsisdn(), null);
	        
	        LoggingUtil.debug(logger, "#autoSignInWitIP --- generated auth_token= " + token);
	        response.setHeader(AuthConstants.JWT_HEADER_NAME, token);

	        subscriberManagementService.performPostLoginActions(msisdn, request.getRemoteAddr(), ClientAppId.MOBILE_APP);

	        return new ResponseEntity<SubscriberProfile>(subscriberProfile, HttpStatus.OK);
	        
		} else {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), " with IP address " + ipAddress), HttpStatus.OK);
		}

	}*/
	
	
	
	/*@PostMapping(value = "/autosigninwithip")
    public ResponseEntity<?> autoSignInWitIP(@RequestBody String ipAddress, final HttpServletRequest request, final HttpServletResponse response) {
           if (!StringUtils.hasText(ipAddress)){
                  return new ResponseEntity<>(String.format(DefaultApiResponse.INVALID_PARAMETER_VALUE.message(), "[null_ip_address]"), HttpStatus.OK);
           }

          // String regex = applicationConfigurationService.get("adapter.radius.ipaddr.regex", "10\\.2[0|1|2|3]\\d\\.\\d{1,3}\\.\\d{1,3}").toString();
          // 10\.[1|2][0|1|2|3|6|9]\d\.\d{1,3}\.\d{1,3}
         
           String regex = applicationConfigurationService.get("adapter.radius.ipaddr.regex", "10\\.[1|2][0|1|2|3|6|9]\\d\\.\\d{1,3}\\.\\d{1,3}").toString();
           if(!Pattern.matches(regex, ipAddress)){
                  return new ResponseEntity<>(String.format(DefaultApiResponse.INVALID_IP_ADDRESS.message(), ipAddress), HttpStatus.OK);
           }
           
    //     String msisdn = subscriberManagementService.lookupUserByIpAddress(ipAddress);
           SubscriberProfile subscriberProfile = subscriberManagementService.signInWithIPAddress(ipAddress);
           String msisdn = subscriberProfile.getMsisdn(); //"01864430003";
           if (msisdn != null) {
                  //SubscriberProfile subscriberProfile = subscriberManagementService.getSubscriberProfile(msisdn, true);
                  
                  //SubscriberProfile subscriberProfile = subscriberManagementService.signInWithIPAddress(ipAddress);
           ///////////////////////////////////////////////////////////////////////////////////////////       
                  
            Authentication authentication = new UsernamePasswordAuthenticationToken(subscriberProfile.getMsisdn(), null, SelfCareUser.getGrantedAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
           
            final String token = getJwtTokenUtil().generateToken(subscriberProfile.getMsisdn(), null);
            
            LoggingUtil.debug(logger, "#login --- generated auth_token= " + token);
            response.setHeader(AuthConstants.JWT_HEADER_NAME, token);
            
                  SubscriberProfile subscriberProfileget = subscriberManagementService.getSubscriberProfile(subscriberProfile.getMsisdn(), true);
                  
            subscriberManagementService.performPostLoginActions(subscriberProfileget.getMsisdn(), request.getRemoteAddr(), ClientAppId.MOBILE_APP);
                  
            return new ResponseEntity<SubscriberProfile>(subscriberProfileget, HttpStatus.OK);
            
           } else {
                  return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), " with IP address " + ipAddress), HttpStatus.OK);
           }

    }*/



	
	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest, HttpServletRequest request, HttpServletResponse response) {

		try {
			subscriberManagementService.authenticated(loginRequest.getLoginId(), loginRequest.getCredential(), request.getRemoteAddr());
			
		}catch (ExternalSubscriberException e) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.NUMBER_NOT_RECOGNIZED.message(), loginRequest.getLoginId()), HttpStatus.OK);
			
		}catch (SubscriberNotFoundException e) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), loginRequest.getLoginId()), HttpStatus.OK);
			
		} catch (PasswordMismatchException e) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.PASSWORD_MISMATCH.message(), loginRequest.getLoginId()), HttpStatus.OK);
		}
		
		/*
		final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                		loginRequest.getLoginId(),
                		loginRequest.getCredential()
                )
        );
        */
		Authentication authentication = new UsernamePasswordAuthenticationToken(loginRequest.getLoginId(), null, SelfCareUser.getGrantedAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
	
        final String token = getJwtTokenUtil().generateToken(loginRequest.getLoginId(), null);
        
        LoggingUtil.debug(logger, "#login --- generated auth_token= " + token);
        //response.setHeader(AuthConstants.JWT_HEADER_NAME, token);
        response.setHeader("Authorization", token);
		SubscriberProfile subscriberProfile = subscriberManagementService.getSubscriberProfile(loginRequest.getLoginId(), true);
		
        subscriberManagementService.performPostLoginActions(subscriberProfile.getMsisdn(), request.getRemoteAddr(), ClientAppId.MOBILE_APP);

		return new ResponseEntity<SubscriberProfile>(subscriberProfile, HttpStatus.OK);
	}
	
	@GetMapping(value = "/token/{msisdn}/{requestid}")
	public ResponseEntity<?> temporaryToken(@PathVariable String msisdn, @PathVariable String requestId){
		return new ResponseEntity<>(getJwtTokenUtil().generateToken(msisdn, requestId), HttpStatus.OK);
	}
	
	
	
	@GetMapping(value = "/blanceandselfpackge/{msisdn}/{langcode}")
	public ResponseEntity<?> getAllData(@PathVariable String msisdn, @PathVariable String langcode) {
		boolean roamingEnabled = false;
		String numberofreadnotification="0";
		BlanceAndSelfPackage blanceAndSelfPackage = new BlanceAndSelfPackage();
		CurrentBalance currentBalance = subscriberManagementService.getBlanceDetails(msisdn, langcode);
		Simname simname = subscriberManagementService.getSimname(msisdn);
		if (simname.getType() != null && simname.getType().equals(SubscriberType.POSTPAID)) {
			currentBalance.setOutstandingBalance(tibcoServiceProvider.getCurrentOutstandingBalance(msisdn));
			currentBalance.setUnbilledBalance(tibcoServiceProvider.getUnbilledBalanceSummary(msisdn));
			currentBalance.setDepositBalance(tibcoServiceProvider.getDepositBalance(msisdn));
		}
		List<PackageSubscription> packagedetails = subscriberManagementService.getPackage(msisdn, langcode);
		List<DiscountTopUp> dicountlist=discountTopupService.getDiscountTopupData(langcode);
		List<PopupBannner> popupBannnerlist=popupBannerManagementService.getPopupBannerData(langcode);
		List<HotNews> hotNewslist =hotNewsManagementService.getHotNewsdata(langcode);
		String smsRoamingPkgId = applicationConfigurationService.get("postpaid.packageid.irsms", "1000006").toString();
		String voiceRoamingPkgId = applicationConfigurationService.get("postpaid.packageid.irvoice", "20000100")
				.toString();

	//	Simname simname = subscriberManagementService.getSimname(msisdn);
		if (packagedetails != null) {
			for (PackageSubscription pkg : packagedetails) {
				String code = pkg.getProduct().getCode();
				if (code.equals(smsRoamingPkgId) || code.equals(voiceRoamingPkgId)) {
					roamingEnabled = true;
				}
			}
			int subcount = packagedetails.size();
			blanceAndSelfPackage.setSubscriptionCount(subcount);
		}
		
		//long unreadCount = pushedCampaignService.getCampaignCount(msisdn);
		//blanceAndSelfPackage.setNotificationCount(unreadCount);
		 
		List<PushedCampaignDTO> data = new ArrayList<>();
		//TODO filter only unread notif
		List<PushedCampaign> list = pushedCampaignService.getCampaignsNew(msisdn);
		if (list != null) {
		for (PushedCampaign pc : list) {
		PushedCampaignDTO dto = new PushedCampaignDTO(pc.getTitleEN(), pc.getDescriptionEN(), pc.getDetailsEN(),
		pc.getTitleVI(), pc.getDescriptionVI(), pc.getDetailsVI(), pc.getTargetedUser(),
		AppUtils.dateToString(pc.getStartDate(), DATE_FORMAT),
		AppUtils.dateToString(pc.getEndDate(), DATE_FORMAT));
		dto.setId(pc.getId());
		 
		data.add(dto);
		}
		}
		if(list!=null&&list.size()>0)
		{
		 
		BazNotifcationStatusEntity recipient = this.bazNotifcationStatusRepository.findOne(QBazNotifcationStatusEntity.bazNotifcationStatusEntity.msisdn.eq(msisdn));
		//String datamsisdn=recipient.getNotification_status();
		 
		if(recipient!=null){
		numberofreadnotification =recipient.getNumber_notification(); 
		}
		 
		int totelnumberofnotification= list.size();
		int Actulvalueofnotifaction=totelnumberofnotification-Integer.parseInt(numberofreadnotification);
		if(Actulvalueofnotifaction>=0){
		blanceAndSelfPackage.setNotificationCount(Actulvalueofnotifaction);
		}
		else{
		blanceAndSelfPackage.setNotificationCount(0);
		}
		 
		}
		else{
		blanceAndSelfPackage.setNotificationCount(0);
		}
		
		blanceAndSelfPackage.setRoamingEnabled(roamingEnabled);
		blanceAndSelfPackage.setCurrentBalance(currentBalance);
		blanceAndSelfPackage.setSubscriptions(packagedetails);
		FattyMonsterDetails fattyMonsterDetails = new FattyMonsterDetails();
	    fattyMonsterDetails = fattyMonsterService.getFattyMonsterDetailsBasedOnMsisdn(msisdn, fattyMonsterDetails);
	    fattyMonsterDetails.setSuccessMessageEn("");
	    fattyMonsterDetails.setSuccessMessageVi("");
		
		
		blanceAndSelfPackage.setFattyMonsterDetails(fattyMonsterDetails);
		blanceAndSelfPackage.setClassOfServiceName(simname.getClassOfServiceName());
		blanceAndSelfPackage.setType(simname.getType());
		if (simname.getType() != null && simname.getType().equals(SubscriberType.POSTPAID)) {

			Calendar start = Calendar.getInstance();
			start.add(Calendar.MONTH, -4);

			Calendar end = Calendar.getInstance();
			end.add(Calendar.MONTH, -1);

			blanceAndSelfPackage.setBillingHistory(tibcoServiceProvider.getBillingHistory(msisdn, start.getTime(), end.getTime()));
			
			}
		blanceAndSelfPackage.setDisabledAppFeatures(simname.getDisabledAppFeatures());
		blanceAndSelfPackage.setDiscountTopUp(dicountlist);
		blanceAndSelfPackage.setPopupBannner(popupBannnerlist);
		blanceAndSelfPackage.setHotNews(hotNewslist);
		//blanceAndSelfPackage.setBasimname(simname);
		System.out.println("blanceAndSelfPackage responce >>>>>>>>>>>>>>>>>>>>>>>>" + blanceAndSelfPackage);
		return new ResponseEntity<BlanceAndSelfPackage>(blanceAndSelfPackage, HttpStatus.OK);
	}
	
	@GetMapping(value = "/blanceandselfpackgenew/{msisdn}/{langcode}")
	public ResponseEntity<?> getAllDataNew(@PathVariable String msisdn, @PathVariable String langcode) {
		boolean roamingEnabled = false;
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		List<FutureTask<?>> taskList = new ArrayList<FutureTask<?>>();
		
		BlanceAndSelfPackage blanceAndSelfPackage = new BlanceAndSelfPackage();
		CurrentBalance currentBalance = subscriberManagementService.getBlanceDetails(msisdn, langcode);
		List<PackageSubscription> packagedetails = subscriberManagementService.getPackage(msisdn, langcode);
		String smsRoamingPkgId = applicationConfigurationService.get("postpaid.packageid.irsms", "1000006").toString();
		String voiceRoamingPkgId = applicationConfigurationService.get("postpaid.packageid.irvoice", "20000100")
				.toString();

		Simname simname = subscriberManagementService.getSimname(msisdn);
		if (packagedetails != null) {
			for (PackageSubscription pkg : packagedetails) {
				String code = pkg.getProduct().getCode();
				if (code.equals(smsRoamingPkgId) || code.equals(voiceRoamingPkgId)) {
					roamingEnabled = true;
				}
			}
			int subcount = packagedetails.size();
			blanceAndSelfPackage.setSubscriptionCount(subcount);
		}
		List<DiscountTopUp> dicountlist=discountTopupService.getDiscountTopupData(langcode);
		List<PopupBannner> popupBannnerlist=popupBannerManagementService.getPopupBannerData(langcode);
		List<HotNews> hotNewslist =hotNewsManagementService.getHotNewsdata(langcode);
		blanceAndSelfPackage.setRoamingEnabled(roamingEnabled);
		blanceAndSelfPackage.setCurrentBalance(currentBalance);
		blanceAndSelfPackage.setSubscriptions(packagedetails);
		FattyMonsterDetails fattyMonsterDetails = new FattyMonsterDetails();
	    fattyMonsterDetails = fattyMonsterService.getFattyMonsterDetailsBasedOnMsisdn(msisdn, fattyMonsterDetails);
	    fattyMonsterDetails.setSuccessMessageEn("");
	    fattyMonsterDetails.setSuccessMessageVi("");
		blanceAndSelfPackage.setFattyMonsterDetails(fattyMonsterDetails);
		//blanceAndSelfPackage.setBasimname(simname);
		blanceAndSelfPackage.setDiscountTopUp(dicountlist);
		blanceAndSelfPackage.setPopupBannner(popupBannnerlist);
		blanceAndSelfPackage.setHotNews(hotNewslist);
		System.out.println("blanceAndSelfPackage responce >>>>>>>>>>>>>>>>>>>>>>>>" + blanceAndSelfPackage);
		return new ResponseEntity<BlanceAndSelfPackage>(blanceAndSelfPackage, HttpStatus.OK);
	}

	/*@PostMapping(value = "/autosigninwithipnew")
	public ResponseEntity<?> autoSignInWitIPNew(@RequestBody String ipAddress, String app_version, String app_os,
			String app_os_version, String device_name, String devic_modeil, String devic_id,
			final HttpServletRequest request, final HttpServletResponse response) {
		System.out.println("" + ipAddress);
		if (!StringUtils.hasText(ipAddress)) {
			return new ResponseEntity<>(
					String.format(DefaultApiResponse.INVALID_PARAMETER_VALUE.message(), "[null_ip_address]"),
					HttpStatus.OK);
		}

		String regex = applicationConfigurationService
				.get("adapter.radius.ipaddr.regex", "10\\.[1|2][0|1|2|3|6|9]\\d\\.\\d{1,3}\\.\\d{1,3}").toString();
		if (!Pattern.matches(regex, ipAddress)) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.INVALID_IP_ADDRESS.message(), ipAddress),
					HttpStatus.OK);
		}

		SubscriberProfile subscriberProfile = subscriberManagementService.signInWithIPAddress(ipAddress);
		String msisdn = subscriberProfile.getMsisdn(); // "01864430003";
		// check validation

		if (msisdn != null) {
			boolean msisdnexist = subscriberManagementService.validateuser(msisdn);
			if (msisdnexist == true) {
				Authentication authentication = new UsernamePasswordAuthenticationToken(subscriberProfile.getMsisdn(),
						null, SelfCareUser.getGrantedAuthorities());
				SecurityContextHolder.getContext().setAuthentication(authentication);

				final String token = getJwtTokenUtil().generateToken(subscriberProfile.getMsisdn(), null);

				LoggingUtil.debug(logger, "#login --- generated auth_token= " + token);
				response.setHeader(AuthConstants.JWT_HEADER_NAME, token);
				SubscriberProfilenew subscriberProfileget = subscriberManagementService
						.getSubscriberProfilenew(subscriberProfile.getMsisdn(), true);

				GetLmsResponse getLmsConfigResponse = new GetLmsResponse(true, DefaultApiResponse.SUCCESS.code(),
						DefaultApiResponse.SUCCESS.message());
				getLmsConfigResponse.setConfigs(backEndRequestProcessor.getLmsConfigs());
				subscriberProfileget.setGetLmsdata(getLmsConfigResponse);

				boolean version_details = backEndRequestProcessor.saveVersionDetails(msisdn, app_version, app_os,
						app_os_version, device_name, devic_modeil, devic_id);
				 int appFeaturesStatus= versionDetailsSevice.getAppFeaturesBasedOnMsisdn(msisdn);
				 subscriberProfileget.setAppFeaturesStatus(appFeaturesStatus);

				subscriberManagementService.performPostLoginActions(subscriberProfileget.getMsisdn(),
						request.getRemoteAddr(), ClientAppId.MOBILE_APP);

				return new ResponseEntity<SubscriberProfilenew>(subscriberProfileget, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn),
						HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<>(
					String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), " with IP address " + ipAddress),
					HttpStatus.OK);
		}

	}*/

	@PostMapping(value = "/loginnew")
	public ResponseEntity<?> loginnmew(@RequestBody LoginRequest_Version loginRequest, HttpServletRequest request,
			HttpServletResponse response) {
		String numberofreadnotification="0";
		// Selfcare db
		try {
			subscriberManagementService.authenticated(loginRequest.getLoginId(), loginRequest.getCredential(),
					request.getRemoteAddr());

		} catch (ExternalSubscriberException e) {
			return new ResponseEntity<>(
					String.format(DefaultApiResponse.NUMBER_NOT_RECOGNIZED.message(), loginRequest.getLoginId()),
					HttpStatus.OK);

		} catch (SubscriberNotFoundException e) {
			return new ResponseEntity<>(
					String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), loginRequest.getLoginId()),
					HttpStatus.OK);

		} catch (PasswordMismatchException e) {
			return new ResponseEntity<>(
					String.format(DefaultApiResponse.PASSWORD_MISMATCH.message(), loginRequest.getLoginId()),
					HttpStatus.OK);
		}
		Authentication authentication = new UsernamePasswordAuthenticationToken(loginRequest.getLoginId(), null,
				SelfCareUser.getGrantedAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);

		final String token = getJwtTokenUtil().generateToken(loginRequest.getLoginId(), null);

		LoggingUtil.debug(logger, "#loginnew --- generated auth_token= " + token);
		response.setHeader(AuthConstants.JWT_HEADER_NAME, token);

		SubscriberProfilenew subscriberProfile = subscriberManagementService
				.getSubscriberProfilenew(loginRequest.getLoginId(), true);
		
		FattyMonsterDetails fattyMonsterDetails = new FattyMonsterDetails();
	    fattyMonsterDetails = fattyMonsterService.getFattyMonsterDetailsBasedOnMsisdn(loginRequest.getLoginId(), fattyMonsterDetails);
	    fattyMonsterDetails.setSuccessMessageEn("");
	    fattyMonsterDetails.setSuccessMessageVi("");
	   if(fattyMonsterDetails!=null) subscriberProfile.setFattyMonsterDetails(fattyMonsterDetails);
	   
	  int appFeaturesStatus= versionDetailsSevice.getAppFeaturesBasedOnMsisdn(loginRequest.getLoginId());
	   subscriberProfile.setAppFeaturesStatus(appFeaturesStatus);

		/*GetLmsResponse getLmsConfigResponse = new GetLmsResponse(true, DefaultApiResponse.SUCCESS.code(),
				DefaultApiResponse.SUCCESS.message());
		getLmsConfigResponse.setConfigs(backEndRequestProcessor.getLmsConfigs());
		subscriberProfile.setGetLmsdata(getLmsConfigResponse);*/
		
	   List<PushedCampaignDTO> data = new ArrayList<>();
	 //TODO filter only unread notif
	 List<PushedCampaign> list = pushedCampaignService.getCampaignsNew(loginRequest.getLoginId());
	 if (list != null) {
	 for (PushedCampaign pc : list) {
	 PushedCampaignDTO dto = new PushedCampaignDTO(pc.getTitleEN(), pc.getDescriptionEN(), pc.getDetailsEN(),
	 pc.getTitleVI(), pc.getDescriptionVI(), pc.getDetailsVI(), pc.getTargetedUser(),
	 AppUtils.dateToString(pc.getStartDate(), DATE_FORMAT),
	 AppUtils.dateToString(pc.getEndDate(), DATE_FORMAT));
	 dto.setId(pc.getId());
	  
	 data.add(dto);
	 }
	 }
	 if(list!=null&&list.size()>0)
	 {
	  
	 BazNotifcationStatusEntity recipient = this.bazNotifcationStatusRepository.findOne(QBazNotifcationStatusEntity.bazNotifcationStatusEntity.msisdn.eq(loginRequest.getLoginId()));
	 //String datamsisdn=recipient.getNotification_status();
	  
	 if(recipient!=null){
	 numberofreadnotification =recipient.getNumber_notification(); 
	 }
	  
	 int totelnumberofnotification= list.size();
	  
	 int Actulvalueofnotifaction=totelnumberofnotification-Integer.parseInt(numberofreadnotification);
	 if(Actulvalueofnotifaction>=0){
	 subscriberProfile.setNotificationCount(Actulvalueofnotifaction);
	 }
	 else{
	 subscriberProfile.setNotificationCount(0);
	 }
	 }
	 else{
	 subscriberProfile.setNotificationCount(0);
	 }
		ExecutorService executorService = Executors.newSingleThreadExecutor();

		executorService.execute(new Runnable() {
		    public void run() {
		    	backEndRequestProcessor.saveVersionDetails(loginRequest.getLoginId(),
						loginRequest.getApp_version(), loginRequest.getApp_os(), loginRequest.getApp_os_version(),
						loginRequest.getDevic_name(), loginRequest.getDevic_modeil(), loginRequest.getDevic_id());
		    }
		});

		executorService.shutdown();
		Simname simname = subscriberManagementService.getSimname(loginRequest.getLoginId());
		subscriberProfile.setType(simname.getType());
		
	/*	boolean version_details = backEndRequestProcessor.saveVersionDetails(loginRequest.getLoginId(),
				loginRequest.getApp_version(), loginRequest.getApp_os(), loginRequest.getApp_os_version(),
				loginRequest.getDevic_name(), loginRequest.getDevic_modeil(), loginRequest.getDevic_id());
*/
		return new ResponseEntity<SubscriberProfilenew>(subscriberProfile, HttpStatus.OK);
	}
	
	

}
