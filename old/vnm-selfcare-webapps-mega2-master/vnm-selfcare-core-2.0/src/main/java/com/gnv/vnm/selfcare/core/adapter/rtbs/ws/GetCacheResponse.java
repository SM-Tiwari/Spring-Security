
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
 *         &lt;element name="GetCacheResult" type="{http://comverse-in.com/prepaid/ccws}ClientCache" minOccurs="0"/&gt;
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
    "getCacheResult"
})
@XmlRootElement(name = "GetCacheResponse")
public class GetCacheResponse {

    @XmlElement(name = "GetCacheResult")
    protected ClientCache getCacheResult;

    /**
     * Gets the value of the getCacheResult property.
     * 
     * @return
     *     possible object is
     *     {@link ClientCache }
     *     
     */
    public ClientCache getGetCacheResult() {
        return getCacheResult;
    }

    /**
     * Sets the value of the getCacheResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClientCache }
     *     
     */
    public void setGetCacheResult(ClientCache value) {
        this.getCacheResult = value;
    }

}
