
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PeriodicChargeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PeriodicChargeType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Recurring"/&gt;
 *     &lt;enumeration value="NonRecurring"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "PeriodicChargeType")
@XmlEnum
public enum PeriodicChargeType {

    @XmlEnumValue("Recurring")
    RECURRING("Recurring"),
    @XmlEnumValue("NonRecurring")
    NON_RECURRING("NonRecurring");
    private final String value;

    PeriodicChargeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PeriodicChargeType fromValue(String v) {
        for (PeriodicChargeType c: PeriodicChargeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
