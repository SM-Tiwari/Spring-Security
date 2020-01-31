
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FundsUsageType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FundsUsageType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Balances"/&gt;
 *     &lt;enumeration value="SpendingLimits"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "FundsUsageType")
@XmlEnum
public enum FundsUsageType {

    @XmlEnumValue("Balances")
    BALANCES("Balances"),
    @XmlEnumValue("SpendingLimits")
    SPENDING_LIMITS("SpendingLimits");
    private final String value;

    FundsUsageType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FundsUsageType fromValue(String v) {
        for (FundsUsageType c: FundsUsageType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
