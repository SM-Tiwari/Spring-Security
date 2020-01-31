
package com.gnv.vnm.selfcare.core.adapter.vasman.ws;

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
 *         &lt;element name="in0" type="{http://vasman.elcom.com}ProvisioningDynamicServiceReq"/&gt;
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
    "in0"
})
@XmlRootElement(name = "dynamicServiceProvisioning")
public class DynamicServiceProvisioning {

    @XmlElement(required = true, nillable = true)
    protected ProvisioningDynamicServiceReq in0;

    /**
     * Gets the value of the in0 property.
     * 
     * @return
     *     possible object is
     *     {@link ProvisioningDynamicServiceReq }
     *     
     */
    public ProvisioningDynamicServiceReq getIn0() {
        return in0;
    }

    /**
     * Sets the value of the in0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProvisioningDynamicServiceReq }
     *     
     */
    public void setIn0(ProvisioningDynamicServiceReq value) {
        this.in0 = value;
    }

}