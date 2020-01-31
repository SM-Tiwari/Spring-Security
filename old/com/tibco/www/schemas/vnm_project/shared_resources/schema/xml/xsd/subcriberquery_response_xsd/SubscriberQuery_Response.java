
/**
 * SubscriberQuery_Response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:06:07 GMT)
 */

            
                package com.tibco.www.schemas.vnm_project.shared_resources.schema.xml.xsd.subcriberquery_response_xsd;
            

            /**
            *  SubscriberQuery_Response bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class SubscriberQuery_Response
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd",
                "SubscriberQuery_Response",
                "ns9");

            

                        /**
                        * field for ACCOUNT_NUMBER
                        */

                        
                                    protected java.lang.String localACCOUNT_NUMBER ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localACCOUNT_NUMBERTracker = false ;

                           public boolean isACCOUNT_NUMBERSpecified(){
                               return localACCOUNT_NUMBERTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getACCOUNT_NUMBER(){
                               return localACCOUNT_NUMBER;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ACCOUNT_NUMBER
                               */
                               public void setACCOUNT_NUMBER(java.lang.String param){
                            localACCOUNT_NUMBERTracker = param != null;
                                   
                                            this.localACCOUNT_NUMBER=param;
                                       

                               }
                            

                        /**
                        * field for RESTRICTED_DATE
                        */

                        
                                    protected java.lang.String localRESTRICTED_DATE ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRESTRICTED_DATETracker = false ;

                           public boolean isRESTRICTED_DATESpecified(){
                               return localRESTRICTED_DATETracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getRESTRICTED_DATE(){
                               return localRESTRICTED_DATE;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param RESTRICTED_DATE
                               */
                               public void setRESTRICTED_DATE(java.lang.String param){
                            localRESTRICTED_DATETracker = param != null;
                                   
                                            this.localRESTRICTED_DATE=param;
                                       

                               }
                            

                        /**
                        * field for FORFEITED_DATE
                        */

                        
                                    protected java.lang.String localFORFEITED_DATE ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFORFEITED_DATETracker = false ;

                           public boolean isFORFEITED_DATESpecified(){
                               return localFORFEITED_DATETracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getFORFEITED_DATE(){
                               return localFORFEITED_DATE;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FORFEITED_DATE
                               */
                               public void setFORFEITED_DATE(java.lang.String param){
                            localFORFEITED_DATETracker = param != null;
                                   
                                            this.localFORFEITED_DATE=param;
                                       

                               }
                            

                        /**
                        * field for TERMINATED_DATE
                        */

                        
                                    protected java.lang.String localTERMINATED_DATE ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTERMINATED_DATETracker = false ;

                           public boolean isTERMINATED_DATESpecified(){
                               return localTERMINATED_DATETracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getTERMINATED_DATE(){
                               return localTERMINATED_DATE;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TERMINATED_DATE
                               */
                               public void setTERMINATED_DATE(java.lang.String param){
                            localTERMINATED_DATETracker = param != null;
                                   
                                            this.localTERMINATED_DATE=param;
                                       

                               }
                            

                        /**
                        * field for LAST_CALL_AMOUNT
                        */

                        
                                    protected java.lang.String localLAST_CALL_AMOUNT ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localLAST_CALL_AMOUNTTracker = false ;

                           public boolean isLAST_CALL_AMOUNTSpecified(){
                               return localLAST_CALL_AMOUNTTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getLAST_CALL_AMOUNT(){
                               return localLAST_CALL_AMOUNT;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param LAST_CALL_AMOUNT
                               */
                               public void setLAST_CALL_AMOUNT(java.lang.String param){
                            localLAST_CALL_AMOUNTTracker = param != null;
                                   
                                            this.localLAST_CALL_AMOUNT=param;
                                       

                               }
                            

                        /**
                        * field for SOURCE_ID
                        */

                        
                                    protected java.lang.String localSOURCE_ID ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSOURCE_IDTracker = false ;

                           public boolean isSOURCE_IDSpecified(){
                               return localSOURCE_IDTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSOURCE_ID(){
                               return localSOURCE_ID;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SOURCE_ID
                               */
                               public void setSOURCE_ID(java.lang.String param){
                            localSOURCE_IDTracker = param != null;
                                   
                                            this.localSOURCE_ID=param;
                                       

                               }
                            

                        /**
                        * field for NOTIFICATION_ID
                        */

                        
                                    protected java.lang.String localNOTIFICATION_ID ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNOTIFICATION_IDTracker = false ;

                           public boolean isNOTIFICATION_IDSpecified(){
                               return localNOTIFICATION_IDTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getNOTIFICATION_ID(){
                               return localNOTIFICATION_ID;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NOTIFICATION_ID
                               */
                               public void setNOTIFICATION_ID(java.lang.String param){
                            localNOTIFICATION_IDTracker = param != null;
                                   
                                            this.localNOTIFICATION_ID=param;
                                       

                               }
                            

                        /**
                        * field for DATA_BALANCE
                        */

                        
                                    protected java.lang.String localDATA_BALANCE ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDATA_BALANCETracker = false ;

                           public boolean isDATA_BALANCESpecified(){
                               return localDATA_BALANCETracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDATA_BALANCE(){
                               return localDATA_BALANCE;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DATA_BALANCE
                               */
                               public void setDATA_BALANCE(java.lang.String param){
                            localDATA_BALANCETracker = param != null;
                                   
                                            this.localDATA_BALANCE=param;
                                       

                               }
                            

                        /**
                        * field for DATA_NIGHT_BALANCE
                        */

                        
                                    protected java.lang.String localDATA_NIGHT_BALANCE ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDATA_NIGHT_BALANCETracker = false ;

                           public boolean isDATA_NIGHT_BALANCESpecified(){
                               return localDATA_NIGHT_BALANCETracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDATA_NIGHT_BALANCE(){
                               return localDATA_NIGHT_BALANCE;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DATA_NIGHT_BALANCE
                               */
                               public void setDATA_NIGHT_BALANCE(java.lang.String param){
                            localDATA_NIGHT_BALANCETracker = param != null;
                                   
                                            this.localDATA_NIGHT_BALANCE=param;
                                       

                               }
                            

                        /**
                        * field for LIFECYCLE_STATUS
                        */

                        
                                    protected java.lang.String localLIFECYCLE_STATUS ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localLIFECYCLE_STATUSTracker = false ;

                           public boolean isLIFECYCLE_STATUSSpecified(){
                               return localLIFECYCLE_STATUSTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getLIFECYCLE_STATUS(){
                               return localLIFECYCLE_STATUS;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param LIFECYCLE_STATUS
                               */
                               public void setLIFECYCLE_STATUS(java.lang.String param){
                            localLIFECYCLE_STATUSTracker = param != null;
                                   
                                            this.localLIFECYCLE_STATUS=param;
                                       

                               }
                            

                        /**
                        * field for ACCOUNT_STATUS
                        */

                        
                                    protected java.lang.String localACCOUNT_STATUS ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localACCOUNT_STATUSTracker = false ;

                           public boolean isACCOUNT_STATUSSpecified(){
                               return localACCOUNT_STATUSTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getACCOUNT_STATUS(){
                               return localACCOUNT_STATUS;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ACCOUNT_STATUS
                               */
                               public void setACCOUNT_STATUS(java.lang.String param){
                            localACCOUNT_STATUSTracker = param != null;
                                   
                                            this.localACCOUNT_STATUS=param;
                                       

                               }
                            

                        /**
                        * field for MAIN_ACCOUNT_BALANCE
                        */

                        
                                    protected java.lang.String localMAIN_ACCOUNT_BALANCE ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMAIN_ACCOUNT_BALANCETracker = false ;

                           public boolean isMAIN_ACCOUNT_BALANCESpecified(){
                               return localMAIN_ACCOUNT_BALANCETracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getMAIN_ACCOUNT_BALANCE(){
                               return localMAIN_ACCOUNT_BALANCE;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MAIN_ACCOUNT_BALANCE
                               */
                               public void setMAIN_ACCOUNT_BALANCE(java.lang.String param){
                            localMAIN_ACCOUNT_BALANCETracker = param != null;
                                   
                                            this.localMAIN_ACCOUNT_BALANCE=param;
                                       

                               }
                            

                        /**
                        * field for ONNET_BAL
                        */

                        
                                    protected java.lang.String localONNET_BAL ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localONNET_BALTracker = false ;

                           public boolean isONNET_BALSpecified(){
                               return localONNET_BALTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getONNET_BAL(){
                               return localONNET_BAL;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ONNET_BAL
                               */
                               public void setONNET_BAL(java.lang.String param){
                            localONNET_BALTracker = param != null;
                                   
                                            this.localONNET_BAL=param;
                                       

                               }
                            

                        /**
                        * field for OFFNET_BAL
                        */

                        
                                    protected java.lang.String localOFFNET_BAL ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOFFNET_BALTracker = false ;

                           public boolean isOFFNET_BALSpecified(){
                               return localOFFNET_BALTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getOFFNET_BAL(){
                               return localOFFNET_BAL;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param OFFNET_BAL
                               */
                               public void setOFFNET_BAL(java.lang.String param){
                            localOFFNET_BALTracker = param != null;
                                   
                                            this.localOFFNET_BAL=param;
                                       

                               }
                            

                        /**
                        * field for SUBSCRIPTION_NUMBER
                        */

                        
                                    protected java.lang.String localSUBSCRIPTION_NUMBER ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSUBSCRIPTION_NUMBERTracker = false ;

                           public boolean isSUBSCRIPTION_NUMBERSpecified(){
                               return localSUBSCRIPTION_NUMBERTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSUBSCRIPTION_NUMBER(){
                               return localSUBSCRIPTION_NUMBER;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SUBSCRIPTION_NUMBER
                               */
                               public void setSUBSCRIPTION_NUMBER(java.lang.String param){
                            localSUBSCRIPTION_NUMBERTracker = param != null;
                                   
                                            this.localSUBSCRIPTION_NUMBER=param;
                                       

                               }
                            

                        /**
                        * field for CALL_PLAN
                        */

                        
                                    protected java.lang.String localCALL_PLAN ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCALL_PLANTracker = false ;

                           public boolean isCALL_PLANSpecified(){
                               return localCALL_PLANTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getCALL_PLAN(){
                               return localCALL_PLAN;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CALL_PLAN
                               */
                               public void setCALL_PLAN(java.lang.String param){
                            localCALL_PLANTracker = param != null;
                                   
                                            this.localCALL_PLAN=param;
                                       

                               }
                            

                        /**
                        * field for SIM
                        */

                        
                                    protected java.lang.String localSIM ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSIMTracker = false ;

                           public boolean isSIMSpecified(){
                               return localSIMTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSIM(){
                               return localSIM;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SIM
                               */
                               public void setSIM(java.lang.String param){
                            localSIMTracker = param != null;
                                   
                                            this.localSIM=param;
                                       

                               }
                            

                        /**
                        * field for IMSI
                        */

                        
                                    protected java.lang.String localIMSI ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIMSITracker = false ;

                           public boolean isIMSISpecified(){
                               return localIMSITracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getIMSI(){
                               return localIMSI;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IMSI
                               */
                               public void setIMSI(java.lang.String param){
                            localIMSITracker = param != null;
                                   
                                            this.localIMSI=param;
                                       

                               }
                            

                        /**
                        * field for CUSTOMER_STATUS
                        */

                        
                                    protected java.lang.String localCUSTOMER_STATUS ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCUSTOMER_STATUSTracker = false ;

                           public boolean isCUSTOMER_STATUSSpecified(){
                               return localCUSTOMER_STATUSTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getCUSTOMER_STATUS(){
                               return localCUSTOMER_STATUS;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CUSTOMER_STATUS
                               */
                               public void setCUSTOMER_STATUS(java.lang.String param){
                            localCUSTOMER_STATUSTracker = param != null;
                                   
                                            this.localCUSTOMER_STATUS=param;
                                       

                               }
                            

                        /**
                        * field for ACTIVATION_DATE
                        */

                        
                                    protected java.lang.String localACTIVATION_DATE ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localACTIVATION_DATETracker = false ;

                           public boolean isACTIVATION_DATESpecified(){
                               return localACTIVATION_DATETracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getACTIVATION_DATE(){
                               return localACTIVATION_DATE;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ACTIVATION_DATE
                               */
                               public void setACTIVATION_DATE(java.lang.String param){
                            localACTIVATION_DATETracker = param != null;
                                   
                                            this.localACTIVATION_DATE=param;
                                       

                               }
                            

                        /**
                        * field for REGISTRATION_DATE
                        */

                        
                                    protected java.lang.String localREGISTRATION_DATE ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localREGISTRATION_DATETracker = false ;

                           public boolean isREGISTRATION_DATESpecified(){
                               return localREGISTRATION_DATETracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getREGISTRATION_DATE(){
                               return localREGISTRATION_DATE;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param REGISTRATION_DATE
                               */
                               public void setREGISTRATION_DATE(java.lang.String param){
                            localREGISTRATION_DATETracker = param != null;
                                   
                                            this.localREGISTRATION_DATE=param;
                                       

                               }
                            

                        /**
                        * field for PROMOTION_CODE
                        */

                        
                                    protected java.lang.String localPROMOTION_CODE ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPROMOTION_CODETracker = false ;

                           public boolean isPROMOTION_CODESpecified(){
                               return localPROMOTION_CODETracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getPROMOTION_CODE(){
                               return localPROMOTION_CODE;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PROMOTION_CODE
                               */
                               public void setPROMOTION_CODE(java.lang.String param){
                            localPROMOTION_CODETracker = param != null;
                                   
                                            this.localPROMOTION_CODE=param;
                                       

                               }
                            

                        /**
                        * field for PAYMENT_TYPE
                        */

                        
                                    protected java.lang.String localPAYMENT_TYPE ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPAYMENT_TYPETracker = false ;

                           public boolean isPAYMENT_TYPESpecified(){
                               return localPAYMENT_TYPETracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getPAYMENT_TYPE(){
                               return localPAYMENT_TYPE;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PAYMENT_TYPE
                               */
                               public void setPAYMENT_TYPE(java.lang.String param){
                            localPAYMENT_TYPETracker = param != null;
                                   
                                            this.localPAYMENT_TYPE=param;
                                       

                               }
                            

                        /**
                        * field for EBILL_MAIL_ID
                        */

                        
                                    protected java.lang.String localEBILL_MAIL_ID ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localEBILL_MAIL_IDTracker = false ;

                           public boolean isEBILL_MAIL_IDSpecified(){
                               return localEBILL_MAIL_IDTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getEBILL_MAIL_ID(){
                               return localEBILL_MAIL_ID;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param EBILL_MAIL_ID
                               */
                               public void setEBILL_MAIL_ID(java.lang.String param){
                            localEBILL_MAIL_IDTracker = param != null;
                                   
                                            this.localEBILL_MAIL_ID=param;
                                       

                               }
                            

                        /**
                        * field for OUTPUT_1
                        */

                        
                                    protected java.lang.String localOUTPUT_1 ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOUTPUT_1Tracker = false ;

                           public boolean isOUTPUT_1Specified(){
                               return localOUTPUT_1Tracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getOUTPUT_1(){
                               return localOUTPUT_1;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param OUTPUT_1
                               */
                               public void setOUTPUT_1(java.lang.String param){
                            localOUTPUT_1Tracker = param != null;
                                   
                                            this.localOUTPUT_1=param;
                                       

                               }
                            

                        /**
                        * field for OUTPUT_2
                        */

                        
                                    protected java.lang.String localOUTPUT_2 ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOUTPUT_2Tracker = false ;

                           public boolean isOUTPUT_2Specified(){
                               return localOUTPUT_2Tracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getOUTPUT_2(){
                               return localOUTPUT_2;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param OUTPUT_2
                               */
                               public void setOUTPUT_2(java.lang.String param){
                            localOUTPUT_2Tracker = param != null;
                                   
                                            this.localOUTPUT_2=param;
                                       

                               }
                            

                        /**
                        * field for OUTPUT_3
                        */

                        
                                    protected java.lang.String localOUTPUT_3 ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOUTPUT_3Tracker = false ;

                           public boolean isOUTPUT_3Specified(){
                               return localOUTPUT_3Tracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getOUTPUT_3(){
                               return localOUTPUT_3;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param OUTPUT_3
                               */
                               public void setOUTPUT_3(java.lang.String param){
                            localOUTPUT_3Tracker = param != null;
                                   
                                            this.localOUTPUT_3=param;
                                       

                               }
                            

                        /**
                        * field for OUTPUT_4
                        */

                        
                                    protected java.lang.String localOUTPUT_4 ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOUTPUT_4Tracker = false ;

                           public boolean isOUTPUT_4Specified(){
                               return localOUTPUT_4Tracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getOUTPUT_4(){
                               return localOUTPUT_4;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param OUTPUT_4
                               */
                               public void setOUTPUT_4(java.lang.String param){
                            localOUTPUT_4Tracker = param != null;
                                   
                                            this.localOUTPUT_4=param;
                                       

                               }
                            

                        /**
                        * field for Status_Code
                        */

                        
                                    protected java.lang.String localStatus_Code ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getStatus_Code(){
                               return localStatus_Code;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Status_Code
                               */
                               public void setStatus_Code(java.lang.String param){
                            
                                            this.localStatus_Code=param;
                                       

                               }
                            

                        /**
                        * field for Status_Text
                        */

                        
                                    protected java.lang.String localStatus_Text ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getStatus_Text(){
                               return localStatus_Text;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Status_Text
                               */
                               public void setStatus_Text(java.lang.String param){
                            
                                            this.localStatus_Text=param;
                                       

                               }
                            

                        /**
                        * field for MsgParam
                        */

                        
                                    protected com.tibco.www.schemas.vnm_project.shared_resources.schema.xml.xsd.subcriberquery_response_xsd.MsgParam_type0 localMsgParam ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMsgParamTracker = false ;

                           public boolean isMsgParamSpecified(){
                               return localMsgParamTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.tibco.www.schemas.vnm_project.shared_resources.schema.xml.xsd.subcriberquery_response_xsd.MsgParam_type0
                           */
                           public  com.tibco.www.schemas.vnm_project.shared_resources.schema.xml.xsd.subcriberquery_response_xsd.MsgParam_type0 getMsgParam(){
                               return localMsgParam;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MsgParam
                               */
                               public void setMsgParam(com.tibco.www.schemas.vnm_project.shared_resources.schema.xml.xsd.subcriberquery_response_xsd.MsgParam_type0 param){
                            localMsgParamTracker = param != null;
                                   
                                            this.localMsgParam=param;
                                       

                               }
                            

     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
               return factory.createOMElement(new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME));
            
        }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       javax.xml.stream.XMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                


                java.lang.String prefix = null;
                java.lang.String namespace = null;
                

                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();
                    writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);
                
                  if (serializeType){
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":SubscriberQuery_Response",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "SubscriberQuery_Response",
                           xmlWriter);
                   }

               
                   }
                if (localACCOUNT_NUMBERTracker){
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd";
                                    writeStartElement(null, namespace, "ACCOUNT_NUMBER", xmlWriter);
                             

                                          if (localACCOUNT_NUMBER==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("ACCOUNT_NUMBER cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localACCOUNT_NUMBER);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localRESTRICTED_DATETracker){
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd";
                                    writeStartElement(null, namespace, "RESTRICTED_DATE", xmlWriter);
                             

                                          if (localRESTRICTED_DATE==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("RESTRICTED_DATE cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localRESTRICTED_DATE);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localFORFEITED_DATETracker){
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd";
                                    writeStartElement(null, namespace, "FORFEITED_DATE", xmlWriter);
                             

                                          if (localFORFEITED_DATE==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("FORFEITED_DATE cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localFORFEITED_DATE);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localTERMINATED_DATETracker){
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd";
                                    writeStartElement(null, namespace, "TERMINATED_DATE", xmlWriter);
                             

                                          if (localTERMINATED_DATE==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("TERMINATED_DATE cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localTERMINATED_DATE);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localLAST_CALL_AMOUNTTracker){
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd";
                                    writeStartElement(null, namespace, "LAST_CALL_AMOUNT", xmlWriter);
                             

                                          if (localLAST_CALL_AMOUNT==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("LAST_CALL_AMOUNT cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localLAST_CALL_AMOUNT);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localSOURCE_IDTracker){
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd";
                                    writeStartElement(null, namespace, "SOURCE_ID", xmlWriter);
                             

                                          if (localSOURCE_ID==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("SOURCE_ID cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSOURCE_ID);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localNOTIFICATION_IDTracker){
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd";
                                    writeStartElement(null, namespace, "NOTIFICATION_ID", xmlWriter);
                             

                                          if (localNOTIFICATION_ID==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("NOTIFICATION_ID cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localNOTIFICATION_ID);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDATA_BALANCETracker){
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd";
                                    writeStartElement(null, namespace, "DATA_BALANCE", xmlWriter);
                             

                                          if (localDATA_BALANCE==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("DATA_BALANCE cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDATA_BALANCE);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDATA_NIGHT_BALANCETracker){
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd";
                                    writeStartElement(null, namespace, "DATA_NIGHT_BALANCE", xmlWriter);
                             

                                          if (localDATA_NIGHT_BALANCE==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("DATA_NIGHT_BALANCE cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDATA_NIGHT_BALANCE);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localLIFECYCLE_STATUSTracker){
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd";
                                    writeStartElement(null, namespace, "LIFECYCLE_STATUS", xmlWriter);
                             

                                          if (localLIFECYCLE_STATUS==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("LIFECYCLE_STATUS cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localLIFECYCLE_STATUS);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localACCOUNT_STATUSTracker){
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd";
                                    writeStartElement(null, namespace, "ACCOUNT_STATUS", xmlWriter);
                             

                                          if (localACCOUNT_STATUS==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("ACCOUNT_STATUS cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localACCOUNT_STATUS);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localMAIN_ACCOUNT_BALANCETracker){
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd";
                                    writeStartElement(null, namespace, "MAIN_ACCOUNT_BALANCE", xmlWriter);
                             

                                          if (localMAIN_ACCOUNT_BALANCE==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("MAIN_ACCOUNT_BALANCE cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localMAIN_ACCOUNT_BALANCE);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localONNET_BALTracker){
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd";
                                    writeStartElement(null, namespace, "ONNET_BAL", xmlWriter);
                             

                                          if (localONNET_BAL==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("ONNET_BAL cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localONNET_BAL);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localOFFNET_BALTracker){
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd";
                                    writeStartElement(null, namespace, "OFFNET_BAL", xmlWriter);
                             

                                          if (localOFFNET_BAL==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("OFFNET_BAL cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localOFFNET_BAL);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localSUBSCRIPTION_NUMBERTracker){
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd";
                                    writeStartElement(null, namespace, "SUBSCRIPTION_NUMBER", xmlWriter);
                             

                                          if (localSUBSCRIPTION_NUMBER==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("SUBSCRIPTION_NUMBER cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSUBSCRIPTION_NUMBER);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localCALL_PLANTracker){
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd";
                                    writeStartElement(null, namespace, "CALL_PLAN", xmlWriter);
                             

                                          if (localCALL_PLAN==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("CALL_PLAN cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localCALL_PLAN);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localSIMTracker){
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd";
                                    writeStartElement(null, namespace, "SIM", xmlWriter);
                             

                                          if (localSIM==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("SIM cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSIM);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localIMSITracker){
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd";
                                    writeStartElement(null, namespace, "IMSI", xmlWriter);
                             

                                          if (localIMSI==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("IMSI cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localIMSI);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localCUSTOMER_STATUSTracker){
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd";
                                    writeStartElement(null, namespace, "CUSTOMER_STATUS", xmlWriter);
                             

                                          if (localCUSTOMER_STATUS==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("CUSTOMER_STATUS cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localCUSTOMER_STATUS);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localACTIVATION_DATETracker){
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd";
                                    writeStartElement(null, namespace, "ACTIVATION_DATE", xmlWriter);
                             

                                          if (localACTIVATION_DATE==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("ACTIVATION_DATE cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localACTIVATION_DATE);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localREGISTRATION_DATETracker){
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd";
                                    writeStartElement(null, namespace, "REGISTRATION_DATE", xmlWriter);
                             

                                          if (localREGISTRATION_DATE==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("REGISTRATION_DATE cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localREGISTRATION_DATE);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPROMOTION_CODETracker){
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd";
                                    writeStartElement(null, namespace, "PROMOTION_CODE", xmlWriter);
                             

                                          if (localPROMOTION_CODE==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("PROMOTION_CODE cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localPROMOTION_CODE);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPAYMENT_TYPETracker){
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd";
                                    writeStartElement(null, namespace, "PAYMENT_TYPE", xmlWriter);
                             

                                          if (localPAYMENT_TYPE==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("PAYMENT_TYPE cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localPAYMENT_TYPE);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localEBILL_MAIL_IDTracker){
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd";
                                    writeStartElement(null, namespace, "EBILL_MAIL_ID", xmlWriter);
                             

                                          if (localEBILL_MAIL_ID==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("EBILL_MAIL_ID cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localEBILL_MAIL_ID);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localOUTPUT_1Tracker){
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd";
                                    writeStartElement(null, namespace, "OUTPUT_1", xmlWriter);
                             

                                          if (localOUTPUT_1==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("OUTPUT_1 cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localOUTPUT_1);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localOUTPUT_2Tracker){
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd";
                                    writeStartElement(null, namespace, "OUTPUT_2", xmlWriter);
                             

                                          if (localOUTPUT_2==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("OUTPUT_2 cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localOUTPUT_2);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localOUTPUT_3Tracker){
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd";
                                    writeStartElement(null, namespace, "OUTPUT_3", xmlWriter);
                             

                                          if (localOUTPUT_3==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("OUTPUT_3 cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localOUTPUT_3);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localOUTPUT_4Tracker){
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd";
                                    writeStartElement(null, namespace, "OUTPUT_4", xmlWriter);
                             

                                          if (localOUTPUT_4==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("OUTPUT_4 cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localOUTPUT_4);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             }
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd";
                                    writeStartElement(null, namespace, "Status_Code", xmlWriter);
                             

                                          if (localStatus_Code==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("Status_Code cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localStatus_Code);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd";
                                    writeStartElement(null, namespace, "Status_Text", xmlWriter);
                             

                                          if (localStatus_Text==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("Status_Text cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localStatus_Text);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                              if (localMsgParamTracker){
                                            if (localMsgParam==null){
                                                 throw new org.apache.axis2.databinding.ADBException("MsgParam cannot be null!!");
                                            }
                                           localMsgParam.serialize(new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd","MsgParam"),
                                               xmlWriter);
                                        }
                    xmlWriter.writeEndElement();
               

        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd")){
                return "ns9";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }
        
        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                    java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeAttribute(writerPrefix, namespace,attName,attValue);
            } else {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
                xmlWriter.writeAttribute(prefix, namespace,attName,attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                    java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName,attValue);
            } else {
                xmlWriter.writeAttribute(registerPrefix(xmlWriter, namespace), namespace,attName,attValue);
            }
        }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(attributePrefix, namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }


  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{
        private static org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(Factory.class);

        
        

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static SubscriberQuery_Response parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            SubscriberQuery_Response object =
                new SubscriberQuery_Response();

            int event;
            javax.xml.namespace.QName currentQName = null;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                currentQName = reader.getName();
                
                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);
                    
                            if (!"SubscriberQuery_Response".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (SubscriberQuery_Response)com.tibco.www.schemas.vnm_project_uat.shared_resources.schema.xml.xsd.crbt.giftsong_xsd.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd","ACCOUNT_NUMBER").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"ACCOUNT_NUMBER" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setACCOUNT_NUMBER(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd","RESTRICTED_DATE").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"RESTRICTED_DATE" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setRESTRICTED_DATE(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd","FORFEITED_DATE").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"FORFEITED_DATE" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setFORFEITED_DATE(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd","TERMINATED_DATE").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"TERMINATED_DATE" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setTERMINATED_DATE(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd","LAST_CALL_AMOUNT").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"LAST_CALL_AMOUNT" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setLAST_CALL_AMOUNT(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd","SOURCE_ID").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"SOURCE_ID" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSOURCE_ID(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd","NOTIFICATION_ID").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"NOTIFICATION_ID" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setNOTIFICATION_ID(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd","DATA_BALANCE").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"DATA_BALANCE" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDATA_BALANCE(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd","DATA_NIGHT_BALANCE").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"DATA_NIGHT_BALANCE" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDATA_NIGHT_BALANCE(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd","LIFECYCLE_STATUS").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"LIFECYCLE_STATUS" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setLIFECYCLE_STATUS(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd","ACCOUNT_STATUS").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"ACCOUNT_STATUS" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setACCOUNT_STATUS(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd","MAIN_ACCOUNT_BALANCE").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"MAIN_ACCOUNT_BALANCE" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMAIN_ACCOUNT_BALANCE(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd","ONNET_BAL").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"ONNET_BAL" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setONNET_BAL(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd","OFFNET_BAL").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"OFFNET_BAL" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setOFFNET_BAL(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd","SUBSCRIPTION_NUMBER").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"SUBSCRIPTION_NUMBER" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSUBSCRIPTION_NUMBER(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd","CALL_PLAN").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"CALL_PLAN" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCALL_PLAN(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd","SIM").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"SIM" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSIM(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd","IMSI").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"IMSI" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIMSI(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd","CUSTOMER_STATUS").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"CUSTOMER_STATUS" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCUSTOMER_STATUS(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd","ACTIVATION_DATE").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"ACTIVATION_DATE" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setACTIVATION_DATE(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd","REGISTRATION_DATE").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"REGISTRATION_DATE" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setREGISTRATION_DATE(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd","PROMOTION_CODE").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"PROMOTION_CODE" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPROMOTION_CODE(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd","PAYMENT_TYPE").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"PAYMENT_TYPE" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPAYMENT_TYPE(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd","EBILL_MAIL_ID").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"EBILL_MAIL_ID" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setEBILL_MAIL_ID(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd","OUTPUT_1").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"OUTPUT_1" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setOUTPUT_1(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd","OUTPUT_2").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"OUTPUT_2" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setOUTPUT_2(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd","OUTPUT_3").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"OUTPUT_3" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setOUTPUT_3(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd","OUTPUT_4").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"OUTPUT_4" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setOUTPUT_4(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd","Status_Code").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"Status_Code" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setStatus_Code(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // 1 - A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd","Status_Text").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"Status_Text" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setStatus_Text(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // 1 - A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/xsd/SubcriberQuery_Response.xsd","MsgParam").equals(reader.getName())){
                                
                                                object.setMsgParam(com.tibco.www.schemas.vnm_project.shared_resources.schema.xml.xsd.subcriberquery_response_xsd.MsgParam_type0.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                  
                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();
                            
                                if (reader.isStartElement())
                                // 2 - A start element we are not expecting indicates a trailing invalid property
                                
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
    