/**
 * TibcoServiceProviderImpl.java
 */
package com.gnv.vnm.selfcare.core.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gnv.vnm.selfcare.core.AppDefaultValues;
import com.gnv.vnm.selfcare.core.adapter.BackEndConnection;
import com.gnv.vnm.selfcare.core.adapter.RechargeResponse;
import com.gnv.vnm.selfcare.core.adapter.tibco.HotBillingObjectFactory;
import com.gnv.vnm.selfcare.core.adapter.tibco.PostpaidBalanceEnquiryObjectFactory;
import com.gnv.vnm.selfcare.core.adapter.tibco.PostpaidBillPaymentObjectFactory;
import com.gnv.vnm.selfcare.core.adapter.tibco.PostpaidQueryObjectFactory;
import com.gnv.vnm.selfcare.core.adapter.tibco.SelfcareInbound;
import com.gnv.vnm.selfcare.core.adapter.tibco.SelfcareInboundService;
import com.gnv.vnm.selfcare.core.adapter.tibco.TopupsObjectFactory;
import com.gnv.vnm.selfcare.core.adapter.tibco.balenq.PostpaidBalanceEnquiryRequest;
import com.gnv.vnm.selfcare.core.adapter.tibco.balenq.PostpaidBalanceEnquiryResponse;
import com.gnv.vnm.selfcare.core.adapter.tibco.etopup.EtopUpRequest;
import com.gnv.vnm.selfcare.core.adapter.tibco.etopup.EtopUpResponse;
import com.gnv.vnm.selfcare.core.adapter.tibco.hotbilling.HotBillingRequest;
import com.gnv.vnm.selfcare.core.adapter.tibco.hotbilling.HotBillingResponse;
import com.gnv.vnm.selfcare.core.adapter.tibco.postpaidpmt.PostpaidBillPaymentRequest;
import com.gnv.vnm.selfcare.core.adapter.tibco.postpaidpmt.PostpaidBillPaymentResponse;
import com.gnv.vnm.selfcare.core.adapter.tibco.postpaidqry.BillHistory;
import com.gnv.vnm.selfcare.core.adapter.tibco.postpaidqry.PostPaidBilledQueryRequest;
import com.gnv.vnm.selfcare.core.adapter.tibco.postpaidqry.PostPaidBilledQueryResponse;
import com.gnv.vnm.selfcare.core.adapter.tibco.subscriberqry.MsgParam;
import com.gnv.vnm.selfcare.core.adapter.tibco.subscriberqry.SubscriberQueryRequest;
import com.gnv.vnm.selfcare.core.adapter.tibco.subscriberqry.SubscriberQueryResponse;
import com.gnv.vnm.selfcare.core.adapter.tibco.topuphistory.VoucherHistory;
import com.gnv.vnm.selfcare.core.adapter.tibco.topuphistory.VoucherHistory.VoucherList.VoucherItems;
import com.gnv.vnm.selfcare.core.enums.BalanceType;
import com.gnv.vnm.selfcare.core.enums.BalanceUnitName;
import com.gnv.vnm.selfcare.core.enums.BillPaymentStatus;
import com.gnv.vnm.selfcare.core.enums.CallDirection;
import com.gnv.vnm.selfcare.core.enums.CallType;
import com.gnv.vnm.selfcare.core.enums.SupportedLanguage;
import com.gnv.vnm.selfcare.core.enums.TibcoResponse;
import com.gnv.vnm.selfcare.core.enums.TopUpType;
import com.gnv.vnm.selfcare.core.enums.TransactionStatus;
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
import com.gnv.vnm.selfcare.core.service.ApplicationConfigurationService;
import com.gnv.vnm.selfcare.core.service.TibcoServiceProvider;
import com.gnv.vnm.selfcare.core.utils.AppUtils;
import com.gnv.vnm.selfcare.core.utils.LoggingUtil;
import com.gnv.vnm.selfcare.dao.entity.BalanceNameMappingEntity;
import com.gnv.vnm.selfcare.dao.entity.ClassOfServiceEntity;
import com.gnv.vnm.selfcare.dao.entity.QBalanceNameMappingEntity;
import com.gnv.vnm.selfcare.dao.entity.QClassOfServiceEntity;
import com.gnv.vnm.selfcare.dao.entity.QRptInvoiceSummary;
import com.gnv.vnm.selfcare.dao.entity.QTopUpTypeEntity;
import com.gnv.vnm.selfcare.dao.entity.RptInvoiceSummary;
import com.gnv.vnm.selfcare.dao.entity.TopUpTypeEntity;
import com.gnv.vnm.selfcare.dao.repo.BalanceNameMappingRepository;
import com.gnv.vnm.selfcare.dao.repo.ClassOfServiceRepository;
import com.gnv.vnm.selfcare.dao.repo.RptInvoiceSummaryRepository;
import com.gnv.vnm.selfcare.dao.repo.TopUpTypeRepository;

/**
 * @author nandipinto
 *
 */

@Service("tibcoServiceProvider")
public class TibcoServiceProviderImpl implements TibcoServiceProvider {
	
	private static final Logger logger = LoggerFactory.getLogger(TibcoServiceProviderImpl.class);
	
	private static final String SOURCE_NAME = "selfcare";
	private static final String REQ_ID_PATTERN = "yyyyMMddHHmmss";
	private static final String TIBCO_SHORT_DATE_PATTERN = "dd/MM/yyyy";
	private static final String TIBCO_LONG_DATE_PATTERN = "dd/MM/yyyy HH:mm:ss";
	
	private static final String BILL_NOT_PAID = "Not Paid";
	private static final String BILL_PAID = "Fully Paid";
	private static final String BILL_PARTIALLY_PAID = "Partially Paid";
	
	private static final String DEFAULT_CALL_HISTORY_SQL = "select msisdn, event_type, event_dtm, duration, amount, b_number "
			+ "from hcpt_intec_usage_details_uat where msisdn = ? "
			+ "and event_type = 'GSM Voice MOC' "
			+ "and event_dtm between ? and ?";

	private static final String DEFAULT_SMS_HISTORY_SQL = "select msisdn, event_type, event_dtm, duration, amount, b_number "
			+ "from hcpt_intec_usage_details_uat where msisdn = ? "
			+ "and event_type = 'GSM SMS MO' "
			+ "and event_dtm between ? and ?";
	
	@Autowired 
	private ApplicationConfigurationService applicationConfigurationService;
	@Autowired
	private BalanceNameMappingRepository balanceNameMappingRepository;
	@Autowired
	private ClassOfServiceRepository classOfServiceRepository;
	@Autowired
	private TopUpTypeRepository topUpTypeRepository;
	@Autowired
	private RptInvoiceSummaryRepository invoiceSummaryRepository;
	
	@Autowired 
	private Environment env;

	private SelfcareInboundService inboundService = new SelfcareInboundService();
	private SelfcareInbound endPoint = null;
	
//	private ObjectFactory objectFactory = new ObjectFactory();

	private Hashtable<String, BalanceNameMappingEntity> balanceMappings = new Hashtable<>();
	private Hashtable<String, String> cosMappings = new Hashtable<>();
	private DataSource singleViewDataSource;
	private JdbcTemplate jdbcTemplate;
	
	@PostConstruct
	public void initService() throws Exception{
		loadBalanceMappings();
		loadClassOfServiceMappings();

		PoolProperties p = new PoolProperties();
		p.setUrl(env.getProperty("datasource.singleview.url"));
		p.setDriverClassName(env.getProperty("datasource.singleview.driverclassname"));
		p.setUsername(env.getProperty("datasource.singleview.username"));
		p.setPassword(env.getProperty("datasource.singleview.password"));
		p.setJmxEnabled(true);
		p.setTestWhileIdle(false);
		p.setTestOnBorrow(true);
		p.setValidationQuery(env.getProperty("datasource.singleview.connectionvalidationsql", "SELECT 1 from DUAL"));
		p.setTestOnReturn(false);
		p.setValidationInterval(
				Long.parseLong(env.getProperty("datasource.singleview.connpool.validationinterval", "30")) * 1000);
		p.setTimeBetweenEvictionRunsMillis(
				Integer.parseInt(env.getProperty("datasource.singleview.connpool.timebetweenbvictionruns", "30")) * 1000);
		p.setMaxWait(Integer.parseInt(env.getProperty("datasource.singleview.connpool.maxwait", "10")) * 1000);
		p.setMinEvictableIdleTimeMillis(
				Integer.parseInt(env.getProperty("datasource.singleview.connpool.minevictableidletime", "30")) * 1000);

		p.setRemoveAbandonedTimeout(
				Integer.parseInt(env.getProperty("datasource.singleview.connpool.removeabandonedtimeout", "60"))); // in
																												// seconds

		p.setInitialSize(Integer.parseInt(env.getProperty("datasource.singleview.connpool.initialsize", "50")));
		p.setMaxActive(Integer.parseInt(env.getProperty("datasource.singleview.connpool.maxactive", "100")));
		p.setMinIdle(Integer.parseInt(env.getProperty("datasource.singleview.connpool.minidle", "10")));

		p.setLogAbandoned(true);
		p.setRemoveAbandoned(true);
		p.setJdbcInterceptors(env.getProperty("datasource.singleview.connpool.interceptors"));

		singleViewDataSource = new DataSource();
		singleViewDataSource.setPoolProperties(p);
		
		jdbcTemplate = new JdbcTemplate(singleViewDataSource);
		
		String endPointURL = applicationConfigurationService.get("adapter.tibco.endpoint", "http://10.8.8.52:45010/Business_Process/Selfcare").toString();
		
//		SelfcareInboundService inboundService = new SelfcareInboundService();
		endPoint = inboundService.getSelfcareInbound();
		BindingProvider bp = (BindingProvider)endPoint;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endPointURL);
		
