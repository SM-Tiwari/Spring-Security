/**
 * TransactionType.java
 */
package com.gnv.vnm.selfcare.core.enums;

/**
 * @author nandipinto
 *
 */
public enum TransactionType {
	
	E_TOPUP,
	POSTPAID_BILL_PAYMENT,
	POSTPAID_DEPOSIT,
	BUY_PRODUCT,
	BUY_CONTENT;
	
	public static TransactionType valueOf(Integer value){
		if (value == null) return null;

		for (TransactionType ds:TransactionType.values()){
		if (ds.ordinal() == value) return ds;
		}
		return TransactionType.E_TOPUP;
		}
	
}
