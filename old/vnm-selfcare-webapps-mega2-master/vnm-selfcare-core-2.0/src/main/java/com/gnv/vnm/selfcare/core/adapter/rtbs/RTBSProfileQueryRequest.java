/**
 * RTBSProfileQueryRequest.java
 */
package com.gnv.vnm.selfcare.core.adapter.rtbs;

import java.util.Date;

import com.gnv.vnm.selfcare.core.adapter.BackEndAdapterRequest;

/**
 * @author nandipinto
 *
 */
public class RTBSProfileQueryRequest extends BackEndAdapterRequest {

	private static final long serialVersionUID = 8063183944564244689L;
	
	private String subscriberId;			//MSISDN
	private String identity;
	private Date startDate;
	private Date endDate;
	private int informationToRetrieve;	//see RTBSSubscriberInfoTypeValues enum
	private boolean withHistory;

	public RTBSProfileQueryRequest() {}

	/**
	 * @param subscriberId
	 * @param identity
	 * @param startDate
	 * @param endDate
	 * @param informationToRetrieve
	 * @param withHistory
	 */
	public RTBSProfileQueryRequest(String subscriberId, String identity, Date startDate, Date endDate,
			int informationToRetrieve, boolean withHistory) {
		this.subscriberId = subscriberId;
		this.identity = identity;
		this.startDate = startDate;
		this.endDate = endDate;
		this.informationToRetrieve = informationToRetrieve;
		this.withHistory = withHistory;
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
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the informationToRetrieve
	 */
	public int getInformationToRetrieve() {
		return informationToRetrieve;
	}

	/**
	 * @param informationToRetrieve the informationToRetrieve to set
	 */
	public void setInformationToRetrieve(int informationToRetrieve) {
		this.informationToRetrieve = informationToRetrieve;
	}

	/**
	 * @return the withHistory
	 */
	public boolean isWithHistory() {
		return withHistory;
	}

	/**
	 * @param withHistory the withHistory to set
	 */
	public void setWithHistory(boolean withHistory) {
		this.withHistory = withHistory;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((identity == null) ? 0 : identity.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((subscriberId == null) ? 0 : subscriberId.hashCode());
		result = prime * result + informationToRetrieve;
		result = prime * result + (withHistory ? 1231 : 1237);
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
		RTBSProfileQueryRequest other = (RTBSProfileQueryRequest) obj;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (identity == null) {
			if (other.identity != null)
				return false;
		} else if (!identity.equals(other.identity))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (subscriberId == null) {
			if (other.subscriberId != null)
				return false;
		} else if (!subscriberId.equals(other.subscriberId))
			return false;
		if (informationToRetrieve != other.informationToRetrieve)
			return false;
		if (withHistory != other.withHistory)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RTBSProfileQueryRequest [subscriberId=");
		builder.append(subscriberId);
		builder.append(", identity=");
		builder.append(identity);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append(", informationToRetrieve=");
		builder.append(informationToRetrieve);
		builder.append(", withHistory=");
		builder.append(withHistory);
		builder.append(", requestId=");
		builder.append(requestId);
		builder.append(", requestType=");
		builder.append(requestType);
		builder.append(", timeStamp=");
		builder.append(timeStamp);
		builder.append("]");
		return builder.toString();
	}
	
}
