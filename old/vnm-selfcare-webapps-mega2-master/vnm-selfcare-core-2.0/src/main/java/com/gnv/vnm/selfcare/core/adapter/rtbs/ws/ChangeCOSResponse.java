
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
 *         &lt;element name="ChangeCOSResult" type="{http://comverse-in.com/prepaid/ccws}ChangeCOSResponse" minOccurs="0"/&gt;
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
    "changeCOSResult"
})
@XmlRootElement(name = "ChangeCOSResponse")
public class ChangeCOSResponse {

    @XmlElement(name = "ChangeCOSResult")
    protected ChangeCOSResponse2 changeCOSResult;

    /**
     * Gets the value of the changeCOSResult property.
     * 
     * @return
     *     possible object is
     *     {@link ChangeCOSResponse2 }
     *     
     */
    public ChangeCOSResponse2 getChangeCOSResult() {
        return changeCOSResult;
    }

    /**
     * Sets the value of the changeCOSResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChangeCOSResponse2 }
     *     
     */
    public void setChangeCOSResult(ChangeCOSResponse2 value) {
        this.changeCOSResult = value;
    }

}
