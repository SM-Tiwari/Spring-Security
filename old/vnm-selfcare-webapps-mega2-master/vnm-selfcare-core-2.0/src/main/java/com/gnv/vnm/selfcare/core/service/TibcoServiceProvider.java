/**
 * TibcoServiceProvider.java
 */
package com.gnv.vnm.selfcare.core.service;

import java.util.Date;
import java.util.List;

import com.gnv.vnm.selfcare.core.adapter.RechargeResponse;
import com.gnv.vnm.selfcare.core.adapter.tibco.subscriberqry.SubscriberQueryResponse;
import com.gnv.vnm.selfcare.core.enums.TransactionType;
import com.gnv.vnm.selfcare.core.model.Balance;
import com.gnv.vnm.selfcare.core.model.BillingSummary;
import com.gnv.vnm.selfcare.core.model.BillingSummaryDetails;
import com.gnv.vnm.selfcare.core.model.CallRecord;
import com.gnv.vnm.selfcare.core.model.CurrentBalance;
import com.gnv.vnm.selfcare.core.model.MyDataBalance;
import com.gnv.vnm.selfcare.core.model.MyPromotionBalance;
import com.gnv.vnm.selfcare.core.model.MySmsBalance;
import com.gnv.vnm.selfcare.core.model.MyVoiceBalance;
import com.gnv.vnm.selfcare.core.model.OutstandingBalance;
import com.gnv.vnm.selfcare.core.model.SmsRecord;
import com.gnv.vnm.selfcare.core.model.TopUpHistory;
import com.gnv.vnm.selfcare.core.model.UnbilledBalance;

/**
 * @author nandipinto
 *
 */
public interface TibcoServiceProvider {
	
	
	SubscriberQueryResponse getSubscriberInfo(String msisdn);
	
	String getClassOfServiceName(String subscriberId);
	
	RechargeResponse topUpWithScratchCard(String subscriberId, String voucherCode);

	RechargeResponse etopUp(String subscriberId, double value, String refCode, String refTrxId);
	
	Balance getCoreBalance(String subscriberId);
	
	MyVoiceBalance getVoiceBalance(String subscriberId);
	
	MySmsBalance getSmsBalance(String subscriberId);

	MyPromotionBalance getPromotionBalance(String subscriberId, String languageCode);

	MyDataBalance getDataBalance(String subscriberId);
	
	CurrentBalance getCurrentBalance(String subscriberId, String langCode);

	List<CallRecord> getCallHistory(String subscriberId, Date startDate, Date endDate);

	List<SmsRecord> getSmsHistory(String subscriberId, Date startDate, Date endDate);

	List<TopUpHistory> getTopUpHistory(String subscriberId, Date startDate, Date endDate);
	
	boolean isPostpaidSubscriber(String msisdn);
	
	boolean postpaidBillPayment(String msisdn, double amount, String reference, TransactionType trxType);
	
	UnbilledBalance getUnbilledBalanceSummary(String msisdn);
	
	List<BillingSummary> getBillingHistory(String msisdn, Date startDate, Date endDate);
	
	double getCurrentOutstandingBalance(String msisdn);
	
	List<OutstandingBalance> getOutstandingBalances(String msisdn);
	
	double getDepositBalance(String msisdn);
	
	BillingSummaryDetails getBillingSummaryDetails(Integer id);
}
