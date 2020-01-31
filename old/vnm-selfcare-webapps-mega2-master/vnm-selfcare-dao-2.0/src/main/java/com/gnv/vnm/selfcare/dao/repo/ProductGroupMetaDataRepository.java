/**
 * ProductGroupMetaDataRepository.java
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.ProductGroupMetaDataEntity;

/**
 * @author nandipinto
 *
 */
public interface ProductGroupMetaDataRepository extends JpaRepository<ProductGroupMetaDataEntity, Integer>,
		QueryDslPredicateExecutor<ProductGroupMetaDataEntity> {

}