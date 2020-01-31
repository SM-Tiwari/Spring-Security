
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PrecedenceOrderType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PrecedenceOrderType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="SpendingLimitMemberBalance"/&gt;
 *     &lt;enumeration value="MemberBalanceSpendingLimit"/&gt;
 *     &lt;enumeration value="NotApplicable"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "PrecedenceOrderType")
@XmlEnum
public enum PrecedenceOrderType {

    @XmlEnumValue("SpendingLimitMemberBalance")
    SPENDING_LIMIT_MEMBER_BALANCE("SpendingLimitMemberBalance"),
    @XmlEnumValue("MemberBalanceSpendingLimit")
    MEMBER_BALANCE_SPENDING_LIMIT("MemberBalanceSpendingLimit"),
    @XmlEnumValue("NotApplicable")
    NOT_APPLICABLE("NotApplicable");
    private final String value;

    PrecedenceOrderType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PrecedenceOrderType fromValue(String v) {
        for (PrecedenceOrderType c: PrecedenceOrderType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
