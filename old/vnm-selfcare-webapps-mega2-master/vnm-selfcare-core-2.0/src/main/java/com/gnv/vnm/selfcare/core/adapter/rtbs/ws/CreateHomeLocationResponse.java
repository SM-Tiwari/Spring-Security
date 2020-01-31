
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
 *         &lt;element name="CreateHomeLocationResult" type="{http://comverse-in.com/prepaid/ccws}HomeLocationResponse" minOccurs="0"/&gt;
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
    "createHomeLocationResult"
})
@XmlRootElement(name = "CreateHomeLocationResponse")
public class CreateHomeLocationResponse {

    @XmlElement(name = "CreateHomeLocationResult")
    protected HomeLocationResponse createHomeLocationResult;

    /**
     * Gets the value of the createHomeLocationResult property.
     * 
     * @return
     *     possible object is
     *     {@link HomeLocationResponse }
     *     
     */
    public HomeLocationResponse getCreateHomeLocationResult() {
        return createHomeLocationResult;
    }

    /**
     * Sets the value of the createHomeLocationResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link HomeLocationResponse }
     *     
     */
    public void setCreateHomeLocationResult(HomeLocationResponse value) {
        this.createHomeLocationResult = value;
    }

}
