package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QOtpEntity is a Querydsl query type for OtpEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOtpEntity extends EntityPathBase<OtpEntity> {

    private static final long serialVersionUID = -1663612309L;

    public static final QOtpEntity otpEntity = new QOtpEntity("otpEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath key = createString("key");

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final StringPath subscriberId = createString("subscriberId");

    public QOtpEntity(String variable) {
        super(OtpEntity.class, forVariable(variable));
    }

    public QOtpEntity(Path<? extends OtpEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOtpEntity(PathMetadata metadata) {
        super(OtpEntity.class, metadata);
    }

}

