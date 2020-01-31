/**
 * OtpRepository.java
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.OtpEntity;

/**
 * @author nandipinto
 *
 */
public interface OtpRepository extends JpaRepository<OtpEntity, Integer>, QueryDslPredicateExecutor<OtpEntity> {

}
