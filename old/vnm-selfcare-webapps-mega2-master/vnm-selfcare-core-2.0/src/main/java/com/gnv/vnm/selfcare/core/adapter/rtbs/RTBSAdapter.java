/**
 * 
 */
package com.gnv.vnm.selfcare.core.adapter.rtbs;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.soap.Detail;
import javax.xml.soap.DetailEntry;
import javax.xml.soap.SOAPFault;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.soap.SOAPFaultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.gnv.vnm.selfcare.core.AppDefaultValues;
import com.gnv.vnm.selfcare.core.adapter.BackEndAdapter;
import com.gnv.vnm.selfcare.core.adapter.BackEndAdapterException;
import com.gnv.vnm.selfcare.core.adapter.BackEndAdapterRequest;
import com.gnv.vnm.selfcare.core.adapter.BackEndAdapterResponse;
import com.gnv.vnm.selfcare.core.adapter.BackEndConnection;
import com.gnv.vnm.selfcare.core.adapter.JaxwsHandlerResolver;
import com.gnv.vnm.selfcare.core.adapter.WSSecurityHeaderSOAPHandler;
import com.gnv.vnm.selfcare.core.adapter.WebServiceBackEndConnection;
import com.gnv.vnm.selfcare.core.adapter.rtbs.ws.ArrayOfDeltaBalance;
import com.gnv.vnm.selfcare.core.adapter.rtbs.ws.Service;
import com.gnv.vnm.selfcare.core.adapter.rtbs.ws.ServiceSoap;
import com.gnv.vnm.selfcare.core.adapter.rtbs.ws.SubscriberRetrieve;
import com.gnv.vnm.selfcare.core.enums.RequestStatus;
import com.gnv.vnm.selfcare.core.enums.TopUpType;
import com.gnv.vnm.selfcare.core.utils.AppUtils;
import com.gnv.vnm.selfcare.core.utils.LoggingUtil;

/**
 * @author nandipinto
 *
 */
public class RTBSAdapter extends BackEndAdapter {

	private static final Logger logger = LoggerFactory.getLogger(RTBSAdapter.class);

	public static final String DATE_PATTERN = AppDefaultValues.GREGORIAN_DATE_FORMAT;
	private static final QName SERVICE_NAME = new QName("http://comverse-in.com/prepaid/ccws", "Service");
	private ServiceSoap endPoint = null;
	private Service service;
	
	public RTBSAdapter(){ }
	
