/**
 * 
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.BankEntity;

/**
 * @author nandipinto
 *
 */
public interface BankRepository extends JpaRepository<BankEntity, Integer>, QueryDslPredicateExecutor<BankEntity> {

}
