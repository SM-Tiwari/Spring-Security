/**
 * PaymentHistoryRepository.java
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.PaymentHistoryEntity;

/**
 * @author nandipinto
 *
 */
public interface PaymentHistoryRepository extends JpaRepository<PaymentHistoryEntity, Integer>, QueryDslPredicateExecutor<PaymentHistoryEntity> {

}
