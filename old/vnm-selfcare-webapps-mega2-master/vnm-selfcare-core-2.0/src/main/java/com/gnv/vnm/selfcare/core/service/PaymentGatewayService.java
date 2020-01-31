/**
 * PaymentGatewayService.java
 */
package com.gnv.vnm.selfcare.core.service;

import com.gnv.vnm.selfcare.core.enums.ClientAppId;
import com.gnv.vnm.selfcare.core.enums.TransactionStatus;
import com.gnv.vnm.selfcare.core.enums.TransactionType;
import com.gnv.vnm.selfcare.core.fault.OrderIdNotFoundException;
import com.gnv.vnm.selfcare.core.fault.TransactionInProgressException;
import com.gnv.vnm.selfcare.core.fault.TransactionNotFoundException;
import com.gnv.vnm.selfcare.core.model.Bank;
import com.gnv.vnm.selfcare.core.model.pg.FinalResponse;

/**
 * @author nandipinto
 *
 */
public interface PaymentGatewayService {

	String initTransaction(String msisdn, String itemCode, double amount, ClientAppId appId, TransactionType trxType, String refPaymentNo, String referrer, String sessionId);
	
	String executeTransaction(String orderId, ClientAppId appId, String language) throws OrderIdNotFoundException, TransactionInProgressException;
	
	boolean confirmTransaction(FinalResponse finalResponse) throws TransactionNotFoundException;
	
	String confirmTransaction(String orderId, TransactionStatus status) throws TransactionNotFoundException, Exception;
	
	TransactionStatus getTransactionStatus(String orderId);
	
	void updateTransactionStatus(String orderId, Integer status);
	
	String getOrderIdByExtTrxId(String extTrxId);
	
	Bank getBankDetails(String code);
	
	boolean refund(String orderId);

	String executeTransactionwithDiscount(String orderId, ClientAppId cai, String lang)  throws OrderIdNotFoundException, TransactionInProgressException;

	

	boolean refundDiscount(String orderId);

	String initTransactiondiscount(String msisdn, String itemCode, double amount, double rechrgeamount,
			ClientAppId appId, TransactionType trxType, String refPaymentNo, String referrer, String sessionId);

 

//TODO implement these methods
//	List<TransactionHistory> getPendingTransactions(String msisdn);
//	
//	List<TransactionHistory> getPendingTransactions(String msisdn, TransactionType type);	
	
	
}
