
package com.gnv.vnm.selfcare.core.adapter.upcc.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SInSubscriberGroupMemberQuotaParaVO complex type.
 * 
 * <p>The following schema fragment specifies the expected result contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SInSubscriberGroupMemberQuotaParaVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="subscriber" type="{rm:type}SPccSubscriber"/>
 *         &lt;element name="subscriberGroupMemberQuota" type="{rm:type}SSubscriberGroupMemberQuota" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SInSubscriberGroupMemberQuotaParaVO", propOrder = {
    "subscriber",
    "subscriberGroupMemberQuota"
})
public class SInSubscriberGroupMemberQuotaParaVO {

    @XmlElement(required = true)
    protected SPccSubscriber subscriber;
    protected SSubscriberGroupMemberQuota subscriberGroupMemberQuota;

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
     * Gets the value of the subscriberGroupMemberQuota property.
     * 
     * @return
     *     possible object is
     *     {@link SSubscriberGroupMemberQuota }
     *     
     */
    public SSubscriberGroupMemberQuota getSubscriberGroupMemberQuota() {
        return subscriberGroupMemberQuota;
    }

    /**
     * Sets the value of the subscriberGroupMemberQuota property.
     * 
     * @param value
     *     allowed object is
     *     {@link SSubscriberGroupMemberQuota }
     *     
     */
    public void setSubscriberGroupMemberQuota(SSubscriberGroupMemberQuota value) {
        this.subscriberGroupMemberQuota = value;
    }

}
