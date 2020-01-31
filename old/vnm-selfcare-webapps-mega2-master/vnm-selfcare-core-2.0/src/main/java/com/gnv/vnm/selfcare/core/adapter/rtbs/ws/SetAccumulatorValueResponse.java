
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SetAccumulatorValueResult" type="{http://comverse-in.com/prepaid/ccws}SetAccumulatorValueResponse" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "setAccumulatorValueResult"
})
@XmlRootElement(name = "SetAccumulatorValueResponse")
public class SetAccumulatorValueResponse {

    @XmlElement(name = "SetAccumulatorValueResult")
    protected SetAccumulatorValueResponse2 setAccumulatorValueResult;

    /**
     * Gets the value of the setAccumulatorValueResult property.
     * 
     * @return
     *     possible object is
     *     {@link SetAccumulatorValueResponse2 }
     *     
     */
    public SetAccumulatorValueResponse2 getSetAccumulatorValueResult() {
        return setAccumulatorValueResult;
    }

    /**
     * Sets the value of the setAccumulatorValueResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link SetAccumulatorValueResponse2 }
     *     
     */
    public void setSetAccumulatorValueResult(SetAccumulatorValueResponse2 value) {
        this.setAccumulatorValueResult = value;
    }

}
