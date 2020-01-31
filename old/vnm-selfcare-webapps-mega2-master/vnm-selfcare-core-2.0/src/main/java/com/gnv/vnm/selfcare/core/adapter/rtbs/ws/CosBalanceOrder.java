
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CosBalanceOrder complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CosBalanceOrder"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="balanceName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="balanceOrder" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="initialBalance" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="maximumBalance" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="unitTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="expireOption" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="expireOffset" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="minimumBalance" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CosBalanceOrder", propOrder = {
    "balanceName",
    "balanceOrder",
    "initialBalance",
    "maximumBalance",
    "unitTypeName",
    "expireOption",
    "expireOffset",
    "minimumBalance"
})
public class CosBalanceOrder {

    protected String balanceName;
    protected long balanceOrder;
    @XmlElement(required = true)
    protected BigDecimal initialBalance;
    @XmlElement(required = true)
    protected BigDecimal maximumBalance;
    protected String unitTypeName;
    protected long expireOption;
    protected long expireOffset;
    @XmlElement(required = true)
    protected BigDecimal minimumBalance;

    /**
     * Gets the value of the balanceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBalanceName() {
        return balanceName;
    }

    /**
     * Sets the value of the balanceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBalanceName(String value) {
        this.balanceName = value;
    }

    /**
     * Gets the value of the balanceOrder property.
     * 
     */
    public long getBalanceOrder() {
        return balanceOrder;
    }

    /**
     * Sets the value of the balanceOrder property.
     * 
     */
    public void setBalanceOrder(long value) {
        this.balanceOrder = value;
    }

    /**
     * Gets the value of the initialBalance property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getInitialBalance() {
        return initialBalance;
    }

    /**
     * Sets the value of the initialBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setInitialBalance(BigDecimal value) {
        this.initialBalance = value;
    }

    /**
     * Gets the value of the maximumBalance property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMaximumBalance() {
        return maximumBalance;
    }

    /**
     * Sets the value of the maximumBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMaximumBalance(BigDecimal value) {
        this.maximumBalance = value;
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
     * Gets the value of the expireOption property.
     * 
     */
    public long getExpireOption() {
        return expireOption;
    }

    /**
     * Sets the value of the expireOption property.
     * 
     */
    public void setExpireOption(long value) {
        this.expireOption = value;
    }

    /**
     * Gets the value of the expireOffset property.
     * 
     */
    public long getExpireOffset() {
        return expireOffset;
    }

    /**
     * Sets the value of the expireOffset property.
     * 
     */
    public void setExpireOffset(long value) {
        this.expireOffset = value;
    }

    /**
     * Gets the value of the minimumBalance property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }

    /**
     * Sets the value of the minimumBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMinimumBalance(BigDecimal value) {
        this.minimumBalance = value;
    }

}
