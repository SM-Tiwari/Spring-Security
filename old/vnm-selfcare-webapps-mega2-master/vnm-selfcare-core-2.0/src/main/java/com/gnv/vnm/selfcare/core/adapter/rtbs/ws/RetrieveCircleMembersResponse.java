
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
 *         &lt;element name="RetrieveCircleMembersResult" type="{http://comverse-in.com/prepaid/ccws}RetrieveCirclesMembersResponse" minOccurs="0"/&gt;
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
    "retrieveCircleMembersResult"
})
@XmlRootElement(name = "RetrieveCircleMembersResponse")
public class RetrieveCircleMembersResponse {

    @XmlElement(name = "RetrieveCircleMembersResult")
    protected RetrieveCirclesMembersResponse retrieveCircleMembersResult;

    /**
     * Gets the value of the retrieveCircleMembersResult property.
     * 
     * @return
     *     possible object is
     *     {@link RetrieveCirclesMembersResponse }
     *     
     */
    public RetrieveCirclesMembersResponse getRetrieveCircleMembersResult() {
        return retrieveCircleMembersResult;
    }

    /**
     * Sets the value of the retrieveCircleMembersResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link RetrieveCirclesMembersResponse }
     *     
     */
    public void setRetrieveCircleMembersResult(RetrieveCirclesMembersResponse value) {
        this.retrieveCircleMembersResult = value;
    }

}