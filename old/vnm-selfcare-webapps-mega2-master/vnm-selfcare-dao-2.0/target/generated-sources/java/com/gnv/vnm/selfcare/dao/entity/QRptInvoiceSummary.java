package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRptInvoiceSummary is a Querydsl query type for RptInvoiceSummary
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRptInvoiceSummary extends EntityPathBase<RptInvoiceSummary> {

    private static final long serialVersionUID = 825141708L;

    public static final QRptInvoiceSummary rptInvoiceSummary = new QRptInvoiceSummary("rptInvoiceSummary");

    public final StringPath accountname = createString("accountname");

    public final StringPath accountnumber = createString("accountnumber");

    public final StringPath address1 = createString("address1");

    public final StringPath address2 = createString("address2");

    public final StringPath address3 = createString("address3");

    public final StringPath addressname = createString("addressname");

    public final NumberPath<Double> adjustment = createNumber("adjustment", Double.class);

    public final NumberPath<Double> balancebroughtforward = createNumber("balancebroughtforward", Double.class);

    public final StringPath callingplan = createString("callingplan");

    public final NumberPath<Double> charge = createNumber("charge", Double.class);

    public final StringPath city = createString("city");

    public final StringPath contractnum = createString("contractnum");

    public final NumberPath<Double> contractpenaltycharge = createNumber("contractpenaltycharge", Double.class);

    public final NumberPath<Double> creditlimit = createNumber("creditlimit", Double.class);

    public final StringPath customertype = createString("customertype");

    public final NumberPath<Double> datacharges = createNumber("datacharges", Double.class);

    public final NumberPath<Double> depositmoney = createNumber("depositmoney", Double.class);

    public final StringPath detailrecord = createString("detailrecord");

    public final NumberPath<Double> discount = createNumber("discount", Double.class);

    public final DateTimePath<java.util.Date> endperiod = createDateTime("endperiod", java.util.Date.class);

    public final NumberPath<Double> excesspayment = createNumber("excesspayment", Double.class);

    public final StringPath fiturcallbaring = createString("fiturcallbaring");

    public final StringPath fiturdata = createString("fiturdata");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Double> iddcharges = createNumber("iddcharges", Double.class);

    public final DateTimePath<java.util.Date> invoicedate = createDateTime("invoicedate", java.util.Date.class);

    public final DateTimePath<java.util.Date> invoiceduedate = createDateTime("invoiceduedate", java.util.Date.class);

    public final StringPath invoicenumber = createString("invoicenumber");

    public final NumberPath<Double> ircharges = createNumber("ircharges", Double.class);

    public final NumberPath<Double> lastmonthbill = createNumber("lastmonthbill", Double.class);

    public final NumberPath<Double> localcharges = createNumber("localcharges", Double.class);

    public final NumberPath<Double> longdistance = createNumber("longdistance", Double.class);

    public final NumberPath<Double> minimumcommitmentcharge = createNumber("minimumcommitmentcharge", Double.class);

    public final NumberPath<Double> mmscharges = createNumber("mmscharges", Double.class);

    public final NumberPath<Double> monthlycharge = createNumber("monthlycharge", Double.class);

    public final NumberPath<Double> monthlyfee = createNumber("monthlyfee", Double.class);

    public final StringPath msisdn = createString("msisdn");

    public final StringPath npwpvalue = createString("npwpvalue");

    public final NumberPath<Double> others = createNumber("others", Double.class);

    public final NumberPath<Double> othersvat = createNumber("othersvat", Double.class);

    public final NumberPath<Double> outstandingbilling = createNumber("outstandingbilling", Double.class);

    public final NumberPath<Double> paymentreceived = createNumber("paymentreceived", Double.class);

    public final NumberPath<Double> planet3charges = createNumber("planet3charges", Double.class);

    public final StringPath postcode = createString("postcode");

    public final NumberPath<Double> postdiscount = createNumber("postdiscount", Double.class);

    public final NumberPath<Double> prediscount = createNumber("prediscount", Double.class);

    public final NumberPath<Double> printingcost = createNumber("printingcost", Double.class);

    public final StringPath seqId = createString("seqId");

    public final NumberPath<Double> smscharges = createNumber("smscharges", Double.class);

    public final NumberPath<Double> stampduty = createNumber("stampduty", Double.class);

    public final DateTimePath<java.util.Date> startperiod = createDateTime("startperiod", java.util.Date.class);

    public final NumberPath<Double> subtotal = createNumber("subtotal", Double.class);

    public final StringPath summarycorpid = createString("summarycorpid");

    public final StringPath taxid = createString("taxid");

    public final NumberPath<Double> thismonthbill = createNumber("thismonthbill", Double.class);

    public final NumberPath<Double> totaladjustment = createNumber("totaladjustment", Double.class);

    public final NumberPath<Double> totalbilling = createNumber("totalbilling", Double.class);

    public final NumberPath<Double> totalcharge = createNumber("totalcharge", Double.class);

    public final NumberPath<Double> totaldiscount = createNumber("totaldiscount", Double.class);

    public final NumberPath<Double> totaldue = createNumber("totaldue", Double.class);

    public final NumberPath<Double> totalExcesspayment = createNumber("totalExcesspayment", Double.class);

    public final NumberPath<Double> totalOutstandingbilling = createNumber("totalOutstandingbilling", Double.class);

    public final NumberPath<Double> totalPaymentreceived = createNumber("totalPaymentreceived", Double.class);

    public final NumberPath<Double> totalstampduty = createNumber("totalstampduty", Double.class);

    public final NumberPath<Double> totalsubtotal = createNumber("totalsubtotal", Double.class);

    public final NumberPath<Double> totalusage = createNumber("totalusage", Double.class);

    public final NumberPath<Double> totalvat = createNumber("totalvat", Double.class);

    public final StringPath trippleDisc = createString("trippleDisc");

    public final StringPath trippleDiscNet = createString("trippleDiscNet");

    public final StringPath trippleDiscOthers = createString("trippleDiscOthers");

    public final NumberPath<Double> usagevariance = createNumber("usagevariance", Double.class);

    public final NumberPath<Double> vat = createNumber("vat", Double.class);

    public final NumberPath<Double> videocharges = createNumber("videocharges", Double.class);

    public QRptInvoiceSummary(String variable) {
        super(RptInvoiceSummary.class, forVariable(variable));
    }

    public QRptInvoiceSummary(Path<? extends RptInvoiceSummary> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRptInvoiceSummary(PathMetadata metadata) {
        super(RptInvoiceSummary.class, metadata);
    }

}

