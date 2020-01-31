package com.gnv.vnm.selfcare.core.adapter;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;
 
public class JaxwsHandlerResolver implements HandlerResolver {
 
	private OutputStream out;
	
    public JaxwsHandlerResolver(OutputStream out) {
		this.out = out;
	}

    @SuppressWarnings("rawtypes")
    @Override
    public List<Handler> getHandlerChain(PortInfo portInfo) {
        List<Handler> hchain = new ArrayList<Handler>();
        hchain.add(new JaxwsLoggingHandler(out));
        return hchain;
    }
 
}