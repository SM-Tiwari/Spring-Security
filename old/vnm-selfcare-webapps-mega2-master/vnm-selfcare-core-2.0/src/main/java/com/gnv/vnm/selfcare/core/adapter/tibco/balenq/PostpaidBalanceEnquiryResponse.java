
package com.gnv.vnm.selfcare.core.adapter.tibco.balenq;

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
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2}BillingSubscriptionStatus" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2}TotalBal" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2}MainBalance" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2}OnNetBal" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2}OffNetBal" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2}TotalUnbilledUsage" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2}TotalOutstandingBalance" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2}DueDate" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2}TotalUnpaid" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2}DepositedAmount" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2}NotificationCreditLimit" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2}MessageId" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2}LanguageId" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2}Priority" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2}BusinessHourIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2}Status"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2}StatusText"/&gt;
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
    "billingSubscriptionStatus",
    "totalBal",
    "mainBalance",
    "onNetBal",
    "offNetBal",
    "totalUnbilledUsage",
    "totalOutstandingBalance",
    "dueDate",
    "totalUnpaid",
    "depositedAmount",
    "notificationCreditLimit",
    "messageId",
    "languageId",
    "priority",
    "businessHourIndicator",
    "status",
    "statusText"
})
@XmlRootElement(name = "Response", namespace = "http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2")
public class PostpaidBalanceEnquiryResponse {

    @XmlElement(name = "BillingSubscriptionStatus", namespace = "http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2")
    protected String billingSubscriptionStatus;
    @XmlElement(name = "TotalBal", namespace = "http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2")
    protected String totalBal;
    @XmlElement(name = "MainBalance", namespace = "http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2")
    protected String mainBalance;
    @XmlElement(name = "OnNetBal", namespace = "http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2")
    protected String onNetBal;
    @XmlElement(name = "OffNetBal", namespace = "http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2")
    protected String offNetBal;
    @XmlElement(name = "TotalUnbilledUsage", namespace = "http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2")
    protected String totalUnbilledUsage;
    @XmlElement(name = "TotalOutstandingBalance", namespace = "http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2")
    protected String totalOutstandingBalance;
    @XmlElement(name = "DueDate", namespace = "http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2")
    protected String dueDate;
    @XmlElement(name = "TotalUnpaid", namespace = "http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2")
    protected String totalUnpaid;
    @XmlElement(name = "DepositedAmount", namespace = "http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2")
    protected String depositedAmount;
    @XmlElement(name = "NotificationCreditLimit", namespace = "http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2")
    protected String notificationCreditLimit;
    @XmlElement(name = "MessageId", namespace = "http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2")
    protected String messageId;
    @XmlElement(name = "LanguageId", namespace = "http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2")
    protected String languageId;
    @XmlElement(name = "Priority", namespace = "http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2")
    protected String priority;
    @XmlElement(name = "BusinessHourIndicator", namespace = "http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2")
    protected String businessHourIndicator;
    @XmlElement(name = "Status", namespace = "http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2", required = true)
    protected String status;
    @XmlElement(name = "StatusText", namespace = "http://www.tibco.com/schemas/VNM_PROJECT_UAT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd2", required = true)
    protected String statusText;

