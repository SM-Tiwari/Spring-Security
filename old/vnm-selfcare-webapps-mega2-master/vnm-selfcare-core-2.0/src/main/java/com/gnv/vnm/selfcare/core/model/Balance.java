package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gnv.vnm.selfcare.core.enums.BalanceType;
import com.gnv.vnm.selfcare.core.enums.DataBalanceDisplayOption;

/**
 * @author nandipinto
 *
 */
public class Balance implements Serializable {

	private static final long serialVersionUID = 4406139567382676047L;
	
	private BalanceType type;
	private String name = "";
	private int totalValue = 0;
	@JsonIgnore
	private int consumedValue = 0;
	private int availableValue = 0;
	@JsonIgnore
	private Date expiryDate;
	private String expiryDateAsString = "";
	private int validityPeriod = -1;
	private String displayNameEN = "";
	private String displayNameVI = "";
	private String unitName = "";
	@JsonIgnore
	private boolean counted = true;
	@JsonIgnore
	private DataBalanceDisplayOption displayOption = DataBalanceDisplayOption.AVAILABLE_VALUE;
	
	public Balance(){ }
	
	public Balance(String name, int totalValue, int consumedValue, int availableValue, Date expiryDate, int validityPeriod) {
		this.name = name;
		this.totalValue = totalValue;
		this.consumedValue = consumedValue;
		this.availableValue = availableValue;
		this.expiryDate = expiryDate;
		this.validityPeriod = validityPeriod;
	}

	/**
	 * @return the type
	 */
	public BalanceType getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(BalanceType type) {
		this.type = type;
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
	 * @return the displayNameEN
	 */
	public String getDisplayNameEN() {
		return displayNameEN;
	}

	/**
	 * @param displayNameEN the displayNameEN to set
	 */
	public void setDisplayNameEN(String alias) {
		this.displayNameEN = alias;
	}
	/**
	 * @return the displayNameVI
	 */
	public String getDisplayNameVI() {
		return displayNameVI;
	}

	/**
	 * @param displayNameVI the displayNameVI to set
	 */
	public void setDisplayNameVI(String displayNameVI) {
		this.displayNameVI = displayNameVI;
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
	 * @return the unitName
	 */
	public String getUnitName() {
		return unitName;
	}

	/**
	 * @param unitName the unitName to set
	 */
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	/**
	 * @return the expiryDate
	 */
	public Date getExpiryDate() {
		return expiryDate;
	}
	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	/**
	 * @return the expiryDateAsString
	 */
	public String getExpiryDateAsString() {
		return expiryDateAsString;
	}
	/**
	 * @param expiryDateAsString the expiryDateAsString to set
	 */
	public void setExpiryDateAsString(String expiryDateAsString) {
		this.expiryDateAsString = expiryDateAsString;
	}

	/**
	 * @return the validityPeriod
	 */
	public int getValidityPeriod() {
		return validityPeriod;
	}
	/**
	 * @param validityPeriod the validityPeriod to set
	 */
	public void setValidityPeriod(int validityPeriod) {
		this.validityPeriod = validityPeriod;
	}
	
	/**
	 * @return the counted
	 */
	public boolean isCounted() {
		return counted;
	}

	/**
	 * @param counted the counted to set
	 */
	public void setCounted(boolean counted) {
		this.counted = counted;
	}

	/**
	 * @return the displayOption
	 */
	public DataBalanceDisplayOption getDisplayOption() {
		return displayOption;
	}

	/**
	 * @param displayOption the displayOption to set
	 */
	public void setDisplayOption(DataBalanceDisplayOption displayOption) {
		this.displayOption = displayOption;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Balance other = (Balance) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Balance [type=");
		builder.append(type);
		builder.append(", name=");
		builder.append(name);
		builder.append(", totalValue=");
		builder.append(totalValue);
		builder.append(", consumedValue=");
		builder.append(consumedValue);
		builder.append(", availableValue=");
		builder.append(availableValue);
		builder.append(", expiryDate=");
		builder.append(expiryDate);
		builder.append(", expiryDateAsString=");
		builder.append(expiryDateAsString);
		builder.append(", validityPeriod=");
		builder.append(validityPeriod);
		builder.append(", displayNameEN=");
		builder.append(displayNameEN);
		builder.append(", displayNameVI=");
		builder.append(displayNameVI);
		builder.append(", unitName=");
		builder.append(unitName);
		builder.append(", counted=");
		builder.append(counted);
		builder.append(", displayOption=");
		builder.append(displayOption);
		builder.append("]");
		return builder.toString();
	}

	public static Comparator<Balance> AvailableValueDescComparator = new Comparator<Balance>() {

		@Override
		public int compare(Balance o1, Balance o2) {
			return (int)(o2.availableValue - o1.availableValue);
		}
	};

	public static Comparator<Balance> AvailableValueAscComparator = new Comparator<Balance>() {

		@Override
		public int compare(Balance o1, Balance o2) {
			return (int)(o1.availableValue - o2.availableValue);
		}
	};

	public static Comparator<Balance> ExpirationDateDescComparator = new Comparator<Balance>(){

		@Override
		public int compare(Balance o1, Balance o2) {
			return o2.expiryDate.after(o1.expiryDate) ? 1 : -1;
		}
		
	};

	public static Comparator<Balance> ExpirationDateAscComparator = new Comparator<Balance>(){

		@Override
		public int compare(Balance o1, Balance o2) {
			return o1.expiryDate.after(o2.expiryDate) ? 1 : -1;
		}
		
	};

	public static Comparator<Balance> DisplayNameENComparator = new Comparator<Balance>(){

		@Override
		public int compare(Balance o1, Balance o2) {
			return o1.displayNameEN.compareTo(o2.displayNameEN);
		}
		
	};
	
	public static Comparator<Balance> DisplayNameVIComparator = new Comparator<Balance>(){

		@Override
		public int compare(Balance o1, Balance o2) {
			return o1.displayNameVI.compareTo(o2.displayNameVI);
		}
		
	};
	
}
