/**
 * Jan 22, 2018 2:21:41 PM
 */
package com.gnv.vnm.selfcare.webapi.model;

import java.util.ArrayList;
import java.util.List;

import com.gnv.vnm.selfcare.core.model.BillingSummary;

/**
 * @author nandipinto
 *
 */
public class GetBillingSummaryResponse extends ApiResponse {

	private static final long serialVersionUID = -4746133416432527653L;
	
	private List<BillingSummary> billHistory = new ArrayList<>();

	public GetBillingSummaryResponse() { }

	public GetBillingSummaryResponse(boolean successful, String code, String message) {
		super(successful, code, message);
	}

	public GetBillingSummaryResponse(boolean successful, String code, String message, List<BillingSummary> billHistory) {
		super(successful, code, message);
		this.billHistory = billHistory;
	}
	
	/**
	 * @return the billHistory
	 */
	public List<BillingSummary> getBillHistory() {
		return billHistory;
	}

	/**
	 * @param billHistory the billHistory to set
	 */
	public void setBillHistory(List<BillingSummary> billHistory) {
		this.billHistory = billHistory;
	}

	
}
