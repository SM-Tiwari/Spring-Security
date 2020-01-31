/**
 * StoreRepository.java
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.ProvinceEntity;
import com.gnv.vnm.selfcare.dao.entity.StoreEntity;

/**
 * @author nandipinto
 *
 */
public interface ProvinceRepository extends JpaRepository<ProvinceEntity, Integer>, QueryDslPredicateExecutor<ProvinceEntity> {

}
