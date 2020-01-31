/**
 * VoiceBalanceNames.java
 */
package com.gnv.vnm.selfcare.core.adapter.rtbs;

/**
 * @author nandipinto
 *
 */
public enum SmsBalanceNames {

	_1DAY_SMS("1DAY_SMS"),
	ANYNET_SMS("ANYNET_SMS"),
	SMS_ONNET("SMS_ONNET");
	
	private String actualName;
	
	private SmsBalanceNames(String actualName){
		this.actualName = actualName;
	}
	
	public String getActualName(){
		return this.actualName;
	}
}
