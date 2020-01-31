
/**
 * ServiceRequest_type0.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:06:07 GMT)
 */

            
                package com.tibco.www.schemas.vnm_project.shared_resources.abstract_wsdl.selfcare.schema_xsd;
            

            /**
            *  ServiceRequest_type0 bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class ServiceRequest_type0
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = ServiceRequest_type0
                Namespace URI = http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Abstract_Wsdl/Selfcare/Schema.xsd
                Namespace Prefix = ns24
                */
            

                        /**
                        * field for TransactionID
                        */

                        
                                    protected java.lang.String localTransactionID ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTransactionIDTracker = false ;

                           public boolean isTransactionIDSpecified(){
                               return localTransactionIDTracker;
                           }

                           

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
                            localTransactionIDTracker = param != null;
                                   
                                            this.localTransactionID=param;
                                       

                               }
                            

                        /**
                        * field for Source
                        */

                        
                                    protected java.lang.String localSource ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSource(){
                               return localSource;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Source
                               */
                               public void setSource(java.lang.String param){
                            
                                            this.localSource=param;
                                       

                               }
                            

                        /**
                        * field for Charge
                        */

                        
                                    protected java.lang.String localCharge ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getCharge(){
                               return localCharge;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Charge
                               */
                               public void setCharge(java.lang.String param){
                            
                                            this.localCharge=param;
                                       

                               }
                            

                        /**
                        * field for HYBRID_FLAG
                        */

                        
                                    protected java.lang.String localHYBRID_FLAG ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localHYBRID_FLAGTracker = false ;

                           public boolean isHYBRID_FLAGSpecified(){
                               return localHYBRID_FLAGTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getHYBRID_FLAG(){
                               return localHYBRID_FLAG;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param HYBRID_FLAG
                               */
                               public void setHYBRID_FLAG(java.lang.String param){
                            localHYBRID_FLAGTracker = param != null;
                                   
                                            this.localHYBRID_FLAG=param;
                                       

                               }
                            

                        /**
                        * field for ResponseCode
                        */

                        
                                    protected java.lang.String localResponseCode ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localResponseCodeTracker = false ;

                           public boolean isResponseCodeSpecified(){
                               return localResponseCodeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getResponseCode(){
                               return localResponseCode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ResponseCode
                               */
                               public void setResponseCode(java.lang.String param){
                            localResponseCodeTracker = param != null;
                                   
                                            this.localResponseCode=param;
                                       

                               }
                            

                        /**
                        * field for ResponseDescription
                        */

                        
                                    protected java.lang.String localResponseDescription ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localResponseDescriptionTracker = false ;

                           public boolean isResponseDescriptionSpecified(){
                               return localResponseDescriptionTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getResponseDescription(){
                               return localResponseDescription;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ResponseDescription
                               */
                               public void setResponseDescription(java.lang.String param){
                            localResponseDescriptionTracker = param != null;
                                   
                                            this.localResponseDescription=param;
                                       

                               }
                            

                        /**
                        * field for MSISDN
                        */

                        
                                    protected java.lang.String localMSISDN ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMSISDNTracker = false ;

                           public boolean isMSISDNSpecified(){
                               return localMSISDNTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getMSISDN(){
                               return localMSISDN;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MSISDN
                               */
                               public void setMSISDN(java.lang.String param){
                            localMSISDNTracker = param != null;
                                   
                                            this.localMSISDN=param;
                                       

                               }
                            

                        /**
                        * field for ActionType
                        */

                        
                                    protected java.lang.String localActionType ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localActionTypeTracker = false ;

                           public boolean isActionTypeSpecified(){
                               return localActionTypeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getActionType(){
                               return localActionType;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ActionType
                               */
                               public void setActionType(java.lang.String param){
                            localActionTypeTracker = param != null;
                                   
                                            this.localActionType=param;
                                       

                               }
                            

                        /**
                        * field for ServiceType
                        */

                        
                                    protected java.lang.String localServiceType ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localServiceTypeTracker = false ;

                           public boolean isServiceTypeSpecified(){
                               return localServiceTypeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getServiceType(){
                               return localServiceType;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ServiceType
                               */
                               public void setServiceType(java.lang.String param){
                            localServiceTypeTracker = param != null;
                                   
                                            this.localServiceType=param;
                                       

                               }
                            

                        /**
                        * field for CPName
                        */

                        
                                    protected java.lang.String localCPName ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCPNameTracker = false ;

                           public boolean isCPNameSpecified(){
                               return localCPNameTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getCPName(){
                               return localCPName;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CPName
                               */
                               public void setCPName(java.lang.String param){
                            localCPNameTracker = param != null;
                                   
                                            this.localCPName=param;
                                       

                               }
                            

                        /**
                        * field for AutoRenewalFlag
                        */

                        
                                    protected java.lang.String localAutoRenewalFlag ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAutoRenewalFlagTracker = false ;

                           public boolean isAutoRenewalFlagSpecified(){
                               return localAutoRenewalFlagTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getAutoRenewalFlag(){
                               return localAutoRenewalFlag;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AutoRenewalFlag
                               */
                               public void setAutoRenewalFlag(java.lang.String param){
                            localAutoRenewalFlagTracker = param != null;
                                   
                                            this.localAutoRenewalFlag=param;
                                       

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


        
               return factory.createOMElement(new org.apache.axis2.databinding.ADBDataSource(this,parentQName));
            
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
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Abstract_Wsdl/Selfcare/Schema.xsd");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":ServiceRequest_type0",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "ServiceRequest_type0",
                           xmlWriter);
                   }

               
                   }
                if (localTransactionIDTracker){
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Abstract_Wsdl/Selfcare/Schema.xsd";
                                    writeStartElement(null, namespace, "TransactionID", xmlWriter);
                             

                                          if (localTransactionID==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("TransactionID cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localTransactionID);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             }
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Abstract_Wsdl/Selfcare/Schema.xsd";
                                    writeStartElement(null, namespace, "Source", xmlWriter);
                             

                                          if (localSource==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("Source cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSource);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Abstract_Wsdl/Selfcare/Schema.xsd";
                                    writeStartElement(null, namespace, "Charge", xmlWriter);
                             

                                          if (localCharge==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("Charge cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localCharge);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                              if (localHYBRID_FLAGTracker){
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Abstract_Wsdl/Selfcare/Schema.xsd";
                                    writeStartElement(null, namespace, "HYBRID_FLAG", xmlWriter);
                             

                                          if (localHYBRID_FLAG==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("HYBRID_FLAG cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localHYBRID_FLAG);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localResponseCodeTracker){
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Abstract_Wsdl/Selfcare/Schema.xsd";
                                    writeStartElement(null, namespace, "ResponseCode", xmlWriter);
                             

                                          if (localResponseCode==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("ResponseCode cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localResponseCode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localResponseDescriptionTracker){
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Abstract_Wsdl/Selfcare/Schema.xsd";
                                    writeStartElement(null, namespace, "ResponseDescription", xmlWriter);
                             

                                          if (localResponseDescription==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("ResponseDescription cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localResponseDescription);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localMSISDNTracker){
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Abstract_Wsdl/Selfcare/Schema.xsd";
                                    writeStartElement(null, namespace, "MSISDN", xmlWriter);
                             

                                          if (localMSISDN==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("MSISDN cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localMSISDN);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localActionTypeTracker){
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Abstract_Wsdl/Selfcare/Schema.xsd";
                                    writeStartElement(null, namespace, "ActionType", xmlWriter);
                             

                                          if (localActionType==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("ActionType cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localActionType);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localServiceTypeTracker){
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Abstract_Wsdl/Selfcare/Schema.xsd";
                                    writeStartElement(null, namespace, "ServiceType", xmlWriter);
                             

                                          if (localServiceType==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("ServiceType cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localServiceType);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localCPNameTracker){
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Abstract_Wsdl/Selfcare/Schema.xsd";
                                    writeStartElement(null, namespace, "CPName", xmlWriter);
                             

                                          if (localCPName==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("CPName cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localCPName);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localAutoRenewalFlagTracker){
                                    namespace = "http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Abstract_Wsdl/Selfcare/Schema.xsd";
                                    writeStartElement(null, namespace, "AutoRenewalFlag", xmlWriter);
                             

                                          if (localAutoRenewalFlag==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("AutoRenewalFlag cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localAutoRenewalFlag);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             }
                    xmlWriter.writeEndElement();
               

        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Abstract_Wsdl/Selfcare/Schema.xsd")){
                return "ns24";
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
        public static ServiceRequest_type0 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            ServiceRequest_type0 object =
                new ServiceRequest_type0();

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
                    
                            if (!"ServiceRequest_type0".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (ServiceRequest_type0)com.tibco.www.schemas.vnm_project_uat.shared_resources.schema.xml.xsd.crbt.giftsong_xsd.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Abstract_Wsdl/Selfcare/Schema.xsd","TransactionID").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"TransactionID" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setTransactionID(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Abstract_Wsdl/Selfcare/Schema.xsd","Source").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"Source" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSource(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // 1 - A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Abstract_Wsdl/Selfcare/Schema.xsd","Charge").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"Charge" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCharge(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // 1 - A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Abstract_Wsdl/Selfcare/Schema.xsd","HYBRID_FLAG").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"HYBRID_FLAG" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setHYBRID_FLAG(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Abstract_Wsdl/Selfcare/Schema.xsd","ResponseCode").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"ResponseCode" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setResponseCode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Abstract_Wsdl/Selfcare/Schema.xsd","ResponseDescription").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"ResponseDescription" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setResponseDescription(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Abstract_Wsdl/Selfcare/Schema.xsd","MSISDN").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"MSISDN" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMSISDN(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Abstract_Wsdl/Selfcare/Schema.xsd","ActionType").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"ActionType" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setActionType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Abstract_Wsdl/Selfcare/Schema.xsd","ServiceType").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"ServiceType" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setServiceType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Abstract_Wsdl/Selfcare/Schema.xsd","CPName").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"CPName" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCPName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.tibco.com/schemas/VNM_PROJECT/Shared_Resources/Abstract_Wsdl/Selfcare/Schema.xsd","AutoRenewalFlag").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"AutoRenewalFlag" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setAutoRenewalFlag(
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
           
    