/**
 * TopUpTypeRepository.java
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.TopUpTypeEntity;

/**
 * @author nandipinto
 *
 */
public interface TopUpTypeRepository extends JpaRepository<TopUpTypeEntity, Integer>, QueryDslPredicateExecutor<TopUpTypeEntity> {

}
