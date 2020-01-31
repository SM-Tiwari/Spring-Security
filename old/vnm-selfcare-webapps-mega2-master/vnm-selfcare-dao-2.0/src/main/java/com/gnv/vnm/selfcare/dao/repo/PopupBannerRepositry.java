package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.PaymentHistoryEntity;
import com.gnv.vnm.selfcare.dao.entity.PopupBannerEntity;

public interface PopupBannerRepositry extends JpaRepository<PopupBannerEntity, Integer>,QueryDslPredicateExecutor<PopupBannerEntity> {

}
