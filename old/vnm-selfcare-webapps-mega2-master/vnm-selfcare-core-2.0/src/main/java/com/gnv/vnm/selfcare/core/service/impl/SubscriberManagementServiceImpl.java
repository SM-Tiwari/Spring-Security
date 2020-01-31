/**
 * SubscriberManagementServiceImpl.java
 */
package com.gnv.vnm.selfcare.core.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.lang.RandomStringUtils;
import org.jboss.aerogear.security.otp.Totp;
import org.jboss.aerogear.security.otp.api.Base32;
import org.jboss.aerogear.security.otp.api.Clock;
import org.jsmpp.bean.Alphabet;
import org.jsmpp.bean.GeneralDataCoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gnv.vnm.selfcare.core.AppDefaultValues;
import com.gnv.vnm.selfcare.core.adapter.loyalty.LMSAdapter;
import com.gnv.vnm.selfcare.core.adapter.radius.BasicSubscriberInfo;
import com.gnv.vnm.selfcare.core.enums.ClientAppId;
import com.gnv.vnm.selfcare.core.enums.DefaultBackendMessage;
import com.gnv.vnm.selfcare.core.enums.Gender;
import com.gnv.vnm.selfcare.core.enums.SubscriberStatus;
import com.gnv.vnm.selfcare.core.enums.SubscriberType;
import com.gnv.vnm.selfcare.core.enums.SubscriptionStatus;
import com.gnv.vnm.selfcare.core.enums.SupportedLanguage;
import com.gnv.vnm.selfcare.core.enums.TokenStatus;
import com.gnv.vnm.selfcare.core.fault.EmailAddressNotRegisteredException;
import com.gnv.vnm.selfcare.core.fault.ExternalSubscriberException;
import com.gnv.vnm.selfcare.core.fault.InvalidPasswordFormatException;
import com.gnv.vnm.selfcare.core.fault.InvalidTokenException;
import com.gnv.vnm.selfcare.core.fault.PasswordMismatchException;
import com.gnv.vnm.selfcare.core.fault.SubscriberAlreadyExistsException;
import com.gnv.vnm.selfcare.core.fault.SubscriberNotFoundException;
import com.gnv.vnm.selfcare.core.model.Avatar;
import com.gnv.vnm.selfcare.core.model.BasicAccount;
import com.gnv.vnm.selfcare.core.model.CurrentBalance;
import com.gnv.vnm.selfcare.core.model.PackageSubscription;
import com.gnv.vnm.selfcare.core.model.Simname;
import com.gnv.vnm.selfcare.core.model.SubscriberDetails;
import com.gnv.vnm.selfcare.core.model.SubscriberProfile;
import com.gnv.vnm.selfcare.core.model.SubscriberProfilenew;
import com.gnv.vnm.selfcare.core.model.SubscriptionDeaitls;
import com.gnv.vnm.selfcare.core.model.TransactionHistory;
import com.gnv.vnm.selfcare.core.security.SimplePasswordEncoder;
import com.gnv.vnm.selfcare.core.service.ApplicationConfigurationService;
import com.gnv.vnm.selfcare.core.service.AvatarService;
import com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor;
import com.gnv.vnm.selfcare.core.service.EposDbClient;
import com.gnv.vnm.selfcare.core.service.MicInformationService;
import com.gnv.vnm.selfcare.core.service.SMPPServiceProvider;
import com.gnv.vnm.selfcare.core.service.SendSMSService;
import com.gnv.vnm.selfcare.core.service.SubscriberManagementService;
import com.gnv.vnm.selfcare.core.service.TibcoServiceProvider;
import com.gnv.vnm.selfcare.core.utils.AppUtils;
import com.gnv.vnm.selfcare.core.utils.Constant;
import com.gnv.vnm.selfcare.core.utils.LoggingUtil;
import com.gnv.vnm.selfcare.core.utils.SpringUtils;
import com.gnv.vnm.selfcare.dao.entity.CosAppFeatureMappingsEntity;
import com.gnv.vnm.selfcare.dao.entity.FcmTokenEntity;
import com.gnv.vnm.selfcare.dao.entity.LoginHistoryEntity;
import com.gnv.vnm.selfcare.dao.entity.MemberGetMemberEntity;
import com.gnv.vnm.selfcare.dao.entity.OtpEntity;
import com.gnv.vnm.selfcare.dao.entity.OtpStatusEntity;
import com.gnv.vnm.selfcare.dao.entity.QCosAppFeatureMappingsEntity;
import com.gnv.vnm.selfcare.dao.entity.QFcmTokenEntity;
import com.gnv.vnm.selfcare.dao.entity.QLoginHistoryEntity;
import com.gnv.vnm.selfcare.dao.entity.QMemberGetMemberEntity;
import com.gnv.vnm.selfcare.dao.entity.QOtpEntity;
import com.gnv.vnm.selfcare.dao.entity.QOtpStatusEntity;
import com.gnv.vnm.selfcare.dao.entity.QSubscriberEntity;
import com.gnv.vnm.selfcare.dao.entity.QSubscriberRegistrationCounterEntity;
import com.gnv.vnm.selfcare.dao.entity.SubscriberDetailEntity;
import com.gnv.vnm.selfcare.dao.entity.SubscriberEntity;
import com.gnv.vnm.selfcare.dao.entity.SubscriberRegistrationCounterEntity;
import com.gnv.vnm.selfcare.dao.repo.CosAppFeatureMappingsRepository;
import com.gnv.vnm.selfcare.dao.repo.FcmTokenRepository;
import com.gnv.vnm.selfcare.dao.repo.LoginHistoryRepository;
import com.gnv.vnm.selfcare.dao.repo.MemberGetMemberRepository;
import com.gnv.vnm.selfcare.dao.repo.OtpRepository;
import com.gnv.vnm.selfcare.dao.repo.OtpStatusRepository;
import com.gnv.vnm.selfcare.dao.repo.SubscriberRegistrationCounterRepository;
import com.gnv.vnm.selfcare.dao.repo.SubscriberRepository;

/**
 * @author nandipinto
 *
 */

@Service("subscriberManagementService")
public class SubscriberManagementServiceImpl implements SubscriberManagementService, MessageSourceAware {

	private static final Logger logger = LoggerFactory.getLogger(SubscriberManagementServiceImpl.class);

	// @Autowired
	private MessageSource messageSource;

	@Autowired
	private SubscriberRepository subscriberRepository;
	@Autowired
	private OtpRepository otpRepository;
	@Autowired
	private LoginHistoryRepository loginHistoryRepository;
	@Autowired
	private SubscriberRegistrationCounterRepository subscriberRegistrationCounterRepository;
	@Autowired
	private MemberGetMemberRepository memberGetMemberRepository;
	@Autowired
	private CosAppFeatureMappingsRepository cosAppFeatureMappingRepository;
	@Autowired
	private FcmTokenRepository fcmTokenRepository;

	@Autowired
	protected AvatarService avatarService;
	@Autowired
	private ApplicationConfigurationService applicationConfigurationService;
	@Autowired
	private BackEndRequestProcessor backEndRequestProcessor;
	@Autowired
	private EposDbClient eposDbClient;

	@Autowired
	private SMPPServiceProvider smppServiceProvider;
	
	@Autowired
	private SendSMSService sendsmsservice;
	@Autowired
	TibcoServiceProvider tibcoServiceProvider;

	@Autowired
	private SimplePasswordEncoder passwordEncoder;

	private Clock otpClock = null;
	private String defaultLanguageCode = SupportedLanguage.VIETNAMESE.code();

	private List<String> imsiPrefixes = new ArrayList<>();
	@Autowired
	private ThreadPoolTaskExecutor taskExecutor;
	@Autowired
	private MicInformationService micInformationService;
	public String mode = Constant.MODE;
	
	@Autowired
	private OtpStatusRepository otpstatusRepository;

	@PostConstruct
	public void initService() throws Exception {
		defaultLanguageCode = applicationConfigurationService
				.get("language.default", SupportedLanguage.VIETNAMESE.code()).toString();
	}

	@PreDestroy
	public void stopService() {
		taskExecutor.shutdown();
	}

	private Clock getOtpClock() {
		if (otpClock == null) {
			otpClock = new Clock(getTokenExpiryTime() * 60);
		}

		return otpClock;
	}

