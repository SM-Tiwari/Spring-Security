package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPushedCampaignStatusTrackerEntity is a Querydsl query type for PushedCampaignStatusTrackerEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPushedCampaignStatusTrackerEntity extends EntityPathBase<PushedCampaignStatusTrackerEntity> {

    private static final long serialVersionUID = 1184629437L;

    public static final QPushedCampaignStatusTrackerEntity pushedCampaignStatusTrackerEntity = new QPushedCampaignStatusTrackerEntity("pushedCampaignStatusTrackerEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final NumberPath<Integer> campaignId = createNumber("campaignId", Integer.class);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final StringPath msisdn = createString("msisdn");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public QPushedCampaignStatusTrackerEntity(String variable) {
        super(PushedCampaignStatusTrackerEntity.class, forVariable(variable));
    }

    public QPushedCampaignStatusTrackerEntity(Path<? extends PushedCampaignStatusTrackerEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPushedCampaignStatusTrackerEntity(PathMetadata metadata) {
        super(PushedCampaignStatusTrackerEntity.class, metadata);
    }

}

