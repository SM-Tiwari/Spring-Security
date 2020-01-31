/**
 * PushedCampaignRepository.java
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.PushedCampaignEntity;

/**
 * @author nandipinto
 *
 */
public interface PushedCampaignRepository extends JpaRepository<PushedCampaignEntity, Integer>, QueryDslPredicateExecutor<PushedCampaignEntity> {

}
