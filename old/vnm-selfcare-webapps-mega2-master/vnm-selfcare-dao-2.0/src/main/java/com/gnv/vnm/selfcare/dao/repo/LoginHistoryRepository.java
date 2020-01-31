/**
 * LoginHistoryRepository.java
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.LoginHistoryEntity;

/**
 * @author nandipinto
 *
 */
public interface LoginHistoryRepository extends JpaRepository<LoginHistoryEntity, Integer>, QueryDslPredicateExecutor<LoginHistoryEntity> {

}
