
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

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
 *         &lt;element name="PromisedPaymentResult" type="{http://comverse-in.com/prepaid/ccws}PromisedPaymentResponse" minOccurs="0"/&gt;
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
    "promisedPaymentResult"
})
@XmlRootElement(name = "PromisedPaymentResponse")
public class PromisedPaymentResponse {

    @XmlElement(name = "PromisedPaymentResult")
    protected PromisedPaymentResponse2 promisedPaymentResult;

    /**
     * Gets the value of the promisedPaymentResult property.
     * 
     * @return
     *     possible object is
     *     {@link PromisedPaymentResponse2 }
     *     
     */
    public PromisedPaymentResponse2 getPromisedPaymentResult() {
        return promisedPaymentResult;
    }

    /**
     * Sets the value of the promisedPaymentResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link PromisedPaymentResponse2 }
     *     
     */
    public void setPromisedPaymentResult(PromisedPaymentResponse2 value) {
        this.promisedPaymentResult = value;
    }

}
