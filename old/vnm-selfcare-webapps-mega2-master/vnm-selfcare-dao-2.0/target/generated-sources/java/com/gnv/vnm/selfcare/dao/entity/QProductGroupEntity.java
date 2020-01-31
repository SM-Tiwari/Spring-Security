package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductGroupEntity is a Querydsl query type for ProductGroupEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProductGroupEntity extends EntityPathBase<ProductGroupEntity> {

    private static final long serialVersionUID = -1832357898L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProductGroupEntity productGroupEntity = new QProductGroupEntity("productGroupEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    protected QProductCategoryEntity category;

    public final StringPath code = createString("code");

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final StringPath defaultBanner = createString("defaultBanner");

    public final StringPath defaultImage = createString("defaultImage");

    public final StringPath descriptionEN = createString("descriptionEN");

    public final StringPath descriptionVI = createString("descriptionVI");

    public final NumberPath<Integer> displayOrder = createNumber("displayOrder", Integer.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final SetPath<ProductGroupMetaDataEntity, QProductGroupMetaDataEntity> metadata = this.<ProductGroupMetaDataEntity, QProductGroupMetaDataEntity>createSet("metadata", ProductGroupMetaDataEntity.class, QProductGroupMetaDataEntity.class, PathInits.DIRECT2);

    public final StringPath nameEN = createString("nameEN");

    public final StringPath nameVI = createString("nameVI");

    public final SetPath<ProductEntity, QProductEntity> products = this.<ProductEntity, QProductEntity>createSet("products", ProductEntity.class, QProductEntity.class, PathInits.DIRECT2);

    public final NumberPath<Integer> visibility = createNumber("visibility", Integer.class);

    public QProductGroupEntity(String variable) {
        this(ProductGroupEntity.class, forVariable(variable), INITS);
    }

    public QProductGroupEntity(Path<? extends ProductGroupEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProductGroupEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProductGroupEntity(PathMetadata metadata, PathInits inits) {
        this(ProductGroupEntity.class, metadata, inits);
    }

    public QProductGroupEntity(Class<? extends ProductGroupEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new QProductCategoryEntity(forProperty("category")) : null;
    }

    public QProductCategoryEntity category() {
        if (category == null) {
            category = new QProductCategoryEntity(forProperty("category"));
        }
        return category;
    }

}

