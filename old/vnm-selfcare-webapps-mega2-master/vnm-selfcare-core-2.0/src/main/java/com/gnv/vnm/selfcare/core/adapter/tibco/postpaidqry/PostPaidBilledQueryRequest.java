
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
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd25}MSISDN" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd25}AccountNumber" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd25}LocalTxnDtTime" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd25}TransactionId" minOccurs="0"/&gt;
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
    "msisdn",
    "accountNumber",
    "localTxnDtTime",
    "transactionId"
})
@XmlRootElement(name = "Request", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd25")
public class PostPaidBilledQueryRequest {

    @XmlElement(name = "MSISDN", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd25")
    protected String msisdn;
    @XmlElement(name = "AccountNumber", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd25")
    protected String accountNumber;
    @XmlElement(name = "LocalTxnDtTime", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd25")
    protected String localTxnDtTime;
    @XmlElement(name = "TransactionId", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd25")
    protected String transactionId;

    /**
     * Gets the value of the msisdn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMSISDN() {
        return msisdn;
    }

    /**
     * Sets the value of the msisdn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMSISDN(String value) {
        this.msisdn = value;
    }

    /**
     * Gets the value of the accountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the value of the accountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountNumber(String value) {
        this.accountNumber = value;
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
     * Gets the value of the transactionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * Sets the value of the transactionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionId(String value) {
        this.transactionId = value;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PostPaidBilledQueryRequest [msisdn=");
		builder.append(msisdn);
		builder.append(", accountNumber=");
		builder.append(accountNumber);
		builder.append(", localTxnDtTime=");
		builder.append(localTxnDtTime);
		builder.append(", transactionId=");
		builder.append(transactionId);
		builder.append("]");
		return builder.toString();
	}

}
