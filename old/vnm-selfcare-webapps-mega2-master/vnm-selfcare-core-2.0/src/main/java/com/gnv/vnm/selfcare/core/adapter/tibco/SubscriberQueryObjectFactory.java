
package com.gnv.vnm.selfcare.core.adapter.tibco;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import com.gnv.vnm.selfcare.core.adapter.tibco.subscriberqry.MsgParam;
import com.gnv.vnm.selfcare.core.adapter.tibco.subscriberqry.SubscriberQueryRequest;
import com.gnv.vnm.selfcare.core.adapter.tibco.subscriberqry.SubscriberQueryResponse;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.gnv.vnm.selfcare.core.adapter.tibco.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class SubscriberQueryObjectFactory {

    private final static QName _MSISDN_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubscriberQuery.xsd", "MSISDN");
    private final static QName _ACCOUNTNUMBER_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", "ACCOUNT_NUMBER");
    private final static QName _ACCOUNTSTATUS_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", "ACCOUNT_STATUS");
    private final static QName _ACTIVATIONDATE_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", "ACTIVATION_DATE");
    private final static QName _CALLPLAN_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", "CALL_PLAN");
    private final static QName _CUSTOMERSTATUS_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", "CUSTOMER_STATUS");
    private final static QName _DATABALANCE_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", "DATA_BALANCE");
    private final static QName _DATANIGHTBALANCE_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", "DATA_NIGHT_BALANCE");
    private final static QName _EBILLMAILID_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", "EBILL_MAIL_ID");
    private final static QName _FORFEITEDDATE_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", "FORFEITED_DATE");
    private final static QName _IMSI_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", "IMSI");
    private final static QName _LASTCALLAMOUNT_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", "LAST_CALL_AMOUNT");
    private final static QName _LIFECYCLESTATUS_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", "LIFECYCLE_STATUS");
    private final static QName _MAINACCOUNTBALANCE_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", "MAIN_ACCOUNT_BALANCE");
    private final static QName _NOTIFICATIONID_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", "NOTIFICATION_ID");
    private final static QName _OFFERNAME_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", "OFFER_NAME");
    private final static QName _OFFNETBAL_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", "OFFNET_BAL");
    private final static QName _ONNETBAL_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", "ONNET_BAL");
    private final static QName _OUTPUT1_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", "OUTPUT_1");
    private final static QName _OUTPUT2_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", "OUTPUT_2");
    private final static QName _OUTPUT3_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", "OUTPUT_3");
    private final static QName _OUTPUT4_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", "OUTPUT_4");
    private final static QName _PAYMENTTYPE_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", "PAYMENT_TYPE");
    private final static QName _PROMOTIONCODE_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", "PROMOTION_CODE");
    private final static QName _REGISTRATIONDATE_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", "REGISTRATION_DATE");
    private final static QName _RESTRICTEDDATE_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", "RESTRICTED_DATE");
    private final static QName _TERMINATEDDATE_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", "TERMINATED_DATE");
    private final static QName _SOURCEID_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", "SOURCE_ID");
    private final static QName _SUBSCRIPTIONNUMBER_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", "SUBSCRIPTION_NUMBER");
    private final static QName _SIM_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", "SIM");
    private final static QName _StatusCode_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", "Status_Code");
    private final static QName _StatusText_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", "Status_Text");
    private final static QName _STATUS_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", "STATUS");
    private final static QName _STATUSTEXT_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", "STATUS_TEXT");
    
    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.gnv.vnm.selfcare.core.adapter.tibco.ws
     * 
     */
    public SubscriberQueryObjectFactory() {
    }

    /**
     * Create an instance of {@link MsgParam }
     * 
     */
    public MsgParam createMsgParam() {
        return new MsgParam();
    }

    /**
     * Create an instance of {@link MsgParam.Attribute }
     * 
     */
    public MsgParam.Attribute createMsgParamAttribute() {
        return new MsgParam.Attribute();
    }

    /**
     * Create an instance of {@link SubscriberQueryRequest }
     * 
     */
    public SubscriberQueryRequest createSubscriberQueryRequest() {
        return new SubscriberQueryRequest();
    }

    /**
     * Create an instance of {@link SubscriberQueryResponse }
     * 
     */
    public SubscriberQueryResponse createSubscriberQueryResponse() {
        return new SubscriberQueryResponse();
    }

    /**
     * Create an instance of {@link MsgParam.Attribute.AttribDtl }
     * 
     */
    public MsgParam.Attribute.AttribDtl createMsgParamAttributeAttribDtl() {
        return new MsgParam.Attribute.AttribDtl();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubscriberQuery.xsd", name = "MSISDN")
    public JAXBElement<String> createMSISDN(String value) {
        return new JAXBElement<String>(_MSISDN_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", name = "ACCOUNT_NUMBER")
    public JAXBElement<String> createACCOUNTNUMBER(String value) {
        return new JAXBElement<String>(_ACCOUNTNUMBER_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", name = "ACCOUNT_STATUS")
    public JAXBElement<String> createACCOUNTSTATUS(String value) {
        return new JAXBElement<String>(_ACCOUNTSTATUS_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", name = "ACTIVATION_DATE")
    public JAXBElement<String> createACTIVATIONDATE(String value) {
        return new JAXBElement<String>(_ACTIVATIONDATE_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", name = "CALL_PLAN")
    public JAXBElement<String> createCALLPLAN(String value) {
        return new JAXBElement<String>(_CALLPLAN_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", name = "CUSTOMER_STATUS")
    public JAXBElement<String> createCUSTOMERSTATUS(String value) {
        return new JAXBElement<String>(_CUSTOMERSTATUS_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", name = "DATA_BALANCE")
    public JAXBElement<String> createDATABALANCE(String value) {
        return new JAXBElement<String>(_DATABALANCE_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", name = "DATA_NIGHT_BALANCE")
    public JAXBElement<String> createDATANIGHTBALANCE(String value) {
        return new JAXBElement<String>(_DATANIGHTBALANCE_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", name = "EBILL_MAIL_ID")
    public JAXBElement<String> createEBILLMAILID(String value) {
        return new JAXBElement<String>(_EBILLMAILID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", name = "FORFEITED_DATE")
    public JAXBElement<String> createFORFEITEDDATE(String value) {
        return new JAXBElement<String>(_FORFEITEDDATE_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", name = "IMSI")
    public JAXBElement<String> createIMSI(String value) {
        return new JAXBElement<String>(_IMSI_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", name = "LAST_CALL_AMOUNT")
    public JAXBElement<String> createLASTCALLAMOUNT(String value) {
        return new JAXBElement<String>(_LASTCALLAMOUNT_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", name = "LIFECYCLE_STATUS")
    public JAXBElement<String> createLIFECYCLESTATUS(String value) {
        return new JAXBElement<String>(_LIFECYCLESTATUS_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", name = "MAIN_ACCOUNT_BALANCE")
    public JAXBElement<String> createMAINACCOUNTBALANCE(String value) {
        return new JAXBElement<String>(_MAINACCOUNTBALANCE_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", name = "NOTIFICATION_ID")
    public JAXBElement<String> createNOTIFICATIONID(String value) {
        return new JAXBElement<String>(_NOTIFICATIONID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", name = "OFFER_NAME")
    public JAXBElement<String> createOFFERNAME(String value) {
        return new JAXBElement<String>(_OFFERNAME_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", name = "OFFNET_BAL")
    public JAXBElement<String> createOFFNETBAL(String value) {
        return new JAXBElement<String>(_OFFNETBAL_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", name = "ONNET_BAL")
    public JAXBElement<String> createONNETBAL(String value) {
        return new JAXBElement<String>(_ONNETBAL_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", name = "OUTPUT_1")
    public JAXBElement<String> createOUTPUT1(String value) {
        return new JAXBElement<String>(_OUTPUT1_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", name = "OUTPUT_2")
    public JAXBElement<String> createOUTPUT2(String value) {
        return new JAXBElement<String>(_OUTPUT2_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", name = "OUTPUT_3")
    public JAXBElement<String> createOUTPUT3(String value) {
        return new JAXBElement<String>(_OUTPUT3_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", name = "OUTPUT_4")
    public JAXBElement<String> createOUTPUT4(String value) {
        return new JAXBElement<String>(_OUTPUT4_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", name = "PAYMENT_TYPE")
    public JAXBElement<String> createPAYMENTTYPE(String value) {
        return new JAXBElement<String>(_PAYMENTTYPE_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", name = "PROMOTION_CODE")
    public JAXBElement<String> createPROMOTIONCODE(String value) {
        return new JAXBElement<String>(_PROMOTIONCODE_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", name = "REGISTRATION_DATE")
    public JAXBElement<String> createREGISTRATIONDATE(String value) {
        return new JAXBElement<String>(_REGISTRATIONDATE_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", name = "RESTRICTED_DATE")
    public JAXBElement<String> createRESTRICTEDDATE(String value) {
        return new JAXBElement<String>(_RESTRICTEDDATE_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", name = "TERMINATED_DATE")
    public JAXBElement<String> createTERMINATEDDATE(String value) {
        return new JAXBElement<String>(_TERMINATEDDATE_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", name = "SOURCE_ID")
    public JAXBElement<String> createSOURCEID(String value) {
        return new JAXBElement<String>(_SOURCEID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", name = "SUBSCRIPTION_NUMBER")
    public JAXBElement<String> createSUBSCRIPTIONNUMBER(String value) {
        return new JAXBElement<String>(_SUBSCRIPTIONNUMBER_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", name = "SIM")
    public JAXBElement<String> createSIM(String value) {
        return new JAXBElement<String>(_SIM_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", name = "Status_Code")
    public JAXBElement<String> createStatusCode(String value) {
        return new JAXBElement<String>(_StatusCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", name = "Status_Text")
    public JAXBElement<String> createStatusText(String value) {
        return new JAXBElement<String>(_StatusText_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", name = "STATUS")
    public JAXBElement<String> createSTATUS(String value) {
        return new JAXBElement<String>(_STATUS_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd", name = "STATUS_TEXT")
    public JAXBElement<String> createSTATUSTEXT(String value) {
        return new JAXBElement<String>(_STATUSTEXT_QNAME, String.class, null, value);
    }

}
