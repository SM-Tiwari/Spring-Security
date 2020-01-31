
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SubscriberHome complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubscriberHome"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Home1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Home2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Home3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Home4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubscriberHome", propOrder = {
    "home1",
    "home2",
    "home3",
    "home4"
})
public class SubscriberHome {

    @XmlElement(name = "Home1")
    protected String home1;
    @XmlElement(name = "Home2")
    protected String home2;
    @XmlElement(name = "Home3")
    protected String home3;
    @XmlElement(name = "Home4")
    protected String home4;

    /**
     * Gets the value of the home1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHome1() {
        return home1;
    }

    /**
     * Sets the value of the home1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHome1(String value) {
        this.home1 = value;
    }

    /**
     * Gets the value of the home2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHome2() {
        return home2;
    }

    /**
     * Sets the value of the home2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHome2(String value) {
        this.home2 = value;
    }

    /**
     * Gets the value of the home3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHome3() {
        return home3;
    }

    /**
     * Sets the value of the home3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHome3(String value) {
        this.home3 = value;
    }

    /**
     * Gets the value of the home4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHome4() {
        return home4;
    }

    /**
     * Sets the value of the home4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHome4(String value) {
        this.home4 = value;
    }

}
