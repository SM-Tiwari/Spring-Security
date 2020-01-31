
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
 *         &lt;element name="ForgiveSubscriberDebtResult" type="{http://comverse-in.com/prepaid/ccws}ForgiveSubscriberDebtResponse" minOccurs="0"/&gt;
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
    "forgiveSubscriberDebtResult"
})
@XmlRootElement(name = "ForgiveSubscriberDebtResponse")
public class ForgiveSubscriberDebtResponse {

    @XmlElement(name = "ForgiveSubscriberDebtResult")
    protected ForgiveSubscriberDebtResponse2 forgiveSubscriberDebtResult;

    /**
     * Gets the value of the forgiveSubscriberDebtResult property.
     * 
     * @return
     *     possible object is
     *     {@link ForgiveSubscriberDebtResponse2 }
     *     
     */
    public ForgiveSubscriberDebtResponse2 getForgiveSubscriberDebtResult() {
        return forgiveSubscriberDebtResult;
    }

    /**
     * Sets the value of the forgiveSubscriberDebtResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ForgiveSubscriberDebtResponse2 }
     *     
     */
    public void setForgiveSubscriberDebtResult(ForgiveSubscriberDebtResponse2 value) {
        this.forgiveSubscriberDebtResult = value;
    }

}
