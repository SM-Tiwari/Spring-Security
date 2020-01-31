/**
 * Jan 22, 2018 6:49:45 AM
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.PostpaidBillPaymentHistoryEntity;

/**
 * @author nandipinto
 *
 */
public interface PostpaidBillPaymentHistoryRepository extends JpaRepository<PostpaidBillPaymentHistoryEntity, Integer>, QueryDslPredicateExecutor<PostpaidBillPaymentHistoryEntity> {

}
