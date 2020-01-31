/**
 * RTBSSubscriberInfoValues.java
 */
package com.gnv.vnm.selfcare.core.adapter.rtbs;

/**
 * @author nandipinto
 *
 */
public enum RTBSSubscriberInfoValues {

	/*
	
+ 35713: All service
+ 257: Activity
+ 129: MTR
+ 32769: Diameter
+ 513: Recharge
+ 2049: OSA	
	*/
	SUBSCRIBER_ENTITY (1, "SubscriberEntity"),
	SUBSCRIBER_HOME (2, "SubscriberHome"),
	SUBSCRIBER_INFO (4, "SubscriberInfo"),
	SUBSCRIBER_PHONEBOOK (8, "SubscriberPhonebook"),
	PERIODIC_CHARGE (16, "PeriodicCharge"),
	CUG_MEMBERS (32, "CUGMembers"),
	RESERVATIONS (64, "Reservations"),
	MONETARY_TRANSACTION_RECORD(128, "Monetary Transaction Record"),
	ACTIVITY_HISTORY(256, "Activity History"),
	RECHARGE_HISTORY(512, "Recharge History"),
	PS_TRANSACTION(1024, "PS Transaction"),
	OSA_HISTORY(2048, "OSA History"),
	IDENTITY_HISTORY(4096, "Identity History"),
	CALLING_CIRCLES (8192, "Calling Circles"),
	OFFER_HISTORY(16384, "Offer History"),
	DIAMETER_OCS_HISTORY(32768, "Diamater OCS History"),
	F_N_F_PHONEBOOK_HISTORY(65536, "F&F Phonebook History"),
	ALL_SERVICES(35713, "All Services");
	
	private int value;
	private String name;
	
	private RTBSSubscriberInfoValues(int value, String name){
		this.value = value;
		this.name = name;
	}
	
	public int getValue(){
		return value;
	}
	
	public String getName(){
		return name;
	}

}
