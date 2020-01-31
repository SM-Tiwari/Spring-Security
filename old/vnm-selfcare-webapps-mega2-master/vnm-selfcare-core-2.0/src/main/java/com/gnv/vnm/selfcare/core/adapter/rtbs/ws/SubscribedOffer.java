
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for SubscribedOffer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubscribedOffer"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://comverse-in.com/prepaid/ccws}OfferBase"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="State" type="{http://comverse-in.com/prepaid/ccws}Offer_State"/&gt;
 *         &lt;element name="InstantiationTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubscribedOffer", propOrder = {
    "state",
    "instantiationTime"
})
public class SubscribedOffer
    extends OfferBase
{

    @XmlElement(name = "State", required = true)
    @XmlSchemaType(name = "string")
    protected OfferState state;
    @XmlElement(name = "InstantiationTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar instantiationTime;

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link OfferState }
     *     
     */
    public OfferState getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link OfferState }
     *     
     */
    public void setState(OfferState value) {
        this.state = value;
    }

    /**
     * Gets the value of the instantiationTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getInstantiationTime() {
        return instantiationTime;
    }

    /**
     * Sets the value of the instantiationTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setInstantiationTime(XMLGregorianCalendar value) {
        this.instantiationTime = value;
    }

}
