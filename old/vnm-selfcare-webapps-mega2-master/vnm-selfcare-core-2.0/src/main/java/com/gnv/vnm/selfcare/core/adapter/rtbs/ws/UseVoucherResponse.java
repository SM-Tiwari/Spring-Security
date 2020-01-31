
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
 *         &lt;element name="UseVoucherResult" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
    "useVoucherResult"
})
@XmlRootElement(name = "UseVoucherResponse")
public class UseVoucherResponse {

    @XmlElement(name = "UseVoucherResult")
    protected int useVoucherResult;

    /**
     * Gets the value of the useVoucherResult property.
     * 
     */
    public int getUseVoucherResult() {
        return useVoucherResult;
    }

    /**
     * Sets the value of the useVoucherResult property.
     * 
     */
    public void setUseVoucherResult(int value) {
        this.useVoucherResult = value;
    }

}