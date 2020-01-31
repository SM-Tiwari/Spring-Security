/**
 * InviteMemberRequest.java
 */
package com.gnv.vnm.selfcare.webapi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nandipinto
 *
 */

public class InviteMemberRequest implements Serializable {

	private static final long serialVersionUID = -8319736975847014445L;
	
	private String msisdn;
	private List<String> invitedNumbers = new ArrayList<String>();
	
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
	 * @return the invitedNumbers
	 */
	public List<String> getInvitedNumbers() {
		return invitedNumbers;
	}
	/**
	 * @param invitedNumbers the invitedNumbers to set
	 */
	public void setInvitedNumbers(List<String> invitedNumbers) {
		this.invitedNumbers = invitedNumbers;
	}

}
