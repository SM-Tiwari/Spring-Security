/**
 * TokenStatus.java
 */
package com.gnv.vnm.selfcare.core.enums;

/**
 * @author nandipinto
 *
 */
public enum TokenStatus {

	UNUSED, USED, EXPIRED;
	
	public static TokenStatus fromInt(int value){
		for (TokenStatus ts:TokenStatus.values()){
			if (ts.ordinal() == value) return ts;
		}
		
		return TokenStatus.EXPIRED;
	}
}
