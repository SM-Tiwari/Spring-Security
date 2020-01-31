
package com.gnv.vnm.selfcare.core.adapter.loyalty.ws;

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
 *         &lt;element name="out" type="{http://loyalty.elcom.com}LoyaltyResp"/&gt;
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
    "out"
})
@XmlRootElement(name = "redeemPointResponse", namespace = "http://iwebservice.nms.com")
public class RedeemPointResponse {

    @XmlElement(namespace = "http://iwebservice.nms.com", required = true, nillable = true)
    protected LoyaltyResp out;

    /**
     * Gets the value of the out property.
     * 
     * @return
     *     possible object is
     *     {@link LoyaltyResp }
     *     
     */
    public LoyaltyResp getOut() {
        return out;
    }

    /**
     * Sets the value of the out property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoyaltyResp }
     *     
     */
    public void setOut(LoyaltyResp value) {
        this.out = value;
    }

}