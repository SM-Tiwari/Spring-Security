/**
 * SimOperatorRepository.java
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.SimOperatorEntity;


/**
 * @author abhinav
 *
 */
public interface SimOperatorRepository extends JpaRepository<SimOperatorEntity, Integer>, QueryDslPredicateExecutor<SimOperatorEntity> {

}
