package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMusicBannerEntity is a Querydsl query type for MusicBannerEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMusicBannerEntity extends EntityPathBase<MusicBannerEntity> {

    private static final long serialVersionUID = 767933297L;

    public static final QMusicBannerEntity musicBannerEntity = new QMusicBannerEntity("musicBannerEntity");

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

    public final NumberPath<Integer> musicId = createNumber("musicId", Integer.class);

    public final DateTimePath<java.util.Date> startDate = createDateTime("startDate", java.util.Date.class);

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public QMusicBannerEntity(String variable) {
        super(MusicBannerEntity.class, forVariable(variable));
    }

    public QMusicBannerEntity(Path<? extends MusicBannerEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMusicBannerEntity(PathMetadata metadata) {
        super(MusicBannerEntity.class, metadata);
    }

}