	@Override
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.SubscriberManagementService#
	 * autoRegistration(java.lang.String)
	 */
	@Override
	public SubscriberProfile signInWithIMSI(String imsi, String loginFrom, String clientAppId)
			throws ExternalSubscriberException {

		if (!isVnmImsi(imsi))
			throw new ExternalSubscriberException("ERROR: Number not recognized!");

		SubscriberProfile user = null;

		try {
			// query to internal subscriber db first
			SubscriberEntity subscriber = subscriberRepository
					.findOne(QSubscriberEntity.subscriberEntity.imsi.eq(imsi));
			if (subscriber != null) {
				user = new SubscriberProfile(subscriber.getId(), subscriber.getMsisdn(), imsi, subscriber.getImei(),
						subscriber.getEmailAddress(), SubscriberType.fromInt(subscriber.getType()),
						SubscriberStatus.fromInt(subscriber.getStatus()));
				user.setPreferredLanguage(subscriber.getLanguageCode());
				if (subscriber.getDetails() != null) {
					SubscriberDetailEntity profile = subscriber.getDetails();
					SubscriberDetails sp = new SubscriberDetails(profile.getFullName(),
							Gender.valueOf(profile.getGender()), profile.getBirthDate(), profile.getAvatar(),
							profile.getAddress1(), profile.getAddress2(), profile.getAddress3(), null,
							profile.getZipCode(), profile.getOccupation(), profile.getCompanyName());
					user.setDetails(sp);
				}

			} else {
				// this is might be first sign-in for this subscriber
				String msisdn = eposDbClient.lookupMSISDN(imsi);
				if (StringUtils.hasText(msisdn)) {

					// TODO check if MSISDN already exists
					subscriber = subscriberRepository.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(msisdn));
					if (subscriber == null) {
						subscriber = new SubscriberEntity();
						subscriber.setMsisdn(msisdn);
					}
					subscriber.setImsi(imsi);
					subscriber.setType(eposDbClient.getSubscriberType(msisdn).ordinal());
					subscriber.setStatus(SubscriberStatus.ACTIVE.ordinal());
					subscriber.setLanguageCode(defaultLanguageCode);

					SubscriberEntity entity = subscriberRepository.saveAndFlush(subscriber);
					user = new SubscriberProfile(entity.getId(), msisdn, imsi, entity.getImei(),
							entity.getEmailAddress(), SubscriberType.fromInt(entity.getType()),
							SubscriberStatus.fromInt(entity.getStatus()));
					user.setPreferredLanguage(subscriber.getLanguageCode());

					// TODO set initial password for this subscriber
				}
			}

			if (user != null) {
				Calendar today = Calendar.getInstance();
				today.set(Calendar.HOUR, 0);
				today.set(Calendar.MINUTE, 0);
				today.set(Calendar.SECOND, 0);

				user.setCurrentBalance(
						backEndRequestProcessor.getCurrentBalance(user.getMsisdn(), user.getPreferredLanguage()));
				user.setCallHistory(
						backEndRequestProcessor.getCallHistory(user.getMsisdn(), today.getTime(), new Date()));
				user.setSubscriptions(getSubscribedPackages(user.getMsisdn(), user.getPreferredLanguage()));

				updateLoginHistory(user.getMsisdn(), loginFrom, clientAppId);
			}
		} catch (Exception e) {
			logger.error(
					"#autoRegistration >> error when processing auto registration for SubscriberProfile with IMSI= "
							+ imsi,
					e);
		}
		return user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.SubscriberManagementService#
	 * signInWithIPAddress(java.lang.String)
	 */
	@Override
	public SubscriberProfile signInWithIPAddress(String ipAddress) {

		LoggingUtil.debug(logger, "#signInWithIPAddress --- " + ipAddress + ", validating IP address to Radius...");

		BasicSubscriberInfo basicInfo = backEndRequestProcessor.getSubscriberInfoFromRadius(ipAddress);

		LoggingUtil.debug(logger,
				"#signInWithIPAddress --- " + ipAddress + ", receiving response from Radius= " + basicInfo);

		if (basicInfo == null)
			return null;

		String msisdn = stripCountryCode(basicInfo.getMsisdn());
		if (!isActiveSubscriber(msisdn))
			return null;

		return getSubscriberProfile(msisdn, true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.SubscriberManagementService#
	 * isIpAddressAuthenticated(java.lang.String)
	 */
	@Override
	public String lookupUserByIpAddress(String ipAddress) {

		LoggingUtil.debug(logger, "#validateUserByIpAddress --- validating IP address " + ipAddress + " to Radius...");

		BasicSubscriberInfo basicInfo = backEndRequestProcessor.getSubscriberInfoFromRadius(ipAddress);

		return basicInfo != null ? basicInfo.getMsisdn() : null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.SubscriberManagementService#
	 * performPostLoginActions(java.lang.String, java.lang.String,
	 * com.gnv.vnm.selfcare.core.enums.ClientAppId)
	 */
	@Override
	public void performPostLoginActions(String msisdn, String remoteIpAddress, ClientAppId clientAppId) {

		try {
			long count = loginHistoryRepository.count(QLoginHistoryEntity.loginHistoryEntity.msisdn.eq(msisdn));
			if (count == 0) {
				// first time login -- send redeem point to LMS if eligible
				redeemLoyaltyPoint(msisdn);
			}

			loginHistoryRepository
					.saveAndFlush(new LoginHistoryEntity(msisdn, new Date(), remoteIpAddress, clientAppId.name()));

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	private String stripCountryCode(String msisdn) {
		String countryCode = applicationConfigurationService.getDefaultCountryCode();
		return AppUtils.removeCountryCode(msisdn, countryCode);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.SubscriberManagementService#
	 * registerSubscriber(java.lang.String)
	 */
	@Override
	public String registerSubscriber(String msisdn, String credential, ClientAppId originator)
			throws ExternalSubscriberException, InvalidPasswordFormatException, SubscriberAlreadyExistsException {
		if (!StringUtils.hasText(msisdn) || !StringUtils.hasText(credential))
			return null;
		if (originator == null)
			originator = ClientAppId.MOBILE_APP;

		if (!isVnmNumber(msisdn))
			throw new ExternalSubscriberException("ERROR: Number not recognized!");

		String passwordPattern = applicationConfigurationService
				.get("security.password.regex", AppDefaultValues.PASSWORD_REGEX).toString();
		if (!credential.matches(passwordPattern))
			throw new InvalidPasswordFormatException("Invalid password format!");

		msisdn = stripCountryCode(msisdn);
		SubscriberEntity subscriber = subscriberRepository
				.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(msisdn));

		if (subscriber != null) {
			if (subscriber.getStatus() != null && subscriber.getStatus().equals(SubscriberStatus.ACTIVE.ordinal())) {
				throw new SubscriberAlreadyExistsException(
						String.format("SubscriberProfile %s already exists!", msisdn));
			}
		} else {
			subscriber = new SubscriberEntity();
			subscriber.setMsisdn(msisdn);
		}

		try {
			subscriber.setLanguageCode(SupportedLanguage.VIETNAMESE.code());
			subscriber.setCredential(passwordEncoder.encode(credential));
			subscriber.setRegisterFrom(originator.name());

			if (originator.equals(ClientAppId.MOBILE_APP)) {
				subscriber.setStatus(SubscriberStatus.ACTIVE.ordinal());
			} else {
				subscriber.setStatus(SubscriberStatus.PENDING.ordinal());
			}
			subscriberRepository.saveAndFlush(subscriber);

			String otp = generateOTP(msisdn, false, null);

			return otp;
		} catch (Exception e) {
			logger.error(
					"#registerSubscriber(MSISDN, credential) -- error processing subscriber registration for MSISDN= "
							+ msisdn,
					e);

		} finally {
			updateRegistrationCounter(originator.name());
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.SubscriberManagementService#
	 * registerSubscriber(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void registerSubscriber(String msisdn, String credential, String otp, String registerFrom)
			throws ExternalSubscriberException, InvalidPasswordFormatException, SubscriberAlreadyExistsException,
			InvalidTokenException, Exception {

		if (!isVnmNumber(msisdn))
			throw new ExternalSubscriberException("ERROR: Number not recognized!");

		String passwordPattern = applicationConfigurationService
				.get("security.password.regex", AppDefaultValues.PASSWORD_REGEX).toString();
		if (!credential.matches(passwordPattern))
			throw new InvalidPasswordFormatException("Invalid password format!");

		msisdn = stripCountryCode(msisdn);

		OtpEntity otpe = otpRepository.findOne(QOtpEntity.otpEntity.subscriberId.eq(msisdn));
		if (otpe == null){
			invalidOtp(msisdn);
			throw new InvalidTokenException(String.format("Token %s is not valid!", otp));
		}
			

		if (!otp.matches("\\d+")) {
			// token must be numeric value
			invalidOtp(msisdn);
			throw new InvalidTokenException(String.format("Token %s is not valid!", otp));
		}

		// check if token is still valid
		if (!new Totp(otpe.getKey(), getOtpClock()).verify(otp)) {
			otpe.setStatus(TokenStatus.EXPIRED.ordinal());
			otpRepository.saveAndFlush(otpe);
			invalidOtp(msisdn);
			throw new InvalidTokenException("Submitted token has expired: " + otp);
		}
		backEndRequestProcessor.resetFailCount(msisdn);
		SubscriberEntity subscriber = subscriberRepository
				.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(msisdn));
		if (subscriber != null) {
			if (subscriber.getStatus() != null && subscriber.getStatus().equals(SubscriberStatus.ACTIVE.ordinal())) {
				throw new SubscriberAlreadyExistsException(
						String.format("SubscriberProfile %s already exists!", msisdn));
			}
		} else {
			subscriber = new SubscriberEntity();
			subscriber.setMsisdn(msisdn);
		}

		try {
			subscriber.setLanguageCode(SupportedLanguage.VIETNAMESE.code());
			subscriber.setStatus(SubscriberStatus.ACTIVE.ordinal());
			subscriber.setCredential(passwordEncoder.encode(credential));
			subscriber.setRegisterFrom(registerFrom);

			subscriberRepository.saveAndFlush(subscriber);

		} catch (Exception e) {
			logger.error(
					"#registerSubscriber(MSISDN, credential, OTP) -- error processing subscriber registration for MSISDN= "
							+ msisdn,
					e);
			throw e;

		} finally {
			updateRegistrationCounter(registerFrom);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.SubscriberManagementService#
	 * registerSubscriber(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void registerSubscriberTemp(String msisdn, String credential, String otp, String registerFrom)
			throws ExternalSubscriberException, InvalidPasswordFormatException, SubscriberAlreadyExistsException,
			InvalidTokenException, Exception {

		if (!isVnmNumber(msisdn))
			throw new ExternalSubscriberException("ERROR: Number not recognized!");

		String passwordPattern = applicationConfigurationService
				.get("security.password.regex", AppDefaultValues.PASSWORD_REGEX).toString();
		if (!credential.matches(passwordPattern))
			throw new InvalidPasswordFormatException("Invalid password format!");

		msisdn = stripCountryCode(msisdn);

		/*
		 * OtpEntity otpe =
		 * otpRepository.findOne(QOtpEntity.otpEntity.subscriberId.eq(msisdn));
		 * if (otpe == null) throw new
		 * InvalidTokenException(String.format("Token %s is not valid!", otp));
		 * 
		 * if (!otp.matches("\\d+")) { // token must be numeric value throw new
		 * InvalidTokenException(String.format("Token %s is not valid!", otp));
		 * }
		 * 
		 * // check if token is still valid if (!new Totp(otpe.getKey(),
		 * getOtpClock()).verify(otp)) {
		 * otpe.setStatus(TokenStatus.EXPIRED.ordinal());
		 * otpRepository.saveAndFlush(otpe);
		 * 
		 * throw new InvalidTokenException("Submitted token has expired: " +
		 * otp); }
		 */

		SubscriberEntity subscriber = subscriberRepository
				.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(msisdn));
		if (subscriber != null) {
			if (subscriber.getStatus() != null && subscriber.getStatus().equals(SubscriberStatus.ACTIVE.ordinal())) {
				throw new SubscriberAlreadyExistsException(
						String.format("SubscriberProfile %s already exists!", msisdn));
			}
		} else {
			subscriber = new SubscriberEntity();
			subscriber.setMsisdn(msisdn);
		}

		try {
			subscriber.setLanguageCode(SupportedLanguage.VIETNAMESE.code());
			subscriber.setStatus(SubscriberStatus.ACTIVE.ordinal());
			subscriber.setCredential(passwordEncoder.encode(credential));
			subscriber.setRegisterFrom(registerFrom);

			subscriberRepository.saveAndFlush(subscriber);

		} catch (Exception e) {
			logger.error(
					"#registerSubscriber(MSISDN, credential, OTP) -- error processing subscriber registration for MSISDN= "
							+ msisdn,
					e);
			throw e;

		} finally {
			updateRegistrationCounter(registerFrom);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.SubscriberManagementService#
	 * confirmRegistration(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void confirmRegistration(String subscriberId, String credential, String otp)
			throws InvalidTokenException, Exception {

		subscriberId = stripCountryCode(subscriberId);

		OtpEntity otpe = otpRepository.findOne(QOtpEntity.otpEntity.subscriberId.eq(subscriberId));
		if (otpe == null)
			throw new InvalidTokenException(String.format("Token %s is not valid!", otp));

		// check if token is still valid
		if (!new Totp(otpe.getKey(), getOtpClock()).verify(otp)) {
			otpe.setStatus(TokenStatus.EXPIRED.ordinal());
			otpRepository.saveAndFlush(otpe);

			throw new InvalidTokenException("Submitted token has expired: " + otp);
		}

		try {
			SubscriberEntity subscriber = subscriberRepository
					.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(subscriberId));
			if (subscriber == null) {
				subscriber = new SubscriberEntity();
				subscriber.setMsisdn(subscriberId);
			}
			subscriber.setLanguageCode(SupportedLanguage.VIETNAMESE.code());
			subscriber.setStatus(SubscriberStatus.ACTIVE.ordinal());
			subscriber.setCredential(credential); // password has already been
													// encoded
			subscriber.setRegisterFrom(ClientAppId.WEB_APP.name()); // this
																	// method
																	// will only
																	// be
																	// invoked
																	// from web
																	// app
																	// controller

			subscriberRepository.saveAndFlush(subscriber);

		} catch (Exception e) {
			logger.error(String.format("#confirmRegistration --- error registering MSISDN %s with OTP %s", subscriberId,
					otp), e);
			throw e;

		} finally {
			updateRegistrationCounter(ClientAppId.WEB_APP.name());
		}
	}

	private void updateRegistrationCounter(String appSourceId) {

		try {
			SubscriberRegistrationCounterEntity counter = this.subscriberRegistrationCounterRepository
					.findOne(QSubscriberRegistrationCounterEntity.subscriberRegistrationCounterEntity.appSourceId
							.equalsIgnoreCase(appSourceId));

			if (counter == null) {
				counter = new SubscriberRegistrationCounterEntity();
				counter.setAppSourceId(appSourceId);
			}
			counter.setCount(counter.getCount() + 1);
			subscriberRegistrationCounterRepository.saveAndFlush(counter);

		} catch (Exception e) {
			logger.error(
					"#updateRegistrationCounter --error updating subscriber registration counter: " + e.getMessage());
		}
	}

	/**
	 * @return the imsiPrefixes
	 */
	public List<String> getImsiPrefixes() {
		String[] prefixes = applicationConfigurationService.get("prefixes.vnm.imsi", "").toString().split(";");
		if (prefixes != null && prefixes.length > 0) {
			imsiPrefixes = new ArrayList<>();
			for (String prefix : prefixes)
				imsiPrefixes.add(prefix);
		}
		return imsiPrefixes;
	}

	private boolean isVnmImsi(String imsi) {
		if (!StringUtils.hasText(imsi))
			return true;

		List<String> prefixes = getImsiPrefixes();
		for (String prefix : prefixes) {
			if (imsi.startsWith(prefix))
				return true;
		}
		return false;
	}

	@Override
	public boolean isVnmNumber(String msisdn) {
		if (!StringUtils.hasText(msisdn))
			return false;

		String regex = applicationConfigurationService.get("phonenumber.regex", AppDefaultValues.PHONE_NO_REGEX)
				.toString();
		boolean matches=true;
		/*boolean matches = msisdn.matches(regex);*/
		if (!matches) {
			LoggingUtil.debug(logger, "#isVnmSubscriber -- " + msisdn + " is not a valid VNM number!");
		}
		return matches;
	}

	private boolean sendMessage(String dest, String message) {
		String sender = applicationConfigurationService.get("smpp.defaultsender", "SELFCARE").toString();
		
		/*return smppServiceProvider.sendSMS(sender, dest, message, true, null, null);*/
		return sendsmsservice.sendSMS(sender, dest, message, true, null, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.SubscriberManagementService#
	 * confirmRegistration(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void activateSubscriber(String subscriberId, String otp)
			throws SubscriberNotFoundException, InvalidTokenException, Exception {

		LoggingUtil.debug(logger, String.format("#activateSubscriber >> about to activate subscriber %s with otp: %s",
				new Object[] { subscriberId, otp }));

		subscriberId = stripCountryCode(subscriberId);

		SubscriberEntity subscriber = subscriberRepository
				.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(subscriberId));
		LoggingUtil.debug(logger, "#activateSubscriber -- found subscriber= " + subscriber);

		if (subscriber == null)
			throw new SubscriberNotFoundException("SubscriberProfile " + subscriberId + " has not been registered!");

		OtpEntity otpe = otpRepository.findOne(QOtpEntity.otpEntity.subscriberId.eq(subscriberId));
		LoggingUtil.debug(logger, "#activateSubscriber -- checking against otp= " + otp);

		if (otpe == null)
			throw new InvalidTokenException(String.format("Token %s is not valid!", otp));

		// Totp only supports long/integer value for otp
		try {
			Long.parseLong(otp);
		} catch (NumberFormatException e) {
			throw new InvalidTokenException("Invalid token!");
		}

		// check if token is still valid
		if (!new Totp(otpe.getKey(), getOtpClock()).verify(otp)) {

			LoggingUtil.debug(logger, "#activateSubscriber -- invalid token or token has expired= " + otp);

			otpe.setStatus(TokenStatus.EXPIRED.ordinal());
			otpRepository.saveAndFlush(otpe);

			throw new InvalidTokenException(String.format("Token %s is not valid!", otp));
		}

		try {
			subscriber.setStatus(SubscriberStatus.ACTIVE.ordinal());
			subscriberRepository.saveAndFlush(subscriber);

			otpe.setStatus(TokenStatus.USED.ordinal());
			otpRepository.saveAndFlush(otpe);

			LoggingUtil.debug(logger,
					String.format("#activateSubscriber >> SubscriberProfile %s successfully activated.", subscriberId));
		} catch (Exception e) {
			logger.error("#activateSubscriber >> error when processing registration confirmation for subscriber= "
					+ subscriberId, e);
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.SubscriberManagementService#
	 * subscriberExists(java.lang.String)
	 */
	@Override
	public boolean isActiveSubscriber(String subscriberId) {
		subscriberId = stripCountryCode(subscriberId);

		long count = subscriberRepository.count(QSubscriberEntity.subscriberEntity.msisdn.eq(subscriberId)
				.and(QSubscriberEntity.subscriberEntity.status.eq(SubscriberStatus.ACTIVE.ordinal())));
		return count > 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.SubscriberManagementService#
	 * authenticate(java.lang.String, java.lang.String)
	 */
	@Override
	public void authenticated(String subscriberId, String credential, String remoteAddr)
			throws SubscriberNotFoundException, ExternalSubscriberException, PasswordMismatchException {
		if (!StringUtils.hasText(subscriberId) || !StringUtils.hasText(credential) || !isVnmNumber(subscriberId)) {

			logger.error("#authentication error --- " + subscriberId + " is not recognized!");
			throw new ExternalSubscriberException("ERROR: Number not recognized!");
		}

		subscriberId = stripCountryCode(subscriberId);

		// modified on 2017-07-06 to accommodate LMS functions
		SubscriberEntity subscriber = subscriberRepository
				.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(subscriberId));

		if (subscriber == null || subscriber.getStatus() != SubscriberStatus.ACTIVE.ordinal()) {
			logger.error("#authentication error --- " + subscriberId + " is not registered!");

			throw new SubscriberNotFoundException("Subscriber not registered!");
		} else {
			if (!subscriber.getCredential().equals(passwordEncoder.encode(credential))) {
				logger.error("#authentication error --- " + subscriberId + " password incorrect!");

				throw new PasswordMismatchException("Incorrect password!");
			}
		}

		try {
			Pageable pageable = new PageRequest(0, 1);

			Iterable<LoginHistoryEntity> list = loginHistoryRepository
					.findAll(QLoginHistoryEntity.loginHistoryEntity.msisdn.eq(subscriberId), pageable);

			if (list == null || !list.iterator().hasNext()) {
				// first time login -- send redeem point to LMS if eligible
				redeemLoyaltyPoint(subscriberId);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		updateLoginHistory(subscriberId, remoteAddr, ClientAppId.MOBILE_APP.name());
	}

	private void redeemLoyaltyPoint(String msisdn) {
		// search member_get_member table for this MSISDN
		// if referrer found, and this is MSISDN's first time login then redeem
		// loyalty point to LMS

		try {
			Iterable<MemberGetMemberEntity> list = memberGetMemberRepository.findAll(
					QMemberGetMemberEntity.memberGetMemberEntity.invidtedMsisdn.eq(msisdn)
							.and(QMemberGetMemberEntity.memberGetMemberEntity.activationDate.isNull()),
					QMemberGetMemberEntity.memberGetMemberEntity.createTimestamp.asc());

			if (list != null && list.iterator().hasNext()) {

				double referrerPoint = Double.parseDouble(
						applicationConfigurationService.get("membergetmember.rewardpoint.sender", "10").toString());
				double memberPoint = Double.parseDouble(
						applicationConfigurationService.get("membergetmember.rewardpoint.invited", "10").toString());

				MemberGetMemberEntity mgm = list.iterator().next();
				final String referrer = mgm.getMsisdn();

				// update registered_date
				mgm.setActivationDate(new Date());
				mgm.setActivatedFlag(1);

				memberGetMemberRepository.save(mgm);

				taskExecutor.submit(new Runnable() {

					@Override
					public void run() {
						backEndRequestProcessor.redeemLmsPoint(referrer, LMSAdapter.ADD_POINT_KEYWORD, referrerPoint);
					}
				});

				taskExecutor.submit(new Runnable() {

					@Override
					public void run() {
						backEndRequestProcessor.redeemLmsPoint(msisdn, LMSAdapter.ADD_POINT_KEYWORD, memberPoint);
					}
				});

			}

		} catch (Exception e) {
			logger.error("#redeemLoyaltyPoint --- " + msisdn + ", error when sending request to LMS!", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.SubscriberManagementService#
	 * instantLogin(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean instantLogin(String subscriberId, String credential) {

		subscriberId = stripCountryCode(subscriberId);

		String encodedPasswd = passwordEncoder.encode(credential);
		long count = subscriberRepository.count(QSubscriberEntity.subscriberEntity.msisdn.eq(subscriberId)
				.and(QSubscriberEntity.subscriberEntity.credential.eq(encodedPasswd))
				.and(QSubscriberEntity.subscriberEntity.status.eq(SubscriberStatus.ACTIVE.ordinal())));

		return count > 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.SubscriberManagementService#
	 * changePassword(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void changePassword(String subscriberId, String oldPassword, String newPassword)
			throws SubscriberNotFoundException, PasswordMismatchException, InvalidPasswordFormatException {

		subscriberId = stripCountryCode(subscriberId);

		SubscriberEntity subscriber = subscriberRepository
				.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(subscriberId));
		if (subscriber == null)
			throw new SubscriberNotFoundException("SubscriberProfile " + subscriberId + " does not exist!");

		if (!passwordEncoder.encode(oldPassword).equals(subscriber.getCredential()))
			throw new PasswordMismatchException("Password missmatch!");

		String regex = applicationConfigurationService.get("security.password.regex", "((?=.*\\d)(?=.*[a-zA-Z]).{8,})")
				.toString();
		LoggingUtil.debug(logger, "#changePassword --- regex= " + regex);

		if (!Pattern.matches(regex, newPassword))
			throw new InvalidPasswordFormatException("Invalid password format!");

		try {
			subscriber.setCredential(passwordEncoder.encode(newPassword));
			subscriberRepository.saveAndFlush(subscriber);
		} catch (Exception e) {
			logger.error("#changePassword >> error when updating password of subscriber= " + subscriberId, e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.SubscriberManagementService#
	 * resetPassword(java.lang.String, java.lang.String)
	 */
	@Override
	public void resetPassword(String subscriberId) throws SubscriberNotFoundException, Exception {

		subscriberId = stripCountryCode(subscriberId);

		SubscriberEntity subscriber = subscriberRepository
				.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(subscriberId));
		if (subscriber == null)
			throw new SubscriberNotFoundException("SubscriberProfile " + subscriberId + " does not exist!");

		int passwdLength = Integer.parseInt(applicationConfigurationService
				.get("security.password.minlength", AppDefaultValues.MIN_PASSWORD_LENGTH).toString());
		String passwd = RandomStringUtils.randomAlphanumeric(passwdLength); // new
																			// RandomString(passwdLength).nextString();

		subscriber.setCredential(passwordEncoder.encode(passwd));
		subscriberRepository.saveAndFlush(subscriber);

		Locale locale = new Locale.Builder().setLanguage(subscriber.getLanguageCode()).build();
		String message = messageSource.getMessage("Message.NewPasswordNotification", new String[] { passwd }, passwd,
				locale);

		sendMessage(subscriberId, message);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.SubscriberManagementService#
	 * resetPassword(java.lang.String, java.lang.String)
	 */
	@Override
	public void resetPassword(String subscriberId, String password, String otp) throws ExternalSubscriberException,
			SubscriberNotFoundException, InvalidTokenException, InvalidPasswordFormatException, Exception {

		if (!StringUtils.hasText(password))
			throw new InvalidPasswordFormatException("Invalid password format!");
		if (!StringUtils.hasText(otp)){
			invalidOtp(subscriberId);
			throw new InvalidTokenException("Invalid token!");
		}
		if (!otp.matches("\\d+")) {
			// token must be numeric value
			invalidOtp(subscriberId);
			throw new InvalidTokenException(String.format("Token %s is not valid!", otp));
		}

		if (!isVnmNumber(subscriberId))
			throw new ExternalSubscriberException("ERROR: Number not recognized!");

		subscriberId = stripCountryCode(subscriberId);

		SubscriberEntity subscriber = subscriberRepository
				.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(subscriberId));
		if (subscriber == null)
			throw new SubscriberNotFoundException("SubscriberProfile " + subscriberId + " does not exist!");

		OtpEntity otpe = otpRepository.findOne(QOtpEntity.otpEntity.subscriberId.eq(subscriberId));
		if (otpe == null)
			throw new InvalidTokenException(String.format("Token %s is not valid!", otp));

		// check if token is still valid
		if (!new Totp(otpe.getKey(), getOtpClock()).verify(otp)) {
			otpe.setStatus(TokenStatus.EXPIRED.ordinal());
			otpRepository.saveAndFlush(otpe);
			invalidOtp(subscriberId);
			throw new InvalidTokenException("Submitted token has expired: " + otp);
		}

		String regex = applicationConfigurationService.get("security.password.regex", "((?=.*\\d)(?=.*[a-zA-Z]).{8,})")
				.toString();
		// LoggingUtil.debug(logger, "#resetPassword --- regex= " + regex + ",
		// passwd= " + password);

		if (!Pattern.matches(regex, password))
			throw new InvalidPasswordFormatException("Invalid password format!");

		try {
			subscriber.setCredential(passwordEncoder.encode(password));
			subscriberRepository.saveAndFlush(subscriber);

			otpe.setStatus(TokenStatus.USED.ordinal());
			otpRepository.saveAndFlush(otpe);

		} catch (Exception e) {
			logger.error("#changePassword >> error when updating password of subscriber= " + subscriberId, e);
			throw e;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.SubscriberManagementService#
	 * changeEmailAddress(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void changeEmailAddress(String subscriberId, String oldEmailAddress, String newEmailAddress)
			throws SubscriberNotFoundException, EmailAddressNotRegisteredException {

		subscriberId = stripCountryCode(subscriberId);

		SubscriberEntity subscriber = subscriberRepository
				.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(subscriberId));
		if (subscriber == null)
			throw new SubscriberNotFoundException("SubscriberProfile " + subscriberId + " does not exist!");

		String emailAddr = subscriber.getEmailAddress();
		if (StringUtils.hasLength(emailAddr) && !emailAddr.equalsIgnoreCase(oldEmailAddress))
			throw new EmailAddressNotRegisteredException("Email address not valid!");

		try {
			subscriber.setEmailAddress(newEmailAddress);
			subscriberRepository.saveAndFlush(subscriber);
		} catch (Exception e) {
			logger.error("#changeEmailAddress >> error when updating email address of subscriber= " + subscriberId, e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.SubscriberManagementService#
	 * changeEmailAddress(java.lang.String, java.lang.String)
	 */
	@Override
	public void changeEmailAddress(String subscriberId, String newEmailAddress) throws SubscriberNotFoundException {

		subscriberId = stripCountryCode(subscriberId);

		SubscriberEntity subscriber = subscriberRepository
				.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(subscriberId));
		if (subscriber == null)
			throw new SubscriberNotFoundException("SubscriberProfile " + subscriberId + " does not exist!");

		try {
			subscriber.setEmailAddress(newEmailAddress);
			subscriberRepository.saveAndFlush(subscriber);
		} catch (Exception e) {
			logger.error("#changeEmailAddress >> error when updating email address of subscriber= " + subscriberId, e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.SubscriberManagementService#
	 * changeLanguage(java.lang.String, java.lang.String)
	 */
	@Override
	public void changeLanguage(String subscriberId, String languageCode) throws SubscriberNotFoundException {

		subscriberId = stripCountryCode(subscriberId);

		SubscriberEntity subscriber = subscriberRepository
				.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(subscriberId));
		if (subscriber == null)
			throw new SubscriberNotFoundException("SubscriberProfile " + subscriberId + " does not exist!");

		try {
			subscriber.setLanguageCode(languageCode);
			subscriberRepository.saveAndFlush(subscriber);
		} catch (Exception e) {
			logger.error("#changePassword >> error when updating language of subscriber= " + subscriberId, e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.SubscriberManagementService#
	 * changeGender(java.lang.String, int)
	 */
	@Override
	public void changeGender(String subscriberId, int genderId) throws SubscriberNotFoundException {

		subscriberId = stripCountryCode(subscriberId);

		SubscriberEntity subscriber = subscriberRepository
				.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(subscriberId));
		if (subscriber == null)
			throw new SubscriberNotFoundException("SubscriberProfile " + subscriberId + " does not exist!");

		try {
			if (subscriber.getDetails() != null) {
				subscriber.getDetails().setGender(genderId);
			} else {
				SubscriberDetailEntity detail = new SubscriberDetailEntity();
				detail.setGender(genderId);
				detail.setSubscriber(subscriber);
				subscriber.setDetails(detail);
			}
			subscriberRepository.saveAndFlush(subscriber);
		} catch (Exception e) {
			logger.error("#changePassword >> error when updating language of subscriber= " + subscriberId, e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gnv.vnm.selfcare.core.service.SubscriberManagementService#generateOTP
	 * ()
	 */
	@Override
	public String generateOTP(String subscriberId, boolean notifySubscriber, String langCode)
			throws ExternalSubscriberException {
		if (!StringUtils.hasText(subscriberId))
			return null;

		if (!isVnmNumber(subscriberId))
			throw new ExternalSubscriberException("ERROR: Number not recognized!");
		subscriberId = stripCountryCode(subscriberId);
		LoggingUtil.debug(logger, String.format("#generateOTP >> subscriberId  generated OTP ", ""));
		try {
			String key = Base32.random();
			String token = new Totp(key, getOtpClock()).now();

			OtpEntity otpe = otpRepository.findOne(QOtpEntity.otpEntity.subscriberId.eq(subscriberId));
			if (otpe == null) {
				otpe = new OtpEntity(subscriberId, key, TokenStatus.UNUSED.ordinal());
			} else {
				otpe.setKey(key);
				otpe.setStatus(TokenStatus.UNUSED.ordinal());
			}
			otpRepository.save(otpe);

			LoggingUtil.debug(logger, String.format("#generateOTP >> generated OTP= %s for subscriberId= %s",
					new Object[] { token, subscriberId }));

			// send OTP to subscriber
			if (notifySubscriber) {
				LoggingUtil.debug(logger, String.format("#generateOTP >> notifySubscriber  generated OTP ", ""));
				Locale locale = new Locale(applicationConfigurationService.getDefaultLanguageCode()); // new
																										// Locale(AppDefaultValues.LANGUAGE_VIETNAMESE);
				if (StringUtils.hasText(langCode)) {
					locale = new Locale(langCode);

				} else {
					try {
						SubscriberEntity subscriber = this.subscriberRepository
								.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(subscriberId));
						if (subscriber != null) {
							locale = new Locale(subscriber.getLanguageCode());
						}
					} catch (Exception e) {
					}
				}

				String message = SpringUtils.resolveMessage(messageSource, "Message.sms.OTP", new String[] { token },
						String.format(DefaultBackendMessage.OTP_REQUEST_SUCCESS.getMessage(), token), locale);

				sendMessage(subscriberId, message);
			}

			return token;
		} catch (Exception e) {
			logger.error("#generateOTP >> error occured when generating OTP!", e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gnv.vnm.selfcare.core.service.SubscriberManagementService#sendOTP(
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public boolean sendOTP(String subscriberId, String otp) {

		subscriberId = stripCountryCode(subscriberId);

		// get subscriber's language to send the correct message
		Locale locale = new Locale(applicationConfigurationService.getDefaultLanguageCode()); // new
																								// Locale(AppDefaultValues.LANGUAGE_VIETNAMESE);
		try {
			SubscriberEntity subscriber = this.subscriberRepository
					.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(subscriberId));
			if (subscriber != null && StringUtils.hasText(subscriber.getLanguageCode())) {
				locale = new Locale(subscriber.getLanguageCode());
			}
		} catch (Exception e) {
		}

		String message = SpringUtils.resolveMessage(messageSource, "Message.sms.OTP", new String[] { otp },
				String.format(DefaultBackendMessage.OTP_REQUEST_SUCCESS.getMessage(), otp), locale);

		sendMessage(subscriberId, message);

		return true;
	}

	private int getTokenExpiryTime() {
		return Integer.parseInt(applicationConfigurationService
				.get("otp.expirytime.minutes", "" + AppDefaultValues.TOKEN_EXP_IN_MINUTES).toString());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gnv.vnm.selfcare.core.service.SubscriberManagementService#validateOTP
	 * (java.lang.String, java.lang.String)
	 */
	@Override
	public boolean isValidOTP(String token, String subscriberId) {
		if (!StringUtils.hasText(token) || !StringUtils.hasText(subscriberId))
			return false;

		subscriberId = stripCountryCode(subscriberId);

		boolean valid = false;
		try {
			OtpEntity otpe = otpRepository.findOne(QOtpEntity.otpEntity.subscriberId.eq(subscriberId));
			if (otpe != null) {
				valid = new Totp(otpe.getKey(), getOtpClock()).verify(token);
				if (valid) {
					otpe.setStatus(TokenStatus.USED.ordinal());
				} else {
					otpe.setStatus(TokenStatus.EXPIRED.ordinal());
				}
				otpRepository.saveAndFlush(otpe);

				/*
				 * if (otpe.getStatus() == TokenStatus.UNUSED.ordinal()){ valid
				 * = new Totp(otpe.getKey(), getOtpClock()).verify(token); if
				 * (valid){ otpe.setStatus(TokenStatus.USED.ordinal()); }else{
				 * otpe.setStatus(TokenStatus.EXPIRED.ordinal()); }
				 * otpRepository.saveAndFlush(otpe);
				 * 
				 * return valid; }
				 */
			}

		} catch (Exception e) {
			logger.error("#isValidOTP >> error occured when validating OTP", e);
		}
		return valid;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.SubscriberManagementService#
	 * updateLoginHistory(java.lang.String, java.lang.String)
	 */
	@Override
	public void updateLoginHistory(String subscriberId, String remoteAddress, String clientAppId) {
		try {
			loginHistoryRepository
					.saveAndFlush(new LoginHistoryEntity(subscriberId, new Date(), remoteAddress, clientAppId));
		} catch (Exception e) {
			logger.error("#updateLoginHistory >> error when creating login history for MSISDN= " + subscriberId, e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.SubscriberManagementService#
	 * getSubscriberProfile(java.lang.String)
	 */
	@Override
	public SubscriberProfile getSubscriberProfile(String subscriberId, boolean withHistory) {

		subscriberId = stripCountryCode(subscriberId);

		try {
			SubscriberEntity sub = subscriberRepository
					.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(subscriberId));
			if (sub != null) {
				SubscriberProfile subscriberProfile = new SubscriberProfile(sub.getId(), sub.getMsisdn(), sub.getImsi(),
						sub.getImei(), sub.getEmailAddress(), SubscriberType.fromInt(sub.getType()),
						SubscriberStatus.fromInt(sub.getStatus()));
				subscriberProfile.setPreferredLanguage(sub.getLanguageCode());
				subscriberProfile.setCredential(sub.getCredential());

				Avatar avatar = avatarService.getSubscriberAvatar(subscriberId);
				if (avatar != null) {
					subscriberProfile.setAvatar(avatar.getImageURL());
				}

				SubscriberDetailEntity details = sub.getDetails();
				SubscriberDetails dtl = null;
				if (details != null) {
					dtl = new SubscriberDetails(eposDbClient.getSubscriberName(subscriberId),
							Gender.valueOf(details.getGender()), details.getBirthDate(), details.getAvatar(),
							details.getAddress1(), details.getAddress2(), details.getAddress3(), null,
							details.getZipCode(), details.getOccupation(), details.getCompanyName());

					// if (!StringUtils.hasText(dtl.getFullName()))
					// dtl.setFullName(eposDbClient.getSubscriberName(subscriberId));
				} else {
					dtl = new SubscriberDetails();
					dtl.setFullName(eposDbClient.getSubscriberName(subscriberId));
				}

				if (!StringUtils.hasText(dtl.getFullName()))
					dtl.setFullName(subscriberProfile.getMsisdn());

				subscriberProfile.setDetails(dtl);

				// subscriberProfile.setClassOfServiceName(basicAccount.getCosDisplayName());
				// UPDATED 20180125
				BasicAccount basicAccount = backEndRequestProcessor.getBasicAccount(subscriberId);
				String simname = basicAccount.getCosDisplayName();

				// check null by Oneclick
				if ((simname != null) && (simname.equalsIgnoreCase("Thanh_2"))) {
					subscriberProfile.setClassOfServiceName("SIEU THANH SIM");
				} else {
					subscriberProfile.setClassOfServiceName(basicAccount.getCosDisplayName());
				}

				subscriberProfile.setType(basicAccount.getType());

				// commented-out for testing purpose only
				// TODO remove comment when done

				String smsRoamingPkgId = applicationConfigurationService.get("postpaid.packageid.irsms", "1000006")
						.toString();
				String voiceRoamingPkgId = applicationConfigurationService.get("postpaid.packageid.irvoice", "20000100")
						.toString();
				;

				boolean roamingEnabled = false;
				List<PackageSubscription> subscriptions = getSubscribedPackages(subscriberId, sub.getLanguageCode());
				subscriberProfile.setSubscriptions(subscriptions);

				if (subscriptions != null) {
					for (PackageSubscription pkg : subscriptions) {
						String code = pkg.getProduct().getCode();
						if (code.equals(smsRoamingPkgId) || code.equals(voiceRoamingPkgId)) {
							roamingEnabled = true;
						}
					}
				}
				subscriberProfile.setRoamingEnabled(roamingEnabled);

				// subscriberProfile.setRoamingEnabled(true);

				/*if (subscriberProfile.getType() != null
						&& subscriberProfile.getType().equals(SubscriberType.POSTPAID)) {
					Calendar start = Calendar.getInstance();
					start.add(Calendar.MONTH, -3);

					subscriberProfile.setBillingHistory(
							tibcoServiceProvider.getBillingHistory(subscriberId, start.getTime(), new Date()));
				}*/
				
				if (subscriberProfile.getType() != null && subscriberProfile.getType().equals(SubscriberType.POSTPAID)) {

					Calendar start = Calendar.getInstance();
					start.add(Calendar.MONTH, -4);

					Calendar end = Calendar.getInstance();
					end.add(Calendar.MONTH, -1);

					subscriberProfile.setBillingHistory(tibcoServiceProvider.getBillingHistory(subscriberId, start.getTime(), end.getTime()));
					}

				if (withHistory) {
					Calendar today = Calendar.getInstance();
					today.set(Calendar.HOUR, 0);
					today.set(Calendar.MINUTE, 0);
					today.set(Calendar.SECOND, 0);

					CurrentBalance currentBalance = backEndRequestProcessor
							.getCurrentBalance(subscriberProfile.getMsisdn(), sub.getLanguageCode());

					if (subscriberProfile.getType() != null
							&& subscriberProfile.getType().equals(SubscriberType.POSTPAID)) {
						currentBalance
								.setOutstandingBalance(tibcoServiceProvider.getCurrentOutstandingBalance(subscriberId));
						currentBalance.setUnbilledBalance(tibcoServiceProvider.getUnbilledBalanceSummary(subscriberId));
						currentBalance.setDepositBalance(tibcoServiceProvider.getDepositBalance(subscriberId));
					}

					subscriberProfile.setCurrentBalance(currentBalance);

					subscriberProfile.setCallHistory(backEndRequestProcessor
							.getCallHistory(subscriberProfile.getMsisdn(), today.getTime(), new Date()));
					subscriberProfile.setSmsHistory(
							backEndRequestProcessor.getSmsHistory(subscriberId, today.getTime(), new Date()));
				}
				// String micStatus =
				// micInformationService.getDevMicStatus(subscriberProfile.getMsisdn());
				String micStatus = "";
				if (mode.equalsIgnoreCase("test")) {
					micStatus = micInformationService.getDevMicStatus(subscriberProfile.getMsisdn());
				} else {
					micStatus = micInformationService.getMicStatus(subscriberProfile.getMsisdn());

				}
				subscriberProfile.setMicUploadStatus(Integer.parseInt(micStatus));
				int subcount = backEndRequestProcessor
						.getSubscribedPackages(subscriberProfile.getMsisdn(), null, sub.getLanguageCode()).size();
				subscriberProfile.setSubscriptionCount(subcount);
				// logger.debug("#SubscriptionCount >> = " + subcount);
				subscriberProfile.setDisabledAppFeatures(getDisabledAppFeatures(basicAccount.getCos()));
				return subscriberProfile;
			}
		} catch (Exception e) {
			logger.error("#getSubscriberProfile >> error when getting subscriber details= " + subscriberId, e);
		}
		return null;
	}

	private List<String> getDisabledAppFeatures(String cos) {
		List<String> appFeatures = new ArrayList<>();
		if (cos == null)
			return appFeatures;

		try {
			Iterable<CosAppFeatureMappingsEntity> list = cosAppFeatureMappingRepository
					.findAll(QCosAppFeatureMappingsEntity.cosAppFeatureMappingsEntity.cosName.isNotNull().and(
							QCosAppFeatureMappingsEntity.cosAppFeatureMappingsEntity.cosName.equalsIgnoreCase(cos)));

			if (list != null) {
				for (CosAppFeatureMappingsEntity map : list) {
					appFeatures.add(map.getDisabledFeatureName());
				}
			}
		} catch (Exception e) {
			logger.error("#getDisabledAppFeatures --- error retrieving cos_app_features mappings", e);
		}
		return appFeatures;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.SubscriberManagementService#
	 * updateSubscriberProfile(com.gnv.vnm.selfcare.core.model.
	 * SubscriberProfile)
	 */
	@Override
	public void updateSubscriberProfile(SubscriberProfile subscriberProfile) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.SubscriberManagementService#
	 * getTransactionHistory(java.lang.String, java.util.Date, java.util.Date)
	 */
	@Override
	public List<TransactionHistory> getTransactionHistory(String subscriberId, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.SubscriberManagementService#
	 * getSubscribedPackages(java.lang.String)
	 */
	@Override
	public List<PackageSubscription> getSubscribedPackages(String subscriberId, String langCode) {
		return backEndRequestProcessor.getSubscribedPackages(subscriberId, null, langCode);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.SubscriberManagementService#
	 * getPackageSubscriptionDetails(java.lang.String, java.lang.String)
	 */
	@Override
	public PackageSubscription getPackageSubscriptionDetails(String subscriberId, String packageId) {
		return backEndRequestProcessor.getPackageSubscriptionDetails(subscriberId, packageId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.SubscriberManagementService#
	 * getPackageSubscriptionStatus(java.lang.String, java.lang.String)
	 */
	@Override
	public SubscriptionStatus getPackageSubscriptionStatus(String subscriberId, String packageId) {
		return backEndRequestProcessor.getPackageSubscriptionStatus(subscriberId, packageId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.SubscriberManagementService#
	 * inviteMembers(java.lang.String, java.util.List)
	 */
	@Override
	public void inviteMembers(String subscriberId, List<String> invitedNumbers) throws SubscriberNotFoundException {

		LoggingUtil.debug(logger, "#inviteMembers --- " + subscriberId + ", invited= " + invitedNumbers);
		if (invitedNumbers == null)
			return;

		subscriberId = stripCountryCode(subscriberId);

		if (!isActiveSubscriber(subscriberId))
			throw new SubscriberNotFoundException("Subscriber not found or not active: " + subscriberId);

		String sender = applicationConfigurationService.get("smpp.defaultsender", "SELFCARE").toString();
		String message = null;
		Locale vietnamese = new Locale(applicationConfigurationService.getDefaultLanguageCode()); // new
																									// Locale(AppDefaultValues.LANGUAGE_VIETNAMESE);
		GeneralDataCoding dataCoding = new GeneralDataCoding(Alphabet.ALPHA_DEFAULT);
		String charset = "UTF-8";
		for (String number : invitedNumbers) {

			try {
				if (StringUtils.hasText(number)) {
					memberGetMemberRepository.save(new MemberGetMemberEntity(subscriberId, number));

					// Subscriber {0} invite you to download MyVietnamobile app
					// (FREE) at http://vietnamobile.com.vn/seftcare. Thank you!
					message = SpringUtils.resolveMessage(messageSource, "Message.mgm.invitation",
							new String[] { number },
							String.format(
									"Thue bao %s moi ban tai ung dung MyVietnamobile (MIEN PHI) tai http://vietnamobile.com.vn/selfcare. Tran trong!",
									number),
							vietnamese);
					sendsmsservice.sendSMS(sender,
							AppUtils.prependCountryCodeToMsisdn(number,
									applicationConfigurationService.getDefaultCountryCode()),
							message, false, dataCoding, charset);

					// disable English SMS notif as requested by Trung
					// (16-11-2017)
					/*
					 * message = SpringUtils.resolveMessage(messageSource,
					 * "Message.mgm.invitation", new String[] { number },
					 * String.format(
					 * "Subscriber %s invite you to download MyVietnamobile app (FREE) at http://vietnamobile.com.vn/seftcare. Thank you!"
					 * , number), Locale.ENGLISH);
					 * smppServiceProvider.sendSMS(sender,
					 * AppUtils.prependCountryCodeToMsisdn(number,
					 * applicationConfigurationService.getDefaultCountryCode()),
					 * message, false, dataCoding, charset);
					 */
				}
			} catch (Exception e) {
				logger.error("#inviteMembers --- error processing invitation to number " + number);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.SubscriberManagementService#
	 * storeUserToken(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean storeFcmToken(String msisdn, String token, String osType) {
		LoggingUtil.debug(logger,
				String.format("#storeFcmToken -- create/update FCM token (msisdn= %s, token= %s)", msisdn, token));
		try {
			FcmTokenEntity entity = fcmTokenRepository.findOne(QFcmTokenEntity.fcmTokenEntity.msisdn.eq(msisdn));
			if (entity == null) {
				entity = new FcmTokenEntity();
				entity.setMsisdn(msisdn);
			}
			entity.setToken(token);
			entity.setOsType(osType);
			fcmTokenRepository.saveAndFlush(entity);

			return true;
		} catch (Exception e) {
			logger.error("#storeFcmToken --- error creating/updating FCM token for MSISDN " + msisdn, e);
			return false;
		}
	}

	@Override
	public Simname getSimname(String msisdn) {
		// TODO Auto-generated method stub
		Simname simname = new Simname();
		BasicAccount basicAccount = backEndRequestProcessor.getBasicAccount(msisdn);
		String simnamevalue = basicAccount.getCosDisplayName();

		// check null by Oneclick
		if ((simnamevalue != null) && (simnamevalue.equalsIgnoreCase("Thanh_2"))) {
			simname.setClassOfServiceName("SIEU THANH SIM");
		} else {
			simname.setClassOfServiceName(basicAccount.getCosDisplayName());
		}

		simname.setType(basicAccount.getType());
		simname.setMsisdn(msisdn);
		if (basicAccount.getCos() != null) {
			simname.setDisabledAppFeatures(getDisabledAppFeatures(basicAccount.getCos()));

		}
		return simname;
	}

	@Override
	public List<PackageSubscription> getPackage(String msisdn, String langcode) {
		// TODO Auto-generated method stub
		boolean roamingEnabled = false;
		SubscriptionDeaitls subscriptionDeaitls = new SubscriptionDeaitls();
		String smsRoamingPkgId = applicationConfigurationService.get("postpaid.packageid.irsms", "1000006").toString();
		String voiceRoamingPkgId = applicationConfigurationService.get("postpaid.packageid.irvoice", "20000100")
				.toString();
		;

		List<PackageSubscription> subscriptions = getSubscribedPackages(msisdn, langcode);
		subscriptionDeaitls.setSubscriptions(subscriptions);

		if (subscriptions != null) {
			for (PackageSubscription pkg : subscriptions) {
				String code = pkg.getProduct().getCode();
				if (code.equals(smsRoamingPkgId) || code.equals(voiceRoamingPkgId)) {
					roamingEnabled = true;
				}
			}
			int subcount = subscriptions.size();
			subscriptionDeaitls.setSubscriptionCount(subcount);
		}
		subscriptionDeaitls.setSoamingEnabled(roamingEnabled);
		return subscriptions;
	}

	@Override
	public CurrentBalance getBlanceDetails(String msisdn, String langcode) {
		// TODO Auto-generated method stub
		CurrentBalance currentBalance = backEndRequestProcessor.getCurrentBalance(msisdn, langcode);

		return currentBalance;
	}

	@Override
	public boolean validateuser(String msisdn) {
		// TODO Auto-generated method stub
		boolean validuser = false;
		SubscriberEntity sub = subscriberRepository.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(msisdn));

		if (sub != null) {
			validuser = true;
		} else {
			validuser = false;
		}

		return validuser;
	}

	@Override
	public SubscriberProfilenew getSubscriberProfilenew(String subscriberId, boolean withHistory) {

		subscriberId = stripCountryCode(subscriberId);

		try {
			SubscriberEntity sub = subscriberRepository
					.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(subscriberId));
			if (sub != null) {
				SubscriberProfilenew subscriberProfile = new SubscriberProfilenew(sub.getId(), sub.getMsisdn(),
						sub.getImsi(), sub.getImei(), sub.getEmailAddress(), SubscriberType.fromInt(sub.getType()),
						SubscriberStatus.fromInt(sub.getStatus()));
				subscriberProfile.setPreferredLanguage(sub.getLanguageCode());
				subscriberProfile.setCredential(sub.getCredential());

				Avatar avatar = avatarService.getSubscriberAvatar(subscriberId);
				if (avatar != null) {
					subscriberProfile.setAvatar(avatar.getImageURL());
				}
				/// change in Api
				// epos details
				SubscriberDetailEntity details = sub.getDetails();
				SubscriberDetails dtl = null;
				if (details != null) {
					dtl = new SubscriberDetails(eposDbClient.getSubscriberName(subscriberId),
							Gender.valueOf(details.getGender()), details.getBirthDate(), details.getAvatar(),
							details.getAddress1(), details.getAddress2(), details.getAddress3(), null,
							details.getZipCode(), details.getOccupation(), details.getCompanyName());
					/*
					 * dtl = new SubscriberDetails("test",
					 * Gender.valueOf(details.getGender()),
					 * details.getBirthDate(), details.getAvatar(),
					 * details.getAddress1(), details.getAddress2(),
					 * details.getAddress3(), null, details.getZipCode(),
					 * details.getOccupation(), details.getCompanyName());
					 */

				} else {
					dtl = new SubscriberDetails();
					// dtl.setFullName("test");
					dtl.setFullName(eposDbClient.getSubscriberName(subscriberId));
				}

				if (!StringUtils.hasText(dtl.getFullName()))
					dtl.setFullName(subscriberProfile.getMsisdn());

				subscriberProfile.setDetails(dtl);

				if (withHistory) {
					Calendar today = Calendar.getInstance();
					today.set(Calendar.HOUR, 0);
					today.set(Calendar.MINUTE, 0);
					today.set(Calendar.SECOND, 0);

				}
				String micStatus = "";
				if (mode.equalsIgnoreCase("test")) {
					micStatus = micInformationService.getDevMicStatus(subscriberProfile.getMsisdn());
				} else {
					micStatus = micInformationService.getMicStatus(subscriberProfile.getMsisdn());

				}
				subscriberProfile.setMicUploadStatus(Integer.parseInt(micStatus));

				return subscriberProfile;
			}
		} catch (Exception e) {
			logger.error("#getSubscriberProfile >> error when getting subscriber details= " + subscriberId, e);
		}
		return null;
	}

	@Override
	public SubscriberProfilenew getSubscriberProfileCheck(String subscriberId, boolean withHistory) {
		// TODO Auto-generated method stub
		subscriberId = stripCountryCode(subscriberId);
		return null;
	}

	@Override
	public String generateOTPnew(String subscriberId, boolean notifySubscriber, String langCode)
			throws ExternalSubscriberException {
		System.out.println("generateOTPnew");
		if (!StringUtils.hasText(subscriberId))
			return null;

		if (!isVnmNumber(subscriberId))
			throw new ExternalSubscriberException("ERROR: Number not recognized!");
		subscriberId = stripCountryCode(subscriberId);
		LoggingUtil.debug(logger, String.format("#generateOTP >> subscriberId generated OTP ", ""));
		try {
			String key = Base32.random();
			String token = new Totp(key, getOtpClock()).now();

			OtpEntity otpe = otpRepository.findOne(QOtpEntity.otpEntity.subscriberId.eq(subscriberId));
			if (otpe == null) {
				otpe = new OtpEntity(subscriberId, key, TokenStatus.UNUSED.ordinal());
			} else {
				otpe.setKey(key);
				otpe.setStatus(TokenStatus.UNUSED.ordinal());
			}
			otpRepository.save(otpe);

			LoggingUtil.debug(logger, String.format("#generateOTP >> generated OTP= %s for subscriberId= %s",
					new Object[] { token, subscriberId }));

			// send OTP to subscriber
			if (notifySubscriber) {
				LoggingUtil.debug(logger, String.format("#generateOTP >> notifySubscriber generated OTP ", ""));
				Locale locale = new Locale(applicationConfigurationService.getDefaultLanguageCode()); // new
				// Locale(AppDefaultValues.LANGUAGE_VIETNAMESE);
				if (StringUtils.hasText(langCode)) {
					locale = new Locale(langCode);

				} else {
					try {
						SubscriberEntity subscriber = this.subscriberRepository
								.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(subscriberId));
						if (subscriber != null) {
							locale = new Locale(subscriber.getLanguageCode());
						}
					} catch (Exception e) {
					}
				}

				String message = SpringUtils.resolveMessage(messageSource, "Message.sms.OTP", new String[] { token },

						String.format(DefaultBackendMessage.OTP_REQUEST_SUCCESS.getMessage(), token), locale);
				sendMessagenew(subscriberId, message);
			}

			return token;
		} catch (Exception e) {
			logger.error("#generateOTP >> error occured when generating OTP!", e);
		}
		return null;
	}

	private boolean sendMessagenew(String dest, String message) {
		String sender = applicationConfigurationService.get("smpp.defaultsender", "SELFCARE").toString();
		return sendsmsservice.sendSMS(sender, dest, message, true, null, null);
	}
	
	public void invalidOtp(String msisdn){
	       
        System.out.println("In msgId fail " + msisdn);
        System.out.println("msisidn " + msisdn);
        OtpStatusEntity otpStatusEntity = otpstatusRepository
                     .findOne(QOtpStatusEntity.otpStatusEntity.msisdn.eq(msisdn));
        System.out.println("entity from msisdn " + otpStatusEntity);
        if (otpStatusEntity != null) {
               System.out.println("if otpstatus not null");
               System.out.println("fc drd " + otpStatusEntity.getFailCount());
               int failCount = otpStatusEntity.getFailCount();
               System.out.println("fc" + failCount);
               if (failCount >= 0) {
                     failCount++;
                     otpStatusEntity.setFailCount(failCount);
               } else {
                     otpStatusEntity.setFailCount(0);
               }
               otpStatusEntity.setId(otpStatusEntity.getId());
               otpstatusRepository.save(otpStatusEntity);
        }

 
 }
	@Override
	public SubscriptionStatus getIntlRoamingStatus(String msisdn) {
		String intlRoamingPkgId = applicationConfigurationService.get("postpaid.packageid.intlroaming", "1000006", false).toString(); 
		
		return backEndRequestProcessor.getPackageSubscriptionStatus(msisdn, intlRoamingPkgId);
	}
	
	@Override
	public SubscriberProfile getSubscriberProfile(String subscriberId, boolean includeDetails, String langCode){
		
		subscriberId = stripCountryCode(subscriberId);
		
		try {
			SubscriberEntity sub = subscriberRepository.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(subscriberId));
			if (sub != null){
				SubscriberProfile subscriberProfile = new SubscriberProfile(sub.getId(), sub.getMsisdn(), sub.getImsi(), sub.getImei(), sub.getEmailAddress(),
						SubscriberType.fromInt(sub.getType()), SubscriberStatus.fromInt(sub.getStatus()));
				subscriberProfile.setPreferredLanguage(sub.getLanguageCode());
				subscriberProfile.setCredential(sub.getCredential());

				Avatar avatar = avatarService.getSubscriberAvatar(subscriberId);
				if (avatar != null){
					subscriberProfile.setAvatar(avatar.getImageURL());
				}

				SubscriberDetailEntity details = sub.getDetails();
				SubscriberDetails dtl = null;
				if (details != null){
					dtl = new SubscriberDetails(eposDbClient.getSubscriberName(subscriberId), 
							Gender.valueOf(details.getGender()),
							details.getBirthDate(), details.getAvatar(), details.getAddress1(), details.getAddress2(),
							details.getAddress3(), null, details.getZipCode(), details.getOccupation(), details.getCompanyName());

//					if (!StringUtils.hasText(dtl.getFullName())) dtl.setFullName(eposDbClient.getSubscriberName(subscriberId));
				}else{
					dtl = new SubscriberDetails();
					dtl.setFullName(eposDbClient.getSubscriberName(subscriberId));
				}

				if (!StringUtils.hasText(dtl.getFullName())) dtl.setFullName(subscriberProfile.getMsisdn());

				subscriberProfile.setDetails(dtl);
				
				//UPDATED 20180125
				BasicAccount basicAccount = backEndRequestProcessor.getBasicAccount(subscriberId);
				subscriberProfile.setClassOfServiceName(basicAccount.getCosDisplayName());
				if(basicAccount.getCosDisplayName()!=null)subscriberProfile.setType(basicAccount.getType());
				
				
				List<PackageSubscription> subscriptions = getSubscribedPackages(subscriberId, StringUtils.hasText(langCode) ? langCode : sub.getLanguageCode());
				subscriberProfile.setSubscriptions(subscriptions);
				
				LoggingUtil.debug(logger, "#getSubscriberProfile --- subscriptions= " + subscriberProfile.getSubscriptions());
				
				if (subscriberProfile.getType() != null && subscriberProfile.getType().equals(SubscriberType.POSTPAID)) {
					String intlRoamingPkgId = applicationConfigurationService.get("postpaid.packageid.intlroaming", "1000006", false).toString();;
					if (subscriptions != null) {
						for (PackageSubscription pkg : subscriptions) {
							String code = pkg.getProduct().getCode();
							if (code.equalsIgnoreCase(intlRoamingPkgId)) {
								subscriberProfile.setRoamingEnabled(true);
							}
						}
					}
				}

				/*
				if (subscriberProfile.getType() != null && subscriberProfile.getType().equals(SubscriberType.POSTPAID)) {
					Calendar start = Calendar.getInstance();
					start.add(Calendar.MONTH, -3);
					
					subscriberProfile.setBillingHistory(tibcoServiceProvider.getBillingHistory(subscriberId, start.getTime(), new Date()));
				}
				*/
				
				if (includeDetails){
					Calendar today = Calendar.getInstance();

					today.set(Calendar.HOUR, 0);
					today.set(Calendar.MINUTE, 0);
					today.set(Calendar.SECOND, 0);

					CurrentBalance currentBalance = backEndRequestProcessor.getCurrentBalance(subscriberProfile.getMsisdn(), sub.getLanguageCode());
					
					if (subscriberProfile.getType() != null && subscriberProfile.getType().equals(SubscriberType.POSTPAID)) {
						currentBalance.setOutstandingBalance(tibcoServiceProvider.getCurrentOutstandingBalance(subscriberId));
						currentBalance.setUnbilledBalance(tibcoServiceProvider.getUnbilledBalanceSummary(subscriberId));
						currentBalance.setDepositBalance(tibcoServiceProvider.getDepositBalance(subscriberId));
					}

					subscriberProfile.setCurrentBalance(currentBalance);
					
					subscriberProfile.setCallHistory(backEndRequestProcessor.getCallHistory(subscriberProfile.getMsisdn(), today.getTime(), new Date()));
					subscriberProfile.setSmsHistory(backEndRequestProcessor.getSmsHistory(subscriberId, today.getTime(), new Date()));
					
					if (subscriberProfile.getType() != null && subscriberProfile.getType().equals(SubscriberType.POSTPAID)) {
						
						Calendar start = Calendar.getInstance();
						start.add(Calendar.MONTH, -4);
						
						Calendar end = Calendar.getInstance();
						end.add(Calendar.MONTH, -1);
						
						subscriberProfile.setBillingHistory(tibcoServiceProvider.getBillingHistory(subscriberId, start.getTime(), end.getTime()));
					}
				}

				subscriberProfile.setDisabledAppFeatures(getDisabledAppFeatures(basicAccount.getCos()));
				
				return subscriberProfile;
			}
		} catch (Exception e) {
			logger.error("#getSubscriberProfile >> error when getting subscriber details= " + subscriberId, e);
		}
		return null;
	}

}
