
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ChangeCallingCircleRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ChangeCallingCircleRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="callingCircle" type="{http://comverse-in.com/prepaid/ccws}CallingCircle" minOccurs="0"/&gt;
 *         &lt;element name="callingCircleOperation" type="{http://comverse-in.com/prepaid/ccws}CallingCircleOperation"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChangeCallingCircleRequest", propOrder = {
    "callingCircle",
    "callingCircleOperation"
})
public class ChangeCallingCircleRequest {

    protected CallingCircle callingCircle;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected CallingCircleOperation callingCircleOperation;

    /**
     * Gets the value of the callingCircle property.
     * 
     * @return
     *     possible object is
     *     {@link CallingCircle }
     *     
     */
    public CallingCircle getCallingCircle() {
        return callingCircle;
    }

    /**
     * Sets the value of the callingCircle property.
     * 
     * @param value
     *     allowed object is
     *     {@link CallingCircle }
     *     
     */
    public void setCallingCircle(CallingCircle value) {
        this.callingCircle = value;
    }

    /**
     * Gets the value of the callingCircleOperation property.
     * 
     * @return
     *     possible object is
     *     {@link CallingCircleOperation }
     *     
     */
    public CallingCircleOperation getCallingCircleOperation() {
        return callingCircleOperation;
    }

    /**
     * Sets the value of the callingCircleOperation property.
     * 
     * @param value
     *     allowed object is
     *     {@link CallingCircleOperation }
     *     
     */
    public void setCallingCircleOperation(CallingCircleOperation value) {
        this.callingCircleOperation = value;
    }

}
