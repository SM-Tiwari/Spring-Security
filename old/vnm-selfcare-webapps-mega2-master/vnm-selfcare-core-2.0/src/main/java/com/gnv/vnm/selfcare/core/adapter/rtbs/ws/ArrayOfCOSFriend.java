
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfCOSFriend complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfCOSFriend"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="COSFriend" type="{http://comverse-in.com/prepaid/ccws}COSFriend" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCOSFriend", propOrder = {
    "cosFriend"
})
public class ArrayOfCOSFriend {

    @XmlElement(name = "COSFriend", nillable = true)
    protected List<COSFriend> cosFriend;

    /**
     * Gets the value of the cosFriend property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cosFriend property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCOSFriend().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link COSFriend }
     * 
     * 
     */
    public List<COSFriend> getCOSFriend() {
        if (cosFriend == null) {
            cosFriend = new ArrayList<COSFriend>();
        }
        return this.cosFriend;
    }

}
