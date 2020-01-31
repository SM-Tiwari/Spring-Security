package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHotNewsEntity is a Querydsl query type for HotNewsEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHotNewsEntity extends EntityPathBase<HotNewsEntity> {

    private static final long serialVersionUID = 1908536768L;

    public static final QHotNewsEntity hotNewsEntity = new QHotNewsEntity("hotNewsEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final StringPath detail_url = createString("detail_url");

    public final StringPath hotnewsCode = createString("hotnewsCode");

    public final StringPath hotnewsCreatedBy = createString("hotnewsCreatedBy");

    public final DateTimePath<java.util.Date> hotnewsCreateTime = createDateTime("hotnewsCreateTime", java.util.Date.class);

    public final StringPath hotnewsDefaultBanner = createString("hotnewsDefaultBanner");

    public final StringPath hotnewsDefaultImage = createString("hotnewsDefaultImage");

    public final StringPath hotnewsDescEN = createString("hotnewsDescEN");

    public final StringPath hotnewsDescVI = createString("hotnewsDescVI");

    public final StringPath hotnewsDetailEN = createString("hotnewsDetailEN");

    public final StringPath hotnewsDetailVI = createString("hotnewsDetailVI");

    public final NumberPath<Integer> hotnewsDisplayOrder = createNumber("hotnewsDisplayOrder", Integer.class);

    public final StringPath hotnewsExtCode = createString("hotnewsExtCode");

    public final NumberPath<Integer> hotnewsId = createNumber("hotnewsId", Integer.class);

    public final NumberPath<Integer> hotnewsIsVisible = createNumber("hotnewsIsVisible", Integer.class);

    public final DateTimePath<java.util.Date> hotnewsLastModifiedTime = createDateTime("hotnewsLastModifiedTime", java.util.Date.class);

    public final StringPath hotnewsModifiedBy = createString("hotnewsModifiedBy");

    public final StringPath hotnewsNameEN = createString("hotnewsNameEN");

    public final StringPath hotnewsNameVI = createString("hotnewsNameVI");

    public final StringPath hotnewsShortDescEN = createString("hotnewsShortDescEN");

    public final StringPath hotnewsShortDescVI = createString("hotnewsShortDescVI");

    public final StringPath hotnewsShortName = createString("hotnewsShortName");

    public final NumberPath<Integer> hotnewsStatus = createNumber("hotnewsStatus", Integer.class);

    public final DateTimePath<java.util.Date> hotnewsValidFromDate = createDateTime("hotnewsValidFromDate", java.util.Date.class);

    public final DateTimePath<java.util.Date> hotnewsValidToDate = createDateTime("hotnewsValidToDate", java.util.Date.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final StringPath myselectLink = createString("myselectLink");

    public QHotNewsEntity(String variable) {
        super(HotNewsEntity.class, forVariable(variable));
    }

    public QHotNewsEntity(Path<? extends HotNewsEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHotNewsEntity(PathMetadata metadata) {
        super(HotNewsEntity.class, metadata);
    }

}

