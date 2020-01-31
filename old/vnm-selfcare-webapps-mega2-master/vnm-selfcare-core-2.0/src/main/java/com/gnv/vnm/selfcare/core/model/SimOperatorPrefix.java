package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonIgnore;



public class SimOperatorPrefix implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8369177483089236627L;
	@JsonIgnore
	private Integer id;
	@JsonIgnore
	private Integer operatorId;

	private String oldPrefix;
	
	private String newPrefix;
	
	private String simOperatorName;
	
	private Integer operatorPrefixStatus;

	
	
	public SimOperatorPrefix() {
		super();
	}

	
	


	public SimOperatorPrefix(Integer operatorId, String oldPrefix, String newPrefix) {
		super();
		this.operatorId = operatorId;
		this.oldPrefix = oldPrefix;
		this.newPrefix = newPrefix;
	}





	 
	
	
	public SimOperatorPrefix(Integer id, Integer operatorId, String oldPrefix, String newPrefix) {
		super();
		this.id = id;
		this.operatorId = operatorId;
		this.oldPrefix = oldPrefix;
		this.newPrefix = newPrefix;
	}






	public SimOperatorPrefix(Integer operatorId, String oldPrefix, String newPrefix, String simOperatorName,
			Integer operatorPrefixStatus) {
		super();
		this.operatorId = operatorId;
		this.oldPrefix = oldPrefix;
		this.newPrefix = newPrefix;
		this.simOperatorName = simOperatorName;
		this.operatorPrefixStatus = operatorPrefixStatus;
	}





	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}

	
	

	public String getOldPrefix() {
		return oldPrefix;
	}





	public void setOldPrefix(String oldPrefix) {
		this.oldPrefix = oldPrefix;
	}





	public String getNewPrefix() {
		return newPrefix;
	}





	public void setNewPrefix(String newPrefix) {
		this.newPrefix = newPrefix;
	}





	public String getSimOperatorName() {
		return simOperatorName;
	}



	public void setSimOperatorName(String simOperatorName) {
		this.simOperatorName = simOperatorName;
	}



	public Integer getOperatorPrefixStatus() {
		return operatorPrefixStatus;
	}



	public void setOperatorPrefixStatus(Integer operatorPrefixStatus) {
		this.operatorPrefixStatus = operatorPrefixStatus;
	}



	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((newPrefix == null) ? 0 : newPrefix.hashCode());
		result = prime * result + ((oldPrefix == null) ? 0 : oldPrefix.hashCode());
		result = prime * result + ((operatorId == null) ? 0 : operatorId.hashCode());
		result = prime * result + ((operatorPrefixStatus == null) ? 0 : operatorPrefixStatus.hashCode());
		result = prime * result + ((simOperatorName == null) ? 0 : simOperatorName.hashCode());
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
		SimOperatorPrefix other = (SimOperatorPrefix) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (newPrefix == null) {
			if (other.newPrefix != null)
				return false;
		} else if (!newPrefix.equals(other.newPrefix))
			return false;
		if (oldPrefix == null) {
			if (other.oldPrefix != null)
				return false;
		} else if (!oldPrefix.equals(other.oldPrefix))
			return false;
		if (operatorId == null) {
			if (other.operatorId != null)
				return false;
		} else if (!operatorId.equals(other.operatorId))
			return false;
		if (operatorPrefixStatus == null) {
			if (other.operatorPrefixStatus != null)
				return false;
		} else if (!operatorPrefixStatus.equals(other.operatorPrefixStatus))
			return false;
		if (simOperatorName == null) {
			if (other.simOperatorName != null)
				return false;
		} else if (!simOperatorName.equals(other.simOperatorName))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "SimOperatorPrefix [id=" + id + ", operatorId=" + operatorId + ", oldPrefix=" + oldPrefix
				+ ", newPrefix=" + newPrefix + ", simOperatorName=" + simOperatorName + ", operatorPrefixStatus="
				+ operatorPrefixStatus + "]";
	}



}
