
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
 *         &lt;element name="GetServiceParametersResult" type="{http://comverse-in.com/prepaid/ccws}ArrayOfServiceParameter" minOccurs="0"/&gt;
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
    "getServiceParametersResult"
})
@XmlRootElement(name = "GetServiceParametersResponse")
public class GetServiceParametersResponse {

    @XmlElement(name = "GetServiceParametersResult")
    protected ArrayOfServiceParameter getServiceParametersResult;

    /**
     * Gets the value of the getServiceParametersResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfServiceParameter }
     *     
     */
    public ArrayOfServiceParameter getGetServiceParametersResult() {
        return getServiceParametersResult;
    }

    /**
     * Sets the value of the getServiceParametersResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfServiceParameter }
     *     
     */
    public void setGetServiceParametersResult(ArrayOfServiceParameter value) {
        this.getServiceParametersResult = value;
    }

}
