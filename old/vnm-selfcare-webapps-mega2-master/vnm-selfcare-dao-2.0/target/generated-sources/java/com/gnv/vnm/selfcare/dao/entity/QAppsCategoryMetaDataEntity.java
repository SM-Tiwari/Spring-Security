package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAppsCategoryMetaDataEntity is a Querydsl query type for AppsCategoryMetaDataEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAppsCategoryMetaDataEntity extends EntityPathBase<AppsCategoryMetaDataEntity> {

    private static final long serialVersionUID = 1478632421L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAppsCategoryMetaDataEntity appsCategoryMetaDataEntity = new QAppsCategoryMetaDataEntity("appsCategoryMetaDataEntity");

    public final QMetaDataEntity _super = new QMetaDataEntity(this);

    protected QAppsCategoryEntity category;

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

    public QAppsCategoryMetaDataEntity(String variable) {
        this(AppsCategoryMetaDataEntity.class, forVariable(variable), INITS);
    }

    public QAppsCategoryMetaDataEntity(Path<? extends AppsCategoryMetaDataEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAppsCategoryMetaDataEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAppsCategoryMetaDataEntity(PathMetadata metadata, PathInits inits) {
        this(AppsCategoryMetaDataEntity.class, metadata, inits);
    }

    public QAppsCategoryMetaDataEntity(Class<? extends AppsCategoryMetaDataEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new QAppsCategoryEntity(forProperty("category")) : null;
    }

    public QAppsCategoryEntity category() {
        if (category == null) {
            category = new QAppsCategoryEntity(forProperty("category"));
        }
        return category;
    }

}

