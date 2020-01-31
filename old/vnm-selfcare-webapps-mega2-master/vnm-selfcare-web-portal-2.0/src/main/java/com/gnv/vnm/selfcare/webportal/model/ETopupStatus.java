/**
 * 
 */
package com.gnv.vnm.selfcare.webportal.model;

import java.io.Serializable;

import com.gnv.vnm.selfcare.core.enums.TransactionStatus;

/**
 * @author nandipinto
 *
 */
public class ETopupStatus implements Serializable {

	private static final long serialVersionUID = 3585878828927429356L;
	
	private String refTrxId;
	private TransactionStatus status;
	private String message;
	
	public ETopupStatus() { }

	public ETopupStatus(String refTrxId, TransactionStatus status) {
		this.refTrxId = refTrxId;
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
	 * @return the status
	 */
	public TransactionStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(TransactionStatus status) {
		this.status = status;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((refTrxId == null) ? 0 : refTrxId.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ETopupStatus other = (ETopupStatus) obj;
		if (refTrxId == null) {
			if (other.refTrxId != null)
				return false;
		} else if (!refTrxId.equals(other.refTrxId))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ETopupStatus [refTrxId=");
		builder.append(refTrxId);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}

}
