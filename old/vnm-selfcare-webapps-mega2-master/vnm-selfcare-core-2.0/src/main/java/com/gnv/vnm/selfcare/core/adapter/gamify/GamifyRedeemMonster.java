/**
 * GamifyRedeemMonster.java
 */
package com.gnv.vnm.selfcare.core.adapter.gamify;

import java.io.Serializable;

/**
 * @author nandipinto
 *
 */
public class GamifyRedeemMonster implements Serializable {

	private static final long serialVersionUID = 28019731105464131L;

	private String itemID;
	private String num;

	public GamifyRedeemMonster(){}

	public GamifyRedeemMonster(String itemID, String num) {
		this.itemID = itemID;
		this.num = num;
	}

	/**
	 * @return the itemID
	 */
	public String getItemID() {
		return itemID;
	}

	/**
	 * @param itemID the itemID to set
	 */
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	/**
	 * @return the num
	 */
	public String getNum() {
		return num;
	}

	/**
	 * @param num the num to set
	 */
	public void setNum(String num) {
		this.num = num;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemID == null) ? 0 : itemID.hashCode());
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
		GamifyRedeemMonster other = (GamifyRedeemMonster) obj;
		if (itemID == null) {
			if (other.itemID != null)
				return false;
		} else if (!itemID.equals(other.itemID))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GamifyRedeemMonster [itemID=");
		builder.append(itemID);
		builder.append(", num=");
		builder.append(num);
		builder.append("]");
		return builder.toString();
	}
	
}
