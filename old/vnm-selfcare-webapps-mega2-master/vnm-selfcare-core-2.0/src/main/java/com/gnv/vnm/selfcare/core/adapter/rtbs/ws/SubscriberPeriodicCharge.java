
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for SubscriberPeriodicCharge complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubscriberPeriodicCharge"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PeriodicChargeID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RemainingApplications" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="FirstChargeApplied" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="LastChargeDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="ApplyDay" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="PostActiveChargeApplied" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubscriberPeriodicCharge", propOrder = {
    "periodicChargeID",
    "remainingApplications",
    "startDate",
    "endDate",
    "firstChargeApplied",
    "lastChargeDate",
    "applyDay",
    "postActiveChargeApplied"
})
public class SubscriberPeriodicCharge {

    @XmlElement(name = "PeriodicChargeID")
    protected String periodicChargeID;
    @XmlElement(name = "RemainingApplications")
    protected int remainingApplications;
    @XmlElement(name = "StartDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startDate;
    @XmlElement(name = "EndDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endDate;
    @XmlElement(name = "FirstChargeApplied")
    protected boolean firstChargeApplied;
    @XmlElement(name = "LastChargeDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastChargeDate;
    @XmlElement(name = "ApplyDay")
    protected long applyDay;
    @XmlElement(name = "PostActiveChargeApplied")
    protected String postActiveChargeApplied;

    /**
     * Gets the value of the periodicChargeID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeriodicChargeID() {
        return periodicChargeID;
    }

    /**
     * Sets the value of the periodicChargeID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeriodicChargeID(String value) {
        this.periodicChargeID = value;
    }

    /**
     * Gets the value of the remainingApplications property.
     * 
     */
    public int getRemainingApplications() {
        return remainingApplications;
    }

    /**
     * Sets the value of the remainingApplications property.
     * 
     */
    public void setRemainingApplications(int value) {
        this.remainingApplications = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the firstChargeApplied property.
     * 
     */
    public boolean isFirstChargeApplied() {
        return firstChargeApplied;
    }

    /**
     * Sets the value of the firstChargeApplied property.
     * 
     */
    public void setFirstChargeApplied(boolean value) {
        this.firstChargeApplied = value;
    }

    /**
     * Gets the value of the lastChargeDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastChargeDate() {
        return lastChargeDate;
    }

    /**
     * Sets the value of the lastChargeDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastChargeDate(XMLGregorianCalendar value) {
        this.lastChargeDate = value;
    }

    /**
     * Gets the value of the applyDay property.
     * 
     */
    public long getApplyDay() {
        return applyDay;
    }

    /**
     * Sets the value of the applyDay property.
     * 
     */
    public void setApplyDay(long value) {
        this.applyDay = value;
    }

    /**
     * Gets the value of the postActiveChargeApplied property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostActiveChargeApplied() {
        return postActiveChargeApplied;
    }

    /**
     * Sets the value of the postActiveChargeApplied property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostActiveChargeApplied(String value) {
        this.postActiveChargeApplied = value;
    }

}
