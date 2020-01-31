
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
 *         &lt;element name="CreatePhonebookNumberResult" type="{http://comverse-in.com/prepaid/ccws}PhonebookNumberResponse" minOccurs="0"/&gt;
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
    "createPhonebookNumberResult"
})
@XmlRootElement(name = "CreatePhonebookNumberResponse")
public class CreatePhonebookNumberResponse {

    @XmlElement(name = "CreatePhonebookNumberResult")
    protected PhonebookNumberResponse createPhonebookNumberResult;

    /**
     * Gets the value of the createPhonebookNumberResult property.
     * 
     * @return
     *     possible object is
     *     {@link PhonebookNumberResponse }
     *     
     */
    public PhonebookNumberResponse getCreatePhonebookNumberResult() {
        return createPhonebookNumberResult;
    }

    /**
     * Sets the value of the createPhonebookNumberResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link PhonebookNumberResponse }
     *     
     */
    public void setCreatePhonebookNumberResult(PhonebookNumberResponse value) {
        this.createPhonebookNumberResult = value;
    }

}
