package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMetaDataEntity is a Querydsl query type for MetaDataEntity
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QMetaDataEntity extends EntityPathBase<MetaDataEntity> {

    private static final long serialVersionUID = -1692608843L;

    public static final QMetaDataEntity metaDataEntity = new QMetaDataEntity("metaDataEntity");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.util.Date> createTimestamp = createDateTime("createTimestamp", java.util.Date.class);

    public final NumberPath<Integer> displayOrder = createNumber("displayOrder", Integer.class);

    public final StringPath lastModifiedBy = createString("lastModifiedBy");

    public final DateTimePath<java.util.Date> lastModifiedTime = createDateTime("lastModifiedTime", java.util.Date.class);

    public final StringPath name = createString("name");

    public final StringPath value = createString("value");

    public QMetaDataEntity(String variable) {
        super(MetaDataEntity.class, forVariable(variable));
    }

    public QMetaDataEntity(Path<? extends MetaDataEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMetaDataEntity(PathMetadata metadata) {
        super(MetaDataEntity.class, metadata);
    }

}

