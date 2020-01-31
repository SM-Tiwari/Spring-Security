
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BonusPlanModify complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BonusPlanModify"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://comverse-in.com/prepaid/ccws}BonusPlanEntity"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BonusPlanAction" type="{http://comverse-in.com/prepaid/ccws}eBonusPlanAction"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BonusPlanModify", propOrder = {
    "bonusPlanAction"
})
public class BonusPlanModify
    extends BonusPlanEntity
{

    @XmlElement(name = "BonusPlanAction", required = true)
    @XmlSchemaType(name = "string")
    protected EBonusPlanAction bonusPlanAction;

    /**
     * Gets the value of the bonusPlanAction property.
     * 
     * @return
     *     possible object is
     *     {@link EBonusPlanAction }
     *     
     */
    public EBonusPlanAction getBonusPlanAction() {
        return bonusPlanAction;
    }

    /**
     * Sets the value of the bonusPlanAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link EBonusPlanAction }
     *     
     */
    public void setBonusPlanAction(EBonusPlanAction value) {
        this.bonusPlanAction = value;
    }

}
