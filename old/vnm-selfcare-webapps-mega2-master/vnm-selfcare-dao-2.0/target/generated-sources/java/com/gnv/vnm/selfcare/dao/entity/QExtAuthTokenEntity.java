package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QExtAuthTokenEntity is a Querydsl query type for ExtAuthTokenEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QExtAuthTokenEntity extends EntityPathBase<ExtAuthTokenEntity> {

    private static final long serialVersionUID = 394799414L;

    public static final QExtAuthTokenEntity extAuthTokenEntity = new QExtAuthTokenEntity("extAuthTokenEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final StringPath extAppId = createString("extAppId");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final StringPath secretKey = createString("secretKey");

    public QExtAuthTokenEntity(String variable) {
        super(ExtAuthTokenEntity.class, forVariable(variable));
    }

    public QExtAuthTokenEntity(Path<? extends ExtAuthTokenEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QExtAuthTokenEntity(PathMetadata metadata) {
        super(ExtAuthTokenEntity.class, metadata);
    }

}

