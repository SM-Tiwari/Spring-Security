
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CurrencyConversionCreate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CurrencyConversionCreate"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://comverse-in.com/prepaid/ccws}CurrencyConversionDelete"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IntermediaryCurrency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CurrencyConversionRate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CurrencyConversionCreate", propOrder = {
    "intermediaryCurrency",
    "currencyConversionRate"
})
@XmlSeeAlso({
    CurrencyConversionModify.class,
    CurrencyConversionRetrieve.class
})
public class CurrencyConversionCreate
    extends CurrencyConversionDelete
{

    @XmlElement(name = "IntermediaryCurrency")
    protected String intermediaryCurrency;
    @XmlElement(name = "CurrencyConversionRate")
    protected String currencyConversionRate;

    /**
     * Gets the value of the intermediaryCurrency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntermediaryCurrency() {
        return intermediaryCurrency;
    }

    /**
     * Sets the value of the intermediaryCurrency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntermediaryCurrency(String value) {
        this.intermediaryCurrency = value;
    }

    /**
     * Gets the value of the currencyConversionRate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyConversionRate() {
        return currencyConversionRate;
    }

    /**
     * Sets the value of the currencyConversionRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyConversionRate(String value) {
        this.currencyConversionRate = value;
    }

}
