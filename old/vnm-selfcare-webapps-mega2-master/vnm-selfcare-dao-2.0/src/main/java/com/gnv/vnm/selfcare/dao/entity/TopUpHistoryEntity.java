/**
 * TopUpHistoryEntity.java
 */
package com.gnv.vnm.selfcare.dao.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * @author nandipinto
 *
 */

@Entity
@Table(name = "topup_history", indexes = {
		@Index(columnList = "msisdn"), @Index(columnList = "voucher_code"), @Index(columnList = "trx_dtm") })
@SequenceGenerator(name = "topup_hist_seq", sequenceName = "topup_hist_seq", allocationSize = 1)
public class TopUpHistoryEntity extends BaseEntity {

	private static final long serialVersionUID = -5027352163052435955L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "topup_hist_seq")
	@Column(name = "id")
	private Integer id;
	
	@Column(length = 20, nullable = false)
	private String msisdn;
	
	@Column(name = "voucher_code", length = 100)
	private String voucherCode;
	
	@Column(name = "channel_id", length = 20)
	private String channelId;
	
	@Column(name = "amount")
	private Double amount;
	
	@Column(name = "recharge_amount")
	private Double recharge_amount;
	
	@Column(name = "trx_dtm")
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeStamp;
	
	@Column(name = "status")
	private Integer status;
	
	@Column(name = "ref_trx_id")
	private String refTrxId;
	
	@Column(name = "client_app_id")
	private String clientAppId;
	
	@Column(name = "referrer", length = 20)
	private String referrer;
	
	@Column(name = "ref_session_id")
	private String sessionId;
	
	
	
	public TopUpHistoryEntity(){ }

	/**
	 * @param id
	 * @param msisdn
	 * @param voucherCode
	 * @param amount
	 * @param timeStamp
	 * @param status
	 */
	public TopUpHistoryEntity(Integer id, String msisdn, String voucherCode, Double amount, Date timeStamp,
			Integer status) {
		this.id = id;
		this.msisdn = msisdn;
		this.voucherCode = voucherCode;
		this.amount = amount;
		this.timeStamp = timeStamp;
		this.status = status;
	}

	/**
	 * @param msisdn
	 * @param voucherCode
	 * @param amount
	 * @param timeStamp
	 * @param status
	 */
	public TopUpHistoryEntity(String msisdn, String voucherCode, Double amount, Date timeStamp, Integer status) {
		this.msisdn = msisdn;
		this.voucherCode = voucherCode;
		this.amount = amount;
		this.timeStamp = timeStamp;
		this.status = status;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	public Double getRecharge_amount() {
		return recharge_amount;
	}

	public void setRecharge_amount(Double recharge_amount) {
		this.recharge_amount = recharge_amount;
	}

	/**
	 * @return the msisdn
	 */
	public String getMsisdn() {
		return msisdn;
	}

	/**
	 * @param msisdn the msisdn to set
	 */
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	/**
	 * @return the channelId
	 */
	public String getChannelId() {
		return channelId;
	}

	/**
	 * @param channelId the channelId to set
	 */
	public void setChannelId(String channelId) {
		this.channelId = channelId;
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
	public Double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * @return the timeStamp
	 */
	public Date getTimeStamp() {
		return timeStamp;
	}

	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	/**
	 * @return the refTrxId
	 */
	public String getRefTrxId() {
		return refTrxId;
	}

	/**
	 * @param refTrxId the refTrxId to set
	 */
	public void setRefTrxId(String refTrxId) {
		this.refTrxId = refTrxId;
	}

	/**
	 * @return the clientAppId
	 */
	public String getClientAppId() {
		return clientAppId;
	}

	/**
	 * @param clientAppId the clientAppId to set
	 */
	public void setClientAppId(String clientAppId) {
		this.clientAppId = clientAppId;
	}

	/**
	 * @return the referrer
	 */
	public String getReferrer() {
		return referrer;
	}

	/**
	 * @param referrer the referrer to set
	 */
	public void setReferrer(String referrer) {
		this.referrer = referrer;
	}

	/**
	 * @return the sessionId
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((msisdn == null) ? 0 : msisdn.hashCode());
		result = prime * result + ((voucherCode == null) ? 0 : voucherCode.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TopUpHistoryEntity other = (TopUpHistoryEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (msisdn == null) {
			if (other.msisdn != null)
				return false;
		} else if (!msisdn.equals(other.msisdn))
			return false;
		if (voucherCode == null) {
			if (other.voucherCode != null)
				return false;
		} else if (!voucherCode.equals(other.voucherCode))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TopUpHistoryEntity [id=");
		builder.append(id);
		builder.append(", msisdn=");
		builder.append(msisdn);
		builder.append(", voucherCode=");
		builder.append(voucherCode);
		builder.append(", channelId=");
		builder.append(channelId);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", timeStamp=");
		builder.append(timeStamp);
		builder.append(", status=");
		builder.append(status);
		builder.append(", refTrxId=");
		builder.append(refTrxId);
		builder.append(", clientAppId=");
		builder.append(clientAppId);
		builder.append(", referrer=");
		builder.append(referrer);
		builder.append(", sessionId=");
		builder.append(sessionId);
		builder.append("]");
		return builder.toString();
	}
	
}
