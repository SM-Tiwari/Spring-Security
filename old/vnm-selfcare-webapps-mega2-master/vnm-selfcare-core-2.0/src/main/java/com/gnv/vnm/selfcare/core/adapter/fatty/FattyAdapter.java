package com.gnv.vnm.selfcare.core.adapter.fatty;

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
import com.gnv.vnm.selfcare.core.adapter.loyalty.CheckPointRequest;
import com.gnv.vnm.selfcare.core.adapter.loyaltynew.ws.LoyaltyWS;
import com.gnv.vnm.selfcare.core.adapter.loyaltynew.ws.LoyaltyWSPortType;
import com.gnv.vnm.selfcare.core.enums.RequestStatus;
import com.gnv.vnm.selfcare.core.utils.AppUtils;
import com.gnv.vnm.selfcare.core.utils.Constant.FattyRedeemStatus;
import com.gnv.vnm.selfcare.core.utils.LoggingUtil;
import com.elcom.loyalty.LoyaltyCheckpointResp;
import com.elcom.loyalty.LoyaltyRedeempointReq;
import com.elcom.loyalty.LoyaltyReq;
import com.elcom.loyalty.LoyaltyResp;
import com.elcom.loyalty.ObjectFactory;

public class FattyAdapter extends BackEndAdapter {

	private static final Logger logger = LoggerFactory.getLogger(FattyAdapter.class);

	public static final String ADD_POINT_KEYWORD = "ADDPOINT";
	public static final String SUB_POINT_KEYWORD = "SUBSPOINT";

	// private static final QName SERVICE_NAME = new
	// QName("http://loyalty.elcom.com", "LoyaltyWS");
	private static final QName SERVICE_NAME = new QName("http://iwebservice.nms.com", "LoyaltyWS");

	public static final String RESP_CODE_SUCCESS = "1";
	public static final String RESP_MSG_SUCCESS = "success";

	public static final String RESP_CODE_ERROR = "0";
	public static final String RESP_MSG_ERROR = "error";

	public static final String RESP_CODE_NOT_ENOUGH_POINT = "1007";
	public static final String RESP_MSG_NOT_ENOUGH_POINT = "not-enough-point";

	public static final String RESP_CODE_MINIMUM_POINT = "1008";
	public static final String RESP_MSG_MINIMUM_POINT = "minimum-point";

	public static final String RESP_CODE_POINT_ODD = "1009";
	public static final String RESP_MSG_POINT_ODD = "point-odd";

	public static final String RESP_CODE_REGISTERED = "1005";
	public static final String RESP_MSG_REGISTERED = "registered";

	public static final String RESP_CODE_UNREGISTERED = "1006";
	public static final String RESP_MSG_UNREGISTERED = "unregistered";
	
	public static final String RESP_CODE_OUT_OF_TIME = "1012";
	public static final String RESP_MSG_OUT_OF_TIME = "out-of-time";
	
	private LoyaltyWS loyaltyWS;
	private LoyaltyWSPortType port;

