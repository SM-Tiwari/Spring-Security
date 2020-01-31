/**
 * SubscriberRegistrationCounterRepository.java
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.SubscriberRegistrationCounterEntity;

/**
 * @author nandipinto
 *
 */
public interface SubscriberRegistrationCounterRepository
		extends JpaRepository<SubscriberRegistrationCounterEntity, Integer>,
		QueryDslPredicateExecutor<SubscriberRegistrationCounterEntity> {

}
