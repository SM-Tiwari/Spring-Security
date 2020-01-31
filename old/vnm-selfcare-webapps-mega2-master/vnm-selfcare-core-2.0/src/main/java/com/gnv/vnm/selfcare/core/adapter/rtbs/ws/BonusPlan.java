
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BonusPlan complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BonusPlan"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="bonusPlanID" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="bonusPlanName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="accumulatorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="threshold" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="rewardAmount" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="targetBalanceName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="expOffset" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="chargeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="currencyISO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ServiceProvider" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ExtensionData" type="{http://comverse-in.com/prepaid/ccws}BONUSPLANEXTENSIONDATA" minOccurs="0"/&gt;
 *         &lt;element name="ExtensionDataRaw" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;any/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BonusPlan", propOrder = {
    "bonusPlanID",
    "bonusPlanName",
    "accumulatorName",
    "threshold",
    "rewardAmount",
    "targetBalanceName",
    "expOffset",
    "chargeCode",
    "currencyISO",
    "serviceProvider",
    "extensionData",
    "extensionDataRaw"
})
public class BonusPlan {

    protected long bonusPlanID;
    protected String bonusPlanName;
    protected String accumulatorName;
    protected double threshold;
    protected double rewardAmount;
    protected String targetBalanceName;
    protected long expOffset;
    protected String chargeCode;
    protected String currencyISO;
    @XmlElement(name = "ServiceProvider")
    protected String serviceProvider;
    @XmlElement(name = "ExtensionData")
    protected BONUSPLANEXTENSIONDATA extensionData;
    @XmlElement(name = "ExtensionDataRaw")
    protected BonusPlan.ExtensionDataRaw extensionDataRaw;

    /**
     * Gets the value of the bonusPlanID property.
     * 
     */
    public long getBonusPlanID() {
        return bonusPlanID;
    }

    /**
     * Sets the value of the bonusPlanID property.
     * 
     */
    public void setBonusPlanID(long value) {
        this.bonusPlanID = value;
    }

    /**
     * Gets the value of the bonusPlanName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBonusPlanName() {
        return bonusPlanName;
    }

    /**
     * Sets the value of the bonusPlanName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBonusPlanName(String value) {
        this.bonusPlanName = value;
    }

    /**
     * Gets the value of the accumulatorName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccumulatorName() {
        return accumulatorName;
    }

    /**
     * Sets the value of the accumulatorName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccumulatorName(String value) {
        this.accumulatorName = value;
    }

    /**
     * Gets the value of the threshold property.
     * 
     */
    public double getThreshold() {
        return threshold;
    }

    /**
     * Sets the value of the threshold property.
     * 
     */
    public void setThreshold(double value) {
        this.threshold = value;
    }

    /**
     * Gets the value of the rewardAmount property.
     * 
     */
    public double getRewardAmount() {
        return rewardAmount;
    }

    /**
     * Sets the value of the rewardAmount property.
     * 
     */
    public void setRewardAmount(double value) {
        this.rewardAmount = value;
    }

    /**
     * Gets the value of the targetBalanceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetBalanceName() {
        return targetBalanceName;
    }

    /**
     * Sets the value of the targetBalanceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetBalanceName(String value) {
        this.targetBalanceName = value;
    }

    /**
     * Gets the value of the expOffset property.
     * 
     */
    public long getExpOffset() {
        return expOffset;
    }

    /**
     * Sets the value of the expOffset property.
     * 
     */
    public void setExpOffset(long value) {
        this.expOffset = value;
    }

    /**
     * Gets the value of the chargeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChargeCode() {
        return chargeCode;
    }

    /**
     * Sets the value of the chargeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChargeCode(String value) {
        this.chargeCode = value;
    }

    /**
     * Gets the value of the currencyISO property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyISO() {
        return currencyISO;
    }

    /**
     * Sets the value of the currencyISO property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyISO(String value) {
        this.currencyISO = value;
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
     * Gets the value of the extensionData property.
     * 
     * @return
     *     possible object is
     *     {@link BONUSPLANEXTENSIONDATA }
     *     
     */
    public BONUSPLANEXTENSIONDATA getExtensionData() {
        return extensionData;
    }

    /**
     * Sets the value of the extensionData property.
     * 
     * @param value
     *     allowed object is
     *     {@link BONUSPLANEXTENSIONDATA }
     *     
     */
    public void setExtensionData(BONUSPLANEXTENSIONDATA value) {
        this.extensionData = value;
    }

    /**
     * Gets the value of the extensionDataRaw property.
     * 
     * @return
     *     possible object is
     *     {@link BonusPlan.ExtensionDataRaw }
     *     
     */
    public BonusPlan.ExtensionDataRaw getExtensionDataRaw() {
        return extensionDataRaw;
    }

    /**
     * Sets the value of the extensionDataRaw property.
     * 
     * @param value
     *     allowed object is
     *     {@link BonusPlan.ExtensionDataRaw }
     *     
     */
    public void setExtensionDataRaw(BonusPlan.ExtensionDataRaw value) {
        this.extensionDataRaw = value;
    }


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
     *         &lt;any/&gt;
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
        "content"
    })
    public static class ExtensionDataRaw {

        @XmlMixed
        @XmlAnyElement(lax = true)
        protected List<Object> content;

        /**
         * Gets the value of the content property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the content property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getContent().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Object }
         * {@link String }
         * 
         * 
         */
        public List<Object> getContent() {
            if (content == null) {
                content = new ArrayList<Object>();
            }
            return this.content;
        }

    }

}
