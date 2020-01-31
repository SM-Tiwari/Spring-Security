/**
 * WebServiceBackEndConnection.java
 */
package com.gnv.vnm.selfcare.core.adapter;

/**
 * @author nandipinto
 *
 */
public class WebServiceBackEndConnection extends BackEndConnection {

	private static final long serialVersionUID = -1660899728795974744L;
	
	private String wsdlLocation;
	private boolean logSoapMessage = false;

	public WebServiceBackEndConnection() {}

	/**
	 * @param host
	 * @param port
	 * @param userName
	 * @param credential
	 * @param protocol
	 */
	public WebServiceBackEndConnection(String host, int port, String userName, String credential, String protocol) {
		super(host, port, userName, credential, protocol);
	}

	public WebServiceBackEndConnection(String host, int port, String userName, String credential, String protocol, String wsdlLocation) {
		super(host, port, userName, credential, protocol);
		this.wsdlLocation = wsdlLocation;
	}

	/**
	 * @return the wsdlLocation
	 */
	public String getWsdlLocation() {
		return wsdlLocation;
	}

	/**
	 * @param wsdlLocation the wsdlLocation to set
	 */
	public void setWsdlLocation(String wsdlLocation) {
		this.wsdlLocation = wsdlLocation;
	}

	/**
	 * @return the logSoapMessage
	 */
	public boolean isLogSoapMessage() {
		return logSoapMessage;
	}

	/**
	 * @param logSoapMessage the logSoapMessage to set
	 */
	public void setLogSoapMessage(boolean logSoapMessage) {
		this.logSoapMessage = logSoapMessage;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WebServiceBackEndConnection [wsdlLocation=");
		builder.append(wsdlLocation);
		builder.append(", host=");
		builder.append(host);
		builder.append(", port=");
		builder.append(port);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", credential=");
		builder.append(credential.replaceAll("(?s).", "*"));
		builder.append(", protocol=");
		builder.append(protocol);
		builder.append(", socketTimeOut=");
		builder.append(socketTimeOut);
		builder.append(", connectionTimeOut=");
		builder.append(connectionTimeOut);
		builder.append(", maxConcurrentConnections=");
		builder.append(maxConcurrentConnections);
		builder.append("]");
		return builder.toString();
	}
	
	

}
