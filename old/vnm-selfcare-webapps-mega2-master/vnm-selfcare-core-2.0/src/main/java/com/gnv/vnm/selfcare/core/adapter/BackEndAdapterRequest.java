/**
 * 
 */
package com.gnv.vnm.selfcare.core.adapter;

import java.io.Serializable;
import java.util.Date;

import com.gnv.vnm.selfcare.core.enums.RequestType;

/**
 * @author nandipinto
 *
 */
public abstract class BackEndAdapterRequest implements Serializable{

	private static final long serialVersionUID = 5318833801608659851L;
	
	protected String requestId;
	protected RequestType requestType;
	protected Date timeStamp = new Date();
	
	public BackEndAdapterRequest(){ }
	
	/**
	 * @param requestId
	 * @param requestType
	 * @param timeStamp
	 */
	public BackEndAdapterRequest(String requestId, RequestType requestType, Date timeStamp) {
		this.requestId = requestId;
		this.requestType = requestType;
		this.timeStamp = timeStamp;
	}

	/**
	 * @return the requestId
	 */
	public String getRequestId() {
		return requestId;
	}
	
	/**
	 * @param requestId the requestId to set
	 */
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	
	/**
	 * @return the requestType
	 */
	public RequestType getRequestType() {
		return requestType;
	}
	
	/**
	 * @param requestType the requestType to set
	 */
	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((requestId == null) ? 0 : requestId.hashCode());
		result = prime * result + ((requestType == null) ? 0 : requestType.hashCode());
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
		BackEndAdapterRequest other = (BackEndAdapterRequest) obj;
		if (requestId == null) {
			if (other.requestId != null)
				return false;
		} else if (!requestId.equals(other.requestId))
			return false;
		if (requestType != other.requestType)
			return false;
		return true;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BackEndAdapterRequest [requestId=");
		builder.append(requestId);
		builder.append(", requestType=");
		builder.append(requestType);
		builder.append(", timeStamp=");
		builder.append(timeStamp);
		builder.append("]");
		return builder.toString();
	}
}
