
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IVRGetGroupAccountWithOwnerResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IVRGetGroupAccountWithOwnerResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GroupAccountRetrieve" type="{http://comverse-in.com/prepaid/ccws}GroupAccountRetrieve" minOccurs="0"/&gt;
 *         &lt;element name="SubscriberRetrieve" type="{http://comverse-in.com/prepaid/ccws}SubscriberRetrieve" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IVRGetGroupAccountWithOwnerResponse", propOrder = {
    "groupAccountRetrieve",
    "subscriberRetrieve"
})
public class IVRGetGroupAccountWithOwnerResponse2 {

    @XmlElement(name = "GroupAccountRetrieve")
    protected GroupAccountRetrieve groupAccountRetrieve;
    @XmlElement(name = "SubscriberRetrieve")
    protected SubscriberRetrieve subscriberRetrieve;

    /**
     * Gets the value of the groupAccountRetrieve property.
     * 
     * @return
     *     possible object is
     *     {@link GroupAccountRetrieve }
     *     
     */
    public GroupAccountRetrieve getGroupAccountRetrieve() {
        return groupAccountRetrieve;
    }

    /**
     * Sets the value of the groupAccountRetrieve property.
     * 
     * @param value
     *     allowed object is
     *     {@link GroupAccountRetrieve }
     *     
     */
    public void setGroupAccountRetrieve(GroupAccountRetrieve value) {
        this.groupAccountRetrieve = value;
    }

    /**
     * Gets the value of the subscriberRetrieve property.
     * 
     * @return
     *     possible object is
     *     {@link SubscriberRetrieve }
     *     
     */
    public SubscriberRetrieve getSubscriberRetrieve() {
        return subscriberRetrieve;
    }

    /**
     * Sets the value of the subscriberRetrieve property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriberRetrieve }
     *     
     */
    public void setSubscriberRetrieve(SubscriberRetrieve value) {
        this.subscriberRetrieve = value;
    }

}
