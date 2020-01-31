/**
 * BackEndRequestProcessorImpl.java
 */
package com.gnv.vnm.selfcare.core.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gnv.vnm.selfcare.core.AppDefaultValues;
import com.gnv.vnm.selfcare.core.adapter.BackEndAdapterException;
import com.gnv.vnm.selfcare.core.adapter.BackEndAdapterResponse;
import com.gnv.vnm.selfcare.core.adapter.BackEndConnection;
import com.gnv.vnm.selfcare.core.adapter.RechargeResponse;
import com.gnv.vnm.selfcare.core.adapter.WebServiceBackEndConnection;
import com.gnv.vnm.selfcare.core.adapter.fatty.FattyAdapter;
import com.gnv.vnm.selfcare.core.adapter.fatty.FattyAdapterFactory;
import com.gnv.vnm.selfcare.core.adapter.fatty.FattyAdapterPool;
import com.gnv.vnm.selfcare.core.adapter.fatty.RedeemPointRequestFatty;
import com.gnv.vnm.selfcare.core.adapter.gamify.GamifyAdapter;
import com.gnv.vnm.selfcare.core.adapter.gamify.GamifyConnection;
import com.gnv.vnm.selfcare.core.adapter.gamify.GamifyGetMonsterResponse;
import com.gnv.vnm.selfcare.core.adapter.gamify.GamifyGetMonstersRequest;
import com.gnv.vnm.selfcare.core.adapter.gamify.GamifyRedeemByMonsterRequest;
import com.gnv.vnm.selfcare.core.adapter.loyalty.CheckPointRequest;
import com.gnv.vnm.selfcare.core.adapter.loyalty.LMSAdapter;
import com.gnv.vnm.selfcare.core.adapter.loyalty.LMSAdapterFactory;
import com.gnv.vnm.selfcare.core.adapter.loyalty.LMSAdapterPool;
import com.gnv.vnm.selfcare.core.adapter.loyalty.RedeemPointRequest;
import com.gnv.vnm.selfcare.core.adapter.radius.BasicSubscriberInfo;
import com.gnv.vnm.selfcare.core.adapter.radius.RadiusAdapter;
import com.gnv.vnm.selfcare.core.adapter.radius.RadiusAdapterFactory;
import com.gnv.vnm.selfcare.core.adapter.radius.RadiusAdapterPool;
import com.gnv.vnm.selfcare.core.adapter.radius.RadiusConnection;
import com.gnv.vnm.selfcare.core.adapter.radius.RadiusQueryRequest;
import com.gnv.vnm.selfcare.core.adapter.rtbs.RTBSAdapter;
import com.gnv.vnm.selfcare.core.adapter.rtbs.RTBSAdapterFactory;
import com.gnv.vnm.selfcare.core.adapter.rtbs.RTBSAdapterPool;
import com.gnv.vnm.selfcare.core.adapter.rtbs.RTBSProfileQueryRequest;
import com.gnv.vnm.selfcare.core.adapter.rtbs.RTBSSubscriberInfoValues;
import com.gnv.vnm.selfcare.core.adapter.rtbs.ws.ArrayOfBalanceEntity;
import com.gnv.vnm.selfcare.core.adapter.rtbs.ws.ArrayOfCallHistory;
import com.gnv.vnm.selfcare.core.adapter.rtbs.ws.ArrayOfRechargeHistory;
import com.gnv.vnm.selfcare.core.adapter.rtbs.ws.BalanceEntity;
import com.gnv.vnm.selfcare.core.adapter.rtbs.ws.CallHistory;
import com.gnv.vnm.selfcare.core.adapter.rtbs.ws.DiameterOCSHistory;
import com.gnv.vnm.selfcare.core.adapter.rtbs.ws.RechargeHistory;
import com.gnv.vnm.selfcare.core.adapter.rtbs.ws.SubscriberRetrieve;
import com.gnv.vnm.selfcare.core.adapter.sv.ws.CommonPortType;
import com.gnv.vnm.selfcare.core.adapter.sv.ws.CommonService;
import com.gnv.vnm.selfcare.core.adapter.tibco.subscriberqry.SubscriberQueryResponse;
import com.gnv.vnm.selfcare.core.adapter.upcc.UPCCAdapter;
import com.gnv.vnm.selfcare.core.adapter.upcc.UPCCAdapterFactory;
import com.gnv.vnm.selfcare.core.adapter.upcc.UPCCAdapterPool;
import com.gnv.vnm.selfcare.core.adapter.upcc.UPCCSubscribedService;
import com.gnv.vnm.selfcare.core.adapter.upcc.UPCCSubscriberData;
import com.gnv.vnm.selfcare.core.adapter.upcc.UPCCSubscriberQueryRequest;
import com.gnv.vnm.selfcare.core.adapter.upcc.UPCCSubscriberQuota;
import com.gnv.vnm.selfcare.core.adapter.vasman.VASManAdapter;
import com.gnv.vnm.selfcare.core.adapter.vasman.VASManAdapterFactory;
import com.gnv.vnm.selfcare.core.adapter.vasman.VASManAdapterPool;
import com.gnv.vnm.selfcare.core.adapter.vasman.VASManDataSharingRequest;
import com.gnv.vnm.selfcare.core.adapter.vasman.VASManProvisioningRequest;
import com.gnv.vnm.selfcare.core.adapter.vasman.VASManSelfPackageBalance;
import com.gnv.vnm.selfcare.core.adapter.vasman.VASManSelfPackageRequest;
import com.gnv.vnm.selfcare.core.adapter.vasman.VASManSubscriptionQueryRequest;
import com.gnv.vnm.selfcare.core.adapter.vasman.ws.VasProductDetail;
import com.gnv.vnm.selfcare.core.enums.BalanceType;
import com.gnv.vnm.selfcare.core.enums.BalanceUnitName;
import com.gnv.vnm.selfcare.core.enums.CallDirection;
import com.gnv.vnm.selfcare.core.enums.ClientAppId;
import com.gnv.vnm.selfcare.core.enums.DataBalanceDisplayOption;
import com.gnv.vnm.selfcare.core.enums.DataStatus;
import com.gnv.vnm.selfcare.core.enums.DefaultBackendMessage;
import com.gnv.vnm.selfcare.core.enums.DefaultBalanceName;
import com.gnv.vnm.selfcare.core.enums.LmsConfigNames;
import com.gnv.vnm.selfcare.core.enums.NotificationDisplayType;
import com.gnv.vnm.selfcare.core.enums.NotificationStatus;
import com.gnv.vnm.selfcare.core.enums.PushedCampaignType;
import com.gnv.vnm.selfcare.core.enums.RequestStatus;
import com.gnv.vnm.selfcare.core.enums.SelfPackageCycle;
import com.gnv.vnm.selfcare.core.enums.SelfPackageType;
import com.gnv.vnm.selfcare.core.enums.SubscriberType;
import com.gnv.vnm.selfcare.core.enums.SubscriptionStatus;
import com.gnv.vnm.selfcare.core.enums.SupportedLanguage;
import com.gnv.vnm.selfcare.core.enums.TibcoResponse;
import com.gnv.vnm.selfcare.core.enums.TopUpType;
import com.gnv.vnm.selfcare.core.enums.TransactionStatus;
import com.gnv.vnm.selfcare.core.fault.SubscriberNotFoundException;
import com.gnv.vnm.selfcare.core.metadata.DefaultProductMetadata;
import com.gnv.vnm.selfcare.core.model.Balance;
import com.gnv.vnm.selfcare.core.model.BasicAccount;
import com.gnv.vnm.selfcare.core.model.CallRecord;
import com.gnv.vnm.selfcare.core.model.CurrentBalance;
import com.gnv.vnm.selfcare.core.model.DataBalance;
import com.gnv.vnm.selfcare.core.model.KeyValue;
import com.gnv.vnm.selfcare.core.model.LmsItem;
import com.gnv.vnm.selfcare.core.model.MyDataBalance;
import com.gnv.vnm.selfcare.core.model.MyPromotionBalance;
import com.gnv.vnm.selfcare.core.model.MySmsBalance;
import com.gnv.vnm.selfcare.core.model.MyVoiceBalance;
import com.gnv.vnm.selfcare.core.model.OtpStatusModel;
import com.gnv.vnm.selfcare.core.model.PackageSubscription;
import com.gnv.vnm.selfcare.core.model.Product;
import com.gnv.vnm.selfcare.core.model.ScratchStatusModel;
import com.gnv.vnm.selfcare.core.model.SelfPackageBalanceName;
import com.gnv.vnm.selfcare.core.model.SelfPackagePriceMapping;
import com.gnv.vnm.selfcare.core.model.SmsCallHistoryStatusModel;
import com.gnv.vnm.selfcare.core.model.SmsRecord;
import com.gnv.vnm.selfcare.core.model.TopUpHistory;
import com.gnv.vnm.selfcare.core.security.SimplePasswordEncoder;
import com.gnv.vnm.selfcare.core.service.ApplicationConfigurationService;
import com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor;
import com.gnv.vnm.selfcare.core.service.SMPPServiceProvider;
import com.gnv.vnm.selfcare.core.service.SendSMSService;
import com.gnv.vnm.selfcare.core.service.TibcoServiceProvider;
import com.gnv.vnm.selfcare.core.utils.AppUtils;
import com.gnv.vnm.selfcare.core.utils.LoggingUtil;
import com.gnv.vnm.selfcare.core.utils.SpringUtils;
import com.gnv.vnm.selfcare.core.utils.UnitConverter;
import com.gnv.vnm.selfcare.dao.entity.BalanceNameMappingEntity;
import com.gnv.vnm.selfcare.dao.entity.BazNotifcationStatusEntity;
import com.gnv.vnm.selfcare.dao.entity.ClassOfServiceEntity;
import com.gnv.vnm.selfcare.dao.entity.FattyItemMappingsEntity;
import com.gnv.vnm.selfcare.dao.entity.LmsConfigEntity;
import com.gnv.vnm.selfcare.dao.entity.LmsItemMappingsEntity;
import com.gnv.vnm.selfcare.dao.entity.LmsKeywordMappingsEntity;
import com.gnv.vnm.selfcare.dao.entity.MetaDataEntity;
import com.gnv.vnm.selfcare.dao.entity.OtpStatusEntity;
import com.gnv.vnm.selfcare.dao.entity.ProductEntity;
import com.gnv.vnm.selfcare.dao.entity.ProductGroupEntity;
import com.gnv.vnm.selfcare.dao.entity.ProductSubscriptionEntity;
import com.gnv.vnm.selfcare.dao.entity.PushedCampaignEntity;
import com.gnv.vnm.selfcare.dao.entity.QBalanceNameMappingEntity;
import com.gnv.vnm.selfcare.dao.entity.QBazNotifcationStatusEntity;
import com.gnv.vnm.selfcare.dao.entity.QClassOfServiceEntity;
import com.gnv.vnm.selfcare.dao.entity.QFattyItemMappingsEntity;
import com.gnv.vnm.selfcare.dao.entity.QLmsConfigEntity;
import com.gnv.vnm.selfcare.dao.entity.QLmsItemMappingsEntity;
import com.gnv.vnm.selfcare.dao.entity.QLmsKeywordMappingsEntity;
import com.gnv.vnm.selfcare.dao.entity.QOtpStatusEntity;
import com.gnv.vnm.selfcare.dao.entity.QProductEntity;
import com.gnv.vnm.selfcare.dao.entity.QProductSubscriptionEntity;
import com.gnv.vnm.selfcare.dao.entity.QPushedCampaignEntity;
import com.gnv.vnm.selfcare.dao.entity.QScratchStatusEntity;
import com.gnv.vnm.selfcare.dao.entity.QSelfPackageBalanceNameEntity;
import com.gnv.vnm.selfcare.dao.entity.QSelfPackageCommonConfigEntity;
import com.gnv.vnm.selfcare.dao.entity.QSelfPackagePriceMappingEntity;
import com.gnv.vnm.selfcare.dao.entity.QSmsCallHistoryStatusEntity;
import com.gnv.vnm.selfcare.dao.entity.QSubscriberEntity;
import com.gnv.vnm.selfcare.dao.entity.QTopUpHistoryEntity;
import com.gnv.vnm.selfcare.dao.entity.QTopUpTypeEntity;
import com.gnv.vnm.selfcare.dao.entity.QVersion_DetailsEntity;
import com.gnv.vnm.selfcare.dao.entity.ScratchBlockHistoryEntity;
import com.gnv.vnm.selfcare.dao.entity.ScratchStatusEntity;
import com.gnv.vnm.selfcare.dao.entity.SelfPackageBalanceNameEntity;
import com.gnv.vnm.selfcare.dao.entity.SelfPackageCommonConfigEntity;
import com.gnv.vnm.selfcare.dao.entity.SelfPackagePriceMappingEntity;
import com.gnv.vnm.selfcare.dao.entity.SmsCallHistoryStatusEntity;
import com.gnv.vnm.selfcare.dao.entity.SubscriberEntity;
import com.gnv.vnm.selfcare.dao.entity.TopUpHistoryEntity;
import com.gnv.vnm.selfcare.dao.entity.TopUpTypeEntity;
import com.gnv.vnm.selfcare.dao.entity.TransactionHistoryEntity;
import com.gnv.vnm.selfcare.dao.entity.Version_DetailsEntity;
import com.gnv.vnm.selfcare.dao.repo.BalanceNameMappingRepository;
import com.gnv.vnm.selfcare.dao.repo.BazNotifcationStatusRepository;
import com.gnv.vnm.selfcare.dao.repo.ClassOfServiceRepository;
import com.gnv.vnm.selfcare.dao.repo.FattyKeywordMappingsRepository;
import com.gnv.vnm.selfcare.dao.repo.FattyRedeemRepository;
import com.gnv.vnm.selfcare.dao.repo.LmsConfigRepository;
import com.gnv.vnm.selfcare.dao.repo.LmsItemMappingsRepository;
import com.gnv.vnm.selfcare.dao.repo.LmsKeywordMappingsRepository;
import com.gnv.vnm.selfcare.dao.repo.OtpStatusRepository;
import com.gnv.vnm.selfcare.dao.repo.ProductRepository;
import com.gnv.vnm.selfcare.dao.repo.ProductSubscriptionRepository;
import com.gnv.vnm.selfcare.dao.repo.PushedCampaignRepository;
import com.gnv.vnm.selfcare.dao.repo.ScratchBlockRepository;
import com.gnv.vnm.selfcare.dao.repo.ScratchStatusRepository;
import com.gnv.vnm.selfcare.dao.repo.SelfPackageBalanceNameRepository;
import com.gnv.vnm.selfcare.dao.repo.SelfPackageCommonConfigRepository;
import com.gnv.vnm.selfcare.dao.repo.SelfPackagePriceMappingRepository;
import com.gnv.vnm.selfcare.dao.repo.SmsCallHistoryStatusRepository;
import com.gnv.vnm.selfcare.dao.repo.SubscriberRepository;
import com.gnv.vnm.selfcare.dao.repo.TopUpHistoryRepository;
import com.gnv.vnm.selfcare.dao.repo.TopUpTypeRepository;
import com.gnv.vnm.selfcare.dao.repo.TransactionHistoryRepository;
import com.gnv.vnm.selfcare.dao.repo.Version_DetailsRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;

/**
 * @author nandipinto
 *
 */

@Service("backEndRequestProcessor")
public class BackEndRequestProcessorImpl implements BackEndRequestProcessor, MessageSourceAware {

	private static final Logger logger = LoggerFactory.getLogger(BackEndRequestProcessorImpl.class);

	@Autowired
	private ApplicationConfigurationService applicationConfigurationService;
	@Autowired
	private TibcoServiceProvider tibcoServiceProvider;

	@Autowired
	private TopUpHistoryRepository topUpHistoryRepository;
	@Autowired
	private TransactionHistoryRepository transactionHistoryRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private SubscriberRepository subscriberRepository;
	@Autowired
	private TopUpTypeRepository topUpTypeRepository;

	@Autowired
	private ProductSubscriptionRepository productSubscriptionRepository;
	@Autowired
	private LmsItemMappingsRepository lmsItemMappingsRepository;
	@Autowired
	private LmsKeywordMappingsRepository lmsKeywordMappingsRepository;
	@Autowired
	private BalanceNameMappingRepository balanceNameMappingRepository;
	@Autowired
	private ClassOfServiceRepository classOfServiceRepository;
	@Autowired
	private SelfPackageBalanceNameRepository selfPackageBalanceNameRepository;
	@Autowired
	private SelfPackagePriceMappingRepository selfPackagePriceMappingRepository;
	@Autowired
	private SelfPackageCommonConfigRepository selfPackageCommonConfigRepository;
	@Autowired
	private LmsConfigRepository lmsConfigRepository;
	@Autowired
	private PushedCampaignRepository pushedCampaignRepository;

	@Autowired
	private SMPPServiceProvider smppServiceProvider;

	@Autowired
	private SmsCallHistoryStatusRepository smsCallHistoryStatusRepository;
	@Autowired
	private SimplePasswordEncoder passwordEncoder;
	
	@Autowired
	private Version_DetailsRepository version_DetailsRepository;
	
	@Autowired
	private FattyKeywordMappingsRepository fattyKeywordMappingsRepository;
	
	@Autowired
	private FattyRedeemRepository fattyRedeemRepository;
	
	@Autowired
	private BazNotifcationStatusRepository bazNotifcationStatusRepository;
	
	@Autowired
	private OtpStatusRepository otpstatusRepository;

	private MessageSource messageSource;

	private boolean adapterPoolEnabled = false;

	private GenericObjectPoolConfig objectPoolConfig;
	private RTBSAdapterPool rtbsAdapterPool;
	private UPCCAdapterPool upccAdapterPool;
	private VASManAdapterPool vasManAdapterPool;
	private RadiusAdapterPool radiusAdapterPool;
	private LMSAdapterPool lmsAdapterPool;
	private FattyAdapterPool fattyAdapterPool;

	private WebServiceBackEndConnection rtbsConnection = null;
	private WebServiceBackEndConnection vasManConnection = null;
	private BackEndConnection upccConnection = null;
	private RadiusConnection radiusConnection = null;
	private WebServiceBackEndConnection lmsConnection = null;
	private WebServiceBackEndConnection fattyConnection = null;
	private GamifyConnection gamifyConnection = null;

	private RTBSAdapter rtbsAdapter;
	private VASManAdapter vasManAdapter;
	private UPCCAdapter upccAdapter;
	private RadiusAdapter radiusAdapter;
	private LMSAdapter lmsAdapter;
	private FattyAdapter fattyAdapter;
	private GamifyAdapter gamifyAdapter;

	private Hashtable<String, BalanceNameMappingEntity> balanceMappings = new Hashtable<>();

	private Hashtable<String, String> cosMappings = new Hashtable<>();

	private CommonService singleViewCommonService = new CommonService();
	private CommonPortType singleViewEndPoint = null;
	///////// Changes By OneClick 10-07-2018
	@Autowired
	private ScratchStatusRepository scratchstatusRepository;
	@Autowired
	private ScratchBlockRepository scratchBlockRepository;
	
	@Autowired
	private SendSMSService sendsmsservice;

