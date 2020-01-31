package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductCategoryMetaDataEntity is a Querydsl query type for ProductCategoryMetaDataEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProductCategoryMetaDataEntity extends EntityPathBase<ProductCategoryMetaDataEntity> {

    private static final long serialVersionUID = 1646968700L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProductCategoryMetaDataEntity productCategoryMetaDataEntity = new QProductCategoryMetaDataEntity("productCategoryMetaDataEntity");

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

    //inherited
    public final StringPath name = _super.name;

    protected QProductCategoryEntity productCategory;

    //inherited
    public final StringPath value = _super.value;

    public QProductCategoryMetaDataEntity(String variable) {
        this(ProductCategoryMetaDataEntity.class, forVariable(variable), INITS);
    }

    public QProductCategoryMetaDataEntity(Path<? extends ProductCategoryMetaDataEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProductCategoryMetaDataEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProductCategoryMetaDataEntity(PathMetadata metadata, PathInits inits) {
        this(ProductCategoryMetaDataEntity.class, metadata, inits);
    }

    public QProductCategoryMetaDataEntity(Class<? extends ProductCategoryMetaDataEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.productCategory = inits.isInitialized("productCategory") ? new QProductCategoryEntity(forProperty("productCategory")) : null;
    }

    public QProductCategoryEntity productCategory() {
        if (productCategory == null) {
            productCategory = new QProductCategoryEntity(forProperty("productCategory"));
        }
        return productCategory;
    }

}

