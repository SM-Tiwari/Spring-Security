
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SubscriberModify complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubscriberModify"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://comverse-in.com/prepaid/ccws}SubscriberBase"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PeriodicCharges" type="{http://comverse-in.com/prepaid/ccws}ArrayOfSubscriberPeriodicCharge" minOccurs="0"/&gt;
 *         &lt;element name="DeleteSubscriberPeriodicCharges" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="Subscriber" type="{http://comverse-in.com/prepaid/ccws}SubscriberPPS" minOccurs="0"/&gt;
 *         &lt;element name="SubscriberSpecialHomeArea" type="{http://comverse-in.com/prepaid/ccws}SubscriberSpecialHome" minOccurs="0"/&gt;
 *         &lt;element name="SubscriberHappyHours" type="{http://comverse-in.com/prepaid/ccws}SubscriberHappyHour" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubscriberModify", propOrder = {
    "periodicCharges",
    "deleteSubscriberPeriodicCharges",
    "subscriber",
    "subscriberSpecialHomeArea",
    "subscriberHappyHours"
})
public class SubscriberModify
    extends SubscriberBase
{

    @XmlElement(name = "PeriodicCharges")
    protected ArrayOfSubscriberPeriodicCharge periodicCharges;
    @XmlElement(name = "DeleteSubscriberPeriodicCharges")
    protected boolean deleteSubscriberPeriodicCharges;
    @XmlElement(name = "Subscriber")
    protected SubscriberPPS subscriber;
    @XmlElement(name = "SubscriberSpecialHomeArea")
    protected SubscriberSpecialHome subscriberSpecialHomeArea;
    @XmlElement(name = "SubscriberHappyHours")
    protected SubscriberHappyHour subscriberHappyHours;

    /**
     * Gets the value of the periodicCharges property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSubscriberPeriodicCharge }
     *     
     */
    public ArrayOfSubscriberPeriodicCharge getPeriodicCharges() {
        return periodicCharges;
    }

    /**
     * Sets the value of the periodicCharges property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSubscriberPeriodicCharge }
     *     
     */
    public void setPeriodicCharges(ArrayOfSubscriberPeriodicCharge value) {
        this.periodicCharges = value;
    }

    /**
     * Gets the value of the deleteSubscriberPeriodicCharges property.
     * 
     */
    public boolean isDeleteSubscriberPeriodicCharges() {
        return deleteSubscriberPeriodicCharges;
    }

    /**
     * Sets the value of the deleteSubscriberPeriodicCharges property.
     * 
     */
    public void setDeleteSubscriberPeriodicCharges(boolean value) {
        this.deleteSubscriberPeriodicCharges = value;
    }

    /**
     * Gets the value of the subscriber property.
     * 
     * @return
     *     possible object is
     *     {@link SubscriberPPS }
     *     
     */
    public SubscriberPPS getSubscriber() {
        return subscriber;
    }

    /**
     * Sets the value of the subscriber property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriberPPS }
     *     
     */
    public void setSubscriber(SubscriberPPS value) {
        this.subscriber = value;
    }

    /**
     * Gets the value of the subscriberSpecialHomeArea property.
     * 
     * @return
     *     possible object is
     *     {@link SubscriberSpecialHome }
     *     
     */
    public SubscriberSpecialHome getSubscriberSpecialHomeArea() {
        return subscriberSpecialHomeArea;
    }

    /**
     * Sets the value of the subscriberSpecialHomeArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriberSpecialHome }
     *     
     */
    public void setSubscriberSpecialHomeArea(SubscriberSpecialHome value) {
        this.subscriberSpecialHomeArea = value;
    }

    /**
     * Gets the value of the subscriberHappyHours property.
     * 
     * @return
     *     possible object is
     *     {@link SubscriberHappyHour }
     *     
     */
    public SubscriberHappyHour getSubscriberHappyHours() {
        return subscriberHappyHours;
    }

    /**
     * Sets the value of the subscriberHappyHours property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriberHappyHour }
     *     
     */
    public void setSubscriberHappyHours(SubscriberHappyHour value) {
        this.subscriberHappyHours = value;
    }

}
