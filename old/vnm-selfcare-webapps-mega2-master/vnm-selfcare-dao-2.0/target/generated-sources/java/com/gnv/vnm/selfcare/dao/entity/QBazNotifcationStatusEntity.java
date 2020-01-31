package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBazNotifcationStatusEntity is a Querydsl query type for BazNotifcationStatusEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBazNotifcationStatusEntity extends EntityPathBase<BazNotifcationStatusEntity> {

    private static final long serialVersionUID = -1970430273L;

    public static final QBazNotifcationStatusEntity bazNotifcationStatusEntity = new QBazNotifcationStatusEntity("bazNotifcationStatusEntity");

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

    public final StringPath msisdn = createString("msisdn");

    public final StringPath notification_status = createString("notification_status");

    public final StringPath number_notification = createString("number_notification");

    public final StringPath read_by = createString("read_by");

    public final DateTimePath<java.util.Date> read_time = createDateTime("read_time", java.util.Date.class);

    public QBazNotifcationStatusEntity(String variable) {
        super(BazNotifcationStatusEntity.class, forVariable(variable));
    }

    public QBazNotifcationStatusEntity(Path<? extends BazNotifcationStatusEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBazNotifcationStatusEntity(PathMetadata metadata) {
        super(BazNotifcationStatusEntity.class, metadata);
    }

}

