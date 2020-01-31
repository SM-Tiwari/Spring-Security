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
public class RedeemLmsPointRequest implements Serializable {

	private static final long serialVersionUID = 3775253793776878513L;
	
	private String msisdn;
	private List<LmsParam> points = new ArrayList<>();
	
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
	 * @return the points
	 */
	public List<LmsParam> getPoints() {
		return points;
	}
	/**
	 * @param points the points to set
	 */
	public void setPoints(List<LmsParam> points) {
		this.points = points;
	}

}
