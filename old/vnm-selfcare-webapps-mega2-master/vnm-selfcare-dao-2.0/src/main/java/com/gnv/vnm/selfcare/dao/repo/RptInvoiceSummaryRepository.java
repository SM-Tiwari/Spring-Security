package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.RptInvoiceSummary;

public interface RptInvoiceSummaryRepository extends JpaRepository<RptInvoiceSummary, Integer>, QueryDslPredicateExecutor<RptInvoiceSummary> {

}
