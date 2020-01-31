
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RechargeAccountPIRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RechargeAccountPIRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SubscriberId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Identity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="InvokePaymentInterface" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="secreteCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RechargeAccountPIRequest", propOrder = {
    "subscriberId",
    "identity",
    "invokePaymentInterface",
    "secreteCode",
    "comment"
})
public class RechargeAccountPIRequest {

    @XmlElement(name = "SubscriberId")
    protected String subscriberId;
    @XmlElement(name = "Identity")
    protected String identity;
    @XmlElement(name = "InvokePaymentInterface")
    protected int invokePaymentInterface;
    protected String secreteCode;
    @XmlElement(name = "Comment")
    protected String comment;

    /**
     * Gets the value of the subscriberId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscriberId() {
        return subscriberId;
    }

    /**
     * Sets the value of the subscriberId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubscriberId(String value) {
        this.subscriberId = value;
    }

    /**
     * Gets the value of the identity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentity() {
        return identity;
    }

    /**
     * Sets the value of the identity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentity(String value) {
        this.identity = value;
    }

    /**
     * Gets the value of the invokePaymentInterface property.
     * 
     */
    public int getInvokePaymentInterface() {
        return invokePaymentInterface;
    }

    /**
     * Sets the value of the invokePaymentInterface property.
     * 
     */
    public void setInvokePaymentInterface(int value) {
        this.invokePaymentInterface = value;
    }

    /**
     * Gets the value of the secreteCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecreteCode() {
        return secreteCode;
    }

    /**
     * Sets the value of the secreteCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecreteCode(String value) {
        this.secreteCode = value;
    }

    /**
     * Gets the value of the comment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComment(String value) {
        this.comment = value;
    }

}
