package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBalanceNameMappingEntity is a Querydsl query type for BalanceNameMappingEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBalanceNameMappingEntity extends EntityPathBase<BalanceNameMappingEntity> {

    private static final long serialVersionUID = 236275949L;

    public static final QBalanceNameMappingEntity balanceNameMappingEntity = new QBalanceNameMappingEntity("balanceNameMappingEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final NumberPath<Integer> countedFlag = createNumber("countedFlag", Integer.class);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final StringPath displayNameEN = createString("displayNameEN");

    public final StringPath displayNameVI = createString("displayNameVI");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final StringPath nameOnRTBS = createString("nameOnRTBS");

    public final StringPath nameOnTibco = createString("nameOnTibco");

    public final StringPath nameOnUpcc = createString("nameOnUpcc");

    public final StringPath remarks = createString("remarks");

    public final StringPath type = createString("type");

    public final StringPath unitName = createString("unitName");

    public final NumberPath<Integer> visibleFlag = createNumber("visibleFlag", Integer.class);

    public QBalanceNameMappingEntity(String variable) {
        super(BalanceNameMappingEntity.class, forVariable(variable));
    }

    public QBalanceNameMappingEntity(Path<? extends BalanceNameMappingEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBalanceNameMappingEntity(PathMetadata metadata) {
        super(BalanceNameMappingEntity.class, metadata);
    }

}

