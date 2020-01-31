
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SpecialHomeAreaRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SpecialHomeAreaRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="subscriberID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="identity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="homeArea1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="homeArea2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="homeArea3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="homeArea4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpecialHomeAreaRequest", propOrder = {
    "subscriberID",
    "identity",
    "homeArea1",
    "homeArea2",
    "homeArea3",
    "homeArea4"
})
public class SpecialHomeAreaRequest {

    protected String subscriberID;
    protected String identity;
    protected String homeArea1;
    protected String homeArea2;
    protected String homeArea3;
    protected String homeArea4;

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
     * Gets the value of the identity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentity() {
        return identity;
    }

    /**
     * Sets the value of the identity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentity(String value) {
        this.identity = value;
    }

    /**
     * Gets the value of the homeArea1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHomeArea1() {
        return homeArea1;
    }

    /**
     * Sets the value of the homeArea1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHomeArea1(String value) {
        this.homeArea1 = value;
    }

    /**
     * Gets the value of the homeArea2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHomeArea2() {
        return homeArea2;
    }

    /**
     * Sets the value of the homeArea2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHomeArea2(String value) {
        this.homeArea2 = value;
    }

    /**
     * Gets the value of the homeArea3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHomeArea3() {
        return homeArea3;
    }

    /**
     * Sets the value of the homeArea3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHomeArea3(String value) {
        this.homeArea3 = value;
    }

    /**
     * Gets the value of the homeArea4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHomeArea4() {
        return homeArea4;
    }

    /**
     * Sets the value of the homeArea4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHomeArea4(String value) {
        this.homeArea4 = value;
    }

}
