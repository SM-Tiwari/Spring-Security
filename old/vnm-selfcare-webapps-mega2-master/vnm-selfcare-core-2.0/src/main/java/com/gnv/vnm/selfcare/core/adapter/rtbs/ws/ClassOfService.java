
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
 * <p>Java class for ClassOfService complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClassOfService"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cosName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cosCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cosFriendsANDFamily" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="bonusPlanName" type="{http://comverse-in.com/prepaid/ccws}ArrayOfString" minOccurs="0"/&gt;
 *         &lt;element name="discountPlanName" type="{http://comverse-in.com/prepaid/ccws}ArrayOfString" minOccurs="0"/&gt;
 *         &lt;element name="accumulators" type="{http://comverse-in.com/prepaid/ccws}ArrayOfCosAccumulator" minOccurs="0"/&gt;
 *         &lt;element name="cosBalanceOrder" type="{http://comverse-in.com/prepaid/ccws}ArrayOfCosBalanceOrder" minOccurs="0"/&gt;
 *         &lt;element name="cosPeriodicCharges" type="{http://comverse-in.com/prepaid/ccws}ArrayOfPeriodicCharge" minOccurs="0"/&gt;
 *         &lt;element name="subscriberFinalStateName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="currencyUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="expirationType" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="rechargeAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="serviceFeeActive" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="serviceType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="preCallThreshold" type="{http://comverse-in.com/prepaid/ccws}ArrayOfPreCallThreshold" minOccurs="0"/&gt;
 *         &lt;element name="cosFriends" type="{http://comverse-in.com/prepaid/ccws}ArrayOfCOSFriend" minOccurs="0"/&gt;
 *         &lt;element name="rechargeLimit" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="multipleVouchers" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="LifeCycles" type="{http://comverse-in.com/prepaid/ccws}ArrayOfLifeCycle" minOccurs="0"/&gt;
 *         &lt;element name="ServiceProvider" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CompatibleOffers" type="{http://comverse-in.com/prepaid/ccws}ArrayOfString" minOccurs="0"/&gt;
 *         &lt;element name="MarketSegments" type="{http://comverse-in.com/prepaid/ccws}ArrayOfString" minOccurs="0"/&gt;
 *         &lt;element name="preferredNumberFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="HomeZoneFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PlayHomeZoneToneFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ExtensionData" type="{http://comverse-in.com/prepaid/ccws}CLASSOFSERVICEEXTENSIONDATA" minOccurs="0"/&gt;
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
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClassOfService", propOrder = {
    "cosName",
    "cosCode",
    "cosFriendsANDFamily",
    "bonusPlanName",
    "discountPlanName",
    "accumulators",
    "cosBalanceOrder",
    "cosPeriodicCharges",
    "subscriberFinalStateName",
    "currencyUnit",
    "description",
    "expirationType",
    "rechargeAllowed",
    "serviceFeeActive",
    "serviceType",
    "preCallThreshold",
    "cosFriends",
    "rechargeLimit",
    "multipleVouchers",
    "lifeCycles",
    "serviceProvider",
    "compatibleOffers",
    "marketSegments",
    "preferredNumberFlag",
    "homeZoneFlag",
    "playHomeZoneToneFlag",
    "extensionData",
    "extensionDataRaw"
})
public class ClassOfService {

    protected String cosName;
    protected String cosCode;
    protected int cosFriendsANDFamily;
    protected ArrayOfString bonusPlanName;
    protected ArrayOfString discountPlanName;
    protected ArrayOfCosAccumulator accumulators;
    protected ArrayOfCosBalanceOrder cosBalanceOrder;
    protected ArrayOfPeriodicCharge cosPeriodicCharges;
    protected String subscriberFinalStateName;
    protected String currencyUnit;
    protected String description;
    protected int expirationType;
    protected boolean rechargeAllowed;
    protected boolean serviceFeeActive;
    protected String serviceType;
    protected ArrayOfPreCallThreshold preCallThreshold;
    protected ArrayOfCOSFriend cosFriends;
    protected double rechargeLimit;
    protected boolean multipleVouchers;
    @XmlElement(name = "LifeCycles")
    protected ArrayOfLifeCycle lifeCycles;
    @XmlElement(name = "ServiceProvider")
    protected String serviceProvider;
    @XmlElement(name = "CompatibleOffers")
    protected ArrayOfString compatibleOffers;
    @XmlElement(name = "MarketSegments")
    protected ArrayOfString marketSegments;
    protected String preferredNumberFlag;
    @XmlElement(name = "HomeZoneFlag")
    protected String homeZoneFlag;
    @XmlElement(name = "PlayHomeZoneToneFlag")
    protected String playHomeZoneToneFlag;
    @XmlElement(name = "ExtensionData")
    protected CLASSOFSERVICEEXTENSIONDATA extensionData;
    @XmlElement(name = "ExtensionDataRaw")
    protected ClassOfService.ExtensionDataRaw extensionDataRaw;

