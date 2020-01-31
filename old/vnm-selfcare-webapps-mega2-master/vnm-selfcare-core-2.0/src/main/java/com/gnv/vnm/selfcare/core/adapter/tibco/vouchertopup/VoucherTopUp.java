
package com.gnv.vnm.selfcare.core.adapter.tibco.vouchertopup;

import java.util.ArrayList;
import java.util.List;

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
 *         &lt;element name="TransactionID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="MessageType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ProcCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="STAN" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="LocalTxnDtTime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="MobNum" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="VoucherNum" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="DomainID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DeliveryChannelCtrlID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ActCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Curr" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="VoucherBal" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ValidityDate" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="GraceDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="GracePeriod" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="AddonBalance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BonusBal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="VoucherDenom" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="MessageID" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="LanguageID" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Priority" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="BusinessHourIndicator" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="VlrId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CellId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "transactionID",
    "messageType",
    "procCode",
    "stan",
    "localTxnDtTime",
    "mobNum",
    "voucherNum",
    "domainID",
    "deliveryChannelCtrlID",
    "actCode",
    "curr",
    "voucherBal",
    "validityDate",
    "graceDate",
    "gracePeriod",
    "addonBalance",
    "bonusBal",
    "voucherDenom",
    "messageID",
    "languageID",
    "priority",
    "businessHourIndicator",
    "vlrId",
    "cellId"
})
@XmlRootElement(name = "VoucherTopUp", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4")
public class VoucherTopUp {

    @XmlElement(name = "TransactionID", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4", required = true)
    protected String transactionID;
    @XmlElement(name = "MessageType", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4", required = true)
    protected String messageType;
    @XmlElement(name = "ProcCode", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4", required = true)
    protected String procCode;
    @XmlElement(name = "STAN", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4", required = true)
    protected String stan;
    @XmlElement(name = "LocalTxnDtTime", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4", required = true)
    protected String localTxnDtTime;
    @XmlElement(name = "MobNum", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4", required = true)
    protected String mobNum;
    @XmlElement(name = "VoucherNum", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4", required = true)
    protected String voucherNum;
    @XmlElement(name = "DomainID", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4")
    protected String domainID;
    @XmlElement(name = "DeliveryChannelCtrlID", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4", required = true)
    protected String deliveryChannelCtrlID;
    @XmlElement(name = "ActCode", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4", required = true)
    protected String actCode;
    @XmlElement(name = "Curr", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4", required = true)
    protected String curr;
    @XmlElement(name = "VoucherBal", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4", required = true)
    protected String voucherBal;
    @XmlElement(name = "ValidityDate", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4", required = true)
    protected String validityDate;
    @XmlElement(name = "GraceDate", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4")
    protected String graceDate;
    @XmlElement(name = "GracePeriod", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4", required = true)
    protected String gracePeriod;
    @XmlElement(name = "AddonBalance", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4")
    protected String addonBalance;
    @XmlElement(name = "BonusBal", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4")
    protected String bonusBal;
    @XmlElement(name = "VoucherDenom", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4", required = true)
    protected String voucherDenom;
    @XmlElement(name = "MessageID", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4")
    protected List<String> messageID;
    @XmlElement(name = "LanguageID", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4")
    protected List<String> languageID;
    @XmlElement(name = "Priority", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4")
    protected List<String> priority;
    @XmlElement(name = "BusinessHourIndicator", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4")
    protected List<String> businessHourIndicator;
    @XmlElement(name = "VlrId", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4")
    protected String vlrId;
    @XmlElement(name = "CellId", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4")
    protected String cellId;

    /**
     * Gets the value of the transactionID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionID() {
        return transactionID;
    }

    /**
     * Sets the value of the transactionID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionID(String value) {
        this.transactionID = value;
    }

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
     * Gets the value of the voucherNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVoucherNum() {
        return voucherNum;
    }

    /**
     * Sets the value of the voucherNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVoucherNum(String value) {
        this.voucherNum = value;
    }

    /**
     * Gets the value of the domainID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDomainID() {
        return domainID;
    }

    /**
     * Sets the value of the domainID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomainID(String value) {
        this.domainID = value;
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
     * Gets the value of the actCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActCode() {
        return actCode;
    }

    /**
     * Sets the value of the actCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActCode(String value) {
        this.actCode = value;
    }

    /**
     * Gets the value of the curr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurr() {
        return curr;
    }

    /**
     * Sets the value of the curr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurr(String value) {
        this.curr = value;
    }

    /**
     * Gets the value of the voucherBal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVoucherBal() {
        return voucherBal;
    }

    /**
     * Sets the value of the voucherBal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVoucherBal(String value) {
        this.voucherBal = value;
    }

    /**
     * Gets the value of the validityDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidityDate() {
        return validityDate;
    }

    /**
     * Sets the value of the validityDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidityDate(String value) {
        this.validityDate = value;
    }

    /**
     * Gets the value of the graceDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGraceDate() {
        return graceDate;
    }

    /**
     * Sets the value of the graceDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGraceDate(String value) {
        this.graceDate = value;
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

    /**
     * Gets the value of the voucherDenom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVoucherDenom() {
        return voucherDenom;
    }

    /**
     * Sets the value of the voucherDenom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVoucherDenom(String value) {
        this.voucherDenom = value;
    }

    /**
     * Gets the value of the messageID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the messageID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMessageID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getMessageID() {
        if (messageID == null) {
            messageID = new ArrayList<String>();
        }
        return this.messageID;
    }

    /**
     * Gets the value of the languageID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the languageID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLanguageID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getLanguageID() {
        if (languageID == null) {
            languageID = new ArrayList<String>();
        }
        return this.languageID;
    }

    /**
     * Gets the value of the priority property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the priority property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPriority().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPriority() {
        if (priority == null) {
            priority = new ArrayList<String>();
        }
        return this.priority;
    }

    /**
     * Gets the value of the businessHourIndicator property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the businessHourIndicator property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBusinessHourIndicator().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getBusinessHourIndicator() {
        if (businessHourIndicator == null) {
            businessHourIndicator = new ArrayList<String>();
        }
        return this.businessHourIndicator;
    }

    /**
     * Gets the value of the vlrId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVlrId() {
        return vlrId;
    }

    /**
     * Sets the value of the vlrId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVlrId(String value) {
        this.vlrId = value;
    }

    /**
     * Gets the value of the cellId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCellId() {
        return cellId;
    }

    /**
     * Sets the value of the cellId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCellId(String value) {
        this.cellId = value;
    }

}
