/**
 * SubscriberManagementService.java
 */
package com.gnv.vnm.selfcare.core.service;

import java.util.Date;
import java.util.List;

import com.gnv.vnm.selfcare.core.enums.ClientAppId;
import com.gnv.vnm.selfcare.core.enums.SubscriptionStatus;
import com.gnv.vnm.selfcare.core.fault.EmailAddressNotRegisteredException;
import com.gnv.vnm.selfcare.core.fault.ExternalSubscriberException;
import com.gnv.vnm.selfcare.core.fault.InvalidPasswordFormatException;
import com.gnv.vnm.selfcare.core.fault.InvalidTokenException;
import com.gnv.vnm.selfcare.core.fault.PasswordMismatchException;
import com.gnv.vnm.selfcare.core.fault.SubscriberAlreadyExistsException;
import com.gnv.vnm.selfcare.core.fault.SubscriberNotFoundException;
import com.gnv.vnm.selfcare.core.model.CurrentBalance;
import com.gnv.vnm.selfcare.core.model.PackageSubscription;
import com.gnv.vnm.selfcare.core.model.Simname;
import com.gnv.vnm.selfcare.core.model.SubscriberProfile;
import com.gnv.vnm.selfcare.core.model.SubscriberProfilenew;
import com.gnv.vnm.selfcare.core.model.TransactionHistory;

/**
 * SubscriberProfile management service interface.
 * 
 * @author nandipinto
 *
 */
public interface SubscriberManagementService {

	SubscriberProfile signInWithIMSI(String imsi, String loginFrom, String clientAppId) throws ExternalSubscriberException;

	SubscriberProfile signInWithIPAddress(String ipAddress);

	String lookupUserByIpAddress(String ipAddress);
	
	void performPostLoginActions(String msisdn, String remoteIpAddress, ClientAppId clientAppId);

	boolean isVnmNumber(String msisdn);
	
	String registerSubscriber(String msisdn, String credential, ClientAppId originator)
			throws ExternalSubscriberException, InvalidPasswordFormatException, SubscriberAlreadyExistsException;

	void registerSubscriber(String msisdn, String credential, String otp, String registerFrom) throws ExternalSubscriberException,
			InvalidPasswordFormatException, SubscriberAlreadyExistsException, InvalidTokenException, Exception;
	
	void registerSubscriberTemp(String msisdn, String credential, String otp, String registerFrom) throws ExternalSubscriberException,
	InvalidPasswordFormatException, SubscriberAlreadyExistsException, InvalidTokenException, Exception;

	void activateSubscriber(String subscriberId, String otp)
			throws SubscriberNotFoundException, InvalidTokenException, Exception;
	
	void confirmRegistration(String subscriberId, String credential, String otp) throws InvalidTokenException, Exception;

	boolean isActiveSubscriber(String subscriberId);

	void authenticated(String subscriberId, String credential, String remoteAddr) throws ExternalSubscriberException, SubscriberNotFoundException, PasswordMismatchException;

	void changePassword(String subscriberId, String oldPassword, String newPassword)
			throws SubscriberNotFoundException, PasswordMismatchException, InvalidPasswordFormatException;

	void resetPassword(String subscriberId) throws SubscriberNotFoundException, Exception;

	void resetPassword(String subscriberId, String password, String otp)
			throws ExternalSubscriberException, SubscriberNotFoundException, InvalidTokenException, InvalidPasswordFormatException, Exception;

	void changeEmailAddress(String subscriberId, String oldEmailAddress, String newEmailAddress)
			throws SubscriberNotFoundException, EmailAddressNotRegisteredException;

	void changeEmailAddress(String subscriberId, String newEmailAddress) throws SubscriberNotFoundException;

	void changeLanguage(String subscriberId, String languageCode) throws SubscriberNotFoundException;

	void changeGender(String subscriberId, int genderId) throws SubscriberNotFoundException;

	String generateOTP(String subscriberId, boolean notifySubscriber, String langCode) throws ExternalSubscriberException;

	boolean sendOTP(String subscriberId, String otp);

	boolean isValidOTP(String otp, String subscriberId);

	void updateLoginHistory(String subscriberId, String remoteAddress, String clientAppId);

	SubscriberProfile getSubscriberProfile(String subscriberId, boolean withHistory);

	void updateSubscriberProfile(SubscriberProfile subscriberProfile);

	List<TransactionHistory> getTransactionHistory(String subscriberId, Date startDate, Date endDate);

	List<PackageSubscription> getSubscribedPackages(String subscriberId, String langCode);

	PackageSubscription getPackageSubscriptionDetails(String subscriberId, String packageId);

	SubscriptionStatus getPackageSubscriptionStatus(String subscriberId, String packageId);
	
	void inviteMembers(String subscriberId, List<String> invitedNumbers) throws SubscriberNotFoundException;
	
	boolean instantLogin(String subscriberId, String credential); 
	
	boolean storeFcmToken(String msisdn, String token, String osType);
	
	Simname getSimname(String msisdn);

	List<PackageSubscription> getPackage(String msisdn, String langcode);

	CurrentBalance getBlanceDetails(String msisdn, String langcode);

	boolean validateuser(String msisdn);
	
	SubscriberProfilenew getSubscriberProfilenew(String subscriberId, boolean withHistory);
	
	SubscriberProfilenew getSubscriberProfileCheck(String subscriberId, boolean withHistory);
	
	String generateOTPnew(String subscriberId, boolean notifySubscriber, String langCode)
			throws ExternalSubscriberException;
	
	//Update 20180803
		SubscriptionStatus getIntlRoamingStatus(String msisdn);
		
		SubscriberProfile getSubscriberProfile(String subscriberId, boolean includeDetails, String langCode);
}
