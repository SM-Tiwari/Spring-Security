package com.gnv.vnm.selfcare.dao.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MemberGetMemberEntity.class)
public abstract class MemberGetMemberEntity_ extends com.gnv.vnm.selfcare.dao.entity.BaseEntity_ {

	public static volatile SingularAttribute<MemberGetMemberEntity, String> invidtedMsisdn;
	public static volatile SingularAttribute<MemberGetMemberEntity, Integer> activatedFlag;
	public static volatile SingularAttribute<MemberGetMemberEntity, Integer> id;
	public static volatile SingularAttribute<MemberGetMemberEntity, String> msisdn;
	public static volatile SingularAttribute<MemberGetMemberEntity, Date> activationDate;

}

