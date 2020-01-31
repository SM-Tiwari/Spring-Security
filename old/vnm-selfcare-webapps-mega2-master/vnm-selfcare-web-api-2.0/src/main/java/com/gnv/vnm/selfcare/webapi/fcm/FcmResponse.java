/**
 * May 3, 2018 8:58:39 PM
 */
package com.gnv.vnm.selfcare.webapi.fcm;

import java.io.Serializable;

/**
 * @author nandipinto
 *
 */
public class FcmResponse implements Serializable {

	private static final long serialVersionUID = 5998696676557594355L;
	
	public FcmResponse() {}
	
	private String multicast_id;
	private int success = 0;
	private int failure = 0;
	private int canonical_ids = 0;
	
	/**
	 * @return the multicast_id
	 */
	public String getMulticast_id() {
		return multicast_id;
	}
	/**
	 * @param multicast_id the multicast_id to set
	 */
	public void setMulticast_id(String multicast_id) {
		this.multicast_id = multicast_id;
	}
	/**
	 * @return the success
	 */
	public int getSuccess() {
		return success;
	}
	/**
	 * @param success the success to set
	 */
	public void setSuccess(int success) {
		this.success = success;
	}
	/**
	 * @return the failure
	 */
	public int getFailure() {
		return failure;
	}
	/**
	 * @param failure the failure to set
	 */
	public void setFailure(int failure) {
		this.failure = failure;
	}
	
	/**
	 * @return the canonical_ids
	 */
	public int getCanonical_ids() {
		return canonical_ids;
	}
	/**
	 * @param canonical_ids the canonical_ids to set
	 */
	public void setCanonical_ids(int canonical_ids) {
		this.canonical_ids = canonical_ids;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + failure;
		result = prime * result + ((multicast_id == null) ? 0 : multicast_id.hashCode());
		result = prime * result + success;
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
		FcmResponse other = (FcmResponse) obj;
		if (failure != other.failure)
			return false;
		if (multicast_id == null) {
			if (other.multicast_id != null)
				return false;
		} else if (!multicast_id.equals(other.multicast_id))
			return false;
		if (success != other.success)
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FcmResponse [multicast_id=");
		builder.append(multicast_id);
		builder.append(", success=");
		builder.append(success);
		builder.append(", failure=");
		builder.append(failure);
		builder.append(", canonical_ids=");
		builder.append(canonical_ids);
		builder.append("]");
		return builder.toString();
	}

}
