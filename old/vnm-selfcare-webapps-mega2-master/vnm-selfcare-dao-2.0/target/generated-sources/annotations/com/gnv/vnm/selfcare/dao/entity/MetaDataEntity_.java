package com.gnv.vnm.selfcare.dao.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MetaDataEntity.class)
public abstract class MetaDataEntity_ {

	public static volatile SingularAttribute<MetaDataEntity, Date> lastModifiedTime;
	public static volatile SingularAttribute<MetaDataEntity, String> createdBy;
	public static volatile SingularAttribute<MetaDataEntity, String> lastModifiedBy;
	public static volatile SingularAttribute<MetaDataEntity, String> name;
	public static volatile SingularAttribute<MetaDataEntity, Integer> displayOrder;
	public static volatile SingularAttribute<MetaDataEntity, String> value;
	public static volatile SingularAttribute<MetaDataEntity, Date> createTimestamp;

}

