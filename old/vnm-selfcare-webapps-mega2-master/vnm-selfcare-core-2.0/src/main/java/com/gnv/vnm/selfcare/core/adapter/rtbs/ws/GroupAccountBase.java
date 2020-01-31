
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GroupAccountBase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GroupAccountBase"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AdminName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AdminPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="GroupName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RefurbishPeriod" type="{http://comverse-in.com/prepaid/ccws}DatePeriod"/&gt;
 *         &lt;element name="RefurbishDay" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="NotificationHandling" type="{http://comverse-in.com/prepaid/ccws}GroupMemberType"/&gt;
 *         &lt;element name="GroupCUG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DifferentMemberCUG" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="COSName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SPName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DifferentMemberCOS" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="PeriodicChargeApply" type="{http://comverse-in.com/prepaid/ccws}GroupMemberType"/&gt;
 *         &lt;element name="TimeZone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="HomeL1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="HomeL2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="HomeL3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="HomeL4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CFUNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CFBNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CFNANumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CFISNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FundsAvailable" type="{http://comverse-in.com/prepaid/ccws}FundsType"/&gt;
 *         &lt;element name="PrecedenceOrder" type="{http://comverse-in.com/prepaid/ccws}PrecedenceOrderType"/&gt;
 *         &lt;element name="FinancialHandling" type="{http://comverse-in.com/prepaid/ccws}FinancialHandlingType"/&gt;
 *         &lt;element name="AccountToAccountTransferAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="BalanceTransferMinimum" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="BalanceTransferMaximum" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="BalanceTransferResidualAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="SpendingLimitOverride" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="IsReactivationFeeApplied" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="BalanceToBalanceTransferAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="GroupMaximumSize" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GroupAccountBase", propOrder = {
    "adminName",
    "adminPassword",
    "groupName",
    "refurbishPeriod",
    "refurbishDay",
    "notificationHandling",
    "groupCUG",
    "differentMemberCUG",
    "cosName",
    "spName",
    "differentMemberCOS",
    "periodicChargeApply",
    "timeZone",
    "homeL1",
    "homeL2",
    "homeL3",
    "homeL4",
    "cfuNumber",
    "cfbNumber",
    "cfnaNumber",
    "cfisNumber",
    "fundsAvailable",
    "precedenceOrder",
    "financialHandling",
    "accountToAccountTransferAllowed",
    "balanceTransferMinimum",
    "balanceTransferMaximum",
    "balanceTransferResidualAmount",
    "spendingLimitOverride",
    "isReactivationFeeApplied",
    "balanceToBalanceTransferAllowed",
    "groupMaximumSize"
})
@XmlSeeAlso({
    GroupAccountCreate.class,
    GroupAccountModify.class,
    GroupAccountRetrieve.class
})
public class GroupAccountBase {

    @XmlElement(name = "AdminName")
    protected String adminName;
    @XmlElement(name = "AdminPassword")
    protected String adminPassword;
    @XmlElement(name = "GroupName")
    protected String groupName;
    @XmlElement(name = "RefurbishPeriod", required = true)
    @XmlSchemaType(name = "string")
    protected DatePeriod refurbishPeriod;
    @XmlElement(name = "RefurbishDay")
    protected long refurbishDay;
    @XmlElement(name = "NotificationHandling", required = true)
    @XmlSchemaType(name = "string")
    protected GroupMemberType notificationHandling;
    @XmlElement(name = "GroupCUG")
    protected String groupCUG;
    @XmlElement(name = "DifferentMemberCUG")
    protected boolean differentMemberCUG;
    @XmlElement(name = "COSName")
    protected String cosName;
    @XmlElement(name = "SPName")
    protected String spName;
    @XmlElement(name = "DifferentMemberCOS")
    protected boolean differentMemberCOS;
    @XmlElement(name = "PeriodicChargeApply", required = true)
    @XmlSchemaType(name = "string")
    protected GroupMemberType periodicChargeApply;
    @XmlElement(name = "TimeZone")
    protected String timeZone;
    @XmlElement(name = "HomeL1")
    protected String homeL1;
    @XmlElement(name = "HomeL2")
    protected String homeL2;
    @XmlElement(name = "HomeL3")
    protected String homeL3;
    @XmlElement(name = "HomeL4")
    protected String homeL4;
    @XmlElement(name = "CFUNumber")
    protected String cfuNumber;
    @XmlElement(name = "CFBNumber")
    protected String cfbNumber;
    @XmlElement(name = "CFNANumber")
    protected String cfnaNumber;
    @XmlElement(name = "CFISNumber")
    protected String cfisNumber;
    @XmlElement(name = "FundsAvailable", required = true)
    @XmlSchemaType(name = "string")
    protected FundsType fundsAvailable;
    @XmlElement(name = "PrecedenceOrder", required = true)
    @XmlSchemaType(name = "string")
    protected PrecedenceOrderType precedenceOrder;
    @XmlElement(name = "FinancialHandling", required = true)
    @XmlSchemaType(name = "string")
    protected FinancialHandlingType financialHandling;
    @XmlElement(name = "AccountToAccountTransferAllowed")
    protected boolean accountToAccountTransferAllowed;
    @XmlElement(name = "BalanceTransferMinimum")
    protected long balanceTransferMinimum;
    @XmlElement(name = "BalanceTransferMaximum")
    protected long balanceTransferMaximum;
    @XmlElement(name = "BalanceTransferResidualAmount", required = true)
    protected BigDecimal balanceTransferResidualAmount;
    @XmlElement(name = "SpendingLimitOverride")
    protected boolean spendingLimitOverride;
    @XmlElement(name = "IsReactivationFeeApplied")
    protected boolean isReactivationFeeApplied;
    @XmlElement(name = "BalanceToBalanceTransferAllowed")
    protected boolean balanceToBalanceTransferAllowed;
    @XmlElement(name = "GroupMaximumSize")
    protected long groupMaximumSize;