	@PostConstruct
	public void initService() throws Exception {

		loadBalanceMappings();
		loadClassOfServiceMappings();

		adapterPoolEnabled = Boolean
				.parseBoolean(applicationConfigurationService.get("adapter.poolenabled", "false").toString());

		if (adapterPoolEnabled) {
			LoggingUtil.debug(logger, "#initService -- initiating back-end adapter pools...");

			objectPoolConfig = new GenericObjectPoolConfig();
			objectPoolConfig.setTestOnBorrow(true);
			objectPoolConfig.setTestOnReturn(true);
			objectPoolConfig.setMaxIdle(Integer.parseInt(applicationConfigurationService
					.get("adapter.pool.maxidle", "" + AppDefaultValues.OBJECT_POOL_MAX_IDLE).toString()));
			objectPoolConfig.setMaxTotal(Integer.parseInt(applicationConfigurationService
					.get("adapter.pool.maxtotal", "" + AppDefaultValues.OBJECT_POOL_MAX_TOTAL).toString()));

			rtbsAdapterPool = new RTBSAdapterPool(new RTBSAdapterFactory(getRtbsConnection()), objectPoolConfig);
			upccAdapterPool = new UPCCAdapterPool(new UPCCAdapterFactory(getUpccConnection()), objectPoolConfig);
			vasManAdapterPool = new VASManAdapterPool(new VASManAdapterFactory(getVasManConnection()),
					objectPoolConfig);
			radiusAdapterPool = new RadiusAdapterPool(new RadiusAdapterFactory(getRadiusConnection()),
					objectPoolConfig);
			lmsAdapterPool = new LMSAdapterPool(new LMSAdapterFactory(getLMSConnection()), objectPoolConfig);
			fattyAdapterPool = new FattyAdapterPool(new FattyAdapterFactory(getFattyConnection()), objectPoolConfig);
			LoggingUtil.debug(logger, "#initService -- back-end adapter pools initiated.");

		} else {
			LoggingUtil.debug(logger, "#initService -- initiating RTBS adapter...");
			rtbsAdapter = new RTBSAdapter();
			try {
				rtbsAdapter.init(getRtbsConnection());
			} catch (BackEndAdapterException e1) {
				logger.error("#initService --- error initiating RTBSAdapter!", e1);
			}

			LoggingUtil.debug(logger, "#initService -- initiating UPCC adapter...");
			upccAdapter = new UPCCAdapter();
			try {
				upccAdapter.init(getUpccConnection());
			} catch (BackEndAdapterException e1) {
				logger.error("#initService --- error initiating UPCCAdapter!", e1);
			}

			LoggingUtil.debug(logger, "#initService -- initiating VASMan adapter...");
			vasManAdapter = new VASManAdapter();
			try {
				vasManAdapter.init(getVasManConnection());
			} catch (BackEndAdapterException e1) {
				logger.error("#initService --- error initiating VASManAdapter!", e1);
			}

			radiusAdapter = new RadiusAdapter();
			radiusAdapter.setConnection(getRadiusConnection());

			LoggingUtil.debug(logger, "#initService -- initiating LMS-loyalty adapter...");
			lmsAdapter = new LMSAdapter();
			try {
				lmsAdapter.init(getLMSConnection());
			} catch (BackEndAdapterException e) {
				logger.error("#initService --- error initiating LMSAdapter!", e);
			}
			LoggingUtil.debug(logger, "#initService -- initiating Fatty-loyalty adapter...");
			fattyAdapter = new FattyAdapter();
			try {
				fattyAdapter.init(getFattyConnection());
			} catch (BackEndAdapterException e) {
				logger.error("#initService --- error initiating FattyAdapter!", e);
			}
			LoggingUtil.debug(logger, "#initService -- initiating Gamify adapter...");
			gamifyAdapter = new GamifyAdapter();
			try {
				gamifyAdapter.init(getGamifyConnection());
			} catch (BackEndAdapterException e) {
				logger.error("#initService --- error initiating GamifyAdapter!", e);
			}
		}

		String svEndPoint = applicationConfigurationService
				.get("adapter.singleview.endpoint", "http://10.8.8.86:8022/services/Inbound").toString();
		singleViewEndPoint = singleViewCommonService.getCommonPortType();
		BindingProvider bp = (BindingProvider) singleViewEndPoint;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, svEndPoint);
	}

	private WebServiceBackEndConnection getRtbsConnection() {
		rtbsConnection = new WebServiceBackEndConnection(
				applicationConfigurationService.get("adapter.rtbs.conn.ip", "localhost").toString(),
				Integer.parseInt(applicationConfigurationService.get("adapter.rtbs.conn.port", "80").toString()),
				applicationConfigurationService.get("adapter.rtbs.conn.username", "").toString(),
				applicationConfigurationService.get("adapter.rtbs.conn.credential", "").toString(), "http");
		rtbsConnection.setWsdlLocation(applicationConfigurationService.get("adapter.rtbs.conn.wsdl", "").toString());
		rtbsConnection.setProtocol(applicationConfigurationService
				.get("adapter.rtbs.conn.protocol", BackEndConnection.PROTOCOL_HTTP).toString());
		rtbsConnection.setLogSoapMessage(Boolean.parseBoolean(
				applicationConfigurationService.get("adapter.rtbs.logsoapmsg.enabled", "false").toString()));

		return rtbsConnection;
	}

	private WebServiceBackEndConnection getVasManConnection() {
		vasManConnection = new WebServiceBackEndConnection(
				applicationConfigurationService.get("adapter.vasman.conn.ip", "localhost").toString(),
				Integer.parseInt(applicationConfigurationService.get("adapter.vasman.conn.port", "80").toString()),
				applicationConfigurationService.get("adapter.vasman.conn.username", "").toString(),
				applicationConfigurationService.get("adapter.vasman.conn.credential", "").toString(), "http");
		vasManConnection
				.setWsdlLocation(applicationConfigurationService.get("adapter.vasman.conn.wsdl", "").toString());
		vasManConnection.setProtocol(applicationConfigurationService
				.get("adapter.vasman.conn.protocol", BackEndConnection.PROTOCOL_HTTP).toString());
		vasManConnection.setLogSoapMessage(Boolean.parseBoolean(
				applicationConfigurationService.get("adapter.vasman.logsoapmsg.enabled", "false").toString()));

		return vasManConnection;
	}

	private BackEndConnection getUpccConnection() {
		upccConnection = new BackEndConnection(
				applicationConfigurationService.get("adapter.upcc.conn.ip", "localhost").toString(),
				Integer.parseInt(applicationConfigurationService.get("adapter.upcc.conn.port", "80").toString()),
				applicationConfigurationService.get("adapter.upcc.conn.username", "").toString(),
				applicationConfigurationService.get("adapter.upcc.conn.credential", "").toString(), "http");

		upccConnection.setConnectionTimeOut(
				Integer.parseInt(applicationConfigurationService.get("adapter.upcc.conn.timeout", "0").toString()));
		upccConnection.setMaxConcurrentConnections(
				Integer.parseInt(applicationConfigurationService.get("adapter.upcc.conn.maxcount", "1").toString()));
		upccConnection.setReconnectInterval(Integer.parseInt(applicationConfigurationService
				.get("adapter.upcc.conn.reconnectinterval", "" + BackEndConnection.RECONNECT_INTERVAL_SECS)
				.toString()));
		upccConnection.setSocketTimeOut(
				Integer.parseInt(applicationConfigurationService.get("adapter.upcc.conn.sotimeout", "0").toString()));
		upccConnection.setProtocol(applicationConfigurationService
				.get("adapter.upcc.conn.protocol", BackEndConnection.PROTOCOL_HTTP).toString());
		rtbsConnection.setLogSoapMessage(Boolean.parseBoolean(
				applicationConfigurationService.get("adapter.upcc.logsoapmsg.enabled", "false").toString()));

		return upccConnection;
	}

	private RadiusConnection getRadiusConnection() {

		radiusConnection = new RadiusConnection(
				applicationConfigurationService.get("adapter.radius.conn.ip", "localhost").toString(),
				Integer.parseInt(applicationConfigurationService.get("adapter.radius.conn.port", "667").toString()),
				applicationConfigurationService.get("adapter.radius.conn.username", "").toString(),
				applicationConfigurationService.get("adapter.radius.conn.credential", "").toString(), "ldap");

		radiusConnection
				.setSearchFilter(applicationConfigurationService.get("adapter.radius.search.filter", "").toString());
		radiusConnection.setSearchScope(
				applicationConfigurationService.get("adapter.radius.search.scope", "SUBTREE_SCOPE").toString());
		radiusConnection.setDnPrefix(applicationConfigurationService.get("adapter.radius.dn.prefix", "").toString());
		radiusConnection.setDnSuffix(applicationConfigurationService.get("adapter.radius.dn.suffix", "").toString());

		radiusConnection.setConnectionPoolEnabled(Boolean.parseBoolean(
				applicationConfigurationService.get("adapter.radius.conpool.enabled", "false").toString()));

		return radiusConnection;
	}

	private WebServiceBackEndConnection getLMSConnection() {
		lmsConnection = new WebServiceBackEndConnection(
				applicationConfigurationService.get("adapter.loyalty.conn.ip", "localhost").toString(),
				Integer.parseInt(applicationConfigurationService.get("adapter.loyalty.conn.port", "8080").toString()),
				applicationConfigurationService.get("adapter.loyalty.conn.username", "").toString(),
				applicationConfigurationService.get("adapter.loyalty.conn.credential", "").toString(), "http");
		lmsConnection.setWsdlLocation(applicationConfigurationService.get("adapter.loyalty.conn.wsdl", "").toString());
		lmsConnection.setProtocol(applicationConfigurationService
				.get("adapter.loyalty.conn.protocol", BackEndConnection.PROTOCOL_HTTP).toString());
		lmsConnection.setLogSoapMessage(Boolean.parseBoolean(
				applicationConfigurationService.get("adapter.loyalty.logsoapmsg.enabled", "false").toString()));

		return lmsConnection;
	}

	private WebServiceBackEndConnection getFattyConnection() {
		fattyConnection = new WebServiceBackEndConnection(
				applicationConfigurationService.get("adapter.fatty.conn.ip", "localhost").toString(),
				Integer.parseInt(applicationConfigurationService.get("adapter.loyalty.conn.port", "8080").toString()),
				applicationConfigurationService.get("adapter.fatty.conn.username", "").toString(),
				applicationConfigurationService.get("adapter.fatty.conn.credential", "").toString(), "http");
		fattyConnection.setWsdlLocation(applicationConfigurationService.get("adapter.fatty.conn.wsdl", "").toString());

		fattyConnection.setProtocol(applicationConfigurationService
				.get("adapter.fatty.conn.protocol", BackEndConnection.PROTOCOL_HTTP).toString());

		fattyConnection.setLogSoapMessage(Boolean.parseBoolean(
				applicationConfigurationService.get("adapter.fatty.logsoapmsg.enabled", "false").toString()));

		return fattyConnection;
	}

	private GamifyConnection getGamifyConnection() {

		gamifyConnection = new GamifyConnection(
				applicationConfigurationService
						.get("adapter.gamify.url.getmonsters", "http://10.8.1.117/api/getMonster.php").toString(),
				applicationConfigurationService
						.get("adapter.gamify.url.redeembymonster", "http://10.8.1.117/api/redeemByMonster.php")
						.toString());

		gamifyConnection.setConnectionTimeOut(Integer
				.parseInt(applicationConfigurationService.get("adapter.gamify.connecttimeout", "10").toString()));
		gamifyConnection.setSocketTimeOut(
				Integer.parseInt(applicationConfigurationService.get("adapter.gamify.sockettimeout", "10").toString()));

		return gamifyConnection;
	}

	private RTBSAdapter getRTBSAdapter() {
		if (adapterPoolEnabled) {
			try {
				return rtbsAdapterPool.borrowObject();
			} catch (Exception e) {
				logger.error(
						"#getRTBSAdapter -- could not get RTBSAdapter from pool, returning default adapter instance.",
						e);
			}
		}
		return rtbsAdapter;
	}

	private UPCCAdapter getUPCCAdapter() {
		if (adapterPoolEnabled) {
			try {
				return upccAdapterPool.borrowObject();
			} catch (Exception e) {
				logger.error(
						"#getUPCCAdapter -- could not get UPCCAdapter from pool, returning default adapter instance.",
						e);
			}
		}
		return upccAdapter;
	}

	private VASManAdapter getVASManAdapter() {
		if (adapterPoolEnabled) {
			try {
				return vasManAdapterPool.borrowObject();
			} catch (Exception e) {
				logger.error(
						"#getVASManAdapter -- could not get VASManAdapter from pool, returning default adapter instance.",
						e);
			}
		}
		return vasManAdapter;
	}

	private RadiusAdapter getRadiusAdapter() {
		if (adapterPoolEnabled) {
			try {
				return radiusAdapterPool.borrowObject();
			} catch (Exception e) {
				logger.error(
						"#getRadiusAdapter -- could not get Radius adapter from pool, returning default adapter instance.",
						e);
			}
		}
		return this.radiusAdapter;
	}

	private LMSAdapter getLMSAdapter() {
		if (adapterPoolEnabled) {
			try {
				return lmsAdapterPool.borrowObject();
			} catch (Exception e) {
				logger.error(
						"#getLMSAdapter -- could not get LMS adapter from pool, returning default adapter instance.",
						e);
			}
		}
		return this.lmsAdapter;
	}

	private FattyAdapter getFattyAdapter() {
		if (adapterPoolEnabled) {
			try {
				return fattyAdapterPool.borrowObject();
			} catch (Exception e) {

				logger.error(
						"#getFattyAdapter -- could not get Fatty adapter from pool, returning default adapter instance.",
						e);
			}
		}
		return this.fattyAdapter;
	}

	private GamifyAdapter getGamifyAdapter() {
		// TODO configure adapter pool for gamifyadapter
		return gamifyAdapter;
	}

	@Scheduled(fixedDelayString = "${app.config.reloadinterval:300000}")
	@Override
	public void loadBalanceMappings() {
		try {
			Iterable<BalanceNameMappingEntity> list = balanceNameMappingRepository
					.findAll(QBalanceNameMappingEntity.balanceNameMappingEntity.nameOnRTBS.asc());
			if (list != null) {
				for (BalanceNameMappingEntity bme : list) {
					this.balanceMappings.put(bme.getNameOnRTBS(), bme);
				}
			}
		} catch (Exception e) {
			logger.error("#loadBalanceMappings --- error when loading balance mappings!", e);
		}
	}

	@Scheduled(fixedDelayString = "${app.config.reloadinterval:300000}")
	@Override
	public void loadClassOfServiceMappings() {
		try {
			Iterable<ClassOfServiceEntity> list = classOfServiceRepository
					.findAll(QClassOfServiceEntity.classOfServiceEntity.name.asc());
			if (list != null) {
				for (ClassOfServiceEntity cse : list) {
					this.cosMappings.put(cse.getName(), cse.getDisplayName());
				}
			}
		} catch (Exception e) {
			logger.error("#loadClassOfServiceMappings --- error loading COS mappings!", e);
		}
	}

	private BalanceNameMappingEntity getBalanceMap(String key) {
		return this.balanceMappings.get(key);
	}

	private boolean isNewStackSubscriber(String msisdn) {

		// updated Jun 26, 2018
		// always return true as all subscribers have been migrated to SV
		return true;

		/*
		 * String result = ""; try { boolean tibcoEnabled =
		 * Boolean.parseBoolean(applicationConfigurationService.get(
		 * "service.tibco.enabled", "true").toString()); if (tibcoEnabled){
		 * result = singleViewEndPoint.migratedServiceRequest(msisdn); } } catch
		 * (Exception e) { logger.error(String.
		 * format("#isNewStackSubscriber --- (%s) error querying subscriber status to SingleView!"
		 * , msisdn), e); } return result != null && result.equals("1");
		 */
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#getBasicAccount
	 * (java.lang.String)
	 */
	@Override
	public BasicAccount getBasicAccount(String subscriberId) {

		BasicAccount account = new BasicAccount();
		account.setMsisdn(subscriberId);

		String msisdn = subscriberId;

		subscriberId = AppUtils.prependCountryCodeToMsisdn(subscriberId,
				applicationConfigurationService.getDefaultCountryCode());

		double coreBalance = 0;
		String cos = null, cosDisplayName = null;
		if (isNewStackSubscriber(subscriberId)) {
			SubscriberQueryResponse sqr = tibcoServiceProvider.getSubscriberInfo(subscriberId);
			if (sqr != null) {
				cos = sqr.getCALLPLAN();
				cosDisplayName = this.cosMappings.get(sqr.getCALLPLAN());
				boolean postpaid = sqr.getRESTRICTEDDATE().equals("01/01/0001 00:00:00")
						|| sqr.getTERMINATEDDATE().equals("01/01/0001 00:00:00");
				account.setType(postpaid ? SubscriberType.POSTPAID : SubscriberType.PREPAID);

				coreBalance = Integer.parseInt(sqr.getMAINACCOUNTBALANCE());
			}

		} else {

			RTBSAdapter adapter = getRTBSAdapter();
			try {
				RTBSProfileQueryRequest request = new RTBSProfileQueryRequest();
				request.setSubscriberId(subscriberId);
				request.setWithHistory(false);
				request.setInformationToRetrieve(RTBSSubscriberInfoValues.SUBSCRIBER_ENTITY.getValue());

				//###########################################################
				long startTime= System.currentTimeMillis();
				logger.debug("fetching response   from  RTBS ");
				
				BackEndAdapterResponse response = adapter.sendRequest(request);

				//###########################################################
				long endTime= System.currentTimeMillis();
				logger.debug("execution time to fetch subscriber info  from RTBS in millis "+(endTime-startTime));
				

				LoggingUtil.debug(logger,
						String.format("#getClassOfServiceName -- retrieving Class of Service name from RTBS "
								+ ">> subscriber_id= %s", subscriberId) + ", receiving response= " + response);

				if (response.isSuccessful()) {
					SubscriberRetrieve subscriber = (SubscriberRetrieve) response.getResult();
					cos = subscriber.getSubscriberData().getCOSName();
					cosDisplayName = this.cosMappings.get(subscriber.getSubscriberData().getCOSName());

					ArrayOfBalanceEntity arrBalance = subscriber.getSubscriberData().getBalances();

					Balance balance = extractCoreBalance(arrBalance.getBalance());
					if (balance != null) {
						coreBalance = balance.getAvailableValue();
					}
				}

				account.setType(SubscriberType.PREPAID);

			} catch (Exception e) {
				logger.error(String.format(
						"#getClassOfServiceName -- error retrieving Class of Service name from RTBS >> subscriber_id= %s",
						subscriberId), e);

			} finally {

				if (adapterPoolEnabled && adapter != null) {
					rtbsAdapterPool.returnObject(adapter);
				}
			}
		}
		account.setCos(cos);
		account.setCosDisplayName(cosDisplayName != null ? cosDisplayName : cos);

		// TODO Fatty monster enhancement (FCM related)
		// createTopUpReminder(coreBalance, msisdn);

		return account;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#
	 * getClassOfServiceName(java.lang.String)
	 */
	@Override
	public String getClassOfServiceName(String subscriberId) {

		subscriberId = AppUtils.prependCountryCodeToMsisdn(subscriberId,
				applicationConfigurationService.getDefaultCountryCode());

		if (isNewStackSubscriber(subscriberId)) {
			String cos = tibcoServiceProvider.getClassOfServiceName(subscriberId);
			String displayName = null;
			if (cos != null) {
				displayName = this.cosMappings.get(cos);
			}
			return displayName != null ? displayName : cos;
		}

		RTBSAdapter adapter = getRTBSAdapter();
		try {
			RTBSProfileQueryRequest request = new RTBSProfileQueryRequest();
			request.setSubscriberId(subscriberId);
			request.setWithHistory(false);
			request.setInformationToRetrieve(RTBSSubscriberInfoValues.SUBSCRIBER_ENTITY.getValue());

			BackEndAdapterResponse response = adapter.sendRequest(request);

			LoggingUtil.debug(logger, String.format(
					"#getClassOfServiceName -- retrieving Class of Service name from RTBS " + ">> subscriber_id= %s",
					subscriberId) + ", receiving response= " + response);

			if (response.isSuccessful()) {
				SubscriberRetrieve subscriber = (SubscriberRetrieve) response.getResult();
				String cos = subscriber.getSubscriberData().getCOSName();
				String displayName = this.cosMappings.get(cos);
				return displayName != null ? displayName : cos;
			}

		} catch (Exception e) {
			logger.error(String.format(
					"#getClassOfServiceName -- error retrieving Class of Service name from RTBS >> subscriber_id= %s",
					subscriberId), e);

		} finally {

			if (adapterPoolEnabled && adapter != null) {
				rtbsAdapterPool.returnObject(adapter);
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.context.MessageSourceAware#setMessageSource(org.
	 * springframework.context.MessageSource)
	 */
	@Override
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#topUp(java.lang
	 * .String, java.lang.String)
	 */
	@Override
	public RechargeResponse topUpWithScratchCard(String subscriberId, String voucherCode, String recipientNumber,
			ClientAppId clientAppId, String referrer, String sessionId) {

		if (!StringUtils.hasText(subscriberId) && !StringUtils.hasText(voucherCode)) {
			return new RechargeResponse();
		}

		if (!StringUtils.hasText(recipientNumber))
			recipientNumber = subscriberId;

		RequestStatus status = RequestStatus.PROCESSING;
		String statusCode = "";
		double balance = 0;

		// Updated: 2017-07-21
		// directly send topup request to Tibco
		RechargeResponse rechargeResponse = tibcoServiceProvider.topUpWithScratchCard(AppUtils
				.prependCountryCodeToMsisdn(recipientNumber, applicationConfigurationService.getDefaultCountryCode()),
				voucherCode);
		balance = rechargeResponse.getBalance();
		statusCode = rechargeResponse.getCode();

		if (statusCode.equals(TibcoResponse.SUCCESS.code())) {
			// might not return updated balance information -- double check
			if (balance <= 0) {
				Balance coreBalance = getCoreBalance(subscriberId);
				rechargeResponse.setBalance(coreBalance != null ? coreBalance.getAvailableValue() : 0);
			}
			status = RequestStatus.SUCCESS;

			if (!recipientNumber.equals(subscriberId)) {

				Locale locale = new Locale(applicationConfigurationService.getDefaultLanguageCode());
				try {
					SubscriberEntity recipient = this.subscriberRepository
							.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(recipientNumber));
					if (recipient != null && StringUtils.hasText(recipient.getLanguageCode())) {
						locale = new Locale(recipient.getLanguageCode());
					} else {
						SubscriberEntity sender = this.subscriberRepository
								.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(subscriberId));
						if (sender != null && StringUtils.hasText(sender.getLanguageCode())) {
							locale = new Locale(sender.getLanguageCode());
						}
					}
				} catch (Exception e) {
				}

				Object[] params = new Object[] { rechargeResponse.getRechargeValue(), subscriberId,
						AppUtils.dateToString(new Date(), "dd/MM/yyyy HH:mm:ss") };
				String message = SpringUtils.resolveMessage(messageSource, "Message.Topup.ForOtherNumber", params,
						String.format(DefaultBackendMessage.TOPUP_FOR_ANOTHER_NUMBER.getMessage(), params), locale);

				String sender = applicationConfigurationService.get("smpp.defaultsender", "SELFCARE").toString();
				sendsmsservice.sendSMS(sender, recipientNumber, message, true, null, null);

			}

			// TODO remove this comment
			removeTopupReminders(subscriberId, rechargeResponse.getBalance());
		} else {
			status = RequestStatus.FAIL;
		}

		createTopUpHistory(subscriberId, voucherCode, rechargeResponse.getRechargeValue(), status.ordinal(),
				TopUpType.SCRATCH_CARD.name(), null,
				clientAppId != null ? clientAppId.name() : ClientAppId.MOBILE_APP.name(), referrer, sessionId);

		return rechargeResponse;
	}

	private void createTopUpHistory(String msisdn, String voucherCode, double amount, Integer status, String channelId,
			String refTrxId, String clientAppId, String referrer, String sessionId) {
		// create top-up history
		try {
			TopUpHistoryEntity history = new TopUpHistoryEntity(msisdn, voucherCode, amount, new Date(), status);
			history.setRefTrxId(refTrxId);
			history.setChannelId(channelId);
			history.setClientAppId(clientAppId);
			history.setReferrer(referrer);
			history.setSessionId(sessionId);

			topUpHistoryRepository.saveAndFlush(history);
		} catch (Exception e) {
			logger.error("#createTopUpHistory -- error creating top up history " + "(subscriber_id= " + msisdn
					+ ", voucher_code= " + voucherCode + ", balance= " + amount + ",)", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#etopUp(java.
	 * lang.String, double, java.lang.String)
	 */
	@Override
	public RechargeResponse etopUp(String subscriberId, double amount, String refTrxId, String referrer) {

		String statusCode = "";

		// Q8Qe6unCc9LqDO1q9j3wVx8tBsInuI6YTuLSEE2u
		String refCode = "ET_";
		if (StringUtils.hasText(refTrxId)) {
			refCode = refCode + refTrxId.substring(0, 13);
		} else {
			refCode = refCode + AppUtils.dateToString(new Date(), "yyyyMMddHHmmss");
		}
		RechargeResponse rechargeResponse = tibcoServiceProvider.etopUp(AppUtils.prependCountryCodeToMsisdn(
				subscriberId, applicationConfigurationService.getDefaultCountryCode()), amount, refCode, refTrxId);
		statusCode = rechargeResponse.getCode();

		if (statusCode.equals(TibcoResponse.SUCCESS.code())) {
			if (rechargeResponse.getBalance() <= 0) {
				Balance balance = getCoreBalance(subscriberId);
				rechargeResponse.setBalance(balance != null ? balance.getAvailableValue() : 0);
			}

			// TODO remove comment
			removeTopupReminders(subscriberId, rechargeResponse.getBalance());
		}

		return rechargeResponse;
	}

	/**
	 * Delete (all) Fatty monster notification for the user after successful
	 * top-up
	 * 
	 * @param msisdn
	 */
	private void removeTopupReminders(String msisdn, double coreBalanceAmt) {
		LoggingUtil.debug(logger, "#removeTopupReminders --- msisdn= " + msisdn);
		try {
			double minBalance = Double
					.parseDouble(getLmsConfigValue(LmsConfigNames.CORE_BALANCE_MIN_AMOUNT.name(), "5000").toString());

			if (coreBalanceAmt >= minBalance) {
				Iterable<PushedCampaignEntity> list = pushedCampaignRepository
						.findAll(QPushedCampaignEntity.pushedCampaignEntity.targetedUser.isNotNull()
								.and(QPushedCampaignEntity.pushedCampaignEntity.targetedUser.eq(msisdn))
								.and(QPushedCampaignEntity.pushedCampaignEntity.type.isNotNull()
										.and(QPushedCampaignEntity.pushedCampaignEntity.type
												.eq(PushedCampaignType.FCM.ordinal()))));
				// .and(QPushedCampaignEntity.pushedCampaignEntity.displayType.eq(NotificationDisplayType.PUSHED.ordinal()))));

				if (list != null) {
					pushedCampaignRepository.delete(list);
				}
			}
		} catch (Exception e) {
			logger.error("#removeTopupReminders --- error removing topup reminder for msisdn= " + msisdn, e);
		}
	}

	private List<BalanceEntity> getSubscriberBalancesFromRtbs(String subscriberId) {

		RTBSAdapter adapter = getRTBSAdapter();
		List<BalanceEntity> balanceList = null;
		try {
			RTBSProfileQueryRequest request = new RTBSProfileQueryRequest();
			request.setSubscriberId(subscriberId);
			request.setWithHistory(false);
			request.setInformationToRetrieve(RTBSSubscriberInfoValues.SUBSCRIBER_ENTITY.getValue());

			BackEndAdapterResponse response = adapter.sendRequest(request);

			LoggingUtil.debug(logger,
					String.format(
							"#getSubscriberBalances -- retrieving balance details from RTBS " + ">> subscriber_id= %s",
							subscriberId) + ", receiving response= " + response);

			if (response.isSuccessful()) {
				SubscriberRetrieve subscriberData = (SubscriberRetrieve) response.getResult();
				ArrayOfBalanceEntity arrBalance = subscriberData.getSubscriberData().getBalances();

				balanceList = arrBalance.getBalance();
			}

		} catch (Exception e) {
			logger.error(String.format(
					"#getSubscriberBalances -- error retrieving balance details from RTBS >> subscriber_id= %s",
					subscriberId), e);

		} finally {
			if (adapterPoolEnabled && adapter != null) {
				rtbsAdapterPool.returnObject(adapter);
			}
		}
		return balanceList;
	}

	private List<Balance> getBalanceDetails(List<BalanceEntity> balanceList, BalanceType balanceType,
			List<String> balanceNames) {
		// 2017-05-07 -- changed date format from dd-MM-yyyy HH:mm:ss to
		// dd-MM-yyyy as requested

		String dateFormat = applicationConfigurationService.get("dateformat.default", AppDefaultValues.DATE_FORMAT)
				.toString();
		List<Balance> result = new ArrayList<>();

		if (balanceList != null) {
			try {
				// there are more than one balances defined, need to iterate
				// through the list and count the one matching the defined
				// balance names
				for (String balanceName : balanceNames) {
					for (BalanceEntity be : balanceList) {
						// if value == 0 do not include in the list -- requested
						// by VNM
						if (be.getBalanceName().equalsIgnoreCase(balanceName) && be.getAvailableBalance() > 0) {
							Balance balance = new Balance();
							balance.setName(be.getBalanceName());
							balance.setType(balanceType);
							balance.setAvailableValue((int) be.getAvailableBalance());
							balance.setTotalValue((int) be.getBalance());
							if (be.getAccountExpiration() != null) {
								Date expDate = be.getAccountExpiration().toGregorianCalendar().getTime();
								long validityPeriod = (expDate.getTime() - new Date().getTime()) / 86400000;
								if (validityPeriod >= 0) {
									balance.setExpiryDate(expDate);
									balance.setValidityPeriod((int) validityPeriod);
									balance.setExpiryDateAsString(AppUtils.dateToString(expDate, dateFormat));
								}
							}

							boolean addToList = true, counted = true;
							BalanceNameMappingEntity balanceMap = this.balanceMappings.get(balanceName);
							// LoggingUtil.debug(logger, "#getBalanceDetails ---
							// balanceMap= " + balanceMap);
							if (balanceMap != null) {
								balance.setDisplayNameEN(balanceMap.getDisplayNameEN());
								balance.setDisplayNameVI(balanceMap.getDisplayNameVI());
								balance.setUnitName(balanceMap.getUnitName());

								counted = balanceMap.getCountedFlag() != null && balanceMap.getCountedFlag().equals(1);
								addToList = balanceMap.getVisibleFlag() != null
										&& balanceMap.getVisibleFlag().equals(1);
							} else {
								balance.setDisplayNameEN(be.getBalanceName());
								balance.setDisplayNameVI(be.getBalanceName());
							}
							balance.setCounted(counted);

							// LoggingUtil.debug(logger, "#getBalanceDetails ---
							// balance= " + balance.getName() + ", counted= " +
							// counted + ", visible= " + addToList);
							if (addToList)
								result.add(balance);
						}
					}
				}
			} catch (Exception e) {
				logger.error("#getBalanceDetails --- error retrieving balance details", e);
			}
		}

		return result;
	}

	private List<String> getSmsBalanceNames() {
		List<String> list = new ArrayList<>();

		Enumeration<BalanceNameMappingEntity> en = this.balanceMappings.elements();
		while (en.hasMoreElements()) {
			BalanceNameMappingEntity bme = en.nextElement();
			if (bme.getType().equals(BalanceType.SMS.name())
					|| bme.getUnitName().equalsIgnoreCase(BalanceUnitName.SMS.name())) {
				list.add(bme.getNameOnRTBS());
			}
		}
		return list;
	}

	private List<String> getVoiceBalanceNames() {
		List<String> list = new ArrayList<>();

		Enumeration<BalanceNameMappingEntity> en = this.balanceMappings.elements();
		while (en.hasMoreElements()) {
			BalanceNameMappingEntity bme = en.nextElement();
			if (bme.getType().equals(BalanceType.VOICE.name())
					|| bme.getUnitName().equalsIgnoreCase(BalanceUnitName.SECOND.name())) {
				list.add(bme.getNameOnRTBS());
			}
		}
		return list;
	}

	private List<String> getPromotionBalanceNames() {
		List<String> list = new ArrayList<>();

		Enumeration<BalanceNameMappingEntity> en = this.balanceMappings.elements();
		while (en.hasMoreElements()) {
			BalanceNameMappingEntity bme = en.nextElement();
			// if (bme.getType().equals(BalanceType.PROMOTION.name()) &&
			// bme.getVisibleFlag() != null && bme.getVisibleFlag().equals(1)){
			if (bme.getType().equals(BalanceType.PROMOTION.name())) {
				list.add(bme.getNameOnRTBS());
			}
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#getMainBalance(
	 * java.lang.String)
	 */
	@Override
	public Balance getCoreBalance(String subscriberId) {

		String msisdn = AppUtils.prependCountryCodeToMsisdn(subscriberId,
				applicationConfigurationService.getDefaultCountryCode());

		Balance coreBalance = null;
		if (isNewStackSubscriber(subscriberId)) {
			coreBalance = tibcoServiceProvider.getCoreBalance(msisdn);
		} else {
			List<BalanceEntity> list = getSubscriberBalancesFromRtbs(msisdn);
			coreBalance = extractCoreBalance(list);
		}

		// TODO Fatty monster enhancement (FCM related)
		// createTopUpReminder(coreBalance != null ?
		// coreBalance.getAvailableValue() : 0, subscriberId);

		return coreBalance;
	}

	private Balance extractCoreBalance(List<BalanceEntity> list) {

		Balance balance = new Balance();

		if (list == null || list.isEmpty())
			return balance;

		String dateFormat = applicationConfigurationService.get("dateformat.default", AppDefaultValues.DATE_FORMAT)
				.toString();
		String coreBalanceName = applicationConfigurationService.get("adapter.rtbs.balancenames.core", "Core")
				.toString();

		Enumeration<BalanceNameMappingEntity> en = balanceMappings.elements();
		while (en.hasMoreElements()) {
			BalanceNameMappingEntity bme = en.nextElement();
			if (bme.getType().equals(BalanceType.CORE.name()))
				coreBalanceName = bme.getNameOnRTBS();
		}

		BalanceNameMappingEntity balanceMap = getBalanceMap(coreBalanceName);
		LoggingUtil.debug(logger,
				"#getCoreBalance --- core balance name= " + coreBalanceName + ", balanceMap= " + balanceMap);

		for (BalanceEntity be : list) {
			if (be.getBalanceName().equalsIgnoreCase(coreBalanceName)) {
				balance.setAvailableValue((int) be.getAvailableBalance());
				balance.setTotalValue((int) be.getBalance());
				balance.setType(BalanceType.CORE);

				if (balanceMap != null) {
					balance.setDisplayNameEN(balanceMap.getDisplayNameEN());
					balance.setDisplayNameVI(balanceMap.getDisplayNameVI());
					balance.setUnitName(balanceMap.getUnitName());
				} else {
					balance.setDisplayNameEN(be.getBalanceName());
					balance.setDisplayNameVI(be.getBalanceName());
				}
				balance.setName(be.getBalanceName());

				if (be.getAccountExpiration() != null) {
					balance.setExpiryDate(be.getAccountExpiration().toGregorianCalendar().getTime());
					long validityPeriod = (balance.getExpiryDate().getTime() - new Date().getTime()) / 86400000;
					if (validityPeriod >= 0)
						balance.setValidityPeriod((int) validityPeriod);

					balance.setExpiryDateAsString(AppUtils.dateToString(balance.getExpiryDate(), dateFormat));
				}

				break;
			}
		}

		return balance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#getVoiceBalance
	 * (java.lang.String)
	 */
	@Override
	public MyVoiceBalance getVoiceBalance(String subscriberId) {

		subscriberId = AppUtils.prependCountryCodeToMsisdn(subscriberId,
				applicationConfigurationService.getDefaultCountryCode());

		if (isNewStackSubscriber(subscriberId)) {
			return tibcoServiceProvider.getVoiceBalance(subscriberId);
		}

		List<Balance> balanceList = getBalanceDetails(getSubscriberBalancesFromRtbs(subscriberId), BalanceType.VOICE,
				getVoiceBalanceNames());
		int totalValue = 0;
		int availableValue = 0;
		int consumedValue = 0;

		for (Balance balance : balanceList) {
			totalValue = totalValue + balance.getTotalValue();
			consumedValue = consumedValue + balance.getConsumedValue();
			availableValue = availableValue + balance.getAvailableValue();
		}
		Collections.sort(balanceList, Balance.AvailableValueDescComparator);
		return new MyVoiceBalance(totalValue, consumedValue, availableValue, balanceList);
	}

	private MyVoiceBalance getVoiceBalance(List<BalanceEntity> list) {
		List<Balance> balanceList = getBalanceDetails(list, BalanceType.VOICE, getVoiceBalanceNames());
		int totalValue = 0;
		int availableValue = 0;
		int consumedValue = 0;

		for (Balance balance : balanceList) {
			totalValue = totalValue + balance.getTotalValue();
			consumedValue = consumedValue + balance.getConsumedValue();
			availableValue = availableValue + balance.getAvailableValue();
		}
		Collections.sort(balanceList, Balance.AvailableValueDescComparator);
		return new MyVoiceBalance(totalValue, consumedValue, availableValue, balanceList);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#getSmsBalance(
	 * java.lang.String)
	 */
	@Override
	public MySmsBalance getSmsBalance(String subscriberId) {
		subscriberId = AppUtils.prependCountryCodeToMsisdn(subscriberId,
				applicationConfigurationService.getDefaultCountryCode());

		if (isNewStackSubscriber(subscriberId)) {
			return tibcoServiceProvider.getSmsBalance(subscriberId);
		}

		List<Balance> balanceList = getBalanceDetails(getSubscriberBalancesFromRtbs(subscriberId), BalanceType.SMS,
				getSmsBalanceNames());

		int totalValue = 0;
		int availableValue = 0;
		int consumedValue = 0;

		for (Balance balance : balanceList) {
			totalValue = totalValue + balance.getTotalValue();
			consumedValue = consumedValue + balance.getConsumedValue();
			availableValue = availableValue + balance.getAvailableValue();
		}
		Collections.sort(balanceList, Balance.AvailableValueDescComparator);
		return new MySmsBalance(totalValue, consumedValue, availableValue, balanceList);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#
	 * getPromotionBalance(java.lang.String)
	 */
	@Override
	public MyPromotionBalance getPromotionBalance(String subscriberId, String langCode) {
		subscriberId = AppUtils.prependCountryCodeToMsisdn(subscriberId,
				applicationConfigurationService.getDefaultCountryCode());
		if (isNewStackSubscriber(subscriberId)) {
			return tibcoServiceProvider.getPromotionBalance(subscriberId, langCode);
		}

		if (!StringUtils.hasText(langCode))
			langCode = SupportedLanguage.ENGLISH.code();

		List<Balance> balanceList = getBalanceDetails(getSubscriberBalancesFromRtbs(subscriberId),
				BalanceType.PROMOTION, getPromotionBalanceNames());

		int totalValue = 0;
		int availableValue = 0;
		int consumedValue = 0;
		for (Balance balance : balanceList) {
			if (balance.isCounted()) {
				totalValue = totalValue + balance.getTotalValue();
				consumedValue = consumedValue + balance.getConsumedValue();
				availableValue = availableValue + balance.getAvailableValue();
			}
		}

		// Collections.sort(balanceList, Balance.AvailableValueDescComparator);
		if (langCode.equals(SupportedLanguage.ENGLISH.code())) {
			Collections.sort(balanceList, Balance.DisplayNameENComparator);
		} else {
			Collections.sort(balanceList, Balance.DisplayNameVIComparator);
		}
		return new MyPromotionBalance(totalValue, consumedValue, availableValue, balanceList);
	}

	private MySmsBalance getSmsBalance(List<BalanceEntity> list) {
		List<Balance> balanceList = getBalanceDetails(list, BalanceType.SMS, getSmsBalanceNames());

		int totalValue = 0;
		int availableValue = 0;
		int consumedValue = 0;

		for (Balance balance : balanceList) {
			totalValue = totalValue + balance.getTotalValue();
			consumedValue = consumedValue + balance.getConsumedValue();
			availableValue = availableValue + balance.getAvailableValue();
		}
		Collections.sort(balanceList, Balance.AvailableValueDescComparator);
		return new MySmsBalance(totalValue, consumedValue, availableValue, balanceList);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#getDataBalance(
	 * java.lang.String)
	 */
	/*
	 * @Override public MyDataBalance getDataBalance(String subscriberId, String
	 * langCode) {
	 * 
	 * // String dateFormat =
	 * applicationConfigurationService.get("dateformat.long",
	 * AppDefaultValues.DATE_TIME_FORMAT).toString(); String dateFormat =
	 * applicationConfigurationService.get("dateformat.default",
	 * AppDefaultValues.DATE_FORMAT).toString();
	 * 
	 * List<DataBalance> result = new ArrayList<>(); UPCCAdapter adapter =
	 * getUPCCAdapter();
	 * 
	 * long totalValue = 0; long availableValue = 0; long consumedValue = 0; try
	 * {
	 * 
	 * LoggingUtil.debug(logger, String.
	 * format("#getDataBalance -- retrieving data balance from UPCC >> subscriber_id= %s"
	 * , subscriberId));
	 * 
	 * UPCCSubscriberQueryRequest request = new UPCCSubscriberQueryRequest();
	 * request.setSubscriberId(AppUtils.prependCountryCodeToMsisdn(subscriberId,
	 * applicationConfigurationService.getDefaultCountryCode()));
	 * 
	 * BackEndAdapterResponse response = adapter.sendRequest(request);
	 * 
	 * LoggingUtil.debug(logger,
	 * String.format("#getDataBalance -- retrieving data balance from UPCC " +
	 * ">> subscriber_id= %s", subscriberId) + ", receiving response= " +
	 * response);
	 * 
	 * if (response.isSuccessful()){ UPCCSubscriberData subscriberData =
	 * (UPCCSubscriberData) response.getResult();
	 * 
	 * if (subscriberData != null && subscriberData.getSubscribedServices() !=
	 * null && subscriberData.getQuotas() != null){ if
	 * (!StringUtils.hasText(langCode)) { try { SubscriberEntity sub =
	 * subscriberRepository.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq
	 * (subscriberId)); if (sub != null) { langCode = sub.getLanguageCode(); } }
	 * catch (Exception e) { langCode =
	 * applicationConfigurationService.getDefaultLanguageCode();
	 * logger.error(String.
	 * format("#getDataBalance --- error retrieving subcriber details %s: " +
	 * e.getMessage(), subscriberId)); } }
	 * 
	 * List<UPCCSubscribedService> serviceList =
	 * subscriberData.getSubscribedServices(); List<UPCCSubscriberQuota>
	 * quotaList = subscriberData.getQuotas();
	 * 
	 * for (UPCCSubscribedService service:serviceList){ Date startDate =
	 * AppUtils.stringToDate(service.getStartDateTime(),
	 * UPCCAdapter.DATE_TIME_FORMAT); Date endDate =
	 * AppUtils.stringToDate(service.getEndDateTime(),
	 * UPCCAdapter.DATE_TIME_FORMAT); Date expDate =
	 * AppUtils.stringToDate(service.getOverDueDate(),
	 * UPCCAdapter.DATE_TIME_FORMAT);
	 * 
	 * if (endDate != null && endDate.getTime() >= System.currentTimeMillis()) {
	 * 
	 * boolean addToList = true;
	 * 
	 * DataBalance balance = new DataBalance(); balance.setEndDate(endDate);
	 * balance.setEndDateAsString(AppUtils.dateToString(endDate, dateFormat));
	 * balance.setOverdueDate(expDate);
	 * balance.setOverdueDateAsString(AppUtils.dateToString(expDate,
	 * dateFormat)); balance.setStartDate(startDate);
	 * balance.setStartDateAsString(AppUtils.dateToString(startDate,
	 * dateFormat)); balance.setName(service.getName());
	 * balance.setServiceName(service.getServicePackageName());
	 * balance.setDisplayNameEN(service.getName());
	 * balance.setDisplayNameVI(service.getName());
	 * 
	 * try { LoggingUtil.debug(logger,
	 * "#getDataBalance --- looking up product_code for UPCC service " +
	 * service.getName());
	 * 
	 * ProductEntity pe = null; Iterable<ProductEntity> list =
	 * productRepository.findAll(QProductEntity.productEntity.extCode.isNotNull(
	 * ).and(
	 * QProductEntity.productEntity.extCode.equalsIgnoreCase(service.getName()))
	 * , QProductEntity.productEntity.createTimestamp.desc());
	 * 
	 * if (list != null && list.iterator() != null && list.iterator().hasNext())
	 * { pe = list.iterator().next(); }
	 * 
	 * LoggingUtil.debug(logger,
	 * "#getDataBalance --- Found internal product for UPCC service " +
	 * service.getName() + " = " + (pe != null ? pe.getCode() : null));
	 * 
	 * if (pe != null){
	 * 
	 * addToList = pe.getVisibility() != null && pe.getVisibility().equals(1);
	 * if (pe.getBalanceDisplayOption() != null &&
	 * pe.getBalanceDisplayOption().equals(DataBalanceDisplayOption.
	 * CONSUMED_VALUE.ordinal()) ){
	 * balance.setDisplayOption(DataBalanceDisplayOption.CONSUMED_VALUE); } else
	 * { balance.setDisplayOption(DataBalanceDisplayOption.AVAILABLE_VALUE); }
	 * 
	 * balance.setCode(pe.getCode());
	 * balance.setDashboardVisible(pe.getDashboardVisibility() != null &&
	 * pe.getDashboardVisibility().equals(1));
	 * 
	 * if (StringUtils.hasText(pe.getExtCode())){ if
	 * (langCode.equals(AppDefaultValues.LANGUAGE_ENGLISH)) {
	 * balance.setName(pe.getNameEN()); if
	 * (StringUtils.hasText(pe.getShortNameEN())) {
	 * balance.setDisplayNameEN(pe.getShortNameEN()); } else {
	 * balance.setDisplayNameEN(pe.getNameEN()); } } else {
	 * balance.setName(pe.getNameVI()); if
	 * (StringUtils.hasText(pe.getShortNameVI())) {
	 * balance.setDisplayNameVI(pe.getShortNameVI()); } else {
	 * balance.setDisplayNameVI(pe.getNameVI()); } }
	 * balance.setServiceName(pe.getExtProductName()); } } } catch (Exception e)
	 * { logger.
	 * error("#getDataBalance --- could not get internal_product_code for " +
	 * service.getName(), e); }
	 * 
	 * for (UPCCSubscriberQuota quota:quotaList){ //service package name is
	 * associated with quota service name
	 * 
	 * if (quota.getServiceName().equals(service.getName())){
	 * balance.setRemainingValue(AppUtils.toLong(quota.getBalance()));
	 * balance.setConsumedValue(AppUtils.toLong(quota.getConsumption()));
	 * balance.setTotalValue(AppUtils.toLong(quota.getValue()));
	 * 
	 * boolean counted = true; BalanceNameMappingEntity balanceMap =
	 * this.balanceMappings.get(service.getName()); //TODO exclude/include
	 * balance from calculation -- requested by Trung, Feb 07 2018 if
	 * (balanceMap != null && balanceMap.getCountedFlag() != null &&
	 * !balanceMap.getCountedFlag().equals(1)) { counted = false; }
	 * 
	 * if (counted) { if
	 * (balance.getDisplayOption().equals(DataBalanceDisplayOption.
	 * AVAILABLE_VALUE)) { totalValue = totalValue + balance.getTotalValue();
	 * availableValue = availableValue + balance.getRemainingValue(); }
	 * 
	 * consumedValue = consumedValue + balance.getConsumedValue(); } } }
	 * balance.setRemainingValueAsString(UnitConverter.bytes2String(balance.
	 * getRemainingValue()));
	 * balance.setConsumedValueAsString(UnitConverter.bytes2String(balance.
	 * getConsumedValue()));
	 * 
	 * if (addToList) result.add(balance);
	 * 
	 * }//end if endDate.getTime() >= System.currentTimeMillis() } } }
	 * Collections.sort(result, DataBalance.RemainingValueDescComparator);
	 * 
	 * } catch (Exception e) { logger.error(String.
	 * format("#getDataBalance -- error retrieving data balance from UPCC >> subscriber_id= %s"
	 * , subscriberId), e);
	 * 
	 * } finally{ if (adapterPoolEnabled && adapter != null){
	 * upccAdapterPool.returnObject(adapter); } }
	 * 
	 * MyDataBalance myDataBalance = new
	 * MyDataBalance(DefaultBalanceName.Data.name(), totalValue, consumedValue,
	 * availableValue, result); return myDataBalance; }
	 */

	@Override
	public MyDataBalance getDataBalance(String subscriberId, String langCode) {

		// String dateFormat =
		// applicationConfigurationService.get("dateformat.long",
		// AppDefaultValues.DATE_TIME_FORMAT).toString();
		String dateFormat = applicationConfigurationService.get("dateformat.default", AppDefaultValues.DATE_FORMAT)
				.toString();

		List<DataBalance> result = new ArrayList<>();
		UPCCAdapter adapter = getUPCCAdapter();

		long totalValue = 0;
		long availableValue = 0;
		long consumedValue = 0;
		try {

			LoggingUtil.debug(logger, String
					.format("#getDataBalance -- retrieving data balance from UPCC >> subscriber_id= %s", subscriberId));

			UPCCSubscriberQueryRequest request = new UPCCSubscriberQueryRequest();
			request.setSubscriberId(AppUtils.prependCountryCodeToMsisdn(subscriberId,
					applicationConfigurationService.getDefaultCountryCode()));

			BackEndAdapterResponse response = adapter.sendRequest(request);

			LoggingUtil.debug(logger,
					String.format("#getDataBalance -- retrieving data balance from UPCC " + ">> subscriber_id= %s",
							subscriberId) + ", receiving response= " + response);

			if (response.isSuccessful()) {
				UPCCSubscriberData subscriberData = (UPCCSubscriberData) response.getResult();

				if (subscriberData != null && subscriberData.getSubscribedServices() != null
						&& subscriberData.getQuotas() != null) {
					if (!StringUtils.hasText(langCode)) {
						try {
							SubscriberEntity sub = subscriberRepository
									.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(subscriberId));
							if (sub != null) {
								langCode = sub.getLanguageCode();
							}
						} catch (Exception e) {
							langCode = applicationConfigurationService.getDefaultLanguageCode();
							logger.error(String.format(
									"#getDataBalance --- error retrieving subcriber details %s: " + e.getMessage(),
									subscriberId));
						}
					}

					List<UPCCSubscribedService> serviceList = subscriberData.getSubscribedServices();
					List<UPCCSubscriberQuota> quotaList = subscriberData.getQuotas();

					for (UPCCSubscribedService service : serviceList) {
						Date startDate = AppUtils.stringToDate(service.getStartDateTime(),
								UPCCAdapter.DATE_TIME_FORMAT);
						Date endDate = AppUtils.stringToDate(service.getEndDateTime(), UPCCAdapter.DATE_TIME_FORMAT);
						Date expDate = AppUtils.stringToDate(service.getOverDueDate(), UPCCAdapter.DATE_TIME_FORMAT);

						if (endDate != null && endDate.getTime() >= System.currentTimeMillis()) {

							boolean addToList = true;

							DataBalance balance = new DataBalance();
							balance.setEndDate(endDate);
							balance.setEndDateAsString(AppUtils.dateToString(endDate, dateFormat));
							balance.setOverdueDate(expDate);
							balance.setOverdueDateAsString(AppUtils.dateToString(expDate, dateFormat));
							balance.setStartDate(startDate);
							balance.setStartDateAsString(AppUtils.dateToString(startDate, dateFormat));
							if (service.getName().contains("Unlimit")) {
								balance.setName("Unlimited");
							} else {
								balance.setName(service.getName());
							}
							balance.setServiceName(service.getServicePackageName());

							// changes as per recomnded by toung 07/06/2018
							String nameen = service.getName();
							// if(nameen.contains("UnlimitF") ||
							// nameen.contains("UnlimitM") ||
							// nameen.contains("UnlimitFM")||
							// nameen.contains("UnlimitSM")){
							if (nameen.contains("Unlimit")) {
								nameen = "Unlimited";
							}
							String namevi = service.getName();
							// if(namevi.contains("Unlimit") ||
							// namevi.contains("UnlimitM") ||
							// namevi.contains("UnlimitFM")||
							// namevi.contains("UnlimitSM")){
							if (namevi.contains("Unlimit")) {
								namevi = "Dữ liệu không giới hạn";
							}
							balance.setDisplayNameEN(nameen);
							balance.setDisplayNameVI(namevi);

							try {
								LoggingUtil.debug(logger,
										"#getDataBalance --- looking up product_code for UPCC service "
												+ service.getName());

								ProductEntity pe = null;
								Iterable<ProductEntity> list = productRepository.findAll(
										QProductEntity.productEntity.extCode.isNotNull()
												.and(QProductEntity.productEntity.extCode
														.equalsIgnoreCase(service.getName())),
										QProductEntity.productEntity.createTimestamp.desc());

								if (list != null && list.iterator() != null && list.iterator().hasNext()) {
									pe = list.iterator().next();
								}

								LoggingUtil.debug(logger, "#getDataBalance --- Found internal product for UPCC service "
										+ service.getName() + " = " + (pe != null ? pe.getCode() : null));

								if (pe != null) {

									addToList = pe.getVisibility() != null && pe.getVisibility().equals(1);
									if (pe.getBalanceDisplayOption() != null && pe.getBalanceDisplayOption()
											.equals(DataBalanceDisplayOption.CONSUMED_VALUE.ordinal())) {
										balance.setDisplayOption(DataBalanceDisplayOption.CONSUMED_VALUE);
									} else {
										balance.setDisplayOption(DataBalanceDisplayOption.AVAILABLE_VALUE);
									}

									balance.setCode(pe.getCode());
									balance.setDashboardVisible(pe.getDashboardVisibility() != null
											&& pe.getDashboardVisibility().equals(1));

									if (StringUtils.hasText(pe.getExtCode())) {
										if (langCode.equals(AppDefaultValues.LANGUAGE_ENGLISH)) {
											balance.setName(pe.getNameEN());
											if (StringUtils.hasText(pe.getShortNameEN())) {

												String shortNameEn = pe.getNameEN();

												// if(shortNameEn.contains("UnlimitF")
												// ||
												// shortNameEn.contains("UnlimitM")
												// ||
												// shortNameEn.contains("UnlimitFM")||
												// shortNameEn.contains("UnlimitSM")){
												if (shortNameEn.contains("Unlimit")) {
													shortNameEn = "Unlimited";
												}

												balance.setDisplayNameEN(shortNameEn);
												balance.setDisplayNameVI(pe.getNameVI());
											} else {

												String nameEn = pe.getNameEN();
												if (nameEn.contains("Unlimit")) {
													nameEn = "Unlimited";
												}
												balance.setDisplayNameEN(nameEn);
												balance.setDisplayNameVI(pe.getNameVI());
											}
										} else {
											balance.setName(pe.getNameVI());
											if (StringUtils.hasText(pe.getShortNameVI())) {

												String shortNameVi = pe.getNameVI();
												// if(shortNameVi.contains("UnlimitF")
												// ||
												// shortNameVi.contains("UnlimitM")
												// ||
												// shortNameVi.contains("UnlimitFM")||
												// shortNameVi.contains("UnlimitSM")){
												if (shortNameVi.contains("Unlimit")) {
													shortNameVi = "Dữ liệu không giới hạn";
												}
												balance.setDisplayNameVI(shortNameVi);
												balance.setDisplayNameEN(pe.getNameEN());
											} else {
												String nameVi = pe.getNameVI();
												// if(nameVi.contains("UnlimitF")
												// ||
												// nameVi.contains("UnlimitM")
												// ||
												// nameVi.contains("UnlimitFM")||
												// nameVi.contains("UnlimitSM")){
												if (nameVi.contains("Unlimit")) {
													nameVi = "Dữ liệu không giới hạn";
												}
												balance.setDisplayNameVI(nameVi);
												balance.setDisplayNameEN(pe.getNameEN());
											}
										}
										balance.setServiceName(pe.getExtProductName());
									}
								}
							} catch (Exception e) {
								logger.error("#getDataBalance --- could not get internal_product_code for "
										+ service.getName(), e);
							}

							for (UPCCSubscriberQuota quota : quotaList) {
								// service package name is associated with quota
								// service name

								if (quota.getServiceName().equals(service.getName())) {
									// if(service.getName().contains("UnlimitF")
									// || service.getName().contains("UnlimitM")
									// ||
									// service.getName().contains("UnlimitFM")||
									// service.getName().contains("UnlimitSM")){
									if (service.getName().contains("Unlimit")) {
										balance.setRemainingValue(0);
										balance.setConsumedValue(0);
									} else {
										balance.setRemainingValue(AppUtils.toLong(quota.getBalance()));
										balance.setConsumedValue(AppUtils.toLong(quota.getConsumption()));
									}
									balance.setTotalValue(AppUtils.toLong(quota.getValue()));

									boolean counted = true;
									BalanceNameMappingEntity balanceMap = this.balanceMappings.get(service.getName());
									// TODO exclude/include balance from
									// calculation -- requested by Trung, Feb 07
									// 2018
									if (balanceMap != null && balanceMap.getCountedFlag() != null
											&& !balanceMap.getCountedFlag().equals(1)) {
										counted = false;
									}

									if (counted) {
										if (balance.getDisplayOption()
												.equals(DataBalanceDisplayOption.AVAILABLE_VALUE)) {
											totalValue = totalValue + balance.getTotalValue();
											/// availableValue = availableValue
											/// + balance.getRemainingValue();
										}

										consumedValue = consumedValue + balance.getConsumedValue();
									}
								}
							}

							if (balance.getName().contains("Unlimit")) {

								balance.setConsumedValueAsString(UnitConverter.bytes2String(0));
								balance.setRemainingValueAsString(UnitConverter.bytes2String(0));
							}
							/*
							 * else if( balance.getName().contains("UnlimitM"))
							 * { balance.setConsumedValueAsString(UnitConverter.
							 * bytes2String(0));
							 * balance.setRemainingValueAsString(UnitConverter.
							 * bytes2String(0)); } else if(
							 * balance.getName().contains("UnlimitFM")) {
							 * balance.setConsumedValueAsString(UnitConverter.
							 * bytes2String(0));
							 * balance.setRemainingValueAsString(UnitConverter.
							 * bytes2String(0)); } else if(
							 * balance.getName().contains("UnlimitSM")) {
							 * balance.setConsumedValueAsString(UnitConverter.
							 * bytes2String(0));
							 * balance.setRemainingValueAsString(UnitConverter.
							 * bytes2String(0)); }
							 */
							else {
								balance.setConsumedValueAsString(
										UnitConverter.bytes2String(balance.getConsumedValue()));
								balance.setRemainingValueAsString(
										UnitConverter.bytes2String(balance.getRemainingValue()));
							}

							if (!balance.getName().equalsIgnoreCase("Defaulte_FUP")) {
								if (addToList)
									result.add(balance);
							}

						} // end if endDate.getTime() >=
							// System.currentTimeMillis()
					}
				}
			}

			// changes as per recomnded by Toung 01/06/2018

			for (int i = 0; i < result.size(); i++) {

				if ((result.get(i).getDisplayNameEN().equalsIgnoreCase("Unlimited"))) {

					result.get(i).setRemainingValueAsString(UnitConverter.bytes2String(0));
					// do nothing
					// ////System.out.println(" "+i+" value is
					// "+result.get(i).getDisplayNameEN() +"
					// "+result.get(i).getRemainingValue());
				} else if (result.get(i).getDisplayNameEN().equalsIgnoreCase("facebook")) {
					// do nothing
					result.get(i).setRemainingValueAsString(UnitConverter.bytes2String(0));
				} else {
					availableValue = availableValue + result.get(i).getRemainingValue();
				}
				// ////System.out.println(" final value is "+availableValue);

				// ////System.out.println(" "+i+" value is "+result.size());

			}
			Collections.sort(result, DataBalance.RemainingValueDescComparator);
			Collections.sort(result, new Comparator<DataBalance>() {
				@Override
				public int compare(DataBalance o1, DataBalance o2) {
					// TODO Auto-generated method stub
					return o2.getEndDate().compareTo(o1.getEndDate());
				}
			});

		} catch (Exception e) {
			logger.error(
					String.format("#getDataBalance -- error retrieving data balance from UPCC >> subscriber_id= %s",
							subscriberId),
					e);

		} finally {
			if (adapterPoolEnabled && adapter != null) {
				upccAdapterPool.returnObject(adapter);
			}
		}

		MyDataBalance myDataBalance = new MyDataBalance(DefaultBalanceName.Data.name(), totalValue, consumedValue,
				availableValue, result);
		return myDataBalance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#
	 * getCurrentBalance(java.lang.String)
	 */
	@Override
	public CurrentBalance getCurrentBalance(String subscriberId, String langCode) {
		subscriberId = AppUtils.prependCountryCodeToMsisdn(subscriberId,
				applicationConfigurationService.getDefaultCountryCode());

		if (isNewStackSubscriber(subscriberId)) {
			CurrentBalance currentBalance = tibcoServiceProvider.getCurrentBalance(subscriberId, langCode);
			if (currentBalance != null) {
				currentBalance.setDataBalance(getDataBalance(subscriberId, langCode));
			}

			return currentBalance;
		}

		LoggingUtil.debug(logger, String.format(
				"#getCurrentBalance -- retrieving balance information from back-end (subscriber= %s)", subscriberId));

		List<BalanceEntity> balanceList = getSubscriberBalancesFromRtbs(subscriberId);

		Balance coreBalance = extractCoreBalance(balanceList);
		MyVoiceBalance voiceBalance = getVoiceBalance(balanceList);
		MySmsBalance smsBalance = getSmsBalance(balanceList);
		MyDataBalance dataBalance = getDataBalance(subscriberId, langCode);
		MyPromotionBalance promotionBalance = getPromotionBalance(subscriberId, langCode);

		CurrentBalance balance = new CurrentBalance(coreBalance, voiceBalance, smsBalance, dataBalance,
				promotionBalance);

		LoggingUtil.debug(logger,
				String.format("#getCurrentBalance -- got balance information from back-end (subscriber: %s)= ",
						subscriberId) + balance);

		return balance;
	}

	private String createImageURL(String imageName) {
		if (!StringUtils.hasText(imageName))
			return "";

		String imageSvr = applicationConfigurationService.get("imageserver.url", "").toString();
		String imageDir = applicationConfigurationService.get("imageserver.imgdir", "").toString();

		if (!imageDir.endsWith("/"))
			imageDir = imageDir + "/";

		return imageSvr + imageDir + imageName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#
	 * activateSubscription(java.lang.String, java.lang.String)
	 */
	@Override
	public BackEndAdapterResponse activatePackageSubscription(String subscriberId, String packageId,
			ClientAppId clientAppId) {

		VASManAdapter adapter = getVASManAdapter();
		BackEndAdapterResponse response = adapter.sendRequest(new VASManProvisioningRequest(
				AppUtils.prependCountryCodeToMsisdn(subscriberId,
						applicationConfigurationService.getDefaultCountryCode()),
				packageId, VASManAdapter.ACTIVATE_CMD));

		boolean successful = response != null && response.getStatus().equals(RequestStatus.SUCCESS);

		ProductEntity productEntity = productRepository
				.findOne(QProductEntity.productEntity.code.equalsIgnoreCase(packageId));
		createTransactionHistory(subscriberId, productEntity != null ? productEntity.getId() : null, packageId,
				successful ? TransactionStatus.SUCCESS.ordinal() : TransactionStatus.FAIL.ordinal(), clientAppId);

		// insert or update data into product_subscription table
		if (successful) {
			try {
				ProductSubscriptionEntity pse = productSubscriptionRepository
						.findOne(QProductSubscriptionEntity.productSubscriptionEntity.product().code.eq(packageId)
								.and(QProductSubscriptionEntity.productSubscriptionEntity.subscriber().msisdn
										.eq(subscriberId)));

				if (pse == null) {
					SubscriberEntity subscriber = this.subscriberRepository
							.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(subscriberId));
					pse = new ProductSubscriptionEntity();
					pse.setProduct(productEntity);
					pse.setSubscriber(subscriber);
				}
				pse.setStartDate(new Date());
				pse.setStatus(SubscriptionStatus.ACTIVE.ordinal());
				productSubscriptionRepository.save(pse);
			} catch (Exception e) {
				logger.error(
						"#activatePackageSubscription --- error inserting/updating data into product_subscription table!",
						e);
			}
		}

		if (adapterPoolEnabled && adapter != null) {
			vasManAdapterPool.returnObject(adapter);
		}

		return response;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#
	 * cancelSubscription(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean cancelPackageSubscription(String subscriberId, String packageId) {

		VASManAdapter adapter = getVASManAdapter();
		BackEndAdapterResponse response = adapter.sendRequest(new VASManProvisioningRequest(
				AppUtils.prependCountryCodeToMsisdn(subscriberId,
						applicationConfigurationService.getDefaultCountryCode()),
				packageId, VASManAdapter.DEACTIVATE_CMD));

		boolean successful = (response != null && response.getStatus().equals(RequestStatus.SUCCESS)) ? true : false;

		// insert or update data into product_subscription table
		if (successful) {
			try {
				ProductSubscriptionEntity pse = productSubscriptionRepository
						.findOne(QProductSubscriptionEntity.productSubscriptionEntity.product().code.eq(packageId)
								.and(QProductSubscriptionEntity.productSubscriptionEntity.subscriber().msisdn
										.eq(subscriberId)));

				if (pse != null) {
					pse.setEndDate(new Date());
					pse.setUnregisterDate(new Date());
					pse.setStatus(SubscriptionStatus.INACTIVE.ordinal());
					productSubscriptionRepository.save(pse);
				}
			} catch (Exception e) {
				logger.error(
						"#cancelPackageSubscription --- error inserting/updating data into product_subscription table!",
						e);
			}
		}

		if (adapterPoolEnabled && adapter != null) {
			vasManAdapterPool.returnObject(adapter);
		}

		return successful;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#sendMail(java.
	 * lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void sendMail(String from, String subject, String content) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public SubscriptionStatus getPackageSubscriptionStatus(String subscriberId, String packageId) {

		SubscriptionStatus status = SubscriptionStatus.INACTIVE;

		VASManAdapter adapter = getVASManAdapter();
		BackEndAdapterResponse response = adapter
				.sendRequest(new VASManSubscriptionQueryRequest(AppUtils.prependCountryCodeToMsisdn(subscriberId,
						applicationConfigurationService.getDefaultCountryCode()), packageId));

		if (response.getStatus().equals(RequestStatus.SUCCESS) && response.getResult() != null) {
			List<VasProductDetail> details = (List<VasProductDetail>) response.getResult();
			if (details != null && !details.isEmpty()) {
				VasProductDetail vpd = details.get(0);
				if (vpd.getBarringStatus() != null && vpd.getBarringStatus().equals(1)) {
					status = SubscriptionStatus.ACTIVE;
				}
			}
		}

		if (adapterPoolEnabled && adapter != null) {
			vasManAdapterPool.returnObject(adapter);
		}

		return status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#
	 * getSubscribedPackages(java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PackageSubscription> getSubscribedPackages(String subscriberId, String packageId, String langCode) {

		subscriberId = AppUtils.prependCountryCodeToMsisdn(subscriberId,
				applicationConfigurationService.getDefaultCountryCode());
		if (!StringUtils.hasText(langCode))
			langCode = applicationConfigurationService.getDefaultLanguageCode();

		LoggingUtil.debug(logger, "#getSubscribedPackages --- getting subcription list from VASMan, msisdn= "
				+ subscriberId + ", lang_code= " + langCode);

		List<PackageSubscription> result = new ArrayList<>();

		VASManAdapter adapter = getVASManAdapter();
		
		//###########################################################
		long startTime= System.currentTimeMillis();
		logger.debug("fetching subscribing  from vasman start");
		
		BackEndAdapterResponse response = adapter
				.sendRequest(new VASManSubscriptionQueryRequest(subscriberId, packageId));
		
		//###########################################################
		long endTime= System.currentTimeMillis();
		logger.debug( "execution time in fetching  from vasman start "+(endTime-startTime));
		
		
		if (response.getStatus().equals(RequestStatus.SUCCESS) && response.getResult() != null) {
			List<VasProductDetail> details = (List<VasProductDetail>) response.getResult();

			if (details != null) {
				long ed = 0;
				for (VasProductDetail vpd : details) {
					XMLGregorianCalendar startDate = vpd.getRegisterDate();
					XMLGregorianCalendar endDate = vpd.getExpirationDate();

					LoggingUtil.debug(logger,
							"#getSubscribedPackages -- code= " + vpd.getProductId() + ", exp date= " + endDate);
					boolean addToList = false;
					if (endDate == null) {
						addToList = true;
					} else {
						ed = endDate.toGregorianCalendar().getTimeInMillis();
						if (ed >= System.currentTimeMillis())
							addToList = true;
					}
					if (addToList) {
						PackageSubscription subscription = new PackageSubscription();
						if (endDate != null) {
							subscription.setEndDate(endDate.toGregorianCalendar().getTime());
							subscription.setEndDateAsString(AppUtils.dateToString(subscription.getEndDate(),
									AppDefaultValues.DATE_TIME_FORMAT));
							subscription.setExpDate(endDate.toGregorianCalendar().getTime());
							subscription.setExpDateAsString(AppUtils.dateToString(subscription.getEndDate(),
									AppDefaultValues.DATE_TIME_FORMAT));
						}

						subscription.setStartDate(startDate.toGregorianCalendar().getTime());
						subscription.setStartDateAsString(
								AppUtils.dateToString(subscription.getStartDate(), AppDefaultValues.DATE_TIME_FORMAT));

						subscription.setStatus(vpd.getBarringStatus() != null && vpd.getBarringStatus().equals(1)
								? SubscriptionStatus.ACTIVE : SubscriptionStatus.INACTIVE);

						Product product = fromProductEntity(productRepository.findOne(
								QProductEntity.productEntity.code.equalsIgnoreCase(vpd.getProductId().toString())),
								langCode);

						if (product == null) {
							product = new Product();
							product.setCode(vpd.getProductId().toString());
							product.setAlias(vpd.getAlias().getValue());
							product.setName(vpd.getTitle().getValue());
						}

						subscription.setProduct(product);
						result.add(subscription);
					}
				}
			}
		}

		LoggingUtil.debug(logger, "#getSubscribedPackages --- subcription list from VASMan (msisdn= " + subscriberId
				+ ", lang_code= " + langCode + ") >> " + result);

		if (adapterPoolEnabled && adapter != null) {
			vasManAdapterPool.returnObject(adapter);
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#
	 * getPackageSubscriptionDetails(java.lang.String, java.lang.String)
	 */
	@Override
	public PackageSubscription getPackageSubscriptionDetails(String subscriberId, String packageId) {

		String langCode = applicationConfigurationService.getDefaultLanguageCode(); // AppDefaultValues.LANGUAGE_VIETNAMESE;
		SubscriberEntity subscriber = this.subscriberRepository
				.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(subscriberId));
		if (subscriber.getLanguageCode() != null) {
			langCode = subscriber.getLanguageCode();
		}

		List<PackageSubscription> list = getSubscribedPackages(subscriberId, packageId, langCode);

		return list != null && !list.isEmpty() ? list.get(0) : null;
	}

	private Map<String, String> metaDataAsMap(Set<?> metadata) {

		Map<String, String> map = new HashMap<>();
		if (metadata != null) {
			Iterator<?> it = metadata.iterator();
			while (it.hasNext()) {
				MetaDataEntity mde = (MetaDataEntity) it.next();
				if (mde.getValue() != null)
					map.put(mde.getName(), mde.getValue());
			}
		}
		return map;
	}

	private Product fromProductEntity(ProductEntity source, String langCode) {
		if (source == null)
			return null;

		Product product = new Product();
		product.setId(source.getId());
		product.setCode(source.getCode());
		product.setStatus(source.getStatus() != null ? DataStatus.valueOf(source.getStatus()) : DataStatus.ACTIVE);
		product.setPrice(source.getPrice() != null ? source.getPrice().doubleValue() : 0);

		if (langCode.equalsIgnoreCase(AppDefaultValues.LANGUAGE_ENGLISH)) {
			product.setName(source.getNameEN());
			product.setDescription(source.getDescriptionEN());
			product.setDetails(source.getDetailsEN());
			product.setHowToRegister(source.getHowToRegEN());
			product.setHowToUnregister(source.getHowToUnregEN());

		} else if (langCode.equalsIgnoreCase(AppDefaultValues.LANGUAGE_VIETNAMESE)) {
			product.setName(source.getNameVI());
			product.setDescription(source.getDescriptionVI());
			product.setDetails(source.getDetailsVI());
			product.setHowToRegister(source.getHowToRegVI());
			product.setHowToUnregister(source.getHowToUnregVI());
		}

		if (StringUtils.hasText(source.getExtProductName())) {
			product.setAlias(source.getExtProductName());
		} else {
			product.setAlias(source.getCode());
		}

		Map<String, String> metadata = metaDataAsMap(source.getMetadata());

		product.setMetadata(metadata);

		product.setValidFromDate(source.getValidFromDate());
		product.setValidToDate(source.getValidToDate());

		String image = "", banner = "";
		ProductGroupEntity group = source.getProductGroup();
		if (group != null) {
			product.setProductGroupId(group.getId());

			if (langCode.equalsIgnoreCase(AppDefaultValues.LANGUAGE_ENGLISH)) {
				product.setProductGroupName(group.getNameEN());

			} else if (langCode.equalsIgnoreCase(AppDefaultValues.LANGUAGE_VIETNAMESE)) {
				product.setProductGroupName(group.getNameVI());
			}

			if (group.getCategory() != null) {
				product.setCategoryId(group.getCategory().getId());
				product.setCategoryCode(group.getCategory().getCode());
			}
		}

		product.setSmallIcon(metadata.get(DefaultProductMetadata.ICON_SMALL.name()));
		product.setMediumIcon(metadata.get(DefaultProductMetadata.ICON_MEDIUM.name()));
		product.setLargeIcon(metadata.get(DefaultProductMetadata.ICON_LARGE.name()));
		product.setXlargeIcon(metadata.get(DefaultProductMetadata.ICON_XLARGE.name()));

		if (StringUtils.hasText(source.getDefaultImage())) {
			image = createImageURL(source.getDefaultImage());
		} else {
			if (group != null)
				image = createImageURL(group.getDefaultImage());
		}

		product.setDefaultImage(image);
		product.setSmallImage(image);
		product.setMediumImage(image);
		product.setLargeImage(image);
		product.setXlargeImage(image);

		if (StringUtils.hasText(source.getDefaultBanner())) {
			banner = createImageURL(source.getDefaultBanner());
		} else {
			if (group != null)
				banner = createImageURL(group.getDefaultBanner());
		}

		product.setXlargeImage(banner);
		product.setDefaultBanner(banner);

		if (metadata.get(DefaultProductMetadata.QUOTA.name()) != null) {
			product.setQuota(metadata.get(DefaultProductMetadata.QUOTA.name()).toString());
		}

		return product;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#getCallHistory(
	 * java.lang.String, java.util.Date, java.util.Date)
	 */
	@Override
	public List<CallRecord> getCallHistory(String subscriberId, Date startDate, Date endDate) {

		subscriberId = AppUtils.prependCountryCodeToMsisdn(subscriberId,
				applicationConfigurationService.getDefaultCountryCode());
		if (isNewStackSubscriber(subscriberId)) {
			return tibcoServiceProvider.getCallHistory(subscriberId, startDate, endDate);
		}

		String payload = String.format("[subscriber_id= %s, start_date= %s, end_date= %s]", subscriberId,
				AppUtils.dateToString(startDate, AppDefaultValues.DATE_FORMAT),
				AppUtils.dateToString(endDate, AppDefaultValues.DATE_FORMAT));

		List<CallRecord> result = new ArrayList<>();

		RTBSAdapter adapter = getRTBSAdapter();
		try {
			RTBSProfileQueryRequest request = new RTBSProfileQueryRequest();
			request.setSubscriberId(subscriberId);
			request.setWithHistory(true);
			request.setStartDate(startDate);
			request.setEndDate(endDate);
			request.setInformationToRetrieve(RTBSSubscriberInfoValues.ALL_SERVICES.getValue());

			BackEndAdapterResponse response = adapter.sendRequest(request);
			LoggingUtil.debug(logger, "#getCallHistory -- retrieving call history from RTBS" + payload
					+ ", receiving response= " + response);

			if (response.isSuccessful()) {
				SubscriberRetrieve subscriber = (SubscriberRetrieve) response.getResult();
				ArrayOfCallHistory arrCallHistory = subscriber.getCallHistories();

				if (arrCallHistory != null && arrCallHistory.getCallHistory() != null) {

					String countryCode = applicationConfigurationService.getDefaultCountryCode();
					String dateFormat = applicationConfigurationService
							.get("dateformat.long", AppDefaultValues.DATE_TIME_FORMAT).toString();
					for (CallHistory ch : arrCallHistory.getCallHistory()) {
						CallRecord record = new CallRecord();

						// replace country code 84 with "0" as requested on
						// 2017-05-07
						String calledNumber = ch.getCalledNumber();
						record.setCalledNumber(AppUtils.replaceCountryCodeFromMsisdn(calledNumber, countryCode, "0"));

						/*
						 * try {
						 * record.setCallType(CallType.valueOf(ch.getCallType())
						 * ); } catch (Exception e) { logger.
						 * warn("#getCallHistory -- un-resolvable call_type= " +
						 * ch.getCallType()); }
						 */

						record.setDirection(
								ch.getCalledNumber() != null ? CallDirection.OUTGOING : CallDirection.INCOMING);
						record.setDuration(ch.getCallDuration());

						if (ch.getEndCallDateTime() != null) {
							record.setEndTime(ch.getEndCallDateTime().toGregorianCalendar().getTime());
						}
						if (ch.getStartCallDateTime() != null) {
							record.setStartTime(ch.getStartCallDateTime().toGregorianCalendar().getTime());
						}

						record.setEndTimeAsString(AppUtils.dateToString(record.getEndTime(), dateFormat));
						record.setStartTimeAsString(AppUtils.dateToString(record.getStartTime(), dateFormat));

						result.add(record);
					}
				} else {
					LoggingUtil.debug(logger,
							String.format("#getCallHistory -- no call history found for %s", subscriberId));
				}
			}

			Collections.sort(result, new CallRecord.CallRecordTimeDescComparator());
		} catch (Exception e) {
			logger.error("#getCallHistory -- error retrieving call history from RTBS" + payload, e);

		} finally {

			if (adapterPoolEnabled && adapter != null) {
				rtbsAdapterPool.returnObject(adapter);
			}
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#getSmsHistory(
	 * java.lang.String, java.util.Date, java.util.Date)
	 */
	@Override
	public List<SmsRecord> getSmsHistory(String subscriberId, Date startDate, Date endDate) {

		subscriberId = AppUtils.prependCountryCodeToMsisdn(subscriberId,
				applicationConfigurationService.getDefaultCountryCode());

		if (isNewStackSubscriber(subscriberId)) {
			return tibcoServiceProvider.getSmsHistory(subscriberId, startDate, endDate);
		}

		List<SmsRecord> result = new ArrayList<>();

		String payload = String.format("[subscriber_id= %s, start_date= %s, end_date= %s]", subscriberId,
				AppUtils.dateToString(startDate, AppDefaultValues.DATE_FORMAT),
				AppUtils.dateToString(endDate, AppDefaultValues.DATE_FORMAT));

		RTBSAdapter adapter = getRTBSAdapter();
		try {
			RTBSProfileQueryRequest request = new RTBSProfileQueryRequest();
			request.setSubscriberId(subscriberId);
			request.setWithHistory(true);
			request.setStartDate(startDate);
			request.setEndDate(endDate);
			request.setInformationToRetrieve(RTBSSubscriberInfoValues.ALL_SERVICES.getValue());

			//###########################################################
			long startTime= System.currentTimeMillis();
			logger.debug( "execution time in fetching sms history from RTBS ");
		
			
			BackEndAdapterResponse response = adapter.sendRequest(request);
			
			//###########################################################

			LoggingUtil.debug(logger, "#getSmsHistory -- retrieving SMS history from RTBS" + payload
					+ ", receiving response= " + response);

			// record.setEndTimeAsString(AppUtils.dateToString(record.getEndTime(),
			// AppDefaultValues.DATE_TIME_FORMAT));
			if (response.isSuccessful()) {
				SubscriberRetrieve subscriber = (SubscriberRetrieve) response.getResult();
				List<DiameterOCSHistory> history = subscriber.getDiameterOCSHistoryRecords();
				if (history != null && history.size() > 0) {
					String countryCode = applicationConfigurationService.getDefaultCountryCode();
					String dateFormat = applicationConfigurationService
							.get("dateformat.long", AppDefaultValues.DATE_TIME_FORMAT).toString();

					for (DiameterOCSHistory sh : history) {
						if (sh.getActivityType() != null && sh.getActivityType().equalsIgnoreCase("directDebitUnit")
								&& sh.getUnitTypeName() != null && sh.getUnitTypeName().equalsIgnoreCase("SMS")) {

							SmsRecord smsrec = new SmsRecord();

							// replace country code 84 with "0" as requested on
							// 2017-05-07
							String destNumber = sh.getOCSComment();
							smsrec.setDestinationNumber(
									AppUtils.replaceCountryCodeFromMsisdn(destNumber, countryCode, "0"));

							smsrec.setDirection(CallDirection.OUTGOING);
							smsrec.setTimeStamp(sh.getStartCallDateTime().toGregorianCalendar().getTime());
							smsrec.setTimeStampAsString(AppUtils.dateToString(smsrec.getTimeStamp(), dateFormat));

							result.add(smsrec);
						}
					}
				} else {
					LoggingUtil.info(logger, "#getSmsHistory -- no SMS history found for MSISDN= " + subscriberId);
				}
			}

			Collections.sort(result, new SmsRecord.SmsRecordTimeDescComparator());
		} catch (Exception e) {
			logger.error("#getCallHistory -- error retrieving call history from RTBS" + payload, e);

		} finally {

			if (adapterPoolEnabled && adapter != null) {
				rtbsAdapterPool.returnObject(adapter);
			}
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#getTopUpHistory
	 * (java.lang.String, java.util.Date, java.util.Date)
	 */
	@Override
	public List<TopUpHistory> getTopUpHistory(String subscriberId, Date startDate, Date endDate) {

		subscriberId = AppUtils.prependCountryCodeToMsisdn(subscriberId,
				applicationConfigurationService.getDefaultCountryCode());

		if (isNewStackSubscriber(subscriberId)) {
			return tibcoServiceProvider.getTopUpHistory(subscriberId, startDate, endDate);
		}

		List<TopUpHistory> result = new ArrayList<>();

		String payload = String.format("[subscriber_id= %s, start_date= %s, end_date= %s]", subscriberId,
				AppUtils.dateToString(startDate, AppDefaultValues.DATE_FORMAT),
				AppUtils.dateToString(endDate, AppDefaultValues.DATE_FORMAT));

		RTBSAdapter adapter = getRTBSAdapter();
		try {
			RTBSProfileQueryRequest request = new RTBSProfileQueryRequest();
			request.setSubscriberId(subscriberId);
			request.setWithHistory(true);
			request.setStartDate(startDate);
			request.setEndDate(endDate);
			request.setInformationToRetrieve(RTBSSubscriberInfoValues.ALL_SERVICES.getValue());

			BackEndAdapterResponse response = adapter.sendRequest(request);
			LoggingUtil.debug(logger, "#getTopUpHistory -- retrieving TopUp history from RTBS" + payload
					+ ", receiving response= " + response);

			if (response.isSuccessful()) {
				SubscriberRetrieve subscriber = (SubscriberRetrieve) response.getResult();
				ArrayOfRechargeHistory history = subscriber.getRechargeHistories();

				if (history != null && history.getRechargeHistory() != null) {

					for (RechargeHistory rh : history.getRechargeHistory()) {
						TopUpHistory tuh = new TopUpHistory();
						tuh.setMsisdn(subscriberId);
						if (rh.getRechargeDate() != null) {
							tuh.setTimeStamp(rh.getRechargeDate().toGregorianCalendar().getTime());
							tuh.setTimeStampAsString(
									AppUtils.dateToString(tuh.getTimeStamp(), AppDefaultValues.DATE_TIME_FORMAT));
						}
						tuh.setStatus(TransactionStatus.SUCCESS);
						tuh.setVoucherCode(rh.getCardNumber());
						tuh.setAmount(rh.getFaceValue());

						String originator = rh.getRechargeOriginator();
						String comment = rh.getComment();
						if (comment == null)
							comment = "";

						LoggingUtil.debug(logger, "getTopUpHistory --- " + subscriberId + ", originator= " + originator
								+ ", comment= " + comment + ", time= " + rh.getRechargeDate());

						if (StringUtils.hasText(originator)) {
							if (originator.equalsIgnoreCase("CCWS_non_voucher")) {

								if (comment.toUpperCase().startsWith("VMS")) {
									// a hack to show correct top up history
									// originator if voucher top up is done
									// through Tibco
									if (comment.toUpperCase().startsWith("VMS ETOPUP_")
											|| comment.toUpperCase().startsWith("VMS ET_")) {
										originator = originator + "_VMS_ETOPUP";
									} else {
										originator = originator + "_VMS";
									}
								}
							}
							try {
								TopUpTypeEntity type = topUpTypeRepository
										.findOne(QTopUpTypeEntity.topUpTypeEntity.name.equalsIgnoreCase(originator));
								if (type != null) {
									tuh.setTypeNameEN(type.getDisplayNameEN());
									tuh.setTypeNameVN(type.getDisplayNameVI());
								}
							} catch (Exception e) {
								logger.error("#getTopUpHistory -- error looking up top_up_type to DB for originator= "
										+ originator + ": " + e.getMessage());
							}

							if (!StringUtils.hasText(tuh.getTypeNameEN())) {
								tuh.setTypeNameEN(TopUpType.SCRATCH_CARD.displayName());
							}
							if (!StringUtils.hasText(tuh.getTypeNameVN())) {
								tuh.setTypeNameVN(TopUpType.SCRATCH_CARD.displayName());
							}
						}
						result.add(tuh);
					}
				} else {
					LoggingUtil.debug(logger,
							String.format("#getTopUpHistory -- no top up history found for %s", subscriberId));
				}
			}

		} catch (Exception e) {
			logger.error("#getCallHistory -- error retrieving call history from RTBS" + payload, e);

		} finally {

			if (adapterPoolEnabled && adapter != null) {
				rtbsAdapterPool.returnObject(adapter);
			}
		}

		Collections.sort(result, new TopUpHistory.TopUpHistoryTimestampDescendingComparator());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#
	 * getDailyCallHistory(java.lang.String)
	 */
	@Override
	public List<CallRecord> getDailyCallHistory(String subscriberId) {
		Calendar start = Calendar.getInstance();
		start.set(Calendar.HOUR, 0);
		start.set(Calendar.MINUTE, 0);
		start.set(Calendar.MILLISECOND, 0);

		return getCallHistory(subscriberId, start.getTime(), new Date());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#
	 * getWeeklyCallHistory(java.lang.String)
	 */
	@Override
	public List<CallRecord> getWeeklyCallHistory(String subscriberId) {
		Calendar start = Calendar.getInstance();
		start.add(Calendar.DATE, -7);

		return getCallHistory(subscriberId, start.getTime(), new Date());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#
	 * getMonthlyCallHistory(java.lang.String)
	 */
	@Override
	public List<CallRecord> getMonthlyCallHistory(String subscriberId) {
		Calendar start = Calendar.getInstance();
		start.add(Calendar.MONTH, -1);

		return getCallHistory(subscriberId, start.getTime(), new Date());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#
	 * getYearhlyCallHistory(java.lang.String)
	 */
	@Override
	public List<CallRecord> getYearlyCallHistory(String subscriberId) {
		Calendar start = Calendar.getInstance();
		start.add(Calendar.YEAR, -1);

		return getCallHistory(subscriberId, start.getTime(), new Date());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#
	 * getDailySmsHistory(java.lang.String)
	 */
	@Override
	public List<SmsRecord> getDailySmsHistory(String subscriberId) {
		Calendar start = Calendar.getInstance();
		start.set(Calendar.HOUR, 0);
		start.set(Calendar.MINUTE, 0);
		start.set(Calendar.MILLISECOND, 0);

		return getSmsHistory(subscriberId, start.getTime(), new Date());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#
	 * getWeeklySmsHistory(java.lang.String)
	 */
	@Override
	public List<SmsRecord> getWeeklySmsHistory(String subscriberId) {
		Calendar start = Calendar.getInstance();
		start.add(Calendar.DATE, -7);

		return getSmsHistory(subscriberId, start.getTime(), new Date());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#
	 * getMonthlySmsHistory(java.lang.String)
	 */
	@Override
	public List<SmsRecord> getMonthlySmsHistory(String subscriberId) {
		Calendar start = Calendar.getInstance();
		start.add(Calendar.MONTH, -1);

		return getSmsHistory(subscriberId, start.getTime(), new Date());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#
	 * getYearlySmsHistory(java.lang.String)
	 */
	@Override
	public List<SmsRecord> getYearlySmsHistory(String subscriberId) {
		Calendar start = Calendar.getInstance();
		start.add(Calendar.YEAR, -1);

		return getSmsHistory(subscriberId, start.getTime(), new Date());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#
	 * getDailyTopUpHistory(java.lang.String)
	 */
	@Override
	public List<TopUpHistory> getDailyTopUpHistory(String subscriberId) {
		Calendar start = Calendar.getInstance();
		start.set(Calendar.HOUR, 0);
		start.set(Calendar.MINUTE, 0);
		start.set(Calendar.MILLISECOND, 0);

		return getTopUpHistory(subscriberId, start.getTime(), new Date());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#
	 * getWeeklyTopUpHistory(java.lang.String)
	 */
	@Override
	public List<TopUpHistory> getWeeklyTopUpHistory(String subscriberId) {
		Calendar start = Calendar.getInstance();
		start.add(Calendar.DATE, -7);

		return getTopUpHistory(subscriberId, start.getTime(), new Date());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#
	 * getMonthlyTopUpHistory(java.lang.String)
	 */
	@Override
	public List<TopUpHistory> getMonthlyTopUpHistory(String subscriberId) {
		Calendar start = Calendar.getInstance();
		start.add(Calendar.MONTH, -1);

		return getTopUpHistory(subscriberId, start.getTime(), new Date());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#
	 * getYearlyTopUpHistory(java.lang.String)
	 */
	@Override
	public List<TopUpHistory> getYearlyTopUpHistory(String subscriberId) {
		Calendar start = Calendar.getInstance();
		start.add(Calendar.YEAR, -1);

		return getTopUpHistory(subscriberId, start.getTime(), new Date());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#
	 * getTopUpHistoryByRefTrxId(java.lang.String)
	 */
	@Override
	public TopUpHistory getInternalTopUpHistoryByRefTrxId(String refTrxId) {

		try {
			TopUpHistoryEntity entity = topUpHistoryRepository
					.findOne(QTopUpHistoryEntity.topUpHistoryEntity.refTrxId.eq(refTrxId));
			if (entity != null) {
				TopUpHistory history = new TopUpHistory();
				history.setAmount(entity.getAmount());
				history.setMsisdn(entity.getMsisdn());
				history.setRefTrxId(refTrxId);
				if (entity.getStatus() != null) {
					history.setStatus(TransactionStatus.fromInt(entity.getStatus()));
				}
				history.setTimeStamp(entity.getTimeStamp());
				history.setVoucherCode(entity.getVoucherCode());

				return history;
			}
		} catch (Exception e) {
			logger.error("#getTopUpHistoryByRefTrxId --- error retrieving topup history for ref_trx_id " + refTrxId, e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#
	 * getTopupHistoryBySessionId(java.lang.String)
	 */
	@Override
	public List<TopUpHistory> getTopupHistoryBySessionId(String sessionId, String referrer) {

		List<TopUpHistory> result = new ArrayList<>();

		try {
			BooleanExpression expr = QTopUpHistoryEntity.topUpHistoryEntity.sessionId.isNotNull()
					.and(QTopUpHistoryEntity.topUpHistoryEntity.sessionId.eq(sessionId));
			if (StringUtils.hasText(referrer)) {
				expr = expr.and(QTopUpHistoryEntity.topUpHistoryEntity.referrer.isNotNull()
						.and(QTopUpHistoryEntity.topUpHistoryEntity.referrer.equalsIgnoreCase(referrer)));
			}
			Iterable<TopUpHistoryEntity> list = topUpHistoryRepository.findAll(expr,
					QTopUpHistoryEntity.topUpHistoryEntity.lastModifiedTime.desc());

			if (list != null) {
				for (TopUpHistoryEntity entity : list) {
					TopUpHistory history = new TopUpHistory();
					history.setAmount(entity.getAmount());
					history.setMsisdn(entity.getMsisdn());
					history.setRefTrxId(entity.getRefTrxId());
					if (entity.getStatus() != null) {
						history.setStatus(TransactionStatus.fromInt(entity.getStatus()));
					}
					history.setTimeStamp(entity.getTimeStamp());
					history.setVoucherCode(entity.getVoucherCode());

					result.add(history);
				}
			}
		} catch (Exception e) {
			logger.error("#getTopupHistoryBySessionId --- error retrieving topup_history for session_id " + sessionId,
					e);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#
	 * getSubscriberInfoFromRadius(java.lang.String)
	 */
	@Override
	public BasicSubscriberInfo getSubscriberInfoFromRadius(String ipAddress) {

		RadiusQueryRequest request = new RadiusQueryRequest();
		request.setIpAddress(ipAddress);
		RadiusAdapter adapter = getRadiusAdapter();

		BasicSubscriberInfo bsi = null;
		try {
			adapter.init(getRadiusConnection());
		} catch (BackEndAdapterException e) {
			logger.error("#getSubscriberInfoFromRadius -- could not initiate connection to Radius!", e);
			return null;
		}

		BackEndAdapterResponse response = adapter.sendRequest(request);
		LoggingUtil.debug(logger, "#getSubscriberInfoFromRadius -- receiving response from Radius= " + response);

		if (response.isSuccessful() && response.getResult() != null) {
			bsi = (BasicSubscriberInfo) response.getResult();
		}

		adapter.shutdown();

		return bsi;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#isInHomeNetwork
	 * (java.lang.String)
	 */
	@Override
	public boolean isInHomeNetwork(String ipAddress) {
		return getSubscriberInfoFromRadius(ipAddress) != null;
	}

	private Integer createTransactionHistory(String subscriberId, Integer productId, String productCode, Integer status,
			ClientAppId clientAppId) {
		try {
			TransactionHistoryEntity trx = new TransactionHistoryEntity();
			trx.setPaymentMethod(null);
			trx.setProductId(productId);
			trx.setProductCode(productCode);
			trx.setStatus(status);
			trx.setSubscriber(subscriberRepository.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(subscriberId)));
			trx.setTrxDate(new Date());
			trx.setClientAppId(clientAppId != null ? clientAppId.name() : ClientAppId.MOBILE_APP.name());

			return transactionHistoryRepository.saveAndFlush(trx).getId();
		} catch (Exception e) {
			logger.error(String.format("#createTransactionHistory -- error creating transaction history "
					+ "(subscriber= %s, product= %s, trx_status= %d)", subscriberId, productId, status), e);
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#
	 * checkLoyaltyPoint(java.lang.String)
	 */
	@Override
	public int getLmsPoint(String msisdn) {

		CheckPointRequest request = new CheckPointRequest(
				AppUtils.prependCountryCodeToMsisdn(msisdn, applicationConfigurationService.getDefaultCountryCode()));
		BackEndAdapterResponse response = getLMSAdapter().sendRequest(request);

		return response.isSuccessful() ? (Integer) response.getResult() : 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#
	 * checkFattyPonts(java.lang.String)
	 */
	@Override
	public int getFattyPoint(String msisdn) {

		CheckPointRequest request = new CheckPointRequest(
				AppUtils.prependCountryCodeToMsisdn(msisdn, applicationConfigurationService.getDefaultCountryCode()));
		BackEndAdapterResponse response = getFattyAdapter().sendRequest(request);

		return response.isSuccessful() ? (Integer) response.getResult() : 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#
	 * redeemLoyaltyPoint(java.lang.String, java.lang.String, double)
	 */
	@Override
	public BackEndAdapterResponse redeemLmsPoint(String msisdn, String keyword, double point) {

		LoggingUtil.debug(logger,
				"#redeemLmsPoint --- receiving request from " + msisdn + ", keyword= " + keyword + ", point= " + point);
		int multiplier = 5;
		try {
			multiplier = Integer.parseInt(
					this.applicationConfigurationService.get("adapter.loyalty.pointmultiplier',", "5").toString());
		} catch (Exception e) {
		}
		RedeemPointRequest request = new RedeemPointRequest(
				AppUtils.prependCountryCodeToMsisdn(msisdn, applicationConfigurationService.getDefaultCountryCode()),
				keyword, (int) point * multiplier);
		return getLMSAdapter().sendRequest(request);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#
	 * redeemFattyPoint(java.lang.String, java.lang.String, double)
	 */
	@Override
	public BackEndAdapterResponse redeemFattyPoint(String msisdn, String keyword, int point, String description) {

		LoggingUtil.debug(logger, "#redeemFattyPoint --- receiving request from " + msisdn + ", keyword= " + keyword
				+ ", point= " + point);
		/*
		 * int multiplier = 5; try { multiplier = Integer.parseInt(
		 * this.applicationConfigurationService.get(
		 * "adapter.loyalty.pointmultiplier',", "5").toString()); } catch
		 * (Exception e) { }
		 */
		RedeemPointRequestFatty request = new RedeemPointRequestFatty(
				AppUtils.prependCountryCodeToMsisdn(msisdn, applicationConfigurationService.getDefaultCountryCode()),
				keyword, (int) point, description);
		return getFattyAdapter().sendRequest(request);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#
	 * getLoyaltyItemList()
	 */
	@Override
	public List<LmsItem> getLmsItemList() {

		List<LmsItem> result = new ArrayList<>();
		try {
			Iterable<LmsItemMappingsEntity> list = lmsItemMappingsRepository
					.findAll(QLmsItemMappingsEntity.lmsItemMappingsEntity.keyword.asc());
			if (list != null) {
				for (LmsItemMappingsEntity item : list) {
					LmsItem lri = new LmsItem(item.getKeyword(), item.getProductName(), item.getMonsterWeight());
					lri.setDisplayNameEN(item.getDisplayNameEN());
					lri.setDisplayNameVN(item.getDisplayNameVI());
					lri.setMonsterImage(createImageURL(item.getMonsterImage()));

					result.add(lri);
				}
			}
		} catch (Exception e) {
			logger.error("#getLoyaltyItemList --- error retrieving LMS items from DB!", e);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#getItem(java.
	 * lang.String)
	 */
	@Override
	public LmsItem getLmsRedeemableItem(String keyword) {

		try {
			LmsItemMappingsEntity item = lmsItemMappingsRepository
					.findOne(QLmsItemMappingsEntity.lmsItemMappingsEntity.keyword.equalsIgnoreCase(keyword));
			if (item != null) {
				LmsItem lri = new LmsItem(item.getKeyword(), item.getProductName(), item.getMonsterWeight());
				lri.setDisplayNameEN(item.getDisplayNameEN());
				lri.setDisplayNameVN(item.getDisplayNameVI());
				lri.setMonsterImage(createImageURL(lri.getMonsterImage()));

				return lri;
			}
		} catch (Exception e) {
			logger.error("#getLoyaltyRedeemableItem --- error getting LMS item detail for keyword " + keyword, e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#getKeywordList(
	 * )
	 */
	@Override
	public List<String> getLmsKeywordList() {

		List<String> result = new ArrayList<>();

		try {
			Iterable<LmsKeywordMappingsEntity> list = lmsKeywordMappingsRepository
					.findAll(QLmsKeywordMappingsEntity.lmsKeywordMappingsEntity.keyword.asc());
			if (list != null) {
				for (LmsKeywordMappingsEntity item : list) {
					result.add(item.getKeyword());
				}
			}
		} catch (Exception e) {
			logger.error("#getLoyaltyKeywordList --- error retrieving LMS keywords from DB!", e);
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#
	 * getLmsKeywordMappings()
	 */
	@Override
	public Map<String, Integer> getLmsKeywordMappings() {
		Map<String, Integer> maps = new Hashtable<>();
		try {
			Iterable<LmsKeywordMappingsEntity> list = lmsKeywordMappingsRepository
					.findAll(QLmsKeywordMappingsEntity.lmsKeywordMappingsEntity.keyword.asc());
			if (list != null) {
				for (LmsKeywordMappingsEntity item : list) {
					maps.put(item.getKeyword().toUpperCase(), item.getUnitAmount());
				}
			}
		} catch (Exception e) {
			logger.error("#getLmsKeywordMappings --- error retrieving LMS keyword mappings from DB!", e);
		}

		return maps;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#
	 * getFattyKeywordMappings()
	 */
	@Override
	public Map<String, Integer> getFattyKeywordMappings() {
		Map<String, Integer> maps = new Hashtable<>();
		try {
			Iterable<FattyItemMappingsEntity> list = fattyKeywordMappingsRepository
					.findAll(QFattyItemMappingsEntity.fattyItemMappingsEntity.keyword.asc());
			if (list != null) {
				for (FattyItemMappingsEntity item : list) {
					maps.put(item.getKeyword().toUpperCase(), item.getMonsterWeight());
				}
			}
		} catch (Exception e) {
			logger.error("#getFattyKeywordMappings --- error retrieving Fatty keyword mappings from DB!", e);
		}

		return maps;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#
	 * getGamifyMonsters(java.lang.String, java.lang.String)
	 */
	@Override
	public GamifyGetMonsterResponse getGamifyMonsters(String msisdn, String langCode) {

		GamifyGetMonstersRequest request = new GamifyGetMonstersRequest(langCode,
				AppUtils.prependCountryCodeToMsisdn(msisdn, applicationConfigurationService.getDefaultCountryCode()));

		BackEndAdapterResponse response = getGamifyAdapter().sendRequest(request);
		if (response.isSuccessful()) {

			GamifyGetMonsterResponse gamifyResponse = (GamifyGetMonsterResponse) response.getResult();
			return gamifyResponse;
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#
	 * gamifyRedeemByMonsters(com.gnv.vnm.selfcare.core.adapter.gamify.
	 * GamifyRedeemByMonsterRequest)
	 */
	@Override
	public BackEndAdapterResponse gamifyRedeemByMonsters(GamifyRedeemByMonsterRequest request) {
		request.setMsisdn(AppUtils.prependCountryCodeToMsisdn(request.getMsisdn(),
				applicationConfigurationService.getDefaultCountryCode()));
		return getGamifyAdapter().sendRequest(request);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#
	 * subscribeDataSharing(java.lang.String, java.lang.String, java.util.List)
	 */
	@Override
	public BackEndAdapterResponse registerDataSharing(String msisdn, String packageId, List<String> members) {

		List<String> targetNumbers = new ArrayList<>();
		for (String no : members) {
			targetNumbers.add(
					AppUtils.prependCountryCodeToMsisdn(no, applicationConfigurationService.getDefaultCountryCode()));
		}

		VASManAdapter adapter = getVASManAdapter();
		VASManDataSharingRequest request = new VASManDataSharingRequest(
				AppUtils.prependCountryCodeToMsisdn(msisdn, applicationConfigurationService.getDefaultCountryCode()),
				packageId, VASManAdapter.ACTIVATE_CMD, targetNumbers);
		BackEndAdapterResponse response = adapter.sendRequest(request);

		if (adapterPoolEnabled && adapter != null) {
			vasManAdapterPool.returnObject(adapter);
		}

		return response;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#
	 * deleteDataSharing(java.lang.String, java.lang.String)
	 */
	@Override
	public BackEndAdapterResponse deleteDataSharing(String msisdn, String packageId) {
		VASManAdapter adapter = getVASManAdapter();
		VASManDataSharingRequest request = new VASManDataSharingRequest(
				AppUtils.prependCountryCodeToMsisdn(msisdn, applicationConfigurationService.getDefaultCountryCode()),
				packageId, VASManAdapter.DEACTIVATE_CMD);

		BackEndAdapterResponse response = adapter.sendRequest(request);

		if (adapterPoolEnabled && adapter != null) {
			vasManAdapterPool.returnObject(adapter);
		}

		return response;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#
	 * getSelfPackageUnitPriceList()
	 */
	@Override
	public List<SelfPackagePriceMapping> getSelfPackagePriceMappings() {

		List<SelfPackagePriceMapping> result = new ArrayList<>();
		try {
			Iterable<SelfPackagePriceMappingEntity> list = selfPackagePriceMappingRepository
					.findAll(QSelfPackagePriceMappingEntity.selfPackagePriceMappingEntity.type.asc());
			if (list != null) {
				for (SelfPackagePriceMappingEntity spup : list) {
					result.add(new SelfPackagePriceMapping(spup.getType(), spup.getMinAmount(), spup.getMaxAmount(),
							spup.getPrice() != null ? spup.getPrice().doubleValue() : 0,
							spup.getNormalPrice() != null ? spup.getNormalPrice().doubleValue() : 0,
							spup.getCycle() != null ? spup.getCycle() : 0));
				}
			}
		} catch (Exception e) {
			logger.error("#getSelfPackageUnitPriceList --- error retrieving self pkg unit price list", e);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#
	 * getSelfPackageUnitPriceList(java.lang.String)
	 */
	@Override
	public List<SelfPackagePriceMapping> getSelfPackagePriceMappings(String type) {

		List<SelfPackagePriceMapping> result = new ArrayList<>();
		try {
			Iterable<SelfPackagePriceMappingEntity> list = selfPackagePriceMappingRepository.findAll(
					QSelfPackagePriceMappingEntity.selfPackagePriceMappingEntity.type.equalsIgnoreCase(type),
					QSelfPackagePriceMappingEntity.selfPackagePriceMappingEntity.type.asc());
			if (list != null) {
				for (SelfPackagePriceMappingEntity spup : list) {
					result.add(new SelfPackagePriceMapping(spup.getType(), spup.getMinAmount(), spup.getMaxAmount(),
							spup.getPrice() != null ? spup.getPrice().doubleValue() : 0,
							spup.getNormalPrice() != null ? spup.getNormalPrice().doubleValue() : 0,
							spup.getCycle() != null ? spup.getCycle() : 0));
				}
			}
		} catch (Exception e) {
			logger.error("#getSelfPackageUnitPriceList (string) --- error retrieving self pkg unit price list", e);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#
	 * getSelfPackagePriceMappings(java.lang.String, int)
	 */
	@Override
	public List<SelfPackagePriceMapping> getSelfPackagePriceMappings(String type, int cycle) {
		List<SelfPackagePriceMapping> result = new ArrayList<>();
		try {
			Iterable<SelfPackagePriceMappingEntity> list = selfPackagePriceMappingRepository.findAll(
					QSelfPackagePriceMappingEntity.selfPackagePriceMappingEntity.type.equalsIgnoreCase(type)
							.and(QSelfPackagePriceMappingEntity.selfPackagePriceMappingEntity.cycle.eq(cycle)),
					QSelfPackagePriceMappingEntity.selfPackagePriceMappingEntity.type.asc());
			if (list != null) {
				for (SelfPackagePriceMappingEntity spup : list) {
					result.add(new SelfPackagePriceMapping(spup.getType(), spup.getMinAmount(), spup.getMaxAmount(),
							spup.getPrice() != null ? spup.getPrice().doubleValue() : 0,
							spup.getNormalPrice() != null ? spup.getNormalPrice().doubleValue() : 0,
							spup.getCycle() != null ? spup.getCycle() : 0));
				}
			}
		} catch (Exception e) {
			logger.error("#getSelfPackageUnitPriceList (string) --- error retrieving self pkg unit price list", e);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#
	 * getSelfPackagePriceMappings(java.lang.String, int, int, int)
	 */
	@Override
	public List<SelfPackagePriceMapping> getSelfPackagePriceMappings(String type, int cycle, double amount) {

		List<SelfPackagePriceMapping> result = new ArrayList<>();
		try {
			Iterable<SelfPackagePriceMappingEntity> list = selfPackagePriceMappingRepository.findAll(
					QSelfPackagePriceMappingEntity.selfPackagePriceMappingEntity.type.equalsIgnoreCase(type)
							.and(QSelfPackagePriceMappingEntity.selfPackagePriceMappingEntity.cycle.eq(cycle))
							.and(Expressions.asNumber(amount)
									.goe(QSelfPackagePriceMappingEntity.selfPackagePriceMappingEntity.minAmount))
							.and(Expressions.asNumber(amount)
									.loe(QSelfPackagePriceMappingEntity.selfPackagePriceMappingEntity.maxAmount)),
					QSelfPackagePriceMappingEntity.selfPackagePriceMappingEntity.type.asc());
			if (list != null) {
				for (SelfPackagePriceMappingEntity spup : list) {
					double normalPrice = 0.0;

					if (type.equalsIgnoreCase(SelfPackageType.DATA.name())
							&& cycle == SelfPackageCycle.MONTHLY.ordinal()) {

						try {
							// Map<String, String> configs =
							// getSelfPackageCommonConfigs();
							// normal_price = amount/500 * field_normal_price
							// int divider =
							// Integer.parseInt(configs.get(SelfPackageConfigKey.DATA_MONTHLY_INCR_VALUE.name()));
							// normalPrice = amount/divider *
							// (spup.getNormalPrice() != null ?
							// spup.getNormalPrice().doubleValue() : 0);

							// changed to normal_price = data_size *
							// field_normal_price --> using flat price (512) as
							// of Feb 01, 2018
							double dbNormalPrice = (spup.getNormalPrice() != null ? spup.getNormalPrice().doubleValue()
									: 0);
							normalPrice = amount * dbNormalPrice;

							LoggingUtil.debug(logger,
									"#getSelfPackagePriceMappings --- amount= " + amount + ", normal_price_db= "
											+ dbNormalPrice + ", resulting normal_price= " + normalPrice);

						} catch (Exception e) {
							logger.error(
									"#getSelfPackagePriceMappings --- error calculating price mappings for monthly DATA package!",
									e);
						}
					} else {
						if (spup.getNormalPrice() != null) {
							normalPrice = spup.getNormalPrice().doubleValue();
						}
					}

					result.add(new SelfPackagePriceMapping(spup.getType(), spup.getMinAmount(), spup.getMaxAmount(),
							spup.getPrice() != null ? spup.getPrice().doubleValue() : 0, normalPrice,
							spup.getCycle() != null ? spup.getCycle() : 0));
				}
			}
		} catch (Exception e) {
			logger.error("#getSelfPackageUnitPriceList (string) --- error retrieving self pkg unit price list", e);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#
	 * getSelfPackagePriceMappings(int)
	 */
	@Override
	public List<SelfPackagePriceMapping> getSelfPackagePriceMappings(int cycle) {
		List<SelfPackagePriceMapping> result = new ArrayList<>();
		try {
			Iterable<SelfPackagePriceMappingEntity> list = selfPackagePriceMappingRepository.findAll(
					QSelfPackagePriceMappingEntity.selfPackagePriceMappingEntity.cycle.eq(cycle),
					QSelfPackagePriceMappingEntity.selfPackagePriceMappingEntity.type.asc());
			if (list != null) {
				for (SelfPackagePriceMappingEntity spup : list) {
					result.add(new SelfPackagePriceMapping(spup.getType(), spup.getMinAmount(), spup.getMaxAmount(),
							spup.getPrice() != null ? spup.getPrice().doubleValue() : 0,
							spup.getNormalPrice() != null ? spup.getNormalPrice().doubleValue() : 0,
							spup.getCycle() != null ? spup.getCycle() : 0));
				}
			}
		} catch (Exception e) {
			logger.error("#getSelfPackageUnitPriceList (string) --- error retrieving self pkg unit price list", e);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#
	 * getSelfPackageCommonConfigs()
	 */
	@Override
	public Map<String, String> getSelfPackageCommonConfigs() {

		Map<String, String> result = new Hashtable<>();
		try {
			Iterable<SelfPackageCommonConfigEntity> list = selfPackageCommonConfigRepository
					.findAll(QSelfPackageCommonConfigEntity.selfPackageCommonConfigEntity.name.asc());
			if (list != null) {
				for (SelfPackageCommonConfigEntity config : list) {
					result.put(config.getName(), config.getValue());
				}
			}
		} catch (Exception e) {
			logger.error("#getSelfPackageCommonConfigs --- error retrieving self_package common configs", e);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#
	 * getSelfPackageCommonConfigsAsList()
	 */
	@Override
	public List<KeyValue> getSelfPackageCommonConfigsAsList() {
		List<KeyValue> configs = new ArrayList<>();
		try {
			Iterable<SelfPackageCommonConfigEntity> list = selfPackageCommonConfigRepository
					.findAll(QSelfPackageCommonConfigEntity.selfPackageCommonConfigEntity.name.asc());
			if (list != null) {
				for (SelfPackageCommonConfigEntity config : list) {
					configs.add(new KeyValue(config.getName(), config.getValue()));
				}
			}
		} catch (Exception e) {
			logger.error("#getSelfPackageCommonConfigsAsList --- error populating self_package common config!", e);
		}
		return configs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#
	 * getSelfPackageBalanceList()
	 */
	@Override
	public List<SelfPackageBalanceName> getSelfPackageBalanceList() {

		List<SelfPackageBalanceName> result = new ArrayList<>();
		try {
			Iterable<SelfPackageBalanceNameEntity> list = selfPackageBalanceNameRepository
					.findAll(QSelfPackageBalanceNameEntity.selfPackageBalanceNameEntity.name.asc());
			if (list != null) {
				for (SelfPackageBalanceNameEntity entity : list) {
					result.add(new SelfPackageBalanceName(entity.getName(), entity.getDescriptionEN(),
							entity.getDescriptionVI()));
				}
			}
		} catch (Exception e) {
			logger.error("#getSelfPackageBalanceList --- error retrieving balance names for self_package!", e);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#
	 * registerSelfPackage(com.gnv.vnm.selfcare.core.adapter.vasman.
	 * VASManSelfPackageRequest)
	 */
	@Override
	public BackEndAdapterResponse registerSelfPackage(VASManSelfPackageRequest request) {

		LoggingUtil.debug(logger, "#registerSelfPackage --- receiving request= " + request);

		request.setMsisdn(AppUtils.prependCountryCodeToMsisdn(request.getMsisdn(),
				applicationConfigurationService.getDefaultCountryCode()));

		int daily = 2, weekly = 7, monthly = 30;
		try {
			Iterable<SelfPackageCommonConfigEntity> list = selfPackageCommonConfigRepository.findAll(
					QSelfPackageCommonConfigEntity.selfPackageCommonConfigEntity.name.startsWithIgnoreCase("DAYS_"));
			if (list != null) {
				for (SelfPackageCommonConfigEntity config : list) {
					if (config.getName().equalsIgnoreCase("DAYS_DAILY")) {
						if (config.getValue() != null)
							daily = Integer.parseInt(config.getValue().trim());
					} else if (config.getName().equalsIgnoreCase("DAYS_WEEKLY")) {
						if (config.getValue() != null)
							weekly = Integer.parseInt(config.getValue().trim());
					} else if (config.getName().equalsIgnoreCase("DAYS_MONTHLY")) {
						if (config.getValue() != null)
							monthly = Integer.parseInt(config.getValue().trim());
					}
				}
			}
		} catch (Exception e) {
		}

		if (request.getCycle().equals(SelfPackageCycle.DAILY)) {
			request.setNumOfDays(daily);
		} else if (request.getCycle().equals(SelfPackageCycle.WEEKLY)) {
			request.setNumOfDays(weekly);
		} else {
			request.setNumOfDays(monthly);
		}

		Hashtable<String, Double> valueMultiplierMaps = new Hashtable<>();
		Iterable<SelfPackageBalanceNameEntity> balanceNames = selfPackageBalanceNameRepository
				.findAll(QSelfPackageBalanceNameEntity.selfPackageBalanceNameEntity.name.asc());
		if (balanceNames != null) {
			for (SelfPackageBalanceNameEntity bn : balanceNames) {
				if (bn.getMultiplierValue() != null) {
					valueMultiplierMaps.put(bn.getName().toUpperCase(), bn.getMultiplierValue());
				}
			}
		}

		List<VASManSelfPackageBalance> balanceList = request.getBalanceList();
		// recalculate amount with multiplier value if exists, e.g: if VOICE_XXX
		// then it should be multiplied with 60 (seconds)
		for (VASManSelfPackageBalance bal : balanceList) {
			Double mv = valueMultiplierMaps.get(bal.getName().toUpperCase());
			if (mv != null && mv > 0) {
				bal.setAmount(bal.getAmount() * mv);
			}
		}

		double chargingAmount = 0.0;
		// double check if mobile app did not send the chargingAmount param
		if (request.getChargingAmount() <= 0) {
			for (VASManSelfPackageBalance bal : balanceList) {
				List<SelfPackagePriceMapping> priceMap = getSelfPackagePriceMappings(bal.getName(),
						request.getCycle().ordinal(), (int) bal.getAmount());
				if (priceMap != null && !priceMap.isEmpty()) {
					chargingAmount = chargingAmount + priceMap.get(0).getPrice();
				}
			}

			LoggingUtil.debug(logger, "#registerSelfPackage --- request from MSISDN " + request.getMsisdn()
					+ " does not come with chargingAmount, calculated amount is= " + chargingAmount);
			request.setChargingAmount(chargingAmount);
		}

		VASManAdapter adapter = getVASManAdapter();
		BackEndAdapterResponse response = adapter.sendRequest(request);

		if (adapterPoolEnabled && adapter != null) {
			vasManAdapterPool.returnObject(adapter);
		}

		LoggingUtil.debug(logger, "#registerSelfPackage --- MSISDN " + request.getMsisdn() + ", result= " + response);
		return response;
	}

	/**
	 * Create top up reminder if core balance value is lower than defined in
	 * lms_config
	 * 
	 * @param coreBalance
	 * @param msisdn
	 */
	private void createTopUpReminder(double coreBalance, String msisdn) {
		double minBalance = 0;
		int maxSentCount = 0;
		try {
			minBalance = Double
					.parseDouble(getLmsConfigValue(LmsConfigNames.CORE_BALANCE_MIN_AMOUNT.name(), "5000").toString());
			maxSentCount = Integer.parseInt(getLmsConfigValue("RECHARGE_REMINDER_MAX_SHOW_COUNT", "6").toString());
		} catch (Exception e) {
		}

		if (minBalance > 0 && coreBalance < minBalance) {
			LoggingUtil.debug(logger, "#createTopUpReminder --- msisdn " + msisdn + ", core_balance= " + coreBalance
					+ ", min_balance= " + minBalance);

			try {
				Map<String, Object> lmsConfigs = getLmsConfigs();
				Object titleEN = lmsConfigs.get(LmsConfigNames.RECHARGE_REMINDER_TITLE_EN.name());
				Object titleVI = lmsConfigs.get(LmsConfigNames.RECHARGE_REMINDER_TITLE_VI.name());
				Object messageEN = lmsConfigs.get(LmsConfigNames.RECHARGE_REMINDER_TEXT_EN.name());
				Object messageVI = lmsConfigs.get(LmsConfigNames.RECHARGE_REMINDER_TEXT_VI.name());
				Object imageName = lmsConfigs.get(LmsConfigNames.RECHARGE_REMINDER_IMAGE.name());

				// check if notification already exists --- expect only one row
				// is found
				PushedCampaignEntity pce = pushedCampaignRepository
						.findOne(QPushedCampaignEntity.pushedCampaignEntity.targetedUser.eq(msisdn)
								.and(QPushedCampaignEntity.pushedCampaignEntity.type.isNotNull()
										.and(QPushedCampaignEntity.pushedCampaignEntity.type
												.eq(PushedCampaignType.FCM.ordinal()))));

				if (pce != null) {
					if (pce.getSentCounter() >= maxSentCount
							|| (pce.getStatus() != null && pce.getStatus().equals(NotificationStatus.READ.ordinal()))) {
						pce.setSentCounter(0);
						pce.setStatus(NotificationStatus.UNREAD.ordinal());
					}
				} else {
					pce = new PushedCampaignEntity();
					pce.setDisplayType(NotificationDisplayType.PUSHED.ordinal());
					pce.setEndDate(null);
					pce.setStartDate(new Date());
					pce.setStatus(NotificationStatus.UNREAD.ordinal());
					pce.setTargetedUser(msisdn);
					pce.setType(PushedCampaignType.FCM.ordinal());
				}

				pce.setDescriptionEN(messageEN != null ? messageEN.toString() : "");
				pce.setDescriptionVI(messageVI != null ? messageVI.toString() : "");
				pce.setDetailsEN(messageEN != null ? messageEN.toString() : "");
				pce.setDetailsVI(messageVI != null ? messageVI.toString() : "");

				pce.setTitleEN(titleEN != null ? titleEN.toString() : "");
				pce.setTitleVI(titleVI != null ? titleVI.toString() : "");

				if (imageName != null) {
					pce.setImageURL(createImageURL(imageName.toString()));
				}
				pushedCampaignRepository.save(pce);

			} catch (Exception e) {
				logger.error("#createTopUpReminder --- error creating topup reminder for MSISDN " + msisdn, e);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#getLmsConfigs()
	 */
	@Override
	public Map<String, Object> getLmsConfigs() {

		Map<String, Object> configs = new Hashtable<>();
		Iterable<LmsConfigEntity> list = lmsConfigRepository.findAll(QLmsConfigEntity.lmsConfigEntity.value.isNotNull(),
				QLmsConfigEntity.lmsConfigEntity.name.asc());
		if (list != null) {
			for (LmsConfigEntity lce : list) {
				if (lce.getValue() != null) {
					if (lce.getName().equalsIgnoreCase(LmsConfigNames.POPUP_NOTIF_IMAGE_HUNGRY.name())
							|| lce.getName().equalsIgnoreCase(LmsConfigNames.POPUP_NOTIF_IMAGE_FULL.name())
							|| lce.getName().equalsIgnoreCase(LmsConfigNames.RECHARGE_REMINDER_IMAGE.name())) {

						String imageURL = createImageURL(lce.getValue());
						configs.put(lce.getName(), imageURL);
					} else {
						configs.put(lce.getName(), lce.getValue());
					}
				}
			}
		}

		return configs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#
	 * getLmsConfigValue(java.lang.String)
	 */
	@Override
	public Object getLmsConfigValue(String key, Object defaultValue) {

		try {
			LmsConfigEntity lce = lmsConfigRepository
					.findOne(QLmsConfigEntity.lmsConfigEntity.name.equalsIgnoreCase(key));
			if (lce != null && lce.getValue() != null) {
				if (lce.getName().equalsIgnoreCase(LmsConfigNames.POPUP_NOTIF_IMAGE_HUNGRY.name())
						|| lce.getName().equalsIgnoreCase(LmsConfigNames.POPUP_NOTIF_IMAGE_FULL.name())
						|| lce.getName().equalsIgnoreCase(LmsConfigNames.RECHARGE_REMINDER_IMAGE.name())) {

					return createImageURL(lce.getValue());
				} else {
					return lce.getValue();
				}
			}
		} catch (Exception e) {
			logger.error("#getLmsConfigValue --- error retrieving LMS config value for name= " + key, e);
		}
		return defaultValue;
	}

	public ScratchStatusModel checkBlockUnblockTopUp(String msisdn) {

		ScratchStatusModel scratchStatusModel = new ScratchStatusModel();
		try {
			ScratchStatusEntity scratchStatusEntity = scratchstatusRepository
					.findOne(QScratchStatusEntity.scratchStatusEntity.msisdn.eq(msisdn));

			if (scratchStatusEntity == null) {
				scratchStatusModel.setStatus("0");
				scratchStatusModel.setTimeStamp("00-00-0000 00:00");
			} else {
				scratchStatusModel.setStatus(scratchStatusEntity.getStatus());
				scratchStatusModel.setTimeStamp(scratchStatusEntity.getTimeStamp());
			}

		} catch (Exception e) {

			logger.error("#checkBlockUnblockTopUp --- No status in ScratchStatusEntity", e);
		}
		return scratchStatusModel;
	}

	@Override
	public void saveScratchCardInHistory(ScratchBlockHistoryEntity scratchBlockEntities) {

		// create failure scratch card history
		try {
			scratchBlockRepository.save(scratchBlockEntities);

		} catch (Exception e) {
			logger.error(
					"#saveScratchCardFailLimit -- error creating failure scratch card history " + scratchBlockEntities,
					e);
		}

	}

	@Override
	public int getCountFromScratchBlock(String msisdn) {
		int count = 0;
		try {
			ScratchStatusEntity scratchStatusEntity = scratchstatusRepository
					.findOne(QScratchStatusEntity.scratchStatusEntity.msisdn.eq(msisdn));

			if (scratchStatusEntity != null) {
				count = scratchStatusEntity.getCount();
			}

		} catch (Exception e) {
			logger.error("#getCountFromScratchBlock --- No Count in ScratchStatusEntity", e);
		}
		return count;
	}

	@Override
	public void saveScratchStatus(String msisdn, int count, String status, String timeStamp) {
		// create failure scratch card status
		try {

			ScratchStatusEntity scratchStatusEntity = this.scratchstatusRepository
					.findOne(QScratchStatusEntity.scratchStatusEntity.msisdn.equalsIgnoreCase(msisdn));

			if (scratchStatusEntity != null) {
				scratchStatusEntity.setCount(count);
				scratchStatusEntity.setMsisdn(msisdn);
				scratchStatusEntity.setStatus(status);
				if (count == 1 || count == 5) {
					scratchStatusEntity.setTimeStamp(timeStamp); // after 24hrs,
																	// count
																	// value
																	// will be
																	// zero.
				}

				// scratchStatusEntity.setId(0);

				scratchstatusRepository.save(scratchStatusEntity);
			} else {
				ScratchStatusEntity scratchStatus = new ScratchStatusEntity();
				scratchStatus.setCount(count);
				scratchStatus.setMsisdn(msisdn);
				scratchStatus.setStatus(status);
				scratchStatus.setTimeStamp(timeStamp);
				scratchStatus.setId(0);

				scratchstatusRepository.save(scratchStatus);
			}

		} catch (Exception e) {
			logger.error("#saveScratchStatus -- error creating failure scratch card status : msisdn::" + msisdn
					+ "::count::" + count + "status::" + status + "timeStamp::" + timeStamp, e);
		}

	}

	@Override
	public String getFirstTimestampScratchStatus(String msisdn) {

		String firstTimestamp = null;
		try {
			ScratchStatusEntity scratchStatusEntity = scratchstatusRepository
					.findOne(QScratchStatusEntity.scratchStatusEntity.msisdn.eq(msisdn));

			if (scratchStatusEntity != null) {
				firstTimestamp = scratchStatusEntity.getTimeStamp();
			}

		} catch (Exception e) {
			logger.error("#getFirstTimestampScratchStatus --- No Timestamp in ScratchStatusEntity", e);
		}
		return firstTimestamp;
	}

	@Override
	public RechargeResponse topUpWithScratchCardUpdate(String subscriberId, String voucherCode, String recipientNumber,
			ClientAppId clientAppId, String referrer) {

		if (!StringUtils.hasText(subscriberId) && !StringUtils.hasText(voucherCode)) {
			return new RechargeResponse();
		}

		if (!StringUtils.hasText(recipientNumber))
			recipientNumber = subscriberId;

		RequestStatus status = RequestStatus.PROCESSING;
		String statusCode = "";
		double balance = 0;

		// Updated: 2017-07-21
		// directly send topup request to Tibco
		RechargeResponse rechargeResponse = tibcoServiceProvider.topUpWithScratchCard(AppUtils
				.prependCountryCodeToMsisdn(recipientNumber, applicationConfigurationService.getDefaultCountryCode()),
				voucherCode);
		balance = rechargeResponse.getBalance();
		statusCode = rechargeResponse.getCode();

		if (statusCode.equals(TibcoResponse.SUCCESS.code())) {
			// might not return updated balance information -- double check
			if (balance <= 0) {
				Balance coreBalance = getCoreBalance(subscriberId);
				rechargeResponse.setBalance(coreBalance != null ? coreBalance.getAvailableValue() : 0);
			}
			status = RequestStatus.SUCCESS;

			if (!recipientNumber.equals(subscriberId)) {

				Locale locale = new Locale(applicationConfigurationService.getDefaultLanguageCode());
				try {
					SubscriberEntity recipient = this.subscriberRepository
							.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(recipientNumber));
					if (recipient != null && StringUtils.hasText(recipient.getLanguageCode())) {
						locale = new Locale(recipient.getLanguageCode());
					} else {
						SubscriberEntity sender = this.subscriberRepository
								.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(subscriberId));
						if (sender != null && StringUtils.hasText(sender.getLanguageCode())) {
							locale = new Locale(sender.getLanguageCode());
						}
					}
				} catch (Exception e) {
				}

				Object[] params = new Object[] { rechargeResponse.getRechargeValue(), subscriberId,
						AppUtils.dateToString(new Date(), "dd/MM/yyyy HH:mm:ss") };
				String message = SpringUtils.resolveMessage(messageSource, "Message.Topup.ForOtherNumber", params,
						String.format(DefaultBackendMessage.TOPUP_FOR_ANOTHER_NUMBER.getMessage(), params), locale);

				String sender = applicationConfigurationService.get("smpp.defaultsender", "SELFCARE").toString();
				sendsmsservice.sendSMS(sender, recipientNumber, message, true, null, null);

			}

			// TODO remove this comment
			removeTopupReminders(subscriberId, rechargeResponse.getBalance());
		} else {
			status = RequestStatus.FAIL;
		}

		createTopUpHistory(subscriberId, voucherCode, rechargeResponse.getRechargeValue(), status.ordinal(),
				TopUpType.SCRATCH_CARD.name(), null,
				clientAppId != null ? clientAppId.name() : ClientAppId.MOBILE_APP.name(), referrer);

		return rechargeResponse;
	}

	private void createTopUpHistory(String msisdn, String voucherCode, double amount, Integer status, String channelId,
			String refTrxId, String clientAppId, String referrer) {
		// create top-up history
		try {
			TopUpHistoryEntity history = new TopUpHistoryEntity(msisdn, voucherCode, amount, new Date(), status);
			history.setRefTrxId(refTrxId);
			history.setChannelId(channelId);
			history.setClientAppId(clientAppId);
			history.setReferrer(referrer);

			topUpHistoryRepository.saveAndFlush(history);
		} catch (Exception e) {
			logger.error("#createTopUpHistory -- error creating top up history " + "(subscriber_id= " + msisdn
					+ ", voucher_code= " + voucherCode + ", balance= " + amount + ",)", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor#topUp(java.lang
	 * .String, java.lang.String)
	 */
	@Override
	public RechargeResponse topUpWithScratchCard(String subscriberId, String voucherCode, String recipientNumber,
			ClientAppId clientAppId, String referrer) {

		if (!StringUtils.hasText(subscriberId) && !StringUtils.hasText(voucherCode)) {
			return new RechargeResponse();
		}

		if (!StringUtils.hasText(recipientNumber))
			recipientNumber = subscriberId;

		RequestStatus status = RequestStatus.PROCESSING;
		String statusCode = "";
		double balance = 0;

		// Updated: 2017-07-21
		// directly send topup request to Tibco
		RechargeResponse rechargeResponse = tibcoServiceProvider.topUpWithScratchCard(AppUtils
				.prependCountryCodeToMsisdn(recipientNumber, applicationConfigurationService.getDefaultCountryCode()),
				voucherCode);
		balance = rechargeResponse.getBalance();
		statusCode = rechargeResponse.getCode();

		if (statusCode.equals(TibcoResponse.SUCCESS.code())) {
			// might not return updated balance information -- double check
			if (balance <= 0) {
				Balance coreBalance = getCoreBalance(subscriberId);
				rechargeResponse.setBalance(coreBalance != null ? coreBalance.getAvailableValue() : 0);
			}
			status = RequestStatus.SUCCESS;

			if (!recipientNumber.equals(subscriberId)) {

				Locale locale = new Locale(applicationConfigurationService.getDefaultLanguageCode());
				try {
					SubscriberEntity recipient = this.subscriberRepository
							.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(recipientNumber));
					if (recipient != null && StringUtils.hasText(recipient.getLanguageCode())) {
						locale = new Locale(recipient.getLanguageCode());
					} else {
						SubscriberEntity sender = this.subscriberRepository
								.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(subscriberId));
						if (sender != null && StringUtils.hasText(sender.getLanguageCode())) {
							locale = new Locale(sender.getLanguageCode());
						}
					}
				} catch (Exception e) {
				}

				Object[] params = new Object[] { rechargeResponse.getRechargeValue(), subscriberId,
						AppUtils.dateToString(new Date(), "dd/MM/yyyy HH:mm:ss") };
				String message = SpringUtils.resolveMessage(messageSource, "Message.Topup.ForOtherNumber", params,
						String.format(DefaultBackendMessage.TOPUP_FOR_ANOTHER_NUMBER.getMessage(), params), locale);

				String sender = applicationConfigurationService.get("smpp.defaultsender", "SELFCARE").toString();
				sendsmsservice.sendSMS(sender, recipientNumber, message, true, null, null);

			}

			// TODO remove this comment
			removeTopupReminders(subscriberId, rechargeResponse.getBalance());
		} else {
			status = RequestStatus.FAIL;
		}

		createTopUpHistory(subscriberId, voucherCode, rechargeResponse.getRechargeValue(), status.ordinal(),
				TopUpType.SCRATCH_CARD.name(), null,
				clientAppId != null ? clientAppId.name() : ClientAppId.MOBILE_APP.name(), referrer);

		return rechargeResponse;
	}

	@Override
	public SmsCallHistoryStatusModel checkSmsCallHistorycredential(String msisdn, String credential)
			throws SubscriberNotFoundException {

		SmsCallHistoryStatusModel historyStatusModel = new SmsCallHistoryStatusModel();

		SubscriberEntity subscriber = subscriberRepository
				.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(msisdn));
		if (subscriber == null)
			throw new SubscriberNotFoundException("SubscriberProfile " + msisdn + " does not exist!");
		if (credential != null && (credential.length() != 0)) {
			if (!passwordEncoder.encode(credential.trim()).equals(subscriber.getCredential())) {
				historyStatusModel.setMessage("Password Mismatch");
				historyStatusModel.setStatus("2");
				return historyStatusModel;
			}
		}

		try {
			SmsCallHistoryStatusEntity smStatusEntity = smsCallHistoryStatusRepository
					.findOne(QSmsCallHistoryStatusEntity.smsCallHistoryStatusEntity.msisdn.equalsIgnoreCase(msisdn));
			historyStatusModel.setMessage("Password match");
			if (smStatusEntity == null) {
				historyStatusModel.setStatus("0");
			} else {
				if (smStatusEntity.getStatus() == null) {
					historyStatusModel.setStatus("0");
				} else {
					historyStatusModel.setStatus(smStatusEntity.getStatus());
				}

			}

		}

		catch (Exception exception) {
			exception.printStackTrace();
		}

		return historyStatusModel;
	}

	@Override
	public SmsCallHistoryStatusModel updateSmsCallHistoryStatus(String msisdn, String credential, String status)
			throws SubscriberNotFoundException {

		SmsCallHistoryStatusModel historyStatusModel = new SmsCallHistoryStatusModel();

		SubscriberEntity subscriber = subscriberRepository
				.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(msisdn));
		if (subscriber == null)
			throw new SubscriberNotFoundException("SubscriberProfile " + msisdn + " does not exist!");
		// ////System.out.println("password Is
		// :::"+passwordEncoder.encode(credential.trim())+" password is
		// "+subscriber.getCredential());
		if (credential != null && (credential.length() != 0)) {
			if (!passwordEncoder.encode(credential.trim()).equals(subscriber.getCredential())) {
				historyStatusModel.setMessage("Password Mismatch");
				historyStatusModel.setStatus("2");
				return historyStatusModel;
			}
		}
		try {
			SmsCallHistoryStatusEntity smStatusEntity = smsCallHistoryStatusRepository
					.findOne(QSmsCallHistoryStatusEntity.smsCallHistoryStatusEntity.msisdn.equalsIgnoreCase(msisdn));

			if (smStatusEntity != null) {
				smStatusEntity.setMsisdn(msisdn);
				smStatusEntity.setStatus(status);
				smsCallHistoryStatusRepository.save(smStatusEntity);
			} else {
				SmsCallHistoryStatusEntity statusEntity = new SmsCallHistoryStatusEntity();
				statusEntity.setId(0);
				statusEntity.setMsisdn(msisdn);
				statusEntity.setStatus(status);
				smsCallHistoryStatusRepository.save(statusEntity);
			}

			historyStatusModel.setMessage("Successfully updated!");
			if (status != null)
				historyStatusModel.setStatus(status);
			else
				historyStatusModel.setStatus("0");
			// historyStatusModel.setStatus("0");
			// ////System.out.println("smStatusEntity.getStatus() " +
			// smStatusEntity.getStatus());
		} catch (Exception ex) {
			ex.printStackTrace();
			historyStatusModel.setMessage("Updation failed!");
			historyStatusModel.setStatus("3");
		}

		return historyStatusModel;
	}

	@Override
	public String getSmsCallHistoryStatus(String msisdn) {

		String status = "0";
		SmsCallHistoryStatusEntity smStatusEntity = smsCallHistoryStatusRepository
				.findOne(QSmsCallHistoryStatusEntity.smsCallHistoryStatusEntity.msisdn.equalsIgnoreCase(msisdn));

		if (smStatusEntity != null) {
			status = smStatusEntity.getStatus();
		}

		return status;
	}

	@Override
	public boolean saveVersionDetails(String loginId, String app_version, String app_os, String app_os_version,
			String devic_name, String devic_modeil, String devic_id) {
		// TODO Auto-generated method stub
		Version_DetailsEntity version_DetailsEntity = null;

		boolean retrun_status = false;
		try {
			version_DetailsEntity = version_DetailsRepository
					.findOne(QVersion_DetailsEntity.version_DetailsEntity.loginId.equalsIgnoreCase(loginId));
			// smStatusEntity=
			// smsCallHistoryStatusRepository.findOne(QSmsCallHistoryStatusEntity.smsCallHistoryStatusEntity.msisdn.equalsIgnoreCase(msisdn));

			if ((version_DetailsEntity != null) && (version_DetailsEntity.getLoginId() != null)) {

				version_DetailsEntity.setId(version_DetailsEntity.getId());
				version_DetailsEntity.setLoginId(loginId);
				version_DetailsEntity.setApp_os(app_os);
				version_DetailsEntity.setApp_os_version(app_os_version);
				version_DetailsEntity.setApp_version(app_version);
				version_DetailsEntity.setDevic_id(devic_id);
				version_DetailsEntity.setDevic_modeil(devic_modeil);
				version_DetailsEntity.setDevic_name(devic_name);
				version_DetailsRepository.save(version_DetailsEntity);
				retrun_status = true;
			} else {
				version_DetailsEntity = new Version_DetailsEntity();
				version_DetailsEntity.setLoginId(loginId);
				version_DetailsEntity.setApp_os(app_os);
				version_DetailsEntity.setApp_os_version(app_os_version);
				version_DetailsEntity.setApp_version(app_version);
				version_DetailsEntity.setDevic_id(devic_id);
				version_DetailsEntity.setDevic_modeil(devic_modeil);
				version_DetailsEntity.setDevic_name(devic_name);
				version_DetailsRepository.save(version_DetailsEntity);

				retrun_status = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return retrun_status;
	}
	
	/*@Override
	public boolean savebaznotificationDetails(String msisdn, String readstatus,String readBy) {
		// TODO Auto-generated method stub
		BazNotifcationStatusEntity bazNotifcationStatusEntity =null;
	
		boolean retrun_status=false;
		try{
			bazNotifcationStatusEntity= bazNotifcationStatusRepository.findOne(QBazNotifcationStatusEntity.bazNotifcationStatusEntity.msisdn.equalsIgnoreCase(msisdn));
	   //smStatusEntity= smsCallHistoryStatusRepository.findOne(QSmsCallHistoryStatusEntity.smsCallHistoryStatusEntity.msisdn.equalsIgnoreCase(msisdn));
          
		if((bazNotifcationStatusEntity!=null)&&(bazNotifcationStatusEntity.getMsisdn()!=null))
		{
			
			bazNotifcationStatusEntity.setId(bazNotifcationStatusEntity.getId());
			bazNotifcationStatusEntity.setMsisdn(msisdn);
			bazNotifcationStatusEntity.setRead_by(readBy);
			bazNotifcationStatusEntity.setNotification_status(readstatus);
			bazNotifcationStatusRepository.save(bazNotifcationStatusEntity);
			retrun_status=true;
		}
		else{
			bazNotifcationStatusEntity = new BazNotifcationStatusEntity();
			bazNotifcationStatusEntity.setMsisdn(msisdn);
			bazNotifcationStatusEntity.setRead_by(readBy);
			bazNotifcationStatusEntity.setNotification_status(readstatus);
			
			bazNotifcationStatusRepository.save(bazNotifcationStatusEntity);
		
		retrun_status=true;
	}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return retrun_status;
	}*/
	
    @Override
    public OtpStatusModel checkBlockUnblockOtp(String msisdn) {

           OtpStatusModel otpStatusModel = new OtpStatusModel();
           try {
                  OtpStatusEntity otpStatusEntity = otpstatusRepository
                               .findOne(QOtpStatusEntity.otpStatusEntity.msisdn.eq(msisdn));

                  if (otpStatusEntity != null) {
                  //     ////System.out.println("fetching");
                	  System.out.println("----"+otpStatusEntity.getStatus());
                	  System.out.println("----"+otpStatusEntity.getFailCount());
                	  System.out.println("----"+otpStatusEntity.getCount());
                        otpStatusModel.setStatus(otpStatusEntity.getStatus());
                        otpStatusModel.setTimeStamp(otpStatusEntity.getTimeStamp());
                        otpStatusModel.setCount(otpStatusEntity.getCount());
                        otpStatusModel.setFailCount(otpStatusEntity.getFailCount());
                        
                  } else {
                        //////System.out.println("saving ... and fetch");
                        saveOtpStatus(msisdn, 0, "0", getCurrentDateTime(),true);
                        OtpStatusEntity otpStatusEntity2 = otpstatusRepository
                                      .findOne(QOtpStatusEntity.otpStatusEntity.msisdn.eq(msisdn));
                        otpStatusModel.setStatus(otpStatusEntity2.getStatus());
                        otpStatusModel.setTimeStamp(otpStatusEntity2.getTimeStamp());
                        otpStatusModel.setCount(0);
                        otpStatusModel.setFailCount(0);
                        
                  }

           } catch (Exception e) {

                  logger.error("#checkBlockUnblockTopUp --- No status in ScratchStatusEntity", e);
           }
           return otpStatusModel;
                        }      
    





@Override
    public int getfailCountFromOtpBlock(String msisdn) {
           int count = 0;
           try {
                  OtpStatusEntity otpStatusEntity = otpstatusRepository
                               .findOne(QOtpStatusEntity.otpStatusEntity.msisdn.eq(msisdn));

                  if (otpStatusEntity != null) {
                  //     ////System.out.println( "fffffffff "+otpStatusEntity.getFailCount());
                        count = otpStatusEntity.getFailCount();
                  }

           } catch (Exception e) {
                  logger.error("#getCountFromOTPBlock --- No Count in OTPStatusEntity", e);
           }
           return count;
                        }






@Override
    public void saveOtpStatus(String msisdn, int count, String status, String timeStamp,boolean timechange) {
           // create failure scratch card status
           //try {
                  LoggingUtil.debug(logger, "#sendMessage >> fatch the data regarding otp " + timeStamp);
           
            
                  OtpStatusEntity otpStatusEntity = otpstatusRepository.findOne(QOtpStatusEntity.otpStatusEntity.msisdn.eq(msisdn));
           //     ////System.out.println("otpEntity from repo "+otpStatusEntity);
                  if (otpStatusEntity != null) {
                  //     ////System.out.println("save if not null");
                        otpStatusEntity.setCount(count);
                  //     otpStatusEntity.setMsisdn(msisdn);
                        otpStatusEntity.setStatus(status);
                        otpStatusEntity.setId(otpStatusEntity.getId());
                        if(timechange)
                               otpStatusEntity.setTimeStamp(timeStamp); // after 24hrs,
                                                                                                                  // count
                                                                                                                  // value
                                                                                                                  // will be
                                                                                                                  // zero.
                        otpstatusRepository.save(otpStatusEntity);
                        // scratchStatusEntity.setId(0);
                        LoggingUtil.debug(logger, "#otpstatusRepository >> fatch the data regarding otpstatusRepository " + otpstatusRepository);
                        
                  } else {
                        //////System.out.println("save if  null");
                        OtpStatusEntity otpStatusEntity1 = new OtpStatusEntity();
                        otpStatusEntity1.setCount(count);
                        otpStatusEntity1.setFailCount(0);
                        otpStatusEntity1.setMsisdn(msisdn);
                        otpStatusEntity1.setStatus(status);
                        otpStatusEntity1.setTimeStamp(timeStamp);
                        
                        otpstatusRepository.save(otpStatusEntity1);
                  }

           /*} catch (Exception e) {
                  logger.error("#saveScratchStatus -- error creating failure scratch card status : msisdn::" + msisdn
                               + "::count::" + count + "status::" + status + "timeStamp::" + timeStamp, e);
           }*/

    }


    @Override
    public void resetFailCount(String msisdn) {
           
           OtpStatusEntity otpStatusEntity = otpstatusRepository
                        .findOne(QOtpStatusEntity.otpStatusEntity.msisdn.eq(msisdn));
           
           if(otpStatusEntity != null){
                  otpStatusEntity.setFailCount(0);
                  otpstatusRepository.save(otpStatusEntity);
           }
           
           
           
           
    }
    
    public String getCurrentDateTime() {

		Date dt = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		String strDate = dateFormat.format(dt);
		// ////System.out.println(strDate);
		return strDate;
	}


    @Override
	public boolean savebaznotificationDetails(String msisdn, String readstatus,String readcount,String readBy) {
		// TODO Auto-generated method stub
		BazNotifcationStatusEntity bazNotifcationStatusEntity =null;
	
		boolean retrun_status=false;
		try{
			bazNotifcationStatusEntity= bazNotifcationStatusRepository.findOne(QBazNotifcationStatusEntity.bazNotifcationStatusEntity.msisdn.equalsIgnoreCase(msisdn));
	   //smStatusEntity= smsCallHistoryStatusRepository.findOne(QSmsCallHistoryStatusEntity.smsCallHistoryStatusEntity.msisdn.equalsIgnoreCase(msisdn));
          
		if((bazNotifcationStatusEntity!=null)&&(bazNotifcationStatusEntity.getMsisdn()!=null))
		{
			
			bazNotifcationStatusEntity.setId(bazNotifcationStatusEntity.getId());
			bazNotifcationStatusEntity.setMsisdn(msisdn);
			bazNotifcationStatusEntity.setRead_by(readBy);
			bazNotifcationStatusEntity.setNotification_status(readstatus);
			bazNotifcationStatusEntity.setNumber_notification(readcount);
			bazNotifcationStatusRepository.save(bazNotifcationStatusEntity);
			retrun_status=true;
		}
		else{
			bazNotifcationStatusEntity = new BazNotifcationStatusEntity();
			bazNotifcationStatusEntity.setMsisdn(msisdn);
			bazNotifcationStatusEntity.setRead_by(readBy);
			bazNotifcationStatusEntity.setNumber_notification(readcount);
			bazNotifcationStatusEntity.setNotification_status(readstatus);
			
			bazNotifcationStatusRepository.save(bazNotifcationStatusEntity);
		
		retrun_status=true;
	}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return retrun_status;
	}
}
