
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Offer_Action.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Offer_Action"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="SUBSCRIPTION"/&gt;
 *     &lt;enumeration value="UNSUBSCRIPTION"/&gt;
 *     &lt;enumeration value="RCSTATE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "Offer_Action")
@XmlEnum
public enum OfferAction {

    SUBSCRIPTION,
    UNSUBSCRIPTION,
    RCSTATE;

    public String value() {
        return name();
    }

    public static OfferAction fromValue(String v) {
        return valueOf(v);
    }

}
