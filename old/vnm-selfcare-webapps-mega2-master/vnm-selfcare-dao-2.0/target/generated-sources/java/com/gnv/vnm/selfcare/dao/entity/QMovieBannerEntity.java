package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMovieBannerEntity is a Querydsl query type for MovieBannerEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMovieBannerEntity extends EntityPathBase<MovieBannerEntity> {

    private static final long serialVersionUID = -822946820L;

    public static final QMovieBannerEntity movieBannerEntity = new QMovieBannerEntity("movieBannerEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final DateTimePath<java.util.Date> endDate = createDateTime("endDate", java.util.Date.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final NumberPath<Integer> movieId = createNumber("movieId", Integer.class);

    public final DateTimePath<java.util.Date> startDate = createDateTime("startDate", java.util.Date.class);

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public QMovieBannerEntity(String variable) {
        super(MovieBannerEntity.class, forVariable(variable));
    }

    public QMovieBannerEntity(Path<? extends MovieBannerEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMovieBannerEntity(PathMetadata metadata) {
        super(MovieBannerEntity.class, metadata);
    }

}

