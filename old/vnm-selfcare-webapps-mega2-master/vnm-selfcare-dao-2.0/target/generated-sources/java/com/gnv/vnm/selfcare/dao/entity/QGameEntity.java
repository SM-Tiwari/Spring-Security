package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGameEntity is a Querydsl query type for GameEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGameEntity extends EntityPathBase<GameEntity> {

    private static final long serialVersionUID = 2039461528L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGameEntity gameEntity = new QGameEntity("gameEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath androidSourceURL = createString("androidSourceURL");

    protected QGameCategoryEntity category;

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

    public final SetPath<GameMetaDataEntity, QGameMetaDataEntity> metadata = this.<GameMetaDataEntity, QGameMetaDataEntity>createSet("metadata", GameMetaDataEntity.class, QGameMetaDataEntity.class, PathInits.DIRECT2);

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

    public QGameEntity(String variable) {
        this(GameEntity.class, forVariable(variable), INITS);
    }

    public QGameEntity(Path<? extends GameEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGameEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGameEntity(PathMetadata metadata, PathInits inits) {
        this(GameEntity.class, metadata, inits);
    }

    public QGameEntity(Class<? extends GameEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new QGameCategoryEntity(forProperty("category")) : null;
    }

    public QGameCategoryEntity category() {
        if (category == null) {
            category = new QGameCategoryEntity(forProperty("category"));
        }
        return category;
    }

}

