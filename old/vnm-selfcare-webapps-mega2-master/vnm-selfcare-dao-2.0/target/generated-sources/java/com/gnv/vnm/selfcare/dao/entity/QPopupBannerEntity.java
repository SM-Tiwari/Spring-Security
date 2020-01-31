package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPopupBannerEntity is a Querydsl query type for PopupBannerEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPopupBannerEntity extends EntityPathBase<PopupBannerEntity> {

    private static final long serialVersionUID = 2077404024L;

    public static final QPopupBannerEntity popupBannerEntity = new QPopupBannerEntity("popupBannerEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final StringPath popupBannerCode = createString("popupBannerCode");

    public final StringPath popupbannerCreatedBy = createString("popupbannerCreatedBy");

    public final DateTimePath<java.util.Date> popupbannerCreateTime = createDateTime("popupbannerCreateTime", java.util.Date.class);

    public final StringPath popupbannerDefaultBanner = createString("popupbannerDefaultBanner");

    public final StringPath popupbannerDescEN = createString("popupbannerDescEN");

    public final StringPath popupbannerDescVI = createString("popupbannerDescVI");

    public final StringPath popupbannerDetailEN = createString("popupbannerDetailEN");

    public final StringPath popupbannerDetailVI = createString("popupbannerDetailVI");

    public final NumberPath<Integer> popupbannerDisplayOrder = createNumber("popupbannerDisplayOrder", Integer.class);

    public final NumberPath<Integer> popupBannerId = createNumber("popupBannerId", Integer.class);

    public final NumberPath<Integer> popupbannerIsVisible = createNumber("popupbannerIsVisible", Integer.class);

    public final DateTimePath<java.util.Date> popupbannerLastModifiedTime = createDateTime("popupbannerLastModifiedTime", java.util.Date.class);

    public final StringPath popupBannerLink = createString("popupBannerLink");

    public final StringPath popupbannerModifiedBy = createString("popupbannerModifiedBy");

    public final StringPath popupbannerNameEN = createString("popupbannerNameEN");

    public final StringPath popupbannerNameVI = createString("popupbannerNameVI");

    public final StringPath popupbannerShortDescEN = createString("popupbannerShortDescEN");

    public final StringPath popupbannerShortDescVI = createString("popupbannerShortDescVI");

    public final StringPath popupbannerShortName = createString("popupbannerShortName");

    public final NumberPath<Integer> popupbannerStatus = createNumber("popupbannerStatus", Integer.class);

    public final DateTimePath<java.util.Date> popupbannerValidFromDate = createDateTime("popupbannerValidFromDate", java.util.Date.class);

    public final DateTimePath<java.util.Date> popupbannerValidToDate = createDateTime("popupbannerValidToDate", java.util.Date.class);

    public QPopupBannerEntity(String variable) {
        super(PopupBannerEntity.class, forVariable(variable));
    }

    public QPopupBannerEntity(Path<? extends PopupBannerEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPopupBannerEntity(PathMetadata metadata) {
        super(PopupBannerEntity.class, metadata);
    }

}