    /**
     * Gets the value of the cosName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCosName() {
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
    public void setCosName(String value) {
        this.cosName = value;
    }

    /**
     * Gets the value of the cosCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCosCode() {
        return cosCode;
    }

    /**
     * Sets the value of the cosCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCosCode(String value) {
        this.cosCode = value;
    }

    /**
     * Gets the value of the cosFriendsANDFamily property.
     * 
     */
    public int getCosFriendsANDFamily() {
        return cosFriendsANDFamily;
    }

    /**
     * Sets the value of the cosFriendsANDFamily property.
     * 
     */
    public void setCosFriendsANDFamily(int value) {
        this.cosFriendsANDFamily = value;
    }

    /**
     * Gets the value of the bonusPlanName property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getBonusPlanName() {
        return bonusPlanName;
    }

    /**
     * Sets the value of the bonusPlanName property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setBonusPlanName(ArrayOfString value) {
        this.bonusPlanName = value;
    }

    /**
     * Gets the value of the discountPlanName property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getDiscountPlanName() {
        return discountPlanName;
    }

    /**
     * Sets the value of the discountPlanName property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setDiscountPlanName(ArrayOfString value) {
        this.discountPlanName = value;
    }

    /**
     * Gets the value of the accumulators property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCosAccumulator }
     *     
     */
    public ArrayOfCosAccumulator getAccumulators() {
        return accumulators;
    }

    /**
     * Sets the value of the accumulators property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCosAccumulator }
     *     
     */
    public void setAccumulators(ArrayOfCosAccumulator value) {
        this.accumulators = value;
    }

    /**
     * Gets the value of the cosBalanceOrder property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCosBalanceOrder }
     *     
     */
    public ArrayOfCosBalanceOrder getCosBalanceOrder() {
        return cosBalanceOrder;
    }

    /**
     * Sets the value of the cosBalanceOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCosBalanceOrder }
     *     
     */
    public void setCosBalanceOrder(ArrayOfCosBalanceOrder value) {
        this.cosBalanceOrder = value;
    }

    /**
     * Gets the value of the cosPeriodicCharges property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPeriodicCharge }
     *     
     */
    public ArrayOfPeriodicCharge getCosPeriodicCharges() {
        return cosPeriodicCharges;
    }

    /**
     * Sets the value of the cosPeriodicCharges property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPeriodicCharge }
     *     
     */
    public void setCosPeriodicCharges(ArrayOfPeriodicCharge value) {
        this.cosPeriodicCharges = value;
    }

    /**
     * Gets the value of the subscriberFinalStateName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscriberFinalStateName() {
        return subscriberFinalStateName;
    }

    /**
     * Sets the value of the subscriberFinalStateName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubscriberFinalStateName(String value) {
        this.subscriberFinalStateName = value;
    }

    /**
     * Gets the value of the currencyUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyUnit() {
        return currencyUnit;
    }

    /**
     * Sets the value of the currencyUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyUnit(String value) {
        this.currencyUnit = value;
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
     * Gets the value of the expirationType property.
     * 
     */
    public int getExpirationType() {
        return expirationType;
    }

    /**
     * Sets the value of the expirationType property.
     * 
     */
    public void setExpirationType(int value) {
        this.expirationType = value;
    }

    /**
     * Gets the value of the rechargeAllowed property.
     * 
     */
    public boolean isRechargeAllowed() {
        return rechargeAllowed;
    }

    /**
     * Sets the value of the rechargeAllowed property.
     * 
     */
    public void setRechargeAllowed(boolean value) {
        this.rechargeAllowed = value;
    }

    /**
     * Gets the value of the serviceFeeActive property.
     * 
     */
    public boolean isServiceFeeActive() {
        return serviceFeeActive;
    }

