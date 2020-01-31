/**
 * Apr 15, 2018 8:15:35 PM
 */
package com.gnv.vnm.selfcare.webapi.model;

/**
 * @author nandipinto
 *
 */
public class GetUnreadNotifCountResponse extends ApiResponse {

	private static final long serialVersionUID = -1729767520623621343L;

	private long count = 0;
	
	public GetUnreadNotifCountResponse() {
	}

	public GetUnreadNotifCountResponse(boolean successful, String code, String message) {
		super(successful, code, message);
	}

	/**
	 * @return the count
	 */
	public long getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(long count) {
		this.count = count;
	}

}
