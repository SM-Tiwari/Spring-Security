/**
 * CurrentBalance.java
 */
package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nandipinto
 *
 */
public class CurrentBalance implements Serializable {

	public int getLoyalityPoint() {
		return loyalityPoint;
	}

	public void setLoyalityPoint(int loyalityPoint) {
		this.loyalityPoint = loyalityPoint;
	}


	private static final long serialVersionUID = -6325118657849092085L;
	
	private Balance coreBalance = new Balance();
	private MyVoiceBalance voiceBalance = new MyVoiceBalance();
	private MySmsBalance smsBalance = new MySmsBalance();
	private MyPromotionBalance promotionBalance = new MyPromotionBalance();
	private MyDataBalance dataBalance = new MyDataBalance();
	
	private double outstandingBalance = 0.0;
	private String fullName;
	private boolean unlimtedStatus;
	public boolean isUnlimtedStatus() {
		return unlimtedStatus;
	}

	public void setUnlimtedStatus(boolean unlimtedStatus) {
		this.unlimtedStatus = unlimtedStatus;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	private UnbilledBalance unbilledBalance = new UnbilledBalance();
	
	private List<Balance> balanceList=new ArrayList<>() ;
	public List<Balance> getBalanceList() {
		return balanceList;
	}

	public void setBalanceList(List<Balance> balanceList) {
		this.balanceList = balanceList;
	}


	private double depositBalance = 0.0;
	private int loyalityPoint=0;
	private String accountNumber;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getDepositBalance() {
		return depositBalance;
	}

	public void setDepositBalance(double depositBalance) {
		this.depositBalance = depositBalance;
	}

	public CurrentBalance(){ }
	
	public CurrentBalance(Balance coreBalance, MyVoiceBalance voiceBalance, MySmsBalance smsBalance,
			MyDataBalance dataBalance, MyPromotionBalance promotionBalance,int loyalityPoints) {
		this.coreBalance = coreBalance;
		this.voiceBalance = voiceBalance;
		this.smsBalance = smsBalance;
		this.dataBalance = dataBalance;
		this.loyalityPoint=loyalityPoints;
		this.promotionBalance = promotionBalance;
	}

	/**
	 * @return the coreBalance
	 */
	public Balance getCoreBalance() {
		return coreBalance;
	}

	/**
	 * @param coreBalance the coreBalance to set
	 */
	public void setCoreBalance(Balance coreBalance) {
		this.coreBalance = coreBalance;
	}

	/**
	 * @return the voiceBalance
	 */
	public MyVoiceBalance getVoiceBalance() {
		return voiceBalance;
	}

	/**
	 * @param voiceBalance the voiceBalance to set
	 */
	public void setVoiceBalance(MyVoiceBalance voiceBalance) {
		this.voiceBalance = voiceBalance;
	}

	/**
	 * @return the smsBalance
	 */
	public MySmsBalance getSmsBalance() {
		return smsBalance;
	}

	/**
	 * @param smsBalance the smsBalance to set
	 */
	public void setSmsBalance(MySmsBalance smsBalance) {
		this.smsBalance = smsBalance;
	}

	/**
	 * @return the dataBalance
	 */
	public MyDataBalance getDataBalance() {
		return dataBalance;
	}

	/**
	 * @param dataBalance the dataBalance to set
	 */
	public void setDataBalance(MyDataBalance dataBalance) {
		this.dataBalance = dataBalance;
	}

	/**
	 * @return the promotionBalance
	 */
	public MyPromotionBalance getPromotionBalance() {
		return promotionBalance;
	}

	/**
	 * @param promotionBalance the promotionBalance to set
	 */
	public void setPromotionBalance(MyPromotionBalance promotionBalance) {
		this.promotionBalance = promotionBalance;
	}

	/**
	 * @return the outstandingBalance
	 */
	public double getOutstandingBalance() {
		return outstandingBalance;
	}

	/**
	 * @return the unbilledBalance
	 */
	public UnbilledBalance getUnbilledBalance() {
		return unbilledBalance;
	}

	/**
	 * @param unbilledBalance the unbilledBalance to set
	 */
	public void setUnbilledBalance(UnbilledBalance unbilledBalance) {
		this.unbilledBalance = unbilledBalance;
	}

	/**
	 * @param outstandingBalance the outstandingBalance to set
	 */
	public void setOutstandingBalance(double outstandingBalance) {
		this.outstandingBalance = outstandingBalance;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CurrentBalance [coreBalance=");
		builder.append(coreBalance);
		builder.append(", voiceBalance=");
		builder.append(voiceBalance);
		builder.append(", smsBalance=");
		builder.append(smsBalance);
		builder.append(", dataBalance=");
		builder.append(dataBalance);
		builder.append(", promotionBalance=");
		builder.append(promotionBalance);
		builder.append("]");
		return builder.toString();
	}
	
}
