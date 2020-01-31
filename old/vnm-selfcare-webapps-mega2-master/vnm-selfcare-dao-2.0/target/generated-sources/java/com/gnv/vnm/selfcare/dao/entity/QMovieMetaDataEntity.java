package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMovieMetaDataEntity is a Querydsl query type for MovieMetaDataEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMovieMetaDataEntity extends EntityPathBase<MovieMetaDataEntity> {

    private static final long serialVersionUID = -1486610785L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMovieMetaDataEntity movieMetaDataEntity = new QMovieMetaDataEntity("movieMetaDataEntity");

    public final QMetaDataEntity _super = new QMetaDataEntity(this);

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

    protected QMovieEntity movie;

    //inherited
    public final StringPath name = _super.name;

    //inherited
    public final StringPath value = _super.value;

    public QMovieMetaDataEntity(String variable) {
        this(MovieMetaDataEntity.class, forVariable(variable), INITS);
    }

    public QMovieMetaDataEntity(Path<? extends MovieMetaDataEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMovieMetaDataEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMovieMetaDataEntity(PathMetadata metadata, PathInits inits) {
        this(MovieMetaDataEntity.class, metadata, inits);
    }

    public QMovieMetaDataEntity(Class<? extends MovieMetaDataEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.movie = inits.isInitialized("movie") ? new QMovieEntity(forProperty("movie"), inits.get("movie")) : null;
    }

    public QMovieEntity movie() {
        if (movie == null) {
            movie = new QMovieEntity(forProperty("movie"));
        }
        return movie;
    }

}

