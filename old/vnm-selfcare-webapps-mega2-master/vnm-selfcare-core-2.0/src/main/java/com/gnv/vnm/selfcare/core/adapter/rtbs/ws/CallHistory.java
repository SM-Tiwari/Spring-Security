
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
 * <p>Java class for CallHistory complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CallHistory"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ExtensionData" type="{http://comverse-in.com/prepaid/ccws}CALLHISTORYEXTENSIONDATA" minOccurs="0"/&gt;
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
 *         &lt;element name="UsageAmount" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="Balances" type="{http://comverse-in.com/prepaid/ccws}ArrayOfBalanceEntity" minOccurs="0"/&gt;
 *         &lt;element name="SubscriberID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="StartCallDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="EndCallDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="CalledNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CallDuration" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="CallType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Reason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AdditionalNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CUGCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MasterSubID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ApplicationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SubTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MSCID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CellID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SLUID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="UnitTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="APN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="QOS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CRN" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="Identity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AccountType" type="{http://comverse-in.com/prepaid/ccws}SubscriberAccountType"/&gt;
 *         &lt;element name="ORPTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="FundUsageType" type="{http://comverse-in.com/prepaid/ccws}FundsUsageType"/&gt;
 *         &lt;element name="GroupID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IsoCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PreviousISOCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ConversionRate" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="SPName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CallingCircle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Accumulators" type="{http://comverse-in.com/prepaid/ccws}ArrayOfAccumulatorHistory" minOccurs="0"/&gt;
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
@XmlType(name = "CallHistory", propOrder = {
    "extensionData",
    "extensionDataRaw",
    "chargecode",
    "usageAmount",
    "balances",
    "subscriberID",
    "startCallDateTime",
    "endCallDateTime",
    "calledNumber",
    "callDuration",
    "callType",
    "description",
    "reason",
    "additionalNumber",
    "cugCode",
    "masterSubID",
    "applicationName",
    "subTypeName",
    "mscid",
    "cellID",
    "sluid",
    "unitTypeName",
    "apn",
    "qos",
    "crn",
    "identity",
    "accountType",
    "orpTime",
    "fundUsageType",
    "groupID",
    "isoCode",
    "previousISOCode",
    "conversionRate",
    "spName",
    "callingCircle",
    "accumulators",
    "originalTariffPlan",
    "finalTariffPlan",
    "overrideAlcsName"
})
@XmlSeeAlso({
    FastCallHistory.class
})
public class CallHistory {

    @XmlElement(name = "ExtensionData")
    protected CALLHISTORYEXTENSIONDATA extensionData;
    @XmlElement(name = "ExtensionDataRaw")
    protected CallHistory.ExtensionDataRaw extensionDataRaw;
    @XmlElement(name = "Chargecode")
    protected String chargecode;
    @XmlElement(name = "UsageAmount")
    protected double usageAmount;
    @XmlElement(name = "Balances")
    protected ArrayOfBalanceEntity balances;
    @XmlElement(name = "SubscriberID")
    protected String subscriberID;
    @XmlElement(name = "StartCallDateTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startCallDateTime;
    @XmlElement(name = "EndCallDateTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endCallDateTime;
    @XmlElement(name = "CalledNumber")
    protected String calledNumber;
    @XmlElement(name = "CallDuration")
    protected long callDuration;
    @XmlElement(name = "CallType")
    protected String callType;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "Reason")
    protected String reason;
    @XmlElement(name = "AdditionalNumber")
    protected String additionalNumber;
    @XmlElement(name = "CUGCode")
    protected String cugCode;
    @XmlElement(name = "MasterSubID")
    protected String masterSubID;
    @XmlElement(name = "ApplicationName")
    protected String applicationName;
    @XmlElement(name = "SubTypeName")
    protected String subTypeName;
    @XmlElement(name = "MSCID")
    protected String mscid;
    @XmlElement(name = "CellID")
    protected String cellID;
    @XmlElement(name = "SLUID")
    protected String sluid;
    @XmlElement(name = "UnitTypeName")
    protected String unitTypeName;
    @XmlElement(name = "APN")
    protected String apn;
    @XmlElement(name = "QOS")
    protected String qos;
    @XmlElement(name = "CRN")
    protected long crn;
    @XmlElement(name = "Identity")
    protected String identity;
    @XmlElement(name = "AccountType", required = true)
    @XmlSchemaType(name = "string")
    protected SubscriberAccountType accountType;
    @XmlElement(name = "ORPTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar orpTime;
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
    @XmlElement(name = "SPName")
    protected String spName;
    @XmlElement(name = "CallingCircle")
    protected String callingCircle;
    @XmlElement(name = "Accumulators")
    protected ArrayOfAccumulatorHistory accumulators;
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
     *     {@link CALLHISTORYEXTENSIONDATA }
     *     
     */
    public CALLHISTORYEXTENSIONDATA getExtensionData() {
        return extensionData;
    }

    /**
     * Sets the value of the extensionData property.
     * 
     * @param value
     *     allowed object is
     *     {@link CALLHISTORYEXTENSIONDATA }
     *     
     */
    public void setExtensionData(CALLHISTORYEXTENSIONDATA value) {
        this.extensionData = value;
    }

    /**
     * Gets the value of the extensionDataRaw property.
     * 
     * @return
     *     possible object is
     *     {@link CallHistory.ExtensionDataRaw }
     *     
     */
    public CallHistory.ExtensionDataRaw getExtensionDataRaw() {
        return extensionDataRaw;
    }

    /**
     * Sets the value of the extensionDataRaw property.
     * 
     * @param value
     *     allowed object is
     *     {@link CallHistory.ExtensionDataRaw }
     *     
     */
    public void setExtensionDataRaw(CallHistory.ExtensionDataRaw value) {
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
     * Gets the value of the usageAmount property.
     * 
     */
    public double getUsageAmount() {
        return usageAmount;
    }

    /**
     * Sets the value of the usageAmount property.
     * 
     */
    public void setUsageAmount(double value) {
        this.usageAmount = value;
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
     * Gets the value of the calledNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCalledNumber() {
        return calledNumber;
    }

    /**
     * Sets the value of the calledNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCalledNumber(String value) {
        this.calledNumber = value;
    }

    /**
     * Gets the value of the callDuration property.
     * 
     */
    public long getCallDuration() {
        return callDuration;
    }

    /**
     * Sets the value of the callDuration property.
     * 
     */
    public void setCallDuration(long value) {
        this.callDuration = value;
    }

    /**
     * Gets the value of the callType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCallType() {
        return callType;
    }

    /**
     * Sets the value of the callType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCallType(String value) {
        this.callType = value;
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
     * Gets the value of the additionalNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdditionalNumber() {
        return additionalNumber;
    }

    /**
     * Sets the value of the additionalNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdditionalNumber(String value) {
        this.additionalNumber = value;
    }

    /**
     * Gets the value of the cugCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCUGCode() {
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
    public void setCUGCode(String value) {
        this.cugCode = value;
    }

    /**
     * Gets the value of the masterSubID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMasterSubID() {
        return masterSubID;
    }

    /**
     * Sets the value of the masterSubID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMasterSubID(String value) {
        this.masterSubID = value;
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
     * Gets the value of the mscid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMSCID() {
        return mscid;
    }

    /**
     * Sets the value of the mscid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMSCID(String value) {
        this.mscid = value;
    }

    /**
     * Gets the value of the cellID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCellID() {
        return cellID;
    }

    /**
     * Sets the value of the cellID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCellID(String value) {
        this.cellID = value;
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
     * Gets the value of the apn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAPN() {
        return apn;
    }

    /**
     * Sets the value of the apn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAPN(String value) {
        this.apn = value;
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
     * Gets the value of the crn property.
     * 
     */
    public long getCRN() {
        return crn;
    }

    /**
     * Sets the value of the crn property.
     * 
     */
    public void setCRN(long value) {
        this.crn = value;
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
     * Gets the value of the orpTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getORPTime() {
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
    public void setORPTime(XMLGregorianCalendar value) {
        this.orpTime = value;
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
     * Gets the value of the callingCircle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCallingCircle() {
        return callingCircle;
    }

    /**
     * Sets the value of the callingCircle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCallingCircle(String value) {
        this.callingCircle = value;
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
