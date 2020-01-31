
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SubscriberRetrieve complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubscriberRetrieve"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://comverse-in.com/prepaid/ccws}SubscriberBase"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SubscriberData" type="{http://comverse-in.com/prepaid/ccws}SubscriberEntity" minOccurs="0"/&gt;
 *         &lt;element name="CallHistories" type="{http://comverse-in.com/prepaid/ccws}ArrayOfCallHistory" minOccurs="0"/&gt;
 *         &lt;element name="MonetaryTransactionsRecords" type="{http://comverse-in.com/prepaid/ccws}ArrayOfMonetaryTransactionRecord" minOccurs="0"/&gt;
 *         &lt;element name="PaymentServerTransaction" type="{http://comverse-in.com/prepaid/ccws}PSTransaction" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="RechargeHistories" type="{http://comverse-in.com/prepaid/ccws}ArrayOfRechargeHistory" minOccurs="0"/&gt;
 *         &lt;element name="OSAHistories" type="{http://comverse-in.com/prepaid/ccws}ArrayOfOSAHistory" minOccurs="0"/&gt;
 *         &lt;element name="OfferHistories" type="{http://comverse-in.com/prepaid/ccws}ArrayOfOfferHistoryRecord" minOccurs="0"/&gt;
 *         &lt;element name="CUGMembers" type="{http://comverse-in.com/prepaid/ccws}CUGMembers" minOccurs="0"/&gt;
 *         &lt;element name="Reservations" type="{http://comverse-in.com/prepaid/ccws}ArrayOfReservation" minOccurs="0"/&gt;
 *         &lt;element name="PeriodicCharges" type="{http://comverse-in.com/prepaid/ccws}ArrayOfSubscriberPeriodicCharge" minOccurs="0"/&gt;
 *         &lt;element name="IdentityHistories" type="{http://comverse-in.com/prepaid/ccws}ArrayOfIdentityHistory" minOccurs="0"/&gt;
 *         &lt;element name="Circles" type="{http://comverse-in.com/prepaid/ccws}ArrayOfCircleMembership" minOccurs="0"/&gt;
 *         &lt;element name="DiameterOCSHistoryRecords" type="{http://comverse-in.com/prepaid/ccws}DiameterOCSHistory" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="FandFPhonebookHistoryRecords" type="{http://comverse-in.com/prepaid/ccws}FandFPhonebookHistory" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubscriberRetrieve", propOrder = {
    "subscriberData",
    "callHistories",
    "monetaryTransactionsRecords",
    "paymentServerTransaction",
    "rechargeHistories",
    "osaHistories",
    "offerHistories",
    "cugMembers",
    "reservations",
    "periodicCharges",
    "identityHistories",
    "circles",
    "diameterOCSHistoryRecords",
    "fandFPhonebookHistoryRecords"
})
public class SubscriberRetrieve
    extends SubscriberBase
{

    @XmlElement(name = "SubscriberData")
    protected SubscriberEntity subscriberData;
    @XmlElement(name = "CallHistories")
    protected ArrayOfCallHistory callHistories;
    @XmlElement(name = "MonetaryTransactionsRecords")
    protected ArrayOfMonetaryTransactionRecord monetaryTransactionsRecords;
    @XmlElement(name = "PaymentServerTransaction")
    protected List<PSTransaction> paymentServerTransaction;
    @XmlElement(name = "RechargeHistories")
    protected ArrayOfRechargeHistory rechargeHistories;
    @XmlElement(name = "OSAHistories")
    protected ArrayOfOSAHistory osaHistories;
    @XmlElement(name = "OfferHistories")
    protected ArrayOfOfferHistoryRecord offerHistories;
    @XmlElement(name = "CUGMembers")
    protected CUGMembers cugMembers;
    @XmlElement(name = "Reservations")
    protected ArrayOfReservation reservations;
    @XmlElement(name = "PeriodicCharges")
    protected ArrayOfSubscriberPeriodicCharge periodicCharges;
    @XmlElement(name = "IdentityHistories")
    protected ArrayOfIdentityHistory identityHistories;
    @XmlElement(name = "Circles")
    protected ArrayOfCircleMembership circles;
    @XmlElement(name = "DiameterOCSHistoryRecords")
    protected List<DiameterOCSHistory> diameterOCSHistoryRecords;
    @XmlElement(name = "FandFPhonebookHistoryRecords")
    protected List<FandFPhonebookHistory> fandFPhonebookHistoryRecords;

    /**
     * Gets the value of the subscriberData property.
     * 
     * @return
     *     possible object is
     *     {@link SubscriberEntity }
     *     
     */
    public SubscriberEntity getSubscriberData() {
        return subscriberData;
    }

    /**
     * Sets the value of the subscriberData property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriberEntity }
     *     
     */
    public void setSubscriberData(SubscriberEntity value) {
        this.subscriberData = value;
    }

    /**
     * Gets the value of the callHistories property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCallHistory }
     *     
     */
    public ArrayOfCallHistory getCallHistories() {
        return callHistories;
    }

    /**
     * Sets the value of the callHistories property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCallHistory }
     *     
     */
    public void setCallHistories(ArrayOfCallHistory value) {
        this.callHistories = value;
    }

    /**
     * Gets the value of the monetaryTransactionsRecords property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMonetaryTransactionRecord }
     *     
     */
    public ArrayOfMonetaryTransactionRecord getMonetaryTransactionsRecords() {
        return monetaryTransactionsRecords;
    }

    /**
     * Sets the value of the monetaryTransactionsRecords property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMonetaryTransactionRecord }
     *     
     */
    public void setMonetaryTransactionsRecords(ArrayOfMonetaryTransactionRecord value) {
        this.monetaryTransactionsRecords = value;
    }

    /**
     * Gets the value of the paymentServerTransaction property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paymentServerTransaction property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentServerTransaction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PSTransaction }
     * 
     * 
     */
    public List<PSTransaction> getPaymentServerTransaction() {
        if (paymentServerTransaction == null) {
            paymentServerTransaction = new ArrayList<PSTransaction>();
        }
        return this.paymentServerTransaction;
    }

    /**
     * Gets the value of the rechargeHistories property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRechargeHistory }
     *     
     */
    public ArrayOfRechargeHistory getRechargeHistories() {
        return rechargeHistories;
    }

    /**
     * Sets the value of the rechargeHistories property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRechargeHistory }
     *     
     */
    public void setRechargeHistories(ArrayOfRechargeHistory value) {
        this.rechargeHistories = value;
    }

    /**
     * Gets the value of the osaHistories property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfOSAHistory }
     *     
     */
    public ArrayOfOSAHistory getOSAHistories() {
        return osaHistories;
    }

    /**
     * Sets the value of the osaHistories property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfOSAHistory }
     *     
     */
    public void setOSAHistories(ArrayOfOSAHistory value) {
        this.osaHistories = value;
    }

    /**
     * Gets the value of the offerHistories property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfOfferHistoryRecord }
     *     
     */
    public ArrayOfOfferHistoryRecord getOfferHistories() {
        return offerHistories;
    }

    /**
     * Sets the value of the offerHistories property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfOfferHistoryRecord }
     *     
     */
    public void setOfferHistories(ArrayOfOfferHistoryRecord value) {
        this.offerHistories = value;
    }

    /**
     * Gets the value of the cugMembers property.
     * 
     * @return
     *     possible object is
     *     {@link CUGMembers }
     *     
     */
    public CUGMembers getCUGMembers() {
        return cugMembers;
    }

    /**
     * Sets the value of the cugMembers property.
     * 
     * @param value
     *     allowed object is
     *     {@link CUGMembers }
     *     
     */
    public void setCUGMembers(CUGMembers value) {
        this.cugMembers = value;
    }

    /**
     * Gets the value of the reservations property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfReservation }
     *     
     */
    public ArrayOfReservation getReservations() {
        return reservations;
    }

    /**
     * Sets the value of the reservations property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfReservation }
     *     
     */
    public void setReservations(ArrayOfReservation value) {
        this.reservations = value;
    }

    /**
     * Gets the value of the periodicCharges property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSubscriberPeriodicCharge }
     *     
     */
    public ArrayOfSubscriberPeriodicCharge getPeriodicCharges() {
        return periodicCharges;
    }

    /**
     * Sets the value of the periodicCharges property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSubscriberPeriodicCharge }
     *     
     */
    public void setPeriodicCharges(ArrayOfSubscriberPeriodicCharge value) {
        this.periodicCharges = value;
    }

    /**
     * Gets the value of the identityHistories property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIdentityHistory }
     *     
     */
    public ArrayOfIdentityHistory getIdentityHistories() {
        return identityHistories;
    }

    /**
     * Sets the value of the identityHistories property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIdentityHistory }
     *     
     */
    public void setIdentityHistories(ArrayOfIdentityHistory value) {
        this.identityHistories = value;
    }

    /**
     * Gets the value of the circles property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCircleMembership }
     *     
     */
    public ArrayOfCircleMembership getCircles() {
        return circles;
    }

    /**
     * Sets the value of the circles property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCircleMembership }
     *     
     */
    public void setCircles(ArrayOfCircleMembership value) {
        this.circles = value;
    }

    /**
     * Gets the value of the diameterOCSHistoryRecords property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the diameterOCSHistoryRecords property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDiameterOCSHistoryRecords().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DiameterOCSHistory }
     * 
     * 
     */
    public List<DiameterOCSHistory> getDiameterOCSHistoryRecords() {
        if (diameterOCSHistoryRecords == null) {
            diameterOCSHistoryRecords = new ArrayList<DiameterOCSHistory>();
        }
        return this.diameterOCSHistoryRecords;
    }

    /**
     * Gets the value of the fandFPhonebookHistoryRecords property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fandFPhonebookHistoryRecords property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFandFPhonebookHistoryRecords().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FandFPhonebookHistory }
     * 
     * 
     */
    public List<FandFPhonebookHistory> getFandFPhonebookHistoryRecords() {
        if (fandFPhonebookHistoryRecords == null) {
            fandFPhonebookHistoryRecords = new ArrayList<FandFPhonebookHistory>();
        }
        return this.fandFPhonebookHistoryRecords;
    }

}
