/**
 * PaymentGatewayServiceImpl.java
 */
package com.gnv.vnm.selfcare.core.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.gnv.vnm.selfcare.core.AppDefaultValues;
import com.gnv.vnm.selfcare.core.adapter.RechargeResponse;
import com.gnv.vnm.selfcare.core.enums.ClientAppId;
import com.gnv.vnm.selfcare.core.enums.PostpaidPaymentType;
import com.gnv.vnm.selfcare.core.enums.TibcoResponse;
import com.gnv.vnm.selfcare.core.enums.TopUpType;
import com.gnv.vnm.selfcare.core.enums.TransactionStatus;
import com.gnv.vnm.selfcare.core.enums.TransactionType;
import com.gnv.vnm.selfcare.core.fault.OrderIdNotFoundException;
import com.gnv.vnm.selfcare.core.fault.TransactionInProgressException;
import com.gnv.vnm.selfcare.core.fault.TransactionNotFoundException;
import com.gnv.vnm.selfcare.core.model.Bank;
import com.gnv.vnm.selfcare.core.model.pg.FinalResponse;
import com.gnv.vnm.selfcare.core.model.pg.InitialResponse;
import com.gnv.vnm.selfcare.core.model.pg.NapasErrorCode;
import com.gnv.vnm.selfcare.core.model.pg.NapasSuccessCode;
import com.gnv.vnm.selfcare.core.model.pg.PaymentRequest;
import com.gnv.vnm.selfcare.core.model.pg.RefundRequest;
import com.gnv.vnm.selfcare.core.model.pg.RefundResponse;
import com.gnv.vnm.selfcare.core.service.ApplicationConfigurationService;
import com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor;
import com.gnv.vnm.selfcare.core.service.PaymentGatewayService;
import com.gnv.vnm.selfcare.core.service.TibcoServiceProvider;
import com.gnv.vnm.selfcare.core.utils.AppUtils;
import com.gnv.vnm.selfcare.core.utils.LoggingUtil;
import com.gnv.vnm.selfcare.dao.entity.BankEntity;
import com.gnv.vnm.selfcare.dao.entity.PaymentHistoryEntity;
import com.gnv.vnm.selfcare.dao.entity.PostpaidBillPaymentHistoryEntity;
import com.gnv.vnm.selfcare.dao.entity.QBankEntity;
import com.gnv.vnm.selfcare.dao.entity.QPaymentHistoryEntity;
import com.gnv.vnm.selfcare.dao.entity.QPostpaidBillPaymentHistoryEntity;
import com.gnv.vnm.selfcare.dao.entity.QSubscriberEntity;
import com.gnv.vnm.selfcare.dao.entity.QTopUpHistoryEntity;
import com.gnv.vnm.selfcare.dao.entity.SubscriberEntity;
import com.gnv.vnm.selfcare.dao.entity.TopUpHistoryEntity;
import com.gnv.vnm.selfcare.dao.repo.BankRepository;
import com.gnv.vnm.selfcare.dao.repo.PaymentHistoryRepository;
import com.gnv.vnm.selfcare.dao.repo.PostpaidBillPaymentHistoryRepository;
import com.gnv.vnm.selfcare.dao.repo.SubscriberRepository;
import com.gnv.vnm.selfcare.dao.repo.TopUpHistoryRepository;
import com.google.common.base.Charsets;

/**
 * @author nandipinto
 *
 */

@Service("paymentGatewayService")
public class PaymentGatewayServiceImpl implements PaymentGatewayService{

	private static final Logger logger = LoggerFactory.getLogger(PaymentGatewayServiceImpl.class);
	
	static final String SUCCESS_RESP = "0";
	static final int CONNECTION_TIMEOUT_IN_SECS = 5;
	static final int MAX_CONNECTIONS = 10;
	static final int CONNECTION_CHECK_INT_SECS = 5;

	private String url = "http://10.8.8.51:19092/vnmbl/VNM/capturePayment";
	private String mid = "938425";
	private String channelId = "SELFCARE";
	private String language = "E";
	private String requestDateFormat = "ddMMyyyy HH:mm:ss:SSS";
	private String responseDateFormat = "yyyy-MM-dd HH:mm:ss";
	private String userName = "";
	private String credential = "";
	private String secretKey = "";
	private String callBackUrl = "";
	private String napasCallbackURL = "";
	private String napasCancelURL = "";
	private String successRespCode = SUCCESS_RESP;
	
	private int connectTimeout = CONNECTION_TIMEOUT_IN_SECS;
	private int maxConnections = MAX_CONNECTIONS;
	private int httpConnectionCheckInterval = CONNECTION_CHECK_INT_SECS * 1000;

	private RestTemplate restTemplate = new RestTemplate();
	private HttpComponentsClientHttpRequestFactory httpRequestFactory = null;

	@Autowired
	private TopUpHistoryRepository topUpHistoryRepository;
	@Autowired
	private PaymentHistoryRepository paymentHistoryRepository;
	@Autowired
	private BankRepository bankRepository;
	@Autowired
	private SubscriberRepository subscriberRepository;
	@Autowired
	private PostpaidBillPaymentHistoryRepository postpaidBillPaymentHistoryRepository;
	
	@Autowired
	private ApplicationConfigurationService applicationConfigurationService;
	@Autowired
	private BackEndRequestProcessor backEndRequestProcessor;
	@Autowired
	private ThreadPoolTaskExecutor taskExecutor; 
	@Autowired
	private TibcoServiceProvider tibcoServiceProvider;
	
	private CloseableHttpClient pgHttpClient = null;
	private CloseableHttpClient napasHttpClient = null; 
	private PoolingHttpClientConnectionManager connectionManager = null;
	private RequestConfig requestConfig = null;
	
	@PreDestroy
	public void stopService(){
		try {
			if (pgHttpClient != null) pgHttpClient.close();
			if (napasHttpClient != null) napasHttpClient.close();
		} catch (Exception e) {}

		taskExecutor.shutdown();
	}
	
	@PostConstruct
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public void initService() throws Exception{
		//commented out for temporary
		connectTimeout = Integer.parseInt(applicationConfigurationService.get("pg.connecttimeout", "5").toString());
		maxConnections = Integer.parseInt(applicationConfigurationService.get("pg.maxconnections", "50").toString());
		
		int trxTimeoutInSecs = Integer.parseInt(applicationConfigurationService.get("napas.trxtimeout.seconds", "1800").toString()); //30 minutes

		//upon start ups look for pending transaction to NAPAS just in case the server was shutdown and transaction timer was shutdown forcefully
		List<PaymentHistoryEntity> pendingTransactions = new ArrayList<>();
		try {
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.SECOND, -1 * trxTimeoutInSecs);
			
			LoggingUtil.info(logger, "#initService --- querying pending transaction for request time >= " + cal.getTime());
			
			Iterable<PaymentHistoryEntity> list = paymentHistoryRepository.findAll(QPaymentHistoryEntity.paymentHistoryEntity.requestTime.goe(cal.getTime())
					.and(QPaymentHistoryEntity.paymentHistoryEntity.status.eq(TransactionStatus.PROCESSING.ordinal())));
			
			if (list != null) {
				for (PaymentHistoryEntity phe : list) {
					pendingTransactions.add(phe);
				}
			}
			
		} catch (Exception e) {
			logger.error("#initService --- error when querying payment_history", e);
		}
		
		if (pendingTransactions.isEmpty()) {
			LoggingUtil.info(logger, "#initService --- no pending transaction found.");
			return;
		}
		
