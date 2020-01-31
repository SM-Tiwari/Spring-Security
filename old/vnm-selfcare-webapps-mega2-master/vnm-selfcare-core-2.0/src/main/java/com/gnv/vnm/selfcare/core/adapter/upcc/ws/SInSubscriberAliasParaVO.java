
package com.gnv.vnm.selfcare.core.adapter.upcc.ws;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SInSubscriberAliasParaVO complex type.
 * 
 * <p>The following schema fragment specifies the expected result contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SInSubscriberAliasParaVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="subscriber" type="{rm:type}SPccSubscriber"/>
 *         &lt;element name="subscriberAlias" type="{rm:type}SSubscriberAlias" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SInSubscriberAliasParaVO", propOrder = {
    "subscriber",
    "subscriberAlias"
})
public class SInSubscriberAliasParaVO {

    @XmlElement(required = true)
    protected SPccSubscriber subscriber;
    protected List<SSubscriberAlias> subscriberAlias;

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
     * Gets the value of the subscriberAlias property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subscriberAlias property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubscriberAlias().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SSubscriberAlias }
     * 
     * 
     */
    public List<SSubscriberAlias> getSubscriberAlias() {
        if (subscriberAlias == null) {
            subscriberAlias = new ArrayList<SSubscriberAlias>();
        }
        return this.subscriberAlias;
    }

}
