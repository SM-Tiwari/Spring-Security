package com.gnv.vnm.selfcare.dao.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PushedCampaignEntity.class)
public abstract class PushedCampaignEntity_ extends com.gnv.vnm.selfcare.dao.entity.BaseEntity_ {

	public static volatile SingularAttribute<PushedCampaignEntity, String> descriptionEN;
	public static volatile SingularAttribute<PushedCampaignEntity, Date> endDate;
	public static volatile SingularAttribute<PushedCampaignEntity, String> descriptionVI;
	public static volatile SingularAttribute<PushedCampaignEntity, String> targetedUser;
	public static volatile SingularAttribute<PushedCampaignEntity, Integer> type;
	public static volatile SingularAttribute<PushedCampaignEntity, String> detailsEN;
	public static volatile SingularAttribute<PushedCampaignEntity, String> detailsVI;
	public static volatile SingularAttribute<PushedCampaignEntity, Integer> sentCounter;
	public static volatile SingularAttribute<PushedCampaignEntity, Integer> displayType;
	public static volatile SingularAttribute<PushedCampaignEntity, String> titleEN;
	public static volatile SingularAttribute<PushedCampaignEntity, String> imageURL;
	public static volatile SingularAttribute<PushedCampaignEntity, Integer> id;
	public static volatile SingularAttribute<PushedCampaignEntity, Date> startDate;
	public static volatile SingularAttribute<PushedCampaignEntity, String> titleVI;
	public static volatile SingularAttribute<PushedCampaignEntity, Integer> status;

}

