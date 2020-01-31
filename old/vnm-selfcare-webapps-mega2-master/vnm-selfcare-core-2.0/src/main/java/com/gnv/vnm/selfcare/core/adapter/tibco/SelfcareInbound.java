package com.gnv.vnm.selfcare.core.adapter.tibco;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import com.gnv.vnm.selfcare.core.adapter.tibco.balenq.PostpaidBalanceEnquiryRequest;
import com.gnv.vnm.selfcare.core.adapter.tibco.balenq.PostpaidBalanceEnquiryResponse;
import com.gnv.vnm.selfcare.core.adapter.tibco.etopup.EtopUpRequest;
import com.gnv.vnm.selfcare.core.adapter.tibco.etopup.EtopUpResponse;
import com.gnv.vnm.selfcare.core.adapter.tibco.hotbilling.HotBillingResponse;
import com.gnv.vnm.selfcare.core.adapter.tibco.hotbilling.HotBillingRequest;
import com.gnv.vnm.selfcare.core.adapter.tibco.postpaidpmt.PostpaidBillPaymentRequest;
import com.gnv.vnm.selfcare.core.adapter.tibco.postpaidpmt.PostpaidBillPaymentResponse;
import com.gnv.vnm.selfcare.core.adapter.tibco.postpaidqry.PostPaidBilledQueryRequest;
import com.gnv.vnm.selfcare.core.adapter.tibco.postpaidqry.PostPaidBilledQueryResponse;
import com.gnv.vnm.selfcare.core.adapter.tibco.subscriberqry.SubscriberQueryRequest;
import com.gnv.vnm.selfcare.core.adapter.tibco.subscriberqry.SubscriberQueryResponse;
import com.gnv.vnm.selfcare.core.adapter.tibco.topuphistory.VoucherHistory;

/**
 * This class was generated by Apache CXF 3.1.10
 * 2017-07-11T14:02:32.721+07:00
 * Generated source version: 3.1.10
 * 
 */
@WebService(targetNamespace = "http://xmlns.example.com/1491473061728", name = "SelfcareInbound")
@XmlSeeAlso({SubscriberQueryObjectFactory.class})
public interface SelfcareInbound {

