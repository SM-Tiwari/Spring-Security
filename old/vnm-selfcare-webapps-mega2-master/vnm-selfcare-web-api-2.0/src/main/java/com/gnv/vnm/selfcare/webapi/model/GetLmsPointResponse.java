/**
 * 
 */
package com.gnv.vnm.selfcare.webapi.model;

/**
 * @author nandipinto
 *
 */
public class GetLmsPointResponse extends ApiResponse {

	private static final long serialVersionUID = -3405425847110625163L;
	
	private String msisdn;
	private int point;
	
	public GetLmsPointResponse() { }

	public GetLmsPointResponse(boolean successful, String code, String message, String msisdn, int point) {
		super(successful, code, message);
		this.msisdn = msisdn;
		this.point = point;
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
