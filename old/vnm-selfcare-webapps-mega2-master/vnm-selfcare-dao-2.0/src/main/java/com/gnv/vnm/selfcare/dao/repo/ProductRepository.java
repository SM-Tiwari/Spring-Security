/**
 * ProductRepository.java
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.ProductEntity;

/**
 * @author nandipinto
 *
 */
public interface ProductRepository
		extends JpaRepository<ProductEntity, Integer>, QueryDslPredicateExecutor<ProductEntity> {

}
