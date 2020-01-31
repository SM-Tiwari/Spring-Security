/**
 * MyPromotionBalance.java
 */
package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author nandipinto
 *
 */
public class MyPromotionBalance implements Serializable {

	private static final long serialVersionUID = 4915965919113784484L;

	private int totalValue;
	@JsonIgnore
	private int consumedValue;
	private int availableValue;
	private List<Balance> balanceList = new ArrayList<>();
	@JsonIgnore
	private int totalCoreBalance;
	
	public MyPromotionBalance(){ }
	
	public MyPromotionBalance(int totalValue, int consumedValue, int availableValue, List<Balance> balanceList) {
		this.totalValue = totalValue;
		this.consumedValue = consumedValue;
		this.availableValue = availableValue;
		this.balanceList = balanceList;
	}

	/**
	 * @return the totalValue
	 */
	public int getTotalValue() {
		return totalValue;
	}
	/**
	 * @param totalValue the totalValue to set
	 */
	public void setTotalValue(int totalValue) {
		this.totalValue = totalValue;
	}
	
	/**
	 * @return the consumedValue
	 */
	public int getConsumedValue() {
		return consumedValue;
	}

	/**
	 * @param consumedValue the consumedValue to set
	 */
	public void setConsumedValue(int consumedValue) {
		this.consumedValue = consumedValue;
	}

	/**
	 * @return the availableValue
	 */
	public int getAvailableValue() {
		return availableValue;
	}
	/**
	 * @param availableValue the availableValue to set
	 */
	public void setAvailableValue(int availableValue) {
		this.availableValue = availableValue;
	}
	/**
	 * @return the balanceList
	 */
	public List<Balance> getBalanceList() {
		return balanceList;
	}
	/**
	 * @param balanceList the balanceList to set
	 */
	public void setBalanceList(List<Balance> balanceList) {
		this.balanceList = balanceList;
	}

	/**
	 * @return the totalCoreBalance
	 */
	public int getTotalCoreBalance() {
		return totalCoreBalance;
	}

	/**
	 * @param totalCoreBalance the totalCoreBalance to set
	 */
	public void setTotalCoreBalance(int totalCoreBalance) {
		this.totalCoreBalance = totalCoreBalance;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MyPromotionBalance [totalValue=");
		builder.append(totalValue);
		builder.append(", availableValue=");
		builder.append(availableValue);
		builder.append(", consumedValue=");
		builder.append(consumedValue);
		builder.append(", balanceList=");
		builder.append(balanceList);
		builder.append(", totalCoreBalance=");
		builder.append(totalCoreBalance);
		builder.append("]");
		return builder.toString();
	}

	
}
