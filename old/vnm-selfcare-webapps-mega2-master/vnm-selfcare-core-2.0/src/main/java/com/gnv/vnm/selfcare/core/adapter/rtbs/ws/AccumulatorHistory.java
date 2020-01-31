
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AccumulatorHistory complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccumulatorHistory"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://comverse-in.com/prepaid/ccws}AccumulatorBase"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ChangeAmount" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccumulatorHistory", propOrder = {
    "changeAmount"
})
public class AccumulatorHistory
    extends AccumulatorBase
{

    @XmlElement(name = "ChangeAmount")
    protected double changeAmount;

    /**
     * Gets the value of the changeAmount property.
     * 
     */
    public double getChangeAmount() {
        return changeAmount;
    }

    /**
     * Sets the value of the changeAmount property.
     * 
     */
    public void setChangeAmount(double value) {
        this.changeAmount = value;
    }

}
