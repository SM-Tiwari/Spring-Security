package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.FattyRedeemEntity;
/**
* @author  kuldeep Singh
* @version 1.0
* @since   2018-12-04
*/
public interface FattyRedeemRepository extends JpaRepository<FattyRedeemEntity, Integer>, QueryDslPredicateExecutor<FattyRedeemEntity> {

}
