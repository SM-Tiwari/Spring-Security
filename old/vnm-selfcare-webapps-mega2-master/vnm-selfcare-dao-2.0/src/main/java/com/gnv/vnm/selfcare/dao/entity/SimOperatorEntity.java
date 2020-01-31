package com.gnv.vnm.selfcare.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "sim_operator", uniqueConstraints = {@UniqueConstraint(columnNames = "OPERATOR_ID")})
@SequenceGenerator(name = "sim_operator_seq", sequenceName = "sim_operator_seq", allocationSize = 1)
public class SimOperatorEntity extends BaseEntity{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sim_operator_seq")
	@Column(name = "OPERATOR_ID")
	private Integer operatorId;
	
	@Column(name = "OPERATOR_NAME")
	private String operatorName;
	
	@Column(name = "OPERATOR_STATUS")
	private Integer operatorStatus;
	
	public SimOperatorEntity() {
		 
	}

	public SimOperatorEntity(Integer operatorId, String operatorName, Integer operatorStatus) {
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
		int result = super.hashCode();
		result = prime * result + ((operatorId == null) ? 0 : operatorId.hashCode());
		result = prime * result + ((operatorName == null) ? 0 : operatorName.hashCode());
		result = prime * result + ((operatorStatus == null) ? 0 : operatorStatus.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimOperatorEntity other = (SimOperatorEntity) obj;
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

	
}
