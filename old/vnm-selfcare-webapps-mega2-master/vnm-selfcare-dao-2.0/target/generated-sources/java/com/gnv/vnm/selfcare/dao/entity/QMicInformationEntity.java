package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMicInformationEntity is a Querydsl query type for MicInformationEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMicInformationEntity extends EntityPathBase<MicInformationEntity> {

    private static final long serialVersionUID = 1324092683L;

    public static final QMicInformationEntity micInformationEntity = new QMicInformationEntity("micInformationEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath Address = createString("Address");

    public final StringPath country = createString("country");

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final StringPath customerPortrait = createString("customerPortrait");

    public final StringPath customerSignature = createString("customerSignature");

    public final StringPath date_of_issue = createString("date_of_issue");

    public final StringPath district = createString("district");

    public final StringPath dob = createString("dob");

    public final StringPath firstNmae = createString("firstNmae");

    public final StringPath firstSideIdcard = createString("firstSideIdcard");

    public final StringPath gender = createString("gender");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath idCard = createString("idCard");

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final StringPath lastName = createString("lastName");

    public final StringPath msisdn = createString("msisdn");

    public final StringPath placeOfIssue = createString("placeOfIssue");

    public final StringPath province = createString("province");

    public final StringPath secondSideIdcard = createString("secondSideIdcard");

    public QMicInformationEntity(String variable) {
        super(MicInformationEntity.class, forVariable(variable));
    }

    public QMicInformationEntity(Path<? extends MicInformationEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMicInformationEntity(PathMetadata metadata) {
        super(MicInformationEntity.class, metadata);
    }

}

