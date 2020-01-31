
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClientCache complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClientCache"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CachedTables" type="{http://comverse-in.com/prepaid/ccws}CachedTables" minOccurs="0"/&gt;
 *         &lt;element name="CachedTablesRaw" minOccurs="0"&gt;
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
 *         &lt;element name="OverrideHomeAreas" type="{http://comverse-in.com/prepaid/ccws}ArrayOfOverrideHomeAreas" minOccurs="0"/&gt;
 *         &lt;element name="MarketSegments" type="{http://comverse-in.com/prepaid/ccws}ArrayOfString" minOccurs="0"/&gt;
 *         &lt;element name="OfferDefinitions" type="{http://comverse-in.com/prepaid/ccws}ArrayOfOffer" minOccurs="0"/&gt;
 *         &lt;element name="versionId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="balances" type="{http://comverse-in.com/prepaid/ccws}ArrayOfBalanceDefinition" minOccurs="0"/&gt;
 *         &lt;element name="accumulators" type="{http://comverse-in.com/prepaid/ccws}ArrayOfAccumulator" minOccurs="0"/&gt;
 *         &lt;element name="bonusPlans" type="{http://comverse-in.com/prepaid/ccws}ArrayOfBonusPlan" minOccurs="0"/&gt;
 *         &lt;element name="discountPlans" type="{http://comverse-in.com/prepaid/ccws}ArrayOfDiscountPlan" minOccurs="0"/&gt;
 *         &lt;element name="globalPeriodicCharges" type="{http://comverse-in.com/prepaid/ccws}ArrayOfPeriodicCharge" minOccurs="0"/&gt;
 *         &lt;element name="activityDefinitions" type="{http://comverse-in.com/prepaid/ccws}ArrayOfActivityDefinition" minOccurs="0"/&gt;
 *         &lt;element name="unitTypes" type="{http://comverse-in.com/prepaid/ccws}ArrayOfUnitType" minOccurs="0"/&gt;
 *         &lt;element name="classesOfService" type="{http://comverse-in.com/prepaid/ccws}ArrayOfClassOfService" minOccurs="0"/&gt;
 *         &lt;element name="AccessNumber" type="{http://comverse-in.com/prepaid/ccws}ArrayOfString" minOccurs="0"/&gt;
 *         &lt;element name="applicationName" type="{http://comverse-in.com/prepaid/ccws}ArrayOfString" minOccurs="0"/&gt;
 *         &lt;element name="barredNumber" type="{http://comverse-in.com/prepaid/ccws}ArrayOfString" minOccurs="0"/&gt;
 *         &lt;element name="emergencyNumber" type="{http://comverse-in.com/prepaid/ccws}ArrayOfString" minOccurs="0"/&gt;
 *         &lt;element name="languageName" type="{http://comverse-in.com/prepaid/ccws}ArrayOfString" minOccurs="0"/&gt;
 *         &lt;element name="timezoneName" type="{http://comverse-in.com/prepaid/ccws}ArrayOfString" minOccurs="0"/&gt;
 *         &lt;element name="subscriberStateName" type="{http://comverse-in.com/prepaid/ccws}ArrayOfString" minOccurs="0"/&gt;
 *         &lt;element name="rechargeCardStateName" type="{http://comverse-in.com/prepaid/ccws}ArrayOfString" minOccurs="0"/&gt;
 *         &lt;element name="serviceProviderName" type="{http://comverse-in.com/prepaid/ccws}ArrayOfString" minOccurs="0"/&gt;
 *         &lt;element name="currencyUnitName" type="{http://comverse-in.com/prepaid/ccws}ArrayOfCurrencyUnit" minOccurs="0"/&gt;
 *         &lt;element name="callingCircleGroups" type="{http://comverse-in.com/prepaid/ccws}ArrayOfString" minOccurs="0"/&gt;
 *         &lt;element name="barredNumberSets" type="{http://comverse-in.com/prepaid/ccws}ArrayOfString" minOccurs="0"/&gt;
 *         &lt;element name="LoyaltyBonusPlans" type="{http://comverse-in.com/prepaid/ccws}ArrayOfLoyaltyBonusPlan" minOccurs="0"/&gt;
 *         &lt;element name="OverrideOffers" type="{http://comverse-in.com/prepaid/ccws}ArrayOfAlcsOverrideDefinition" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClientCache", propOrder = {
    "cachedTables",
    "cachedTablesRaw",
    "overrideHomeAreas",
    "marketSegments",
    "offerDefinitions",
    "versionId",
    "balances",
    "accumulators",
    "bonusPlans",
    "discountPlans",
    "globalPeriodicCharges",
    "activityDefinitions",
    "unitTypes",
    "classesOfService",
    "accessNumber",
    "applicationName",
    "barredNumber",
    "emergencyNumber",
    "languageName",
    "timezoneName",
    "subscriberStateName",
    "rechargeCardStateName",
    "serviceProviderName",
    "currencyUnitName",
    "callingCircleGroups",
    "barredNumberSets",
    "loyaltyBonusPlans",
    "overrideOffers"
})
public class ClientCache {

