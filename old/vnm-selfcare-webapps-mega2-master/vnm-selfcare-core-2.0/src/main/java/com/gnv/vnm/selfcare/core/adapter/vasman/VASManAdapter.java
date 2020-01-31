/**
 * 
 */
package com.gnv.vnm.selfcare.core.adapter.vasman;

import java.io.File;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.gnv.vnm.selfcare.core.adapter.BackEndAdapter;
import com.gnv.vnm.selfcare.core.adapter.BackEndAdapterException;
import com.gnv.vnm.selfcare.core.adapter.BackEndAdapterRequest;
import com.gnv.vnm.selfcare.core.adapter.BackEndAdapterResponse;
import com.gnv.vnm.selfcare.core.adapter.BackEndConnection;
import com.gnv.vnm.selfcare.core.adapter.JaxwsHandlerResolver;
import com.gnv.vnm.selfcare.core.adapter.WebServiceBackEndConnection;
import com.gnv.vnm.selfcare.core.adapter.vasman.ws.ArrayOfBalanceRequest;
import com.gnv.vnm.selfcare.core.adapter.vasman.ws.ArrayOfString;
import com.gnv.vnm.selfcare.core.adapter.vasman.ws.BalanceRequest;
import com.gnv.vnm.selfcare.core.adapter.vasman.ws.CheckVasStatusReq;
import com.gnv.vnm.selfcare.core.adapter.vasman.ws.MemberManagementReq;
import com.gnv.vnm.selfcare.core.adapter.vasman.ws.MemberManagementResp;
import com.gnv.vnm.selfcare.core.adapter.vasman.ws.ObjectFactory;
import com.gnv.vnm.selfcare.core.adapter.vasman.ws.ProvisioningCampaignReq;
import com.gnv.vnm.selfcare.core.adapter.vasman.ws.ProvisioningDynamicServiceReq;
import com.gnv.vnm.selfcare.core.adapter.vasman.ws.ProvisioningResp;
import com.gnv.vnm.selfcare.core.adapter.vasman.ws.VasDetailResp;
import com.gnv.vnm.selfcare.core.adapter.vasman.ws.WSVasnew;
import com.gnv.vnm.selfcare.core.adapter.vasman.ws.WSVasnewPortType;
import com.gnv.vnm.selfcare.core.enums.RequestStatus;
import com.gnv.vnm.selfcare.core.utils.AppUtils;
import com.gnv.vnm.selfcare.core.utils.LoggingUtil;

/**
 * @author nandipinto
 *
 */
public class VASManAdapter extends BackEndAdapter {

	public static final int ACTIVATE_CMD 		= 1;
	public static final int DEACTIVATE_CMD 		= 3;
	
	public static final String ADD_MEMBER_ACTION = "add-member";
	public static final String DEL_MEMBER_ACTION	= "remove-member";
	public static final String QRY_MEMBER_ACTION	= "check-member";
	
	public static final double ONE_MB = 1048576;
	
	private static final Logger logger = LoggerFactory.getLogger(VASManAdapter.class);

	private static final QName SERVICE_NAME 	= new QName("http://vasman.elcom.com", "WSVasnew");
	
	private WSVasnewPortType endPoint = null;
	private WSVasnew service = null; 
	private ObjectFactory objFactory = new ObjectFactory();
	
	@Override
	public void init(BackEndConnection connection) throws BackEndAdapterException {
		
		try {
			this.connection = connection;
			WebServiceBackEndConnection wsconn = (WebServiceBackEndConnection)this.connection;
			
			/*
			URL url = null;
			String wsdl = wsconn.getWsdlLocation();
			if (StringUtils.hasText(wsdl)) {
				url = new URL(connection.getProtocol() + "://"+  connection.getHost() + ":" + connection.getPort() + "/" + wsdl);
			} else {
				url = WSVasnew.class.getClassLoader().getResource("wsdl/WSVasnew.wsdl");
			}

			WSVasnew service = new WSVasnew(url, SERVICE_NAME);
			endPoint = service.getWSVasnewHttpPort();
			
			try {
				if (connection.getConnectionTimeOut() > 0){
					((BindingProvider) endPoint).getRequestContext().put("com.sun.xml.internal.ws.request.timeout", connection.getConnectionTimeOut() * 1000);
				}
			} catch (Exception e) {
				logger.error("#getEndPoint --- error setting connection timeout: " + e.getMessage());
			}
			*/
			endPoint = getEndPoint();
			LoggingUtil.debug(logger, "#init -- SOAP message logging enabled= " + wsconn.isLogSoapMessage());
			if (wsconn.isLogSoapMessage()){
				
				String catalinaHome = System.getProperty("catalina.base");
				if (catalinaHome != null){
					File logDir = new File(catalinaHome + File.separator + "logs");
					if (!logDir.exists()) logDir.mkdir();
					File logFile = new File(logDir, "vasman-soap-" + AppUtils.dateToString(new Date(), "yyyyMMdd") + ".log");
					service.setHandlerResolver(new JaxwsHandlerResolver(new FileOutputStream(logFile, true)));
				}else{
					service.setHandlerResolver(new JaxwsHandlerResolver(System.out));
				}
			}

		} catch (Exception e) {
			logger.error("#init >> error initiating VASManager adapter!", e);
			throw new BackEndAdapterException(e);
		}
	}

