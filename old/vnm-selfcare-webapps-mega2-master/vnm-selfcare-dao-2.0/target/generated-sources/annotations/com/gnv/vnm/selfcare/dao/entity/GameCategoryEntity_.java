package com.gnv.vnm.selfcare.dao.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GameCategoryEntity.class)
public abstract class GameCategoryEntity_ extends com.gnv.vnm.selfcare.dao.entity.BaseEntity_ {

	public static volatile SingularAttribute<GameCategoryEntity, String> nameVI;
	public static volatile SetAttribute<GameCategoryEntity, GameCategoryMetaDataEntity> metadata;
	public static volatile SingularAttribute<GameCategoryEntity, String> code;
	public static volatile SingularAttribute<GameCategoryEntity, Integer> displayOrder;
	public static volatile SingularAttribute<GameCategoryEntity, Integer> parentCategoryId;
	public static volatile SingularAttribute<GameCategoryEntity, Integer> id;
	public static volatile SingularAttribute<GameCategoryEntity, String> nameEN;

}

