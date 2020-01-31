/**
 * LmsItemMappingsRepository.java
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.LmsItemMappingsEntity;

/**
 * @author nandipinto
 *
 */
public interface LmsItemMappingsRepository extends JpaRepository<LmsItemMappingsEntity, Integer>, QueryDslPredicateExecutor<LmsItemMappingsEntity> {

}
