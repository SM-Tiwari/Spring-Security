
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LifeCycle complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LifeCycle"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="allowOriginatingFreeVoiceCalls" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="allowOriginatingBillableCalls" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="allowTerminatingCalls" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="allowGPRS" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="allowOSA" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="allowAdminMenu" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="allowRechargeServer" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="allowCustomerCare" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="allowInfoServer" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LifeCycle", propOrder = {
    "state",
    "allowOriginatingFreeVoiceCalls",
    "allowOriginatingBillableCalls",
    "allowTerminatingCalls",
    "allowGPRS",
    "allowOSA",
    "allowAdminMenu",
    "allowRechargeServer",
    "allowCustomerCare",
    "allowInfoServer"
})
public class LifeCycle {

    protected String state;
    protected boolean allowOriginatingFreeVoiceCalls;
    protected boolean allowOriginatingBillableCalls;
    protected boolean allowTerminatingCalls;
    protected boolean allowGPRS;
    protected boolean allowOSA;
    protected boolean allowAdminMenu;
    protected boolean allowRechargeServer;
    protected boolean allowCustomerCare;
    protected boolean allowInfoServer;

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setState(String value) {
        this.state = value;
    }

    /**
     * Gets the value of the allowOriginatingFreeVoiceCalls property.
     * 
     */
    public boolean isAllowOriginatingFreeVoiceCalls() {
        return allowOriginatingFreeVoiceCalls;
    }

    /**
     * Sets the value of the allowOriginatingFreeVoiceCalls property.
     * 
     */
    public void setAllowOriginatingFreeVoiceCalls(boolean value) {
        this.allowOriginatingFreeVoiceCalls = value;
    }

    /**
     * Gets the value of the allowOriginatingBillableCalls property.
     * 
     */
    public boolean isAllowOriginatingBillableCalls() {
        return allowOriginatingBillableCalls;
    }

    /**
     * Sets the value of the allowOriginatingBillableCalls property.
     * 
     */
    public void setAllowOriginatingBillableCalls(boolean value) {
        this.allowOriginatingBillableCalls = value;
    }

    /**
     * Gets the value of the allowTerminatingCalls property.
     * 
     */
    public boolean isAllowTerminatingCalls() {
        return allowTerminatingCalls;
    }

    /**
     * Sets the value of the allowTerminatingCalls property.
     * 
     */
    public void setAllowTerminatingCalls(boolean value) {
        this.allowTerminatingCalls = value;
    }

    /**
     * Gets the value of the allowGPRS property.
     * 
     */
    public boolean isAllowGPRS() {
        return allowGPRS;
    }

    /**
     * Sets the value of the allowGPRS property.
     * 
     */
    public void setAllowGPRS(boolean value) {
        this.allowGPRS = value;
    }

    /**
     * Gets the value of the allowOSA property.
     * 
     */
    public boolean isAllowOSA() {
        return allowOSA;
    }

    /**
     * Sets the value of the allowOSA property.
     * 
     */
    public void setAllowOSA(boolean value) {
        this.allowOSA = value;
    }

    /**
     * Gets the value of the allowAdminMenu property.
     * 
     */
    public boolean isAllowAdminMenu() {
        return allowAdminMenu;
    }

    /**
     * Sets the value of the allowAdminMenu property.
     * 
     */
    public void setAllowAdminMenu(boolean value) {
        this.allowAdminMenu = value;
    }

    /**
     * Gets the value of the allowRechargeServer property.
     * 
     */
    public boolean isAllowRechargeServer() {
        return allowRechargeServer;
    }

    /**
     * Sets the value of the allowRechargeServer property.
     * 
     */
    public void setAllowRechargeServer(boolean value) {
        this.allowRechargeServer = value;
    }

    /**
     * Gets the value of the allowCustomerCare property.
     * 
     */
    public boolean isAllowCustomerCare() {
        return allowCustomerCare;
    }

    /**
     * Sets the value of the allowCustomerCare property.
     * 
     */
    public void setAllowCustomerCare(boolean value) {
        this.allowCustomerCare = value;
    }

    /**
     * Gets the value of the allowInfoServer property.
     * 
     */
    public boolean isAllowInfoServer() {
        return allowInfoServer;
    }

    /**
     * Sets the value of the allowInfoServer property.
     * 
     */
    public void setAllowInfoServer(boolean value) {
        this.allowInfoServer = value;
    }

}
