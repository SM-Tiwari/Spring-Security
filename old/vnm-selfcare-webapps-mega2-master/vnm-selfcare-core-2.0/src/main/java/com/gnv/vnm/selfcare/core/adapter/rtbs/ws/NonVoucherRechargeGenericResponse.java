
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
 *         &lt;element name="NonVoucherRechargeGenericResult" type="{http://comverse-in.com/prepaid/ccws}NonVoucherRechargeResponse" minOccurs="0"/&gt;
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
    "nonVoucherRechargeGenericResult"
})
@XmlRootElement(name = "NonVoucherRechargeGenericResponse")
public class NonVoucherRechargeGenericResponse {

    @XmlElement(name = "NonVoucherRechargeGenericResult")
    protected NonVoucherRechargeResponse2 nonVoucherRechargeGenericResult;

    /**
     * Gets the value of the nonVoucherRechargeGenericResult property.
     * 
     * @return
     *     possible object is
     *     {@link NonVoucherRechargeResponse2 }
     *     
     */
    public NonVoucherRechargeResponse2 getNonVoucherRechargeGenericResult() {
        return nonVoucherRechargeGenericResult;
    }

    /**
     * Sets the value of the nonVoucherRechargeGenericResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link NonVoucherRechargeResponse2 }
     *     
     */
    public void setNonVoucherRechargeGenericResult(NonVoucherRechargeResponse2 value) {
        this.nonVoucherRechargeGenericResult = value;
    }

}
