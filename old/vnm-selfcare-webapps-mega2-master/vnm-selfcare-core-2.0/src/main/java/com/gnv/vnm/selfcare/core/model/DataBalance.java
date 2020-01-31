/**
 * DataBalance.java
 */
package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gnv.vnm.selfcare.core.enums.DataBalanceDisplayOption;

/**
 * @author nandipinto
 *
 */
public class DataBalance implements Serializable {

	private static final long serialVersionUID = 2624843578681033387L;

	private String code = "";
	private String name = "";
	private String serviceName = "";
	private long totalValue = 0; 		//initial value 
	private long consumedValue = 0;
	private long remainingValue = 0;		//current balance/current value
	@JsonIgnore
	private Date startDate;
	private String startDateAsString = "";
	@JsonIgnore
	private Date overdueDate;
	private String overdueDateAsString = "";
	@JsonIgnore
	private Date endDate;
	private String endDateAsString = "";
	@JsonIgnore
	private String remainingValueAsString = "";
	@JsonIgnore
	private String consumedValueAsString = "";
	private DataBalanceDisplayOption displayOption = DataBalanceDisplayOption.AVAILABLE_VALUE;
	@JsonIgnore
	private boolean dashboardVisible = true;
	private String displayNameEN;
	private String displayNameVI;

	public DataBalance(){ }
	
	public DataBalance(String code, String name, long totalValue, long consumedValue, long remainingValue) {
		this.code = code;
		this.name = name;
		this.totalValue = totalValue;
		this.consumedValue = consumedValue;
		this.remainingValue = remainingValue;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
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
	 * @return the serviceName
	 */
	public String getServiceName() {
		return serviceName;
	}
	/**
	 * @param serviceName the serviceName to set
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
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
	 * @return the remainingValue
	 */
	public long getRemainingValue() {
		return remainingValue;
	}
	/**
	 * @param remainingValue the remainingValue to set
	 */
	public void setRemainingValue(long remainingValue) {
		this.remainingValue = remainingValue;
	}
	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the startDateAsString
	 */
	public String getStartDateAsString() {
		return startDateAsString;
	}
	/**
	 * @param startDateAsString the startDateAsString to set
	 */
	public void setStartDateAsString(String startDateAsString) {
		this.startDateAsString = startDateAsString;
	}
	/**
	 * @return the overdueDate
	 */
	public Date getOverdueDate() {
		return overdueDate;
	}
	/**
	 * @param overdueDate the overdueDate to set
	 */
	public void setOverdueDate(Date overdueDate) {
		this.overdueDate = overdueDate;
	}
	/**
	 * @return the overdueDateAsString
	 */
	public String getOverdueDateAsString() {
		return overdueDateAsString;
	}
	/**
	 * @param overdueDateAsString the overdueDateAsString to set
	 */
	public void setOverdueDateAsString(String overdueDateAsString) {
		this.overdueDateAsString = overdueDateAsString;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the endDateAsString
	 */
	public String getEndDateAsString() {
		return endDateAsString;
	}
	/**
	 * @param endDateAsString the endDateAsString to set
	 */
	public void setEndDateAsString(String endDateAsString) {
		this.endDateAsString = endDateAsString;
	}
	
	/**
	 * @return the remainingValueAsString
	 */
	public String getRemainingValueAsString() {
		return remainingValueAsString;
	}
	/**
	 * @param remainingValueAsString the remainingValueAsString to set
	 */
	public void setRemainingValueAsString(String remainingBalanceAsString) {
		this.remainingValueAsString = remainingBalanceAsString;
	}
	
	/**
	 * @return the consumedValueAsString
	 */
	public String getConsumedValueAsString() {
		return consumedValueAsString;
	}

	/**
	 * @param consumedValueAsString the consumedValueAsString to set
	 */
	public void setConsumedValueAsString(String usedBalanceAsString) {
		this.consumedValueAsString = usedBalanceAsString;
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

	/**
	 * @return the dashboardVisible
	 */
	public boolean isDashboardVisible() {
		return dashboardVisible;
	}

	/**
	 * @param dashboardVisible the dashboardVisible to set
	 */
	public void setDashboardVisible(boolean dashboardVisible) {
		this.dashboardVisible = dashboardVisible;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((serviceName == null) ? 0 : serviceName.hashCode());
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
		DataBalance other = (DataBalance) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (serviceName == null) {
			if (other.serviceName != null)
				return false;
		} else if (!serviceName.equals(other.serviceName))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DataBalance [code=");
		builder.append(code);
		builder.append(", name=");
		builder.append(name);
		builder.append(", serviceName=");
		builder.append(serviceName);
		builder.append(", totalValue=");
		builder.append(totalValue);
		builder.append(", consumedValue=");
		builder.append(consumedValue);
		builder.append(", remainingValue=");
		builder.append(remainingValue);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append(", startDateAsString=");
		builder.append(startDateAsString);
		builder.append(", overdueDate=");
		builder.append(overdueDate);
		builder.append(", overdueDateAsString=");
		builder.append(overdueDateAsString);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append(", endDateAsString=");
		builder.append(endDateAsString);
		builder.append(", remainingValueAsString=");
		builder.append(remainingValueAsString);
		builder.append(", displayOption=");
		builder.append(displayOption);
		builder.append("]");
		return builder.toString();
	}
	
	public static Comparator<DataBalance> RemainingValueDescComparator = new Comparator<DataBalance>() {

		@Override
		public int compare(DataBalance o1, DataBalance o2) {
			return (int)(o2.remainingValue - o1.remainingValue) ; //desc order
		}
	};
	
	public static Comparator<DataBalance> RemainingValueAscComparator = new Comparator<DataBalance>() {

		@Override
		public int compare(DataBalance o1, DataBalance o2) {
			return (int)(o1.remainingValue - o2.remainingValue) ; //asc order
		}
	};
	
	public static Comparator<DataBalance> EndDateDescComparator = new Comparator<DataBalance>() {

		@Override
		public int compare(DataBalance o1, DataBalance o2) {
			return o2.endDate.after(o1.endDate) ? 1 : -1;
		}
	};	
	
	public static Comparator<DataBalance> EndDateAscComparator = new Comparator<DataBalance>() {

		@Override
		public int compare(DataBalance o1, DataBalance o2) {
			return o1.endDate.after(o2.endDate) ? 1 : -1;
		}
	};	

}
