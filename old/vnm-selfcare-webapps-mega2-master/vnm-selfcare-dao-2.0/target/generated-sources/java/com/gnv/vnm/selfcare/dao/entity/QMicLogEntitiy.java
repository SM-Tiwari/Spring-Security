package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMicLogEntitiy is a Querydsl query type for MicLogEntitiy
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMicLogEntitiy extends EntityPathBase<MicLogEntitiy> {

    private static final long serialVersionUID = 837139910L;

    public static final QMicLogEntitiy micLogEntitiy = new QMicLogEntitiy("micLogEntitiy");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath clientType = createString("clientType");

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final NumberPath<Integer> logId = createNumber("logId", Integer.class);

    public final StringPath logMessage = createString("logMessage");

    public final StringPath msisdn = createString("msisdn");

    public QMicLogEntitiy(String variable) {
        super(MicLogEntitiy.class, forVariable(variable));
    }

    public QMicLogEntitiy(Path<? extends MicLogEntitiy> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMicLogEntitiy(PathMetadata metadata) {
        super(MicLogEntitiy.class, metadata);
    }

}

