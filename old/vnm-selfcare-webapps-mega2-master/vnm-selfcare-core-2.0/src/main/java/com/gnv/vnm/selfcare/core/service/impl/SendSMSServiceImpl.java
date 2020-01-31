package com.gnv.vnm.selfcare.core.service.impl;

import java.util.Arrays;
import org.jsmpp.bean.Alphabet;
import org.jsmpp.bean.GeneralDataCoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.gnv.vnm.selfcare.core.service.ApplicationConfigurationService;
import com.gnv.vnm.selfcare.core.service.SendSMSService;
import com.gnv.vnm.selfcare.core.utils.AppUtils;
import com.gnv.vnm.selfcare.core.utils.LoggingUtil;

/**
 * This class provides the Send SMS for SendSMS Service.
 * 
 * @author Kuldeep Singh
 *
 */
@Service("sendSMSService")
@Transactional
public class SendSMSServiceImpl implements SendSMSService {
	/**
	 * Instance of Logger {@link Logger}
	 */
	private static final Logger logger = LoggerFactory.getLogger(SendSMSServiceImpl.class);

	public static final int UCS2_MAX_TXT_LEN = 70;

	public static final int DEFAULT_MAX_TXT_LEN = 140;
	
    private static int smsapisuccessstatus=0;

	
	RestTemplate restTemplate;

	@Autowired
	private ApplicationConfigurationService applicationConfigurationService;

	/**
     * This Method used send message to users and return success or fail  .
     * @param {{@link sender}}
     * @param {{@link recipient}}
     * @param {{@link message}}
     * @param {{@link prependCountryCode}}
     * @param {{@link dataCoding}}
     * @return boolean.
     * */
	@Override
	public boolean sendSMS(String sender, String recipient, String message, boolean prependCountryCode,
			GeneralDataCoding dataCoding, String charset) {
		LoggingUtil.debug(logger, String.format("#sendSMS >> Sending message  (%s), message= [%s] ", new Object[]{recipient, message}));
	    boolean smsSuccessStatus=false;
		try
		{
		if (dataCoding == null) {
			dataCoding = new GeneralDataCoding(Alphabet.ALPHA_UCS2);
			}
			if (AppUtils.emptyOrWhiteSpace(charset)) {
			charset = "UTF-16BE";
			}
			
			if (prependCountryCode)
				recipient = AppUtils.prependCountryCodeToMsisdn(recipient,
						applicationConfigurationService.getDefaultCountryCode());
			
		    HttpHeaders headers = new HttpHeaders();
		                headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		                
		    HttpEntity<String> entity = new HttpEntity<String>(headers);
		  /*  String smsurl=applicationConfigurationService.get("sms.conn.ip", "localhost").toString();
		    StringBuilder url=new StringBuilder();
		    if(smsurl!=null)url.append(smsurl).append("from="+sender+"&to="+recipient+"&text="+message);*/
		   String url="http://10.6.10.51:8009/sendsms?from="+sender+"&to="+recipient+"&text="+message;
		    
		    String response=restTemplate.exchange(
		    		url, HttpMethod.GET, entity, String.class).getBody();
		    
		    System.out.println("Success Response is "+response);
			LoggingUtil.info(logger,"#sendSMS >> Sending message response is   "+response);
		  
			if(response!=null)
		    {
		    	String[] respArray=response.split(":");
		    	
		    	if(respArray[0]!=null && Integer.parseInt(respArray[0])==smsapisuccessstatus)
		    	{
		    		smsSuccessStatus=true;
		    	}
		    	
		    }
		}
		catch (Exception e) {
			// TODO: handle exception
			logger.error("could not send message to " + recipient + ", error= " + e.getMessage());
		}
		return smsSuccessStatus;
	}

}
