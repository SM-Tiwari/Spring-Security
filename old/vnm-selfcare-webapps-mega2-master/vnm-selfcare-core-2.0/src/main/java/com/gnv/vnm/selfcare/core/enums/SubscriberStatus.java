/**
 * SubscriberStatus.java
 */
package com.gnv.vnm.selfcare.core.enums;

/**
 * @author nandipinto
 *
 */
public enum SubscriberStatus {

	INACTIVE, PENDING, ACTIVE, BLOCKED;
	
	public static SubscriberStatus fromInt(int value){
		for (SubscriberStatus st:SubscriberStatus.values()){
			if (st.ordinal() == value) return st;
		}
		return SubscriberStatus.INACTIVE;
	}
}
