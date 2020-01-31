/**
 * ProductPurchaseMappingRepository.java
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.ProductChangeMappingEntity;

/**
 * @author nandipinto
 *
 */
public interface ProductPurchaseMappingRepository extends JpaRepository<ProductChangeMappingEntity, Integer>, QueryDslPredicateExecutor<ProductChangeMappingEntity> {

}
