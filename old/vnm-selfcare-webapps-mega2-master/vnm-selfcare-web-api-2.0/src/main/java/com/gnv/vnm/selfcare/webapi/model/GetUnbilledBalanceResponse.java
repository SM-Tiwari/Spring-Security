/**
 * Jan 22, 2018 1:50:44 PM
 */
package com.gnv.vnm.selfcare.webapi.model;

import com.gnv.vnm.selfcare.core.model.UnbilledBalance;

/**
 * @author nandipinto
 *
 */
public class GetUnbilledBalanceResponse extends ApiResponse {

	private static final long serialVersionUID = 3089606529995252198L;
	
	private UnbilledBalance unbilledBalance;
	
	public GetUnbilledBalanceResponse() {
	}

	public GetUnbilledBalanceResponse(boolean successful, String code, String message) {
		super(successful, code, message);
	}

	public GetUnbilledBalanceResponse(boolean successful, String code, String message, UnbilledBalance billSummary) {
		super(successful, code, message);
		this.unbilledBalance = billSummary;
	}
	
	/**
	 * @return the billSummary
	 */
	public UnbilledBalance getUnbilledBalance() {
		return unbilledBalance;
	}

	/**
	 * @param billSummary the billSummary to set
	 */
	public void setUnbilledBalance(UnbilledBalance billSummary) {
		this.unbilledBalance = billSummary;
	}

}
