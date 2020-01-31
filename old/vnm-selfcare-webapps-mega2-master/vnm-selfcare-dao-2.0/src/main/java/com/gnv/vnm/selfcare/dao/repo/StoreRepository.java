/**
 * StoreRepository.java
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.StoreEntity;

/**
 * @author nandipinto
 *
 */
public interface StoreRepository extends JpaRepository<StoreEntity, Integer>, QueryDslPredicateExecutor<StoreEntity> {

}