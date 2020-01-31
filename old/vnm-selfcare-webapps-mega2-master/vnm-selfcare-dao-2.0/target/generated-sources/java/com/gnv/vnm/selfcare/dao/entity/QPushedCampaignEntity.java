package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPushedCampaignEntity is a Querydsl query type for PushedCampaignEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPushedCampaignEntity extends EntityPathBase<PushedCampaignEntity> {

    private static final long serialVersionUID = -977395953L;

    public static final QPushedCampaignEntity pushedCampaignEntity = new QPushedCampaignEntity("pushedCampaignEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final StringPath descriptionEN = createString("descriptionEN");

    public final StringPath descriptionVI = createString("descriptionVI");

    public final StringPath detailsEN = createString("detailsEN");

    public final StringPath detailsVI = createString("detailsVI");

    public final NumberPath<Integer> displayType = createNumber("displayType", Integer.class);

    public final DateTimePath<java.util.Date> endDate = createDateTime("endDate", java.util.Date.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath imageURL = createString("imageURL");

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final NumberPath<Integer> sentCounter = createNumber("sentCounter", Integer.class);

    public final DateTimePath<java.util.Date> startDate = createDateTime("startDate", java.util.Date.class);

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final StringPath targetedUser = createString("targetedUser");

    public final StringPath titleEN = createString("titleEN");

    public final StringPath titleVI = createString("titleVI");

    public final NumberPath<Integer> type = createNumber("type", Integer.class);

    public QPushedCampaignEntity(String variable) {
        super(PushedCampaignEntity.class, forVariable(variable));
    }

    public QPushedCampaignEntity(Path<? extends PushedCampaignEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPushedCampaignEntity(PathMetadata metadata) {
        super(PushedCampaignEntity.class, metadata);
    }

}

