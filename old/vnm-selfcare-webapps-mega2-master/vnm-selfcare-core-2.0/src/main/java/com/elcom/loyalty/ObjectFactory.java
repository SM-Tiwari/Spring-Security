
package com.elcom.loyalty;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.elcom.loyalty package. 
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
public class ObjectFactory {

    private final static QName _LoyaltyRespErrorCode_QNAME = new QName("http://loyalty.elcom.com", "errorCode");
    private final static QName _LoyaltyRespErrorDetail_QNAME = new QName("http://loyalty.elcom.com", "errorDetail");
    private final static QName _LoyaltyRespIsdn_QNAME = new QName("http://loyalty.elcom.com", "isdn");
    private final static QName _LoyaltyRedeempointReqDescription_QNAME = new QName("http://loyalty.elcom.com", "description");
    private final static QName _LoyaltyRedeempointReqKeyword_QNAME = new QName("http://loyalty.elcom.com", "keyword");
    private final static QName _LoyaltyRedeempointReqPassword_QNAME = new QName("http://loyalty.elcom.com", "password");
    private final static QName _LoyaltyRedeempointReqUser_QNAME = new QName("http://loyalty.elcom.com", "user");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.elcom.loyalty
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LoyaltyReq }
     * 
     */
    public LoyaltyReq createLoyaltyReq() {
        return new LoyaltyReq();
    }

    /**
     * Create an instance of {@link LoyaltyCheckpointResp }
     * 
     */
    public LoyaltyCheckpointResp createLoyaltyCheckpointResp() {
        return new LoyaltyCheckpointResp();
    }

    /**
     * Create an instance of {@link LoyaltyRedeempointReq }
     * 
     */
    public LoyaltyRedeempointReq createLoyaltyRedeempointReq() {
        return new LoyaltyRedeempointReq();
    }

    /**
     * Create an instance of {@link LoyaltyResp }
     * 
     */
    public LoyaltyResp createLoyaltyResp() {
        return new LoyaltyResp();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://loyalty.elcom.com", name = "errorCode", scope = LoyaltyResp.class)
    public JAXBElement<String> createLoyaltyRespErrorCode(String value) {
        return new JAXBElement<String>(_LoyaltyRespErrorCode_QNAME, String.class, LoyaltyResp.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://loyalty.elcom.com", name = "errorDetail", scope = LoyaltyResp.class)
    public JAXBElement<String> createLoyaltyRespErrorDetail(String value) {
        return new JAXBElement<String>(_LoyaltyRespErrorDetail_QNAME, String.class, LoyaltyResp.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://loyalty.elcom.com", name = "isdn", scope = LoyaltyResp.class)
    public JAXBElement<String> createLoyaltyRespIsdn(String value) {
        return new JAXBElement<String>(_LoyaltyRespIsdn_QNAME, String.class, LoyaltyResp.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://loyalty.elcom.com", name = "description", scope = LoyaltyRedeempointReq.class)
    public JAXBElement<String> createLoyaltyRedeempointReqDescription(String value) {
        return new JAXBElement<String>(_LoyaltyRedeempointReqDescription_QNAME, String.class, LoyaltyRedeempointReq.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://loyalty.elcom.com", name = "isdn", scope = LoyaltyRedeempointReq.class)
    public JAXBElement<String> createLoyaltyRedeempointReqIsdn(String value) {
        return new JAXBElement<String>(_LoyaltyRespIsdn_QNAME, String.class, LoyaltyRedeempointReq.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://loyalty.elcom.com", name = "keyword", scope = LoyaltyRedeempointReq.class)
    public JAXBElement<String> createLoyaltyRedeempointReqKeyword(String value) {
        return new JAXBElement<String>(_LoyaltyRedeempointReqKeyword_QNAME, String.class, LoyaltyRedeempointReq.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://loyalty.elcom.com", name = "password", scope = LoyaltyRedeempointReq.class)
    public JAXBElement<String> createLoyaltyRedeempointReqPassword(String value) {
        return new JAXBElement<String>(_LoyaltyRedeempointReqPassword_QNAME, String.class, LoyaltyRedeempointReq.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://loyalty.elcom.com", name = "user", scope = LoyaltyRedeempointReq.class)
    public JAXBElement<String> createLoyaltyRedeempointReqUser(String value) {
        return new JAXBElement<String>(_LoyaltyRedeempointReqUser_QNAME, String.class, LoyaltyRedeempointReq.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://loyalty.elcom.com", name = "errorCode", scope = LoyaltyCheckpointResp.class)
    public JAXBElement<String> createLoyaltyCheckpointRespErrorCode(String value) {
        return new JAXBElement<String>(_LoyaltyRespErrorCode_QNAME, String.class, LoyaltyCheckpointResp.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://loyalty.elcom.com", name = "errorDetail", scope = LoyaltyCheckpointResp.class)
    public JAXBElement<String> createLoyaltyCheckpointRespErrorDetail(String value) {
        return new JAXBElement<String>(_LoyaltyRespErrorDetail_QNAME, String.class, LoyaltyCheckpointResp.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://loyalty.elcom.com", name = "isdn", scope = LoyaltyCheckpointResp.class)
    public JAXBElement<String> createLoyaltyCheckpointRespIsdn(String value) {
        return new JAXBElement<String>(_LoyaltyRespIsdn_QNAME, String.class, LoyaltyCheckpointResp.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://loyalty.elcom.com", name = "isdn", scope = LoyaltyReq.class)
    public JAXBElement<String> createLoyaltyReqIsdn(String value) {
        return new JAXBElement<String>(_LoyaltyRespIsdn_QNAME, String.class, LoyaltyReq.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://loyalty.elcom.com", name = "password", scope = LoyaltyReq.class)
    public JAXBElement<String> createLoyaltyReqPassword(String value) {
        return new JAXBElement<String>(_LoyaltyRedeempointReqPassword_QNAME, String.class, LoyaltyReq.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://loyalty.elcom.com", name = "user", scope = LoyaltyReq.class)
    public JAXBElement<String> createLoyaltyReqUser(String value) {
        return new JAXBElement<String>(_LoyaltyRedeempointReqUser_QNAME, String.class, LoyaltyReq.class, value);
    }

}
