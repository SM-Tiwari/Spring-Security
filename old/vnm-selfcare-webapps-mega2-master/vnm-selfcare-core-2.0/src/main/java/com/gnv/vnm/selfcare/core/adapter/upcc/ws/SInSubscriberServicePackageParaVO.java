
package com.gnv.vnm.selfcare.core.adapter.upcc.ws;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SInSubscriberServicePackageParaVO complex type.
 * 
 * <p>The following schema fragment specifies the expected result contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SInSubscriberServicePackageParaVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="subscriber" type="{rm:type}SPccSubscriber"/>
 *         &lt;element name="servicePackage" type="{rm:type}SServicePackage" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SInSubscriberServicePackageParaVO", propOrder = {
    "subscriber",
    "servicePackage"
})
public class SInSubscriberServicePackageParaVO {

    @XmlElement(required = true)
    protected SPccSubscriber subscriber;
    protected List<SServicePackage> servicePackage;

    /**
     * Gets the value of the subscriber property.
     * 
     * @return
     *     possible object is
     *     {@link SPccSubscriber }
     *     
     */
    public SPccSubscriber getSubscriber() {
        return subscriber;
    }

    /**
     * Sets the value of the subscriber property.
     * 
     * @param value
     *     allowed object is
     *     {@link SPccSubscriber }
     *     
     */
    public void setSubscriber(SPccSubscriber value) {
        this.subscriber = value;
    }

    /**
     * Gets the value of the servicePackage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the servicePackage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServicePackage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SServicePackage }
     * 
     * 
     */
    public List<SServicePackage> getServicePackage() {
        if (servicePackage == null) {
            servicePackage = new ArrayList<SServicePackage>();
        }
        return this.servicePackage;
    }

}
