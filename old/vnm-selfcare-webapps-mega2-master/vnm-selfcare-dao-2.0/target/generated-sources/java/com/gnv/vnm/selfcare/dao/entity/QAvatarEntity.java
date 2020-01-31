package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAvatarEntity is a Querydsl query type for AvatarEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAvatarEntity extends EntityPathBase<AvatarEntity> {

    private static final long serialVersionUID = 2045953535L;

    public static final QAvatarEntity avatarEntity = new QAvatarEntity("avatarEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath category = createString("category");

    public final ArrayPath<byte[], Byte> content = createArray("content", byte[].class);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final StringPath fileName = createString("fileName");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> imageHeight = createNumber("imageHeight", Integer.class);

    public final NumberPath<Integer> imageWidth = createNumber("imageWidth", Integer.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final StringPath title = createString("title");

    public QAvatarEntity(String variable) {
        super(AvatarEntity.class, forVariable(variable));
    }

    public QAvatarEntity(Path<? extends AvatarEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAvatarEntity(PathMetadata metadata) {
        super(AvatarEntity.class, metadata);
    }

}

