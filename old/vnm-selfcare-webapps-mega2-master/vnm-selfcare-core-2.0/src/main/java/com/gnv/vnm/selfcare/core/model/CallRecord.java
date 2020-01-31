/**
 * CallRecord.java
 */
package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gnv.vnm.selfcare.core.enums.CallDirection;
import com.gnv.vnm.selfcare.core.enums.CallType;

/**
 * @author nandipinto
 *
 */
public class CallRecord implements Serializable {

	private static final long serialVersionUID = -2539440394197201488L;

	@JsonIgnore
	private Date startTime;
	private String startTimeAsString;
	@JsonIgnore
	private Date endTime;
	private String endTimeAsString;
	private String calledNumber;
	private long duration;
	private CallDirection direction;
	private CallType callType;
	
	public CallRecord(){ }

	/**
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return the startTimeAsString
	 */
	public String getStartTimeAsString() {
		return startTimeAsString;
	}

	/**
	 * @param startTimeAsString the startTimeAsString to set
	 */
	public void setStartTimeAsString(String startTimeAsString) {
		this.startTimeAsString = startTimeAsString;
	}

	/**
	 * @return the endTimeAsString
	 */
	public String getEndTimeAsString() {
		return endTimeAsString;
	}

	/**
	 * @param endTimeAsString the endTimeAsString to set
	 */
	public void setEndTimeAsString(String endTimeAsString) {
		this.endTimeAsString = endTimeAsString;
	}

	/**
	 * @return the calledNumber
	 */
	public String getCalledNumber() {
		return calledNumber;
	}

	/**
	 * @param calledNumber the calledNumber to set
	 */
	public void setCalledNumber(String calledNumber) {
		this.calledNumber = calledNumber;
	}

	/**
	 * @return the duration
	 */
	public long getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(long duration) {
		this.duration = duration;
	}

	/**
	 * @return the direction
	 */
	public CallDirection getDirection() {
		return direction;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(CallDirection direction) {
		this.direction = direction;
	}

	/**
	 * @return the callType
	 */
	public CallType getCallType() {
		return callType;
	}

	/**
	 * @param callType the callType to set
	 */
	public void setCallType(CallType callType) {
		this.callType = callType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((callType == null) ? 0 : callType.hashCode());
		result = prime * result + ((calledNumber == null) ? 0 : calledNumber.hashCode());
		result = prime * result + ((direction == null) ? 0 : direction.hashCode());
		result = prime * result + (int) (duration ^ (duration >>> 32));
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
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
		CallRecord other = (CallRecord) obj;
		if (callType != other.callType)
			return false;
		if (calledNumber == null) {
			if (other.calledNumber != null)
				return false;
		} else if (!calledNumber.equals(other.calledNumber))
			return false;
		if (direction != other.direction)
			return false;
		if (duration != other.duration)
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CallRecord [startTime=");
		builder.append(startTime);
		builder.append(", endTime=");
		builder.append(endTime);
		builder.append(", calledNumber=");
		builder.append(calledNumber);
		builder.append(", duration=");
		builder.append(duration);
		builder.append(", direction=");
		builder.append(direction);
		builder.append(", callType=");
		builder.append(callType);
		builder.append("]");
		return builder.toString();
	}
	
	public static class CallRecordTimeDescComparator implements Comparator<CallRecord>{

		@Override
		public int compare(CallRecord o1, CallRecord o2) {
			if (o1.endTime == null || o2.endTime == null) return 0;
			
			return o2.endTime.compareTo(o1.endTime);
		}
	}

	public static class CallRecordTimeAscComparator implements Comparator<CallRecord>{

		@Override
		public int compare(CallRecord o1, CallRecord o2) {
			if (o1.endTime == null || o2.endTime == null) return 0;
			
			return o1.endTime.compareTo(o2.endTime);
		}
	}

}
