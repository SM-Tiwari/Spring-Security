
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
 *         &lt;element name="IVRChangeLanguageResult" type="{http://comverse-in.com/prepaid/ccws}IVRChangeLanguageResponse" minOccurs="0"/&gt;
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
    "ivrChangeLanguageResult"
})
@XmlRootElement(name = "IVRChangeLanguageResponse")
public class IVRChangeLanguageResponse {

    @XmlElement(name = "IVRChangeLanguageResult")
    protected IVRChangeLanguageResponse2 ivrChangeLanguageResult;

    /**
     * Gets the value of the ivrChangeLanguageResult property.
     * 
     * @return
     *     possible object is
     *     {@link IVRChangeLanguageResponse2 }
     *     
     */
    public IVRChangeLanguageResponse2 getIVRChangeLanguageResult() {
        return ivrChangeLanguageResult;
    }

    /**
     * Sets the value of the ivrChangeLanguageResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link IVRChangeLanguageResponse2 }
     *     
     */
    public void setIVRChangeLanguageResult(IVRChangeLanguageResponse2 value) {
        this.ivrChangeLanguageResult = value;
    }

}
