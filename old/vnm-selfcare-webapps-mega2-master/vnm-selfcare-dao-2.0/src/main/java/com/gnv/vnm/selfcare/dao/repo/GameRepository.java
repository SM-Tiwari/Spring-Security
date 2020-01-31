/**
 * GameRepository.java
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.GameEntity;

/**
 * @author nandipinto
 *
 */
public interface GameRepository extends JpaRepository<GameEntity, Integer>, QueryDslPredicateExecutor<GameEntity> {

}
