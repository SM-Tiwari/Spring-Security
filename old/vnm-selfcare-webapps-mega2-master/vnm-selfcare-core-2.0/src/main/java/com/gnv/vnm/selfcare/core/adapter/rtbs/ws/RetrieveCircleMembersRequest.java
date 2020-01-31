
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RetrieveCircleMembersRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetrieveCircleMembersRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="circle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="startFromSubscriber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="chunkSize" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveCircleMembersRequest", propOrder = {
    "circle",
    "startFromSubscriber",
    "chunkSize"
})
public class RetrieveCircleMembersRequest {

    protected String circle;
    protected String startFromSubscriber;
    protected int chunkSize;

    /**
     * Gets the value of the circle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCircle() {
        return circle;
    }

    /**
     * Sets the value of the circle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCircle(String value) {
        this.circle = value;
    }

    /**
     * Gets the value of the startFromSubscriber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartFromSubscriber() {
        return startFromSubscriber;
    }

    /**
     * Sets the value of the startFromSubscriber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartFromSubscriber(String value) {
        this.startFromSubscriber = value;
    }

    /**
     * Gets the value of the chunkSize property.
     * 
     */
    public int getChunkSize() {
        return chunkSize;
    }

    /**
     * Sets the value of the chunkSize property.
     * 
     */
    public void setChunkSize(int value) {
        this.chunkSize = value;
    }

}
