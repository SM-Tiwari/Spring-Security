package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.MsisdnTokenEntity;

public interface MsisdnTokenRepo extends JpaRepository<MsisdnTokenEntity, Integer>, QueryDslPredicateExecutor<MsisdnTokenEntity> {

}

