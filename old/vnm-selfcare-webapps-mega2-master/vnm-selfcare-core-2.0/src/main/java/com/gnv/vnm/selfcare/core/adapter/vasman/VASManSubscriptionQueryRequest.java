/**
 * 
 */
package com.gnv.vnm.selfcare.core.adapter.vasman;

import java.util.Date;

import com.gnv.vnm.selfcare.core.adapter.BackEndAdapterRequest;
import com.gnv.vnm.selfcare.core.enums.RequestType;

/**
 * @author nandipinto
 *
 */
public class VASManSubscriptionQueryRequest extends BackEndAdapterRequest {

	private static final long serialVersionUID = 8789636499772602091L;

	private String msisdn;
	private String packageId;
	
	public VASManSubscriptionQueryRequest() {}

	public VASManSubscriptionQueryRequest(String msisdn, String packageId) {
		super();
		this.msisdn = msisdn;
		this.packageId = packageId;
	}

	public VASManSubscriptionQueryRequest(String requestId, RequestType requestType, Date timeStamp) {
		super(requestId, requestType, timeStamp);
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getPackageId() {
		return packageId;
	}

	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	
}
