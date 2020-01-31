/**
 * BackEndRequestProcessor.java
 */
package com.gnv.vnm.selfcare.core.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.gnv.vnm.selfcare.core.adapter.BackEndAdapterResponse;
import com.gnv.vnm.selfcare.core.adapter.RechargeResponse;
import com.gnv.vnm.selfcare.core.adapter.gamify.GamifyGetMonsterResponse;
import com.gnv.vnm.selfcare.core.adapter.gamify.GamifyRedeemByMonsterRequest;
import com.gnv.vnm.selfcare.core.adapter.radius.BasicSubscriberInfo;
import com.gnv.vnm.selfcare.core.adapter.vasman.VASManSelfPackageRequest;
import com.gnv.vnm.selfcare.core.enums.ClientAppId;
import com.gnv.vnm.selfcare.core.enums.SubscriptionStatus;
import com.gnv.vnm.selfcare.core.fault.SubscriberNotFoundException;
import com.gnv.vnm.selfcare.core.model.Balance;
import com.gnv.vnm.selfcare.core.model.BasicAccount;
import com.gnv.vnm.selfcare.core.model.CallRecord;
import com.gnv.vnm.selfcare.core.model.CurrentBalance;
import com.gnv.vnm.selfcare.core.model.KeyValue;
import com.gnv.vnm.selfcare.core.model.LmsItem;
import com.gnv.vnm.selfcare.core.model.MyDataBalance;
import com.gnv.vnm.selfcare.core.model.MyPromotionBalance;
import com.gnv.vnm.selfcare.core.model.MySmsBalance;
import com.gnv.vnm.selfcare.core.model.MyVoiceBalance;
import com.gnv.vnm.selfcare.core.model.OtpStatusModel;
import com.gnv.vnm.selfcare.core.model.PackageSubscription;
import com.gnv.vnm.selfcare.core.model.ScratchStatusModel;
import com.gnv.vnm.selfcare.core.model.SelfPackageBalanceName;
import com.gnv.vnm.selfcare.core.model.SelfPackagePriceMapping;
import com.gnv.vnm.selfcare.core.model.SmsCallHistoryStatusModel;
import com.gnv.vnm.selfcare.core.model.SmsRecord;
import com.gnv.vnm.selfcare.core.model.TopUpHistory;
import com.gnv.vnm.selfcare.dao.entity.ScratchBlockHistoryEntity;

/**
 * @author nandipinto
 *
 */
public interface BackEndRequestProcessor {
	
	void loadBalanceMappings();

	void loadClassOfServiceMappings();
	
	BasicAccount getBasicAccount(String subscriberId);
	
	String getClassOfServiceName(String subscriberId);
	
	RechargeResponse topUpWithScratchCard(String subscriberId, String voucherCode, String recipientNumber, ClientAppId clientAppId, String referrer, String sessionId);

	RechargeResponse etopUp(String subscriberId, double value, String refTrxId, String referrer);
	
	Balance getCoreBalance(String subscriberId);
	
	//boolean savebaznotificationDetails(String loginId, String readstatus,String readBy);
	boolean savebaznotificationDetails(String loginId, String readstatus,String readcount,String readBy);
	
	MyVoiceBalance getVoiceBalance(String subscriberId);
	
	MySmsBalance getSmsBalance(String subscriberId);

	MyPromotionBalance getPromotionBalance(String subscriberId, String languageCode);

	MyDataBalance getDataBalance(String subscriberId, String langCode);
	
	CurrentBalance getCurrentBalance(String subscriberId, String langCode);
	
	BackEndAdapterResponse activatePackageSubscription(String subscriberId, String packageId, ClientAppId clientAppId);
	
	boolean cancelPackageSubscription(String subscriberId, String packageId);
	
	SubscriptionStatus getPackageSubscriptionStatus(String subscriberId, String packageId); 
	
	List<PackageSubscription> getSubscribedPackages(String subscriberId, String packageId, String langCode);

	PackageSubscription getPackageSubscriptionDetails(String subscriberId, String packageId);
	
	List<CallRecord> getCallHistory(String subscriberId, Date startDate, Date endDate);
	List<CallRecord> getDailyCallHistory(String subscriberId);
	List<CallRecord> getWeeklyCallHistory(String subscriberId);
	List<CallRecord> getMonthlyCallHistory(String subscriberId);
	List<CallRecord> getYearlyCallHistory(String subscriberId);