    /**
     * Gets the value of the billingSubscriptionStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillingSubscriptionStatus() {
        return billingSubscriptionStatus;
    }

    /**
     * Sets the value of the billingSubscriptionStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillingSubscriptionStatus(String value) {
        this.billingSubscriptionStatus = value;
    }

    /**
     * Gets the value of the totalBal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalBal() {
        return totalBal;
    }

    /**
     * Sets the value of the totalBal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalBal(String value) {
        this.totalBal = value;
    }

    /**
     * Gets the value of the mainBalance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMainBalance() {
        return mainBalance;
    }

    /**
     * Sets the value of the mainBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMainBalance(String value) {
        this.mainBalance = value;
    }

    /**
     * Gets the value of the onNetBal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnNetBal() {
        return onNetBal;
    }

    /**
     * Sets the value of the onNetBal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnNetBal(String value) {
        this.onNetBal = value;
    }

    /**
     * Gets the value of the offNetBal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOffNetBal() {
        return offNetBal;
    }

    /**
     * Sets the value of the offNetBal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOffNetBal(String value) {
        this.offNetBal = value;
    }

    /**
     * Gets the value of the totalUnbilledUsage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalUnbilledUsage() {
        return totalUnbilledUsage;
    }

    /**
     * Sets the value of the totalUnbilledUsage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalUnbilledUsage(String value) {
        this.totalUnbilledUsage = value;
    }

    /**
     * Gets the value of the totalOutstandingBalance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalOutstandingBalance() {
        return totalOutstandingBalance;
    }

    /**
     * Sets the value of the totalOutstandingBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalOutstandingBalance(String value) {
        this.totalOutstandingBalance = value;
    }

    /**
     * Gets the value of the dueDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDueDate() {
        return dueDate;
    }

    /**
     * Sets the value of the dueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDueDate(String value) {
        this.dueDate = value;
    }

    /**
     * Gets the value of the totalUnpaid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalUnpaid() {
        return totalUnpaid;
    }

    /**
     * Sets the value of the totalUnpaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalUnpaid(String value) {
        this.totalUnpaid = value;
    }

    /**
     * Gets the value of the depositedAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepositedAmount() {
        return depositedAmount;
    }

    /**
     * Sets the value of the depositedAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepositedAmount(String value) {
        this.depositedAmount = value;
    }

    /**
     * Gets the value of the notificationCreditLimit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotificationCreditLimit() {
        return notificationCreditLimit;
    }

    /**
     * Sets the value of the notificationCreditLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotificationCreditLimit(String value) {
        this.notificationCreditLimit = value;
    }

    /**
     * Gets the value of the messageId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * Sets the value of the messageId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageId(String value) {
        this.messageId = value;
    }

    /**
     * Gets the value of the languageId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguageId() {
        return languageId;
    }

    /**
     * Sets the value of the languageId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguageId(String value) {
        this.languageId = value;
    }

    /**
     * Gets the value of the priority property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPriority() {
        return priority;
    }

    /**
     * Sets the value of the priority property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPriority(String value) {
        this.priority = value;
    }

    /**
     * Gets the value of the businessHourIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessHourIndicator() {
        return businessHourIndicator;
    }

    /**
     * Sets the value of the businessHourIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessHourIndicator(String value) {
        this.businessHourIndicator = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the statusText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusText() {
        return statusText;
    }

    /**
     * Sets the value of the statusText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusText(String value) {
        this.statusText = value;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PostpaidBalanceEnquiryResponse [billingSubscriptionStatus=");
		builder.append(billingSubscriptionStatus);
		builder.append(", totalBal=");
		builder.append(totalBal);
		builder.append(", mainBalance=");
		builder.append(mainBalance);
		builder.append(", onNetBal=");
		builder.append(onNetBal);
		builder.append(", offNetBal=");
		builder.append(offNetBal);
		builder.append(", totalUnbilledUsage=");
		builder.append(totalUnbilledUsage);
		builder.append(", totalOutstandingBalance=");
		builder.append(totalOutstandingBalance);
		builder.append(", dueDate=");
		builder.append(dueDate);
		builder.append(", totalUnpaid=");
		builder.append(totalUnpaid);
		builder.append(", depositedAmount=");
		builder.append(depositedAmount);
		builder.append(", notificationCreditLimit=");
		builder.append(notificationCreditLimit);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append(", languageId=");
		builder.append(languageId);
		builder.append(", priority=");
		builder.append(priority);
		builder.append(", businessHourIndicator=");
		builder.append(businessHourIndicator);
		builder.append(", status=");
		builder.append(status);
		builder.append(", statusText=");
		builder.append(statusText);
		builder.append("]");
		return builder.toString();
	}

}
