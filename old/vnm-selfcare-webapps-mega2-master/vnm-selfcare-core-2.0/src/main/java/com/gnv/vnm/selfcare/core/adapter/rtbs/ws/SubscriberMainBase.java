
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SubscriberMainBase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubscriberMainBase"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ExtensionData" type="{http://comverse-in.com/prepaid/ccws}SUBSCRIBEREXTENSIONDATA" minOccurs="0"/&gt;
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
 *         &lt;element name="NotificationLanguage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RoamingCreditLimitAsString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CurrentState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="COSName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PIN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PINChangeNeeded" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="LanguageName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TimeZone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IMSI" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NumberFreeAnCallsString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CFUNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CFBNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CFNANumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CFISNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="InFocusIdentity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ESN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="HLR_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OtherSysID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AccountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BillCycleDay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NotificationLevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MarketSegment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CreditLimit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CyclicLimit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="LimitType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AvailableCyclicLimit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubscriberMainBase", propOrder = {
    "extensionData",
    "extensionDataRaw",
    "notificationLanguage",
    "roamingCreditLimitAsString",
    "currentState",
    "cosName",
    "pin",
    "pinChangeNeeded",
    "languageName",
    "timeZone",
    "imsi",
    "numberFreeAnCallsString",
    "cfuNumber",
    "cfbNumber",
    "cfnaNumber",
    "cfisNumber",
    "inFocusIdentity",
    "esn",
    "hlrid",
    "otherSysID",
    "accountNumber",
    "billCycleDay",
    "notificationLevel",
    "marketSegment",
    "creditLimit",
    "cyclicLimit",
    "limitType",
    "availableCyclicLimit"
})
@XmlSeeAlso({
    SubscriberPPS.class,
    SubscriberEntity.class
})
public class SubscriberMainBase {

    @XmlElement(name = "ExtensionData")
    protected SUBSCRIBEREXTENSIONDATA extensionData;
    @XmlElement(name = "ExtensionDataRaw")
    protected SubscriberMainBase.ExtensionDataRaw extensionDataRaw;
    @XmlElement(name = "NotificationLanguage")
    protected String notificationLanguage;
    @XmlElement(name = "RoamingCreditLimitAsString")
    protected String roamingCreditLimitAsString;
    @XmlElement(name = "CurrentState")
    protected String currentState;
    @XmlElement(name = "COSName")
    protected String cosName;
    @XmlElement(name = "PIN")
    protected String pin;
    @XmlElement(name = "PINChangeNeeded")
    protected boolean pinChangeNeeded;
    @XmlElement(name = "LanguageName")
    protected String languageName;
    @XmlElement(name = "TimeZone")
    protected String timeZone;
    @XmlElement(name = "IMSI")
    protected String imsi;
    @XmlElement(name = "NumberFreeAnCallsString")
    protected String numberFreeAnCallsString;
    @XmlElement(name = "CFUNumber")
    protected String cfuNumber;
    @XmlElement(name = "CFBNumber")
    protected String cfbNumber;
    @XmlElement(name = "CFNANumber")
    protected String cfnaNumber;
    @XmlElement(name = "CFISNumber")
    protected String cfisNumber;
    @XmlElement(name = "InFocusIdentity")
    protected String inFocusIdentity;
    @XmlElement(name = "ESN")
    protected String esn;
    @XmlElement(name = "HLR_ID")
    protected String hlrid;
    @XmlElement(name = "OtherSysID")
    protected String otherSysID;
    @XmlElement(name = "AccountNumber")
    protected String accountNumber;
    @XmlElement(name = "BillCycleDay")
    protected String billCycleDay;
    @XmlElement(name = "NotificationLevel")
    protected String notificationLevel;
    @XmlElement(name = "MarketSegment")
    protected String marketSegment;
    @XmlElement(name = "CreditLimit")
    protected String creditLimit;
    @XmlElement(name = "CyclicLimit")
    protected String cyclicLimit;
    @XmlElement(name = "LimitType")
    protected String limitType;
    @XmlElement(name = "AvailableCyclicLimit")
    protected String availableCyclicLimit;

    /**
     * Gets the value of the extensionData property.
     * 
     * @return
     *     possible object is
     *     {@link SUBSCRIBEREXTENSIONDATA }
     *     
     */
    public SUBSCRIBEREXTENSIONDATA getExtensionData() {
        return extensionData;
    }

    /**
     * Sets the value of the extensionData property.
     * 
     * @param value
     *     allowed object is
     *     {@link SUBSCRIBEREXTENSIONDATA }
     *     
     */
    public void setExtensionData(SUBSCRIBEREXTENSIONDATA value) {
        this.extensionData = value;
    }

    /**
     * Gets the value of the extensionDataRaw property.
     * 
     * @return
     *     possible object is
     *     {@link SubscriberMainBase.ExtensionDataRaw }
     *     
     */
    public SubscriberMainBase.ExtensionDataRaw getExtensionDataRaw() {
        return extensionDataRaw;
    }

    /**
     * Sets the value of the extensionDataRaw property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriberMainBase.ExtensionDataRaw }
     *     
     */
    public void setExtensionDataRaw(SubscriberMainBase.ExtensionDataRaw value) {
        this.extensionDataRaw = value;
    }

