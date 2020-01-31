/**
 * GameBannerRepository.java
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.GameBannerEntity;

/**
 * @author nandipinto
 *
 */
public interface GameBannerRepository extends JpaRepository<GameBannerEntity, Integer>, QueryDslPredicateExecutor<GameBannerEntity> {

}
