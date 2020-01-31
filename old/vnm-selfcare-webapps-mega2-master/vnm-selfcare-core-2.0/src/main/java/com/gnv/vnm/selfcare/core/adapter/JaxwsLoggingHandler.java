package com.gnv.vnm.selfcare.core.adapter;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class JaxwsLoggingHandler implements SOAPHandler<SOAPMessageContext> {
	
	private static final Logger logger = LoggerFactory.getLogger(JaxwsLoggingHandler.class);
	
	private OutputStream out;
 
	public JaxwsLoggingHandler(OutputStream out) {
		this.out = out;
	}

	@Override
    public void close(MessageContext ctx) {
    }
 
    @Override
    public boolean handleFault(SOAPMessageContext ctx) {
        SOAPMessage message = ctx.getMessage();
        try {
            message.writeTo(this.out);
        } catch (SOAPException e) {
            logger.error(e.getMessage());
        } catch (IOException e) {
        	logger.error(e.getMessage());
        }
        return true;
    }
 
    @Override
    public boolean handleMessage(SOAPMessageContext ctx) {
        SOAPMessage message = ctx.getMessage();
        boolean isOutboundMessage = (Boolean) ctx.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        
        try {
            if (isOutboundMessage) {
                this.out.write("--Outbound Message\n".getBytes());
     
            } else {
                this.out.write("--Inbound Message\n".getBytes());
            }
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

        try {
            message.writeTo(System.out);
        } catch (SOAPException e) {
        	logger.error(e.getMessage());
        } catch (IOException e) {
        	logger.error(e.getMessage());
        }
        return true;
    }
 
    @Override
    public Set<QName> getHeaders() {
        return null;
    }
 
}