/**
 * Feb 6, 2018 6:48:17 AM
 */
package com.gnv.vnm.selfcare.webapi.model;

import com.gnv.vnm.selfcare.core.model.BillingSummaryDetails;

/**
 * @author nandipinto
 *
 */
public class GetBillingSummaryDetailsResponse extends ApiResponse {

	private static final long serialVersionUID = 3075353463324456738L;

	private BillingSummaryDetails details;

	public GetBillingSummaryDetailsResponse() {
	}

	public GetBillingSummaryDetailsResponse(boolean successful, String code, String message) {
		super(successful, code, message);
	}

	public GetBillingSummaryDetailsResponse(boolean successful, String code, String message, BillingSummaryDetails details) {
		super(successful, code, message);
		this.details = details;
	}

	/**
	 * @return the details
	 */
	public BillingSummaryDetails getDetails() {
		return details;
	}

	/**
	 * @param details the details to set
	 */
	public void setDetails(BillingSummaryDetails details) {
		this.details = details;
	}
	
}
