package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSmsCallHistoryStatusEntity is a Querydsl query type for SmsCallHistoryStatusEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSmsCallHistoryStatusEntity extends EntityPathBase<SmsCallHistoryStatusEntity> {

    private static final long serialVersionUID = -324699531L;

    public static final QSmsCallHistoryStatusEntity smsCallHistoryStatusEntity = new QSmsCallHistoryStatusEntity("smsCallHistoryStatusEntity");

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

    public final StringPath status = createString("status");

    public QSmsCallHistoryStatusEntity(String variable) {
        super(SmsCallHistoryStatusEntity.class, forVariable(variable));
    }

    public QSmsCallHistoryStatusEntity(Path<? extends SmsCallHistoryStatusEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSmsCallHistoryStatusEntity(PathMetadata metadata) {
        super(SmsCallHistoryStatusEntity.class, metadata);
    }

}

