
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PostpaidDeltaBalance complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PostpaidDeltaBalance"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DeltaBalances" type="{http://comverse-in.com/prepaid/ccws}ArrayOfDeltaBalance" minOccurs="0"/&gt;
 *         &lt;element name="InvoiceAmounts" type="{http://comverse-in.com/prepaid/ccws}ArrayOfInvoiceAmount" minOccurs="0"/&gt;
 *         &lt;element name="DepositAmount" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="TotalAmt" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PostpaidDeltaBalance", propOrder = {
    "deltaBalances",
    "invoiceAmounts",
    "depositAmount",
    "totalAmt"
})
public class PostpaidDeltaBalance {

    @XmlElement(name = "DeltaBalances")
    protected ArrayOfDeltaBalance deltaBalances;
    @XmlElement(name = "InvoiceAmounts")
    protected ArrayOfInvoiceAmount invoiceAmounts;
    @XmlElement(name = "DepositAmount")
    protected double depositAmount;
    @XmlElement(name = "TotalAmt")
    protected double totalAmt;

    /**
     * Gets the value of the deltaBalances property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDeltaBalance }
     *     
     */
    public ArrayOfDeltaBalance getDeltaBalances() {
        return deltaBalances;
    }

    /**
     * Sets the value of the deltaBalances property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDeltaBalance }
     *     
     */
    public void setDeltaBalances(ArrayOfDeltaBalance value) {
        this.deltaBalances = value;
    }

    /**
     * Gets the value of the invoiceAmounts property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfInvoiceAmount }
     *     
     */
    public ArrayOfInvoiceAmount getInvoiceAmounts() {
        return invoiceAmounts;
    }

    /**
     * Sets the value of the invoiceAmounts property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfInvoiceAmount }
     *     
     */
    public void setInvoiceAmounts(ArrayOfInvoiceAmount value) {
        this.invoiceAmounts = value;
    }

    /**
     * Gets the value of the depositAmount property.
     * 
     */
    public double getDepositAmount() {
        return depositAmount;
    }

    /**
     * Sets the value of the depositAmount property.
     * 
     */
    public void setDepositAmount(double value) {
        this.depositAmount = value;
    }

    /**
     * Gets the value of the totalAmt property.
     * 
     */
    public double getTotalAmt() {
        return totalAmt;
    }

    /**
     * Sets the value of the totalAmt property.
     * 
     */
    public void setTotalAmt(double value) {
        this.totalAmt = value;
    }

}
