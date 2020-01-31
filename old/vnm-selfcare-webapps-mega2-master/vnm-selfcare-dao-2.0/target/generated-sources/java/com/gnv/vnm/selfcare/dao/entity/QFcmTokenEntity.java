package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QFcmTokenEntity is a Querydsl query type for FcmTokenEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QFcmTokenEntity extends EntityPathBase<FcmTokenEntity> {

    private static final long serialVersionUID = 940532847L;

    public static final QFcmTokenEntity fcmTokenEntity = new QFcmTokenEntity("fcmTokenEntity");

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

    public final DateTimePath<java.util.Date> lastUsed = createDateTime("lastUsed", java.util.Date.class);

    public final StringPath msisdn = createString("msisdn");

    public final StringPath osType = createString("osType");

    public final StringPath token = createString("token");

    public QFcmTokenEntity(String variable) {
        super(FcmTokenEntity.class, forVariable(variable));
    }

    public QFcmTokenEntity(Path<? extends FcmTokenEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFcmTokenEntity(PathMetadata metadata) {
        super(FcmTokenEntity.class, metadata);
    }

}

