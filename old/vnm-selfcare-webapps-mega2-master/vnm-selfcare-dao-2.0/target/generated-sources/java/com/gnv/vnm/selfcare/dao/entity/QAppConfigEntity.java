package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAppConfigEntity is a Querydsl query type for AppConfigEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAppConfigEntity extends EntityPathBase<AppConfigEntity> {

    private static final long serialVersionUID = -207829949L;

    public static final QAppConfigEntity appConfigEntity = new QAppConfigEntity("appConfigEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final StringPath description = createString("description");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> isFlag = createNumber("isFlag", Integer.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final StringPath name = createString("name");

    public final StringPath value = createString("value");

    public QAppConfigEntity(String variable) {
        super(AppConfigEntity.class, forVariable(variable));
    }

    public QAppConfigEntity(Path<? extends AppConfigEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAppConfigEntity(PathMetadata metadata) {
        super(AppConfigEntity.class, metadata);
    }

}

