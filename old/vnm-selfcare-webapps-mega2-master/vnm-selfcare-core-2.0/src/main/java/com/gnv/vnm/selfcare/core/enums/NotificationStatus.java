/**
 * NotificationStatus.java
 */
package com.gnv.vnm.selfcare.core.enums;

/**
 * @author nandipinto
 *
 */
public enum NotificationStatus {

	UNREAD, READ;
	
	public static NotificationStatus fromInt(Integer value){
		if (value == null) return UNREAD;
		
		return value == 0 ? UNREAD : READ;
	}
}
