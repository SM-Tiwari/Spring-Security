/**
 * TransactionHistoryRepository.java
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.TransactionHistoryEntity;

/**
 * @author nandipinto
 *
 */
public interface TransactionHistoryRepository
		extends JpaRepository<TransactionHistoryEntity, Integer>, QueryDslPredicateExecutor<TransactionHistoryEntity> {

}
