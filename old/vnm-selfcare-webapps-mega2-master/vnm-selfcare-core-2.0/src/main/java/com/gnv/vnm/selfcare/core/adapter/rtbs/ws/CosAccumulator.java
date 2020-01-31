
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CosAccumulator complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CosAccumulator"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="accumulator_id" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="accumulator_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="accumulator_offer_type" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CosAccumulator", propOrder = {
    "accumulatorId",
    "accumulatorName",
    "accumulatorOfferType"
})
public class CosAccumulator {

    @XmlElement(name = "accumulator_id")
    protected long accumulatorId;
    @XmlElement(name = "accumulator_name")
    protected String accumulatorName;
    @XmlElement(name = "accumulator_offer_type")
    protected int accumulatorOfferType;

    /**
     * Gets the value of the accumulatorId property.
     * 
     */
    public long getAccumulatorId() {
        return accumulatorId;
    }

    /**
     * Sets the value of the accumulatorId property.
     * 
     */
    public void setAccumulatorId(long value) {
        this.accumulatorId = value;
    }

    /**
     * Gets the value of the accumulatorName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccumulatorName() {
        return accumulatorName;
    }

    /**
     * Sets the value of the accumulatorName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccumulatorName(String value) {
        this.accumulatorName = value;
    }

    /**
     * Gets the value of the accumulatorOfferType property.
     * 
     */
    public int getAccumulatorOfferType() {
        return accumulatorOfferType;
    }

    /**
     * Sets the value of the accumulatorOfferType property.
     * 
     */
    public void setAccumulatorOfferType(int value) {
        this.accumulatorOfferType = value;
    }

}
