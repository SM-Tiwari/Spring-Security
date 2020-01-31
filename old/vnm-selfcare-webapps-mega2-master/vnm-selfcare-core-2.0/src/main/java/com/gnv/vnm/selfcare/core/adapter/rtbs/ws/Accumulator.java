
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Accumulator complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Accumulator"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="accumulatorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="accumulatorId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="resetPoint" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="period" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="count_type" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="accumulator_type" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="unitTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Accumulator", propOrder = {
    "accumulatorName",
    "accumulatorId",
    "resetPoint",
    "period",
    "countType",
    "accumulatorType",
    "unitTypeName"
})
public class Accumulator {

    protected String accumulatorName;
    protected long accumulatorId;
    protected long resetPoint;
    protected long period;
    @XmlElement(name = "count_type")
    protected long countType;
    @XmlElement(name = "accumulator_type")
    protected long accumulatorType;
    protected String unitTypeName;

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
     * Gets the value of the resetPoint property.
     * 
     */
    public long getResetPoint() {
        return resetPoint;
    }

    /**
     * Sets the value of the resetPoint property.
     * 
     */
    public void setResetPoint(long value) {
        this.resetPoint = value;
    }

    /**
     * Gets the value of the period property.
     * 
     */
    public long getPeriod() {
        return period;
    }

    /**
     * Sets the value of the period property.
     * 
     */
    public void setPeriod(long value) {
        this.period = value;
    }

    /**
     * Gets the value of the countType property.
     * 
     */
    public long getCountType() {
        return countType;
    }

    /**
     * Sets the value of the countType property.
     * 
     */
    public void setCountType(long value) {
        this.countType = value;
    }

    /**
     * Gets the value of the accumulatorType property.
     * 
     */
    public long getAccumulatorType() {
        return accumulatorType;
    }

    /**
     * Sets the value of the accumulatorType property.
     * 
     */
    public void setAccumulatorType(long value) {
        this.accumulatorType = value;
    }

    /**
     * Gets the value of the unitTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitTypeName() {
        return unitTypeName;
    }

    /**
     * Sets the value of the unitTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitTypeName(String value) {
        this.unitTypeName = value;
    }

}
