
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfAccessNumberInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfAccessNumberInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AccessNumberInfo" type="{http://comverse-in.com/prepaid/ccws}AccessNumberInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfAccessNumberInfo", propOrder = {
    "accessNumberInfo"
})
public class ArrayOfAccessNumberInfo {

    @XmlElement(name = "AccessNumberInfo", nillable = true)
    protected List<AccessNumberInfo> accessNumberInfo;

    /**
     * Gets the value of the accessNumberInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accessNumberInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccessNumberInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccessNumberInfo }
     * 
     * 
     */
    public List<AccessNumberInfo> getAccessNumberInfo() {
        if (accessNumberInfo == null) {
            accessNumberInfo = new ArrayList<AccessNumberInfo>();
        }
        return this.accessNumberInfo;
    }

}
