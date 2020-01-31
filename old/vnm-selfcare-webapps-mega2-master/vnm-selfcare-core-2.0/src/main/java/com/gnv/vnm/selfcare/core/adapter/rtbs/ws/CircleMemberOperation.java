
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CircleMemberOperation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CircleMemberOperation"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="circleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="circleMember" type="{http://comverse-in.com/prepaid/ccws}CircleMember" minOccurs="0"/&gt;
 *         &lt;element name="circleOperation" type="{http://comverse-in.com/prepaid/ccws}CircleOperation"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CircleMemberOperation", propOrder = {
    "circleName",
    "circleMember",
    "circleOperation"
})
public class CircleMemberOperation {

    protected String circleName;
    protected CircleMember circleMember;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected CircleOperation circleOperation;

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
     * Gets the value of the circleMember property.
     * 
     * @return
     *     possible object is
     *     {@link CircleMember }
     *     
     */
    public CircleMember getCircleMember() {
        return circleMember;
    }

    /**
     * Sets the value of the circleMember property.
     * 
     * @param value
     *     allowed object is
     *     {@link CircleMember }
     *     
     */
    public void setCircleMember(CircleMember value) {
        this.circleMember = value;
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

}
