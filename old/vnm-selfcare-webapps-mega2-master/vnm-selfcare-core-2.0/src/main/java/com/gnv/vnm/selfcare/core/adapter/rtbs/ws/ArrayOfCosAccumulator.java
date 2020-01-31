
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfCosAccumulator complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfCosAccumulator"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CosAccumulator" type="{http://comverse-in.com/prepaid/ccws}CosAccumulator" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCosAccumulator", propOrder = {
    "cosAccumulator"
})
public class ArrayOfCosAccumulator {

    @XmlElement(name = "CosAccumulator", nillable = true)
    protected List<CosAccumulator> cosAccumulator;

    /**
     * Gets the value of the cosAccumulator property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cosAccumulator property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCosAccumulator().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CosAccumulator }
     * 
     * 
     */
    public List<CosAccumulator> getCosAccumulator() {
        if (cosAccumulator == null) {
            cosAccumulator = new ArrayList<CosAccumulator>();
        }
        return this.cosAccumulator;
    }

}
