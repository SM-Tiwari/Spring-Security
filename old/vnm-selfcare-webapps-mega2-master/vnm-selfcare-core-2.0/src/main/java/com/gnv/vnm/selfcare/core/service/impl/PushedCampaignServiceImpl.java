/**
 * PushedCampaignServiceImpl.java
 */
package com.gnv.vnm.selfcare.core.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.gnv.vnm.selfcare.core.enums.NotificationDisplayType;
import com.gnv.vnm.selfcare.core.enums.NotificationStatus;
import com.gnv.vnm.selfcare.core.enums.PushedCampaignType;
import com.gnv.vnm.selfcare.core.model.PushedCampaign;
import com.gnv.vnm.selfcare.core.service.PushedCampaignService;
import com.gnv.vnm.selfcare.dao.entity.PushedCampaignEntity;
import com.gnv.vnm.selfcare.dao.entity.QPushedCampaignEntity;
import com.gnv.vnm.selfcare.dao.repo.PushedCampaignRepository;
import com.querydsl.core.types.dsl.BooleanExpression;

/**
 * @author nandipinto
 * @param <E>
 *
 */

@Service("pushedCampaignService")
public class PushedCampaignServiceImpl implements PushedCampaignService {
	
	private static final Logger logger = LoggerFactory.getLogger(PushedCampaignServiceImpl.class);
	