		LoggingUtil.info(logger, "#initService --- found " + pendingTransactions.size() + " pending transaction(s)...starting transaction timer task now.");
		for (PaymentHistoryEntity phe : pendingTransactions) {
			startTransactionDaemon(phe.getOrderId(), phe.getExtTrxId(), language);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.PaymentGatewayService#initPayment(java.lang.String, java.lang.String, double, com.gnv.vnm.selfcare.core.enums.ClientAppId)
	 */
	@Override
	public String initTransaction(String msisdn, String itemCode, double amount, ClientAppId appId, TransactionType trxType, String refPaymentNo, String referrer, String sessionId) {
		LoggingUtil.debug(logger, "#initPayment --- itemCode= " + itemCode + ", amount= " + amount + ", trx_type= "
				+ trxType + ", client_app= " + appId + ", refPaymentNo= " + refPaymentNo + ", referrer= " + referrer);
		
		String orderId = RandomStringUtils.randomAlphanumeric(40);
		try {
			PaymentHistoryEntity history = new PaymentHistoryEntity();
			history.setAmount(amount);
			history.setItemCode(itemCode);
			history.setMsisdn(msisdn);
			history.setOrderId(orderId);
			history.setChannel(appId.name());
			history.setClientAppId(appId.name());
			history.setTrxType(trxType.name());
			
			paymentHistoryRepository.saveAndFlush(history);
			
			if (trxType.equals(TransactionType.E_TOPUP)){
				TopUpHistoryEntity topupHistory = new TopUpHistoryEntity(msisdn, itemCode, amount, new Date(), TransactionStatus.PROCESSING.ordinal());
				topupHistory.setChannelId(TopUpType.E_TOPUP.name());
				topupHistory.setClientAppId(appId.name());
				topupHistory.setRefTrxId(orderId);
				topupHistory.setReferrer(referrer);
				
				topUpHistoryRepository.saveAndFlush(topupHistory);
				
			} else if (trxType.equals(TransactionType.POSTPAID_BILL_PAYMENT) || trxType.equals(TransactionType.POSTPAID_DEPOSIT)) {
				//TODO
				PostpaidBillPaymentHistoryEntity postpaidPmtHistory = new PostpaidBillPaymentHistoryEntity(msisdn, itemCode, amount, new Date(), TransactionStatus.PROCESSING.ordinal());
				postpaidPmtHistory.setChannelId(PostpaidPaymentType.BANK_ACCOUNT.name());
				postpaidPmtHistory.setClientAppId(appId.name());
				postpaidPmtHistory.setRefTrxId(orderId);
				postpaidPmtHistory.setTrxType(trxType.name());
				postpaidPmtHistory.setInvoiceNo(refPaymentNo);
				
				postpaidBillPaymentHistoryRepository.saveAndFlush(postpaidPmtHistory);
			}

			return orderId;
			
		} catch (Exception e) {
			logger.error("#initPayment -- error initiating transaction request(orderId= " + orderId + ", msisdn= " + msisdn + ", amount= " + amount + ")", e);
			return null;
		}
		
	}
	
	@Override
	public String initTransactiondiscount(String msisdn, String itemCode, double amount, double rechrgeamount,ClientAppId appId, TransactionType trxType, String refPaymentNo, String referrer, String sessionId) {
		LoggingUtil.debug(logger, "#initPayment --- itemCode= " + itemCode + ", amount= " + amount + ", trx_type= "
				+ trxType + ", client_app= " + appId + ", refPaymentNo= " + refPaymentNo + ", referrer= " + referrer);
		
		String orderId = RandomStringUtils.randomAlphanumeric(40);
		try {
			PaymentHistoryEntity history = new PaymentHistoryEntity();
			history.setAmount(amount);
			history.setRecharge_amount(rechrgeamount);
			history.setItemCode(itemCode);
			history.setMsisdn(msisdn);
			history.setOrderId(orderId);
			history.setChannel(appId.name());
			history.setClientAppId(appId.name());
			history.setTrxType(trxType.name());
			
			paymentHistoryRepository.saveAndFlush(history);
			
			if (trxType.equals(TransactionType.E_TOPUP)){
				TopUpHistoryEntity topupHistory = new TopUpHistoryEntity(msisdn, itemCode, amount, new Date(), TransactionStatus.PROCESSING.ordinal());
				topupHistory.setChannelId(TopUpType.E_TOPUP.name());
				topupHistory.setClientAppId(appId.name());
				topupHistory.setRefTrxId(orderId);
				topupHistory.setReferrer(referrer);
				
				topUpHistoryRepository.saveAndFlush(topupHistory);
				
			} else if (trxType.equals(TransactionType.POSTPAID_BILL_PAYMENT) || trxType.equals(TransactionType.POSTPAID_DEPOSIT)) {
				//TODO
				PostpaidBillPaymentHistoryEntity postpaidPmtHistory = new PostpaidBillPaymentHistoryEntity(msisdn, itemCode, amount, new Date(), TransactionStatus.PROCESSING.ordinal());
				postpaidPmtHistory.setChannelId(PostpaidPaymentType.BANK_ACCOUNT.name());
				postpaidPmtHistory.setClientAppId(appId.name());
				postpaidPmtHistory.setRefTrxId(orderId);
				postpaidPmtHistory.setTrxType(trxType.name());
				postpaidPmtHistory.setInvoiceNo(refPaymentNo);
				
				postpaidBillPaymentHistoryRepository.saveAndFlush(postpaidPmtHistory);
			}

			return orderId;
			
		} catch (Exception e) {
			logger.error("#initPayment -- error initiating transaction request(orderId= " + orderId + ", msisdn= " + msisdn + ", amount= " + amount + ")", e);
			return null;
		}
		
	}
	
	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.PaymentGatewayService#makePayment(java.lang.String)
	 */
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public String executeTransaction(String orderId, ClientAppId appId, String language) throws OrderIdNotFoundException, TransactionInProgressException {
		
		int amount = 0;
		String msisdn = "";
		String itemCode = "";

		PaymentHistoryEntity history = paymentHistoryRepository.findOne(QPaymentHistoryEntity.paymentHistoryEntity.orderId.eq(orderId));
		if (history == null) {
			logger.error(String.format("Transaction with order_id %s does not exist", orderId));
			throw new OrderIdNotFoundException("Order Id " + orderId + " does not exist!");
		}
		
		String pageContent = "";
		
		if (history.getStatus() != null && history.getStatus() >= TransactionStatus.PROCESSING.ordinal()) {
			logger.error(String.format("Rejecting execution of transaction with order_id %s, transaction already in progress", orderId));
			throw new TransactionInProgressException("Transaction with orderId " + orderId +" already in progress!");
		}
		
		HttpPost post = null;
		InitialResponse pgResponse = null;
		
		try {
			
			url = applicationConfigurationService.get("pg.requesturl", "http://10.8.8.51:19092/vnmbl/VNM/capturePayment").toString();
			channelId = applicationConfigurationService.get("pg.channelid", "SELFCARE").toString();
			mid = applicationConfigurationService.get("pg.mid", "938425").toString();
			userName = applicationConfigurationService.get("pg.username", "selfcare").toString();
			credential = applicationConfigurationService.get("pg.credential", "selfcare").toString();
			secretKey = applicationConfigurationService.get("pg.secretkey", "646ed314-8").toString();

			requestDateFormat = applicationConfigurationService.get("pg.datetimeformat", "ddMMyyyy HH:mm:ss:SSS").toString();

			if (appId.equals(ClientAppId.MOBILE_APP)) {
				callBackUrl = applicationConfigurationService
						.get("pg.callbackurl.api", "http://10.8.8.31:8181/webapi/pg/callback").toString();
			} else {
				callBackUrl = applicationConfigurationService
						.get("pg.callbackurl.api", "http://10.8.8.31:8383/pg/callback").toString();
			}
			
			napasCallbackURL = applicationConfigurationService.get("pg.napas.callbackurl", "http://10.0.0.36:8080/merchant/status/callBackURL").toString();
			napasCancelURL = applicationConfigurationService.get("pg.napas.cancelurl", "http://202.172.4.55/webapi/pg/cancelPayment?orderId=").toString();
			
			successRespCode = applicationConfigurationService.get("pg.responsecode.success", SUCCESS_RESP).toString();

			amount = history.getAmount().intValue();
			msisdn = history.getMsisdn();
			itemCode = history.getItemCode();

			//get preferred language of the subscriber
			if (!StringUtils.hasText(language)) {
				try {
					SubscriberEntity sub = subscriberRepository.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(msisdn));
					if (sub != null) {
						if (sub.getLanguageCode().equalsIgnoreCase(AppDefaultValues.LANGUAGE_ENGLISH)) {
							language = "E";
						}else if (sub.getLanguageCode().equalsIgnoreCase(AppDefaultValues.LANGUAGE_VIETNAMESE)) {
							language = "VN";
						}
					}
				} catch (Exception e) {
					logger.error("#makePayment --- could not get subscriber info for MSISDN " + msisdn);
				}
			}
			
			if (!StringUtils.hasText(language)) language = "VN";
			
			Date requestTime = new Date();
			PaymentRequest request = new PaymentRequest();
			request.setAmount(amount);
			request.setCallBackUrl(callBackUrl);
			request.setCardType("");
			request.setChannel(channelId);
			request.setMid(mid);
			// SECRET KEY+ amount+mid+ orderId
			String checkSumHash = sha256(secretKey + amount + mid + orderId);
			request.setCheckSumHash(checkSumHash);
			request.setEmailId("");
			request.setIpAddress(InetAddress.getLocalHost().getHostAddress());
			request.setLanguageId(language);
			request.setMobileNumber(msisdn);
			
			request.setNapasCallBackURL(napasCallbackURL);
			request.setNapasCancelURL(napasCancelURL + orderId);
			
			request.setOrderId(orderId);
			request.setOrderInfo(itemCode);
			request.setRequestTime(AppUtils.dateToString(requestTime, requestDateFormat));
			request.setTxnType("");

			LoggingUtil.debug(logger, String.format("#makePayment(1) -- (MSISDN=%s, amount=%s, order_id=%s, language=%s) sending initial payment request to PG...", msisdn, "" + amount, orderId, language));

			restTemplate.setRequestFactory(getSimpleClientHttpRequestFactory(connectTimeout));
			HttpEntity<PaymentRequest> entity = new HttpEntity<PaymentRequest>(request, createHeaders(userName, credential));
			pgResponse = restTemplate.postForObject(url, entity, InitialResponse.class);

			LoggingUtil.debug(logger, String.format("#makePayment(1) -- (MSISDN=%s, amount=%s, order_id=%s) receiving initial response= ", msisdn, "" + amount, orderId) + pgResponse);
			
			// create payment history
			history.setCheckSumHash(checkSumHash);
			history.setIpAddress(request.getIpAddress());
			history.setOrderInfo(request.getOrderInfo());
			history.setRequestTime(requestTime);

		} catch (Exception e) {
			logger.error(String.format("#makePayment(1) -- error when initiating PG request(MSISDN=%s, amount=%s, order_id=%s)", msisdn, "" + amount, orderId), e);
			
		} finally{
			if (post != null) post.releaseConnection();
		}

		if (pgResponse == null) {
			history.setStatus(TransactionStatus.FAIL.ordinal());
			logger.error(String.format("#makePayment(1) -- NULL response received for initial PG request(MSISDN=%s, amount=%s, order_id=%s)", msisdn, "" + amount, orderId));
			try {
				paymentHistoryRepository.save(history);
			} catch (Exception e) {
				logger.error("#makePayment(1) --- error when updating payment history with order_id# " + orderId, e);
			}
			return pageContent;
		}
			
		if (pgResponse.getResultCode() == null || !pgResponse.getResultCode().equals(successRespCode)){
			history.setStatus(TransactionStatus.FAIL.ordinal());
			
			logger.error(String.format(
					"#makePayment(1) --- initial request to PG was not successful (order_id= %s, result_code= %s, result_msg= %s)",
					orderId, pgResponse.getResultCode(), pgResponse.getResponseMsg()));
			try {
				paymentHistoryRepository.save(history);
			} catch (Exception e) {
				logger.error("#makePayment(1) --- initial request to PG was not successful, error when updating payment history with order_id# " + orderId, e);
			}
			
			try {
				String trxType = history.getTrxType();
				if (trxType.equalsIgnoreCase(TransactionType.E_TOPUP.name())) {
					
					TopUpHistoryEntity topupHistory = topUpHistoryRepository.findOne(QTopUpHistoryEntity.topUpHistoryEntity.refTrxId.eq(orderId));
					if (topupHistory != null) {
						topupHistory.setStatus(TransactionStatus.FAIL.ordinal());
						topUpHistoryRepository.saveAndFlush(topupHistory);
					}

				} else if (trxType.equalsIgnoreCase(TransactionType.POSTPAID_BILL_PAYMENT.name()) || trxType.equalsIgnoreCase(TransactionType.POSTPAID_DEPOSIT.name())) {
					
					PostpaidBillPaymentHistoryEntity ph = postpaidBillPaymentHistoryRepository.findOne(
									QPostpaidBillPaymentHistoryEntity.postpaidBillPaymentHistoryEntity.refTrxId.eq(orderId));
					if (ph != null) {
						ph.setStatus(TransactionStatus.FAIL.ordinal());
						postpaidBillPaymentHistoryRepository.saveAndFlush(ph);
					}
				}				
			} catch (Exception e) {
				logger.error("#makePayment(1) --- error when updating transaction history for payment with order_id= "+ orderId, e); 
			}
			
			return pageContent;
		}

		history.setStatus(TransactionStatus.PROCESSING.ordinal());
		history.setRedirectURL(pgResponse.getRedirectionURL());
		history.setResponseTime(AppUtils.stringToDate(pgResponse.getResponseTime(), responseDateFormat));
		history.setInitialResultCode(pgResponse.getResultCode());
		history.setInitialResultMsg(pgResponse.getResponseMsg());
		history.setExtTrxId(pgResponse.getTransactionId());
		
		paymentHistoryRepository.save(history);
		
		CloseableHttpResponse response = null;
		LoggingUtil.debug(logger, "#makePayment(1) --- order_id= " + orderId + ", opening NAPAS page...");
		try {
			//open redirectionURL and get the page content and give it back to the browser to display payment page
			HttpClientContext context = HttpClientContext.create();
			post = new HttpPost(pgResponse.getRedirectionURL());
			response = getPgHttpClient().execute(post, context);

			ByteArrayOutputStream out = new ByteArrayOutputStream();
			org.apache.http.HttpEntity httpEntity = response.getEntity();
			httpEntity.writeTo(out);
			
			pageContent = new String(out.toByteArray(), "UTF-8");
			
			EntityUtils.consume(httpEntity);
			
		} catch (Exception e) {
			logger.error("#makePayment(1) --- order_id= " + orderId + ", error when opening NAPAS page!", e);

		} finally {
			if (post != null) post.releaseConnection();
			try {
				if (response != null) response.close();
			} catch (IOException e) { }
		}

		if (!StringUtils.hasText(pageContent)) {
			history.setStatus(TransactionStatus.FAIL.ordinal());
			
			LoggingUtil.debug(logger, "#makePayment(1) --- order_id= " + orderId + ", received NAPAS page was empty - transaction could not be processed.");
			try {
				paymentHistoryRepository.save(history);
			} catch (Exception e) {
				logger.error("#makePayment(1) --- received NAPAS page was empty - error when updating payment history with order_id# " + orderId, e);
			}
			
			try {
				String trxType = history.getTrxType();
				if (trxType.equalsIgnoreCase(TransactionType.E_TOPUP.name())) {
					
					TopUpHistoryEntity topupHistory = topUpHistoryRepository.findOne(QTopUpHistoryEntity.topUpHistoryEntity.refTrxId.eq(orderId));
					if (topupHistory != null) {
						topupHistory.setStatus(TransactionStatus.FAIL.ordinal());
						topUpHistoryRepository.saveAndFlush(topupHistory);
					}

				} else if (trxType.equalsIgnoreCase(TransactionType.POSTPAID_BILL_PAYMENT.name()) || trxType.equalsIgnoreCase(TransactionType.POSTPAID_DEPOSIT.name())) {
					
					PostpaidBillPaymentHistoryEntity ph = postpaidBillPaymentHistoryRepository.findOne(
									QPostpaidBillPaymentHistoryEntity.postpaidBillPaymentHistoryEntity.refTrxId.eq(orderId));
					if (ph != null) {
						ph.setStatus(TransactionStatus.FAIL.ordinal());
						postpaidBillPaymentHistoryRepository.saveAndFlush(ph);
					}
				}				
			} catch (Exception e) {
				logger.error("#makePayment(1) --- error when updating transaction history for payment with order_id= "+ orderId, e); 
			}
			
			return pageContent;
		}
		
		//start periodic query to NAPAS
		startTransactionDaemon(orderId, pgResponse.getTransactionId(), language);

		return pageContent;
	}
	//created by oneclick
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public String executeTransactionwithDiscount(String orderId, ClientAppId appId, String language) throws OrderIdNotFoundException, TransactionInProgressException {
		
		int amount = 0;
		String msisdn = "";
		String itemCode = "";

		PaymentHistoryEntity history = paymentHistoryRepository.findOne(QPaymentHistoryEntity.paymentHistoryEntity.orderId.eq(orderId));
		if (history == null) {
			logger.error(String.format("Transaction with order_id %s does not exist", orderId));
			throw new OrderIdNotFoundException("Order Id " + orderId + " does not exist!");
		}
		
		String pageContent = "";
		
		if (history.getStatus() != null && history.getStatus() >= TransactionStatus.PROCESSING.ordinal()) {
			logger.error(String.format("Rejecting execution of transaction with order_id %s, transaction already in progress", orderId));
			throw new TransactionInProgressException("Transaction with orderId " + orderId +" already in progress!");
		}
		
		HttpPost post = null;
		InitialResponse pgResponse = null;
		
		try {
			
			url = applicationConfigurationService.get("pg.requesturl", "http://10.8.8.51:19092/vnmbl/VNM/capturePayment").toString();
			channelId = applicationConfigurationService.get("pg.channelid", "SELFCARE").toString();
			mid = applicationConfigurationService.get("pg.mid", "938425").toString();
			userName = applicationConfigurationService.get("pg.username", "selfcare").toString();
			credential = applicationConfigurationService.get("pg.credential", "selfcare").toString();
			secretKey = applicationConfigurationService.get("pg.secretkey", "646ed314-8").toString();

			requestDateFormat = applicationConfigurationService.get("pg.datetimeformat", "ddMMyyyy HH:mm:ss:SSS").toString();

			if (appId.equals(ClientAppId.MOBILE_APP)) {
				callBackUrl = applicationConfigurationService
						.get("pg.callbackurl.api", "http://10.8.8.31:8181/webapi/pg/callback").toString();
			} else {
				callBackUrl = applicationConfigurationService
						.get("pg.callbackurl.api", "http://10.8.8.31:8383/pg/callback").toString();
			}
			
			napasCallbackURL = applicationConfigurationService.get("pg.napas.callbackurl", "http://10.0.0.36:8080/merchant/status/callBackURL").toString();
			napasCancelURL = applicationConfigurationService.get("pg.napas.cancelurl", "http://202.172.4.55/webapi/pg/cancelPayment?orderId=").toString();
			
			successRespCode = applicationConfigurationService.get("pg.responsecode.success", SUCCESS_RESP).toString();

			amount = history.getAmount().intValue();
			msisdn = history.getMsisdn();
			itemCode = history.getItemCode();

			//get preferred language of the subscriber
			if (!StringUtils.hasText(language)) {
				try {
					SubscriberEntity sub = subscriberRepository.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(msisdn));
					if (sub != null) {
						if (sub.getLanguageCode().equalsIgnoreCase(AppDefaultValues.LANGUAGE_ENGLISH)) {
							language = "E";
						}else if (sub.getLanguageCode().equalsIgnoreCase(AppDefaultValues.LANGUAGE_VIETNAMESE)) {
							language = "VN";
						}
					}
				} catch (Exception e) {
					logger.error("#makePayment --- could not get subscriber info for MSISDN " + msisdn);
				}
			}
			
			if (!StringUtils.hasText(language)) language = "VN";
			
			Date requestTime = new Date();
			PaymentRequest request = new PaymentRequest();
			request.setAmount(amount);
			request.setCallBackUrl(callBackUrl);
			request.setCardType("");
			request.setChannel(channelId);
			request.setMid(mid);
			// SECRET KEY+ amount+mid+ orderId
			String checkSumHash = sha256(secretKey + amount + mid + orderId);
			request.setCheckSumHash(checkSumHash);
			request.setEmailId("");
			request.setIpAddress(InetAddress.getLocalHost().getHostAddress());
			request.setLanguageId(language);
			request.setMobileNumber(msisdn);
			
			request.setNapasCallBackURL(napasCallbackURL);
			request.setNapasCancelURL(napasCancelURL + orderId);
			
			request.setOrderId(orderId);
			request.setOrderInfo(itemCode);
			request.setRequestTime(AppUtils.dateToString(requestTime, requestDateFormat));
			request.setTxnType("");

			LoggingUtil.debug(logger, String.format("#makePayment(1) -- (MSISDN=%s, amount=%s, order_id=%s, language=%s) sending initial payment request to PG...", msisdn, "" + amount, orderId, language));

			restTemplate.setRequestFactory(getSimpleClientHttpRequestFactory(connectTimeout));
			HttpEntity<PaymentRequest> entity = new HttpEntity<PaymentRequest>(request, createHeaders(userName, credential));
			pgResponse = restTemplate.postForObject(url, entity, InitialResponse.class);

			LoggingUtil.debug(logger, String.format("#makePayment(1) -- (MSISDN=%s, amount=%s, order_id=%s) receiving initial response= ", msisdn, "" + amount, orderId) + pgResponse);
			
			// create payment history
			history.setCheckSumHash(checkSumHash);
			history.setIpAddress(request.getIpAddress());
			history.setOrderInfo(request.getOrderInfo());
			history.setRequestTime(requestTime);

		} catch (Exception e) {
			logger.error(String.format("#makePayment(1) -- error when initiating PG request(MSISDN=%s, amount=%s, order_id=%s)", msisdn, "" + amount, orderId), e);
			
		} finally{
			if (post != null) post.releaseConnection();
		}

