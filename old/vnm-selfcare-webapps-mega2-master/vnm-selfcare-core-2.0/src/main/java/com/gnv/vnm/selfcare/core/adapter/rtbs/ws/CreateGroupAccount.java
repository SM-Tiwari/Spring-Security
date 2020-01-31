
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="groupAccountCreate" type="{http://comverse-in.com/prepaid/ccws}GroupAccountCreate" minOccurs="0"/&gt;
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
    "groupAccountCreate"
})
@XmlRootElement(name = "CreateGroupAccount")
public class CreateGroupAccount {

    protected GroupAccountCreate groupAccountCreate;

    /**
     * Gets the value of the groupAccountCreate property.
     * 
     * @return
     *     possible object is
     *     {@link GroupAccountCreate }
     *     
     */
    public GroupAccountCreate getGroupAccountCreate() {
        return groupAccountCreate;
    }

    /**
     * Sets the value of the groupAccountCreate property.
     * 
     * @param value
     *     allowed object is
     *     {@link GroupAccountCreate }
     *     
     */
    public void setGroupAccountCreate(GroupAccountCreate value) {
        this.groupAccountCreate = value;
    }

}
