
/**
 * VoucherTopUp.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:06:07 GMT)
 */

            
                package com.tibco.www.schemas.vnm_project.shared_resources.schema.xml.selfcare.schema_xsd4;
            

            /**
            *  VoucherTopUp bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class VoucherTopUp
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4",
                "VoucherTopUp",
                "ns4");

            

                        /**
                        * field for TransactionID
                        */

                        
                                    protected java.lang.String localTransactionID ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getTransactionID(){
                               return localTransactionID;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TransactionID
                               */
                               public void setTransactionID(java.lang.String param){
                            
                                            this.localTransactionID=param;
                                       

                               }
                            

                        /**
                        * field for MessageType
                        */

                        
                                    protected java.lang.String localMessageType ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getMessageType(){
                               return localMessageType;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MessageType
                               */
                               public void setMessageType(java.lang.String param){
                            
                                            this.localMessageType=param;
                                       

                               }
                            

                        /**
                        * field for ProcCode
                        */

                        
                                    protected java.lang.String localProcCode ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getProcCode(){
                               return localProcCode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ProcCode
                               */
                               public void setProcCode(java.lang.String param){
                            
                                            this.localProcCode=param;
                                       

                               }
                            

                        /**
                        * field for STAN
                        */

                        
                                    protected java.lang.String localSTAN ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSTAN(){
                               return localSTAN;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param STAN
                               */
                               public void setSTAN(java.lang.String param){
                            
                                            this.localSTAN=param;
                                       

                               }
                            

                        /**
                        * field for LocalTxnDtTime
                        */

                        
                                    protected java.lang.String localLocalTxnDtTime ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getLocalTxnDtTime(){
                               return localLocalTxnDtTime;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param LocalTxnDtTime
                               */
                               public void setLocalTxnDtTime(java.lang.String param){
                            
                                            this.localLocalTxnDtTime=param;
                                       

                               }
                            

                        /**
                        * field for MobNum
                        */

                        
                                    protected java.lang.String localMobNum ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getMobNum(){
                               return localMobNum;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MobNum
                               */
                               public void setMobNum(java.lang.String param){
                            
                                            this.localMobNum=param;
                                       

                               }
                            

                        /**
                        * field for VoucherNum
                        */

                        
                                    protected java.lang.String localVoucherNum ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getVoucherNum(){
                               return localVoucherNum;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param VoucherNum
                               */
                               public void setVoucherNum(java.lang.String param){
                            
                                            this.localVoucherNum=param;
                                       

                               }
                            

                        /**
                        * field for DomainID
                        */

                        
                                    protected java.lang.String localDomainID ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDomainIDTracker = false ;

                           public boolean isDomainIDSpecified(){
                               return localDomainIDTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDomainID(){
                               return localDomainID;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DomainID
                               */
                               public void setDomainID(java.lang.String param){
                            localDomainIDTracker = param != null;
                                   
                                            this.localDomainID=param;
                                       

                               }
                            

                        /**
                        * field for DeliveryChannelCtrlID
                        */

                        
                                    protected java.lang.String localDeliveryChannelCtrlID ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDeliveryChannelCtrlID(){
                               return localDeliveryChannelCtrlID;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DeliveryChannelCtrlID
                               */
                               public void setDeliveryChannelCtrlID(java.lang.String param){
                            
                                            this.localDeliveryChannelCtrlID=param;
                                       

                               }
                            

                        /**
                        * field for ActCode
                        */

                        
                                    protected java.lang.String localActCode ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getActCode(){
                               return localActCode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ActCode
                               */
                               public void setActCode(java.lang.String param){
                            
                                            this.localActCode=param;
                                       

                               }
                            

                        /**
                        * field for Curr
                        */

                        
                                    protected java.lang.String localCurr ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getCurr(){
                               return localCurr;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Curr
                               */
                               public void setCurr(java.lang.String param){
                            
                                            this.localCurr=param;
                                       

                               }
                            

                        /**
                        * field for VoucherBal
                        */

                        
                                    protected java.lang.String localVoucherBal ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getVoucherBal(){
                               return localVoucherBal;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param VoucherBal
                               */
                               public void setVoucherBal(java.lang.String param){
                            
                                            this.localVoucherBal=param;
                                       

                               }
                            

                        /**
                        * field for ValidityDate
                        */

                        
                                    protected java.lang.String localValidityDate ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getValidityDate(){
                               return localValidityDate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ValidityDate
                               */
                               public void setValidityDate(java.lang.String param){
                            
                                            this.localValidityDate=param;
                                       

                               }
                            

                        /**
                        * field for GraceDate
                        */

                        
                                    protected java.lang.String localGraceDate ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localGraceDateTracker = false ;

                           public boolean isGraceDateSpecified(){
                               return localGraceDateTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getGraceDate(){
                               return localGraceDate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param GraceDate
                               */
                               public void setGraceDate(java.lang.String param){
                            localGraceDateTracker = param != null;
                                   
                                            this.localGraceDate=param;
                                       

                               }
                            

                        /**
                        * field for GracePeriod
                        */

                        
                                    protected java.lang.String localGracePeriod ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getGracePeriod(){
                               return localGracePeriod;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param GracePeriod
                               */
                               public void setGracePeriod(java.lang.String param){
                            
                                            this.localGracePeriod=param;
                                       

                               }
                            

                        /**
                        * field for AddonBalance
                        */

                        
                                    protected java.lang.String localAddonBalance ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAddonBalanceTracker = false ;

                           public boolean isAddonBalanceSpecified(){
                               return localAddonBalanceTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getAddonBalance(){
                               return localAddonBalance;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AddonBalance
                               */
                               public void setAddonBalance(java.lang.String param){
                            localAddonBalanceTracker = param != null;
                                   
                                            this.localAddonBalance=param;
                                       

                               }
                            

                        /**
                        * field for BonusBal
                        */

                        
                                    protected java.lang.String localBonusBal ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localBonusBalTracker = false ;

                           public boolean isBonusBalSpecified(){
                               return localBonusBalTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getBonusBal(){
                               return localBonusBal;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BonusBal
                               */
                               public void setBonusBal(java.lang.String param){
                            localBonusBalTracker = param != null;
                                   
                                            this.localBonusBal=param;
                                       

                               }
                            

                        /**
                        * field for VoucherDenom
                        */

                        
                                    protected java.lang.String localVoucherDenom ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getVoucherDenom(){
                               return localVoucherDenom;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param VoucherDenom
                               */
                               public void setVoucherDenom(java.lang.String param){
                            
                                            this.localVoucherDenom=param;
                                       

                               }
                            

                        /**
                        * field for MessageID
                        * This was an Array!
                        */

                        
                                    protected java.lang.String[] localMessageID ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMessageIDTracker = false ;

                           public boolean isMessageIDSpecified(){
                               return localMessageIDTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String[]
                           */
                           public  java.lang.String[] getMessageID(){
                               return localMessageID;
                           }

                           
                        


                               
                              /**
                               * validate the array for MessageID
                               */
                              protected void validateMessageID(java.lang.String[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param MessageID
                              */
                              public void setMessageID(java.lang.String[] param){
                              
                                   validateMessageID(param);

                               localMessageIDTracker = param != null;
                                      
                                      this.localMessageID=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param java.lang.String
                             */
                             public void addMessageID(java.lang.String param){
                                   if (localMessageID == null){
                                   localMessageID = new java.lang.String[]{};
                                   }

                            
                                 //update the setting tracker
                                localMessageIDTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localMessageID);
                               list.add(param);
                               this.localMessageID =
                             (java.lang.String[])list.toArray(
                            new java.lang.String[list.size()]);

                             }
                             

                        /**
                        * field for LanguageID
                        * This was an Array!
                        */

                        
                                    protected java.lang.String[] localLanguageID ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localLanguageIDTracker = false ;

                           public boolean isLanguageIDSpecified(){
                               return localLanguageIDTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String[]
                           */
                           public  java.lang.String[] getLanguageID(){
                               return localLanguageID;
                           }

                           
                        


                               
                              /**
                               * validate the array for LanguageID
                               */
                              protected void validateLanguageID(java.lang.String[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param LanguageID
                              */
                              public void setLanguageID(java.lang.String[] param){
                              
                                   validateLanguageID(param);

                               localLanguageIDTracker = param != null;
                                      
                                      this.localLanguageID=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param java.lang.String
                             */
                             public void addLanguageID(java.lang.String param){
                                   if (localLanguageID == null){
                                   localLanguageID = new java.lang.String[]{};
                                   }

                            
                                 //update the setting tracker
                                localLanguageIDTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localLanguageID);
                               list.add(param);
                               this.localLanguageID =
                             (java.lang.String[])list.toArray(
                            new java.lang.String[list.size()]);

                             }
                             

                        /**
                        * field for Priority
                        * This was an Array!
                        */

                        
                                    protected java.lang.String[] localPriority ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPriorityTracker = false ;

                           public boolean isPrioritySpecified(){
                               return localPriorityTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String[]
                           */
                           public  java.lang.String[] getPriority(){
                               return localPriority;
                           }

                           
                        


                               
                              /**
                               * validate the array for Priority
                               */
                              protected void validatePriority(java.lang.String[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param Priority
                              */
                              public void setPriority(java.lang.String[] param){
                              
                                   validatePriority(param);

                               localPriorityTracker = param != null;
                                      
                                      this.localPriority=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param java.lang.String
                             */
                             public void addPriority(java.lang.String param){
                                   if (localPriority == null){
                                   localPriority = new java.lang.String[]{};
                                   }

                            
                                 //update the setting tracker
                                localPriorityTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localPriority);
                               list.add(param);
                               this.localPriority =
                             (java.lang.String[])list.toArray(
                            new java.lang.String[list.size()]);

                             }
                             

                        /**
                        * field for BusinessHourIndicator
                        * This was an Array!
                        */

                        
                                    protected java.lang.String[] localBusinessHourIndicator ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localBusinessHourIndicatorTracker = false ;

                           public boolean isBusinessHourIndicatorSpecified(){
                               return localBusinessHourIndicatorTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String[]
                           */
                           public  java.lang.String[] getBusinessHourIndicator(){
                               return localBusinessHourIndicator;
                           }

                           
                        


                               
                              /**
                               * validate the array for BusinessHourIndicator
                               */
                              protected void validateBusinessHourIndicator(java.lang.String[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param BusinessHourIndicator
                              */
                              public void setBusinessHourIndicator(java.lang.String[] param){
                              
                                   validateBusinessHourIndicator(param);

                               localBusinessHourIndicatorTracker = param != null;
                                      
                                      this.localBusinessHourIndicator=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param java.lang.String
                             */
                             public void addBusinessHourIndicator(java.lang.String param){
                                   if (localBusinessHourIndicator == null){
                                   localBusinessHourIndicator = new java.lang.String[]{};
                                   }

                            
                                 //update the setting tracker
                                localBusinessHourIndicatorTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localBusinessHourIndicator);
                               list.add(param);
                               this.localBusinessHourIndicator =
                             (java.lang.String[])list.toArray(
                            new java.lang.String[list.size()]);

                             }
                             

                        /**
                        * field for VlrId
                        */

                        
                                    protected java.lang.String localVlrId ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localVlrIdTracker = false ;

                           public boolean isVlrIdSpecified(){
                               return localVlrIdTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getVlrId(){
                               return localVlrId;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param VlrId
                               */
                               public void setVlrId(java.lang.String param){
                            localVlrIdTracker = param != null;
                                   
                                            this.localVlrId=param;
                                       

                               }
                            

                        /**
                        * field for CellId
                        */

                        
                                    protected java.lang.String localCellId ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCellIdTracker = false ;

                           public boolean isCellIdSpecified(){
                               return localCellIdTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getCellId(){
                               return localCellId;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CellId
                               */
                               public void setCellId(java.lang.String param){
                            localCellIdTracker = param != null;
                                   
                                            this.localCellId=param;
                                       

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
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":VoucherTopUp",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "VoucherTopUp",
                           xmlWriter);
                   }

               
                   }
               
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4";
                                    writeStartElement(null, namespace, "TransactionID", xmlWriter);
                             

                                          if (localTransactionID==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("TransactionID cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localTransactionID);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4";
                                    writeStartElement(null, namespace, "MessageType", xmlWriter);
                             

                                          if (localMessageType==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("MessageType cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localMessageType);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4";
                                    writeStartElement(null, namespace, "ProcCode", xmlWriter);
                             

                                          if (localProcCode==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("ProcCode cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localProcCode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4";
                                    writeStartElement(null, namespace, "STAN", xmlWriter);
                             

                                          if (localSTAN==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("STAN cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSTAN);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4";
                                    writeStartElement(null, namespace, "LocalTxnDtTime", xmlWriter);
                             

                                          if (localLocalTxnDtTime==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("LocalTxnDtTime cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localLocalTxnDtTime);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4";
                                    writeStartElement(null, namespace, "MobNum", xmlWriter);
                             

                                          if (localMobNum==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("MobNum cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localMobNum);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4";
                                    writeStartElement(null, namespace, "VoucherNum", xmlWriter);
                             

                                          if (localVoucherNum==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("VoucherNum cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localVoucherNum);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                              if (localDomainIDTracker){
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4";
                                    writeStartElement(null, namespace, "DomainID", xmlWriter);
                             

                                          if (localDomainID==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("DomainID cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDomainID);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             }
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4";
                                    writeStartElement(null, namespace, "DeliveryChannelCtrlID", xmlWriter);
                             

                                          if (localDeliveryChannelCtrlID==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("DeliveryChannelCtrlID cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDeliveryChannelCtrlID);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4";
                                    writeStartElement(null, namespace, "ActCode", xmlWriter);
                             

                                          if (localActCode==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("ActCode cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localActCode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4";
                                    writeStartElement(null, namespace, "Curr", xmlWriter);
                             

                                          if (localCurr==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("Curr cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localCurr);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4";
                                    writeStartElement(null, namespace, "VoucherBal", xmlWriter);
                             

                                          if (localVoucherBal==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("VoucherBal cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localVoucherBal);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4";
                                    writeStartElement(null, namespace, "ValidityDate", xmlWriter);
                             

                                          if (localValidityDate==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("ValidityDate cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localValidityDate);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                              if (localGraceDateTracker){
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4";
                                    writeStartElement(null, namespace, "GraceDate", xmlWriter);
                             

                                          if (localGraceDate==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("GraceDate cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localGraceDate);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             }
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4";
                                    writeStartElement(null, namespace, "GracePeriod", xmlWriter);
                             

                                          if (localGracePeriod==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("GracePeriod cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localGracePeriod);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                              if (localAddonBalanceTracker){
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4";
                                    writeStartElement(null, namespace, "AddonBalance", xmlWriter);
                             

                                          if (localAddonBalance==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("AddonBalance cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localAddonBalance);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localBonusBalTracker){
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4";
                                    writeStartElement(null, namespace, "BonusBal", xmlWriter);
                             

                                          if (localBonusBal==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("BonusBal cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localBonusBal);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             }
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4";
                                    writeStartElement(null, namespace, "VoucherDenom", xmlWriter);
                             

                                          if (localVoucherDenom==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("VoucherDenom cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localVoucherDenom);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                              if (localMessageIDTracker){
                             if (localMessageID!=null) {
                                   namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4";
                                   for (int i = 0;i < localMessageID.length;i++){
                                        
                                            if (localMessageID[i] != null){
                                        
                                                writeStartElement(null, namespace, "MessageID", xmlWriter);

                                            
                                                        xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMessageID[i]));
                                                    
                                                xmlWriter.writeEndElement();
                                              
                                                } else {
                                                   
                                                           // we have to do nothing since minOccurs is zero
                                                       
                                                }

                                   }
                             } else {
                                 
                                         throw new org.apache.axis2.databinding.ADBException("MessageID cannot be null!!");
                                    
                             }

                        } if (localLanguageIDTracker){
                             if (localLanguageID!=null) {
                                   namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4";
                                   for (int i = 0;i < localLanguageID.length;i++){
                                        
                                            if (localLanguageID[i] != null){
                                        
                                                writeStartElement(null, namespace, "LanguageID", xmlWriter);

                                            
                                                        xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLanguageID[i]));
                                                    
                                                xmlWriter.writeEndElement();
                                              
                                                } else {
                                                   
                                                           // we have to do nothing since minOccurs is zero
                                                       
                                                }

                                   }
                             } else {
                                 
                                         throw new org.apache.axis2.databinding.ADBException("LanguageID cannot be null!!");
                                    
                             }

                        } if (localPriorityTracker){
                             if (localPriority!=null) {
                                   namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4";
                                   for (int i = 0;i < localPriority.length;i++){
                                        
                                            if (localPriority[i] != null){
                                        
                                                writeStartElement(null, namespace, "Priority", xmlWriter);

                                            
                                                        xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPriority[i]));
                                                    
                                                xmlWriter.writeEndElement();
                                              
                                                } else {
                                                   
                                                           // we have to do nothing since minOccurs is zero
                                                       
                                                }

                                   }
                             } else {
                                 
                                         throw new org.apache.axis2.databinding.ADBException("Priority cannot be null!!");
                                    
                             }

                        } if (localBusinessHourIndicatorTracker){
                             if (localBusinessHourIndicator!=null) {
                                   namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4";
                                   for (int i = 0;i < localBusinessHourIndicator.length;i++){
                                        
                                            if (localBusinessHourIndicator[i] != null){
                                        
                                                writeStartElement(null, namespace, "BusinessHourIndicator", xmlWriter);

                                            
                                                        xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localBusinessHourIndicator[i]));
                                                    
                                                xmlWriter.writeEndElement();
                                              
                                                } else {
                                                   
                                                           // we have to do nothing since minOccurs is zero
                                                       
                                                }

                                   }
                             } else {
                                 
                                         throw new org.apache.axis2.databinding.ADBException("BusinessHourIndicator cannot be null!!");
                                    
                             }

                        } if (localVlrIdTracker){
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4";
                                    writeStartElement(null, namespace, "VlrId", xmlWriter);
                             

                                          if (localVlrId==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("VlrId cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localVlrId);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localCellIdTracker){
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4";
                                    writeStartElement(null, namespace, "CellId", xmlWriter);
                             

                                          if (localCellId==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("CellId cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localCellId);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             }
                    xmlWriter.writeEndElement();
               

        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4")){
                return "ns4";
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
        public static VoucherTopUp parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            VoucherTopUp object =
                new VoucherTopUp();

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
                    
                            if (!"VoucherTopUp".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (VoucherTopUp)com.tibco.www.schemas.vnm_project_uat.shared_resources.schema.xml.xsd.crbt.giftsong_xsd.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                
                    
                    reader.next();
                
                        java.util.ArrayList list19 = new java.util.ArrayList();
                    
                        java.util.ArrayList list20 = new java.util.ArrayList();
                    
                        java.util.ArrayList list21 = new java.util.ArrayList();
                    
                        java.util.ArrayList list22 = new java.util.ArrayList();
                    
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4","TransactionID").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"TransactionID" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setTransactionID(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // 1 - A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4","MessageType").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"MessageType" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMessageType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // 1 - A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4","ProcCode").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"ProcCode" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setProcCode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // 1 - A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4","STAN").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"STAN" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSTAN(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // 1 - A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4","LocalTxnDtTime").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"LocalTxnDtTime" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setLocalTxnDtTime(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // 1 - A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4","MobNum").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"MobNum" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMobNum(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // 1 - A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4","VoucherNum").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"VoucherNum" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setVoucherNum(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // 1 - A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4","DomainID").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"DomainID" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDomainID(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4","DeliveryChannelCtrlID").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"DeliveryChannelCtrlID" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDeliveryChannelCtrlID(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // 1 - A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4","ActCode").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"ActCode" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setActCode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // 1 - A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4","Curr").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"Curr" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCurr(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // 1 - A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4","VoucherBal").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"VoucherBal" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setVoucherBal(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // 1 - A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4","ValidityDate").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"ValidityDate" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setValidityDate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // 1 - A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4","GraceDate").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"GraceDate" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setGraceDate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4","GracePeriod").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"GracePeriod" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setGracePeriod(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // 1 - A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4","AddonBalance").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"AddonBalance" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setAddonBalance(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4","BonusBal").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"BonusBal" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setBonusBal(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4","VoucherDenom").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"VoucherDenom" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setVoucherDenom(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // 1 - A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4","MessageID").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    
                                    list19.add(reader.getElementText());
                                            
                                            //loop until we find a start element that is not part of this array
                                            boolean loopDone19 = false;
                                            while(!loopDone19){
                                                // Ensure we are at the EndElement
                                                while (!reader.isEndElement()){
                                                    reader.next();
                                                }
                                                // Step out of this element
                                                reader.next();
                                                // Step to next element event.
                                                while (!reader.isStartElement() && !reader.isEndElement())
                                                    reader.next();
                                                if (reader.isEndElement()){
                                                    //two continuous end elements means we are exiting the xml structure
                                                    loopDone19 = true;
                                                } else {
                                                    if (new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4","MessageID").equals(reader.getName())){
                                                         list19.add(reader.getElementText());
                                                        
                                                    }else{
                                                        loopDone19 = true;
                                                    }
                                                }
                                            }
                                            // call the converter utility  to convert and set the array
                                            
                                                    object.setMessageID((java.lang.String[])
                                                        list19.toArray(new java.lang.String[list19.size()]));
                                                
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4","LanguageID").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    
                                    list20.add(reader.getElementText());
                                            
                                            //loop until we find a start element that is not part of this array
                                            boolean loopDone20 = false;
                                            while(!loopDone20){
                                                // Ensure we are at the EndElement
                                                while (!reader.isEndElement()){
                                                    reader.next();
                                                }
                                                // Step out of this element
                                                reader.next();
                                                // Step to next element event.
                                                while (!reader.isStartElement() && !reader.isEndElement())
                                                    reader.next();
                                                if (reader.isEndElement()){
                                                    //two continuous end elements means we are exiting the xml structure
                                                    loopDone20 = true;
                                                } else {
                                                    if (new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4","LanguageID").equals(reader.getName())){
                                                         list20.add(reader.getElementText());
                                                        
                                                    }else{
                                                        loopDone20 = true;
                                                    }
                                                }
                                            }
                                            // call the converter utility  to convert and set the array
                                            
                                                    object.setLanguageID((java.lang.String[])
                                                        list20.toArray(new java.lang.String[list20.size()]));
                                                
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4","Priority").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    
                                    list21.add(reader.getElementText());
                                            
                                            //loop until we find a start element that is not part of this array
                                            boolean loopDone21 = false;
                                            while(!loopDone21){
                                                // Ensure we are at the EndElement
                                                while (!reader.isEndElement()){
                                                    reader.next();
                                                }
                                                // Step out of this element
                                                reader.next();
                                                // Step to next element event.
                                                while (!reader.isStartElement() && !reader.isEndElement())
                                                    reader.next();
                                                if (reader.isEndElement()){
                                                    //two continuous end elements means we are exiting the xml structure
                                                    loopDone21 = true;
                                                } else {
                                                    if (new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4","Priority").equals(reader.getName())){
                                                         list21.add(reader.getElementText());
                                                        
                                                    }else{
                                                        loopDone21 = true;
                                                    }
                                                }
                                            }
                                            // call the converter utility  to convert and set the array
                                            
                                                    object.setPriority((java.lang.String[])
                                                        list21.toArray(new java.lang.String[list21.size()]));
                                                
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4","BusinessHourIndicator").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    
                                    list22.add(reader.getElementText());
                                            
                                            //loop until we find a start element that is not part of this array
                                            boolean loopDone22 = false;
                                            while(!loopDone22){
                                                // Ensure we are at the EndElement
                                                while (!reader.isEndElement()){
                                                    reader.next();
                                                }
                                                // Step out of this element
                                                reader.next();
                                                // Step to next element event.
                                                while (!reader.isStartElement() && !reader.isEndElement())
                                                    reader.next();
                                                if (reader.isEndElement()){
                                                    //two continuous end elements means we are exiting the xml structure
                                                    loopDone22 = true;
                                                } else {
                                                    if (new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4","BusinessHourIndicator").equals(reader.getName())){
                                                         list22.add(reader.getElementText());
                                                        
                                                    }else{
                                                        loopDone22 = true;
                                                    }
                                                }
                                            }
                                            // call the converter utility  to convert and set the array
                                            
                                                    object.setBusinessHourIndicator((java.lang.String[])
                                                        list22.toArray(new java.lang.String[list22.size()]));
                                                
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4","VlrId").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"VlrId" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setVlrId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd4","CellId").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"CellId" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCellId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
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
           
    