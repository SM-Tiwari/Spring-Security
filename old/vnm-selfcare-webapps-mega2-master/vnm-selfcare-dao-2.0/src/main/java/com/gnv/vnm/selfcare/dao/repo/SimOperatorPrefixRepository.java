/**
 * SimOperatorPrefixRepository.java
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.SimOperatorPrefixEntity;


/**
 * @author abhinav
 *
 */
public interface SimOperatorPrefixRepository extends JpaRepository<SimOperatorPrefixEntity, Integer>, QueryDslPredicateExecutor<SimOperatorPrefixEntity> {

	 
}