	private WSVasnewPortType getEndPoint() throws MalformedURLException {
		URL url = null;
		WebServiceBackEndConnection wsconn = (WebServiceBackEndConnection)this.connection;
		String wsdl = wsconn.getWsdlLocation();
		if (StringUtils.hasText(wsdl)) {
			url = new URL(connection.getProtocol() + "://"+  connection.getHost() + ":" + connection.getPort() + "/" + wsdl);
		} else {
			url = WSVasnew.class.getClassLoader().getResource("wsdl/WSVasnew.wsdl");
		}

		service = new WSVasnew(url, SERVICE_NAME);
		endPoint = service.getWSVasnewHttpPort();
		
		try {
			if (connection.getConnectionTimeOut() > 0){
				((BindingProvider) endPoint).getRequestContext().put("com.sun.xml.internal.ws.request.timeout", connection.getConnectionTimeOut() * 1000);
			}
		} catch (Exception e) {
			logger.error("#getEndPoint --- error setting connection timeout: " + e.getMessage());
		}
		return endPoint;
	}
	
	
	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.adapter.BackEndAdapter#reconnect(com.gnv.vnm.selfcare.core.adapter.BackEndConnection)
	 */
	@Override
	public void reconnect(BackEndConnection connection) throws BackEndAdapterException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BackEndAdapterResponse sendRequest(BackEndAdapterRequest request) {
		
		BackEndAdapterResponse bar = new BackEndAdapterResponse();
		
		try {
			if (endPoint == null) {
//				bar.setStatus(RequestStatus.FAIL);
//				return bar;
				endPoint = getEndPoint();
			}

			if (request instanceof VASManProvisioningRequest) {
				handleProvisioningRequest((VASManProvisioningRequest) request, bar);
				
			} else if (request instanceof VASManSubscriptionQueryRequest) {
				handleSubscriptionQueryRequest((VASManSubscriptionQueryRequest) request, bar);
				
			} else if (request instanceof VASManDataSharingRequest) {
				handleDataSharingRequest((VASManDataSharingRequest)request, bar);
				
			} else if (request instanceof VASManSelfPackageRequest) {
				handleSelfPackageRequest((VASManSelfPackageRequest)request, bar);
			}
			
		} catch (Exception e) {
			bar.setStatus(RequestStatus.FAIL);
			bar.setResponseDescription(e.getMessage());
			
			logger.error("#sendRequest >> error processing request", e);
		}
		return bar;
	}
	
	private void handleProvisioningRequest(VASManProvisioningRequest req, BackEndAdapterResponse bar) {
		LoggingUtil.debug(logger, String.format(
				"#package_subscription --- sending provisioning request to VASMan (msisdn = %s, package_id= %s, command_id= %s)",
				req.getMsisdn(), req.getPackageId(), "" + req.getCommandId()));
		
		ProvisioningCampaignReq serviceReq = objFactory.createProvisioningCampaignReq();
		serviceReq.setUser(objFactory.createProvisioningCampaignReqUser(connection.getUserName()));
		serviceReq.setPass(objFactory.createProvisioningCampaignReqPass(connection.getCredential()));

		serviceReq.setNCmdID(req.getCommandId());
		serviceReq.setMdn(objFactory.createProvisioningCampaignReqMdn(req.getMsisdn()));
		serviceReq.setNVasID(objFactory.createProvisioningCampaignReqNVasID(req.getPackageId()));
		
		ProvisioningResp resp = endPoint.provisioningWithCampaign(serviceReq);
		
		LoggingUtil.debug(logger, String.format(
				"#package_subscription --- receiving response from VASMAN (msisdn = %s, package_id= %s, command_id= %s, resp_code= %s)",
				req.getMsisdn(), req.getPackageId(), "" + req.getCommandId(), resp.getErrorCode().getValue()));
		
		bar.setStatus(resp.getErrorCode().getValue().equals(VASManErrorMessage.SUCCESS.code()) ? RequestStatus.SUCCESS : RequestStatus.FAIL);
		bar.setResponseCode(resp.getErrorCode().getValue());
		bar.setResponseDescription(resp.getErrorDetail().getValue());
		bar.setResult(resp);
	}
	
