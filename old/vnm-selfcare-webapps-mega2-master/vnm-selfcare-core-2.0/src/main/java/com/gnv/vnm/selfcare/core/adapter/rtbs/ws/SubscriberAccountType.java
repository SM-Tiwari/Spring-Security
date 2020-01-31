
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SubscriberAccountType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SubscriberAccountType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="GroupOwner"/&gt;
 *     &lt;enumeration value="MemberSL"/&gt;
 *     &lt;enumeration value="Individual"/&gt;
 *     &lt;enumeration value="MemberBL"/&gt;
 *     &lt;enumeration value="MemberBoth"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "SubscriberAccountType")
@XmlEnum
public enum SubscriberAccountType {

    @XmlEnumValue("GroupOwner")
    GROUP_OWNER("GroupOwner"),
    @XmlEnumValue("MemberSL")
    MEMBER_SL("MemberSL"),
    @XmlEnumValue("Individual")
    INDIVIDUAL("Individual"),
    @XmlEnumValue("MemberBL")
    MEMBER_BL("MemberBL"),
    @XmlEnumValue("MemberBoth")
    MEMBER_BOTH("MemberBoth");
    private final String value;

    SubscriberAccountType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SubscriberAccountType fromValue(String v) {
        for (SubscriberAccountType c: SubscriberAccountType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
