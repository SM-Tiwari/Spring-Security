/**
 * TopUpHistoryRepository.java
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.TopUpHistoryEntity;

/**
 * @author nandipinto
 *
 */
public interface TopUpHistoryRepository extends JpaRepository<TopUpHistoryEntity, Integer>, QueryDslPredicateExecutor<TopUpHistoryEntity> {

}
