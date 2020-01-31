/**
 * MusicRepository.java
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.MusicEntity;

/**
 * @author nandipinto
 *
 */
public interface MusicRepository extends JpaRepository<MusicEntity, Integer>, QueryDslPredicateExecutor<MusicEntity> {

}
