
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CircleMember complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CircleMember"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="position" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="subscriber" type="{http://comverse-in.com/prepaid/ccws}SubscriberBasic" minOccurs="0"/&gt;
 *         &lt;element name="nonRTBS" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CircleMember", propOrder = {
    "position",
    "subscriber",
    "nonRTBS"
})
public class CircleMember {

    protected int position;
    protected SubscriberBasic subscriber;
    protected boolean nonRTBS;

    /**
     * Gets the value of the position property.
     * 
     */
    public int getPosition() {
        return position;
    }

    /**
     * Sets the value of the position property.
     * 
     */
    public void setPosition(int value) {
        this.position = value;
    }

    /**
     * Gets the value of the subscriber property.
     * 
     * @return
     *     possible object is
     *     {@link SubscriberBasic }
     *     
     */
    public SubscriberBasic getSubscriber() {
        return subscriber;
    }

    /**
     * Sets the value of the subscriber property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriberBasic }
     *     
     */
    public void setSubscriber(SubscriberBasic value) {
        this.subscriber = value;
    }

    /**
     * Gets the value of the nonRTBS property.
     * 
     */
    public boolean isNonRTBS() {
        return nonRTBS;
    }

    /**
     * Sets the value of the nonRTBS property.
     * 
     */
    public void setNonRTBS(boolean value) {
        this.nonRTBS = value;
    }

}
