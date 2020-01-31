
package com.gnv.vnm.selfcare.core.adapter.tibco;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import com.gnv.vnm.selfcare.core.adapter.tibco.postpaidqry.BillHistory;
import com.gnv.vnm.selfcare.core.adapter.tibco.postpaidqry.PostPaidBilledQueryRequest;
import com.gnv.vnm.selfcare.core.adapter.tibco.postpaidqry.PostPaidBilledQueryResponse;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.gnv.vnm.selfcare.core.adapter.tibco.postpaidqry package. 
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
public class PostpaidQueryObjectFactory {

    private final static QName _Amount_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd26", "Amount");
    private final static QName _AmountPaid_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd26", "Amount_Paid");
    private final static QName _BalanceBroughtForward_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd26", "Balance_Brought_Forward");
    private final static QName _BalanceDue_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd26", "Balance_Due");
    private final static QName _BillDate_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd26", "Bill_Date");
    private final static QName _BillDueDate_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd26", "Bill_Due_Date");
    private final static QName _BillStatus_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd26", "Bill_Status");
    private final static QName _PaymentStatus_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd26", "Payment_Status");
    private final static QName _BillType_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd26", "Bill_Type");
    private final static QName _InvoiceImagePath_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd26", "Invoice_Image_Path");
    private final static QName _InvoiceNumber_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd26", "Invoice_Number");
    private final static QName _Status_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd26", "Status");
    private final static QName _StatusText_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd26", "Status_Text");
    private final static QName _AccountNumber_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd25", "AccountNumber");
    private final static QName _LocalTxnDtTime_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd25", "LocalTxnDtTime");
    private final static QName _MSISDN_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd25", "MSISDN");
    private final static QName _TransactionId_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd25", "TransactionId");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.gnv.vnm.selfcare.core.adapter.tibco.postpaidqry
     * 
     */
    public PostpaidQueryObjectFactory() {
    }

    /**
     * Create an instance of {@link BillHistory }
     * 
     */
    public BillHistory createBillHistory() {
        return new BillHistory();
    }

    /**
     * Create an instance of {@link PostPaidBilledQueryResponse }
     * 
     */
    public PostPaidBilledQueryResponse createResponse() {
        return new PostPaidBilledQueryResponse();
    }

    /**
     * Create an instance of {@link PostPaidBilledQueryRequest }
     * 
     */
    public PostPaidBilledQueryRequest createRequest() {
        return new PostPaidBilledQueryRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd26", name = "Amount")
    public JAXBElement<String> createAmount(String value) {
        return new JAXBElement<String>(_Amount_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd26", name = "Amount_Paid")
    public JAXBElement<String> createAmountPaid(String value) {
        return new JAXBElement<String>(_AmountPaid_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd26", name = "Balance_Brought_Forward")
    public JAXBElement<String> createBalanceBroughtForward(String value) {
        return new JAXBElement<String>(_BalanceBroughtForward_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd26", name = "Balance_Due")
    public JAXBElement<String> createBalanceDue(String value) {
        return new JAXBElement<String>(_BalanceDue_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd26", name = "Bill_Date")
    public JAXBElement<String> createBillDate(String value) {
        return new JAXBElement<String>(_BillDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd26", name = "Bill_Due_Date")
    public JAXBElement<String> createBillDueDate(String value) {
        return new JAXBElement<String>(_BillDueDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd26", name = "Bill_Status")
    public JAXBElement<String> createBillStatus(String value) {
        return new JAXBElement<String>(_BillStatus_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd26", name = "Payment_Status")
    public JAXBElement<String> createPaymentStatus(String value) {
        return new JAXBElement<String>(_PaymentStatus_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd26", name = "Bill_Type")
    public JAXBElement<String> createBillType(String value) {
        return new JAXBElement<String>(_BillType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd26", name = "Invoice_Image_Path")
    public JAXBElement<String> createInvoiceImagePath(String value) {
        return new JAXBElement<String>(_InvoiceImagePath_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd26", name = "Invoice_Number")
    public JAXBElement<String> createInvoiceNumber(String value) {
        return new JAXBElement<String>(_InvoiceNumber_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd26", name = "Status")
    public JAXBElement<String> createStatus(String value) {
        return new JAXBElement<String>(_Status_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd26", name = "Status_Text")
    public JAXBElement<String> createStatusText(String value) {
        return new JAXBElement<String>(_StatusText_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd25", name = "AccountNumber")
    public JAXBElement<String> createAccountNumber(String value) {
        return new JAXBElement<String>(_AccountNumber_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd25", name = "LocalTxnDtTime")
    public JAXBElement<String> createLocalTxnDtTime(String value) {
        return new JAXBElement<String>(_LocalTxnDtTime_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd25", name = "MSISDN")
    public JAXBElement<String> createMSISDN(String value) {
        return new JAXBElement<String>(_MSISDN_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd25", name = "TransactionId")
    public JAXBElement<String> createTransactionId(String value) {
        return new JAXBElement<String>(_TransactionId_QNAME, String.class, null, value);
    }

}
