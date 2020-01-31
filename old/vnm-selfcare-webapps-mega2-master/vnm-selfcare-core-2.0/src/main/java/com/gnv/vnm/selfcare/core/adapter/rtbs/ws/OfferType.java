
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Offer_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Offer_Type"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="USAGE"/&gt;
 *     &lt;enumeration value="DISCOUNT_AWARD"/&gt;
 *     &lt;enumeration value="BONUS_AWARD"/&gt;
 *     &lt;enumeration value="OVERRIDE"/&gt;
 *     &lt;enumeration value="OVERRIDE_BBT"/&gt;
 *     &lt;enumeration value="OVERRIDE_HAPPYHOUR"/&gt;
 *     &lt;enumeration value="OVERRIDE_HOMEAREA"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "Offer_Type")
@XmlEnum
public enum OfferType {

    USAGE,
    DISCOUNT_AWARD,
    BONUS_AWARD,
    OVERRIDE,
    OVERRIDE_BBT,
    OVERRIDE_HAPPYHOUR,
    OVERRIDE_HOMEAREA;

    public String value() {
        return name();
    }

    public static OfferType fromValue(String v) {
        return valueOf(v);
    }

}
