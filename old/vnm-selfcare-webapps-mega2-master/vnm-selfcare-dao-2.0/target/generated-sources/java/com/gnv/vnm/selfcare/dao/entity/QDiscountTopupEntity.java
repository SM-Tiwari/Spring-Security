package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDiscountTopupEntity is a Querydsl query type for DiscountTopupEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDiscountTopupEntity extends EntityPathBase<DiscountTopupEntity> {

    private static final long serialVersionUID = 1870760431L;

    public static final QDiscountTopupEntity discountTopupEntity = new QDiscountTopupEntity("discountTopupEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final StringPath discountCreatedBy = createString("discountCreatedBy");

    public final DateTimePath<java.util.Date> discountCreateTime = createDateTime("discountCreateTime", java.util.Date.class);

    public final StringPath discountDescEN = createString("discountDescEN");

    public final StringPath discountDescVI = createString("discountDescVI");

    public final StringPath discountDetailEN = createString("discountDetailEN");

    public final StringPath discountDetailVI = createString("discountDetailVI");

    public final DateTimePath<java.util.Date> discountLastModifiedTime = createDateTime("discountLastModifiedTime", java.util.Date.class);

    public final StringPath discountModifiedBy = createString("discountModifiedBy");

    public final StringPath discountNameEN = createString("discountNameEN");

    public final StringPath discountNameVI = createString("discountNameVI");

    public final NumberPath<Integer> discountStatus = createNumber("discountStatus", Integer.class);

    public final StringPath discounttopupCode = createString("discounttopupCode");

    public final NumberPath<Integer> discounttopupId = createNumber("discounttopupId", Integer.class);

    public final DateTimePath<java.util.Date> discountValidFromDate = createDateTime("discountValidFromDate", java.util.Date.class);

    public final DateTimePath<java.util.Date> discountValidToDate = createDateTime("discountValidToDate", java.util.Date.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final StringPath rechageAmount = createString("rechageAmount");

    public final StringPath rechageDiscount = createString("rechageDiscount");

    public QDiscountTopupEntity(String variable) {
        super(DiscountTopupEntity.class, forVariable(variable));
    }

    public QDiscountTopupEntity(Path<? extends DiscountTopupEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDiscountTopupEntity(PathMetadata metadata) {
        super(DiscountTopupEntity.class, metadata);
    }

}

