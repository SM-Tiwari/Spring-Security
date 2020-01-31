/**
 * UPCCSubscriberQueryRequest.java
 */
package com.gnv.vnm.selfcare.core.adapter.upcc;

import java.util.Date;

import com.gnv.vnm.selfcare.core.adapter.BackEndAdapterRequest;
import com.gnv.vnm.selfcare.core.enums.RequestType;

/**
 * @author nandipinto
 *
 */
public class UPCCSubscriberQueryRequest extends BackEndAdapterRequest {

	private static final long serialVersionUID = -2411241670296731244L;
	
	private String subscriberId;
	private String quotaName;

	public UPCCSubscriberQueryRequest() {}
	
	/**
	 * @param requestId
	 * @param timeStamp
	 */
	public UPCCSubscriberQueryRequest(String requestId, Date timeStamp, String subscriberId, String quotaName) {
		super(requestId, RequestType.QUERY, timeStamp);
		this.subscriberId = subscriberId;
		this.quotaName = quotaName;
	}

	/**
	 * @return the subscriberId
	 */
	public String getSubscriberId() {
		return subscriberId;
	}

	/**
	 * @param subscriberId the subscriberId to set
	 */
	public void setSubscriberId(String subscriberId) {
		this.subscriberId = subscriberId;
	}

	/**
	 * @return the quotaName
	 */
	public String getQuotaName() {
		return quotaName;
	}

	/**
	 * @param quotaName the quotaName to set
	 */
	public void setQuotaName(String quotaName) {
		this.quotaName = quotaName;
	}

}
