/**
 * Gender.java
 */
package com.gnv.vnm.selfcare.core.enums;

/**
 * @author nandipinto
 *
 */
public enum Gender {

	MALE, FEMALE;
	
	public static Gender valueOf(int value){
		return value == 0 ? Gender.MALE:FEMALE;
	}
}
