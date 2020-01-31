/**
 * OtpRepository.java
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.MicStatusEntity;

/**
 * @author nandipinto
 *
 */
public interface MicStatusRepository extends JpaRepository<MicStatusEntity, Integer>, QueryDslPredicateExecutor<MicStatusEntity> {

}
