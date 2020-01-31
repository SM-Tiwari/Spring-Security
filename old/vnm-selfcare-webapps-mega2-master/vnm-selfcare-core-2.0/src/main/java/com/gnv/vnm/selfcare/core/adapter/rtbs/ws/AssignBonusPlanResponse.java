
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AssignBonusPlanResult" type="{http://comverse-in.com/prepaid/ccws}AssignBonusPlanResponse" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "assignBonusPlanResult"
})
@XmlRootElement(name = "AssignBonusPlanResponse")
public class AssignBonusPlanResponse {

    @XmlElement(name = "AssignBonusPlanResult")
    protected AssignBonusPlanResponse2 assignBonusPlanResult;

    /**
     * Gets the value of the assignBonusPlanResult property.
     * 
     * @return
     *     possible object is
     *     {@link AssignBonusPlanResponse2 }
     *     
     */
    public AssignBonusPlanResponse2 getAssignBonusPlanResult() {
        return assignBonusPlanResult;
    }

    /**
     * Sets the value of the assignBonusPlanResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssignBonusPlanResponse2 }
     *     
     */
    public void setAssignBonusPlanResult(AssignBonusPlanResponse2 value) {
        this.assignBonusPlanResult = value;
    }

}
