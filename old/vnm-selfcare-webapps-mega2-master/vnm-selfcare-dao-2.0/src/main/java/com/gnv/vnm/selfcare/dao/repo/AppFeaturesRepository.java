package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import com.gnv.vnm.selfcare.dao.entity.AppFeaturesEntity;
public interface AppFeaturesRepository extends JpaRepository<AppFeaturesEntity, Integer>, QueryDslPredicateExecutor<AppFeaturesEntity>
{

}
