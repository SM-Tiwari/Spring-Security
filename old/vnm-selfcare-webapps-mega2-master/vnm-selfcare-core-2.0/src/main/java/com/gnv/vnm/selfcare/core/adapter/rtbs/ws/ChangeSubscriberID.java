
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="oldSubscriberID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="newSubscriberID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "oldSubscriberID",
    "newSubscriberID"
})
@XmlRootElement(name = "ChangeSubscriberID")
public class ChangeSubscriberID {

    protected String oldSubscriberID;
    protected String newSubscriberID;

    /**
     * Gets the value of the oldSubscriberID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOldSubscriberID() {
        return oldSubscriberID;
    }

    /**
     * Sets the value of the oldSubscriberID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOldSubscriberID(String value) {
        this.oldSubscriberID = value;
    }

    /**
     * Gets the value of the newSubscriberID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewSubscriberID() {
        return newSubscriberID;
    }

    /**
     * Sets the value of the newSubscriberID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewSubscriberID(String value) {
        this.newSubscriberID = value;
    }

}
