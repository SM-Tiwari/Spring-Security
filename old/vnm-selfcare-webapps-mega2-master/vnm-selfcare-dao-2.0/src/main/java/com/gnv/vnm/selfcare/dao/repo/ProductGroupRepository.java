/**
 * ProductGroupRepository.java
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.ProductGroupEntity;

/**
 * @author nandipinto
 *
 */
public interface ProductGroupRepository extends JpaRepository<ProductGroupEntity, Integer>, QueryDslPredicateExecutor<ProductGroupEntity> {

}
