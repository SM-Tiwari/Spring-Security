
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package com.gnv.vnm.selfcare.core.adapter.loyaltynew.ws;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.6
 * 2018-10-10T10:47:26.475+05:30
 * Generated source version: 3.2.6
 *
 */

@javax.jws.WebService(
                      serviceName = "LoyaltyWS",
                      portName = "LoyaltyWSHttpPort",
                      targetNamespace = "http://iwebservice.nms.com",
                      wsdlLocation = "file:/D:/workSpace/VietApi/vnm-selfcare-webapps-mega2-master/resources/wsdl/LoyaltyWSFatty.wsdl",
                      endpointInterface = "com.gnv.vnm.selfcare.core.adapter.loyaltynew.ws.LoyaltyWSPortType")

public class LoyaltyWSHttpPortImpl implements LoyaltyWSPortType {

    private static final Logger LOG = Logger.getLogger(LoyaltyWSHttpPortImpl.class.getName());

    /* (non-Javadoc)
     * @see com.gnv.vnm.selfcare.core.adapter.loyaltynew.ws.LoyaltyWSPortType#redeemPoint(com.elcom.loyalty.LoyaltyRedeempointReq in0)*
     */
    public com.elcom.loyalty.LoyaltyResp redeemPoint(com.elcom.loyalty.LoyaltyRedeempointReq in0) {
        LOG.info("Executing operation redeemPoint");
        System.out.println(in0);
        try {
            com.elcom.loyalty.LoyaltyResp _return = new com.elcom.loyalty.LoyaltyResp();
            javax.xml.bind.JAXBElement<java.lang.String> _returnErrorCode = null;
            _return.setErrorCode(_returnErrorCode);
            javax.xml.bind.JAXBElement<java.lang.String> _returnErrorDetail = null;
            _return.setErrorDetail(_returnErrorDetail);
            javax.xml.bind.JAXBElement<java.lang.String> _returnIsdn = null;
            _return.setIsdn(_returnIsdn);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.gnv.vnm.selfcare.core.adapter.loyaltynew.ws.LoyaltyWSPortType#checkPoint(com.elcom.loyalty.LoyaltyReq in0)*
     */
    public com.elcom.loyalty.LoyaltyCheckpointResp checkPoint(com.elcom.loyalty.LoyaltyReq in0) {
        LOG.info("Executing operation checkPoint");
        System.out.println(in0);
        try {
            com.elcom.loyalty.LoyaltyCheckpointResp _return = new com.elcom.loyalty.LoyaltyCheckpointResp();
            javax.xml.bind.JAXBElement<java.lang.String> _returnErrorCode = null;
            _return.setErrorCode(_returnErrorCode);
            javax.xml.bind.JAXBElement<java.lang.String> _returnErrorDetail = null;
            _return.setErrorDetail(_returnErrorDetail);
            javax.xml.bind.JAXBElement<java.lang.String> _returnIsdn = null;
            _return.setIsdn(_returnIsdn);
            _return.setPoint(Double.valueOf(0.7503586030248324));
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
