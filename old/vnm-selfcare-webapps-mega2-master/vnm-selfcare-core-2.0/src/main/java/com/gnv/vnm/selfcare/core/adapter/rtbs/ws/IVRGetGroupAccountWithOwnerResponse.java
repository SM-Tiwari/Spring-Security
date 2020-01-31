
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
 *         &lt;element name="IVRGetGroupAccountWithOwnerResult" type="{http://comverse-in.com/prepaid/ccws}IVRGetGroupAccountWithOwnerResponse" minOccurs="0"/&gt;
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
    "ivrGetGroupAccountWithOwnerResult"
})
@XmlRootElement(name = "IVRGetGroupAccountWithOwnerResponse")
public class IVRGetGroupAccountWithOwnerResponse {

    @XmlElement(name = "IVRGetGroupAccountWithOwnerResult")
    protected IVRGetGroupAccountWithOwnerResponse2 ivrGetGroupAccountWithOwnerResult;

    /**
     * Gets the value of the ivrGetGroupAccountWithOwnerResult property.
     * 
     * @return
     *     possible object is
     *     {@link IVRGetGroupAccountWithOwnerResponse2 }
     *     
     */
    public IVRGetGroupAccountWithOwnerResponse2 getIVRGetGroupAccountWithOwnerResult() {
        return ivrGetGroupAccountWithOwnerResult;
    }

    /**
     * Sets the value of the ivrGetGroupAccountWithOwnerResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link IVRGetGroupAccountWithOwnerResponse2 }
     *     
     */
    public void setIVRGetGroupAccountWithOwnerResult(IVRGetGroupAccountWithOwnerResponse2 value) {
        this.ivrGetGroupAccountWithOwnerResult = value;
    }

}
