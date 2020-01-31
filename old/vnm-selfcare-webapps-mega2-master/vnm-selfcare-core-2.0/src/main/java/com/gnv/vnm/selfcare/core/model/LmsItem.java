/**
 * LmsItem.java
 */
package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;

/**
 * @author nandipinto
 *
 */
public class LmsItem implements Serializable {

	private static final long serialVersionUID = 1173586707395249717L;
	
	private String keyword;
	private String itemName;
	private String displayNameEN;
	private String displayNameVN;
	private int monsterWeight;
	private String monsterImage;
	
	public LmsItem(){ }
	
	public LmsItem(String keyword, String itemName, int monsterWeight) {
		this.keyword = keyword;
		this.itemName = itemName;
		this.monsterWeight = monsterWeight;
	}

	/**
	 * @return the keyword
	 */
	public String getKeyword() {
		return keyword;
	}
	/**
	 * @param keyword the keyword to set
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}
	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	/**
	 * @return the displayNameEN
	 */
	public String getDisplayNameEN() {
		return displayNameEN;
	}

	/**
	 * @param displayNameEN the displayNameEN to set
	 */
	public void setDisplayNameEN(String displayNameEN) {
		this.displayNameEN = displayNameEN;
	}

	/**
	 * @return the displayNameVN
	 */
	public String getDisplayNameVN() {
		return displayNameVN;
	}

	/**
	 * @param displayNameVN the displayNameVN to set
	 */
	public void setDisplayNameVN(String displayNameVN) {
		this.displayNameVN = displayNameVN;
	}

	/**
	 * @return the monsterWeight
	 */
	public int getMonsterWeight() {
		return monsterWeight;
	}
	/**
	 * @param monsterWeight the monsterWeight to set
	 */
	public void setMonsterWeight(int monsterWeight) {
		this.monsterWeight = monsterWeight;
	}

	/**
	 * @return the monsterImage
	 */
	public String getMonsterImage() {
		return monsterImage;
	}

	/**
	 * @param monsterImage the monsterImage to set
	 */
	public void setMonsterImage(String monsterImage) {
		this.monsterImage = monsterImage;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((keyword == null) ? 0 : keyword.hashCode());
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
		LmsItem other = (LmsItem) obj;
		if (keyword == null) {
			if (other.keyword != null)
				return false;
		} else if (!keyword.equals(other.keyword))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LmsItem [keyword=");
		builder.append(keyword);
		builder.append(", itemName=");
		builder.append(itemName);
		builder.append(", displayNameEN=");
		builder.append(displayNameEN);
		builder.append(", displayNameVN=");
		builder.append(displayNameVN);
		builder.append(", monsterWeight=");
		builder.append(monsterWeight);
		builder.append("]");
		return builder.toString();
	}

}
