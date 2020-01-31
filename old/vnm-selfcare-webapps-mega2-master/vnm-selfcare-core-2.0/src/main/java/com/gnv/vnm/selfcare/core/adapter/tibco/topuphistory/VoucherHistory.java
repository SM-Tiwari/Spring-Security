
package com.gnv.vnm.selfcare.core.adapter.tibco.topuphistory;

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
 *         &lt;element name="MobNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Start_Date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="End_Date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Account_Number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Voucher_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Status_Text" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="VoucherList" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="VoucherItems" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="Top_Up_Type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                             &lt;element name="Top_Up_Date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                             &lt;element name="Voucher_Money" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                             &lt;element name="Source_Request" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                             &lt;element name="Voucher_Active_End_Date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                             &lt;element name="Voucher_Grace_End_Date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                             &lt;element name="Payment_Ref_Number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                             &lt;element name="Reversal_Flag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                             &lt;element name="Net_Top_Up_Money" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                             &lt;element name="Bonus_Amount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                             &lt;element name="Top_Up_Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                             &lt;element name="MSISDN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
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
@XmlType(name = "", propOrder = {
    "transactionID",
    "mobNum",
    "startDate",
    "endDate",
    "accountNumber",
    "voucherID",
    "status",
    "statusText",
    "voucherList"
})
@XmlRootElement(name = "VoucherHistory", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd3")
public class VoucherHistory {

    @XmlElement(name = "TransactionID", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd3", required = true)
    protected String transactionID;
    @XmlElement(name = "MobNum", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd3")
    protected String mobNum;
    @XmlElement(name = "Start_Date", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd3")
    protected String startDate;
    @XmlElement(name = "End_Date", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd3")
    protected String endDate;
    @XmlElement(name = "Account_Number", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd3")
    protected String accountNumber;
    @XmlElement(name = "Voucher_ID", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd3")
    protected String voucherID;
    @XmlElement(name = "Status", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd3")
    protected String status;
    @XmlElement(name = "Status_Text", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd3")
    protected String statusText;
    @XmlElement(name = "VoucherList", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd3")
    protected VoucherHistory.VoucherList voucherList;

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
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDate(String value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDate(String value) {
        this.endDate = value;
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
     * Gets the value of the voucherID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVoucherID() {
        return voucherID;
    }

    /**
     * Sets the value of the voucherID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVoucherID(String value) {
        this.voucherID = value;
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

    /**
     * Gets the value of the voucherList property.
     * 
     * @return
     *     possible object is
     *     {@link VoucherHistory.VoucherList }
     *     
     */
    public VoucherHistory.VoucherList getVoucherList() {
        return voucherList;
    }

    /**
     * Sets the value of the voucherList property.
     * 
     * @param value
     *     allowed object is
     *     {@link VoucherHistory.VoucherList }
     *     
     */
    public void setVoucherList(VoucherHistory.VoucherList value) {
        this.voucherList = value;
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
     *         &lt;element name="VoucherItems" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="Top_Up_Type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *                   &lt;element name="Top_Up_Date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *                   &lt;element name="Voucher_Money" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *                   &lt;element name="Source_Request" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *                   &lt;element name="Voucher_Active_End_Date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *                   &lt;element name="Voucher_Grace_End_Date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *                   &lt;element name="Payment_Ref_Number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *                   &lt;element name="Reversal_Flag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *                   &lt;element name="Net_Top_Up_Money" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *                   &lt;element name="Bonus_Amount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *                   &lt;element name="Top_Up_Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *                   &lt;element name="MSISDN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    @XmlType(name = "", propOrder = {
        "voucherItems"
    })
    public static class VoucherList {

        @XmlElement(name = "VoucherItems", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd3")
        protected List<VoucherHistory.VoucherList.VoucherItems> voucherItems;

        /**
         * Gets the value of the voucherItems property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the voucherItems property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getVoucherItems().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link VoucherHistory.VoucherList.VoucherItems }
         * 
         * 
         */
        public List<VoucherHistory.VoucherList.VoucherItems> getVoucherItems() {
            if (voucherItems == null) {
                voucherItems = new ArrayList<VoucherHistory.VoucherList.VoucherItems>();
            }
            return this.voucherItems;
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
         *         &lt;element name="Top_Up_Type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
         *         &lt;element name="Top_Up_Date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
         *         &lt;element name="Voucher_Money" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
         *         &lt;element name="Source_Request" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
         *         &lt;element name="Voucher_Active_End_Date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
         *         &lt;element name="Voucher_Grace_End_Date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
         *         &lt;element name="Payment_Ref_Number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
         *         &lt;element name="Reversal_Flag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
         *         &lt;element name="Net_Top_Up_Money" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
         *         &lt;element name="Bonus_Amount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
         *         &lt;element name="Top_Up_Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
         *         &lt;element name="MSISDN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
            "topUpType",
            "topUpDate",
            "voucherMoney",
            "sourceRequest",
            "voucherActiveEndDate",
            "voucherGraceEndDate",
            "paymentRefNumber",
            "reversalFlag",
            "netTopUpMoney",
            "bonusAmount",
            "topUpStatus",
            "msisdn"
        })
        public static class VoucherItems {

            @XmlElement(name = "Top_Up_Type", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd3")
            protected String topUpType;
            @XmlElement(name = "Top_Up_Date", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd3")
            protected String topUpDate;
            @XmlElement(name = "Voucher_Money", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd3")
            protected String voucherMoney;
            @XmlElement(name = "Source_Request", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd3")
            protected String sourceRequest;
            @XmlElement(name = "Voucher_Active_End_Date", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd3")
            protected String voucherActiveEndDate;
            @XmlElement(name = "Voucher_Grace_End_Date", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd3")
            protected String voucherGraceEndDate;
            @XmlElement(name = "Payment_Ref_Number", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd3")
            protected String paymentRefNumber;
            @XmlElement(name = "Reversal_Flag", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd3")
            protected String reversalFlag;
            @XmlElement(name = "Net_Top_Up_Money", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd3")
            protected String netTopUpMoney;
            @XmlElement(name = "Bonus_Amount", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd3")
            protected String bonusAmount;
            @XmlElement(name = "Top_Up_Status", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd3")
            protected String topUpStatus;
            @XmlElement(name = "MSISDN", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd3")
            protected String msisdn;

            /**
             * Gets the value of the topUpType property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTopUpType() {
                return topUpType;
            }

            /**
             * Sets the value of the topUpType property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTopUpType(String value) {
                this.topUpType = value;
            }

            /**
             * Gets the value of the topUpDate property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTopUpDate() {
                return topUpDate;
            }

            /**
             * Sets the value of the topUpDate property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTopUpDate(String value) {
                this.topUpDate = value;
            }

            /**
             * Gets the value of the voucherMoney property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getVoucherMoney() {
                return voucherMoney;
            }

            /**
             * Sets the value of the voucherMoney property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setVoucherMoney(String value) {
                this.voucherMoney = value;
            }

            /**
             * Gets the value of the sourceRequest property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSourceRequest() {
                return sourceRequest;
            }

            /**
             * Sets the value of the sourceRequest property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSourceRequest(String value) {
                this.sourceRequest = value;
            }

            /**
             * Gets the value of the voucherActiveEndDate property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getVoucherActiveEndDate() {
                return voucherActiveEndDate;
            }

            /**
             * Sets the value of the voucherActiveEndDate property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setVoucherActiveEndDate(String value) {
                this.voucherActiveEndDate = value;
            }

            /**
             * Gets the value of the voucherGraceEndDate property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getVoucherGraceEndDate() {
                return voucherGraceEndDate;
            }

            /**
             * Sets the value of the voucherGraceEndDate property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setVoucherGraceEndDate(String value) {
                this.voucherGraceEndDate = value;
            }

            /**
             * Gets the value of the paymentRefNumber property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPaymentRefNumber() {
                return paymentRefNumber;
            }

            /**
             * Sets the value of the paymentRefNumber property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPaymentRefNumber(String value) {
                this.paymentRefNumber = value;
            }

            /**
             * Gets the value of the reversalFlag property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getReversalFlag() {
                return reversalFlag;
            }

            /**
             * Sets the value of the reversalFlag property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setReversalFlag(String value) {
                this.reversalFlag = value;
            }

            /**
             * Gets the value of the netTopUpMoney property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNetTopUpMoney() {
                return netTopUpMoney;
            }

            /**
             * Sets the value of the netTopUpMoney property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNetTopUpMoney(String value) {
                this.netTopUpMoney = value;
            }

            /**
             * Gets the value of the bonusAmount property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBonusAmount() {
                return bonusAmount;
            }

            /**
             * Sets the value of the bonusAmount property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBonusAmount(String value) {
                this.bonusAmount = value;
            }

            /**
             * Gets the value of the topUpStatus property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTopUpStatus() {
                return topUpStatus;
            }

            /**
             * Sets the value of the topUpStatus property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTopUpStatus(String value) {
                this.topUpStatus = value;
            }

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

        }

    }

}