		if (pgResponse == null) {
			history.setStatus(TransactionStatus.FAIL.ordinal());
			logger.error(String.format("#makePayment(1) -- NULL response received for initial PG request(MSISDN=%s, amount=%s, order_id=%s)", msisdn, "" + amount, orderId));
			try {
				paymentHistoryRepository.save(history);
			} catch (Exception e) {
				logger.error("#makePayment(1) --- error when updating payment history with order_id# " + orderId, e);
			}
			return pageContent;
		}
			
		if (pgResponse.getResultCode() == null || !pgResponse.getResultCode().equals(successRespCode)){
			history.setStatus(TransactionStatus.FAIL.ordinal());
			
			logger.error(String.format(
					"#makePayment(1) --- initial request to PG was not successful (order_id= %s, result_code= %s, result_msg= %s)",
					orderId, pgResponse.getResultCode(), pgResponse.getResponseMsg()));
			try {
				paymentHistoryRepository.save(history);
			} catch (Exception e) {
				logger.error("#makePayment(1) --- initial request to PG was not successful, error when updating payment history with order_id# " + orderId, e);
			}
			
			try {
				String trxType = history.getTrxType();
				if (trxType.equalsIgnoreCase(TransactionType.E_TOPUP.name())) {
					
					TopUpHistoryEntity topupHistory = topUpHistoryRepository.findOne(QTopUpHistoryEntity.topUpHistoryEntity.refTrxId.eq(orderId));
					if (topupHistory != null) {
						topupHistory.setStatus(TransactionStatus.FAIL.ordinal());
						topUpHistoryRepository.saveAndFlush(topupHistory);
					}

				} else if (trxType.equalsIgnoreCase(TransactionType.POSTPAID_BILL_PAYMENT.name()) || trxType.equalsIgnoreCase(TransactionType.POSTPAID_DEPOSIT.name())) {
					
					PostpaidBillPaymentHistoryEntity ph = postpaidBillPaymentHistoryRepository.findOne(
									QPostpaidBillPaymentHistoryEntity.postpaidBillPaymentHistoryEntity.refTrxId.eq(orderId));
					if (ph != null) {
						ph.setStatus(TransactionStatus.FAIL.ordinal());
						postpaidBillPaymentHistoryRepository.saveAndFlush(ph);
					}
				}				
			} catch (Exception e) {
				logger.error("#makePayment(1) --- error when updating transaction history for payment with order_id= "+ orderId, e); 
			}
			
			return pageContent;
		}

