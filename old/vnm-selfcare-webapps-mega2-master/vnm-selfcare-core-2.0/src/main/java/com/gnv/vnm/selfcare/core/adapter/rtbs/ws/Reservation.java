
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Reservation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Reservation"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AccumulatorAmounts" type="{http://comverse-in.com/prepaid/ccws}ArrayOfAccumulatorBase" minOccurs="0"/&gt;
 *         &lt;element name="ReservationAmounts" type="{http://comverse-in.com/prepaid/ccws}ArrayOfReservationAmount" minOccurs="0"/&gt;
 *         &lt;element name="SubscriberID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SLUName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ProcessName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CRN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ReservationID" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="ApplicationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SubTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ReservationEndTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="ConsUsage" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="MasterSubID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MasterIdentityId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="ActivityStartTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="CalledNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ServiceType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AssumeConsumption" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DiscountPlanName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="VersionID" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="COSName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FundUsageType" type="{http://comverse-in.com/prepaid/ccws}FundsUsageType"/&gt;
 *         &lt;element name="IsoCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
@XmlType(name = "Reservation", propOrder = {
    "accumulatorAmounts",
    "reservationAmounts",
    "subscriberID",
    "sluName",
    "processName",
    "crn",
    "reservationID",
    "applicationName",
    "subTypeName",
    "reservationEndTime",
    "consUsage",
    "masterSubID",
    "masterIdentityId",
    "activityStartTime",
    "calledNumber",
    "serviceType",
    "assumeConsumption",
    "discountPlanName",
    "versionID",
    "cosName",
    "fundUsageType",
    "isoCode",
    "originalTariffPlan",
    "finalTariffPlan",
    "overrideAlcsName"
})
public class Reservation {

    @XmlElement(name = "AccumulatorAmounts")
    protected ArrayOfAccumulatorBase accumulatorAmounts;
    @XmlElement(name = "ReservationAmounts")
    protected ArrayOfReservationAmount reservationAmounts;
    @XmlElement(name = "SubscriberID")
    protected String subscriberID;
    @XmlElement(name = "SLUName")
    protected String sluName;
    @XmlElement(name = "ProcessName")
    protected String processName;
    @XmlElement(name = "CRN")
    protected String crn;
    @XmlElement(name = "ReservationID")
    protected int reservationID;
    @XmlElement(name = "ApplicationName")
    protected String applicationName;
    @XmlElement(name = "SubTypeName")
    protected String subTypeName;
    @XmlElement(name = "ReservationEndTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar reservationEndTime;
    @XmlElement(name = "ConsUsage")
    protected int consUsage;
    @XmlElement(name = "MasterSubID")
    protected String masterSubID;
    @XmlElement(name = "MasterIdentityId")
    protected int masterIdentityId;
    @XmlElement(name = "ActivityStartTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar activityStartTime;
    @XmlElement(name = "CalledNumber")
    protected String calledNumber;
    @XmlElement(name = "ServiceType")
    protected String serviceType;
    @XmlElement(name = "AssumeConsumption")
    protected String assumeConsumption;
    @XmlElement(name = "DiscountPlanName")
    protected String discountPlanName;
    @XmlElement(name = "VersionID")
    protected int versionID;
    @XmlElement(name = "COSName")
    protected String cosName;
    @XmlElement(name = "FundUsageType", required = true)
    @XmlSchemaType(name = "string")
    protected FundsUsageType fundUsageType;
    @XmlElement(name = "IsoCode")
    protected String isoCode;
    @XmlElement(name = "OriginalTariffPlan")
    protected String originalTariffPlan;
    @XmlElement(name = "FinalTariffPlan")
    protected String finalTariffPlan;
    @XmlElement(name = "OverrideAlcsName")
    protected String overrideAlcsName;

    /**
     * Gets the value of the accumulatorAmounts property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAccumulatorBase }
     *     
     */
    public ArrayOfAccumulatorBase getAccumulatorAmounts() {
        return accumulatorAmounts;
    }

    /**
     * Sets the value of the accumulatorAmounts property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAccumulatorBase }
     *     
     */
    public void setAccumulatorAmounts(ArrayOfAccumulatorBase value) {
        this.accumulatorAmounts = value;
    }

    /**
     * Gets the value of the reservationAmounts property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfReservationAmount }
     *     
     */
    public ArrayOfReservationAmount getReservationAmounts() {
        return reservationAmounts;
    }

    /**
     * Sets the value of the reservationAmounts property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfReservationAmount }
     *     
     */
    public void setReservationAmounts(ArrayOfReservationAmount value) {
        this.reservationAmounts = value;
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
     * Gets the value of the sluName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSLUName() {
        return sluName;
    }

    /**
     * Sets the value of the sluName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSLUName(String value) {
        this.sluName = value;
    }

    /**
     * Gets the value of the processName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessName() {
        return processName;
    }

    /**
     * Sets the value of the processName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessName(String value) {
        this.processName = value;
    }

    /**
     * Gets the value of the crn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCRN() {
        return crn;
    }

    /**
     * Sets the value of the crn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCRN(String value) {
        this.crn = value;
    }

    /**
     * Gets the value of the reservationID property.
     * 
     */
    public int getReservationID() {
        return reservationID;
    }

    /**
     * Sets the value of the reservationID property.
     * 
     */
    public void setReservationID(int value) {
        this.reservationID = value;
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
     * Gets the value of the reservationEndTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReservationEndTime() {
        return reservationEndTime;
    }

    /**
     * Sets the value of the reservationEndTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReservationEndTime(XMLGregorianCalendar value) {
        this.reservationEndTime = value;
    }

    /**
     * Gets the value of the consUsage property.
     * 
     */
    public int getConsUsage() {
        return consUsage;
    }

    /**
     * Sets the value of the consUsage property.
     * 
     */
    public void setConsUsage(int value) {
        this.consUsage = value;
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
     * Gets the value of the masterIdentityId property.
     * 
     */
    public int getMasterIdentityId() {
        return masterIdentityId;
    }

    /**
     * Sets the value of the masterIdentityId property.
     * 
     */
    public void setMasterIdentityId(int value) {
        this.masterIdentityId = value;
    }

    /**
     * Gets the value of the activityStartTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getActivityStartTime() {
        return activityStartTime;
    }

    /**
     * Sets the value of the activityStartTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setActivityStartTime(XMLGregorianCalendar value) {
        this.activityStartTime = value;
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
     * Gets the value of the serviceType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceType() {
        return serviceType;
    }

    /**
     * Sets the value of the serviceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceType(String value) {
        this.serviceType = value;
    }

    /**
     * Gets the value of the assumeConsumption property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssumeConsumption() {
        return assumeConsumption;
    }

    /**
     * Sets the value of the assumeConsumption property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssumeConsumption(String value) {
        this.assumeConsumption = value;
    }

    /**
     * Gets the value of the discountPlanName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiscountPlanName() {
        return discountPlanName;
    }

    /**
     * Sets the value of the discountPlanName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiscountPlanName(String value) {
        this.discountPlanName = value;
    }

    /**
     * Gets the value of the versionID property.
     * 
     */
    public int getVersionID() {
        return versionID;
    }

    /**
     * Sets the value of the versionID property.
     * 
     */
    public void setVersionID(int value) {
        this.versionID = value;
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
