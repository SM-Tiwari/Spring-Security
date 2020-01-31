package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAppsEntity is a Querydsl query type for AppsEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAppsEntity extends EntityPathBase<AppsEntity> {

    private static final long serialVersionUID = -1944824552L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAppsEntity appsEntity = new QAppsEntity("appsEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath androidSourceURL = createString("androidSourceURL");

    protected QAppsCategoryEntity category;

    public final StringPath code = createString("code");

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final StringPath defaultBanner = createString("defaultBanner");

    public final StringPath defaultIcon = createString("defaultIcon");

    public final StringPath defaultImage = createString("defaultImage");

    public final StringPath defaultWebBanner = createString("defaultWebBanner");

    public final StringPath descriptionEN = createString("descriptionEN");

    public final StringPath descriptionVI = createString("descriptionVI");

    public final StringPath displayNameEN = createString("displayNameEN");

    public final StringPath displayNameVI = createString("displayNameVI");

    public final NumberPath<Long> fileSize = createNumber("fileSize", Long.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath iosSourceURL = createString("iosSourceURL");

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final SetPath<AppsMetaDataEntity, QAppsMetaDataEntity> metadata = this.<AppsMetaDataEntity, QAppsMetaDataEntity>createSet("metadata", AppsMetaDataEntity.class, QAppsMetaDataEntity.class, PathInits.DIRECT2);

    public final StringPath notesEN = createString("notesEN");

    public final StringPath notesVI = createString("notesVI");

    public final StringPath previewURL = createString("previewURL");

    public final NumberPath<java.math.BigDecimal> price = createNumber("price", java.math.BigDecimal.class);

    public final StringPath producers = createString("producers");

    public final StringPath productNameEN = createString("productNameEN");

    public final StringPath productNameVI = createString("productNameVI");

    public final DateTimePath<java.util.Date> releaseDate = createDateTime("releaseDate", java.util.Date.class);

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final StringPath supportedSystems = createString("supportedSystems");

    public final StringPath version = createString("version");

    public QAppsEntity(String variable) {
        this(AppsEntity.class, forVariable(variable), INITS);
    }

    public QAppsEntity(Path<? extends AppsEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAppsEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAppsEntity(PathMetadata metadata, PathInits inits) {
        this(AppsEntity.class, metadata, inits);
    }

    public QAppsEntity(Class<? extends AppsEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new QAppsCategoryEntity(forProperty("category")) : null;
    }

    public QAppsCategoryEntity category() {
        if (category == null) {
            category = new QAppsCategoryEntity(forProperty("category"));
        }
        return category;
    }

}

