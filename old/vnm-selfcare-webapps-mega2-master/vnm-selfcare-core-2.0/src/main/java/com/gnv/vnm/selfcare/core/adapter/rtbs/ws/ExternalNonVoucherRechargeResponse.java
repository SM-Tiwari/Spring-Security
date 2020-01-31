
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
 *         &lt;element name="ExternalNonVoucherRechargeResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
    "externalNonVoucherRechargeResult"
})
@XmlRootElement(name = "ExternalNonVoucherRechargeResponse")
public class ExternalNonVoucherRechargeResponse {

    @XmlElement(name = "ExternalNonVoucherRechargeResult")
    protected boolean externalNonVoucherRechargeResult;

    /**
     * Gets the value of the externalNonVoucherRechargeResult property.
     * 
     */
    public boolean isExternalNonVoucherRechargeResult() {
        return externalNonVoucherRechargeResult;
    }

    /**
     * Sets the value of the externalNonVoucherRechargeResult property.
     * 
     */
    public void setExternalNonVoucherRechargeResult(boolean value) {
        this.externalNonVoucherRechargeResult = value;
    }

}
