
package com.gnv.vnm.selfcare.core.adapter.tibco.postpaidqry;

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
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd26}Bill_History" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd26}Status" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/Selfcare/Schema.xsd26}Status_Text" minOccurs="0"/&gt;
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
    "billHistory",
    "status",
    "statusText"
})
@XmlRootElement(name = "Response")
public class PostPaidBilledQueryResponse {

    @XmlElement(name = "Bill_History")
    protected List<BillHistory> billHistory;
    @XmlElement(name = "Status")
    protected String status;
    @XmlElement(name = "Status_Text")
    protected String statusText;

    /**
     * Gets the value of the billHistory property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the billHistory property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBillHistory().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BillHistory }
     * 
     * 
     */
    public List<BillHistory> getBillHistory() {
        if (billHistory == null) {
            billHistory = new ArrayList<BillHistory>();
        }
        return this.billHistory;
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
		builder.append("PostPaidBilledQueryResponse [billHistory=");
		builder.append(billHistory);
		builder.append(", status=");
		builder.append(status);
		builder.append(", statusText=");
		builder.append(statusText);
		builder.append("]");
		return builder.toString();
	}
    
}
