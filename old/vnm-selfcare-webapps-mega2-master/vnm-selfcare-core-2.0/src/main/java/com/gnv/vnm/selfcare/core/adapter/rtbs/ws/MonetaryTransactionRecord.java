
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
 * <p>Java class for MonetaryTransactionRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MonetaryTransactionRecord"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ExtensionData" type="{http://comverse-in.com/prepaid/ccws}MTRHISTORYEXTENSIONDATA" minOccurs="0"/&gt;
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
 *         &lt;element name="SubscriberID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Chargecode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PPSAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="LoginName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ModDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="MTRComment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DiscountPlanName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BonusPlanName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BonusAwarded" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="DiscountAwarded" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="UnitTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Balances" type="{http://comverse-in.com/prepaid/ccws}ArrayOfBalanceEntity" minOccurs="0"/&gt;
 *         &lt;element name="Accumulators" type="{http://comverse-in.com/prepaid/ccws}ArrayOfAccumulatorHistory" minOccurs="0"/&gt;
 *         &lt;element name="Identity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AccountType" type="{http://comverse-in.com/prepaid/ccws}SubscriberAccountType"/&gt;
 *         &lt;element name="Offers" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="FundUsageType" type="{http://comverse-in.com/prepaid/ccws}FundsUsageType"/&gt;
 *         &lt;element name="GroupID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IsoCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PreviousISOCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ConversionRate" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="PreviousCOSName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CurrentCOSName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SPName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OldLoyaltyScale" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="NewLoyaltyScale" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="NewHappyHours" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OldHappyHours" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MonetaryTransactionRecord", propOrder = {
    "extensionData",
    "extensionDataRaw",
    "subscriberID",
    "chargecode",
    "ppsAccount",
    "loginName",
    "modDate",
    "mtrComment",
    "discountPlanName",
    "bonusPlanName",
    "bonusAwarded",
    "discountAwarded",
    "unitTypeName",
    "balances",
    "accumulators",
    "identity",
    "accountType",
    "offers",
    "fundUsageType",
    "groupID",
    "isoCode",
    "previousISOCode",
    "conversionRate",
    "previousCOSName",
    "currentCOSName",
    "spName",
    "oldLoyaltyScale",
    "newLoyaltyScale",
    "newHappyHours",
    "oldHappyHours"
})
@XmlSeeAlso({
    FastMonetaryTransactionRecord.class
})
public class MonetaryTransactionRecord {

