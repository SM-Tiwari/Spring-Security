
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
 *         &lt;element name="GetAllGroupMembersResult" type="{http://comverse-in.com/prepaid/ccws}ArrayOfSubscriberRetrieve" minOccurs="0"/&gt;
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
    "getAllGroupMembersResult"
})
@XmlRootElement(name = "GetAllGroupMembersResponse")
public class GetAllGroupMembersResponse {

    @XmlElement(name = "GetAllGroupMembersResult")
    protected ArrayOfSubscriberRetrieve getAllGroupMembersResult;

    /**
     * Gets the value of the getAllGroupMembersResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSubscriberRetrieve }
     *     
     */
    public ArrayOfSubscriberRetrieve getGetAllGroupMembersResult() {
        return getAllGroupMembersResult;
    }

    /**
     * Sets the value of the getAllGroupMembersResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSubscriberRetrieve }
     *     
     */
    public void setGetAllGroupMembersResult(ArrayOfSubscriberRetrieve value) {
        this.getAllGroupMembersResult = value;
    }

}
