package com.gnv.vnm.selfcare.dao.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ExtAuthTokenEntity.class)
public abstract class ExtAuthTokenEntity_ extends com.gnv.vnm.selfcare.dao.entity.BaseEntity_ {

	public static volatile SingularAttribute<ExtAuthTokenEntity, String> secretKey;
	public static volatile SingularAttribute<ExtAuthTokenEntity, String> extAppId;
	public static volatile SingularAttribute<ExtAuthTokenEntity, Integer> id;

}

