
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SubscriberCreate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubscriberCreate"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://comverse-in.com/prepaid/ccws}SubscriberBase"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Balances" type="{http://comverse-in.com/prepaid/ccws}ArrayOfBalanceEntityBase" minOccurs="0"/&gt;
 *         &lt;element name="Subscriber" type="{http://comverse-in.com/prepaid/ccws}SubscriberMainBase" minOccurs="0"/&gt;
 *         &lt;element name="SPName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubscriberCreate", propOrder = {
    "balances",
    "subscriber",
    "spName"
})
public class SubscriberCreate
    extends SubscriberBase
{

    @XmlElement(name = "Balances")
    protected ArrayOfBalanceEntityBase balances;
    @XmlElement(name = "Subscriber")
    protected SubscriberMainBase subscriber;
    @XmlElement(name = "SPName")
    protected String spName;

    /**
     * Gets the value of the balances property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfBalanceEntityBase }
     *     
     */
    public ArrayOfBalanceEntityBase getBalances() {
        return balances;
    }

    /**
     * Sets the value of the balances property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfBalanceEntityBase }
     *     
     */
    public void setBalances(ArrayOfBalanceEntityBase value) {
        this.balances = value;
    }

    /**
     * Gets the value of the subscriber property.
     * 
     * @return
     *     possible object is
     *     {@link SubscriberMainBase }
     *     
     */
    public SubscriberMainBase getSubscriber() {
        return subscriber;
    }

    /**
     * Sets the value of the subscriber property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriberMainBase }
     *     
     */
    public void setSubscriber(SubscriberMainBase value) {
        this.subscriber = value;
    }

    /**
     * Gets the value of the spName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSPName() {
        return spName;
    }

    /**
     * Sets the value of the spName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSPName(String value) {
        this.spName = value;
    }

}
