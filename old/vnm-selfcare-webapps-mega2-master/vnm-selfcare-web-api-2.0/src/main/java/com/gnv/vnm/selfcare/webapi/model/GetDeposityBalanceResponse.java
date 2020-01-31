/**
 * Feb 6, 2018 6:48:17 AM
 */
package com.gnv.vnm.selfcare.webapi.model;

/**
 * @author nandipinto
 *
 */
public class GetDeposityBalanceResponse extends ApiResponse {

	private static final long serialVersionUID = 3075353463324456738L;

	private double depositBalance = 0.0;

	public GetDeposityBalanceResponse() {
	}

	public GetDeposityBalanceResponse(boolean successful, String code, String message) {
		super(successful, code, message);
	}

	public GetDeposityBalanceResponse(boolean successful, String code, String message, double depositBalance) {
		super(successful, code, message);
		this.depositBalance = depositBalance;
	}

	/**
	 * @return the depositBalance
	 */
	public double getDepositBalance() {
		return depositBalance;
	}

	/**
	 * @param depositBalance the depositBalance to set
	 */
	public void setDepositBalance(double depositBalance) {
		this.depositBalance = depositBalance;
	}

	
}
