
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LoyaltyBonusScale complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LoyaltyBonusScale"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="loyaltyBonusScaleID" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="loyaltyBonusScaleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="loyaltyAwardLevel" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="loyaltySubscriptionMonth" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoyaltyBonusScale", propOrder = {
    "loyaltyBonusScaleID",
    "loyaltyBonusScaleName",
    "loyaltyAwardLevel",
    "loyaltySubscriptionMonth"
})
public class LoyaltyBonusScale {

    protected int loyaltyBonusScaleID;
    protected String loyaltyBonusScaleName;
    protected int loyaltyAwardLevel;
    protected int loyaltySubscriptionMonth;

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
     * Gets the value of the loyaltyBonusScaleName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoyaltyBonusScaleName() {
        return loyaltyBonusScaleName;
    }

    /**
     * Sets the value of the loyaltyBonusScaleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoyaltyBonusScaleName(String value) {
        this.loyaltyBonusScaleName = value;
    }

    /**
     * Gets the value of the loyaltyAwardLevel property.
     * 
     */
    public int getLoyaltyAwardLevel() {
        return loyaltyAwardLevel;
    }

    /**
     * Sets the value of the loyaltyAwardLevel property.
     * 
     */
    public void setLoyaltyAwardLevel(int value) {
        this.loyaltyAwardLevel = value;
    }

    /**
     * Gets the value of the loyaltySubscriptionMonth property.
     * 
     */
    public int getLoyaltySubscriptionMonth() {
        return loyaltySubscriptionMonth;
    }

    /**
     * Sets the value of the loyaltySubscriptionMonth property.
     * 
     */
    public void setLoyaltySubscriptionMonth(int value) {
        this.loyaltySubscriptionMonth = value;
    }

}
