/**
 * VoiceBalanceNames.java
 */
package com.gnv.vnm.selfcare.core.adapter.rtbs;

/**
 * @author nandipinto
 *
 */
public enum VoiceBalanceNames {

	VOICE_ONNET("VOICE_ONNET"),
	CALLME("CALLME"),
	_1DAY_VOICE("1DAY_VOICE"),
	VM18("VM18"),
	VOICE_ONNET2("VOICE_ONNET2"),
	VOICE_ONNET3("VOICE_ONNET3"),
	VOICE_ANYNET("VOICE_ANYNET"),
	VOICE_IDD("VOICE_ANYNET");
	
	private String actualName;
	
	private VoiceBalanceNames(String actualName){
		this.actualName = actualName;
	}
	
	public String getActualName(){
		return this.actualName;
	}
}
