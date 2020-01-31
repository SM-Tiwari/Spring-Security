
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PreCallThreshold complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PreCallThreshold"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="thresholdType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="thresholdValue" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PreCallThreshold", propOrder = {
    "thresholdType",
    "thresholdValue"
})
public class PreCallThreshold {

    protected String thresholdType;
    protected double thresholdValue;

    /**
     * Gets the value of the thresholdType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThresholdType() {
        return thresholdType;
    }

    /**
     * Sets the value of the thresholdType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThresholdType(String value) {
        this.thresholdType = value;
    }

    /**
     * Gets the value of the thresholdValue property.
     * 
     */
    public double getThresholdValue() {
        return thresholdValue;
    }

    /**
     * Sets the value of the thresholdValue property.
     * 
     */
    public void setThresholdValue(double value) {
        this.thresholdValue = value;
    }

}
