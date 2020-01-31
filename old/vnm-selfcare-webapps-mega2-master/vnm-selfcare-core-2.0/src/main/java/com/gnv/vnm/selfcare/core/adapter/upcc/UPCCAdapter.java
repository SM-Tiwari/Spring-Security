/**
 * 
 */
package com.gnv.vnm.selfcare.core.adapter.upcc;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.gnv.vnm.selfcare.core.adapter.BackEndAdapter;
import com.gnv.vnm.selfcare.core.adapter.BackEndAdapterException;
import com.gnv.vnm.selfcare.core.adapter.BackEndAdapterRequest;
import com.gnv.vnm.selfcare.core.adapter.BackEndAdapterResponse;
import com.gnv.vnm.selfcare.core.adapter.BackEndConnection;
import com.gnv.vnm.selfcare.core.enums.RequestStatus;
import com.gnv.vnm.selfcare.core.utils.HttpResponseWrapper;
import com.gnv.vnm.selfcare.core.utils.HttpSessionManager;
import com.gnv.vnm.selfcare.core.utils.LoggingUtil;

/**
 * @author nandipinto
 *
 */
public class UPCCAdapter extends BackEndAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(UPCCAdapter.class);
	
	public static final String DATE_TIME_FORMAT = "yyyyMMddHHmmss";
	
	static final int MAX_LOGIN_ATTEMPT = 3;
	
	static final String UPCC_PROPS_FILE	= "config/upcc-adapter.properties";
	static final String XPATH_LOGIN_RESPONSE_RESULT_CODE 	= "//rm:LGIResponse/result/resultCode/text()";
	static final String XPATH_LOGIN_RESPONSE_RESULT_DESC 	= "//rm:LGIResponse/result/paras[key = 'errorDescription']/value/text()";
	
	static final String XPATH_GET_SUBSCRIBER_INFO_RESPONSE_RESULT_CODE = "//rm:getSubscriberAllInfResponse/result/resultCode/text()";
	static final String XPATH_GET_SUBSCRIBER_INFO_RESPONSE_RESULT_DESC = "//rm:getSubscriberAllInfResponse/result/paras[key = 'errorDescription']/value/text()";
	 
	static final String STATUS_CODE_SUCCESS = "0";
	static final String SESSION_TIMEOUT_ERROR_CODE = "5004";
	static final String SESSION_TIMEOUT_ERROR_MSG = "Session ID invalid or time out";
	
	private HttpSessionManager httpSessionManager = null;
	private String initialURL = "";
	private String sessionURL = "";
	private long lastConnectedTimestamp = -1;
	private boolean connected = false;
	private boolean running = false;
	private int maxLoginAttempt = MAX_LOGIN_ATTEMPT;
	
	private DocumentBuilderFactory domFactory = null;
	private XPath xpath = null;

	private String loginRequest = "";
	private String logoutRequest = "";
	private String getSubscriberInfoRequest = "";
	private String xpathLoginResultCode;
	private String xpathLoginResultDesc;
	private String xpathQuerySubsInfoResultCode;
	private String xpathQuerySubsInfoResultDesc;
	private String successStatusCode;
	private String sessionTimeoutMsg = SESSION_TIMEOUT_ERROR_MSG;
	
	private Properties configs = new Properties();
	
	private int reconnectInterval = BackEndConnection.RECONNECT_INTERVAL_SECS * 1000;
	
	private void loadResources() throws Exception {
		InputStream is = null;
		try {
			is = UPCCAdapter.class.getClassLoader().getResourceAsStream(UPCC_PROPS_FILE);
			configs.load(is);
			
			maxLoginAttempt = Integer.parseInt(configs.getProperty("upcc.login.maxretry", "" + MAX_LOGIN_ATTEMPT));
			loginRequest = configs.getProperty("upcc.req.xml.login", buildLoginRequest()).replaceAll("P_USER_NAME", connection.getUserName()).replaceAll("P_PASSWORD", connection.getCredential());
			logoutRequest = configs.getProperty("upcc.req.xml.logout", buildLogoutRequest());
			getSubscriberInfoRequest = configs.getProperty("upcc.req.xml.querysubscriberinfo", buildGetSubscriberInfoRequest());
			
			xpathLoginResultCode = configs.getProperty("upcc.resp.xpath.login.statuscode", XPATH_LOGIN_RESPONSE_RESULT_CODE);
			xpathLoginResultDesc = configs.getProperty("upcc.resp.xpath.login.statusdesc", XPATH_LOGIN_RESPONSE_RESULT_DESC);
			xpathQuerySubsInfoResultCode = configs.getProperty("upcc.resp.xpath.querysubsinfo.statuscode", XPATH_GET_SUBSCRIBER_INFO_RESPONSE_RESULT_CODE);
			xpathQuerySubsInfoResultDesc = configs.getProperty("upcc.resp.xpath.querysubsinfo.statusdesc", XPATH_GET_SUBSCRIBER_INFO_RESPONSE_RESULT_DESC);
			
			successStatusCode = configs.getProperty("status.code.success", STATUS_CODE_SUCCESS);
			sessionTimeoutMsg = configs.getProperty("status.desc.sessiontimeout", SESSION_TIMEOUT_ERROR_MSG);
			
		} catch (Exception e) {
			logger.error("#init >> error loading UPCC Adapter resources!", e);
			throw e;
		} finally{
			if (is != null){
				try {
					is.close();
				} catch (Exception e2) {}
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.adapter.BackEndAdapter#init(com.gnv.vnm.selfcare.core.adapter.BackEndConnection)
	 */
	@Override
	public void init(BackEndConnection connection) throws BackEndAdapterException {
		this.connection = connection;
		try {
			loadResources();
		} catch (Exception e) {
			throw new BackEndAdapterException(e);
		}
		
		httpSessionManager = HttpSessionManager.getInstance(connection.getSocketTimeOut() * 1000, connection.getConnectionTimeOut() * 1000, 
				connection.getMaxConcurrentConnections(), false);
		initialURL = connection.getProtocol() + "://"+ connection.getHost() + ":" + connection.getPort();
		
		int attempt = 0;
		while (!isConnected() && attempt < maxLoginAttempt){
			login();
			attempt++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
		if (!isConnected()) throw new BackEndAdapterException("Failed to login to UPCC after " + MAX_LOGIN_ATTEMPT + " attempts!");
		
		if (connection.getReconnectInterval() > 0){
			this.reconnectInterval = connection.getReconnectInterval() * 1000;
		}
		
		setRunning(true);
		new SessionKeeper().start();
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.adapter.BackEndAdapter#reconnect(com.gnv.vnm.selfcare.core.adapter.BackEndConnection)
	 */
	@Override
	public void reconnect(BackEndConnection connection) throws BackEndAdapterException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.adapter.BackEndAdapter#login()
	 */
	@Override
	public void login() {
		Header[] headers =  new Header[]{
				new Header("Content-Type", "text/xml"),
				new Header("Content-length", ""+String.valueOf(loginRequest.getBytes().length)),
				new Header("Connection", "Keep-Alive")
		};
		LoggingUtil.debug(logger, "#login >> sending request to= " + initialURL);
		
		HttpResponseWrapper response = httpSessionManager.post(initialURL, loginRequest, "text/xml", headers);
		
		LoggingUtil.debug(logger, "#login >> receiving response= " + response);
		
		if (response.getCode() != HttpStatus.SC_TEMPORARY_REDIRECT) return; 
		
		sessionURL = response.getHeaderValue("Location");
		LoggingUtil.debug(logger, "#login >> got redirect_location from UPCC= " + this.sessionURL);

		if (!StringUtils.hasText(sessionURL)){
			LoggingUtil.error(logger, "#login >> login failure, did not receive Session ID from UPCC", null);
			return;
		}
		
		String respBody = response.getContent();
		UPCCRequestStatus status = getRequestStatusFromResponse(respBody, xpathLoginResultCode, xpathLoginResultDesc);
		LoggingUtil.debug(logger, "#login >> returning with status= " + status);
		
		if (status != null && status.getCode().equals(successStatusCode)){
			setConnected(true);
			setLastConnectedTimestamp(System.currentTimeMillis());
			
			LoggingUtil.info(logger, "#login >> successfully connected to UPCC.");
		}
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.adapter.BackEndAdapter#logout()
	 */
	@Override
	public void logout() {
		if (isConnected()){
			LoggingUtil.info(logger, "#logout >> logging out from UPCC...");
			httpSessionManager.post(sessionURL, logoutRequest, "text/xml", null);
			setConnected(false);
		}
	}


	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.adapter.BackEndAdapter#sendRequest(com.gnv.vnm.selfcare.core.adapter.BackEndAdapterRequest)
	 */
	@Override
	public BackEndAdapterResponse sendRequest(BackEndAdapterRequest request) {
		BackEndAdapterResponse response = new BackEndAdapterResponse();
		
		boolean retryRequired = false;
		if (request instanceof UPCCSubscriberQueryRequest){
			
			UPCCSubscriberQueryRequest queryReq = (UPCCSubscriberQueryRequest)request;
			String xmlRequest = getSubscriberInfoRequest.replaceAll("P_SUBS_ID", queryReq.getSubscriberId());
			
			LoggingUtil.debug(logger, "#querySubscriberInfo >> sending XML request=\n" + xmlRequest);
			
			HttpResponseWrapper httpResp = httpSessionManager.post(sessionURL, xmlRequest, "text/xml", null);
			LoggingUtil.debug(logger, "#querySubscriberInfo >> receiving http response_code: " + httpResp.getCode());
			
			if (httpResp.getCode() != HttpStatus.SC_INTERNAL_SERVER_ERROR){
//				LoggingUtil.debug(logger, "#querySubscriberInfo >> receiving response=\n" + httpResp.getContent());
				try {
					UPCCSubscriberData subscriberData = parseSubscriberData(queryReq.getSubscriberId(), httpResp.getContent());
					response.setResult(subscriberData);
					response.setStatus(RequestStatus.SUCCESS);
					
				} catch (BackEndAdapterException e) {
					logger.error("Error querying subscriber data(subscriberId= " + queryReq.getSubscriberId() + "), returning with exception= " + e);
					
					response.setStatus(RequestStatus.FAIL);
					response.setResponseCode(e.getCode());
					response.setResponseDescription(e.getMessage());
					
					if (e.getCode() != null && e.getCode().equals(SESSION_TIMEOUT_ERROR_CODE)){
						retryRequired = true;
					}
				} catch (Exception e) {
					response.setStatus(RequestStatus.FAIL);
					response.setResponseCode(BackEndAdapter.INTERNAL_ERROR_CODE);
					response.setResponseDescription(e.getMessage());
				}

			}else{
				response.setStatus(RequestStatus.FAIL);
				response.setResponseCode(BackEndAdapter.INTERNAL_ERROR_CODE);
			}
			
		}else if (request instanceof UPCCRechargeQuotaRequest){
			
		}

		if (retryRequired){
			//TODO
		}
		return response;
	}

	public UPCCSubscriberData parseSubscriberData(String subscriberId, String response) throws BackEndAdapterException, Exception{
		if (!StringUtils.hasText(response)) return null;
		
		Document doc = getDomFactory().newDocumentBuilder().parse(new ByteArrayInputStream(response.getBytes()));
		
		XPathExpression codePath = getXpath().compile(xpathQuerySubsInfoResultCode);
		XPathExpression msgPath = getXpath().compile(xpathQuerySubsInfoResultDesc);
		String code = null, message = null;
		if (codePath != null && msgPath != null){
			Node codeNode = ((NodeList)codePath.evaluate(doc, XPathConstants.NODESET)).item(0);
			if (codeNode != null) code = codeNode.getTextContent();
			
			Node msgNode  = ((NodeList)msgPath.evaluate(doc, XPathConstants.NODESET)).item(0);
			if (msgNode != null) message = msgNode.getTextContent();
			
			LoggingUtil.debug(logger, "#parseSubscriberData >> status_code= " + code + ", desc= " + message);
			if (!code.equals(successStatusCode)) throw new BackEndAdapterException(code, message);
			
			UPCCSubscriberData subscriber = new UPCCSubscriberData();
			subscriber.setId(subscriberId);
			subscriber.setMsisdn(((NodeList)getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.USRMSISDN")).evaluate(doc, 
					XPathConstants.NODESET)).item(0).getTextContent());
			subscriber.setState(((NodeList)getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.USRSTATE")).evaluate(doc, 
					XPathConstants.NODESET)).item(0).getTextContent());
			subscriber.setHomeServiceZone(((NodeList)getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.USRHOMESRVZONE")).evaluate(doc, 
					XPathConstants.NODESET)).item(0).getTextContent());
			subscriber.setPaymentType(((NodeList)getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.USRPAIDTYPE")).evaluate(doc, 
					XPathConstants.NODESET)).item(0).getTextContent());
			subscriber.setCategory(((NodeList)getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.USRCATEGORY")).evaluate(doc, 
					XPathConstants.NODESET)).item(0).getTextContent());
			subscriber.setStation(((NodeList)getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.USRSTATION")).evaluate(doc, 
					XPathConstants.NODESET)).item(0).getTextContent());
			subscriber.setMasterId(((NodeList)getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.USRMASTERIDENTIFIER")).evaluate(doc, 
					XPathConstants.NODESET)).item(0).getTextContent());
			subscriber.setContactMethod(((NodeList)getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.USRCONTACTMETHOD")).evaluate(doc, 
					XPathConstants.NODESET)).item(0).getTextContent());
			subscriber.setEmailAddress(((NodeList)getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.USREMAILADDRESS")).evaluate(doc, 
					XPathConstants.NODESET)).item(0).getTextContent());
			subscriber.setCycleDate(((NodeList)getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.USRBILLCYCLEDATE")).evaluate(doc, 
					XPathConstants.NODESET)).item(0).getTextContent());
			subscriber.setSubTerminalType(((NodeList)getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.USRSUBTERMINALTYPE")).evaluate(doc, 
					XPathConstants.NODESET)).item(0).getTextContent());
			subscriber.setCreationType(((NodeList)getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.USRCREATETYPE")).evaluate(doc, 
					XPathConstants.NODESET)).item(0).getTextContent());
			subscriber.setMaxOfflineDays(((NodeList)getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.USRMAXOFFLINEDAYS")).evaluate(doc, 
					XPathConstants.NODESET)).item(0).getTextContent());
			subscriber.setLastOfflineTimestamp(((NodeList)getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.USRLATESTOFFLINETIME")).evaluate(doc, 
					XPathConstants.NODESET)).item(0).getTextContent());
			subscriber.setSubNetType(((NodeList)getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.USRSUBNETTYPE")).evaluate(doc, 
					XPathConstants.NODESET)).item(0).getTextContent());
			subscriber.setImsi(((NodeList)getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.USRIMSI")).evaluate(doc, 
					XPathConstants.NODESET)).item(0).getTextContent());
			subscriber.setLanguageId(((NodeList)getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.USRLANGUAGE")).evaluate(doc, 
					XPathConstants.NODESET)).item(0).getTextContent());
			subscriber.setMsisdn(((NodeList)getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.USRSMSMSISDN")).evaluate(doc, 
					XPathConstants.NODESET)).item(0).getTextContent());
			subscriber.setSmsReceiveFlag(((NodeList)getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.USRSMSRECEIVEFLAG")).evaluate(doc, 
					XPathConstants.NODESET)).item(0).getTextContent());
			subscriber.setSecondaryId(((NodeList)getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.USRSECONDIDENTIFIER")).evaluate(doc, 
					XPathConstants.NODESET)).item(0).getTextContent());
			subscriber.setImei(((NodeList)getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.USRIMEI")).evaluate(doc, 
					XPathConstants.NODESET)).item(0).getTextContent());
			subscriber.setBirthDate(((NodeList)getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.USRBIRTHDAY")).evaluate(doc, 
					XPathConstants.NODESET)).item(0).getTextContent());
			subscriber.setGroupId(((NodeList)getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.GRPIDENTIFIER")).evaluate(doc, 
					XPathConstants.NODESET)).item(0).getTextContent());
			
			NodeList sslist = (NodeList)getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscribedservice")).evaluate(doc, XPathConstants.NODESET);
			if (sslist != null){
				for (int i=0; i<sslist.getLength(); i++){
					Node node = sslist.item(i);
					String name = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscribedservice.SRVNAME")).evaluate(node);
					String pkgName = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscribedservice.SRVPKGNAME")).evaluate(node);
					String usageState = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscribedservice.SRVUSAGESTATE")).evaluate(node);
					String subscribedDate = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscribedservice.SRVSUBSCRIBEDATE")).evaluate(node);
					String startDateTime = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscribedservice.SRVSTARTDATETIME")).evaluate(node);
					String overDueDate = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscribedservice.SRVOVERDUEDATE")).evaluate(node);
					String endDateTime = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscribedservice.SRVENDDATETIME")).evaluate(node);
					String roamingType = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscribedservice.SRVROAMINGTYPE")).evaluate(node);
					String subscribedType = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscribedservice.SUBSCRIBEDTYPE")).evaluate(node);
					String status = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscribedservice.SRVSTATUS")).evaluate(node);
					String workDaysTimeSchedule = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscribedservice.SRVWORKDAYSTIMESCHEDULE")).evaluate(node);
					String restDaysTimeSchedule = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscribedservice.SRVRESTDAYSTIMESCHEDULE")).evaluate(node);
					String contactMethod = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscribedservice.SRVCONTACTMETHOD")).evaluate(node);
					String useFlag = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscribedservice.SRVUSEFLAG")).evaluate(node);
					String extAttr1 = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscribedservice.SRVEXATTRSTR1")).evaluate(node);
					
					UPCCSubscribedService subscribedService = new UPCCSubscribedService();
					subscribedService.setContactMethod(contactMethod);
					subscribedService.setEndDateTime(endDateTime);
					subscribedService.setExtendedAttr(extAttr1);
					subscribedService.setName(name);
					subscribedService.setOverDueDate(overDueDate);
					subscribedService.setServicePackageName(pkgName);
					subscribedService.setSubscribedDate(subscribedDate);
					subscribedService.setRestDaysTimeSchedule(restDaysTimeSchedule);
					subscribedService.setRoamingType(roamingType);
					subscribedService.setStartDateTime(startDateTime);
					subscribedService.setStatus(status);
					subscribedService.setSubscriptionType(subscribedType);
					subscribedService.setUsageState(usageState);
					subscribedService.setUseFlag(useFlag);
					subscribedService.setWorkDaysTimeSchedule(workDaysTimeSchedule);
					
					subscriber.getSubscribedServices().add(subscribedService);
				}
			}
			
			NodeList splist = (NodeList)getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.servicepackage")).evaluate(doc, XPathConstants.NODESET);
			if (splist != null){
				for (int i=0; i<splist.getLength(); i++){
					Node node = splist.item(i);
					String name = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.servicepackage.SRVPKGNAME")).evaluate(node);
					String subscribedDate = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.servicepackage.SRVPKGSUBSCRIBEDATE")).evaluate(node);
					String startDateTime = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.servicepackage.SRVPKGSTARTDATETIME")).evaluate(node);
					String overDueDate = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.servicepackage.SRVPKGOVERDUEDATE")).evaluate(node);
					String endDateTime = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.servicepackage.SRVPKGENDDATETIME")).evaluate(node);
					String roamingType = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.servicepackage.SRVPKGROAMINGTYPE")).evaluate(node);
					String contactMethod = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.servicepackage.SRVPKGCONTACTMETHOD")).evaluate(node);
					
					UPCCServicePackage servicePkg = new UPCCServicePackage();
					servicePkg.setContactMethod(contactMethod);
					servicePkg.setEndDateTime(endDateTime);
					servicePkg.setName(name);
					servicePkg.setOverDueDate(overDueDate);
					servicePkg.setSubscribedDate(subscribedDate);
					servicePkg.setRoamingType(roamingType);
					servicePkg.setStartDateTime(startDateTime);
					
					LoggingUtil.debug(logger, "#UPCCServicePackage= " + servicePkg);
					subscriber.getServicePackages().add(servicePkg);
				}
			}
			
			NodeList quotalist = (NodeList)getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscriberquota")).evaluate(doc, XPathConstants.NODESET);
			if (quotalist != null){
				for (int i=0; i<quotalist.getLength(); i++){
					Node node = quotalist.item(i);
					String name = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscriberquota.QTANAME")).evaluate(node);
					String serviceName = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscriberquota.SRVNAME")).evaluate(node);
					String value = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscriberquota.QTAVALUE")).evaluate(node);
					String balance = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscriberquota.QTABALANCE")).evaluate(node);
					String consumption = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscriberquota.QTACONSUMPTION")).evaluate(node);
					String qclass = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscriberquota.QTACLASS")).evaluate(node);
					String status = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscriberquota.QTASTATUS")).evaluate(node);
					String resetDateTime = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscriberquota.QTARSTDATETIME")).evaluate(node);
					String flag = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscriberquota.QTAFLAG")).evaluate(node);
					String upconsumption = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscriberquota.QTAUPCONSUMPTION")).evaluate(node);
					String downconsumption = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscriberquota.QTADOWNCONSUMPTION")).evaluate(node);
					String startDateTime = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscriberquota.QTASTARTDATETIME")).evaluate(node);
					String timestamp = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscriberquota.QTATIMESTAMP")).evaluate(node);
					String customInitialValue = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscriberquota.QTACUSTOMINITIALVALUE")).evaluate(node);
					String customStatus = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscriberquota.QTACUSTOMSTATUS")).evaluate(node);
					String selfConsumption = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscriberquota.SELFCONSUMPTION")).evaluate(node);
					String selfPreUpload = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscriberquota.SELFPREUPLOAD")).evaluate(node);
					String selfPreDownload = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscriberquota.SELFPREDOWNLOAD")).evaluate(node);
					
					UPCCSubscriberQuota quota = new UPCCSubscriberQuota();
					quota.setName(name);
					quota.setServiceName(serviceName);
					quota.setBalance(balance);
					quota.setConsumption(consumption);
					quota.setQuotaClass(qclass);
					quota.setStatus(status);
					quota.setResetDateTime(resetDateTime);
					quota.setFlag(flag);
					quota.setUplinkVolume(upconsumption);
					quota.setDownlinkVolume(downconsumption);
					quota.setStartDateTime(startDateTime);
					quota.setLastUpdateTimestamp(timestamp);
					quota.setCustomInitialValue(customInitialValue);
					quota.setCustomStatus(customStatus);
					quota.setSelfConsumption(selfConsumption);
					quota.setSelfPreUpload(selfPreUpload);
					quota.setSelfPreDownload(selfPreDownload);
					quota.setValue(value);
					
//					LoggingUtil.debug(logger, "#UPCCSubscriberQuota= " + quota);
					subscriber.getQuotas().add(quota);
				}
			}
			
			NodeList accountlist = (NodeList)getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscriberaccount")).evaluate(doc, XPathConstants.NODESET);
			if (accountlist != null){
				for (int i=0; i<accountlist.getLength(); i++){
					Node node = accountlist.item(i);
					String value = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscriberaccount.ACTVALUE")).evaluate(node);
					String balance = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscriberaccount.ACTBALANCE")).evaluate(node);
					String consumption = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscriberaccount.ACTCONSUMPTION")).evaluate(node);
					String privilege = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscriberaccount.ACTPRIVILEGE")).evaluate(node);
					String expDate = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscriberaccount.ACTEXPIREDATE")).evaluate(node);
					String status = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscriberaccount.ACTSTATUS")).evaluate(node);
					String personalizedValue = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscriberaccount.ACTPERSONALIZEDVALUE")).evaluate(node);
					String name = getXpath().compile(configs.getProperty("upcc.resp.xpath.querysubsinfo.subscriberaccount.ACCOUNTNAME")).evaluate(node);
					
					UPCCSubscriberAccount account = new UPCCSubscriberAccount();
					account.setValue(value);
					account.setBalance(balance);
					account.setConsumption(consumption);
					account.setPrivilege(privilege);
					account.setExpiryDate(expDate);
					account.setStatus(status);
					account.setPersonalizedValue(personalizedValue);
					account.setName(name);
					
					LoggingUtil.debug(logger, "#UPCCAccount= " + account);
					subscriber.getAccounts().add(account);
				}
			}
			return subscriber;
		}

		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.adapter.BackEndAdapter#shutdown()
	 */
	@Override
	public void shutdown() {
		logout();
		setRunning(false);
		httpSessionManager.shutdown();
	}
	
	private DocumentBuilderFactory getDomFactory(){
		if (this.domFactory == null){
			this.domFactory = DocumentBuilderFactory.newInstance();
		}
		return domFactory;
	}
	
	private XPath getXpath(){
		if (this.xpath == null){
			xpath = XPathFactory.newInstance().newXPath();
		}
		return xpath;
	}
	
	public UPCCRequestStatus getRequestStatusFromResponse(String response, String xpathStatusCode, String xpathStatusMsg){
		if (!StringUtils.hasText(response)) return null;
		
		UPCCRequestStatus requestStatus = new UPCCRequestStatus();
		
		LoggingUtil.debug(logger, "#getRequestStatusFromResponse >> parsing request status from response= " + response);
		try {
			Document doc = getDomFactory().newDocumentBuilder().parse(new ByteArrayInputStream(response.getBytes()));
			XPathExpression codePath = getXpath().compile(xpathStatusCode);
			XPathExpression msgPath = getXpath().compile(xpathStatusMsg);
			String code = null, message = null;
			if (codePath != null && msgPath != null){
				Node codeNode = ((NodeList)codePath.evaluate(doc, XPathConstants.NODESET)).item(0);
				if (codeNode != null) code = codeNode.getTextContent();
				
				Node msgNode  = ((NodeList)msgPath.evaluate(doc, XPathConstants.NODESET)).item(0);
				if (msgNode != null) message = msgNode.getTextContent();
				
				requestStatus.setCode(code);
				requestStatus.setMessage(message);
			}
			
		} catch (Exception e) {
			logger.error("#getRequestStatusFromResponse >> error occured when parsing XML response", e);
		}
		return requestStatus;
	}
	
	/**
	 * @return the lastConnectedTimestamp
	 */
	public long getLastConnectedTimestamp() {
		return lastConnectedTimestamp;
	}

	/**
	 * @param lastConnectedTimestamp the lastConnectedTimestamp to set
	 */
	public void setLastConnectedTimestamp(long lastConnectedTimestamp) {
		this.lastConnectedTimestamp = lastConnectedTimestamp;
	}

	/**
	 * @return the connected
	 */
	public boolean isConnected() {
		return connected;
	}

	/**
	 * @param connected the connected to set
	 */
	public void setConnected(boolean connected) {
		this.connected = connected;
	}

	/**
	 * @return the running
	 */
	public boolean isRunning() {
		return running;
	}

	/**
	 * @param running the running to set
	 */
	public void setRunning(boolean running) {
		this.running = running;
	}

	public String buildLoginRequest(){
		loginRequest = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
				+ "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:rm=\"rm:soap\">"
				+ "<soapenv:Header/>" + "<soapenv:Body>" + "<rm:LGI>" + "<inPara>" + "<Login>" + "<attribute>"
				+ "<key>OPNAME</key>" + "<value>P_USER_NAME</value>" + "</attribute>" + "<attribute>" + "<key>PWD</key>"
				+ "<value>P_PASSWORD</value>" + "</attribute>" + "</Login>" + "</inPara>" + "</rm:LGI>"
				+ "</soapenv:Body>" + "</soapenv:Envelope>";
		
		return loginRequest;
	}
	
	public String buildLogoutRequest(){
		
		logoutRequest = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:rm=\"rm:soap\">"
				+ "<soapenv:Header/>" + "<soapenv:Body>" + "<rm:LGO></rm:LGO>" + "</soapenv:Body>"
				+ "</soapenv:Envelope>";
		
		return logoutRequest;
	}
	
	//TODO get the key element value for subscriberQuota
	private String buildGetSubscriberInfoRequest(){
		getSubscriberInfoRequest = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:rm=\"rm:soap\">"
				+ "<soapenv:Header/>" + "<soapenv:Body>" + "<rm:getSubscriberAllInf>" + "<inPara>" + "<subscriber>"
				+ "<attribute>" + "<key>usrIdentifier</key>" + "<value>P_SUBS_ID</value>" + "</attribute>"
				+ "</subscriber>" + "</inPara>" + "</rm:getSubscriberAllInf>" + "</soapenv:Body>"
				+ "</soapenv:Envelope>";
	
		return getSubscriberInfoRequest;
	}

    public void keepAlive(){
    	if (isConnected()){
//    		LoggingUtil.debug(logger, "#keepAlive >> Sending keep-alive request to UPCC (" + sessionURL + ")");
    		Header[] headers =  new Header[]{new Header("Connection", "Keep-Alive") };
    		HttpResponseWrapper response = httpSessionManager.post(sessionURL, "", "text/xml", headers);
    		if (response != null){
    			if (response.getCode() == HttpStatus.SC_OK || response.getCode() == HttpStatus.SC_TEMPORARY_REDIRECT){
        			if (response.getContent().indexOf(this.sessionTimeoutMsg) >= 0){
            			logger.error("#keepAlive >> Connection to UPCC has been aborted due to session timeout");
            			setConnected(false);
        			}else{
        				setLastConnectedTimestamp(System.currentTimeMillis());
        			}
        		}else{
        			LoggingUtil.info(logger, "#keepAlive >> Disconnected from UPCC with status_code= " + response.getCode());
        			setConnected(false);
        		}
    		}else{
    			logger.error("#keepAlive >> Disconnected from UPCC, receiving empty response!");
//    			setConnected(false); 
    			login(); //force login
    		}
    	}else{
    		login(); //force login
    	}
    }
    
    final class SessionKeeper extends Thread{

		/* (non-Javadoc)
		 * @see java.lang.Thread#run()
		 */
		@Override
		public void run() {
			while (isRunning()){
		    	long timeElapsed = System.currentTimeMillis() - getLastConnectedTimestamp();
		    	if (timeElapsed >= reconnectInterval){
					keepAlive();
					
		    	}else if (!isConnected()){
		    		LoggingUtil.info(logger, "Disconnected from UPCC, attempting to reconnect now...");
		    		int attempt = 0;
		    		while (!isConnected() && attempt < maxLoginAttempt){
		    			login();
		    			attempt++;
		    			try {
		    				Thread.sleep(1000);
		    			} catch (InterruptedException e) {}
		    		}
		    		if (isConnected()){
		    			LoggingUtil.info(logger, "Successfully reconnected to UPCC after " + attempt + " attempt(s).");
		    		}else{
		    			LoggingUtil.warn(logger, "Could not login to UPCC after " + attempt + " attempts, will retry in a few moments...", null);
		    		}
		    	}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {}
			}
		}
    }
    
    final class UPCCRequestStatus{
    	private String code;
    	private String message;
    	
    	public UPCCRequestStatus(){ }
    	
    	public UPCCRequestStatus(String code, String message){
    		this.code = code;
    		this.message = message;
    	}

		/**
		 * @return the code
		 */
		public String getCode() {
			return code;
		}

		/**
		 * @param code the code to set
		 */
		public void setCode(String code) {
			this.code = code;
		}

		/**
		 * @return the message
		 */
		public String getMessage() {
			return message;
		}

		/**
		 * @param message the message to set
		 */
		public void setMessage(String message) {
			this.message = message;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("UPCCRequestStatus [code=");
			builder.append(code);
			builder.append(", message=");
			builder.append(message);
			builder.append("]");
			return builder.toString();
		}
    }
    
}
