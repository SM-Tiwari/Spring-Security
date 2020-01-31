package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;



public class SimOperator implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -820413927203043203L;
	private Integer operatorId;
	private String operatorName;
	private Integer operatorStatus;
 
	

	public SimOperator() {
		super();
	}


	public SimOperator(Integer operatorId, String operatorName, Integer operatorStatus) {
		super();
		this.operatorId = operatorId;
		this.operatorName = operatorName;
		this.operatorStatus = operatorStatus;
	}



	public Integer getOperatorId() {
		return operatorId;
	}


	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}


	public String getOperatorName() {
		return operatorName;
	}


	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}


	public Integer getOperatorStatus() {
		return operatorStatus;
	}


	public void setOperatorStatus(Integer operatorStatus) {
		this.operatorStatus = operatorStatus;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((operatorId == null) ? 0 : operatorId.hashCode());
		result = prime * result + ((operatorName == null) ? 0 : operatorName.hashCode());
		result = prime * result + ((operatorStatus == null) ? 0 : operatorStatus.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimOperator other = (SimOperator) obj;
		if (operatorId == null) {
			if (other.operatorId != null)
				return false;
		} else if (!operatorId.equals(other.operatorId))
			return false;
		if (operatorName == null) {
			if (other.operatorName != null)
				return false;
		} else if (!operatorName.equals(other.operatorName))
			return false;
		if (operatorStatus == null) {
			if (other.operatorStatus != null)
				return false;
		} else if (!operatorStatus.equals(other.operatorStatus))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "SimOperator [operatorId=" + operatorId + ", operatorName=" + operatorName + ", operatorStatus="
				+ operatorStatus + "]";
	}


}