	List<SmsRecord> getSmsHistory(String subscriberId, Date startDate, Date endDate);
	List<SmsRecord> getDailySmsHistory(String subscriberId);
	List<SmsRecord> getWeeklySmsHistory(String subscriberId);
	List<SmsRecord> getMonthlySmsHistory(String subscriberId);
	List<SmsRecord> getYearlySmsHistory(String subscriberId);

	List<TopUpHistory> getTopUpHistory(String subscriberId, Date startDate, Date endDate);
	List<TopUpHistory> getDailyTopUpHistory(String subscriberId);
	List<TopUpHistory> getWeeklyTopUpHistory(String subscriberId);
	List<TopUpHistory> getMonthlyTopUpHistory(String subscriberId);
	List<TopUpHistory> getYearlyTopUpHistory(String subscriberId);
	
	TopUpHistory getInternalTopUpHistoryByRefTrxId(String refTrxId);
	//added for petie helper
	List<TopUpHistory> getTopupHistoryBySessionId(String sessionId, String referrer);
	
	BasicSubscriberInfo getSubscriberInfoFromRadius(String ipAddress);
	boolean isInHomeNetwork(String ipAddress);
	
	void sendMail(String from, String subject, String content);
	
	//the following methods are for Mega (1 & 2) releases
	GamifyGetMonsterResponse getGamifyMonsters(String msisdn, String langCode);
	BackEndAdapterResponse gamifyRedeemByMonsters(GamifyRedeemByMonsterRequest request);

	int getLmsPoint(String msisdn);
	int getFattyPoint(String msisdn);
	BackEndAdapterResponse redeemLmsPoint(String msisdn, String keyword, double point);
	BackEndAdapterResponse redeemFattyPoint(String msisdn, String keyword, int point,String description);
	List<LmsItem> getLmsItemList();
	LmsItem getLmsRedeemableItem(String keyword);
	List<String> getLmsKeywordList();
	Map<String, Integer> getLmsKeywordMappings();
    Map<String, Integer> getFattyKeywordMappings();
	Map<String, Object> getLmsConfigs();
	Object getLmsConfigValue(String key, Object defaultValue);

	BackEndAdapterResponse registerDataSharing(String msisdn, String packageId, List<String> members);
	BackEndAdapterResponse deleteDataSharing(String msisdn, String packageId);
	
	List<SelfPackagePriceMapping> getSelfPackagePriceMappings();
	List<SelfPackagePriceMapping> getSelfPackagePriceMappings(String type);
	List<SelfPackagePriceMapping> getSelfPackagePriceMappings(String type, int cycle);
	List<SelfPackagePriceMapping> getSelfPackagePriceMappings(String type, int cycle, double amount);
	List<SelfPackagePriceMapping> getSelfPackagePriceMappings(int cycle);
	List<SelfPackageBalanceName> getSelfPackageBalanceList();
	Map<String, String> getSelfPackageCommonConfigs();
	List<KeyValue> getSelfPackageCommonConfigsAsList();
	BackEndAdapterResponse registerSelfPackage(VASManSelfPackageRequest request);

	
	//change
	ScratchStatusModel checkBlockUnblockTopUp(String msisdn);
	
	void saveScratchCardInHistory(ScratchBlockHistoryEntity scratchBlockEntitiest);
	
	void saveScratchStatus(String msisdn, int count, String status, String timestamp);
	
	int getCountFromScratchBlock(String msisdn);
	
	String getFirstTimestampScratchStatus(String msisdn);
	RechargeResponse topUpWithScratchCardUpdate(String subscriberId, String voucherCode, String recipientNumber, ClientAppId clientAppId, String referrer);

	RechargeResponse topUpWithScratchCard(String subscriberId, String voucherCode, String recipientNumber,
			ClientAppId clientAppId, String referrer);
	SmsCallHistoryStatusModel updateSmsCallHistoryStatus(String msisdn, String credential, String status)throws SubscriberNotFoundException ;

    String getSmsCallHistoryStatus(String msisdn);

    SmsCallHistoryStatusModel checkSmsCallHistorycredential(String msisdn, String credential)
                  throws SubscriberNotFoundException;
    
    boolean saveVersionDetails(String loginId, String app_version, String app_os, String app_os_version,
			String devic_name,String devic_modeil, String devic_id);
    OtpStatusModel checkBlockUnblockOtp(String msisdn);    
int getfailCountFromOtpBlock(String msisdn);
void saveOtpStatus(String msisdn, int count, String status, String timeStamp,boolean timechange);

void resetFailCount(String msisdn);


	
}