	private void handleSubscriptionQueryRequest(VASManSubscriptionQueryRequest req, BackEndAdapterResponse bar) {
		LoggingUtil.debug(logger,
				String.format(
						"#query_subscription --- sending query request to VASMan (msisdn = %s, package_id= %s)",
						req.getMsisdn(), req.getPackageId()));
		
		CheckVasStatusReq statusReq = objFactory.createCheckVasStatusReq();
		statusReq.setMdn(objFactory.createCheckVasStatusReqMdn(req.getMsisdn()));
		
		if (StringUtils.hasText(req.getPackageId())) {
			Integer nvasId = 0;
			try {
				nvasId = Integer.parseInt(req.getPackageId());
			} catch (Exception e) {}
			statusReq.setNVasID(nvasId);
		}
		statusReq.setUser(objFactory.createCheckVasStatusReqUser(connection.getUserName()));
		statusReq.setPass(objFactory.createCheckVasStatusReqPass(connection.getCredential()));

		VasDetailResp resp = endPoint.vasDetail(statusReq);
		
		LoggingUtil.debug(logger, String.format(
				"#query_subscription --- receiving response from VASMan (msisdn = %s, package_id= %s, resp_code= %s)",
				req.getMsisdn(), req.getPackageId(), resp.getErrorCode().getValue()));
		
		bar.setStatus(resp.getErrorCode().getValue().equals(VASManErrorMessage.SUCCESS.code()) ? RequestStatus.SUCCESS : RequestStatus.FAIL);
		bar.setResponseCode(resp.getErrorCode().getValue());
		bar.setResponseDescription(resp.getErrorDetail().getValue());
		
		if (resp.getVasPro().getValue() != null) {
			bar.setResult(resp.getVasPro().getValue().getVasProductDetail());
		}
	}
	
	private void handleDataSharingRequest(VASManDataSharingRequest req, BackEndAdapterResponse bar) {
		//need to call 2 API

		LoggingUtil.debug(logger, String.format(
				"#data_sharing(1) --- sending provisioning request to VASMan (msisdn = %s, package_id= %s, command_id= %s)",
				req.getMsisdn(), req.getPackageId(), "" + req.getCommandId()));
		
		ProvisioningCampaignReq serviceReq = objFactory.createProvisioningCampaignReq();
		serviceReq.setUser(objFactory.createProvisioningCampaignReqUser(connection.getUserName()));
		serviceReq.setPass(objFactory.createProvisioningCampaignReqPass(connection.getCredential()));

		serviceReq.setNCmdID(req.getCommandId());
		serviceReq.setMdn(objFactory.createProvisioningCampaignReqMdn(req.getMsisdn()));
		serviceReq.setNVasID(objFactory.createProvisioningCampaignReqNVasID(req.getPackageId()));
		
		ProvisioningResp provResp = endPoint.provisioningWithCampaign(serviceReq);
		
		LoggingUtil.debug(logger, String.format(
				"#data_sharing(1) --- receiving response from VASMan (msisdn = %s, package_id= %s, command_id= %s, resp_code= %s)",
				req.getMsisdn(), req.getPackageId(), "" + req.getCommandId(), provResp.getErrorCode().getValue()));

		if (provResp != null && provResp.getErrorCode().getValue().equals(VASManErrorMessage.SUCCESS.code()) && req.getCommandId() == ACTIVATE_CMD) {
			//not removing member if initiator deactivate data_sharing subscription
			
			MemberManagementReq memberMgmtReq = objFactory.createMemberManagementReq();
			memberMgmtReq.setUser(objFactory.createProvisioningCampaignReqUser(connection.getUserName()));
			memberMgmtReq.setPass(objFactory.createProvisioningCampaignReqPass(connection.getCredential()));

			memberMgmtReq.setAction(objFactory.createMemberManagementReqAction(ADD_MEMBER_ACTION));
			LoggingUtil.debug(logger, String.format(
					"#data_sharing(2) --- adding member (msisdn = %s, package_id= %s, member= %s)",
					req.getMsisdn(), req.getPackageId(), req.getMembers().toString()));

			ArrayOfString arrayOfString = objFactory.createArrayOfString();
			for (String member : req.getMembers()) {
//				arrayOfString.getString().add(AppUtils.prependCountryCodeToMsisdn(member, AppDefaultValues.COUNTRY_CODE));
				arrayOfString.getString().add(member);
			}
			memberMgmtReq.setMembers(objFactory.createMemberManagementReqMembers(arrayOfString));

			memberMgmtReq.setMdn(objFactory.createProvisioningCampaignReqMdn(req.getMsisdn()));
			memberMgmtReq.setNVasID(objFactory.createProvisioningCampaignReqNVasID(req.getPackageId()));
			
			MemberManagementResp memberMgmtResp = endPoint.memberManagement(memberMgmtReq);
			LoggingUtil.debug(logger, String.format(
					"#data_sharing(2) --- member mgmt (msisdn = %s, package_id= %s, result_code= %s)",
					req.getMsisdn(), req.getPackageId(), memberMgmtResp.getErrorCode().getValue()));
			
			if (memberMgmtResp.getErrorCode().getValue().equals(VASManErrorMessage.SUCCESS.code())) {
				bar.setStatus(RequestStatus.SUCCESS );
				bar.setResult(memberMgmtResp.getMembers().getValue().getString());
				
			} else {
				bar.setStatus(RequestStatus.FAIL );
				//roll-back package subscription if adding member failed
				LoggingUtil.warn(logger, String.format(
						"#data_sharing(3) --- failed to add members for data-sharing, rolling back transaction (msisdn = %s, package_id= %s)",
						req.getMsisdn(), req.getPackageId()), null);
				
				try {
					serviceReq.setNCmdID(DEACTIVATE_CMD);
					ProvisioningResp rollbackResp = endPoint.provisioningWithCampaign(serviceReq);
					LoggingUtil.info(logger, String.format(
							"#data_sharing(3) --- roll-back response from VASMan (msisdn = %s, package_id= %s, resp_code= %s)",
							req.getMsisdn(), req.getPackageId(), rollbackResp.getErrorCode().getValue()));

				} catch (Exception e) {
					logger.error(String.format(
							"#data_sharing(3) --- error occured when rolling back trx to VASMan (msisdn = %s, package_id= %s)",
							req.getMsisdn(), req.getPackageId()), e);
				}
			}
			
			bar.setResponseCode(memberMgmtResp.getErrorCode().getValue());
			bar.setResponseDescription(memberMgmtResp.getErrorDetail().getValue());
			
		} else {
			bar.setStatus(RequestStatus.FAIL );
			if (provResp != null) {
				bar.setResponseCode(provResp.getErrorCode().getValue());
				bar.setResponseDescription(provResp.getErrorDetail().getValue());
			}
		}
	}
	
