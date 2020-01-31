/**
 * EPOSDBQueryProcessor.java
 */
package com.gnv.vnm.selfcare.core.service;

import java.util.List;

import com.gnv.vnm.selfcare.core.enums.SubscriberType;
import com.gnv.vnm.selfcare.core.enums.SubscriptionStatus;
import com.gnv.vnm.selfcare.core.model.PackageSubscription;

/**
 * @author nandipinto
 *
 */
public interface EposDbClient {
	
	List<PackageSubscription> getSubscribedPackages(String subscriberId, String langCode);
	
	List<PackageSubscription> getSubscribedPackages(String subscriberId, String categoryCode, String langCode);
	
	PackageSubscription getPackageSubscriptionDetails(String subscriberId, String packageId, String langCode);
	
	SubscriptionStatus getPackageSubscriptionStatus(String subscriberId, String packageId);
	
	SubscriberType getSubscriberType(String msisdn);
	
	String lookupIMSI(String msisdn);
	
	String lookupMSISDN(String imsi);
	
	String getSubscriberName(String msisdn);

}
