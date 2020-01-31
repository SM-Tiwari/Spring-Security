/**
 * Apr 13, 2018 1:52:00 PM
 */
package com.gnv.vnm.selfcare.core.enums;

/**
 * @author nandipinto
 *
 */
public enum PushedCampaignType {

	NEWS,
	FCM,
	GENERAL_REMINDER;
	
	
	public static PushedCampaignType fromInt(Integer value){
		if (value == null) return NEWS;
		
		for (PushedCampaignType pct : PushedCampaignType.values()) {
			if (value.equals(pct.ordinal())) return pct;
		}
		return NEWS;
	}
}
