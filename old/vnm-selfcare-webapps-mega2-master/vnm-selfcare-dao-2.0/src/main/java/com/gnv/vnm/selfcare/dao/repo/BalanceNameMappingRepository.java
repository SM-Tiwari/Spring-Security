/**
 * BalanceNameMappingRepository.java
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.BalanceNameMappingEntity;

/**
 * @author nandipinto
 *
 */
public interface BalanceNameMappingRepository extends JpaRepository<BalanceNameMappingEntity, Integer>, QueryDslPredicateExecutor<BalanceNameMappingEntity> {

}
