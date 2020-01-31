/**
 * Feb 6, 2018 6:48:17 AM
 */
package com.gnv.vnm.selfcare.webapi.model;

/**
 * @author nandipinto
 *
 */
public class GetPostpaidConfigResponse extends ApiResponse {

	private static final long serialVersionUID = 3075353463324456738L;

	private double minDepositAmount = 0.0;

	public GetPostpaidConfigResponse() {
	}

	public GetPostpaidConfigResponse(boolean successful, String code, String message) {
		super(successful, code, message);
	}
	
	public GetPostpaidConfigResponse(boolean successful, String code, String message, double minDepositAmount) {
		super(successful, code, message);
		this.minDepositAmount = minDepositAmount;
	}
	
	/**
	 * @return the minDepositAmount
	 */
	public double getMinDepositAmount() {
		return minDepositAmount;
	}

	/**
	 * @param minDepositAmount the minDepositAmount to set
	 */
	public void setMinDepositAmount(double minDepositAmount) {
		this.minDepositAmount = minDepositAmount;
	}
	
	
}
