
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RetrieveAccumulatorValueResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetrieveAccumulatorValueResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AccumulatorValue" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveAccumulatorValueResponse", propOrder = {
    "accumulatorValue"
})
public class RetrieveAccumulatorValueResponse2 {

    @XmlElement(name = "AccumulatorValue")
    protected double accumulatorValue;

    /**
     * Gets the value of the accumulatorValue property.
     * 
     */
    public double getAccumulatorValue() {
        return accumulatorValue;
    }

    /**
     * Sets the value of the accumulatorValue property.
     * 
     */
    public void setAccumulatorValue(double value) {
        this.accumulatorValue = value;
    }

}
