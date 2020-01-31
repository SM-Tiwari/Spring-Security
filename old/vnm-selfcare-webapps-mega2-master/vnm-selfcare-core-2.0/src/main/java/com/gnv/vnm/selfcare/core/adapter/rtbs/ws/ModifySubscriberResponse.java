
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
 *         &lt;element name="ModifySubscriberResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
    "modifySubscriberResult"
})
@XmlRootElement(name = "ModifySubscriberResponse")
public class ModifySubscriberResponse {

    @XmlElement(name = "ModifySubscriberResult")
    protected boolean modifySubscriberResult;

    /**
     * Gets the value of the modifySubscriberResult property.
     * 
     */
    public boolean isModifySubscriberResult() {
        return modifySubscriberResult;
    }

    /**
     * Sets the value of the modifySubscriberResult property.
     * 
     */
    public void setModifySubscriberResult(boolean value) {
        this.modifySubscriberResult = value;
    }

}
