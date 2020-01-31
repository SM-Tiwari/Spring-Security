
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
 *         &lt;element name="RemovePreferredNumberFromSubscriberResult" type="{http://comverse-in.com/prepaid/ccws}PreferredNumberResponse" minOccurs="0"/&gt;
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
    "removePreferredNumberFromSubscriberResult"
})
@XmlRootElement(name = "RemovePreferredNumberFromSubscriberResponse")
public class RemovePreferredNumberFromSubscriberResponse {

    @XmlElement(name = "RemovePreferredNumberFromSubscriberResult")
    protected PreferredNumberResponse removePreferredNumberFromSubscriberResult;

    /**
     * Gets the value of the removePreferredNumberFromSubscriberResult property.
     * 
     * @return
     *     possible object is
     *     {@link PreferredNumberResponse }
     *     
     */
    public PreferredNumberResponse getRemovePreferredNumberFromSubscriberResult() {
        return removePreferredNumberFromSubscriberResult;
    }

    /**
     * Sets the value of the removePreferredNumberFromSubscriberResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link PreferredNumberResponse }
     *     
     */
    public void setRemovePreferredNumberFromSubscriberResult(PreferredNumberResponse value) {
        this.removePreferredNumberFromSubscriberResult = value;
    }

}
