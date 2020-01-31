/**
 * 
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.SelfPackageBalanceNameEntity;

/**
 * @author nandipinto
 *
 */
public interface SelfPackageBalanceNameRepository extends JpaRepository<SelfPackageBalanceNameEntity, Integer>, QueryDslPredicateExecutor<SelfPackageBalanceNameEntity> {

}
