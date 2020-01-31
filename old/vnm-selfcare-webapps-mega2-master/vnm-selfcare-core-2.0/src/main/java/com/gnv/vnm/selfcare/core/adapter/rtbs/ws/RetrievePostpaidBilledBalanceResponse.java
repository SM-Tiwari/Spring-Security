
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
 *         &lt;element name="RetrievePostpaidBilledBalanceResult" type="{http://comverse-in.com/prepaid/ccws}BilledBalance" minOccurs="0"/&gt;
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
    "retrievePostpaidBilledBalanceResult"
})
@XmlRootElement(name = "RetrievePostpaidBilledBalanceResponse")
public class RetrievePostpaidBilledBalanceResponse {

    @XmlElement(name = "RetrievePostpaidBilledBalanceResult")
    protected BilledBalance retrievePostpaidBilledBalanceResult;

    /**
     * Gets the value of the retrievePostpaidBilledBalanceResult property.
     * 
     * @return
     *     possible object is
     *     {@link BilledBalance }
     *     
     */
    public BilledBalance getRetrievePostpaidBilledBalanceResult() {
        return retrievePostpaidBilledBalanceResult;
    }

    /**
     * Sets the value of the retrievePostpaidBilledBalanceResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link BilledBalance }
     *     
     */
    public void setRetrievePostpaidBilledBalanceResult(BilledBalance value) {
        this.retrievePostpaidBilledBalanceResult = value;
    }

}
