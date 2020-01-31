
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
 *         &lt;element name="UnReserveVoucherResult" type="{http://comverse-in.com/prepaid/ccws}VoucherEntity" minOccurs="0"/&gt;
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
    "unReserveVoucherResult"
})
@XmlRootElement(name = "UnReserveVoucherResponse")
public class UnReserveVoucherResponse {

    @XmlElement(name = "UnReserveVoucherResult")
    protected VoucherEntity unReserveVoucherResult;

    /**
     * Gets the value of the unReserveVoucherResult property.
     * 
     * @return
     *     possible object is
     *     {@link VoucherEntity }
     *     
     */
    public VoucherEntity getUnReserveVoucherResult() {
        return unReserveVoucherResult;
    }

    /**
     * Sets the value of the unReserveVoucherResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link VoucherEntity }
     *     
     */
    public void setUnReserveVoucherResult(VoucherEntity value) {
        this.unReserveVoucherResult = value;
    }

}
