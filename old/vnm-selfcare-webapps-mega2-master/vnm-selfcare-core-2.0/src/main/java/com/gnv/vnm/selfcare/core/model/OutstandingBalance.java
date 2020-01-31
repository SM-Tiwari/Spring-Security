/**
 * Mar 12, 2018 11:01:25 AM
 */
package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gnv.vnm.selfcare.core.enums.BillPaymentStatus;

/**
 * @author nandipinto
 *
 */
public class OutstandingBalance implements Serializable {

	private static final long serialVersionUID = 4917553682759927085L;

	private double amount = 0.0;
	private BillPaymentStatus status = BillPaymentStatus.UNPAID;
	private String dueDate = "";
	@JsonIgnore
	private Date dueDateAsDate;
	
	public Date getDueDateAsDate() {
		return dueDateAsDate;
	}
	public void setDueDateAsDate(Date dueDateAsDate) {
		this.dueDateAsDate = dueDateAsDate;
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
	 * @return the status
	 */
	public BillPaymentStatus getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(BillPaymentStatus status) {
		this.status = status;
	}
	/**
	 * @return the dueDate
	 */
	public String getDueDate() {
		return dueDate;
	}
	/**
	 * @param dueDate the dueDate to set
	 */
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		OutstandingBalance other = (OutstandingBalance) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (dueDate == null) {
			if (other.dueDate != null)
				return false;
		} else if (!dueDate.equals(other.dueDate))
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OutstandingBalance [amount=");
		builder.append(amount);
		builder.append(", status=");
		builder.append(status);
		builder.append(", dueDate=");
		builder.append(dueDate);
		builder.append("]");
		return builder.toString();
	}
	
}
