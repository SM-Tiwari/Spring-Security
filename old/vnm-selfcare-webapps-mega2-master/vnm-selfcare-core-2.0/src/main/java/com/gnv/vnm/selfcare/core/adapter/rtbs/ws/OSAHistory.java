
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
 * <p>Java class for OSAHistory complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OSAHistory"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ExtensionData" type="{http://comverse-in.com/prepaid/ccws}OSAHISTORYEXTENSIONDATA" minOccurs="0"/&gt;
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
 *         &lt;element name="SPName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SubscriberID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Chargecode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="StartCallDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="EndCallDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="ActivityType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="UsageAmount" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Reason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ApplicationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SubTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SLUID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="UnitTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MerchantName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SessionDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CorrelationID" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="CorrelationType" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="AccountID" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="ApplicationDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OSAItem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OSASubType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="QOS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ServiceCatalog1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ServiceCatalog2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ServiceCatalog3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ServiceCatalog4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ParamConfirmID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ParamContract" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="LocationA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="LocationAType" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="LocationB" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="LocationBType" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="IMSI" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="InfoParameter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Balances" type="{http://comverse-in.com/prepaid/ccws}ArrayOfBalanceEntity" minOccurs="0"/&gt;
 *         &lt;element name="Accumulators" type="{http://comverse-in.com/prepaid/ccws}ArrayOfAccumulatorHistory" minOccurs="0"/&gt;
 *         &lt;element name="Identity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AccountType" type="{http://comverse-in.com/prepaid/ccws}SubscriberAccountType"/&gt;
 *         &lt;element name="ORPDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="FundUsageType" type="{http://comverse-in.com/prepaid/ccws}FundsUsageType"/&gt;
 *         &lt;element name="GroupID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IsoCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PreviousISOCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ConversionRate" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="OriginalTariffPlan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FinalTariffPlan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OverrideAlcsName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OSAHistory", propOrder = {
    "extensionData",
    "extensionDataRaw",
    "spName",
    "subscriberID",
    "chargecode",
    "startCallDateTime",
    "endCallDateTime",
    "activityType",
    "usageAmount",
    "description",
    "reason",
    "applicationName",
    "subTypeName",
    "sluid",
    "unitTypeName",
    "merchantName",
    "sessionDescription",
    "correlationID",
    "correlationType",
    "accountID",
    "applicationDescription",
    "osaItem",
    "osaSubType",
    "qos",
    "serviceCatalog1",
    "serviceCatalog2",
    "serviceCatalog3",
    "serviceCatalog4",
    "paramConfirmID",
    "paramContract",
    "locationA",
    "locationAType",
    "locationB",
    "locationBType",
    "imsi",
    "infoParameter",
    "currency",
    "balances",
    "accumulators",
    "identity",
    "accountType",
    "orpDate",
    "fundUsageType",
    "groupID",
    "isoCode",
    "previousISOCode",
    "conversionRate",
    "originalTariffPlan",
    "finalTariffPlan",
    "overrideAlcsName"
})
@XmlSeeAlso({
    FastOSAHistory.class
})
public class OSAHistory {

