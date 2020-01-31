package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMusicEntity is a Querydsl query type for MusicEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMusicEntity extends EntityPathBase<MusicEntity> {

    private static final long serialVersionUID = 1364458149L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMusicEntity musicEntity = new QMusicEntity("musicEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath albumName = createString("albumName");

    public final StringPath artistName = createString("artistName");

    protected QMusicCategoryEntity category;

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

    public final NumberPath<Long> duration = createNumber("duration", Long.class);

    public final StringPath format = createString("format");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final SetPath<MusicMetaDataEntity, QMusicMetaDataEntity> metadata = this.<MusicMetaDataEntity, QMusicMetaDataEntity>createSet("metadata", MusicMetaDataEntity.class, QMusicMetaDataEntity.class, PathInits.DIRECT2);

    public final StringPath previewURL = createString("previewURL");

    public final NumberPath<java.math.BigDecimal> price = createNumber("price", java.math.BigDecimal.class);

    public final StringPath productNameEN = createString("productNameEN");

    public final StringPath productNameVI = createString("productNameVI");

    public final NumberPath<Integer> quality = createNumber("quality", Integer.class);

    public final DateTimePath<java.util.Date> releaseDate = createDateTime("releaseDate", java.util.Date.class);

    public final StringPath sourceURL = createString("sourceURL");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public QMusicEntity(String variable) {
        this(MusicEntity.class, forVariable(variable), INITS);
    }

    public QMusicEntity(Path<? extends MusicEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMusicEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMusicEntity(PathMetadata metadata, PathInits inits) {
        this(MusicEntity.class, metadata, inits);
    }

    public QMusicEntity(Class<? extends MusicEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new QMusicCategoryEntity(forProperty("category")) : null;
    }

    public QMusicCategoryEntity category() {
        if (category == null) {
            category = new QMusicCategoryEntity(forProperty("category"));
        }
        return category;
    }

}