	/*
	 * (non-Javadoc)
	 * 
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
				url = new URL(connection.getProtocol() + "://"+ connection.getHost() + ":" + connection.getPort() + "/" + wsdl);
			} else {
				url = com.gnv.vnm.selfcare.core.adapter.rtbs.ws.Service.WSDL_LOCATION;
			}

			service = new Service(url, SERVICE_NAME);
			
			LoggingUtil.debug(logger, "#init -- SOAP message logging enabled= " + wsconn.isLogSoapMessage());
			if (wsconn.isLogSoapMessage()){
				
				String catalinaHome = System.getProperty("catalina.base");
				if (catalinaHome != null){
					File logDir = new File(catalinaHome + File.separator + "logs");
					if (!logDir.exists()) logDir.mkdir();
					File logFile = new File(logDir, "rtbs-soap-" + AppUtils.dateToString(new Date(), "yyyyMMdd") + ".log");
					service.setHandlerResolver(new JaxwsHandlerResolver(new FileOutputStream(logFile, true)));
				}else{
					service.setHandlerResolver(new JaxwsHandlerResolver(System.out));
				}
			}
		} catch (Exception e) {
			logger.error("#init >> error initiating RTBS adapter!", e);
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

	@SuppressWarnings("rawtypes")
	private ServiceSoap getEndPoint() {
		
		if (endPoint == null){
			endPoint = service.getServiceSoap();
			try {
				if (connection.getConnectionTimeOut() > 0){
					((BindingProvider) endPoint).getRequestContext().put("com.sun.xml.internal.ws.request.timeout", connection.getConnectionTimeOut() * 1000);
				}
			} catch (Exception e) {
				logger.error("#getEndPoint --- error setting connection timeout: " + e.getMessage());
			}
		}
		BindingProvider bindingProvider = (BindingProvider) endPoint;
		List<Handler> handlerChain = new ArrayList<Handler>();
		handlerChain.add(new WSSecurityHeaderSOAPHandler(connection.getUserName(), connection.getCredential(), false));
		bindingProvider.getBinding().setHandlerChain(handlerChain);
		return endPoint;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gnv.vnm.selfcare.core.adapter.BackEndAdapter#sendRequest(com.gnv.vnm.selfcare.core.adapter.BackEndAdapterRequest)
	 */
	@Override
	public BackEndAdapterResponse sendRequest(BackEndAdapterRequest request) {

		BackEndAdapterResponse response = new BackEndAdapterResponse();
		try {
			if (request instanceof RTBSProfileQueryRequest){
				
				RTBSProfileQueryRequest queryRequest = (RTBSProfileQueryRequest)request;
				SubscriberRetrieve data = null;
				
				if (queryRequest.isWithHistory()){
					data = getEndPoint().retrieveSubscriberWithIdentityWithHistoryForMultipleIdentities(
							queryRequest.getSubscriberId(), queryRequest.getIdentity(), queryRequest.getInformationToRetrieve(), 
							toXmlGregorianCalendar(queryRequest.getStartDate()), 
							toXmlGregorianCalendar(queryRequest.getEndDate()), false);
				}else{
					data = getEndPoint().retrieveSubscriberWithIdentityNoHistory(queryRequest.getSubscriberId(), 
							queryRequest.getIdentity(), queryRequest.getInformationToRetrieve());
				}
				
				response.setResult(data);
				response.setStatus(data != null ? RequestStatus.SUCCESS : RequestStatus.FAIL);
				
			}else if (request instanceof RTBSRechargeRequest){
				
				RTBSRechargeRequest rechargeRequest = (RTBSRechargeRequest)request;
				if (rechargeRequest.getType().equals(TopUpType.SCRATCH_CARD)){
					ArrayOfDeltaBalance balances = getEndPoint().rechargeAccountBySubscriber(rechargeRequest.getSubscriberId(), null, 
							rechargeRequest.getVoucherCode(), rechargeRequest.getComment());
					
					response.setResult(balances);
					response.setStatus(( balances != null && balances.getDeltaBalance() != null 
							& balances.getDeltaBalance().size() > 0) ? RequestStatus.SUCCESS : RequestStatus.FAIL);
					
				}else if (rechargeRequest.getType().equals(TopUpType.E_TOPUP)){
					/*		
					Rules:			
					0 < rechValue <= 10.000 VND -> rechDays = 3 days
					10.000 < rechValue <= 20.000 VND -> rechDays = 6 days
					20.000 < rechValue <= 50.000 VND -> rechDays = 15 days
					50.000 < rechValue <= 100.000 VND -> rechDays = 30 days
					100.000 < rechValue <= 200.000 VND -> rechDays = 60 days
					200.000 < rechValue <= 300.000 VND -> rechDays = 120 days
					300.000 < rechValue <= 500.000 VND -> rechDays = 240 days
					*/					
					int days = 0;
					double amount = rechargeRequest.getAmount();
					if (amount > 10000){
						if (amount > 20000){
							if (amount > 50000){
								if (amount > 100000){
									if (amount > 200000){
										if (amount > 300000){
											days = 240;
										}else{
											days = 120;
										}
									}else{
										days = 60;
									}
								}else {
									days = 30;
								}
							}else {
								days = 15;
							}
						}else {
							days = 6;
						}
					}else{
						days = 3;
					}
					
					boolean result = getEndPoint().nonVoucherRecharge(rechargeRequest.getSubscriberId(), null, 
							rechargeRequest.getAmount(), days, rechargeRequest.getType().name());
					
					response.setResult(rechargeRequest.getAmount());
					response.setStatus(result ? RequestStatus.SUCCESS : RequestStatus.FAIL);
				}
			
			}else if (request instanceof RTBSDeductBalanceRequest){
				//TODO
			}
			
		} catch (SOAPFaultException e) {
			extractSOAPFault(response, e);
			logger.error("#sendRequest >> Caught SOAPFaultException= " + e.getMessage() + ", error_code= " + response.getResponseCode() + ", error_desc= " + response.getResponseDescription());

		} catch (Exception e){
			response.setStatus(RequestStatus.FAIL);
			response.setResponseDescription(e.getMessage());
			logger.error("#sendRequest >> Caught Exception= " + e.getMessage());
		}
		return response;
	}

	private void extractSOAPFault(BackEndAdapterResponse response, SOAPFaultException e){
		try {
			response.setStatus(RequestStatus.FAIL);

			SOAPFault fault = e.getFault();
			Detail detail = fault.getDetail();
			@SuppressWarnings("unchecked")
			Iterator<DetailEntry> entries = detail.getDetailEntries();
			if (entries != null){
				while (entries.hasNext()){
					DetailEntry de = entries.next();
//					LoggingUtil.debug(logger, "--- de.getElementName( " + de.getElementName() + ", " + de.getNodeName()
//							+ ")" + ", (value= " + de.getValue() + ", " + de.getNodeValue());
					if (de.getNodeName().equals("ErrorCode")){
						response.setResponseCode(de.getValue());
					}else if (de.getNodeName().equals("ErrorDescription")){
						response.setResponseDescription(de.getValue());
					}
				}
			}
		} catch (Exception e2) {}
	}
	
	private XMLGregorianCalendar toXmlGregorianCalendar(Date input){
		
		try {
			GregorianCalendar cal = new GregorianCalendar();
			cal.setTime(input);
			
			XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
			return xmlDate;
		} catch (Exception e) {
			logger.error("#toXmlGregorianCalendar >> error converting input string(" + input + ") to XMLGregorianCalendar", e);
		}
		
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.adapter.BackEndAdapter#shutdown()
	 */
	@Override
	public void shutdown() {
		//do nothing
	}

}
