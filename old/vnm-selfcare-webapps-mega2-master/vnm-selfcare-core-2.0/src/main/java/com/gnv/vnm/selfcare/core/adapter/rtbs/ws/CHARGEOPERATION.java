
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CHARGE_OPERATION.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CHARGE_OPERATION"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="ADD"/&gt;
 *     &lt;enumeration value="SUBTRACT"/&gt;
 *     &lt;enumeration value="PUT"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CHARGE_OPERATION")
@XmlEnum
public enum CHARGEOPERATION {

    ADD,
    SUBTRACT,
    PUT;

    public String value() {
        return name();
    }

    public static CHARGEOPERATION fromValue(String v) {
        return valueOf(v);
    }

}
