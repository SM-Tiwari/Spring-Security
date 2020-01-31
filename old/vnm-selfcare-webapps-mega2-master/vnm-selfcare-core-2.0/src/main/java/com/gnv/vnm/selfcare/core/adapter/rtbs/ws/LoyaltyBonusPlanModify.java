
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LoyaltyBonusPlanModify complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LoyaltyBonusPlanModify"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://comverse-in.com/prepaid/ccws}BonusPlanEntity"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LoyaltyBonusPlanAction" type="{http://comverse-in.com/prepaid/ccws}eBonusPlanAction"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoyaltyBonusPlanModify", propOrder = {
    "loyaltyBonusPlanAction"
})
public class LoyaltyBonusPlanModify
    extends BonusPlanEntity
{

    @XmlElement(name = "LoyaltyBonusPlanAction", required = true)
    @XmlSchemaType(name = "string")
    protected EBonusPlanAction loyaltyBonusPlanAction;

    /**
     * Gets the value of the loyaltyBonusPlanAction property.
     * 
     * @return
     *     possible object is
     *     {@link EBonusPlanAction }
     *     
     */
    public EBonusPlanAction getLoyaltyBonusPlanAction() {
        return loyaltyBonusPlanAction;
    }

    /**
     * Sets the value of the loyaltyBonusPlanAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link EBonusPlanAction }
     *     
     */
    public void setLoyaltyBonusPlanAction(EBonusPlanAction value) {
        this.loyaltyBonusPlanAction = value;
    }

}
