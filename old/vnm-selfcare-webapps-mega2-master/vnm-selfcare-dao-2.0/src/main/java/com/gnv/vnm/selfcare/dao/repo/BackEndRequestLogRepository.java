/**
 * BackEndRequestLogRepository.java
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.BackEndRequestLogEntity;

/**
 * @author nandipinto
 *
 */
public interface BackEndRequestLogRepository extends JpaRepository<BackEndRequestLogEntity, Integer>, QueryDslPredicateExecutor<BackEndRequestLogEntity> {

}
