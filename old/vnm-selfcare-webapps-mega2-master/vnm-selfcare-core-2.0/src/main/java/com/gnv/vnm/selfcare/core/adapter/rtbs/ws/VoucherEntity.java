
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for VoucherEntity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VoucherEntity"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CardId" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="BatchNumber" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="SerialNumber" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="CodeNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="State" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ExpirationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="SubscriberId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="UseDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="Distributor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OrderNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="VoucherKey" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="ServiceProvider" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CurrencyUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FaceValue" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="ExpirationOffset" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="AcctExpirationOffset" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="ChangeCosF" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="ChangeCos" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="ChangePhonebook" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="ShipDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="UcardSp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="UcardCos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VoucherEntity", propOrder = {
    "cardId",
    "batchNumber",
    "serialNumber",
    "codeNumber",
    "state",
    "expirationDate",
    "subscriberId",
    "useDate",
    "distributor",
    "orderNumber",
    "voucherKey",
    "serviceProvider",
    "currencyUnit",
    "faceValue",
    "expirationOffset",
    "acctExpirationOffset",
    "changeCosF",
    "changeCos",
    "changePhonebook",
    "shipDate",
    "ucardSp",
    "ucardCos"
})
public class VoucherEntity {

    @XmlElement(name = "CardId", required = true)
    protected BigDecimal cardId;
    @XmlElement(name = "BatchNumber", required = true)
    protected BigDecimal batchNumber;
    @XmlElement(name = "SerialNumber", required = true)
    protected BigDecimal serialNumber;
    @XmlElement(name = "CodeNumber")
    protected String codeNumber;
    @XmlElement(name = "State")
    protected String state;
    @XmlElement(name = "ExpirationDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expirationDate;
    @XmlElement(name = "SubscriberId")
    protected String subscriberId;
    @XmlElement(name = "UseDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar useDate;
    @XmlElement(name = "Distributor")
    protected String distributor;
    @XmlElement(name = "OrderNumber")
    protected String orderNumber;
    @XmlElement(name = "VoucherKey", required = true)
    protected BigDecimal voucherKey;
    @XmlElement(name = "ServiceProvider")
    protected String serviceProvider;
    @XmlElement(name = "CurrencyUnit")
    protected String currencyUnit;
    @XmlElement(name = "FaceValue", required = true)
    protected BigDecimal faceValue;
    @XmlElement(name = "ExpirationOffset", required = true)
    protected BigDecimal expirationOffset;
    @XmlElement(name = "AcctExpirationOffset", required = true)
    protected BigDecimal acctExpirationOffset;
    @XmlElement(name = "ChangeCosF", required = true)
    protected BigDecimal changeCosF;
    @XmlElement(name = "ChangeCos", required = true)
    protected BigDecimal changeCos;
    @XmlElement(name = "ChangePhonebook", required = true)
    protected BigDecimal changePhonebook;
    @XmlElement(name = "ShipDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar shipDate;
    @XmlElement(name = "UcardSp")
    protected String ucardSp;
    @XmlElement(name = "UcardCos")
    protected String ucardCos;

    /**
     * Gets the value of the cardId property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCardId() {
        return cardId;
    }

    /**
     * Sets the value of the cardId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCardId(BigDecimal value) {
        this.cardId = value;
    }

    /**
     * Gets the value of the batchNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBatchNumber() {
        return batchNumber;
    }

    /**
     * Sets the value of the batchNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBatchNumber(BigDecimal value) {
        this.batchNumber = value;
    }

    /**
     * Gets the value of the serialNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSerialNumber() {
        return serialNumber;
    }

    /**
     * Sets the value of the serialNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSerialNumber(BigDecimal value) {
        this.serialNumber = value;
    }

    /**
     * Gets the value of the codeNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeNumber() {
        return codeNumber;
    }

    /**
     * Sets the value of the codeNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeNumber(String value) {
        this.codeNumber = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setState(String value) {
        this.state = value;
    }

    /**
     * Gets the value of the expirationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpirationDate() {
        return expirationDate;
    }

    /**
     * Sets the value of the expirationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpirationDate(XMLGregorianCalendar value) {
        this.expirationDate = value;
    }

    /**
     * Gets the value of the subscriberId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscriberId() {
        return subscriberId;
    }

    /**
     * Sets the value of the subscriberId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubscriberId(String value) {
        this.subscriberId = value;
    }

    /**
     * Gets the value of the useDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUseDate() {
        return useDate;
    }

    /**
     * Sets the value of the useDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUseDate(XMLGregorianCalendar value) {
        this.useDate = value;
    }

    /**
     * Gets the value of the distributor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDistributor() {
        return distributor;
    }

    /**
     * Sets the value of the distributor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDistributor(String value) {
        this.distributor = value;
    }

    /**
     * Gets the value of the orderNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * Sets the value of the orderNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderNumber(String value) {
        this.orderNumber = value;
    }

    /**
     * Gets the value of the voucherKey property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVoucherKey() {
        return voucherKey;
    }

    /**
     * Sets the value of the voucherKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVoucherKey(BigDecimal value) {
        this.voucherKey = value;
    }

    /**
     * Gets the value of the serviceProvider property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceProvider() {
        return serviceProvider;
    }

    /**
     * Sets the value of the serviceProvider property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceProvider(String value) {
        this.serviceProvider = value;
    }

    /**
     * Gets the value of the currencyUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyUnit() {
        return currencyUnit;
    }

    /**
     * Sets the value of the currencyUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyUnit(String value) {
        this.currencyUnit = value;
    }

    /**
     * Gets the value of the faceValue property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFaceValue() {
        return faceValue;
    }

    /**
     * Sets the value of the faceValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFaceValue(BigDecimal value) {
        this.faceValue = value;
    }

    /**
     * Gets the value of the expirationOffset property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getExpirationOffset() {
        return expirationOffset;
    }

    /**
     * Sets the value of the expirationOffset property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setExpirationOffset(BigDecimal value) {
        this.expirationOffset = value;
    }

    /**
     * Gets the value of the acctExpirationOffset property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAcctExpirationOffset() {
        return acctExpirationOffset;
    }

    /**
     * Sets the value of the acctExpirationOffset property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAcctExpirationOffset(BigDecimal value) {
        this.acctExpirationOffset = value;
    }

    /**
     * Gets the value of the changeCosF property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getChangeCosF() {
        return changeCosF;
    }

    /**
     * Sets the value of the changeCosF property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setChangeCosF(BigDecimal value) {
        this.changeCosF = value;
    }

    /**
     * Gets the value of the changeCos property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getChangeCos() {
        return changeCos;
    }

    /**
     * Sets the value of the changeCos property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setChangeCos(BigDecimal value) {
        this.changeCos = value;
    }

    /**
     * Gets the value of the changePhonebook property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getChangePhonebook() {
        return changePhonebook;
    }

    /**
     * Sets the value of the changePhonebook property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setChangePhonebook(BigDecimal value) {
        this.changePhonebook = value;
    }

    /**
     * Gets the value of the shipDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getShipDate() {
        return shipDate;
    }

    /**
     * Sets the value of the shipDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setShipDate(XMLGregorianCalendar value) {
        this.shipDate = value;
    }

    /**
     * Gets the value of the ucardSp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUcardSp() {
        return ucardSp;
    }

    /**
     * Sets the value of the ucardSp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUcardSp(String value) {
        this.ucardSp = value;
    }

    /**
     * Gets the value of the ucardCos property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUcardCos() {
        return ucardCos;
    }

    /**
     * Sets the value of the ucardCos property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUcardCos(String value) {
        this.ucardCos = value;
    }

}
