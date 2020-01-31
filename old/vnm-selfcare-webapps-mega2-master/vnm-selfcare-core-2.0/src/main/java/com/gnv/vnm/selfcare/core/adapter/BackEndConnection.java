/**
 * 
 */
package com.gnv.vnm.selfcare.core.adapter;

import java.io.Serializable;

/**
 * @author nandipinto
 *
 */
public class BackEndConnection implements Serializable{

	private static final long serialVersionUID = -2856099305955471720L;
	
	public static final int CONNECT_TIMEOUT_SECS 	= 10;
	public static final int SOCKET_TIMOUT_SECS	 	= 10;
	public static final int REQUEST_TIMEOUT_SECS	 	= 10;
	public static final int RECONNECT_INTERVAL_SECS = 30; //Secs
	public static final int MAX_CONCURRENT_CONN 	= 10;
	public static final String PROTOCOL_HTTP		= "http";
	public static final String PROTOCOL_HTTPS		= "https";

	protected String host;
	protected int port;
	protected String userName;
	protected String credential;
	protected String protocol;
	protected int socketTimeOut = SOCKET_TIMOUT_SECS;
	protected int connectionTimeOut = CONNECT_TIMEOUT_SECS;
	protected int reconnectInterval;
	protected int maxConcurrentConnections;
	
	public BackEndConnection() {}

	/**
	 * 
	 * @param host the host or IP address
	 * @param port the port number
	 * @param userName the user name
	 * @param credential the user's credential
	 * @param protocol the protocol used to communicate with the network element 
	 */
	public BackEndConnection(String host, int port, String userName, String credential, String protocol) {
		this.host = host;
		this.port = port;
		this.userName = userName;
		this.credential = credential;
		this.protocol = protocol;
	}

	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the credential
	 */
	public String getCredential() {
		return credential;
	}

	/**
	 * @param credential the credential to set
	 */
	public void setCredential(String credential) {
		this.credential = credential;
	}

	/**
	 * @return the protocol
	 */
	public String getProtocol() {
		return protocol;
	}

	/**
	 * @param protocol the protocol to set
	 */
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	/**
	 * @return the socketTimeOut
	 */
	public int getSocketTimeOut() {
		return socketTimeOut;
	}

	/**
	 * @param socketTimeOut the socketTimeOut to set
	 */
	public void setSocketTimeOut(int socketTimeOut) {
		this.socketTimeOut = socketTimeOut;
	}

	/**
	 * @return the connectionTimeOut
	 */
	public int getConnectionTimeOut() {
		return connectionTimeOut;
	}

	/**
	 * @param connectionTimeOut the connectionTimeOut to set
	 */
	public void setConnectionTimeOut(int connectionTimeOut) {
		this.connectionTimeOut = connectionTimeOut;
	}

	/**
	 * @return the reconnectInterval
	 */
	public int getReconnectInterval() {
		return reconnectInterval;
	}

	/**
	 * @param reconnectInterval the reconnectInterval to set
	 */
	public void setReconnectInterval(int reconnectInterval) {
		this.reconnectInterval = reconnectInterval;
	}

	/**
	 * @return the maxConcurrentConnections
	 */
	public int getMaxConcurrentConnections() {
		return maxConcurrentConnections;
	}

	/**
	 * @param maxConcurrentConnections the maxConcurrentConnections to set
	 */
	public void setMaxConcurrentConnections(int maxConcurrentConnections) {
		this.maxConcurrentConnections = maxConcurrentConnections;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((credential == null) ? 0 : credential.hashCode());
		result = prime * result + ((host == null) ? 0 : host.hashCode());
		result = prime * result + port;
		result = prime * result + ((protocol == null) ? 0 : protocol.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BackEndConnection other = (BackEndConnection) obj;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BackEndConnection [host=");
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
		builder.append(", reconnectInterval=");
		builder.append(reconnectInterval);
		builder.append(", maxConcurrentConnections=");
		builder.append(maxConcurrentConnections);
		builder.append("]");
		return builder.toString();
	}

	
}
