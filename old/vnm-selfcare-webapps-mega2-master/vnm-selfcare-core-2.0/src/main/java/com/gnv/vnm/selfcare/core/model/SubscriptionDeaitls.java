package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;
import java.util.List;

public class SubscriptionDeaitls implements Serializable {

	private static final long serialVersionUID = -8435360960939624805L;

	
	List<PackageSubscription> subscriptions =null;
	private int  subscriptionCount;
	private boolean roamingEnabled;
	
	
	public SubscriptionDeaitls() {
	 
	}
	public SubscriptionDeaitls(List<PackageSubscription> subscriptions, int subscriptionCount,
			boolean roamingEnabled) {
		super();
		this.subscriptions = subscriptions;
		this.subscriptionCount = subscriptionCount;
		this.roamingEnabled = roamingEnabled;
	}
 
	 
	public List<PackageSubscription> getSubscriptions() {
		return subscriptions;
	}
	public void setSubscriptions(List<PackageSubscription> subscriptions) {
		this.subscriptions = subscriptions;
	}
	public int getSubscriptionCount() {
		return subscriptionCount;
	}
	public void setSubscriptionCount(int subscriptionCount) {
		this.subscriptionCount = subscriptionCount;
	}
	 
	public boolean isSoamingEnabled() {
		return roamingEnabled;
	}
	public void setSoamingEnabled(boolean roamingEnabled) {
		this.roamingEnabled = roamingEnabled;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		SubscriptionDeaitls other = (SubscriptionDeaitls) obj;
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
		return "SubscriptionDeaitls [subscriptions=" + subscriptions + ", subscriptionCount=" + subscriptionCount
				+ ", soamingEnabled=" + roamingEnabled + "]";
	}
	
}
