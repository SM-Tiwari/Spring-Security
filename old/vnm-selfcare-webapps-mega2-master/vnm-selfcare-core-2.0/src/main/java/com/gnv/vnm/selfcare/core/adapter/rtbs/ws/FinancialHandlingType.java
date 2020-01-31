
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FinancialHandlingType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FinancialHandlingType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Common"/&gt;
 *     &lt;enumeration value="Segregated"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "FinancialHandlingType")
@XmlEnum
public enum FinancialHandlingType {

    @XmlEnumValue("Common")
    COMMON("Common"),
    @XmlEnumValue("Segregated")
    SEGREGATED("Segregated");
    private final String value;

    FinancialHandlingType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FinancialHandlingType fromValue(String v) {
        for (FinancialHandlingType c: FinancialHandlingType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
