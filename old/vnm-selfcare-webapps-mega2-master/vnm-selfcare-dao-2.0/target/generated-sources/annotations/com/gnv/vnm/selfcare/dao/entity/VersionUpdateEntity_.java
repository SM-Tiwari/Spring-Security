package com.gnv.vnm.selfcare.dao.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(VersionUpdateEntity.class)
public abstract class VersionUpdateEntity_ extends com.gnv.vnm.selfcare.dao.entity.BaseEntity_ {

	public static volatile SingularAttribute<VersionUpdateEntity, String> updateVersion;
	public static volatile SingularAttribute<VersionUpdateEntity, String> appUpdateURL;
	public static volatile SingularAttribute<VersionUpdateEntity, String> osType;
	public static volatile SingularAttribute<VersionUpdateEntity, Integer> id;
	public static volatile SingularAttribute<VersionUpdateEntity, String> bundleIdentifier;
	public static volatile SingularAttribute<VersionUpdateEntity, String> currentVersion;
	public static volatile SingularAttribute<VersionUpdateEntity, String> isUpdate;
	public static volatile SingularAttribute<VersionUpdateEntity, String> isMandatory;

}

