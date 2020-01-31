
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IVRDeltaBalanceWithSessionValueResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IVRDeltaBalanceWithSessionValueResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Delta" type="{http://comverse-in.com/prepaid/ccws}DeltaBalance" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ConvertedFaceValue" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IVRDeltaBalanceWithSessionValueResponse", propOrder = {
    "delta",
    "convertedFaceValue"
})
public class IVRDeltaBalanceWithSessionValueResponse {

    @XmlElement(name = "Delta")
    protected List<DeltaBalance> delta;
    @XmlElement(name = "ConvertedFaceValue")
    protected long convertedFaceValue;

    /**
     * Gets the value of the delta property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the delta property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDelta().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DeltaBalance }
     * 
     * 
     */
    public List<DeltaBalance> getDelta() {
        if (delta == null) {
            delta = new ArrayList<DeltaBalance>();
        }
        return this.delta;
    }

    /**
     * Gets the value of the convertedFaceValue property.
     * 
     */
    public long getConvertedFaceValue() {
        return convertedFaceValue;
    }

    /**
     * Sets the value of the convertedFaceValue property.
     * 
     */
    public void setConvertedFaceValue(long value) {
        this.convertedFaceValue = value;
    }

}
