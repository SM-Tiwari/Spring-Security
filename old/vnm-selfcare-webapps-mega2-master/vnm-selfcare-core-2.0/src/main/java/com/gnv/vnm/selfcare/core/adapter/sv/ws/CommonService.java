package com.gnv.vnm.selfcare.core.adapter.sv.ws;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

/**
 * This class was generated by Apache CXF 3.1.10
 * 2017-06-12T16:43:05.387+07:00
 * Generated source version: 3.1.10
 * 
 */
@WebServiceClient(name = "CommonService", 
                  wsdlLocation = "classpath:wsdl/MigratedService.wsdl",
                  targetNamespace = "http://www.intecbilling.com/HCPT/prepaid_soap") 
public class CommonService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.intecbilling.com/HCPT/prepaid_soap", "CommonService");
    public final static QName CommonPortType = new QName("http://www.intecbilling.com/HCPT/prepaid_soap", "CommonPortType");
    static {
        URL url = CommonService.class.getClassLoader().getResource("wsdl/MigratedService.wsdl");
        if (url == null) {
            java.util.logging.Logger.getLogger(CommonService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "classpath:wsdl/MigratedService.wsdl");
        }       
        WSDL_LOCATION = url;   
    }

    public CommonService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public CommonService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CommonService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public CommonService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public CommonService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public CommonService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns CommonPortType
     */
    @WebEndpoint(name = "CommonPortType")
    public CommonPortType getCommonPortType() {
        return super.getPort(CommonPortType, CommonPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CommonPortType
     */
    @WebEndpoint(name = "CommonPortType")
    public CommonPortType getCommonPortType(WebServiceFeature... features) {
        return super.getPort(CommonPortType, CommonPortType.class, features);
    }

}
