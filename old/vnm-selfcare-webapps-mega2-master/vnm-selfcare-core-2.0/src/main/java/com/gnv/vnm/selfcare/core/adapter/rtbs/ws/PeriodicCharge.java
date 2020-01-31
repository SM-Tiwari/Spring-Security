
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PeriodicCharge complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PeriodicCharge"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="chargeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="period" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="applyDay" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="currencyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="spName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tax1" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="tax2" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="tax3" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="proratedStart" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="proratedEnd" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="mandatory" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="charge_code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="HLR_code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="currencyISO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="type" type="{http://comverse-in.com/prepaid/ccws}PeriodicChargeType"/&gt;
 *         &lt;element name="coreCharge" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="ChargeBalances" type="{http://comverse-in.com/prepaid/ccws}ArrayOfChargeBalance" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PeriodicCharge", propOrder = {
    "chargeId",
    "description",
    "period",
    "applyDay",
    "currencyName",
    "spName",
    "tax1",
    "tax2",
    "tax3",
    "proratedStart",
    "proratedEnd",
    "mandatory",
    "chargeCode",
    "hlrCode",
    "currencyISO",
    "type",
    "coreCharge",
    "chargeBalances"
})
public class PeriodicCharge {

    protected String chargeId;
    protected String description;
    protected String period;
    protected long applyDay;
    protected String currencyName;
    protected String spName;
    @XmlElement(required = true)
    protected BigDecimal tax1;
    @XmlElement(required = true)
    protected BigDecimal tax2;
    @XmlElement(required = true)
    protected BigDecimal tax3;
    protected boolean proratedStart;
    protected boolean proratedEnd;
    protected boolean mandatory;
    @XmlElement(name = "charge_code")
    protected String chargeCode;
    @XmlElement(name = "HLR_code")
    protected String hlrCode;
    protected String currencyISO;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected PeriodicChargeType type;
    protected double coreCharge;
    @XmlElement(name = "ChargeBalances")
    protected ArrayOfChargeBalance chargeBalances;

    /**
     * Gets the value of the chargeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChargeId() {
        return chargeId;
    }

    /**
     * Sets the value of the chargeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChargeId(String value) {
        this.chargeId = value;
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
     * Gets the value of the period property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeriod() {
        return period;
    }

    /**
     * Sets the value of the period property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeriod(String value) {
        this.period = value;
    }

    /**
     * Gets the value of the applyDay property.
     * 
     */
    public long getApplyDay() {
        return applyDay;
    }

    /**
     * Sets the value of the applyDay property.
     * 
     */
    public void setApplyDay(long value) {
        this.applyDay = value;
    }

    /**
     * Gets the value of the currencyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyName() {
        return currencyName;
    }

    /**
     * Sets the value of the currencyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyName(String value) {
        this.currencyName = value;
    }

    /**
     * Gets the value of the spName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpName() {
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
    public void setSpName(String value) {
        this.spName = value;
    }

    /**
     * Gets the value of the tax1 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTax1() {
        return tax1;
    }

    /**
     * Sets the value of the tax1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTax1(BigDecimal value) {
        this.tax1 = value;
    }

    /**
     * Gets the value of the tax2 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTax2() {
        return tax2;
    }

    /**
     * Sets the value of the tax2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTax2(BigDecimal value) {
        this.tax2 = value;
    }

    /**
     * Gets the value of the tax3 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTax3() {
        return tax3;
    }

    /**
     * Sets the value of the tax3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTax3(BigDecimal value) {
        this.tax3 = value;
    }

    /**
     * Gets the value of the proratedStart property.
     * 
     */
    public boolean isProratedStart() {
        return proratedStart;
    }

    /**
     * Sets the value of the proratedStart property.
     * 
     */
    public void setProratedStart(boolean value) {
        this.proratedStart = value;
    }

    /**
     * Gets the value of the proratedEnd property.
     * 
     */
    public boolean isProratedEnd() {
        return proratedEnd;
    }

    /**
     * Sets the value of the proratedEnd property.
     * 
     */
    public void setProratedEnd(boolean value) {
        this.proratedEnd = value;
    }

    /**
     * Gets the value of the mandatory property.
     * 
     */
    public boolean isMandatory() {
        return mandatory;
    }

    /**
     * Sets the value of the mandatory property.
     * 
     */
    public void setMandatory(boolean value) {
        this.mandatory = value;
    }

    /**
     * Gets the value of the chargeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChargeCode() {
        return chargeCode;
    }

    /**
     * Sets the value of the chargeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChargeCode(String value) {
        this.chargeCode = value;
    }

    /**
     * Gets the value of the hlrCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHLRCode() {
        return hlrCode;
    }

    /**
     * Sets the value of the hlrCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHLRCode(String value) {
        this.hlrCode = value;
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
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link PeriodicChargeType }
     *     
     */
    public PeriodicChargeType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodicChargeType }
     *     
     */
    public void setType(PeriodicChargeType value) {
        this.type = value;
    }

    /**
     * Gets the value of the coreCharge property.
     * 
     */
    public double getCoreCharge() {
        return coreCharge;
    }

    /**
     * Sets the value of the coreCharge property.
     * 
     */
    public void setCoreCharge(double value) {
        this.coreCharge = value;
    }

    /**
     * Gets the value of the chargeBalances property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfChargeBalance }
     *     
     */
    public ArrayOfChargeBalance getChargeBalances() {
        return chargeBalances;
    }

    /**
     * Sets the value of the chargeBalances property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfChargeBalance }
     *     
     */
    public void setChargeBalances(ArrayOfChargeBalance value) {
        this.chargeBalances = value;
    }

}
