
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for AccumulatorEntity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccumulatorEntity"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://comverse-in.com/prepaid/ccws}AccumulatorBase"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ZeroDay" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="Period" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="CurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NextResetAccumulatorTS" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccumulatorEntity", propOrder = {
    "zeroDay",
    "period",
    "currencyCode",
    "nextResetAccumulatorTS"
})
public class AccumulatorEntity
    extends AccumulatorBase
{

    @XmlElement(name = "ZeroDay")
    protected int zeroDay;
    @XmlElement(name = "Period")
    protected int period;
    @XmlElement(name = "CurrencyCode")
    protected String currencyCode;
    @XmlElement(name = "NextResetAccumulatorTS", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar nextResetAccumulatorTS;

    /**
     * Gets the value of the zeroDay property.
     * 
     */
    public int getZeroDay() {
        return zeroDay;
    }

    /**
     * Sets the value of the zeroDay property.
     * 
     */
    public void setZeroDay(int value) {
        this.zeroDay = value;
    }

    /**
     * Gets the value of the period property.
     * 
     */
    public int getPeriod() {
        return period;
    }

    /**
     * Sets the value of the period property.
     * 
     */
    public void setPeriod(int value) {
        this.period = value;
    }

    /**
     * Gets the value of the currencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the value of the currencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyCode(String value) {
        this.currencyCode = value;
    }

    /**
     * Gets the value of the nextResetAccumulatorTS property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getNextResetAccumulatorTS() {
        return nextResetAccumulatorTS;
    }

    /**
     * Sets the value of the nextResetAccumulatorTS property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setNextResetAccumulatorTS(XMLGregorianCalendar value) {
        this.nextResetAccumulatorTS = value;
    }

}
