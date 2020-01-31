/**
 * VoiceBalanceNames.java
 */
package com.gnv.vnm.selfcare.core.adapter.rtbs;

/**
 * @author nandipinto
 *
 */
public enum MainBalanceNames {

	Core("Core"),
	CURRENCY_ONNET("CURRENCY_ONNET"),
	CURRENCY_ONNET3("CURRENCY_ONNET3"),
	PROMOTION("PROMOTION"),
	CURRENCY_ONNET2("CURRENCY_ONNET2"),
	PROMOTION_60("PROMOTION_60"),
	VB600_M("VB600_M"),
	CURRENCY_NORTH("CURRENCY_NORTH"),
	ONNET_VOICE("ONNET_VOICE"),
	ANYNET_VOICE("ANYNET_VOICE"),
	CURRENCY_ANYNET("CURRENCY_ANYNET"),
	CURRENCY_ONNET4("CURRENCY_ONNET4"),
	CURRENCY_ONNET5("CURRENCY_ONNET5"),
	PROMOTION_KN5("PROMOTION_KN5"),
	CURRENCY_ONNET_KN5("CURRENCY_ONNET_KN5");
	
	private String actualName;
	
	private MainBalanceNames(String actualName){
		this.actualName = actualName;
	}
	
	public String getActualName(){
		return this.actualName;
	}
}
