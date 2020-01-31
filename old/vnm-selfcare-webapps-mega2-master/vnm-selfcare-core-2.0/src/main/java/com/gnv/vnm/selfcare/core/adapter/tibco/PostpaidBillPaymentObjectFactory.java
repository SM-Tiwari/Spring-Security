package com.gnv.vnm.selfcare.core.adapter.tibco;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import com.gnv.vnm.selfcare.core.adapter.tibco.postpaidpmt.PostpaidBillPaymentRequest;
import com.gnv.vnm.selfcare.core.adapter.tibco.postpaidpmt.PostpaidBillPaymentResponse;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.gnv.vnm.selfcare.core.adapter.tibco package. 
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
public class PostpaidBillPaymentObjectFactory {

    private final static QName _Status_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd16", "Status");
    private final static QName _StatusText_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd16", "Status_Text");
    private final static QName _CustomerNumber_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/postpaidPayment_Request.xsd16", "Customer_Number");
    private final static QName _LocalTxnDtTime_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/postpaidPayment_Request.xsd16", "LocalTxnDtTime");
    private final static QName _Source_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/postpaidPayment_Request.xsd16", "Source");
    private final static QName _TransactionId_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/postpaidPayment_Request.xsd16", "transactionId");
    private final static QName _AccountNumber_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/postpaidPayment_Request.xsd16", "accountNumber");
    private final static QName _AgencyAccountNumber_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/postpaidPayment_Request.xsd16", "agencyAccountNumber");
    private final static QName _PaymentAmount_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/postpaidPayment_Request.xsd16", "paymentAmount");
    private final static QName _DepositAmount_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/postpaidPayment_Request.xsd16", "depositAmount");
    private final static QName _PaymentTxt_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/postpaidPayment_Request.xsd16", "payment_Txt");
    private final static QName _PaymentReference_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/postpaidPayment_Request.xsd16", "paymentReference");
    private final static QName _PaymentType_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/postpaidPayment_Request.xsd16", "paymentType");
    private final static QName _PaymentLevel_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/postpaidPayment_Request.xsd16", "paymentLevel");
    private final static QName _InvoiceNumber_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/postpaidPayment_Request.xsd16", "invoiceNumber");
    private final static QName _PaymentDates_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/postpaidPayment_Request.xsd16", "paymentDates");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.gnv.vnm.selfcare.core.adapter.tibco
     * 
     */
    public PostpaidBillPaymentObjectFactory() {
    }

    /**
     * Create an instance of {@link PostPaidBilledQueryResponse }
     * 
     */
    public PostpaidBillPaymentResponse createResponse() {
        return new PostpaidBillPaymentResponse();
    }

    /**
     * Create an instance of {@link PostPaidBilledQueryRequest }
     * 
     */
    public PostpaidBillPaymentRequest createRequest() {
        return new PostpaidBillPaymentRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd16", name = "Status")
    public JAXBElement<String> createStatus(String value) {
        return new JAXBElement<String>(_Status_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd16", name = "Status_Text")
    public JAXBElement<String> createStatusText(String value) {
        return new JAXBElement<String>(_StatusText_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/postpaidPayment_Request.xsd16", name = "Customer_Number")
    public JAXBElement<String> createCustomerNumber(String value) {
        return new JAXBElement<String>(_CustomerNumber_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/postpaidPayment_Request.xsd16", name = "LocalTxnDtTime")
    public JAXBElement<String> createLocalTxnDtTime(String value) {
        return new JAXBElement<String>(_LocalTxnDtTime_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/postpaidPayment_Request.xsd16", name = "Source")
    public JAXBElement<String> createSource(String value) {
        return new JAXBElement<String>(_Source_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/postpaidPayment_Request.xsd16", name = "transactionId")
    public JAXBElement<String> createTransactionId(String value) {
        return new JAXBElement<String>(_TransactionId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/postpaidPayment_Request.xsd16", name = "accountNumber")
    public JAXBElement<String> createAccountNumber(String value) {
        return new JAXBElement<String>(_AccountNumber_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/postpaidPayment_Request.xsd16", name = "agencyAccountNumber")
    public JAXBElement<String> createAgencyAccountNumber(String value) {
        return new JAXBElement<String>(_AgencyAccountNumber_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/postpaidPayment_Request.xsd16", name = "paymentAmount")
    public JAXBElement<String> createPaymentAmount(String value) {
        return new JAXBElement<String>(_PaymentAmount_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/postpaidPayment_Request.xsd16", name = "depositAmount")
    public JAXBElement<String> createDepositAmount(String value) {
        return new JAXBElement<String>(_DepositAmount_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/postpaidPayment_Request.xsd16", name = "payment_Txt")
    public JAXBElement<String> createPaymentTxt(String value) {
        return new JAXBElement<String>(_PaymentTxt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/postpaidPayment_Request.xsd16", name = "paymentReference")
    public JAXBElement<String> createPaymentReference(String value) {
        return new JAXBElement<String>(_PaymentReference_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/postpaidPayment_Request.xsd16", name = "paymentType")
    public JAXBElement<String> createPaymentType(String value) {
        return new JAXBElement<String>(_PaymentType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/postpaidPayment_Request.xsd16", name = "paymentLevel")
    public JAXBElement<String> createPaymentLevel(String value) {
        return new JAXBElement<String>(_PaymentLevel_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/postpaidPayment_Request.xsd16", name = "invoiceNumber")
    public JAXBElement<String> createInvoiceNumber(String value) {
        return new JAXBElement<String>(_InvoiceNumber_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/postpaidPayment_Request.xsd16", name = "paymentDates")
    public JAXBElement<String> createPaymentDates(String value) {
        return new JAXBElement<String>(_PaymentDates_QNAME, String.class, null, value);
    }

}
