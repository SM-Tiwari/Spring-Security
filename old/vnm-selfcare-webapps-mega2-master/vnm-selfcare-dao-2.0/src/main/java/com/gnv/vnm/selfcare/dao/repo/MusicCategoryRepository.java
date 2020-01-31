/**
 * MusicCategoryRepository.java
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.MusicCategoryEntity;

/**
 * @author nandipinto
 *
 */
public interface MusicCategoryRepository extends JpaRepository<MusicCategoryEntity, Integer>, QueryDslPredicateExecutor<MusicCategoryEntity> {

}
