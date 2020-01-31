/**
 * 
 */
package com.gnv.vnm.selfcare.webapi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nandipinto
 *
 */
public class PushedCampaignRequest implements Serializable {

	private static final long serialVersionUID = -378928450936791723L;

	private List<PushedCampaignDTO> data = new ArrayList<>();
	
	public PushedCampaignRequest() { }

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
