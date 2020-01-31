/**
 * 
 */
package com.gnv.vnm.selfcare.webapi.model;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author nandipinto
 *
 */
public class GetLmsKeywordMappingsResponse extends ApiResponse {

	private static final long serialVersionUID = -834817395959798755L;
	private Map<String, Integer> keywordMaps = new Hashtable<>();

	public GetLmsKeywordMappingsResponse() {
	}

	public GetLmsKeywordMappingsResponse(boolean successful, String code, String message, Map<String, Integer> keywordMaps) {
		super(successful, code, message);
		this.keywordMaps = keywordMaps;
	}

	/**
	 * @return the keywordMaps
	 */
	public Map<String, Integer> getKeywordMaps() {
		return keywordMaps;
	}

	/**
	 * @param keywordMaps the keywordMaps to set
	 */
	public void setKeywordMaps(Map<String, Integer> keywordMaps) {
		this.keywordMaps = keywordMaps;
	}

	
}
