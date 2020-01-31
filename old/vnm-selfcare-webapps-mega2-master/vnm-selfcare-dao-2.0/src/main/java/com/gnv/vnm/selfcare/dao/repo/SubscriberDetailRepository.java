/**
 * SubscriberDetailRepository.java
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.SubscriberDetailEntity;

/**
 * @author nandipinto
 *
 */
public interface SubscriberDetailRepository extends JpaRepository<SubscriberDetailEntity, Integer>, QueryDslPredicateExecutor<SubscriberDetailEntity> {

}
