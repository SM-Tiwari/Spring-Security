
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="subscriberID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="identity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="subCreditBalances" type="{http://comverse-in.com/prepaid/ccws}ArrayOfBalanceCreditAccount" minOccurs="0"/&gt;
 *         &lt;element name="balanceChangeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="balanceChangeComment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "subscriberID",
    "identity",
    "subCreditBalances",
    "balanceChangeCode",
    "balanceChangeComment"
})
@XmlRootElement(name = "CreditAccount")
public class CreditAccount {

    protected String subscriberID;
    protected String identity;
    protected ArrayOfBalanceCreditAccount subCreditBalances;
    protected String balanceChangeCode;
    protected String balanceChangeComment;

    /**
     * Gets the value of the subscriberID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscriberID() {
        return subscriberID;
    }

    /**
     * Sets the value of the subscriberID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubscriberID(String value) {
        this.subscriberID = value;
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
     * Gets the value of the subCreditBalances property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfBalanceCreditAccount }
     *     
     */
    public ArrayOfBalanceCreditAccount getSubCreditBalances() {
        return subCreditBalances;
    }

    /**
     * Sets the value of the subCreditBalances property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfBalanceCreditAccount }
     *     
     */
    public void setSubCreditBalances(ArrayOfBalanceCreditAccount value) {
        this.subCreditBalances = value;
    }

    /**
     * Gets the value of the balanceChangeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBalanceChangeCode() {
        return balanceChangeCode;
    }

    /**
     * Sets the value of the balanceChangeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBalanceChangeCode(String value) {
        this.balanceChangeCode = value;
    }

    /**
     * Gets the value of the balanceChangeComment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBalanceChangeComment() {
        return balanceChangeComment;
    }

    /**
     * Sets the value of the balanceChangeComment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBalanceChangeComment(String value) {
        this.balanceChangeComment = value;
    }

}
