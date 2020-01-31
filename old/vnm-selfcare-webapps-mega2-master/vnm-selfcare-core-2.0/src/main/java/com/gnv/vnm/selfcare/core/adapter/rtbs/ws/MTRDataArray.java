
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * <p>Java class for MTRDataArray complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MTRDataArray"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MTRItems" type="{http://comverse-in.com/prepaid/ccws}ArrayOfMTRItem" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;anyAttribute/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MTRDataArray", propOrder = {
    "mtrItems"
})
public class MTRDataArray {

    @XmlElement(name = "MTRItems")
    protected ArrayOfMTRItem mtrItems;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the mtrItems property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMTRItem }
     *     
     */
    public ArrayOfMTRItem getMTRItems() {
        return mtrItems;
    }

    /**
     * Sets the value of the mtrItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMTRItem }
     *     
     */
    public void setMTRItems(ArrayOfMTRItem value) {
        this.mtrItems = value;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

}
