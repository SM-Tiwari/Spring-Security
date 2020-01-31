
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OverrideHomeAreas complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OverrideHomeAreas"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ivrPrompt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="homeAreaName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="location" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OverrideHomeAreas", propOrder = {
    "ivrPrompt",
    "homeAreaName",
    "location"
})
public class OverrideHomeAreas {

    protected String ivrPrompt;
    protected String homeAreaName;
    protected String location;

    /**
     * Gets the value of the ivrPrompt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIvrPrompt() {
        return ivrPrompt;
    }

    /**
     * Sets the value of the ivrPrompt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIvrPrompt(String value) {
        this.ivrPrompt = value;
    }

    /**
     * Gets the value of the homeAreaName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHomeAreaName() {
        return homeAreaName;
    }

    /**
     * Sets the value of the homeAreaName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHomeAreaName(String value) {
        this.homeAreaName = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocation(String value) {
        this.location = value;
    }

}
