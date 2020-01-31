/**
 * ProductSubscriptionRepository.java
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.ProductSubscriptionEntity;

/**
 * @author nandipinto
 *
 */
public interface ProductSubscriptionRepository extends JpaRepository<ProductSubscriptionEntity, Integer>,
		QueryDslPredicateExecutor<ProductSubscriptionEntity> {

}
