
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
 *         &lt;element name="DeleteCallingCircleResult" type="{http://comverse-in.com/prepaid/ccws}DeleteCallingCircleResponse" minOccurs="0"/&gt;
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
    "deleteCallingCircleResult"
})
@XmlRootElement(name = "DeleteCallingCircleResponse")
public class DeleteCallingCircleResponse {

    @XmlElement(name = "DeleteCallingCircleResult")
    protected DeleteCallingCircleResponse2 deleteCallingCircleResult;

    /**
     * Gets the value of the deleteCallingCircleResult property.
     * 
     * @return
     *     possible object is
     *     {@link DeleteCallingCircleResponse2 }
     *     
     */
    public DeleteCallingCircleResponse2 getDeleteCallingCircleResult() {
        return deleteCallingCircleResult;
    }

    /**
     * Sets the value of the deleteCallingCircleResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeleteCallingCircleResponse2 }
     *     
     */
    public void setDeleteCallingCircleResult(DeleteCallingCircleResponse2 value) {
        this.deleteCallingCircleResult = value;
    }

}
