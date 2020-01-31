
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CallingCircle complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CallingCircle"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="circleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="callingCircleGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="serviceProvider" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="maximumSize" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="barredNumberList" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ivrPrompt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CallingCircle", propOrder = {
    "circleName",
    "callingCircleGroup",
    "serviceProvider",
    "maximumSize",
    "barredNumberList",
    "ivrPrompt"
})
public class CallingCircle {

    protected String circleName;
    protected String callingCircleGroup;
    protected String serviceProvider;
    protected String maximumSize;
    protected String barredNumberList;
    protected String ivrPrompt;

    /**
     * Gets the value of the circleName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCircleName() {
        return circleName;
    }

    /**
     * Sets the value of the circleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCircleName(String value) {
        this.circleName = value;
    }

    /**
     * Gets the value of the callingCircleGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCallingCircleGroup() {
        return callingCircleGroup;
    }

    /**
     * Sets the value of the callingCircleGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCallingCircleGroup(String value) {
        this.callingCircleGroup = value;
    }

    /**
     * Gets the value of the serviceProvider property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceProvider() {
        return serviceProvider;
    }

    /**
     * Sets the value of the serviceProvider property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceProvider(String value) {
        this.serviceProvider = value;
    }

    /**
     * Gets the value of the maximumSize property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaximumSize() {
        return maximumSize;
    }

    /**
     * Sets the value of the maximumSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaximumSize(String value) {
        this.maximumSize = value;
    }

    /**
     * Gets the value of the barredNumberList property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBarredNumberList() {
        return barredNumberList;
    }

    /**
     * Sets the value of the barredNumberList property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBarredNumberList(String value) {
        this.barredNumberList = value;
    }

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

}
