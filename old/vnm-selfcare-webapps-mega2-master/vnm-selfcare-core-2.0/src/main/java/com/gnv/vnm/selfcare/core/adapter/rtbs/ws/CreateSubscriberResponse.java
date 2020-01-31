
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
 *         &lt;element name="CreateSubscriberResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
    "createSubscriberResult"
})
@XmlRootElement(name = "CreateSubscriberResponse")
public class CreateSubscriberResponse {

    @XmlElement(name = "CreateSubscriberResult")
    protected boolean createSubscriberResult;

    /**
     * Gets the value of the createSubscriberResult property.
     * 
     */
    public boolean isCreateSubscriberResult() {
        return createSubscriberResult;
    }

    /**
     * Sets the value of the createSubscriberResult property.
     * 
     */
    public void setCreateSubscriberResult(boolean value) {
        this.createSubscriberResult = value;
    }

}
