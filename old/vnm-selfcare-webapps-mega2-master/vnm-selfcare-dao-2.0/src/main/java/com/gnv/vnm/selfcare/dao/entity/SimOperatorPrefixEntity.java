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
@Table(name = "sim_operator_prefix", uniqueConstraints = {@UniqueConstraint(columnNames = "ID")})
@SequenceGenerator(name = "sim_operator_prefix_seq", sequenceName = "sim_operator_prefix_seq", allocationSize = 1)
public class SimOperatorPrefixEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -266358786216687593L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sim_operator_prefix_seq")
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "OPERATOR_ID")
	private Integer operatorId;
	
	@Column(name = "OLD_PREFIX")
	private String oldPrefix;
	
	@Column(name = "NEW_PREFIX")
	private String newPrefix;
	
	@Column(name = "SIM_OPERATOR_NAME")
	private String simOperatorName;
	
	@Column(name = "OPERATOR_PREFIX_STATUS")
	private Integer operatorPrefixStatus;


	
	public SimOperatorPrefixEntity() {
		super();
	}
	
	

	public SimOperatorPrefixEntity(Integer id, Integer operatorId, String oldPrefix, String newPrefix,
			String simOperatorName, Integer operatorPrefixStatus) {
		super();
		this.id = id;
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
		int result = super.hashCode();
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
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimOperatorPrefixEntity other = (SimOperatorPrefixEntity) obj;
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
		return "SimOperatorPrefixEntity [id=" + id + ", operatorId=" + operatorId + ", oldPrefix=" + oldPrefix
				+ ", newPrefix=" + newPrefix + ", simOperatorName=" + simOperatorName + ", operatorPrefixStatus="
				+ operatorPrefixStatus + "]";
	}


}