    /**
     * Sets the value of the serviceFeeActive property.
     * 
     */
    public void setServiceFeeActive(boolean value) {
        this.serviceFeeActive = value;
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
     * Gets the value of the preCallThreshold property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPreCallThreshold }
     *     
     */
    public ArrayOfPreCallThreshold getPreCallThreshold() {
        return preCallThreshold;
    }

    /**
     * Sets the value of the preCallThreshold property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPreCallThreshold }
     *     
     */
    public void setPreCallThreshold(ArrayOfPreCallThreshold value) {
        this.preCallThreshold = value;
    }

    /**
     * Gets the value of the cosFriends property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCOSFriend }
     *     
     */
    public ArrayOfCOSFriend getCosFriends() {
        return cosFriends;
    }

    /**
     * Sets the value of the cosFriends property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCOSFriend }
     *     
     */
    public void setCosFriends(ArrayOfCOSFriend value) {
        this.cosFriends = value;
    }

    /**
     * Gets the value of the rechargeLimit property.
     * 
     */
    public double getRechargeLimit() {
        return rechargeLimit;
    }

    /**
     * Sets the value of the rechargeLimit property.
     * 
     */
    public void setRechargeLimit(double value) {
        this.rechargeLimit = value;
    }

    /**
     * Gets the value of the multipleVouchers property.
     * 
     */
    public boolean isMultipleVouchers() {
        return multipleVouchers;
    }

    /**
     * Sets the value of the multipleVouchers property.
     * 
     */
    public void setMultipleVouchers(boolean value) {
        this.multipleVouchers = value;
    }

    /**
     * Gets the value of the lifeCycles property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLifeCycle }
     *     
     */
    public ArrayOfLifeCycle getLifeCycles() {
        return lifeCycles;
    }

    /**
     * Sets the value of the lifeCycles property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLifeCycle }
     *     
     */
    public void setLifeCycles(ArrayOfLifeCycle value) {
        this.lifeCycles = value;
    }

    /**
     * Gets the value of the serviceProvider property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceProvider() {
        return serviceProvider;
    }

    /**
     * Sets the value of the serviceProvider property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceProvider(String value) {
        this.serviceProvider = value;
    }

    /**
     * Gets the value of the compatibleOffers property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getCompatibleOffers() {
        return compatibleOffers;
    }

    /**
     * Sets the value of the compatibleOffers property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setCompatibleOffers(ArrayOfString value) {
        this.compatibleOffers = value;
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
     * Gets the value of the preferredNumberFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreferredNumberFlag() {
        return preferredNumberFlag;
    }

    /**
     * Sets the value of the preferredNumberFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreferredNumberFlag(String value) {
        this.preferredNumberFlag = value;
    }

    /**
     * Gets the value of the homeZoneFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHomeZoneFlag() {
        return homeZoneFlag;
    }

    /**
     * Sets the value of the homeZoneFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHomeZoneFlag(String value) {
        this.homeZoneFlag = value;
    }

    /**
     * Gets the value of the playHomeZoneToneFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlayHomeZoneToneFlag() {
        return playHomeZoneToneFlag;
    }

    /**
     * Sets the value of the playHomeZoneToneFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlayHomeZoneToneFlag(String value) {
        this.playHomeZoneToneFlag = value;
    }

    /**
     * Gets the value of the extensionData property.
     * 
     * @return
     *     possible object is
     *     {@link CLASSOFSERVICEEXTENSIONDATA }
     *     
     */
    public CLASSOFSERVICEEXTENSIONDATA getExtensionData() {
        return extensionData;
    }

    /**
     * Sets the value of the extensionData property.
     * 
     * @param value
     *     allowed object is
     *     {@link CLASSOFSERVICEEXTENSIONDATA }
     *     
     */
    public void setExtensionData(CLASSOFSERVICEEXTENSIONDATA value) {
        this.extensionData = value;
    }

    /**
     * Gets the value of the extensionDataRaw property.
     * 
     * @return
     *     possible object is
     *     {@link ClassOfService.ExtensionDataRaw }
     *     
     */
    public ClassOfService.ExtensionDataRaw getExtensionDataRaw() {
        return extensionDataRaw;
    }

    /**
     * Sets the value of the extensionDataRaw property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClassOfService.ExtensionDataRaw }
     *     
     */
    public void setExtensionDataRaw(ClassOfService.ExtensionDataRaw value) {
        this.extensionDataRaw = value;
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
