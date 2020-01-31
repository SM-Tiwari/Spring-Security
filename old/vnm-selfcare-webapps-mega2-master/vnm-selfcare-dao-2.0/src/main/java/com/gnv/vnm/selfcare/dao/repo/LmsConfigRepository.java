/**
 * Apr 13, 2018 1:24:53 PM
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.LmsConfigEntity;

/**
 * @author nandipinto
 *
 */
public interface LmsConfigRepository extends JpaRepository<LmsConfigEntity, Integer>, QueryDslPredicateExecutor<LmsConfigEntity> {

}
