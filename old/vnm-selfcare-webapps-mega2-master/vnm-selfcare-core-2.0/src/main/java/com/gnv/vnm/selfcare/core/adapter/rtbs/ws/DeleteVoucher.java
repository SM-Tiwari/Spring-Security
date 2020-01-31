
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="batchNumber" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="startSerial" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="endSerial" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "batchNumber",
    "startSerial",
    "endSerial"
})
@XmlRootElement(name = "DeleteVoucher")
public class DeleteVoucher {

    @XmlElement(required = true)
    protected BigDecimal batchNumber;
    @XmlElement(required = true)
    protected BigDecimal startSerial;
    @XmlElement(required = true)
    protected BigDecimal endSerial;

    /**
     * Gets the value of the batchNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBatchNumber() {
        return batchNumber;
    }

    /**
     * Sets the value of the batchNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBatchNumber(BigDecimal value) {
        this.batchNumber = value;
    }

    /**
     * Gets the value of the startSerial property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getStartSerial() {
        return startSerial;
    }

    /**
     * Sets the value of the startSerial property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setStartSerial(BigDecimal value) {
        this.startSerial = value;
    }

    /**
     * Gets the value of the endSerial property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getEndSerial() {
        return endSerial;
    }

    /**
     * Sets the value of the endSerial property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setEndSerial(BigDecimal value) {
        this.endSerial = value;
    }

}
