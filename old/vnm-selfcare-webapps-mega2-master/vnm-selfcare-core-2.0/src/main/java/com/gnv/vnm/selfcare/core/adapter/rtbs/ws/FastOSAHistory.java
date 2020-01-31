
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FastOSAHistory complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FastOSAHistory"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://comverse-in.com/prepaid/ccws}OSAHistory"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="NewBalance1" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="NewBalance2" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="NewBalance3" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="NewBalance4" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="NewBalance5" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="NewBalance6" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="NewBalance7" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="NewBalance8" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="NewBalance9" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="NewBalance10" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="ChangeAmount1" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="ChangeAmount2" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="ChangeAmount3" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="ChangeAmount4" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="ChangeAmount5" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="ChangeAmount6" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="ChangeAmount7" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="ChangeAmount8" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="ChangeAmount9" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="ChangeAmount10" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FastOSAHistory", propOrder = {
    "newBalance1",
    "newBalance2",
    "newBalance3",
    "newBalance4",
    "newBalance5",
    "newBalance6",
    "newBalance7",
    "newBalance8",
    "newBalance9",
    "newBalance10",
    "changeAmount1",
    "changeAmount2",
    "changeAmount3",
    "changeAmount4",
    "changeAmount5",
    "changeAmount6",
    "changeAmount7",
    "changeAmount8",
    "changeAmount9",
    "changeAmount10"
})
public class FastOSAHistory
    extends OSAHistory
{

    @XmlElement(name = "NewBalance1")
    protected double newBalance1;
    @XmlElement(name = "NewBalance2")
    protected double newBalance2;
    @XmlElement(name = "NewBalance3")
    protected double newBalance3;
    @XmlElement(name = "NewBalance4")
    protected double newBalance4;
    @XmlElement(name = "NewBalance5")
    protected double newBalance5;
    @XmlElement(name = "NewBalance6")
    protected double newBalance6;
    @XmlElement(name = "NewBalance7")
    protected double newBalance7;
    @XmlElement(name = "NewBalance8")
    protected double newBalance8;
    @XmlElement(name = "NewBalance9")
    protected double newBalance9;
    @XmlElement(name = "NewBalance10")
    protected double newBalance10;
    @XmlElement(name = "ChangeAmount1")
    protected double changeAmount1;
    @XmlElement(name = "ChangeAmount2")
    protected double changeAmount2;
    @XmlElement(name = "ChangeAmount3")
    protected double changeAmount3;
    @XmlElement(name = "ChangeAmount4")
    protected double changeAmount4;
    @XmlElement(name = "ChangeAmount5")
    protected double changeAmount5;
    @XmlElement(name = "ChangeAmount6")
    protected double changeAmount6;
    @XmlElement(name = "ChangeAmount7")
    protected double changeAmount7;
    @XmlElement(name = "ChangeAmount8")
    protected double changeAmount8;
    @XmlElement(name = "ChangeAmount9")
    protected double changeAmount9;
    @XmlElement(name = "ChangeAmount10")
    protected double changeAmount10;

    /**
     * Gets the value of the newBalance1 property.
     * 
     */
    public double getNewBalance1() {
        return newBalance1;
    }

    /**
     * Sets the value of the newBalance1 property.
     * 
     */
    public void setNewBalance1(double value) {
        this.newBalance1 = value;
    }

    /**
     * Gets the value of the newBalance2 property.
     * 
     */
    public double getNewBalance2() {
        return newBalance2;
    }

    /**
     * Sets the value of the newBalance2 property.
     * 
     */
    public void setNewBalance2(double value) {
        this.newBalance2 = value;
    }

    /**
     * Gets the value of the newBalance3 property.
     * 
     */
    public double getNewBalance3() {
        return newBalance3;
    }

    /**
     * Sets the value of the newBalance3 property.
     * 
     */
    public void setNewBalance3(double value) {
        this.newBalance3 = value;
    }

    /**
     * Gets the value of the newBalance4 property.
     * 
     */
    public double getNewBalance4() {
        return newBalance4;
    }

    /**
     * Sets the value of the newBalance4 property.
     * 
     */
    public void setNewBalance4(double value) {
        this.newBalance4 = value;
    }

    /**
     * Gets the value of the newBalance5 property.
     * 
     */
    public double getNewBalance5() {
        return newBalance5;
    }

    /**
     * Sets the value of the newBalance5 property.
     * 
     */
    public void setNewBalance5(double value) {
        this.newBalance5 = value;
    }

    /**
     * Gets the value of the newBalance6 property.
     * 
     */
    public double getNewBalance6() {
        return newBalance6;
    }

    /**
     * Sets the value of the newBalance6 property.
     * 
     */
    public void setNewBalance6(double value) {
        this.newBalance6 = value;
    }

    /**
     * Gets the value of the newBalance7 property.
     * 
     */
    public double getNewBalance7() {
        return newBalance7;
    }

    /**
     * Sets the value of the newBalance7 property.
     * 
     */
    public void setNewBalance7(double value) {
        this.newBalance7 = value;
    }

    /**
     * Gets the value of the newBalance8 property.
     * 
     */
    public double getNewBalance8() {
        return newBalance8;
    }

    /**
     * Sets the value of the newBalance8 property.
     * 
     */
    public void setNewBalance8(double value) {
        this.newBalance8 = value;
    }

    /**
     * Gets the value of the newBalance9 property.
     * 
     */
    public double getNewBalance9() {
        return newBalance9;
    }

    /**
     * Sets the value of the newBalance9 property.
     * 
     */
    public void setNewBalance9(double value) {
        this.newBalance9 = value;
    }

    /**
     * Gets the value of the newBalance10 property.
     * 
     */
    public double getNewBalance10() {
        return newBalance10;
    }

    /**
     * Sets the value of the newBalance10 property.
     * 
     */
    public void setNewBalance10(double value) {
        this.newBalance10 = value;
    }

    /**
     * Gets the value of the changeAmount1 property.
     * 
     */
    public double getChangeAmount1() {
        return changeAmount1;
    }

    /**
     * Sets the value of the changeAmount1 property.
     * 
     */
    public void setChangeAmount1(double value) {
        this.changeAmount1 = value;
    }

    /**
     * Gets the value of the changeAmount2 property.
     * 
     */
    public double getChangeAmount2() {
        return changeAmount2;
    }

    /**
     * Sets the value of the changeAmount2 property.
     * 
     */
    public void setChangeAmount2(double value) {
        this.changeAmount2 = value;
    }

    /**
     * Gets the value of the changeAmount3 property.
     * 
     */
    public double getChangeAmount3() {
        return changeAmount3;
    }

    /**
     * Sets the value of the changeAmount3 property.
     * 
     */
    public void setChangeAmount3(double value) {
        this.changeAmount3 = value;
    }

    /**
     * Gets the value of the changeAmount4 property.
     * 
     */
    public double getChangeAmount4() {
        return changeAmount4;
    }

    /**
     * Sets the value of the changeAmount4 property.
     * 
     */
    public void setChangeAmount4(double value) {
        this.changeAmount4 = value;
    }

    /**
     * Gets the value of the changeAmount5 property.
     * 
     */
    public double getChangeAmount5() {
        return changeAmount5;
    }

    /**
     * Sets the value of the changeAmount5 property.
     * 
     */
    public void setChangeAmount5(double value) {
        this.changeAmount5 = value;
    }

    /**
     * Gets the value of the changeAmount6 property.
     * 
     */
    public double getChangeAmount6() {
        return changeAmount6;
    }

    /**
     * Sets the value of the changeAmount6 property.
     * 
     */
    public void setChangeAmount6(double value) {
        this.changeAmount6 = value;
    }

    /**
     * Gets the value of the changeAmount7 property.
     * 
     */
    public double getChangeAmount7() {
        return changeAmount7;
    }

    /**
     * Sets the value of the changeAmount7 property.
     * 
     */
    public void setChangeAmount7(double value) {
        this.changeAmount7 = value;
    }

    /**
     * Gets the value of the changeAmount8 property.
     * 
     */
    public double getChangeAmount8() {
        return changeAmount8;
    }

    /**
     * Sets the value of the changeAmount8 property.
     * 
     */
    public void setChangeAmount8(double value) {
        this.changeAmount8 = value;
    }

    /**
     * Gets the value of the changeAmount9 property.
     * 
     */
    public double getChangeAmount9() {
        return changeAmount9;
    }

    /**
     * Sets the value of the changeAmount9 property.
     * 
     */
    public void setChangeAmount9(double value) {
        this.changeAmount9 = value;
    }

    /**
     * Gets the value of the changeAmount10 property.
     * 
     */
    public double getChangeAmount10() {
        return changeAmount10;
    }

    /**
     * Sets the value of the changeAmount10 property.
     * 
     */
    public void setChangeAmount10(double value) {
        this.changeAmount10 = value;
    }

}
