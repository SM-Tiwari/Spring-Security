
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AuditEvent.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AuditEvent"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Login"/&gt;
 *     &lt;enumeration value="Logout"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "AuditEvent")
@XmlEnum
public enum AuditEvent2 {

    @XmlEnumValue("Login")
    LOGIN("Login"),
    @XmlEnumValue("Logout")
    LOGOUT("Logout");
    private final String value;

    AuditEvent2(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AuditEvent2 fromValue(String v) {
        for (AuditEvent2 c: AuditEvent2 .values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
