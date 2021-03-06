
package com.gnv.vnm.selfcare.core.adapter.vasman.ws;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

/**
 * This class was generated by Apache CXF 3.1.10
 * 2017-07-21T11:49:58.917+07:00
 * Generated source version: 3.1.10
 * 
 */
public final class WSVasnewPortType_WSVasnewHttpPort_Client {

    private static final QName SERVICE_NAME = new QName("http://vasman.elcom.com", "WSVasnew");

    private WSVasnewPortType_WSVasnewHttpPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = WSVasnew.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        WSVasnew ss = new WSVasnew(wsdlURL, SERVICE_NAME);
        WSVasnewPortType port = ss.getWSVasnewHttpPort();  
        
        {
        System.out.println("Invoking dynamicServiceProvisioning...");
        com.gnv.vnm.selfcare.core.adapter.vasman.ws.ProvisioningDynamicServiceReq _dynamicServiceProvisioning_in0 = null;
        com.gnv.vnm.selfcare.core.adapter.vasman.ws.ProvisioningResp _dynamicServiceProvisioning__return = port.dynamicServiceProvisioning(_dynamicServiceProvisioning_in0);
        System.out.println("dynamicServiceProvisioning.result=" + _dynamicServiceProvisioning__return);


        }
        {
        System.out.println("Invoking provisioningWithCampaign...");
        com.gnv.vnm.selfcare.core.adapter.vasman.ws.ProvisioningCampaignReq _provisioningWithCampaign_in0 = null;
        com.gnv.vnm.selfcare.core.adapter.vasman.ws.ProvisioningResp _provisioningWithCampaign__return = port.provisioningWithCampaign(_provisioningWithCampaign_in0);
        System.out.println("provisioningWithCampaign.result=" + _provisioningWithCampaign__return);


        }
        {
        System.out.println("Invoking terminateAllVas...");
        com.gnv.vnm.selfcare.core.adapter.vasman.ws.CheckAllVasStatusReq _terminateAllVas_in0 = null;
        com.gnv.vnm.selfcare.core.adapter.vasman.ws.TerminalAllVasResp _terminateAllVas__return = port.terminateAllVas(_terminateAllVas_in0);
        System.out.println("terminateAllVas.result=" + _terminateAllVas__return);


        }
        {
        System.out.println("Invoking memberManagement...");
        com.gnv.vnm.selfcare.core.adapter.vasman.ws.MemberManagementReq _memberManagement_in0 = null;
        com.gnv.vnm.selfcare.core.adapter.vasman.ws.MemberManagementResp _memberManagement__return = port.memberManagement(_memberManagement_in0);
        System.out.println("memberManagement.result=" + _memberManagement__return);


        }
        {
        System.out.println("Invoking vasDetail...");
        com.gnv.vnm.selfcare.core.adapter.vasman.ws.CheckVasStatusReq _vasDetail_in0 = null;
        com.gnv.vnm.selfcare.core.adapter.vasman.ws.VasDetailResp _vasDetail__return = port.vasDetail(_vasDetail_in0);
        System.out.println("vasDetail.result=" + _vasDetail__return);


        }

        System.exit(0);
    }

}
