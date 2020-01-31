/**
 * AppsRepository.java
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.AppsEntity;

/**
 * @author nandipinto
 *
 */
public interface AppsRepository extends JpaRepository<AppsEntity, Integer>, QueryDslPredicateExecutor<AppsEntity> {

}
