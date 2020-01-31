package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMusicMetaDataEntity is a Querydsl query type for MusicMetaDataEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMusicMetaDataEntity extends EntityPathBase<MusicMetaDataEntity> {

    private static final long serialVersionUID = -1659175724L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMusicMetaDataEntity musicMetaDataEntity = new QMusicMetaDataEntity("musicMetaDataEntity");

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

    protected QMusicEntity music;

    //inherited
    public final StringPath name = _super.name;

    //inherited
    public final StringPath value = _super.value;

    public QMusicMetaDataEntity(String variable) {
        this(MusicMetaDataEntity.class, forVariable(variable), INITS);
    }

    public QMusicMetaDataEntity(Path<? extends MusicMetaDataEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMusicMetaDataEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMusicMetaDataEntity(PathMetadata metadata, PathInits inits) {
        this(MusicMetaDataEntity.class, metadata, inits);
    }

    public QMusicMetaDataEntity(Class<? extends MusicMetaDataEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.music = inits.isInitialized("music") ? new QMusicEntity(forProperty("music"), inits.get("music")) : null;
    }

    public QMusicEntity music() {
        if (music == null) {
            music = new QMusicEntity(forProperty("music"));
        }
        return music;
    }

}

