/**
 * TransactionStatus.java
 */
package com.gnv.vnm.selfcare.core.enums;

/**
 * @author nandipinto
 *
 */
public enum TransactionStatus {

	PROCESSING, SUCCESS, FAIL, CANCELED, NOT_FOUND, ROLL_BACK, TIME_OUT;
	
	public static TransactionStatus fromInt(int value){
		for (TransactionStatus st:TransactionStatus.values()){
			if (st.ordinal() == value) return st;
		}
		return TransactionStatus.PROCESSING;
	}
}
