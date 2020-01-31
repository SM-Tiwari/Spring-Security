/**
 * AppConfigRepository.java
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.MicInformationEntity;
import com.gnv.vnm.selfcare.dao.entity.VersionUpdateEntity;
 

/**
 * @author nandipinto
 *
 */
public interface VersionUpdateRepository extends JpaRepository<VersionUpdateEntity, Integer>, QueryDslPredicateExecutor<VersionUpdateEntity> {
	

}
