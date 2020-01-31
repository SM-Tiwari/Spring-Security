/**
 * 
 */
package com.gnv.vnm.selfcare.webportal.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nandipinto
 *
 */
public class InviteFriendsForm implements Serializable{
	private static final long serialVersionUID = -7700832628082081966L;

	private List<String> phoneNumbers = new ArrayList<>();

	/**
	 * @return the phoneNumbers
	 */
	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	/**
	 * @param phoneNumbers the phoneNumbers to set
	 */
	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	
	
}
