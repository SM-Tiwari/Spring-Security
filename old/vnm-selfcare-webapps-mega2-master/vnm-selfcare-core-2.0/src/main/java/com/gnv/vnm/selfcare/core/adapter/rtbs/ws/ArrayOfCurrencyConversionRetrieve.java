
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfCurrencyConversionRetrieve complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfCurrencyConversionRetrieve"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CurrencyConversionRetrieve" type="{http://comverse-in.com/prepaid/ccws}CurrencyConversionRetrieve" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCurrencyConversionRetrieve", propOrder = {
    "currencyConversionRetrieve"
})
public class ArrayOfCurrencyConversionRetrieve {

    @XmlElement(name = "CurrencyConversionRetrieve", nillable = true)
    protected List<CurrencyConversionRetrieve> currencyConversionRetrieve;

    /**
     * Gets the value of the currencyConversionRetrieve property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the currencyConversionRetrieve property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCurrencyConversionRetrieve().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CurrencyConversionRetrieve }
     * 
     * 
     */
    public List<CurrencyConversionRetrieve> getCurrencyConversionRetrieve() {
        if (currencyConversionRetrieve == null) {
            currencyConversionRetrieve = new ArrayList<CurrencyConversionRetrieve>();
        }
        return this.currencyConversionRetrieve;
    }

}
