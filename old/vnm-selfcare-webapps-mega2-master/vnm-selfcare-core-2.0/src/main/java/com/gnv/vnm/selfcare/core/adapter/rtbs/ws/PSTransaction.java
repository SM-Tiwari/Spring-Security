
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for PSTransaction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PSTransaction"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SubscriberID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TypeOfCharge" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Chargecode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="UsageAmount" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="UnitTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TransID1" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="TransID2" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="DateTimeTrans" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="SubscriberType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MessageType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Balances" type="{http://comverse-in.com/prepaid/ccws}ArrayOfBalanceEntity" minOccurs="0"/&gt;
 *         &lt;element name="Accumulators" type="{http://comverse-in.com/prepaid/ccws}ArrayOfAccumulatorHistory" minOccurs="0"/&gt;
 *         &lt;element name="SubID2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RefundFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RefundTransID1" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="RefundTransID2" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="ApplicationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SubTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Identity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AccountType" type="{http://comverse-in.com/prepaid/ccws}SubscriberAccountType"/&gt;
 *         &lt;element name="ContentType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ORPDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="FundUsageType" type="{http://comverse-in.com/prepaid/ccws}FundsUsageType"/&gt;
 *         &lt;element name="GroupID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IsoCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ConversionRate" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="RequestedISOCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MSCID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SPName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CallingCircle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
@XmlType(name = "PSTransaction", propOrder = {
    "subscriberID",
    "typeOfCharge",
    "chargecode",
    "usageAmount",
    "unitTypeName",
    "transID1",
    "transID2",
    "dateTimeTrans",
    "subscriberType",
    "messageType",
    "balances",
    "accumulators",
    "subID2",
    "refundFlag",
    "refundTransID1",
    "refundTransID2",
    "applicationName",
    "subTypeName",
    "identity",
    "accountType",
    "contentType",
    "orpDate",
    "fundUsageType",
    "groupID",
    "isoCode",
    "conversionRate",
    "requestedISOCode",
    "mscid",
    "spName",
    "callingCircle",
    "originalTariffPlan",
    "finalTariffPlan",
    "overrideAlcsName"
})
@XmlSeeAlso({
    FastPSTransaction.class
})
public class PSTransaction {

    @XmlElement(name = "SubscriberID")
    protected String subscriberID;
    @XmlElement(name = "TypeOfCharge")
    protected String typeOfCharge;
    @XmlElement(name = "Chargecode")
    protected String chargecode;
    @XmlElement(name = "UsageAmount")
    protected double usageAmount;
    @XmlElement(name = "UnitTypeName")
    protected String unitTypeName;
    @XmlElement(name = "TransID1")
    protected long transID1;
    @XmlElement(name = "TransID2")
    protected long transID2;
    @XmlElement(name = "DateTimeTrans", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateTimeTrans;
    @XmlElement(name = "SubscriberType")
    protected String subscriberType;
    @XmlElement(name = "MessageType")
    protected String messageType;
    @XmlElement(name = "Balances")
    protected ArrayOfBalanceEntity balances;
    @XmlElement(name = "Accumulators")
    protected ArrayOfAccumulatorHistory accumulators;
    @XmlElement(name = "SubID2")
    protected String subID2;
    @XmlElement(name = "RefundFlag")
    protected String refundFlag;
    @XmlElement(name = "RefundTransID1")
    protected long refundTransID1;
    @XmlElement(name = "RefundTransID2")
    protected long refundTransID2;
    @XmlElement(name = "ApplicationName")
    protected String applicationName;
    @XmlElement(name = "SubTypeName")
    protected String subTypeName;
    @XmlElement(name = "Identity")
    protected String identity;
    @XmlElement(name = "AccountType", required = true)
    @XmlSchemaType(name = "string")
    protected SubscriberAccountType accountType;
    @XmlElement(name = "ContentType")
    protected String contentType;
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
    @XmlElement(name = "ConversionRate")
    protected double conversionRate;
    @XmlElement(name = "RequestedISOCode")
    protected String requestedISOCode;
    @XmlElement(name = "MSCID")
    protected String mscid;
    @XmlElement(name = "SPName")
    protected String spName;
    @XmlElement(name = "CallingCircle")
    protected String callingCircle;
    @XmlElement(name = "OriginalTariffPlan")
    protected String originalTariffPlan;
    @XmlElement(name = "FinalTariffPlan")
    protected String finalTariffPlan;
    @XmlElement(name = "OverrideAlcsName")
    protected String overrideAlcsName;

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
     * Gets the value of the typeOfCharge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeOfCharge() {
        return typeOfCharge;
    }

    /**
     * Sets the value of the typeOfCharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeOfCharge(String value) {
        this.typeOfCharge = value;
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
     * Gets the value of the transID1 property.
     * 
     */
    public long getTransID1() {
        return transID1;
    }

    /**
     * Sets the value of the transID1 property.
     * 
     */
    public void setTransID1(long value) {
        this.transID1 = value;
    }

    /**
     * Gets the value of the transID2 property.
     * 
     */
    public long getTransID2() {
        return transID2;
    }

    /**
     * Sets the value of the transID2 property.
     * 
     */
    public void setTransID2(long value) {
        this.transID2 = value;
    }

    /**
     * Gets the value of the dateTimeTrans property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateTimeTrans() {
        return dateTimeTrans;
    }

    /**
     * Sets the value of the dateTimeTrans property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateTimeTrans(XMLGregorianCalendar value) {
        this.dateTimeTrans = value;
    }

    /**
     * Gets the value of the subscriberType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscriberType() {
        return subscriberType;
    }

    /**
     * Sets the value of the subscriberType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubscriberType(String value) {
        this.subscriberType = value;
    }

    /**
     * Gets the value of the messageType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageType() {
        return messageType;
    }

    /**
     * Sets the value of the messageType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageType(String value) {
        this.messageType = value;
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
     * Gets the value of the subID2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubID2() {
        return subID2;
    }

    /**
     * Sets the value of the subID2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubID2(String value) {
        this.subID2 = value;
    }

    /**
     * Gets the value of the refundFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefundFlag() {
        return refundFlag;
    }

    /**
     * Sets the value of the refundFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefundFlag(String value) {
        this.refundFlag = value;
    }

    /**
     * Gets the value of the refundTransID1 property.
     * 
     */
    public long getRefundTransID1() {
        return refundTransID1;
    }

    /**
     * Sets the value of the refundTransID1 property.
     * 
     */
    public void setRefundTransID1(long value) {
        this.refundTransID1 = value;
    }

    /**
     * Gets the value of the refundTransID2 property.
     * 
     */
    public long getRefundTransID2() {
        return refundTransID2;
    }

    /**
     * Sets the value of the refundTransID2 property.
     * 
     */
    public void setRefundTransID2(long value) {
        this.refundTransID2 = value;
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
     * Gets the value of the contentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * Sets the value of the contentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContentType(String value) {
        this.contentType = value;
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
     * Gets the value of the requestedISOCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestedISOCode() {
        return requestedISOCode;
    }

    /**
     * Sets the value of the requestedISOCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestedISOCode(String value) {
        this.requestedISOCode = value;
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

}