    @XmlElement(name = "ExtensionData")
    protected OSAHISTORYEXTENSIONDATA extensionData;
    @XmlElement(name = "ExtensionDataRaw")
    protected OSAHistory.ExtensionDataRaw extensionDataRaw;
    @XmlElement(name = "SPName")
    protected String spName;
    @XmlElement(name = "SubscriberID")
    protected String subscriberID;
    @XmlElement(name = "Chargecode")
    protected String chargecode;
    @XmlElement(name = "StartCallDateTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startCallDateTime;
    @XmlElement(name = "EndCallDateTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endCallDateTime;
    @XmlElement(name = "ActivityType")
    protected String activityType;
    @XmlElement(name = "UsageAmount")
    protected long usageAmount;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "Reason")
    protected String reason;
    @XmlElement(name = "ApplicationName")
    protected String applicationName;
    @XmlElement(name = "SubTypeName")
    protected String subTypeName;
    @XmlElement(name = "SLUID")
    protected String sluid;
    @XmlElement(name = "UnitTypeName")
    protected String unitTypeName;
    @XmlElement(name = "MerchantName")
    protected String merchantName;
    @XmlElement(name = "SessionDescription")
    protected String sessionDescription;
    @XmlElement(name = "CorrelationID")
    protected long correlationID;
    @XmlElement(name = "CorrelationType")
    protected long correlationType;
    @XmlElement(name = "AccountID")
    protected long accountID;
    @XmlElement(name = "ApplicationDescription")
    protected String applicationDescription;
    @XmlElement(name = "OSAItem")
    protected String osaItem;
    @XmlElement(name = "OSASubType")
    protected String osaSubType;
    @XmlElement(name = "QOS")
    protected String qos;
    @XmlElement(name = "ServiceCatalog1")
    protected String serviceCatalog1;
    @XmlElement(name = "ServiceCatalog2")
    protected String serviceCatalog2;
    @XmlElement(name = "ServiceCatalog3")
    protected String serviceCatalog3;
    @XmlElement(name = "ServiceCatalog4")
    protected String serviceCatalog4;
    @XmlElement(name = "ParamConfirmID")
    protected String paramConfirmID;
    @XmlElement(name = "ParamContract")
    protected String paramContract;
    @XmlElement(name = "LocationA")
    protected String locationA;
    @XmlElement(name = "LocationAType")
    protected long locationAType;
    @XmlElement(name = "LocationB")
    protected String locationB;
    @XmlElement(name = "LocationBType")
    protected long locationBType;
    @XmlElement(name = "IMSI")
    protected String imsi;
    @XmlElement(name = "InfoParameter")
    protected String infoParameter;
    @XmlElement(name = "Currency")
    protected String currency;
    @XmlElement(name = "Balances")
    protected ArrayOfBalanceEntity balances;
    @XmlElement(name = "Accumulators")
    protected ArrayOfAccumulatorHistory accumulators;
    @XmlElement(name = "Identity")
    protected String identity;
    @XmlElement(name = "AccountType", required = true)
    @XmlSchemaType(name = "string")
    protected SubscriberAccountType accountType;
    @XmlElement(name = "ORPDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar orpDate;
    @XmlElement(name = "FundUsageType", required = true)
    @XmlSchemaType(name = "string")
    protected FundsUsageType fundUsageType;
    @XmlElement(name = "GroupID")
    protected String groupID;
    @XmlElement(name = "IsoCode")
    protected String isoCode;
    @XmlElement(name = "PreviousISOCode")
    protected String previousISOCode;
    @XmlElement(name = "ConversionRate")
    protected double conversionRate;
    @XmlElement(name = "OriginalTariffPlan")
    protected String originalTariffPlan;
    @XmlElement(name = "FinalTariffPlan")
    protected String finalTariffPlan;
    @XmlElement(name = "OverrideAlcsName")
    protected String overrideAlcsName;

    /**
     * Gets the value of the extensionData property.
     * 
     * @return
     *     possible object is
     *     {@link OSAHISTORYEXTENSIONDATA }
     *     
     */
    public OSAHISTORYEXTENSIONDATA getExtensionData() {
        return extensionData;
    }

    /**
     * Sets the value of the extensionData property.
     * 
     * @param value
     *     allowed object is
     *     {@link OSAHISTORYEXTENSIONDATA }
     *     
     */
    public void setExtensionData(OSAHISTORYEXTENSIONDATA value) {
        this.extensionData = value;
    }

    /**
     * Gets the value of the extensionDataRaw property.
     * 
     * @return
     *     possible object is
     *     {@link OSAHistory.ExtensionDataRaw }
     *     
     */
    public OSAHistory.ExtensionDataRaw getExtensionDataRaw() {
        return extensionDataRaw;
    }

    /**
     * Sets the value of the extensionDataRaw property.
     * 
     * @param value
     *     allowed object is
     *     {@link OSAHistory.ExtensionDataRaw }
     *     
     */
    public void setExtensionDataRaw(OSAHistory.ExtensionDataRaw value) {
        this.extensionDataRaw = value;
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
     * Gets the value of the startCallDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartCallDateTime() {
        return startCallDateTime;
    }

    /**
     * Sets the value of the startCallDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartCallDateTime(XMLGregorianCalendar value) {
        this.startCallDateTime = value;
    }

    /**
     * Gets the value of the endCallDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndCallDateTime() {
        return endCallDateTime;
    }

    /**
     * Sets the value of the endCallDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndCallDateTime(XMLGregorianCalendar value) {
        this.endCallDateTime = value;
    }

    /**
     * Gets the value of the activityType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActivityType() {
        return activityType;
    }

    /**
     * Sets the value of the activityType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivityType(String value) {
        this.activityType = value;
    }

    /**
     * Gets the value of the usageAmount property.
     * 
     */
    public long getUsageAmount() {
        return usageAmount;
    }

    /**
     * Sets the value of the usageAmount property.
     * 
     */
    public void setUsageAmount(long value) {
        this.usageAmount = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the reason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReason() {
        return reason;
    }

    /**
     * Sets the value of the reason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReason(String value) {
        this.reason = value;
    }

    /**
     * Gets the value of the applicationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicationName() {
        return applicationName;
    }

    /**
     * Sets the value of the applicationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicationName(String value) {
        this.applicationName = value;
    }

    /**
     * Gets the value of the subTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubTypeName() {
        return subTypeName;
    }

    /**
     * Sets the value of the subTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubTypeName(String value) {
        this.subTypeName = value;
    }

    /**
     * Gets the value of the sluid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSLUID() {
        return sluid;
    }

    /**
     * Sets the value of the sluid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSLUID(String value) {
        this.sluid = value;
    }

    /**
     * Gets the value of the unitTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitTypeName() {
        return unitTypeName;
    }

    /**
     * Sets the value of the unitTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitTypeName(String value) {
        this.unitTypeName = value;
    }

    /**
     * Gets the value of the merchantName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerchantName() {
        return merchantName;
    }

    /**
     * Sets the value of the merchantName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerchantName(String value) {
        this.merchantName = value;
    }

    /**
     * Gets the value of the sessionDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionDescription() {
        return sessionDescription;
    }

    /**
     * Sets the value of the sessionDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionDescription(String value) {
        this.sessionDescription = value;
    }

    /**
     * Gets the value of the correlationID property.
     * 
     */
    public long getCorrelationID() {
        return correlationID;
    }

    /**
     * Sets the value of the correlationID property.
     * 
     */
    public void setCorrelationID(long value) {
        this.correlationID = value;
    }

    /**
     * Gets the value of the correlationType property.
     * 
     */
    public long getCorrelationType() {
        return correlationType;
    }

    /**
     * Sets the value of the correlationType property.
     * 
     */
    public void setCorrelationType(long value) {
        this.correlationType = value;
    }

    /**
     * Gets the value of the accountID property.
     * 
     */
    public long getAccountID() {
        return accountID;
    }

    /**
     * Sets the value of the accountID property.
     * 
     */
    public void setAccountID(long value) {
        this.accountID = value;
    }

    /**
     * Gets the value of the applicationDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicationDescription() {
        return applicationDescription;
    }

    /**
     * Sets the value of the applicationDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicationDescription(String value) {
        this.applicationDescription = value;
    }

    /**
     * Gets the value of the osaItem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOSAItem() {
        return osaItem;
    }

    /**
     * Sets the value of the osaItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOSAItem(String value) {
        this.osaItem = value;
    }

    /**
     * Gets the value of the osaSubType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOSASubType() {
        return osaSubType;
    }

    /**
     * Sets the value of the osaSubType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOSASubType(String value) {
        this.osaSubType = value;
    }

    /**
     * Gets the value of the qos property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQOS() {
        return qos;
    }

    /**
     * Sets the value of the qos property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQOS(String value) {
        this.qos = value;
    }

    /**
     * Gets the value of the serviceCatalog1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceCatalog1() {
        return serviceCatalog1;
    }

    /**
     * Sets the value of the serviceCatalog1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceCatalog1(String value) {
        this.serviceCatalog1 = value;
    }

    /**
     * Gets the value of the serviceCatalog2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceCatalog2() {
        return serviceCatalog2;
    }

    /**
     * Sets the value of the serviceCatalog2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceCatalog2(String value) {
        this.serviceCatalog2 = value;
    }

    /**
     * Gets the value of the serviceCatalog3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceCatalog3() {
        return serviceCatalog3;
    }

    /**
     * Sets the value of the serviceCatalog3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceCatalog3(String value) {
        this.serviceCatalog3 = value;
    }

    /**
     * Gets the value of the serviceCatalog4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceCatalog4() {
        return serviceCatalog4;
    }

    /**
     * Sets the value of the serviceCatalog4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceCatalog4(String value) {
        this.serviceCatalog4 = value;
    }

    /**
     * Gets the value of the paramConfirmID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParamConfirmID() {
        return paramConfirmID;
    }

    /**
     * Sets the value of the paramConfirmID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParamConfirmID(String value) {
        this.paramConfirmID = value;
    }

    /**
     * Gets the value of the paramContract property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParamContract() {
        return paramContract;
    }

    /**
     * Sets the value of the paramContract property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParamContract(String value) {
        this.paramContract = value;
    }

    /**
     * Gets the value of the locationA property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocationA() {
        return locationA;
    }

    /**
     * Sets the value of the locationA property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocationA(String value) {
        this.locationA = value;
    }

    /**
     * Gets the value of the locationAType property.
     * 
     */
    public long getLocationAType() {
        return locationAType;
    }

    /**
     * Sets the value of the locationAType property.
     * 
     */
    public void setLocationAType(long value) {
        this.locationAType = value;
    }

    /**
     * Gets the value of the locationB property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocationB() {
        return locationB;
    }

    /**
     * Sets the value of the locationB property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocationB(String value) {
        this.locationB = value;
    }

    /**
     * Gets the value of the locationBType property.
     * 
     */
    public long getLocationBType() {
        return locationBType;
    }

    /**
     * Sets the value of the locationBType property.
     * 
     */
    public void setLocationBType(long value) {
        this.locationBType = value;
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
     * Gets the value of the infoParameter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInfoParameter() {
        return infoParameter;
    }

    /**
     * Sets the value of the infoParameter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInfoParameter(String value) {
        this.infoParameter = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
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
     * Gets the value of the orpDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getORPDate() {
        return orpDate;
    }

    /**
     * Sets the value of the orpDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setORPDate(XMLGregorianCalendar value) {
        this.orpDate = value;
    }

    /**
     * Gets the value of the fundUsageType property.
     * 
     * @return
     *     possible object is
     *     {@link FundsUsageType }
     *     
     */
    public FundsUsageType getFundUsageType() {
        return fundUsageType;
    }

    /**
     * Sets the value of the fundUsageType property.
     * 
     * @param value
     *     allowed object is
     *     {@link FundsUsageType }
     *     
     */
    public void setFundUsageType(FundsUsageType value) {
        this.fundUsageType = value;
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
     * Gets the value of the previousISOCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreviousISOCode() {
        return previousISOCode;
    }

    /**
     * Sets the value of the previousISOCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreviousISOCode(String value) {
        this.previousISOCode = value;
    }

    /**
     * Gets the value of the conversionRate property.
     * 
     */
    public double getConversionRate() {
        return conversionRate;
    }

    /**
     * Sets the value of the conversionRate property.
     * 
     */
    public void setConversionRate(double value) {
        this.conversionRate = value;
    }

    /**
     * Gets the value of the originalTariffPlan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalTariffPlan() {
        return originalTariffPlan;
    }

    /**
     * Sets the value of the originalTariffPlan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalTariffPlan(String value) {
        this.originalTariffPlan = value;
    }

    /**
     * Gets the value of the finalTariffPlan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFinalTariffPlan() {
        return finalTariffPlan;
    }

    /**
     * Sets the value of the finalTariffPlan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFinalTariffPlan(String value) {
        this.finalTariffPlan = value;
    }

    /**
     * Gets the value of the overrideAlcsName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOverrideAlcsName() {
        return overrideAlcsName;
    }

    /**
     * Sets the value of the overrideAlcsName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOverrideAlcsName(String value) {
        this.overrideAlcsName = value;
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
