
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Range complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Range"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RangeStart" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RangeEnd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RangeSDP" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="RangeID" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Range", propOrder = {
    "rangeStart",
    "rangeEnd",
    "rangeSDP",
    "rangeID"
})
public class Range {

    @XmlElement(name = "RangeStart")
    protected String rangeStart;
    @XmlElement(name = "RangeEnd")
    protected String rangeEnd;
    @XmlElement(name = "RangeSDP")
    protected int rangeSDP;
    @XmlElement(name = "RangeID")
    protected int rangeID;

    /**
     * Gets the value of the rangeStart property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRangeStart() {
        return rangeStart;
    }

    /**
     * Sets the value of the rangeStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRangeStart(String value) {
        this.rangeStart = value;
    }

    /**
     * Gets the value of the rangeEnd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRangeEnd() {
        return rangeEnd;
    }

    /**
     * Sets the value of the rangeEnd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRangeEnd(String value) {
        this.rangeEnd = value;
    }

    /**
     * Gets the value of the rangeSDP property.
     * 
     */
    public int getRangeSDP() {
        return rangeSDP;
    }

    /**
     * Sets the value of the rangeSDP property.
     * 
     */
    public void setRangeSDP(int value) {
        this.rangeSDP = value;
    }

    /**
     * Gets the value of the rangeID property.
     * 
     */
    public int getRangeID() {
        return rangeID;
    }

    /**
     * Sets the value of the rangeID property.
     * 
     */
    public void setRangeID(int value) {
        this.rangeID = value;
    }

}
