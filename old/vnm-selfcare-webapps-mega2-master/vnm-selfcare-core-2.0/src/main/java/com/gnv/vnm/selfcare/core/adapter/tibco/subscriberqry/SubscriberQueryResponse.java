
package com.gnv.vnm.selfcare.core.adapter.tibco.subscriberqry;

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
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd}ACCOUNT_NUMBER" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd}RESTRICTED_DATE" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd}FORFEITED_DATE" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd}TERMINATED_DATE" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd}LAST_CALL_AMOUNT" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd}SOURCE_ID" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd}NOTIFICATION_ID" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd}DATA_BALANCE" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd}DATA_NIGHT_BALANCE" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd}LIFECYCLE_STATUS" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd}ACCOUNT_STATUS" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd}MAIN_ACCOUNT_BALANCE" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd}ONNET_BAL" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd}OFFNET_BAL" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd}SUBSCRIPTION_NUMBER" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd}CALL_PLAN" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd}SIM" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd}IMSI" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd}CUSTOMER_STATUS" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd}ACTIVATION_DATE" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd}REGISTRATION_DATE" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd}PROMOTION_CODE" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd}PAYMENT_TYPE" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd}EBILL_MAIL_ID" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd}OUTPUT_1" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd}OUTPUT_2" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd}OUTPUT_3" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd}OUTPUT_4" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd}Status_Code"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd}Status_Text"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd}MsgParam" minOccurs="0"/&gt;
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
    "accountnumber",
    "restricteddate",
    "forfeiteddate",
    "terminateddate",
    "lastcallamount",
    "sourceid",
    "notificationid",
    "databalance",
    "datanightbalance",
    "lifecyclestatus",
    "accountstatus",
    "mainaccountbalance",
    "onnetbal",
    "offnetbal",
    "subscriptionnumber",
    "callplan",
    "sim",
    "imsi",
    "customerstatus",
    "activationdate",
    "registrationdate",
    "promotioncode",
    "paymenttype",
    "ebillmailid",
    "output1",
    "output2",
    "output3",
    "output4",
    "statusCode",
    "statusText",
    "msgParam"
})
@XmlRootElement(name = "Response", namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd")
public class SubscriberQueryResponse {

    @XmlElement(name = "ACCOUNT_NUMBER")
    protected String accountnumber;
    @XmlElement(name = "RESTRICTED_DATE")
    protected String restricteddate;
    @XmlElement(name = "FORFEITED_DATE")
    protected String forfeiteddate;
    @XmlElement(name = "TERMINATED_DATE")
    protected String terminateddate;
    @XmlElement(name = "LAST_CALL_AMOUNT")
    protected String lastcallamount;
    @XmlElement(name = "SOURCE_ID")
    protected String sourceid;
    @XmlElement(name = "NOTIFICATION_ID")
    protected String notificationid;
    @XmlElement(name = "DATA_BALANCE")
    protected String databalance;
    @XmlElement(name = "DATA_NIGHT_BALANCE")
    protected String datanightbalance;
    @XmlElement(name = "LIFECYCLE_STATUS")
    protected String lifecyclestatus;
    @XmlElement(name = "ACCOUNT_STATUS")
    protected String accountstatus;
    @XmlElement(name = "MAIN_ACCOUNT_BALANCE")
    protected String mainaccountbalance;
    @XmlElement(name = "ONNET_BAL")
    protected String onnetbal;
    @XmlElement(name = "OFFNET_BAL")
    protected String offnetbal;
    @XmlElement(name = "SUBSCRIPTION_NUMBER")
    protected String subscriptionnumber;
    @XmlElement(name = "CALL_PLAN")
    protected String callplan;
    @XmlElement(name = "SIM")
    protected String sim;
    @XmlElement(name = "IMSI")
    protected String imsi;
    @XmlElement(name = "CUSTOMER_STATUS")
    protected String customerstatus;
    @XmlElement(name = "ACTIVATION_DATE")
    protected String activationdate;
    @XmlElement(name = "REGISTRATION_DATE")
    protected String registrationdate;
    @XmlElement(name = "PROMOTION_CODE")
    protected String promotioncode;
    @XmlElement(name = "PAYMENT_TYPE")
    protected String paymenttype;
    @XmlElement(name = "EBILL_MAIL_ID")
    protected String ebillmailid;
    @XmlElement(name = "OUTPUT_1")
    protected String output1;
    @XmlElement(name = "OUTPUT_2")
    protected String output2;
    @XmlElement(name = "OUTPUT_3")
    protected String output3;
    @XmlElement(name = "OUTPUT_4")
    protected String output4;
    @XmlElement(name = "Status_Code", required = true)
    protected String statusCode;
    @XmlElement(name = "Status_Text", required = true)
    protected String statusText;
    @XmlElement(name = "MsgParam")
    protected MsgParam msgParam;

    /**
     * Gets the value of the accountnumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACCOUNTNUMBER() {
        return accountnumber;
    }

    /**
     * Sets the value of the accountnumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACCOUNTNUMBER(String value) {
        this.accountnumber = value;
    }

    /**
     * Gets the value of the restricteddate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESTRICTEDDATE() {
        return restricteddate;
    }

    /**
     * Sets the value of the restricteddate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESTRICTEDDATE(String value) {
        this.restricteddate = value;
    }

    /**
     * Gets the value of the forfeiteddate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFORFEITEDDATE() {
        return forfeiteddate;
    }

    /**
     * Sets the value of the forfeiteddate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFORFEITEDDATE(String value) {
        this.forfeiteddate = value;
    }

    /**
     * Gets the value of the terminateddate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTERMINATEDDATE() {
        return terminateddate;
    }

    /**
     * Sets the value of the terminateddate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTERMINATEDDATE(String value) {
        this.terminateddate = value;
    }

    /**
     * Gets the value of the lastcallamount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLASTCALLAMOUNT() {
        return lastcallamount;
    }

    /**
     * Sets the value of the lastcallamount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLASTCALLAMOUNT(String value) {
        this.lastcallamount = value;
    }

    /**
     * Gets the value of the sourceid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSOURCEID() {
        return sourceid;
    }

    /**
     * Sets the value of the sourceid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSOURCEID(String value) {
        this.sourceid = value;
    }

    /**
     * Gets the value of the notificationid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNOTIFICATIONID() {
        return notificationid;
    }

    /**
     * Sets the value of the notificationid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNOTIFICATIONID(String value) {
        this.notificationid = value;
    }

    /**
     * Gets the value of the databalance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDATABALANCE() {
        return databalance;
    }

    /**
     * Sets the value of the databalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDATABALANCE(String value) {
        this.databalance = value;
    }

    /**
     * Gets the value of the datanightbalance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDATANIGHTBALANCE() {
        return datanightbalance;
    }

    /**
     * Sets the value of the datanightbalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDATANIGHTBALANCE(String value) {
        this.datanightbalance = value;
    }

    /**
     * Gets the value of the lifecyclestatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLIFECYCLESTATUS() {
        return lifecyclestatus;
    }

    /**
     * Sets the value of the lifecyclestatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLIFECYCLESTATUS(String value) {
        this.lifecyclestatus = value;
    }

    /**
     * Gets the value of the accountstatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACCOUNTSTATUS() {
        return accountstatus;
    }

    /**
     * Sets the value of the accountstatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACCOUNTSTATUS(String value) {
        this.accountstatus = value;
    }

    /**
     * Gets the value of the mainaccountbalance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMAINACCOUNTBALANCE() {
        return mainaccountbalance;
    }

    /**
     * Sets the value of the mainaccountbalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMAINACCOUNTBALANCE(String value) {
        this.mainaccountbalance = value;
    }

    /**
     * Gets the value of the onnetbal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getONNETBAL() {
        return onnetbal;
    }

    /**
     * Sets the value of the onnetbal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setONNETBAL(String value) {
        this.onnetbal = value;
    }

    /**
     * Gets the value of the offnetbal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOFFNETBAL() {
        return offnetbal;
    }

    /**
     * Sets the value of the offnetbal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOFFNETBAL(String value) {
        this.offnetbal = value;
    }

    /**
     * Gets the value of the subscriptionnumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSUBSCRIPTIONNUMBER() {
        return subscriptionnumber;
    }

    /**
     * Sets the value of the subscriptionnumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSUBSCRIPTIONNUMBER(String value) {
        this.subscriptionnumber = value;
    }

    /**
     * Gets the value of the callplan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCALLPLAN() {
        return callplan;
    }

    /**
     * Sets the value of the callplan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCALLPLAN(String value) {
        this.callplan = value;
    }

    /**
     * Gets the value of the sim property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSIM() {
        return sim;
    }

    /**
     * Sets the value of the sim property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSIM(String value) {
        this.sim = value;
    }

    /**
     * Gets the value of the imsi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIMSI() {
        return imsi;
    }

    /**
     * Sets the value of the imsi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIMSI(String value) {
        this.imsi = value;
    }

    /**
     * Gets the value of the customerstatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCUSTOMERSTATUS() {
        return customerstatus;
    }

    /**
     * Sets the value of the customerstatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCUSTOMERSTATUS(String value) {
        this.customerstatus = value;
    }

    /**
     * Gets the value of the activationdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACTIVATIONDATE() {
        return activationdate;
    }

    /**
     * Sets the value of the activationdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACTIVATIONDATE(String value) {
        this.activationdate = value;
    }

    /**
     * Gets the value of the registrationdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREGISTRATIONDATE() {
        return registrationdate;
    }

    /**
     * Sets the value of the registrationdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREGISTRATIONDATE(String value) {
        this.registrationdate = value;
    }

    /**
     * Gets the value of the promotioncode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPROMOTIONCODE() {
        return promotioncode;
    }

    /**
     * Sets the value of the promotioncode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPROMOTIONCODE(String value) {
        this.promotioncode = value;
    }

    /**
     * Gets the value of the paymenttype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAYMENTTYPE() {
        return paymenttype;
    }

    /**
     * Sets the value of the paymenttype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAYMENTTYPE(String value) {
        this.paymenttype = value;
    }

    /**
     * Gets the value of the ebillmailid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEBILLMAILID() {
        return ebillmailid;
    }

    /**
     * Sets the value of the ebillmailid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEBILLMAILID(String value) {
        this.ebillmailid = value;
    }

    /**
     * Gets the value of the output1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOUTPUT1() {
        return output1;
    }

    /**
     * Sets the value of the output1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOUTPUT1(String value) {
        this.output1 = value;
    }

    /**
     * Gets the value of the output2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOUTPUT2() {
        return output2;
    }

    /**
     * Sets the value of the output2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOUTPUT2(String value) {
        this.output2 = value;
    }

    /**
     * Gets the value of the output3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOUTPUT3() {
        return output3;
    }

    /**
     * Sets the value of the output3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOUTPUT3(String value) {
        this.output3 = value;
    }

    /**
     * Gets the value of the output4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOUTPUT4() {
        return output4;
    }

    /**
     * Sets the value of the output4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOUTPUT4(String value) {
        this.output4 = value;
    }

    /**
     * Gets the value of the statusCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusCode() {
        return statusCode;
    }

    /**
     * Sets the value of the statusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusCode(String value) {
        this.statusCode = value;
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
     * Gets the value of the msgParam property.
     * 
     * @return
     *     possible object is
     *     {@link MsgParam }
     *     
     */
    public MsgParam getMsgParam() {
        return msgParam;
    }

    /**
     * Sets the value of the msgParam property.
     * 
     * @param value
     *     allowed object is
     *     {@link MsgParam }
     *     
     */
    public void setMsgParam(MsgParam value) {
        this.msgParam = value;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Response [accountnumber=");
		builder.append(accountnumber);
		builder.append(", restricteddate=");
		builder.append(restricteddate);
		builder.append(", forfeiteddate=");
		builder.append(forfeiteddate);
		builder.append(", terminateddate=");
		builder.append(terminateddate);
		builder.append(", lastcallamount=");
		builder.append(lastcallamount);
		builder.append(", sourceid=");
		builder.append(sourceid);
		builder.append(", notificationid=");
		builder.append(notificationid);
		builder.append(", databalance=");
		builder.append(databalance);
		builder.append(", datanightbalance=");
		builder.append(datanightbalance);
		builder.append(", lifecyclestatus=");
		builder.append(lifecyclestatus);
		builder.append(", accountstatus=");
		builder.append(accountstatus);
		builder.append(", mainaccountbalance=");
		builder.append(mainaccountbalance);
		builder.append(", onnetbal=");
		builder.append(onnetbal);
		builder.append(", offnetbal=");
		builder.append(offnetbal);
		builder.append(", subscriptionnumber=");
		builder.append(subscriptionnumber);
		builder.append(", callplan=");
		builder.append(callplan);
		builder.append(", sim=");
		builder.append(sim);
		builder.append(", imsi=");
		builder.append(imsi);
		builder.append(", customerstatus=");
		builder.append(customerstatus);
		builder.append(", activationdate=");
		builder.append(activationdate);
		builder.append(", registrationdate=");
		builder.append(registrationdate);
		builder.append(", promotioncode=");
		builder.append(promotioncode);
		builder.append(", paymenttype=");
		builder.append(paymenttype);
		builder.append(", ebillmailid=");
		builder.append(ebillmailid);
		builder.append(", output1=");
		builder.append(output1);
		builder.append(", output2=");
		builder.append(output2);
		builder.append(", output3=");
		builder.append(output3);
		builder.append(", output4=");
		builder.append(output4);
		builder.append(", statusCode=");
		builder.append(statusCode);
		builder.append(", statusText=");
		builder.append(statusText);
		builder.append(", msgParam=");
		builder.append(msgParam);
		builder.append("]");
		return builder.toString();
	}
    

}
