
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CircleOperation.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CircleOperation"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="JOIN"/&gt;
 *     &lt;enumeration value="LEAVE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CircleOperation")
@XmlEnum
public enum CircleOperation {

    JOIN,
    LEAVE;

    public String value() {
        return name();
    }

    public static CircleOperation fromValue(String v) {
        return valueOf(v);
    }

}
