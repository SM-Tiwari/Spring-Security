

/**
 * Selfcare_Inbound.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */

    package com.tibco;

    /*
     *  Selfcare_Inbound java interface
     */

    public interface Selfcare_Inbound {
          

        /**
          * Auto generated method signature
          * 
                    * @param billedQuery_Request2
                
         */

         
                     public com.tibco.www.schemas.vnm_project.shared_resources.schema.xml.xsd.selfcare.schema_xsd26.BilledQuery_Response postPaidBilledQuery(

                        com.tibco.www.schemas.vnm_project.shared_resources.schema.xml.xsd.selfcare.schema_xsd25.BilledQuery_Request billedQuery_Request2)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param billedQuery_Request2
            
          */
        public void startpostPaidBilledQuery(

            com.tibco.www.schemas.vnm_project.shared_resources.schema.xml.xsd.selfcare.schema_xsd25.BilledQuery_Request billedQuery_Request2,

            final com.tibco.Selfcare_InboundCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param subscriberQuery_Request4
                
         */

         
                     public com.tibco.www.schemas.vnm_project.shared_resources.schema.xml.xsd.subcriberquery_response_xsd.SubscriberQuery_Response subscriberQuery(

                        com.tibco.www.schemas.vnm_project.shared_resources.schema.xml.xsd.subscriberquery_xsd.SubscriberQuery_Request subscriberQuery_Request4)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param subscriberQuery_Request4
            
          */
        public void startsubscriberQuery(

            com.tibco.www.schemas.vnm_project.shared_resources.schema.xml.xsd.subscriberquery_xsd.SubscriberQuery_Request subscriberQuery_Request4,

            final com.tibco.Selfcare_InboundCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param postpaid_Payment_Request6
                
         */

         
                     public com.tibco.www.schemas.vnm_project.shared_resources.schema.xml.xsd.epos.schema_xsd16.Postpaid_Payment_Response postpaidBillPayment(

                        com.tibco.www.schemas.vnm_project.shared_resources.schema.xml.xsd.epos.postpaidpayment_request_xsd16.Postpaid_Payment_Request postpaid_Payment_Request6)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param postpaid_Payment_Request6
            
          */
        public void startpostpaidBillPayment(

            com.tibco.www.schemas.vnm_project.shared_resources.schema.xml.xsd.epos.postpaidpayment_request_xsd16.Postpaid_Payment_Request postpaid_Payment_Request6,

            final com.tibco.Selfcare_InboundCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param balanceQuery_Request8
                
         */

         
                     public com.tibco.www.schemas.vnm_project_uat.shared_resources.schema.xml.xsd.selfcare.schema_xsd2.BalanceQuery_Response postpaidBalanceEnquiry(

                        com.tibco.www.schemas.vnm_project_uat.shared_resources.schema.xml.xsd.selfcare.schema_xsd.BalanceQuery_Request balanceQuery_Request8)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param balanceQuery_Request8
            
          */
        public void startpostpaidBalanceEnquiry(

            com.tibco.www.schemas.vnm_project_uat.shared_resources.schema.xml.xsd.selfcare.schema_xsd.BalanceQuery_Request balanceQuery_Request8,

            final com.tibco.Selfcare_InboundCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param voucherTopUp10
                
         */

         
                     public com.tibco.www.schemas.vnm_project.shared_resources.schema.xml.selfcare.schema_xsd4.VoucherTopUp voucherTopUp(

                        com.tibco.www.schemas.vnm_project.shared_resources.schema.xml.selfcare.schema_xsd4.VoucherTopUp voucherTopUp10)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param voucherTopUp10
            
          */
        public void startvoucherTopUp(

            com.tibco.www.schemas.vnm_project.shared_resources.schema.xml.selfcare.schema_xsd4.VoucherTopUp voucherTopUp10,

            final com.tibco.Selfcare_InboundCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param activateOffer_Request12
                
         */

         
                     public com.tibco.www.schemas.vnm_project_uat.shared_resources.schema.xml.selfcare.activateoffer_xsd.ActivateOffer_Response activateOffer_CMS(

                        com.tibco.www.schemas.vnm_project_uat.shared_resources.schema.xml.selfcare.activateoffer_xsd.ActivateOffer_Request activateOffer_Request12)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param activateOffer_Request12
            
          */
        public void startactivateOffer_CMS(

            com.tibco.www.schemas.vnm_project_uat.shared_resources.schema.xml.selfcare.activateoffer_xsd.ActivateOffer_Request activateOffer_Request12,

            final com.tibco.Selfcare_InboundCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param giftSong_Request14
                
         */

         
                     public com.tibco.www.schemas.vnm_project_uat.shared_resources.schema.xml.xsd.crbt.giftsong_xsd.GiftSong_Response cRBT_GiftSong(

                        com.tibco.www.schemas.vnm_project_uat.shared_resources.schema.xml.xsd.crbt.giftsong_xsd.GiftSong_Request giftSong_Request14)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param giftSong_Request14
            
          */
        public void startcRBT_GiftSong(

            com.tibco.www.schemas.vnm_project_uat.shared_resources.schema.xml.xsd.crbt.giftsong_xsd.GiftSong_Request giftSong_Request14,

            final com.tibco.Selfcare_InboundCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param ebill_Reg_Request16
                
         */

         
                     public com.tibco.www.schemas.vnm_project_uat.shared_resources.schema.xml.xsd.selfcare.schema_xsd4.Ebill_Registration_Response ebillRegistration(

                        com.tibco.www.schemas.vnm_project_uat.shared_resources.schema.xml.xsd.selfcare.schema_xsd3.Ebill_Reg_Request ebill_Reg_Request16)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param ebill_Reg_Request16
            
          */
        public void startebillRegistration(

            com.tibco.www.schemas.vnm_project_uat.shared_resources.schema.xml.xsd.selfcare.schema_xsd3.Ebill_Reg_Request ebill_Reg_Request16,

            final com.tibco.Selfcare_InboundCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param hotBilling_Request18
                
         */

         
                     public com.tibco.www.schemas._28_nov_sit.shared_resources.schema.xml.selfcare.schema_xsd.HotBilling_Response hotBilling(

                        com.tibco.www.schemas._28_nov_sit.shared_resources.schema.xml.selfcare.schema_xsd.HotBilling_Request hotBilling_Request18)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param hotBilling_Request18
            
          */
        public void starthotBilling(

            com.tibco.www.schemas._28_nov_sit.shared_resources.schema.xml.selfcare.schema_xsd.HotBilling_Request hotBilling_Request18,

            final com.tibco.Selfcare_InboundCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param viewCreditLimit_Request20
                
         */

         
                     public com.tibco.www.schemas._24_nov_sit.shared_resources.schema.xml.selfcare.schema_xsd.ViewCreditLimit_Response viewCreditLimit(

                        com.tibco.www.schemas._24_nov_sit.shared_resources.schema.xml.selfcare.schema_xsd.ViewCreditLimit_Request viewCreditLimit_Request20)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param viewCreditLimit_Request20
            
          */
        public void startviewCreditLimit(

            com.tibco.www.schemas._24_nov_sit.shared_resources.schema.xml.selfcare.schema_xsd.ViewCreditLimit_Request viewCreditLimit_Request20,

            final com.tibco.Selfcare_InboundCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param nonVasRegRequest22
                
         */

         
                     public com.tibco.www.schemas.vnm_project.shared_resources.abstract_wsdl.selfcare.schema_xsd.NonVasRegResponse vas_Registration(

                        com.tibco.www.schemas.vnm_project.shared_resources.abstract_wsdl.selfcare.schema_xsd.NonVasRegRequest nonVasRegRequest22)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param nonVasRegRequest22
            
          */
        public void startvas_Registration(

            com.tibco.www.schemas.vnm_project.shared_resources.abstract_wsdl.selfcare.schema_xsd.NonVasRegRequest nonVasRegRequest22,

            final com.tibco.Selfcare_InboundCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getStatus_Request24
                
         */

         
                     public com.tibco.www.schemas.vnm_project_uat.shared_resources.schema.xml.xsd.crbt.schema_xsd.GetStatus_Response cRBT_GetStatus(

                        com.tibco.www.schemas.vnm_project_uat.shared_resources.schema.xml.xsd.crbt.schema_xsd.GetStatus_Request getStatus_Request24)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getStatus_Request24
            
          */
        public void startcRBT_GetStatus(

            com.tibco.www.schemas.vnm_project_uat.shared_resources.schema.xml.xsd.crbt.schema_xsd.GetStatus_Request getStatus_Request24,

            final com.tibco.Selfcare_InboundCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param voucherHistory26
                
         */

         
                     public com.tibco.www.schemas.vnm_project.shared_resources.schema.xml.selfcare.schema_xsd3.VoucherHistory topupHistory(

                        com.tibco.www.schemas.vnm_project.shared_resources.schema.xml.selfcare.schema_xsd3.VoucherHistory voucherHistory26)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param voucherHistory26
            
          */
        public void starttopupHistory(

            com.tibco.www.schemas.vnm_project.shared_resources.schema.xml.selfcare.schema_xsd3.VoucherHistory voucherHistory26,

            final com.tibco.Selfcare_InboundCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param paymentHistory_Request28
                
         */

         
                     public com.tibco.www.schemas.vnm_project.shared_resources.schema.xml.xsd.epos.schema_xsd22.PaymentHistory_Response postpaidPaymentHistory(

                        com.tibco.www.schemas.vnm_project.shared_resources.schema.xml.xsd.epos.schema_xsd21.PaymentHistory_Request paymentHistory_Request28)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param paymentHistory_Request28
            
          */
        public void startpostpaidPaymentHistory(

            com.tibco.www.schemas.vnm_project.shared_resources.schema.xml.xsd.epos.schema_xsd21.PaymentHistory_Request paymentHistory_Request28,

            final com.tibco.Selfcare_InboundCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param usageDetailsQueryReq30
                
         */

         
                     public com.tibco.www.schemas.hcpt_project_01042014.shared_resources.schema.xml.eai.schema_xsd6.UsageDetailsQueryRes usageHistory(

                        com.tibco.www.schemas.hcpt_project_01042014.shared_resources.schema.xml.eai.schema_xsd6.UsageDetailsQueryReq usageDetailsQueryReq30)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param usageDetailsQueryReq30
            
          */
        public void startusageHistory(

            com.tibco.www.schemas.hcpt_project_01042014.shared_resources.schema.xml.eai.schema_xsd6.UsageDetailsQueryReq usageDetailsQueryReq30,

            final com.tibco.Selfcare_InboundCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param purchaseSong_Request32
                
         */

         
                     public com.tibco.www.schemas.vnm_project_uat.shared_resources.schema.xml.xsd.crbt.purchasesong_xsd.PurchaseSong_Response cRBT_PurchaseSong(

                        com.tibco.www.schemas.vnm_project_uat.shared_resources.schema.xml.xsd.crbt.purchasesong_xsd.PurchaseSong_Request purchaseSong_Request32)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param purchaseSong_Request32
            
          */
        public void startcRBT_PurchaseSong(

            com.tibco.www.schemas.vnm_project_uat.shared_resources.schema.xml.xsd.crbt.purchasesong_xsd.PurchaseSong_Request purchaseSong_Request32,

            final com.tibco.Selfcare_InboundCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getVasDetails_Request34
                
         */

         
                     public com.tibco.www.schemas.vnm_project_uat.shared_resources.schema.xml.selfcare.schema_xsd.GetVasDetails_Response getVasDetails(

                        com.tibco.www.schemas.vnm_project_uat.shared_resources.schema.xml.selfcare.schema_xsd.GetVasDetails_Request getVasDetails_Request34)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getVasDetails_Request34
            
          */
        public void startgetVasDetails(

            com.tibco.www.schemas.vnm_project_uat.shared_resources.schema.xml.selfcare.schema_xsd.GetVasDetails_Request getVasDetails_Request34,

            final com.tibco.Selfcare_InboundCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param etopUp_Request36
                
         */

         
                     public com.tibco.www.schemas.vnm_project.shared_resources.schema.xml.xsd.epos.schema_xsd13.EtopUp_Response etopup_Selfcare(

                        com.tibco.www.schemas.vnm_project.shared_resources.schema.xml.xsd.epos.schema_xsd12.EtopUp_Request etopUp_Request36)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param etopUp_Request36
            
          */
        public void startetopup_Selfcare(

            com.tibco.www.schemas.vnm_project.shared_resources.schema.xml.xsd.epos.schema_xsd12.EtopUp_Request etopUp_Request36,

            final com.tibco.Selfcare_InboundCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getOffer_Request38
                
         */

         
                     public com.tibco.www.schemas.vnm_project_uat.shared_resources.schema.xml.selfcare.getoffer_xsd.GetOffer_Response getOffer_CMS(

                        com.tibco.www.schemas.vnm_project_uat.shared_resources.schema.xml.selfcare.getoffer_xsd.GetOffer_Request getOffer_Request38)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getOffer_Request38
            
          */
        public void startgetOffer_CMS(

            com.tibco.www.schemas.vnm_project_uat.shared_resources.schema.xml.selfcare.getoffer_xsd.GetOffer_Request getOffer_Request38,

            final com.tibco.Selfcare_InboundCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    