    @XmlElement(name = "CachedTables")
    protected CachedTables cachedTables;
    @XmlElement(name = "CachedTablesRaw")
    protected ClientCache.CachedTablesRaw cachedTablesRaw;
    @XmlElement(name = "OverrideHomeAreas")
    protected ArrayOfOverrideHomeAreas overrideHomeAreas;
    @XmlElement(name = "MarketSegments")
    protected ArrayOfString marketSegments;
    @XmlElement(name = "OfferDefinitions")
    protected ArrayOfOffer offerDefinitions;
    protected long versionId;
    protected ArrayOfBalanceDefinition balances;
    protected ArrayOfAccumulator accumulators;
    protected ArrayOfBonusPlan bonusPlans;
    protected ArrayOfDiscountPlan discountPlans;
    protected ArrayOfPeriodicCharge globalPeriodicCharges;
    protected ArrayOfActivityDefinition activityDefinitions;
    protected ArrayOfUnitType unitTypes;
    protected ArrayOfClassOfService classesOfService;
    @XmlElement(name = "AccessNumber")
    protected ArrayOfString accessNumber;
    protected ArrayOfString applicationName;
    protected ArrayOfString barredNumber;
    protected ArrayOfString emergencyNumber;
    protected ArrayOfString languageName;
    protected ArrayOfString timezoneName;
    protected ArrayOfString subscriberStateName;
    protected ArrayOfString rechargeCardStateName;
    protected ArrayOfString serviceProviderName;
    protected ArrayOfCurrencyUnit currencyUnitName;
    protected ArrayOfString callingCircleGroups;
    protected ArrayOfString barredNumberSets;
    @XmlElement(name = "LoyaltyBonusPlans")
    protected ArrayOfLoyaltyBonusPlan loyaltyBonusPlans;
    @XmlElement(name = "OverrideOffers")
    protected ArrayOfAlcsOverrideDefinition overrideOffers;

    /**
     * Gets the value of the cachedTables property.
     * 
     * @return
     *     possible object is
     *     {@link CachedTables }
     *     
     */
    public CachedTables getCachedTables() {
        return cachedTables;
    }

    /**
     * Sets the value of the cachedTables property.
     * 
     * @param value
     *     allowed object is
     *     {@link CachedTables }
     *     
     */
    public void setCachedTables(CachedTables value) {
        this.cachedTables = value;
    }

    /**
     * Gets the value of the cachedTablesRaw property.
     * 
     * @return
     *     possible object is
     *     {@link ClientCache.CachedTablesRaw }
     *     
     */
    public ClientCache.CachedTablesRaw getCachedTablesRaw() {
        return cachedTablesRaw;
    }

    /**
     * Sets the value of the cachedTablesRaw property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClientCache.CachedTablesRaw }
     *     
     */
    public void setCachedTablesRaw(ClientCache.CachedTablesRaw value) {
        this.cachedTablesRaw = value;
    }

    /**
     * Gets the value of the overrideHomeAreas property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfOverrideHomeAreas }
     *     
     */
    public ArrayOfOverrideHomeAreas getOverrideHomeAreas() {
        return overrideHomeAreas;
    }

