
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AccumulatorModify complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccumulatorModify"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://comverse-in.com/prepaid/ccws}AccumulatorBase"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ZeroDay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ResetAccumulator" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccumulatorModify", propOrder = {
    "zeroDay",
    "resetAccumulator"
})
public class AccumulatorModify
    extends AccumulatorBase
{

    @XmlElement(name = "ZeroDay")
    protected String zeroDay;
    @XmlElement(name = "ResetAccumulator")
    protected boolean resetAccumulator;

    /**
     * Gets the value of the zeroDay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZeroDay() {
        return zeroDay;
    }

    /**
     * Sets the value of the zeroDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZeroDay(String value) {
        this.zeroDay = value;
    }

    /**
     * Gets the value of the resetAccumulator property.
     * 
     */
    public boolean isResetAccumulator() {
        return resetAccumulator;
    }

    /**
     * Sets the value of the resetAccumulator property.
     * 
     */
    public void setResetAccumulator(boolean value) {
        this.resetAccumulator = value;
    }

}
