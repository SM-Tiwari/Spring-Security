package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QOtpStatusEntity is a Querydsl query type for OtpStatusEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOtpStatusEntity extends EntityPathBase<OtpStatusEntity> {

    private static final long serialVersionUID = -704527619L;

    public static final QOtpStatusEntity otpStatusEntity = new QOtpStatusEntity("otpStatusEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final NumberPath<Integer> count = createNumber("count", Integer.class);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final NumberPath<Integer> failCount = createNumber("failCount", Integer.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final StringPath msisdn = createString("msisdn");

    public final StringPath status = createString("status");

    public final StringPath timeStamp = createString("timeStamp");

    public QOtpStatusEntity(String variable) {
        super(OtpStatusEntity.class, forVariable(variable));
    }

    public QOtpStatusEntity(Path<? extends OtpStatusEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOtpStatusEntity(PathMetadata metadata) {
        super(OtpStatusEntity.class, metadata);
    }

}

