/**
 * AppConfigRepository.java
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.MicInformationEntity;
 

/**
 * @author nandipinto
 *
 */
public interface MicInformationRepository extends JpaRepository<MicInformationEntity, Integer>, QueryDslPredicateExecutor<MicInformationEntity> {
	

}
