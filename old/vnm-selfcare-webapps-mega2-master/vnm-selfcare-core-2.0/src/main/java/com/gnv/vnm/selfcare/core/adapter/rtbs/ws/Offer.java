
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Offer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Offer"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://comverse-in.com/prepaid/ccws}OfferBase"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FirstAvailabilityDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="LastAvailabilityDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Type" type="{http://comverse-in.com/prepaid/ccws}Offer_Type"/&gt;
 *         &lt;element name="ServiceProvider" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MarketSegments" type="{http://comverse-in.com/prepaid/ccws}ArrayOfString" minOccurs="0"/&gt;
 *         &lt;element name="Currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nrcActivation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nrcEarlyTermination" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BonusPlan" type="{http://comverse-in.com/prepaid/ccws}ArrayOfString" minOccurs="0"/&gt;
 *         &lt;element name="DiscountPlan" type="{http://comverse-in.com/prepaid/ccws}ArrayOfString" minOccurs="0"/&gt;
 *         &lt;element name="Balances" type="{http://comverse-in.com/prepaid/ccws}ArrayOfString" minOccurs="0"/&gt;
 *         &lt;element name="ivrType" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="ivrCharge" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="ivrDescPrompt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ivrNamePrompt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ServiceDuration" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Offer", propOrder = {
    "firstAvailabilityDate",
    "lastAvailabilityDate",
    "id",
    "description",
    "type",
    "serviceProvider",
    "marketSegments",
    "currency",
    "rc",
    "nrcActivation",
    "nrcEarlyTermination",
    "bonusPlan",
    "discountPlan",
    "balances",
    "ivrType",
    "ivrCharge",
    "ivrDescPrompt",
    "ivrNamePrompt",
    "serviceDuration"
})
public class Offer
    extends OfferBase
{

    @XmlElement(name = "FirstAvailabilityDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar firstAvailabilityDate;
    @XmlElement(name = "LastAvailabilityDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastAvailabilityDate;
    @XmlElement(name = "ID")
    protected long id;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "Type", required = true)
    @XmlSchemaType(name = "string")
    protected OfferType type;
    @XmlElement(name = "ServiceProvider")
    protected String serviceProvider;
    @XmlElement(name = "MarketSegments")
    protected ArrayOfString marketSegments;
    @XmlElement(name = "Currency")
    protected String currency;
    @XmlElement(name = "RC")
    protected String rc;
    protected String nrcActivation;
    protected String nrcEarlyTermination;
    @XmlElement(name = "BonusPlan")
    protected ArrayOfString bonusPlan;
    @XmlElement(name = "DiscountPlan")
    protected ArrayOfString discountPlan;
    @XmlElement(name = "Balances")
    protected ArrayOfString balances;
    protected long ivrType;
    protected double ivrCharge;
    protected String ivrDescPrompt;
    protected String ivrNamePrompt;
    @XmlElement(name = "ServiceDuration")
    protected long serviceDuration;

    /**
     * Gets the value of the firstAvailabilityDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFirstAvailabilityDate() {
        return firstAvailabilityDate;
    }

    /**
     * Sets the value of the firstAvailabilityDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFirstAvailabilityDate(XMLGregorianCalendar value) {
        this.firstAvailabilityDate = value;
    }

    /**
     * Gets the value of the lastAvailabilityDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastAvailabilityDate() {
        return lastAvailabilityDate;
    }

    /**
     * Sets the value of the lastAvailabilityDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastAvailabilityDate(XMLGregorianCalendar value) {
        this.lastAvailabilityDate = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public long getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setID(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link OfferType }
     *     
     */
    public OfferType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link OfferType }
     *     
     */
    public void setType(OfferType value) {
        this.type = value;
    }

    /**
     * Gets the value of the serviceProvider property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceProvider() {
        return serviceProvider;
    }

    /**
     * Sets the value of the serviceProvider property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceProvider(String value) {
        this.serviceProvider = value;
    }

    /**
     * Gets the value of the marketSegments property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getMarketSegments() {
        return marketSegments;
    }

    /**
     * Sets the value of the marketSegments property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setMarketSegments(ArrayOfString value) {
        this.marketSegments = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

    /**
     * Gets the value of the rc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRC() {
        return rc;
    }

    /**
     * Sets the value of the rc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRC(String value) {
        this.rc = value;
    }

    /**
     * Gets the value of the nrcActivation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNrcActivation() {
        return nrcActivation;
    }

    /**
     * Sets the value of the nrcActivation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNrcActivation(String value) {
        this.nrcActivation = value;
    }

    /**
     * Gets the value of the nrcEarlyTermination property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNrcEarlyTermination() {
        return nrcEarlyTermination;
    }

    /**
     * Sets the value of the nrcEarlyTermination property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNrcEarlyTermination(String value) {
        this.nrcEarlyTermination = value;
    }

    /**
     * Gets the value of the bonusPlan property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getBonusPlan() {
        return bonusPlan;
    }

    /**
     * Sets the value of the bonusPlan property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setBonusPlan(ArrayOfString value) {
        this.bonusPlan = value;
    }

    /**
     * Gets the value of the discountPlan property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getDiscountPlan() {
        return discountPlan;
    }

    /**
     * Sets the value of the discountPlan property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setDiscountPlan(ArrayOfString value) {
        this.discountPlan = value;
    }

    /**
     * Gets the value of the balances property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getBalances() {
        return balances;
    }

    /**
     * Sets the value of the balances property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setBalances(ArrayOfString value) {
        this.balances = value;
    }

    /**
     * Gets the value of the ivrType property.
     * 
     */
    public long getIvrType() {
        return ivrType;
    }

    /**
     * Sets the value of the ivrType property.
     * 
     */
    public void setIvrType(long value) {
        this.ivrType = value;
    }

    /**
     * Gets the value of the ivrCharge property.
     * 
     */
    public double getIvrCharge() {
        return ivrCharge;
    }

    /**
     * Sets the value of the ivrCharge property.
     * 
     */
    public void setIvrCharge(double value) {
        this.ivrCharge = value;
    }

    /**
     * Gets the value of the ivrDescPrompt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIvrDescPrompt() {
        return ivrDescPrompt;
    }

    /**
     * Sets the value of the ivrDescPrompt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIvrDescPrompt(String value) {
        this.ivrDescPrompt = value;
    }

    /**
     * Gets the value of the ivrNamePrompt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIvrNamePrompt() {
        return ivrNamePrompt;
    }

    /**
     * Sets the value of the ivrNamePrompt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIvrNamePrompt(String value) {
        this.ivrNamePrompt = value;
    }

    /**
     * Gets the value of the serviceDuration property.
     * 
     */
    public long getServiceDuration() {
        return serviceDuration;
    }

    /**
     * Sets the value of the serviceDuration property.
     * 
     */
    public void setServiceDuration(long value) {
        this.serviceDuration = value;
    }

}