	private void handleSelfPackageRequest(VASManSelfPackageRequest req, BackEndAdapterResponse bar) {
		
		LoggingUtil.debug(logger, "#selfpackage --- sending request to VASMan, params= " + req);
		
		
		ProvisioningDynamicServiceReq serviceReq = objFactory.createProvisioningDynamicServiceReq();

		serviceReq.setUser(objFactory.createProvisioningCampaignReqUser(connection.getUserName()));
		serviceReq.setPass(objFactory.createProvisioningCampaignReqPass(connection.getCredential()));
		serviceReq.setCmdID(ACTIVATE_CMD);
		serviceReq.setMdn(objFactory.createProvisioningDynamicServiceReqMdn(req.getMsisdn()));
		serviceReq.setVasID(objFactory.createProvisioningDynamicServiceReqVasID(req.getPackageId()));
		serviceReq.setSDescription(objFactory.createProvisioningDynamicServiceReqSDescription(req.getDescription()));
		serviceReq.setExtendDate((long)req.getNumOfDays());
		serviceReq.setChargingAmount(req.getChargingAmount());
		//TODO remove this later
		//serviceReq.setDataAmount(ONE_MB);
		serviceReq.setDataAmount(0.0);
		
		ArrayOfBalanceRequest arrBalance = objFactory.createArrayOfBalanceRequest();
		for (VASManSelfPackageBalance bal : req.getBalanceList()) {
			BalanceRequest br = objFactory.createBalanceRequest();
			br.setBalanceName(objFactory.createBalanceRequestBalanceName(bal.getName()));
			br.setBalanceAmount(bal.getAmount());
			
			arrBalance.getBalanceRequest().add(br);
		}
		serviceReq.setListBalance(objFactory.createProvisioningDynamicServiceReqListBalance(arrBalance));
		
		ProvisioningResp response = endPoint.dynamicServiceProvisioning(serviceReq);
		if (response != null) {
			LoggingUtil.debug(logger,
					String.format("#selfpackage --- receiving response from VASMan (msisdn = %s, package_id= %s, resp_code= %s, resp_msg= %s)", 
							req.getMsisdn(), req.getPackageId(), response.getErrorCode().getValue(), response.getErrorDetail().getValue()));
			
			bar.setResponseCode(response.getErrorCode().getValue());
			bar.setResponseDescription(response.getErrorDetail().getValue());
			bar.setStatus(response.getErrorCode().getValue().equals(VASManErrorMessage.SUCCESS.code()) ? RequestStatus.SUCCESS : RequestStatus.FAIL);
			
		} else {
			bar.setStatus(RequestStatus.FAIL);
		}
	}
	
	@Override
	public void login() {
		//do nothing
	}

	@Override
	public void logout() {
		//do nothing
	}

	@Override
	public boolean isConnected() {
		return true;
	}

	@Override
	public void shutdown() {
		// do nothing
	}

}
