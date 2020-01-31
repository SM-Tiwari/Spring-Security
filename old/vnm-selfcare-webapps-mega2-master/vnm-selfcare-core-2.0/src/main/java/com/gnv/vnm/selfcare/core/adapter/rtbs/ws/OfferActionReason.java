
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Offer_Action_Reason.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Offer_Action_Reason"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="SUBSCRIPTION"/&gt;
 *     &lt;enumeration value="RCT_SUBSCRIPTION"/&gt;
 *     &lt;enumeration value="COS_CHANGE_SUBSCRIPTION"/&gt;
 *     &lt;enumeration value="CCWS_OPERATION"/&gt;
 *     &lt;enumeration value="COS_CHANGE_UNSUBSCRIPTION"/&gt;
 *     &lt;enumeration value="BATCH_OPERATION"/&gt;
 *     &lt;enumeration value="RC_ENABLE"/&gt;
 *     &lt;enumeration value="RC_DISABLE"/&gt;
 *     &lt;enumeration value="RC_INACTIVE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "Offer_Action_Reason")
@XmlEnum
public enum OfferActionReason {

    SUBSCRIPTION,
    RCT_SUBSCRIPTION,
    COS_CHANGE_SUBSCRIPTION,
    CCWS_OPERATION,
    COS_CHANGE_UNSUBSCRIPTION,
    BATCH_OPERATION,
    RC_ENABLE,
    RC_DISABLE,
    RC_INACTIVE;

    public String value() {
        return name();
    }

    public static OfferActionReason fromValue(String v) {
        return valueOf(v);
    }

}
