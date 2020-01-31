package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.AvatarEntity;

public interface AvatarEntityRepository extends JpaRepository<AvatarEntity, Integer>, QueryDslPredicateExecutor<AvatarEntity> {

}
