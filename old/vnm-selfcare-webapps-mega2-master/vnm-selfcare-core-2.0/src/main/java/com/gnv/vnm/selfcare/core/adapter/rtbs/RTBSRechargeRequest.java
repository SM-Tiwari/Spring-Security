/**
 * RTBSRechargeRequest.java
 */
package com.gnv.vnm.selfcare.core.adapter.rtbs;

import java.util.Date;

import com.gnv.vnm.selfcare.core.adapter.BackEndAdapterRequest;
import com.gnv.vnm.selfcare.core.enums.RequestType;
import com.gnv.vnm.selfcare.core.enums.TopUpType;

/**
 * @author nandipinto
 *
 */
public class RTBSRechargeRequest extends BackEndAdapterRequest {

	private static final long serialVersionUID = 52960736156008940L;
	
	private String subscriberId;
	private String identity;
	private String voucherCode;
	private double amount;
	private String comment;
	private TopUpType type = TopUpType.SCRATCH_CARD;
	
	public RTBSRechargeRequest() {}
	
	/**
	 * @param requestId
	 * @param timeStamp
	 */
	public RTBSRechargeRequest(String requestId, Date timeStamp) {
		super(requestId, RequestType.UPDATE, timeStamp);
	}

	/**
	 * @param subscriberId
	 * @param voucherCode
	 * @param amount
	 * @param comment
	 */
	public RTBSRechargeRequest(String requestId, Date timeStamp, String subscriberId, String identity, String voucherCode, double amount, String comment) {
		this(requestId, timeStamp);
		this.subscriberId = subscriberId;
		this.identity = identity;
		this.voucherCode = voucherCode;
		this.amount = amount;
		this.comment = comment;
	}

	/**
	 * @return the subscriberId
	 */
	public String getSubscriberId() {
		return subscriberId;
	}

	/**
	 * @param subscriberId the subscriberId to set
	 */
	public void setSubscriberId(String subscriberId) {
		this.subscriberId = subscriberId;
	}

	/**
	 * @return the identity
	 */
	public String getIdentity() {
		return identity;
	}

	/**
	 * @param identity the identity to set
	 */
	public void setIdentity(String identity) {
		this.identity = identity;
	}

	/**
	 * @return the voucherCode
	 */
	public String getVoucherCode() {
		return voucherCode;
	}

	/**
	 * @param voucherCode the voucherCode to set
	 */
	public void setVoucherCode(String voucherCode) {
		this.voucherCode = voucherCode;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the type
	 */
	public TopUpType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(TopUpType type) {
		this.type = type;
	}
	

}
