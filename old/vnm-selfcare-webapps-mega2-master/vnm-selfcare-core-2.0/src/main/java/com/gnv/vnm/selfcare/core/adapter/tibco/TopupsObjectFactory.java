
package com.gnv.vnm.selfcare.core.adapter.tibco;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import com.gnv.vnm.selfcare.core.adapter.tibco.etopup.EtopUpRequest;
import com.gnv.vnm.selfcare.core.adapter.tibco.etopup.EtopUpResponse;
import com.gnv.vnm.selfcare.core.adapter.tibco.topuphistory.VoucherHistory;
import com.gnv.vnm.selfcare.core.adapter.tibco.vouchertopup.VoucherTopUp;


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
public class TopupsObjectFactory {

    private final static QName _ActCode_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd13", "ActCode");
    private final static QName _CurrentBal_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd13", "CurrentBal");
    private final static QName _MessageType13_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd13", "MessageType");
    private final static QName _ValidityDate_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd13", "ValidityDate");
    private final static QName _GraceDate_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd13", "GraceDate");
    private final static QName _AddonBalance_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12", "AddonBalance");
    private final static QName _BonusBal_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12", "BonusBal");
    private final static QName _Currency_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12", "Currency");
    private final static QName _DeliveryChannelCtrlID_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12", "DeliveryChannelCtrlID");
    private final static QName _MessageType12_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12", "MessageType");
    private final static QName _ProcCode_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12", "ProcCode");
    private final static QName _STAN_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12", "STAN");
    private final static QName _LocalTxnDtTime_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12", "LocalTxnDtTime");
    private final static QName _MobNum_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12", "MobNum");
    private final static QName _ValidityDays_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12", "ValidityDays");
    private final static QName _GracePeriod_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12", "GracePeriod");
    private final static QName _OriginalAmount_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12", "OriginalAmount");
    private final static QName _TopUpAmount_QNAME = new QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12", "TopUpAmount");

    /**
     * Create an instance of {@link VoucherTopUp }
     * 
     */
    public VoucherTopUp createVoucherTopUp() {
        return new VoucherTopUp();
    }

    /**
     * Create an instance of {@link EtopUpResponse }
     * 
     */
    public EtopUpResponse createEtopUpResponse() {
        return new EtopUpResponse();
    }

    /**
     * Create an instance of {@link EtopUpRequest }
     * 
     */
    public EtopUpRequest createEtopUpRequest() {
        return new EtopUpRequest();
    }

    /**
     * Create an instance of {@link VoucherHistory.VoucherList.VoucherItems }
     * 
     */
    public VoucherHistory.VoucherList.VoucherItems createVoucherHistoryVoucherListVoucherItems() {
        return new VoucherHistory.VoucherList.VoucherItems();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd13", name = "ActCode")
    public JAXBElement<String> createActCode(String value) {
        return new JAXBElement<String>(_ActCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd13", name = "CurrentBal")
    public JAXBElement<String> createCurrentBal(String value) {
        return new JAXBElement<String>(_CurrentBal_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd13", name = "MessageType")
    public JAXBElement<String> createMessageType1(String value) {
        return new JAXBElement<String>(_MessageType13_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd13", name = "ValidityDate")
    public JAXBElement<String> createValidityDate(String value) {
        return new JAXBElement<String>(_ValidityDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd13", name = "GraceDate")
    public JAXBElement<String> createGraceDate(String value) {
        return new JAXBElement<String>(_GraceDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12", name = "AddonBalance")
    public JAXBElement<String> createAddonBalance(String value) {
        return new JAXBElement<String>(_AddonBalance_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12", name = "BonusBal")
    public JAXBElement<String> createBonusBal(String value) {
        return new JAXBElement<String>(_BonusBal_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12", name = "Currency")
    public JAXBElement<String> createCurrency(String value) {
        return new JAXBElement<String>(_Currency_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12", name = "DeliveryChannelCtrlID")
    public JAXBElement<String> createDeliveryChannelCtrlID(String value) {
        return new JAXBElement<String>(_DeliveryChannelCtrlID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12", name = "MessageType")
    public JAXBElement<String> createMessageType(String value) {
        return new JAXBElement<String>(_MessageType12_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12", name = "ProcCode")
    public JAXBElement<String> createProcCode(String value) {
        return new JAXBElement<String>(_ProcCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12", name = "STAN")
    public JAXBElement<String> createSTAN(String value) {
        return new JAXBElement<String>(_STAN_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12", name = "LocalTxnDtTime")
    public JAXBElement<String> createLocalTxnDtTime(String value) {
        return new JAXBElement<String>(_LocalTxnDtTime_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12", name = "MobNum")
    public JAXBElement<String> createMobNum(String value) {
        return new JAXBElement<String>(_MobNum_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12", name = "ValidityDays")
    public JAXBElement<String> createValidityDays(String value) {
        return new JAXBElement<String>(_ValidityDays_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12", name = "GracePeriod")
    public JAXBElement<String> createGracePeriod(String value) {
        return new JAXBElement<String>(_GracePeriod_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12", name = "OriginalAmount")
    public JAXBElement<String> createOriginalAmount(String value) {
        return new JAXBElement<String>(_OriginalAmount_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12", name = "TopUpAmount")
    public JAXBElement<String> createTopUpAmount(String value) {
        return new JAXBElement<String>(_TopUpAmount_QNAME, String.class, null, value);
    }

}