    /**
     * Gets the value of the adminName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdminName() {
        return adminName;
    }

    /**
     * Sets the value of the adminName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdminName(String value) {
        this.adminName = value;
    }

    /**
     * Gets the value of the adminPassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdminPassword() {
        return adminPassword;
    }

    /**
     * Sets the value of the adminPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdminPassword(String value) {
        this.adminPassword = value;
    }

    /**
     * Gets the value of the groupName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * Sets the value of the groupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupName(String value) {
        this.groupName = value;
    }

    /**
     * Gets the value of the refurbishPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link DatePeriod }
     *     
     */
    public DatePeriod getRefurbishPeriod() {
        return refurbishPeriod;
    }

    /**
     * Sets the value of the refurbishPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatePeriod }
     *     
     */
    public void setRefurbishPeriod(DatePeriod value) {
        this.refurbishPeriod = value;
    }

    /**
     * Gets the value of the refurbishDay property.
     * 
     */
    public long getRefurbishDay() {
        return refurbishDay;
    }

    /**
     * Sets the value of the refurbishDay property.
     * 
     */
    public void setRefurbishDay(long value) {
        this.refurbishDay = value;
    }

    /**
     * Gets the value of the notificationHandling property.
     * 
     * @return
     *     possible object is
     *     {@link GroupMemberType }
     *     
     */
    public GroupMemberType getNotificationHandling() {
        return notificationHandling;
    }

    /**
     * Sets the value of the notificationHandling property.
     * 
     * @param value
     *     allowed object is
     *     {@link GroupMemberType }
     *     
     */
    public void setNotificationHandling(GroupMemberType value) {
        this.notificationHandling = value;
    }

    /**
     * Gets the value of the groupCUG property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupCUG() {
        return groupCUG;
    }

    /**
     * Sets the value of the groupCUG property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupCUG(String value) {
        this.groupCUG = value;
    }

    /**
     * Gets the value of the differentMemberCUG property.
     * 
     */
    public boolean isDifferentMemberCUG() {
        return differentMemberCUG;
    }

    /**
     * Sets the value of the differentMemberCUG property.
     * 
     */
    public void setDifferentMemberCUG(boolean value) {
        this.differentMemberCUG = value;
    }

    /**
     * Gets the value of the cosName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOSName() {
        return cosName;
    }

    /**
     * Sets the value of the cosName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOSName(String value) {
        this.cosName = value;
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
     * Gets the value of the differentMemberCOS property.
     * 
     */
    public boolean isDifferentMemberCOS() {
        return differentMemberCOS;
    }

    /**
     * Sets the value of the differentMemberCOS property.
     * 
     */
    public void setDifferentMemberCOS(boolean value) {
        this.differentMemberCOS = value;
    }

    /**
     * Gets the value of the periodicChargeApply property.
     * 
     * @return
     *     possible object is
     *     {@link GroupMemberType }
     *     
     */
    public GroupMemberType getPeriodicChargeApply() {
        return periodicChargeApply;
    }

    /**
     * Sets the value of the periodicChargeApply property.
     * 
     * @param value
     *     allowed object is
     *     {@link GroupMemberType }
     *     
     */
    public void setPeriodicChargeApply(GroupMemberType value) {
        this.periodicChargeApply = value;
    }

    /**
     * Gets the value of the timeZone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeZone() {
        return timeZone;
    }

    /**
     * Sets the value of the timeZone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeZone(String value) {
        this.timeZone = value;
    }

    /**
     * Gets the value of the homeL1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHomeL1() {
        return homeL1;
    }

    /**
     * Sets the value of the homeL1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHomeL1(String value) {
        this.homeL1 = value;
    }

    /**
     * Gets the value of the homeL2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHomeL2() {
        return homeL2;
    }

    /**
     * Sets the value of the homeL2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHomeL2(String value) {
        this.homeL2 = value;
    }

    /**
     * Gets the value of the homeL3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHomeL3() {
        return homeL3;
    }

    /**
     * Sets the value of the homeL3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHomeL3(String value) {
        this.homeL3 = value;
    }

    /**
     * Gets the value of the homeL4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHomeL4() {
        return homeL4;
    }

    /**
     * Sets the value of the homeL4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHomeL4(String value) {
        this.homeL4 = value;
    }

    /**
     * Gets the value of the cfuNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCFUNumber() {
        return cfuNumber;
    }

    /**
     * Sets the value of the cfuNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCFUNumber(String value) {
        this.cfuNumber = value;
    }

    /**
     * Gets the value of the cfbNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCFBNumber() {
        return cfbNumber;
    }

    /**
     * Sets the value of the cfbNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCFBNumber(String value) {
        this.cfbNumber = value;
    }

    /**
     * Gets the value of the cfnaNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCFNANumber() {
        return cfnaNumber;
    }

    /**
     * Sets the value of the cfnaNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCFNANumber(String value) {
        this.cfnaNumber = value;
    }

    /**
     * Gets the value of the cfisNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCFISNumber() {
        return cfisNumber;
    }

    /**
     * Sets the value of the cfisNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCFISNumber(String value) {
        this.cfisNumber = value;
    }

    /**
     * Gets the value of the fundsAvailable property.
     * 
     * @return
     *     possible object is
     *     {@link FundsType }
     *     
     */
    public FundsType getFundsAvailable() {
        return fundsAvailable;
    }

