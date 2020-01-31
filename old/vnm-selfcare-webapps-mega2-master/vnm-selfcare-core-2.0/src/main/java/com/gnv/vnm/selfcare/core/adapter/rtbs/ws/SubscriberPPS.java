
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for SubscriberPPS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubscriberPPS"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://comverse-in.com/prepaid/ccws}SubscriberMainBase"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SPName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Accumulators" type="{http://comverse-in.com/prepaid/ccws}AccumulatorModify" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="BonusPlan" type="{http://comverse-in.com/prepaid/ccws}BonusPlanModify" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Balances" type="{http://comverse-in.com/prepaid/ccws}ArrayOfBalanceEntityBase" minOccurs="0"/&gt;
 *         &lt;element name="BalanceChangeChargeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BalanceChangeComment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FreeFFChgAllowance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FFChangeCount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SubscriberDateEnterActive" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="LoyaltyBonusScale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="LoyaltyBonusPlan" type="{http://comverse-in.com/prepaid/ccws}LoyaltyBonusPlanModify" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubscriberPPS", propOrder = {
    "currencyCode",
    "spName",
    "accumulators",
    "bonusPlan",
    "balances",
    "balanceChangeChargeCode",
    "balanceChangeComment",
    "freeFFChgAllowance",
    "ffChangeCount",
    "subscriberDateEnterActive",
    "loyaltyBonusScale",
    "loyaltyBonusPlan"
})
public class SubscriberPPS
    extends SubscriberMainBase
{

    @XmlElement(name = "CurrencyCode")
    protected String currencyCode;
    @XmlElement(name = "SPName")
    protected String spName;
    @XmlElement(name = "Accumulators")
    protected List<AccumulatorModify> accumulators;
    @XmlElement(name = "BonusPlan")
    protected List<BonusPlanModify> bonusPlan;
    @XmlElement(name = "Balances")
    protected ArrayOfBalanceEntityBase balances;
    @XmlElement(name = "BalanceChangeChargeCode")
    protected String balanceChangeChargeCode;
    @XmlElement(name = "BalanceChangeComment")
    protected String balanceChangeComment;
    @XmlElement(name = "FreeFFChgAllowance")
    protected String freeFFChgAllowance;
    @XmlElement(name = "FFChangeCount")
    protected String ffChangeCount;
    @XmlElement(name = "SubscriberDateEnterActive", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar subscriberDateEnterActive;
    @XmlElement(name = "LoyaltyBonusScale")
    protected String loyaltyBonusScale;
    @XmlElement(name = "LoyaltyBonusPlan")
    protected LoyaltyBonusPlanModify loyaltyBonusPlan;

    /**
     * Gets the value of the currencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the value of the currencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyCode(String value) {
        this.currencyCode = value;
    }

    /**
     * Gets the value of the spName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSPName() {
        return spName;
    }

    /**
     * Sets the value of the spName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSPName(String value) {
        this.spName = value;
    }

    /**
     * Gets the value of the accumulators property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accumulators property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccumulators().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccumulatorModify }
     * 
     * 
     */
    public List<AccumulatorModify> getAccumulators() {
        if (accumulators == null) {
            accumulators = new ArrayList<AccumulatorModify>();
        }
        return this.accumulators;
    }

    /**
     * Gets the value of the bonusPlan property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bonusPlan property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBonusPlan().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BonusPlanModify }
     * 
     * 
     */
    public List<BonusPlanModify> getBonusPlan() {
        if (bonusPlan == null) {
            bonusPlan = new ArrayList<BonusPlanModify>();
        }
        return this.bonusPlan;
    }

    /**
     * Gets the value of the balances property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfBalanceEntityBase }
     *     
     */
    public ArrayOfBalanceEntityBase getBalances() {
        return balances;
    }

    /**
     * Sets the value of the balances property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfBalanceEntityBase }
     *     
     */
    public void setBalances(ArrayOfBalanceEntityBase value) {
        this.balances = value;
    }

    /**
     * Gets the value of the balanceChangeChargeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBalanceChangeChargeCode() {
        return balanceChangeChargeCode;
    }

    /**
     * Sets the value of the balanceChangeChargeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBalanceChangeChargeCode(String value) {
        this.balanceChangeChargeCode = value;
    }

    /**
     * Gets the value of the balanceChangeComment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBalanceChangeComment() {
        return balanceChangeComment;
    }

    /**
     * Sets the value of the balanceChangeComment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBalanceChangeComment(String value) {
        this.balanceChangeComment = value;
    }

    /**
     * Gets the value of the freeFFChgAllowance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFreeFFChgAllowance() {
        return freeFFChgAllowance;
    }

    /**
     * Sets the value of the freeFFChgAllowance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFreeFFChgAllowance(String value) {
        this.freeFFChgAllowance = value;
    }

    /**
     * Gets the value of the ffChangeCount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFFChangeCount() {
        return ffChangeCount;
    }

    /**
     * Sets the value of the ffChangeCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFFChangeCount(String value) {
        this.ffChangeCount = value;
    }

    /**
     * Gets the value of the subscriberDateEnterActive property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSubscriberDateEnterActive() {
        return subscriberDateEnterActive;
    }

    /**
     * Sets the value of the subscriberDateEnterActive property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSubscriberDateEnterActive(XMLGregorianCalendar value) {
        this.subscriberDateEnterActive = value;
    }

    /**
     * Gets the value of the loyaltyBonusScale property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoyaltyBonusScale() {
        return loyaltyBonusScale;
    }

    /**
     * Sets the value of the loyaltyBonusScale property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoyaltyBonusScale(String value) {
        this.loyaltyBonusScale = value;
    }

    /**
     * Gets the value of the loyaltyBonusPlan property.
     * 
     * @return
     *     possible object is
     *     {@link LoyaltyBonusPlanModify }
     *     
     */
    public LoyaltyBonusPlanModify getLoyaltyBonusPlan() {
        return loyaltyBonusPlan;
    }

    /**
     * Sets the value of the loyaltyBonusPlan property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoyaltyBonusPlanModify }
     *     
     */
    public void setLoyaltyBonusPlan(LoyaltyBonusPlanModify value) {
        this.loyaltyBonusPlan = value;
    }

}
