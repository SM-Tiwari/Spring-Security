/**
 * 
 */
package com.gnv.vnm.selfcare.core.adapter.upcc;

import com.gnv.vnm.selfcare.core.adapter.BackEndConnection;

/**
 * @author nandipinto
 *
 */
public class UPCCConnection extends BackEndConnection {

	private static final long serialVersionUID = 2511393476625945764L;

	private String keyStoreFile;
	private String keyStorePassword;
	private String trustStoreFile;
	private String trustStorePassword;
	
	public UPCCConnection() {}

	/**
	 * @param host
	 * @param port
	 * @param userName
	 * @param credential
	 * @param protocol
	 */
	public UPCCConnection(String host, int port, String userName, String credential, String protocol) {
		super(host, port, userName, credential, protocol);
	}

	/**
	 * @return the keyStoreFile
	 */
	public String getKeyStoreFile() {
		return keyStoreFile;
	}

	/**
	 * @param keyStoreFile the keyStoreFile to set
	 */
	public void setKeyStoreFile(String keyStoreFile) {
		this.keyStoreFile = keyStoreFile;
	}

	/**
	 * @return the keyStorePassword
	 */
	public String getKeyStorePassword() {
		return keyStorePassword;
	}

	/**
	 * @param keyStorePassword the keyStorePassword to set
	 */
	public void setKeyStorePassword(String keyStorePassword) {
		this.keyStorePassword = keyStorePassword;
	}

	/**
	 * @return the trustStoreFile
	 */
	public String getTrustStoreFile() {
		return trustStoreFile;
	}

	/**
	 * @param trustStoreFile the trustStoreFile to set
	 */
	public void setTrustStoreFile(String trustStoreFile) {
		this.trustStoreFile = trustStoreFile;
	}

	/**
	 * @return the trustStorePassword
	 */
	public String getTrustStorePassword() {
		return trustStorePassword;
	}

	/**
	 * @param trustStorePassword the trustStorePassword to set
	 */
	public void setTrustStorePassword(String trustStorePassword) {
		this.trustStorePassword = trustStorePassword;
	}

}
