/**
 * 
 */
package com.gnv.vnm.selfcare.core.adapter.vasman;

import java.util.ArrayList;
import java.util.List;

import com.gnv.vnm.selfcare.core.adapter.BackEndAdapterRequest;
import com.gnv.vnm.selfcare.core.enums.SelfPackageCycle;

/**
 * @author nandipinto
 *
 */
public class VASManSelfPackageRequest extends BackEndAdapterRequest{

	private static final long serialVersionUID = 8704046559547971156L;
	
	private String msisdn;
	private String packageId;
	private String description;
	private SelfPackageCycle cycle = SelfPackageCycle.MONTHLY;
	private int numOfDays;
	private List<VASManSelfPackageBalance> balanceList = new ArrayList<>();
	private double chargingAmount = 0.0;
	
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
	public SelfPackageCycle getCycle() {
		return cycle;
	}
	/**
	 * @param cycle the cycle to set
	 */
	public void setCycle(SelfPackageCycle cycle) {
		this.cycle = cycle;
	}
	/**
	 * @return the numOfDays
	 */
	public int getNumOfDays() {
		return numOfDays;
	}
	/**
	 * @param numOfDays the numOfDays to set
	 */
	public void setNumOfDays(int numOfDays) {
		this.numOfDays = numOfDays;
	}
	/**
	 * @return the balanceList
	 */
	public List<VASManSelfPackageBalance> getBalanceList() {
		return balanceList;
	}
	/**
	 * @param balanceList the balanceList to set
	 */
	public void setBalanceList(List<VASManSelfPackageBalance> balanceList) {
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
		VASManSelfPackageRequest other = (VASManSelfPackageRequest) obj;
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
		builder.append("VASManSelfPackageRequest [msisdn=");
		builder.append(msisdn);
		builder.append(", packageId=");
		builder.append(packageId);
		builder.append(", description=");
		builder.append(description);
		builder.append(", cycle=");
		builder.append(cycle);
		builder.append(", numOfDays=");
		builder.append(numOfDays);
		builder.append(", balanceList=");
		builder.append(balanceList);
		builder.append(", chargingAmount=");
		builder.append(chargingAmount);
		builder.append("]");
		return builder.toString();
	}

}
