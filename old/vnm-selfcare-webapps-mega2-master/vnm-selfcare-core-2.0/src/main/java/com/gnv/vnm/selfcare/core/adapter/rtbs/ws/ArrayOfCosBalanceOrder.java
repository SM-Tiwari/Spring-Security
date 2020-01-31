
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfCosBalanceOrder complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfCosBalanceOrder"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CosBalanceOrder" type="{http://comverse-in.com/prepaid/ccws}CosBalanceOrder" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCosBalanceOrder", propOrder = {
    "cosBalanceOrder"
})
public class ArrayOfCosBalanceOrder {

    @XmlElement(name = "CosBalanceOrder", nillable = true)
    protected List<CosBalanceOrder> cosBalanceOrder;

    /**
     * Gets the value of the cosBalanceOrder property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cosBalanceOrder property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCosBalanceOrder().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CosBalanceOrder }
     * 
     * 
     */
    public List<CosBalanceOrder> getCosBalanceOrder() {
        if (cosBalanceOrder == null) {
            cosBalanceOrder = new ArrayList<CosBalanceOrder>();
        }
        return this.cosBalanceOrder;
    }

}
