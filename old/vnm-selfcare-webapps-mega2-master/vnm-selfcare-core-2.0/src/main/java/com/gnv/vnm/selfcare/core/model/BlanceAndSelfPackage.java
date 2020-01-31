package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.gnv.vnm.selfcare.core.enums.SubscriberType;

public class BlanceAndSelfPackage implements Serializable {

	private static final long serialVersionUID = -8435360960939624805L;
	List<PackageSubscription> subscriptions;

	CurrentBalance currentBalance;
	//Simname basimname;
	private int subscriptionCount;
	private boolean roamingEnabled;
	private FattyMonsterDetails fattyMonsterDetails;
	List<DiscountTopUp>  discountTopUp;
	List<PopupBannner> popupBannner;
	List<HotNews> hotNews;
	
	private long notificationCount=0;
	
	List<BillingSummary> billingHistory;
	
	public List<BillingSummary> getBillingHistory() {
		return billingHistory;
	}

	public void setBillingHistory(List<BillingSummary> billingHistory) {
		this.billingHistory = billingHistory;
	}

	private String classOfServiceName;
	private SubscriberType type;
	private List<String> disabledAppFeatures = new ArrayList<>();
	
	
	public long getNotificationCount() {
		return notificationCount;
	}

	public void setNotificationCount(long notificationCount) {
		this.notificationCount = notificationCount;
	}

	public List<PopupBannner> getPopupBannner() {
		return popupBannner;
	}

	public void setPopupBannner(List<PopupBannner> popupBannner) {
		this.popupBannner = popupBannner;
	}

	public List<HotNews> getHotNews() {
		return hotNews;
	}

	public void setHotNews(List<HotNews> hotNews) {
		this.hotNews = hotNews;
	}

	public FattyMonsterDetails getFattyMonsterDetails() {
		return fattyMonsterDetails;
	}

	public void setFattyMonsterDetails(FattyMonsterDetails fattyMonsterDetails) {
		this.fattyMonsterDetails = fattyMonsterDetails;
	}

	public List<DiscountTopUp> getDiscountTopUp() {
		return discountTopUp;
	}

	public void setDiscountTopUp(List<DiscountTopUp> discountTopUp) {
		this.discountTopUp = discountTopUp;
	}

	public BlanceAndSelfPackage() {
		// TODO Auto-generated constructor stub
	}

	public int getSubscriptionCount() {
		return subscriptionCount;
	}

	public void setSubscriptionCount(int subscriptionCount) {
		this.subscriptionCount = subscriptionCount;
	}

	public boolean isRoamingEnabled() {
		return roamingEnabled;
	}

	public void setRoamingEnabled(boolean roamingEnabled) {
		this.roamingEnabled = roamingEnabled;
	}

	public CurrentBalance getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(CurrentBalance currentBalance) {
		this.currentBalance = currentBalance;
	}

  
	public List<PackageSubscription> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(List<PackageSubscription> subscriptions) {
		this.subscriptions = subscriptions;
	}

	public String getClassOfServiceName() {
		return classOfServiceName;
	}

	public void setClassOfServiceName(String classOfServiceName) {
		this.classOfServiceName = classOfServiceName;
	}

	public SubscriberType getType() {
		return type;
	}

	public void setType(SubscriberType type) {
		this.type = type;
	}

	public List<String> getDisabledAppFeatures() {
		return disabledAppFeatures;
	}

	public void setDisabledAppFeatures(List<String> disabledAppFeatures) {
		this.disabledAppFeatures = disabledAppFeatures;
	}

	public BlanceAndSelfPackage(List<PackageSubscription> subscriptionDeaitls, CurrentBalance currentBalance ) {
		super();
		this.subscriptions = subscriptionDeaitls;
		this.currentBalance = currentBalance;
		 
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		 
		result = prime * result + ((currentBalance == null) ? 0 : currentBalance.hashCode());
		result = prime * result + (roamingEnabled ? 1231 : 1237);
		result = prime * result + subscriptionCount;
		result = prime * result + ((subscriptions == null) ? 0 : subscriptions.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BlanceAndSelfPackage other = (BlanceAndSelfPackage) obj;
		 
		if (currentBalance == null) {
			if (other.currentBalance != null)
				return false;
		} else if (!currentBalance.equals(other.currentBalance))
			return false;
		if (roamingEnabled != other.roamingEnabled)
			return false;
		if (subscriptionCount != other.subscriptionCount)
			return false;
		if (subscriptions == null) {
			if (other.subscriptions != null)
				return false;
		} else if (!subscriptions.equals(other.subscriptions))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BlanceAndSelfPackage [subscriptions=" + subscriptions + ", currentBalance=" + currentBalance
				+ ", subscriptionCount=" + subscriptionCount + ", roamingEnabled="
				+ roamingEnabled + "]";
	}

}
