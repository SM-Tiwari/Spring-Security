/**
* SubscriberProfileController.java
*/
package com.gnv.vnm.selfcare.webapi.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.gnv.vnm.selfcare.core.enums.NotificationStatus;
import com.gnv.vnm.selfcare.core.fault.InvalidPasswordFormatException;
import com.gnv.vnm.selfcare.core.fault.InvalidTokenException;
import com.gnv.vnm.selfcare.core.fault.PasswordMismatchException;
import com.gnv.vnm.selfcare.core.fault.SubscriberNotFoundException;
import com.gnv.vnm.selfcare.core.model.FattyMonsterDetails;
import com.gnv.vnm.selfcare.core.model.OtpStatusModel;
import com.gnv.vnm.selfcare.core.model.PushedCampaign;
import com.gnv.vnm.selfcare.core.model.Simname;
import com.gnv.vnm.selfcare.core.model.SubscriberProfile;
import com.gnv.vnm.selfcare.core.model.SubscriberProfilenew;
import com.gnv.vnm.selfcare.core.security.AuthConstants;
import com.gnv.vnm.selfcare.core.security.SelfCareUser;
import com.gnv.vnm.selfcare.core.service.FattyMonsterService;
import com.gnv.vnm.selfcare.core.utils.AppUtils;
import com.gnv.vnm.selfcare.core.utils.LoggingUtil;
import com.gnv.vnm.selfcare.dao.entity.BazNotifcationStatusEntity;
import com.gnv.vnm.selfcare.dao.entity.MsisdnTokenEntity;
import com.gnv.vnm.selfcare.dao.entity.QBazNotifcationStatusEntity;
import com.gnv.vnm.selfcare.dao.entity.QMsisdnTokenEntity;
import com.gnv.vnm.selfcare.dao.repo.MsisdnTokenRepo;
import com.gnv.vnm.selfcare.webapi.DefaultApiResponse;
import com.gnv.vnm.selfcare.webapi.model.ApiResponse;
import com.gnv.vnm.selfcare.webapi.model.ChangePasswordRequest;
import com.gnv.vnm.selfcare.webapi.model.PushedCampaignDTO;
import com.gnv.vnm.selfcare.webapi.model.ResetPasswordRequest;
import com.gnv.vnm.selfcare.webapi.model.UpdateUserTokenRequest;

/**
 * @author nandipinto
 *
 */
@RestController
public class SubscriberProfileController extends BaseRestController {

	private static final Logger logger = LoggerFactory.getLogger(SubscriberProfileController.class);
	static final String DATE_FORMAT = "dd/MM/yyyy";
	@Autowired
	private FattyMonsterService fattyMonsterService;

	@Autowired
	MsisdnTokenRepo msisdnRepo;

