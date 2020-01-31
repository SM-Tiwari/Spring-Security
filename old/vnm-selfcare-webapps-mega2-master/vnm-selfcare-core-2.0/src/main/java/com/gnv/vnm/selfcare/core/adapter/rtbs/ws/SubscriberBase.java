
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SubscriberBase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubscriberBase"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://comverse-in.com/prepaid/ccws}SubscriberBasic"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SubscriberHome" type="{http://comverse-in.com/prepaid/ccws}SubscriberHome" minOccurs="0"/&gt;
 *         &lt;element name="SubscriberInfo" type="{http://comverse-in.com/prepaid/ccws}SubscriberInfo" minOccurs="0"/&gt;
 *         &lt;element name="SubscriberPhoneBook" type="{http://comverse-in.com/prepaid/ccws}SubscriberPB" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubscriberBase", propOrder = {
    "subscriberHome",
    "subscriberInfo",
    "subscriberPhoneBook"
})
@XmlSeeAlso({
    SubscriberModify.class,
    SubscriberCreate.class,
    SubscriberRetrieve.class
})
public abstract class SubscriberBase
    extends SubscriberBasic
{

    @XmlElement(name = "SubscriberHome")
    protected SubscriberHome subscriberHome;
    @XmlElement(name = "SubscriberInfo")
    protected SubscriberInfo subscriberInfo;
    @XmlElement(name = "SubscriberPhoneBook")
    protected SubscriberPB subscriberPhoneBook;

    /**
     * Gets the value of the subscriberHome property.
     * 
     * @return
     *     possible object is
     *     {@link SubscriberHome }
     *     
     */
    public SubscriberHome getSubscriberHome() {
        return subscriberHome;
    }

    /**
     * Sets the value of the subscriberHome property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriberHome }
     *     
     */
    public void setSubscriberHome(SubscriberHome value) {
        this.subscriberHome = value;
    }

    /**
     * Gets the value of the subscriberInfo property.
     * 
     * @return
     *     possible object is
     *     {@link SubscriberInfo }
     *     
     */
    public SubscriberInfo getSubscriberInfo() {
        return subscriberInfo;
    }

    /**
     * Sets the value of the subscriberInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriberInfo }
     *     
     */
    public void setSubscriberInfo(SubscriberInfo value) {
        this.subscriberInfo = value;
    }

    /**
     * Gets the value of the subscriberPhoneBook property.
     * 
     * @return
     *     possible object is
     *     {@link SubscriberPB }
     *     
     */
    public SubscriberPB getSubscriberPhoneBook() {
        return subscriberPhoneBook;
    }

    /**
     * Sets the value of the subscriberPhoneBook property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriberPB }
     *     
     */
    public void setSubscriberPhoneBook(SubscriberPB value) {
        this.subscriberPhoneBook = value;
    }

}
