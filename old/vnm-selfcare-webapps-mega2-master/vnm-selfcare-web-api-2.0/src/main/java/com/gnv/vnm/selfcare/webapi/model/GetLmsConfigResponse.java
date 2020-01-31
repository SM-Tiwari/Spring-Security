/**
 * Apr 13, 2018 2:47:40 PM
 */
package com.gnv.vnm.selfcare.webapi.model;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author nandipinto
 *
 */
public class GetLmsConfigResponse extends ApiResponse {

	private static final long serialVersionUID = -2315942121495957366L;
	
	private Map<String, Object> configs = new Hashtable<>();

	public GetLmsConfigResponse() {
	}

	public GetLmsConfigResponse(boolean successful, String code, String message) {
		super(successful, code, message);
	}

	/**
	 * @return the configs
	 */
	public Map<String, Object> getConfigs() {
		return configs;
	}

	/**
	 * @param configs the configs to set
	 */
	public void setConfigs(Map<String, Object> configs) {
		this.configs = configs;
	}

	
	
}
