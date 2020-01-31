package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSocialMediaIntegrationEntity is a Querydsl query type for SocialMediaIntegrationEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSocialMediaIntegrationEntity extends EntityPathBase<SocialMediaIntegrationEntity> {

    private static final long serialVersionUID = 1089512579L;

    public static final QSocialMediaIntegrationEntity socialMediaIntegrationEntity = new QSocialMediaIntegrationEntity("socialMediaIntegrationEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final NumberPath<Integer> media_count_fail = createNumber("media_count_fail", Integer.class);

    public final NumberPath<Integer> media_count_sucess = createNumber("media_count_sucess", Integer.class);

    public final StringPath msisdn = createString("msisdn");

    public final StringPath share_os_type = createString("share_os_type");

    public final StringPath share_product_deatils = createString("share_product_deatils");

    public final NumberPath<Integer> share_product_id = createNumber("share_product_id", Integer.class);

    public final StringPath social_media_name = createString("social_media_name");

    public QSocialMediaIntegrationEntity(String variable) {
        super(SocialMediaIntegrationEntity.class, forVariable(variable));
    }

    public QSocialMediaIntegrationEntity(Path<? extends SocialMediaIntegrationEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSocialMediaIntegrationEntity(PathMetadata metadata) {
        super(SocialMediaIntegrationEntity.class, metadata);
    }

}

