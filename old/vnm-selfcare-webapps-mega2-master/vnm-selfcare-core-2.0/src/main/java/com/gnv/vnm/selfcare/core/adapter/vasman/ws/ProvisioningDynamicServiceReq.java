
package com.gnv.vnm.selfcare.core.adapter.vasman.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProvisioningDynamicServiceReq complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProvisioningDynamicServiceReq"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="chargingAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="cmdID" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="dataAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="extendDate" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="listBalance" type="{http://vasman.elcom.com}ArrayOfBalanceRequest" minOccurs="0"/&gt;
 *         &lt;element name="mdn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="pass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="user" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="vasID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProvisioningDynamicServiceReq", propOrder = {
    "sDescription",
    "chargingAmount",
    "cmdID",
    "dataAmount",
    "extendDate",
    "listBalance",
    "mdn",
    "pass",
    "user",
    "vasID"
})
public class ProvisioningDynamicServiceReq {

    @XmlElementRef(name = "SDescription", namespace = "http://vasman.elcom.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sDescription;
    protected Double chargingAmount;
    protected Integer cmdID;
    protected Double dataAmount;
    protected Long extendDate;
    @XmlElementRef(name = "listBalance", namespace = "http://vasman.elcom.com", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfBalanceRequest> listBalance;
    @XmlElementRef(name = "mdn", namespace = "http://vasman.elcom.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> mdn;
    @XmlElementRef(name = "pass", namespace = "http://vasman.elcom.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> pass;
    @XmlElementRef(name = "user", namespace = "http://vasman.elcom.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> user;
    @XmlElementRef(name = "vasID", namespace = "http://vasman.elcom.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> vasID;

    /**
     * Gets the value of the sDescription property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSDescription() {
        return sDescription;
    }

    /**
     * Sets the value of the sDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSDescription(JAXBElement<String> value) {
        this.sDescription = value;
    }

    /**
     * Gets the value of the chargingAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getChargingAmount() {
        return chargingAmount;
    }

    /**
     * Sets the value of the chargingAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setChargingAmount(Double value) {
        this.chargingAmount = value;
    }

    /**
     * Gets the value of the cmdID property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCmdID() {
        return cmdID;
    }

    /**
     * Sets the value of the cmdID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCmdID(Integer value) {
        this.cmdID = value;
    }

    /**
     * Gets the value of the dataAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDataAmount() {
        return dataAmount;
    }

    /**
     * Sets the value of the dataAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDataAmount(Double value) {
        this.dataAmount = value;
    }

    /**
     * Gets the value of the extendDate property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getExtendDate() {
        return extendDate;
    }

    /**
     * Sets the value of the extendDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setExtendDate(Long value) {
        this.extendDate = value;
    }

    /**
     * Gets the value of the listBalance property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfBalanceRequest }{@code >}
     *     
     */
    public JAXBElement<ArrayOfBalanceRequest> getListBalance() {
        return listBalance;
    }

    /**
     * Sets the value of the listBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfBalanceRequest }{@code >}
     *     
     */
    public void setListBalance(JAXBElement<ArrayOfBalanceRequest> value) {
        this.listBalance = value;
    }

    /**
     * Gets the value of the mdn property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMdn() {
        return mdn;
    }

    /**
     * Sets the value of the mdn property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMdn(JAXBElement<String> value) {
        this.mdn = value;
    }

    /**
     * Gets the value of the pass property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPass() {
        return pass;
    }

    /**
     * Sets the value of the pass property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPass(JAXBElement<String> value) {
        this.pass = value;
    }

    /**
     * Gets the value of the user property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUser(JAXBElement<String> value) {
        this.user = value;
    }

    /**
     * Gets the value of the vasID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getVasID() {
        return vasID;
    }

    /**
     * Sets the value of the vasID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setVasID(JAXBElement<String> value) {
        this.vasID = value;
    }

}
