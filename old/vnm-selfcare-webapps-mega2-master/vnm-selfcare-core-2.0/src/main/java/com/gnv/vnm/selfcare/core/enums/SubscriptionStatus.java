/**
 * SubscriptionStatus.java
 */
package com.gnv.vnm.selfcare.core.enums;

/**
 * @author nandipinto
 *
 */
public enum SubscriptionStatus {
	
	INACTIVE, ACTIVE, EXPIRED;

	public static SubscriptionStatus fromInt(int value){
		for (SubscriptionStatus st:SubscriptionStatus.values()){
			if (value == st.ordinal()) return st;
		}
		return SubscriptionStatus.INACTIVE;
	}
}
