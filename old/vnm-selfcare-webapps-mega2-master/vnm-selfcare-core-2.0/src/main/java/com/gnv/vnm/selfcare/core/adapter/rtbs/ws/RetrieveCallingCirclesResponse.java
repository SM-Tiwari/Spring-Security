
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
 *         &lt;element name="RetrieveCallingCirclesResult" type="{http://comverse-in.com/prepaid/ccws}RetrieveCallingCirclesResponse" minOccurs="0"/&gt;
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
    "retrieveCallingCirclesResult"
})
@XmlRootElement(name = "RetrieveCallingCirclesResponse")
public class RetrieveCallingCirclesResponse {

    @XmlElement(name = "RetrieveCallingCirclesResult")
    protected RetrieveCallingCirclesResponse2 retrieveCallingCirclesResult;

    /**
     * Gets the value of the retrieveCallingCirclesResult property.
     * 
     * @return
     *     possible object is
     *     {@link RetrieveCallingCirclesResponse2 }
     *     
     */
    public RetrieveCallingCirclesResponse2 getRetrieveCallingCirclesResult() {
        return retrieveCallingCirclesResult;
    }

    /**
     * Sets the value of the retrieveCallingCirclesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link RetrieveCallingCirclesResponse2 }
     *     
     */
    public void setRetrieveCallingCirclesResult(RetrieveCallingCirclesResponse2 value) {
        this.retrieveCallingCirclesResult = value;
    }

}
