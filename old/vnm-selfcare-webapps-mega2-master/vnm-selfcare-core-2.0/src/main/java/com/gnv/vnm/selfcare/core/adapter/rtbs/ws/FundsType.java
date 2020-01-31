
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FundsType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FundsType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="SpendingLimitOnly"/&gt;
 *     &lt;enumeration value="BalanceOnly"/&gt;
 *     &lt;enumeration value="SpendingLimitAndBalance"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "FundsType")
@XmlEnum
public enum FundsType {

    @XmlEnumValue("SpendingLimitOnly")
    SPENDING_LIMIT_ONLY("SpendingLimitOnly"),
    @XmlEnumValue("BalanceOnly")
    BALANCE_ONLY("BalanceOnly"),
    @XmlEnumValue("SpendingLimitAndBalance")
    SPENDING_LIMIT_AND_BALANCE("SpendingLimitAndBalance");
    private final String value;

    FundsType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FundsType fromValue(String v) {
        for (FundsType c: FundsType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
