package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QLoginHistoryEntity is a Querydsl query type for LoginHistoryEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLoginHistoryEntity extends EntityPathBase<LoginHistoryEntity> {

    private static final long serialVersionUID = -1106293295L;

    public static final QLoginHistoryEntity loginHistoryEntity = new QLoginHistoryEntity("loginHistoryEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath clientAppId = createString("clientAppId");

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath lastLoginFrom = createString("lastLoginFrom");

    public final DateTimePath<java.util.Date> lastLoginTime = createDateTime("lastLoginTime", java.util.Date.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final DateTimePath<java.util.Date> logoutTime = createDateTime("logoutTime", java.util.Date.class);

    public final StringPath msisdn = createString("msisdn");

    public QLoginHistoryEntity(String variable) {
        super(LoginHistoryEntity.class, forVariable(variable));
    }

    public QLoginHistoryEntity(Path<? extends LoginHistoryEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLoginHistoryEntity(PathMetadata metadata) {
        super(LoginHistoryEntity.class, metadata);
    }

}

