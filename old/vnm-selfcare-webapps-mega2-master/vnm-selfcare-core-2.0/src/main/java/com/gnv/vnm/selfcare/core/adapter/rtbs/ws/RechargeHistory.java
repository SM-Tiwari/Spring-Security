
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for RechargeHistory complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RechargeHistory"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ExtensionData" type="{http://comverse-in.com/prepaid/ccws}RECHARGEHISTORYEXTENSIONDATA" minOccurs="0"/&gt;
 *         &lt;element name="ExtensionDataRaw" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;any/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Chargecode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Balances" type="{http://comverse-in.com/prepaid/ccws}ArrayOfBalanceEntity" minOccurs="0"/&gt;
 *         &lt;element name="Accumulators" type="{http://comverse-in.com/prepaid/ccws}ArrayOfAccumulatorHistory" minOccurs="0"/&gt;
 *         &lt;element name="SubscriberID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RechargeOriginator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RechargeDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="CardNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ExpirationOffset" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="VoucherType" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="BatchNumber" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="SerialNumber" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="Comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FaceValue" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="BilledBalanceAmount" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="Identity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AccountType" type="{http://comverse-in.com/prepaid/ccws}SubscriberAccountType"/&gt;
 *         &lt;element name="GroupID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IsoCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CurrencyConversionRate" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="VoucherISOCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SPName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RechargeHistory", propOrder = {
    "extensionData",
    "extensionDataRaw",
    "chargecode",
    "balances",
    "accumulators",
    "subscriberID",
    "rechargeOriginator",
    "rechargeDate",
    "cardNumber",
    "expirationOffset",
    "voucherType",
    "batchNumber",
    "serialNumber",
    "comment",
    "faceValue",
    "billedBalanceAmount",
    "identity",
    "accountType",
    "groupID",
    "isoCode",
    "currencyConversionRate",
    "voucherISOCode",
    "spName"
})
@XmlSeeAlso({
    FastRechargeHistory.class
})
public class RechargeHistory {

    @XmlElement(name = "ExtensionData")
    protected RECHARGEHISTORYEXTENSIONDATA extensionData;
    @XmlElement(name = "ExtensionDataRaw")
    protected RechargeHistory.ExtensionDataRaw extensionDataRaw;
    @XmlElement(name = "Chargecode")
    protected String chargecode;
    @XmlElement(name = "Balances")
    protected ArrayOfBalanceEntity balances;
    @XmlElement(name = "Accumulators")
    protected ArrayOfAccumulatorHistory accumulators;
    @XmlElement(name = "SubscriberID")
    protected String subscriberID;
    @XmlElement(name = "RechargeOriginator")
    protected String rechargeOriginator;
    @XmlElement(name = "RechargeDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar rechargeDate;
    @XmlElement(name = "CardNumber")
    protected String cardNumber;
    @XmlElement(name = "ExpirationOffset")
    protected long expirationOffset;
    @XmlElement(name = "VoucherType")
    protected long voucherType;
    @XmlElement(name = "BatchNumber")
    protected long batchNumber;
    @XmlElement(name = "SerialNumber")
    protected long serialNumber;
    @XmlElement(name = "Comment")
    protected String comment;
    @XmlElement(name = "FaceValue")
    protected double faceValue;
    @XmlElement(name = "BilledBalanceAmount")
    protected double billedBalanceAmount;
    @XmlElement(name = "Identity")
    protected String identity;
    @XmlElement(name = "AccountType", required = true)
    @XmlSchemaType(name = "string")
    protected SubscriberAccountType accountType;
    @XmlElement(name = "GroupID")
    protected String groupID;
    @XmlElement(name = "IsoCode")
    protected String isoCode;
    @XmlElement(name = "CurrencyConversionRate")
    protected double currencyConversionRate;
    @XmlElement(name = "VoucherISOCode")
    protected String voucherISOCode;
    @XmlElement(name = "SPName")
    protected String spName;

    /**
     * Gets the value of the extensionData property.
     * 
     * @return
     *     possible object is
     *     {@link RECHARGEHISTORYEXTENSIONDATA }
     *     
     */
    public RECHARGEHISTORYEXTENSIONDATA getExtensionData() {
        return extensionData;
    }

    /**
     * Sets the value of the extensionData property.
     * 
     * @param value
     *     allowed object is
     *     {@link RECHARGEHISTORYEXTENSIONDATA }
     *     
     */
    public void setExtensionData(RECHARGEHISTORYEXTENSIONDATA value) {
        this.extensionData = value;
    }

    /**
     * Gets the value of the extensionDataRaw property.
     * 
     * @return
     *     possible object is
     *     {@link RechargeHistory.ExtensionDataRaw }
     *     
     */
    public RechargeHistory.ExtensionDataRaw getExtensionDataRaw() {
        return extensionDataRaw;
    }

    /**
     * Sets the value of the extensionDataRaw property.
     * 
     * @param value
     *     allowed object is
     *     {@link RechargeHistory.ExtensionDataRaw }
     *     
     */
    public void setExtensionDataRaw(RechargeHistory.ExtensionDataRaw value) {
        this.extensionDataRaw = value;
    }

    /**
     * Gets the value of the chargecode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChargecode() {
        return chargecode;
    }

    /**
     * Sets the value of the chargecode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChargecode(String value) {
        this.chargecode = value;
    }

    /**
     * Gets the value of the balances property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfBalanceEntity }
     *     
     */
    public ArrayOfBalanceEntity getBalances() {
        return balances;
    }

    /**
     * Sets the value of the balances property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfBalanceEntity }
     *     
     */
    public void setBalances(ArrayOfBalanceEntity value) {
        this.balances = value;
    }

    /**
     * Gets the value of the accumulators property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAccumulatorHistory }
     *     
     */
    public ArrayOfAccumulatorHistory getAccumulators() {
        return accumulators;
    }

    /**
     * Sets the value of the accumulators property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAccumulatorHistory }
     *     
     */
    public void setAccumulators(ArrayOfAccumulatorHistory value) {
        this.accumulators = value;
    }

    /**
     * Gets the value of the subscriberID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscriberID() {
        return subscriberID;
    }

    /**
     * Sets the value of the subscriberID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubscriberID(String value) {
        this.subscriberID = value;
    }

    /**
     * Gets the value of the rechargeOriginator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRechargeOriginator() {
        return rechargeOriginator;
    }

    /**
     * Sets the value of the rechargeOriginator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRechargeOriginator(String value) {
        this.rechargeOriginator = value;
    }

    /**
     * Gets the value of the rechargeDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRechargeDate() {
        return rechargeDate;
    }

    /**
     * Sets the value of the rechargeDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRechargeDate(XMLGregorianCalendar value) {
        this.rechargeDate = value;
    }

    /**
     * Gets the value of the cardNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * Sets the value of the cardNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardNumber(String value) {
        this.cardNumber = value;
    }

    /**
     * Gets the value of the expirationOffset property.
     * 
     */
    public long getExpirationOffset() {
        return expirationOffset;
    }

    /**
     * Sets the value of the expirationOffset property.
     * 
     */
    public void setExpirationOffset(long value) {
        this.expirationOffset = value;
    }

    /**
     * Gets the value of the voucherType property.
     * 
     */
    public long getVoucherType() {
        return voucherType;
    }

    /**
     * Sets the value of the voucherType property.
     * 
     */
    public void setVoucherType(long value) {
        this.voucherType = value;
    }

    /**
     * Gets the value of the batchNumber property.
     * 
     */
    public long getBatchNumber() {
        return batchNumber;
    }

    /**
     * Sets the value of the batchNumber property.
     * 
     */
    public void setBatchNumber(long value) {
        this.batchNumber = value;
    }

    /**
     * Gets the value of the serialNumber property.
     * 
     */
    public long getSerialNumber() {
        return serialNumber;
    }

    /**
     * Sets the value of the serialNumber property.
     * 
     */
    public void setSerialNumber(long value) {
        this.serialNumber = value;
    }

    /**
     * Gets the value of the comment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComment(String value) {
        this.comment = value;
    }

    /**
     * Gets the value of the faceValue property.
     * 
     */
    public double getFaceValue() {
        return faceValue;
    }

    /**
     * Sets the value of the faceValue property.
     * 
     */
    public void setFaceValue(double value) {
        this.faceValue = value;
    }

    /**
     * Gets the value of the billedBalanceAmount property.
     * 
     */
    public double getBilledBalanceAmount() {
        return billedBalanceAmount;
    }

    /**
     * Sets the value of the billedBalanceAmount property.
     * 
     */
    public void setBilledBalanceAmount(double value) {
        this.billedBalanceAmount = value;
    }

    /**
     * Gets the value of the identity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentity() {
        return identity;
    }

    /**
     * Sets the value of the identity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentity(String value) {
        this.identity = value;
    }

    /**
     * Gets the value of the accountType property.
     * 
     * @return
     *     possible object is
     *     {@link SubscriberAccountType }
     *     
     */
    public SubscriberAccountType getAccountType() {
        return accountType;
    }

    /**
     * Sets the value of the accountType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriberAccountType }
     *     
     */
    public void setAccountType(SubscriberAccountType value) {
        this.accountType = value;
    }

    /**
     * Gets the value of the groupID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupID() {
        return groupID;
    }

    /**
     * Sets the value of the groupID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupID(String value) {
        this.groupID = value;
    }

    /**
     * Gets the value of the isoCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsoCode() {
        return isoCode;
    }

    /**
     * Sets the value of the isoCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsoCode(String value) {
        this.isoCode = value;
    }

    /**
     * Gets the value of the currencyConversionRate property.
     * 
     */
    public double getCurrencyConversionRate() {
        return currencyConversionRate;
    }

    /**
     * Sets the value of the currencyConversionRate property.
     * 
     */
    public void setCurrencyConversionRate(double value) {
        this.currencyConversionRate = value;
    }

    /**
     * Gets the value of the voucherISOCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVoucherISOCode() {
        return voucherISOCode;
    }

    /**
     * Sets the value of the voucherISOCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVoucherISOCode(String value) {
        this.voucherISOCode = value;
    }

    /**
     * Gets the value of the spName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSPName() {
        return spName;
    }

    /**
     * Sets the value of the spName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSPName(String value) {
        this.spName = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;any/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "content"
    })
    public static class ExtensionDataRaw {

        @XmlMixed
        @XmlAnyElement(lax = true)
        protected List<Object> content;

        /**
         * Gets the value of the content property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the content property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getContent().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Object }
         * {@link String }
         * 
         * 
         */
        public List<Object> getContent() {
            if (content == null) {
                content = new ArrayList<Object>();
            }
            return this.content;
        }

    }

}
