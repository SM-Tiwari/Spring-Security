
package com.gnv.vnm.selfcare.core.adapter.tibco.hotbilling;

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
 *         &lt;element name="Total_Due" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Monthly_3G_Charge" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Monthly_Charge" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Detailed_Usage_Free" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Unbilled_Usage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Discount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Usage_variance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Total_Adjustment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Others_Adjustments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Balance_Transfer_Amount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Transfer_Fee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Total_VAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Other_VAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Status_Text" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "totalDue",
    "monthly3GCharge",
    "monthlyCharge",
    "detailedUsageFree",
    "unbilledUsage",
    "discount",
    "usageVariance",
    "totalAdjustment",
    "othersAdjustments",
    "balanceTransferAmount",
    "transferFee",
    "totalVAT",
    "otherVAT",
    "status",
    "statusText"
})
@XmlRootElement(name = "Response")
public class HotBillingResponse {

    @XmlElement(name = "Total_Due")
    protected String totalDue;
    @XmlElement(name = "Monthly_3G_Charge")
    protected String monthly3GCharge;
    @XmlElement(name = "Monthly_Charge")
    protected String monthlyCharge;
    @XmlElement(name = "Detailed_Usage_Free")
    protected String detailedUsageFree;
    @XmlElement(name = "Unbilled_Usage")
    protected String unbilledUsage;
    @XmlElement(name = "Discount")
    protected String discount;
    @XmlElement(name = "Usage_variance")
    protected String usageVariance;
    @XmlElement(name = "Total_Adjustment")
    protected String totalAdjustment;
    @XmlElement(name = "Others_Adjustments")
    protected String othersAdjustments;
    @XmlElement(name = "Balance_Transfer_Amount")
    protected String balanceTransferAmount;
    @XmlElement(name = "Transfer_Fee")
    protected String transferFee;
    @XmlElement(name = "Total_VAT")
    protected String totalVAT;
    @XmlElement(name = "Other_VAT")
    protected String otherVAT;
    @XmlElement(name = "Status")
    protected String status;
    @XmlElement(name = "Status_Text")
    protected String statusText;

    /**
     * Gets the value of the totalDue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalDue() {
        return totalDue;
    }

    /**
     * Sets the value of the totalDue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalDue(String value) {
        this.totalDue = value;
    }

    /**
     * Gets the value of the monthly3GCharge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMonthly3GCharge() {
        return monthly3GCharge;
    }

    /**
     * Sets the value of the monthly3GCharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMonthly3GCharge(String value) {
        this.monthly3GCharge = value;
    }

    /**
     * Gets the value of the monthlyCharge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMonthlyCharge() {
        return monthlyCharge;
    }

    /**
     * Sets the value of the monthlyCharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMonthlyCharge(String value) {
        this.monthlyCharge = value;
    }

    /**
     * Gets the value of the detailedUsageFree property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDetailedUsageFree() {
        return detailedUsageFree;
    }

    /**
     * Sets the value of the detailedUsageFree property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDetailedUsageFree(String value) {
        this.detailedUsageFree = value;
    }

    /**
     * Gets the value of the unbilledUsage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnbilledUsage() {
        return unbilledUsage;
    }

    /**
     * Sets the value of the unbilledUsage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnbilledUsage(String value) {
        this.unbilledUsage = value;
    }

    /**
     * Gets the value of the discount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiscount() {
        return discount;
    }

    /**
     * Sets the value of the discount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiscount(String value) {
        this.discount = value;
    }

    /**
     * Gets the value of the usageVariance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsageVariance() {
        return usageVariance;
    }

    /**
     * Sets the value of the usageVariance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsageVariance(String value) {
        this.usageVariance = value;
    }

    /**
     * Gets the value of the totalAdjustment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalAdjustment() {
        return totalAdjustment;
    }

    /**
     * Sets the value of the totalAdjustment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalAdjustment(String value) {
        this.totalAdjustment = value;
    }

    /**
     * Gets the value of the othersAdjustments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOthersAdjustments() {
        return othersAdjustments;
    }

    /**
     * Sets the value of the othersAdjustments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOthersAdjustments(String value) {
        this.othersAdjustments = value;
    }

    /**
     * Gets the value of the balanceTransferAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBalanceTransferAmount() {
        return balanceTransferAmount;
    }

    /**
     * Sets the value of the balanceTransferAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBalanceTransferAmount(String value) {
        this.balanceTransferAmount = value;
    }

    /**
     * Gets the value of the transferFee property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransferFee() {
        return transferFee;
    }

    /**
     * Sets the value of the transferFee property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransferFee(String value) {
        this.transferFee = value;
    }

    /**
     * Gets the value of the totalVAT property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalVAT() {
        return totalVAT;
    }

    /**
     * Sets the value of the totalVAT property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalVAT(String value) {
        this.totalVAT = value;
    }

    /**
     * Gets the value of the otherVAT property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOtherVAT() {
        return otherVAT;
    }

    /**
     * Sets the value of the otherVAT property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOtherVAT(String value) {
        this.otherVAT = value;
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
		builder.append("HotBillingResponse [totalDue=");
		builder.append(totalDue);
		builder.append(", monthly3GCharge=");
		builder.append(monthly3GCharge);
		builder.append(", monthlyCharge=");
		builder.append(monthlyCharge);
		builder.append(", detailedUsageFree=");
		builder.append(detailedUsageFree);
		builder.append(", unbilledUsage=");
		builder.append(unbilledUsage);
		builder.append(", discount=");
		builder.append(discount);
		builder.append(", usageVariance=");
		builder.append(usageVariance);
		builder.append(", totalAdjustment=");
		builder.append(totalAdjustment);
		builder.append(", othersAdjustments=");
		builder.append(othersAdjustments);
		builder.append(", balanceTransferAmount=");
		builder.append(balanceTransferAmount);
		builder.append(", transferFee=");
		builder.append(transferFee);
		builder.append(", totalVAT=");
		builder.append(totalVAT);
		builder.append(", otherVAT=");
		builder.append(otherVAT);
		builder.append(", status=");
		builder.append(status);
		builder.append(", statusText=");
		builder.append(statusText);
		builder.append("]");
		return builder.toString();
	}

}
