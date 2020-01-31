/**
 * UPCCRechargeQuotaRequest.java
 */
package com.gnv.vnm.selfcare.core.adapter.upcc;

import java.util.Date;

import com.gnv.vnm.selfcare.core.adapter.BackEndAdapterRequest;
import com.gnv.vnm.selfcare.core.enums.RequestType;

/**
 * @author nandipinto
 *
 */
public class UPCCRechargeQuotaRequest extends BackEndAdapterRequest {

	private static final long serialVersionUID = -2350347388385120263L;
	
	private String subscriberId;
	private String quotaName;
	private int quotaClass;
	private int quotaValue;

	public UPCCRechargeQuotaRequest() {}
	
	/**
	 * @param requestId
	 * @param requestType
	 * @param timeStamp
	 */
	public UPCCRechargeQuotaRequest(String requestId, Date timeStamp, String subscriberId, String quotaName, int quotaClass, int quotaValue) {
		super(requestId, RequestType.UPDATE, timeStamp);
		this.subscriberId = subscriberId;
		this.quotaName = quotaName;
		this.quotaClass = quotaClass;
		this.quotaValue = quotaValue;
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

	/**
	 * @return the quotaClass
	 */
	public int getQuotaClass() {
		return quotaClass;
	}

	/**
	 * @param quotaClass the quotaClass to set
	 */
	public void setQuotaClass(int quotaClass) {
		this.quotaClass = quotaClass;
	}

	/**
	 * @return the quotaValue
	 */
	public int getQuotaValue() {
		return quotaValue;
	}

	/**
	 * @param quotaValue the quotaValue to set
	 */
	public void setQuotaValue(int quotaValue) {
		this.quotaValue = quotaValue;
	}
	
	

}
