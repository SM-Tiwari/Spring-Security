
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AlcsOverrideDefinition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AlcsOverrideDefinition"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="alcsID" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="maxHappyHours" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="blockoutHours" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dailyResetFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="minValidityPeriod" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="homeArea1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="homeArea2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="homeArea3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="homeArea4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AlcsOverrideDefinition", propOrder = {
    "alcsID",
    "maxHappyHours",
    "blockoutHours",
    "dailyResetFlag",
    "minValidityPeriod",
    "homeArea1",
    "homeArea2",
    "homeArea3",
    "homeArea4"
})
public class AlcsOverrideDefinition {

    protected long alcsID;
    protected long maxHappyHours;
    protected String blockoutHours;
    protected String dailyResetFlag;
    protected long minValidityPeriod;
    protected String homeArea1;
    protected String homeArea2;
    protected String homeArea3;
    protected String homeArea4;

    /**
     * Gets the value of the alcsID property.
     * 
     */
    public long getAlcsID() {
        return alcsID;
    }

    /**
     * Sets the value of the alcsID property.
     * 
     */
    public void setAlcsID(long value) {
        this.alcsID = value;
    }

    /**
     * Gets the value of the maxHappyHours property.
     * 
     */
    public long getMaxHappyHours() {
        return maxHappyHours;
    }

    /**
     * Sets the value of the maxHappyHours property.
     * 
     */
    public void setMaxHappyHours(long value) {
        this.maxHappyHours = value;
    }

    /**
     * Gets the value of the blockoutHours property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBlockoutHours() {
        return blockoutHours;
    }

    /**
     * Sets the value of the blockoutHours property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBlockoutHours(String value) {
        this.blockoutHours = value;
    }

    /**
     * Gets the value of the dailyResetFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDailyResetFlag() {
        return dailyResetFlag;
    }

    /**
     * Sets the value of the dailyResetFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDailyResetFlag(String value) {
        this.dailyResetFlag = value;
    }

    /**
     * Gets the value of the minValidityPeriod property.
     * 
     */
    public long getMinValidityPeriod() {
        return minValidityPeriod;
    }

    /**
     * Sets the value of the minValidityPeriod property.
     * 
     */
    public void setMinValidityPeriod(long value) {
        this.minValidityPeriod = value;
    }

    /**
     * Gets the value of the homeArea1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHomeArea1() {
        return homeArea1;
    }

    /**
     * Sets the value of the homeArea1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHomeArea1(String value) {
        this.homeArea1 = value;
    }

    /**
     * Gets the value of the homeArea2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHomeArea2() {
        return homeArea2;
    }

    /**
     * Sets the value of the homeArea2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHomeArea2(String value) {
        this.homeArea2 = value;
    }

    /**
     * Gets the value of the homeArea3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHomeArea3() {
        return homeArea3;
    }

    /**
     * Sets the value of the homeArea3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHomeArea3(String value) {
        this.homeArea3 = value;
    }

    /**
     * Gets the value of the homeArea4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHomeArea4() {
        return homeArea4;
    }

    /**
     * Sets the value of the homeArea4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHomeArea4(String value) {
        this.homeArea4 = value;
    }

}
