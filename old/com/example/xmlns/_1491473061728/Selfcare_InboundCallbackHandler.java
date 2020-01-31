
/**
 * Selfcare_InboundCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */

    package com.example.xmlns._1491473061728;

    /**
     *  Selfcare_InboundCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class Selfcare_InboundCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public Selfcare_InboundCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public Selfcare_InboundCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for postPaidBilledQuery method
            * override this method for handling normal response from postPaidBilledQuery operation
            */
           public void receiveResultpostPaidBilledQuery(
                    com.tibco.www.schemas.vnm_project.shared_resources.schema.xml.xsd.selfcare.schema_xsd26.BilledQuery_Response result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from postPaidBilledQuery operation
           */
            public void receiveErrorpostPaidBilledQuery(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for subscriberQuery method
            * override this method for handling normal response from subscriberQuery operation
            */
           public void receiveResultsubscriberQuery(
                    com.tibco.www.schemas.vnm_project.shared_resources.schema.xml.xsd.subcriberquery_response_xsd.SubscriberQuery_Response result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from subscriberQuery operation
           */
            public void receiveErrorsubscriberQuery(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for postpaidBillPayment method
            * override this method for handling normal response from postpaidBillPayment operation
            */
           public void receiveResultpostpaidBillPayment(
                    com.tibco.www.schemas.vnm_project.shared_resources.schema.xml.xsd.epos.schema_xsd16.Postpaid_Payment_Response result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from postpaidBillPayment operation
           */
            public void receiveErrorpostpaidBillPayment(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for postpaidBalanceEnquiry method
            * override this method for handling normal response from postpaidBalanceEnquiry operation
            */
           public void receiveResultpostpaidBalanceEnquiry(
                    com.tibco.www.schemas.vnm_project_uat.shared_resources.schema.xml.xsd.selfcare.schema_xsd2.BalanceQuery_Response result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from postpaidBalanceEnquiry operation
           */
            public void receiveErrorpostpaidBalanceEnquiry(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for voucherTopUp method
            * override this method for handling normal response from voucherTopUp operation
            */
           public void receiveResultvoucherTopUp(
                    com.tibco.www.schemas.vnm_project.shared_resources.schema.xml.selfcare.schema_xsd4.VoucherTopUp result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from voucherTopUp operation
           */
            public void receiveErrorvoucherTopUp(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for activateOffer_CMS method
            * override this method for handling normal response from activateOffer_CMS operation
            */
           public void receiveResultactivateOffer_CMS(
                    com.tibco.www.schemas.vnm_project_uat.shared_resources.schema.xml.selfcare.activateoffer_xsd.ActivateOffer_Response result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from activateOffer_CMS operation
           */
            public void receiveErroractivateOffer_CMS(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for cRBT_GiftSong method
            * override this method for handling normal response from cRBT_GiftSong operation
            */
           public void receiveResultcRBT_GiftSong(
                    com.tibco.www.schemas.vnm_project_uat.shared_resources.schema.xml.xsd.crbt.giftsong_xsd.GiftSong_Response result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from cRBT_GiftSong operation
           */
            public void receiveErrorcRBT_GiftSong(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for ebillRegistration method
            * override this method for handling normal response from ebillRegistration operation
            */
           public void receiveResultebillRegistration(
                    com.tibco.www.schemas.vnm_project_uat.shared_resources.schema.xml.xsd.selfcare.schema_xsd4.Ebill_Registration_Response result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from ebillRegistration operation
           */
            public void receiveErrorebillRegistration(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for hotBilling method
            * override this method for handling normal response from hotBilling operation
            */
           public void receiveResulthotBilling(
                    com.tibco.www.schemas._28_nov_sit.shared_resources.schema.xml.selfcare.schema_xsd.HotBilling_Response result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from hotBilling operation
           */
            public void receiveErrorhotBilling(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for viewCreditLimit method
            * override this method for handling normal response from viewCreditLimit operation
            */
           public void receiveResultviewCreditLimit(
                    com.tibco.www.schemas._24_nov_sit.shared_resources.schema.xml.selfcare.schema_xsd.ViewCreditLimit_Response result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from viewCreditLimit operation
           */
            public void receiveErrorviewCreditLimit(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for vas_Registration method
            * override this method for handling normal response from vas_Registration operation
            */
           public void receiveResultvas_Registration(
                    com.tibco.www.schemas.vnm_project.shared_resources.abstract_wsdl.selfcare.schema_xsd.NonVasRegResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from vas_Registration operation
           */
            public void receiveErrorvas_Registration(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for cRBT_GetStatus method
            * override this method for handling normal response from cRBT_GetStatus operation
            */
           public void receiveResultcRBT_GetStatus(
                    com.tibco.www.schemas.vnm_project_uat.shared_resources.schema.xml.xsd.crbt.schema_xsd.GetStatus_Response result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from cRBT_GetStatus operation
           */
            public void receiveErrorcRBT_GetStatus(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for topupHistory method
            * override this method for handling normal response from topupHistory operation
            */
           public void receiveResulttopupHistory(
                    com.tibco.www.schemas.vnm_project.shared_resources.schema.xml.selfcare.schema_xsd3.VoucherHistory result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from topupHistory operation
           */
            public void receiveErrortopupHistory(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for postpaidPaymentHistory method
            * override this method for handling normal response from postpaidPaymentHistory operation
            */
           public void receiveResultpostpaidPaymentHistory(
                    com.tibco.www.schemas.vnm_project.shared_resources.schema.xml.xsd.epos.schema_xsd22.PaymentHistory_Response result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from postpaidPaymentHistory operation
           */
            public void receiveErrorpostpaidPaymentHistory(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for usageHistory method
            * override this method for handling normal response from usageHistory operation
            */
           public void receiveResultusageHistory(
                    com.tibco.www.schemas.hcpt_project_01042014.shared_resources.schema.xml.eai.schema_xsd6.UsageDetailsQueryRes result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from usageHistory operation
           */
            public void receiveErrorusageHistory(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for cRBT_PurchaseSong method
            * override this method for handling normal response from cRBT_PurchaseSong operation
            */
           public void receiveResultcRBT_PurchaseSong(
                    com.tibco.www.schemas.vnm_project_uat.shared_resources.schema.xml.xsd.crbt.purchasesong_xsd.PurchaseSong_Response result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from cRBT_PurchaseSong operation
           */
            public void receiveErrorcRBT_PurchaseSong(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getVasDetails method
            * override this method for handling normal response from getVasDetails operation
            */
           public void receiveResultgetVasDetails(
                    com.tibco.www.schemas.vnm_project_uat.shared_resources.schema.xml.selfcare.schema_xsd.GetVasDetails_Response result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getVasDetails operation
           */
            public void receiveErrorgetVasDetails(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for etopup_Selfcare method
            * override this method for handling normal response from etopup_Selfcare operation
            */
           public void receiveResultetopup_Selfcare(
                    com.tibco.www.schemas.vnm_project.shared_resources.schema.xml.xsd.epos.schema_xsd13.EtopUp_Response result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from etopup_Selfcare operation
           */
            public void receiveErroretopup_Selfcare(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getOffer_CMS method
            * override this method for handling normal response from getOffer_CMS operation
            */
           public void receiveResultgetOffer_CMS(
                    com.tibco.www.schemas.vnm_project_uat.shared_resources.schema.xml.selfcare.getoffer_xsd.GetOffer_Response result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getOffer_CMS operation
           */
            public void receiveErrorgetOffer_CMS(java.lang.Exception e) {
            }
                


    }
    