    /**
     * Gets the value of the notificationLanguage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotificationLanguage() {
        return notificationLanguage;
    }

    /**
     * Sets the value of the notificationLanguage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotificationLanguage(String value) {
        this.notificationLanguage = value;
    }

    /**
     * Gets the value of the roamingCreditLimitAsString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoamingCreditLimitAsString() {
        return roamingCreditLimitAsString;
    }

    /**
     * Sets the value of the roamingCreditLimitAsString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoamingCreditLimitAsString(String value) {
        this.roamingCreditLimitAsString = value;
    }

    /**
     * Gets the value of the currentState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentState() {
        return currentState;
    }

    /**
     * Sets the value of the currentState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentState(String value) {
        this.currentState = value;
    }

    /**
     * Gets the value of the cosName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOSName() {
        return cosName;
    }

    /**
     * Sets the value of the cosName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOSName(String value) {
        this.cosName = value;
    }

    /**
     * Gets the value of the pin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPIN() {
        return pin;
    }

    /**
     * Sets the value of the pin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPIN(String value) {
        this.pin = value;
    }

    /**
     * Gets the value of the pinChangeNeeded property.
     * 
     */
    public boolean isPINChangeNeeded() {
        return pinChangeNeeded;
    }

    /**
     * Sets the value of the pinChangeNeeded property.
     * 
     */
    public void setPINChangeNeeded(boolean value) {
        this.pinChangeNeeded = value;
    }

    /**
     * Gets the value of the languageName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguageName() {
        return languageName;
    }

    /**
     * Sets the value of the languageName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguageName(String value) {
        this.languageName = value;
    }

    /**
     * Gets the value of the timeZone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeZone() {
        return timeZone;
    }

    /**
     * Sets the value of the timeZone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeZone(String value) {
        this.timeZone = value;
    }

    /**
     * Gets the value of the imsi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIMSI() {
        return imsi;
    }

    /**
     * Sets the value of the imsi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIMSI(String value) {
        this.imsi = value;
    }

    /**
     * Gets the value of the numberFreeAnCallsString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberFreeAnCallsString() {
        return numberFreeAnCallsString;
    }

    /**
     * Sets the value of the numberFreeAnCallsString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberFreeAnCallsString(String value) {
        this.numberFreeAnCallsString = value;
    }

    /**
     * Gets the value of the cfuNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCFUNumber() {
        return cfuNumber;
    }

    /**
     * Sets the value of the cfuNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCFUNumber(String value) {
        this.cfuNumber = value;
    }

    /**
     * Gets the value of the cfbNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCFBNumber() {
        return cfbNumber;
    }

    /**
     * Sets the value of the cfbNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCFBNumber(String value) {
        this.cfbNumber = value;
    }

    /**
     * Gets the value of the cfnaNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCFNANumber() {
        return cfnaNumber;
    }

    /**
     * Sets the value of the cfnaNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCFNANumber(String value) {
        this.cfnaNumber = value;
    }

    /**
     * Gets the value of the cfisNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCFISNumber() {
        return cfisNumber;
    }

    /**
     * Sets the value of the cfisNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCFISNumber(String value) {
        this.cfisNumber = value;
    }

    /**
     * Gets the value of the inFocusIdentity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInFocusIdentity() {
        return inFocusIdentity;
    }

    /**
     * Sets the value of the inFocusIdentity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInFocusIdentity(String value) {
        this.inFocusIdentity = value;
    }

    /**
     * Gets the value of the esn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getESN() {
        return esn;
    }

    /**
     * Sets the value of the esn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setESN(String value) {
        this.esn = value;
    }

    /**
     * Gets the value of the hlrid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHLRID() {
        return hlrid;
    }

    /**
     * Sets the value of the hlrid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHLRID(String value) {
        this.hlrid = value;
    }

    /**
     * Gets the value of the otherSysID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOtherSysID() {
        return otherSysID;
    }

    /**
     * Sets the value of the otherSysID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOtherSysID(String value) {
        this.otherSysID = value;
    }

    /**
     * Gets the value of the accountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the value of the accountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountNumber(String value) {
        this.accountNumber = value;
    }

    /**
     * Gets the value of the billCycleDay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillCycleDay() {
        return billCycleDay;
    }

    /**
     * Sets the value of the billCycleDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillCycleDay(String value) {
        this.billCycleDay = value;
    }

    /**
     * Gets the value of the notificationLevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotificationLevel() {
        return notificationLevel;
    }

    /**
     * Sets the value of the notificationLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotificationLevel(String value) {
        this.notificationLevel = value;
    }

    /**
     * Gets the value of the marketSegment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarketSegment() {
        return marketSegment;
    }

    /**
     * Sets the value of the marketSegment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarketSegment(String value) {
        this.marketSegment = value;
    }

    /**
     * Gets the value of the creditLimit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditLimit() {
        return creditLimit;
    }

    /**
     * Sets the value of the creditLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditLimit(String value) {
        this.creditLimit = value;
    }

    /**
     * Gets the value of the cyclicLimit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCyclicLimit() {
        return cyclicLimit;
    }

    /**
     * Sets the value of the cyclicLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCyclicLimit(String value) {
        this.cyclicLimit = value;
    }

    /**
     * Gets the value of the limitType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLimitType() {
        return limitType;
    }

    /**
     * Sets the value of the limitType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLimitType(String value) {
        this.limitType = value;
    }

    /**
     * Gets the value of the availableCyclicLimit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAvailableCyclicLimit() {
        return availableCyclicLimit;
    }

    /**
     * Sets the value of the availableCyclicLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAvailableCyclicLimit(String value) {
        this.availableCyclicLimit = value;
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
