
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BalanceEntity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BalanceEntity"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://comverse-in.com/prepaid/ccws}BalanceEntityBase"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AvailableBalance" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="FundsType" type="{http://comverse-in.com/prepaid/ccws}FundsType"/&gt;
 *         &lt;element name="MaximumSpendingLimit" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="AvailableSpendingLimit" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="PrecisionPoint" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="ExclusiveBalance" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BalanceEntity", propOrder = {
    "availableBalance",
    "fundsType",
    "maximumSpendingLimit",
    "availableSpendingLimit",
    "precisionPoint",
    "exclusiveBalance"
})
public class BalanceEntity
    extends BalanceEntityBase
{

    @XmlElement(name = "AvailableBalance")
    protected double availableBalance;
    @XmlElement(name = "FundsType", required = true)
    @XmlSchemaType(name = "string")
    protected FundsType fundsType;
    @XmlElement(name = "MaximumSpendingLimit")
    protected double maximumSpendingLimit;
    @XmlElement(name = "AvailableSpendingLimit")
    protected double availableSpendingLimit;
    @XmlElement(name = "PrecisionPoint")
    protected int precisionPoint;
    @XmlElement(name = "ExclusiveBalance")
    protected boolean exclusiveBalance;

    /**
     * Gets the value of the availableBalance property.
     * 
     */
    public double getAvailableBalance() {
        return availableBalance;
    }

    /**
     * Sets the value of the availableBalance property.
     * 
     */
    public void setAvailableBalance(double value) {
        this.availableBalance = value;
    }

    /**
     * Gets the value of the fundsType property.
     * 
     * @return
     *     possible object is
     *     {@link FundsType }
     *     
     */
    public FundsType getFundsType() {
        return fundsType;
    }

    /**
     * Sets the value of the fundsType property.
     * 
     * @param value
     *     allowed object is
     *     {@link FundsType }
     *     
     */
    public void setFundsType(FundsType value) {
        this.fundsType = value;
    }

    /**
     * Gets the value of the maximumSpendingLimit property.
     * 
     */
    public double getMaximumSpendingLimit() {
        return maximumSpendingLimit;
    }

    /**
     * Sets the value of the maximumSpendingLimit property.
     * 
     */
    public void setMaximumSpendingLimit(double value) {
        this.maximumSpendingLimit = value;
    }

    /**
     * Gets the value of the availableSpendingLimit property.
     * 
     */
    public double getAvailableSpendingLimit() {
        return availableSpendingLimit;
    }

    /**
     * Sets the value of the availableSpendingLimit property.
     * 
     */
    public void setAvailableSpendingLimit(double value) {
        this.availableSpendingLimit = value;
    }

    /**
     * Gets the value of the precisionPoint property.
     * 
     */
    public int getPrecisionPoint() {
        return precisionPoint;
    }

    /**
     * Sets the value of the precisionPoint property.
     * 
     */
    public void setPrecisionPoint(int value) {
        this.precisionPoint = value;
    }

    /**
     * Gets the value of the exclusiveBalance property.
     * 
     */
    public boolean isExclusiveBalance() {
        return exclusiveBalance;
    }

    /**
     * Sets the value of the exclusiveBalance property.
     * 
     */
    public void setExclusiveBalance(boolean value) {
        this.exclusiveBalance = value;
    }

}
