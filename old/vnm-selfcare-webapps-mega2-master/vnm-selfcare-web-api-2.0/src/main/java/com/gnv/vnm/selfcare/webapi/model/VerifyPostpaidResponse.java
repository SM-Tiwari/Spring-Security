/**
 * Jan 24, 2018 9:51:54 AM
 */
package com.gnv.vnm.selfcare.webapi.model;

/**
 * @author nandipinto
 *
 */
public class VerifyPostpaidResponse extends ApiResponse {

	private static final long serialVersionUID = -3853180301445175092L;
	
	private boolean postpaid = false;

	public VerifyPostpaidResponse() {}

	/**
	 * @param successful
	 * @param code
	 * @param message
	 */
	public VerifyPostpaidResponse(boolean successful, String code, String message) {
		super(successful, code, message);
	}

	public VerifyPostpaidResponse(boolean successful, String code, String message, boolean postpaid) {
		super(successful, code, message);
		this.postpaid = postpaid;
	}

	/**
	 * @return the postpaid
	 */
	public boolean isPostpaid() {
		return postpaid;
	}

	/**
	 * @param postpaid the postpaid to set
	 */
	public void setPostpaid(boolean postpaid) {
		this.postpaid = postpaid;
	}
	
	
}