    @WebMethod(operationName = "SubscriberQuery", action = "/Business_Process/Selfcare/SubscriberQuery")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebResult(name = "Response", targetNamespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", partName = "part1")
    public SubscriberQueryResponse subscriberQuery(
        @WebParam(partName = "part1", name = "Request", targetNamespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubscriberQuery.xsd")
        SubscriberQueryRequest part1
    );

    @WebMethod(operationName = "VoucherTopUp", action = "/Business_Process/Selfcare/VoucherTopUp")
    @RequestWrapper(localName = "VoucherTopUp", targetNamespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4", className = "com.gnv.vnm.selfcare.core.adapter.tibco.VoucherTopUp")
    @ResponseWrapper(localName = "VoucherTopUp", targetNamespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4", className = "com.gnv.vnm.selfcare.core.adapter.tibco.VoucherTopUp")
    public void voucherTopUp(
        @WebParam(mode = WebParam.Mode.INOUT, name = "TransactionID", targetNamespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4")
        javax.xml.ws.Holder<java.lang.String> transactionID,
        @WebParam(mode = WebParam.Mode.INOUT, name = "MessageType", targetNamespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4")
        javax.xml.ws.Holder<java.lang.String> messageType,
        @WebParam(mode = WebParam.Mode.INOUT, name = "ProcCode", targetNamespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4")
        javax.xml.ws.Holder<java.lang.String> procCode,
        @WebParam(mode = WebParam.Mode.INOUT, name = "STAN", targetNamespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4")
        javax.xml.ws.Holder<java.lang.String> stan,
        @WebParam(mode = WebParam.Mode.INOUT, name = "LocalTxnDtTime", targetNamespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4")
        javax.xml.ws.Holder<java.lang.String> localTxnDtTime,
        @WebParam(mode = WebParam.Mode.INOUT, name = "MobNum", targetNamespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4")
        javax.xml.ws.Holder<java.lang.String> mobNum,
        @WebParam(mode = WebParam.Mode.INOUT, name = "VoucherNum", targetNamespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4")
        javax.xml.ws.Holder<java.lang.String> voucherNum,
        @WebParam(mode = WebParam.Mode.INOUT, name = "DomainID", targetNamespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4")
        javax.xml.ws.Holder<java.lang.String> domainID,
        @WebParam(mode = WebParam.Mode.INOUT, name = "DeliveryChannelCtrlID", targetNamespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4")
        javax.xml.ws.Holder<java.lang.String> deliveryChannelCtrlID,
        @WebParam(mode = WebParam.Mode.INOUT, name = "ActCode", targetNamespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4")
        javax.xml.ws.Holder<java.lang.String> actCode,
        @WebParam(mode = WebParam.Mode.INOUT, name = "Curr", targetNamespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4")
        javax.xml.ws.Holder<java.lang.String> curr,
        @WebParam(mode = WebParam.Mode.INOUT, name = "VoucherBal", targetNamespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4")
        javax.xml.ws.Holder<java.lang.String> voucherBal,
        @WebParam(mode = WebParam.Mode.INOUT, name = "ValidityDate", targetNamespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4")
        javax.xml.ws.Holder<java.lang.String> validityDate,
        @WebParam(mode = WebParam.Mode.INOUT, name = "GraceDate", targetNamespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4")
        javax.xml.ws.Holder<java.lang.String> graceDate,
        @WebParam(mode = WebParam.Mode.INOUT, name = "GracePeriod", targetNamespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4")
        javax.xml.ws.Holder<java.lang.String> gracePeriod,
        @WebParam(mode = WebParam.Mode.INOUT, name = "AddonBalance", targetNamespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4")
        javax.xml.ws.Holder<java.lang.String> addonBalance,
        @WebParam(mode = WebParam.Mode.INOUT, name = "BonusBal", targetNamespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4")
        javax.xml.ws.Holder<java.lang.String> bonusBal,
        @WebParam(mode = WebParam.Mode.INOUT, name = "VoucherDenom", targetNamespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4")
        javax.xml.ws.Holder<java.lang.String> voucherDenom,
        @WebParam(mode = WebParam.Mode.INOUT, name = "MessageID", targetNamespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4")
        javax.xml.ws.Holder<java.util.List<java.lang.String>> messageID,
        @WebParam(mode = WebParam.Mode.INOUT, name = "LanguageID", targetNamespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4")
        javax.xml.ws.Holder<java.util.List<java.lang.String>> languageID,
        @WebParam(mode = WebParam.Mode.INOUT, name = "Priority", targetNamespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4")
        javax.xml.ws.Holder<java.util.List<java.lang.String>> priority,
        @WebParam(mode = WebParam.Mode.INOUT, name = "BusinessHourIndicator", targetNamespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4")
        javax.xml.ws.Holder<java.util.List<java.lang.String>> businessHourIndicator,
        @WebParam(mode = WebParam.Mode.INOUT, name = "VlrId", targetNamespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4")
        javax.xml.ws.Holder<java.lang.String> vlrId,
        @WebParam(mode = WebParam.Mode.INOUT, name = "CellId", targetNamespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4")
        javax.xml.ws.Holder<java.lang.String> cellId
    );

    @WebMethod(operationName = "Etopup_Selfcare", action = "/Business_Process/Selfcare/Etopup_Selfcare")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebResult(name = "EtopUp_Response", targetNamespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd13", partName = "part1")
    public EtopUpResponse etopupSelfcare(
        @WebParam(partName = "part1", name = "EtopUp_Request", targetNamespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12")
        EtopUpRequest part1
    );

    @WebMethod(operationName = "TopupHistory", action = "/Business_Process/Selfcare/TopupHistory")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebResult(name = "VoucherHistory", targetNamespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd3", partName = "TopUpHistoryResponse")
    public VoucherHistory topupHistory(
        @WebParam(partName = "TopUpHistoryRequest", name = "VoucherHistory", targetNamespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd3")
        VoucherHistory topUpHistoryRequest
    );
    
    @WebMethod(operationName = "PostpaidBillPayment", action = "/Business_Process/Selfcare/Selfcare_Inbound.serviceagent//PostpaidBillPayment")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebResult(name = "Response", targetNamespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd16", partName = "part1")
    public PostpaidBillPaymentResponse postpaidBillPayment(
        @WebParam(partName = "part1", name = "Request", targetNamespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/postpaidPayment_Request.xsd16")
        PostpaidBillPaymentRequest part1
    );
    
    @WebMethod(operationName = "PostpaidBalanceEnquiry", action = "/Business_Process/Selfcare/Selfcare_Inbound.serviceagent//PostpaidBalanceEnquiry")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebResult(name = "Response", targetNamespace = "http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2", partName = "part1")
    public PostpaidBalanceEnquiryResponse postpaidBalanceEnquiry(
        @WebParam(partName = "part1", name = "Request", targetNamespace = "http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd")
        PostpaidBalanceEnquiryRequest part1
    );
    
    @WebMethod(operationName = "PostPaidBilledQuery", action = "/Business_Process/Selfcare/PostPaidBilledQuery")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebResult(name = "Response", targetNamespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd26", partName = "part1")
    public PostPaidBilledQueryResponse postPaidBilledQuery(
        @WebParam(partName = "Request", name = "Request", targetNamespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd25")
        PostPaidBilledQueryRequest request
    );
    
    @WebMethod(operationName = "HotBilling", action = "/Business_Process/Selfcare/HotBilling")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebResult(name = "Response", targetNamespace = "http://www.tibco.com/schemas/28_NOV_SIT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd", partName = "part1")
    public HotBillingResponse hotBilling(
        @WebParam(partName = "part1", name = "Request", targetNamespace = "http://www.tibco.com/schemas/28_NOV_SIT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd")
        HotBillingRequest part1
    );
}
