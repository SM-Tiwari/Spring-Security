/**
 * Mar 15, 2018 6:05:21 PM
 */
package com.gnv.vnm.selfcare.webapi.model;

import com.gnv.vnm.selfcare.core.enums.SubscriptionStatus;

/**
 * @author nandipinto
 *
 */
public class GetRoamingStatusResponse extends ApiResponse {

	private static final long serialVersionUID = 7954401845066067271L;
	
	private SubscriptionStatus voiceRoamingStatus = SubscriptionStatus.INACTIVE;
	private SubscriptionStatus smsRoamingStatus = SubscriptionStatus.INACTIVE;
	private SubscriptionStatus roamingStatus = SubscriptionStatus.INACTIVE;

	public SubscriptionStatus getRoamingStatus() {
		return roamingStatus;
	}

	public void setRoamingStatus(SubscriptionStatus roamingStatus) {
		this.roamingStatus = roamingStatus;
	}

	public GetRoamingStatusResponse() {
	}

	public GetRoamingStatusResponse(boolean successful, String code, String message) {
		super(successful, code, message);
	}

	/**
	 * @return the voiceRoamingStatus
	 */
	public SubscriptionStatus getVoiceRoamingStatus() {
		return voiceRoamingStatus;
	}

	/**
	 * @param voiceRoamingStatus the voiceRoamingStatus to set
	 */
	public void setVoiceRoamingStatus(SubscriptionStatus voiceRoamingStatus) {
		this.voiceRoamingStatus = voiceRoamingStatus;
	}

	/**
	 * @return the smsRoamingStatus
	 */
	public SubscriptionStatus getSmsRoamingStatus() {
		return smsRoamingStatus;
	}

	/**
	 * @param smsRoamingStatus the smsRoamingStatus to set
	 */
	public void setSmsRoamingStatus(SubscriptionStatus smsRoamingStatus) {
		this.smsRoamingStatus = smsRoamingStatus;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GetRoamingStatusResponse [voiceRoamingStatus=");
		builder.append(voiceRoamingStatus);
		builder.append(", smsRoamingStatus=");
		builder.append(smsRoamingStatus);
		builder.append(", successful=");
		builder.append(successful);
		builder.append(", code=");
		builder.append(code);
		builder.append(", message=");
		builder.append(message);
		builder.append("]");
		return builder.toString();
	}
}
