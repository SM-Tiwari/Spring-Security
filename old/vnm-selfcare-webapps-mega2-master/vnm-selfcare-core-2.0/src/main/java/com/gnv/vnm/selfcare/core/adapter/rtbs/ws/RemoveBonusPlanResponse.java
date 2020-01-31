
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
 *         &lt;element name="RemoveBonusPlanResult" type="{http://comverse-in.com/prepaid/ccws}RemoveBonusPlanResponse" minOccurs="0"/&gt;
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
    "removeBonusPlanResult"
})
@XmlRootElement(name = "RemoveBonusPlanResponse")
public class RemoveBonusPlanResponse {

    @XmlElement(name = "RemoveBonusPlanResult")
    protected RemoveBonusPlanResponse2 removeBonusPlanResult;

    /**
     * Gets the value of the removeBonusPlanResult property.
     * 
     * @return
     *     possible object is
     *     {@link RemoveBonusPlanResponse2 }
     *     
     */
    public RemoveBonusPlanResponse2 getRemoveBonusPlanResult() {
        return removeBonusPlanResult;
    }

    /**
     * Sets the value of the removeBonusPlanResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link RemoveBonusPlanResponse2 }
     *     
     */
    public void setRemoveBonusPlanResult(RemoveBonusPlanResponse2 value) {
        this.removeBonusPlanResult = value;
    }

}
