/**
 * Apr 22, 2018 9:56:41 AM
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.CosAppFeatureMappingsEntity;

/**
 * @author nandipinto
 *
 */
public interface CosAppFeatureMappingsRepository extends JpaRepository<CosAppFeatureMappingsEntity, Integer>, QueryDslPredicateExecutor<CosAppFeatureMappingsEntity> {

}