    /**
     * Sets the value of the overrideHomeAreas property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfOverrideHomeAreas }
     *     
     */
    public void setOverrideHomeAreas(ArrayOfOverrideHomeAreas value) {
        this.overrideHomeAreas = value;
    }

    /**
     * Gets the value of the marketSegments property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getMarketSegments() {
        return marketSegments;
    }

    /**
     * Sets the value of the marketSegments property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setMarketSegments(ArrayOfString value) {
        this.marketSegments = value;
    }

    /**
     * Gets the value of the offerDefinitions property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfOffer }
     *     
     */
    public ArrayOfOffer getOfferDefinitions() {
        return offerDefinitions;
    }

    /**
     * Sets the value of the offerDefinitions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfOffer }
     *     
     */
    public void setOfferDefinitions(ArrayOfOffer value) {
        this.offerDefinitions = value;
    }

    /**
     * Gets the value of the versionId property.
     * 
     */
    public long getVersionId() {
        return versionId;
    }

    /**
     * Sets the value of the versionId property.
     * 
     */
    public void setVersionId(long value) {
        this.versionId = value;
    }

    /**
     * Gets the value of the balances property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfBalanceDefinition }
     *     
     */
    public ArrayOfBalanceDefinition getBalances() {
        return balances;
    }

    /**
     * Sets the value of the balances property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfBalanceDefinition }
     *     
     */
    public void setBalances(ArrayOfBalanceDefinition value) {
        this.balances = value;
    }

    /**
     * Gets the value of the accumulators property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAccumulator }
     *     
     */
    public ArrayOfAccumulator getAccumulators() {
        return accumulators;
    }

    /**
     * Sets the value of the accumulators property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAccumulator }
     *     
     */
    public void setAccumulators(ArrayOfAccumulator value) {
        this.accumulators = value;
    }

    /**
     * Gets the value of the bonusPlans property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfBonusPlan }
     *     
     */
    public ArrayOfBonusPlan getBonusPlans() {
        return bonusPlans;
    }

    /**
     * Sets the value of the bonusPlans property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfBonusPlan }
     *     
     */
    public void setBonusPlans(ArrayOfBonusPlan value) {
        this.bonusPlans = value;
    }

    /**
     * Gets the value of the discountPlans property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDiscountPlan }
     *     
     */
    public ArrayOfDiscountPlan getDiscountPlans() {
        return discountPlans;
    }

    /**
     * Sets the value of the discountPlans property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDiscountPlan }
     *     
     */
    public void setDiscountPlans(ArrayOfDiscountPlan value) {
        this.discountPlans = value;
    }

    /**
     * Gets the value of the globalPeriodicCharges property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPeriodicCharge }
     *     
     */
    public ArrayOfPeriodicCharge getGlobalPeriodicCharges() {
        return globalPeriodicCharges;
    }

    /**
     * Sets the value of the globalPeriodicCharges property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPeriodicCharge }
     *     
     */
    public void setGlobalPeriodicCharges(ArrayOfPeriodicCharge value) {
        this.globalPeriodicCharges = value;
    }

    /**
     * Gets the value of the activityDefinitions property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfActivityDefinition }
     *     
     */
    public ArrayOfActivityDefinition getActivityDefinitions() {
        return activityDefinitions;
    }

    /**
     * Sets the value of the activityDefinitions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfActivityDefinition }
     *     
     */
    public void setActivityDefinitions(ArrayOfActivityDefinition value) {
        this.activityDefinitions = value;
    }

    /**
     * Gets the value of the unitTypes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfUnitType }
     *     
     */
    public ArrayOfUnitType getUnitTypes() {
        return unitTypes;
    }

    /**
     * Sets the value of the unitTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfUnitType }
     *     
     */
    public void setUnitTypes(ArrayOfUnitType value) {
        this.unitTypes = value;
    }

    /**
     * Gets the value of the classesOfService property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfClassOfService }
     *     
     */
    public ArrayOfClassOfService getClassesOfService() {
        return classesOfService;
    }

    /**
     * Sets the value of the classesOfService property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfClassOfService }
     *     
     */
    public void setClassesOfService(ArrayOfClassOfService value) {
        this.classesOfService = value;
    }

