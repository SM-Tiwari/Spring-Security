
package com.gnv.vnm.selfcare.core.adapter.upcc.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SInASubscribeResetQuotaParaVO complex type.
 * 
 * <p>The following schema fragment specifies the expected result contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SInASubscribeResetQuotaParaVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="subscriber" type="{rm:type}SPccSubscriber"/>
 *         &lt;element name="subscriberQuota" type="{rm:type}SSubscriberQuota"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SInASubscribeResetQuotaParaVO", propOrder = {
    "subscriber",
    "subscriberQuota"
})
public class SInASubscribeResetQuotaParaVO {

    @XmlElement(required = true)
    protected SPccSubscriber subscriber;
    @XmlElement(required = true)
    protected SSubscriberQuota subscriberQuota;

    /**
     * Gets the value of the subscriber property.
     * 
     * @return
     *     possible object is
     *     {@link SPccSubscriber }
     *     
     */
    public SPccSubscriber getSubscriber() {
        return subscriber;
    }

    /**
     * Sets the value of the subscriber property.
     * 
     * @param value
     *     allowed object is
     *     {@link SPccSubscriber }
     *     
     */
    public void setSubscriber(SPccSubscriber value) {
        this.subscriber = value;
    }

    /**
     * Gets the value of the subscriberQuota property.
     * 
     * @return
     *     possible object is
     *     {@link SSubscriberQuota }
     *     
     */
    public SSubscriberQuota getSubscriberQuota() {
        return subscriberQuota;
    }

    /**
     * Sets the value of the subscriberQuota property.
     * 
     * @param value
     *     allowed object is
     *     {@link SSubscriberQuota }
     *     
     */
    public void setSubscriberQuota(SSubscriberQuota value) {
        this.subscriberQuota = value;
    }

}
