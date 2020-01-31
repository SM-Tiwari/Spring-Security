/**
 * 
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.SelfPackageCommonConfigEntity;

/**
 * @author nandipinto
 *
 */
public interface SelfPackageCommonConfigRepository extends JpaRepository<SelfPackageCommonConfigEntity, Integer>, QueryDslPredicateExecutor<SelfPackageCommonConfigEntity> {

}
