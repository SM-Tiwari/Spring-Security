package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMovieEntity is a Querydsl query type for MovieEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMovieEntity extends EntityPathBase<MovieEntity> {

    private static final long serialVersionUID = -1103816848L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMovieEntity movieEntity = new QMovieEntity("movieEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath actors = createString("actors");

    protected QMovieCategoryEntity category;

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

    public final StringPath directors = createString("directors");

    public final StringPath displayNameEN = createString("displayNameEN");

    public final StringPath displayNameVI = createString("displayNameVI");

    public final NumberPath<Long> duration = createNumber("duration", Long.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final SetPath<MovieMetaDataEntity, QMovieMetaDataEntity> metadata = this.<MovieMetaDataEntity, QMovieMetaDataEntity>createSet("metadata", MovieMetaDataEntity.class, QMovieMetaDataEntity.class, PathInits.DIRECT2);

    public final StringPath previewURL = createString("previewURL");

    public final NumberPath<java.math.BigDecimal> price = createNumber("price", java.math.BigDecimal.class);

    public final StringPath producers = createString("producers");

    public final StringPath productNameEN = createString("productNameEN");

    public final StringPath productNameVI = createString("productNameVI");

    public final DateTimePath<java.util.Date> releaseDate = createDateTime("releaseDate", java.util.Date.class);

    public final StringPath sourceURL = createString("sourceURL");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final StringPath storyLineEN = createString("storyLineEN");

    public final StringPath storyLineVI = createString("storyLineVI");

    public final StringPath writers = createString("writers");

    public QMovieEntity(String variable) {
        this(MovieEntity.class, forVariable(variable), INITS);
    }

    public QMovieEntity(Path<? extends MovieEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMovieEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMovieEntity(PathMetadata metadata, PathInits inits) {
        this(MovieEntity.class, metadata, inits);
    }

    public QMovieEntity(Class<? extends MovieEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new QMovieCategoryEntity(forProperty("category")) : null;
    }

    public QMovieCategoryEntity category() {
        if (category == null) {
            category = new QMovieCategoryEntity(forProperty("category"));
        }
        return category;
    }

}

