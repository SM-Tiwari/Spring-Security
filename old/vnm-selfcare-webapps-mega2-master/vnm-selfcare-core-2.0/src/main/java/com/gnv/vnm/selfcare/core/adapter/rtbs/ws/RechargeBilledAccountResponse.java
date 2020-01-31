
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
 *         &lt;element name="RechargeBilledAccountResult" type="{http://comverse-in.com/prepaid/ccws}PostpaidDeltaBalance" minOccurs="0"/&gt;
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
    "rechargeBilledAccountResult"
})
@XmlRootElement(name = "RechargeBilledAccountResponse")
public class RechargeBilledAccountResponse {

    @XmlElement(name = "RechargeBilledAccountResult")
    protected PostpaidDeltaBalance rechargeBilledAccountResult;

    /**
     * Gets the value of the rechargeBilledAccountResult property.
     * 
     * @return
     *     possible object is
     *     {@link PostpaidDeltaBalance }
     *     
     */
    public PostpaidDeltaBalance getRechargeBilledAccountResult() {
        return rechargeBilledAccountResult;
    }

    /**
     * Sets the value of the rechargeBilledAccountResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link PostpaidDeltaBalance }
     *     
     */
    public void setRechargeBilledAccountResult(PostpaidDeltaBalance value) {
        this.rechargeBilledAccountResult = value;
    }

}
