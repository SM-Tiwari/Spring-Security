
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfAlcsOverrideDefinition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfAlcsOverrideDefinition"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AlcsOverrideDefinition" type="{http://comverse-in.com/prepaid/ccws}AlcsOverrideDefinition" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfAlcsOverrideDefinition", propOrder = {
    "alcsOverrideDefinition"
})
public class ArrayOfAlcsOverrideDefinition {

    @XmlElement(name = "AlcsOverrideDefinition", nillable = true)
    protected List<AlcsOverrideDefinition> alcsOverrideDefinition;

    /**
     * Gets the value of the alcsOverrideDefinition property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the alcsOverrideDefinition property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAlcsOverrideDefinition().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AlcsOverrideDefinition }
     * 
     * 
     */
    public List<AlcsOverrideDefinition> getAlcsOverrideDefinition() {
        if (alcsOverrideDefinition == null) {
            alcsOverrideDefinition = new ArrayList<AlcsOverrideDefinition>();
        }
        return this.alcsOverrideDefinition;
    }

}
