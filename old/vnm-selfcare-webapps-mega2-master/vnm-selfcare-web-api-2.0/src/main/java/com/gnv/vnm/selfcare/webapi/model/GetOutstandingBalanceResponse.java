/**
 * Feb 6, 2018 6:48:17 AM
 */
package com.gnv.vnm.selfcare.webapi.model;

import java.util.ArrayList;
import java.util.List;

import com.gnv.vnm.selfcare.core.model.OutstandingBalance;

/**
 * @author nandipinto
 *
 */
public class GetOutstandingBalanceResponse extends ApiResponse {

	private static final long serialVersionUID = 3075353463324456738L;

	private List<OutstandingBalance> outstandingBalances = new ArrayList<>();

	public GetOutstandingBalanceResponse() {
	}

	public GetOutstandingBalanceResponse(boolean successful, String code, String message) {
		super(successful, code, message);
	}

	public GetOutstandingBalanceResponse(boolean successful, String code, String message, List<OutstandingBalance> outstandingBalances) {
		super(successful, code, message);
		this.outstandingBalances = outstandingBalances;
	}

	/**
	 * @return the outstandingBalances
	 */
	public List<OutstandingBalance> getOutstandingBalances() {
		return outstandingBalances;
	}

	/**
	 * @param outstandingBalances the outstandingBalances to set
	 */
	public void setOutstandingBalances(List<OutstandingBalance> outstandingBalances) {
		this.outstandingBalances = outstandingBalances;
	}
	
}
