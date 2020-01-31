
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BonusPlanEntity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BonusPlanEntity"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BonusPlanName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BonusPlanEntity", propOrder = {
    "bonusPlanName"
})
@XmlSeeAlso({
    BonusPlanModify.class,
    LoyaltyBonusPlanModify.class
})
public class BonusPlanEntity {

    @XmlElement(name = "BonusPlanName")
    protected String bonusPlanName;

    /**
     * Gets the value of the bonusPlanName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBonusPlanName() {
        return bonusPlanName;
    }

    /**
     * Sets the value of the bonusPlanName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBonusPlanName(String value) {
        this.bonusPlanName = value;
    }

}
