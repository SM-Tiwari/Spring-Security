/**
 * 
 */
package com.gnv.vnm.selfcare.webapi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.gnv.vnm.selfcare.core.enums.SelfPackageCycle;

/**
 * @author nandipinto
 *
 */
public class SelfPackageRequest implements Serializable {

	private static final long serialVersionUID = 6999598607003570015L;

	private String msisdn;
	private String packageId;
	private String description;
	private String cycle = SelfPackageCycle.MONTHLY.name();
	private List<SelfPackageBalance> balanceList = new ArrayList<>();
	private double chargingAmount = 0.0;
	
	public SelfPackageRequest() { }

	/**
	 * @return the msisdn
	 */
	public String getMsisdn() {
		return msisdn;
	}

	/**
	 * @param msisdn the msisdn to set
	 */
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	/**
	 * @return the packageId
	 */
	public String getPackageId() {
		return packageId;
	}

	/**
	 * @param packageId the packageId to set
	 */
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the cycle
	 */
	public String getCycle() {
		return cycle;
	}

	/**
	 * @param cycle the cycle to set
	 */
	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

	/**
	 * @return the balanceList
	 */
	public List<SelfPackageBalance> getBalanceList() {
		return balanceList;
	}

	/**
	 * @param balanceList the balanceList to set
	 */
	public void setBalanceList(List<SelfPackageBalance> balanceList) {
		this.balanceList = balanceList;
	}

	/**
	 * @return the chargingAmount
	 */
	public double getChargingAmount() {
		return chargingAmount;
	}

	/**
	 * @param chargingAmount the chargingAmount to set
	 */
	public void setChargingAmount(double chargingAmount) {
		this.chargingAmount = chargingAmount;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((msisdn == null) ? 0 : msisdn.hashCode());
		result = prime * result + ((packageId == null) ? 0 : packageId.hashCode());
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
		SelfPackageRequest other = (SelfPackageRequest) obj;
		if (msisdn == null) {
			if (other.msisdn != null)
				return false;
		} else if (!msisdn.equals(other.msisdn))
			return false;
		if (packageId == null) {
			if (other.packageId != null)
				return false;
		} else if (!packageId.equals(other.packageId))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SelfPackageRequest [msisdn=");
		builder.append(msisdn);
		builder.append(", packageId=");
		builder.append(packageId);
		builder.append(", description=");
		builder.append(description);
		builder.append(", cycle=");
		builder.append(cycle);
		builder.append(", balanceList=");
		builder.append(balanceList);
		builder.append(", chargingAmount=");
		builder.append(chargingAmount);
		builder.append("]");
		return builder.toString();
	}
	
}