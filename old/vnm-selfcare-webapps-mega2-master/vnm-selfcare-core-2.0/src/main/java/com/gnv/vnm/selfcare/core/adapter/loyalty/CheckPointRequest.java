/**
 * CheckPointRequest.java
 */
package com.gnv.vnm.selfcare.core.adapter.loyalty;

import java.util.Date;

import com.gnv.vnm.selfcare.core.adapter.BackEndAdapterRequest;
import com.gnv.vnm.selfcare.core.enums.RequestType;

/**
 * @author nandipinto
 *
 */
public class CheckPointRequest extends BackEndAdapterRequest {

	private static final long serialVersionUID = 4346881809298022208L;

	private String msisdn;
	
	public CheckPointRequest(){
		this.requestType = RequestType.QUERY;
	}
	
	public CheckPointRequest(String msisdn) {
		this.msisdn = msisdn;
		this.requestType = RequestType.QUERY;
	}

	/**
	 * @param requestId
	 * @param requestType
	 * @param timeStamp
	 */
	public CheckPointRequest(String requestId, RequestType requestType, Date timeStamp) {
		super(requestId, requestType, timeStamp);
	}

	/**
	 * @return the msisdn
	 */
	public String getMsisdn() {
		return msisdn;
	}

	/**
	 * @param msisdn the msisdn to set
	 */
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	
}
