package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBankEntity is a Querydsl query type for BankEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBankEntity extends EntityPathBase<BankEntity> {

    private static final long serialVersionUID = 1499926882L;

    public static final QBankEntity bankEntity = new QBankEntity("bankEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath code = createString("code");

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final StringPath displayName = createString("displayName");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final StringPath name = createString("name");

    public QBankEntity(String variable) {
        super(BankEntity.class, forVariable(variable));
    }

    public QBankEntity(Path<? extends BankEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBankEntity(PathMetadata metadata) {
        super(BankEntity.class, metadata);
    }

}

