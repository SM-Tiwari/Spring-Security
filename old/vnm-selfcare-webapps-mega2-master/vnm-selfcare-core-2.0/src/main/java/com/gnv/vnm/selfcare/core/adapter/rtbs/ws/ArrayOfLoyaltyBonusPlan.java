
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfLoyaltyBonusPlan complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfLoyaltyBonusPlan"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LoyaltyBonusPlan" type="{http://comverse-in.com/prepaid/ccws}LoyaltyBonusPlan" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfLoyaltyBonusPlan", propOrder = {
    "loyaltyBonusPlan"
})
public class ArrayOfLoyaltyBonusPlan {

    @XmlElement(name = "LoyaltyBonusPlan", nillable = true)
    protected List<LoyaltyBonusPlan> loyaltyBonusPlan;

    /**
     * Gets the value of the loyaltyBonusPlan property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the loyaltyBonusPlan property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLoyaltyBonusPlan().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LoyaltyBonusPlan }
     * 
     * 
     */
    public List<LoyaltyBonusPlan> getLoyaltyBonusPlan() {
        if (loyaltyBonusPlan == null) {
            loyaltyBonusPlan = new ArrayList<LoyaltyBonusPlan>();
        }
        return this.loyaltyBonusPlan;
    }

}
