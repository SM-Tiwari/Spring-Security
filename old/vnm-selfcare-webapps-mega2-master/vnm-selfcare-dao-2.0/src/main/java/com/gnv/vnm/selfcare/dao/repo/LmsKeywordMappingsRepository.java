/**
 * 
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.LmsKeywordMappingsEntity;

/**
 * @author nandipinto
 *
 */
public interface LmsKeywordMappingsRepository extends JpaRepository<LmsKeywordMappingsEntity, Integer>, QueryDslPredicateExecutor<LmsKeywordMappingsEntity> {

}
