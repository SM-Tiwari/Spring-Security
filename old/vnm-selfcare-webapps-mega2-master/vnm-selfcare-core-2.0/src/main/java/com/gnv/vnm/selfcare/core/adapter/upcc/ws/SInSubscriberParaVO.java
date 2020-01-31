
package com.gnv.vnm.selfcare.core.adapter.upcc.ws;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SInSubscriberParaVO complex type.
 * 
 * <p>The following schema fragment specifies the expected result contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SInSubscriberParaVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="subscriber" type="{rm:type}SPccSubscriber"/>
 *         &lt;element name="deleteService" type="{rm:type}SSubscribedService" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="modifyService" type="{rm:type}SSubscribedService" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="addService" type="{rm:type}SSubscribedService" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SInSubscriberParaVO", propOrder = {
    "subscriber",
    "deleteService",
    "modifyService",
    "addService"
})
public class SInSubscriberParaVO {

    @XmlElement(required = true)
    protected SPccSubscriber subscriber;
    protected List<SSubscribedService> deleteService;
    protected List<SSubscribedService> modifyService;
    protected List<SSubscribedService> addService;

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
     * Gets the value of the deleteService property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the deleteService property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDeleteService().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SSubscribedService }
     * 
     * 
     */
    public List<SSubscribedService> getDeleteService() {
        if (deleteService == null) {
            deleteService = new ArrayList<SSubscribedService>();
        }
        return this.deleteService;
    }

    /**
     * Gets the value of the modifyService property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the modifyService property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getModifyService().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SSubscribedService }
     * 
     * 
     */
    public List<SSubscribedService> getModifyService() {
        if (modifyService == null) {
            modifyService = new ArrayList<SSubscribedService>();
        }
        return this.modifyService;
    }

    /**
     * Gets the value of the addService property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the addService property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddService().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SSubscribedService }
     * 
     * 
     */
    public List<SSubscribedService> getAddService() {
        if (addService == null) {
            addService = new ArrayList<SSubscribedService>();
        }
        return this.addService;
    }

}
