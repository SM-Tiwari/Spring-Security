/**
 * ProductMetadataRepository.java
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.ProductMetaDataEntity;

/**
 * @author nandipinto
 *
 */
public interface ProductMetadataRepository
		extends JpaRepository<ProductMetaDataEntity, Integer>, QueryDslPredicateExecutor<ProductMetaDataEntity> {

}
