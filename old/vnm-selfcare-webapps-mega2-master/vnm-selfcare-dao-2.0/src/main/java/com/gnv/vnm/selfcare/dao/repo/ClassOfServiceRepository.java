/**
 * ClassOfServiceRepository.java
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.ClassOfServiceEntity;

/**
 * @author nandipinto
 *
 */
public interface ClassOfServiceRepository extends JpaRepository<ClassOfServiceEntity, Integer>, QueryDslPredicateExecutor<ClassOfServiceEntity> {

}
