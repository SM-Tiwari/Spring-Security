package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAppsMetaDataEntity is a Querydsl query type for AppsMetaDataEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAppsMetaDataEntity extends EntityPathBase<AppsMetaDataEntity> {

    private static final long serialVersionUID = -1046531001L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAppsMetaDataEntity appsMetaDataEntity = new QAppsMetaDataEntity("appsMetaDataEntity");

    public final QMetaDataEntity _super = new QMetaDataEntity(this);

    protected QAppsEntity apps;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    //inherited
    public final NumberPath<Integer> displayOrder = _super.displayOrder;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    //inherited
    public final StringPath name = _super.name;

    //inherited
    public final StringPath value = _super.value;

    public QAppsMetaDataEntity(String variable) {
        this(AppsMetaDataEntity.class, forVariable(variable), INITS);
    }

    public QAppsMetaDataEntity(Path<? extends AppsMetaDataEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAppsMetaDataEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAppsMetaDataEntity(PathMetadata metadata, PathInits inits) {
        this(AppsMetaDataEntity.class, metadata, inits);
    }

    public QAppsMetaDataEntity(Class<? extends AppsMetaDataEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.apps = inits.isInitialized("apps") ? new QAppsEntity(forProperty("apps"), inits.get("apps")) : null;
    }

    public QAppsEntity apps() {
        if (apps == null) {
            apps = new QAppsEntity(forProperty("apps"));
        }
        return apps;
    }

}

