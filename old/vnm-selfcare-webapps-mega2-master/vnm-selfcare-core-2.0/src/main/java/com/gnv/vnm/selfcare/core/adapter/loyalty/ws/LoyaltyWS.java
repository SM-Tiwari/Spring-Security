package com.gnv.vnm.selfcare.core.adapter.loyalty.ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.10
 * 2018-02-02T16:11:46.314+07:00
 * Generated source version: 3.1.10
 * 
 */
@WebServiceClient(name = "loyaltyWS", 
                  wsdlLocation = "classpath:wsdl/LoyaltyWS.wsdl",
                  targetNamespace = "http://iwebservice.nms.com") 
public class LoyaltyWS extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://iwebservice.nms.com", "loyaltyWS");
    public final static QName LoyaltyWSHttpPort = new QName("http://iwebservice.nms.com", "loyaltyWSHttpPort");
    static {
        URL url = null;
        try {
            url = new URL("classpath:wsdl/LoyaltyWS.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(LoyaltyWS.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "classpath:wsdl/LoyaltyWS.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public LoyaltyWS(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public LoyaltyWS(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public LoyaltyWS() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public LoyaltyWS(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public LoyaltyWS(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public LoyaltyWS(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns LoyaltyWSPortType
     */
    @WebEndpoint(name = "loyaltyWSHttpPort")
    public LoyaltyWSPortType getLoyaltyWSHttpPort() {
        return super.getPort(LoyaltyWSHttpPort, LoyaltyWSPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns LoyaltyWSPortType
     */
    @WebEndpoint(name = "loyaltyWSHttpPort")
    public LoyaltyWSPortType getLoyaltyWSHttpPort(WebServiceFeature... features) {
        return super.getPort(LoyaltyWSHttpPort, LoyaltyWSPortType.class, features);
    }

}