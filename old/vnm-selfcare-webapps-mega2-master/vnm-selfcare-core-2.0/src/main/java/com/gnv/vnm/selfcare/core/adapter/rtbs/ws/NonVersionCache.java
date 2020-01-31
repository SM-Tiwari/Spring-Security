
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NonVersionCache complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NonVersionCache"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ChargeCode" type="{http://comverse-in.com/prepaid/ccws}ArrayOfString" minOccurs="0"/&gt;
 *         &lt;element name="GlobalIdentities" type="{http://comverse-in.com/prepaid/ccws}ArrayOfIdentity" minOccurs="0"/&gt;
 *         &lt;element name="ServiceParameters" type="{http://comverse-in.com/prepaid/ccws}ArrayOfServiceParameter" minOccurs="0"/&gt;
 *         &lt;element name="RangeMap" type="{http://comverse-in.com/prepaid/ccws}ArrayOfRange" minOccurs="0"/&gt;
 *         &lt;element name="PPSParameters" type="{http://comverse-in.com/prepaid/ccws}ArrayOfServiceParameter" minOccurs="0"/&gt;
 *         &lt;element name="CurrencyConversion" type="{http://comverse-in.com/prepaid/ccws}ArrayOfCurrencyConversion" minOccurs="0"/&gt;
 *         &lt;element name="PasswordCharacteristics" type="{http://comverse-in.com/prepaid/ccws}PasswordCharacteristics" minOccurs="0"/&gt;
 *         &lt;element name="LoyaltyBonusScale" type="{http://comverse-in.com/prepaid/ccws}ArrayOfLoyaltyBonusScale" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NonVersionCache", propOrder = {
    "chargeCode",
    "globalIdentities",
    "serviceParameters",
    "rangeMap",
    "ppsParameters",
    "currencyConversion",
    "passwordCharacteristics",
    "loyaltyBonusScale"
})
public class NonVersionCache {

    @XmlElement(name = "ChargeCode")
    protected ArrayOfString chargeCode;
    @XmlElement(name = "GlobalIdentities")
    protected ArrayOfIdentity globalIdentities;
    @XmlElement(name = "ServiceParameters")
    protected ArrayOfServiceParameter serviceParameters;
    @XmlElement(name = "RangeMap")
    protected ArrayOfRange rangeMap;
    @XmlElement(name = "PPSParameters")
    protected ArrayOfServiceParameter ppsParameters;
    @XmlElement(name = "CurrencyConversion")
    protected ArrayOfCurrencyConversion currencyConversion;
    @XmlElement(name = "PasswordCharacteristics")
    protected PasswordCharacteristics passwordCharacteristics;
    @XmlElement(name = "LoyaltyBonusScale")
    protected ArrayOfLoyaltyBonusScale loyaltyBonusScale;

    /**
     * Gets the value of the chargeCode property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getChargeCode() {
        return chargeCode;
    }

    /**
     * Sets the value of the chargeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setChargeCode(ArrayOfString value) {
        this.chargeCode = value;
    }

    /**
     * Gets the value of the globalIdentities property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIdentity }
     *     
     */
    public ArrayOfIdentity getGlobalIdentities() {
        return globalIdentities;
    }

    /**
     * Sets the value of the globalIdentities property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIdentity }
     *     
     */
    public void setGlobalIdentities(ArrayOfIdentity value) {
        this.globalIdentities = value;
    }

    /**
     * Gets the value of the serviceParameters property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfServiceParameter }
     *     
     */
    public ArrayOfServiceParameter getServiceParameters() {
        return serviceParameters;
    }

    /**
     * Sets the value of the serviceParameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfServiceParameter }
     *     
     */
    public void setServiceParameters(ArrayOfServiceParameter value) {
        this.serviceParameters = value;
    }

    /**
     * Gets the value of the rangeMap property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRange }
     *     
     */
    public ArrayOfRange getRangeMap() {
        return rangeMap;
    }

    /**
     * Sets the value of the rangeMap property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRange }
     *     
     */
    public void setRangeMap(ArrayOfRange value) {
        this.rangeMap = value;
    }

    /**
     * Gets the value of the ppsParameters property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfServiceParameter }
     *     
     */
    public ArrayOfServiceParameter getPPSParameters() {
        return ppsParameters;
    }

    /**
     * Sets the value of the ppsParameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfServiceParameter }
     *     
     */
    public void setPPSParameters(ArrayOfServiceParameter value) {
        this.ppsParameters = value;
    }

    /**
     * Gets the value of the currencyConversion property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCurrencyConversion }
     *     
     */
    public ArrayOfCurrencyConversion getCurrencyConversion() {
        return currencyConversion;
    }

    /**
     * Sets the value of the currencyConversion property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCurrencyConversion }
     *     
     */
    public void setCurrencyConversion(ArrayOfCurrencyConversion value) {
        this.currencyConversion = value;
    }

    /**
     * Gets the value of the passwordCharacteristics property.
     * 
     * @return
     *     possible object is
     *     {@link PasswordCharacteristics }
     *     
     */
    public PasswordCharacteristics getPasswordCharacteristics() {
        return passwordCharacteristics;
    }

    /**
     * Sets the value of the passwordCharacteristics property.
     * 
     * @param value
     *     allowed object is
     *     {@link PasswordCharacteristics }
     *     
     */
    public void setPasswordCharacteristics(PasswordCharacteristics value) {
        this.passwordCharacteristics = value;
    }

    /**
     * Gets the value of the loyaltyBonusScale property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLoyaltyBonusScale }
     *     
     */
    public ArrayOfLoyaltyBonusScale getLoyaltyBonusScale() {
        return loyaltyBonusScale;
    }

    /**
     * Sets the value of the loyaltyBonusScale property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLoyaltyBonusScale }
     *     
     */
    public void setLoyaltyBonusScale(ArrayOfLoyaltyBonusScale value) {
        this.loyaltyBonusScale = value;
    }

}
