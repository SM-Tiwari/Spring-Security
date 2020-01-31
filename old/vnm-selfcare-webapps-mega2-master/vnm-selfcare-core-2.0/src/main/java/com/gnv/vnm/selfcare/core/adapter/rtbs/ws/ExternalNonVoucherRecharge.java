
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="subscriberId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="identity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="rechValue" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="rechDays" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="rechComm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="INSwitchID" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="currencyConversionRate" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
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
    "subscriberId",
    "identity",
    "rechValue",
    "rechDays",
    "rechComm",
    "inSwitchID",
    "currencyConversionRate"
})
@XmlRootElement(name = "ExternalNonVoucherRecharge")
public class ExternalNonVoucherRecharge {

    protected String subscriberId;
    protected String identity;
    protected double rechValue;
    protected int rechDays;
    protected String rechComm;
    @XmlElement(name = "INSwitchID")
    protected int inSwitchID;
    @XmlElement(required = true)
    protected BigDecimal currencyConversionRate;

    /**
     * Gets the value of the subscriberId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscriberId() {
        return subscriberId;
    }

    /**
     * Sets the value of the subscriberId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubscriberId(String value) {
        this.subscriberId = value;
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
     * Gets the value of the rechValue property.
     * 
     */
    public double getRechValue() {
        return rechValue;
    }

    /**
     * Sets the value of the rechValue property.
     * 
     */
    public void setRechValue(double value) {
        this.rechValue = value;
    }

    /**
     * Gets the value of the rechDays property.
     * 
     */
    public int getRechDays() {
        return rechDays;
    }

    /**
     * Sets the value of the rechDays property.
     * 
     */
    public void setRechDays(int value) {
        this.rechDays = value;
    }

    /**
     * Gets the value of the rechComm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRechComm() {
        return rechComm;
    }

    /**
     * Sets the value of the rechComm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRechComm(String value) {
        this.rechComm = value;
    }

    /**
     * Gets the value of the inSwitchID property.
     * 
     */
    public int getINSwitchID() {
        return inSwitchID;
    }

    /**
     * Sets the value of the inSwitchID property.
     * 
     */
    public void setINSwitchID(int value) {
        this.inSwitchID = value;
    }

    /**
     * Gets the value of the currencyConversionRate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCurrencyConversionRate() {
        return currencyConversionRate;
    }

    /**
     * Sets the value of the currencyConversionRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCurrencyConversionRate(BigDecimal value) {
        this.currencyConversionRate = value;
    }

}
