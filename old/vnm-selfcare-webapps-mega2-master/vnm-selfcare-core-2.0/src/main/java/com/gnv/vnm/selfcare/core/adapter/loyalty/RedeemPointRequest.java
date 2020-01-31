/**
 * RedeemPointRequest.java
 */
package com.gnv.vnm.selfcare.core.adapter.loyalty;

import java.util.Date;

import com.gnv.vnm.selfcare.core.adapter.BackEndAdapterRequest;
import com.gnv.vnm.selfcare.core.enums.RequestType;

/**
 * @author nandipinto
 *
 */
public class RedeemPointRequest extends BackEndAdapterRequest {

	private static final long serialVersionUID = -1539163321263700395L;

	private String msisdn;
	private String keyword;
	private int point;

	public RedeemPointRequest() {
		this.requestType = RequestType.UPDATE;
	}

	public RedeemPointRequest(String msisdn, String keyword, int point) {
		this.msisdn = msisdn;
		this.keyword = keyword;
		this.point = point;
		this.requestType = RequestType.UPDATE;
	}

	public RedeemPointRequest(String requestId, RequestType requestType, Date timeStamp) {
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

	/**
	 * @return the keyword
	 */
	public String getKeyword() {
		return keyword;
	}

	/**
	 * @param keyword the keyword to set
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	/**
	 * @return the point
	 */
	public int getPoint() {
		return point;
	}

	/**
	 * @param point the point to set
	 */
	public void setPoint(int point) {
		this.point = point;
	}
	
	
}
