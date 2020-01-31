/**
 * GamifyConnection.java
 */
package com.gnv.vnm.selfcare.core.adapter.gamify;

import com.gnv.vnm.selfcare.core.adapter.BackEndConnection;

/**
 * @author nandipinto
 *
 */
public class GamifyConnection extends BackEndConnection {

	private static final long serialVersionUID = 7031356930210712654L;
	
	private String getMonsterURL;
	private String redeemByMonsterURL;
	
	public GamifyConnection() {
	}
	
	public GamifyConnection(String host, int port, String userName, String credential, String protocol) {
		super(host, port, userName, credential, protocol);
	}

	public GamifyConnection(String getMonsterURL, String redeemByMonsterURL) {
		this.getMonsterURL = getMonsterURL;
		this.redeemByMonsterURL = redeemByMonsterURL;
	}

	/**
	 * @return the getMonsterURL
	 */
	public String getGetMonsterURL() {
		return getMonsterURL;
	}

	/**
	 * @param getMonsterURL the getMonsterURL to set
	 */
	public void setGetMonsterURL(String getMonsterURL) {
		this.getMonsterURL = getMonsterURL;
	}

	/**
	 * @return the redeemByMonsterURL
	 */
	public String getRedeemByMonsterURL() {
		return redeemByMonsterURL;
	}

	/**
	 * @param redeemByMonsterURL the redeemByMonsterURL to set
	 */
	public void setRedeemByMonsterURL(String redeemByMonsterURL) {
		this.redeemByMonsterURL = redeemByMonsterURL;
	}


}
