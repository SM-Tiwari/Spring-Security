
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
 *         &lt;element name="GetGlobalIdentitiesResult" type="{http://comverse-in.com/prepaid/ccws}ArrayOfIdentity" minOccurs="0"/&gt;
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
    "getGlobalIdentitiesResult"
})
@XmlRootElement(name = "GetGlobalIdentitiesResponse")
public class GetGlobalIdentitiesResponse {

    @XmlElement(name = "GetGlobalIdentitiesResult")
    protected ArrayOfIdentity getGlobalIdentitiesResult;

    /**
     * Gets the value of the getGlobalIdentitiesResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIdentity }
     *     
     */
    public ArrayOfIdentity getGetGlobalIdentitiesResult() {
        return getGlobalIdentitiesResult;
    }

    /**
     * Sets the value of the getGlobalIdentitiesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIdentity }
     *     
     */
    public void setGetGlobalIdentitiesResult(ArrayOfIdentity value) {
        this.getGlobalIdentitiesResult = value;
    }

}
