/**
 * 
 */
package com.gnv.vnm.selfcare.core.adapter;

/**
 * Back-end Connector/Adapter interface
 * 
 * @author nandipinto
 *
 */
public abstract class BackEndAdapter {
	
	public static final String INTERNAL_ERROR_CODE = "9999";
	
	protected BackEndConnection connection;
	
	/**
	 * @return the connection
	 */
	public BackEndConnection getConnection() {
		return connection;
	}

	/**
	 * @param connection the connection to set
	 */
	public void setConnection(BackEndConnection connection) {
		this.connection = connection;
	}
	
	/**
	 * Initiate the connector, e.g: setup connection, login, etc
	 * 
	 * @param connection the connection configuration, an instance of {@link BackEndConnection}
	 * @throws BackEndAdapterException the exception thrown if there was any error during the initialization stage
	 */
	public abstract void init(BackEndConnection connection) throws BackEndAdapterException;
	
	public abstract void login();
	
	public abstract void logout();
	
	public abstract boolean isConnected();
	
	public abstract void reconnect(BackEndConnection connection) throws BackEndAdapterException;
	
	/**
	 * Send the request to network element
	 * 
	 * @param request the request
	 * @return response received from the back-end
	 */
	public abstract BackEndAdapterResponse sendRequest(BackEndAdapterRequest request);
	
	/**
	 * Logout/disconnect from back-end, cleanup resources, etc.
	 */
	public abstract void shutdown();
}
