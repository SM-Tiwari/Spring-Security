
package com.gnv.vnm.selfcare.core.adapter.loyalty.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LoyaltyResp complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LoyaltyResp"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="errorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="errorDetail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="isdn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoyaltyResp", propOrder = {
    "errorCode",
    "errorDetail",
    "isdn"
})
public class LoyaltyResp {

    @XmlElementRef(name = "errorCode", namespace = "http://loyalty.elcom.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> errorCode;
    @XmlElementRef(name = "errorDetail", namespace = "http://loyalty.elcom.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> errorDetail;
    @XmlElementRef(name = "isdn", namespace = "http://loyalty.elcom.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> isdn;

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
     * Gets the value of the isdn property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIsdn() {
        return isdn;
    }

    /**
     * Sets the value of the isdn property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIsdn(JAXBElement<String> value) {
        this.isdn = value;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoyaltyResp [errorCode=");
		builder.append(errorCode != null ? errorCode.getValue() : null);
		builder.append(", errorDetail=");
		builder.append(errorDetail != null ? errorDetail.getValue() : null);
		builder.append(", isdn=");
		builder.append(isdn != null ? isdn.getValue() : null);
		builder.append("]");
		return builder.toString();
	}

}