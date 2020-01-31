/**
 * MusicBannerRepository.java
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.MusicBannerEntity;

/**
 * @author nandipinto
 *
 */
public interface MusicBannerRepository extends JpaRepository<MusicBannerEntity, Integer>, QueryDslPredicateExecutor<MusicBannerEntity> {

}