		history.setStatus(TransactionStatus.PROCESSING.ordinal());
		history.setRedirectURL(pgResponse.getRedirectionURL());
		history.setResponseTime(AppUtils.stringToDate(pgResponse.getResponseTime(), responseDateFormat));
		history.setInitialResultCode(pgResponse.getResultCode());
		history.setInitialResultMsg(pgResponse.getResponseMsg());
		history.setExtTrxId(pgResponse.getTransactionId());
		
		paymentHistoryRepository.save(history);
		
		CloseableHttpResponse response = null;
		LoggingUtil.debug(logger, "#makePayment(1) --- order_id= " + orderId + ", opening NAPAS page...");
		try {
			//open redirectionURL and get the page content and give it back to the browser to display payment page
			HttpClientContext context = HttpClientContext.create();
			post = new HttpPost(pgResponse.getRedirectionURL());
			response = getPgHttpClient().execute(post, context);

			ByteArrayOutputStream out = new ByteArrayOutputStream();
			org.apache.http.HttpEntity httpEntity = response.getEntity();
			httpEntity.writeTo(out);
			
			pageContent = new String(out.toByteArray(), "UTF-8");
			
			EntityUtils.consume(httpEntity);
			
		} catch (Exception e) {
			logger.error("#makePayment(1) --- order_id= " + orderId + ", error when opening NAPAS page!", e);

		} finally {
			if (post != null) post.releaseConnection();
			try {
				if (response != null) response.close();
			} catch (IOException e) { }
		}

		if (!StringUtils.hasText(pageContent)) {
			history.setStatus(TransactionStatus.FAIL.ordinal());
			
			LoggingUtil.debug(logger, "#makePayment(1) --- order_id= " + orderId + ", received NAPAS page was empty - transaction could not be processed.");
			try {
				paymentHistoryRepository.save(history);
			} catch (Exception e) {
				logger.error("#makePayment(1) --- received NAPAS page was empty - error when updating payment history with order_id# " + orderId, e);
			}
			
			try {
				String trxType = history.getTrxType();
				if (trxType.equalsIgnoreCase(TransactionType.E_TOPUP.name())) {
					
					TopUpHistoryEntity topupHistory = topUpHistoryRepository.findOne(QTopUpHistoryEntity.topUpHistoryEntity.refTrxId.eq(orderId));
					if (topupHistory != null) {
						topupHistory.setStatus(TransactionStatus.FAIL.ordinal());
						topUpHistoryRepository.saveAndFlush(topupHistory);
					}

				} else if (trxType.equalsIgnoreCase(TransactionType.POSTPAID_BILL_PAYMENT.name()) || trxType.equalsIgnoreCase(TransactionType.POSTPAID_DEPOSIT.name())) {
					
					PostpaidBillPaymentHistoryEntity ph = postpaidBillPaymentHistoryRepository.findOne(
									QPostpaidBillPaymentHistoryEntity.postpaidBillPaymentHistoryEntity.refTrxId.eq(orderId));
					if (ph != null) {
						ph.setStatus(TransactionStatus.FAIL.ordinal());
						postpaidBillPaymentHistoryRepository.saveAndFlush(ph);
					}
				}				
			} catch (Exception e) {
				logger.error("#makePayment(1) --- error when updating transaction history for payment with order_id= "+ orderId, e); 
			}
			
			return pageContent;
		}
		
		//start periodic query to NAPAS
		startTransactionDaemonDiscount(orderId, pgResponse.getTransactionId(), language);

		return pageContent;
	}
	//End by oneclick
	private void startTransactionDaemon(String orderId, String transactionId, String locale) {
		
		long trxTimeoutInSecs = Long.parseLong(applicationConfigurationService.get("napas.trxtimeout.seconds", "1800").toString()); //30 minutes
		long startTime = System.currentTimeMillis();
		int queryInterval = Integer.parseInt(applicationConfigurationService.get("napas.querydr.interval.seconds", "30").toString());
		
		final Timer timer = new Timer("napasTransactionDaemon-#" + transactionId);
		long delayBeforeStart = 30 * 1000;

		LoggingUtil.debug(logger, "#transactionDaemon --- starting transaction status query #" + transactionId);

		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				PaymentHistoryEntity paymentHistory = paymentHistoryRepository.findOne(QPaymentHistoryEntity.paymentHistoryEntity.orderId.eq(orderId)); 
						//paymentHistoryRepository.findOne(QPaymentHistoryEntity.paymentHistoryEntity.extTrxId.eq(transactionId));
				
				int status = paymentHistory.getStatus();
				if (status == TransactionStatus.PROCESSING.ordinal() ){
					String respCode = queryTrxStatusToNapas(transactionId);
					boolean timeOutReached = (System.currentTimeMillis() - startTime) > trxTimeoutInSecs * 1000;
					
					if (respCode.equals(NapasSuccessCode.SUCCESS.code())) {
						//fixed on Mar 10, 2018 --- no need to wait for timeout
						LoggingUtil.debug(logger,
								"#transactionDaemon --- stopping transaction status query #" + transactionId
										+ ", trx already completed successfully and time out has been reached, updating status to "
										+ TransactionStatus.SUCCESS.name());

						timer.cancel();

						try {
							paymentHistory.setStatus(TransactionStatus.SUCCESS.ordinal());
							paymentHistoryRepository.saveAndFlush(paymentHistory);
							
						} catch (Exception e) {
							logger.error("#transactionDaemon --- error when updating payment|topup history with trx_id# " + transactionId, e);
						}

						sendNotificationToPG(paymentHistory.getId(), transactionId, paymentHistory.getOrderId(),
								paymentHistory.getOrderInfo(), NapasSuccessCode.SUCCESS.code(), locale);
						
						if (paymentHistory.getTrxType() != null) {
							handleUserTransaction(orderId, paymentHistory.getExtTrxId(), TransactionType.valueOf(paymentHistory.getTrxType().toUpperCase()));	
						}

						/*
						if (timeOutReached) {
							LoggingUtil.debug(logger,
									"#transactionDaemon --- stopping transaction status query #" + transactionId
											+ ", trx already completed successfully and time out has been reached, updating status to "
											+ TransactionStatus.SUCCESS.name());

							timer.cancel();

							try {
								paymentHistory.setStatus(TransactionStatus.SUCCESS.ordinal());
								paymentHistoryRepository.save(paymentHistory);
								
							} catch (Exception e) {
								logger.error("#transactionDaemon --- error when updating payment|topup history with trx_id# " + transactionId, e);
							}

							sendNotificationToPG(paymentHistory.getId(), transactionId, paymentHistory.getOrderId(),
									paymentHistory.getOrderInfo(), NapasSuccessCode.SUCCESS.code(), locale);
							
							//if time out is detected and no final confirmation has been received from NAPAS/PG execute ETOPUP anyway
							handleUserTransaction(orderId, paymentHistory.getExtTrxId(), TransactionType.valueOf(paymentHistory.getTrxType().toUpperCase()));
						}
						*/
					} else {
						
						if (timeOutReached) {
							
							LoggingUtil.debug(logger, "#transactionDaemon --- stopping transaction status query #" + transactionId  + ", trx timed out detected.");

							timer.cancel();
							
							try {
								LoggingUtil.debug(logger, "#transactionDaemon --- updating transaction status trxId#" + transactionId  + " to= " + TransactionStatus.TIME_OUT.name());
								
								paymentHistory.setStatus(TransactionStatus.TIME_OUT.ordinal());
								paymentHistoryRepository.save(paymentHistory);

								if (paymentHistory.getStatus() >= TransactionStatus.FAIL.ordinal() && paymentHistory.getTrxType() != null) {
									
									TransactionType trxType = TransactionType.valueOf(paymentHistory.getTrxType());
									
									if (trxType.equals(TransactionType.E_TOPUP)) {
										
										TopUpHistoryEntity topupHistory = topUpHistoryRepository.findOne(QTopUpHistoryEntity.topUpHistoryEntity.refTrxId.eq(orderId));
										if (topupHistory != null) {
											topupHistory.setStatus(paymentHistory.getStatus());
											topUpHistoryRepository.saveAndFlush(topupHistory);
										}

									} else if (trxType.equals(TransactionType.POSTPAID_BILL_PAYMENT) || trxType.equals(TransactionType.POSTPAID_DEPOSIT)) {
										
										PostpaidBillPaymentHistoryEntity ph = postpaidBillPaymentHistoryRepository.findOne(
														QPostpaidBillPaymentHistoryEntity.postpaidBillPaymentHistoryEntity.refTrxId.eq(orderId));
										if (ph != null) {
											ph.setStatus(paymentHistory.getStatus());
											postpaidBillPaymentHistoryRepository.saveAndFlush(ph);
										}
									}
								}
							} catch (Exception e) {
								logger.error("#transactionDaemon --- error when updating payment|topup history with trx_id# " + transactionId, e);
							}
							
							sendNotificationToPG(paymentHistory.getId(), transactionId, orderId,
									paymentHistory.getOrderInfo(), NapasErrorCode.TRANSACTION_TIMEOUT.code(), locale);
						} 
					}

				} else {
					timer.cancel();
					LoggingUtil.debug(logger, "#transactionDaemon --- not running transaction status query #" + transactionId  + ", trx already completed with status= " + paymentHistory.getStatus());
				}

			}
		}, delayBeforeStart, queryInterval * 1000);
	}
