package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMusicCategoryMetaDataEntity is a Querydsl query type for MusicCategoryMetaDataEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMusicCategoryMetaDataEntity extends EntityPathBase<MusicCategoryMetaDataEntity> {

    private static final long serialVersionUID = -1459155086L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMusicCategoryMetaDataEntity musicCategoryMetaDataEntity = new QMusicCategoryMetaDataEntity("musicCategoryMetaDataEntity");

    public final QMetaDataEntity _super = new QMetaDataEntity(this);

    protected QMusicCategoryEntity category;

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

    public QMusicCategoryMetaDataEntity(String variable) {
        this(MusicCategoryMetaDataEntity.class, forVariable(variable), INITS);
    }

    public QMusicCategoryMetaDataEntity(Path<? extends MusicCategoryMetaDataEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMusicCategoryMetaDataEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMusicCategoryMetaDataEntity(PathMetadata metadata, PathInits inits) {
        this(MusicCategoryMetaDataEntity.class, metadata, inits);
    }

    public QMusicCategoryMetaDataEntity(Class<? extends MusicCategoryMetaDataEntity> type, PathMetadata metadata, PathInits inits) {
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

