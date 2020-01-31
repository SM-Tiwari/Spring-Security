package com.gnv.vnm.selfcare.dao.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MusicCategoryEntity.class)
public abstract class MusicCategoryEntity_ extends com.gnv.vnm.selfcare.dao.entity.BaseEntity_ {

	public static volatile SingularAttribute<MusicCategoryEntity, String> nameVI;
	public static volatile SetAttribute<MusicCategoryEntity, MusicCategoryMetaDataEntity> metadata;
	public static volatile SingularAttribute<MusicCategoryEntity, String> code;
	public static volatile SingularAttribute<MusicCategoryEntity, Integer> displayOrder;
	public static volatile SingularAttribute<MusicCategoryEntity, Integer> parentCategoryId;
	public static volatile SingularAttribute<MusicCategoryEntity, Integer> id;
	public static volatile SingularAttribute<MusicCategoryEntity, String> nameEN;

}

