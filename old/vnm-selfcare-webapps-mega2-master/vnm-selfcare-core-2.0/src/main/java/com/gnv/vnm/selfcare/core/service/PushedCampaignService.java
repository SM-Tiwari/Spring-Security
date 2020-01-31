/**
 * PushedCampaignService.java
 */
package com.gnv.vnm.selfcare.core.service;

import java.util.List;

import com.gnv.vnm.selfcare.core.enums.NotificationDisplayType;
import com.gnv.vnm.selfcare.core.enums.NotificationStatus;
import com.gnv.vnm.selfcare.core.enums.PushedCampaignType;
import com.gnv.vnm.selfcare.core.model.PushedCampaign;

/**
 * @author nandipinto
 *
 */
public interface PushedCampaignService {

	void createCampaign(PushedCampaign pushedCampaign) throws Exception;
	
	void createCampaigns(List<PushedCampaign> pushedCampaigns) throws Exception;
	
	long getCampaignCount(String msisdn);
	
	long getUnreadCampaignCount(String msisdn);
	
	long getUnreadCampaignCount(String msisdn, NotificationDisplayType displayType);
	
	List<PushedCampaign> getCampaigns(String msisdn, PushedCampaignType[] notifTypes, NotificationStatus[] statuses, NotificationDisplayType[] displayTypes, int maxSentCount);
	
	List<PushedCampaign> getCampaigns(PushedCampaignType[] notifTypes, NotificationStatus[] statuses, NotificationDisplayType[] displayTypes, int maxSentCount);
	
	void setCampaignStatus(String msisdn, Integer status);

	List<PushedCampaign> getCampaignsNew(String msisdn);

}
