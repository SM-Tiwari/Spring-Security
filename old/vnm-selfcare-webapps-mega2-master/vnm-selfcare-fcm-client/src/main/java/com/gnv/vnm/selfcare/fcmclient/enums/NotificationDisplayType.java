/**
 * NotificationDisplayType.java
 */
package com.gnv.vnm.selfcare.fcmclient.enums;

/**
 * @author nandipinto
 *
 */
public enum NotificationDisplayType {

	REGULAR, PUSHED, POPUP;
	
	
	public static NotificationDisplayType fromInt(Integer value){
		if (value == null) return REGULAR;
		
		for (NotificationDisplayType ndt : NotificationDisplayType.values()) {
			if (value.equals(ndt.ordinal())) return ndt;
		}
		return REGULAR;
	}
}
