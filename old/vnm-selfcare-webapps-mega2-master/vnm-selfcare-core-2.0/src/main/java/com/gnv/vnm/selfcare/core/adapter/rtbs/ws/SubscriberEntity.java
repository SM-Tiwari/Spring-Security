
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for SubscriberEntity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubscriberEntity"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://comverse-in.com/prepaid/ccws}SubscriberMainBase"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BonusPlan" type="{http://comverse-in.com/prepaid/ccws}BonusPlanEntity" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Balances" type="{http://comverse-in.com/prepaid/ccws}ArrayOfBalanceEntity" minOccurs="0"/&gt;
 *         &lt;element name="SPName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CreationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="DateEnterActive" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="PreviousState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PrevTransDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="LastTransDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="AccountType" type="{http://comverse-in.com/prepaid/ccws}SubscriberAccountType"/&gt;
 *         &lt;element name="GroupName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="LastCallCharge" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="FreeFFChgAllowance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FFChangeCount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PromisedPaymentAmount" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="PromisedPaymentDueDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="PromisedPaymentBalanceID" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="CosInstantiationTimeStamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="Accumulator" type="{http://comverse-in.com/prepaid/ccws}AccumulatorEntity" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Offer" type="{http://comverse-in.com/prepaid/ccws}SubscribedOffer" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="LoyaltyEnrollmentDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="NextLoyaltySyncDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="LoyaltyScaleRate" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="LoyaltyBonusScale" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="CurrentHappyHourActiveDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="CurrentHappyHourEndDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="CurrentHappyHours" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="FutureHappyHours" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="HomeArea1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="HomeArea2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="HomeArea3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="HomeArea4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PreferredNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PreviousPreferredNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PreferredNumberDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubscriberEntity", propOrder = {
    "bonusPlan",
    "balances",
    "spName",
    "creationDate",
    "dateEnterActive",
    "previousState",
    "prevTransDate",
    "lastTransDate",
    "accountType",
    "groupName",
    "lastCallCharge",
    "freeFFChgAllowance",
    "ffChangeCount",
    "currencyCode",
    "promisedPaymentAmount",
    "promisedPaymentDueDate",
    "promisedPaymentBalanceID",
    "cosInstantiationTimeStamp",
    "accumulator",
    "offer",
    "loyaltyEnrollmentDate",
    "nextLoyaltySyncDate",
    "loyaltyScaleRate",
    "loyaltyBonusScale",
    "currentHappyHourActiveDate",
    "currentHappyHourEndDate",
    "currentHappyHours",
    "futureHappyHours",
    "homeArea1",
    "homeArea2",
    "homeArea3",
    "homeArea4",
    "preferredNumber",
    "previousPreferredNumber",
    "preferredNumberDate"
})
public class SubscriberEntity
    extends SubscriberMainBase
{

    @XmlElement(name = "BonusPlan")
    protected List<BonusPlanEntity> bonusPlan;
    @XmlElement(name = "Balances")
    protected ArrayOfBalanceEntity balances;
    @XmlElement(name = "SPName")
    protected String spName;
    @XmlElement(name = "CreationDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationDate;
    @XmlElement(name = "DateEnterActive", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateEnterActive;
    @XmlElement(name = "PreviousState")
    protected String previousState;
    @XmlElement(name = "PrevTransDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar prevTransDate;
    @XmlElement(name = "LastTransDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastTransDate;
    @XmlElement(name = "AccountType", required = true)
    @XmlSchemaType(name = "string")
    protected SubscriberAccountType accountType;
    @XmlElement(name = "GroupName")
    protected String groupName;
    @XmlElement(name = "LastCallCharge")
    protected double lastCallCharge;
    @XmlElement(name = "FreeFFChgAllowance")
    protected String freeFFChgAllowance;
    @XmlElement(name = "FFChangeCount")
    protected String ffChangeCount;
    @XmlElement(name = "CurrencyCode")
    protected String currencyCode;
    @XmlElement(name = "PromisedPaymentAmount")
    protected double promisedPaymentAmount;
    @XmlElement(name = "PromisedPaymentDueDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar promisedPaymentDueDate;
    @XmlElement(name = "PromisedPaymentBalanceID")
    protected int promisedPaymentBalanceID;
    @XmlElement(name = "CosInstantiationTimeStamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar cosInstantiationTimeStamp;
    @XmlElement(name = "Accumulator")
    protected List<AccumulatorEntity> accumulator;
    @XmlElement(name = "Offer")
    protected List<SubscribedOffer> offer;
    @XmlElement(name = "LoyaltyEnrollmentDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar loyaltyEnrollmentDate;
    @XmlElement(name = "NextLoyaltySyncDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar nextLoyaltySyncDate;
    @XmlElement(name = "LoyaltyScaleRate")
    protected double loyaltyScaleRate;
    @XmlElement(name = "LoyaltyBonusScale")
    protected int loyaltyBonusScale;
    @XmlElement(name = "CurrentHappyHourActiveDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar currentHappyHourActiveDate;
    @XmlElement(name = "CurrentHappyHourEndDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar currentHappyHourEndDate;
    @XmlElement(name = "CurrentHappyHours")
    protected List<String> currentHappyHours;
    @XmlElement(name = "FutureHappyHours")
    protected List<String> futureHappyHours;
    @XmlElement(name = "HomeArea1")
    protected String homeArea1;
    @XmlElement(name = "HomeArea2")
    protected String homeArea2;
    @XmlElement(name = "HomeArea3")
    protected String homeArea3;
    @XmlElement(name = "HomeArea4")
    protected String homeArea4;
    @XmlElement(name = "PreferredNumber")
    protected String preferredNumber;
    @XmlElement(name = "PreviousPreferredNumber")
    protected String previousPreferredNumber;
    @XmlElement(name = "PreferredNumberDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar preferredNumberDate;

    /**
     * Gets the value of the bonusPlan property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bonusPlan property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBonusPlan().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BonusPlanEntity }
     * 
     * 
     */
    public List<BonusPlanEntity> getBonusPlan() {
        if (bonusPlan == null) {
            bonusPlan = new ArrayList<BonusPlanEntity>();
        }
        return this.bonusPlan;
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
     * Gets the value of the creationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the value of the creationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreationDate(XMLGregorianCalendar value) {
        this.creationDate = value;
    }

    /**
     * Gets the value of the dateEnterActive property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateEnterActive() {
        return dateEnterActive;
    }

    /**
     * Sets the value of the dateEnterActive property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateEnterActive(XMLGregorianCalendar value) {
        this.dateEnterActive = value;
    }

    /**
     * Gets the value of the previousState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreviousState() {
        return previousState;
    }

    /**
     * Sets the value of the previousState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreviousState(String value) {
        this.previousState = value;
    }

    /**
     * Gets the value of the prevTransDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPrevTransDate() {
        return prevTransDate;
    }

    /**
     * Sets the value of the prevTransDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPrevTransDate(XMLGregorianCalendar value) {
        this.prevTransDate = value;
    }

    /**
     * Gets the value of the lastTransDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastTransDate() {
        return lastTransDate;
    }

    /**
     * Sets the value of the lastTransDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastTransDate(XMLGregorianCalendar value) {
        this.lastTransDate = value;
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
     * Gets the value of the groupName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * Sets the value of the groupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupName(String value) {
        this.groupName = value;
    }

    /**
     * Gets the value of the lastCallCharge property.
     * 
     */
    public double getLastCallCharge() {
        return lastCallCharge;
    }

    /**
     * Sets the value of the lastCallCharge property.
     * 
     */
    public void setLastCallCharge(double value) {
        this.lastCallCharge = value;
    }

    /**
     * Gets the value of the freeFFChgAllowance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFreeFFChgAllowance() {
        return freeFFChgAllowance;
    }

    /**
     * Sets the value of the freeFFChgAllowance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFreeFFChgAllowance(String value) {
        this.freeFFChgAllowance = value;
    }

    /**
     * Gets the value of the ffChangeCount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFFChangeCount() {
        return ffChangeCount;
    }

    /**
     * Sets the value of the ffChangeCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFFChangeCount(String value) {
        this.ffChangeCount = value;
    }

    /**
     * Gets the value of the currencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the value of the currencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyCode(String value) {
        this.currencyCode = value;
    }

    /**
     * Gets the value of the promisedPaymentAmount property.
     * 
     */
    public double getPromisedPaymentAmount() {
        return promisedPaymentAmount;
    }

    /**
     * Sets the value of the promisedPaymentAmount property.
     * 
     */
    public void setPromisedPaymentAmount(double value) {
        this.promisedPaymentAmount = value;
    }

    /**
     * Gets the value of the promisedPaymentDueDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPromisedPaymentDueDate() {
        return promisedPaymentDueDate;
    }

    /**
     * Sets the value of the promisedPaymentDueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPromisedPaymentDueDate(XMLGregorianCalendar value) {
        this.promisedPaymentDueDate = value;
    }

    /**
     * Gets the value of the promisedPaymentBalanceID property.
     * 
     */
    public int getPromisedPaymentBalanceID() {
        return promisedPaymentBalanceID;
    }

    /**
     * Sets the value of the promisedPaymentBalanceID property.
     * 
     */
    public void setPromisedPaymentBalanceID(int value) {
        this.promisedPaymentBalanceID = value;
    }

    /**
     * Gets the value of the cosInstantiationTimeStamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCosInstantiationTimeStamp() {
        return cosInstantiationTimeStamp;
    }

    /**
     * Sets the value of the cosInstantiationTimeStamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCosInstantiationTimeStamp(XMLGregorianCalendar value) {
        this.cosInstantiationTimeStamp = value;
    }

    /**
     * Gets the value of the accumulator property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accumulator property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccumulator().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccumulatorEntity }
     * 
     * 
     */
    public List<AccumulatorEntity> getAccumulator() {
        if (accumulator == null) {
            accumulator = new ArrayList<AccumulatorEntity>();
        }
        return this.accumulator;
    }

    /**
     * Gets the value of the offer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the offer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOffer().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubscribedOffer }
     * 
     * 
     */
    public List<SubscribedOffer> getOffer() {
        if (offer == null) {
            offer = new ArrayList<SubscribedOffer>();
        }
        return this.offer;
    }

    /**
     * Gets the value of the loyaltyEnrollmentDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLoyaltyEnrollmentDate() {
        return loyaltyEnrollmentDate;
    }

    /**
     * Sets the value of the loyaltyEnrollmentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLoyaltyEnrollmentDate(XMLGregorianCalendar value) {
        this.loyaltyEnrollmentDate = value;
    }

    /**
     * Gets the value of the nextLoyaltySyncDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getNextLoyaltySyncDate() {
        return nextLoyaltySyncDate;
    }

    /**
     * Sets the value of the nextLoyaltySyncDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setNextLoyaltySyncDate(XMLGregorianCalendar value) {
        this.nextLoyaltySyncDate = value;
    }

    /**
     * Gets the value of the loyaltyScaleRate property.
     * 
     */
    public double getLoyaltyScaleRate() {
        return loyaltyScaleRate;
    }

    /**
     * Sets the value of the loyaltyScaleRate property.
     * 
     */
    public void setLoyaltyScaleRate(double value) {
        this.loyaltyScaleRate = value;
    }

    /**
     * Gets the value of the loyaltyBonusScale property.
     * 
     */
    public int getLoyaltyBonusScale() {
        return loyaltyBonusScale;
    }

    /**
     * Sets the value of the loyaltyBonusScale property.
     * 
     */
    public void setLoyaltyBonusScale(int value) {
        this.loyaltyBonusScale = value;
    }

    /**
     * Gets the value of the currentHappyHourActiveDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCurrentHappyHourActiveDate() {
        return currentHappyHourActiveDate;
    }

    /**
     * Sets the value of the currentHappyHourActiveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCurrentHappyHourActiveDate(XMLGregorianCalendar value) {
        this.currentHappyHourActiveDate = value;
    }

    /**
     * Gets the value of the currentHappyHourEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCurrentHappyHourEndDate() {
        return currentHappyHourEndDate;
    }

    /**
     * Sets the value of the currentHappyHourEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCurrentHappyHourEndDate(XMLGregorianCalendar value) {
        this.currentHappyHourEndDate = value;
    }

    /**
     * Gets the value of the currentHappyHours property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the currentHappyHours property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCurrentHappyHours().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getCurrentHappyHours() {
        if (currentHappyHours == null) {
            currentHappyHours = new ArrayList<String>();
        }
        return this.currentHappyHours;
    }

    /**
     * Gets the value of the futureHappyHours property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the futureHappyHours property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFutureHappyHours().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getFutureHappyHours() {
        if (futureHappyHours == null) {
            futureHappyHours = new ArrayList<String>();
        }
        return this.futureHappyHours;
    }

    /**
     * Gets the value of the homeArea1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHomeArea1() {
        return homeArea1;
    }

    /**
     * Sets the value of the homeArea1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHomeArea1(String value) {
        this.homeArea1 = value;
    }

    /**
     * Gets the value of the homeArea2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHomeArea2() {
        return homeArea2;
    }

    /**
     * Sets the value of the homeArea2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHomeArea2(String value) {
        this.homeArea2 = value;
    }

    /**
     * Gets the value of the homeArea3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHomeArea3() {
        return homeArea3;
    }

    /**
     * Sets the value of the homeArea3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHomeArea3(String value) {
        this.homeArea3 = value;
    }

    /**
     * Gets the value of the homeArea4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHomeArea4() {
        return homeArea4;
    }

    /**
     * Sets the value of the homeArea4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHomeArea4(String value) {
        this.homeArea4 = value;
    }

    /**
     * Gets the value of the preferredNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreferredNumber() {
        return preferredNumber;
    }

    /**
     * Sets the value of the preferredNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreferredNumber(String value) {
        this.preferredNumber = value;
    }

    /**
     * Gets the value of the previousPreferredNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreviousPreferredNumber() {
        return previousPreferredNumber;
    }

    /**
     * Sets the value of the previousPreferredNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreviousPreferredNumber(String value) {
        this.previousPreferredNumber = value;
    }

    /**
     * Gets the value of the preferredNumberDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPreferredNumberDate() {
        return preferredNumberDate;
    }

    /**
     * Sets the value of the preferredNumberDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPreferredNumberDate(XMLGregorianCalendar value) {
        this.preferredNumberDate = value;
    }

}
