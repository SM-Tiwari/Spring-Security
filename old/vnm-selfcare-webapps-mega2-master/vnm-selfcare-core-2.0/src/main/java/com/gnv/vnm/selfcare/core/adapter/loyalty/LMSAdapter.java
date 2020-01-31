/**
 * LMSAdapter.java
 */
package com.gnv.vnm.selfcare.core.adapter.loyalty;

import java.io.File;
import java.io.FileOutputStream;
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
import com.gnv.vnm.selfcare.core.adapter.loyalty.ws.LoyaltyCheckpointResp;
import com.gnv.vnm.selfcare.core.adapter.loyalty.ws.LoyaltyRedeempointReq;
import com.gnv.vnm.selfcare.core.adapter.loyalty.ws.LoyaltyReq;
import com.gnv.vnm.selfcare.core.adapter.loyalty.ws.LoyaltyResp;
import com.gnv.vnm.selfcare.core.adapter.loyalty.ws.LoyaltyWS;
import com.gnv.vnm.selfcare.core.adapter.loyalty.ws.LoyaltyWSPortType;
import com.gnv.vnm.selfcare.core.adapter.loyalty.ws.ObjectFactory;
import com.gnv.vnm.selfcare.core.enums.RequestStatus;
import com.gnv.vnm.selfcare.core.utils.AppUtils;
import com.gnv.vnm.selfcare.core.utils.LoggingUtil;

/**
 * @author nandipinto
 *
 */
public class LMSAdapter extends BackEndAdapter {
	private static final Logger logger = LoggerFactory.getLogger(LMSAdapter.class);

	public static final String ADD_POINT_KEYWORD = "ADDPOINT";
	public static final String SUB_POINT_KEYWORD = "SUBSPOINT";
	
//	private static final QName SERVICE_NAME = new QName("http://loyalty.elcom.com", "LoyaltyWS");
	private static final QName SERVICE_NAME = new QName("http://iwebservice.nms.com", "loyaltyWS");
	
	public static final String RESP_CODE_SUCCESS	= "1";
	public static final String RESP_MSG_SUCCESS	= "success";
	
