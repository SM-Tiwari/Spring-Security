
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfAccumulatorBase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfAccumulatorBase"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AccumulatorBase" type="{http://comverse-in.com/prepaid/ccws}AccumulatorBase" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfAccumulatorBase", propOrder = {
    "accumulatorBase"
})
public class ArrayOfAccumulatorBase {

    @XmlElement(name = "AccumulatorBase", nillable = true)
    protected List<AccumulatorBase> accumulatorBase;

    /**
     * Gets the value of the accumulatorBase property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accumulatorBase property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccumulatorBase().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccumulatorBase }
     * 
     * 
     */
    public List<AccumulatorBase> getAccumulatorBase() {
        if (accumulatorBase == null) {
            accumulatorBase = new ArrayList<AccumulatorBase>();
        }
        return this.accumulatorBase;
    }

}