
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for BalanceEntityBase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BalanceEntityBase"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Balance" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="AccountExpiration" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="BalanceName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NextMaximumSpendingLimit" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="TotalSpendingLimit" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BalanceEntityBase", propOrder = {
    "balance",
    "accountExpiration",
    "balanceName",
    "nextMaximumSpendingLimit",
    "totalSpendingLimit"
})
@XmlSeeAlso({
    BalanceEntity.class
})
public class BalanceEntityBase {

    @XmlElement(name = "Balance")
    protected double balance;
    @XmlElement(name = "AccountExpiration", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar accountExpiration;
    @XmlElement(name = "BalanceName")
    protected String balanceName;
    @XmlElement(name = "NextMaximumSpendingLimit")
    protected double nextMaximumSpendingLimit;
    @XmlElement(name = "TotalSpendingLimit")
    protected double totalSpendingLimit;

    /**
     * Gets the value of the balance property.
     * 
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets the value of the balance property.
     * 
     */
    public void setBalance(double value) {
        this.balance = value;
    }

    /**
     * Gets the value of the accountExpiration property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAccountExpiration() {
        return accountExpiration;
    }

    /**
     * Sets the value of the accountExpiration property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAccountExpiration(XMLGregorianCalendar value) {
        this.accountExpiration = value;
    }

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
     * Gets the value of the nextMaximumSpendingLimit property.
     * 
     */
    public double getNextMaximumSpendingLimit() {
        return nextMaximumSpendingLimit;
    }

    /**
     * Sets the value of the nextMaximumSpendingLimit property.
     * 
     */
    public void setNextMaximumSpendingLimit(double value) {
        this.nextMaximumSpendingLimit = value;
    }

    /**
     * Gets the value of the totalSpendingLimit property.
     * 
     */
    public double getTotalSpendingLimit() {
        return totalSpendingLimit;
    }

    /**
     * Sets the value of the totalSpendingLimit property.
     * 
     */
    public void setTotalSpendingLimit(double value) {
        this.totalSpendingLimit = value;
    }

}
