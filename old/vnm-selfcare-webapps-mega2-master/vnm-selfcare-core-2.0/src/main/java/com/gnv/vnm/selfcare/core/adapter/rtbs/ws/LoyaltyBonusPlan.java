
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LoyaltyBonusPlan complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LoyaltyBonusPlan"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="loyaltyBonusPlanID" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="loyaltyBonusPlanName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="loyaltyBonusScaleID" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="usageAccumulatorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="loyaltyAccumulatorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="activeLengthOfTime" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="threshold" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="targetBalanceName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="currencyISO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ServiceProvider" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoyaltyBonusPlan", propOrder = {
    "loyaltyBonusPlanID",
    "loyaltyBonusPlanName",
    "loyaltyBonusScaleID",
    "usageAccumulatorName",
    "loyaltyAccumulatorName",
    "activeLengthOfTime",
    "threshold",
    "description",
    "targetBalanceName",
    "currencyISO",
    "serviceProvider"
})
public class LoyaltyBonusPlan {

    protected long loyaltyBonusPlanID;
    protected String loyaltyBonusPlanName;
    protected int loyaltyBonusScaleID;
    protected String usageAccumulatorName;
    protected String loyaltyAccumulatorName;
    protected long activeLengthOfTime;
    protected double threshold;
    @XmlElement(name = "Description")
    protected String description;
    protected String targetBalanceName;
    protected String currencyISO;
    @XmlElement(name = "ServiceProvider")
    protected String serviceProvider;

    /**
     * Gets the value of the loyaltyBonusPlanID property.
     * 
     */
    public long getLoyaltyBonusPlanID() {
        return loyaltyBonusPlanID;
    }

    /**
     * Sets the value of the loyaltyBonusPlanID property.
     * 
     */
    public void setLoyaltyBonusPlanID(long value) {
        this.loyaltyBonusPlanID = value;
    }

    /**
     * Gets the value of the loyaltyBonusPlanName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoyaltyBonusPlanName() {
        return loyaltyBonusPlanName;
    }

    /**
     * Sets the value of the loyaltyBonusPlanName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoyaltyBonusPlanName(String value) {
        this.loyaltyBonusPlanName = value;
    }

    /**
     * Gets the value of the loyaltyBonusScaleID property.
     * 
     */
    public int getLoyaltyBonusScaleID() {
        return loyaltyBonusScaleID;
    }

    /**
     * Sets the value of the loyaltyBonusScaleID property.
     * 
     */
    public void setLoyaltyBonusScaleID(int value) {
        this.loyaltyBonusScaleID = value;
    }

    /**
     * Gets the value of the usageAccumulatorName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsageAccumulatorName() {
        return usageAccumulatorName;
    }

    /**
     * Sets the value of the usageAccumulatorName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsageAccumulatorName(String value) {
        this.usageAccumulatorName = value;
    }

    /**
     * Gets the value of the loyaltyAccumulatorName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoyaltyAccumulatorName() {
        return loyaltyAccumulatorName;
    }

    /**
     * Sets the value of the loyaltyAccumulatorName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoyaltyAccumulatorName(String value) {
        this.loyaltyAccumulatorName = value;
    }

    /**
     * Gets the value of the activeLengthOfTime property.
     * 
     */
    public long getActiveLengthOfTime() {
        return activeLengthOfTime;
    }

    /**
     * Sets the value of the activeLengthOfTime property.
     * 
     */
    public void setActiveLengthOfTime(long value) {
        this.activeLengthOfTime = value;
    }

    /**
     * Gets the value of the threshold property.
     * 
     */
    public double getThreshold() {
        return threshold;
    }

    /**
     * Sets the value of the threshold property.
     * 
     */
    public void setThreshold(double value) {
        this.threshold = value;
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
     * Gets the value of the targetBalanceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetBalanceName() {
        return targetBalanceName;
    }

    /**
     * Sets the value of the targetBalanceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetBalanceName(String value) {
        this.targetBalanceName = value;
    }

    /**
     * Gets the value of the currencyISO property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyISO() {
        return currencyISO;
    }

    /**
     * Sets the value of the currencyISO property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyISO(String value) {
        this.currencyISO = value;
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

}
