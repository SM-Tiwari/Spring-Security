/**
 * 
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.SelfPackagePriceMappingEntity;

/**
 * @author nandipinto
 *
 */
public interface SelfPackagePriceMappingRepository extends JpaRepository<SelfPackagePriceMappingEntity, Integer>, QueryDslPredicateExecutor<SelfPackagePriceMappingEntity> {

}
