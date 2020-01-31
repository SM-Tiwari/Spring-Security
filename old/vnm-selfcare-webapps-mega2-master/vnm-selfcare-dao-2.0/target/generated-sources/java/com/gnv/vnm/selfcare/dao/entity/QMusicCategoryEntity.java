package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMusicCategoryEntity is a Querydsl query type for MusicCategoryEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMusicCategoryEntity extends EntityPathBase<MusicCategoryEntity> {

    private static final long serialVersionUID = 194218819L;

    public static final QMusicCategoryEntity musicCategoryEntity = new QMusicCategoryEntity("musicCategoryEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath code = createString("code");

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final NumberPath<Integer> displayOrder = createNumber("displayOrder", Integer.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final SetPath<MusicCategoryMetaDataEntity, QMusicCategoryMetaDataEntity> metadata = this.<MusicCategoryMetaDataEntity, QMusicCategoryMetaDataEntity>createSet("metadata", MusicCategoryMetaDataEntity.class, QMusicCategoryMetaDataEntity.class, PathInits.DIRECT2);

    public final StringPath nameEN = createString("nameEN");

    public final StringPath nameVI = createString("nameVI");

    public final NumberPath<Integer> parentCategoryId = createNumber("parentCategoryId", Integer.class);

    public QMusicCategoryEntity(String variable) {
        super(MusicCategoryEntity.class, forVariable(variable));
    }

    public QMusicCategoryEntity(Path<? extends MusicCategoryEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMusicCategoryEntity(PathMetadata metadata) {
        super(MusicCategoryEntity.class, metadata);
    }

}

