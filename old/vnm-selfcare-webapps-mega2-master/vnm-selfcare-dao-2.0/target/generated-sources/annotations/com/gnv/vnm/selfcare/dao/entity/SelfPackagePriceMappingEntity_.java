package com.gnv.vnm.selfcare.dao.entity;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SelfPackagePriceMappingEntity.class)
public abstract class SelfPackagePriceMappingEntity_ extends com.gnv.vnm.selfcare.dao.entity.BaseEntity_ {

	public static volatile SingularAttribute<SelfPackagePriceMappingEntity, Integer> minAmount;
	public static volatile SingularAttribute<SelfPackagePriceMappingEntity, BigDecimal> price;
	public static volatile SingularAttribute<SelfPackagePriceMappingEntity, BigDecimal> normalPrice;
	public static volatile SingularAttribute<SelfPackagePriceMappingEntity, Integer> id;
	public static volatile SingularAttribute<SelfPackagePriceMappingEntity, String> type;
	public static volatile SingularAttribute<SelfPackagePriceMappingEntity, Integer> maxAmount;
	public static volatile SingularAttribute<SelfPackagePriceMappingEntity, Integer> cycle;

}

