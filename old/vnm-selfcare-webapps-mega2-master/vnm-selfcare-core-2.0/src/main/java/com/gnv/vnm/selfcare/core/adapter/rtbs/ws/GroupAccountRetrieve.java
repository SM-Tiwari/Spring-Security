
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GroupAccountRetrieve complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GroupAccountRetrieve"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://comverse-in.com/prepaid/ccws}GroupAccountBase"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GroupID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OwnerID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OwnerIdentityName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DefaultMaxSpendinglimits" type="{http://comverse-in.com/prepaid/ccws}ArrayOfGroupAccountSpendingLimit" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GroupAccountRetrieve", propOrder = {
    "groupID",
    "ownerID",
    "ownerIdentityName",
    "defaultMaxSpendinglimits"
})
public class GroupAccountRetrieve
    extends GroupAccountBase
{

    @XmlElement(name = "GroupID")
    protected String groupID;
    @XmlElement(name = "OwnerID")
    protected String ownerID;
    @XmlElement(name = "OwnerIdentityName")
    protected String ownerIdentityName;
    @XmlElement(name = "DefaultMaxSpendinglimits")
    protected ArrayOfGroupAccountSpendingLimit defaultMaxSpendinglimits;

    /**
     * Gets the value of the groupID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupID() {
        return groupID;
    }

    /**
     * Sets the value of the groupID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupID(String value) {
        this.groupID = value;
    }

    /**
     * Gets the value of the ownerID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerID() {
        return ownerID;
    }

    /**
     * Sets the value of the ownerID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerID(String value) {
        this.ownerID = value;
    }

    /**
     * Gets the value of the ownerIdentityName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerIdentityName() {
        return ownerIdentityName;
    }

    /**
     * Sets the value of the ownerIdentityName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerIdentityName(String value) {
        this.ownerIdentityName = value;
    }

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

}
