
/**
 * HotBilling_Response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:06:07 GMT)
 */

            
                package com.tibco.www.schemas._28_nov_sit.shared_resources.schema.xml.selfcare.schema_xsd;
            

            /**
            *  HotBilling_Response bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class HotBilling_Response
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://www.tibco.com/schemas/28_NOV_SIT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd",
                "HotBilling_Response",
                "ns2");

            

                        /**
                        * field for Total_Due
                        */

                        
                                    protected java.lang.String localTotal_Due ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTotal_DueTracker = false ;

                           public boolean isTotal_DueSpecified(){
                               return localTotal_DueTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getTotal_Due(){
                               return localTotal_Due;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Total_Due
                               */
                               public void setTotal_Due(java.lang.String param){
                            localTotal_DueTracker = param != null;
                                   
                                            this.localTotal_Due=param;
                                       

                               }
                            

                        /**
                        * field for Monthly_3G_Charge
                        */

                        
                                    protected java.lang.String localMonthly_3G_Charge ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMonthly_3G_ChargeTracker = false ;

                           public boolean isMonthly_3G_ChargeSpecified(){
                               return localMonthly_3G_ChargeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getMonthly_3G_Charge(){
                               return localMonthly_3G_Charge;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Monthly_3G_Charge
                               */
                               public void setMonthly_3G_Charge(java.lang.String param){
                            localMonthly_3G_ChargeTracker = param != null;
                                   
                                            this.localMonthly_3G_Charge=param;
                                       

                               }
                            

                        /**
                        * field for Monthly_Charge
                        */

                        
                                    protected java.lang.String localMonthly_Charge ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMonthly_ChargeTracker = false ;

                           public boolean isMonthly_ChargeSpecified(){
                               return localMonthly_ChargeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getMonthly_Charge(){
                               return localMonthly_Charge;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Monthly_Charge
                               */
                               public void setMonthly_Charge(java.lang.String param){
                            localMonthly_ChargeTracker = param != null;
                                   
                                            this.localMonthly_Charge=param;
                                       

                               }
                            

                        /**
                        * field for Detailed_Usage_Free
                        */

                        
                                    protected java.lang.String localDetailed_Usage_Free ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDetailed_Usage_FreeTracker = false ;

                           public boolean isDetailed_Usage_FreeSpecified(){
                               return localDetailed_Usage_FreeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDetailed_Usage_Free(){
                               return localDetailed_Usage_Free;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Detailed_Usage_Free
                               */
                               public void setDetailed_Usage_Free(java.lang.String param){
                            localDetailed_Usage_FreeTracker = param != null;
                                   
                                            this.localDetailed_Usage_Free=param;
                                       

                               }
                            

                        /**
                        * field for Unbilled_Usage
                        */

                        
                                    protected java.lang.String localUnbilled_Usage ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localUnbilled_UsageTracker = false ;

                           public boolean isUnbilled_UsageSpecified(){
                               return localUnbilled_UsageTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getUnbilled_Usage(){
                               return localUnbilled_Usage;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Unbilled_Usage
                               */
                               public void setUnbilled_Usage(java.lang.String param){
                            localUnbilled_UsageTracker = param != null;
                                   
                                            this.localUnbilled_Usage=param;
                                       

                               }
                            

                        /**
                        * field for Discount
                        */

                        
                                    protected java.lang.String localDiscount ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDiscountTracker = false ;

                           public boolean isDiscountSpecified(){
                               return localDiscountTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDiscount(){
                               return localDiscount;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Discount
                               */
                               public void setDiscount(java.lang.String param){
                            localDiscountTracker = param != null;
                                   
                                            this.localDiscount=param;
                                       

                               }
                            

                        /**
                        * field for Usage_variance
                        */

                        
                                    protected java.lang.String localUsage_variance ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localUsage_varianceTracker = false ;

                           public boolean isUsage_varianceSpecified(){
                               return localUsage_varianceTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getUsage_variance(){
                               return localUsage_variance;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Usage_variance
                               */
                               public void setUsage_variance(java.lang.String param){
                            localUsage_varianceTracker = param != null;
                                   
                                            this.localUsage_variance=param;
                                       

                               }
                            

                        /**
                        * field for Total_Adjustment
                        */

                        
                                    protected java.lang.String localTotal_Adjustment ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTotal_AdjustmentTracker = false ;

                           public boolean isTotal_AdjustmentSpecified(){
                               return localTotal_AdjustmentTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getTotal_Adjustment(){
                               return localTotal_Adjustment;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Total_Adjustment
                               */
                               public void setTotal_Adjustment(java.lang.String param){
                            localTotal_AdjustmentTracker = param != null;
                                   
                                            this.localTotal_Adjustment=param;
                                       

                               }
                            

                        /**
                        * field for Others_Adjustments
                        */

                        
                                    protected java.lang.String localOthers_Adjustments ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOthers_AdjustmentsTracker = false ;

                           public boolean isOthers_AdjustmentsSpecified(){
                               return localOthers_AdjustmentsTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getOthers_Adjustments(){
                               return localOthers_Adjustments;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Others_Adjustments
                               */
                               public void setOthers_Adjustments(java.lang.String param){
                            localOthers_AdjustmentsTracker = param != null;
                                   
                                            this.localOthers_Adjustments=param;
                                       

                               }
                            

                        /**
                        * field for Balance_Transfer_Amount
                        */

                        
                                    protected java.lang.String localBalance_Transfer_Amount ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localBalance_Transfer_AmountTracker = false ;

                           public boolean isBalance_Transfer_AmountSpecified(){
                               return localBalance_Transfer_AmountTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getBalance_Transfer_Amount(){
                               return localBalance_Transfer_Amount;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Balance_Transfer_Amount
                               */
                               public void setBalance_Transfer_Amount(java.lang.String param){
                            localBalance_Transfer_AmountTracker = param != null;
                                   
                                            this.localBalance_Transfer_Amount=param;
                                       

                               }
                            

                        /**
                        * field for Transfer_Fee
                        */

                        
                                    protected java.lang.String localTransfer_Fee ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTransfer_FeeTracker = false ;

                           public boolean isTransfer_FeeSpecified(){
                               return localTransfer_FeeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getTransfer_Fee(){
                               return localTransfer_Fee;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Transfer_Fee
                               */
                               public void setTransfer_Fee(java.lang.String param){
                            localTransfer_FeeTracker = param != null;
                                   
                                            this.localTransfer_Fee=param;
                                       

                               }
                            

                        /**
                        * field for Total_VAT
                        */

                        
                                    protected java.lang.String localTotal_VAT ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTotal_VATTracker = false ;

                           public boolean isTotal_VATSpecified(){
                               return localTotal_VATTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getTotal_VAT(){
                               return localTotal_VAT;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Total_VAT
                               */
                               public void setTotal_VAT(java.lang.String param){
                            localTotal_VATTracker = param != null;
                                   
                                            this.localTotal_VAT=param;
                                       

                               }
                            

                        /**
                        * field for Other_VAT
                        */

                        
                                    protected java.lang.String localOther_VAT ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOther_VATTracker = false ;

                           public boolean isOther_VATSpecified(){
                               return localOther_VATTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getOther_VAT(){
                               return localOther_VAT;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Other_VAT
                               */
                               public void setOther_VAT(java.lang.String param){
                            localOther_VATTracker = param != null;
                                   
                                            this.localOther_VAT=param;
                                       

                               }
                            

                        /**
                        * field for Status
                        */

                        
                                    protected java.lang.String localStatus ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localStatusTracker = false ;

                           public boolean isStatusSpecified(){
                               return localStatusTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getStatus(){
                               return localStatus;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Status
                               */
                               public void setStatus(java.lang.String param){
                            localStatusTracker = param != null;
                                   
                                            this.localStatus=param;
                                       

                               }
                            

                        /**
                        * field for Status_Text
                        */

                        
                                    protected java.lang.String localStatus_Text ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localStatus_TextTracker = false ;

                           public boolean isStatus_TextSpecified(){
                               return localStatus_TextTracker;
                           }

                           

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
                            localStatus_TextTracker = param != null;
                                   
                                            this.localStatus_Text=param;
                                       

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
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://www.tibco.com/schemas/28_NOV_SIT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":HotBilling_Response",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "HotBilling_Response",
                           xmlWriter);
                   }

               
                   }
                if (localTotal_DueTracker){
                                    namespace = "http://www.tibco.com/schemas/28_NOV_SIT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd";
                                    writeStartElement(null, namespace, "Total_Due", xmlWriter);
                             

                                          if (localTotal_Due==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("Total_Due cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localTotal_Due);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localMonthly_3G_ChargeTracker){
                                    namespace = "http://www.tibco.com/schemas/28_NOV_SIT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd";
                                    writeStartElement(null, namespace, "Monthly_3G_Charge", xmlWriter);
                             

                                          if (localMonthly_3G_Charge==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("Monthly_3G_Charge cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localMonthly_3G_Charge);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localMonthly_ChargeTracker){
                                    namespace = "http://www.tibco.com/schemas/28_NOV_SIT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd";
                                    writeStartElement(null, namespace, "Monthly_Charge", xmlWriter);
                             

                                          if (localMonthly_Charge==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("Monthly_Charge cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localMonthly_Charge);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDetailed_Usage_FreeTracker){
                                    namespace = "http://www.tibco.com/schemas/28_NOV_SIT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd";
                                    writeStartElement(null, namespace, "Detailed_Usage_Free", xmlWriter);
                             

                                          if (localDetailed_Usage_Free==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("Detailed_Usage_Free cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDetailed_Usage_Free);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localUnbilled_UsageTracker){
                                    namespace = "http://www.tibco.com/schemas/28_NOV_SIT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd";
                                    writeStartElement(null, namespace, "Unbilled_Usage", xmlWriter);
                             

                                          if (localUnbilled_Usage==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("Unbilled_Usage cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localUnbilled_Usage);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDiscountTracker){
                                    namespace = "http://www.tibco.com/schemas/28_NOV_SIT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd";
                                    writeStartElement(null, namespace, "Discount", xmlWriter);
                             

                                          if (localDiscount==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("Discount cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDiscount);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localUsage_varianceTracker){
                                    namespace = "http://www.tibco.com/schemas/28_NOV_SIT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd";
                                    writeStartElement(null, namespace, "Usage_variance", xmlWriter);
                             

                                          if (localUsage_variance==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("Usage_variance cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localUsage_variance);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localTotal_AdjustmentTracker){
                                    namespace = "http://www.tibco.com/schemas/28_NOV_SIT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd";
                                    writeStartElement(null, namespace, "Total_Adjustment", xmlWriter);
                             

                                          if (localTotal_Adjustment==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("Total_Adjustment cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localTotal_Adjustment);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localOthers_AdjustmentsTracker){
                                    namespace = "http://www.tibco.com/schemas/28_NOV_SIT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd";
                                    writeStartElement(null, namespace, "Others_Adjustments", xmlWriter);
                             

                                          if (localOthers_Adjustments==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("Others_Adjustments cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localOthers_Adjustments);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localBalance_Transfer_AmountTracker){
                                    namespace = "http://www.tibco.com/schemas/28_NOV_SIT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd";
                                    writeStartElement(null, namespace, "Balance_Transfer_Amount", xmlWriter);
                             

                                          if (localBalance_Transfer_Amount==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("Balance_Transfer_Amount cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localBalance_Transfer_Amount);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localTransfer_FeeTracker){
                                    namespace = "http://www.tibco.com/schemas/28_NOV_SIT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd";
                                    writeStartElement(null, namespace, "Transfer_Fee", xmlWriter);
                             

                                          if (localTransfer_Fee==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("Transfer_Fee cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localTransfer_Fee);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localTotal_VATTracker){
                                    namespace = "http://www.tibco.com/schemas/28_NOV_SIT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd";
                                    writeStartElement(null, namespace, "Total_VAT", xmlWriter);
                             

                                          if (localTotal_VAT==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("Total_VAT cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localTotal_VAT);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localOther_VATTracker){
                                    namespace = "http://www.tibco.com/schemas/28_NOV_SIT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd";
                                    writeStartElement(null, namespace, "Other_VAT", xmlWriter);
                             

                                          if (localOther_VAT==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("Other_VAT cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localOther_VAT);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localStatusTracker){
                                    namespace = "http://www.tibco.com/schemas/28_NOV_SIT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd";
                                    writeStartElement(null, namespace, "Status", xmlWriter);
                             

                                          if (localStatus==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("Status cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localStatus);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localStatus_TextTracker){
                                    namespace = "http://www.tibco.com/schemas/28_NOV_SIT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd";
                                    writeStartElement(null, namespace, "Status_Text", xmlWriter);
                             

                                          if (localStatus_Text==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("Status_Text cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localStatus_Text);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             }
                    xmlWriter.writeEndElement();
               

        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://www.tibco.com/schemas/28_NOV_SIT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd")){
                return "ns2";
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
        public static HotBilling_Response parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            HotBilling_Response object =
                new HotBilling_Response();

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
                    
                            if (!"HotBilling_Response".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (HotBilling_Response)com.tibco.www.schemas.vnm_project_uat.shared_resources.schema.xml.xsd.crbt.giftsong_xsd.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/28_NOV_SIT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd","Total_Due").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"Total_Due" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setTotal_Due(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/28_NOV_SIT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd","Monthly_3G_Charge").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"Monthly_3G_Charge" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMonthly_3G_Charge(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/28_NOV_SIT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd","Monthly_Charge").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"Monthly_Charge" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMonthly_Charge(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/28_NOV_SIT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd","Detailed_Usage_Free").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"Detailed_Usage_Free" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDetailed_Usage_Free(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/28_NOV_SIT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd","Unbilled_Usage").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"Unbilled_Usage" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setUnbilled_Usage(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/28_NOV_SIT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd","Discount").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"Discount" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDiscount(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/28_NOV_SIT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd","Usage_variance").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"Usage_variance" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setUsage_variance(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/28_NOV_SIT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd","Total_Adjustment").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"Total_Adjustment" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setTotal_Adjustment(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/28_NOV_SIT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd","Others_Adjustments").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"Others_Adjustments" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setOthers_Adjustments(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/28_NOV_SIT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd","Balance_Transfer_Amount").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"Balance_Transfer_Amount" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setBalance_Transfer_Amount(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/28_NOV_SIT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd","Transfer_Fee").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"Transfer_Fee" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setTransfer_Fee(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/28_NOV_SIT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd","Total_VAT").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"Total_VAT" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setTotal_VAT(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/28_NOV_SIT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd","Other_VAT").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"Other_VAT" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setOther_VAT(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/28_NOV_SIT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd","Status").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"Status" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setStatus(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/28_NOV_SIT/Shared_Resources/Schema/XML/Selfcare/Schema.xsd","Status_Text").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"Status_Text" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setStatus_Text(
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
           
    