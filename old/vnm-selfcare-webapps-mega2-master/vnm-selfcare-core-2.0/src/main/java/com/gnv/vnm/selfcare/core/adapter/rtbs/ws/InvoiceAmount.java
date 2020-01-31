
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InvoiceAmount complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InvoiceAmount"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="InvoiceID" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="InvoiceAmt" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InvoiceAmount", propOrder = {
    "invoiceID",
    "invoiceAmt"
})
public class InvoiceAmount {

    @XmlElement(name = "InvoiceID")
    protected long invoiceID;
    @XmlElement(name = "InvoiceAmt")
    protected double invoiceAmt;

    /**
     * Gets the value of the invoiceID property.
     * 
     */
    public long getInvoiceID() {
        return invoiceID;
    }

    /**
     * Sets the value of the invoiceID property.
     * 
     */
    public void setInvoiceID(long value) {
        this.invoiceID = value;
    }

    /**
     * Gets the value of the invoiceAmt property.
     * 
     */
    public double getInvoiceAmt() {
        return invoiceAmt;
    }

    /**
     * Sets the value of the invoiceAmt property.
     * 
     */
    public void setInvoiceAmt(double value) {
        this.invoiceAmt = value;
    }

}
