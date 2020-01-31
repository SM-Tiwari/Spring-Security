package com.gnv.vnm.selfcare.core.service;

import org.jsmpp.bean.GeneralDataCoding;

/**
 * This interface provides the Send SMS for SendSMS Service.
 * 
 * @author Kuldeep Singh
 *
 */
public interface SendSMSService {

	public boolean sendSMS(String sender, String recipient, String message, boolean prependCountryCode,
			GeneralDataCoding dataCoding, String charset);
}
