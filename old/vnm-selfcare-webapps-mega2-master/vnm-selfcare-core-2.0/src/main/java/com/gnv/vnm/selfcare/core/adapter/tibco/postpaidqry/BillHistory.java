
package com.gnv.vnm.selfcare.core.adapter.tibco.postpaidqry;

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
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd26}Bill_Date"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd26}Amount"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd26}Bill_Status"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd26}Payment_Status"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd26}Amount_Paid"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd26}Balance_Brought_Forward"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd26}Balance_Due"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd26}Bill_Due_Date"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd26}Bill_Type"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd26}Invoice_Image_Path"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd26}Invoice_Number"/&gt;
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
    "billDate",
    "amount",
    "billStatus",
    "paymentStatus",
    "amountPaid",
    "balanceBroughtForward",
    "balanceDue",
    "billDueDate",
    "billType",
    "invoiceImagePath",
    "invoiceNumber"
})
@XmlRootElement(name = "Bill_History")
public class BillHistory {

    @XmlElement(name = "Bill_Date", required = true)
    protected String billDate;
    @XmlElement(name = "Amount", required = true)
    protected String amount;
    @XmlElement(name = "Bill_Status", required = true)
    protected String billStatus;
    @XmlElement(name = "Payment_Status", required = true)
    protected String paymentStatus;
    @XmlElement(name = "Amount_Paid", required = true)
    protected String amountPaid;
    @XmlElement(name = "Balance_Brought_Forward", required = true)
    protected String balanceBroughtForward;
    @XmlElement(name = "Balance_Due", required = true)
    protected String balanceDue;
    @XmlElement(name = "Bill_Due_Date", required = true)
    protected String billDueDate;
    @XmlElement(name = "Bill_Type", required = true)
    protected String billType;
    @XmlElement(name = "Invoice_Image_Path", required = true)
    protected String invoiceImagePath;
    @XmlElement(name = "Invoice_Number", required = true)
    protected String invoiceNumber;

    /**
     * Gets the value of the billDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillDate() {
        return billDate;
    }

    /**
     * Sets the value of the billDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillDate(String value) {
        this.billDate = value;
    }

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmount(String value) {
        this.amount = value;
    }

    /**
     * Gets the value of the billStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillStatus() {
        return billStatus;
    }

    /**
     * Sets the value of the billStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillStatus(String value) {
        this.billStatus = value;
    }

    /**
     * Gets the value of the paymentStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentStatus() {
        return paymentStatus;
    }

    /**
     * Sets the value of the paymentStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentStatus(String value) {
        this.paymentStatus = value;
    }

    /**
     * Gets the value of the amountPaid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmountPaid() {
        return amountPaid;
    }

    /**
     * Sets the value of the amountPaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmountPaid(String value) {
        this.amountPaid = value;
    }

    /**
     * Gets the value of the balanceBroughtForward property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBalanceBroughtForward() {
        return balanceBroughtForward;
    }

    /**
     * Sets the value of the balanceBroughtForward property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBalanceBroughtForward(String value) {
        this.balanceBroughtForward = value;
    }

    /**
     * Gets the value of the balanceDue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBalanceDue() {
        return balanceDue;
    }

    /**
     * Sets the value of the balanceDue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBalanceDue(String value) {
        this.balanceDue = value;
    }

    /**
     * Gets the value of the billDueDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillDueDate() {
        return billDueDate;
    }

    /**
     * Sets the value of the billDueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillDueDate(String value) {
        this.billDueDate = value;
    }

    /**
     * Gets the value of the billType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillType() {
        return billType;
    }

    /**
     * Sets the value of the billType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillType(String value) {
        this.billType = value;
    }

    /**
     * Gets the value of the invoiceImagePath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceImagePath() {
        return invoiceImagePath;
    }

    /**
     * Sets the value of the invoiceImagePath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceImagePath(String value) {
        this.invoiceImagePath = value;
    }

    /**
     * Gets the value of the invoiceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    /**
     * Sets the value of the invoiceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceNumber(String value) {
        this.invoiceNumber = value;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BillHistory [billDate=");
		builder.append(billDate);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", billStatus=");
		builder.append(billStatus);
		builder.append(", paymentStatus=");
		builder.append(paymentStatus);
		builder.append(", amountPaid=");
		builder.append(amountPaid);
		builder.append(", balanceBroughtForward=");
		builder.append(balanceBroughtForward);
		builder.append(", balanceDue=");
		builder.append(balanceDue);
		builder.append(", billDueDate=");
		builder.append(billDueDate);
		builder.append(", billType=");
		builder.append(billType);
		builder.append(", invoiceImagePath=");
		builder.append(invoiceImagePath);
		builder.append(", invoiceNumber=");
		builder.append(invoiceNumber);
		builder.append("]");
		return builder.toString();
	}

}
