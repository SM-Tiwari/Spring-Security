/**
 * AppConfigRepository.java
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.SmsCallHistoryStatusEntity;

 

/**
 * @author nandipinto
 *
 */
public interface SmsCallHistoryStatusRepository extends JpaRepository<SmsCallHistoryStatusEntity, Integer>, QueryDslPredicateExecutor<SmsCallHistoryStatusEntity> {
	

}
