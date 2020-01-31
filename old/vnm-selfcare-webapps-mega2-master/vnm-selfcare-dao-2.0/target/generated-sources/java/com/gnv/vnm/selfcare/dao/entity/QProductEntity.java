package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductEntity is a Querydsl query type for ProductEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProductEntity extends EntityPathBase<ProductEntity> {

    private static final long serialVersionUID = 1851588271L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProductEntity productEntity = new QProductEntity("productEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final NumberPath<Integer> balanceDisplayOption = createNumber("balanceDisplayOption", Integer.class);

    public final StringPath code = createString("code");

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final NumberPath<Integer> dashboardVisibility = createNumber("dashboardVisibility", Integer.class);

    public final StringPath defaultBanner = createString("defaultBanner");

    public final StringPath defaultImage = createString("defaultImage");

    public final StringPath descriptionEN = createString("descriptionEN");

    public final StringPath descriptionVI = createString("descriptionVI");

    public final StringPath detailsEN = createString("detailsEN");

    public final StringPath detailsVI = createString("detailsVI");

    public final NumberPath<Integer> displayOrder = createNumber("displayOrder", Integer.class);

    public final StringPath extCode = createString("extCode");

    public final StringPath extProductName = createString("extProductName");

    public final StringPath howToRegEN = createString("howToRegEN");

    public final StringPath howToRegVI = createString("howToRegVI");

    public final StringPath howToUnregEN = createString("howToUnregEN");

    public final StringPath howToUnregVI = createString("howToUnregVI");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final SetPath<ProductMetaDataEntity, QProductMetaDataEntity> metadata = this.<ProductMetaDataEntity, QProductMetaDataEntity>createSet("metadata", ProductMetaDataEntity.class, QProductMetaDataEntity.class, PathInits.DIRECT2);

    public final StringPath nameEN = createString("nameEN");

    public final StringPath nameVI = createString("nameVI");

    public final NumberPath<java.math.BigDecimal> price = createNumber("price", java.math.BigDecimal.class);

    protected QProductGroupEntity productGroup;

    public final StringPath quotaInfo = createString("quotaInfo");

    public final StringPath shortDescriptionEN = createString("shortDescriptionEN");

    public final StringPath shortDescriptionVI = createString("shortDescriptionVI");

    public final StringPath shortNameEN = createString("shortNameEN");

    public final StringPath shortNameVI = createString("shortNameVI");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final NumberPath<Integer> subscriberType = createNumber("subscriberType", Integer.class);

    public final DateTimePath<java.util.Date> validFromDate = createDateTime("validFromDate", java.util.Date.class);

    public final DateTimePath<java.util.Date> validToDate = createDateTime("validToDate", java.util.Date.class);

    public final NumberPath<Integer> visibility = createNumber("visibility", Integer.class);

    public QProductEntity(String variable) {
        this(ProductEntity.class, forVariable(variable), INITS);
    }

    public QProductEntity(Path<? extends ProductEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProductEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProductEntity(PathMetadata metadata, PathInits inits) {
        this(ProductEntity.class, metadata, inits);
    }

    public QProductEntity(Class<? extends ProductEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.productGroup = inits.isInitialized("productGroup") ? new QProductGroupEntity(forProperty("productGroup"), inits.get("productGroup")) : null;
    }

    public QProductGroupEntity productGroup() {
        if (productGroup == null) {
            productGroup = new QProductGroupEntity(forProperty("productGroup"));
        }
        return productGroup;
    }

}

