
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
 *         &lt;element name="GetGroupCountResult" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
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
    "getGroupCountResult"
})
@XmlRootElement(name = "GetGroupCountResponse")
public class GetGroupCountResponse {

    @XmlElement(name = "GetGroupCountResult")
    protected long getGroupCountResult;

    /**
     * Gets the value of the getGroupCountResult property.
     * 
     */
    public long getGetGroupCountResult() {
        return getGroupCountResult;
    }

    /**
     * Sets the value of the getGroupCountResult property.
     * 
     */
    public void setGetGroupCountResult(long value) {
        this.getGroupCountResult = value;
    }

}
