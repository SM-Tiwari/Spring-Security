/**
 * SubscriberRepository.java
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.SubscriberEntity;

/**
 * @author nandipinto
 *
 */
public interface SubscriberRepository extends JpaRepository<SubscriberEntity, Integer>, QueryDslPredicateExecutor<SubscriberEntity> {

}
