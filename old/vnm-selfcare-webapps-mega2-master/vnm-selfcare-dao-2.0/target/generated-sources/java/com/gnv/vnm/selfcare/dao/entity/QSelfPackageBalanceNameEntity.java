package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSelfPackageBalanceNameEntity is a Querydsl query type for SelfPackageBalanceNameEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSelfPackageBalanceNameEntity extends EntityPathBase<SelfPackageBalanceNameEntity> {

    private static final long serialVersionUID = 205046643L;

    public static final QSelfPackageBalanceNameEntity selfPackageBalanceNameEntity = new QSelfPackageBalanceNameEntity("selfPackageBalanceNameEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final StringPath descriptionEN = createString("descriptionEN");

    public final StringPath descriptionVI = createString("descriptionVI");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final NumberPath<Double> multiplierValue = createNumber("multiplierValue", Double.class);

    public final StringPath name = createString("name");

    public QSelfPackageBalanceNameEntity(String variable) {
        super(SelfPackageBalanceNameEntity.class, forVariable(variable));
    }

    public QSelfPackageBalanceNameEntity(Path<? extends SelfPackageBalanceNameEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSelfPackageBalanceNameEntity(PathMetadata metadata) {
        super(SelfPackageBalanceNameEntity.class, metadata);
    }

}