	@Override
	public void init(BackEndConnection connection) throws BackEndAdapterException {
		// TODO Auto-generated method stub
		try {
		
			URL url = null;
			this.connection = connection;
			WebServiceBackEndConnection wsconn = (WebServiceBackEndConnection) this.connection;
			String wsdl = wsconn.getWsdlLocation();
			// String wsdl="/LoyaltyWS/services/LoyaltyWS?wsdl";
		
			if (StringUtils.hasText(wsdl)) {
				url = new URL(connection.getProtocol() + "://" + connection.getHost() + ":" + connection.getPort() + "/"
						+ wsdl);
			} else {
				url = this.getClass().getClassLoader().getResource("wsdl/LoyaltyWS.wsdl");
			}
			
			loyaltyWS = new LoyaltyWS(url, SERVICE_NAME);

			port = loyaltyWS.getLoyaltyWSHttpPort();
			
			if (connection.getConnectionTimeOut() > 0) {
				try {
					if (connection.getConnectionTimeOut() > 0) {
						((BindingProvider) port).getRequestContext().put("com.sun.xml.internal.ws.request.timeout",
								connection.getConnectionTimeOut() * 1000);
					}
				} catch (Exception e) {
					logger.error("#getEndPoint --- error setting connection timeout: " + e.getMessage());
				}
			}
			LoggingUtil.debug(logger, "#init -- SOAP message logging enabled= " + wsconn.isLogSoapMessage());
			if (wsconn.isLogSoapMessage()) {

				String catalinaHome = System.getProperty("catalina.base");
				if (catalinaHome != null) {
					File logDir = new File(catalinaHome + File.separator + "logs");
					if (!logDir.exists())
						logDir.mkdir();
					File logFile = new File(logDir,
							"loyalty-soap-" + AppUtils.dateToString(new Date(), "yyyyMMdd") + ".log");
					loyaltyWS.setHandlerResolver(new JaxwsHandlerResolver(new FileOutputStream(logFile, true)));
				} else {
					loyaltyWS.setHandlerResolver(new JaxwsHandlerResolver(System.out));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	@Override
	public void login() {
		// TODO Auto-generated method stub

	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isConnected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void reconnect(BackEndConnection connection) throws BackEndAdapterException {
		// TODO Auto-generated method stub

	}

	@Override
	public BackEndAdapterResponse sendRequest(BackEndAdapterRequest request) {
		BackEndAdapterResponse bar = new BackEndAdapterResponse();
		int point = 0;
		if (port == null) {
			bar.setStatus(RequestStatus.FAIL);
			bar.setResponseDescription("Connection to FATTY could not be made!");

			return bar;
		}
		// TODO Auto-generated method stub

		try {
			// port = loyaltyWS.getLoyaltyWSHttpPort();
			// ((BindingProvider)proxy).getRequestContext().
			// put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
			// "http://new/endpointaddress");

			ObjectFactory objectFactory = new ObjectFactory();

			if (request instanceof CheckPointRequest) {
				CheckPointRequest cpr = (CheckPointRequest) request;

				LoggingUtil.debug(logger,
						"#sendRequest --- retrieving point information from FATTY, MSISDN= " + cpr.getMsisdn());

				LoyaltyReq loyaltyReq = objectFactory.createLoyaltyReq();
				loyaltyReq.setIsdn(objectFactory.createLoyaltyCheckpointRespIsdn(cpr.getMsisdn()));
				loyaltyReq.setUser(objectFactory.createLoyaltyRedeempointReqUser(this.connection.getUserName()));
				loyaltyReq.setPassword(
						objectFactory.createLoyaltyRedeempointReqPassword(this.connection.getCredential()));

				LoyaltyCheckpointResp checkPointResp = port.checkPoint(loyaltyReq);
				String respCode = checkPointResp.getErrorCode().getValue();
				String respMsg = checkPointResp.getErrorDetail().getValue();
				System.out.println("respCode is :::" + respCode);
				LoggingUtil.debug(logger, "#sendRequest --- receiving response= " + checkPointResp);

				if (respCode.equals(RESP_CODE_SUCCESS) || respMsg.equalsIgnoreCase(RESP_MSG_SUCCESS)) {
					bar.setStatus(RequestStatus.SUCCESS);
					
					if (checkPointResp.getPoint() != null) {
						point = checkPointResp.getPoint().intValue();
					}

				} else {
					bar.setStatus(RequestStatus.FAIL);
				}
				bar.setResult(point);
				bar.setResponseCode(respCode);
				bar.setResponseDescription(respMsg);

			} else if (request instanceof RedeemPointRequestFatty) {

				RedeemPointRequestFatty rpr = (RedeemPointRequestFatty) request;
				LoggingUtil.debug(logger, "#sendRequest --- redeem point, MSISDN= " + rpr.getMsisdn() + ", point= "
						+ rpr.getPoint() + ", keyword= " + rpr.getKeyword());

				LoyaltyRedeempointReq redeemReq = objectFactory.createLoyaltyRedeempointReq();
				redeemReq.setIsdn(objectFactory.createLoyaltyRedeempointReqIsdn(rpr.getMsisdn()));
				redeemReq.setKeyword(objectFactory.createLoyaltyRedeempointReqKeyword(rpr.getKeyword().toUpperCase()));
				redeemReq.setDescription(objectFactory.createLoyaltyRedeempointReqDescription(rpr.getDescription()));
				// redeemReq.setPoint(Long.valueOf(rpr.getPoint()));
				redeemReq.setUser(objectFactory.createLoyaltyRedeempointReqUser(this.connection.getUserName()));
				redeemReq.setPassword(
						objectFactory.createLoyaltyRedeempointReqPassword(this.connection.getCredential()));

				LoyaltyResp redeemResp = port.redeemPoint(redeemReq);
				String respCode = redeemResp.getErrorCode().getValue();
				String respMsg = redeemResp.getErrorDetail().getValue();
				LoggingUtil.debug(logger,
						"#sendRequest --- redeem point MSISDN= " + rpr.getMsisdn() + ", receiving resp= " + redeemResp);

				if (respCode.equals(RESP_CODE_SUCCESS) || respMsg.equalsIgnoreCase(RESP_MSG_SUCCESS)) {
					// if (respCode.equals(RESP_CODE_SUCCESS)){
					bar.setResponseCode(respCode);
					bar.setStatus(RequestStatus.SUCCESS);
				} 
				else if(respCode.equals(RESP_CODE_ERROR) || respMsg.equalsIgnoreCase(RESP_MSG_ERROR)) {
					bar.setResponseCode(RESP_CODE_ERROR);
					bar.setStatus(RequestStatus.FAIL);
				}
				else if(respCode.equals(RESP_CODE_NOT_ENOUGH_POINT) || respMsg.equalsIgnoreCase(RESP_MSG_NOT_ENOUGH_POINT)) {
					bar.setResponseCode(RESP_CODE_NOT_ENOUGH_POINT);
					bar.setStatus(RequestStatus.FAIL);
				}
				else if(respCode.equals(RESP_CODE_MINIMUM_POINT) || respMsg.equalsIgnoreCase(RESP_MSG_MINIMUM_POINT)) {
					bar.setResponseCode(RESP_CODE_MINIMUM_POINT);
					bar.setStatus(RequestStatus.FAIL);
				}
				else if(respCode.equals(RESP_CODE_POINT_ODD) || respMsg.equalsIgnoreCase(RESP_MSG_POINT_ODD)) {
					bar.setResponseCode(RESP_CODE_POINT_ODD);
					bar.setStatus(RequestStatus.FAIL);
				}
				else if(respCode.equals(RESP_CODE_REGISTERED) || respMsg.equalsIgnoreCase(RESP_MSG_REGISTERED)) {
					bar.setResponseCode(RESP_CODE_REGISTERED);
					bar.setStatus(RequestStatus.FAIL);
				}
				else if(respCode.equals(RESP_CODE_OUT_OF_TIME) || respMsg.equalsIgnoreCase(RESP_MSG_OUT_OF_TIME)) {
					bar.setResponseCode(RESP_CODE_OUT_OF_TIME);
					bar.setStatus(RequestStatus.FAIL);
				}
				else if(respCode.equals(RESP_CODE_UNREGISTERED) || respMsg.equalsIgnoreCase(RESP_MSG_UNREGISTERED)) {
					bar.setResponseCode(RESP_CODE_UNREGISTERED);
					bar.setStatus(RequestStatus.FAIL);
				}
				bar.setResponseDescription(respMsg);
			}
		} catch (Exception e) {
			bar.setStatus(RequestStatus.FAIL);
			bar.setResponseDescription(e.getMessage());

			logger.error("#sendRequest >> error processing request", e);
		}

		return bar;
	}

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub

	}

}
