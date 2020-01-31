
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ForgiveSubscriberDebtRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ForgiveSubscriberDebtRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SubscriberId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DaysInSuspension" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="RefundOption" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AdjustmentAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ConfiscateBenefits" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ForgiveSubscriberDebtRequest", propOrder = {
    "subscriberId",
    "daysInSuspension",
    "refundOption",
    "adjustmentAmount",
    "confiscateBenefits"
})
public class ForgiveSubscriberDebtRequest {

    @XmlElement(name = "SubscriberId")
    protected String subscriberId;
    @XmlElement(name = "DaysInSuspension")
    protected long daysInSuspension;
    @XmlElement(name = "RefundOption")
    protected String refundOption;
    @XmlElement(name = "AdjustmentAmount")
    protected String adjustmentAmount;
    @XmlElement(name = "ConfiscateBenefits")
    protected String confiscateBenefits;

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
     * Gets the value of the daysInSuspension property.
     * 
     */
    public long getDaysInSuspension() {
        return daysInSuspension;
    }

    /**
     * Sets the value of the daysInSuspension property.
     * 
     */
    public void setDaysInSuspension(long value) {
        this.daysInSuspension = value;
    }

    /**
     * Gets the value of the refundOption property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefundOption() {
        return refundOption;
    }

    /**
     * Sets the value of the refundOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefundOption(String value) {
        this.refundOption = value;
    }

    /**
     * Gets the value of the adjustmentAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdjustmentAmount() {
        return adjustmentAmount;
    }

    /**
     * Sets the value of the adjustmentAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdjustmentAmount(String value) {
        this.adjustmentAmount = value;
    }

    /**
     * Gets the value of the confiscateBenefits property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfiscateBenefits() {
        return confiscateBenefits;
    }

    /**
     * Sets the value of the confiscateBenefits property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfiscateBenefits(String value) {
        this.confiscateBenefits = value;
    }

}
