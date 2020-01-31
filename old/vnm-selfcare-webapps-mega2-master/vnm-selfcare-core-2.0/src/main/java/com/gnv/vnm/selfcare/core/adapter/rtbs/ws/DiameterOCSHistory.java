
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for DiameterOCSHistory complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DiameterOCSHistory"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ExtensionData" type="{http://comverse-in.com/prepaid/ccws}DIAMETEROCSHISTORYEXTENSIONDATA" minOccurs="0"/&gt;
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
 *         &lt;element name="IdentityType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="StartCallDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="EndCallDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="ActivityType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="UsageAmount" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="AccountType" type="{http://comverse-in.com/prepaid/ccws}SubscriberAccountType"/&gt;
 *         &lt;element name="StartCallDateTimeTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="EndCallDateTimeTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Reason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CugCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ApplicationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SubTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SLUID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="UnitTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SessionID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SubSessionID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ChargeItemID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OrpTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="GroupID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ChargecodeType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FundUsageType" type="{http://comverse-in.com/prepaid/ccws}FundsUsageType"/&gt;
 *         &lt;element name="ISOCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PrevISOCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ConversionRate" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="CircleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Balances" type="{http://comverse-in.com/prepaid/ccws}ArrayOfBalanceEntity" minOccurs="0"/&gt;
 *         &lt;element name="Accumulators" type="{http://comverse-in.com/prepaid/ccws}ArrayOfAccumulatorHistory" minOccurs="0"/&gt;
 *         &lt;element name="RefundFlag" type="{http://microsoft.com/wsdl/types/}char"/&gt;
 *         &lt;element name="OCSComment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
@XmlType(name = "DiameterOCSHistory", propOrder = {
    "extensionData",
    "extensionDataRaw",
    "spName",
    "subscriberID",
    "identityType",
    "startCallDateTime",
    "endCallDateTime",
    "activityType",
    "usageAmount",
    "accountType",
    "startCallDateTimeTypeName",
    "endCallDateTimeTypeName",
    "description",
    "reason",
    "cugCode",
    "applicationName",
    "subTypeName",
    "sluid",
    "unitTypeName",
    "sessionID",
    "subSessionID",
    "chargeItemID",
    "orpTime",
    "groupID",
    "chargecodeType",
    "fundUsageType",
    "isoCode",
    "prevISOCode",
    "conversionRate",
    "circleName",
    "balances",
    "accumulators",
    "refundFlag",
    "ocsComment",
    "originalTariffPlan",
    "finalTariffPlan",
    "overrideAlcsName"
})
public class DiameterOCSHistory {

    @XmlElement(name = "ExtensionData")
    protected DIAMETEROCSHISTORYEXTENSIONDATA extensionData;
    @XmlElement(name = "ExtensionDataRaw")
    protected DiameterOCSHistory.ExtensionDataRaw extensionDataRaw;
    @XmlElement(name = "SPName")
    protected String spName;
    @XmlElement(name = "SubscriberID")
    protected String subscriberID;
    @XmlElement(name = "IdentityType")
    protected String identityType;
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
    @XmlElement(name = "AccountType", required = true)
    @XmlSchemaType(name = "string")
    protected SubscriberAccountType accountType;
    @XmlElement(name = "StartCallDateTimeTypeName")
    protected String startCallDateTimeTypeName;
    @XmlElement(name = "EndCallDateTimeTypeName")
    protected String endCallDateTimeTypeName;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "Reason")
    protected String reason;
    @XmlElement(name = "CugCode")
    protected String cugCode;
    @XmlElement(name = "ApplicationName")
    protected String applicationName;
    @XmlElement(name = "SubTypeName")
    protected String subTypeName;
    @XmlElement(name = "SLUID")
    protected String sluid;
    @XmlElement(name = "UnitTypeName")
    protected String unitTypeName;
    @XmlElement(name = "SessionID")
    protected String sessionID;
    @XmlElement(name = "SubSessionID")
    protected String subSessionID;
    @XmlElement(name = "ChargeItemID")
    protected String chargeItemID;
    @XmlElement(name = "OrpTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar orpTime;
    @XmlElement(name = "GroupID")
    protected String groupID;
    @XmlElement(name = "ChargecodeType")
    protected String chargecodeType;
    @XmlElement(name = "FundUsageType", required = true)
    @XmlSchemaType(name = "string")
    protected FundsUsageType fundUsageType;
    @XmlElement(name = "ISOCode")
    protected String isoCode;
    @XmlElement(name = "PrevISOCode")
    protected String prevISOCode;
    @XmlElement(name = "ConversionRate")
    protected double conversionRate;
    @XmlElement(name = "CircleName")
    protected String circleName;
    @XmlElement(name = "Balances")
    protected ArrayOfBalanceEntity balances;
    @XmlElement(name = "Accumulators")
    protected ArrayOfAccumulatorHistory accumulators;
    @XmlElement(name = "RefundFlag")
    @XmlSchemaType(name = "unsignedShort")
    protected int refundFlag;
    @XmlElement(name = "OCSComment")
    protected String ocsComment;
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
     *     {@link DIAMETEROCSHISTORYEXTENSIONDATA }
     *     
     */
    public DIAMETEROCSHISTORYEXTENSIONDATA getExtensionData() {
        return extensionData;
    }

    /**
     * Sets the value of the extensionData property.
     * 
     * @param value
     *     allowed object is
     *     {@link DIAMETEROCSHISTORYEXTENSIONDATA }
     *     
     */
    public void setExtensionData(DIAMETEROCSHISTORYEXTENSIONDATA value) {
        this.extensionData = value;
    }

    /**
     * Gets the value of the extensionDataRaw property.
     * 
     * @return
     *     possible object is
     *     {@link DiameterOCSHistory.ExtensionDataRaw }
     *     
     */
    public DiameterOCSHistory.ExtensionDataRaw getExtensionDataRaw() {
        return extensionDataRaw;
    }

    /**
     * Sets the value of the extensionDataRaw property.
     * 
     * @param value
     *     allowed object is
     *     {@link DiameterOCSHistory.ExtensionDataRaw }
     *     
     */
    public void setExtensionDataRaw(DiameterOCSHistory.ExtensionDataRaw value) {
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
     * Gets the value of the identityType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentityType() {
        return identityType;
    }

    /**
     * Sets the value of the identityType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentityType(String value) {
        this.identityType = value;
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
     * Gets the value of the startCallDateTimeTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartCallDateTimeTypeName() {
        return startCallDateTimeTypeName;
    }

    /**
     * Sets the value of the startCallDateTimeTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartCallDateTimeTypeName(String value) {
        this.startCallDateTimeTypeName = value;
    }

    /**
     * Gets the value of the endCallDateTimeTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndCallDateTimeTypeName() {
        return endCallDateTimeTypeName;
    }

    /**
     * Sets the value of the endCallDateTimeTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndCallDateTimeTypeName(String value) {
        this.endCallDateTimeTypeName = value;
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
     * Gets the value of the cugCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCugCode() {
        return cugCode;
    }

    /**
     * Sets the value of the cugCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCugCode(String value) {
        this.cugCode = value;
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
     * Gets the value of the sessionID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionID() {
        return sessionID;
    }

    /**
     * Sets the value of the sessionID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionID(String value) {
        this.sessionID = value;
    }

    /**
     * Gets the value of the subSessionID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubSessionID() {
        return subSessionID;
    }

    /**
     * Sets the value of the subSessionID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubSessionID(String value) {
        this.subSessionID = value;
    }

    /**
     * Gets the value of the chargeItemID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChargeItemID() {
        return chargeItemID;
    }

    /**
     * Sets the value of the chargeItemID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChargeItemID(String value) {
        this.chargeItemID = value;
    }

    /**
     * Gets the value of the orpTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOrpTime() {
        return orpTime;
    }

    /**
     * Sets the value of the orpTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOrpTime(XMLGregorianCalendar value) {
        this.orpTime = value;
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
     * Gets the value of the chargecodeType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChargecodeType() {
        return chargecodeType;
    }

    /**
     * Sets the value of the chargecodeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChargecodeType(String value) {
        this.chargecodeType = value;
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
     * Gets the value of the isoCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISOCode() {
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
    public void setISOCode(String value) {
        this.isoCode = value;
    }

    /**
     * Gets the value of the prevISOCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrevISOCode() {
        return prevISOCode;
    }

    /**
     * Sets the value of the prevISOCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrevISOCode(String value) {
        this.prevISOCode = value;
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
     * Gets the value of the circleName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCircleName() {
        return circleName;
    }

    /**
     * Sets the value of the circleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCircleName(String value) {
        this.circleName = value;
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
     * Gets the value of the refundFlag property.
     * 
     */
    public int getRefundFlag() {
        return refundFlag;
    }

    /**
     * Sets the value of the refundFlag property.
     * 
     */
    public void setRefundFlag(int value) {
        this.refundFlag = value;
    }

    /**
     * Gets the value of the ocsComment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOCSComment() {
        return ocsComment;
    }

    /**
     * Sets the value of the ocsComment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOCSComment(String value) {
        this.ocsComment = value;
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
