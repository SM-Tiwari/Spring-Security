
package com.gnv.vnm.selfcare.core.adapter.upcc.ws;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SReturnVO complex type.
 * 
 * <p>The following schema fragment specifies the expected result contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SReturnVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="resultCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="paras" type="{rm:type}SAVP" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="subscriber" type="{rm:type}SPccSubscriber" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="subscribedService" type="{rm:type}SSubscribedService" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="subscriberQuota" type="{rm:type}SSubscriberQuota" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="subscriberAccount" type="{rm:type}SSubscriberAccount" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="servicePackage" type="{rm:type}SServicePackage" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="subscriberAccumulation" type="{rm:type}SSubscriberAccumulation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="subscriberAccumulationUsageInfo" type="{rm:type}SSubscriberAccumulationUsageInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="subscriberCustomLevel" type="{rm:type}SSubscriberCustomLevel" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="subscriberAlias" type="{rm:type}SSubscriberAlias" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="sharedQuota" type="{rm:type}SSubscriberSharedQuota" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="subscriberGroupMemberQuota" type="{rm:type}SSubscriberGroupMemberQuota" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="subscriberGroupMemberNumber" type="{rm:type}SSubscriberGroupMemberNumber" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="subscriberGroupMemberId" type="{rm:type}SSubscriberGroupMemberId" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="subscriberGroupMemberDesc" type="{rm:type}SSubscriberGroupMemberDesc" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SReturnVO", propOrder = {
    "resultCode",
    "paras",
    "subscriber",
    "subscribedService",
    "subscriberQuota",
    "subscriberAccount",
    "servicePackage",
    "subscriberAccumulation",
    "subscriberAccumulationUsageInfo",
    "subscriberCustomLevel",
    "subscriberAlias",
    "sharedQuota",
    "subscriberGroupMemberQuota",
    "subscriberGroupMemberNumber",
    "subscriberGroupMemberId",
    "subscriberGroupMemberDesc"
})
public class SReturnVO {

    protected int resultCode;
    protected List<SAVP> paras;
    protected List<SPccSubscriber> subscriber;
    protected List<SSubscribedService> subscribedService;
    protected List<SSubscriberQuota> subscriberQuota;
    protected List<SSubscriberAccount> subscriberAccount;
    protected List<SServicePackage> servicePackage;
    protected List<SSubscriberAccumulation> subscriberAccumulation;
    protected List<SSubscriberAccumulationUsageInfo> subscriberAccumulationUsageInfo;
    protected List<SSubscriberCustomLevel> subscriberCustomLevel;
    protected List<SSubscriberAlias> subscriberAlias;
    protected List<SSubscriberSharedQuota> sharedQuota;
    protected List<SSubscriberGroupMemberQuota> subscriberGroupMemberQuota;
    protected List<SSubscriberGroupMemberNumber> subscriberGroupMemberNumber;
    protected List<SSubscriberGroupMemberId> subscriberGroupMemberId;
    protected List<SSubscriberGroupMemberDesc> subscriberGroupMemberDesc;

    /**
     * Gets the value of the resultCode property.
     * 
     */
    public int getResultCode() {
        return resultCode;
    }

    /**
     * Sets the value of the resultCode property.
     * 
     */
    public void setResultCode(int value) {
        this.resultCode = value;
    }

    /**
     * Gets the value of the paras property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paras property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SAVP }
     * 
     * 
     */
    public List<SAVP> getParas() {
        if (paras == null) {
            paras = new ArrayList<SAVP>();
        }
        return this.paras;
    }

    /**
     * Gets the value of the subscriber property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subscriber property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubscriber().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SPccSubscriber }
     * 
     * 
     */
    public List<SPccSubscriber> getSubscriber() {
        if (subscriber == null) {
            subscriber = new ArrayList<SPccSubscriber>();
        }
        return this.subscriber;
    }

    /**
     * Gets the value of the subscribedService property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subscribedService property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubscribedService().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SSubscribedService }
     * 
     * 
     */
    public List<SSubscribedService> getSubscribedService() {
        if (subscribedService == null) {
            subscribedService = new ArrayList<SSubscribedService>();
        }
        return this.subscribedService;
    }

    /**
     * Gets the value of the subscriberQuota property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subscriberQuota property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubscriberQuota().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SSubscriberQuota }
     * 
     * 
     */
    public List<SSubscriberQuota> getSubscriberQuota() {
        if (subscriberQuota == null) {
            subscriberQuota = new ArrayList<SSubscriberQuota>();
        }
        return this.subscriberQuota;
    }

