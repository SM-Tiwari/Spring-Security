/**
 * ProductCategoryRepository.java
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.ProductCategoryEntity;

/**
 * @author nandipinto
 *
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategoryEntity, Integer>, QueryDslPredicateExecutor<ProductCategoryEntity> {

}
