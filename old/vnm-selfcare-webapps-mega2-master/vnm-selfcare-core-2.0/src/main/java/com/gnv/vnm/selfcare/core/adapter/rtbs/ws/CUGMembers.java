
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CUGMembers complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CUGMembers"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CodeProp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CUGNameProp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="VPNAccessProp" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="ShortDialProp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SuperCUGCodeProp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SuperCUGNameProp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CUGMembers", propOrder = {
    "codeProp",
    "cugNameProp",
    "vpnAccessProp",
    "shortDialProp",
    "superCUGCodeProp",
    "superCUGNameProp"
})
public class CUGMembers {

    @XmlElement(name = "CodeProp")
    protected String codeProp;
    @XmlElement(name = "CUGNameProp")
    protected String cugNameProp;
    @XmlElement(name = "VPNAccessProp")
    protected int vpnAccessProp;
    @XmlElement(name = "ShortDialProp")
    protected String shortDialProp;
    @XmlElement(name = "SuperCUGCodeProp")
    protected String superCUGCodeProp;
    @XmlElement(name = "SuperCUGNameProp")
    protected String superCUGNameProp;

    /**
     * Gets the value of the codeProp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeProp() {
        return codeProp;
    }

    /**
     * Sets the value of the codeProp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeProp(String value) {
        this.codeProp = value;
    }

    /**
     * Gets the value of the cugNameProp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCUGNameProp() {
        return cugNameProp;
    }

    /**
     * Sets the value of the cugNameProp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCUGNameProp(String value) {
        this.cugNameProp = value;
    }

    /**
     * Gets the value of the vpnAccessProp property.
     * 
     */
    public int getVPNAccessProp() {
        return vpnAccessProp;
    }

    /**
     * Sets the value of the vpnAccessProp property.
     * 
     */
    public void setVPNAccessProp(int value) {
        this.vpnAccessProp = value;
    }

    /**
     * Gets the value of the shortDialProp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShortDialProp() {
        return shortDialProp;
    }

    /**
     * Sets the value of the shortDialProp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortDialProp(String value) {
        this.shortDialProp = value;
    }

    /**
     * Gets the value of the superCUGCodeProp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuperCUGCodeProp() {
        return superCUGCodeProp;
    }

    /**
     * Sets the value of the superCUGCodeProp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuperCUGCodeProp(String value) {
        this.superCUGCodeProp = value;
    }

    /**
     * Gets the value of the superCUGNameProp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuperCUGNameProp() {
        return superCUGNameProp;
    }

    /**
     * Sets the value of the superCUGNameProp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuperCUGNameProp(String value) {
        this.superCUGNameProp = value;
    }

}
