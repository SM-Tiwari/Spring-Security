/**
 * PromotedProductRepository.java
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.PromotedProductEntity;

/**
 * @author nandipinto
 *
 */
public interface PromotedProductRepository extends JpaRepository<PromotedProductEntity, Integer>, QueryDslPredicateExecutor<PromotedProductEntity> {

}
