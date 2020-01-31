
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GroupMemberType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="GroupMemberType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="GroupMember"/&gt;
 *     &lt;enumeration value="GroupOwner"/&gt;
 *     &lt;enumeration value="Both"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "GroupMemberType")
@XmlEnum
public enum GroupMemberType {

    @XmlEnumValue("GroupMember")
    GROUP_MEMBER("GroupMember"),
    @XmlEnumValue("GroupOwner")
    GROUP_OWNER("GroupOwner"),
    @XmlEnumValue("Both")
    BOTH("Both");
    private final String value;

    GroupMemberType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GroupMemberType fromValue(String v) {
        for (GroupMemberType c: GroupMemberType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
