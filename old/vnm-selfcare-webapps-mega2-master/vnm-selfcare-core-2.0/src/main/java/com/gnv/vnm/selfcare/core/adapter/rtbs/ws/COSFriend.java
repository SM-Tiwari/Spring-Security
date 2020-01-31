
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for COSFriend complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="COSFriend"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="allowedRechargeCOS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="treansferNumber" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COSFriend", propOrder = {
    "allowedRechargeCOS",
    "treansferNumber"
})
public class COSFriend {

    protected String allowedRechargeCOS;
    protected int treansferNumber;

    /**
     * Gets the value of the allowedRechargeCOS property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAllowedRechargeCOS() {
        return allowedRechargeCOS;
    }

    /**
     * Sets the value of the allowedRechargeCOS property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAllowedRechargeCOS(String value) {
        this.allowedRechargeCOS = value;
    }

    /**
     * Gets the value of the treansferNumber property.
     * 
     */
    public int getTreansferNumber() {
        return treansferNumber;
    }

    /**
     * Sets the value of the treansferNumber property.
     * 
     */
    public void setTreansferNumber(int value) {
        this.treansferNumber = value;
    }

}
