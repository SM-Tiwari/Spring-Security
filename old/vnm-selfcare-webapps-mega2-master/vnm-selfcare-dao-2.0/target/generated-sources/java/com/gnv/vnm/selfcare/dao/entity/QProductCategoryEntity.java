package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductCategoryEntity is a Querydsl query type for ProductCategoryEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProductCategoryEntity extends EntityPathBase<ProductCategoryEntity> {

    private static final long serialVersionUID = -335223475L;

    public static final QProductCategoryEntity productCategoryEntity = new QProductCategoryEntity("productCategoryEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath code = createString("code");

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final StringPath defaultBanner = createString("defaultBanner");

    public final StringPath defaultIcon = createString("defaultIcon");

    public final StringPath defaultImage = createString("defaultImage");

    public final StringPath descriptionEN = createString("descriptionEN");

    public final StringPath descriptionVI = createString("descriptionVI");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final SetPath<ProductCategoryMetaDataEntity, QProductCategoryMetaDataEntity> metadata = this.<ProductCategoryMetaDataEntity, QProductCategoryMetaDataEntity>createSet("metadata", ProductCategoryMetaDataEntity.class, QProductCategoryMetaDataEntity.class, PathInits.DIRECT2);

    public final StringPath nameEN = createString("nameEN");

    public final StringPath nameVI = createString("nameVI");

    public final NumberPath<Integer> parentCategoryId = createNumber("parentCategoryId", Integer.class);

    public QProductCategoryEntity(String variable) {
        super(ProductCategoryEntity.class, forVariable(variable));
    }

    public QProductCategoryEntity(Path<? extends ProductCategoryEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductCategoryEntity(PathMetadata metadata) {
        super(ProductCategoryEntity.class, metadata);
    }

}

