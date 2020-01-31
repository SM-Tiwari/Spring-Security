/**
 * MovieCategoryRepository.java
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.MovieCategoryEntity;

/**
 * @author nandipinto
 *
 */
public interface MovieCategoryRepository extends JpaRepository<MovieCategoryEntity, Integer>, QueryDslPredicateExecutor<MovieCategoryEntity> {

}