    @XmlElement(name = "ExtensionData")
    protected MTRHISTORYEXTENSIONDATA extensionData;
    @XmlElement(name = "ExtensionDataRaw")
    protected MonetaryTransactionRecord.ExtensionDataRaw extensionDataRaw;
    @XmlElement(name = "SubscriberID")
    protected String subscriberID;
    @XmlElement(name = "Chargecode")
    protected String chargecode;
    @XmlElement(name = "PPSAccount")
    protected String ppsAccount;
    @XmlElement(name = "LoginName")
    protected String loginName;
    @XmlElement(name = "ModDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar modDate;
    @XmlElement(name = "MTRComment")
    protected String mtrComment;
    @XmlElement(name = "DiscountPlanName")
    protected String discountPlanName;
    @XmlElement(name = "BonusPlanName")
    protected String bonusPlanName;
    @XmlElement(name = "BonusAwarded")
    protected double bonusAwarded;
    @XmlElement(name = "DiscountAwarded")
    protected double discountAwarded;
    @XmlElement(name = "UnitTypeName")
    protected String unitTypeName;
    @XmlElement(name = "Balances")
    protected ArrayOfBalanceEntity balances;
    @XmlElement(name = "Accumulators")
    protected ArrayOfAccumulatorHistory accumulators;
    @XmlElement(name = "Identity")
    protected String identity;
    @XmlElement(name = "AccountType", required = true)
    @XmlSchemaType(name = "string")
    protected SubscriberAccountType accountType;
    @XmlElement(name = "Offers")
    protected List<String> offers;
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
    @XmlElement(name = "PreviousCOSName")
    protected String previousCOSName;
    @XmlElement(name = "CurrentCOSName")
    protected String currentCOSName;
    @XmlElement(name = "SPName")
    protected String spName;
    @XmlElement(name = "OldLoyaltyScale")
    protected int oldLoyaltyScale;
    @XmlElement(name = "NewLoyaltyScale")
    protected int newLoyaltyScale;
    @XmlElement(name = "NewHappyHours")
    protected String newHappyHours;
    @XmlElement(name = "OldHappyHours")
    protected String oldHappyHours;

    /**
     * Gets the value of the extensionData property.
     * 
     * @return
     *     possible object is
     *     {@link MTRHISTORYEXTENSIONDATA }
     *     
     */
    public MTRHISTORYEXTENSIONDATA getExtensionData() {
        return extensionData;
    }

    /**
     * Sets the value of the extensionData property.
     * 
     * @param value
     *     allowed object is
     *     {@link MTRHISTORYEXTENSIONDATA }
     *     
     */
    public void setExtensionData(MTRHISTORYEXTENSIONDATA value) {
        this.extensionData = value;
    }

    /**
     * Gets the value of the extensionDataRaw property.
     * 
     * @return
     *     possible object is
     *     {@link MonetaryTransactionRecord.ExtensionDataRaw }
     *     
     */
    public MonetaryTransactionRecord.ExtensionDataRaw getExtensionDataRaw() {
        return extensionDataRaw;
    }

    /**
     * Sets the value of the extensionDataRaw property.
     * 
     * @param value
     *     allowed object is
     *     {@link MonetaryTransactionRecord.ExtensionDataRaw }
     *     
     */
    public void setExtensionDataRaw(MonetaryTransactionRecord.ExtensionDataRaw value) {
        this.extensionDataRaw = value;
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
     * Gets the value of the ppsAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPPSAccount() {
        return ppsAccount;
    }

    /**
     * Sets the value of the ppsAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPPSAccount(String value) {
        this.ppsAccount = value;
    }

    /**
     * Gets the value of the loginName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * Sets the value of the loginName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoginName(String value) {
        this.loginName = value;
    }

    /**
     * Gets the value of the modDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getModDate() {
        return modDate;
    }

    /**
     * Sets the value of the modDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setModDate(XMLGregorianCalendar value) {
        this.modDate = value;
    }

    /**
     * Gets the value of the mtrComment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMTRComment() {
        return mtrComment;
    }

    /**
     * Sets the value of the mtrComment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMTRComment(String value) {
        this.mtrComment = value;
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
     * Gets the value of the bonusPlanName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBonusPlanName() {
        return bonusPlanName;
    }

    /**
     * Sets the value of the bonusPlanName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBonusPlanName(String value) {
        this.bonusPlanName = value;
    }

    /**
     * Gets the value of the bonusAwarded property.
     * 
     */
    public double getBonusAwarded() {
        return bonusAwarded;
    }

    /**
     * Sets the value of the bonusAwarded property.
     * 
     */
    public void setBonusAwarded(double value) {
        this.bonusAwarded = value;
    }

    /**
     * Gets the value of the discountAwarded property.
     * 
     */
    public double getDiscountAwarded() {
        return discountAwarded;
    }

    /**
     * Sets the value of the discountAwarded property.
     * 
     */
    public void setDiscountAwarded(double value) {
        this.discountAwarded = value;
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
     * Gets the value of the offers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the offers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOffers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getOffers() {
        if (offers == null) {
            offers = new ArrayList<String>();
        }
        return this.offers;
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
     * Gets the value of the previousCOSName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreviousCOSName() {
        return previousCOSName;
    }

    /**
     * Sets the value of the previousCOSName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreviousCOSName(String value) {
        this.previousCOSName = value;
    }

    /**
     * Gets the value of the currentCOSName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentCOSName() {
        return currentCOSName;
    }

    /**
     * Sets the value of the currentCOSName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentCOSName(String value) {
        this.currentCOSName = value;
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
     * Gets the value of the oldLoyaltyScale property.
     * 
     */
    public int getOldLoyaltyScale() {
        return oldLoyaltyScale;
    }

    /**
     * Sets the value of the oldLoyaltyScale property.
     * 
     */
    public void setOldLoyaltyScale(int value) {
        this.oldLoyaltyScale = value;
    }

    /**
     * Gets the value of the newLoyaltyScale property.
     * 
     */
    public int getNewLoyaltyScale() {
        return newLoyaltyScale;
    }

    /**
     * Sets the value of the newLoyaltyScale property.
     * 
     */
    public void setNewLoyaltyScale(int value) {
        this.newLoyaltyScale = value;
    }

    /**
     * Gets the value of the newHappyHours property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewHappyHours() {
        return newHappyHours;
    }

    /**
     * Sets the value of the newHappyHours property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewHappyHours(String value) {
        this.newHappyHours = value;
    }

    /**
     * Gets the value of the oldHappyHours property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOldHappyHours() {
        return oldHappyHours;
    }

    /**
     * Sets the value of the oldHappyHours property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOldHappyHours(String value) {
        this.oldHappyHours = value;
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
