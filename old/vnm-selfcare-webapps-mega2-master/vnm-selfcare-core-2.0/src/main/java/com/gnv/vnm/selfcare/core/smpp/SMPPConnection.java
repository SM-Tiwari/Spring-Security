/**
 * SMPPConnection.java
 */
package com.gnv.vnm.selfcare.core.smpp;

import java.io.Serializable;

import org.jsmpp.bean.BindType;
import org.jsmpp.bean.TypeOfNumber;

/**
 * @author nandipinto
 *
 */
public class SMPPConnection implements Serializable{

	private static final long serialVersionUID = 1439042466572067628L;

	public static final int RECONNECT_INTERVAL = 360 * 1000;
	
	protected String host;
	protected int port;
	protected String userName;
	protected String credential;
	protected String protocol;
	private BindType bindType = BindType.BIND_TRX;
	private TypeOfNumber senderTON = TypeOfNumber.ALPHANUMERIC;
	private TypeOfNumber recipientTON = TypeOfNumber.INTERNATIONAL;
	protected int reconnectInterval = RECONNECT_INTERVAL;

	/*public SMPPConnection(){ }

	*//**
	 * @param host
	 * @param port
	 * @param userName
	 * @param credential
	 * @param protocol
	 * @param bindType
	 *//*
	public SMPPConnection(String host, int port, String userName, String credential, String protocol,
			BindType bindType) {
		this.host = host;
		this.port = port;
		this.userName = userName;
		this.credential = credential;
		this.protocol = protocol;
		this.bindType = bindType;
	}

	*//**
	 * @return the host
	 *//*
	public String getHost() {
		return host;
	}

	*//**
	 * @param host the host to set
	 *//*
	public void setHost(String host) {
		this.host = host;
	}

	*//**
	 * @return the port
	 *//*
	public int getPort() {
		return port;
	}

	*//**
	 * @param port the port to set
	 *//*
	public void setPort(int port) {
		this.port = port;
	}

	*//**
	 * @return the userName
	 *//*
	public String getUserName() {
		return userName;
	}

	*//**
	 * @param userName the userName to set
	 *//*
	public void setUserName(String userName) {
		this.userName = userName;
	}

	*//**
	 * @return the credential
	 *//*
	public String getCredential() {
		return credential;
	}

	*//**
	 * @param credential the credential to set
	 *//*
	public void setCredential(String credential) {
		this.credential = credential;
	}

	*//**
	 * @return the protocol
	 *//*
	public String getProtocol() {
		return protocol;
	}

	*//**
	 * @param protocol the protocol to set
	 *//*
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	*//**
	 * @return the reconnectInterval
	 *//*
	public int getReconnectInterval() {
		return reconnectInterval;
	}

	*//**
	 * @param reconnectInterval the reconnectInterval to set
	 *//*
	public void setReconnectInterval(int reconnectInterval) {
		this.reconnectInterval = reconnectInterval;
	}

	*//**
	 * @return the bindType
	 *//*
	public BindType getBindType() {
		return bindType;
	}

	*//**
	 * @param bindType the bindType to set
	 *//*
	public void setBindType(BindType bindType) {
		this.bindType = bindType;
	}

	*//**
	 * @return the senderTON
	 *//*
	public TypeOfNumber getSenderTON() {
		return senderTON;
	}

	*//**
	 * @param senderTON the senderTON to set
	 *//*
	public void setSenderTON(TypeOfNumber senderTON) {
		this.senderTON = senderTON;
	}

	*//**
	 * @return the recipientTON
	 *//*
	public TypeOfNumber getRecipientTON() {
		return recipientTON;
	}

	*//**
	 * @param recipientTON the recipientTON to set
	 *//*
	public void setRecipientTON(TypeOfNumber recipientTON) {
		this.recipientTON = recipientTON;
	}

	 (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bindType == null) ? 0 : bindType.hashCode());
		result = prime * result + ((credential == null) ? 0 : credential.hashCode());
		result = prime * result + ((host == null) ? 0 : host.hashCode());
		result = prime * result + port;
		result = prime * result + ((protocol == null) ? 0 : protocol.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	 (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SMPPConnection other = (SMPPConnection) obj;
		if (bindType != other.bindType)
			return false;
		if (credential == null) {
			if (other.credential != null)
				return false;
		} else if (!credential.equals(other.credential))
			return false;
		if (host == null) {
			if (other.host != null)
				return false;
		} else if (!host.equals(other.host))
			return false;
		if (port != other.port)
			return false;
		if (protocol == null) {
			if (other.protocol != null)
				return false;
		} else if (!protocol.equals(other.protocol))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	 (non-Javadoc)
	 * @see java.lang.Object#toString()
	 
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SMPPConnection [host=");
		builder.append(host);
		builder.append(", port=");
		builder.append(port);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", credential=");
		builder.append(credential);
		builder.append(", protocol=");
		builder.append(protocol);
		builder.append(", bindType=");
		builder.append(bindType);
		builder.append(", senderTON=");
		builder.append(senderTON);
		builder.append(", recipientTON=");
		builder.append(recipientTON);
		builder.append(", reconnectInterval=");
		builder.append(reconnectInterval);
		builder.append("]");
		return builder.toString();
	}*/
	
}
