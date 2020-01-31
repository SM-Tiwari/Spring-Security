/**
 * 
 */
package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;

/**
 * @author nandipinto
 *
 */
public class SelfPackagePriceMapping implements Serializable {

	private static final long serialVersionUID = 8718760587973077079L;

	private String type;
	private int minAmount;
	private int maxAmount;
	private double price;
	private double normalPrice;
	private int cycle;
	
	public SelfPackagePriceMapping() { }

	public SelfPackagePriceMapping(String type, int mintAmount, int maxAmount, double price, double normalPrice, int cycle) {
		this.type = type;
		this.minAmount = mintAmount;
		this.maxAmount = maxAmount;
		this.price = price;
		this.normalPrice = normalPrice;
		this.cycle = cycle;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the minAmount
	 */
	public int getMinAmount() {
		return minAmount;
	}

	/**
	 * @param minAmount the minAmount to set
	 */
	public void setMinAmount(int amount) {
		this.minAmount = amount;
	}

	/**
	 * @return the maxAmount
	 */
	public int getMaxAmount() {
		return maxAmount;
	}

	/**
	 * @param maxAmount the maxAmount to set
	 */
	public void setMaxAmount(int maxAmount) {
		this.maxAmount = maxAmount;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the normalPrice
	 */
	public double getNormalPrice() {
		return normalPrice;
	}

	/**
	 * @param normalPrice the normalPrice to set
	 */
	public void setNormalPrice(double normalPrice) {
		this.normalPrice = normalPrice;
	}

	/**
	 * @return the cycle
	 */
	public int getCycle() {
		return cycle;
	}

	/**
	 * @param cycle the cycle to set
	 */
	public void setCycle(int cycle) {
		this.cycle = cycle;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + minAmount;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		SelfPackagePriceMapping other = (SelfPackagePriceMapping) obj;
		if (minAmount != other.minAmount)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SelfPackagePriceMapping [type=");
		builder.append(type);
		builder.append(", minAmount=");
		builder.append(minAmount);
		builder.append(", maxAmount=");
		builder.append(maxAmount);
		builder.append(", price=");
		builder.append(price);
		builder.append(", normalPrice=");
		builder.append(normalPrice);
		builder.append(", cycle=");
		builder.append(cycle);
		builder.append("]");
		return builder.toString();
	}

}
