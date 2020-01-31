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
public class UpdatePushedCampaignStatusRequest implements Serializable {

	private static final long serialVersionUID = 1552266527767220488L;

	private List<PushedCampaignStatus> data = new ArrayList<>();

	/**
	 * @return the data
	 */
	public List<PushedCampaignStatus> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(List<PushedCampaignStatus> data) {
		this.data = data;
	}
	
}
