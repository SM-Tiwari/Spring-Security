/**
 * MemberGetMemberRepository.java
 */
package com.gnv.vnm.selfcare.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.gnv.vnm.selfcare.dao.entity.MemberGetMemberEntity;

/**
 * @author nandipinto
 *
 */
public interface MemberGetMemberRepository extends JpaRepository<MemberGetMemberEntity, Integer>, QueryDslPredicateExecutor<MemberGetMemberEntity> {

}
