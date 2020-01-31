/**
 * ExtAuthTokenRepository.java
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.ExtAuthTokenEntity;

/**
 * @author nandipinto
 *
 */
public interface ExtAuthTokenRepository extends JpaRepository<ExtAuthTokenEntity, Integer>, QueryDslPredicateExecutor<ExtAuthTokenEntity> {

}
