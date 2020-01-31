
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfSubscriberRetrieve complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfSubscriberRetrieve"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SubscriberRetrieve" type="{http://comverse-in.com/prepaid/ccws}SubscriberRetrieve" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfSubscriberRetrieve", propOrder = {
    "subscriberRetrieve"
})
public class ArrayOfSubscriberRetrieve {

    @XmlElement(name = "SubscriberRetrieve", nillable = true)
    protected List<SubscriberRetrieve> subscriberRetrieve;

    /**
     * Gets the value of the subscriberRetrieve property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subscriberRetrieve property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubscriberRetrieve().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubscriberRetrieve }
     * 
     * 
     */
    public List<SubscriberRetrieve> getSubscriberRetrieve() {
        if (subscriberRetrieve == null) {
            subscriberRetrieve = new ArrayList<SubscriberRetrieve>();
        }
        return this.subscriberRetrieve;
    }

}
