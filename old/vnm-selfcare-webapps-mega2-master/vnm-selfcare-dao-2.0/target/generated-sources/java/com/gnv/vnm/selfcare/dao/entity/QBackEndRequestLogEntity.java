package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBackEndRequestLogEntity is a Querydsl query type for BackEndRequestLogEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBackEndRequestLogEntity extends EntityPathBase<BackEndRequestLogEntity> {

    private static final long serialVersionUID = -574443063L;

    public static final QBackEndRequestLogEntity backEndRequestLogEntity = new QBackEndRequestLogEntity("backEndRequestLogEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath adapterName = createString("adapterName");

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final DateTimePath<java.util.Date> endTime = createDateTime("endTime", java.util.Date.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final StringPath reqPayload = createString("reqPayload");

    public final DateTimePath<java.util.Date> startTime = createDateTime("startTime", java.util.Date.class);

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final StringPath statusCode = createString("statusCode");

    public final StringPath statusDesc = createString("statusDesc");

    public final StringPath trxId = createString("trxId");

    public QBackEndRequestLogEntity(String variable) {
        super(BackEndRequestLogEntity.class, forVariable(variable));
    }

    public QBackEndRequestLogEntity(Path<? extends BackEndRequestLogEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBackEndRequestLogEntity(PathMetadata metadata) {
        super(BackEndRequestLogEntity.class, metadata);
    }

}

