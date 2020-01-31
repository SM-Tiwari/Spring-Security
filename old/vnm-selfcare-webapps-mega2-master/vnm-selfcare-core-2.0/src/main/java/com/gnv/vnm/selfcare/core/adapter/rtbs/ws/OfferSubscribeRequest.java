
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OfferSubscribeRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OfferSubscribeRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://comverse-in.com/prepaid/ccws}OfferBase"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SubscriberID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SubscriberIdentity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RCApplyDay" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OfferSubscribeRequest", propOrder = {
    "subscriberID",
    "subscriberIdentity",
    "rcApplyDay"
})
public class OfferSubscribeRequest
    extends OfferBase
{

    @XmlElement(name = "SubscriberID")
    protected String subscriberID;
    @XmlElement(name = "SubscriberIdentity")
    protected String subscriberIdentity;
    @XmlElement(name = "RCApplyDay")
    protected long rcApplyDay;

    /**
     * Gets the value of the subscriberID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscriberID() {
        return subscriberID;
    }

    /**
     * Sets the value of the subscriberID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubscriberID(String value) {
        this.subscriberID = value;
    }

    /**
     * Gets the value of the subscriberIdentity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscriberIdentity() {
        return subscriberIdentity;
    }

    /**
     * Sets the value of the subscriberIdentity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubscriberIdentity(String value) {
        this.subscriberIdentity = value;
    }

    /**
     * Gets the value of the rcApplyDay property.
     * 
     */
    public long getRCApplyDay() {
        return rcApplyDay;
    }

    /**
     * Sets the value of the rcApplyDay property.
     * 
     */
    public void setRCApplyDay(long value) {
        this.rcApplyDay = value;
    }

}
