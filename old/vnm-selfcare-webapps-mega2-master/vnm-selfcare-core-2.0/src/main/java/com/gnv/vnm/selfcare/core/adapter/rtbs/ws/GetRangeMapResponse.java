
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
 *         &lt;element name="GetRangeMapResult" type="{http://comverse-in.com/prepaid/ccws}ArrayOfRange" minOccurs="0"/&gt;
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
    "getRangeMapResult"
})
@XmlRootElement(name = "GetRangeMapResponse")
public class GetRangeMapResponse {

    @XmlElement(name = "GetRangeMapResult")
    protected ArrayOfRange getRangeMapResult;

    /**
     * Gets the value of the getRangeMapResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRange }
     *     
     */
    public ArrayOfRange getGetRangeMapResult() {
        return getRangeMapResult;
    }

    /**
     * Sets the value of the getRangeMapResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRange }
     *     
     */
    public void setGetRangeMapResult(ArrayOfRange value) {
        this.getRangeMapResult = value;
    }

}
