
package com.gnv.vnm.selfcare.core.adapter.tibco;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import com.gnv.vnm.selfcare.core.adapter.tibco.balenq.PostpaidBalanceEnquiryRequest;
import com.gnv.vnm.selfcare.core.adapter.tibco.balenq.PostpaidBalanceEnquiryResponse;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.gnv.vnm.selfcare.core.adapter.tibco.balenq package. 
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
public class PostpaidBalanceEnquiryObjectFactory {

    private final static QName _AccountNumber_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd", "AccountNumber");
    private final static QName _LocalTxnDtTime_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd", "LocalTxnDtTime");
    private final static QName _MSISDN_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd", "MSISDN");
    private final static QName _TransactionId_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd", "TransactionId");
    private final static QName _BillingSubscriptionStatus_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2", "BillingSubscriptionStatus");
    private final static QName _BusinessHourIndicator_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2", "BusinessHourIndicator");
    private final static QName _DepositedAmount_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2", "DepositedAmount");
    private final static QName _DueDate_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2", "DueDate");
    private final static QName _LanguageId_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2", "LanguageId");
    private final static QName _MainBalance_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2", "MainBalance");
    private final static QName _MessageId_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2", "MessageId");
    private final static QName _NotificationCreditLimit_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2", "NotificationCreditLimit");
    private final static QName _OffNetBal_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2", "OffNetBal");
    private final static QName _OnNetBal_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2", "OnNetBal");
    private final static QName _Priority_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2", "Priority");
    private final static QName _TotalBal_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2", "TotalBal");
    private final static QName _TotalUnbilledUsage_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2", "TotalUnbilledUsage");
    private final static QName _TotalOutstandingBalance_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2", "TotalOutstandingBalance");
    private final static QName _TotalUnpaid_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2", "TotalUnpaid");
    private final static QName _Status_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2", "Status");
    private final static QName _StatusText_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2", "StatusText");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.gnv.vnm.selfcare.core.adapter.tibco.balenq
     * 
     */
    public PostpaidBalanceEnquiryObjectFactory() {
    }

    /**
     * Create an instance of {@link PostpaidBalanceEnquiryRequest }
     * 
     */
    public PostpaidBalanceEnquiryRequest createRequest() {
        return new PostpaidBalanceEnquiryRequest();
    }

    /**
     * Create an instance of {@link PostpaidBalanceEnquiryResponse }
     * 
     */
    public PostpaidBalanceEnquiryResponse createResponse() {
        return new PostpaidBalanceEnquiryResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd", name = "AccountNumber")
    public JAXBElement<String> createAccountNumber(String value) {
        return new JAXBElement<String>(_AccountNumber_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd", name = "LocalTxnDtTime")
    public JAXBElement<String> createLocalTxnDtTime(String value) {
        return new JAXBElement<String>(_LocalTxnDtTime_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd", name = "MSISDN")
    public JAXBElement<String> createMSISDN(String value) {
        return new JAXBElement<String>(_MSISDN_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd", name = "TransactionId")
    public JAXBElement<String> createTransactionId(String value) {
        return new JAXBElement<String>(_TransactionId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2", name = "BillingSubscriptionStatus")
    public JAXBElement<String> createBillingSubscriptionStatus(String value) {
        return new JAXBElement<String>(_BillingSubscriptionStatus_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2", name = "BusinessHourIndicator")
    public JAXBElement<String> createBusinessHourIndicator(String value) {
        return new JAXBElement<String>(_BusinessHourIndicator_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2", name = "DepositedAmount")
    public JAXBElement<String> createDepositedAmount(String value) {
        return new JAXBElement<String>(_DepositedAmount_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2", name = "DueDate")
    public JAXBElement<String> createDueDate(String value) {
        return new JAXBElement<String>(_DueDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2", name = "LanguageId")
    public JAXBElement<String> createLanguageId(String value) {
        return new JAXBElement<String>(_LanguageId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2", name = "MainBalance")
    public JAXBElement<String> createMainBalance(String value) {
        return new JAXBElement<String>(_MainBalance_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2", name = "MessageId")
    public JAXBElement<String> createMessageId(String value) {
        return new JAXBElement<String>(_MessageId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2", name = "NotificationCreditLimit")
    public JAXBElement<String> createNotificationCreditLimit(String value) {
        return new JAXBElement<String>(_NotificationCreditLimit_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2", name = "OffNetBal")
    public JAXBElement<String> createOffNetBal(String value) {
        return new JAXBElement<String>(_OffNetBal_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2", name = "OnNetBal")
    public JAXBElement<String> createOnNetBal(String value) {
        return new JAXBElement<String>(_OnNetBal_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2", name = "Priority")
    public JAXBElement<String> createPriority(String value) {
        return new JAXBElement<String>(_Priority_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2", name = "TotalBal")
    public JAXBElement<String> createTotalBal(String value) {
        return new JAXBElement<String>(_TotalBal_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2", name = "TotalUnbilledUsage")
    public JAXBElement<String> createTotalUnbilledUsage(String value) {
        return new JAXBElement<String>(_TotalUnbilledUsage_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2", name = "TotalOutstandingBalance")
    public JAXBElement<String> createTotalOutstandingBalance(String value) {
        return new JAXBElement<String>(_TotalOutstandingBalance_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2", name = "TotalUnpaid")
    public JAXBElement<String> createTotalUnpaid(String value) {
        return new JAXBElement<String>(_TotalUnpaid_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2", name = "Status")
    public JAXBElement<String> createStatus(String value) {
        return new JAXBElement<String>(_Status_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2", name = "StatusText")
    public JAXBElement<String> createStatusText(String value) {
        return new JAXBElement<String>(_StatusText_QNAME, String.class, null, value);
    }

}
