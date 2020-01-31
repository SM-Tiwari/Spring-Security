
package com.gnv.vnm.selfcare.core.adapter.tibco.etopup;

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
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12}MessageType" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12}DeliveryChannelCtrlID" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12}ProcCode" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12}STAN" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12}LocalTxnDtTime" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12}MobNum" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12}Currency" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12}ValidityDays" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12}GracePeriod" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12}OriginalAmount" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12}TopUpAmount" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12}AddonBalance" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12}BonusBal" minOccurs="0"/&gt;
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
    "messageType",
    "deliveryChannelCtrlID",
    "procCode",
    "stan",
    "localTxnDtTime",
    "mobNum",
    "currency",
    "validityDays",
    "gracePeriod",
    "originalAmount",
    "topUpAmount",
    "addonBalance",
    "bonusBal"
})
@XmlRootElement(name = "EtopUp_Request", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12")
public class EtopUpRequest {

    @XmlElement(name = "MessageType", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12")
    protected String messageType;
    @XmlElement(name = "DeliveryChannelCtrlID", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12")
    protected String deliveryChannelCtrlID;
    @XmlElement(name = "ProcCode", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12")
    protected String procCode;
    @XmlElement(name = "STAN", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12")
    protected String stan;
    @XmlElement(name = "LocalTxnDtTime", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12")
    protected String localTxnDtTime;
    @XmlElement(name = "MobNum", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12")
    protected String mobNum;
    @XmlElement(name = "Currency", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12")
    protected String currency;
    @XmlElement(name = "ValidityDays", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12")
    protected String validityDays;
    @XmlElement(name = "GracePeriod", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12")
    protected String gracePeriod;
    @XmlElement(name = "OriginalAmount", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12")
    protected String originalAmount;
    @XmlElement(name = "TopUpAmount", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12")
    protected String topUpAmount;
    @XmlElement(name = "AddonBalance", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12")
    protected String addonBalance;
    @XmlElement(name = "BonusBal", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/EPOS/Schema.xsd12")
    protected String bonusBal;

    /**
     * Gets the value of the messageType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageType() {
        return messageType;
    }

    /**
     * Sets the value of the messageType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageType(String value) {
        this.messageType = value;
    }

    /**
     * Gets the value of the deliveryChannelCtrlID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliveryChannelCtrlID() {
        return deliveryChannelCtrlID;
    }

    /**
     * Sets the value of the deliveryChannelCtrlID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliveryChannelCtrlID(String value) {
        this.deliveryChannelCtrlID = value;
    }

    /**
     * Gets the value of the procCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcCode() {
        return procCode;
    }

    /**
     * Sets the value of the procCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcCode(String value) {
        this.procCode = value;
    }

    /**
     * Gets the value of the stan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTAN() {
        return stan;
    }

    /**
     * Sets the value of the stan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTAN(String value) {
        this.stan = value;
    }

    /**
     * Gets the value of the localTxnDtTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalTxnDtTime() {
        return localTxnDtTime;
    }

    /**
     * Sets the value of the localTxnDtTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalTxnDtTime(String value) {
        this.localTxnDtTime = value;
    }

    /**
     * Gets the value of the mobNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobNum() {
        return mobNum;
    }

    /**
     * Sets the value of the mobNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobNum(String value) {
        this.mobNum = value;
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
     * Gets the value of the validityDays property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidityDays() {
        return validityDays;
    }

    /**
     * Sets the value of the validityDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidityDays(String value) {
        this.validityDays = value;
    }

    /**
     * Gets the value of the gracePeriod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGracePeriod() {
        return gracePeriod;
    }

    /**
     * Sets the value of the gracePeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGracePeriod(String value) {
        this.gracePeriod = value;
    }

    /**
     * Gets the value of the originalAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalAmount() {
        return originalAmount;
    }

    /**
     * Sets the value of the originalAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalAmount(String value) {
        this.originalAmount = value;
    }

    /**
     * Gets the value of the topUpAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTopUpAmount() {
        return topUpAmount;
    }

    /**
     * Sets the value of the topUpAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTopUpAmount(String value) {
        this.topUpAmount = value;
    }

    /**
     * Gets the value of the addonBalance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddonBalance() {
        return addonBalance;
    }

    /**
     * Sets the value of the addonBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddonBalance(String value) {
        this.addonBalance = value;
    }

    /**
     * Gets the value of the bonusBal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBonusBal() {
        return bonusBal;
    }

    /**
     * Sets the value of the bonusBal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBonusBal(String value) {
        this.bonusBal = value;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EtopUpRequest [messageType=");
		builder.append(messageType);
		builder.append(", deliveryChannelCtrlID=");
		builder.append(deliveryChannelCtrlID);
		builder.append(", procCode=");
		builder.append(procCode);
		builder.append(", stan=");
		builder.append(stan);
		builder.append(", localTxnDtTime=");
		builder.append(localTxnDtTime);
		builder.append(", mobNum=");
		builder.append(mobNum);
		builder.append(", currency=");
		builder.append(currency);
		builder.append(", validityDays=");
		builder.append(validityDays);
		builder.append(", gracePeriod=");
		builder.append(gracePeriod);
		builder.append(", originalAmount=");
		builder.append(originalAmount);
		builder.append(", topUpAmount=");
		builder.append(topUpAmount);
		builder.append(", addonBalance=");
		builder.append(addonBalance);
		builder.append(", bonusBal=");
		builder.append(bonusBal);
		builder.append("]");
		return builder.toString();
	}

    
}
