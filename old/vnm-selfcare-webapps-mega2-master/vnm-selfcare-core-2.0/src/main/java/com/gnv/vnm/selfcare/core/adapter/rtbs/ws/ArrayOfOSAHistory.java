
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfOSAHistory complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfOSAHistory"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="OSAHistory" type="{http://comverse-in.com/prepaid/ccws}OSAHistory" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfOSAHistory", propOrder = {
    "osaHistory"
})
public class ArrayOfOSAHistory {

    @XmlElement(name = "OSAHistory", nillable = true)
    protected List<OSAHistory> osaHistory;

    /**
     * Gets the value of the osaHistory property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the osaHistory property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOSAHistory().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OSAHistory }
     * 
     * 
     */
    public List<OSAHistory> getOSAHistory() {
        if (osaHistory == null) {
            osaHistory = new ArrayList<OSAHistory>();
        }
        return this.osaHistory;
    }

}