    /**
     * Sets the value of the fundsAvailable property.
     * 
     * @param value
     *     allowed object is
     *     {@link FundsType }
     *     
     */
    public void setFundsAvailable(FundsType value) {
        this.fundsAvailable = value;
    }

    /**
     * Gets the value of the precedenceOrder property.
     * 
     * @return
     *     possible object is
     *     {@link PrecedenceOrderType }
     *     
     */
    public PrecedenceOrderType getPrecedenceOrder() {
        return precedenceOrder;
    }

    /**
     * Sets the value of the precedenceOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrecedenceOrderType }
     *     
     */
    public void setPrecedenceOrder(PrecedenceOrderType value) {
        this.precedenceOrder = value;
    }

    /**
     * Gets the value of the financialHandling property.
     * 
     * @return
     *     possible object is
     *     {@link FinancialHandlingType }
     *     
     */
    public FinancialHandlingType getFinancialHandling() {
        return financialHandling;
    }

    /**
     * Sets the value of the financialHandling property.
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialHandlingType }
     *     
     */
    public void setFinancialHandling(FinancialHandlingType value) {
        this.financialHandling = value;
    }

    /**
     * Gets the value of the accountToAccountTransferAllowed property.
     * 
     */
    public boolean isAccountToAccountTransferAllowed() {
        return accountToAccountTransferAllowed;
    }

    /**
     * Sets the value of the accountToAccountTransferAllowed property.
     * 
     */
    public void setAccountToAccountTransferAllowed(boolean value) {
        this.accountToAccountTransferAllowed = value;
    }

    /**
     * Gets the value of the balanceTransferMinimum property.
     * 
     */
    public long getBalanceTransferMinimum() {
        return balanceTransferMinimum;
    }

    /**
     * Sets the value of the balanceTransferMinimum property.
     * 
     */
    public void setBalanceTransferMinimum(long value) {
        this.balanceTransferMinimum = value;
    }

    /**
     * Gets the value of the balanceTransferMaximum property.
     * 
     */
    public long getBalanceTransferMaximum() {
        return balanceTransferMaximum;
    }

    /**
     * Sets the value of the balanceTransferMaximum property.
     * 
     */
    public void setBalanceTransferMaximum(long value) {
        this.balanceTransferMaximum = value;
    }

    /**
     * Gets the value of the balanceTransferResidualAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBalanceTransferResidualAmount() {
        return balanceTransferResidualAmount;
    }

    /**
     * Sets the value of the balanceTransferResidualAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBalanceTransferResidualAmount(BigDecimal value) {
        this.balanceTransferResidualAmount = value;
    }

    /**
     * Gets the value of the spendingLimitOverride property.
     * 
     */
    public boolean isSpendingLimitOverride() {
        return spendingLimitOverride;
    }

    /**
     * Sets the value of the spendingLimitOverride property.
     * 
     */
    public void setSpendingLimitOverride(boolean value) {
        this.spendingLimitOverride = value;
    }

    /**
     * Gets the value of the isReactivationFeeApplied property.
     * 
     */
    public boolean isIsReactivationFeeApplied() {
        return isReactivationFeeApplied;
    }

    /**
     * Sets the value of the isReactivationFeeApplied property.
     * 
     */
    public void setIsReactivationFeeApplied(boolean value) {
        this.isReactivationFeeApplied = value;
    }

    /**
     * Gets the value of the balanceToBalanceTransferAllowed property.
     * 
     */
    public boolean isBalanceToBalanceTransferAllowed() {
        return balanceToBalanceTransferAllowed;
    }

    /**
     * Sets the value of the balanceToBalanceTransferAllowed property.
     * 
     */
    public void setBalanceToBalanceTransferAllowed(boolean value) {
        this.balanceToBalanceTransferAllowed = value;
    }

    /**
     * Gets the value of the groupMaximumSize property.
     * 
     */
    public long getGroupMaximumSize() {
        return groupMaximumSize;
    }

    /**
     * Sets the value of the groupMaximumSize property.
     * 
     */
    public void setGroupMaximumSize(long value) {
        this.groupMaximumSize = value;
    }

}
