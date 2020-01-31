/**
 * 
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.PushedCampaignStatusTrackerEntity;

/**
 * @author nandipinto
 *
 */
public interface PushedCampaignStatusTrackerRepository extends JpaRepository<PushedCampaignStatusTrackerEntity, Integer>, QueryDslPredicateExecutor<PushedCampaignStatusTrackerEntity> {

}
