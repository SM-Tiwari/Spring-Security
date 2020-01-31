/**
 * 
 */
package com.gnv.vnm.selfcare.core.adapter;

import java.io.Serializable;

import com.gnv.vnm.selfcare.core.enums.RequestStatus;

/**
 * @author nandipinto
 *
 */
public class BackEndAdapterResponse implements Serializable{

	private static final long serialVersionUID = 2238324809349765996L;
	
	protected String originRequestId;
	protected RequestStatus status = RequestStatus.PROCESSING;
	protected Object result;
	protected String responseCode = "0";
	protected String responseDescription = "";
	
	/**
	 * @return the originRequestId
	 */
	public String getOriginRequestId() {
		return originRequestId;
	}
	
	/**
	 * @param originRequestId the originRequestId to set
	 */
	public void setOriginRequestId(String originRequestId) {
		this.originRequestId = originRequestId;
	}
	
	/**
	 * @return the status
	 */
	public RequestStatus getStatus() {
		return status;
	}
	
	/**
	 * @param status the status to set
	 */
	public void setStatus(RequestStatus status) {
		this.status = status;
	}
	
	/**
	 * @return the result
	 */
	public Object getResult() {
		return result;
	}
	
	/**
	 * @param result the result to set
	 */
	public void setResult(Object result) {
		this.result = result;
	}
	
	/**
	 * @return the responseCode
	 */
	public String getResponseCode() {
		return responseCode;
	}

	/**
	 * @param responseCode the responseCode to set
	 */
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * @return the responseDescription
	 */
	public String getResponseDescription() {
		return responseDescription;
	}

	/**
	 * @param responseDescription the responseDescription to set
	 */
	public void setResponseDescription(String responseDescription) {
		this.responseDescription = responseDescription;
	}
	
	public boolean isSuccessful(){
		return status.equals(RequestStatus.SUCCESS);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((originRequestId == null) ? 0 : originRequestId.hashCode());
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
		BackEndAdapterResponse other = (BackEndAdapterResponse) obj;
		if (originRequestId == null) {
			if (other.originRequestId != null)
				return false;
		} else if (!originRequestId.equals(other.originRequestId))
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
		builder.append("BackEndAdapterResponse [status=");
		builder.append(status);
//		builder.append(", result=");
//		builder.append(result);
		builder.append(", responseCode=");
		builder.append(responseCode);
		builder.append(", responseDescription=");
		builder.append(responseDescription);
		builder.append("]");
		return builder.toString();
	}
	
}
