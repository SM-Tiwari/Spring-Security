
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CircleOperationResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CircleOperationResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ReturnCode" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="subscriber" type="{http://comverse-in.com/prepaid/ccws}SubscriberBasic" minOccurs="0"/&gt;
 *         &lt;element name="circleOperation" type="{http://comverse-in.com/prepaid/ccws}CircleOperation"/&gt;
 *         &lt;element name="circleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CircleOperationResponse", propOrder = {
    "returnCode",
    "subscriber",
    "circleOperation",
    "circleName"
})
public class CircleOperationResponse {

    @XmlElement(name = "ReturnCode")
    protected long returnCode;
    protected SubscriberBasic subscriber;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected CircleOperation circleOperation;
    protected String circleName;

    /**
     * Gets the value of the returnCode property.
     * 
     */
    public long getReturnCode() {
        return returnCode;
    }

    /**
     * Sets the value of the returnCode property.
     * 
     */
    public void setReturnCode(long value) {
        this.returnCode = value;
    }

    /**
     * Gets the value of the subscriber property.
     * 
     * @return
     *     possible object is
     *     {@link SubscriberBasic }
     *     
     */
    public SubscriberBasic getSubscriber() {
        return subscriber;
    }

    /**
     * Sets the value of the subscriber property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriberBasic }
     *     
     */
    public void setSubscriber(SubscriberBasic value) {
        this.subscriber = value;
    }

    /**
     * Gets the value of the circleOperation property.
     * 
     * @return
     *     possible object is
     *     {@link CircleOperation }
     *     
     */
    public CircleOperation getCircleOperation() {
        return circleOperation;
    }

    /**
     * Sets the value of the circleOperation property.
     * 
     * @param value
     *     allowed object is
     *     {@link CircleOperation }
     *     
     */
    public void setCircleOperation(CircleOperation value) {
        this.circleOperation = value;
    }

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

}
