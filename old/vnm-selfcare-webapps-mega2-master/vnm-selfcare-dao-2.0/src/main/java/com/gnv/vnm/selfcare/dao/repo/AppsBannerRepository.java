/**
 * AppsBannerRepository.java
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.AppsBannerEntity;

/**
 * @author nandipinto
 *
 */
public interface AppsBannerRepository extends JpaRepository<AppsBannerEntity, Integer>, QueryDslPredicateExecutor<AppsBannerEntity> {

}
