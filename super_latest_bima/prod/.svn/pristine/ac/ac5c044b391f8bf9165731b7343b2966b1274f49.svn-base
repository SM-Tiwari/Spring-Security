/**
 * DataStatus.java
 */
package com.gnv.vnm.selfcare.core.enums;

/**
 * @author nandipinto
 *
 */
public enum DataStatus {

	INACTIVE, ACTIVE, EXPIRED;
	
	public static DataStatus valueOf(Integer value){
		if (value == null) return null;
		
		for (DataStatus ds:DataStatus.values()){
			if (ds.ordinal() == value) return ds;
		}
		return DataStatus.INACTIVE;
	}
}
