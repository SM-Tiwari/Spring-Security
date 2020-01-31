
package com.gnv.vnm.selfcare.core.adapter.vasman.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VasDetailResp complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VasDetailResp"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="errorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="errorDetail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="mdn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="vasPro" type="{http://vasman.elcom.com}ArrayOfVasProductDetail" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VasDetailResp", propOrder = {
    "errorCode",
    "errorDetail",
    "mdn",
    "vasPro"
})
public class VasDetailResp {

    @XmlElementRef(name = "errorCode", namespace = "http://vasman.elcom.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> errorCode;
    @XmlElementRef(name = "errorDetail", namespace = "http://vasman.elcom.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> errorDetail;
    @XmlElementRef(name = "mdn", namespace = "http://vasman.elcom.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> mdn;
    @XmlElementRef(name = "vasPro", namespace = "http://vasman.elcom.com", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfVasProductDetail> vasPro;

    /**
     * Gets the value of the errorCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getErrorCode() {
        return errorCode;
    }

    /**
     * Sets the value of the errorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setErrorCode(JAXBElement<String> value) {
        this.errorCode = value;
    }

    /**
     * Gets the value of the errorDetail property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getErrorDetail() {
        return errorDetail;
    }

    /**
     * Sets the value of the errorDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setErrorDetail(JAXBElement<String> value) {
        this.errorDetail = value;
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
     * Gets the value of the vasPro property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfVasProductDetail }{@code >}
     *     
     */
    public JAXBElement<ArrayOfVasProductDetail> getVasPro() {
        return vasPro;
    }

    /**
     * Sets the value of the vasPro property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfVasProductDetail }{@code >}
     *     
     */
    public void setVasPro(JAXBElement<ArrayOfVasProductDetail> value) {
        this.vasPro = value;
    }

}
