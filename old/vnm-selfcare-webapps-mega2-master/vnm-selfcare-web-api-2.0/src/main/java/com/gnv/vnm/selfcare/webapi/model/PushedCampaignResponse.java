/**
 * 
 */
package com.gnv.vnm.selfcare.webapi.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nandipinto
 *
 */
public class PushedCampaignResponse extends ApiResponse {

	private static final long serialVersionUID = 6381237913736629646L;
	
	private List<PushedCampaignDTO> data = new ArrayList<>();

	public PushedCampaignResponse() {}

	/**
	 * @param successful
	 * @param code
	 * @param message
	 */
	public PushedCampaignResponse(boolean successful, String code, String message) {
		super(successful, code, message);
	}

	/**
	 * @return the data
	 */
	public List<PushedCampaignDTO> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(List<PushedCampaignDTO> data) {
		this.data = data;
	}

	
}