		bp.getRequestContext().put("com.sun.xml.internal.ws.connect.timeout", BackEndConnection.CONNECT_TIMEOUT_SECS * 1000); // Timeout in millis
		bp.getRequestContext().put("com.sun.xml.internal.ws.request.timeout", BackEndConnection.REQUEST_TIMEOUT_SECS * 1000); // Timeout in millis
		bp.getRequestContext().put("com.sun.xml.ws.request.timeout", BackEndConnection.CONNECT_TIMEOUT_SECS * 1000); // Timeout in millis
		bp.getRequestContext().put("com.sun.xml.ws.connect.timeout", BackEndConnection.REQUEST_TIMEOUT_SECS * 1000); // Timeout in millis
	}
	
	@Scheduled(fixedDelayString = "${app.config.reloadinterval:300000}")
	public void loadBalanceMappings(){
		try {
			Iterable<BalanceNameMappingEntity> list = balanceNameMappingRepository.findAll(QBalanceNameMappingEntity.balanceNameMappingEntity.nameOnRTBS.asc());
			if (list != null){
				for (BalanceNameMappingEntity bme : list){
					this.balanceMappings.put(bme.getNameOnRTBS(), bme);
				}
			}
		} catch (Exception e) {
			logger.error("#loadBalanceMappings --- error when loading balance mappings!", e);
		}
	}
	
	@Scheduled(fixedDelayString = "${app.config.reloadinterval:300000}")
	public void loadClassOfServiceMappings() {
		try {
			Iterable<ClassOfServiceEntity> list = classOfServiceRepository.findAll(QClassOfServiceEntity.classOfServiceEntity.name.asc());
			if (list != null){
				for (ClassOfServiceEntity cse : list){
					this.cosMappings.put(cse.getName(), cse.getDisplayName());
				}
			}
		} catch (Exception e) {
			logger.error("#loadClassOfServiceMappings --- error loading COS mappings!", e);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.TibcoServiceProvider#getClassOfServiceName(java.lang.String)
	 */
	@Override
	public String getClassOfServiceName(String subscriberId) {
		SubscriberQueryResponse response = getSubscriberInfo(subscriberId);
		String cos = response != null && response.getStatusCode().equals(TibcoResponse.SUCCESS.code()) ? response.getCALLPLAN() : null;
		
		LoggingUtil.debug(logger, String.format("#getClassOfServiceName --- COS from Tibco for %s is %s", subscriberId, cos));
		return cos;
	}

	@Override
	public SubscriberQueryResponse getSubscriberInfo(String msisdn){
		LoggingUtil.debug(logger, "#getSubscriberInfo --- querying subscriber data from Tibco for MSISDN= " + msisdn);
		SubscriberQueryResponse response = null;
		try {
			
			SubscriberQueryRequest request = new SubscriberQueryRequest();
			request.setMSISDN(msisdn);
			
			//###########################################################
			long startTime= System.currentTimeMillis();
			logger.debug("fetching subscribing  from tibco start");
			
			response = endPoint.subscriberQuery(request);
				
			//###########################################################
			long endTime= System.currentTimeMillis();
			logger.debug("execution time to fetch subscriber info  from tibco in millis "+(endTime-startTime));
			LoggingUtil.debug(logger, "#getSubscriberInfo --- subscriber data= " + response);

			if (response.getStatusCode() == null || !response.getStatusCode().equals(TibcoResponse.SUCCESS.code())) {
				return null;
			}
			
		} catch (Exception e) {
			logger.error("#getSubscriberInfo --- (" + msisdn + "), error when sending request to Tibco!", e);
		}
		
		return response;
	}
	
	private String getShortDateFormat() {
		return this.applicationConfigurationService.get("adapter.tibco.dateformat.short", TIBCO_SHORT_DATE_PATTERN).toString();
	}
	
	private String getLongDateFormat() {
		return this.applicationConfigurationService.get("adapter.tibco.dateformat.long", TIBCO_LONG_DATE_PATTERN).toString();
	}
	
	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.TibcoServiceProvider#topUpWithScratchCard(java.lang.String, java.lang.String)
	 */
	@Override
	public RechargeResponse topUpWithScratchCard(String subscriberId, String voucherCode) {
		RechargeResponse response = new RechargeResponse();
		
		try {
			LoggingUtil.debug(logger, "#topUpWithScratchCard --- sending topup request to Tibco for  (msisdn= " + subscriberId + ", voucher_code= " + voucherCode + ")");

			String reqId = requestId();
			Holder<String> transactionID = new Holder<String>(reqId);
			Holder<String> messageType = new Holder<String>("0");
			Holder<String> procCode = new Holder<String>("VOUCHER");
			Holder<String> stan = new Holder<String>("VOUCHERTOPUP");
			Holder<String> localTxnDtTime = new Holder<String>(AppUtils.dateToString(new Date(),  getShortDateFormat()));
			Holder<String> mobNum = new Holder<String>(subscriberId);
			Holder<String> voucherNum = new Holder<String>(voucherCode);
			Holder<String> deliveryChannelCtrlID = new Holder<String>(SOURCE_NAME);
			Holder<String> actCode = new Holder<String>(reqId);
			Holder<String> curr = new Holder<String>(AppDefaultValues.CURRENCY_VND);
			
			//this is really not necessary, why sending these parameters for voucher top up?
			Holder<String> voucherBal = new Holder<String>("0");
			Holder<String> validityDate = new Holder<String>("0");
			Holder<String> gracePeriod = new Holder<String>("0");
			Holder<String> voucherDenom = new Holder<String>("0");
			
			Holder<String> respCodeHolder = new Holder<String>();
			Holder<String> respDescHolder = new Holder<String>();
			
			endPoint.voucherTopUp(transactionID, messageType, procCode, stan, localTxnDtTime, mobNum, voucherNum, 
					null, deliveryChannelCtrlID, actCode, curr, voucherBal, validityDate, null, gracePeriod, 
					null, null, voucherDenom, null, null, null, null, respCodeHolder, respDescHolder);
			
			LoggingUtil.debug(logger, String.format(
					"topUpWithScratchCard --- msisdn= %s, voucher_code= %s, resp_code= %s, resp_desc= %s, voucher_value= %s, balance= %s",
					subscriberId, voucherCode, respCodeHolder.value, respDescHolder.value, voucherDenom.value,
					voucherBal.value));
			
			response.setCode(respCodeHolder.value);
			response.setMessage(respDescHolder.value);
			
			if (respCodeHolder.value.equals(TibcoResponse.SUCCESS.code())){
				try {
					response.setBalance(new Double(voucherBal.value).intValue());
				} catch (Exception e) {}
				
				try {
					response.setRechargeValue(new Double(voucherDenom.value).intValue());
				} catch (Exception e) {}
			}
			
		} catch (Exception e) {
			logger.error("#topUpWithScratchCard --- (" + subscriberId + ",  " + voucherCode + "), error sendint top up request to Tibco", e);
			
			response.setCode("9999");
			response.setMessage(e.getMessage());
		}
		return response;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.TibcoServiceProvider#etopUp(java.lang.String, double, java.lang.String)
	 */
	@Override
	public RechargeResponse etopUp(String subscriberId, double value, String refCode, String refTrxId) {
		
		RechargeResponse rechargeResponse = new RechargeResponse();
		
		try {
			LoggingUtil.info(logger, "#etopUp --- msisdn= " + subscriberId + ", value= " + value + ", ref_trx_id= " + refTrxId);
			
			TopupsObjectFactory objectFactory = new TopupsObjectFactory();
			EtopUpRequest request = objectFactory.createEtopUpRequest();
			
			request.setCurrency(objectFactory.createCurrency(AppDefaultValues.CURRENCY_VND).getValue());
			request.setDeliveryChannelCtrlID(objectFactory.createDeliveryChannelCtrlID("ETOPUP").getValue());
			request.setLocalTxnDtTime(objectFactory.createLocalTxnDtTime(AppUtils.dateToString(new Date(),  getShortDateFormat())).getValue());
			request.setMessageType(objectFactory.createMessageType("1").getValue());
			request.setMobNum(objectFactory.createMobNum(subscriberId).getValue());
			
			if (!StringUtils.hasText(refCode)) {
				refCode = "ET_" + AppUtils.dateToString(new Date(), "yyyyMMddHHmmss");
			}
			request.setSTAN(objectFactory.createSTAN(refCode).getValue());
			
			request.setTopUpAmount(objectFactory.createTopUpAmount("" + String.format("%.2f", value)).getValue());
			request.setProcCode(objectFactory.createProcCode("ETOPUP").getValue());
			
			EtopUpResponse response = endPoint.etopupSelfcare(request);
			LoggingUtil.info(logger, "#etopUp --- msisdn= " + subscriberId + ", value= " + value + ", ref_trx_id= "
					+ refTrxId + ", etopup_response= " + response);
			
			if (response != null){
				LoggingUtil.info(logger, "#etopUp --- msisdn= " + subscriberId + ", value= " + value + ", ref_trx_id= "
						+ refTrxId + ", etopup_response_code= " + response.getActCode()+ ", etopup_response_balance= " + response.getCurrentBal());
				
				//etopup does not return latest core balance information as confirmed by Venky
				int currentBalance = 0;
				try {
					currentBalance = Integer.parseInt(response.getCurrentBal());
				} catch (Exception e) {}
				
				rechargeResponse.setBalance(currentBalance);
				rechargeResponse.setCode(response.getActCode());
			}
		} catch (Exception e) {
			logger.error("#etopUp --- msisdn= " + subscriberId + ", value= " + value + ", ref_trx_id= " + refTrxId, e);
			
			rechargeResponse.setCode("9999");
			rechargeResponse.setMessage(e.getMessage());
		}
		LoggingUtil.info(logger, "#etopUp --- msisdn= " + subscriberId + ", value= " + value + ", ref_trx_id= "
				+ refTrxId + ", final recharge_response= " + (rechargeResponse.getCode() + ", "  + rechargeResponse.getBalance()) );
		return rechargeResponse;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.TibcoServiceProvider#getCoreBalance(java.lang.String)
	 */
	@Override
	public Balance getCoreBalance(String subscriberId) {
		String dateFormat = applicationConfigurationService.get("dateformat.default", AppDefaultValues.DATE_FORMAT).toString();
		
		SubscriberQueryResponse response = getSubscriberInfo(subscriberId);

		//work around as Tibco does not have balance name for Core Balance
		String coreBalanceName = BalanceType.CORE.name();

		Balance balance = new Balance();
		balance.setType(BalanceType.CORE);
		balance.setName(coreBalanceName);

		BalanceNameMappingEntity balanceMap = balanceMappings.get(coreBalanceName);
		if (balanceMap != null){
			balance.setDisplayNameEN(balanceMap.getDisplayNameEN());
			balance.setDisplayNameVI(balanceMap.getDisplayNameVI());
			balance.setUnitName(balanceMap.getUnitName());
		}else {
			balance.setDisplayNameEN(coreBalanceName);
			balance.setDisplayNameVI(coreBalanceName);
			balance.setUnitName("vnd");
		}
		if (response != null){
			try {
				long validityPeriod = 0;
				Date expDate = AppUtils.stringToDate(response.getTERMINATEDDATE(), getLongDateFormat());
				if (expDate != null) {
					validityPeriod = (expDate.getTime() - new Date().getTime())/86400000;					
				}

				if (StringUtils.hasText(response.getMAINACCOUNTBALANCE())) {
					balance.setAvailableValue(Integer.parseInt(response.getMAINACCOUNTBALANCE()));
				}
				if (StringUtils.hasText(response.getMAINACCOUNTBALANCE())) {
					balance.setTotalValue(Integer.parseInt(response.getMAINACCOUNTBALANCE()));
				}
				if (validityPeriod >= 0) {
					balance.setValidityPeriod((int)validityPeriod);
					balance.setExpiryDate(expDate);
					balance.setExpiryDateAsString(AppUtils.dateToString(expDate, dateFormat));
				}
				
			} catch (Exception e) {
				logger.error("#getCoreBalance --- (" + subscriberId + ") error when querying core balance from Tibco!", e);
			}
		}
		return balance;
	}
	
	private Balance getCoreBalance(SubscriberQueryResponse response){
		String dateFormat = applicationConfigurationService.get("dateformat.default", AppDefaultValues.DATE_FORMAT).toString();

		//work around as Tibco does not have balance name for Core Balance
		String coreBalanceName = BalanceType.CORE.name();

		Balance balance = new Balance();
		balance.setType(BalanceType.CORE);
		balance.setName(coreBalanceName);
		
		BalanceNameMappingEntity balanceMap = balanceMappings.get(coreBalanceName);
		if (balanceMap != null){
			balance.setDisplayNameEN(balanceMap.getDisplayNameEN());
			balance.setDisplayNameVI(balanceMap.getDisplayNameVI());
			balance.setUnitName(balanceMap.getUnitName());
		}else {
			balance.setDisplayNameEN(coreBalanceName);
			balance.setDisplayNameVI(coreBalanceName);
			balance.setUnitName("vnd");
		}

		if (response != null && response.getStatusCode().equals(TibcoResponse.SUCCESS.code())){
			try {
				//changed to use RESTRICTED_DATE as requested by VNM on 20107-12-12
//				Date expDate = AppUtils.stringToDate(response.getTERMINATEDDATE(), getLongDateFormat());
				Date expDate = AppUtils.stringToDate(response.getRESTRICTEDDATE(), getLongDateFormat());
				long validityPeriod = (expDate.getTime() - new Date().getTime())/86400000;

				balance.setAvailableValue(Integer.parseInt(response.getMAINACCOUNTBALANCE()));
				balance.setTotalValue(Integer.parseInt(response.getMAINACCOUNTBALANCE()));
				if (validityPeriod >= 0) balance.setValidityPeriod((int)validityPeriod);
				balance.setExpiryDate(expDate);
				balance.setExpiryDateAsString(AppUtils.dateToString(expDate, dateFormat));
				
			} catch (Exception e) {
				logger.error("#getCoreBalance ---  error when querying core balance from Tibco!", e);
			}
		}
		return balance;

	}
	
	private List<Balance> createBalanceList(List<MsgParam.Attribute> attrs){
		String dateFormat = applicationConfigurationService.get("dateformat.default", AppDefaultValues.DATE_FORMAT).toString();

		List<Balance> balances = new ArrayList<Balance>();

		for (MsgParam.Attribute attr : attrs){
			Map<String, String> maps = new HashMap<>();
			List<MsgParam.Attribute.AttribDtl> attrDetails = attr.getAttribDtl();
			for (MsgParam.Attribute.AttribDtl dtl : attrDetails){
				maps.put(dtl.getName(), dtl.getValue());
			}
			Balance bal = new Balance();
			bal.setName(maps.get("BONUS_NAME"));
			if (maps.get("REMAINING_AMOUNT") != null){
				bal.setAvailableValue(Integer.parseInt(maps.get("REMAINING_AMOUNT")));
			}
			if (maps.get("ALLOCATED_AMOUNT") != null){
				bal.setTotalValue(Integer.parseInt(maps.get("ALLOCATED_AMOUNT")));
			}
			
			Date expDate = AppUtils.stringToDate(maps.get("END_DATE"), getLongDateFormat());
			if (expDate != null){
				long validityPeriod = (expDate.getTime() - new Date().getTime())/86400000;
				if (validityPeriod >= 0) bal.setValidityPeriod((int)validityPeriod);
				bal.setExpiryDate(expDate);
				bal.setExpiryDateAsString(AppUtils.dateToString(expDate, dateFormat));
			}
			
			String uom = maps.get("BONUS_UOM");
			if (uom != null && uom.equalsIgnoreCase("Charge")){
				bal.setType(BalanceType.PROMOTION);
				bal.setUnitName(BalanceUnitName.VND.name());
				
			}else if (uom != null && uom.equalsIgnoreCase("Seconds")){
				bal.setType(BalanceType.VOICE);
				bal.setUnitName(BalanceUnitName.SECOND.name());
				
			}else if (uom != null && uom.equalsIgnoreCase("SMS")){
				bal.setType(BalanceType.SMS);
				bal.setUnitName(BalanceUnitName.SMS.name());
			}
			
			if (bal.getType() != null) {
				
				boolean addToList = true;
				BalanceNameMappingEntity balanceMap = this.balanceMappings.get(bal.getName());
				if (balanceMap != null){
					bal.setDisplayNameEN(balanceMap.getDisplayNameEN());
					bal.setDisplayNameVI(balanceMap.getDisplayNameVI());
					bal.setUnitName(balanceMap.getUnitName());
					
					addToList = balanceMap.getVisibleFlag() != null && balanceMap.getVisibleFlag().equals(1);
				}else{
					bal.setDisplayNameEN(bal.getName());
					bal.setDisplayNameVI(bal.getName());
				}
				
				if (addToList) balances.add(bal);
			}
		}
		
		return balances;
	}

	private List<Balance> getBalanceList(String subscriberId){
		
		SubscriberQueryResponse response = getSubscriberInfo(subscriberId);
		if (response != null){
			if (response.getStatusCode().equals(TibcoResponse.SUCCESS.code())){
				try {
					return createBalanceList(response.getMsgParam().getAttribute());
					
				} catch (Exception e) {
					logger.error("#getBalanceList --- (" + subscriberId + "), error when retrieiving balance information from Tibco!", e);
				}
				
			}else{
				logger.error(String.format(
						"#getBalanceList --- (%s), error retrieving balance from Tibco, returned with status_code= [ %s ], status_msg=[ %s ]",
						subscriberId, response.getStatusCode(), response.getStatusText()));
			}
		}
		return new ArrayList<Balance>();
	}
	
	private List<Balance> getBalanceList(SubscriberQueryResponse response){
		
		if (response != null){
			if (response.getStatusCode().equals(TibcoResponse.SUCCESS.code())){
				try {
					
					return createBalanceList(response.getMsgParam().getAttribute());
					
				} catch (Exception e) {
					logger.error("#getBalances --- error when retrieiving balance information from Tibco!", e);
				}
				
			}else{
				logger.error(String.format(
						"#getBalanceList --- error retrieving balance from Tibco, returned with status_code= [ %s ], status_msg=[ %s ]",
						response.getStatusCode(), response.getStatusText()));
			}
		}
		return new ArrayList<Balance>();
	}
	
	
	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.TibcoServiceProvider#getVoiceBalance(java.lang.String)
	 */
	@Override
	public MyVoiceBalance getVoiceBalance(String subscriberId) {

		int totalValue = 0;
		int availableValue = 0;
		int consumedValue = 0;

		MyVoiceBalance myBalance = new MyVoiceBalance();
		List<Balance> balanceList = getBalanceList(subscriberId);
		for (Balance balance : balanceList){
			if (balance.getType().equals(BalanceType.VOICE)){
				totalValue = totalValue + balance.getTotalValue();
				consumedValue = consumedValue + balance.getConsumedValue();
				availableValue = availableValue + balance.getAvailableValue();
				
				myBalance.getBalanceList().add(balance);
			}
		}
		
		Collections.sort(myBalance.getBalanceList(), Balance.AvailableValueDescComparator);
		myBalance.setConsumedValue(consumedValue);
		myBalance.setAvailableValue(availableValue);
		myBalance.setTotalValue(totalValue);
		
		return myBalance;
	}

	private MyVoiceBalance getVoiceBalance(List<Balance> balanceList) {

		MyVoiceBalance myBalance = new MyVoiceBalance();
		if (balanceList == null) return myBalance;
		
		int totalValue = 0;
		int availableValue = 0;
		int consumedValue = 0;

		for (Balance balance : balanceList){
			if (balance.getType().equals(BalanceType.VOICE)){
				totalValue = totalValue + balance.getTotalValue();
				consumedValue = consumedValue + balance.getConsumedValue();
				availableValue = availableValue + balance.getAvailableValue();
				
				myBalance.getBalanceList().add(balance);
			}
		}
		
		Collections.sort(myBalance.getBalanceList(), Balance.AvailableValueDescComparator);	
		myBalance.setConsumedValue(consumedValue);
		myBalance.setAvailableValue(availableValue);
		myBalance.setTotalValue(totalValue);
		
		return myBalance;
	}
	
	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.TibcoServiceProvider#getSmsBalance(java.lang.String)
	 */
	@Override
	public MySmsBalance getSmsBalance(String subscriberId) {

		int totalValue = 0;
		int availableValue = 0;
		int consumedValue = 0;

		MySmsBalance myBalance = new MySmsBalance();
		List<Balance> balanceList = getBalanceList(subscriberId);
		for (Balance balance : balanceList){
			if (balance.getType().equals(BalanceType.SMS)){
				totalValue = totalValue + balance.getTotalValue();
				consumedValue = consumedValue + balance.getConsumedValue();
				availableValue = availableValue + balance.getAvailableValue();
				
				myBalance.getBalanceList().add(balance);
			}
		}
		
		Collections.sort(myBalance.getBalanceList(), Balance.AvailableValueDescComparator);
		
		myBalance.setConsumedValue(consumedValue);
		myBalance.setAvailableValue(availableValue);
		myBalance.setTotalValue(totalValue);
		
		return myBalance;
	}
	
	private MySmsBalance getSmsBalance(List<Balance> balanceList) {
		
		MySmsBalance myBalance = new MySmsBalance();
		if (balanceList == null) return myBalance;
		
		int totalValue = 0;
		int availableValue = 0;
		int consumedValue = 0;
		
		for (Balance balance : balanceList){
			if (balance.getType().equals(BalanceType.SMS)){
				totalValue = totalValue + balance.getTotalValue();
				consumedValue = consumedValue + balance.getConsumedValue();
				availableValue = availableValue + balance.getAvailableValue();
				
				myBalance.getBalanceList().add(balance);
			}
		}
		
		Collections.sort(myBalance.getBalanceList(), Balance.AvailableValueDescComparator);	

		myBalance.setConsumedValue(consumedValue);
		myBalance.setAvailableValue(availableValue);
		myBalance.setTotalValue(totalValue);
		
		return myBalance;
	}
	

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.TibcoServiceProvider#getPromotionBalance(java.lang.String, java.lang.String)
	 */
	@Override
	public MyPromotionBalance getPromotionBalance(String subscriberId, String langCode) {
		
		if (!StringUtils.hasText(langCode)) langCode = SupportedLanguage.ENGLISH.code();
		
		int totalValue = 0;
		int availableValue = 0;
		int consumedValue = 0;
		
		MyPromotionBalance myBalance = new MyPromotionBalance();
		List<Balance> balanceList = getBalanceList(subscriberId);
		for (Balance balance : balanceList){
			if (balance.getType().equals(BalanceType.PROMOTION)){
				totalValue = totalValue + balance.getTotalValue();
				consumedValue = consumedValue + balance.getConsumedValue();
				availableValue = availableValue + balance.getAvailableValue();
				
				myBalance.getBalanceList().add(balance);
			}
		}
		
		if (langCode.equals(SupportedLanguage.ENGLISH.code())){
			Collections.sort(myBalance.getBalanceList(), Balance.DisplayNameENComparator);
		}else{
			Collections.sort(myBalance.getBalanceList(), Balance.DisplayNameVIComparator);
		}

		myBalance.setConsumedValue(consumedValue);
		myBalance.setAvailableValue(availableValue);
		myBalance.setTotalValue(totalValue);
		
		return myBalance;
	}

	private MyPromotionBalance getPromotionBalance(String langCode, List<Balance> balanceList) {

		MyPromotionBalance myBalance = new MyPromotionBalance();
		if (balanceList == null) return myBalance;
		
		if (!StringUtils.hasText(langCode)) langCode = SupportedLanguage.ENGLISH.code();
		
		int totalValue = 0;
		int availableValue = 0;
		int consumedValue = 0;
		
		for (Balance balance : balanceList){
			if (balance.getType().equals(BalanceType.PROMOTION)){
				totalValue = totalValue + balance.getTotalValue();
				consumedValue = consumedValue + balance.getConsumedValue();
				availableValue = availableValue + balance.getAvailableValue();
				
				myBalance.getBalanceList().add(balance);
			}
		}
		
		if (langCode.equals(SupportedLanguage.ENGLISH.code())){
			Collections.sort(myBalance.getBalanceList(), Balance.DisplayNameENComparator);
		}else{
			Collections.sort(myBalance.getBalanceList(), Balance.DisplayNameVIComparator);
		}

		myBalance.setConsumedValue(consumedValue);
		myBalance.setAvailableValue(availableValue);
		myBalance.setTotalValue(totalValue);
		
		return myBalance;
	}
	
	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.TibcoServiceProvider#getDataBalance(java.lang.String)
	 */
	@Override
	public MyDataBalance getDataBalance(String subscriberId) {
		
		MyDataBalance balance = new MyDataBalance();
		SubscriberQueryResponse response = getSubscriberInfo(subscriberId);
		if (response != null) {
			//TODO
		}
		return balance;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.TibcoServiceProvider#getCurrentBalance(java.lang.String, java.lang.String)
	 */
	@Override
	public CurrentBalance getCurrentBalance(String subscriberId, String langCode) {
		LoggingUtil.debug(logger, String.format("#getCurrentBalance -- retrieving balance information from back-end (subscriber= %s)", subscriberId));

		SubscriberQueryResponse response = getSubscriberInfo(subscriberId);
		List<Balance> balanceList = getBalanceList(response);
		
		Balance coreBalance = getCoreBalance(response);
		MyVoiceBalance voiceBalance = getVoiceBalance(balanceList);
		MySmsBalance smsBalance = getSmsBalance(balanceList);
		MyPromotionBalance promotionBalance = getPromotionBalance(langCode, balanceList);
		
		CurrentBalance balance = new CurrentBalance(coreBalance, voiceBalance, smsBalance, null, promotionBalance);
		
		LoggingUtil.debug(logger, String.format("#getCurrentBalance -- got balance information from back-end (subscriber: %s)= ", subscriberId) + balance);

		return balance;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.TibcoServiceProvider#getCallHistory(java.lang.String, java.util.Date, java.util.Date)
	 */
	@Override
	public List<CallRecord> getCallHistory(String subscriberId, Date startDate, Date endDate) {
		
		String dateFormat = applicationConfigurationService.get("dateformat.long", AppDefaultValues.DATE_TIME_FORMAT).toString();
		
		String sql = env.getProperty("datasource.singleview.callhistory.sql", DEFAULT_CALL_HISTORY_SQL);
		
		List<CallRecord> result = new ArrayList<>();
		try {
			List<CallRecord> list = jdbcTemplate.query(sql, new Object[]{subscriberId, 
					startDate, endDate},  new RowMapper<CallRecord>() {

				@Override
				public CallRecord mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					CallRecord record = new CallRecord();
					record.setCalledNumber(rs.getString("b_number"));
					record.setCallType(CallType.UNKNOWN);
					record.setDirection(CallDirection.OUTGOING);
					record.setDuration(rs.getLong("duration"));
					record.setStartTime(rs.getTimestamp("event_dtm"));
					record.setStartTimeAsString(AppUtils.dateToString(rs.getTimestamp("event_dtm"), dateFormat));
					
					return record;
				}
			});
			
			if (list != null) result.addAll(list);
		} catch (Exception e) {
			logger.error("#getCallHistory --- error retrieving call history from SingleView for MSISDN= " + subscriberId, e);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.TibcoServiceProvider#getSmsHistory(java.lang.String, java.util.Date, java.util.Date)
	 */
	@Override
	public List<SmsRecord> getSmsHistory(String subscriberId, Date startDate, Date endDate) {
		String dateFormat = applicationConfigurationService.get("dateformat.long", AppDefaultValues.DATE_TIME_FORMAT).toString();
		
		String sql = env.getProperty("datasource.singleview.smshistory.sql", DEFAULT_SMS_HISTORY_SQL);
		
		List<SmsRecord> result = new ArrayList<>();
		try {
			List<SmsRecord> list = jdbcTemplate.query(sql, new Object[]{ subscriberId, 
					startDate, endDate},  new RowMapper<SmsRecord>() {

				@Override
				public SmsRecord mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					SmsRecord record = new SmsRecord();
					record.setDestinationNumber(rs.getString("b_number"));
					record.setDirection(CallDirection.OUTGOING);
					record.setTimeStamp(rs.getTimestamp("event_dtm"));
					record.setTimeStampAsString(AppUtils.dateToString(rs.getTimestamp("event_dtm"), dateFormat));
					
					return record;
				}
			});
			
			if (list != null) result.addAll(list);
		} catch (Exception e) {
			logger.error("#getSmsHistory --- error retrieving call history from SingleView for MSISDN= " + subscriberId, e);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.TibcoServiceProvider#getTopUpHistory(java.lang.String, java.util.Date, java.util.Date)
	 */
	@Override
	public List<TopUpHistory> getTopUpHistory(String subscriberId, Date startDate, Date endDate) {

		LoggingUtil.debug(logger, "#getTopUpHistory -- subscriber= " + subscriberId + ", start_date= " + startDate + ", end_date= " + endDate);
		
		List<TopUpHistory> history = new ArrayList<>();
		
		try {
			VoucherHistory request = new VoucherHistory(); //new ObjectFactory().createVoucherHistory();
			request.setEndDate(AppUtils.dateToString(endDate,  getShortDateFormat()));
			request.setMobNum(subscriberId);
			request.setStartDate(AppUtils.dateToString(startDate,  getShortDateFormat()));
			request.setTransactionID(AppUtils.dateToString(new Date(), "yyyyMMddHHmmssSSS"));
			
			VoucherHistory result = endPoint.topupHistory(request);
			LoggingUtil.debug(logger, "#getTopUpHistory -- subscriber= " + subscriberId + ", result= " + (result != null ? result.getStatus() : null) );
			
			if (result != null && result.getStatusText().equalsIgnoreCase(TibcoResponse.SUCCESS.message())){
				if (result.getVoucherList() != null){
					List<VoucherHistory.VoucherList.VoucherItems> list = result.getVoucherList().getVoucherItems();
					
					LoggingUtil.debug(logger, "#getTopUpHistory -- subscriber= " + subscriberId + ", found " + list.size() + " records.");
					
					for (VoucherItems item : list){
						TopUpHistory tuh = new TopUpHistory();
						tuh.setAmount(Double.parseDouble(item.getVoucherMoney()));
						tuh.setMsisdn(subscriberId);
						tuh.setStatus(TransactionStatus.SUCCESS);
						tuh.setTimeStamp(AppUtils.stringToDate(item.getTopUpDate(), getLongDateFormat())); //TODO check new output
						tuh.setTimeStampAsString(AppUtils.dateToString(tuh.getTimeStamp(), AppDefaultValues.DATE_TIME_FORMAT));
						tuh.setVoucherCode(item.getPaymentRefNumber());
						
						String originator = item.getSourceRequest();
						
						LoggingUtil.debug(logger,
								"#getTopUpHistory -- subscriber= " + subscriberId + ", originator= " + originator
										+ ", time_stamp= " + item.getTopUpDate() + ", amount_net= "
										+ item.getNetTopUpMoney() + ", amount_voucher= " + item.getVoucherMoney());
						
						if (StringUtils.hasText(originator)){
							try {
								TopUpTypeEntity type = topUpTypeRepository.findOne(QTopUpTypeEntity.topUpTypeEntity.name.equalsIgnoreCase(originator));
								if (type != null){
									tuh.setTypeNameEN(type.getDisplayNameEN());
									tuh.setTypeNameVN(type.getDisplayNameVI());
								}
							} catch (Exception e) {
								logger.error("#getTopUpHistory -- error looking up top_up_type to DB for originator= " + originator + ": " + e.getMessage());
							}
						}
						if (!StringUtils.hasText(tuh.getTypeNameEN())){
							tuh.setTypeNameEN(TopUpType.SCRATCH_CARD.displayName());
						}
						if (!StringUtils.hasText(tuh.getTypeNameVN())){
							tuh.setTypeNameVN(TopUpType.SCRATCH_CARD.displayName());
						}

						history.add(tuh);
					}
				}
			}
		} catch (Exception e) {
			logger.error("#getTopUpHistory --- error retrieving top up history from Tibco for MSISDN " + subscriberId, e);
		}
		
		Collections.sort(history, new TopUpHistory.TopUpHistoryTimestampDescendingComparator());
		return history;
	}
	
	private String requestId(){
		return AppUtils.dateToString(new Date(), REQ_ID_PATTERN);
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.TibcoServiceProvider#isPostpaidSubscriber(java.lang.String)
	 */
	/**
	 * Comment 17-12-2018 Post paid migration method name isPostpaidSubscriber
	 * */
	/*@Override
	public boolean isPostpaidSubscriber(String msisdn) {
		SubscriberQueryResponse subscriber = getSubscriberInfo(
				AppUtils.prependCountryCodeToMsisdn(msisdn, applicationConfigurationService.getDefaultCountryCode()));
		
		if (subscriber == null) return false;

		boolean isPostpaid = false;
		try {
			isPostpaid = subscriber.getRESTRICTEDDATE() == null
					|| subscriber.getRESTRICTEDDATE().equals("01/01/0001 00:00:00")
					|| subscriber.getTERMINATEDDATE() == null
					|| subscriber.getTERMINATEDDATE().equals("01/01/0001 00:00:00");
		} catch (Exception e) {
			logger.error("#isPostpaidSubscriber --- error identifying MSISDN " + msisdn, e);
		}
		return isPostpaid;
	}*/
	
	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.TibcoServiceProvider#isPostpaidSubscriber(java.lang.String)
	 */
	@Override
	public boolean isPostpaidSubscriber(String msisdn) {
		SubscriberQueryResponse subscriber = getSubscriberInfo(
				AppUtils.prependCountryCodeToMsisdn(msisdn, applicationConfigurationService.getDefaultCountryCode()));
		
		if (subscriber == null) return false;

		boolean isPostpaid = false;
		try {
			isPostpaid = subscriber.getRESTRICTEDDATE() == null
					|| subscriber.getRESTRICTEDDATE().equals("01/01/0001 00:00:00")
					|| subscriber.getTERMINATEDDATE() == null
					|| subscriber.getTERMINATEDDATE().equals("01/01/0001 00:00:00");
		} catch (Exception e) {
			logger.error("#isPostpaidSubscriber --- error identifying MSISDN " + msisdn, e);
		}
		return isPostpaid;
	}
	
	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.TibcoServiceProvider#postpaidBillPayment(java.lang.String, double, double, java.lang.String)
	 */
	/**Comment on 17-12-2018 method name postpaidBillPayment */
	/*@Override
	public boolean postpaidBillPayment(String msisdn, double amount, String reference, TransactionType trxType) {
		try {
			
			SubscriberQueryResponse subscriber = getSubscriberInfo(AppUtils.prependCountryCodeToMsisdn(msisdn,
					applicationConfigurationService.getDefaultCountryCode()));
			
			if (subscriber == null) {
				logger.info("#postpaidBillPayment --- no subscriber data found with MSISDN " + msisdn);
				return false;
			}
			
			PostpaidBillPaymentRequest request = new PostpaidBillPaymentObjectFactory().createRequest();
			request.setAccountNumber(subscriber.getACCOUNTNUMBER());
			request.setAgencyAccountNumber("");
			request.setCustomerNumber("");
			request.setInvoiceNumber("");
			request.setLocalTxnDtTime(AppUtils.dateToString(new Date(),  getLongDateFormat()));
			
			if (trxType.equals(TransactionType.POSTPAID_BILL_PAYMENT)) {
				request.setPaymentAmount("" + String.format("%.2f", amount));
				request.setDepositAmount("");				
			} else if (trxType.equals(TransactionType.POSTPAID_DEPOSIT)) {
				request.setPaymentAmount("");
				request.setDepositAmount("" + String.format("%.2f", amount));				
			}
			
			request.setPaymentLevel("");
			request.setPaymentReference(reference);
			request.setPaymentTxt("SELFCARE");
			request.setPaymentType("Online");
			request.setSource("SELFCARE");
			request.setTransactionId("SC" + AppUtils.dateToString(new Date(), "yyyyMMddHHmmss"));
			
			LoggingUtil.debug(logger, "#postpaidBillPayment --- sending request " + request);
			
			PostpaidBillPaymentResponse response = endPoint.postpaidBillPayment(request);
			
			LoggingUtil.debug(logger, "#postpaidBillPayment --- receiving response " + response);
			
			return response != null && response.getStatus() != null && response.getStatus().equals(TibcoResponse.SUCCESS.code());
		} catch (Exception e) {
			logger.error("#postpaidBillPayment --- error processing request for MSISDN " + msisdn, e);
		}
		return false;
	}*/
	
	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.TibcoServiceProvider#postpaidBillPayment(java.lang.String, double, double, java.lang.String)
	 */
	@Override
	public boolean postpaidBillPayment(String msisdn, double amount, String reference, TransactionType trxType) {
		try {
			
			SubscriberQueryResponse subscriber = getSubscriberInfo(AppUtils.prependCountryCodeToMsisdn(msisdn,
					applicationConfigurationService.getDefaultCountryCode()));
			
			if (subscriber == null) {
				logger.info("#postpaidBillPayment --- no subscriber data found with MSISDN " + msisdn);
				return false;
			}
			
			PostpaidBillPaymentRequest request = new PostpaidBillPaymentObjectFactory().createRequest();
			request.setAccountNumber(subscriber.getACCOUNTNUMBER());
			request.setAgencyAccountNumber("");
			request.setCustomerNumber("");
			request.setInvoiceNumber("");
			request.setLocalTxnDtTime(AppUtils.dateToString(new Date(),  getLongDateFormat()));
			
			if (trxType.equals(TransactionType.POSTPAID_BILL_PAYMENT)) {
				request.setPaymentAmount("" + String.format("%.2f", amount));
				request.setDepositAmount("");				
			} else if (trxType.equals(TransactionType.POSTPAID_DEPOSIT)) {
				request.setPaymentAmount("");
				request.setDepositAmount("" + String.format("%.2f", amount));				
			}
			
			request.setPaymentLevel("");
//			request.setPaymentReference(reference);
			request.setPaymentReference("SC" + AppUtils.dateToString(new Date(), "yyyyMMddHHmmss"));
			request.setPaymentTxt("SELFCARE");
			request.setPaymentType("Online");
			request.setSource("SELFCARE");
			request.setTransactionId("SC" + AppUtils.dateToString(new Date(), "yyyyMMddHHmmss"));
			
			LoggingUtil.debug(logger, "#postpaidBillPayment --- sending request " + request);
			
			PostpaidBillPaymentResponse response = endPoint.postpaidBillPayment(request);
			
			LoggingUtil.debug(logger, "#postpaidBillPayment --- receiving response " + response);
			
			return response != null && response.getStatus() != null && response.getStatus().equals(TibcoResponse.SUCCESS.code());
		} catch (Exception e) {
			logger.error("#postpaidBillPayment --- error processing request for MSISDN " + msisdn, e);
		}
		return false;
	}


	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.TibcoServiceProvider#getLastBillingSummary(java.lang.String)
	 */
	/**Comment on 17-12-2018 method name getUnbilledBalanceSummary*/
/*	@Override
	public UnbilledBalance getUnbilledBalanceSummary(String msisdn) {
		
		UnbilledBalance unbilled = new UnbilledBalance();
		try {
			
			msisdn = AppUtils.prependCountryCodeToMsisdn(msisdn, applicationConfigurationService.getDefaultCountryCode());
			
			HotBillingObjectFactory hotBillingObjFactory = new HotBillingObjectFactory();
			HotBillingRequest hotBillingReq = hotBillingObjFactory.createRequest();
			hotBillingReq.setMsisdn(msisdn);
			
			HotBillingResponse hotBillingResp = endPoint.hotBilling(hotBillingReq);
			LoggingUtil.debug(logger, "#getUnbilledBalanceSummary --- hot billing response= " + hotBillingResp);
			
			//no due date information in hot billing response, need to extract information from balance inquiry response (dueDate - 1 month)
			if (hotBillingResp != null && hotBillingResp.getStatus() != null
					&& (hotBillingResp.getStatus().equals(TibcoResponse.SUCCESS.code()) || hotBillingResp.getStatusText().equals(TibcoResponse.SUCCESS.code())) ) {
				
				unbilled.setTotalAmount(Double.parseDouble(hotBillingResp.getTotalDue()));

				PostpaidBalanceEnquiryObjectFactory postpaidBalEnqObjFactory = new PostpaidBalanceEnquiryObjectFactory();
				
				PostpaidBalanceEnquiryRequest request = postpaidBalEnqObjFactory.createRequest();
				request.setMSISDN(msisdn);
				request.setLocalTxnDtTime(AppUtils.dateToString(new Date(),  getShortDateFormat()));
				request.setTransactionId("SC" + AppUtils.dateToString(new Date(), "yyyyMMddHHmmss"));
				
				LoggingUtil.debug(logger, "#getUnbilledBalanceSummary --- sending balance query= " + request);
				
				
				//###########################################################
				long startTime= System.currentTimeMillis();
				logger.debug("fetching outstanding balance");
				
				PostpaidBalanceEnquiryResponse response = endPoint.postpaidBalanceEnquiry(request);
				
				//###########################################################
				long endTime= System.currentTimeMillis();
				logger.debug( "execution time in fetching outstanding balance "+(endTime-startTime));
				
				LoggingUtil.debug(logger, "#getUnbilledBalanceSummary --- receiving balance query response= " + response);
				
				if (response != null && response.getStatus() != null && response.getStatus().equals(TibcoResponse.SUCCESS.code()) ) {

					
					unbilled.setStartDate(response.getDueDate());
					Date start = AppUtils.stringToDate(response.getDueDate(), getShortDateFormat());
					if (start != null) {
						Calendar cal = Calendar.getInstance();
						cal.setTime(start);
						cal.add(Calendar.MONTH, 1);
						
						unbilled.setEndDate(AppUtils.dateToString(cal.getTime(), getShortDateFormat()));
					}
					
					unbilled.setEndDate(response.getDueDate() != null ? response.getDueDate() : "");
					Date end = AppUtils.stringToDate(response.getDueDate(), getShortDateFormat());
					if (end != null) {
						Calendar cal = Calendar.getInstance();
						cal.setTime(end);
						cal.add(Calendar.MONTH, -1);
						
						unbilled.setStartDate(AppUtils.dateToString(cal.getTime(), getShortDateFormat()));
					}
				}
			}
			
		} catch (Exception e) {
			logger.error("#getLastBillingSummary --- error retrieving data for MSISDN " + msisdn, e);
		}
		return unbilled;
	}*/
	
	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.TibcoServiceProvider#getLastBillingSummary(java.lang.String)
	 */
	@Override
	public UnbilledBalance getUnbilledBalanceSummary(String msisdn) {
		
		UnbilledBalance unbilled = new UnbilledBalance();
		try {
			
			msisdn = AppUtils.prependCountryCodeToMsisdn(msisdn, applicationConfigurationService.getDefaultCountryCode());
			
			HotBillingObjectFactory hotBillingObjFactory = new HotBillingObjectFactory();
			HotBillingRequest hotBillingReq = hotBillingObjFactory.createRequest();
			hotBillingReq.setMsisdn(msisdn);
			
			HotBillingResponse hotBillingResp = endPoint.hotBilling(hotBillingReq);
			LoggingUtil.debug(logger, "#getUnbilledBalanceSummary --- hot billing response= " + hotBillingResp);
			
			//no due date information in hot billing response, need to extract information from balance inquiry response (dueDate - 1 month)
			if (hotBillingResp != null && hotBillingResp.getStatus() != null
					&& (hotBillingResp.getStatus().equals(TibcoResponse.SUCCESS.code()) || hotBillingResp.getStatusText().equals(TibcoResponse.SUCCESS.code())) ) {
				
				unbilled.setTotalAmount(Double.parseDouble(hotBillingResp.getTotalDue()));

				PostpaidBalanceEnquiryObjectFactory postpaidBalEnqObjFactory = new PostpaidBalanceEnquiryObjectFactory();
				
				PostpaidBalanceEnquiryRequest request = postpaidBalEnqObjFactory.createRequest();
				request.setMSISDN(msisdn);
				request.setLocalTxnDtTime(AppUtils.dateToString(new Date(),  getShortDateFormat()));
				request.setTransactionId("SC" + AppUtils.dateToString(new Date(), "yyyyMMddHHmmss"));
				
				LoggingUtil.debug(logger, "#getUnbilledBalanceSummary --- sending balance query= " + request);
				
				PostpaidBalanceEnquiryResponse response = endPoint.postpaidBalanceEnquiry(request);
				
				LoggingUtil.debug(logger, "#getUnbilledBalanceSummary --- receiving balance query response= " + response);
				
				if (response != null && response.getStatus() != null && response.getStatus().equals(TibcoResponse.SUCCESS.code()) ) {

					/*
					unbilled.setStartDate(response.getDueDate());
					Date start = AppUtils.stringToDate(response.getDueDate(), getShortDateFormat());
					if (start != null) {
						Calendar cal = Calendar.getInstance();
						cal.setTime(start);
						cal.add(Calendar.MONTH, 1);
						
						unbilled.setEndDate(AppUtils.dateToString(cal.getTime(), getShortDateFormat()));
					}
					*/
					unbilled.setEndDate(response.getDueDate() != null ? response.getDueDate() : "");
					Date end = AppUtils.stringToDate(response.getDueDate(), getShortDateFormat());
					if (end != null) {
						Calendar cal = Calendar.getInstance();
						cal.setTime(end);
						cal.add(Calendar.MONTH, -1);
						
						unbilled.setStartDate(AppUtils.dateToString(cal.getTime(), getShortDateFormat()));
					}
				}
			}
			
		} catch (Exception e) {
			logger.error("#getLastBillingSummary --- error retrieving data for MSISDN " + msisdn, e);
		}
		return unbilled;
	}


	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.TibcoServiceProvider#getPostpaidOutstandingBillSummary(java.util.Date, java.util.Date)
	 */
	/**Comment on 17-12-2018 method name getBillingHistory*/
	/*@Override
	public List<BillingSummary> getBillingHistory(String msisdn, Date startDate, Date endDate) {
		
		List<BillingSummary> result = new ArrayList<>();
		
		try {
			
			//###########################################################
			long startTime= System.currentTimeMillis();
			logger.debug("fetching Billing Hostory  from Tibco ");
			//TODO format prepend MSISDN with country code?
			Iterable<RptInvoiceSummary> list = invoiceSummaryRepository.findAll(
					QRptInvoiceSummary.rptInvoiceSummary.msisdn.eq(msisdn)
							.and(QRptInvoiceSummary.rptInvoiceSummary.invoicedate
									.goe(org.joda.time.LocalDate.fromDateFields(startDate).toDate()))
							.and(QRptInvoiceSummary.rptInvoiceSummary.invoicedate
									.loe(org.joda.time.LocalDate.fromDateFields(endDate).toDate())),
					QRptInvoiceSummary.rptInvoiceSummary.endperiod.desc());
			
			//###########################################################
			long endTime= System.currentTimeMillis();
			logger.debug( "execution time in fetchingBilling Hostory  from Tibco "+(endTime-startTime));
			
			if (list != null) {
				for (RptInvoiceSummary rpt : list) {
					BillingSummary summary = new BillingSummary();
					
					summary.setId(rpt.getId());
					summary.setDueDate(AppUtils.dateToString(rpt.getInvoiceduedate(), AppDefaultValues.DATE_FORMAT));
					summary.setEndDate(AppUtils.dateToString(rpt.getEndperiod(), AppDefaultValues.DATE_FORMAT));
					summary.setInvoiceNumber(rpt.getInvoicenumber());
					summary.setStartDate(AppUtils.dateToString(rpt.getStartperiod(), AppDefaultValues.DATE_FORMAT));
					
					if (rpt.getTotalOutstandingbilling() > 0) {
						if (rpt.getTotalPaymentreceived() > 0) {
							summary.setStatus(BillPaymentStatus.PARTIALLY_PAID);
						} else {
							summary.setStatus(BillPaymentStatus.UNPAID);
						}
					} else {
						summary.setStatus(BillPaymentStatus.PAID);
					}
					summary.setPaidAmount(rpt.getTotalPaymentreceived());
					summary.setTotalAmount(rpt.getTotaldue());
					
					result.add(summary);
				}
			}
		} catch (Exception e) {
			logger.error("#getPostpaidOutstandingBillSummary --- error when processing request for MSISDN " + msisdn, e);
		}
		return result;
	}*/
	
	
	@Override
	public List<BillingSummary> getBillingHistory(String msisdn, Date startDate, Date endDate) {
		
		List<BillingSummary> result = new ArrayList<>();
		
		LoggingUtil.debug(logger, "#getBillingHistory --- msisdn= " + msisdn + ", start_date= " + startDate + ", end_date= " + endDate);
		try {
			//TODO format prepend MSISDN with country code?
			Iterable<RptInvoiceSummary> list = invoiceSummaryRepository.findAll(
					QRptInvoiceSummary.rptInvoiceSummary.msisdn.eq(msisdn)
							.and(QRptInvoiceSummary.rptInvoiceSummary.invoicedate
									.goe(org.joda.time.LocalDate.fromDateFields(startDate).toDate()))
							.and(QRptInvoiceSummary.rptInvoiceSummary.invoicedate
									.loe(org.joda.time.LocalDate.fromDateFields(endDate).toDate())),
					QRptInvoiceSummary.rptInvoiceSummary.endperiod.desc());
			
			if (list != null) {
				for (RptInvoiceSummary rpt : list) {
					BillingSummary summary = new BillingSummary();
					
					summary.setId(rpt.getId());
					summary.setDueDate(AppUtils.dateToString(rpt.getInvoiceduedate(), AppDefaultValues.DATE_FORMAT));
					summary.setDdate(rpt.getInvoiceduedate());
					
					summary.setEndDate(AppUtils.dateToString(rpt.getEndperiod(), AppDefaultValues.DATE_FORMAT));
					summary.setEdate(rpt.getEndperiod());
					
					summary.setInvoiceNumber(rpt.getInvoicenumber());
					summary.setInvoiceDate(rpt.getInvoicedate());
					
					summary.setStartDate(AppUtils.dateToString(rpt.getStartperiod(), AppDefaultValues.DATE_FORMAT));
					summary.setSdate(rpt.getStartperiod());
					
					if (rpt.getTotalOutstandingbilling() > 0) {
						if (rpt.getTotalPaymentreceived() > 0) {
							summary.setStatus(BillPaymentStatus.PARTIALLY_PAID);
						} else {
							summary.setStatus(BillPaymentStatus.UNPAID);
						}
					} else {
						summary.setStatus(BillPaymentStatus.PAID);
					}
					summary.setPaidAmount(rpt.getTotalPaymentreceived());
					summary.setTotalAmount(rpt.getTotaldue());
					summary.setSeqId(rpt.getSeqId());
					
					result.add(summary);
				}
			}
		} catch (Exception e) {
			logger.error("#getPostpaidOutstandingBillSummary --- error when processing request for MSISDN " + msisdn, e);
		}
		return result;
	}


	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.TibcoServiceProvider#getOutstandingBalance(java.lang.String)
	 
	@Override
	public double getCurrentOutstandingBalance(String msisdn) {
		try {
			PostpaidBalanceEnquiryObjectFactory of = new PostpaidBalanceEnquiryObjectFactory();
			PostpaidBalanceEnquiryRequest request = of.createRequest();
			request.setMSISDN(AppUtils.prependCountryCodeToMsisdn(msisdn, applicationConfigurationService.getDefaultCountryCode()));
			
			PostpaidBalanceEnquiryResponse response = endPoint.postpaidBalanceEnquiry(request);
			if (response != null && response.getStatus() != null && response.getStatus().equals(TibcoResponse.SUCCESS.code())) {
				return Double.parseDouble(response.getTotalOutstandingBalance());
			}
		} catch (Exception e) {
			logger.error("#getOutstandingBalance --- error retrieving outstanding balance info from Tibco for MSISDN= " + msisdn, e);
		}
		return 0;
	}*/
	
	@Override
	public double getCurrentOutstandingBalance(String msisdn) {
		double balance = 0;
		try {
			PostpaidBalanceEnquiryObjectFactory of = new PostpaidBalanceEnquiryObjectFactory();
			PostpaidBalanceEnquiryRequest request = of.createRequest();
			request.setMSISDN(AppUtils.prependCountryCodeToMsisdn(msisdn, applicationConfigurationService.getDefaultCountryCode()));
			
			PostpaidBalanceEnquiryResponse response = endPoint.postpaidBalanceEnquiry(request);
			if (response != null && response.getStatus() != null && response.getStatus().equals(TibcoResponse.SUCCESS.code())) {
				balance = Double.parseDouble(response.getTotalOutstandingBalance());
			}
		} catch (Exception e) {
			logger.error("#getOutstandingBalance --- error retrieving outstanding balance info from Tibco for MSISDN= " + msisdn, e);
		}
		
		LoggingUtil.debug(logger, "#getCurrentOutstandingBalance --- MSISDN= " + msisdn + ", result= " + balance);
		return balance;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.TibcoServiceProvider#getOutstandingBalances(java.lang.String)
	 */
	/**Comment on 17-12-2018 method name getOutstandingBalances*/
	/*@Override
	public List<OutstandingBalance> getOutstandingBalances(String msisdn) {

		List<OutstandingBalance> result = new ArrayList<>();
		
		try {
			msisdn = AppUtils.prependCountryCodeToMsisdn(msisdn, applicationConfigurationService.getDefaultCountryCode());
			SubscriberQueryResponse subscriber = getSubscriberInfo(msisdn);

			PostpaidQueryObjectFactory of = new PostpaidQueryObjectFactory();
			PostPaidBilledQueryRequest request = of.createRequest();
			request.setMSISDN(msisdn);
			request.setAccountNumber(subscriber.getACCOUNTNUMBER());
			
			PostPaidBilledQueryResponse response = endPoint.postPaidBilledQuery(request);
			
			if (response != null && response.getStatus() != null && response.getStatus().equals(TibcoResponse.SUCCESS.code())) {
				List<BillHistory> billHistory = response.getBillHistory();
				if (billHistory != null) {
					for (BillHistory bh : billHistory) {
						OutstandingBalance balance = new OutstandingBalance();
						balance.setAmount(Double.parseDouble(bh.getAmount()));
						balance.setDueDate(bh.getBillDueDate());
						
						String paymentStatus = bh.getPaymentStatus();
						if (paymentStatus == null) paymentStatus = "";
						
						if (paymentStatus.equals(BILL_NOT_PAID)) {
							balance.setStatus(BillPaymentStatus.UNPAID);
						} else if (paymentStatus.equals(BILL_PARTIALLY_PAID)) {
							balance.setStatus(BillPaymentStatus.PARTIALLY_PAID);
						} else if (paymentStatus.equals(BILL_PAID)) {
							balance.setStatus(BillPaymentStatus.PAID);
						}
						
						result.add(balance);
					}
				}
			}
			
		} catch (Exception e) {
			logger.error("#getOutstandingBalances --- error retrieving outstanding balances for MSISDN " + msisdn, e);
		}
		return result;
	}*/
	
	@Override
	public List<OutstandingBalance> getOutstandingBalances(String msisdn) {

		List<OutstandingBalance> result = new ArrayList<>();
		
		try {
			msisdn = AppUtils.prependCountryCodeToMsisdn(msisdn, applicationConfigurationService.getDefaultCountryCode());
			SubscriberQueryResponse subscriber = getSubscriberInfo(msisdn);

			PostpaidQueryObjectFactory of = new PostpaidQueryObjectFactory();
			PostPaidBilledQueryRequest request = of.createRequest();
			request.setMSISDN(msisdn);
			request.setAccountNumber(subscriber.getACCOUNTNUMBER());
			
			PostPaidBilledQueryResponse response = endPoint.postPaidBilledQuery(request);
			
			if (response != null && response.getStatus() != null && response.getStatus().equals(TibcoResponse.SUCCESS.code())) {
				List<BillHistory> billHistory = response.getBillHistory();
				if (billHistory != null) {
					for (BillHistory bh : billHistory) {
						OutstandingBalance balance = new OutstandingBalance();
						balance.setAmount(Double.parseDouble(bh.getAmount()));
						balance.setDueDate(bh.getBillDueDate());
						
						balance.setDueDateAsDate(AppUtils.stringToDate(bh.getBillDueDate(), getShortDateFormat()));
						
						String paymentStatus = bh.getPaymentStatus();
						if (paymentStatus == null) paymentStatus = "";
						
						if (paymentStatus.equals(BILL_NOT_PAID)) {
							balance.setStatus(BillPaymentStatus.UNPAID);
						} else if (paymentStatus.equals(BILL_PARTIALLY_PAID)) {
							balance.setStatus(BillPaymentStatus.PARTIALLY_PAID);
						} else if (paymentStatus.equals(BILL_PAID)) {
							balance.setStatus(BillPaymentStatus.PAID);
						}
						
						result.add(balance);
					}
				}
			}
			
		} catch (Exception e) {
			logger.error("#getOutstandingBalances --- error retrieving outstanding balances for MSISDN " + msisdn, e);
		}
		return result;
	}


	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.TibcoServiceProvider#getDepositAmount(java.lang.String)
	 */
	/**Comment on 17-12-2018 method name getDepositBalance */
	/*@Override
	public double getDepositBalance(String msisdn) {
		try {
			PostpaidBalanceEnquiryObjectFactory of = new PostpaidBalanceEnquiryObjectFactory();
			PostpaidBalanceEnquiryRequest request = of.createRequest();
			request.setMSISDN(AppUtils.prependCountryCodeToMsisdn(msisdn, applicationConfigurationService.getDefaultCountryCode()));
			
			PostpaidBalanceEnquiryResponse response = endPoint.postpaidBalanceEnquiry(request);
			if (response != null && response.getStatus() != null && response.getStatus().equals(TibcoResponse.SUCCESS.code())) {
				return Double.parseDouble(response.getDepositedAmount());
			}
		} catch (Exception e) {
			logger.error("#getDepositAmount --- error retrieving outstanding balance info from Tibco for MSISDN= " + msisdn, e);
		}
		return 0;
	}*/
	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.TibcoServiceProvider#getDepositAmount(java.lang.String)
	 */
	@Override
	public double getDepositBalance(String msisdn) {
		try {
			PostpaidBalanceEnquiryObjectFactory of = new PostpaidBalanceEnquiryObjectFactory();
			PostpaidBalanceEnquiryRequest request = of.createRequest();
			request.setMSISDN(AppUtils.prependCountryCodeToMsisdn(msisdn, applicationConfigurationService.getDefaultCountryCode()));
			
			PostpaidBalanceEnquiryResponse response = endPoint.postpaidBalanceEnquiry(request);
			if (response != null && response.getStatus() != null && response.getStatus().equals(TibcoResponse.SUCCESS.code())) {
				return Double.parseDouble(response.getDepositedAmount());
			}
		} catch (Exception e) {
			logger.error("#getDepositAmount --- error retrieving outstanding balance info from Tibco for MSISDN= " + msisdn, e);
		}
		return 0;
	}
	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.TibcoServiceProvider#getBillingSummaryDetails(java.lang.Integer)
	 */
	/**Comment on 17-12-2018 method name getBillingSummaryDetails*/
	/*@Override
	public BillingSummaryDetails getBillingSummaryDetails(Integer id) {
		
		BillingSummaryDetails details = new BillingSummaryDetails();
		try {
			RptInvoiceSummary rpt = invoiceSummaryRepository.findOne(id);
			if (rpt != null) {
				details.setAdjustment(rpt.getAdjustment() != null ? rpt.getAdjustment() : 0);
				details.setBalanceBroughtForward(rpt.getBalancebroughtforward() != null ? rpt.getBalancebroughtforward() : 0);
				details.setCharge(rpt.getCharge() != null ? rpt.getCharge() : 0);
				details.setContractPenaltyCharge(rpt.getContractpenaltycharge() != null ? rpt.getContractpenaltycharge() : 0);
				details.setCreditLimit(rpt.getCreditlimit() != null ? rpt.getCreditlimit() : 0);
				details.setDataCharges(rpt.getDatacharges() != null ? rpt.getDatacharges() : 0);
				details.setDepositMoney(rpt.getDepositmoney() != null ? rpt.getDepositmoney() : 0);
				details.setDiscount(rpt.getDiscount() != null ? rpt.getDiscount() : 0);
				details.setEndPeriod(AppUtils.dateToString(rpt.getEndperiod(), getShortDateFormat()));
				details.setExcessPayment(rpt.getExcesspayment() != null ? rpt.getExcesspayment() : 0);
				details.setId(rpt.getId());
				details.setIddCharges(rpt.getIddcharges() != null ? rpt.getIddcharges() : 0);
				details.setInvoiceDate(AppUtils.dateToString(rpt.getInvoicedate(), getShortDateFormat()));
				details.setInvoiceDueDate(AppUtils.dateToString(rpt.getInvoiceduedate(), getShortDateFormat()));
				details.setInvoicenumber(rpt.getInvoicenumber());
				details.setIrCharges(rpt.getIrcharges() != null ? rpt.getIrcharges() : 0);
				details.setLastmonthBill(rpt.getLastmonthbill() != null ? rpt.getLastmonthbill() : 0);
				details.setLocalCharges(rpt.getLocalcharges() != null ? rpt.getLocalcharges() : 0);
				details.setLongDistance(rpt.getLongdistance() != null ? rpt.getLongdistance() : 0);
				details.setMinimumCommitmentCharge(rpt.getMinimumcommitmentcharge() != null ? rpt.getMinimumcommitmentcharge() : 0);
				details.setMmsCharges(rpt.getMmscharges() != null ? rpt.getMmscharges() : 0);
				details.setMonthlyCharge(rpt.getMonthlycharge() != null ? rpt.getMonthlycharge() : 0);
				details.setMonthlyFee(rpt.getMonthlyfee() != null ? rpt.getMonthlyfee() : 0);
				details.setMsisdn(rpt.getMsisdn());
				details.setOthers(rpt.getOthers() != null ? rpt.getOthers() : 0);
				details.setOthersVat(rpt.getOthersvat() != null ? rpt.getOthersvat() : 0);
				details.setOutstandingBilling(rpt.getOutstandingbilling() != null ? rpt.getOutstandingbilling() : 0);
				details.setPaymentReceived(rpt.getPaymentreceived() != null ? rpt.getPaymentreceived() : 0);
				details.setPostdiscount(rpt.getPostdiscount() != null ? rpt.getPostdiscount() : 0);
				details.setPrediscount(rpt.getPrediscount() != null ? rpt.getPrediscount() : 0);
				details.setPrintingCost(rpt.getPrintingcost() != null ? rpt.getPrintingcost() : 0);
				details.setSmsCharges(rpt.getSmscharges() != null ? rpt.getSmscharges() : 0);
				details.setStampDuty(rpt.getStampduty() != null ? rpt.getStampduty() : 0);
				details.setStartPeriod(AppUtils.dateToString(rpt.getStartperiod(), getShortDateFormat()));
				details.setSubtotal(rpt.getSubtotal() != null? rpt.getSubtotal() : 0);
				details.setThismonthBill(rpt.getThismonthbill() != null ? rpt.getThismonthbill() : 0);
				details.setTotalAdjustment(rpt.getTotaladjustment() != null ? rpt.getTotaladjustment() : 0);
				details.setTotalBilling(rpt.getTotalbilling() != null ? rpt.getTotalbilling() : 0);
				details.setTotalCharge(rpt.getTotalcharge() != null ? rpt.getTotalcharge() : 0);
				details.setTotalDiscount(rpt.getTotaldiscount() != null ? rpt.getTotaldiscount() : 0);
				details.setTotalDue(rpt.getTotaldue() != null? rpt.getTotaldue() : 0);
				details.setTotalExcessPayment(rpt.getTotalExcesspayment() != null ? rpt.getTotalExcesspayment() : 0);
				details.setTotalOutstandingBilling(rpt.getTotalOutstandingbilling() != null ? rpt.getTotalOutstandingbilling() : 0);
				details.setTotalPaymentReceived(rpt.getTotalPaymentreceived());
				details.setTotalStampDuty(rpt.getTotalstampduty() != null ? rpt.getTotalstampduty() : 0);
				details.setTotalUsage(rpt.getTotalusage() != null ? rpt.getTotalusage() : 0);
				details.setTotalVAT(rpt.getTotalvat() != null ? rpt.getTotalvat() : 0);
				details.setUsageVariance(rpt.getUsagevariance() != null ? rpt.getUsagevariance() : 0);
				details.setVat(rpt.getVat() != null ? rpt.getVat() : 0);
				details.setVideoCharges(rpt.getVideocharges() != null ? rpt.getVideocharges() : 0);
			}
		} catch (Exception e) {
			logger.error("#getBillingSummaryDetails --- error retrieving billing summary details!", e);
		}
		return details;
	}
*/	
	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.TibcoServiceProvider#getBillingSummaryDetails(java.lang.Integer)
	 */
	@Override
	public BillingSummaryDetails getBillingSummaryDetails(Integer id) {
		
		BillingSummaryDetails details = new BillingSummaryDetails();
		try {
			RptInvoiceSummary rpt = invoiceSummaryRepository.findOne(id);
			if (rpt != null) {
				details.setAdjustment(rpt.getAdjustment() != null ? rpt.getAdjustment() : 0);
				details.setBalanceBroughtForward(rpt.getBalancebroughtforward() != null ? rpt.getBalancebroughtforward() : 0);
				details.setCharge(rpt.getCharge() != null ? rpt.getCharge() : 0);
				details.setContractPenaltyCharge(rpt.getContractpenaltycharge() != null ? rpt.getContractpenaltycharge() : 0);
				details.setCreditLimit(rpt.getCreditlimit() != null ? rpt.getCreditlimit() : 0);
				details.setDataCharges(rpt.getDatacharges() != null ? rpt.getDatacharges() : 0);
				details.setDepositMoney(rpt.getDepositmoney() != null ? rpt.getDepositmoney() : 0);
				details.setDiscount(rpt.getDiscount() != null ? rpt.getDiscount() : 0);
				details.setEndPeriod(AppUtils.dateToString(rpt.getEndperiod(), getShortDateFormat()));
				details.setExcessPayment(rpt.getExcesspayment() != null ? rpt.getExcesspayment() : 0);
				details.setId(rpt.getId());
				details.setIddCharges(rpt.getIddcharges() != null ? rpt.getIddcharges() : 0);
				details.setInvoiceDate(AppUtils.dateToString(rpt.getInvoicedate(), getShortDateFormat()));
				details.setInvoiceDueDate(AppUtils.dateToString(rpt.getInvoiceduedate(), getShortDateFormat()));
				details.setInvoicenumber(rpt.getInvoicenumber());
				details.setIrCharges(rpt.getIrcharges() != null ? rpt.getIrcharges() : 0);
				details.setLastmonthBill(rpt.getLastmonthbill() != null ? rpt.getLastmonthbill() : 0);
				details.setLocalCharges(rpt.getLocalcharges() != null ? rpt.getLocalcharges() : 0);
				details.setLongDistance(rpt.getLongdistance() != null ? rpt.getLongdistance() : 0);
				details.setMinimumCommitmentCharge(rpt.getMinimumcommitmentcharge() != null ? rpt.getMinimumcommitmentcharge() : 0);
				details.setMmsCharges(rpt.getMmscharges() != null ? rpt.getMmscharges() : 0);
				details.setMonthlyCharge(rpt.getMonthlycharge() != null ? rpt.getMonthlycharge() : 0);
				details.setMonthlyFee(rpt.getMonthlyfee() != null ? rpt.getMonthlyfee() : 0);
				details.setMsisdn(rpt.getMsisdn());
				details.setOthers(rpt.getOthers() != null ? rpt.getOthers() : 0);
				details.setOthersVat(rpt.getOthersvat() != null ? rpt.getOthersvat() : 0);
				details.setOutstandingBilling(rpt.getOutstandingbilling() != null ? rpt.getOutstandingbilling() : 0);
				details.setPaymentReceived(rpt.getPaymentreceived() != null ? rpt.getPaymentreceived() : 0);
				details.setPostdiscount(rpt.getPostdiscount() != null ? rpt.getPostdiscount() : 0);
				details.setPrediscount(rpt.getPrediscount() != null ? rpt.getPrediscount() : 0);
				details.setPrintingCost(rpt.getPrintingcost() != null ? rpt.getPrintingcost() : 0);
				details.setSmsCharges(rpt.getSmscharges() != null ? rpt.getSmscharges() : 0);
				details.setStampDuty(rpt.getStampduty() != null ? rpt.getStampduty() : 0);
				details.setStartPeriod(AppUtils.dateToString(rpt.getStartperiod(), getShortDateFormat()));
				details.setSubtotal(rpt.getSubtotal() != null? rpt.getSubtotal() : 0);
				details.setThismonthBill(rpt.getThismonthbill() != null ? rpt.getThismonthbill() : 0);
				details.setTotalAdjustment(rpt.getTotaladjustment() != null ? rpt.getTotaladjustment() : 0);
				details.setTotalBilling(rpt.getTotalbilling() != null ? rpt.getTotalbilling() : 0);
				details.setTotalCharge(rpt.getTotalcharge() != null ? rpt.getTotalcharge() : 0);
				details.setTotalDiscount(rpt.getTotaldiscount() != null ? rpt.getTotaldiscount() : 0);
				details.setTotalDue(rpt.getTotaldue() != null? rpt.getTotaldue() : 0);
				details.setTotalExcessPayment(rpt.getTotalExcesspayment() != null ? rpt.getTotalExcesspayment() : 0);
				details.setTotalOutstandingBilling(rpt.getTotalOutstandingbilling() != null ? rpt.getTotalOutstandingbilling() : 0);
				details.setTotalPaymentReceived(rpt.getTotalPaymentreceived());
				details.setTotalStampDuty(rpt.getTotalstampduty() != null ? rpt.getTotalstampduty() : 0);
				details.setTotalUsage(rpt.getTotalusage() != null ? rpt.getTotalusage() : 0);
				details.setTotalVAT(rpt.getTotalvat() != null ? rpt.getTotalvat() : 0);
				details.setUsageVariance(rpt.getUsagevariance() != null ? rpt.getUsagevariance() : 0);
				details.setVat(rpt.getVat() != null ? rpt.getVat() : 0);
				details.setVideoCharges(rpt.getVideocharges() != null ? rpt.getVideocharges() : 0);
			}
		} catch (Exception e) {
			logger.error("#getBillingSummaryDetails --- error retrieving billing summary details!", e);
		}
		return details;
	}

	
	
}