	@Autowired 
	private PushedCampaignRepository pushedCampaignRepository;

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.PushedCampaignService#acceptPushedCampaign(com.gnv.vnm.selfcare.core.model.PushedCampaign)
	 */
	@Override
	public void createCampaign(PushedCampaign pushedCampaign) throws Exception{

		try {
			PushedCampaignEntity pce = new PushedCampaignEntity();
			pce.setDescriptionEN(pushedCampaign.getDescriptionEN());
			pce.setDescriptionVI(pushedCampaign.getDescriptionVI());
			pce.setDetailsEN(pushedCampaign.getDetailsEN());
			pce.setDetailsVI(pushedCampaign.getDetailsVI());
			pce.setEndDate(pushedCampaign.getEndDate());
			pce.setStartDate(pushedCampaign.getStartDate());
			pce.setTargetedUser(pushedCampaign.getTargetedUser());
			pce.setTitleEN(pushedCampaign.getTitleEN());
			pce.setTitleVI(pushedCampaign.getTitleVI());
			
			pushedCampaignRepository.save(pce);
		} catch (Exception e) {
			logger.error("#storePushedCampaign -- error storing pushed campaign " + pushedCampaign, e);
			throw e;
		}
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.PushedCampaignService#acceptPushedCampaign(java.util.List)
	 */
	@Override
	public void createCampaigns(List<PushedCampaign> pushedCampaigns) throws Exception{
		
		List<PushedCampaignEntity> list = new ArrayList<PushedCampaignEntity>();
		
		for (PushedCampaign pushedCampaign:pushedCampaigns){

			PushedCampaignEntity pce = new PushedCampaignEntity();
			pce.setDescriptionEN(pushedCampaign.getDescriptionEN());
			pce.setDescriptionVI(pushedCampaign.getDescriptionVI());
			pce.setDetailsEN(pushedCampaign.getDetailsEN());
			pce.setDetailsVI(pushedCampaign.getDetailsVI());
			pce.setEndDate(pushedCampaign.getEndDate());
			pce.setStartDate(pushedCampaign.getStartDate());
			pce.setTargetedUser(pushedCampaign.getTargetedUser());
			pce.setTitleEN(pushedCampaign.getTitleEN());
			pce.setTitleVI(pushedCampaign.getTitleVI());
			
			list.add(pce);
		}
		try {
			pushedCampaignRepository.save(list);
		} catch (Exception e) {
			logger.error("#storePushedCampaigns --- error saving pushed campaigns!", e);
			throw e;
		}
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.PushedCampaignService#getPushedCampaignCount(java.lang.String)
	 */
	@Override
	public long getCampaignCount(String msisdn) {
		BooleanExpression dateExpr = QPushedCampaignEntity.pushedCampaignEntity.endDate.isNull().or(QPushedCampaignEntity.pushedCampaignEntity.endDate.goe(new Date()));
		return pushedCampaignRepository.count(dateExpr.and(QPushedCampaignEntity.pushedCampaignEntity.targetedUser.isNull().or(
				QPushedCampaignEntity.pushedCampaignEntity.targetedUser.eq(msisdn))));
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.PushedCampaignService#getUnreadNotificationCount(java.lang.String)
	 */
	@Override
	public long getUnreadCampaignCount(String msisdn) {
		
		return pushedCampaignRepository.count(QPushedCampaignEntity.pushedCampaignEntity.targetedUser.isNotNull()
				.and(QPushedCampaignEntity.pushedCampaignEntity.targetedUser.eq(msisdn))
				.and(QPushedCampaignEntity.pushedCampaignEntity.status.isNull().or(
						QPushedCampaignEntity.pushedCampaignEntity.status.eq(NotificationStatus.UNREAD.ordinal()))));
	}
	
	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.PushedCampaignService#getUnreadCampaignCount(java.lang.String, com.gnv.vnm.selfcare.core.enums.NotificationDisplayType)
	 */
	@Override
	public long getUnreadCampaignCount(String msisdn, NotificationDisplayType displayType) {
		return pushedCampaignRepository.count(QPushedCampaignEntity.pushedCampaignEntity.targetedUser.isNotNull()
				.and(QPushedCampaignEntity.pushedCampaignEntity.targetedUser.eq(msisdn))
				.and(QPushedCampaignEntity.pushedCampaignEntity.displayType.isNotNull()
						.and(QPushedCampaignEntity.pushedCampaignEntity.displayType.eq(displayType.ordinal())))
				.and(QPushedCampaignEntity.pushedCampaignEntity.status.isNull().or(
						QPushedCampaignEntity.pushedCampaignEntity.status.eq(NotificationStatus.UNREAD.ordinal()))));
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.PushedCampaignService#getPushedCampaigns(java.lang.String)
	 */
	@Override
	public List<PushedCampaign> getCampaigns(String msisdn, PushedCampaignType[] notifTypes, NotificationStatus[] statuses,
			NotificationDisplayType[] displayTypes, int maxSentCount) {
		
		List<PushedCampaign> result = new ArrayList<>();
		try {
			BooleanExpression expr = QPushedCampaignEntity.pushedCampaignEntity.endDate.isNull()
					.or(QPushedCampaignEntity.pushedCampaignEntity.endDate.goe(new Date()))
					.and(QPushedCampaignEntity.pushedCampaignEntity.targetedUser.isNull()
							.or(QPushedCampaignEntity.pushedCampaignEntity.targetedUser.eq(msisdn)));
			
			if (notifTypes != null) {
				List<Integer> typeIds = new ArrayList<>();
				for (PushedCampaignType pct : notifTypes) {
					typeIds.add(pct.ordinal());
				}
				expr = expr.and(QPushedCampaignEntity.pushedCampaignEntity.type.isNull()
						.or(QPushedCampaignEntity.pushedCampaignEntity.type.in(typeIds)));
			}
			
			if (statuses != null) {
				List<Integer> statusIds = new ArrayList<>();
				for (NotificationStatus ns : statuses) {
					statusIds.add(ns.ordinal());
				}
				expr = expr.and(QPushedCampaignEntity.pushedCampaignEntity.status.isNull()
						.or(QPushedCampaignEntity.pushedCampaignEntity.status.in(statusIds)));
			}

			if (displayTypes != null) {
				List<Integer> displayTypeIds = new ArrayList<>();
				for (NotificationDisplayType ndt : displayTypes) {
					displayTypeIds.add(ndt.ordinal());
				}
				expr = expr.and(QPushedCampaignEntity.pushedCampaignEntity.displayType.isNull()
						.or(QPushedCampaignEntity.pushedCampaignEntity.displayType.in(displayTypeIds)));
			}

			if (maxSentCount > 0) {
				expr = expr.and(QPushedCampaignEntity.pushedCampaignEntity.sentCounter.isNull()
						.or(QPushedCampaignEntity.pushedCampaignEntity.sentCounter.lt(maxSentCount)));
			}
			
			Iterable<PushedCampaignEntity> list = pushedCampaignRepository.findAll(expr,
					QPushedCampaignEntity.pushedCampaignEntity.createTimestamp.desc());
			
			for (PushedCampaignEntity pe : list){
				PushedCampaign pushedCampaign = new PushedCampaign(pe.getId(), pe.getTitleEN(), pe.getDescriptionEN(),
						pe.getDetailsEN(), pe.getTitleVI(), pe.getDescriptionVI(), pe.getDetailsVI(),
						pe.getTargetedUser(), pe.getStartDate(), pe.getEndDate());
				
				pushedCampaign.setStatus(NotificationStatus.fromInt(pe.getStatus()));
				pushedCampaign.setDisplayType(NotificationDisplayType.fromInt(pe.getDisplayType()));
				pushedCampaign.setType(PushedCampaignType.fromInt(pe.getType()));
				pushedCampaign.setSentCounter(pe.getSentCounter());
				
				result.add(pushedCampaign);
			}
		} catch (Exception e) {
			logger.error("#getPushedCampaigns(msisdn) --- error getting pushed campaign for MSISDN " + msisdn, e);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.PushedCampaignService#getPushedCampaigns()
	 */
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public List<PushedCampaign> getCampaigns(PushedCampaignType[] notifTypes, NotificationStatus[] statuses, NotificationDisplayType[] displayTypes, int maxSentCount) {

		List<PushedCampaign> result = new ArrayList<>();
		try {
			BooleanExpression expr = QPushedCampaignEntity.pushedCampaignEntity.endDate.isNull().or(QPushedCampaignEntity.pushedCampaignEntity.endDate.goe(new Date()));
			
			if (notifTypes != null) {
				List<Integer> typeIds = new ArrayList<>();
				for (PushedCampaignType pct : notifTypes) {
					typeIds.add(pct.ordinal());
				}
				expr = expr.and(QPushedCampaignEntity.pushedCampaignEntity.type.isNull()
						.or(QPushedCampaignEntity.pushedCampaignEntity.type.in(typeIds)));
			}
			
			if (statuses != null) {
				List<Integer> statusIds = new ArrayList<>();
				for (NotificationStatus ns : statuses) {
					statusIds.add(ns.ordinal());
				}
				expr = expr.and(QPushedCampaignEntity.pushedCampaignEntity.status.isNull()
						.or(QPushedCampaignEntity.pushedCampaignEntity.status.in(statusIds)));
			}

			if (displayTypes != null) {
				List<Integer> displayTypeIds = new ArrayList<>();
				for (NotificationDisplayType ndt : displayTypes) {
					displayTypeIds.add(ndt.ordinal());
				}
				expr = expr.and(QPushedCampaignEntity.pushedCampaignEntity.displayType.isNull()
						.or(QPushedCampaignEntity.pushedCampaignEntity.displayType.in(displayTypeIds)));
			}

			if (maxSentCount > 0) {
				expr = expr.and(QPushedCampaignEntity.pushedCampaignEntity.sentCounter.isNull()
						.or(QPushedCampaignEntity.pushedCampaignEntity.sentCounter.lt(maxSentCount)));
			}
			
			Iterable<PushedCampaignEntity> list = pushedCampaignRepository.findAll(expr, QPushedCampaignEntity.pushedCampaignEntity.createTimestamp.desc());
			
			for (PushedCampaignEntity pe : list){
				PushedCampaign pushedCampaign = new PushedCampaign(pe.getId(), pe.getTitleEN(), pe.getDescriptionEN(),
						pe.getDetailsEN(), pe.getTitleVI(), pe.getDescriptionVI(), pe.getDetailsVI(),
						pe.getTargetedUser(), pe.getStartDate(), pe.getEndDate());
				
				pushedCampaign.setStatus(NotificationStatus.fromInt(pe.getStatus()));
				pushedCampaign.setDisplayType(NotificationDisplayType.fromInt(pe.getDisplayType()));
				pushedCampaign.setType(PushedCampaignType.fromInt(pe.getType()));
				pushedCampaign.setSentCounter(pe.getSentCounter());

				result.add(pushedCampaign);
				
			}
		} catch (Exception e) {
			logger.error("#getPushedCampaigns --- error getting pushed campaigns", e);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.PushedCampaignService#setCampaignStatus(java.lang.String, java.lang.Integer)
	 */
	@Override
	public void setCampaignStatus(String msisdn, Integer status) {
		try {
			Iterable<PushedCampaignEntity> list = pushedCampaignRepository
					.findAll(QPushedCampaignEntity.pushedCampaignEntity.targetedUser.isNotNull()
							.and(QPushedCampaignEntity.pushedCampaignEntity.targetedUser.eq(msisdn)));
			
			if (list != null) {
				for (PushedCampaignEntity pce : list) {
					pce.setStatus(status);
				}
				pushedCampaignRepository.save(list);
			}
		} catch (Exception e) {
			logger.error("#setCampaignReadStatus --- error updating pushed_campaign status for MSISDN " + msisdn, e);
		}		
	}
	
	@Override
	public List<PushedCampaign> getCampaignsNew(String msisdn)
	{
	List<PushedCampaign> result = new ArrayList<>();
	Iterable<PushedCampaignEntity> list = pushedCampaignRepository.findAll(QPushedCampaignEntity.pushedCampaignEntity.createTimestamp.desc());

	for (PushedCampaignEntity pe : list){
	PushedCampaign pushedCampaign = new PushedCampaign(pe.getId(), pe.getTitleEN(), pe.getDescriptionEN(),
	pe.getDetailsEN(), pe.getTitleVI(), pe.getDescriptionVI(), pe.getDetailsVI(),
	pe.getTargetedUser(), pe.getStartDate(), pe.getEndDate());

	pushedCampaign.setStatus(NotificationStatus.fromInt(pe.getStatus()));
	pushedCampaign.setDisplayType(NotificationDisplayType.fromInt(pe.getDisplayType()));
	pushedCampaign.setType(PushedCampaignType.fromInt(pe.getType()));
	pushedCampaign.setSentCounter(pe.getSentCounter());

	result.add(pushedCampaign);
	}
	return result;
	}
	
}
