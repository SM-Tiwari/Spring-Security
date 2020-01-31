
package com.gnv.vnm.selfcare.core.adapter.tibco;

import javax.xml.bind.annotation.XmlRegistry;

import com.gnv.vnm.selfcare.core.adapter.tibco.hotbilling.HotBillingResponse;
import com.gnv.vnm.selfcare.core.adapter.tibco.hotbilling.HotBillingRequest;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.gnv.vnm.selfcare.core.adapter.tibco.hotbilling package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class HotBillingObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.gnv.vnm.selfcare.core.adapter.tibco.hotbilling
     * 
     */
    public HotBillingObjectFactory() {
    }

    /**
     * Create an instance of {@link HotBillingRequest }
     * 
     */
    public HotBillingRequest createRequest() {
        return new HotBillingRequest();
    }

    /**
     * Create an instance of {@link HotBillingResponse }
     * 
     */
    public HotBillingResponse createResponse() {
        return new HotBillingResponse();
    }

}
