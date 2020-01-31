
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
 *         &lt;element name="GetGroupAccountResult" type="{http://comverse-in.com/prepaid/ccws}GroupAccountRetrieve" minOccurs="0"/&gt;
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
    "getGroupAccountResult"
})
@XmlRootElement(name = "GetGroupAccountResponse")
public class GetGroupAccountResponse {

    @XmlElement(name = "GetGroupAccountResult")
    protected GroupAccountRetrieve getGroupAccountResult;

    /**
     * Gets the value of the getGroupAccountResult property.
     * 
     * @return
     *     possible object is
     *     {@link GroupAccountRetrieve }
     *     
     */
    public GroupAccountRetrieve getGetGroupAccountResult() {
        return getGroupAccountResult;
    }

    /**
     * Sets the value of the getGroupAccountResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GroupAccountRetrieve }
     *     
     */
    public void setGetGroupAccountResult(GroupAccountRetrieve value) {
        this.getGroupAccountResult = value;
    }

}
