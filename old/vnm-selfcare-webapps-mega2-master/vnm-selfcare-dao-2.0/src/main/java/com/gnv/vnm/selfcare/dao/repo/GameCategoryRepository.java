/**
 * GameCategoryRepository.java
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.GameCategoryEntity;

/**
 * @author nandipinto
 *
 */
public interface GameCategoryRepository extends JpaRepository<GameCategoryEntity, Integer>, QueryDslPredicateExecutor<GameCategoryEntity> {

}
