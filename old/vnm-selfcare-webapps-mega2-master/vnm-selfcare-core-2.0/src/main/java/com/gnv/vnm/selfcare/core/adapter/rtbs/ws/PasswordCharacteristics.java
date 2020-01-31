
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PasswordCharacteristics complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PasswordCharacteristics"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MinLength" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="MaxLength" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="MinNumeric" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="MinLower" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="MinUpper" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="MinSpecial" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="UnusableOldPwds" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="ExpDays" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="ExpDaysSplRole" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="MaxFailedAttempts" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="WarningDays" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="UnlockTime" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PasswordCharacteristics", propOrder = {
    "minLength",
    "maxLength",
    "minNumeric",
    "minLower",
    "minUpper",
    "minSpecial",
    "unusableOldPwds",
    "expDays",
    "expDaysSplRole",
    "maxFailedAttempts",
    "warningDays",
    "unlockTime"
})
public class PasswordCharacteristics {

    @XmlElement(name = "MinLength")
    protected int minLength;
    @XmlElement(name = "MaxLength")
    protected int maxLength;
    @XmlElement(name = "MinNumeric")
    protected int minNumeric;
    @XmlElement(name = "MinLower")
    protected int minLower;
    @XmlElement(name = "MinUpper")
    protected int minUpper;
    @XmlElement(name = "MinSpecial")
    protected int minSpecial;
    @XmlElement(name = "UnusableOldPwds")
    protected int unusableOldPwds;
    @XmlElement(name = "ExpDays")
    protected int expDays;
    @XmlElement(name = "ExpDaysSplRole")
    protected int expDaysSplRole;
    @XmlElement(name = "MaxFailedAttempts")
    protected int maxFailedAttempts;
    @XmlElement(name = "WarningDays")
    protected int warningDays;
    @XmlElement(name = "UnlockTime")
    protected int unlockTime;

    /**
     * Gets the value of the minLength property.
     * 
     */
    public int getMinLength() {
        return minLength;
    }

    /**
     * Sets the value of the minLength property.
     * 
     */
    public void setMinLength(int value) {
        this.minLength = value;
    }

    /**
     * Gets the value of the maxLength property.
     * 
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * Sets the value of the maxLength property.
     * 
     */
    public void setMaxLength(int value) {
        this.maxLength = value;
    }

    /**
     * Gets the value of the minNumeric property.
     * 
     */
    public int getMinNumeric() {
        return minNumeric;
    }

    /**
     * Sets the value of the minNumeric property.
     * 
     */
    public void setMinNumeric(int value) {
        this.minNumeric = value;
    }

    /**
     * Gets the value of the minLower property.
     * 
     */
    public int getMinLower() {
        return minLower;
    }

    /**
     * Sets the value of the minLower property.
     * 
     */
    public void setMinLower(int value) {
        this.minLower = value;
    }

    /**
     * Gets the value of the minUpper property.
     * 
     */
    public int getMinUpper() {
        return minUpper;
    }

    /**
     * Sets the value of the minUpper property.
     * 
     */
    public void setMinUpper(int value) {
        this.minUpper = value;
    }

    /**
     * Gets the value of the minSpecial property.
     * 
     */
    public int getMinSpecial() {
        return minSpecial;
    }

    /**
     * Sets the value of the minSpecial property.
     * 
     */
    public void setMinSpecial(int value) {
        this.minSpecial = value;
    }

    /**
     * Gets the value of the unusableOldPwds property.
     * 
     */
    public int getUnusableOldPwds() {
        return unusableOldPwds;
    }

    /**
     * Sets the value of the unusableOldPwds property.
     * 
     */
    public void setUnusableOldPwds(int value) {
        this.unusableOldPwds = value;
    }

    /**
     * Gets the value of the expDays property.
     * 
     */
    public int getExpDays() {
        return expDays;
    }

    /**
     * Sets the value of the expDays property.
     * 
     */
    public void setExpDays(int value) {
        this.expDays = value;
    }

    /**
     * Gets the value of the expDaysSplRole property.
     * 
     */
    public int getExpDaysSplRole() {
        return expDaysSplRole;
    }

    /**
     * Sets the value of the expDaysSplRole property.
     * 
     */
    public void setExpDaysSplRole(int value) {
        this.expDaysSplRole = value;
    }

    /**
     * Gets the value of the maxFailedAttempts property.
     * 
     */
    public int getMaxFailedAttempts() {
        return maxFailedAttempts;
    }

    /**
     * Sets the value of the maxFailedAttempts property.
     * 
     */
    public void setMaxFailedAttempts(int value) {
        this.maxFailedAttempts = value;
    }

    /**
     * Gets the value of the warningDays property.
     * 
     */
    public int getWarningDays() {
        return warningDays;
    }

    /**
     * Sets the value of the warningDays property.
     * 
     */
    public void setWarningDays(int value) {
        this.warningDays = value;
    }

    /**
     * Gets the value of the unlockTime property.
     * 
     */
    public int getUnlockTime() {
        return unlockTime;
    }

    /**
     * Sets the value of the unlockTime property.
     * 
     */
    public void setUnlockTime(int value) {
        this.unlockTime = value;
    }

}
