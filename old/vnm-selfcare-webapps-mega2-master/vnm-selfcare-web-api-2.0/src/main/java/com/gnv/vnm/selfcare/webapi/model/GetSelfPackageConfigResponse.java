/**
 * 
 */
package com.gnv.vnm.selfcare.webapi.model;

import java.util.Map.Entry;
import java.util.Set;

/**
 * @author nandipinto
 *
 */
public class GetSelfPackageConfigResponse extends ApiResponse {

	private static final long serialVersionUID = 1633173115090268915L;
	
//	private Map<String, String> configs = new Hashtable<>();
	private Set<Entry<String, String>> configs = null;
	
	public GetSelfPackageConfigResponse() {
	}

	/**
	 * @param successful
	 * @param code
	 * @param message
	 */
	public GetSelfPackageConfigResponse(boolean successful, String code, String message, Set<Entry<String, String>> configs) {
		super(successful, code, message);
		this.configs = configs;
	}

	/**
	 * @return the configs
	 */
	public Set<Entry<String, String>> getConfigs() {
		return configs;
	}

	/**
	 * @param configs the configs to set
	 */
	public void setConfigs(Set<Entry<String, String>> configs) {
		this.configs = configs;
	}

	
}