    /**
     * Gets the value of the subscriberAccount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subscriberAccount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubscriberAccount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SSubscriberAccount }
     * 
     * 
     */
    public List<SSubscriberAccount> getSubscriberAccount() {
        if (subscriberAccount == null) {
            subscriberAccount = new ArrayList<SSubscriberAccount>();
        }
        return this.subscriberAccount;
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

    /**
     * Gets the value of the subscriberAccumulation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subscriberAccumulation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubscriberAccumulation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SSubscriberAccumulation }
     * 
     * 
     */
    public List<SSubscriberAccumulation> getSubscriberAccumulation() {
        if (subscriberAccumulation == null) {
            subscriberAccumulation = new ArrayList<SSubscriberAccumulation>();
        }
        return this.subscriberAccumulation;
    }

    /**
     * Gets the value of the subscriberAccumulationUsageInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subscriberAccumulationUsageInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubscriberAccumulationUsageInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SSubscriberAccumulationUsageInfo }
     * 
     * 
     */
    public List<SSubscriberAccumulationUsageInfo> getSubscriberAccumulationUsageInfo() {
        if (subscriberAccumulationUsageInfo == null) {
            subscriberAccumulationUsageInfo = new ArrayList<SSubscriberAccumulationUsageInfo>();
        }
        return this.subscriberAccumulationUsageInfo;
    }

    /**
     * Gets the value of the subscriberCustomLevel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subscriberCustomLevel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubscriberCustomLevel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SSubscriberCustomLevel }
     * 
     * 
     */
    public List<SSubscriberCustomLevel> getSubscriberCustomLevel() {
        if (subscriberCustomLevel == null) {
            subscriberCustomLevel = new ArrayList<SSubscriberCustomLevel>();
        }
        return this.subscriberCustomLevel;
    }

    /**
     * Gets the value of the subscriberAlias property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subscriberAlias property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubscriberAlias().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SSubscriberAlias }
     * 
     * 
     */
    public List<SSubscriberAlias> getSubscriberAlias() {
        if (subscriberAlias == null) {
            subscriberAlias = new ArrayList<SSubscriberAlias>();
        }
        return this.subscriberAlias;
    }

    /**
     * Gets the value of the sharedQuota property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sharedQuota property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSharedQuota().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SSubscriberSharedQuota }
     * 
     * 
     */
    public List<SSubscriberSharedQuota> getSharedQuota() {
        if (sharedQuota == null) {
            sharedQuota = new ArrayList<SSubscriberSharedQuota>();
        }
        return this.sharedQuota;
    }

    /**
     * Gets the value of the subscriberGroupMemberQuota property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subscriberGroupMemberQuota property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubscriberGroupMemberQuota().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SSubscriberGroupMemberQuota }
     * 
     * 
     */
    public List<SSubscriberGroupMemberQuota> getSubscriberGroupMemberQuota() {
        if (subscriberGroupMemberQuota == null) {
            subscriberGroupMemberQuota = new ArrayList<SSubscriberGroupMemberQuota>();
        }
        return this.subscriberGroupMemberQuota;
    }

    /**
     * Gets the value of the subscriberGroupMemberNumber property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subscriberGroupMemberNumber property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubscriberGroupMemberNumber().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SSubscriberGroupMemberNumber }
     * 
     * 
     */
    public List<SSubscriberGroupMemberNumber> getSubscriberGroupMemberNumber() {
        if (subscriberGroupMemberNumber == null) {
            subscriberGroupMemberNumber = new ArrayList<SSubscriberGroupMemberNumber>();
        }
        return this.subscriberGroupMemberNumber;
    }

    /**
     * Gets the value of the subscriberGroupMemberId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subscriberGroupMemberId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubscriberGroupMemberId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SSubscriberGroupMemberId }
     * 
     * 
     */
    public List<SSubscriberGroupMemberId> getSubscriberGroupMemberId() {
        if (subscriberGroupMemberId == null) {
            subscriberGroupMemberId = new ArrayList<SSubscriberGroupMemberId>();
        }
        return this.subscriberGroupMemberId;
    }

    /**
     * Gets the value of the subscriberGroupMemberDesc property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subscriberGroupMemberDesc property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubscriberGroupMemberDesc().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SSubscriberGroupMemberDesc }
     * 
     * 
     */
    public List<SSubscriberGroupMemberDesc> getSubscriberGroupMemberDesc() {
        if (subscriberGroupMemberDesc == null) {
            subscriberGroupMemberDesc = new ArrayList<SSubscriberGroupMemberDesc>();
        }
        return this.subscriberGroupMemberDesc;
    }

}
