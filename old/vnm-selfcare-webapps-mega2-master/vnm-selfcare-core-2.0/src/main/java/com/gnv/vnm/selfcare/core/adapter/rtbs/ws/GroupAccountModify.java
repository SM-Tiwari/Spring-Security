
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GroupAccountModify complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GroupAccountModify"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://comverse-in.com/prepaid/ccws}GroupAccountBase"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DefaultMaxSpendinglimits" type="{http://comverse-in.com/prepaid/ccws}ArrayOfGroupAccountSpendingLimit" minOccurs="0"/&gt;
 *         &lt;element name="NewGroupName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GroupAccountModify", propOrder = {
    "defaultMaxSpendinglimits",
    "newGroupName"
})
public class GroupAccountModify
    extends GroupAccountBase
{

    @XmlElement(name = "DefaultMaxSpendinglimits")
    protected ArrayOfGroupAccountSpendingLimit defaultMaxSpendinglimits;
    @XmlElement(name = "NewGroupName")
    protected String newGroupName;

    /**
     * Gets the value of the defaultMaxSpendinglimits property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfGroupAccountSpendingLimit }
     *     
     */
    public ArrayOfGroupAccountSpendingLimit getDefaultMaxSpendinglimits() {
        return defaultMaxSpendinglimits;
    }

    /**
     * Sets the value of the defaultMaxSpendinglimits property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfGroupAccountSpendingLimit }
     *     
     */
    public void setDefaultMaxSpendinglimits(ArrayOfGroupAccountSpendingLimit value) {
        this.defaultMaxSpendinglimits = value;
    }

    /**
     * Gets the value of the newGroupName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewGroupName() {
        return newGroupName;
    }

    /**
     * Sets the value of the newGroupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewGroupName(String value) {
        this.newGroupName = value;
    }

}