	private LoyaltyWS loyaltyWS;
	private LoyaltyWSPortType port;
	
	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.adapter.BackEndAdapter#init(com.gnv.vnm.selfcare.core.adapter.BackEndConnection)
	 */
	@Override
	public void init(BackEndConnection connection) throws BackEndAdapterException {
		try {
			
			URL url = null;
			this.connection = connection;
			WebServiceBackEndConnection wsconn = (WebServiceBackEndConnection)this.connection;
			String wsdl = wsconn.getWsdlLocation();
			if (StringUtils.hasText(wsdl)) {
				url = new URL(connection.getProtocol() + "://" +  connection.getHost() + ":" + connection.getPort() + "/" + wsdl);
			} else {
				url = this.getClass().getClassLoader().getResource("wsdl/LoyaltyWS.wsdl");
			}
			loyaltyWS = new LoyaltyWS(url, SERVICE_NAME);
			
			port = loyaltyWS.getLoyaltyWSHttpPort();  
			if (connection.getConnectionTimeOut() > 0){
				try {
					if (connection.getConnectionTimeOut() > 0){
						((BindingProvider) port).getRequestContext().put("com.sun.xml.internal.ws.request.timeout", connection.getConnectionTimeOut() * 1000);
					}
				} catch (Exception e) {
					logger.error("#getEndPoint --- error setting connection timeout: " + e.getMessage());
				}
			}
//			((BindingProvider)port).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, 
//					connection.getProtocol() + "://"  + connection.getHost() + ":" + connection.getPort() + "/LoyaltyWS/services/LoyaltyWS");   

			LoggingUtil.debug(logger, "#init -- SOAP message logging enabled= " + wsconn.isLogSoapMessage());
			if (wsconn.isLogSoapMessage()){
				
				String catalinaHome = System.getProperty("catalina.base");
				if (catalinaHome != null){
					File logDir = new File(catalinaHome + File.separator + "logs");
					if (!logDir.exists()) logDir.mkdir();
					File logFile = new File(logDir, "loyalty-soap-" + AppUtils.dateToString(new Date(), "yyyyMMdd") + ".log");
					loyaltyWS.setHandlerResolver(new JaxwsHandlerResolver(new FileOutputStream(logFile, true)));
				}else{
					loyaltyWS.setHandlerResolver(new JaxwsHandlerResolver(System.out));
				}
			}
		} catch (Exception e) {
			logger.error("#init >> error initiating LMSAdapter!", e);
			throw new BackEndAdapterException(e);
		}
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
		//do nothing
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.adapter.BackEndAdapter#logout()
	 */
	@Override
	public void logout() {
		//do nothing
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.adapter.BackEndAdapter#isConnected()
	 */
	@Override
	public boolean isConnected() {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.adapter.BackEndAdapter#sendRequest(com.gnv.vnm.selfcare.core.adapter.BackEndAdapterRequest)
	 */
	@Override
	public BackEndAdapterResponse sendRequest(BackEndAdapterRequest request) {
		BackEndAdapterResponse bar = new BackEndAdapterResponse();
		int point = 0;
		if (port == null) {
			bar.setStatus(RequestStatus.FAIL);
			bar.setResponseDescription("Connection to LMS could not be made!");
			
			return bar;
		}
		try {
//			port = loyaltyWS.getLoyaltyWSHttpPort();  
//			((BindingProvider)proxy).getRequestContext().  
//		       put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://new/endpointaddress");   
			
			ObjectFactory objectFactory = new ObjectFactory();
			
			if (request instanceof CheckPointRequest){
				CheckPointRequest cpr = (CheckPointRequest)request;
				
				LoggingUtil.debug(logger, "#sendRequest --- retrieving point information from LMS, MSISDN= " + cpr.getMsisdn());
				
				LoyaltyReq loyaltyReq = objectFactory.createLoyaltyReq();
				loyaltyReq.setIsdn(objectFactory.createLoyaltyCheckpointRespIsdn(cpr.getMsisdn()));
				loyaltyReq.setUser(objectFactory.createLoyaltyRedeempointReqUser(this.connection.getUserName()));
				loyaltyReq.setPassword(objectFactory.createLoyaltyRedeempointReqPassword(this.connection.getCredential()));
				
				LoyaltyCheckpointResp checkPointResp = port.checkPoint(loyaltyReq);
				String respCode = checkPointResp.getErrorCode().getValue();
				String respMsg = checkPointResp.getErrorDetail().getValue();

				LoggingUtil.debug(logger, "#sendRequest --- receiving response= " + checkPointResp);
				
				if (respCode.equals(RESP_CODE_SUCCESS) || respMsg.equalsIgnoreCase(RESP_MSG_SUCCESS)){
					bar.setStatus(RequestStatus.SUCCESS);
					point = checkPointResp.getPoint() != null ? checkPointResp.getPoint().intValue() : 0;
				}else{
					bar.setStatus(RequestStatus.FAIL);
				}
				bar.setResult(point);
				bar.setResponseCode(respCode);
				bar.setResponseDescription(respMsg);
				
			}else if (request instanceof RedeemPointRequest){
				
				RedeemPointRequest rpr = (RedeemPointRequest) request;
				LoggingUtil.debug(logger, "#sendRequest --- redeem point, MSISDN= " + rpr.getMsisdn() + ", point= " + rpr.getPoint() + ", keyword= " + rpr.getKeyword());
				
				LoyaltyRedeempointReq redeemReq = objectFactory.createLoyaltyRedeempointReq();
				redeemReq.setIsdn(objectFactory.createLoyaltyRedeempointReqIsdn(rpr.getMsisdn()));
				redeemReq.setKeyword(objectFactory.createLoyaltyRedeempointReqKeyword(rpr.getKeyword()));
				redeemReq.setPoint(Long.valueOf(rpr.getPoint()));
				redeemReq.setUser(objectFactory.createLoyaltyRedeempointReqUser(this.connection.getUserName()));
				redeemReq.setPassword(objectFactory.createLoyaltyRedeempointReqPassword(this.connection.getCredential()));

				LoyaltyResp redeemResp = port.redeemPoint(redeemReq);
				String respCode = redeemResp.getErrorCode().getValue();
				String respMsg = redeemResp.getErrorDetail().getValue();

				LoggingUtil.debug(logger, "#sendRequest --- redeem point MSISDN= " + rpr.getMsisdn() + ", receiving resp= " + redeemResp);
				
				if (respCode.equals(RESP_CODE_SUCCESS) || respMsg.equalsIgnoreCase(RESP_MSG_SUCCESS)){
//				if (respCode.equals(RESP_CODE_SUCCESS)){		
					bar.setStatus(RequestStatus.SUCCESS);
				}else{
					bar.setStatus(RequestStatus.FAIL);
				}
				bar.setResponseCode(respCode);
				bar.setResponseDescription(respMsg);
			}
		} catch (Exception e) {
			bar.setStatus(RequestStatus.FAIL);
			bar.setResponseDescription(e.getMessage());
			
			logger.error("#sendRequest >> error processing request", e);
		}
		
		return bar;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.adapter.BackEndAdapter#shutdown()
	 */
	@Override
	public void shutdown() {
		//do nothing
	}

}
