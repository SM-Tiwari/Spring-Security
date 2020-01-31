/**
 * 
 */
package com.gnv.vnm.selfcare.core.enums;

/**
 * @author nandipinto
 *
 */
public enum SubscriberType {

	PREPAID, POSTPAID;
	
	public static SubscriberType fromInt(int value){
		return value == 0 ? SubscriberType.PREPAID : SubscriberType.POSTPAID;
	}
}