//create by oneclick 
private void startTransactionDaemonDiscount(String orderId, String transactionId, String locale) {
		
		long trxTimeoutInSecs = Long.parseLong(applicationConfigurationService.get("napas.trxtimeout.seconds", "1800").toString()); //30 minutes
		long startTime = System.currentTimeMillis();
		int queryInterval = Integer.parseInt(applicationConfigurationService.get("napas.querydr.interval.seconds", "30").toString());
		
		final Timer timer = new Timer("napasTransactionDaemon-#" + transactionId);
		long delayBeforeStart = 30 * 1000;

		LoggingUtil.debug(logger, "#transactionDaemon --- starting transaction status query #" + transactionId);

		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				PaymentHistoryEntity paymentHistory = paymentHistoryRepository.findOne(QPaymentHistoryEntity.paymentHistoryEntity.orderId.eq(orderId)); 
						//paymentHistoryRepository.findOne(QPaymentHistoryEntity.paymentHistoryEntity.extTrxId.eq(transactionId));
				
				int status = paymentHistory.getStatus();
				if (status == TransactionStatus.PROCESSING.ordinal() ){
					String respCode = queryTrxStatusToNapas(transactionId);
					boolean timeOutReached = (System.currentTimeMillis() - startTime) > trxTimeoutInSecs * 1000;
					
					if (respCode.equals(NapasSuccessCode.SUCCESS.code())) {
						//fixed on Mar 10, 2018 --- no need to wait for timeout
						LoggingUtil.debug(logger,
								"#transactionDaemon --- stopping transaction status query #" + transactionId
										+ ", trx already completed successfully and time out has been reached, updating status to "
										+ TransactionStatus.SUCCESS.name());

						timer.cancel();

						try {
							paymentHistory.setStatus(TransactionStatus.SUCCESS.ordinal());
							paymentHistoryRepository.saveAndFlush(paymentHistory);
							
						} catch (Exception e) {
							logger.error("#transactionDaemon --- error when updating payment|topup history with trx_id# " + transactionId, e);
						}

						sendNotificationToPG(paymentHistory.getId(), transactionId, paymentHistory.getOrderId(),
								paymentHistory.getOrderInfo(), NapasSuccessCode.SUCCESS.code(), locale);
						
						if (paymentHistory.getTrxType() != null) {
							handleUserTransactiondiscount(orderId, paymentHistory.getExtTrxId(), TransactionType.valueOf(paymentHistory.getTrxType().toUpperCase()));	
						}

						/*
						if (timeOutReached) {
							LoggingUtil.debug(logger,
									"#transactionDaemon --- stopping transaction status query #" + transactionId
											+ ", trx already completed successfully and time out has been reached, updating status to "
											+ TransactionStatus.SUCCESS.name());

							timer.cancel();

							try {
								paymentHistory.setStatus(TransactionStatus.SUCCESS.ordinal());
								paymentHistoryRepository.save(paymentHistory);
								
							} catch (Exception e) {
								logger.error("#transactionDaemon --- error when updating payment|topup history with trx_id# " + transactionId, e);
							}

							sendNotificationToPG(paymentHistory.getId(), transactionId, paymentHistory.getOrderId(),
									paymentHistory.getOrderInfo(), NapasSuccessCode.SUCCESS.code(), locale);
							
							//if time out is detected and no final confirmation has been received from NAPAS/PG execute ETOPUP anyway
							handleUserTransaction(orderId, paymentHistory.getExtTrxId(), TransactionType.valueOf(paymentHistory.getTrxType().toUpperCase()));
						}
						*/
					} else {
						
						if (timeOutReached) {
							
							LoggingUtil.debug(logger, "#transactionDaemon --- stopping transaction status query #" + transactionId  + ", trx timed out detected.");

							timer.cancel();
							
							try {
								LoggingUtil.debug(logger, "#transactionDaemon --- updating transaction status trxId#" + transactionId  + " to= " + TransactionStatus.TIME_OUT.name());
								
								paymentHistory.setStatus(TransactionStatus.TIME_OUT.ordinal());
								paymentHistoryRepository.save(paymentHistory);

								if (paymentHistory.getStatus() >= TransactionStatus.FAIL.ordinal() && paymentHistory.getTrxType() != null) {
									
									TransactionType trxType = TransactionType.valueOf(paymentHistory.getTrxType());
									
									if (trxType.equals(TransactionType.E_TOPUP)) {
										
										TopUpHistoryEntity topupHistory = topUpHistoryRepository.findOne(QTopUpHistoryEntity.topUpHistoryEntity.refTrxId.eq(orderId));
										if (topupHistory != null) {
											topupHistory.setStatus(paymentHistory.getStatus());
											topUpHistoryRepository.saveAndFlush(topupHistory);
										}

									} else if (trxType.equals(TransactionType.POSTPAID_BILL_PAYMENT) || trxType.equals(TransactionType.POSTPAID_DEPOSIT)) {
										
										PostpaidBillPaymentHistoryEntity ph = postpaidBillPaymentHistoryRepository.findOne(
														QPostpaidBillPaymentHistoryEntity.postpaidBillPaymentHistoryEntity.refTrxId.eq(orderId));
										if (ph != null) {
											ph.setStatus(paymentHistory.getStatus());
											postpaidBillPaymentHistoryRepository.saveAndFlush(ph);
										}
									}
								}
							} catch (Exception e) {
								logger.error("#transactionDaemon --- error when updating payment|topup history with trx_id# " + transactionId, e);
							}
							
							sendNotificationToPG(paymentHistory.getId(), transactionId, orderId,
									paymentHistory.getOrderInfo(), NapasErrorCode.TRANSACTION_TIMEOUT.code(), locale);
						} 
					}

				} else {
					timer.cancel();
					LoggingUtil.debug(logger, "#transactionDaemon --- not running transaction status query #" + transactionId  + ", trx already completed with status= " + paymentHistory.getStatus());
				}

			}
		}, delayBeforeStart, queryInterval * 1000);
	}
	
	
	/**
	 * Notify PG if transaction timed out, simulating NAPAS
	 * @param trxId
	 * @param respCode
	 */
	private void sendNotificationToPG(Integer intTrxId, String trxId, String orderId, String orderInfo, String respCode, String locale) {
		LoggingUtil.debug(logger, String.format("#sendNotificationToPG --- (ext_trx_id=%s), sending trx notification to PG...", trxId));
		
		CloseableHttpResponse response = null;
		try {
			
			PaymentHistoryEntity paymentHistory = paymentHistoryRepository.findOne(intTrxId);
			boolean notifSent = paymentHistory.getPgNotificationSent() != null && paymentHistory.getPgNotificationSent().equals(1);
			if (notifSent) {
				LoggingUtil.info(logger, String.format("#sendNotificationToPG --- (ext_trx_id=%s), trx notification has previously been sent to PG.", trxId));
				return;
			}
			
			
			String callbackURL = applicationConfigurationService.get("pg.paymentdone.callbackurl", "").toString();
			String mid = applicationConfigurationService.get("pg.mid", "938425").toString();

			List<NameValuePair> paramList = new ArrayList<>();
			
			//vpc_AdditionalData=970400&vpc_Amount=1000000&vpc_BatchNo=20171214&vpc_Command=pay&
			//vpc_CurrencyCode=VND&vpc_Locale=en&vpc_MerchTxnRef=100224320069922&vpc_Merchant=SMLTEST&
			//vpc_OrderInfo=ETOPUP_01888044003_20171213154758667&vpc_ResponseCode=0&
			//vpc_TransactionNo=835502228&vpc_Version=2.0&vpc_SecureHash=5261522627FE8D682AFD0FD912770A4E&vpc_CardType=Smartlink+Car
			
			paramList.add(new BasicNameValuePair("vpc_AdditionalData", ""));
			paramList.add(new BasicNameValuePair("vpc_Amount", "0"));
			paramList.add(new BasicNameValuePair("vpc_BatchNo", ""));
			paramList.add(new BasicNameValuePair("vpc_Command", ""));
			paramList.add(new BasicNameValuePair("vpc_CurrencyCode", "VND"));
			paramList.add(new BasicNameValuePair("vpc_Locale", locale));
			
			paramList.add(new BasicNameValuePair("vpc_MerchTxnRef", trxId));
			paramList.add(new BasicNameValuePair("vpc_Merchant", mid));
			paramList.add(new BasicNameValuePair("vpc_OrderInfo", orderInfo));
			paramList.add(new BasicNameValuePair("vpc_ResponseCode", respCode));
			paramList.add(new BasicNameValuePair("vpc_TransactionNo", trxId));

			paramList.add(new BasicNameValuePair("vpc_SecureHash", ""));
			paramList.add(new BasicNameValuePair("vpc_CardType", ""));
			
			HttpClientContext context = HttpClientContext.create();
			HttpPost post = new HttpPost(callbackURL);
			post.setEntity(new UrlEncodedFormEntity(paramList));
			
			response = getPgHttpClient().execute(post, context);
			
			if (response != null) {
				LoggingUtil.debug(logger, String.format("#sendNotificationToPG --- (ext_trx_id=%s), receiving response_code from PG= %d", trxId, response.getStatusLine().getStatusCode()));
			} else {
				LoggingUtil.info(logger, String.format("#sendNotificationToPG --- (ext_trx_id=%s), not receiving any response from PG", trxId));
			}
			
			EntityUtils.consume(response.getEntity());
			
			paymentHistory.setPgNotificationSent(1);
			paymentHistoryRepository.saveAndFlush(paymentHistory);
			
		} catch (Exception e) {
			logger.error(String.format("#sendNotificationToPG --- (ext_trx_id=%s), error when sending trx notification to PG.", trxId), e);
		} finally {
			try {
				if (response != null) response.close();
			} catch (IOException e) {}
		}
	}
	
	private String queryTrxStatusToNapas(String refTrxId) {

		try {

			//check internal status first to avoid unnecessary query 
			PaymentHistoryEntity history = paymentHistoryRepository.findOne(QPaymentHistoryEntity.paymentHistoryEntity.extTrxId.eq(refTrxId));
			
			if (history == null) return "";
			if (!history.getStatus().equals(TransactionStatus.PROCESSING.ordinal())) return "";
				
			LoggingUtil.debug(logger, "#queryTrxStatusToNapas --- querying transaction status to NAPAS for ext_trx_id= " + refTrxId);
			
			String secretKey = applicationConfigurationService.get("napas.secretkey", "AF0EAFF75EA44DB0AAE472BE55177CC9").toString();
			String _url = applicationConfigurationService.get("napas.querydr.url", "https://sandbox.napas.com.vn/gateway/vpcdps").toString();

			String vpc_Version = applicationConfigurationService.get("napas.querydr.version", "2.2").toString();
			String vpc_Command = applicationConfigurationService.get("napas.querydr.command", "queryDR").toString();
			String vpc_AccessCode = applicationConfigurationService.get("napas.accesscode", "V1IE3TN5AM4OBI6L7E8").toString();
			String vpc_Merchant = applicationConfigurationService.get("napas.merchantid", "VIETNAMOBILE").toString();
			String vpc_User = applicationConfigurationService.get("napas.user", "querydr").toString();
			String vpc_Password = applicationConfigurationService.get("napas.password", "vietnamobile@123").toString();

			String input = secretKey + vpc_AccessCode + vpc_Command + refTrxId + vpc_Merchant + vpc_Password + vpc_User + vpc_Version ;

			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(input.getBytes());
			byte byteData[] = md.digest();
			
			StringBuffer vpc_SecureHash = new StringBuffer();
	        for (int i = 0; i < byteData.length; i++) {
	        		vpc_SecureHash.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }

	        StringBuffer params = new StringBuffer();
	        params.append("?vpc_Version=").append(vpc_Version).append("&");
	        params.append("vpc_Command=").append(vpc_Command).append("&");
	        params.append("vpc_AccessCode=").append(vpc_AccessCode).append("&");
	        params.append("vpc_Merchant=").append(vpc_Merchant).append("&");
	        params.append("vpc_MerchTxnRef=").append(refTrxId).append("&");
	        params.append("vpc_User=").append(vpc_User).append("&");
	        params.append("vpc_Password=").append(vpc_Password).append("&");
	        params.append("vpc_SecureHash=").append(vpc_SecureHash.toString().toUpperCase());
	        
	        LoggingUtil.debug(logger, "#queryTrxStatusToNapas --- ext_trx_id= " + refTrxId + ", sending params= " + params.toString());
			HttpClientContext context = HttpClientContext.create();
			HttpGet get = new HttpGet(_url + params.toString());
			
			CloseableHttpClient httpClient = getNapasHttpClient();
			CloseableHttpResponse respBody = httpClient.execute(get, context);
			LoggingUtil.debug(logger, "#queryTrxStatusToNapas --- ext_trx_id= " + refTrxId + ", receiving response= " + (respBody != null ? respBody.getStatusLine() : null) );
			
			if (respBody != null) {
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				org.apache.http.HttpEntity httpEntity = respBody.getEntity();
				httpEntity.writeTo(out);
				
				String response = new String(out.toByteArray());
				LoggingUtil.debug(logger, "#queryTrxStatusToNapas --- ext_trx_id= " + refTrxId + ", response content= " + response);
						
				String[] nvpList = response.split("&");
				if (nvpList != null && nvpList.length > 0) {
					for (String nvp : nvpList) {
						String[] arr = nvp.split("=");
						if (arr != null && arr.length >= 2) {
							if (arr[0].equalsIgnoreCase("vpc_TxnResponseCode")) {
								String respCode = arr[1];
								LoggingUtil.debug(logger, String.format("#queryTrxStatusToNapas --- ext_trx_id= %s, status_code= %s", refTrxId, respCode));
								
								return respCode;
							}
						}
					}
				}
				EntityUtils.consume(httpEntity);
				//httpClient.close();
			}
		} catch (Exception e) {
			logger.error("#queryTrxStatusToNapas --- error when querying trx status to NAPAS for ext_trx_id " + refTrxId, e);
		}
		return "";
	}
	
	
	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.PaymentGatewayService#getPaymentStatus(java.lang.String)
	 */
	@Override
	public TransactionStatus getTransactionStatus(String orderId) {
		
		try {
			PaymentHistoryEntity history = paymentHistoryRepository.findOne(QPaymentHistoryEntity.paymentHistoryEntity.orderId.eq(orderId));
			if (history != null){
				return TransactionStatus.fromInt(history.getStatus());
			}
		} catch (Exception e) {
			logger.error("#getPaymentStatus -- error getting transaction status from DB, order_id= " + orderId, e);
		}
		return TransactionStatus.NOT_FOUND;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.PaymentGatewayService#updatePaymentStatus(java.lang.String, java.lang.Integer)
	 */
	@Override
	public void updateTransactionStatus(String orderId, Integer status) {
		try {
			PaymentHistoryEntity history = paymentHistoryRepository.findOne(QPaymentHistoryEntity.paymentHistoryEntity.orderId.eq(orderId));
			if (history != null){
				history.setStatus(status);
				paymentHistoryRepository.save(history);
			}
		} catch (Exception e) {
			logger.error("#getPaymentStatus -- error getting transaction status from DB, order_id= " + orderId, e);
		}
	}

	/*
	private boolean trxInProgress(String respCode) {

		return respCode.equals(NapasSuccessCode.CARD_VERIFICATION_SUCCESSFUL.code()) 
				|| respCode.equals(NapasSuccessCode.AWAITING_BANK_CONFIRMATION.code()) 
				|| respCode.equals(NapasSuccessCode.ORDER_NOT_TO_MAKE_PAYMENT.code());
	}
	
	private boolean trxFailed(String respCode) {
		for (NapasErrorCode nec : NapasErrorCode.values()) {
			if (respCode.equals(nec.code())) return true;
		}
		return false;
	}
	*/
	
	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.PaymentGatewayService#confirmPayment(java.lang.String, com.gnv.vnm.selfcare.core.enums.RequestStatus)
	 */
	@Override
	public String confirmTransaction(String orderId, TransactionStatus status) throws TransactionNotFoundException, Exception {
		if (!StringUtils.hasText(orderId)) return null;
		
		try {
			LoggingUtil.debug(logger, "#confirmTransaction(1) -- updating payment status for order_id= " + orderId + ", status= " + status);
			
			PaymentHistoryEntity history = paymentHistoryRepository.findOne(QPaymentHistoryEntity.paymentHistoryEntity.orderId.eq(orderId));
			if (history == null){
				logger.error("#confirmTransaction(1) -- could not find Payment History with order_id= " + orderId);
				throw new TransactionNotFoundException("Transaction not found, order_id= " + orderId);
				
			}else {
				if (history.getStatus() >= TransactionStatus.SUCCESS.ordinal()) {
					logger.warn(String.format("#confirmTransaction(1) -- transaction with order_id %s has already finished.", orderId));
					
					return history.getExtTrxId();
					
				} else {
					history.setStatus(status.ordinal());
					paymentHistoryRepository.saveAndFlush(history);
					
					if (status.equals(TransactionStatus.SUCCESS) && StringUtils.hasText(history.getTrxType())){
						handleUserTransaction(history.getOrderId(), history.getExtTrxId(), TransactionType.valueOf(history.getTrxType().toUpperCase()));
						
					} else if (status.equals(TransactionStatus.CANCELED)){

						TransactionType trxType = TransactionType.valueOf(history.getTrxType());
						if (trxType != null) {
							if (trxType.equals(TransactionType.E_TOPUP)) {
								try {
									TopUpHistoryEntity th = topUpHistoryRepository.findOne(QTopUpHistoryEntity.topUpHistoryEntity.refTrxId.eq(orderId));
									if (th != null) {
										th.setStatus(TransactionStatus.CANCELED.ordinal());
										topUpHistoryRepository.saveAndFlush(th);
									}
								} catch (Exception e) {
									logger.error("#confirmTransaction(1) --- error when updating topup_history with ref_trx_id= " + orderId, e);
								}
								
							} else if (trxType.equals(TransactionType.POSTPAID_BILL_PAYMENT) || trxType.equals(TransactionType.POSTPAID_DEPOSIT)) {
								//TODO --- added on Jan 22, 2018 for post paid support
								try {
									PostpaidBillPaymentHistoryEntity ph = postpaidBillPaymentHistoryRepository.findOne(
											QPostpaidBillPaymentHistoryEntity.postpaidBillPaymentHistoryEntity.refTrxId.eq(orderId));
									if (ph != null) {
										ph.setStatus(TransactionStatus.CANCELED.ordinal());
										postpaidBillPaymentHistoryRepository.saveAndFlush(ph);
									}
								} catch (Exception e) {
									logger.error("#confirmTransaction(1) --- error when updating postpaid_pmt_history with ref_trx_id= " + orderId, e);
								}
							}
						}						
					}
					
					return history.getExtTrxId();
				}
			}

		} catch (Exception e) {
			logger.error("#confirmTransaction(1) -- error occurred when updating payment_history status (orderId= " + orderId + ")", e);
			throw e;     
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gnv.vnm.selfcare.core.service.PaymentGatewayService#confirmPayment(
	 * com.gnv.vnm.selfcare.core.model.pg.FinalResponse)
	 */
	@Override
	public boolean confirmTransaction(FinalResponse finalResponse) throws TransactionNotFoundException {
		
		LoggingUtil.debug(logger, "#confirmTransaction(2) -- receiving final response from PG= " + finalResponse);
		
		String orderId = finalResponse.getOrderId();
		PaymentHistoryEntity history = paymentHistoryRepository.findOne(QPaymentHistoryEntity.paymentHistoryEntity.orderId.eq(orderId));
		if (history == null){
			logger.error("#confirmTransaction(2) -- could not find Payment History with orderId= " + orderId);
			
			throw new TransactionNotFoundException("Transactionn not found, orderId= " + orderId);
			
		} else {
			if (history.getStatus() >= TransactionStatus.SUCCESS.ordinal()) {
				logger.warn(String.format("#confirmTransaction(2) -- transaction with order_id %s has already finished.", orderId));
				
				return true;
				
			} else {
				history.setFinalResultCode(finalResponse.getResultCode());
				history.setFinalResultMsg(finalResponse.getResponseMsg());
				history.setReferenceId(finalResponse.getReferenceId());
				
				if (StringUtils.hasText(finalResponse.getResultCode()) && finalResponse.getResultCode().equals(successRespCode)){
					history.setStatus(TransactionStatus.SUCCESS.ordinal());
				}else{
					history.setStatus(TransactionStatus.FAIL.ordinal());
				}

				LoggingUtil.debug(logger, "#confirmTransaction(2) -- updating payment trx with orderId = " + orderId + ", status= " + history.getStatus());
				paymentHistoryRepository.saveAndFlush(history);
				
				boolean success = finalResponse.getResultCode().equals(successRespCode) ? true : false;
				if (success || (history.getStatus() >= TransactionStatus.SUCCESS.ordinal() && StringUtils.hasText(history.getTrxType())) ){
					handleUserTransaction(finalResponse.getOrderId(), history.getExtTrxId(), TransactionType.valueOf(history.getTrxType().toUpperCase()));
				
				} else {
					
					TransactionType trxType = TransactionType.valueOf(history.getTrxType());
					if (trxType != null) {
						if (trxType.equals(TransactionType.E_TOPUP)) {
							try {
								TopUpHistoryEntity th = topUpHistoryRepository.findOne(QTopUpHistoryEntity.topUpHistoryEntity.refTrxId.eq(orderId));
								if (th != null) {
									th.setStatus(TransactionStatus.FAIL.ordinal());
									topUpHistoryRepository.saveAndFlush(th);
								}
							} catch (Exception e) {
								logger.error("#confirmTransaction(2) --- error when updating topup_history with ref_trx_id= " + orderId, e);
							}
							
						} else if (trxType.equals(TransactionType.POSTPAID_BILL_PAYMENT) || trxType.equals(TransactionType.POSTPAID_DEPOSIT)) {
							//TODO --- added on Jan 22, 2018 for post paid support
							try {
								PostpaidBillPaymentHistoryEntity ph = postpaidBillPaymentHistoryRepository.findOne(
										QPostpaidBillPaymentHistoryEntity.postpaidBillPaymentHistoryEntity.refTrxId.eq(orderId));
								if (ph != null) {
									ph.setStatus(TransactionStatus.FAIL.ordinal());
									postpaidBillPaymentHistoryRepository.saveAndFlush(ph);
								}
							} catch (Exception e) {
								logger.error("#confirmTransaction(2) --- error when updating postpaid_pmt_history with ref_trx_id= " + orderId, e);
							}
						}
					}
				}
				return success;
			}
		}

	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.PaymentGatewayService#getOrderIdByExtTrxId(java.lang.String)
	 */
	@Override
	public String getOrderIdByExtTrxId(String extTrxId) {
		if (!StringUtils.hasText(extTrxId)) return "";
		try {
			PaymentHistoryEntity history = paymentHistoryRepository.findOne(QPaymentHistoryEntity.paymentHistoryEntity.extTrxId.eq(extTrxId));
			return history != null ? history.getOrderId() : "";
		} catch (Exception e) {
			logger.error("#getOrderIdByExtTrxId --- error retriving order_id for ext_trx_id= " + extTrxId, e);
		}
		return "";
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.PaymentGatewayService#getBankDetails(java.lang.String)
	 */
	@Override
	public Bank getBankDetails(String code) {
		
		try {
//			BankEntity source = bankRepository.findOne(QBankEntity.bankEntity.code.equalsIgnoreCase(code));
			BankEntity source = bankRepository.findOne(QBankEntity.bankEntity.code.startsWithIgnoreCase(code));
			if (source != null) {
				return new Bank(source.getId(), source.getCode(), source.getName(), source.getDisplayName());
			}
		} catch (Exception e) {
			logger.error("#getBankDetails --- error getting bank details, bank_code= " + code, e);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.PaymentGatewayService#refund(com.gnv.vnm.selfcare.core.model.pg.RefundRequest)
	 */
	@Override
	public boolean refund(String orderId) {
		try {
			PaymentHistoryEntity history = paymentHistoryRepository.findOne(QPaymentHistoryEntity.paymentHistoryEntity.orderId.eq(orderId));
			if (history == null) {
				LoggingUtil.info(logger, "#refund --- no data found for order_id " + orderId);
				return false;
			}
			
			url = applicationConfigurationService.get("pg.refundurl", "http://10.8.2.165:19092/vnmbl/VNM/refundPayment").toString();
			channelId = applicationConfigurationService.get("pg.channelid", "SELFCARE").toString();
			mid = applicationConfigurationService.get("pg.mid", "938425").toString();
			userName = applicationConfigurationService.get("pg.username", "selfcare").toString();
			credential = applicationConfigurationService.get("pg.credential", "selfcare").toString();
			secretKey = applicationConfigurationService.get("pg.secretkey", "646ed314-8").toString();
			requestDateFormat = applicationConfigurationService.get("pg.datetimeformat", "ddMMyyyy HH:mm:ss:SSS").toString();
			language = applicationConfigurationService.get("pg.language", "E").toString();
			
			int amount = history.getAmount() != null ? history.getAmount().intValue() : 0;
			
			if (amount > 0) {
				LoggingUtil.info(logger, "#refund --- performing REFUND for order_id " + orderId + ", trx_amount= " + amount);

				RefundRequest request = new RefundRequest(orderId, language, channelId, mid, history.getAmount().intValue(), 
						AppUtils.dateToString(new Date(), requestDateFormat), history.getReferenceId(), userName, credential);

				restTemplate.setRequestFactory(getSimpleClientHttpRequestFactory(connectTimeout));
				HttpEntity<RefundRequest> entity = new HttpEntity<RefundRequest>(request, createHeaders(userName, credential));
				
				RefundResponse response = restTemplate.postForObject(url, entity, RefundResponse.class);

				LoggingUtil.info(logger, "#refund --- order_id = " + orderId + ", response from PG= " + response);
				
				if (response.getResultCode().equals(SUCCESS_RESP)) {
					history.setStatus(TransactionStatus.ROLL_BACK.ordinal());
					paymentHistoryRepository.save(history);
				}
			}else {
				LoggingUtil.error(logger, "#refund --- not performing REFUND for order_id " + orderId + ", transaction amount is 0.", null);
			}
			
		} catch (Exception e) {
			logger.error("#refund --- error occured when performing refund for orderId#" + orderId, e);
		}
		return false;
	}
	
	//refund discount
	@Override
	public boolean refundDiscount(String orderId) {
		try {
			PaymentHistoryEntity history = paymentHistoryRepository.findOne(QPaymentHistoryEntity.paymentHistoryEntity.orderId.eq(orderId));
			if (history == null) {
				LoggingUtil.info(logger, "#refund --- no data found for order_id " + orderId);
				return false;
			}
			
			url = applicationConfigurationService.get("pg.refundurl", "http://10.8.2.165:19092/vnmbl/VNM/refundPayment").toString();
			channelId = applicationConfigurationService.get("pg.channelid", "SELFCARE").toString();
			mid = applicationConfigurationService.get("pg.mid", "938425").toString();
			userName = applicationConfigurationService.get("pg.username", "selfcare").toString();
			credential = applicationConfigurationService.get("pg.credential", "selfcare").toString();
			secretKey = applicationConfigurationService.get("pg.secretkey", "646ed314-8").toString();
			requestDateFormat = applicationConfigurationService.get("pg.datetimeformat", "ddMMyyyy HH:mm:ss:SSS").toString();
			language = applicationConfigurationService.get("pg.language", "E").toString();
			
			int amount = history.getAmount() != null ? history.getAmount().intValue() : 0;
			
			if (amount > 0) {
				LoggingUtil.info(logger, "#refund --- performing REFUND for order_id " + orderId + ", trx_amount= " + amount);

				RefundRequest request = new RefundRequest(orderId, language, channelId, mid, history.getAmount().intValue(), 
						AppUtils.dateToString(new Date(), requestDateFormat), history.getReferenceId(), userName, credential);

				restTemplate.setRequestFactory(getSimpleClientHttpRequestFactory(connectTimeout));
				HttpEntity<RefundRequest> entity = new HttpEntity<RefundRequest>(request, createHeaders(userName, credential));
				
				RefundResponse response = restTemplate.postForObject(url, entity, RefundResponse.class);

				LoggingUtil.info(logger, "#refund --- order_id = " + orderId + ", response from PG= " + response);
				
				if (response.getResultCode().equals(SUCCESS_RESP)) {
					history.setStatus(TransactionStatus.ROLL_BACK.ordinal());
					paymentHistoryRepository.save(history);
				}
			}else {
				LoggingUtil.error(logger, "#refund --- not performing REFUND for order_id " + orderId + ", transaction amount is 0.", null);
			}
			
		} catch (Exception e) {
			logger.error("#refund --- error occured when performing refund for orderId#" + orderId, e);
		}
		return false;
	}

	@Async
	public void handleUserTransaction(String orderId, String refTrxId, TransactionType trxType){
	
		//double check if payment with the given order_id does exist
		PaymentHistoryEntity pmtHistory = paymentHistoryRepository.findOne(QPaymentHistoryEntity.paymentHistoryEntity.orderId.eq(orderId));
		if (pmtHistory == null) {
			logger.error("#handleUserTransaction --- not executing transaction, no payment history exists with order_id= " + orderId);
			return;
		} else {
			if (!pmtHistory.getStatus().equals(TransactionStatus.SUCCESS.ordinal())) {
				logger.error("#handleUserTransaction --- not executing transaction, no payment history exists with order_id= " + orderId);
				return;
			}
		}
		
		LoggingUtil.debug(logger, "#handleUserTransaction --- start handling user transaction, order_id= " + orderId + ", trx_type= " + trxType);
		
		taskExecutor.execute(new Runnable() {
			
			@Override
			public void run() {
				if (trxType.equals(TransactionType.E_TOPUP)){
					try {
						TopUpHistoryEntity topupHistory = topUpHistoryRepository.findOne(QTopUpHistoryEntity.topUpHistoryEntity.refTrxId.eq(orderId));

						if (topupHistory != null && (topupHistory.getStatus() == null || topupHistory.getStatus().equals(TransactionStatus.PROCESSING.ordinal())) ) {
							RechargeResponse etopupResp = backEndRequestProcessor.etopUp(topupHistory.getMsisdn(), topupHistory.getAmount(), orderId, topupHistory.getReferrer());
							
							LoggingUtil.debug(logger, "#handleUserTransaction --- etopup " + topupHistory.getRefTrxId() + " result= " + etopupResp);
							
							if (!StringUtils.hasText(etopupResp.getCode()) || !etopupResp.getCode().equals(TibcoResponse.SUCCESS.code())) {
								topupHistory.setStatus(TransactionStatus.FAIL.ordinal());
								topUpHistoryRepository.save(topupHistory);

								refund(orderId);
							} else {
								topupHistory.setStatus(TransactionStatus.SUCCESS.ordinal());
								topUpHistoryRepository.save(topupHistory);
							}
						} else {
							LoggingUtil.info(logger,
									"#handleUserTransaction --- not executing etopup " + topupHistory.getRefTrxId()
											+ " has already been completed with status= "
											+ topupHistory.getStatus());
						}
						
					} catch (Exception e) {
						logger.error("#handleUserTransaction --- error when processing e_topup for order_id= " + orderId, e);
					}
					
				} else if (trxType.equals(TransactionType.POSTPAID_BILL_PAYMENT) || trxType.equals(TransactionType.POSTPAID_DEPOSIT)) {
					
					try {
						PostpaidBillPaymentHistoryEntity history = postpaidBillPaymentHistoryRepository.findOne(
								QPostpaidBillPaymentHistoryEntity.postpaidBillPaymentHistoryEntity.refTrxId.eq(refTrxId));
						
						if (history != null && (history.getStatus() == null || history.getStatus().equals(TransactionStatus.PROCESSING.ordinal())) ) {
								
							String reference = history.getRefTrxId();
							
							boolean result = tibcoServiceProvider.postpaidBillPayment(history.getMsisdn(), history.getAmount(), reference, trxType);

							LoggingUtil.debug(logger,
									"#handleUserTransaction --- postpaid bill payment ref_trx_id= "
											+ history.getRefTrxId() + ", amount = " + history.getAmount()
											+ ", result= " + result);
							
							history.setStatus(result ? TransactionStatus.SUCCESS.ordinal() : TransactionStatus.FAIL.ordinal());
							postpaidBillPaymentHistoryRepository.saveAndFlush(history);
							
							if (!result) {
								refund(orderId);
							} 
						} 
						
					} catch (Exception e) {
						logger.error("#handleUserTransaction --- error when processing postpaid bill payment for order_id= " + orderId, e);
					}
				}
			}
		});
		LoggingUtil.debug(logger, "#handleUserTransaction --- end handling user transaction, order_id= " + orderId + ", trx_type= " + trxType);
	}
	
	//create by oneclik
	@Async
	public void handleUserTransactiondiscount(String orderId, String refTrxId, TransactionType trxType){
	
		//double check if payment with the given order_id does exist
		PaymentHistoryEntity pmtHistory = paymentHistoryRepository.findOne(QPaymentHistoryEntity.paymentHistoryEntity.orderId.eq(orderId));
		if (pmtHistory == null) {
			logger.error("#handleUserTransaction --- not executing transaction, no payment history exists with order_id= " + orderId);
			return;
		} else {
			if (!pmtHistory.getStatus().equals(TransactionStatus.SUCCESS.ordinal())) {
				logger.error("#handleUserTransaction --- not executing transaction, no payment history exists with order_id= " + orderId);
				return;
			}
		}
		
		LoggingUtil.debug(logger, "#handleUserTransaction --- start handling user transaction, order_id= " + orderId + ", trx_type= " + trxType);
		
		taskExecutor.execute(new Runnable() {
			
			@Override
			public void run() {
				if (trxType.equals(TransactionType.E_TOPUP)){
					try {
						TopUpHistoryEntity topupHistory = topUpHistoryRepository.findOne(QTopUpHistoryEntity.topUpHistoryEntity.refTrxId.eq(orderId));

						if (topupHistory != null && (topupHistory.getStatus() == null || topupHistory.getStatus().equals(TransactionStatus.PROCESSING.ordinal())) ) {
							
							//change by oneclick
							//RechargeResponse etopupResp = backEndRequestProcessor.etopUp(topupHistory.getMsisdn(), topupHistory.getAmount(), orderId, topupHistory.getReferrer());
							RechargeResponse etopupResp = backEndRequestProcessor.etopUp(topupHistory.getMsisdn(), topupHistory.getRecharge_amount(), orderId, topupHistory.getReferrer());
							
							LoggingUtil.debug(logger, "#handleUserTransaction --- etopup " + topupHistory.getRefTrxId() + " result= " + etopupResp);
							
							if (!StringUtils.hasText(etopupResp.getCode()) || !etopupResp.getCode().equals(TibcoResponse.SUCCESS.code())) {
								topupHistory.setStatus(TransactionStatus.FAIL.ordinal());
								topUpHistoryRepository.save(topupHistory);

								refundDiscount(orderId);
							} else {
								topupHistory.setStatus(TransactionStatus.SUCCESS.ordinal());
								topUpHistoryRepository.save(topupHistory);
							}
						} else {
							LoggingUtil.info(logger,
									"#handleUserTransaction --- not executing etopup " + topupHistory.getRefTrxId()
											+ " has already been completed with status= "
											+ topupHistory.getStatus());
						}
						
					} catch (Exception e) {
						logger.error("#handleUserTransaction --- error when processing e_topup for order_id= " + orderId, e);
					}
					
				} else if (trxType.equals(TransactionType.POSTPAID_BILL_PAYMENT) || trxType.equals(TransactionType.POSTPAID_DEPOSIT)) {
					
					try {
						PostpaidBillPaymentHistoryEntity history = postpaidBillPaymentHistoryRepository.findOne(
								QPostpaidBillPaymentHistoryEntity.postpaidBillPaymentHistoryEntity.refTrxId.eq(refTrxId));
						
						if (history != null && (history.getStatus() == null || history.getStatus().equals(TransactionStatus.PROCESSING.ordinal())) ) {
								
							String reference = history.getRefTrxId();
							
							boolean result = tibcoServiceProvider.postpaidBillPayment(history.getMsisdn(), history.getAmount(), reference, trxType);

							LoggingUtil.debug(logger,
									"#handleUserTransaction --- postpaid bill payment ref_trx_id= "
											+ history.getRefTrxId() + ", amount = " + history.getAmount()
											+ ", result= " + result);
							
							history.setStatus(result ? TransactionStatus.SUCCESS.ordinal() : TransactionStatus.FAIL.ordinal());
							postpaidBillPaymentHistoryRepository.saveAndFlush(history);
							
							if (!result) {
								refund(orderId);
							} 
						} 
						
					} catch (Exception e) {
						logger.error("#handleUserTransaction --- error when processing postpaid bill payment for order_id= " + orderId, e);
					}
				}
			}
		});
		LoggingUtil.debug(logger, "#handleUserTransaction --- end handling user transaction, order_id= " + orderId + ", trx_type= " + trxType);
	}
	
	
	private HttpHeaders createHeaders(String userName, String credential) {
		String auth = userName + "|" + credential;
		final byte[] authHeaderBytes = Base64.encodeBase64(auth.getBytes(Charsets.UTF_8));
		String authHeader = new String(authHeaderBytes, Charsets.UTF_8);

		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set(HttpHeaders.AUTHORIZATION, "Basic " + authHeader);

		return headers;
	}

	private String sha256(String input) throws NoSuchAlgorithmException {

		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(input.getBytes());

		byte byteData[] = md.digest();

		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			String hex = Integer.toHexString(0xff & byteData[i]);
			if (hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);
		}
		return hexString.toString();
	}
	
	private PoolingHttpClientConnectionManager getConnectionManager() {
		if (connectionManager == null) {
			connectionManager = new PoolingHttpClientConnectionManager();
			connectionManager.setMaxTotal(maxConnections);
			connectionManager.setValidateAfterInactivity(httpConnectionCheckInterval);
		}
		return connectionManager;
	}
	
	/*
	private BasicHttpClientConnectionManager getConnectionManager() {
		if (connectionManager == null) {
			connectionManager = new BasicHttpClientConnectionManager();
		}
		return connectionManager;
	}
	*/
	
	private RequestConfig getRequestConfig() {
		
		if (requestConfig == null) {
			requestConfig = RequestConfig.custom()
					.setCookieSpec(CookieSpecs.DEFAULT)
					.setSocketTimeout(this.connectTimeout * 1000)
					.setConnectTimeout(this.connectTimeout * 1000)
					.setConnectionRequestTimeout(this.connectTimeout * 1000).build();
		}
		return requestConfig;
	}
	
	private CloseableHttpClient getNapasHttpClient() {
		if (napasHttpClient == null) {
			//updated on Mar 20, 2018 -- to use HTTP connection manager to avoid connection leakage
			/*
			napasHttpClient = HttpClients.custom().setDefaultRequestConfig(RequestConfig.custom()
					.setConnectTimeout(connectTimeout * 1000)
					.setSocketTimeout(connectTimeout * 1000)
					.setConnectionRequestTimeout(connectTimeout * 1000)
					.setCookieSpec(CookieSpecs.DEFAULT).build()).setRedirectStrategy(new LaxRedirectStrategy()).build();
			*/
			napasHttpClient =  HttpClients.custom()
					.setRedirectStrategy(new LaxRedirectStrategy())
					.setConnectionManager(getConnectionManager())
					.setConnectionManagerShared(true)
					.setDefaultRequestConfig(getRequestConfig()).build();
		}
		
		return napasHttpClient;
	}
	
	private CloseableHttpClient getPgHttpClient(){
		if (pgHttpClient == null){
			//updated on Mar 20, 2018 -- to use HTTP connection manager to avoid connection leakage
			/*
			pgHttpClient = HttpClients.custom()
					.setDefaultRequestConfig(RequestConfig.custom().setCookieSpec(CookieSpecs.DEFAULT).build())
					.setRedirectStrategy(new LaxRedirectStrategy()).build();
			*/
			pgHttpClient = HttpClients.custom()
					.setRedirectStrategy(new LaxRedirectStrategy())
					.setConnectionManager(getConnectionManager())
					.setConnectionManagerShared(true)
					.setDefaultRequestConfig(getRequestConfig()).build();
		}
		return pgHttpClient;
	}

	private ClientHttpRequestFactory getSimpleClientHttpRequestFactory(int timeout) {
		if (httpRequestFactory == null){
			httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
			httpRequestFactory.setConnectTimeout(timeout * 1000);
		}
		return httpRequestFactory;
	}

	

	 

	 

}
