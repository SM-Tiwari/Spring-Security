package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QProvinceEntity is a Querydsl query type for ProvinceEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProvinceEntity extends EntityPathBase<ProvinceEntity> {

    private static final long serialVersionUID = 828630486L;

    public static final QProvinceEntity provinceEntity = new QProvinceEntity("provinceEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final StringPath province = createString("province");

    public final NumberPath<Integer> provinceId = createNumber("provinceId", Integer.class);

    public QProvinceEntity(String variable) {
        super(ProvinceEntity.class, forVariable(variable));
    }

    public QProvinceEntity(Path<? extends ProvinceEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProvinceEntity(PathMetadata metadata) {
        super(ProvinceEntity.class, metadata);
    }

}

