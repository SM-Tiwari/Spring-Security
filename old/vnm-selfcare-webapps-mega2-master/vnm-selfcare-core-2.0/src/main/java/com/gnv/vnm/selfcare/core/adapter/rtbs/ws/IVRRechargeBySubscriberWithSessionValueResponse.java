
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
 *         &lt;element name="IVRRechargeBySubscriberWithSessionValueResult" type="{http://comverse-in.com/prepaid/ccws}IVRDeltaBalanceWithSessionValueResponse" minOccurs="0"/&gt;
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
    "ivrRechargeBySubscriberWithSessionValueResult"
})
@XmlRootElement(name = "IVRRechargeBySubscriberWithSessionValueResponse")
public class IVRRechargeBySubscriberWithSessionValueResponse {

    @XmlElement(name = "IVRRechargeBySubscriberWithSessionValueResult")
    protected IVRDeltaBalanceWithSessionValueResponse ivrRechargeBySubscriberWithSessionValueResult;

    /**
     * Gets the value of the ivrRechargeBySubscriberWithSessionValueResult property.
     * 
     * @return
     *     possible object is
     *     {@link IVRDeltaBalanceWithSessionValueResponse }
     *     
     */
    public IVRDeltaBalanceWithSessionValueResponse getIVRRechargeBySubscriberWithSessionValueResult() {
        return ivrRechargeBySubscriberWithSessionValueResult;
    }

    /**
     * Sets the value of the ivrRechargeBySubscriberWithSessionValueResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link IVRDeltaBalanceWithSessionValueResponse }
     *     
     */
    public void setIVRRechargeBySubscriberWithSessionValueResult(IVRDeltaBalanceWithSessionValueResponse value) {
        this.ivrRechargeBySubscriberWithSessionValueResult = value;
    }

}
