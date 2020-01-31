/**
 * GamifyRedeemByMonsterResponse.java
 */
package com.gnv.vnm.selfcare.core.adapter.gamify;

import java.io.Serializable;

/**
 * @author nandipinto
 *
 */
public class GamifyRedeemByMonsterResponse implements Serializable {

	private static final long serialVersionUID = 1972386153426838244L;

	private GamifyResponse result;

	/**
	 * @return the result
	 */
	public GamifyResponse getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(GamifyResponse result) {
		this.result = result;
	}
	
	
}
