/**
 * Mar 4, 2018 9:15:53 PM
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.FcmTokenEntity;

/**
 * @author nandipinto
 *
 */
public interface FcmTokenRepository extends JpaRepository<FcmTokenEntity, Integer>, QueryDslPredicateExecutor<FcmTokenEntity> {

}
