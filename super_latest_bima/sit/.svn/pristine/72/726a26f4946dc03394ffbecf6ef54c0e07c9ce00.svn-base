/**
 * MyDataBalance.java
 */
package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nandipinto
 *
 */
public class MyDataBalance implements Serializable {

	private static final long serialVersionUID = 2561507410438959156L;

	private String name;
	private long totalValue; 
	private long availableValue;
	private long consumedValue;
	private List<DataBalance> balanceList = new ArrayList<>();
	
	public MyDataBalance(){ }

	public MyDataBalance(String name, long totalValue, long consumedValue, long availableValue, List<DataBalance> balanceList) {
		this.name = name;
		this.totalValue = totalValue;
		this.consumedValue = consumedValue;
		this.availableValue = availableValue;
		this.balanceList = balanceList;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the totalValue
	 */
	public long getTotalValue() {
		return totalValue;
	}
	/**
	 * @param totalValue the totalValue to set
	 */
	public void setTotalValue(long totalValue) {
		this.totalValue = totalValue;
	}
	/**
	 * @return the availableValue
	 */
	public long getAvailableValue() {
		return availableValue;
	}
	/**
	 * @param availableValue the availableValue to set
	 */
	public void setAvailableValue(long availableValue) {
		this.availableValue = availableValue;
	}
	
	/**
	 * @return the consumedValue
	 */
	public long getConsumedValue() {
		return consumedValue;
	}

	/**
	 * @param consumedValue the consumedValue to set
	 */
	public void setConsumedValue(long consumedValue) {
		this.consumedValue = consumedValue;
	}

	/**
	 * @return the balanceList
	 */
	public List<DataBalance> getBalanceList() {
		return balanceList;
	}
	/**
	 * @param balanceList the balanceList to set
	 */
	public void setBalanceList(List<DataBalance> balanceList) {
		this.balanceList = balanceList;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MyDataBalance [name=");
		builder.append(name);
		builder.append(", totalValue=");
		builder.append(totalValue);
		builder.append(", availableValue=");
		builder.append(availableValue);
		builder.append(", consumedValue=");
		builder.append(consumedValue);
		builder.append(", balanceList=");
		builder.append(balanceList);
		builder.append("]");
		return builder.toString();
	}
	
	
}