	@PutMapping(value = "/setlang/{msisdn}/{langcode}")
	public ResponseEntity<?> changeLanguage(@PathVariable("msisdn") String msisdn,
			@PathVariable("langcode") String languageCode) {

		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
					DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		try {
			subscriberManagementService.changeLanguage(msisdn, languageCode);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (SubscriberNotFoundException e) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn),
					HttpStatus.OK);
		}
	}

	@PutMapping(value = "/setemail/{msisdn}")
	public ResponseEntity<?> updateEmailAddress(@PathVariable("msisdn") String msisdn, @RequestBody String email) {

		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
					DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		try {
			subscriberManagementService.changeEmailAddress(msisdn, email);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (SubscriberNotFoundException e) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn),
					HttpStatus.OK);
		}
	}

	@PutMapping(value = "/setgender/{msisdn}/{genderid}")
	public ResponseEntity<?> changeGender(@PathVariable("msisdn") String msisdn,
			@PathVariable("genderid") int genderId) {

		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
					DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		try {
			subscriberManagementService.changeGender(msisdn, genderId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (SubscriberNotFoundException e) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn),
					HttpStatus.OK);
		}
	}

	/*
	 * @GetMapping(value = "/subscriber/details/{msisdn}") public
	 * ResponseEntity<?> getSubscriberDetails(@PathVariable("msisdn") String
	 * msisdn) {
	 * 
	 * if (!msisdn.equals(getCurrentUserName())) { return new
	 * ResponseEntity<>(new ApiResponse(false,
	 * DefaultApiResponse.UNAUTHORIZED.code(),
	 * DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED); }
	 * 
	 * SubscriberProfile subscriberProfile =
	 * subscriberManagementService.getSubscriberProfile(msisdn, true); if
	 * (subscriberProfile == null) { return new
	 * ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.
	 * message(), msisdn), HttpStatus.OK); } return new
	 * ResponseEntity<SubscriberProfile>(subscriberProfile, HttpStatus.OK); }
	 */

	@GetMapping(value = "/subscriber/details/{msisdn}")
	public ResponseEntity<?> getSubscriberDetails(@PathVariable("msisdn") String msisdn) {

		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
					DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		SubscriberProfilenew subscriberProfile = subscriberManagementService.getSubscriberProfilenew(msisdn, true);
		FattyMonsterDetails fattyMonsterDetails = new FattyMonsterDetails();
		
		 fattyMonsterDetails =
		  fattyMonsterService.getFattyMonsterDetailsBasedOnMsisdn(msisdn,
		 fattyMonsterDetails);
		 subscriberProfile.setFattyMonsterDetails(fattyMonsterDetails);
		
		if (subscriberProfile == null) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn),
					HttpStatus.OK);
		}
		return new ResponseEntity<SubscriberProfilenew>(subscriberProfile, HttpStatus.OK);
	}

	@GetMapping(value = "/subscriber/touchlogin/details/{msisdn}")
	public ResponseEntity<?> getSubscriberDetailsTouchLogin(@PathVariable("msisdn") String msisdn,
			final HttpServletRequest request, final HttpServletResponse response) {

		/*
		 * if (!msisdn.equals(getCurrentUserName())) { return new
		 * ResponseEntity<>(new ApiResponse(false,
		 * DefaultApiResponse.UNAUTHORIZED.code(),
		 * DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		 * }
		 */

		SubscriberProfile subscriberProfile = subscriberManagementService.getSubscriberProfile(msisdn, true);
		if (subscriberProfile == null) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn),
					HttpStatus.OK);
		} else {
			Authentication authentication = new UsernamePasswordAuthenticationToken(subscriberProfile.getMsisdn(), null,
					SelfCareUser.getGrantedAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);
			final String token = getJwtTokenUtil().generateToken(subscriberProfile.getMsisdn(), null);
			LoggingUtil.debug(logger, "#login --- generated auth_token= " + token);
			response.setHeader(AuthConstants.JWT_HEADER_NAME, token);
		}
		return new ResponseEntity<SubscriberProfile>(subscriberProfile, HttpStatus.OK);
	}

	@PutMapping(value = "/changepassword")
	public ResponseEntity<?> changePassword(@RequestBody ChangePasswordRequest changePasswordRequest) {

		if (!changePasswordRequest.getLoginId().equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
					DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		try {
			subscriberManagementService.changePassword(changePasswordRequest.getLoginId(),
					changePasswordRequest.getOldPassword(), changePasswordRequest.getNewPassword());
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (SubscriberNotFoundException e) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(),
					changePasswordRequest.getLoginId()), HttpStatus.OK);

		} catch (PasswordMismatchException e) {
			return new ResponseEntity<>(DefaultApiResponse.PASSWORD_MISMATCH.message(), HttpStatus.OK);

		} catch (InvalidPasswordFormatException e) {
			return new ResponseEntity<>(DefaultApiResponse.INVALID_PASSWORD_FORMAT.message(), HttpStatus.OK);
		}
	}

	@PutMapping(value = "/resetpassword")
	public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordRequest request) {

		/*
		 * if (!request.getLoginId().equals(getCurrentUserName())) { return new
		 * ResponseEntity<>(new ApiResponse(false,
		 * DefaultApiResponse.UNAUTHORIZED.code(),
		 * DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		 * }
		 */

		LoggingUtil.debug(logger, String.format("#resetPassword --- receiving reset password request for MSISDN %s",
				request.getLoginId()));
		try {
			int status = getBlockStatus(request.getLoginId());
			System.out.println("status " + status);
			if (status == 1) {
				return new ResponseEntity<>(DefaultApiResponse.SUBSCRIBER_OTP_BLOCK.code(), HttpStatus.OK);
			}
			if (status == 2) {
				return new ResponseEntity<>(DefaultApiResponse.SUBSCRIBER_OTP_INVALID_TOKEN.code(), HttpStatus.OK);
			}
			subscriberManagementService.resetPassword(request.getLoginId(), request.getPassword(), request.getOtp());
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (SubscriberNotFoundException e1) {
			return new ResponseEntity<>(
					String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), request.getLoginId()),
					HttpStatus.OK);

		} catch (InvalidTokenException e1) {
			return new ResponseEntity<>(DefaultApiResponse.INVALID_TOKEN.message(), HttpStatus.OK);

		} catch (InvalidPasswordFormatException e1) {
			return new ResponseEntity<>(DefaultApiResponse.INVALID_PASSWORD_FORMAT.message(), HttpStatus.OK);

		} catch (Exception e1) {

			logger.error(String.format("#resetPassword --- error when processing reset password request for MSISDN %s",
					request.getLoginId()), e1);
			return new ResponseEntity<>(DefaultApiResponse.INTERNAL_APP_ERROR.message(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/getcos/{msisdn}")
	public ResponseEntity<?> getClassOfServiceName(@PathVariable String msisdn) {

		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
					DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		String cos = backEndRequestProcessor.getClassOfServiceName(msisdn);
		return new ResponseEntity<>(cos, HttpStatus.OK);
	}

	@PutMapping(value = "/updatetoken")
	public ResponseEntity<?> updateUserToken(@RequestBody UpdateUserTokenRequest request) {

		/*
		 * if (!request.getMsisdn().equals(getCurrentUserName())) { return new
		 * ResponseEntity<>(new ApiResponse(false,
		 * DefaultApiResponse.UNAUTHORIZED.code(),
		 * DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		 * }
		 */

		if (request == null || (request.getMsisdn() == null || request.getToken() == null)) {
			return ResponseEntity.ok(new ApiResponse(false, DefaultApiResponse.MISSING_REQUIRED_PARAMETER.code(),
					String.format(DefaultApiResponse.MISSING_REQUIRED_PARAMETER.message(), "'MSISDN and/or token'")));
		}

		ApiResponse response = new ApiResponse();
		boolean result = subscriberManagementService.storeFcmToken(request.getMsisdn(), request.getToken(),
				request.getOsType());
		if (result) {
			response.setSuccessful(true);
			response.setCode(DefaultApiResponse.SUCCESS.code());
			response.setMessage(DefaultApiResponse.SUCCESS.message());

		} else {
			response.setSuccessful(false);
			response.setCode(DefaultApiResponse.INTERNAL_APP_ERROR.code());
			response.setMessage(DefaultApiResponse.INTERNAL_APP_ERROR.message());
		}
		return ResponseEntity.ok(response);
	}

	// subscriber/usertouchlogin/details/01863470157/1.5.0.0/android/8.1.0/OPPO/CPH1803/NA/MTIzNGFiY2Q=
	@GetMapping(value = "/subscriber/touchloginnew/details/{msisdn}/{app_version}/{app_os}/{app_os_version}/{device_name}/{devic_modeil}/{devic_id}")
	public ResponseEntity<?> getSubscriberDetailsTouchLogin_Selfcare(@PathVariable("msisdn") String msisdn,
			@PathVariable("app_version") String app_version, @PathVariable("app_os") String app_os,
			@PathVariable("app_os_version") String app_os_version, @PathVariable("device_name") String device_name,
			@PathVariable("devic_modeil") String devic_modeil, @PathVariable("devic_id") String devic_id,
			final HttpServletRequest request, final HttpServletResponse response) {
		String numberofreadnotification = "0";
		SubscriberProfilenew subscriberProfile = subscriberManagementService.getSubscriberProfilenew(msisdn, true);

		/*
		 * GetLmsResponse getLmsConfigResponse = new GetLmsResponse(true,
		 * DefaultApiResponse.SUCCESS.code(),
		 * DefaultApiResponse.SUCCESS.message());
		 * 
		 * 
		 * getLmsConfigResponse.setConfigs(backEndRequestProcessor.getLmsConfigs
		 * ()); subscriberProfile.setGetLmsdata(getLmsConfigResponse);
		 */
		boolean version_details = backEndRequestProcessor.saveVersionDetails(msisdn, app_version, app_os,
				app_os_version, device_name, devic_modeil, devic_id);
		int appFeaturesStatus = versionDetailsSevice.getAppFeaturesBasedOnMsisdn(msisdn);
		subscriberProfile.setAppFeaturesStatus(appFeaturesStatus);
		List<PushedCampaignDTO> data = new ArrayList<>();
		// TODO filter only unread notif
		// List<PushedCampaign> list =
		// pushedCampaignService.getCampaigns(msisdn, null, new
		// NotificationStatus[] { NotificationStatus.UNREAD }, null, 0);
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
		if (list != null && list.size() > 0) {

			BazNotifcationStatusEntity recipient = this.bazNotifcationStatusRepository
					.findOne(QBazNotifcationStatusEntity.bazNotifcationStatusEntity.msisdn.eq(msisdn));
			// String datamsisdn=recipient.getNotification_status();

			if (recipient != null) {
				numberofreadnotification = recipient.getNumber_notification();
			}

			int totelnumberofnotification = list.size();

			subscriberProfile
					.setNotificationCount(totelnumberofnotification - Integer.parseInt(numberofreadnotification));
		} else {
			subscriberProfile.setNotificationCount(0);
		}

		if (subscriberProfile == null) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn),
					HttpStatus.OK);
		} else {
			Authentication authentication = new UsernamePasswordAuthenticationToken(subscriberProfile.getMsisdn(), null,
					SelfCareUser.getGrantedAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);
			final String token = getJwtTokenUtil().generateToken(subscriberProfile.getMsisdn(), null);
			LoggingUtil.debug(logger, "#login --- generated auth_token= " + token);
			response.setHeader(AuthConstants.JWT_HEADER_NAME, token);
		}
		Simname simname = subscriberManagementService.getSimname(msisdn);
		subscriberProfile.setType(simname.getType());
		return new ResponseEntity<SubscriberProfilenew>(subscriberProfile, HttpStatus.OK);
	}

	public int getBlockStatus(String msisdn) {
		int status = 0;
		try {
			OtpStatusModel otpStatusModel = backEndRequestProcessor.checkBlockUnblockOtp(msisdn);
			if (otpStatusModel != null) {
				System.out.println("status is --" + otpStatusModel.getStatus());

				if (otpStatusModel.getCount() >= 11) {
					status = 1;
					return status;
				}
				if (otpStatusModel.getFailCount() >= 5) {
					status = 2;
					return status;
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return status;
	}

	/*
	 * @GetMapping(value =
	 * "/subscriber/autosignuser/details/{msisdn}/{app_version}/{app_os}/{app_os_version}/{device_name}/{devic_modeil}/{devic_id}/{password}")
	 * public ResponseEntity<?>
	 * getSubscriberDetailsTouchLogin_Data(@PathVariable("msisdn") String
	 * msisdn,
	 * 
	 * @PathVariable("app_version") String app_version, @PathVariable("app_os")
	 * String app_os,
	 * 
	 * @PathVariable("app_os_version") String
	 * app_os_version, @PathVariable("device_name") String device_name,
	 * 
	 * @PathVariable("devic_modeil") String
	 * devic_modeil, @PathVariable("devic_id") String devic_id,
	 * 
	 * @PathVariable("password") String password, final HttpServletRequest
	 * request, final HttpServletResponse response) { String token_imp =
	 * password; SubscriberProfilenew subscriberProfile = null;
	 * 
	 * String tokenFromDB = fetchToken(msisdn);
	 * 
	 * if (token_imp != null ) { if (tokenFromDB != null
	 * &&tokenFromDB.equals(token_imp)) { subscriberProfile =
	 * subscriberManagementService.getSubscriberProfilenew(msisdn, true);
	 * boolean version_details =
	 * backEndRequestProcessor.saveVersionDetails(msisdn, app_version, app_os,
	 * app_os_version, device_name, devic_modeil, devic_id); } else { return new
	 * ResponseEntity<>(String.format(DefaultApiResponse.UNAUTHORIZED.message(),
	 * msisdn), HttpStatus.OK);
	 * 
	 * } } // ###############################################
	 * 
	 * GetLmsResponse getLmsConfigResponse = new GetLmsResponse(true,
	 * DefaultApiResponse.SUCCESS.code(), DefaultApiResponse.SUCCESS.message());
	 * getLmsConfigResponse.setConfigs(backEndRequestProcessor.getLmsConfigs
	 * ()); subscriberProfile.setGetLmsdata(getLmsConfigResponse);
	 * 
	 * 
	 * if (subscriberProfile == null) { return new
	 * ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.
	 * message(), msisdn), HttpStatus.OK); } else { Authentication
	 * authentication = new
	 * UsernamePasswordAuthenticationToken(subscriberProfile.getMsisdn(), null,
	 * SelfCareUser.getGrantedAuthorities());
	 * SecurityContextHolder.getContext().setAuthentication(authentication);
	 * final String token =
	 * getJwtTokenUtil().generateToken(subscriberProfile.getMsisdn(), null);
	 * LoggingUtil.debug(logger, "#login --- generated auth_token= " + token);
	 * response.setHeader(AuthConstants.JWT_HEADER_NAME, token); } return new
	 * ResponseEntity<SubscriberProfilenew>(subscriberProfile, HttpStatus.OK); }
	 * 
	 */
	/*
	 * @GetMapping(value =
	 * "/subscriber/autosignuser/details/{app_version}/{app_os}/{app_os_version}/{device_name}/{devic_modeil}/{devic_id}/{token}")
	 * public ResponseEntity<?>
	 * getSubscriberDetailsTouchLogin_Data(@PathVariable("app_version") String
	 * app_version,
	 * 
	 * @PathVariable("app_os") String app_os, @PathVariable("app_os_version")
	 * String app_os_version,
	 * 
	 * @PathVariable("device_name") String
	 * device_name, @PathVariable("devic_modeil") String devic_modeil,
	 * 
	 * @PathVariable("devic_id") String devic_id, @PathVariable("token") String
	 * tokenvalue, final HttpServletRequest request, final HttpServletResponse
	 * response) {
	 * 
	 * SubscriberProfilenew subscriberProfile = null; String tokenValid =
	 * StringUtils.newStringUtf8(Base64.decodeBase64(tokenvalue)); String msisdn
	 * = fetchMsisdn(tokenValid);
	 * 
	 * if (msisdn != null) { subscriberProfile =
	 * subscriberManagementService.getSubscriberProfilenew(msisdn, true);
	 * boolean version_details =
	 * backEndRequestProcessor.saveVersionDetails(msisdn, app_version, app_os,
	 * app_os_version, device_name, devic_modeil, devic_id); } else { return new
	 * ResponseEntity<>(String.format(DefaultApiResponse.UNAUTHORIZED.message())
	 * , HttpStatus.OK);
	 * 
	 * }
	 * 
	 * if (subscriberProfile == null) { return new
	 * ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.
	 * message(), msisdn), HttpStatus.OK); } else { Authentication
	 * authentication = new
	 * UsernamePasswordAuthenticationToken(subscriberProfile.getMsisdn(), null,
	 * SelfCareUser.getGrantedAuthorities());
	 * SecurityContextHolder.getContext().setAuthentication(authentication);
	 * final String token =
	 * getJwtTokenUtil().generateToken(subscriberProfile.getMsisdn(), null);
	 * LoggingUtil.debug(logger, "#login --- generated auth_token= " + token);
	 * response.setHeader(AuthConstants.JWT_HEADER_NAME, token); } return new
	 * ResponseEntity<SubscriberProfilenew>(subscriberProfile, HttpStatus.OK); }
	 */

	@GetMapping(value = "/subscriber/autosignuser/details/{app_version}/{app_os}/{app_os_version}/{device_name}/{devic_modeil}/{devic_id}/{token}")
	public ResponseEntity<?> getSubscriberDetailsTouchLogin_Data(@PathVariable("app_version") String app_version,
			@PathVariable("app_os") String app_os, @PathVariable("app_os_version") String app_os_version,
			@PathVariable("device_name") String device_name, @PathVariable("devic_modeil") String devic_modeil,
			@PathVariable("devic_id") String devic_id, @PathVariable("token") String tokenvalue,
			final HttpServletRequest request, final HttpServletResponse response) {
		String numberofreadnotification = "0";

		SubscriberProfilenew subscriberProfile = null;
		String tokenValid = StringUtils.newStringUtf8(Base64.decodeBase64(tokenvalue));
		String msisdn = fetchMsisdn(tokenValid);

		if (msisdn != null) {

			subscriberProfile = subscriberManagementService.getSubscriberProfilenew(msisdn, true);
			boolean version_details = backEndRequestProcessor.saveVersionDetails(msisdn, app_version, app_os,
					app_os_version, device_name, devic_modeil, devic_id);
		} else {
			return new ResponseEntity<>(String.format(DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.OK);

		}

		if (subscriberProfile == null) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn),
					HttpStatus.OK);
		} else {
			Authentication authentication = new UsernamePasswordAuthenticationToken(subscriberProfile.getMsisdn(), null,
					SelfCareUser.getGrantedAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);
			final String token = getJwtTokenUtil().generateToken(subscriberProfile.getMsisdn(), null);
			LoggingUtil.debug(logger, "#login --- generated auth_token= " + token);

			response.setHeader(AuthConstants.JWT_HEADER_NAME, token);
			List<PushedCampaignDTO> data = new ArrayList<>();
			// TODO filter only unread notif
			// List<PushedCampaign> list =
			// pushedCampaignService.getCampaigns(msisdn, null, new
			// NotificationStatus[] { NotificationStatus.UNREAD }, null, 0);

			List<PushedCampaign> list = pushedCampaignService.getCampaignsNew(msisdn);
			if (list != null) {
				for (PushedCampaign pc : list) {
					PushedCampaignDTO dto = new PushedCampaignDTO(pc.getTitleEN(), pc.getDescriptionEN(),
							pc.getDetailsEN(), pc.getTitleVI(), pc.getDescriptionVI(), pc.getDetailsVI(),
							pc.getTargetedUser(), AppUtils.dateToString(pc.getStartDate(), DATE_FORMAT),
							AppUtils.dateToString(pc.getEndDate(), DATE_FORMAT));
					dto.setId(pc.getId());

					data.add(dto);
				}
			}
			if (list != null && list.size() > 0) {

				BazNotifcationStatusEntity recipient = this.bazNotifcationStatusRepository
						.findOne(QBazNotifcationStatusEntity.bazNotifcationStatusEntity.msisdn.eq(msisdn));
				// String datamsisdn=recipient.getNotification_status();

				if (recipient != null) {
					numberofreadnotification = recipient.getNumber_notification();
				}

				int totelnumberofnotification = list.size();
				int Actulvalueofnotifaction = totelnumberofnotification - Integer.parseInt(numberofreadnotification);
				if (Actulvalueofnotifaction >= 0) {
					subscriberProfile.setNotificationCount(Actulvalueofnotifaction);
				} else {
					subscriberProfile.setNotificationCount(0);
				}
				// subscriberProfile.setNotificationCount(totelnumberofnotification-Integer.parseInt(numberofreadnotification));

			}

			else {

				subscriberProfile.setNotificationCount(0);
			}
		}
		Simname simname = subscriberManagementService.getSimname(msisdn);
		subscriberProfile.setType(simname.getType());
		return new ResponseEntity<SubscriberProfilenew>(subscriberProfile, HttpStatus.OK);
	}

	/*
	 * public String fetchMsisdn(String token){ try{ MsisdnTokenEntity
	 * msisdnTokenEntity = msisdnRepo
	 * .findOne(QMsisdnTokenEntity.msisdnTokenEntity.token.eq(token)); return
	 * msisdnTokenEntity != null ?msisdnTokenEntity.getMsisdn():null; }
	 * catch(Exception e){ e.printStackTrace(); return null; }
	 * 
	 * }
	 */

	public String fetchMsisdn(String token) {
		try {
			MsisdnTokenEntity msisdnTokenEntity = msisdnRepo
					.findOne(QMsisdnTokenEntity.msisdnTokenEntity.token.eq(token));
			if (msisdnTokenEntity != null) {
				Date tokenDate = msisdnTokenEntity.getCreateTimestamp();
				Date current = new Date();
				if ((current.getTime() - tokenDate.getTime()) > 300000) {
					return null;
				}
			}

			return msisdnTokenEntity != null ? msisdnTokenEntity.getMsisdn() : null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@GetMapping(value = "/subscriber/usertouchlogin/details/{msisdn}/{app_version}/{app_os}/{app_os_version}/{device_name}/{devic_modeil}/{devic_id}/{password}")
	public ResponseEntity<?> getSubscriberDetailsTouchLogin_Pass(@PathVariable("msisdn") String msisdn,
			@PathVariable("app_version") String app_version, @PathVariable("app_os") String app_os,
			@PathVariable("app_os_version") String app_os_version, @PathVariable("device_name") String device_name,
			@PathVariable("devic_modeil") String devic_modeil, @PathVariable("devic_id") String devic_id,
			@PathVariable("password") String password, final HttpServletRequest request,
			final HttpServletResponse response) {

		SubscriberProfilenew subscriberProfile = null;
		// ############################################
		// JedisConfig jed= new JedisConfig();
		// get the subscriber token from DB
		// jed.getTokenForMsisdn(msisdn);
		// String tokenFromDB = fetchToken(msisdn);
		String numberofreadnotification = "0";
		if (msisdn != null) {

			if (!subscriberManagementService.instantLogin(msisdn,
					StringUtils.newStringUtf8(Base64.decodeBase64(password)))) {

				return new ResponseEntity<>(
						String.format(DefaultApiResponse.PASSWORD_MISMATCH_CHANGE.message(), msisdn), HttpStatus.OK);

			}

			subscriberProfile = subscriberManagementService.getSubscriberProfilenew(msisdn, true);
			boolean version_details = backEndRequestProcessor.saveVersionDetails(msisdn, app_version, app_os,
					app_os_version, device_name, devic_modeil, devic_id);
			int appFeaturesStatus = versionDetailsSevice.getAppFeaturesBasedOnMsisdn(msisdn);
			subscriberProfile.setAppFeaturesStatus(appFeaturesStatus);

			// ###############################################
			/*
			 * GetLmsResponse getLmsConfigResponse = new GetLmsResponse(true,
			 * DefaultApiResponse.SUCCESS.code(),
			 * DefaultApiResponse.SUCCESS.message());
			 * getLmsConfigResponse.setConfigs(backEndRequestProcessor.
			 * getLmsConfigs ());
			 * subscriberProfile.setGetLmsdata(getLmsConfigResponse);
			 */

			if (subscriberProfile == null) {
				return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn),
						HttpStatus.OK);
			} else {
				Authentication authentication = new UsernamePasswordAuthenticationToken(subscriberProfile.getMsisdn(),
						null, SelfCareUser.getGrantedAuthorities());
				SecurityContextHolder.getContext().setAuthentication(authentication);
				final String token = getJwtTokenUtil().generateToken(subscriberProfile.getMsisdn(), null);
				LoggingUtil.debug(logger, "#login --- generated auth_token= " + token);
				response.setHeader(AuthConstants.JWT_HEADER_NAME, token);
			}
			List<PushedCampaignDTO> data = new ArrayList<>();
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
			if (list != null && list.size() > 0) {

				BazNotifcationStatusEntity recipient = this.bazNotifcationStatusRepository
						.findOne(QBazNotifcationStatusEntity.bazNotifcationStatusEntity.msisdn.eq(msisdn));
				// String datamsisdn=recipient.getNotification_status();

				if (recipient != null) {
					numberofreadnotification = recipient.getNumber_notification();
				}

				int totelnumberofnotification = list.size();

				subscriberProfile
						.setNotificationCount(totelnumberofnotification - Integer.parseInt(numberofreadnotification));
			} else {
				subscriberProfile.setNotificationCount(0);
			}
			Simname simname = subscriberManagementService.getSimname(msisdn);
			subscriberProfile.setType(simname.getType());
			return new ResponseEntity<SubscriberProfilenew>(subscriberProfile, HttpStatus.OK);

		}

		else {

			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn),
					HttpStatus.OK);
		}
	}

}