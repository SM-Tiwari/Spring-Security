
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BalanceDefinition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BalanceDefinition"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="balanceName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="balanceId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="unitTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IsCoreBalance" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="IsCurrencyBalance" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="anncTypeId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BalanceDefinition", propOrder = {
    "balanceName",
    "balanceId",
    "unitTypeName",
    "isCoreBalance",
    "isCurrencyBalance",
    "anncTypeId"
})
public class BalanceDefinition {

    protected String balanceName;
    protected int balanceId;
    protected String unitTypeName;
    @XmlElement(name = "IsCoreBalance")
    protected boolean isCoreBalance;
    @XmlElement(name = "IsCurrencyBalance")
    protected boolean isCurrencyBalance;
    protected long anncTypeId;

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
     * Gets the value of the balanceId property.
     * 
     */
    public int getBalanceId() {
        return balanceId;
    }

    /**
     * Sets the value of the balanceId property.
     * 
     */
    public void setBalanceId(int value) {
        this.balanceId = value;
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
     * Gets the value of the isCoreBalance property.
     * 
     */
    public boolean isIsCoreBalance() {
        return isCoreBalance;
    }

    /**
     * Sets the value of the isCoreBalance property.
     * 
     */
    public void setIsCoreBalance(boolean value) {
        this.isCoreBalance = value;
    }

    /**
     * Gets the value of the isCurrencyBalance property.
     * 
     */
    public boolean isIsCurrencyBalance() {
        return isCurrencyBalance;
    }

    /**
     * Sets the value of the isCurrencyBalance property.
     * 
     */
    public void setIsCurrencyBalance(boolean value) {
        this.isCurrencyBalance = value;
    }

    /**
     * Gets the value of the anncTypeId property.
     * 
     */
    public long getAnncTypeId() {
        return anncTypeId;
    }

    /**
     * Sets the value of the anncTypeId property.
     * 
     */
    public void setAnncTypeId(long value) {
        this.anncTypeId = value;
    }

}
