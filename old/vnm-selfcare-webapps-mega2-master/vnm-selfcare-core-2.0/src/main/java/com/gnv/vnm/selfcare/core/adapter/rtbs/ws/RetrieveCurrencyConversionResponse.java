
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
 *         &lt;element name="RetrieveCurrencyConversionResult" type="{http://comverse-in.com/prepaid/ccws}ArrayOfCurrencyConversionRetrieve" minOccurs="0"/&gt;
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
    "retrieveCurrencyConversionResult"
})
@XmlRootElement(name = "RetrieveCurrencyConversionResponse")
public class RetrieveCurrencyConversionResponse {

    @XmlElement(name = "RetrieveCurrencyConversionResult")
    protected ArrayOfCurrencyConversionRetrieve retrieveCurrencyConversionResult;

    /**
     * Gets the value of the retrieveCurrencyConversionResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCurrencyConversionRetrieve }
     *     
     */
    public ArrayOfCurrencyConversionRetrieve getRetrieveCurrencyConversionResult() {
        return retrieveCurrencyConversionResult;
    }

    /**
     * Sets the value of the retrieveCurrencyConversionResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCurrencyConversionRetrieve }
     *     
     */
    public void setRetrieveCurrencyConversionResult(ArrayOfCurrencyConversionRetrieve value) {
        this.retrieveCurrencyConversionResult = value;
    }

}