    /**
     * Gets the value of the accessNumber property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getAccessNumber() {
        return accessNumber;
    }

    /**
     * Sets the value of the accessNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setAccessNumber(ArrayOfString value) {
        this.accessNumber = value;
    }

    /**
     * Gets the value of the applicationName property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getApplicationName() {
        return applicationName;
    }

    /**
     * Sets the value of the applicationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setApplicationName(ArrayOfString value) {
        this.applicationName = value;
    }

    /**
     * Gets the value of the barredNumber property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getBarredNumber() {
        return barredNumber;
    }

    /**
     * Sets the value of the barredNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setBarredNumber(ArrayOfString value) {
        this.barredNumber = value;
    }

    /**
     * Gets the value of the emergencyNumber property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getEmergencyNumber() {
        return emergencyNumber;
    }

    /**
     * Sets the value of the emergencyNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setEmergencyNumber(ArrayOfString value) {
        this.emergencyNumber = value;
    }

    /**
     * Gets the value of the languageName property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getLanguageName() {
        return languageName;
    }

    /**
     * Sets the value of the languageName property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setLanguageName(ArrayOfString value) {
        this.languageName = value;
    }

    /**
     * Gets the value of the timezoneName property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getTimezoneName() {
        return timezoneName;
    }

    /**
     * Sets the value of the timezoneName property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setTimezoneName(ArrayOfString value) {
        this.timezoneName = value;
    }

    /**
     * Gets the value of the subscriberStateName property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getSubscriberStateName() {
        return subscriberStateName;
    }

    /**
     * Sets the value of the subscriberStateName property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setSubscriberStateName(ArrayOfString value) {
        this.subscriberStateName = value;
    }

    /**
     * Gets the value of the rechargeCardStateName property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getRechargeCardStateName() {
        return rechargeCardStateName;
    }

    /**
     * Sets the value of the rechargeCardStateName property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setRechargeCardStateName(ArrayOfString value) {
        this.rechargeCardStateName = value;
    }

    /**
     * Gets the value of the serviceProviderName property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getServiceProviderName() {
        return serviceProviderName;
    }

    /**
     * Sets the value of the serviceProviderName property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setServiceProviderName(ArrayOfString value) {
        this.serviceProviderName = value;
    }

    /**
     * Gets the value of the currencyUnitName property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCurrencyUnit }
     *     
     */
    public ArrayOfCurrencyUnit getCurrencyUnitName() {
        return currencyUnitName;
    }

    /**
     * Sets the value of the currencyUnitName property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCurrencyUnit }
     *     
     */
    public void setCurrencyUnitName(ArrayOfCurrencyUnit value) {
        this.currencyUnitName = value;
    }

    /**
     * Gets the value of the callingCircleGroups property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getCallingCircleGroups() {
        return callingCircleGroups;
    }

    /**
     * Sets the value of the callingCircleGroups property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setCallingCircleGroups(ArrayOfString value) {
        this.callingCircleGroups = value;
    }

    /**
     * Gets the value of the barredNumberSets property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getBarredNumberSets() {
        return barredNumberSets;
    }

    /**
     * Sets the value of the barredNumberSets property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setBarredNumberSets(ArrayOfString value) {
        this.barredNumberSets = value;
    }

    /**
     * Gets the value of the loyaltyBonusPlans property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLoyaltyBonusPlan }
     *     
     */
    public ArrayOfLoyaltyBonusPlan getLoyaltyBonusPlans() {
        return loyaltyBonusPlans;
    }

    /**
     * Sets the value of the loyaltyBonusPlans property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLoyaltyBonusPlan }
     *     
     */
    public void setLoyaltyBonusPlans(ArrayOfLoyaltyBonusPlan value) {
        this.loyaltyBonusPlans = value;
    }

    /**
     * Gets the value of the overrideOffers property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAlcsOverrideDefinition }
     *     
     */
    public ArrayOfAlcsOverrideDefinition getOverrideOffers() {
        return overrideOffers;
    }

    /**
     * Sets the value of the overrideOffers property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAlcsOverrideDefinition }
     *     
     */
    public void setOverrideOffers(ArrayOfAlcsOverrideDefinition value) {
        this.overrideOffers = value;
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
    public static class CachedTablesRaw {

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
